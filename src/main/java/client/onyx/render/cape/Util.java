package client.onyx.render.cape;

import client.onyx.MinecraftAccess;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.minecraft.util.ResourceLocation;

public final class Util implements MinecraftAccess {
   private static final int INT = 8;
   private static final int INT2 = 128;
   private static final int INT3 = 12;
   private static final float FLOAT = 0.7F;
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("onyx", "textures/gui/logo.png");
   private static final int INT4 = 176;
   private static final int INT5 = 8;
   private static final Color COLOR4 = new Color(-14474196, true);
   private static final int INT6 = 96;
   private static final Color COLOR = new Color(-15987695, true);
   private static final int INT7 = 136;
   private static final int INT8 = 80;
   private static final Color COLOR3 = new Color(-16119282, true);
   private static final int INT9 = 256;
   private static final Color COLOR2 = new Color(587202559, true);
   private static final int INT10 = 8;
   private static final int INT11 = 512;

   private Util() {
   }

   public static BufferedImage getBufferedImage3() throws IOException {
      InputStream var1 = MINECRAFT.getResourceManager().getResource(RESOURCE_LOCATION).getInputStream();

      BufferedImage var0;
      try {
         var0 = ImageIO.read(var1);
      } catch (Throwable var5) {
         if (var1 != null) {
            try {
               var1.close();
            } catch (Throwable var4) {
               var5.addSuppressed(var4);
               throw var5;
            }

            throw var5;
         }

         throw var5;
      }

      BufferedImage var7;
      if (var1 != null) {
         var7 = var0;
         var1.close();
      } else {
         var7 = var0;
      }

      if (var7 == null) {
         throw new IOException("logo.png is not a readable PNG");
      } else {
         var7 = new BufferedImage(512, 256, 2);
         Graphics2D var2 = var7.createGraphics();
         var2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         var2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         var2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
         var2.setPaint(new GradientPaint(0.0F, 0.0F, COLOR4, 0.0F, 136.0F, COLOR));
         var2.fillRect(0, 0, 176, 136);
         var2.setPaint(COLOR3);
         var2.fillRect(96, 8, 80, 128);
         var2.setPaint(COLOR2);
         var2.setStroke(new BasicStroke(8.0F));
         var2.drawRect(20, 20, 56, 104);
         int var3;
         int var6 = Math.round((float)(var3 = Math.round(56.0F)) * var0.getHeight() / var0.getWidth());
         var2.drawImage(var0, 8 + (80 - var3) / 2, 8 + (128 - var6) / 2, var3, var6, null);
         var2.dispose();
         return var7;
      }
   }
}
