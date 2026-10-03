package client.onyx.render.skeleton;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public final class Util {
   private static final double DOUBLE = 10.5;
   private static final double DOUBLE2 = 12.0;
   private static final double DOUBLE3 = 0.05859375;
   private static final double DOUBLE4 = 4.0;

   public static Util.HeadNeckRecord getHeadNeckRecordForEntityLivingBase(EntityLivingBase var0, float var1) {
      float var27 = var0.prevLimbSwingAmount + (var0.limbSwingAmount - var0.prevLimbSwingAmount) * var1;
      float var3 = var0.limbSwing - var0.limbSwingAmount * (1.0F - var1);
      if (var27 > 1.0F) {
         var27 = 1.0F;
      }

      float var4 = getFloatForFloat2(var0.prevRenderYawOffset, var0.renderYawOffset, var1);
      float var5 = getFloatForFloat2(var0.prevRotationYawHead, var0.rotationYawHead, var1);
      float var6 = getFloatForFloat2(var0.prevRotationPitch, var0.rotationPitch, var1);
      var5 = getFloatForFloat(var5 - var4) * (float) (Math.PI / 180.0);
      var6 *= (float) (Math.PI / 180.0);
      boolean var7 = var0.isSneaking();
      float var8 = MathHelper.cos(var3 * 0.6662F + (float) Math.PI) * 2.0F * var27 * 0.5F;
      float var9 = MathHelper.cos(var3 * 0.6662F) * 2.0F * var27 * 0.5F;
      float var10 = MathHelper.cos(var3 * 0.6662F) * 1.4F * var27;
      var27 = MathHelper.cos(var3 * 0.6662F + (float) Math.PI) * 1.4F * var27;
      var3 = 0.0F;
      double var11 = 0.0;
      double var13 = 12.0;
      double var15 = 0.1;
      if (var7) {
         var3 = 0.5F;
         var8 += 0.4F;
         var9 += 0.4F;
         var11 = 1.0;
         var13 = 9.0;
         var15 = 4.0;
      }

      double var17 = var0.prevPosX + (var0.posX - var0.prevPosX) * var1;
      double var19 = var0.prevPosY + (var0.posY - var0.prevPosY) * var1;
      double var21 = var0.prevPosZ + (var0.posZ - var0.prevPosZ) * var1;
      double var23;
      double var25 = Math.sin(var23 = var4 * (Math.PI / 180.0));
      var23 = Math.cos(var23);
      double[] var10000 = new double[3];
      boolean var10002 = true;
      var10000[0] = 0.0;
      var10000[1] = var11;
      var10000[2] = 0.0;
      double[] var28 = var10000;
      double[] var10001 = new double[3];
      boolean var10003 = true;
      var10001[0] = 0.0;
      var10001[1] = -4.0;
      var10001[2] = 0.0;
      double[] var31 = getDoubleArrayForDoubleArray2(var10000, getDoubleArrayForDoubleArray(var10001, var6, var5));
      var10000 = new double[3];
      var10002 = true;
      var10000[0] = 0.0;
      var10000[1] = 12.0;
      var10000[2] = 0.0;
      double[] var30 = getDoubleArrayForDoubleArray(var10000, var3, 0.0);
      var10000 = new double[3];
      var10002 = true;
      var10000[0] = -5.0;
      var10000[1] = 2.0;
      var10000[2] = 0.0;
      double[] var33 = var10000;
      var10000 = new double[3];
      var10002 = true;
      var10000[0] = 5.0;
      var10000[1] = 2.0;
      var10000[2] = 0.0;
      double[] var35 = var10000;
      var10001 = new double[3];
      var10003 = true;
      var10001[0] = 0.0;
      var10001[1] = 12.0;
      var10001[2] = 0.0;
      double[] var36 = getDoubleArrayForDoubleArray2(var33, getDoubleArrayForDoubleArray(var10001, var8, 0.0));
      var10001 = new double[3];
      var10003 = true;
      var10001[0] = 0.0;
      var10001[1] = 12.0;
      var10001[2] = 0.0;
      double[] var37 = getDoubleArrayForDoubleArray2(var35, getDoubleArrayForDoubleArray(var10001, var9, 0.0));
      var10000 = new double[3];
      var10002 = true;
      var10000[0] = -1.9;
      var10000[1] = var13;
      var10000[2] = var15;
      double[] var38 = var10000;
      var10000 = new double[3];
      var10002 = true;
      var10000[0] = 1.9;
      var10000[1] = var13;
      var10000[2] = var15;
      double[] var40 = var10000;
      var10001 = new double[3];
      var10003 = true;
      var10001[0] = 0.0;
      var10001[1] = 10.5;
      var10001[2] = 0.0;
      double[] var39 = getDoubleArrayForDoubleArray2(var38, getDoubleArrayForDoubleArray(var10001, var10, 0.0));
      var10001 = new double[3];
      var10003 = true;
      var10001[0] = 0.0;
      var10001[1] = 10.5;
      var10001[2] = 0.0;
      double[] var43 = getDoubleArrayForDoubleArray2(var40, getDoubleArrayForDoubleArray(var10001, var27, 0.0));
      return new Util.HeadNeckRecord(
         getVec3ForDoubleArray(var31, var17, var19, var21, var25, var23),
         getVec3ForDoubleArray(var28, var17, var19, var21, var25, var23),
         getVec3ForDoubleArray(var30, var17, var19, var21, var25, var23),
         getVec3ForDoubleArray(var33, var17, var19, var21, var25, var23),
         getVec3ForDoubleArray(var36, var17, var19, var21, var25, var23),
         getVec3ForDoubleArray(var35, var17, var19, var21, var25, var23),
         getVec3ForDoubleArray(var37, var17, var19, var21, var25, var23),
         getVec3ForDoubleArray(var38, var17, var19, var21, var25, var23),
         getVec3ForDoubleArray(var39, var17, var19, var21, var25, var23),
         getVec3ForDoubleArray(var40, var17, var19, var21, var25, var23),
         getVec3ForDoubleArray(var43, var17, var19, var21, var25, var23)
      );
   }

   private static double[] getDoubleArrayForDoubleArray2(double[] var0, double[] var1) {
      double[] var10000 = new double[3];
      boolean var10002 = true;
      var10000[0] = var0[0] + var1[0];
      var10000[1] = var0[1] + var1[1];
      var10000[2] = var0[2] + var1[2];
      return var10000;
   }

   private Util() {
   }

   private static double[] getDoubleArrayForDoubleArray(double[] var0, double var1, double var3) {
      double var5 = Math.cos(var1);
      var1 = Math.sin(var1);
      double var7 = var0[1] * var5 - var0[2] * var1;
      var1 = var0[1] * var1 + var0[2] * var5;
      var5 = var0[0];
      if (var3 != 0.0) {
         double var9 = Math.cos(var3);
         var3 = Math.sin(var3);
         double var11 = var5 * var9 + var1 * var3;
         var1 = -var5 * var3 + var1 * var9;
         var5 = var11;
      }

      double[] var10000 = new double[3];
      boolean var10002 = true;
      var10000[0] = var5;
      var10000[1] = var7;
      var10000[2] = var1;
      return var10000;
   }

   private static float getFloatForFloat2(float var0, float var1, float var2) {
      float var5 = getFloatForFloat(var1 - var0) * var2;
      return var0 + var5;
   }

   private static Vec3 getVec3ForDoubleArray(double[] var0, double var1, double var3, double var5, double var7, double var9) {
      return new Vec3(
         var1 + (var0[0] * var9 + var0[2] * var7) * 0.05859375, var3 + (24.0 - var0[1]) * 0.05859375, var5 + (var0[0] * var7 - var0[2] * var9) * 0.05859375
      );
   }

   private static float getFloatForFloat(float var0) {
      float var2;
      if ((var2 = var0 % 360.0F) >= 180.0F) {
         var2 -= 360.0F;
      }

      if (var2 < -180.0F) {
         var2 += 360.0F;
      }

      return var2;
   }

   public record HeadNeckRecord(
      Vec3 head,
      Vec3 neck,
      Vec3 hip,
      Vec3 rightShoulder,
      Vec3 rightHand,
      Vec3 leftShoulder,
      Vec3 leftHand,
      Vec3 rightHipJoint,
      Vec3 rightFoot,
      Vec3 leftHipJoint,
      Vec3 leftFoot
   ) {
   }
}
