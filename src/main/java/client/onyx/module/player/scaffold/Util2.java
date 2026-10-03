package client.onyx.module.player.scaffold;

import client.onyx.MinecraftAccess;
import client.onyx.util.Util10;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFalling;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public final class Util2 implements MinecraftAccess {
   private static final Set<Block> SET = Set.of(Blocks.tnt, Blocks.web, Blocks.portal);
   private static final Set<Block> SET2 = Set.of(Blocks.crafting_table, Blocks.enchanting_table, Blocks.cauldron);

   public static boolean isItemStack9(ItemStack var0) {
      if (var0 == null) {
         return false;
      } else {
         Block var2;
         if ((var2 = Util10.getBlockForItemStack2(var0)) == null) {
            return false;
         } else if (!var2.getMaterial().isSolid() || !var2.isFullCube()) {
            return false;
         } else {
            return var2 instanceof BlockFalling ? false : !SET.contains(var2);
         }
      }
   }

   private Util2() {
   }

   public static boolean isItemStack8(ItemStack var0) {
      Block var2;
      if ((var2 = Util10.getBlockForItemStack2(var0)) == null) {
         return true;
      } else if (var2.slipperiness > 0.6F) {
         return true;
      } else if (var2 instanceof BlockContainer) {
         return true;
      } else {
         return !var2.isFullCube() ? true : SET2.contains(var2);
      }
   }
}
