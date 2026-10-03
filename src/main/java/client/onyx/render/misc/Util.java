package client.onyx.render.misc;

public final class Util {
   public static final Iface IFACE8 = var0 -> var0;
   public static final Iface IFACE2 = getIfaceForDouble(0.2, 0.0, 0.0, 1.0);
   public static final Iface IFACE7 = getIfaceForDouble(0.05, 0.7, 0.1, 1.0);
   public static final Iface IFACE = getIfaceForDouble(0.3, 0.0, 0.8, 0.15);
   public static final Iface IFACE6 = getIfaceForDouble(0.2, 0.0, 0.0, 1.0);
   public static final Iface IFACE5 = getIfaceForDouble(0.0, 0.0, 0.0, 1.0);
   public static final Iface IFACE4 = getIfaceForDouble(0.3, 0.0, 1.0, 1.0);
   public static final Iface IFACE3 = getIfaceForDouble(0.4, 0.0, 0.2, 1.0);

   private static double getDoubleForDouble(double var0, double var2, double var4) {
      double var6 = var0;

      int var8;
      for (int var10000 = var8 = 0; var10000 < 8; var10000 = var8) {
         double var9;
         if (Math.abs(var9 = getDoubleForDouble2(var6, var2, var4) - var0) < 1.0E-6) {
            return var6;
         }

         double var11;
         if (Math.abs(var11 = getDoubleForDouble3(var6, var2, var4)) < 1.0E-6) {
            break;
         }

         var8++;
         var6 -= var9 / var11;
      }

      double var17 = 0.0;
      double var10 = 1.0;
      var6 = var0;

      for (double var18 = var17; var18 < var10; var18 = var17) {
         double var12;
         if (Math.abs((var12 = getDoubleForDouble2(var6, var2, var4)) - var0) < 1.0E-6) {
            return var6;
         }

         if (var12 < var0) {
            var18 = var17 = var6;
         } else {
            var10 = var6;
            var18 = var17;
         }

         double var14;
         if (Math.abs((var14 = (var18 + var10) / 2.0) - var6) < 1.0E-9) {
            return var6;
         }

         var6 = var14;
      }

      return var6;
   }

   private static double getDoubleForDouble3(double var0, double var2, double var4) {
      double var6 = 1.0 - var0;
      return 3.0 * var6 * var6 * var2 + 6.0 * var6 * var0 * (var4 - var2) + 3.0 * var0 * var0 * (1.0 - var4);
   }

   private static double getDoubleForDouble2(double var0, double var2, double var4) {
      double var6 = 1.0 - var0;
      return 3.0 * var6 * var6 * var0 * var2 + 3.0 * var6 * var0 * var0 * var4 + var0 * var0 * var0;
   }

   private Util() {
   }

   public static Iface getIfaceForDouble(double var0, double var2, double var4, double var6) {
      return var8 -> {
         if (var8 <= 0.0) {
            return 0.0;
         } else {
            return var8 >= 1.0 ? 1.0 : getDoubleForDouble2(getDoubleForDouble(var8, var0, var4), var2, var6);
         }
      };
   }
}
