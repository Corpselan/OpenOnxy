/*
 * Decompiled with CFR 0.0.9 (FabricMC cc05e23f).
 */
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.client.main.Main;

public final class OpenOnyxLauncher {
    private OpenOnyxLauncher() {
    }

    public static void main(String[] stringArray) throws Exception {
        System.setProperty("file.encoding", "UTF-8");
        Path path = OpenOnyxLauncher.locateJar();
        Path path2 = path != null ? path.toAbsolutePath().getParent() : Paths.get(".", new String[0]).toAbsolutePath();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("username", System.getProperty("onyx.username", "i_use_pastes"));
        linkedHashMap.put("gameDir", System.getProperty("onyx.gameDir", path2.resolve("onyx-game").toString()));
        linkedHashMap.put("width", System.getProperty("onyx.width", "925"));
        linkedHashMap.put("height", System.getProperty("onyx.height", "530"));
        linkedHashMap.put("accessToken", System.getProperty("onyx.accessToken", "0"));
        linkedHashMap.put("userProperties", System.getProperty("onyx.userProperties", "{}"));
        linkedHashMap.put("onyxUser", System.getProperty("onyx.user", "SZY"));
        linkedHashMap.put("assetsDir", System.getProperty("onyx.assetsDir", ""));
        int n = 0;
        while (n + 1 < stringArray.length) {
            if (stringArray[n].startsWith("--") && linkedHashMap.containsKey(stringArray[n].substring(2))) {
                linkedHashMap.put(stringArray[n].substring(2), stringArray[n + 1]);
                ++n;
            }
            ++n;
        }
        System.setProperty("onyx.user", (String)linkedHashMap.get("onyxUser"));
        Path path3 = Paths.get((String)linkedHashMap.get("gameDir"), new String[0]);
        Files.createDirectories(path3, new FileAttribute[0]);
        Path path4 = path3.resolve("natives");
        OpenOnyxLauncher.extractNatives(path, path4);
        System.setProperty("org.lwjgl.librarypath", path4.toString());
        System.setProperty("java.library.path", path4 + File.pathSeparator + System.getProperty("java.library.path", ""));
        String string = System.getProperty("os.name", "").toLowerCase();
        if (string.contains("mac")) {
            System.load(path4.resolve("liblwjgl.dylib").toAbsolutePath().toString());
            try {
                System.load(path4.resolve("openal.dylib").toAbsolutePath().toString());
            }
            catch (Throwable throwable) {
                System.err.println("[OpenOnyx] openal preload skipped: " + throwable.getMessage());
            }
        }
        Path path5 = OpenOnyxLauncher.resolveAssetsDir((String)linkedHashMap.get("assetsDir"), path3, path2);
        System.out.println("[OpenOnyx] assets dir: " + path5);
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("--version", "GradleMCP", "--accessToken", (String)linkedHashMap.get("accessToken"), "--assetsDir", path5.toString(), "--assetIndex", "1.8", "--userProperties", (String)linkedHashMap.get("userProperties"), "--username", (String)linkedHashMap.get("username"), "--gameDir", path3.toString(), "--width", (String)linkedHashMap.get("width"), "--height", (String)linkedHashMap.get("height")));
        Main.main(arrayList.toArray(new String[0]));
    }

    private static Path resolveAssetsDir(String string, Path path, Path path2) {
        Path path3;
        if (string != null && string.length() > 0) {
            Path path4 = Paths.get(string, new String[0]);
            if (!OpenOnyxLauncher.hasAssetIndex(path4)) {
                System.err.println("[OpenOnyx] warning: " + path4 + " has no indexes/1.8.json (sounds may be missing)");
            }
            return path4;
        }
        Path path5 = path.resolve("assets");
        if (OpenOnyxLauncher.hasAssetIndex(path5)) {
            return path5;
        }
        ArrayList<Path> arrayList = new ArrayList<Path>();
        String string2 = System.getProperty("user.home", "");
        if (string2.length() > 0) {
            path3 = Paths.get(string2, new String[0]);
            arrayList.add(path3.resolve("Library/Application Support/PrismLauncher/assets"));
            arrayList.add(path3.resolve("Library/Application Support/multimc/assets"));
            arrayList.add(path3.resolve("Library/Application Support/minecraft/assets"));
            arrayList.add(path3.resolve(".local/share/PrismLauncher/assets"));
            arrayList.add(path3.resolve(".var/app/org.prismlauncher.PrismLauncher/data/PrismLauncher/assets"));
            arrayList.add(path3.resolve(".minecraft/assets"));
            arrayList.add(path3.resolve("AppData/Roaming/.minecraft/assets"));
        }
        arrayList.add(path2.resolve("assets"));
        path3 = path2.getParent();
        if (path3 != null) {
            arrayList.add(path3.resolve("assets"));
        }
        for (Path path6 : arrayList) {
            if (!OpenOnyxLauncher.hasAssetIndex(path6)) continue;
            System.out.println("[OpenOnyx] using shared assets: " + path6);
            return path6;
        }
        System.err.println("[OpenOnyx] no 1.8 assets found (no indexes/1.8.json in the usual places).");
        System.err.println("[OpenOnyx] the game will start, but without sound/music.");
        System.err.println("[OpenOnyx] fix: create " + path5 + " or start with -Donyx.assetsDir=<path>");
        return path5;
    }

    private static boolean hasAssetIndex(Path path) {
        return path != null && Files.isRegularFile(path.resolve("indexes/1.8.json"), new LinkOption[0]);
    }

    private static Path locateJar() {
        try {
            URL uRL = OpenOnyxLauncher.class.getProtectionDomain().getCodeSource().getLocation();
            Path path = Paths.get(uRL.toURI());
            return Files.isRegularFile(path, new LinkOption[0]) ? path : null;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static void extractNatives(Path path, Path path2) throws Exception {
        Files.createDirectories(path2, new FileAttribute[0]);
        if (path == null) {
            return;
        }
        String string = System.getProperty("os.name", "").toLowerCase();
        String string2 = System.getProperty("os.arch", "").toLowerCase();
        String string3 = string.contains("mac") && (string2.contains("arm") || string2.contains("aarch64")) ? "macos-arm64" : (string.contains("mac") ? "macos-x64" : (string.contains("win") ? "windows" : "windows"));
        try (ZipFile zipFile = new ZipFile(path.toFile());){
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                String string4;
                int n;
                ZipEntry zipEntry = enumeration.nextElement();
                String string5 = zipEntry.getName();
                if (!string5.startsWith("native/") || zipEntry.isDirectory() || (n = (string4 = string5.substring("native/".length())).indexOf(47)) < 0 || !string4.substring(0, n).equals(string3)) continue;
                Path path3 = path2.resolve(string4.substring(n + 1));
                Files.createDirectories(path3.getParent(), new FileAttribute[0]);
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                try {
                    Files.copy(inputStream, path3, StandardCopyOption.REPLACE_EXISTING);
                }
                finally {
                    if (inputStream == null) continue;
                    inputStream.close();
                }
            }
        }
    }
}

