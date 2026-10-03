package client.onyx.interact.placement;

import client.onyx.util.Util12;
import client.onyx.util.math.PointDistanceSquaredRecord;
import client.onyx.util.math.PositionDirectionRecord;
import java.util.Comparator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class Cls {
   private final Cls2 cls2;
   private final Cls4 cls4;
   private final Cls3 cls3;
   private final ItemStack itemStack;

   private static AxisAlignedBB getAxisAlignedBBForBlockPos(BlockPos var0) {
      return client.onyx.interact.Util.getAxisAlignedBBForBlockPos(var0).offset(var0.getX(), var0.getY(), var0.getZ());
   }

   public Cls2 getCls2() {
      return this.cls2;
   }

   public static Comparator<BlockPos> getComparatorForPositionDirectionRecord(PositionDirectionRecord var0) {
      return Comparator.comparingDouble(var1 -> {
         AxisAlignedBB var2 = getAxisAlignedBBForBlockPos(var1);
         PointDistanceSquaredRecord var3;
         return -((var3 = var0.getPointDistanceSquaredRecord(var2)) != null ? var3.distanceSquared() : Double.POSITIVE_INFINITY);
      });
   }

   public static Comparator<BlockPos> getComparatorForVec3(Vec3 var0) {
      return Comparator.comparingDouble(var1 -> -Util12.getDoubleForAxisAlignedBB3(getAxisAlignedBBForBlockPos(var1), var0));
   }

   public Cls3 getCls3() {
      return this.cls3;
   }

   public Cls4 getCls4() {
      return this.cls4;
   }

   public ItemStack getItemStack() {
      return this.itemStack;
   }

   public Cls(Cls2 var1, Cls3 var2, ItemStack var3, Cls4 var4) {
      this.cls2 = var1;
      this.cls3 = var2;
      this.itemStack = var3;
      this.cls4 = var4;
   }

   public static String decrypt(String var0) {
      int var10001 = 3 << 3 ^ 4;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 83;
      byte var12 = 50;
      int var10000 = var10002;

      for (int var2 = var10001; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var10002 = var5--;
         var1[var10002] = (char)(var10.charAt(var10002) ^ var4);
      }

      return new String(var1);
   }
}
