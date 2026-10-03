package client.onyx.interact.placement;

import client.onyx.MinecraftAccess;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.util.Util12;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;

public final class Util implements MinecraftAccess {
   private static final Comparator<Util.FaceSideRecord> COMPARATOR = Comparator.<Util.FaceSideRecord>comparingDouble(
         var0 -> var0.point.subtract(0.5, 0.5, 0.5).multiply(new Vec3(var0.side.getDirectionVec())).lengthSqr()
      )
      .thenComparingDouble(var0 -> var0.point.yCoord);

   private static boolean isIBlockState3(IBlockState var0, BlockPos var1) {
      AxisAlignedBB var2;
      return isIBlockState2(var0)
         ? false
         : (var2 = client.onyx.interact.Util.getAxisAlignedBBForIBlockState(var0, var1)).maxY >= 1.0
            && var2.minX <= 0.5
            && var2.maxX >= 0.5
            && var2.minZ <= 0.5
            && var2.maxZ >= 0.5;
   }

   private static Util.FaceSideRecord getFaceSideRecordForIBlockState(IBlockState var0, BlockPos var1, Util.Cls5 var2, Cls var3) {
      List var4 = List.of(client.onyx.interact.Util.getAxisAlignedBBForIBlockState(var0, var1));
      Util.FaceSideRecord var5 = null;
      Iterator var10 = var4.iterator();

      label34:
      while (true) {
         for (Iterator var10000 = var10; var10000.hasNext(); var10000 = var10) {
            client.onyx.util.math.Cls2 var9;
            client.onyx.util.math.Cls2 var7 = var9 = Util12.getCls2ForAxisAlignedBB((AxisAlignedBB)var10.next(), var2.enumFacing);
            if (var7.getVec36().yCoord >= 0.9) {
               client.onyx.util.math.Cls2 var8;
               var7 = (var8 = var7.getCls22(0.6).getCls2()) != null ? var8 : var9;
            }

            Vec3 var11;
            if ((var11 = var3.getCls3().getHitVecStrategy().getVec34(var7, var1)) != null) {
               Util.FaceSideRecord var12 = new Util.FaceSideRecord(var9, var2.enumFacing, var11);
               if (var5 == null || COMPARATOR.compare(var12, var5) > 0) {
                  var5 = var12;
               }
               continue label34;
            }
         }

         return var5;
      }
   }

   private static boolean isIBlockState2(IBlockState var0) {
      Material var2;
      return (var2 = var0.getBlock().getMaterial()) == Material.air || var2.isLiquid();
   }

   private static Util.Cls5 getCls5ForBlockPos(BlockPos var0, Util.PlaceAtNeighborReplaceExistingBlockEnum var1, Cls var2) {
      Vec3 var7 = var2.getCls4().getVec3();
      ArrayList var4 = new ArrayList(6);
      EnumFacing[] var5;
      int var6 = (var5 = EnumFacing.values()).length;

      int var10;
      for (int var10000 = var10 = 0; var10000 < var6; var10000 = ++var10) {
         EnumFacing var8 = var5[var10];
         Util.Cls5 var9;
         if ((var9 = getCls5ForBlockPos2(var0, var8, var1)) != null && (var2.getCls3().isEnabled() || !(var9.getDouble(var7) < 0.0))) {
            var4.add(var9);
         }
      }

      YawPitchRecord var13 = client.onyx.rotation.Cls.CLS.getYawPitchRecord5();
      Util.Cls5 var14 = null;
      float var17 = Float.POSITIVE_INFINITY;
      Iterator var15 = var4.iterator();

      while (var15.hasNext()) {
         Util.Cls5 var16;
         YawPitchRecord var11 = YawPitchRecord.getYawPitchRecordForVec32((var16 = (Util.Cls5)var15.next()).vec3, var7);
         float var12;
         if ((var12 = var13.getFloat(var11)) < var17) {
            var17 = var12;
            var14 = var16;
         }
      }

      return var14;
   }

