package client.onyx.util;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.util.EnumFacing.AxisDirection;

public class Util12 {
   public static double getDoubleForAxisAlignedBB(AxisAlignedBB var0, double var1, double var3, double var5) {
      var1 = Math.max(Math.max(var0.minX - var1, var1 - var0.maxX), 0.0);
      var3 = Math.max(Math.max(var0.minY - var3, var3 - var0.maxY), 0.0);
      var5 = Math.max(Math.max(var0.minZ - var5, var5 - var0.maxZ), 0.0);
      return var1 * var1 + var3 * var3 + var5 * var5;
   }

   public static double getDoubleForAxisAlignedBB2(AxisAlignedBB var0, EnumFacing var1) {
      return var1.getAxisDirection() == AxisDirection.POSITIVE ? var0.max(var1.getAxis()) : var0.min(var1.getAxis());
   }

   public static Vec3 getVec3ForAxisAlignedBB2(AxisAlignedBB var0, EnumFacing var1) {
      double var2 = var0.minX + var0.getXsize() * 0.5;
      double var4 = var0.minY + var0.getYsize() * 0.5;
      double var6 = var0.minZ + var0.getZsize() * 0.5;
      return getVec3ForAxisAlignedBB(var0, var2, var4, var6, var1);
   }

   public static Vec3 getVec3ForAxisAlignedBB3(AxisAlignedBB var0, Vec3 var1) {
      return new Vec3(
         MathHelper.clamp_double(var1.xCoord, var0.minX, var0.maxX),
         MathHelper.clamp_double(var1.yCoord, var0.minY, var0.maxY),
         MathHelper.clamp_double(var1.zCoord, var0.minZ, var0.maxZ)
      );
   }

   public static Vec3 getVec3ForAxisAlignedBB4(AxisAlignedBB var0, Vec3 var1, EnumFacing var2) {
      Vec3 var3;
      return getVec3ForAxisAlignedBB(var0, (var3 = getVec3ForAxisAlignedBB3(var0, var1)).xCoord, var3.yCoord, var3.zCoord, var2);
   }

   private static Vec3 getVec3ForAxisAlignedBB(AxisAlignedBB var0, double var1, double var3, double var5, EnumFacing var7) {
      switch (var7) {
         case DOWN:
            return new Vec3(var1, var0.minY, var5);
         case UP:
            return new Vec3(var1, var0.maxY, var5);
         case NORTH:
            return new Vec3(var1, var3, var0.minZ);
         case SOUTH:
            return new Vec3(var1, var3, var0.maxZ);
         case WEST:
            return new Vec3(var0.minX, var3, var5);
         case EAST:
            return new Vec3(var0.maxX, var3, var5);
         default:
            throw new MatchException(null, null);
      }
   }

   public static client.onyx.util.math.Cls2 getCls2ForAxisAlignedBB(AxisAlignedBB var0, EnumFacing var1) {
      switch (var1) {
         case DOWN:
            return new client.onyx.util.math.Cls2(new Vec3(var0.minX, var0.minY, var0.minZ), new Vec3(var0.maxX, var0.minY, var0.maxZ));
         case UP:
            return new client.onyx.util.math.Cls2(new Vec3(var0.minX, var0.maxY, var0.minZ), new Vec3(var0.maxX, var0.maxY, var0.maxZ));
         case NORTH:
            return new client.onyx.util.math.Cls2(new Vec3(var0.minX, var0.minY, var0.minZ), new Vec3(var0.maxX, var0.maxY, var0.minZ));
         case SOUTH:
            return new client.onyx.util.math.Cls2(new Vec3(var0.minX, var0.minY, var0.maxZ), new Vec3(var0.maxX, var0.maxY, var0.maxZ));
         case WEST:
            return new client.onyx.util.math.Cls2(new Vec3(var0.minX, var0.minY, var0.minZ), new Vec3(var0.minX, var0.maxY, var0.maxZ));
         case EAST:
            return new client.onyx.util.math.Cls2(new Vec3(var0.maxX, var0.minY, var0.minZ), new Vec3(var0.maxX, var0.maxY, var0.maxZ));
         default:
            throw new MatchException(null, null);
      }
   }

   public static double getDoubleForAxisAlignedBB3(AxisAlignedBB var0, Vec3 var1) {
      return getDoubleForAxisAlignedBB(var0, var1.xCoord, var1.yCoord, var1.zCoord);
   }

   public static Vec3[] getVec3ArrayForAxisAlignedBB(AxisAlignedBB var0) {
      Vec3[] var10000 = new Vec3[8];
      boolean var10002 = true;
      boolean var10005 = false;
      var10000[0] = new Vec3(var0.minX, var0.minY, var0.minZ);
      var10000[1] = new Vec3(var0.minX, var0.minY, var0.maxZ);
      var10000[2] = new Vec3(var0.minX, var0.maxY, var0.minZ);
      var10000[3] = new Vec3(var0.minX, var0.maxY, var0.maxZ);
      var10000[4] = new Vec3(var0.maxX, var0.minY, var0.minZ);
      var10000[5] = new Vec3(var0.maxX, var0.minY, var0.maxZ);
      var10000[6] = new Vec3(var0.maxX, var0.maxY, var0.minZ);
      var10000[7] = new Vec3(var0.maxX, var0.maxY, var0.maxZ);
      return var10000;
   }
}
