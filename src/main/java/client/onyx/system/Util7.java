package client.onyx.system;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class Util7 {
   private static Integer getIntegerForItemStack(ItemStack var0) {
      if (var0 != null) {
         Item var4 = var0.getItem();
         if (var4 instanceof ItemArmor) {
            ItemArmor var3;
            if (!(var3 = (ItemArmor)var4).hasColor(var0)) {
               return null;
            }

            return var3.getColor(var0);
         }
      }

      return null;
   }

   public static String decrypt(String var0) {
      int var10001 = 4 << 4 ^ 13;
      int var10002 = 3 << 3 ^ 6;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var12 = var5 = var10003 - 1;
      char[] var1 = var10004;
      int var4 = var10002;
      int var10000 = var12;

      for (byte var2 = 18; var10000 >= 0; var10000 = var5) {
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

   private static boolean isEntityPlayer(EntityPlayer var0, EntityPlayer var1) {
      int var5;
      for (int var10000 = var5 = 1; var10000 <= 4; var10000 = ++var5) {
         Integer var3 = getIntegerForItemStack(var0.getEquipmentInSlot(var5));
         Integer var4 = getIntegerForItemStack(var1.getEquipmentInSlot(var5));
         if (var3 != null && var3.equals(var4)) {
            return true;
         }
      }

      return false;
   }

   private static boolean isEntityPlayer4(EntityPlayer var0, EntityPlayer var1) {
      EnumChatFormatting var3 = var0.getDisplayName().getChatStyle().getColor();
      EnumChatFormatting var4 = var1.getDisplayName().getChatStyle().getColor();
      return var3 != null && var3 == var4;
   }

   private static boolean isEntityPlayer2(EntityPlayer var0) {
      int var2;
      for (int var10000 = var2 = 1; var10000 <= 4; var10000 = ++var2) {
         if (getIntegerForItemStack(var0.getEquipmentInSlot(var2)) != null) {
            return true;
         }
      }

      return false;
   }

   public static boolean isEntityPlayer3(EntityPlayer var0, EntityPlayer var1) {
      if (var0 == null || var1 == null || var0 == var1) {
         return false;
      } else if (!isEntityPlayer2(var0)) {
         return false;
      } else if (var0.isOnSameTeam(var1)) {
         return true;
      } else {
         return isEntityPlayer4(var0, var1) ? true : isEntityPlayer(var0, var1);
      }
   }
}
