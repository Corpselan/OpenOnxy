package client.onyx.theme;

public final class Util4 {
   private static int int_ = -10006364;
   public static final float FLOAT = 0.12F;
   public static final float FLOAT2 = 0.25F;
   public static final float FLOAT3 = 0.1F;
   private static float float_2 = 0.25F;
   public static final float FLOAT4 = 0.08F;
   public static final float FLOAT5 = 0.38F;
   private static PrimaryOnPrimaryRecord primaryOnPrimaryRecord = PrimaryOnPrimaryRecord.getPrimaryOnPrimaryRecordForInt(-10006364, 0.25F);
   public static final float FLOAT6 = 0.16F;
   public static final int INT = -10006364;
   private static float float_ = 1.0F;
   public static final float FLOAT7 = 0.1F;

   public static float getFloat2() {
      return float_;
   }

   public static PrimaryOnPrimaryRecord getPrimaryOnPrimaryRecord() {
      return primaryOnPrimaryRecord;
   }

   public static void handleFloat2(float var0) {
      float_2 = Math.clamp(var0, 0.0F, 1.0F);
      primaryOnPrimaryRecord = PrimaryOnPrimaryRecord.getPrimaryOnPrimaryRecordForInt(int_, float_2);
   }

   public static float getFloat() {
      return float_2;
   }

   public static int getInt() {
      return int_;
   }

   public static void handleFloat(float var0) {
      float_ = Math.clamp(var0, 0.3F, 1.5F);
   }

   public static int getIntForFloat(float var0) {
      return getIntForInt2(primaryOnPrimaryRecord.scrim(), var0);
   }

   public static int getIntForInt(int var0) {
      return getIntForInt2(var0, 0.38F);
   }

   private Util4() {
   }

   public static void handleInt(int var0) {
      int_ = var0 | 0xFF000000;
      primaryOnPrimaryRecord = PrimaryOnPrimaryRecord.getPrimaryOnPrimaryRecordForInt(int_, float_2);
   }

   public static int getIntForInt3(int var0, boolean var1, boolean var2) {
      if (var2) {
         return getIntForInt2(var0, 0.1F);
      } else {
         return var1 ? getIntForInt2(var0, 0.08F) : 0;
      }
   }

   public static int getIntForInt2(int var0, float var1) {
      return client.onyx.theme.impl.Util2.getIntForInt3(var0, var1);
   }
}
