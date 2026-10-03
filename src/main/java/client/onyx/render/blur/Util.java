package client.onyx.render.blur;

import client.onyx.theme.impl.Util2;

public final class Util {
   public static final float FLOAT = 0.6F;
   public static final float FLOAT2 = 1.5F;
   public static final int INT = 20;
   public static final float FLOAT3 = 0.8F;
   public static final float FLOAT4 = 0.7F;
   public static final int INT2 = 18;
   public static final float FLOAT5 = 0.1F;
   public static final float FLOAT6 = 0.6F;
   public static final float FLOAT7 = 0.2F;
   public static final float FLOAT8 = 0.5F;

   public static float getFloatForInt2(int var0, long var1, float var3) {
      return (float)Math.toRadians(var0 * 20 + getFloatForLong(var1, var3) * 0.3F);
   }

   public static float getFloatForFloat3(float var0, float var1) {
      return var0 * getFloatForFloat2(var1);
   }

   public static float getFloatForFloat(float var0) {
      return 1.25F - 0.5F * getFloatForFloat2(var0);
   }

   public static float getFloatForLong(long var0, float var2) {
      return (float)(var0 % 360000L) / 2.5F + var2;
   }

   public static float getFloatForFloat4(float var0) {
      return var0 * 1.5F;
   }

   public static int getIntForInt3(int var0, float var1) {
      return Util2.getIntForInt5(
         Util2.getIntForInt6(var0),
         Math.min(255, (int)(Util2.getIntForInt7(var0) * var1)),
         Math.min(255, (int)(Util2.getIntForInt(var0) * var1)),
         Math.min(255, (int)(Util2.getIntForInt2(var0) * var1))
      );
   }

   public static float getFloatForFloat2(float var0) {
      return Math.clamp(var0, 0.0F, 1.0F);
   }

   public static float getFloatForInt(int var0, float var1) {
      int var3 = var0 * 20;
      return 0.1F + var1 * Math.abs((float)Math.sin(var3));
   }

   public static int getIntForInt4(int var0, int var1, float var2) {
      var2 = getFloatForFloat2(var2);
      return Util2.getIntForInt5(
         Util2.getIntForInt6(var0),
         getIntForInt2(Util2.getIntForInt7(var0), Util2.getIntForInt7(var1), var2),
         getIntForInt2(Util2.getIntForInt(var0), Util2.getIntForInt(var1), var2),
         getIntForInt2(Util2.getIntForInt2(var0), Util2.getIntForInt2(var1), var2)
      );
   }

   public static int getIntForInt(int var0, float var1) {
      float var3 = Util2.getIntForInt6(var0) / 255.0F;
      return Util2.getIntForInt3(var0, var3 * getFloatForFloat2(var1));
   }

   private Util() {
   }

   private static int getIntForInt2(int var0, int var1, float var2) {
      return Math.clamp((long)Math.round(var0 + (var1 - var0) * var2), 0, 255);
   }
}
