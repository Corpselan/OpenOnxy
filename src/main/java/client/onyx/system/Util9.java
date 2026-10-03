package client.onyx.system;

import client.onyx.MinecraftAccess;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

public final class Util9 {
   public static final int INT = 9;
   public static final int INT2 = 45;
   public static final int INT3 = 1;
   public static final int INT4 = 2;
   public static final int INT5 = 36;
   public static final int INT6 = 4;
   public static final int INT7 = 5;
   public static final int INT8 = 9;

   private static void handleInt3(int var0, int var1, int var2) {
      Container var4;
      if ((var4 = getContainer()) != null) {
         MinecraftAccess.MINECRAFT.playerController.windowClick(var4.windowId, var0, var1, var2, MinecraftAccess.MINECRAFT.thePlayer);
      }
   }

   public static double getDoubleForItemStack5(ItemStack var0) {
      if (var0 != null && var0.getItem() != null) {
         Item var5 = var0.getItem();
         double var1 = var5 instanceof ItemSword ? ((ItemSword)var5).getDamageVsEntity() : 1.0;
         double var7;
         return (var7 = var1 + getIntForItemStack2(var0, Enchantment.sharpness) * 1.25)
            + getIntForItemStack2(var0, Enchantment.fireAspect) * 0.3
            + getIntForItemStack2(var0, Enchantment.knockback) * 0.15
            + getIntForItemStack2(var0, Enchantment.unbreaking) * 0.1;
      } else {
         return Double.NEGATIVE_INFINITY;
      }
   }

   public static ItemStack getItemStackForInt(int var0) {
      Container var2;
      return (var2 = getContainer()) != null && var0 >= 0 && var0 < var2.inventorySlots.size() ? var2.getSlot(var0).getStack() : null;
   }

   public static Container getContainer() {
      return MinecraftAccess.MINECRAFT.thePlayer.inventoryContainer;
   }

   private static int getIntForItemStack2(ItemStack var0, Enchantment var1) {
      return EnchantmentHelper.getEnchantmentLevel(var1.effectId, var0);
   }

   public static void handleInt4(int var0) {
      handleInt3(var0, 0, 1);
   }

   public static double getDoubleForItemStack(ItemStack var0) {
      return var0 != null && var0.getItem() instanceof ItemArmor var1 ? getDoubleForItemStack3(var0, var1) : Double.NEGATIVE_INFINITY;
   }

   public static int getIntForItemStack(ItemStack var0) {
      if (var0 != null) {
         Item var4 = var0.getItem();
         if (var4 instanceof ItemArmor) {
            ItemArmor var1;
            return (var1 = (ItemArmor)var4).armorType;
         }
      }

      return -1;
   }

   private Util9() {
   }

   public static void handleInt(int var0) {
      handleInt3(var0, 1, 4);
   }

   private static double getDoubleForItemStack3(ItemStack var0, ItemArmor var1) {
      double var10001 = var1.damageReduceAmount;
      return var1.damageReduceAmount
         + getIntForItemStack2(var0, Enchantment.protection) * 1.25
         + getIntForItemStack2(var0, Enchantment.blastProtection) * 0.15
         + getIntForItemStack2(var0, Enchantment.fireProtection) * 0.15
         + getIntForItemStack2(var0, Enchantment.projectileProtection) * 0.15
         + getIntForItemStack2(var0, Enchantment.thorns) * 0.1
         + getIntForItemStack2(var0, Enchantment.unbreaking) * 0.1;
   }

   public static void handleInt2(int var0, int var1) {
      handleInt3(var0, var1, 2);
   }

   public static double getDoubleForItemStack4(ItemStack var0) {
      if (var0 != null && var0.getItem() != null) {
         Item var3;
         if ((var3 = var0.getItem()) instanceof ItemArmor) {
            ItemArmor var2 = (ItemArmor)var3;
            return getDoubleForItemStack3(var0, var2);
         } else if (var3 instanceof ItemSword) {
            return getDoubleForItemStack5(var0);
         } else if (var3 instanceof ItemTool) {
            return getDoubleForItemStack2(var0);
         } else {
            return var3 instanceof ItemBlock ? var0.stackSize : var0.stackSize;
         }
      } else {
         return Double.NEGATIVE_INFINITY;
      }
   }

   public static int getIntForInt(int var0) {
      return 5 + var0;
   }

   public static double getDoubleForItemStack2(ItemStack var0) {
      if (var0 != null && var0.getItem() != null) {
         Item var5 = var0.getItem();
         double var1 = var5 instanceof ItemTool ? ((ItemTool)var5).getToolMaterial().getEfficiencyOnProperMaterial() : 1.0;
         double var7;
         return (var7 = var1 + getIntForItemStack2(var0, Enchantment.fortune) * 1.25)
            + getIntForItemStack2(var0, Enchantment.efficiency) * 0.5
            + getIntForItemStack2(var0, Enchantment.unbreaking) * 0.3;
      } else {
         return Double.NEGATIVE_INFINITY;
      }
   }
}
