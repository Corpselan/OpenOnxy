package client.onyx.render.cape;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;

public final class CapeLoader implements MinecraftAccess {
   private static final ResourceLocation RESOURCE_LOCATION2 = new ResourceLocation("onyx", "capes/local");
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("onyx", "capes/source");
   private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor(var0 -> {
      Thread var10000 = new Thread(var0, "onyx-cape-loader");
      var10000.setDaemon(true);
      return var10000;
   });

   public static void handleBufferedImage2(BufferedImage var0, Consumer<ResourceLocation> var1) {
      MINECRAFT.addScheduledTask(() -> {
         MINECRAFT.getTextureManager().deleteTexture(RESOURCE_LOCATION2);
         MINECRAFT.getTextureManager().loadTexture(RESOURCE_LOCATION2, new DynamicTexture(var0));
         var1.accept(RESOURCE_LOCATION2);
      });
   }

   private CapeLoader() {
   }

   public static ResourceLocation getResourceLocationForBufferedImage(BufferedImage var0) {
      MINECRAFT.getTextureManager().deleteTexture(RESOURCE_LOCATION);
      MINECRAFT.getTextureManager().loadTexture(RESOURCE_LOCATION, new DynamicTexture(var0));
      return RESOURCE_LOCATION;
   }

   public static void handleConsumer(Consumer<ResourceLocation> var0, Consumer<String> var1) {
      BufferedImage var4;
      try {
         var4 = Util.getBufferedImage3();
      } catch (IOException var5) {
         OnyxClient.LOGGER.warn("CapeChanger: failed to draw the default cape", var5);
         var1.accept("Can't draw the default cape");
         return;
      }

      handleBufferedImage2(var4, var0);
   }

   public static void handleString9(String var0, Consumer<BufferedImage> var1, Consumer<String> var2) {
      if (!var0.isEmpty()) {
         EXECUTOR_SERVICE.submit(() -> {
            BufferedImage var3;
            try {
               var3 = ImageIO.read(new File(var0));
            } catch (IOException var8) {
               Logger var6 = OnyxClient.LOGGER;
               Object[] var7 = new Object[]{var0, var8};
               var6.warn("CapeChanger: failed to read '{}'", var7);
               var2.accept("Can't read that file");
               return;
            }

            if (var3 == null) {
               var2.accept("Not a readable PNG");
            } else {
               MINECRAFT.addScheduledTask(() -> var1.accept(var3));
            }
         });
      }
   }

   public static void handleBufferedImage(
      BufferedImage var0, Util2.AutoFitEnum var1, int var2, double var3, double var5, double var7, Consumer<ResourceLocation> var9
   ) {
      EXECUTOR_SERVICE.submit(() -> {
         Util2.AutoFitEnum var11 = var1;
         BufferedImage var12 = var0;

         try {
            handleBufferedImage2(Util2.getBufferedImageForBufferedImage(var12, var11, var2, var3, var5, var7), var9);
         } catch (RuntimeException var10) {
            OnyxClient.LOGGER.warn("CapeChanger: failed to compose the cape", var10);
         }
      });
   }
}
