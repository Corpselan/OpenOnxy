package client.onyx.nowplaying;

import client.onyx.OnyxClient;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;

final class WindowsNowPlaying implements NowPlayingSource {
   private boolean bool;
   private static final String STRING = "$ErrorActionPreference = 'Stop'\n$outPath = '__OUTPUT__'\n\nfunction Write-Result($obj) {\n    [System.IO.File]::WriteAllText($outPath, ($obj | ConvertTo-Json -Compress), [System.Text.Encoding]::UTF8)\n}\n\ntry {\n    Add-Type -AssemblyName System.Runtime.WindowsRuntime\n\n    $asTaskGeneric = ([System.WindowsRuntimeSystemExtensions].GetMethods() | Where-Object {\n        $_.Name -eq 'AsTask' -and $_.GetParameters().Count -eq 1 -and $_.GetParameters()[0].ParameterType.Name -eq 'IAsyncOperation`1'\n    })[0]\n\n    function Await($WinRtTask, $ResultType) {\n        $asTask = $asTaskGeneric.MakeGenericMethod($ResultType)\n        $netTask = $asTask.Invoke($null, @($WinRtTask))\n        $netTask.Wait(-1) | Out-Null\n        $netTask.Result\n    }\n\n    [Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager,Windows.Media.Control,ContentType=WindowsRuntime] | Out-Null\n\n    $manager = Await ([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager]::RequestAsync()) ([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager])\n    $session = $manager.GetCurrentSession()\n\n    if ($null -eq $session) {\n        Write-Result ([PSCustomObject]@{ empty = $true })\n        exit 0\n    }\n\n    $props = Await ($session.TryGetMediaPropertiesAsync()) ([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionMediaProperties])\n    $playback = $session.GetPlaybackInfo()\n    $timeline = $session.GetTimelineProperties()\n\n    # SMTC hands the cover over as a stream reference rather than a URL, so it has to be\n    # read out whole and carried back as base64. Its own try/catch: a player that\n    # publishes no thumbnail, or hands back a stream that will not open, must still\n    # leave the title and the progress bar working.\n    #\n    # The stream comes back from the reflection-driven await as a bare COM object with no\n    # usable WinRT projection: its .Size reads as empty (so the old size-gated read never\n    # ran) and DataReader refuses to wrap it. AsStreamForRead projects it to an ordinary\n    # .NET stream, which drains cleanly regardless — that is the only path that works here.\n    $art = $null\n\n    try {\n        $reference = $props.Thumbnail\n\n        if ($null -ne $reference) {\n            $stream = Await ($reference.OpenReadAsync()) ([Windows.Storage.Streams.IRandomAccessStreamWithContentType])\n\n            $asStreamForRead = [System.IO.WindowsRuntimeStreamExtensions].GetMethods() | Where-Object {\n                $_.Name -eq 'AsStreamForRead' -and $_.GetParameters().Count -eq 1\n            } | Select-Object -First 1\n\n            $netStream = $asStreamForRead.Invoke($null, @($stream))\n\n            try {\n                $buffer = New-Object System.IO.MemoryStream\n                $netStream.CopyTo($buffer)\n                $bytes = $buffer.ToArray()\n\n                if ($bytes.Length -gt 0) {\n                    $art = [Convert]::ToBase64String($bytes)\n                }\n\n                $buffer.Dispose()\n            } finally {\n                $netStream.Dispose()\n            }\n        }\n    } catch {\n        $art = $null\n    }\n\n    Write-Result ([PSCustomObject]@{\n        title = $props.Title\n        artist = $props.Artist\n        playing = ($playback.PlaybackStatus.ToString() -eq 'Playing')\n        positionMs = [math]::Round($timeline.Position.TotalMilliseconds)\n        durationMs = [math]::Round(($timeline.EndTime - $timeline.StartTime).TotalMilliseconds)\n        art = $art\n    })\n} catch {\n    Write-Result ([PSCustomObject]@{ error = $_.Exception.Message })\n}\n";
   private static final long LONG = 6L;
   private Path path;
   private boolean bool2;
   private Path path2;

   private byte[] getByteArray(String var1) {
      if (var1 != null && !var1.isBlank()) {
         try {
            byte[] var3 = Base64.getDecoder().decode(var1);
            if (!this.bool) {
               this.bool = true;
               Logger var4 = OnyxClient.LOGGER;
               Object[] var5 = new Object[1];
               Integer var6 = var3.length;
               var5[0] = var6;
               var4.info("Now-playing (Windows): cover art is {} bytes", var5);
            }

            return var3;
         } catch (IllegalArgumentException var7) {
            this.handleString("Malformed thumbnail from PowerShell (" + var1.length() + " chars)");
            return null;
         }
      } else {
         if (!this.bool) {
            this.bool = true;
            OnyxClient.LOGGER.info("Now-playing (Windows): session published no cover art");
         }

         return null;
      }
   }

