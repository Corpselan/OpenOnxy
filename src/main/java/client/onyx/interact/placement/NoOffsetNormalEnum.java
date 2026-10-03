package client.onyx.interact.placement;

import client.onyx.util.Util6;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3i;

public enum NoOffsetNormalEnum {
   // 顺序按原 $VALUES 数组（即 ordinal）
   NO_OFFSET(List.of(BlockPos.ORIGIN)),
   NORMAL(getListForIntArray(new int[]{0, -1, 1})),
   DOWN(getListForIntArray(new int[]{0, -1, 1, -2, 2})),
   FULL(getListForIntArray(new int[]{0, -1, 1, -2, 2, -3, 3, -4, 4}));

   private final List<BlockPos> list;

   public boolean isInt(int var1, int var2, int var3) {
      return this.list.contains(new BlockPos(var1, var2, var3));
   }

   public List<BlockPos> getList() {
      return this.list;
   }

   private static List<BlockPos> getListForIntArray(int... var0) {
      ArrayList var14 = new ArrayList(var0.length * var0.length * 2);
      int[] var2 = var0;
      int var3 = var0.length;

      int var4;
      for (int var10000 = var4 = 0; var10000 < var3; var10000 = ++var4) {
         int var5 = var2[var4];
         int[] var6 = var0;
         int var7 = var0.length;

         int var8;
         for (int var18 = var8 = 0; var18 < var7; var18 = ++var8) {
            int var9 = var6[var8];
            long var10 = new BlockPos(var5, 0, var9).toLong();
            long var12 = new BlockPos(var5, -1, var9).toLong();
            if (!var14.contains(var10)) {
               var14.add(var10);
            }

            if (!var14.contains(var12)) {
               var14.add(var12);
            }
         }
      }

      ArrayList var15 = new ArrayList(var14.size());
      Iterator var16;
      Iterator var19 = var16 = var14.iterator();

      while (var19.hasNext()) {
         long var17 = (Long)var16.next();
         var19 = var16;
         var15.add(BlockPos.fromLong(var17));
      }

      var15.sort(NoOffsetNormalEnum.Cls5.COMPARATOR);
      return List.copyOf(var15);
   }

   private NoOffsetNormalEnum(List<BlockPos> var3) {
      this.list = var3;
   }

   private static final class Cls5 {
      static final Comparator<Vec3i> COMPARATOR = Comparator.comparingLong(Util6::getLongForVec3i)
         .thenComparingInt(Vec3i::getY)
         .thenComparingInt(Vec3i::getX)
         .thenComparingInt(Vec3i::getZ);
   }
}
