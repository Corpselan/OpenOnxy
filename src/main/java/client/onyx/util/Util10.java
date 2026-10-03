package client.onyx.util;

import client.onyx.MinecraftAccess;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class Util10 implements MinecraftAccess {
   public static Block getBlockForItemStack2(ItemStack var0) {
      if (var0 != null) {
         Item var4 = var0.getItem();
         if (var4 instanceof ItemBlock) {
            ItemBlock var1;
            return (var1 = (ItemBlock)var4).getBlock();
         }
      }

      return null;
   }

   public static boolean isItemStack10(ItemStack var0) {
      Block var2;
      return (var2 = getBlockForItemStack2(var0)) == null ? false : var2.isFullCube();
   }
}