   public static InteractedBlockPosPlacedBlockRecord getInteractedBlockPosPlacedBlockRecordForBlockPos(BlockPos var0, Cls var1) {
      if (isIBlockState3(client.onyx.interact.Util.getIBlockStateForBlockPos2(var0), var0)) {
         return null;
      } else {
         ArrayList<Vec3i> var5 = new ArrayList<>(var1.getCls2().getList());
         Comparator var3 = var1.getCls2().getComparator();
         var5.sort((var2, var3x) -> var3.compare(var0.add(var3x), var0.add(var2)));
         Iterator var12;
         Iterator var10000 = var12 = var5.iterator();

         while (var10000.hasNext()) {
            Vec3i var8 = (Vec3i)var12.next();
            IBlockState var4;
            BlockPos var9;
            if (isIBlockState3(var4 = client.onyx.interact.Util.getIBlockStateForBlockPos2(var9 = var0.add(var8)), var9)) {
               var10000 = var12;
            } else {
               Util.PlaceAtNeighborReplaceExistingBlockEnum var6 = isIBlockState2(var4)
                  ? Util.PlaceAtNeighborReplaceExistingBlockEnum.PLACE_AT_NEIGHBOR
                  : Util.PlaceAtNeighborReplaceExistingBlockEnum.REPLACE_EXISTING_BLOCK;
               if (var6 == Util.PlaceAtNeighborReplaceExistingBlockEnum.REPLACE_EXISTING_BLOCK
                  && !client.onyx.interact.Util.isIBlockState(var4, var9, var1.getItemStack())) {
                  var10000 = var12;
               } else {
                  Util.Cls5 var10;
                  if ((var10 = getCls5ForBlockPos(var9, var6, var1)) == null) {
                     var10000 = var12;
                  } else {
                     BlockPos var13 = var10.blockPos;
                     Util.FaceSideRecord var11;
                     if ((var11 = getFaceSideRecordForIBlockState(client.onyx.interact.Util.getIBlockStateForBlockPos2(var10.blockPos), var13, var10, var1))
                        != null) {
                        YawPitchRecord var7 = YawPitchRecord.getYawPitchRecordForVec32(
                           var11.point.add(var13.getX(), var13.getY(), var13.getZ()), var1.getCls4().getVec3()
                        );
                        return new InteractedBlockPosPlacedBlockRecord(var13, var9, var11.side, var11.face.getVec3().yCoord + var13.getY(), var7);
                     }

                     var10000 = var12;
                  }
               }
            }
         }

         return null;
      }
   }

   private static Util.Cls5 getCls5ForBlockPos2(BlockPos var0, EnumFacing var1, Util.PlaceAtNeighborReplaceExistingBlockEnum var2) {
      switch (var2) {
         case PLACE_AT_NEIGHBOR:

            IBlockState var3;
            BlockPos var4;
            if ((var3 = client.onyx.interact.Util.getIBlockStateForBlockPos(var4 = var0.offset(var1.getOpposite()))) == null) {
               return null;
            } else {
               return var3.getBlock().isReplaceable(MINECRAFT.theWorld, var4) ? null : new Util.Cls5(var4, var1);
            }
         case REPLACE_EXISTING_BLOCK:
            return new Util.Cls5(var0, var1);
         default:
            return null;
      }
   }

   private Util() {
   }

   private static final class Cls5 {
      final Vec3 vec3;
      final EnumFacing enumFacing;
      final BlockPos blockPos;

      double getDouble(Vec3 var1) {
         var1 = var1.subtract(this.vec3);
         return var1.dotProduct(new Vec3(this.enumFacing.getDirectionVec())) / var1.length();
      }

      private Cls5(BlockPos var1, EnumFacing var2) {
         this.blockPos = var1;
         this.enumFacing = var2;
         this.vec3 = Util12.getVec3ForAxisAlignedBB2(
            new AxisAlignedBB(var1.getX(), var1.getY(), var1.getZ(), var1.getX() + 1.0, var1.getY() + 1.0, var1.getZ() + 1.0), var2
         );
      }
   }

   private record FaceSideRecord(client.onyx.util.math.Cls2 face, EnumFacing side, Vec3 point) {
   }

   public static enum PlaceAtNeighborReplaceExistingBlockEnum {
      PLACE_AT_NEIGHBOR,
      REPLACE_EXISTING_BLOCK;

   }
}
