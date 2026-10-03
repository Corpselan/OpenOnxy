package client.onyx.render.cape;

import client.onyx.setting.DisplayNamed;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import net.optifine.player.CapeUtils;

public final class Util2 {
   private static final int INT = 17;
   private static final int INT2 = 8;
   public static final int INT3 = 1;
   public static final int INT4 = 32;
   private static final int INT5 = 22;
   public static final int INT6 = 1;
   public static final int INT7 = 10;
   public static final int INT8 = 12;
   private static final int INT9 = 32;
   private static final float FLOAT = 0.55F;
   public static final int INT10 = 64;
   public static final int INT11 = 16;

   public static boolean isBufferedImage(BufferedImage var0) {
      int var1 = var0.getWidth();
      int var3 = var0.getHeight();
      return var1 % 64 == 0 && var3 % 32 == 0 ? var1 / 64 == var3 / 32 : false;
   }

   public static BufferedImage getBufferedImageForBufferedImage(BufferedImage var0, Util2.AutoFitEnum var1, int var2, double var3, double var5, double var7) {
      if (getAutoFitEnumForAutoFitEnum(var1, var0) == Util2.AutoFitEnum.TEXTURE) {
         return CapeUtils.parseCape(var0);
      } else {
         int var14 = getIntForBufferedImage(var0);
         int var10 = 10 * var14;
         int var11 = 16 * var14;
         BufferedImage var12;
         Graphics2D var13;
         Graphics2D var10001 = var13 = (var12 = new BufferedImage(64 * var14, 32 * var14, 2)).createGraphics();
         var10001.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         var10001.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
         Color var16;
         var10001.setPaint(var16 = new Color(var2 | 0xFF000000, true));
         var10001.fillRect(0, 0, 22 * var14, 17 * var14);
         var10001.setPaint(getColorForColor(var16));
         var10001.fillRect(12 * var14, 1 * var14, var10, var11);
         double[] var15 = getDoubleArrayForBufferedImage(var0, getAutoFitEnumForAutoFitEnum(var1, var0), var10, var11, var3, var5, var7);
         var13.setClip(1 * var14, 1 * var14, var10, var11);
         var13.drawImage(
            var0,
            1 * var14 + (int)Math.round(var15[0]),
            1 * var14 + (int)Math.round(var15[1]),
            Math.max(1, (int)Math.round(var15[2])),
            Math.max(1, (int)Math.round(var15[3])),
            null
         );
         var13.dispose();
         return var12;
      }
   }

   public static double[] getDoubleArrayForBufferedImage(
      BufferedImage var0, Util2.AutoFitEnum var1, double var2, double var4, double var6, double var8, double var10
   ) {
      double var14;
      double var28;
      if (var1 == Util2.AutoFitEnum.STRETCH) {
         var14 = var4;
         var28 = var2;
      } else {
         double var16 = var2 / var0.getWidth();
         double var18 = var4 / var0.getHeight();
         double var20 = var1 == Util2.AutoFitEnum.FILL ? Math.max(var16, var18) : Math.min(var16, var18);
         double var12 = var0.getWidth() * var20;
         var14 = var0.getHeight() * var20;
         var28 = var12;
      }

      double var24 = var28 * var6;
      var14 *= var6;
      double var26 = (var2 - var24) / 2.0 + var8 * var2;
      double var27 = (var4 - var14) / 2.0 + var10 * var4;
      double[] var29 = new double[4];
      boolean var10002 = true;
      var29[0] = var26;
      var29[1] = var27;
      var29[2] = var24;
      var29[3] = var14;
      return var29;
   }

   public static String decrypt(String var0) {
      int var10001 = 3 << 3 ^ 5;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 36;
      int var10000 = var10002;

      for (byte var2 = 45; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var10002 = var5--;
         var1[var10002] = (char)(var10.charAt(var10002) ^ var4);
      }

      return new String(var1);
   }

   private Util2() {
   }

   private static Color getColorForColor(Color var0) {
      return new Color((int)(var0.getRed() * 0.55F), (int)(var0.getGreen() * 0.55F), (int)(var0.getBlue() * 0.55F));
   }

   private static int getIntForBufferedImage(BufferedImage var0) {
      int var2 = (int)Math.ceil(Math.max(var0.getWidth() / 10.0, var0.getHeight() / 16.0));
      return Math.max(8, Math.min(32, var2));
   }

   public static Util2.AutoFitEnum getAutoFitEnumForAutoFitEnum(Util2.AutoFitEnum var0, BufferedImage var1) {
      if (var0 != Util2.AutoFitEnum.AUTO) {
         return var0;
      } else {
         return isBufferedImage(var1) ? Util2.AutoFitEnum.TEXTURE : Util2.AutoFitEnum.FIT;
      }
   }

   public static enum AutoFitEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      AUTO("Auto"),
      FIT("Fit"),
      FILL("Fill"),
      STRETCH("Stretch"),
      TEXTURE("Texture");
      private final String string;


      @Override
      public String getString5() {
         return this.string;
      }

      private AutoFitEnum(String var3) {
         this.string = var3;
      }
   }
}
