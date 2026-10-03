package client.onyx.system;

import client.onyx.MinecraftAccess;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Util4 implements MinecraftAccess {
   private static final double DOUBLE = 0.05;

   public static double getDoubleForEntity5(Entity var0) {
      return MINECRAFT.thePlayer == null ? Double.MAX_VALUE : getDoubleForAxisAlignedBB2(var0.getEntityBoundingBox(), getVec323());
   }

   public static Vec3 getVec3ForFloat5(float var0, float var1) {
      float var4 = MathHelper.cos(-var0 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var3 = MathHelper.sin(-var0 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var2 = -MathHelper.cos(-var1 * (float) (Math.PI / 180.0));
      var1 = MathHelper.sin(-var1 * (float) (Math.PI / 180.0));
      return new Vec3(var3 * var2, var1, var4 * var2);
   }

   public static Vec3 getVec323() {
      return new Vec3(MINECRAFT.thePlayer.posX, MINECRAFT.thePlayer.posY + MINECRAFT.thePlayer.getEyeHeight(), MINECRAFT.thePlayer.posZ);
   }

   private static double getDoubleForDouble5(double var0, double var2, double var4) {
      return var2 + var0 * (var4 - var2);
   }

   public static Vec3 getVec3ForVec310(Vec3 var0, AxisAlignedBB var1) {
      return new Vec3(
         MathHelper.clamp_double(var0.xCoord, var1.minX, var1.maxX),
         MathHelper.clamp_double(var0.yCoord, var1.minY, var1.maxY),
         MathHelper.clamp_double(var0.zCoord, var1.minZ, var1.maxZ)
      );
   }

   public static Vec3 getVec3ForEntity6(Entity var0, double var1, double var3, double var5, double var7) {
      Vec3 var9 = getVec323();
      AxisAlignedBB var13;
      double var11 = Math.min((var13 = var0.getEntityBoundingBox()).maxX - var13.minX, Math.min(var13.maxY - var13.minY, var13.maxZ - var13.minZ));
      AxisAlignedBB var14;
      double var16;
      Vec3 var17 = (var14 = var13.expand(-(var16 = Math.min(0.05, var11 * 0.25)), -var16, -var16)).isVecInside(var9)
         ? getVec3ForAxisAlignedBB(var14)
         : getVec3ForVec310(var9, var14);
      if (var7 <= 0.0) {
         return var17;
      } else {
         var9 = new Vec3(
            getDoubleForDouble5(var1, var14.minX, var14.maxX),
            getDoubleForDouble5(var3, var14.minY, var14.maxY),
            getDoubleForDouble5(var5, var14.minZ, var14.maxZ)
         );
         return getVec3ForVec311(var17, var9, var7);
      }
   }

   private static Vec3 getVec3ForVec311(Vec3 var0, Vec3 var1, double var2) {
      return new Vec3(
         getDoubleForDouble5(var2, var0.xCoord, var1.xCoord),
         getDoubleForDouble5(var2, var0.yCoord, var1.yCoord),
         getDoubleForDouble5(var2, var0.zCoord, var1.zCoord)
      );
   }

   public static Vec3 getVec3ForEntity5(Entity var0) {
      return getVec3ForEntity6(var0, 0.0, 0.0, 0.0, 0.0);
   }

   public static Vec3 getVec3ForAxisAlignedBB(AxisAlignedBB var0) {
      return new Vec3((var0.minX + var0.maxX) * 0.5, (var0.minY + var0.maxY) * 0.5, (var0.minZ + var0.maxZ) * 0.5);
   }

   public static double getDoubleForAxisAlignedBB2(AxisAlignedBB var0, Vec3 var1) {
      double var2 = Math.max(Math.max(var0.minX - var1.xCoord, 0.0), var1.xCoord - var0.maxX);
      double var4 = Math.max(Math.max(var0.minY - var1.yCoord, 0.0), var1.yCoord - var0.maxY);
      double var6 = Math.max(Math.max(var0.minZ - var1.zCoord, 0.0), var1.zCoord - var0.maxZ);
      return var2 * var2 + var4 * var4 + var6 * var6;
   }
}
