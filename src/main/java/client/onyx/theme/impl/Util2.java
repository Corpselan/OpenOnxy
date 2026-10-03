package client.onyx.theme.impl;

public final class Util2 {
   private static final double[][] DOUBLE_ARRAY_ARRAY;
   public static final double[] DOUBLE_ARRAY;
   private static final double[][] DOUBLE_ARRAY_ARRAY2;

   public static double getDoubleForDouble2(double var0) {
      return 100.0 * getDoubleForDouble5((var0 + 16.0) / 116.0);
   }

   public static double getDoubleForInt2(int var0) {
      return getDoubleForDouble4(getDoubleArrayForInt(var0)[1]);
   }

   public static int getIntForInt4(int var0, int var1) {
      return var0 & 16777215 | (var1 & 0xFF) << 24;
   }

   public static double getDoubleForInt(int var0) {
      double var1;
      return (var1 = var0 / 255.0) <= 0.040449936 ? var1 / 12.92 * 100.0 : Math.pow((var1 + 0.055) / 1.055, 2.4) * 100.0;
   }

   public static int getIntForInt7(int var0) {
      return var0 >> 16 & 0xFF;
   }

   public static int getIntForFloat(float var0, float var1, float var2, int var3) {
      float var8 = (float)getDoubleForDouble(var0) / 60.0F;
      float var9;
      float var5 = (var9 = var2 * Math.clamp(var1, 0.0F, 1.0F)) * (1.0F - Math.abs(var8 % 2.0F - 1.0F));
      var2 -= var9;
      float var6;
      float var7;

      return getIntForInt5(switch ((int)var8 % 6) {
         case 0 -> {

            var8 = var9;
            var6 = var5;
            var7 = 0.0F;
            yield var3;
         }
         case 1 -> {
            var8 = var5;
            var6 = var9;
            var7 = 0.0F;
            yield var3;
         }
         case 2 -> {
            var8 = 0.0F;
            var6 = var9;
            var7 = var5;
            yield var3;
         }
         case 3 -> {
            var8 = 0.0F;
            var6 = var5;
            var7 = var9;
            yield var3;
         }
         case 4 -> {
            var8 = var5;
            var6 = 0.0F;
            var7 = var9;
            yield var3;
         }
         default -> {
            var8 = var9;
            var6 = 0.0F;
            var7 = var5;
            yield var3;
         }
      }, Math.round((var8 + var2) * 255.0F), Math.round((var6 + var2) * 255.0F), Math.round((var7 + var2) * 255.0F));
   }

   private static double getDoubleForDouble5(double var0) {
      double var2 = 0.008856451679035631;
      double var4 = 903.2962962962963;
      double var6;
      return (var6 = var0 * var0 * var0) > var2 ? var6 : (116.0 * var0 - 16.0) / var4;
   }

   public static int getIntForInt5(int var0, int var1, int var2, int var3) {
      return (var0 & 0xFF) << 24 | (var1 & 0xFF) << 16 | (var2 & 0xFF) << 8 | var3 & 0xFF;
   }

   public static double getDoubleForDouble(double var0) {
      double var2;
      return (var2 = var0 % 360.0) < 0.0 ? var2 + 360.0 : var2;
   }

   public static int getIntForDouble3(double var0) {
      double var2;
      double var4 = (var2 = var0 / 100.0) <= 0.0031308 ? var2 * 12.92 : 1.055 * Math.pow(var2, 0.4166666666666667) - 0.055;
      return Math.clamp(Math.round(var4 * 255.0), 0, 255);
   }

   public static int getIntForDouble(double var0) {
      int var2 = getIntForDouble3(getDoubleForDouble2(var0));
      return getIntForInt5(255, var2, var2, var2);
   }

   public static double getDoubleForDouble4(double var0) {
      return getDoubleForDouble3(var0 / 100.0) * 116.0 - 16.0;
   }

   public static int getIntForInt3(int var0, float var1) {
      return getIntForInt4(var0, Math.round(Math.clamp(var1, 0.0F, 1.0F) * 255.0F));
   }

   public static int getIntForInt(int var0) {
      return var0 >> 8 & 0xFF;
   }

   public static double[] getDoubleArrayForInt(int var0) {
      double var1 = getDoubleForInt(getIntForInt7(var0));
      double var3 = getDoubleForInt(getIntForInt(var0));
      double var5 = getDoubleForInt(getIntForInt2(var0));
      double[] var10000 = new double[3];
      boolean var10002 = true;
      var10000[0] = DOUBLE_ARRAY_ARRAY[0][0] * var1 + DOUBLE_ARRAY_ARRAY[0][1] * var3 + DOUBLE_ARRAY_ARRAY[0][2] * var5;
      var10000[1] = DOUBLE_ARRAY_ARRAY[1][0] * var1 + DOUBLE_ARRAY_ARRAY[1][1] * var3 + DOUBLE_ARRAY_ARRAY[1][2] * var5;
      var10000[2] = DOUBLE_ARRAY_ARRAY[2][0] * var1 + DOUBLE_ARRAY_ARRAY[2][1] * var3 + DOUBLE_ARRAY_ARRAY[2][2] * var5;
      return var10000;
   }

