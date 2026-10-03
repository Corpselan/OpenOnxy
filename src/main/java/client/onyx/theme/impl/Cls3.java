package client.onyx.theme.impl;

public final class Cls3 {
   public final double double_;
   public final double double_2;
   public final double double_3;
   public final double double_4;
   public final double double_5;
   public final double double_6;

   public static Cls3 getCls3ForInt(int var0) {
      return getCls3ForDoubleArray(Util2.getDoubleArrayForInt(var0), Util.UTIL);
   }

   private static double getDoubleForDouble2(double var0, double var2) {
      var2 = Math.pow(var2 * Math.abs(var0) / 100.0, 0.42);
      return Math.signum(var0) * 400.0 * var2 / (var2 + 27.13);
   }

   public int getInt2(Util var1) {
      double var2 = this.double_2 != 0.0 && this.double_6 != 0.0 ? this.double_2 / Math.sqrt(this.double_6 / 100.0) : 0.0;
      var2 = Math.pow(var2 / Math.pow(1.64 - Math.pow(0.29, var1.double_7), 0.73), 1.1111111111111112);
      double var4 = Math.toRadians(this.double_);
      double var6 = 0.25 * (Math.cos(var4 + 2.0) + 3.8);
      double var8 = var1.double_2 * Math.pow(this.double_6 / 100.0, 1.0 / var1.double_3 / var1.double_5);
      var6 = var6 * 3846.153846153846 * var1.double_6 * var1.double_8;
      var8 /= var1.double_;
      double var10 = Math.sin(var4);
      var4 = Math.cos(var4);
      double var13;
      var4 = (var13 = 23.0 * (var8 + 0.305) * var2 / (23.0 * var6 + 11.0 * var2 * var4 + 108.0 * var2 * var10)) * var4;
      var2 = var13 * var10;
      var6 = (460.0 * var8 + 451.0 * var4 + 288.0 * var2) / 1403.0;
      var10 = (460.0 * var8 - 891.0 * var4 - 261.0 * var2) / 1403.0;
      var2 = (460.0 * var8 - 220.0 * var4 - 6300.0 * var2) / 1403.0;
      var4 = getDoubleForDouble(var6, var1.double_9) / var1.doubleArray[0];
      var6 = getDoubleForDouble(var10, var1.double_9) / var1.doubleArray[1];
      var2 = getDoubleForDouble(var2, var1.double_9) / var1.doubleArray[2];
      var8 = 1.86206786 * var4 - 1.01125463 * var6 + 0.14918677 * var2;
      var10 = 0.38752654 * var4 + 0.62144744 * var6 - 0.00897398 * var2;
      var2 = -0.0158415 * var4 - 0.03412294 * var6 + 1.04996444 * var2;
      return Util2.getIntForDouble2(var8, var10, var2);
   }

   public static Cls3 getCls3ForDoubleArray(double[] var0, Util var1) {
      double var2 = var0[0];
      double var4 = var0[1];
      double var6 = var0[2];
      double var8 = 0.401288 * var2 + 0.650173 * var4 - 0.051461 * var6;
      double var10 = -0.250268 * var2 + 1.204414 * var4 + 0.045854 * var6;
      var2 = -0.002079 * var2 + 0.048952 * var4 + 0.953127 * var6;
      var4 = getDoubleForDouble2(var1.doubleArray[0] * var8, var1.double_9);
      var6 = getDoubleForDouble2(var1.doubleArray[1] * var10, var1.double_9);
      var2 = getDoubleForDouble2(var1.doubleArray[2] * var2, var1.double_9);
      var8 = (11.0 * var4 - 12.0 * var6 + var2) / 11.0;
      var10 = (var4 + var6 - 2.0 * var2) / 9.0;
      double var12 = (20.0 * var4 + 20.0 * var6 + 21.0 * var2) / 20.0;
      var2 = (40.0 * var4 + 20.0 * var6 + var2) / 20.0;
      var6 = Math.toRadians(var4 = Util2.getDoubleForDouble(Math.toDegrees(Math.atan2(var10, var8))));
      var2 *= var1.double_;
      var2 = 100.0 * Math.pow(var2 / var1.double_2, var1.double_3 * var1.double_5);
      double var14 = var4 < 20.14 ? var4 + 360.0 : var4;
      var14 = 0.25 * (Math.cos(Math.toRadians(var14) + 2.0) + 3.8);
      double var26;
      var10 = (
            var26 = Math.pow(3846.153846153846 * var14 * var1.double_6 * var1.double_8 * Math.hypot(var8, var10) / (var12 + 0.305), 0.9)
               * Math.pow(1.64 - Math.pow(0.29, var1.double_7), 0.73)
               * Math.sqrt(var2 / 100.0)
         )
         * var1.double_4;
      var12 = 1.7 * var2 / (1.0 + 0.007 * var2);
      var10 = 43.859649122807014 * Math.log1p(0.0228 * var10);
      return new Cls3(var4, var26, var2, var12, var10 * Math.cos(var6), var10 * Math.sin(var6));
   }

   public double getDouble(Cls3 var1) {
      double var2 = this.double_4 - var1.double_4;
      double var4 = this.double_3 - var1.double_3;
      double var6 = this.double_5 - var1.double_5;
      return 1.41 * Math.pow(Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6), 0.63);
   }

   private Cls3(double var1, double var3, double var5, double var7, double var9, double var11) {
      this.double_ = var1;
      this.double_2 = var3;
      this.double_6 = var5;
      this.double_4 = var7;
      this.double_3 = var9;
      this.double_5 = var11;
   }

   private static double getDoubleForDouble(double var0, double var2) {
      double var4 = Math.max(0.0, 27.13 * Math.abs(var0) / (400.0 - Math.abs(var0)));
      return Math.signum(var0) * (100.0 / var2) * Math.pow(var4, 2.380952380952381);
   }

   public static Cls3 getCls3ForDouble(double var0, double var2, double var4) {
      Util var6 = Util.UTIL;
      double var7 = var2 * var6.double_4;
      double var9 = 1.7 * var0 / (1.0 + 0.007 * var0);
      var7 = 43.859649122807014 * Math.log1p(0.0228 * var7);
      double var11 = Math.toRadians(var4);
      return new Cls3(var4, var2, var0, var9, var7 * Math.cos(var11), var7 * Math.sin(var11));
   }

   public int getInt() {
      return this.getInt2(Util.UTIL);
   }
}