   private NowPlayingSource.TitleArtistRecord2 getTitleArtistRecord22(String var1) {
      JsonElement var2;
      try {
         var2 = new JsonParser().parse(var1);
      } catch (RuntimeException var8) {
         this.handleString("Malformed JSON from PowerShell: " + var1);
         return null;
      }

      if (var2 != null && var2.isJsonObject()) {
         JsonObject var7;
         if ((var7 = var2.getAsJsonObject()).has("error")) {
            this.handleString(new StringBuilder().insert(0, "PowerShell script error: ").append(getStringForJsonObject(var7, "error")).toString());
            return null;
         } else if ((var1 = getStringForJsonObject(var7, "title")) != null && !var1.isBlank()) {
            String var10 = getStringForJsonObject(var7, "artist");
            boolean var4 = var7.has("playing") && var7.get("playing").isJsonPrimitive() && var7.get("playing").getAsBoolean();
            int var5 = getIntForJsonObject(var7, "positionMs");
            int var6 = getIntForJsonObject(var7, "durationMs");
            String var10003;
            boolean var10004;
            if (var10 == null) {
               var10003 = "";
               var10004 = var4;
            } else {
               var10003 = var10;
               var10004 = var4;
            }

            NowPlayingSource.TitleArtistRecord2 var10000 = new NowPlayingSource.TitleArtistRecord2(
               var1, var10003, var10004, var5, var6, null, this.getByteArray(getStringForJsonObject(var7, "art"))
            );
            return var10000;
         } else {
            return null;
         }
      } else {
         this.handleString(new StringBuilder().insert(0, "Unexpected output from PowerShell: ").append(var1).toString());
         return null;
      }
   }

   private static String getStringForJsonObject(JsonObject var0, String var1) {
      JsonElement var2;
      return (var2 = var0.get(var1)) != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isString() ? var2.getAsString() : null;
   }

   private void handleString(String var1) {
      if (!this.bool2) {
         this.bool2 = true;
         Logger var2 = OnyxClient.LOGGER;
         Object[] var3 = new Object[]{var1};
         var2.warn("Now-playing (Windows): {}", var3);
      }
   }

   @Override
   public NowPlayingSource.TitleArtistRecord2 getTitleArtistRecord2() {
      try {
         this.run();
         Files.deleteIfExists(this.path2);
         String[] var10002 = new String[7];
         boolean var10004 = true;
         var10002[0] = "powershell.exe";
         var10002[1] = "-NoProfile";
         var10002[2] = "-NonInteractive";
         var10002[3] = "-ExecutionPolicy";
         var10002[4] = "Bypass";
         var10002[5] = "-File";
         var10002[6] = this.path.toString();
         Process var4 = new ProcessBuilder(var10002).start();
         String var3 = new String(var4.getErrorStream().readAllBytes(), StandardCharsets.UTF_8);
         if (!var4.waitFor(6L, TimeUnit.SECONDS)) {
            var4.destroyForcibly();
            this.handleString("powershell.exe timed out after 6s");
            return null;
         } else {
            Path var5 = this.path2;
            LinkOption[] var6 = new LinkOption[0];
            if (!Files.isRegularFile(var5, var6)) {
               this.handleString(
                  "powershell.exe produced no output (exit "
                     + var4.exitValue()
                     + "). stderr: "
                     + (var3.isBlank() ? "(none)" : var3.strip())
                     + ". Script left at: "
                     + this.path
               );
               return null;
            } else {
               NowPlayingSource.TitleArtistRecord2 var9 = this.getTitleArtistRecord22(Files.readString(this.path2, StandardCharsets.UTF_8));
               this.bool2 = false;
               return var9;
            }
         }
      } catch (InterruptedException | IOException var8) {
         this.handleString(new StringBuilder().insert(0, "Failed to run powershell.exe: ").append(var8.getMessage()).toString());
         return null;
      }
   }

