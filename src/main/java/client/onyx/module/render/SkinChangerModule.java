/*
 * Decompiled with CFR 0.0.9 (FabricMC cc05e23f).
 */
package client.onyx.module.render;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.hud.notification.InfoSuccessEnum;
import client.onyx.setting.impl.SettingSub;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub4;
import client.onyx.skin.SkinLookup;
import client.onyx.skin.Util;
import client.onyx.system.FileDialog;
import client.onyx.system.Util2;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;

public final class SkinChangerModule
extends Module {
    private static final ExecutorService EXECUTOR_SERVICE;
    public ValueSettingSub11<LocalFilePlayerNameEnum> valueSettingSub112;
    public SettingSub settingSub;
    public SettingSub settingSub2;
    public ValueSettingSub11<DefaultSlimEnum> valueSettingSub113;
    public ValueSettingSub4 valueSettingSub4;
    private static final ResourceLocation RESOURCE_LOCATION;
    public ValueSettingSub4 valueSettingSub42;

    static {
        RESOURCE_LOCATION = new ResourceLocation("onyx", "skins/local");
        EXECUTOR_SERVICE = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable, "onyx-skin-loader");
            thread.setDaemon(true);
            return thread;
        });
    }

    @Override
    protected void run80() {
        this.lambda55();
    }

    private static void handleString11(String string, InfoSuccessEnum infoSuccessEnum) {
        Util2.handleString17("SkinChanger", string, infoSuccessEnum);
    }

    private void handleBufferedImage3(BufferedImage bufferedImage, String string, String string2) {
        BufferedImage skin = new ImageBufferDownload().parseUserSkin(bufferedImage);
        if (skin == null) {
            SkinChangerModule.handleString11("Not a valid skin image", InfoSuccessEnum.ERROR);
            return;
        }
        MINECRAFT.addScheduledTask(() -> {
            MINECRAFT.getTextureManager().deleteTexture(RESOURCE_LOCATION);
            MINECRAFT.getTextureManager().loadTexture(RESOURCE_LOCATION, new DynamicTexture(skin));
            if (!this.isEnabled55()) {
                return;
            }
            Util.handleResourceLocation(RESOURCE_LOCATION, string);
            SkinChangerModule.handleString11(string2, InfoSuccessEnum.SUCCESS);
        });
    }

    private void handleString12(String string) {
        EXECUTOR_SERVICE.submit(() -> {
            BufferedImage bufferedImage;
            try {
                bufferedImage = ImageIO.read(new File(string));
            }
            catch (IOException iOException) {
                Logger logger = OnyxClient.LOGGER;
                Object[] objectArray = new Object[]{string, iOException};
                logger.warn("SkinChanger: failed to read '{}'", objectArray);
                SkinChangerModule.handleString11("Can't read that file", InfoSuccessEnum.ERROR);
                return;
            }
            if (bufferedImage == null) {
                SkinChangerModule.handleString11("Not a readable PNG", InfoSuccessEnum.ERROR);
                return;
            }
            if (bufferedImage.getWidth() != 64 || bufferedImage.getHeight() != 64 && bufferedImage.getHeight() != 32) {
                SkinChangerModule.handleString11(new StringBuilder().insert(0, "Skin must be 64x64 or 64x32, not ").append(bufferedImage.getWidth()).append("x").append(bufferedImage.getHeight()).toString(), InfoSuccessEnum.ERROR);
                return;
            }
            this.handleBufferedImage3(bufferedImage, this.valueSettingSub113.isEnum3(DefaultSlimEnum.SLIM) ? "slim" : "default", "Skin applied");
        });
    }

    private void handleString10(String string2) {
        Consumer<SkinLookup.ImageModelTypeRecord> consumer = imageModelTypeRecord -> this.handleBufferedImage3(imageModelTypeRecord.image(), imageModelTypeRecord.modelType(), new StringBuilder().insert(0, "Wearing ").append(string2).append("'s skin").toString());
        SkinLookup.handleString(string2, consumer, string -> {
            Logger logger = OnyxClient.LOGGER;
            Object[] objectArray = new Object[]{string};
            logger.warn("SkinChanger: {}", objectArray);
            SkinChangerModule.handleString11(string, InfoSuccessEnum.ERROR);
        });
    }

    private void lambda55() {
        if (this.valueSettingSub112.isEnum3(LocalFilePlayerNameEnum.LOCAL_FILE)) {
            if (((String)this.valueSettingSub4.lambda15()).isEmpty()) {
                SkinChangerModule.handleString11("Pick a skin PNG first", InfoSuccessEnum.WARNING);
                return;
            }
            String string = (String)this.valueSettingSub4.lambda15();
            this.handleString12(string);
            return;
        }
        if (((String)this.valueSettingSub42.lambda15()).isEmpty()) {
            SkinChangerModule.handleString11("Type a player name first", InfoSuccessEnum.WARNING);
            return;
        }
        String string = (String)this.valueSettingSub42.lambda15();
        this.handleString10(string);
    }

    @Override
    protected void run79() {
        Util.run();
    }

    public SkinChangerModule() {
        super("SkinChanger", "Overrides your own skin texture locally", ModuleCategory.RENDER);
        SkinChangerModule skinChangerModule = this;
        this.valueSettingSub112 = new ValueSettingSub11<LocalFilePlayerNameEnum>("Source", LocalFilePlayerNameEnum.LOCAL_FILE);
        skinChangerModule.valueSettingSub4 = ((ValueSettingSub4)new ValueSettingSub4("Skin file", "").getBooleanSetting("Full path to a 64x64 or 64x32 skin PNG")).getModeSetting2(this.valueSettingSub112, localFilePlayerNameEnum -> localFilePlayerNameEnum == LocalFilePlayerNameEnum.LOCAL_FILE);
        this.settingSub = new SettingSub("Browse", () -> {
            String string = (String)this.valueSettingSub4.lambda15();
            ValueSettingSub4 valueSettingSub4 = this.valueSettingSub4;
            ValueSettingSub4 valueSettingSub42 = Objects.requireNonNull(valueSettingSub4);
            Consumer<String> consumer = valueSettingSub4::handleObject2;
            FileDialog.handleString("Select a skin PNG", string, consumer);
        }).getSettingSub("Browse\u2026").getBooleanSetting("Or paste the path into the field above").getSetting2(() -> this.valueSettingSub112.isEnum3(LocalFilePlayerNameEnum.LOCAL_FILE));
        this.valueSettingSub42 = new ValueSettingSub4("Player name", "").getModeSetting2(this.valueSettingSub112, localFilePlayerNameEnum -> localFilePlayerNameEnum == LocalFilePlayerNameEnum.PLAYER_NAME);
        this.valueSettingSub113 = ((ValueSettingSub11)new ValueSettingSub11<DefaultSlimEnum>("Arm width", DefaultSlimEnum.DEFAULT).getBooleanSetting("Slim (Alex) vs default (Steve) - can't be detected from a bare local PNG")).getModeSetting2(this.valueSettingSub112, localFilePlayerNameEnum -> localFilePlayerNameEnum == LocalFilePlayerNameEnum.LOCAL_FILE);
        this.settingSub2 = new SettingSub("Apply", this::lambda55).getSettingSub("Apply skin");
        this.valueSettingSub113.getModeSetting3(defaultSlimEnum -> {
            if (this.isEnabled55() && this.valueSettingSub112.isEnum3(LocalFilePlayerNameEnum.LOCAL_FILE) && Util.isEnabled()) {
                Util.handleResourceLocation(Util.getResourceLocation(), defaultSlimEnum == DefaultSlimEnum.SLIM ? "slim" : "default");
            }
        });
    }

    // 顺序按原 $VALUES 数组（即 ordinal）
    public static enum LocalFilePlayerNameEnum {
        LOCAL_FILE,
        PLAYER_NAME;
    }

    public static enum DefaultSlimEnum {
        DEFAULT,
        SLIM;
    }
}

