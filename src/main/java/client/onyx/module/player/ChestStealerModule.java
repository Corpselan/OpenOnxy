package client.onyx.module.player;

import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub10;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;
import java.util.Locale;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.BlockChest;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class ChestStealerModule extends Module {
   public ValueSettingSub10 valueSettingSub10 = (new ValueSettingSub10("Delay", 1.0D, 0.0D, 10.0D, 1.0D)).getValueSettingSub10("t").getBooleanSetting("Ticks between clicks");
   private static final int INT = 5;
   public ValueSettingSub9 valueSettingSub93 = (new ValueSettingSub9("Filter", true)).getBooleanSetting("Leaves behind anything InventoryManager calls junk");
   public ValueSettingSub9 valueSettingSub92 = (new ValueSettingSub9("Close", true)).getBooleanSetting("Closes the chest once there is nothing left worth taking");
   private transient int int_;
   public ValueSettingSub9 valueSettingSub9 = (new ValueSettingSub9("Anti GUI", true)).getBooleanSetting("Only steal from a real chest. A shop, kit or menu is a chest window like any other, and clicking through one buys it out.");

   protected void run79() {
      this.int_ = 0;
   }

   private static String getString31() {
      String var0 = "container.chest";
      Object[] var10001 = new Object[0];
      boolean var10003 = true;
      String var1 = I18n.format("container.chest", var10001);
      return (var0.equals(var1) ? "chest" : var1).toLowerCase(Locale.ROOT);
   }

   private boolean isContainerChest2(ContainerChest var1) {
      if (!this.valueSettingSub9.isEnabled17()) {
         return true;
      } else {
         return isContainerChest(var1) && this.isEnabled117();
      }
   }

   @EventHandler
   private void handleEventSub107(EventSub10 var1) {
      ContainerChest var6;
      if ((var6 = this.getContainerChest()) != null && this.isContainerChest2(var6)) {
         int var2;
         if ((var2 = this.getInt47(var6)) < 0) {
            this.int_ = 0;
            if (this.valueSettingSub92.isEnabled17()) {
               MINECRAFT.thePlayer.closeScreen();
            }

         } else {
            int var3 = this.int_;
            int var4 = var3 + 1;
            this.int_ = var4;
            int var5 = this.valueSettingSub10.getInt10();
            if (var3 >= var5) {
               MINECRAFT.playerController.windowClick(var6.windowId, var2, 0, 1, MINECRAFT.thePlayer);
               this.int_ = 0;
            }
         }
      } else {
         this.int_ = 0;
      }
   }

   public ChestStealerModule() {
      super("ChestStealer", "Takes the useful items out of a chest", ModuleCategory.PLAYER);
   }

   private ContainerChest getContainerChest() {
      if (MINECRAFT.thePlayer != null && MINECRAFT.currentScreen instanceof GuiChest) {
         Container var2;
         return (var2 = MINECRAFT.thePlayer.openContainer) instanceof ContainerChest ? (ContainerChest)var2 : null;
      } else {
         return null;
      }
   }

   private int getInt47(ContainerChest var1) {
      int var4 = var1.getLowerChestInventory().getSizeInventory();

      int var5;
      for(int var10000 = var5 = 0; var10000 < var4; var10000 = var5) {
         ItemStack var2;
         if ((var2 = var1.getSlot(var5).getStack()) != null && var2.getItem() != null && !this.isItemStack4(var2)) {
            return var5;
         }

         ++var5;
      }

      return -1;
   }

   private static boolean isContainerChest(ContainerChest var0) {
      IChatComponent var2;
      if ((var2 = var0.getLowerChestInventory().getDisplayName()) == null) {
         return false;
      } else {
         String var3;
         return (var3 = EnumChatFormatting.getTextWithoutFormattingCodes(var2.getUnformattedText())) == null ? false : var3.toLowerCase(Locale.ROOT).contains(getString31());
      }
   }

   private boolean isItemStack4(ItemStack var1) {
      return this.valueSettingSub93.isEnabled17() && OnyxClient.cls.la.isItemStack6(var1);
   }

   private boolean isEnabled117() {
      if (MINECRAFT.theWorld == null) {
         return false;
      } else {
         BlockPos var4 = new BlockPos(MINECRAFT.thePlayer);

         int var2;
         for(int var10000 = var2 = -5; var10000 <= 5; var10000 = var2) {
            int var5;
            for(var10000 = var5 = -5; var10000 <= 5; var10000 = var5) {
               int var1;
               for(var10000 = var1 = -5; var10000 <= 5; var10000 = var1) {
                  if (MINECRAFT.theWorld.getBlockState(var4.add(var2, var5, var1)).getBlock() instanceof BlockChest) {
                     return true;
                  }

                  ++var1;
               }

               ++var5;
            }

            ++var2;
         }

         return false;
      }
   }
}
