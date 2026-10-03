package client.onyx.nowplaying;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.render.PixelsSmoothEnum;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.imageio.ImageIO;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.Util.EnumOS;
import org.apache.logging.log4j.Logger;

public final class NowPlayingManager implements MinecraftAccess {
   private final AtomicReference<TitleArtistRecord> atomicReference;
   private Thread thread;
   private int int_;
   private boolean bool;
   private boolean bool2;
   private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).build();
   private final NowPlayingSource nowPlayingSource = getNowPlayingSource();
   private final AtomicReference<NowPlayingManager.KeyTextureRecord> atomicReference2;
   private final AtomicBoolean atomicBoolean;
   private String string;
   private static final long LONG = 800L;

   public NowPlayingManager() {
      this.atomicReference = new AtomicReference<>();
      this.atomicReference2 = new AtomicReference<>();
      this.atomicBoolean = new AtomicBoolean(false);
   }

   private static String getStringForTitleArtistRecord2(NowPlayingSource.TitleArtistRecord2 var0) {
      if (var0.artUrl() != null && !var0.artUrl().isEmpty()) {
         return var0.artUrl();
      } else {
         return var0.artData() != null && var0.artData().length != 0
            ? new StringBuilder().insert(0, "track:").append(var0.title()).append(" - ").append(var0.artist()).toString()
            : null;
      }
   }

   private BufferedImage getBufferedImage(String var1) {
      try {
         HttpRequest var9 = HttpRequest.newBuilder(URI.create(var1)).timeout(Duration.ofSeconds(8L)).GET().build();
         HttpResponse var7;
         if ((var7 = HTTP_CLIENT.send(var9, BodyHandlers.ofByteArray())).statusCode() != 200) {
            return null;
         } else {
            BufferedImage var3;
            try (ByteArrayInputStream var8 = new ByteArrayInputStream((byte[])var7.body())) {
               var3 = ImageIO.read(var8);
            }

            return var3;
         }
      } catch (InterruptedException | IOException var6) {
         return null;
      }
   }

   private static BufferedImage getBufferedImageForBufferedImage(BufferedImage var0) {
      int var2;
      if ((var2 = Math.min(var0.getWidth(), var0.getHeight())) == var0.getWidth() && var2 == var0.getHeight()) {
         return var0;
      } else {
         int var5 = (var0.getWidth() - var2) / 2;
         int var8 = (var0.getHeight() - var2) / 2;
         return var0.getSubimage(var5, var8, var2, var2);
      }
   }

   private void run15() {
      NowPlayingSource.TitleArtistRecord2 var4;
      if ((var4 = this.nowPlayingSource.getTitleArtistRecord2()) != null && var4.title() != null && !var4.title().isBlank()) {
         if (!this.bool) {
            this.bool = true;
            Logger var5 = OnyxClient.LOGGER;
            Object[] var6 = new Object[2];
            String var7 = var4.title();
            var6[0] = var7;
            String var8 = var4.artist();
            var6[1] = var8;
            var5.info("Now-playing: detected \"{}\" by \"{}\"", var6);
         }

         String var2 = var4.title();
         ResourceLocation var3 = this.getResourceLocation(getStringForTitleArtistRecord2(var4), var4.artUrl(), var4.artData(), var2);
         AtomicReference var10000 = this.atomicReference;
         String var10004;
         ResourceLocation var10005;
         if (var4.artist() == null) {
            var10004 = "";
            var10005 = var3;
         } else {
            var10004 = var4.artist();
            var10005 = var3;
         }

         TitleArtistRecord var10001 = new TitleArtistRecord(
            var2, var10004, var10005, var4.playing(), var4.positionMs(), var4.durationMs(), System.nanoTime()
         );
         var10000.set(var10001);
      } else {
         this.atomicReference.set(null);
      }
   }

   private ResourceLocation getResourceLocation(String var1, String var2, byte[] var3, String var4) {
      if (var1 != null && !var1.isEmpty()) {
         NowPlayingManager.KeyTextureRecord var6;
         if ((var6 = this.atomicReference2.get()) != null && var1.equals(var6.key())) {
            return var6.texture();
         } else if (var1.equals(this.string)) {
            return null;
         } else {
            this.string = var1;
            BufferedImage var16 = var2 != null && !var2.isEmpty() ? this.getBufferedImage(var2) : this.getBufferedImage2(var3);
            if (var16 == null) {
               this.string = null;
               return null;
            } else {
               if (!this.bool2) {
                  this.bool2 = true;
                  Logger var10000 = OnyxClient.LOGGER;
                  Object[] var10002 = new Object[2];
                  boolean var10004 = true;
                  var10002[0] = var16.getWidth();
                  var10002[1] = var16.getHeight();
                  var10000.info("Now-playing: cover art source is {}x{} pixels", var10002);
               }

               BufferedImage var14 = getBufferedImageForBufferedImage(var16);
               StringBuilder var8 = new StringBuilder().insert(0, "nowplaying/art-");
               int var10 = this.int_ + 1;
               this.int_ = var10;
               String var12 = var8.append(var10).toString();
               ResourceLocation var15 = new ResourceLocation("onyx", var12);
               var6 = this.atomicReference2.get();
               NowPlayingManager.KeyTextureRecord previous = var6;
               MINECRAFT.addScheduledTask(
                  () -> {
                     MINECRAFT.getTextureManager().loadTexture(var15, new DynamicTexture(var14));
                     this.atomicReference2.set(new NowPlayingManager.KeyTextureRecord(var1, var15));
                     if (previous != null) {
                        ITextureObject var6x;
                        if ((var6x = MINECRAFT.getTextureManager().getTexture(previous.texture())) != null) {
                           PixelsSmoothEnum.handleInt2(var6x.getGlTextureId());
                        }

                        MINECRAFT.getTextureManager().deleteTexture(previous.texture());
                     }

                     TitleArtistRecord var7;
                     if ((var7 = this.atomicReference.get()) != null && var7.art() == null && var4.equals(var7.title())) {
                        this.atomicReference
                           .set(
                              new TitleArtistRecord(
                                 var7.title(), var7.artist(), var15, var7.playing(), var7.progressMs(), var7.durationMs(), var7.capturedAtNanos()
                              )
                           );
                     }
                  }
               );
               return null;
            }
         }
      } else {
         return null;
      }
   }

   private BufferedImage getBufferedImage2(byte[] var1) {
      try {
         BufferedImage var8;
         try (ByteArrayInputStream var7 = new ByteArrayInputStream(var1)) {
            BufferedImage var3;
            if ((var3 = ImageIO.read(var7)) == null) {
               Logger var9 = OnyxClient.LOGGER;
               Object[] var10002 = new Object[1];
               boolean var10004 = true;
               var10002[0] = var1.length;
               var9.warn("Now-playing: cover art ({} bytes) is in no format ImageIO reads", var10002);
            }

            var8 = var3;
         }

         return var8;
      } catch (IOException var6) {
         OnyxClient.LOGGER.warn("Now-playing: failed to decode cover art", var6);
         return null;
      }
   }

   public TitleArtistRecord getTitleArtistRecord() {
      return this.atomicReference.get();
   }

   public boolean isEnabled23() {
      return this.nowPlayingSource != null;
   }

   public synchronized void run13() {
      this.atomicBoolean.set(false);
      if (this.thread != null) {
         this.thread.interrupt();
      }

      this.thread = null;
      this.atomicReference.set(null);
   }

   public synchronized void run14() {
      if (this.nowPlayingSource == null) {
         Logger var1 = OnyxClient.LOGGER;
         Object[] var2 = new Object[1];
         EnumOS var3 = Util.getOSType();
         var2[0] = var3;
         var1.warn("Now-playing: no media source for OS type {}, feature disabled", var2);
      } else if (!this.atomicBoolean.getAndSet(true)) {
         Logger var4 = OnyxClient.LOGGER;
         Object[] var5 = new Object[1];
         String var7 = this.nowPlayingSource.getClass().getSimpleName();
         var5[0] = var7;
         var4.info("Now-playing: starting {} polling", var5);
         Runnable var8 = () -> {
            for (NowPlayingManager var10000 = this; var10000.atomicBoolean.get(); var10000 = this) {
               try {
                  this.run15();
               } catch (RuntimeException var4x) {
                  OnyxClient.LOGGER.warn("Now-playing poll failed", var4x);
               }

               try {
                  Thread.sleep(800L);
               } catch (InterruptedException var3x) {
                  return;
               }
            }
         };
         Thread var9 = new Thread(var8, "onyx-nowplaying");
         this.thread = var9;
         this.thread.setDaemon(true);
         this.thread.start();
      }
   }

   private static NowPlayingSource getNowPlayingSource() {
      switch (Util.getOSType()) {
         case WINDOWS:
            return new WindowsNowPlaying();
         case OSX:
            return new MacNowPlaying();
         default:
            return null;
      }
   }

   private record KeyTextureRecord(String key, ResourceLocation texture) {
   }
}
