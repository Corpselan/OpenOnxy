package client.onyx.module.player;

import client.onyx.event.impl.EventSub10;
import client.onyx.gui.Slots;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.SettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub5;
import client.onyx.setting.impl.ValueSettingSub7;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.Util9;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.item.ItemStack;

public class InventoryManagerModule extends Module {
   private transient int int_;
   public ValueSettingSub9 valueSettingSub9;
   public ValueSettingSub5 valueSettingSub5;
   public ValueSettingSub7 valueSettingSub7;
   public ValueSettingSub5 valueSettingSub52;
   private static final int INT = 4;
   public ValueSettingSub10 valueSettingSub10;
   public SettingSub settingSub = new SettingSub("Edit rules", () -> MINECRAFT.displayGuiScreen(new Slots(MINECRAFT.currentScreen)))
      .getBooleanSetting("Drag items onto the slots they belong in");
   public ValueSettingSub9 valueSettingSub92;

   @EventHandler
   private void handleEventSub108(EventSub10 var1) {
      if (MINECRAFT.thePlayer != null
         && MINECRAFT.currentScreen instanceof GuiInventory
         && MINECRAFT.thePlayer.openContainer == MINECRAFT.thePlayer.inventoryContainer) {
         int var2 = this.int_;
         int var3 = var2 + 1;
         this.int_ = var3;
         int var4 = this.valueSettingSub10.getInt10();
         if (var2 >= var4) {
            if (this.isEnabled124() || this.isEnabled126() || this.isEnabled125()) {
               this.int_ = 0;
            }
         }
      } else {
         this.int_ = 0;
      }
   }

   public InventoryManagerModule() {
      super("InventoryManager", "Sorts your inventory the way you laid it out", ModuleCategory.PLAYER);
      this.valueSettingSub10 = new ValueSettingSub10("Delay", 1.0, 0.0, 10.0, 1.0).getValueSettingSub10("t").getBooleanSetting("Ticks between clicks");
      this.valueSettingSub9 = new ValueSettingSub9("Manage armor", true).getBooleanSetting("Wears the best piece you are carrying in each armour slot");
      this.valueSettingSub92 = new ValueSettingSub9("Drop junk", true)
         .getBooleanSetting("Throws away anything on the Drop list that the Keep list does not rescue");
      Object[] var10004 = new Object[18];
      boolean var10006 = true;
      var10004[0] = 0;
      var10004[1] = "@SWORD";
      var10004[2] = 1;
      var10004[3] = "minecraft:golden_apple";
      var10004[4] = 2;
      var10004[5] = "@AXE";
      var10004[6] = 3;
      var10004[7] = "@PICKAXE";
      var10004[8] = 4;
      var10004[9] = "@BLOCK";
      var10004[10] = 5;
      var10004[11] = "@BLOCK";
      var10004[12] = 6;
      var10004[13] = "@BLOCK";
      var10004[14] = 7;
      var10004[15] = "@BLOCK";
      var10004[16] = 8;
      var10004[17] = "@BLOCK";
      this.valueSettingSub7 = new ValueSettingSub7("Slots", ValueSettingSub7.getMapForObjectArray(var10004));
      String[] var1 = new String[0];
      ValueSettingSub5 var2 = new ValueSettingSub5("Keep", var1);
      this.valueSettingSub5 = var2;
      String[] var3 = new String[]{
         "minecraft:snowball",
         "minecraft:egg",
         "minecraft:experience_bottle",
         "minecraft:flint",
         "minecraft:flint_and_steel",
         "minecraft:lava_bucket",
         "minecraft:string",
         "minecraft:chest",
         "minecraft:trapped_chest",
         "minecraft:ender_chest",
         "@HOE",
         "@BAD_POTION",
         "~anvil",
         "~tnt",
         "~seed",
         "~table",
         "~eye",
         "~mushroom",
         "~skull",
         "~pressure_plate"
      };
      ValueSettingSub5 var4 = new ValueSettingSub5("Drop", var3);
      this.valueSettingSub52 = var4;
   }

   private boolean isItemStack7(ItemStack var1) {
      return this.valueSettingSub52.isItemStack(var1) && !this.valueSettingSub5.isItemStack(var1) && this.valueSettingSub7.getInt9(var1) < 0;
   }

