package client.onyx.rotation.data;

import client.onyx.rotation.Cls;
import client.onyx.rotation.util.Util;
import client.onyx.util.Util2;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public record YawPitchRecord(float yaw, float pitch, boolean isNormalized) {
   public static final YawPitchRecord YAW_PITCH_RECORD = new YawPitchRecord(0.0F, 0.0F);

   public float pitch2() {
      return this.pitch;
   }

   public float getFloat(YawPitchRecord var1) {
      return Math.min(this.getDeltaYawDeltaPitchRecord(var1).getFloat(), 180.0F);
   }

   public YawPitchRecord getYawPitchRecord2(float var1, float var2) {
      return new YawPitchRecord(this.yaw + var2, this.pitch + var1);
   }

   public YawPitchRecord(float var1, float var2) {
      this(var1, var2, false);
   }

   public Vec3 getVec3() {
      return Vec3.directionFromRotation(this.pitch, this.yaw);
   }

   public YawPitchRecord getYawPitchRecord() {
      if (this.isNormalized) {
         return this;
      } else {
         double var1 = Util.getDouble16();
         YawPitchRecord var7;
         if ((var7 = Cls.CLS.getYawPitchRecord()) == null) {
            var7 = Util2.getYawPitchRecordForEntity(Minecraft.getMinecraft().thePlayer);
         }

         DeltaYawDeltaPitchRecord var10002 = var7.getDeltaYawDeltaPitchRecord(this);
         double var5 = Math.round(var10002.deltaYaw() / var1) * var1;
         var1 = Math.round(var10002.deltaPitch() / var1) * var1;
         float var9 = var7.yaw2() + (float)var5;
         float var4 = var7.pitch2() + (float)var1;
         return new YawPitchRecord(var9, MathHelper.clamp_float(var4, -90.0F, 90.0F), true);
      }
   }

   public boolean isYawPitchRecord(YawPitchRecord var1) {
      return this.isYawPitchRecord2(var1, 2.0F);
   }

   public static YawPitchRecord getYawPitchRecordForVec3(Vec3 var0) {
      return getYawPitchRecordForDouble(var0.xCoord, var0.yCoord, var0.zCoord);
   }

   public YawPitchRecord getYawPitchRecord3(YawPitchRecord var1, float var2) {
      return new YawPitchRecord(Math.fma(var2, var1.yaw - this.yaw, this.yaw), Math.fma(var2, var1.pitch - this.pitch, this.pitch));
   }

   public DeltaYawDeltaPitchRecord getDeltaYawDeltaPitchRecord(YawPitchRecord var1) {
      return new DeltaYawDeltaPitchRecord(Util.getFloatForFloat9(var1.yaw, this.yaw), Util.getFloatForFloat9(var1.pitch, this.pitch));
   }

   public static YawPitchRecord getYawPitchRecordForDouble(double var0, double var2, double var4) {
      return new YawPitchRecord(
         MathHelper.wrapAngleTo180_float((float)Math.toDegrees(Math.atan2(var4, var0)) - 90.0F),
         MathHelper.wrapAngleTo180_float((float)(-Math.toDegrees(Math.atan2(var2, Math.hypot(var0, var4)))))
      );
   }

   public YawPitchRecord getYawPitchRecord4(YawPitchRecord var1, float var2, float var3) {
      DeltaYawDeltaPitchRecord var5;
      DeltaYawDeltaPitchRecord var10001 = var5 = this.getDeltaYawDeltaPitchRecord(var1);
      float var4 = var10001.getFloat();
      var2 = Math.abs(var10001.deltaYaw() / var4) * var2;
      var3 = Math.abs(var10001.deltaPitch() / var4) * var3;
      return this.getYawPitchRecord2(Util.getFloatForFloat10(var10001.deltaPitch(), -var3, var3), Util.getFloatForFloat10(var5.deltaYaw(), -var2, var2));
   }

   public boolean isYawPitchRecord2(YawPitchRecord var1, float var2) {
      return this.getFloat(var1) <= var2;
   }

   public float yaw2() {
      return this.yaw;
   }

   public static YawPitchRecord getYawPitchRecordForVec32(Vec3 var0, Vec3 var1) {
      return getYawPitchRecordForVec3(var0.subtract(var1));
   }
}