   private void run() throws IOException {
      if (this.path != null) {
         Path var3 = this.path;
         LinkOption[] var4 = new LinkOption[0];
         if (Files.isRegularFile(var3, var4)) {
            return;
         }
      }

      FileAttribute[] var6 = new FileAttribute[0];
      Path var7 = Files.createTempFile("onyx-nowplaying", ".ps1", var6);
      this.path = var7;
      FileAttribute[] var8 = new FileAttribute[0];
      Path var9 = Files.createTempFile("onyx-nowplaying-out", ".json", var8);
      this.path2 = var9;
      this.path.toFile().deleteOnExit();
      this.path2.toFile().deleteOnExit();
      String var2 = this.path2.toString().replace("\\", "\\\\").replace("'", "''");
      Path var10000 = this.path;
      String var10001 = "$ErrorActionPreference = 'Stop'\n$outPath = '__OUTPUT__'\n\nfunction Write-Result($obj) {\n    [System.IO.File]::WriteAllText($outPath, ($obj | ConvertTo-Json -Compress), [System.Text.Encoding]::UTF8)\n}\n\ntry {\n    Add-Type -AssemblyName System.Runtime.WindowsRuntime\n\n    $asTaskGeneric = ([System.WindowsRuntimeSystemExtensions].GetMethods() | Where-Object {\n        $_.Name -eq 'AsTask' -and $_.GetParameters().Count -eq 1 -and $_.GetParameters()[0].ParameterType.Name -eq 'IAsyncOperation`1'\n    })[0]\n\n    function Await($WinRtTask, $ResultType) {\n        $asTask = $asTaskGeneric.MakeGenericMethod($ResultType)\n        $netTask = $asTask.Invoke($null, @($WinRtTask))\n        $netTask.Wait(-1) | Out-Null\n        $netTask.Result\n    }\n\n    [Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager,Windows.Media.Control,ContentType=WindowsRuntime] | Out-Null\n\n    $manager = Await ([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager]::RequestAsync()) ([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager])\n    $session = $manager.GetCurrentSession()\n\n    if ($null -eq $session) {\n        Write-Result ([PSCustomObject]@{ empty = $true })\n        exit 0\n    }\n\n    $props = Await ($session.TryGetMediaPropertiesAsync()) ([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionMediaProperties])\n    $playback = $session.GetPlaybackInfo()\n    $timeline = $session.GetTimelineProperties()\n\n    # SMTC hands the cover over as a stream reference rather than a URL, so it has to be\n    # read out whole and carried back as base64. Its own try/catch: a player that\n    # publishes no thumbnail, or hands back a stream that will not open, must still\n    # leave the title and the progress bar working.\n    #\n    # The stream comes back from the reflection-driven await as a bare COM object with no\n    # usable WinRT projection: its .Size reads as empty (so the old size-gated read never\n    # ran) and DataReader refuses to wrap it. AsStreamForRead projects it to an ordinary\n    # .NET stream, which drains cleanly regardless — that is the only path that works here.\n    $art = $null\n\n    try {\n        $reference = $props.Thumbnail\n\n        if ($null -ne $reference) {\n            $stream = Await ($reference.OpenReadAsync()) ([Windows.Storage.Streams.IRandomAccessStreamWithContentType])\n\n            $asStreamForRead = [System.IO.WindowsRuntimeStreamExtensions].GetMethods() | Where-Object {\n                $_.Name -eq 'AsStreamForRead' -and $_.GetParameters().Count -eq 1\n            } | Select-Object -First 1\n\n            $netStream = $asStreamForRead.Invoke($null, @($stream))\n\n            try {\n                $buffer = New-Object System.IO.MemoryStream\n                $netStream.CopyTo($buffer)\n                $bytes = $buffer.ToArray()\n\n                if ($bytes.Length -gt 0) {\n                    $art = [Convert]::ToBase64String($bytes)\n                }\n\n                $buffer.Dispose()\n            } finally {\n                $netStream.Dispose()\n            }\n        }\n    } catch {\n        $art = $null\n    }\n\n    Write-Result ([PSCustomObject]@{\n        title = $props.Title\n        artist = $props.Artist\n        playing = ($playback.PlaybackStatus.ToString() -eq 'Playing')\n        positionMs = [math]::Round($timeline.Position.TotalMilliseconds)\n        durationMs = [math]::Round(($timeline.EndTime - $timeline.StartTime).TotalMilliseconds)\n        art = $art\n    })\n} catch {\n    Write-Result ([PSCustomObject]@{ error = $_.Exception.Message })\n}\n"
         .replace("__OUTPUT__", var2);
      Charset var10002 = StandardCharsets.UTF_8;
      OpenOption[] var10003 = new OpenOption[0];
      boolean var10005 = true;
      Files.writeString(var10000, var10001, var10002, var10003);
   }

   private static int getIntForJsonObject(JsonObject var0, String var1) {
      JsonElement var2;
      return (var2 = var0.get(var1)) != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isNumber() ? var2.getAsInt() : 0;
   }
}
