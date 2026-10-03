package client.onyx.system;

import client.onyx.MinecraftAccess;
import client.onyx.setting.impl.ValueSettingSub10;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Cls implements MinecraftAccess {
   private int int_;
   private YawPitchRecord yawPitchRecord;
   private float float_;
   private final RotationsBooleanSetting rotationsBooleanSetting;
   private static final float FLOAT = 0.1F;
   private YawPitchRecord yawPitchRecord2;
   private double double_;
   private double double_2;
   private float float_2;
   private int int_2;
   private float float_3;
   private final Random random = new Random();
   private double double_3;
   private float float_4;

   public boolean isEntity6(Entity var1, YawPitchRecord var2, double var3) {
      if (var2 != null && MINECRAFT.thePlayer != null) {
         Vec3 var5 = Util4.getVec323();
         Vec3 var8 = Util4.getVec3ForFloat5(var2.yaw(), var2.pitch());
         Vec3 var9 = var5.addVector(var8.xCoord * var3, var8.yCoord * var3, var8.zCoord * var3);
         float var12 = var1.getCollisionBorderSize();
         AxisAlignedBB var6;
         AxisAlignedBB var10 = (var6 = var1.getEntityBoundingBox().expand(var12, var12, var12))
            .offset(var1.prevPosX - var1.posX, var1.prevPosY - var1.posY, var1.prevPosZ - var1.posZ);
         return this.isAxisAlignedBB2(var6, var5, var9) || this.isAxisAlignedBB2(var10, var5, var9);
      } else {
         return false;
      }
   }

   public Cls(RotationsBooleanSetting var1) {
      this.int_ = -1;
      this.int_2 = 0;
      this.yawPitchRecord2 = null;
      this.yawPitchRecord = null;
      this.rotationsBooleanSetting = var1;
      this.run177();
      this.run179();
   }

   private void run177() {
      this.double_ = this.random.nextDouble();
      this.double_3 = this.random.nextDouble();
      this.double_2 = this.random.nextDouble();
   }

   public YawPitchRecord getYawPitchRecord24() {
      return this.yawPitchRecord;
   }

   private boolean isAxisAlignedBB2(AxisAlignedBB var1, Vec3 var2, Vec3 var3) {
      return var1.isVecInside(var2) || var1.calculateIntercept(var2, var3) != null;
   }

   private void run179() {
      this.float_3 = this.getFloat96(this.rotationsBooleanSetting.valueSettingSub109, this.rotationsBooleanSetting.valueSettingSub10);
      this.float_ = this.getFloat96(this.rotationsBooleanSetting.valueSettingSub107, this.rotationsBooleanSetting.valueSettingSub105);
   }

   private float getFloat98(float var1) {
      return var1 * (this.random.nextFloat() - this.random.nextFloat());
   }

   public void handleEntity4(Entity var1, double var2) {
      if (MINECRAFT.thePlayer == null) {
         this.run178();
      } else {
         boolean var4 = Util6.isEnabled138();
         boolean var20 = var1.getEntityId() != this.int_;
         boolean var10000;
         if (var20) {
            this.int_ = var1.getEntityId();
            var10000 = var4;
            this.int_2 = 0;
            this.run177();
         } else {
            if (this.rotationsBooleanSetting.valueSettingSub102.getInt10() > 0) {
               int var8 = this.int_2 + 1;
               this.int_2 = var8;
               int var9 = this.rotationsBooleanSetting.valueSettingSub102.getInt10();
               if (var8 >= var9) {
                  this.int_2 = 0;
                  this.run177();
               }
            }

            var10000 = var4;
         }

         if (!var10000) {
            this.float_2 = 0.0F;
            this.float_4 = 0.0F;
         }

         if (!var4 || var20) {
            this.run179();
         }

         YawPitchRecord var27 = Util6.getYawPitchRecord25();
         Vec3 var21 = Util4.getVec323();
         Vec3 var6 = Util4.getVec3ForEntity6(
            var1, this.double_, this.double_3, this.double_2, this.rotationsBooleanSetting.valueSettingSub108.lambda15() / 100.0
         );
         if (var21.squareDistanceTo(var6) > var2 * var2) {
            var6 = Util4.getVec3ForEntity5(var1);
         }

         this.yawPitchRecord2 = Util8.getYawPitchRecordForVec32(var6, var27);
         float var25 = MathHelper.wrapAngleTo180_float(this.yawPitchRecord2.yaw() - var27.yaw());
         float var22 = this.yawPitchRecord2.pitch() - var27.pitch();
         float var26 = var27.yaw() + this.getFloat95(var25, this.getFloat94(this.float_3), true);
         float var23 = var27.pitch() + this.getFloat95(var22, this.getFloat94(this.float_), false);
         if (this.rotationsBooleanSetting.valueSettingSub1010.lambda15() > 0.0) {
            float var12 = this.rotationsBooleanSetting.valueSettingSub1010.getFloat5();
            float var13 = this.getFloat98(var12);
            var26 += var13;
         }

         if (this.rotationsBooleanSetting.valueSettingSub106.lambda15() > 0.0) {
            float var17 = this.rotationsBooleanSetting.valueSettingSub106.getFloat5();
            float var18 = this.getFloat98(var17);
            var23 += var18;
         }

         float var24 = MathHelper.clamp_float(var23, -90.0F, 90.0F);
         if (this.rotationsBooleanSetting.valueSettingSub92.isEnabled17()) {
            float var28 = Util8.getFloat104();
            var26 = Util8.getFloatForFloat26(var27.yaw(), var26, var28);
            var24 = Util8.getFloatForFloat25(var27.pitch(), var24, var28, -90.0F, 90.0F);
         }

         this.yawPitchRecord = new YawPitchRecord(var26, var24);
         Util6.handleYawPitchRecord3(this.yawPitchRecord, this.rotationsBooleanSetting.valueSettingSub11.lambda15());
      }
   }

   private float getFloat95(float var1, float var2, boolean var3) {
      switch ((RotationsBooleanSetting.InstantLinearEnum)this.rotationsBooleanSetting.valueSettingSub112.lambda15()) {
         case INSTANT:

            return var1;
         case LINEAR:
            return MathHelper.clamp_float(var1, -var2, var2);
         case SMOOTH:
            float var10 = 1.0F - this.rotationsBooleanSetting.valueSettingSub103.getFloat5() / 100.0F;
            float var11 = MathHelper.clamp_float(var1 * var10, -var2, var2);
            float var12 = this.rotationsBooleanSetting.valueSettingSub92.isEnabled17() ? Util8.getFloat104() : 0.01F;
            return Math.copySign(Math.min(Math.abs(var1), Math.max(Math.abs(var11), var12)), var1);
         default:
            float var4 = var3 ? this.float_2 : this.float_4;
            float var5 = this.rotationsBooleanSetting.valueSettingSub104.getFloat5();
            float var6 = var2 * this.rotationsBooleanSetting.valueSettingSub1011.getFloat5() / 100.0F;
            var4 = MathHelper.clamp_float(var4 + var5, var6, var2);
            var2 = (float)Math.sqrt(2.0 * var5 * Math.abs(var1));
            var2 = Math.min(Math.min(var4, var2), Math.abs(var1));
            float var10000;
            if (var3) {
               this.float_2 = var2;
               var10000 = var2;
            } else {
               this.float_4 = var2;
               var10000 = var2;
            }

            return Math.copySign(var10000, var1);
      }
   }

   public void run178() {
      this.int_ = -1;
      this.int_2 = 0;
      this.float_2 = 0.0F;
      this.float_4 = 0.0F;
      this.yawPitchRecord2 = null;
      this.yawPitchRecord = null;
      Util6.run183();
   }

   private float getFloat96(ValueSettingSub10 var1, ValueSettingSub10 var2) {
      if (!this.rotationsBooleanSetting.valueSettingSub93.isEnabled17()) {
         return var1.getFloat5();
      } else {
         float var7;
         float var8 = Math.max(var7 = var1.getFloat5(), var2.getFloat5());
         float var3 = this.random.nextFloat();
         float var4 = var8 - var7;
         float var5 = var3 * var4;
         return var7 + var5;
      }
   }

   public float getFloat97(YawPitchRecord var1) {
      return var1 != null && this.yawPitchRecord2 != null
         ? Math.max(Math.abs(MathHelper.wrapAngleTo180_float(this.yawPitchRecord2.yaw() - var1.yaw())), Math.abs(this.yawPitchRecord2.pitch() - var1.pitch()))
         : 180.0F;
   }

   private float getFloat94(float var1) {
      return !this.rotationsBooleanSetting.valueSettingSub93.isEnabled17() ? var1 : var1 * (1.0F + this.getFloat98(0.1F));
   }

   public YawPitchRecord getYawPitchRecord23() {
      return this.yawPitchRecord2;
   }
}
