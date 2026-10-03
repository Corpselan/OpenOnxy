package client.onyx.theme.impl;

public final class Util {
   public final double double_;
   public final double double_2;
   public final double[] doubleArray;
   public final double double_3;
   public final double double_4;
   public final double double_5;
   public final double double_6;
   public final double double_7;
   public final double double_8;
   public final double double_9;
   public static final Util UTIL = getUtilForDoubleArray(Util2.DOUBLE_ARRAY, 63.66197723675813 * Util2.getDoubleForDouble2(50.0) / 100.0, 50.0, 2.0, false);

   private static double getDoubleForDouble(double var0, double var2, double var4) {
      return (1.0 - var4) * var0 + var4 * var2;
   }

   public static Util getUtilForDoubleArray(double[] var0, double var1, double var3, double var5, boolean var7) {
      double var8 = var0[0] * 0.401288 + var0[1] * 0.650173 + var0[2] * -0.051461;
      double var10 = var0[0] * -0.250268 + var0[1] * 1.204414 + var0[2] * 0.045854;
      double var12 = var0[0] * -0.002079 + var0[1] * 0.048952 + var0[2] * 0.953127;
      double var25;
      double var14 = (var25 = 0.8 + var5 / 10.0) >= 0.9
         ? getDoubleForDouble(0.59, 0.69, (var25 - 0.9) * 10.0)
         : getDoubleForDouble(0.525, 0.59, (var25 - 0.8) * 10.0);
      double var16 = var7 ? 1.0 : var25 * (1.0 - 0.2777777777777778 * Math.exp((-var1 - 42.0) / 92.0));
      var16 = Math.clamp(var16, 0.0, 1.0);
      double[] var34 = new double[3];
      boolean var10002 = true;
      var34[0] = var16 * (100.0 / var8) + 1.0 - var16;
      var34[1] = var16 * (100.0 / var10) + 1.0 - var16;
      var34[2] = var16 * (100.0 / var12) + 1.0 - var16;
      double[] var22 = var34;
      double var35 = var16 = 1.0 / (5.0 * var1 + 1.0);
      var16 = var35 * var35 * var16 * var16;
      double var18 = 1.0 - var16;
      var1 = var16 * var1 + 0.1 * var18 * var18 * Math.cbrt(5.0 * var1);
      var3 = Util2.getDoubleForDouble2(var3) / var0[1];
      var16 = 1.48 + Math.sqrt(var3);
      var18 = 0.725 / Math.pow(var3, 0.2);
      var34 = new double[3];
      var10002 = true;
      var34[0] = Math.pow(var1 * var22[0] * var8 / 100.0, 0.42);
      var34[1] = Math.pow(var1 * var22[1] * var10 / 100.0, 0.42);
      var34[2] = Math.pow(var1 * var22[2] * var12 / 100.0, 0.42);
      double[] var28 = var34;
      var34 = new double[3];
      var10002 = true;
      var34[0] = 400.0 * var28[0] / (var28[0] + 27.13);
      var34[1] = 400.0 * var28[1] / (var28[1] + 27.13);
      var34[2] = 400.0 * var28[2] / (var28[2] + 27.13);
      double[] var20 = var34;
      var8 = (2.0 * var20[0] + var20[1] + 0.05 * var20[2]) * var18;
      return new Util(var3, var8, var18, var18, var14, var25, var1, Math.pow(var1, 0.25), var16, var22);
   }

   private Util(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17, double[] var19) {
      this.double_7 = var1;
      this.double_2 = var3;
      this.double_ = var5;
      this.double_8 = var7;
      this.double_3 = var9;
      this.double_6 = var11;
      this.double_9 = var13;
      this.double_4 = var15;
      this.double_5 = var17;
      this.doubleArray = var19;
   }
}
