package client.onyx.util;

import java.util.Iterator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;

public class Util6 {
   public static double getDoubleForVec33(Vec3 var0, double var1, double var3, double var5) {
      return var0.xCoord * var1 + var0.yCoord * var3 + var0.zCoord * var5;
   }

   public static double getDoubleForVec37(Vec3 var0, Vec3 var1) {
      return getDoubleForVec36(var0, var1.xCoord, var1.zCoord);
   }

   public static Vec3 getVec3ForVec37(Vec3 var0, double var1, double var3, double var5) {
      return var0.multiply(var1, var3, var5);
   }

   public static Vec3 getVec3ForVec38(Vec3 var0, double var1) {
      return new Vec3(var0.xCoord, var1, var0.zCoord);
   }

   public static boolean isVec32(Vec3 var0, double var1) {
      return Math.abs(var0.lengthSqr() - 1.0) < var1;
   }

   public static Vec3 getVec3ForVec3i(Vec3i var0) {
      return Vec3.upFromBottomCenterOf(var0, 1.0);
   }

   public static BlockPos getBlockPosForVec32(Vec3 var0, double var1, double var3, double var5) {
      return new BlockPos(Math.floor(var0.xCoord + var1), Math.floor(var0.yCoord + var3), Math.floor(var0.zCoord + var5));
   }

   public static double getDoubleForVec36(Vec3 var0, double var1, double var3) {
      return Math.sqrt(getDoubleForVec32(var0, var1, var3));
   }

   private static boolean isDouble(double var0) {
      return Math.abs(var0) < 1.0E-5;
   }

   public static double getDoubleForVec3(Vec3 var0) {
      return Math.atan2(-var0.xCoord, var0.zCoord) * (180.0 / Math.PI);
   }

   public static Vec3 getVec3ForIterable(Iterable<Vec3> var0) {
      double var1 = 0.0;
      double var3 = 0.0;
      double var5 = 0.0;
      int var7 = 0;

      Iterator var8;
      for (Iterator var10000 = var8 = var0.iterator(); var10000.hasNext(); var10000 = var8) {
         Vec3 var10 = (Vec3)var8.next();
         var1 += var10.xCoord;
         var3 += var10.yCoord;
         var7++;
         var5 += var10.zCoord;
      }

      return new Vec3(var1 / var7, var3 / var7, var5 / var7);
   }

   public static Vec3 getVec3ForVec3(Vec3 var0, double var1) {
      double var3;
      return isDouble(var3 = var0.lengthSqr()) ? Vec3.ZERO : var0.scale(var1 / Math.sqrt(var3));
   }

   public static Vec3 getVec3ForVec35(Vec3 var0, double var1, Vec3 var3) {
      return new Vec3(Math.fma(var1, var3.xCoord, var0.xCoord), Math.fma(var1, var3.yCoord, var0.yCoord), Math.fma(var1, var3.zCoord, var0.zCoord));
   }

   public static double getDoubleForVec34(Vec3 var0, Vec3 var1) {
      return getDoubleForVec32(var0, var1.xCoord, var1.zCoord);
   }

   public static Vec3 getVec3ForVec3i4(Vec3i var0) {
      return Vec3.atBottomCenterOf(var0);
   }

   public static Vec3 getVec3ForVec3i2(Vec3i var0) {
      return Vec3.atCenterOf(var0);
   }

   public static long getLongForVec3i(Vec3i var0) {
      long var1 = var0.getX();
      long var3 = var0.getY();
      long var5 = var0.getZ();
      return var1 * var1 + var3 * var3 + var5 * var5;
   }

   public static BlockPos getBlockPosForVec3(Vec3 var0) {
      return new BlockPos(Math.floor(var0.xCoord), Math.floor(var0.yCoord), Math.floor(var0.zCoord));
   }

   public static Vec3 getVec3ForVec36(Vec3 var0, double var1) {
      return new Vec3(var0.xCoord, var0.yCoord, var1);
   }

   public static Vec3 getVec3ForVec33(Vec3 var0, double var1) {
      return new Vec3(var1, var0.yCoord, var0.zCoord);
   }

   public static boolean isVec33(Vec3 var0) {
      return isDouble(var0.lengthSqr());
   }

   public static Vec3 getVec3ForVec3i3(Vec3i var0, double var1) {
      return Vec3.upFromBottomCenterOf(var0, var1);
   }

   public static AxisAlignedBB getAxisAlignedBBForVec3(Vec3 var0, double var1) {
      return new AxisAlignedBB(var0.xCoord - var1, var0.yCoord - var1, var0.zCoord - var1, var0.xCoord + var1, var0.yCoord + var1, var0.zCoord + var1);
   }

   public static Vec3 getVec3ForVec34(Vec3 var0, double var1, double var3, double var5) {
      return new Vec3(var1, var3, var5);
   }

   public static double getDoubleForVec32(Vec3 var0, double var1, double var3) {
      var1 = var0.xCoord - var1;
      var3 = var0.zCoord - var3;
      return var1 * var1 + var3 * var3;
   }

   public static boolean isVec3(Vec3 var0) {
      return isVec32(var0, 1.0E-4);
   }

   public static double getDoubleForVec35(Vec3 var0, Vec3i var1) {
      return getDoubleForVec32(var0, var1.getX(), var1.getZ());
   }

   public static Vec3 getVec3ForVec32(Vec3 var0) {
      return isVec3(var0) ? var0 : var0.normalize();
   }
}
