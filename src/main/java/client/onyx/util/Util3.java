package client.onyx.util;

import client.onyx.MinecraftAccess;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class Util3 implements MinecraftAccess {
   public static Vec3 getVec3ForVec39(Vec3 var0, Vec3 var1, float var2) {
      Vec3 var7;
      if ((var7 = var1.subtract(var0)).lengthSqr() <= 1.0E-12) {
         return null;
      } else {
         List var16 = getListForVec3(var0, var1, var2);
         Vec3 var4 = var0;
         Vec3 var5 = var0.add(var7.scale(-1000.0));
         var7 = var1.add(var7.scale(1000.0));
         HashSet var6;
         HashSet var10000 = var6 = new HashSet();

         while (true) {
            var10000.clear();
            Iterator var15 = var16.iterator();

            while (var15.hasNext()) {
               AxisAlignedBB var8;
               if ((var8 = (AxisAlignedBB)var15.next()).isVecInside(var4)) {
                  var6.add(var8);
               }
            }

            if (var6.isEmpty()) {
               return var4;
            }

            var15 = var6.iterator();

            while (var15.hasNext()) {
               if (((AxisAlignedBB)var15.next()).isVecInside(var1)) {
                  return null;
               }
            }

            Vec3 var21 = null;
            double var18 = Double.POSITIVE_INFINITY;
            Iterator var10 = var6.iterator();

            while (var10.hasNext()) {
               AxisAlignedBB var11;
               MovingObjectPosition var12;
               if ((var12 = (var11 = (AxisAlignedBB)var10.next()).calculateIntercept(var7, var5)) == null) {
                  throw new IllegalArgumentException(
                     new StringBuilder()
                        .insert(0, "Raycast failed. This should be impossible. AABB=")
                        .append(var11)
                        .append(" from=")
                        .append(var0)
                        .append(" to=")
                        .append(var1)
                        .toString()
                  );
               }

               Vec3 var19 = var12.hitVec;
               double var13;
               if ((var13 = var12.hitVec.distanceToSqr(var1)) < var18) {
                  var18 = var13;
                  var21 = var19;
               }
            }

            if (var21 == null) {
               throw new IllegalStateException("Unable to resolve an edge collision");
            }

            var4 = var21;
            var10000 = var6;
            var16.removeAll(var6);
         }
      }
   }

   public static void run175() {
      MINECRAFT.thePlayer.motionX = 0.0;
      MINECRAFT.thePlayer.motionZ = 0.0;
   }

   private static List<AxisAlignedBB> getListForVec3(Vec3 var0, Vec3 var1, float var2) {
      AxisAlignedBB var9 = Util2.getAxisAlignedBBForVec3(var0);
      AxisAlignedBB var4 = Util2.getAxisAlignedBBForVec3(var1);
      var9 = var9.union(var4);
      BlockPos var11 = Util6.getBlockPosForVec3(new Vec3(var9.minX - 0.3 - 1.0E-7, var9.minY - var2 - 1.0E-7, var9.minZ - 0.3 - 1.0E-7));
      BlockPos var17 = Util6.getBlockPosForVec3(new Vec3(var9.maxX + 0.3 + 1.0E-7, var9.minY + 1.0E-7, var9.maxZ + 0.3 + 1.0E-7));
      Vec3 var5;
      Vec3 var6 = var0.add((var5 = var1.subtract(var0)).scale(-1000.0));
      var1 = var1.add(var5.scale(1000.0));
      ArrayList var14 = new ArrayList();
      ArrayList var7 = new ArrayList();

      for (BlockPos var12 : BlockPos.getAllInBox(var11, var17)) {
         IBlockState var10001 = MINECRAFT.theWorld.getBlockState(var12);
         var7.clear();
         handleIBlockState(var10001, var12, var7);
         Iterator var13;
         Iterator var10000 = var13 = var7.iterator();

         while (var10000.hasNext()) {
            AxisAlignedBB var8 = (AxisAlignedBB)var13.next();
            if ((var8 = new AxisAlignedBB(var8.minX - 0.3, var8.minY - 1.0, var8.minZ - 0.3, var8.maxX + 0.3, var8.maxY + var2 + 0.05, var8.maxZ + 0.3))
                  .calculateIntercept(var6, var1)
               == null) {
               var10000 = var13;
            } else {
               var14.add(var8);
               var10000 = var13;
            }
         }
      }

      return var14;
   }

   public static ForwardsBackwardsRecord getForwardsBackwardsRecordForForwardsBackwardsRecord2(ForwardsBackwardsRecord var0, float var1, float var2) {
      boolean var3 = var0.forwards();
      boolean var4 = var0.backwards();
      boolean var5 = var0.left();
      boolean var6 = var0.right();
      float var10000;
      if (var1 > -90.0F + var2 && var1 < 90.0F - var2) {
         var3 = true;
         var10000 = var1;
      } else {
         if (var1 < -90.0F - var2 || var1 > 90.0F + var2) {
            var4 = true;
         }

         var10000 = var1;
      }

      if (var10000 > var2 && var1 < 180.0F - var2) {
         var6 = true;
      } else if (var1 > -180.0F + var2 && var1 < -var2) {
         var5 = true;
      }

      return new ForwardsBackwardsRecord(var3, var4, var5, var6);
   }

   public static void handleIBlockState(IBlockState var0, BlockPos var1, List<AxisAlignedBB> var2) {
      if (var0.getBlock().getMaterial() != Material.air) {
         AxisAlignedBB var3 = new AxisAlignedBB(
            var1.getX() - 1.0, var1.getY() - 1.0, var1.getZ() - 1.0, var1.getX() + 2.0, var1.getY() + 2.0, var1.getZ() + 2.0
         );
         var0.getBlock().addCollisionBoxesToList(MINECRAFT.theWorld, var1, var0, var3, var2, null);
      }
   }

   public static Vec3 getVec3ForVec38(Vec3 var0, Vec3 var1) {
      return getVec3ForVec39(var0, var1, 0.5F);
   }

   public static float getFloatForVec3(Vec3 var0, float var1) {
      double var2 = Util6.getDoubleForVec3(var0);
      var1 = MathHelper.wrapAngleTo180_float(var1);
      return MathHelper.wrapAngleTo180_float((float)var2 - var1);
   }

   public static ForwardsBackwardsRecord getForwardsBackwardsRecordForForwardsBackwardsRecord(ForwardsBackwardsRecord var0, float var1) {
      return getForwardsBackwardsRecordForForwardsBackwardsRecord2(var0, var1, 20.0F);
   }
}
