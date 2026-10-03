package client.onyx.render.trail2;

import client.onyx.MinecraftAccess;
import client.onyx.render.Util8;
import client.onyx.render.Util9;
import java.util.List;
import net.minecraft.util.Vec3;

final class Cls2 implements MinecraftAccess {
   private static final float FLOAT = 4.0F;
   private final double[] doubleArray;
   private static final float FLOAT2 = 0.05F;
   private static final int INT = 2;
   private float float_;
   private static final int INT2 = 8;
   private final float[] floatArray;
   private static final float FLOAT3 = 1.03F;
   private static final float FLOAT4 = 0.12F;
   private static final int INT3 = 16;
   private static final double DOUBLE = 0.06D;
   private float float_2;
   private boolean bool;
   private float float_3;
   private final Vec3[] vec3Array;
   private static final float FLOAT5 = 0.3F;
   private client.onyx.render.extra.Cls cls;
   private boolean bool2;
   private final float[] floatArray2;
   private float float_4;
   private static final float FLOAT6 = 0.16F;

   private int getInt19(List<PositionTimeRecord> var1, ModeColorRecord var2, long var3) {
      Cls2 var9 = this;
      Vec3 var5 = Util8.getVec313();
      float var6 = Util8.getFloat21() * 0.5F;
      this.float_3 = this.float_2 = Float.MAX_VALUE;
      this.float_ = -3.4028235E38F;
      this.float_4 = -3.4028235E38F;
      this.bool2 = false;
      int var7 = 0;

      int var8;
      for(int var10000 = var8 = var1.size() - 1; var10000 >= 0 && var7 < 8; var10000 = var8) {
         PositionTimeRecord var14 = (PositionTimeRecord)var1.get(var8);
         float var10 = Math.clamp((float)(var3 - var14.time()) / (float)var2.lifetime(), 0.0F, 1.0F);
         float var11;
         if (!((var11 = 1.0F - var10) <= 0.0F) && !((var10 = var2.radius() * (1.0F - (float)Math.pow((double)(1.0F - var10), 4.0D))) < 0.05F) && var9.isVec3(var14.position(), var10)) {
            Vec3 var15;
            double var12 = Math.max((var15 = var14.position().subtract(var5)).lengthVector(), 0.1D);
            float var16;
            if (!((var16 = Math.min((float)((double)(var10 * var6) / var12), 0.3F)) <= 0.0F)) {
               int var13 = var7 * 4;
               var9.floatArray2[var13] = (float)var15.xCoord;
               var9.floatArray2[var13 + 1] = (float)var15.yCoord;
               var9.floatArray2[var13 + 2] = (float)var15.zCoord;
               var9.floatArray2[var13 + 3] = var10;
               var9.floatArray[var13] = var11;
               var9.floatArray[var13 + 1] = var16;
               var9.floatArray[var13 + 2] = 0.0F;
               int var10001 = var13 + 3;
               ++var7;
               var9.floatArray[var10001] = 0.0F;
            }
         }

         --var8;
      }

      return var7;
   }

   private Util9.XYRecord getXYRecord2(int var1, ModeColorRecord var2) {
      if (this.bool2) {
         return null;
      } else if (this.float_2 > this.float_) {
         return null;
      } else {
         int var5 = Util9.getInt17();
         int var4 = Util9.getInt16();
         if (var5 > 0 && var4 > 0) {
            float var8 = 0.0F;

            int var6;
            for(int var10000 = var6 = 0; var10000 < var1; var10000 = var6) {
               int var10002 = var6 * 4 + 1;
               ++var6;
               var8 = Math.max(var8, this.floatArray[var10002]);
            }

            float var13 = var2.glassWarp() * 0.16F * var8 * 1.3F;
            float var11 = var2.glassBlur() * 0.12F * var8;
            var1 = (int)Math.ceil((double)Math.max(var13 * (float)var5, var11 * (float)var4)) + 1;
            int var12 = (int)Math.floor((double)(this.float_2 * (float)var5)) - 2;
            int var14 = (int)Math.floor((double)(this.float_3 * (float)var4)) - 2;
            var6 = (int)Math.ceil((double)(this.float_ * (float)var5)) + 2;
            int var7 = (int)Math.ceil((double)(this.float_4 * (float)var4)) + 2;
            return (new Util9.XYRecord(var12, var14, var6 - var12, var7 - var14, var1)).getXYRecord2(var5, var4);
         } else {
            return null;
         }
      }
   }

