package client.onyx.util;

import client.onyx.MinecraftAccess;
import client.onyx.rotation.data.YawPitchRecord;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public final class Util11 implements MinecraftAccess {
   public static YawPitchRecord getYawPitchRecord22() {
      YawPitchRecord var0;
      return (var0 = client.onyx.rotation.Cls.CLS.getYawPitchRecord()) != null ? var0 : Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer);
   }

   public static MovingObjectPosition getMovingObjectPositionForYawPitchRecord3(
      YawPitchRecord var0, double var1, OutlineColliderEnum var3, boolean var4, float var5
   ) {
      return getMovingObjectPositionForDouble3(var1, var3, var4, MINECRAFT.thePlayer.getPositionEyes(var5), var0.getVec3(), MINECRAFT.getRenderViewEntity());
   }

   public static MovingObjectPosition getMovingObjectPositionForYawPitchRecord2(YawPitchRecord var0, double var1) {
      return getMovingObjectPositionForYawPitchRecord3(var0, var1, OutlineColliderEnum.OUTLINE, false, 1.0F);
   }

   public static MovingObjectPosition getMovingObjectPositionForDouble3(double var0, OutlineColliderEnum var2, boolean var3, Vec3 var4, Vec3 var5, Entity var6) {
      Vec3 var8 = var4.addVector(var5.xCoord * var0, var5.yCoord * var0, var5.zCoord * var0);
      return MINECRAFT.theWorld.rayTraceBlocks(var4, var8, var3, var2.isEnabled(), false);
   }

   public static MovingObjectPosition getMovingObjectPositionForYawPitchRecord(YawPitchRecord var0) {
      return getMovingObjectPositionForYawPitchRecord3(var0, getDouble32(), OutlineColliderEnum.OUTLINE, false, 1.0F);
   }

   public static MovingObjectPosition getMovingObjectPosition4() {
      return getMovingObjectPositionForYawPitchRecord3(getYawPitchRecord22(), getDouble32(), OutlineColliderEnum.OUTLINE, false, 1.0F);
   }

   private Util11() {
   }

   public static MovingObjectPosition getMovingObjectPositionForDouble2(double var0, OutlineColliderEnum var2, boolean var3, Vec3 var4, Vec3 var5) {
      return getMovingObjectPositionForDouble3(var0, var2, var3, var4, var5, MINECRAFT.getRenderViewEntity());
   }

   public static boolean isVec33(Vec3 var0, Vec3 var1, Entity var2) {
      return var2.worldObj.rayTraceBlocks(var0, var1, false, true, false) == null;
   }

   public static double getDouble32() {
      return MINECRAFT.playerController.getBlockReachDistance();
   }

   public static boolean isVec32(Vec3 var0, Vec3 var1) {
      return isVec33(var0, var1, MINECRAFT.thePlayer);
   }
}