   @Override
   protected void run79() {
      this.int_ = 0;
   }

   private boolean isEnabled126() {
      boolean[] var4 = new boolean[45];

      int var11;
      for (int var10000 = var11 = 0; var10000 < 9; var10000 = ++var11) {
         if (!this.valueSettingSub7.getList7(var11).isEmpty()) {
            int var7 = 36 + var11;
            int var1 = -1;
            double var5 = Double.NEGATIVE_INFINITY;

            int var3;
            for (int var13 = var3 = 9; var13 < 45; var13 = ++var3) {
               ItemStack var8;
               double var9;
               if (!var4[var3]
                  && (var8 = Util9.getItemStackForInt(var3)) != null
                  && this.valueSettingSub7.isInt(var11, var8)
                  && !((var9 = Util9.getDoubleForItemStack4(var8)) <= var5)) {
                  var5 = var9;
                  var1 = var3;
               }
            }

            if (var1 >= 0) {
               var4[var1] = true;
               if (var1 != var7) {
                  Util9.handleInt2(var1, var11);
                  return true;
               }
            }
         }
      }

      return false;
   }

   private boolean isEnabled125() {
      if (!this.valueSettingSub92.isEnabled17()) {
         return false;
      } else {
         int var3;
         for (int var10000 = var3 = 9; var10000 < 45; var10000 = ++var3) {
            ItemStack var2;
            if ((var2 = Util9.getItemStackForInt(var3)) != null && this.isItemStack7(var2)) {
               Util9.handleInt(var3);
               return true;
            }
         }

         return false;
      }
   }

   public boolean isItemStack6(ItemStack var1) {
      if (var1 == null || var1.getItem() == null) {
         return false;
      } else if (this.valueSettingSub5.isItemStack(var1)) {
         return false;
      } else if (this.valueSettingSub52.isItemStack(var1)) {
         return true;
      } else if (this.isEnabled55() && MINECRAFT.thePlayer != null) {
         int var2;
         if ((var2 = Util9.getIntForItemStack(var1)) >= 0) {
            ItemStack var5;
            return !this.valueSettingSub9.isEnabled17()
               ? false
               : (var5 = Util9.getItemStackForInt(Util9.getIntForInt(var2))) != null && Util9.getDoubleForItemStack(var1) <= Util9.getDoubleForItemStack(var5);
         } else if (this.valueSettingSub7.getInt9(var1) < 0) {
            return false;
         } else {
            int var3;
            for (int var10000 = var3 = 0; var10000 < 9; var10000 = ++var3) {
               ItemStack var4;
               if (this.valueSettingSub7.isInt(var3, var1)
                  && (
                     (var4 = Util9.getItemStackForInt(36 + var3)) == null
                        || !this.valueSettingSub7.isInt(var3, var4)
                        || Util9.getDoubleForItemStack4(var1) > Util9.getDoubleForItemStack4(var4)
                  )) {
                  return false;
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private boolean isEnabled124() {
      if (!this.valueSettingSub9.isEnabled17()) {
         return false;
      } else {
         int var1;
         for (int var10000 = var1 = 0; var10000 < 4; var10000 = ++var1) {
            ItemStack var6;
            int var7;
            double var4 = (var6 = Util9.getItemStackForInt(var7 = Util9.getIntForInt(var1))) == null
               ? Double.NEGATIVE_INFINITY
               : Util9.getDoubleForItemStack(var6);
            int var11 = -1;

            int var2;
            for (int var12 = var2 = 9; var12 < 45; var12 = ++var2) {
               ItemStack var8;
               double var9;
               if (Util9.getIntForItemStack(var8 = Util9.getItemStackForInt(var2)) == var1
                  && !this.isItemStack7(var8)
                  && !((var9 = Util9.getDoubleForItemStack(var8)) <= var4)) {
                  var4 = var9;
                  var11 = var2;
               }
            }

            if (var11 >= 0) {
               if (var6 == null) {
                  Util9.handleInt4(var11);
               } else {
                  Util9.handleInt(var7);
               }

               return true;
            }
         }

         return false;
      }
   }
}