   private static double getDoubleForDouble3(double var0) {
      double var2 = 0.008856451679035631;
      double var4 = 903.2962962962963;
      return var0 > var2 ? Math.cbrt(var0) : (var4 * var0 + 16.0) / 116.0;
   }

   static {
      double[] var10000 = new double[3];
      boolean var10002 = true;
      var10000[0] = 95.047;
      var10000[1] = 100.0;
      var10000[2] = 108.883;
      DOUBLE_ARRAY = var10000;
      double[][] var0 = new double[3][];
      var10002 = true;
      double[] var3 = new double[3];
      boolean var10004 = true;
      var3[0] = 0.41233895;
      var3[1] = 0.35762064;
      var3[2] = 0.18051042;
      var0[0] = var3;
      double[] var4 = new double[3];
      var10004 = true;
      var4[0] = 0.2126;
      var4[1] = 0.7152;
      var4[2] = 0.0722;
      var0[1] = var4;
      double[] var5 = new double[3];
      var10004 = true;
      var5[0] = 0.01932141;
      var5[1] = 0.11916382;
      var5[2] = 0.95034478;
      var0[2] = var5;
      DOUBLE_ARRAY_ARRAY = var0;
      double[][] var1 = new double[3][];
      var10002 = true;
      double[] var7 = new double[3];
      var10004 = true;
      var7[0] = 3.2413774792388685;
      var7[1] = -1.5376652402851851;
      var7[2] = -0.49885366846268053;
      var1[0] = var7;
      double[] var8 = new double[3];
      var10004 = true;
      var8[0] = -0.9691452513005321;
      var8[1] = 1.8758853451067872;
      var8[2] = 0.04156585616912061;
      var1[1] = var8;
      double[] var9 = new double[3];
      var10004 = true;
      var9[0] = 0.05562093689691305;
      var9[1] = -0.20395524564742123;
      var9[2] = 1.0571799111220335;
      var1[2] = var9;
      DOUBLE_ARRAY_ARRAY2 = var1;
   }

   public static int getIntForInt6(int var0) {
      return var0 >>> 24;
   }

   private Util2() {
   }

   public static int getIntForInt2(int var0) {
      return var0 & 0xFF;
   }

   public static float[] getFloatArrayForInt(int var0) {
      float var5 = getIntForInt7(var0) / 255.0F;
      float var4 = getIntForInt(var0) / 255.0F;
      float var3 = getIntForInt2(var0) / 255.0F;
      float var2 = Math.max(var5, Math.max(var4, var3));
      float var7 = Math.min(var5, Math.min(var4, var3));
      var7 = var2 - var7;
      float var6 = 0.0F;
      if (var7 > 0.0F) {
         if (var2 == var5) {
            var6 = 60.0F * ((var4 - var3) / var7 % 6.0F);
         } else if (var2 == var4) {
            var6 = 60.0F * ((var3 - var5) / var7 + 2.0F);
         } else {
            var6 = 60.0F * ((var5 - var4) / var7 + 4.0F);
         }
      }

      float[] var10000 = new float[3];
      boolean var10002 = true;
      var10000[0] = (float)getDoubleForDouble(var6);
      var10000[1] = var2 == 0.0F ? 0.0F : var7 / var2;
      var10000[2] = var2;
      return var10000;
   }

   public static int getIntForDouble2(double var0, double var2, double var4) {
      int var6 = getIntForDouble3(DOUBLE_ARRAY_ARRAY2[0][0] * var0 + DOUBLE_ARRAY_ARRAY2[0][1] * var2 + DOUBLE_ARRAY_ARRAY2[0][2] * var4);
      int var7 = getIntForDouble3(DOUBLE_ARRAY_ARRAY2[1][0] * var0 + DOUBLE_ARRAY_ARRAY2[1][1] * var2 + DOUBLE_ARRAY_ARRAY2[1][2] * var4);
      int var1 = getIntForDouble3(DOUBLE_ARRAY_ARRAY2[2][0] * var0 + DOUBLE_ARRAY_ARRAY2[2][1] * var2 + DOUBLE_ARRAY_ARRAY2[2][2] * var4);
      return getIntForInt5(255, var6, var7, var1);
   }
}
