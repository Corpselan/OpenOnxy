package client.onyx.util;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub2;
import client.onyx.event.impl.EventSub6;
import client.onyx.rotation.data.YawPitchRecord;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Util2 implements MinecraftAccess {
   private static int int_;
   public static final Util2 UTIL2 = new Util2();
   private static int int_2;
   public static final float FLOAT = 0.6F;
   public static final float FLOAT2 = 1.8F;

   public static Vec3 getVec3ForVec34(Vec3 var0, double var1) {
      return getVec3ForVec35(var0, var1, 1.0, getForwardsBackwardsRecordForEntityPlayerSP(MINECRAFT.thePlayer));
   }

   public static ForwardsBackwardsRecord getForwardsBackwardsRecordForEntityPlayerSP(EntityPlayerSP var0) {
      return var0 != null && var0.movementInput != null
         ? new ForwardsBackwardsRecord(var0.movementInput.untransformedForward, var0.movementInput.untransformedStrafe)
         : ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8;
   }

   public static float getFloatForFloat20(float var0, ForwardsBackwardsRecord var1) {
      float var3;
      ForwardsBackwardsRecord var10000;
      if (var1.backwards() && !var1.forwards()) {
         var0 += 180.0F;
         var3 = -0.5F;
         var10000 = var1;
      } else if (var1.forwards() && !var1.backwards()) {
         var3 = 0.5F;
         var10000 = var1;
      } else {
         var3 = 1.0F;
         var10000 = var1;
      }

      if (var10000.left() && !var1.right()) {
         var0 -= 90.0F * var3;
      }

      if (var1.right() && !var1.left()) {
         var0 += 90.0F * var3;
      }

      return var0;
   }

   public static YawPitchRecord getYawPitchRecordForEntity2(Entity var0) {
      float var1 = var0.prevRotationYaw;
      return new YawPitchRecord(var1, var0.prevRotationPitch, true);
   }

   public static float getFloatForEntityPlayerSP4(EntityPlayerSP var0, ForwardsBackwardsRecord var1) {
      return getFloatForFloat20(var0.rotationYaw, var1);
   }

   public static AxisAlignedBB getAxisAlignedBBForVec3(Vec3 var0) {
      double var1 = 0.3F;
      return new AxisAlignedBB(var0.xCoord - var1, var0.yCoord, var0.zCoord - var1, var0.xCoord + var1, var0.yCoord + 1.8F, var0.zCoord + var1);
   }

   public static double getDoubleForEntity4(Entity var0, Entity var1) {
      return Math.sqrt(getDoubleForEntity2(var0, var1));
   }

   public static boolean isEntityPlayerSP5(EntityPlayerSP var0) {
      return isEntityPlayerSP4(var0, getForwardsBackwardsRecordForEntityPlayerSP(var0), 0.1, getVec3ForEntity2(var0));
   }

   public static double getDoubleForAxisAlignedBB(AxisAlignedBB var0, Vec3 var1) {
      double var2 = Math.max(Math.max(var0.minX - var1.xCoord, var1.xCoord - var0.maxX), 0.0);
      double var4 = Math.max(Math.max(var0.minY - var1.yCoord, var1.yCoord - var0.maxY), 0.0);
      double var6 = Math.max(Math.max(var0.minZ - var1.zCoord, var1.zCoord - var0.maxZ), 0.0);
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public static boolean isEntityPlayer4(EntityPlayer var0, Vec3 var1) {
      AxisAlignedBB var2 = getAxisAlignedBBForVec3(var1).expand(-0.05, 0.0, -0.05).offset(0.0, var0.fallDistance - var0.stepHeight, 0.0);
      return MINECRAFT.theWorld.getCollidingBoundingBoxes(var0, var2).isEmpty();
   }

   public static Vec3 getVec3ForVec33(Vec3 var0) {
      return getVec3ForVec35(
         var0, Math.sqrt(var0.xCoord * var0.xCoord + var0.zCoord * var0.zCoord), 1.0, getForwardsBackwardsRecordForEntityPlayerSP(MINECRAFT.thePlayer)
      );
   }

   public static int getIntForEntityPlayerSP2(EntityPlayerSP var0) {
      return int_2;
   }

   public static boolean isEntityPlayerSP(EntityPlayerSP var0) {
      return getFloatForEntityPlayerSP5(var0) != 0.0F || getFloatForEntityPlayerSP2(var0) != 0.0F;
   }

   public static Vec3 getVec3ForVec36(Vec3 var0, double var1, double var3, ForwardsBackwardsRecord var5, float var6) {
      if (var5 != null && !var5.isEnabled()) {
         return new Vec3(0.0, var0.yCoord, 0.0);
      } else {
         double var7 = 1.0 - var3;
         double var9 = var0.xCoord * var7;
         var7 = var0.zCoord * var7;
         var1 *= var3;
         var3 = Math.toRadians(var6);
         var9 -= Math.sin(var3) * var1;
         var1 = var7 + Math.cos(var3) * var1;
         return new Vec3(var9, var0.yCoord, var1);
      }
   }

   public static double getDoubleForEntity2(Entity var0, Entity var1) {
      return getDoubleForEntity3(var0, var1.getPositionEyes(1.0F));
   }

   public static Vec3 getVec3ForEntity2(Entity var0) {
      return new Vec3(var0.posX, var0.posY, var0.posZ);
   }

   public static Vec3 getVec3ForVec37(Vec3 var0, float var1, float var2) {
      double var3;
      if ((var3 = var0.lengthSqr()) < 1.0E-7) {
         return Vec3.ZERO;
      } else {
         double var9;
         int var10001 = (var9 = var3 - 1.0) == 0.0 ? 0 : (var9 < 0.0 ? -1 : 1);
         Vec3 var10000 = var0;
         float var8;
         if (var10001 > 0) {
            var10000 = var0.normalize();
            var8 = var1;
         } else {
            var8 = var1;
         }

         Vec3 var5 = var10000.scale(var8);
         float var7 = MathHelper.sin(var2 * (float) Math.PI / 180.0F);
         var2 = MathHelper.cos(var2 * (float) Math.PI / 180.0F);
         return new Vec3(var5.xCoord * var2 - var5.zCoord * var7, var5.yCoord, var5.zCoord * var2 + var5.xCoord * var7);
      }
   }

   public static float getFloatForEntityPlayerSP2(EntityPlayerSP var0) {
      return var0.movementInput == null ? 0.0F : var0.movementInput.moveStrafe;
   }

   public static float getFloatForEntityPlayerSP5(EntityPlayerSP var0) {
      return var0.movementInput == null ? 0.0F : var0.movementInput.moveForward;
   }

   public static Vec3 getVec3ForEntity4(Entity var0) {
      return new Vec3(var0.prevPosX, var0.prevPosY, var0.prevPosZ);
   }

   public static Vec3 getVec3ForEntity3(Entity var0) {
      return new Vec3(var0.motionX, var0.motionY, var0.motionZ);
   }

   public static double getDoubleForEntity3(Entity var0, Vec3 var1) {
      return getDoubleForAxisAlignedBB(getAxisAlignedBBForEntity(var0), var1);
   }

   public static boolean isEntityPlayerSP3(EntityPlayerSP var0, ForwardsBackwardsRecord var1, double var2) {
      return isEntityPlayerSP4(var0, var1, var2, getVec3ForEntity2(var0));
   }

   @EventHandler
   private void handleEventSub211(EventSub2 var1) {
      if (MINECRAFT.thePlayer == null) {
         int_ = 0;
         int_2 = 0;
      } else if (MINECRAFT.thePlayer.onGround) {
         int_ = 0;
         int_2++;
      } else {
         int_2 = 0;
         int_++;
      }
   }

   public static void handleEntity3(Entity var0, Vec3 var1) {
      var0.motionX = var1.xCoord;
      var0.motionY = var1.yCoord;
      var0.motionZ = var1.zCoord;
   }

   public static int getIntForEntityPlayerSP(EntityPlayerSP var0) {
      return int_;
   }

   public static boolean isEntityPlayerSP4(EntityPlayerSP var0, ForwardsBackwardsRecord var1, double var2, Vec3 var4) {
      client.onyx.simulation.Cls2 var9;
      client.onyx.simulation.Cls2 var10000 = var9 = client.onyx.simulation.Cls2.getCls2ForForwardsBackwardsRecord(var1);
      var10000.forwardBackwardRecord = Util7.getForwardBackwardRecordForForwardBackwardRecord(
         var10000.forwardBackwardRecord,
         var9.forwardBackwardRecord.forward(),
         var9.forwardBackwardRecord.backward(),
         var9.forwardBackwardRecord.left(),
         var9.forwardBackwardRecord.right(),
         false,
         false,
         var9.forwardBackwardRecord.sprint()
      );
      client.onyx.simulation.Cls3 var10;
      client.onyx.simulation.Cls3 var12 = var10 = client.onyx.simulation.Cls3.getCls3ForCls2(var9);
      var12.handleVec34(var4);
      var12.run17();
      Vec3 var6;
      Vec3 var7;
      Vec3 var13;
      if ((var6 = var12.getVec38()).horizontalDistanceSqr() > 9.0E-6) {
         var7 = Util6.getVec3ForVec38(var6, 0.0).normalize();
         var13 = var4;
      } else {
         float var8 = getFloatForEntityPlayerSP4(var0, var1);
         var7 = Vec3.directionFromRotation(0.0F, var8);
         var13 = var4;
      }

      Vec3 var14 = var13.add(0.0, -0.1, 0.0);
      if (Util3.getVec3ForVec38(var14, Util6.getVec3ForVec35(var14, var2, var7)) != null) {
         return true;
      } else {
         Vec3 var11 = var10.getVec311().add(Util6.getVec3ForVec38(var6, 0.0));
         return isEntityPlayer4(var0, var4) || isEntityPlayer4(var0, var11);
      }
   }

   @EventHandler
   private void handleEventSub619(EventSub6 var1) {
      int_ = 0;
      int_2 = 0;
   }

   public static YawPitchRecord getYawPitchRecordForEntity(Entity var0) {
      float var1 = var0.rotationYaw;
      return new YawPitchRecord(var1, var0.rotationPitch, true);
   }

   public static boolean isEntityPlayerSP2(EntityPlayerSP var0, double var1) {
      return isEntityPlayerSP4(var0, getForwardsBackwardsRecordForEntityPlayerSP(var0), var1, getVec3ForEntity2(var0));
   }

   public static AxisAlignedBB getAxisAlignedBBForEntity(Entity var0) {
      float var2 = var0.getCollisionBorderSize();
      return var0.getEntityBoundingBox().expand(var2, var2, var2);
   }

   public static float getFloatForEntityPlayerSP3(EntityPlayerSP var0) {
      return getFloatForFloat20(var0.rotationYaw, getForwardsBackwardsRecordForEntityPlayerSP(var0));
   }

   public static Vec3 getVec3ForVec35(Vec3 var0, double var1, double var3, ForwardsBackwardsRecord var5) {
      ForwardsBackwardsRecord var7 = var5 == null ? getForwardsBackwardsRecordForEntityPlayerSP(MINECRAFT.thePlayer) : var5;
      return getVec3ForVec36(var0, var1, var3, var7, getFloatForEntityPlayerSP4(MINECRAFT.thePlayer, var7));
   }

   public static double getDoubleForEntity(Entity var0) {
      return Math.sqrt(var0.motionX * var0.motionX + var0.motionZ * var0.motionZ);
   }
}
