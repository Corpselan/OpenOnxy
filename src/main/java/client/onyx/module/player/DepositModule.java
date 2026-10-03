package client.onyx.module.player;

import client.onyx.event.impl.EventSub11;
import client.onyx.event.impl.EventSub6;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.Util10;
import client.onyx.util.Cls7;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class DepositModule extends Module {
   private static final int INT = 27;
   private transient int int_;
   public ValueSettingSub9 valueSettingSub9;
   private transient EnumFacing enumFacing;
   private final transient Cls7 cls7;
   private static final int INT2 = 40;
   private transient DepositModule.IdleOpeningEnum idleOpeningEnum;
   private static final int INT3 = 1;
   private transient BlockPos blockPos;
   private static final int INT4 = 9;
   public ValueSettingSub<DepositModule.IronGoldEnum> valueSettingSub;
   public static final DepositModule DEPOSIT_MODULE = new DepositModule();
   private transient int int_2;
   private transient long long_;
   public ValueSettingSub3 valueSettingSub3;
   public ValueSettingSub11<DepositModule.HeldHotbarEnum> valueSettingSub112 = new ValueSettingSub11<>("Mode", DepositModule.HeldHotbarEnum.HELD)
      .getBooleanSetting("What a scroll at a chest sends over - just what you are holding, or a sweep of the hotbar");
   private transient Vec3 vec3;

   @EventHandler
   private void handleEventSub119(EventSub11 var1) {
      if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
         switch (this.idleOpeningEnum) {
            case OPENING:

               this.run157();
               return;
            case DEPOSITING:
               this.run159();
               return;
         }
      } else {
         this.run158();
      }
   }

   @Override
   protected void run79() {
      this.run158();
   }

   private void run157() {
      if (this.getContainerChest2() != null) {
         this.int_2 = this.valueSettingSub112.isEnum3(DepositModule.HeldHotbarEnum.HELD) ? MINECRAFT.thePlayer.inventory.currentItem : 0;
         this.long_ = 0L;
         this.cls7.run();
         this.idleOpeningEnum = DepositModule.IdleOpeningEnum.DEPOSITING;
      } else {
         int var2 = this.int_ + 1;
         this.int_ = var2;
         if (var2 >= 40) {
            this.run158();
         }
      }
   }

   private void run159() {
      ContainerChest var1;
      if ((var1 = this.getContainerChest2()) == null) {
         this.run158();
      } else if (this.cls7.isLong(this.long_)) {
         int var3;
         if ((var3 = this.getInt49()) < 0) {
            MINECRAFT.thePlayer.closeScreen();
            this.run158();
         } else {
            MINECRAFT.playerController.windowClick(var1.windowId, this.getInt50(var1, var3), 0, 1, MINECRAFT.thePlayer);
            this.int_2 = this.valueSettingSub112.isEnum3(DepositModule.HeldHotbarEnum.HELD) ? 9 : var3 + 1;
            this.long_ = (long)this.valueSettingSub3.getDouble();
            this.cls7.run();
         }
      }
   }

   private boolean isBlockPos11(BlockPos var1) {
      Block var2;
      return (var2 = MINECRAFT.theWorld.getBlockState(var1).getBlock()) instanceof BlockChest || var2 instanceof BlockEnderChest;
   }

   private boolean isItemStack5(ItemStack var1) {
      Item var2;
      if ((var2 = var1.getItem()) == Items.iron_ingot) {
         return this.valueSettingSub.isEnum(DepositModule.IronGoldEnum.IRON);
      } else if (var2 == Items.gold_ingot) {
         return this.valueSettingSub.isEnum(DepositModule.IronGoldEnum.GOLD);
      } else if (var2 == Items.diamond) {
         return this.valueSettingSub.isEnum(DepositModule.IronGoldEnum.DIAMOND);
      } else if (var2 == Items.emerald) {
         return this.valueSettingSub.isEnum(DepositModule.IronGoldEnum.EMERALD);
      } else {
         return var2 instanceof ItemBlock
            ? this.valueSettingSub.isEnum(DepositModule.IronGoldEnum.BLOCKS)
            : this.valueSettingSub.isEnum(DepositModule.IronGoldEnum.OTHER);
      }
   }

   private ContainerChest getContainerChest2() {
      if (!(MINECRAFT.currentScreen instanceof GuiChest)) {
         return null;
      } else {
         Container var2 = MINECRAFT.thePlayer.openContainer;
         return MINECRAFT.thePlayer.openContainer instanceof ContainerChest ? (ContainerChest)var2 : null;
      }
   }

   private void run158() {
      this.idleOpeningEnum = DepositModule.IdleOpeningEnum.IDLE;
      this.blockPos = null;
      this.enumFacing = null;
      this.vec3 = null;
      this.int_ = 0;
      this.int_2 = 0;
      this.long_ = 0L;
   }

   private int getInt49() {
      int var3;
      for (int var10000 = var3 = this.int_2; var10000 < 9; var10000 = ++var3) {
         ItemStack var2 = MINECRAFT.thePlayer.inventory.getStackInSlot(var3);
         if (this.valueSettingSub112.isEnum3(DepositModule.HeldHotbarEnum.HELD)) {
            if (var2 == null) {
               return -1;
            }

            return var3;
         }

         if (var2 != null && this.isItemStack5(var2)) {
            return var3;
         }
      }

      return -1;
   }

   private int getInt50(ContainerChest var1, int var2) {
      return var1.getLowerChestInventory().getSizeInventory() / 9 * 9 + 27 + var2;
   }

   private DepositModule() {
      super("Deposit", "Scroll at a chest to put your items in it", ModuleCategory.PLAYER);
      DepositModule.IronGoldEnum[] var10005 = new DepositModule.IronGoldEnum[4];
      boolean var10007 = true;
      var10005[0] = DepositModule.IronGoldEnum.IRON;
      var10005[1] = DepositModule.IronGoldEnum.GOLD;
      var10005[2] = DepositModule.IronGoldEnum.DIAMOND;
      var10005[3] = DepositModule.IronGoldEnum.EMERALD;
      this.valueSettingSub = new ValueSettingSub<>("Items", DepositModule.IronGoldEnum.class, var10005)
         .getValueSettingSub(false)
         .getBooleanSetting("Which of the hotbar a sweep picks up - the rest stays on you")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 == DepositModule.HeldHotbarEnum.HOTBAR);
      this.valueSettingSub9 = new ValueSettingSub9("Hypixel only", true).getBooleanSetting("Leaves the scroll wheel alone on every other server");
      this.valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString2("Delay", 50, 100, 0, 500)
         .getValueSettingSub3(" ms")
         .getBooleanSetting("Spacing between the individual shift clicks");
      this.idleOpeningEnum = DepositModule.IdleOpeningEnum.IDLE;
      this.cls7 = new Cls7();
   }

   public boolean isInt4(int var1) {
      if (var1 == 0 || !this.isEnabled55() || this.idleOpeningEnum != DepositModule.IdleOpeningEnum.IDLE) {
         return false;
      } else if (MINECRAFT.thePlayer == null || MINECRAFT.theWorld == null || MINECRAFT.currentScreen != null) {
         return false;
      } else if (this.valueSettingSub9.isEnabled17() && !Util10.isEnabled2()) {
         return false;
      } else {
         MovingObjectPosition var8 = MINECRAFT.objectMouseOver;
         if (MINECRAFT.objectMouseOver == null || var8.typeOfHit != MovingObjectType.BLOCK) {
            return false;
         } else if (!this.isBlockPos11(var8.getBlockPos())) {
            return false;
         } else if (this.valueSettingSub112.isEnum3(DepositModule.HeldHotbarEnum.HELD) && MINECRAFT.thePlayer.getHeldItem() == null) {
            return false;
         } else {
            this.blockPos = var8.getBlockPos();
            this.enumFacing = var8.sideHit;
            this.vec3 = var8.hitVec;
            this.int_ = 0;
            this.idleOpeningEnum = DepositModule.IdleOpeningEnum.OPENING;
            PlayerControllerMP var2 = MINECRAFT.playerController;
            EntityPlayerSP var3 = MINECRAFT.thePlayer;
            WorldClient var4 = MINECRAFT.theWorld;
            ItemStack var5 = MINECRAFT.thePlayer.getHeldItem();
            BlockPos var6 = this.blockPos;
            boolean var7 = var2.onPlayerRightClick(var3, var4, var5, var6, this.enumFacing, this.vec3);
            return true;
         }
      }
   }

   @EventHandler
   private void handleEventSub617(EventSub6 var1) {
      this.run158();
   }

   public static enum HeldHotbarEnum implements DisplayNamed {
      HELD("Held item"),
      HOTBAR("Hotbar");
      private final String string;

      private HeldHotbarEnum(String var3) {
         this.string = var3;
      }

      @Override
      public String getString5() {
         return this.string;
      }

   }

   private static enum IdleOpeningEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      IDLE,
      OPENING,
      DEPOSITING;

   }

   public static enum IronGoldEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      IRON("Iron"),
      GOLD("Gold"),
      DIAMOND("Diamond"),
      EMERALD("Emerald"),
      BLOCKS("Blocks"),
      OTHER("Anything else");

      private final String string;

      @Override
      public String getString5() {
         return this.string;
      }


      private IronGoldEnum(String var3) {
         this.string = var3;
      }
   }
}