   private boolean isVec3(Vec3 var1, float var2) {
      if (this.bool2) {
         return true;
      } else {
         Vec3 var6 = Util8.getVec313();
         Vec3 var4 = Util8.getVec315();
         var2 *= 1.03F;
         int var5 = 0;

         int var12;
         int var10000;
         for(var10000 = var12 = 0; var10000 < 16; var10000 = var12) {
            double var7 = (double)var12 * 0.39269908169872414D;
            Vec3 var9 = var1.addVector(Math.cos(var7) * (double)var2, 0.0D, Math.sin(var7) * (double)var2);
            this.vec3Array[var12] = var9;
            this.doubleArray[var12] = var9.subtract(var6).dotProduct(var4);
            if (this.doubleArray[var12] >= 0.06D) {
               ++var5;
            }

            ++var12;
         }

         if (var5 == 0) {
            return false;
         } else {
            float var21 = Float.MAX_VALUE;
            float var18 = Float.MAX_VALUE;
            float var8 = -3.4028235E38F;
            float var19 = -3.4028235E38F;

            int var13;
            for(var10000 = var13 = 0; var10000 < 16; var10000 = var13) {
               int var14 = (var13 + 1) % 16;
               boolean var17 = this.doubleArray[var13] >= 0.06D;
               boolean var16 = this.doubleArray[var14] >= 0.06D;
               if (var17) {
                  float[] var10;
                  if ((var10 = this.getFloatArray2(this.vec3Array[var13])) == null) {
                     return true;
                  }

                  var21 = Math.min(var21, var10[0]);
                  var8 = Math.max(var8, var10[0]);
                  var18 = Math.min(var18, var10[1]);
                  var19 = Math.max(var19, var10[1]);
               }

               if (var17 != var16) {
                  double var20 = (this.doubleArray[var13] - 0.06D) / (this.doubleArray[var13] - this.doubleArray[var14]);
                  float[] var15;
                  if ((var15 = this.getFloatArray2(this.vec3Array[var13].add(this.vec3Array[var14].subtract(this.vec3Array[var13]).scale(var20)))) == null) {
                     return true;
                  }

                  var21 = Math.min(var21, var15[0]);
                  var8 = Math.max(var8, var15[0]);
                  var18 = Math.min(var18, var15[1]);
                  var19 = Math.max(var19, var15[1]);
               }

               ++var13;
            }

            if (!(var8 < 0.0F) && !(var21 > 1.0F) && !(var19 < 0.0F) && !(var18 > 1.0F)) {
               this.float_2 = Math.min(this.float_2, var21);
               this.float_ = Math.max(this.float_, var8);
               this.float_3 = Math.min(this.float_3, var18);
               this.float_4 = Math.max(this.float_4, var19);
               return true;
            } else {
               return false;
            }
         }
      }
   }

   private float[] getFloatArray2(Vec3 var1) {
      float[] var2;
      if ((var2 = Util8.getFloatArrayForVec3(var1, 1.0F, 1.0F)) == null) {
         this.bool2 = true;
         return null;
      } else {
         float[] var10000 = new float[2];
         boolean var10002 = true;
         var10000[0] = Math.clamp(var2[0], -4.0F, 4.0F);
         var10000[1] = Math.clamp(1.0F - var2[1], -4.0F, 4.0F);
         return var10000;
      }
   }

   void handleList14(List<PositionTimeRecord> var1, ModeColorRecord var2, long var3) {
      Cls2 var5 = this;
      if (var2.glass() && !var1.isEmpty()) {
         if (!(var2.glassBlur() <= 0.0F) || !(var2.glassWarp() <= 0.0F)) {
            if (Util9.isEnabled45() && Util8.isEnabled44()) {
               int var8;
               if ((var8 = this.getInt19(var1, var2, var3)) != 0) {
                  Util9.XYRecord var9;
                  if ((var9 = this.getXYRecord2(var8, var2)) != null || this.bool2) {
                     if (!this.bool) {
                        this.bool = true;
                        this.cls = client.onyx.render.extra.Cls.getClsForString2("onyx_jump_glass", "onyx_post", "onyx_jump_glass");
                     }

                     if (this.cls != null && this.cls.isEnabled()) {
                        Vec3 var4 = Util8.getVec315();
                        Vec3 var7raw = Util8.getVec314();
                        Vec3 var7 = new Vec3(-var7raw.xCoord, -var7raw.yCoord, -var7raw.zCoord);
                        Vec3 var6 = var7.crossProduct(var4);
                        Util9.handleCls7(var5.cls, (var6x) -> {
                           int var10000 = 0;
                           var6x.handleString5("uCount", var8);
                           var6x.handleString("uBlur", var2.glassBlur() * 0.12F);
                           var6x.handleString("uWarp", var2.glassWarp() * 0.16F);
                           var6x.handleString3("uForward", (float)var4.xCoord, (float)var4.yCoord, (float)var4.zCoord);
                           var6x.handleString3("uRight", (float)var7.xCoord, (float)var7.yCoord, (float)var7.zCoord);
                           var6x.handleString3("uUp", (float)var6.xCoord, (float)var6.yCoord, (float)var6.zCoord);
                           var6x.handleString2("uTanHalf", 1.0F / Util8.getFloat22(), 1.0F / Util8.getFloat21());

                           for(int var7x = 0; var10000 < var8; var10000 = var7x) {
                              int var8x = var7x * 4;
                              var6x.handleString4("uLensA[" + var7x + "]", this.floatArray2[var8x], this.floatArray2[var8x + 1], this.floatArray2[var8x + 2], this.floatArray2[var8x + 3]);
                              String var10001 = (new StringBuilder()).insert(0, "uLensB[").append(var7x).append("]").toString();
                              float var10002 = this.floatArray[var8x];
                              float var10003 = this.floatArray[var8x + 1];
                              float var10004 = this.floatArray[var8x + 2];
                              int var10006 = var8x + 3;
                              ++var7x;
                              var6x.handleString4(var10001, var10002, var10003, var10004, this.floatArray[var10006]);
                           }

                        }, var9);
                     }
                  }
               }
            }
         }
      }
   }

   Cls2() {
      float[] var10005 = new float[32];
      boolean var10007 = true;
      this.floatArray2 = var10005;
      float[] var10003 = new float[32];
      boolean var2 = true;
      this.floatArray = var10003;
      Vec3[] var10001 = new Vec3[16];
      boolean var3 = true;
      this.vec3Array = var10001;
      double[] var1 = new double[16];
      this.doubleArray = var1;
   }
}
