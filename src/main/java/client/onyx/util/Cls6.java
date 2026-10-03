package client.onyx.util;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public final class Cls6 {
   private final Cls6.SwordAxeEnum swordAxeEnum;
   private final String string;
   public static final int INT = -1;
   public static final char CHAR = '@';
   public static final char CHAR2 = '~';
   private final Cls6.ItemGroupEnum itemGroupEnum;
   private final String string2;
   private final int int_;
   private final Item item;
   public static final char CHAR3 = '#';

   public static Cls6 getCls6ForSwordAxeEnum(Cls6.SwordAxeEnum var0) {
      return var0 == null ? null : new Cls6(Cls6.ItemGroupEnum.GROUP, null, -1, var0, null);
   }

   private Cls6(Cls6.ItemGroupEnum var1, Item var2, int var3, Cls6.SwordAxeEnum var4, String var5) {
      this.itemGroupEnum = var1;
      this.item = var2;
      this.int_ = var3;
      this.swordAxeEnum = var4;
      this.string = var5;
      this.string2 = this.getString4();
   }

   public boolean isEnabled() {
      return this.itemGroupEnum == Cls6.ItemGroupEnum.ITEM;
   }

   private ItemStack getItemStack2() {
      Iterator var1 = Item.itemRegistry.iterator();

      while (var1.hasNext()) {
         Item var3;
         if ((var3 = (Item)var1.next()) != null && getStringForItem2(var3).contains(this.string)) {
            return new ItemStack(var3);
         }
      }

      return null;
   }

   public static Cls6 getCls6ForString2(String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var5;
         if ((var5 = var0.trim()).isEmpty()) {
            return null;
         } else if (var5.charAt(0) == '@') {
            try {
               return getCls6ForSwordAxeEnum(Cls6.SwordAxeEnum.valueOf(var5.substring(1).toUpperCase(Locale.ROOT)));
            } catch (IllegalArgumentException var6) {
               return null;
            }
         } else if (var5.charAt(0) == '~') {
            return getCls6ForString(var5.substring(1));
         } else {
            int var2 = var5.indexOf(35);
            int var4 = -1;
            if (var2 >= 0) {
               try {
                  var4 = Integer.parseInt(var5.substring(var2 + 1).trim());
               } catch (NumberFormatException var7) {
                  return null;
               }

               var5 = var5.substring(0, var2).trim();
            }

            ResourceLocation var3 = new ResourceLocation(var5);
            return !Item.itemRegistry.containsKey(var3) ? null : getCls6ForItem(Item.itemRegistry.getObject(var3), var4);
         }
      }
   }

   public static Cls6 getCls6ForItem(Item var0, int var1) {
      return var0 == null ? null : new Cls6(Cls6.ItemGroupEnum.ITEM, var0, var1, null, null);
   }

   private String getString4() {
      switch (this.itemGroupEnum) {
         case ITEM:

            return this.int_ == -1
               ? getStringForItem(this.item)
               : new StringBuilder().insert(0, getStringForItem(this.item)).append('#').append(this.int_).toString();
         case GROUP:
            return '@' + this.swordAxeEnum.name();
         case NAME:
            return '~' + this.string;
         default:
            throw new MatchException(null, null);
      }
   }

   @Override
   public String toString() {
      return this.string2;
   }

   private static String getStringForItem2(Item var0) {
      ResourceLocation var2;
      return (var2 = Item.itemRegistry.getNameForObject(var0)) == null ? "" : var2.getResourcePath();
   }

   public static Cls6 getCls6ForString(String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var2;
         return (var2 = var0.trim().toLowerCase(Locale.ROOT)).isEmpty() ? null : new Cls6(Cls6.ItemGroupEnum.NAME, null, -1, null, var2);
      }
   }

   private String getString() {
      try {
         String var2;
         if ((var2 = new ItemStack(this.item, 1, this.int_ == -1 ? 0 : this.int_).getDisplayName()) != null && !var2.isEmpty()) {
            return var2;
         }
      } catch (RuntimeException var3) {
      }

      return getStringForItem2(this.item);
   }

   public ItemStack getItemStack() {
      switch (this.itemGroupEnum) {
         case ITEM:
            return new ItemStack(this.item, 1, this.int_ == -1 ? 0 : this.int_);
         case GROUP:

            return this.swordAxeEnum.getItemStack();
         case NAME:
            return this.getItemStack2();
         default:
            throw new MatchException(null, null);
      }
   }

   public static Cls6 getCls6ForItemStack(ItemStack var0) {
      return var0 != null && var0.getItem() != null ? getCls6ForItem(var0.getItem(), var0.getMetadata()) : null;
   }

   @Override
   public int hashCode() {
      return this.string2.hashCode();
   }

   public String getString3() {
      switch (this.itemGroupEnum) {
         case ITEM:

            String var2 = this.getString();
            return this.int_ == -1 ? var2 : new StringBuilder().insert(0, var2).append(" #").append(this.int_).toString();
         case GROUP:
            return this.swordAxeEnum.getString();
         case NAME:
            return new StringBuilder().insert(0, "*").append(this.string).append("*").toString();
         default:
            throw new MatchException(null, null);
      }
   }

   public static String getStringForItem(Item var0) {
      return String.valueOf(Item.itemRegistry.getNameForObject(var0));
   }

   public boolean isItemStack(ItemStack var1) {
      if (var1 != null && var1.getItem() != null) {
         switch (this.itemGroupEnum) {
            case ITEM:

               return var1.getItem() == this.item && (this.int_ == -1 || var1.getMetadata() == this.int_);
            case GROUP:
               return this.swordAxeEnum.isItemStack2(var1);
            case NAME:
               return getStringForItem2(var1.getItem()).contains(this.string);
            default:
               throw new MatchException(null, null);
         }
      } else {
         return false;
      }
   }

   public String getString2() {
      return this.string2;
   }

   @Override
   public boolean equals(Object var1) {
      return var1 instanceof Cls6 var2 && this.string2.equals(var2.string2);
   }

   private static enum ItemGroupEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      ITEM,
      GROUP,
      NAME;

   }

   public static enum SwordAxeEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      SWORD("Swords"),
      AXE("Axes"),
      PICKAXE("Pickaxes"),
      SHOVEL("Shovels"),
      HOE("Hoes"),
      TOOL("Any tool"),
      ARMOR("Armor"),
      BLOCK("Blocks"),
      FOOD("Food"),
      POTION("Potions"),
      BAD_POTION("Harmful potions"),
      ANY("Anything");
      private final String string;

      public String getString() {
         return this.string;
      }

      public boolean isItem(Item var1) {
         switch (this) {
            case SWORD:

               return var1 instanceof ItemSword;
            case AXE:
               return var1 instanceof ItemAxe;
            case PICKAXE:
               return var1 instanceof ItemPickaxe;
            case SHOVEL:
               return var1 instanceof ItemSpade;
            case HOE:
               return var1 instanceof ItemHoe;
            case TOOL:
               if (!(var1 instanceof ItemTool) && !(var1 instanceof ItemHoe) && !(var1 instanceof ItemShears)) {
                  return false;
               }

               return true;
            case ARMOR:
               return var1 instanceof ItemArmor;
            case BLOCK:
               return var1 instanceof ItemBlock;
            case FOOD:
               return var1 instanceof ItemFood;
            case POTION:
               return var1 instanceof ItemPotion;
            case BAD_POTION:
               return false;
            case ANY:
               return true;
            default:
               throw new MatchException(null, null);
         }
      }

      public ItemStack getItemStack() {
         Object var2 = switch (this) {
            case SWORD -> {
               yield Items.iron_sword;

            }
            case AXE -> Items.iron_axe;
            case PICKAXE -> Items.iron_pickaxe;
            case SHOVEL -> Items.iron_shovel;
            case HOE -> Items.iron_hoe;
            case TOOL -> Items.iron_pickaxe;
            case ARMOR -> Items.iron_chestplate;
            case BLOCK -> Item.getItemFromBlock(Blocks.stone);
            case FOOD -> Items.bread;
            case POTION, BAD_POTION -> Items.potionitem;
            case ANY -> Items.book;
         };
         return var2 == null ? null : new ItemStack((Item)var2);
      }

      private SwordAxeEnum(String var3) {
         this.string = var3;
      }

      public boolean isItemStack2(ItemStack var1) {
         if (var1 == null || var1.getItem() == null) {
            return false;
         } else {
            return this == BAD_POTION ? isItemStack(var1) : this.isItem(var1.getItem());
         }
      }


      private static boolean isItemStack(ItemStack var0) {
         Item var4 = var0.getItem();
         if (!(var4 instanceof ItemPotion)) {
            return false;
         } else {
            ItemPotion var1;
            List var3;
            if ((var3 = (var1 = (ItemPotion)var4).getEffects(var0)) == null) {
               return false;
            } else {
               Iterator var6 = var3.iterator();

               while (var6.hasNext()) {
                  int var7;
                  if ((var7 = ((PotionEffect)var6.next()).getPotionID()) == Potion.moveSlowdown.id
                     || var7 == Potion.blindness.id
                     || var7 == Potion.poison.id
                     || var7 == Potion.digSlowdown.id
                     || var7 == Potion.weakness.id
                     || var7 == Potion.harm.id) {
                     return true;
                  }
               }

               return false;
            }
         }
      }
   }
}
