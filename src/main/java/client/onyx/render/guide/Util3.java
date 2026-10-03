package client.onyx.render.guide;

import client.onyx.render.Sampler0;
import java.util.Iterator;
import java.util.List;

public final class Util3 {
   private static final int INT = -1885559891;
   private static final float[] FLOAT_ARRAY;
   private static final float FLOAT = 4.0F;
   private static final int INT2 = 1468764569;
   private static final float FLOAT2 = 7.0F;
   public static final Util3.XYRecord X_Y_RECORD;
   private static final float FLOAT3 = 1.0F;
   private static final float FLOAT4 = 5.0F;

   static {
      float[] var0 = new float[]{0.25F, 0.5F, 0.75F};
      FLOAT_ARRAY = var0;
      X_Y_RECORD = new Util3.XYRecord(0.0F, 0.0F, Float.NaN, Float.NaN);
   }

   public static Util3.XYRecord getXYRecordForFloat(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      return getXYRecordForFloat2(var0, var1, var2, var3, var4, var5, var6, List.of());
   }

   private Util3() {
   }

   private static Util3.PositionGuideRecord getPositionGuideRecordForFloat(float var0, float var1, float var2, float var3, List<float[]> var4, boolean var5) {
      float var6 = var3;
      float var7 = Math.max(var3, var2 - var3 - var1);
      float var8;
      float var9 = var8 = Math.clamp(var0, var3, var7);
      float var10 = Float.NaN;
      float var11 = 8.0F;
      float[] var15 = new float[]{var3, var2 * 0.25F, var2 * 0.5F, var2 * 0.75F, var2 - var3};
      float[] var18 = var15;
      float[] var10000 = new float[5];
      boolean var10002 = true;
      var10000[0] = var3;
      var10000[1] = Math.clamp(var15[1] - var1 / 2.0F, var3, var7);
      var10000[2] = Math.clamp(var15[2] - var1 / 2.0F, var3, var7);
      var10000[3] = Math.clamp(var15[3] - var1 / 2.0F, var3, var7);
      var10000[4] = var7;
      float[] var19 = var10000;

      int var12;
      int var24;
      for(var24 = var12 = 0; var24 < var19.length; var24 = var12) {
         float var13;
         if (!((var13 = Math.abs(var8 - var19[var12])) >= var11) && !(var13 > 7.0F)) {
            var9 = var19[var12];
            var10 = var18[var12];
            var11 = var13;
         }

         ++var12;
      }

      Iterator var22 = var4.iterator();

      while(var22.hasNext()) {
         float[] var23 = (float[])var22.next();
         var2 = var5 ? var23[0] : var23[1];
         var3 = var5 ? var23[2] : var23[3];
         float[] var16 = new float[]{var2, var2 + var3 - var1, var2 + var3 / 2.0F - var1 / 2.0F, var2 + var3, var2 - var1};
         float[] var21 = var16;
         float[] var17 = new float[]{var2, var2 + var3, var2 + var3 / 2.0F, var2 + var3, var2};
         var18 = var17;

         int var20;
         for(var24 = var20 = 0; var24 < var21.length; var24 = var20) {
            float var14;
            if (!(var21[var20] < var6) && !(var21[var20] > var7) && !((var14 = Math.abs(var8 - var21[var20])) >= var11) && !(var14 > 7.0F)) {
               var9 = var21[var20];
               var10 = var18[var20];
               var11 = var14;
            }

            ++var20;
         }
      }

      return new Util3.PositionGuideRecord(var9, var10);
   }

   public static Util3.XYRecord getXYRecordForFloat2(float var0, float var1, float var2, float var3, float var4, float var5, float var6, List<float[]> var7) {
      Util3.PositionGuideRecord var9 = getPositionGuideRecordForFloat(var0, var2, var4, var6, var7, true);
      Util3.PositionGuideRecord var8 = getPositionGuideRecordForFloat(var1, var3, var5, var6, var7, false);
      return new Util3.XYRecord(var9.position(), var8.position(), var9.guide(), var8.guide());
   }

   public static void handleSampler02(Sampler0 var0, float var1, float var2, Util3.XYRecord var3) {
      float[] var4;
      int var5 = (var4 = FLOAT_ARRAY).length;

      int var6;
      for(int var10000 = var6 = 0; var10000 < var5; var10000 = var6) {
         float var7 = var4[var6];
         handleSampler03(var0, var1 * var7, var2, 1468764569);
         float var10001 = var2 * var7;
         ++var6;
         handleSampler0(var0, var10001, var1, 1468764569);
      }

      if (Float.isFinite(var3.guideX())) {
         handleSampler03(var0, var3.guideX(), var2, -1885559891);
      }

      if (Float.isFinite(var3.guideY())) {
         handleSampler0(var0, var3.guideY(), var1, -1885559891);
      }

   }

   private static void handleSampler03(Sampler0 var0, float var1, float var2, int var3) {
      float var5;
      for(float var10000 = var5 = 4.0F; var10000 < var2 - 4.0F; var10000 = var5 += 9.0F) {
         var0.handleFloat9(var1, var5, var1, Math.min(var5 + 5.0F, var2 - 4.0F), 1.0F, var3);
      }

   }

   private static void handleSampler0(Sampler0 var0, float var1, float var2, int var3) {
      float var5;
      for(float var10000 = var5 = 4.0F; var10000 < var2 - 4.0F; var10000 = var5 += 9.0F) {
         var0.handleFloat9(var5, var1, Math.min(var5 + 5.0F, var2 - 4.0F), var1, 1.0F, var3);
      }

   }

   public static record XYRecord(float x, float y, float guideX, float guideY) {
      public float guideX() {
         return this.guideX;
      }

      public float y() {
         return this.y;
      }

      public float guideY() {
         return this.guideY;
      }


      public float x() {
         return this.x;
      }
   }

   private static record PositionGuideRecord(float position, float guide) {
      public float guide() {
         return this.guide;
      }

      public float position() {
         return this.position;
      }

   }
}
