package client.onyx.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public final class Util9 {
   private static List<Util9.StackIdRecord> list;

   private Util9() {
   }

   private static List<Util9.StackIdRecord> getList2() {
      ArrayList var0 = new ArrayList();
      Iterator var1 = Item.itemRegistry.iterator();

      label40:
      while (true) {
         Iterator var10000 = var1;

         while (var10000.hasNext()) {
            Item var2;
            if ((var2 = (Item)var1.next()) == null) {
               var10000 = var1;
            } else {
               ResourceLocation var3;
               if ((var3 = Item.itemRegistry.getNameForObject(var2)) != null) {
                  String var4 = var3.toString();
                  Iterator var7 = getListForItem(var2).iterator();

                  while (true) {
                     var10000 = var7;

                     while (true) {
                        if (!var10000.hasNext()) {
                           continue label40;
                        }

                        ItemStack var5;
                        if ((var5 = (ItemStack)var7.next()) == null) {
                           break;
                        }

                        if (var5.getItem() == null) {
                           var10000 = var7;
                        } else {
                           String var6 = getStringForItemStack(var5, var3.getResourcePath());
                           var10000 = var7;
                           var0.add(
                              new Util9.StackIdRecord(
                                 var5, var4, var6, new StringBuilder().insert(0, var4).append(' ').append(var6).toString().toLowerCase(Locale.ROOT)
                              )
                           );
                        }
                     }
                  }
               }

               var10000 = var1;
            }
         }

         return var0;
      }
   }

   public static List<Util9.StackIdRecord> getListForString(String var0, int var1) {
      ArrayList var6 = new ArrayList();
      String var4 = var0 == null ? "" : var0.trim().toLowerCase(Locale.ROOT);
      Iterator var3 = getList().iterator();

      label32:
      while (true) {
         for (Iterator var10000 = var3; var10000.hasNext(); var10000 = var3) {
            Util9.StackIdRecord var5 = (Util9.StackIdRecord)var3.next();
            if (var4.isEmpty() || var5.search().contains(var4)) {
               var6.add(var5);
               if (var1 > 0 && var6.size() >= var1) {
                  break label32;
               }
               continue label32;
            }
         }

         return var6;
      }

      return var6;
   }

   private static String getStringForItemStack(ItemStack var0, String var1) {
      try {
         String var3;
         if ((var3 = var0.getDisplayName()) != null && !var3.isEmpty()) {
            return var3;
         }
      } catch (RuntimeException var4) {
      }

      return var1;
   }

   private static List<ItemStack> getListForItem(Item var0) {
      ArrayList var2 = new ArrayList();

      ArrayList var10000;
      label17: {
         try {
            var0.getSubItems(var0, null, var2);
         } catch (RuntimeException var5) {
            var10000 = var2;
            var2.clear();
            break label17;
         }

         var10000 = var2;
      }

      if (var10000.isEmpty()) {
         ItemStack var3 = new ItemStack(var0);
         boolean var4 = var2.add(var3);
      }

      return var2;
   }

   public static List<Util9.StackIdRecord> getList() {
      if (list == null) {
         list = getList2();
      }

      return list;
   }

   public record StackIdRecord(ItemStack stack, String id, String name, String search) {
   }
}
