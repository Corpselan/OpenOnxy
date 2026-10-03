package client.onyx.util;

import client.onyx.MinecraftAccess;
import java.util.Comparator;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;

public final class Util8 implements MinecraftAccess {
   public static final Comparator<ItemStack> COMPARATOR4 = (var0, var1) -> {
      boolean var10000;
      ItemStack var10001;
      if (!client.onyx.module.player.scaffold.Util2.isItemStack8(var0)) {
         var10000 = true;
         var10001 = var1;
      } else {
         var10000 = false;
         var10001 = var1;
      }

      return Boolean.compare(var10000, !client.onyx.module.player.scaffold.Util2.isItemStack8(var10001));
   };
   private static final double DOUBLE = 0.8;
   private static final double DOUBLE2 = 1.7;
   public static final Comparator<ItemStack> COMPARATOR3 = (var0, var1) -> Boolean.compare(
      getBlockForItemStack(var0).isNormalCube(), getBlockForItemStack(var1).isNormalCube()
   );
   public static final Comparator<ItemStack> COMPARATOR5 = (var0, var1) -> Boolean.compare(
      getBlockForItemStack(var0).isFullCube(), getBlockForItemStack(var1).isFullCube()
   );
   public static final Comparator<ItemStack> COMPARATOR = new Comparator<ItemStack>() {
      private final ComparatorImpl<Block> comparatorImpl;

      {
         Comparator[] var10003 = new Comparator[1];
         boolean var10005 = true;
         var10003[0] = Comparator.<Block>comparingDouble(var0 -> var0.slipperiness);
         this.comparatorImpl = new ComparatorImpl<>(var10003);
      }

      public int compare(ItemStack var1, ItemStack var2) {
         return this.comparatorImpl.compare(Util8.getBlockForItemStack(var1), Util8.getBlockForItemStack(var2));
      }
   };
   public static final Comparator<ItemStack> COMPARATOR6 = Comparator.comparingInt(var0 -> var0.stackSize);
   public static final Comparator<ItemStack> COMPARATOR2 = Util8.COMPARATOR6.reversed();
   private static final double DOUBLE3 = 2.0;

   static Block getBlockForItemStack(ItemStack var0) {
      return ((ItemBlock)var0.getItem()).getBlock();
   }

   private Util8() {
   }

   private static double getDoubleForItemStack(ItemStack var0, boolean var1) {
      float var3 = getBlockForItemStack(var0).getBlockHardness(MINECRAFT.theWorld, BlockPos.ORIGIN);
      return var1 && var3 >= 0.8 && var3 <= 2.0 ? 0.0 : Math.abs(1.7 - var3);
   }

   public static Comparator<ItemStack> getComparatorForBool(boolean var0) {
      return (var1, var2) -> Double.compare(getDoubleForItemStack(var2, var0), getDoubleForItemStack(var1, var0));
   }
}
