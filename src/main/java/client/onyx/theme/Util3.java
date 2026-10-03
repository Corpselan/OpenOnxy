package client.onyx.theme;

public final class Util3 {
   public static final float FLOAT = 32.0F;
   public static final float FLOAT2 = 12.0F;
   public static final float FLOAT3 = 28.0F;
   public static final float FLOAT4 = 0.0F;
   public static final float FLOAT5 = 48.0F;
   public static final float FLOAT6 = 4.0F;
   public static final float FLOAT7 = 16.0F;
   public static final float FLOAT8 = 8.0F;
   public static final float FLOAT9 = 20.0F;
   public static final float FLOAT10 = Float.MAX_VALUE;

   private Util3() {
   }

   public static float getFloatForFloat(float var0, float var1, float var2) {
      return Math.min(var0, Math.min(var1, var2) / 2.0F);
   }
}
