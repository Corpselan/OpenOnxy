package client.onyx.rotation.util;

import client.onyx.MinecraftAccess;
import client.onyx.rotation.data.DeltaYawDeltaPitchRecord;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.util.Util2;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public final class Util implements MinecraftAccess {
   private static final double DOUBLE = 0.15;

   public static double getDouble16() {
      return (float)(getDouble15() * 0.15);
   }

   public static YawPitchRecord getYawPitchRecordForYawPitchRecord(YawPitchRecord var0, double var1, double var3) {
      DeltaYawDeltaPitchRecord var5 = getDeltaYawDeltaPitchRecordForDouble(var1, var3);
      return new YawPitchRecord(var0.yaw2() + var5.deltaYaw(), MathHelper.clamp_float(var0.pitch2() + var5.deltaPitch(), -90.0F, 90.0F));
   }

   public static float getFloatForFloat10(float var0, float var1, float var2) {
      if (var0 < var1) {
         return var1;
      } else {
         return var0 > var2 ? var2 : var0;
      }
   }

   public static void handleEntityPlayerSP(EntityPlayerSP var0, YawPitchRecord var1) {
      YawPitchRecord var2;
      YawPitchRecord var10001 = var2 = var1.getYawPitchRecord();
      var0.prevRotationPitch = var0.rotationPitch;
      var0.prevRotationYaw = var0.rotationYaw;
      var0.renderYawOffset = var0.rotationYaw;
      var0.prevRenderYawOffset = var0.rotationYaw;
      var0.rotationYaw = var2.yaw2();
      var0.rotationPitch = var10001.pitch2();
   }

   public static float getFloatForEntity(Entity var0) {
      if (MINECRAFT.thePlayer == null) {
         return 0.0F;
      } else {
         YawPitchRecord var2 = YawPitchRecord.getYawPitchRecordForVec32(var0.getEntityBoundingBox().getCenter(), MINECRAFT.thePlayer.getPositionEyes(1.0F));
         return Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer).getFloat(var2);
      }
   }

   public static float getFloatForFloat9(float var0, float var1) {
      return MathHelper.wrapAngleTo180_float(var0 - var1);
   }

   private static double getDouble15() {
      float var0;
      float var10000 = var0 = (float)MINECRAFT.gameSettings.mouseSensitivity * 0.6F + 0.2F;
      return var10000 * var10000 * var0 * 8.0F;
   }

   public static float getFloatForEntityPlayerSP(EntityPlayerSP var0, YawPitchRecord var1) {
      return var1.yaw2() + getFloatForFloat9(var0.rotationYaw, var1.yaw2());
   }

   public static DeltaYawDeltaPitchRecord getDeltaYawDeltaPitchRecordForDouble(double var0, double var2) {
      return new DeltaYawDeltaPitchRecord((float)(var0 * 0.15), (float)(var2 * 0.15));
   }

   private Util() {
   }
}
