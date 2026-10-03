package client.onyx.nowplaying;

import client.onyx.OnyxClient;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;

final class MacNowPlaying implements NowPlayingSource {
   private static final String STRING = "on readSpotify()\n    if application \"Spotify\" is running then\n        tell application \"Spotify\"\n            if player state is playing or player state is paused then\n                set trackName to name of current track\n                set trackArtist to artist of current track\n                set isPlaying to (player state is playing)\n                set pos to player position\n                set dur to duration of current track\n                set artUrl to artwork url of current track\n                return trackName & \"@@@\" & trackArtist & \"@@@\" & isPlaying & \"@@@\" & pos & \"@@@\" & dur & \"@@@\" & artUrl\n            end if\n        end tell\n    end if\n    return \"\"\nend readSpotify\n\non readMusic()\n    if application \"Music\" is running then\n        tell application \"Music\"\n            if player state is playing or player state is paused then\n                set trackName to name of current track\n                set trackArtist to artist of current track\n                set isPlaying to (player state is playing)\n                set pos to player position\n                set dur to duration of current track\n                -- Music.app's artwork is embedded binary data, not a URL — no cover here.\n                return trackName & \"@@@\" & trackArtist & \"@@@\" & isPlaying & \"@@@\" & pos & \"@@@\" & dur & \"@@@\"\n            end if\n        end tell\n    end if\n    return \"\"\nend readMusic\n\nset nowPlayingResult to readSpotify()\nif nowPlayingResult is \"\" then set nowPlayingResult to readMusic()\nreturn nowPlayingResult\n";
   private boolean bool;
   private static final String STRING2 = "@@@";
   private static final long LONG = 6L;
   private Path path;

   private void handleString2(String var1) {
      if (!this.bool) {
         this.bool = true;
         Logger var2 = OnyxClient.LOGGER;
         Object[] var3 = new Object[]{var1};
         var2.warn("Now-playing (macOS): {}", var3);
      }
   }

   private void run2() throws IOException {
      if (this.path != null) {
         Path var1 = this.path;
         LinkOption[] var2 = new LinkOption[0];
         if (Files.isRegularFile(var1, var2)) {
            return;
         }
      }

      FileAttribute[] var4 = new FileAttribute[0];
      Path var5 = Files.createTempFile("onyx-nowplaying", ".applescript", var4);
      this.path = var5;
      this.path.toFile().deleteOnExit();
      Path var10000 = this.path;
      Charset var10002 = StandardCharsets.UTF_8;
      OpenOption[] var10003 = new OpenOption[0];
      boolean var10005 = true;
      Files.writeString(
         var10000,
         "on readSpotify()\n    if application \"Spotify\" is running then\n        tell application \"Spotify\"\n            if player state is playing or player state is paused then\n                set trackName to name of current track\n                set trackArtist to artist of current track\n                set isPlaying to (player state is playing)\n                set pos to player position\n                set dur to duration of current track\n                set artUrl to artwork url of current track\n                return trackName & \"@@@\" & trackArtist & \"@@@\" & isPlaying & \"@@@\" & pos & \"@@@\" & dur & \"@@@\" & artUrl\n            end if\n        end tell\n    end if\n    return \"\"\nend readSpotify\n\non readMusic()\n    if application \"Music\" is running then\n        tell application \"Music\"\n            if player state is playing or player state is paused then\n                set trackName to name of current track\n                set trackArtist to artist of current track\n                set isPlaying to (player state is playing)\n                set pos to player position\n                set dur to duration of current track\n                -- Music.app's artwork is embedded binary data, not a URL — no cover here.\n                return trackName & \"@@@\" & trackArtist & \"@@@\" & isPlaying & \"@@@\" & pos & \"@@@\" & dur & \"@@@\"\n            end if\n        end tell\n    end if\n    return \"\"\nend readMusic\n\nset nowPlayingResult to readSpotify()\nif nowPlayingResult is \"\" then set nowPlayingResult to readMusic()\nreturn nowPlayingResult\n",
         var10002,
         var10003
      );
   }

   private static NowPlayingSource.TitleArtistRecord2 getTitleArtistRecord2ForString(String var0) {
      if (var0.isEmpty()) {
         return null;
      } else {
         String[] var1;
         if ((var1 = var0.split("@@@", -1)).length < 5) {
            return null;
         } else {
            String var5;
            if ((var5 = var1[0].trim()).isEmpty()) {
               return null;
            } else {
               String var3 = var1[1].trim();
               boolean var4 = Boolean.parseBoolean(var1[2].trim());
               String var12 = var1.length > 5 ? var1[5].trim() : "";
               if (var12.isEmpty()) {
                  var12 = null;
               }

               try {
                  double var6 = Double.parseDouble(getStringForString(var1[3]));
                  double var8;
                  double var10 = (var8 = Double.parseDouble(getStringForString(var1[4]))) > 1000.0 ? var8 / 1000.0 : var8;
                  return new NowPlayingSource.TitleArtistRecord2(var5, var3, var4, (int)Math.round(var6 * 1000.0), (int)Math.round(var10 * 1000.0), var12, null);
               } catch (NumberFormatException var14) {
                  return new NowPlayingSource.TitleArtistRecord2(var5, var3, var4, 0, 0, var12, null);
               }
            }
         }
      }
   }

   private static String getStringForString(String var0) {
      return var0.trim().replace(',', '.');
   }

   @Override
   public NowPlayingSource.TitleArtistRecord2 getTitleArtistRecord2() {
      try {
         this.run2();
         String[] var10002 = new String[2];
         boolean var10004 = true;
         var10002[0] = "osascript";
         var10002[1] = this.path.toString();
         Process var5 = new ProcessBuilder(var10002).start();
         String var4 = new String(var5.getInputStream().readAllBytes(), StandardCharsets.UTF_8).strip();
         String var3 = new String(var5.getErrorStream().readAllBytes(), StandardCharsets.UTF_8).strip();
         if (!var5.waitFor(6L, TimeUnit.SECONDS)) {
            var5.destroyForcibly();
            this.handleString2("osascript timed out after 6s");
            return null;
         } else if (var5.exitValue() != 0) {
            this.handleString2("osascript exited " + var5.exitValue() + ": " + (var3.isEmpty() ? "(no stderr)" : var3) + ". Script left at: " + this.path);
            return null;
         } else {
            this.bool = false;
            return getTitleArtistRecord2ForString(var4);
         }
      } catch (InterruptedException | IOException var6) {
         this.handleString2(new StringBuilder().insert(0, "Failed to run osascript: ").append(var6.getMessage()).toString());
         return null;
      }
   }
}
