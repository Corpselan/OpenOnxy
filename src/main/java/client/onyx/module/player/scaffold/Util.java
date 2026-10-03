package client.onyx.module.player.scaffold;

import client.onyx.MinecraftAccess;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.Util3;
import client.onyx.util.Util6;
import client.onyx.util.math.PositionDirectionRecord;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public final class Util implements MinecraftAccess {
   private static Util.BlockPosOffsetXRecord blockPosOffsetXRecord;
   private static final int INT = 4;
   private static final double DOUBLE = 0.001;
   private static BlockPos blockPos;
   private static final Deque<BlockPos> DEQUE = new ArrayDeque<>(4);
   private static final double DOUBLE2 = 0.02;
   private static final double[] DOUBLE_ARRAY;
   private static float float_ = Float.NaN;
   private static final float FLOAT = 30.0F;

   private Util() {
   }

   private static Util.BlockPosOverlapAreaRecord getBlockPosOverlapAreaRecordForMap(
      Map<BlockPos, Util.BlockPosOverlapAreaRecord> var0, Util.BlockPosOverlapAreaRecord var1
   ) {
      BlockPos var4;
      Util.BlockPosOverlapAreaRecord var3 = (var4 = DEQUE.peekLast()) == null ? null : (Util.BlockPosOverlapAreaRecord)var0.get(var4);
      Util.BlockPosOverlapAreaRecord var5 = blockPos == null ? null : (Util.BlockPosOverlapAreaRecord)var0.get(blockPos);
      if (var3 != null && var3.isBlockPosOverlapAreaRecord(var1)) {
         return var3;
      } else {
         return var5 != null && var5.isBlockPosOverlapAreaRecord(var1) ? var5 : var1;
      }
   }

   private static boolean isPositionDirectionRecord(PositionDirectionRecord var0, Vec3 var1) {
      return var0.getVec3().dotProduct(var1) < 0.5;
   }

   public static Util.BlockPosOffsetXRecord getBlockPosOffsetXRecord2() {
      return blockPosOffsetXRecord;
   }

   private static Vec3 getVec3ForFloat4(float var0) {
      if (!Float.isNaN(float_) && getFloatForFloat19(var0, float_) <= 30.0F) {
         return Vec3.directionFromRotation(0.0F, float_);
      } else {
         float var2;
         float_ = var2 = MathHelper.wrapAngleTo180_float(((float)Math.rint(var0 / 180.0F * 4.0F + 4.0F) - 4.0F) / 4.0F * 180.0F);
         return Vec3.directionFromRotation(0.0F, var2);
      }
   }

   public static void run160() {
      blockPos = null;
      blockPosOffsetXRecord = null;
      float_ = Float.NaN;
      DEQUE.clear();
   }

   private static Map<BlockPos, Util.BlockPosOverlapAreaRecord> getMap2() {
      LinkedHashMap var0 = new LinkedHashMap();
      Vec3 var1 = client.onyx.util.Util2.getVec3ForEntity2(MINECRAFT.thePlayer);
      double[] var2 = DOUBLE_ARRAY;
      int var3 = DOUBLE_ARRAY.length;

      int var4;
      for (int var10000 = var4 = 0; var10000 < var3; var10000 = ++var4) {
         double var5 = var2[var4];
         double[] var7 = DOUBLE_ARRAY;
         int var8 = DOUBLE_ARRAY.length;

         int var9;
         for (int var15 = var9 = 0; var15 < var8; var15 = ++var9) {
            double var10 = var7[var9];
            BlockPos var14 = Util6.getBlockPosForVec32(var1, var5, -1.0, var10);
            IBlockState var11;
            if (!var0.containsKey(var14)
               && (var11 = client.onyx.interact.Util.getIBlockStateForBlockPos(var14)) != null
               && !getListForIBlockState(var11, var14).isEmpty()) {
               Util.BlockPosOverlapAreaRecord var12 = getBlockPosOverlapAreaRecordForBlockPos(var14);
               Object var13 = var0.put(var14, var12);
            }
         }
      }

      return var0;
   }

   public static void handleBlockPos6(BlockPos var0) {
      if (!var0.equals(DEQUE.peekLast())) {
         while (DEQUE.size() >= 4) {
            DEQUE.removeFirst();
         }

         DEQUE.addLast(var0);
      }
   }

   private static float getFloatForFloat19(float var0, float var1) {
      return Math.abs(MathHelper.wrapAngleTo180_float(var1 - var0));
   }

   private static List<AxisAlignedBB> getListForIBlockState(IBlockState var0, BlockPos var1) {
      ArrayList var3 = new ArrayList(1);
      if (var0 != null) {
         Util3.handleIBlockState(var0, var1, var3);
      }

      return var3;
   }

   private static Util.BlockPosOffsetXRecord getBlockPosOffsetXRecord() {
      Map<BlockPos, Util.BlockPosOverlapAreaRecord> var0;
      if ((var0 = getMap2()).isEmpty()) {
         blockPosOffsetXRecord = null;
         blockPos = null;
         return null;
      } else {
         Util.BlockPosOverlapAreaRecord var1 = null;

         for (Util.BlockPosOverlapAreaRecord var3 : var0.values()) {
            if (var1 == null || var3.compareTo(var1) < 0) {
               var1 = var3;
            }
         }

         if (var1 == null) {
            return null;
         } else {
            Util.BlockPosOverlapAreaRecord var4;
            blockPos = (var4 = getBlockPosOverlapAreaRecordForMap(var0, var1)).blockPos();
            Vec3 var5 = client.onyx.util.Util2.getVec3ForEntity2(MINECRAFT.thePlayer);
            return new Util.BlockPosOffsetXRecord(var4.blockPos(), var5.xCoord - (var4.blockPos().getX() + 0.5), var5.zCoord - (var4.blockPos().getZ() + 0.5));
         }
      }
   }

   static {
      double[] var10000 = new double[3];
      boolean var10002 = true;
      var10000[0] = 0.301;
      var10000[1] = 0.0;
      var10000[2] = -0.301;
      DOUBLE_ARRAY = var10000;
   }

   private static Util.BlockPosOverlapAreaRecord getBlockPosOverlapAreaRecordForBlockPos(BlockPos var0) {
      AxisAlignedBB var7 = MINECRAFT.thePlayer.getEntityBoundingBox();
      IBlockState var14 = client.onyx.interact.Util.getIBlockStateForBlockPos(var0);
      double var3 = Double.POSITIVE_INFINITY;
      double var5 = 0.0;
      Iterator var16 = getListForIBlockState(var14, var0).iterator();

      label28:
      while (true) {
         for (Iterator var10000 = var16; var10000.hasNext(); var10000 = var16) {
            AxisAlignedBB var1 = (AxisAlignedBB)var16.next();
            double var8 = Math.min(var7.maxX, var1.maxX) - Math.max(var7.minX, var1.minX);
            double var10 = Math.min(var7.maxZ, var1.maxZ) - Math.max(var7.minZ, var1.minZ);
            if (var8 <= 0.0) {
               continue label28;
            }

            if (!(var10 <= 0.0)) {
               double var12 = Math.abs(var7.minY - var1.maxY);
               var8 *= var10;
               if (var12 + 0.001 < var3) {
                  var3 = var12;
                  var5 = var8;
               } else if (Math.abs(var12 - var3) <= 0.001) {
                  var5 += var8;
               }
               continue label28;
            }
         }

         return new Util.BlockPosOverlapAreaRecord(
            var0, var5, var3, Util6.getDoubleForVec32(client.onyx.util.Util2.getVec3ForEntity2(MINECRAFT.thePlayer), var0.getX() + 0.5, var0.getZ() + 0.5)
         );
      }
   }

   public static BlockPos getBlockPos12() {
      return DEQUE.peekLast();
   }

   public static PositionDirectionRecord getPositionDirectionRecordForForwardsBackwardsRecord(ForwardsBackwardsRecord var0) {
      Vec3 var4 = getVec3ForFloat4(client.onyx.util.Util2.getFloatForEntityPlayerSP4(MINECRAFT.thePlayer, var0));
      Util.BlockPosOffsetXRecord var6;
      if ((var6 = getBlockPosOffsetXRecord()) == null) {
         return null;
      } else {
         blockPosOffsetXRecord = var6;
         PositionDirectionRecord var3 = getPositionDirectionRecord3();
         Vec3 var1 = client.onyx.util.Util2.getVec3ForEntity2(MINECRAFT.thePlayer);
         Vec3 var5;
         if (var3 != null && !isPositionDirectionRecord(var3, var4)) {
            var5 = var3.getVec34(var1);
         } else {
            var5 = new Vec3(var6.blockPos().getX() + 0.5 + var6.offsetX(), var1.yCoord, var6.blockPos().getZ() + 0.5 + var6.offsetZ());
         }

         return new PositionDirectionRecord(Util6.getVec3ForVec38(var5, var1.yCoord), var4);
      }
   }

   private static PositionDirectionRecord getPositionDirectionRecord3() {
      if (DEQUE.size() < 2) {
         return null;
      } else {
         Deque<BlockPos> var10000 = DEQUE;
         BlockPos[] var10001 = new BlockPos[0];
         boolean var10003 = true;
         BlockPos[] var0;
         BlockPos[] var6 = var0 = var10000.toArray(var10001);
         BlockPos var1 = var6[var6.length - 1];
         Vec3 var2 = Util6.getVec3ForVec3i4(var0[var0.length - 2]);
         Vec3 var4 = Util6.getVec3ForVec3i4(var1);
         Vec3 var3 = var2.add(var4).scale(0.5);
         Vec3 var5 = var4.subtract(var2).normalize();
         return new PositionDirectionRecord(var3, var5);
      }
   }

   public record BlockPosOffsetXRecord(BlockPos blockPos, double offsetX, double offsetZ) {
   }

   private record BlockPosOverlapAreaRecord(BlockPos blockPos, double overlapArea, double surfaceDelta, double horizontalDistanceToPlayerSqr)
      implements Comparable<Util.BlockPosOverlapAreaRecord> {
      boolean isBlockPosOverlapAreaRecord(Util.BlockPosOverlapAreaRecord var1) {
         return this.surfaceDelta > var1.surfaceDelta + 0.001 ? false : !(this.overlapArea + 0.02 < var1.overlapArea);
      }

      public int compareTo(Util.BlockPosOverlapAreaRecord var1) {
         if (this.surfaceDelta + 0.001 < var1.surfaceDelta) {
            return -1;
         } else if (var1.surfaceDelta + 0.001 < this.surfaceDelta) {
            return 1;
         } else if (this.overlapArea > var1.overlapArea + 0.02) {
            return -1;
         } else if (this.overlapArea + 0.02 < var1.overlapArea) {
            return 1;
         } else if (this.horizontalDistanceToPlayerSqr < var1.horizontalDistanceToPlayerSqr) {
            return -1;
         } else {
            return this.horizontalDistanceToPlayerSqr > var1.horizontalDistanceToPlayerSqr ? 1 : 0;
         }
      }
   }
}
