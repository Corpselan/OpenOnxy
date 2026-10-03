package client.onyx.render.particle;

import client.onyx.theme.impl.Util2;

public final class Util {
   public static final float FLOAT = 0.5019608F;
   private static final long LONG = 500L;

   public static double getDoubleForDouble(double var0) {
      return var0 * 0.01;
   }

   public static float getFloatForLong(long var0, long var2) {
      float var4;
      if (var0 < 500L) {
         var4 = (float)var0 / 500.0F;
      } else if (var0 < var2) {
         var4 = 1.0F;
      } else if (var0 < var2 + 500L) {
         var4 = 1.0F - (float)(var0 - var2) / 500.0F;
      } else {
         var4 = 0.0F;
      }

      return 0.5019608F * Math.clamp(var4, 0.0F, 1.0F);
   }

   private static int getIntForInt(int var0, int var1, float var2) {
      return Math.round(var0 + (var1 - var0) * var2);
   }

   public static long getLongForLong(long var0, double var2) {
      return Math.round(var0 / Math.max(0.01, var2));
   }

   public static int getIntForInt2(int var0, int var1, int var2, long var3) {
      int var6;
      float var7 = ((var6 = (int)Math.floorMod(var3 / 10L + var2 * 50L, 360L)) >= 180 ? 360 - var6 : var6) * 2 / 360.0F;
      return Util2.getIntForInt5(
         255,
         getIntForInt(Util2.getIntForInt7(var0), Util2.getIntForInt7(var1), var7),
         getIntForInt(Util2.getIntForInt(var0), Util2.getIntForInt(var1), var7),
         getIntForInt(Util2.getIntForInt2(var0), Util2.getIntForInt2(var1), var7)
      );
   }

   private Util() {
   }
}
