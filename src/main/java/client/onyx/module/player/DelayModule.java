package client.onyx.module.player;

import client.onyx.event.impl.EventSub16;
import client.onyx.event.impl.EventSub2;
import client.onyx.event.impl.EventSub6;
import client.onyx.event.impl.EventSub7;
import client.onyx.interact.DoNotHideHideBothEnum;
import client.onyx.interact.Util;
import client.onyx.interact.placement.InteractedBlockPosPlacedBlockRecord;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.movement.ModeModule;
import client.onyx.module.player.scaffold.ConsiderInventoryBooleanSetting;
import client.onyx.module.player.scaffold.Util2;
import client.onyx.module.player.scaffold.extra.AccelerationSettingGroup;
import client.onyx.module.player.scaffold.extra.AutoBlockSettingGroup;
import client.onyx.module.player.scaffold.extra.ClutchSettingGroup;
import client.onyx.module.player.scaffold.extra.DiagonalSpeedSettingGroup;
import client.onyx.module.player.scaffold.extra.Iface;
import client.onyx.module.player.scaffold.extra.JumpSneakTimeRecord;
import client.onyx.module.player.scaffold.extra.ModeSettingGroup;
import client.onyx.module.player.scaffold.extra.PredictionSettingGroup;
import client.onyx.module.player.scaffold.extra.StrafeSettingGroup;
import client.onyx.module.player.scaffold.mode.BreezilyScaffoldMode;
import client.onyx.module.player.scaffold.mode.ExpandScaffoldMode;
import client.onyx.module.player.scaffold.mode.GodBridgeScaffoldMode;
import client.onyx.module.player.scaffold.mode.HypixelKeepYScaffoldMode;
import client.onyx.module.player.scaffold.mode.HypixelSprintScaffoldMode;
import client.onyx.module.player.scaffold.mode.NormalScaffoldMode;
import client.onyx.module.player.scaffold.mode.ScaffoldMode;
import client.onyx.module.player.scaffold.mode.settings.DownSettingGroup;
import client.onyx.module.player.scaffold.mode.settings.SneakSettingGroup;
import client.onyx.module.player.scaffold.mode.settings.TellySettingGroup;
import client.onyx.module.player.scaffold.watchdog.WatchdogModeOption;
import client.onyx.rotation.Cls;
import client.onyx.rotation.Cls2;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.ModeOption;
import client.onyx.setting.ModeSetting;
import client.onyx.setting.NoneModeOption;
import client.onyx.setting.Setting;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.util.Cls3;
import client.onyx.util.ComparatorImpl;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.NotImportantNormalEnum;
import client.onyx.util.Util10;
import client.onyx.util.Util8;
import client.onyx.util.math.PositionDirectionRecord;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.EnumFacing.Axis;

public class DelayModule extends Module {
   private transient boolean bool2;
   public static final ComparatorImpl<ItemStack> COMPARATOR_IMPL;
   private static final ComparatorImpl<ItemStack> COMPARATOR_IMPL2;
   private transient boolean bool3;
   public StrafeSettingGroup strafeSettingGroup;
   private transient int int_;
   public ConsiderInventoryBooleanSetting considerInventoryBooleanSetting;
   public AutoBlockSettingGroup autoBlockSettingGroup;
   public ModeSetting<ModeOption> modeSetting;
   public ClutchSettingGroup clutchSettingGroup;
   private transient int int_2;
   private transient int int_3;
   public static final DelayModule DELAY_MODULE = new DelayModule();
   public AccelerationSettingGroup accelerationSettingGroup;
   public ValueSettingSub11<DoNotHideHideBothEnum> valueSettingSub112;
   private transient boolean bool4;
   public PredictionSettingGroup predictionSettingGroup;
   private transient ForwardsBackwardsRecord forwardsBackwardsRecord;
   public ValueSettingSub9 valueSettingSub9;
   public ModeSetting<ModeOption> modeSetting2;
   public ValueSettingSub10 valueSettingSub10;
   private transient boolean bool5;
   public ValueSettingSub9 valueSettingSub92;
   public ModeSettingGroup modeSettingGroup;
   public ValueSettingSub9 valueSettingSub93;
   private transient InteractedBlockPosPlacedBlockRecord interactedBlockPosPlacedBlockRecord;
   public ValueSettingSub11<DelayModule.OffOnEnum> valueSettingSub113;
   private transient int int_4;
   private transient Block block;
   private transient int int_5;
   public ValueSettingSub3 valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString2("Delay", 0, 0, 0, 40)
      .getValueSettingSub3(" ticks")
      .getSetting2(Setting.BOOLEAN_SUPPLIER);
   private transient int int_6;
   public DiagonalSpeedSettingGroup diagonalSpeedSettingGroup;
   public ModeSetting<ScaffoldMode> modeSetting3;
   public ValueSettingSub9 valueSettingSub94;
   private transient PositionDirectionRecord positionDirectionRecord;
   private static final int INT = 1;

   private void run153() {
      if (this.isEnabled121()) {
         if (MINECRAFT.thePlayer.onGround) {
            int var6 = new BlockPos(MINECRAFT.thePlayer).getY() - 1;
            this.bool5 = !isEnabled120() && !this.bool4 && var6 == this.int_5 + 1;
            if (!this.bool5) {
               this.int_5 = var6;
            }

            this.bool3 = false;
            this.bool4 = false;
            this.int_3++;
         }

         if (MINECRAFT.gameSettings.keyBindJump.isKeyDown()) {
            this.int_6 = new BlockPos(MINECRAFT.thePlayer).getY();
            this.int_3 = 2;
         }

         InteractedBlockPosPlacedBlockRecord var10 = this.interactedBlockPosPlacedBlockRecord;
         ScaffoldMode var4 = this.getScaffoldMode();
         YawPitchRecord var3 = this.getYawPitchRecord10().getYawPitchRecord();
         MovingObjectPosition var9 = var4.getMovingObjectPosition(var10, var3);
         int var8 = this.valueSettingSub3.getInt4();
         boolean var2 = Util2.isItemStack9(MINECRAFT.thePlayer.inventory.getCurrentItem());
         if (AutoBlockSettingGroup.AUTO_BLOCK_SETTING_GROUP.valueSettingSub92.lambda15()) {
            var2 = this.isBool13(var2);
         }

         if (var10 != null && var9 != null) {
            if (var10.isMovingObjectPosition(var9) && this.isMovingObjectPosition3(var9)) {
               if (!AutoBlockSettingGroup.AUTO_BLOCK_SETTING_GROUP.valueSettingSub92.lambda15()) {
                  var2 = this.isBool13(var2);
               }

               if (var2) {
                  boolean[] var7 = new boolean[]{false};
                  Vec3 var5 = this.positionDirectionRecord != null
                     ? PredictionSettingGroup.PREDICTION_SETTING_GROUP.getVec320(this.positionDirectionRecord)
                     : null;
                  Util.handleMovingObjectPosition2(var9, () -> {
                     this.handleBlockPos5(var10.placedBlock());
                     this.interactedBlockPosPlacedBlockRecord = null;
                     var7[0] = true;
                     return true;
                  }, () -> true, this.valueSettingSub112.lambda15());
                  if (var7[0]) {
                     if (this.isBlockPos10(var10.placedBlock())) {
                        this.bool3 = true;
                     }

                     PredictionSettingGroup.PREDICTION_SETTING_GROUP.handlePositionDirectionRecord(this.positionDirectionRecord, var5);
                     this.int_2 = Math.max(0, var8 - 1);
                  }
               }
            }
         }
      }
   }

   @Override
   protected void run79() {
      this.run154();
      this.run155();
   }

   private List<DelayModule.IndexStackRecord> getList24() {
      ArrayList var1 = new ArrayList(9);
      if (!this.isEnabled121()) {
         return var1;
      } else {
         int var4;
         for (int var10000 = var4 = 0; var10000 <= 8; var10000 = ++var4) {
            ItemStack var3;
            if (Util2.isItemStack9(var3 = MINECRAFT.thePlayer.inventory.getStackInSlot(var4))) {
               DelayModule.IndexStackRecord var5 = new DelayModule.IndexStackRecord(var4, var3);
               boolean var6 = var1.add(var5);
            }
         }

         return var1;
      }
   }

   private Integer getInteger() {
      List<DelayModule.IndexStackRecord> var4 = this.getList24();
      int var2 = AutoBlockSettingGroup.AUTO_BLOCK_SETTING_GROUP.valueSettingSub10.getInt10();
      Comparator<DelayModule.IndexStackRecord> var3 = (var0, var1) -> COMPARATOR_IMPL2.compare(var0.stack(), var1.stack());
      DelayModule.IndexStackRecord var5;
      return (
               var5 = var4.stream()
                  .filter(var1 -> var1.stack().stackSize > var2)
                  .max(var3)
                  .orElseGet(() -> (DelayModule.IndexStackRecord)var4.stream().max(var3).orElse(null))
            )
            != null
         ? var5.index()
         : null;
   }

   private static BlockPos getBlockPosForBlockPos2(BlockPos var0, int var1) {
      return new BlockPos(var0.getX(), var1, var0.getZ());
   }

   @EventHandler
   private void handleEventSub616(EventSub6 var1) {
      this.run155();
      this.bool2 = false;
      if (this.valueSettingSub94.isEnabled17()) {
         this.run156();
      }
   }

   private void handleBlockPos5(BlockPos var1) {
      if (!this.isBlockPos10(var1)) {
         client.onyx.module.player.scaffold.Util.handleBlockPos6(var1);
      }

      SneakSettingGroup.SNEAK_SETTING_GROUP.run164();
      ModeSettingGroup.MODE_SETTING_GROUP.run167();
      HypixelKeepYScaffoldMode.HYPIXEL_KEEP_Y_SCAFFOLD_MODE.run162();
   }

   private static boolean isEnabled120() {
      return MINECRAFT.gameSettings.keyBindJump.isKeyDown();
   }

   private void run155() {
      this.int_2 = 0;
      client.onyx.module.player.scaffold.Util.run160();
      PredictionSettingGroup.PREDICTION_SETTING_GROUP.run168();
      Cls3.CLS3.handleObject4(this);
      this.block = null;
      this.int_4 = 0;
      this.interactedBlockPosPlacedBlockRecord = null;
      this.bool3 = false;
      this.bool5 = false;
      this.bool4 = false;
   }

   private boolean isEnabled118() {
      if (!TellySettingGroup.TELLY_SETTING_GROUP.isEnabled5() || this.bool3 || this.bool5) {
         return false;
      } else {
         return client.onyx.util.Util2.isEntityPlayerSP(MINECRAFT.thePlayer) && !MINECRAFT.thePlayer.onGround
            ? MINECRAFT.thePlayer.motionY <= 0.0 && MINECRAFT.thePlayer.posY >= this.int_5 + 2.0
            : false;
      }
   }

   private ScaffoldMode getScaffoldMode() {
      return this.modeSetting3.getModeOption();
   }

   private BlockPos getBlockPos9() {
      if (!this.isEnabled118()) {
         return null;
      } else {
         BlockPos var2;
         return (var2 = client.onyx.module.player.scaffold.Util.getBlockPos12()) != null && var2.getY() == this.int_5 ? var2.up() : null;
      }
   }

   @EventHandler
   private void handleEventSub7(EventSub7 var1) {
      if (this.isEnabled121()) {
         ItemStack var2;
         Integer var11;
         DelayModule var10000;
         if ((var11 = this.getInteger()) == null) {
            var10000 = this;
            this.block = null;
            var2 = new ItemStack(Blocks.sandstone, 64);
         } else {
            var2 = MINECRAFT.thePlayer.inventory.getStackInSlot(var11);
            var10000 = this;
            this.block = Util10.getBlockForItemStack2(var2);
         }

         PositionDirectionRecord var12 = var10000.positionDirectionRecord;
         Vec3 var3;
         if ((var3 = PredictionSettingGroup.PREDICTION_SETTING_GROUP.getVec322(var12)) == null) {
            var3 = client.onyx.util.Util2.getVec3ForEntity2(MINECRAFT.thePlayer);
         }

         boolean var4 = SneakSettingGroup.SNEAK_SETTING_GROUP.isEnabled5()
            && SneakSettingGroup.SNEAK_SETTING_GROUP
               .isForwardsBackwardsRecord(client.onyx.util.Util2.getForwardsBackwardsRecordForEntityPlayerSP(MINECRAFT.thePlayer));
         ScaffoldMode var5;
         this.interactedBlockPosPlacedBlockRecord = (var5 = this.getScaffoldMode()).getInteractedBlockPosPlacedBlockRecord(var3, var4, var12, var2);
         YawPitchRecord var13;
         if ((var13 = var5.getYawPitchRecord16(this.interactedBlockPosPlacedBlockRecord)) != null) {
            ConsiderInventoryBooleanSetting var6 = this.considerInventoryBooleanSetting;
            boolean var9 = this.considerInventoryBooleanSetting.valueSettingSub92.lambda15();
            Cls2 var14 = var5.getCls213(var13, var6, var9);
            Cls.CLS
               .handleCls24(
                  this.considerInventoryBooleanSetting.getCls212(ClutchSettingGroup.CLUTCH_SETTING_GROUP.getCls214(var14)),
                  NotImportantNormalEnum.IMPORTANT_FOR_PLAYER_LIFE,
                  this
               );
         }
      }
   }

   public int getInt48() {
      if (!this.isEnabled121()) {
         return 0;
      } else {
         int var4 = 0;
         Iterator var2;
         if (AutoBlockSettingGroup.AUTO_BLOCK_SETTING_GROUP.isEnabled5()) {
            for (Iterator var10000 = var2 = this.getList24().iterator(); var10000.hasNext(); var10000 = var2) {
               DelayModule.IndexStackRecord var3 = (DelayModule.IndexStackRecord)var2.next();
               var4 += getIntForItemStack(var3.stack());
            }
         } else {
            var4 += getIntForItemStack(MINECRAFT.thePlayer.inventory.getCurrentItem());
         }

         return var4;
      }
   }

   private DelayModule() {
      super("Scaffold", "Places blocks under you", ModuleCategory.PLAYER);
      this.valueSettingSub10 = new ValueSettingSub10("Min distance", 0.0, 0.0, 0.25, 0.01).getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.autoBlockSettingGroup = AutoBlockSettingGroup.AUTO_BLOCK_SETTING_GROUP;
      this.predictionSettingGroup = PredictionSettingGroup.PREDICTION_SETTING_GROUP;
      NormalScaffoldMode var10004 = NormalScaffoldMode.NORMAL_SCAFFOLD_MODE;
      ScaffoldMode[] var10005 = new ScaffoldMode[6];
      boolean var10007 = true;
      var10005[0] = NormalScaffoldMode.NORMAL_SCAFFOLD_MODE;
      var10005[1] = ExpandScaffoldMode.EXPAND_SCAFFOLD_MODE;
      var10005[2] = GodBridgeScaffoldMode.GOD_BRIDGE_SCAFFOLD_MODE;
      var10005[3] = BreezilyScaffoldMode.BREEZILY_SCAFFOLD_MODE;
      var10005[4] = HypixelKeepYScaffoldMode.HYPIXEL_KEEP_Y_SCAFFOLD_MODE;
      var10005[5] = HypixelSprintScaffoldMode.HYPIXEL_SPRINT_SCAFFOLD_MODE;
      this.modeSetting3 = new ModeSetting<>("Technique", var10004, var10005);
      this.valueSettingSub113 = new ValueSettingSub11<>("Same Y", DelayModule.OffOnEnum.OFF);
      this.valueSettingSub9 = new ValueSettingSub9("Space climb", false)
         .getBooleanSetting("Climb up normally while the jump key is held")
         .getModeSetting2(this.valueSettingSub113, var0 -> var0 == DelayModule.OffOnEnum.ON);
      this.modeSetting = getModeSetting5();
      this.modeSetting2 = ModeModule.getModeSettingForString("Safe walk");
      this.valueSettingSub112 = new ValueSettingSub11<>("Swing", DoNotHideHideBothEnum.DO_NOT_HIDE);
      this.considerInventoryBooleanSetting = new ConsiderInventoryBooleanSetting();
      this.modeSettingGroup = ModeSettingGroup.MODE_SETTING_GROUP;
      this.accelerationSettingGroup = AccelerationSettingGroup.ACCELERATION_SETTING_GROUP;
      this.strafeSettingGroup = StrafeSettingGroup.STRAFE_SETTING_GROUP;
      this.diagonalSpeedSettingGroup = DiagonalSpeedSettingGroup.DIAGONAL_SPEED_SETTING_GROUP;
      this.clutchSettingGroup = ClutchSettingGroup.CLUTCH_SETTING_GROUP;
      this.valueSettingSub93 = new ValueSettingSub9("Edge safety", true)
         .getBooleanSetting("Waits at the edge until the aim is on the block, instead of walking off");
      this.valueSettingSub94 = new ValueSettingSub9("Auto F5", false)
         .getBooleanSetting("Drops into third person behind you while scaffolding, and puts the camera back after")
         .getModeSetting3(var1 -> {
            if (this.isEnabled55()) {
               if (var1) {
                  this.run156();
               } else {
                  this.run154();
               }
            }
         });
      this.valueSettingSub92 = new ValueSettingSub9("Disable on death", true)
         .getBooleanSetting("Turns Scaffold off when you die, so you do not respawn still bridging");
      this.forwardsBackwardsRecord = ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8;
   }

   public ForwardsBackwardsRecord getForwardsBackwardsRecord2() {
      return this.forwardsBackwardsRecord;
   }

   private static ModeSetting<ModeOption> getModeSetting5() {
      NoneModeOption var0 = new NoneModeOption();
      ModeOption[] var10004 = new ModeOption[2];
      boolean var10006 = true;
      var10004[0] = var0;
      var10004[1] = WatchdogModeOption.WATCHDOG_MODE_OPTION;
      return new ModeSetting<>("Tower", var0, var10004).getBooleanSetting("Vertical bridging while you hold jump standing still");
   }

   public void run152() {
      if (this.isEnabled55() && this.valueSettingSub92.isEnabled17()) {
         this.handleBool16(false);
      }
   }

   public boolean isMovingObjectPosition3(MovingObjectPosition var1) {
      if (var1 != null && var1.hitVec != null) {
         Vec3 var5 = var1.hitVec.subtract(MINECRAFT.thePlayer.getPositionEyes(1.0F));
         EnumFacing var2;
         if ((var2 = var1.sideHit) != null && var2.getAxis() != Axis.Y) {
            double var3 = var2 != EnumFacing.NORTH && var2 != EnumFacing.SOUTH ? var5.xCoord : var5.zCoord;
            if (Math.abs(var3) < this.valueSettingSub10.getFloat5()) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private boolean isEnabled121() {
      return MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null && MINECRAFT.playerController != null;
   }

   private boolean isBlockPos10(BlockPos var1) {
      return this.valueSettingSub113.lambda15() == DelayModule.OffOnEnum.HYPIXEL2 && var1.getY() == this.int_5 + 1;
   }

   private YawPitchRecord getYawPitchRecord10() {
      YawPitchRecord var2;
      return (var2 = Cls.CLS.getYawPitchRecord()) != null ? var2 : client.onyx.util.Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer);
   }

   public boolean isEnabled119() {
      return !this.isEnabled121() ? false : this.isBool13(Util2.isItemStack9(MINECRAFT.thePlayer.inventory.getCurrentItem()));
   }

   private boolean isBool13(boolean var1) {
      if (AutoBlockSettingGroup.AUTO_BLOCK_SETTING_GROUP.isEnabled5() && !var1) {
         Integer var2;
         if ((var2 = this.getInteger()) != null) {
            Cls3.CLS3.isObject2(this, var2, AutoBlockSettingGroup.AUTO_BLOCK_SETTING_GROUP.valueSettingSub102.getInt10());
            return true;
         } else {
            Cls3.CLS3.handleObject4(this);
            return var1;
         }
      } else {
         Cls3.CLS3.handleObject4(this);
         return var1;
      }
   }

   @Override
   protected void run80() {
      if (this.valueSettingSub94.isEnabled17()) {
         this.run156();
      }

      if (MINECRAFT.thePlayer != null) {
         this.int_5 = new BlockPos(MINECRAFT.thePlayer).getY() - 1;
         this.int_6 = new BlockPos(MINECRAFT.thePlayer).getY();
         this.int_3 = 2;
         client.onyx.module.player.scaffold.Util.run160();
      }
   }

   private void run156() {
      if (!this.bool2) {
         this.int_ = MINECRAFT.gameSettings.thirdPersonView;
         MINECRAFT.gameSettings.thirdPersonView = 1;
         this.bool2 = true;
      }
   }

   @EventHandler
   private void handleEventSub25(EventSub2 var1) {
      if (!this.isEnabled121()) {
         this.int_2 = 0;
      } else {
         if (!MINECRAFT.thePlayer.onGround && isEnabled120()) {
            this.bool4 = true;
         }

         if (this.int_2 > 0) {
            int var3 = this.int_2 - 1;
            this.int_2 = var3;
         } else {
            this.run153();
         }
      }
   }

   @EventHandler(
      priority = -50
   )
   private void handleEventSub167(EventSub16 var1) {
      if (this.isEnabled121()) {
         if (this.int_4 > 0) {
            var1.handleBool4(true);
            this.int_4--;
         }

         if (this.valueSettingSub93.lambda15()) {
            ScaffoldMode var4 = this.getScaffoldMode();
            YawPitchRecord var3;
            if ((var3 = Cls.CLS.getYawPitchRecord()) == null) {
               var3 = client.onyx.util.Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer);
            }

            JumpSneakTimeRecord var5;
            if ((var5 = client.onyx.module.player.scaffold.extra.Util.getJumpSneakTimeRecordForInteractedBlockPosPlacedBlockRecord(
                  this.interactedBlockPosPlacedBlockRecord, var3, var4 instanceof Iface ? (Iface)var4 : null
               ))
               .jump()) {
               var1.handleBool3(true);
            }

            if (var5.stopInput()) {
               var1.handleForwardsBackwardsRecord(ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8);
            }

            if (var5.stepBack()) {
               var1.handleForwardsBackwardsRecord(
                  new ForwardsBackwardsRecord(false, true, var1.getForwardsBackwardsRecord2().left(), var1.getForwardsBackwardsRecord2().right())
               );
            }

            if (var5.sneakTime() > this.int_4) {
               var1.handleBool4(true);
               this.int_4 = var5.sneakTime();
            }
         }
      }
   }

   private void run154() {
      if (this.bool2) {
         this.bool2 = false;
         if (MINECRAFT.gameSettings.thirdPersonView == 1) {
            MINECRAFT.gameSettings.thirdPersonView = this.int_;
         }
      }
   }

   private BlockPos getBlockPos11(BlockPos var1) {
      switch ((DelayModule.OffOnEnum)this.valueSettingSub113.lambda15()) {
         case OFF:

            return null;
         case ON:
            if (!this.valueSettingSub9.lambda15() || !isEnabled120() && !this.bool4) {
               return getBlockPosForBlockPos2(var1, this.int_5);
            }

            return null;
         case FALLING:
            if (MINECRAFT.thePlayer.motionY < 0.2) {
               return getBlockPosForBlockPos2(var1, this.int_5);
            }

            return null;
         case HYPIXEL:
            if (MINECRAFT.thePlayer.motionY == -0.15233518685055708 && this.int_3 >= 2) {
               this.int_3 = 0;
               return getBlockPosForBlockPos2(var1, this.int_6);
            }

            return getBlockPosForBlockPos2(var1, this.int_6 - 1);
         case HYPIXEL2:
            if (!isEnabled120() && !this.bool4) {
               BlockPos var2;
               if ((var2 = this.getBlockPos9()) != null) {
                  return var2;
               }

               return getBlockPosForBlockPos2(var1, this.int_5);
            }

            return null;
         default:
            throw new MatchException(null, null);
      }
   }

   static {
      Comparator[] var10002 = new Comparator[7];
      boolean var10004 = true;
      var10002[0] = Util8.COMPARATOR4;
      var10002[1] = Util8.COMPARATOR3;
      var10002[2] = Util8.COMPARATOR5;
      var10002[3] = Util8.COMPARATOR;
      var10002[4] = Util8.getComparatorForBool(true);
      var10002[5] = Util8.COMPARATOR2;
      var10002[6] = Util8.getComparatorForBool(false);
      COMPARATOR_IMPL2 = new ComparatorImpl<>(var10002);
      var10002 = new Comparator[7];
      var10004 = true;
      var10002[0] = Util8.COMPARATOR4;
      var10002[1] = Util8.COMPARATOR3;
      var10002[2] = Util8.COMPARATOR5;
      var10002[3] = Util8.COMPARATOR;
      var10002[4] = Util8.getComparatorForBool(true);
      var10002[5] = Util8.COMPARATOR6;
      var10002[6] = Util8.getComparatorForBool(false);
      COMPARATOR_IMPL = new ComparatorImpl<>(var10002);
   }

   public BlockPos getBlockPos10(BlockPos var1) {
      if (DownSettingGroup.DOWN_SETTING_GROUP.isEnabled136() && DownSettingGroup.isEnabled132()) {
         return var1.add(0, -2, 0);
      } else {
         BlockPos var2;
         if (this.valueSettingSub113.lambda15() == DelayModule.OffOnEnum.HYPIXEL2 && (var2 = this.getBlockPos11(var1)) != null) {
            return var2;
         } else if (!MINECRAFT.thePlayer.movementInput.jump
            || client.onyx.util.Util2.isEntityPlayerSP(MINECRAFT.thePlayer) && !MINECRAFT.thePlayer.isCollidedHorizontally) {
            return (var2 = this.getBlockPos11(var1)) != null ? var2 : var1.add(0, -1, 0);
         } else {
            return var1.add(0, -1, 0);
         }
      }
   }

   @EventHandler(
      priority = -10
   )
   private void handleEventSub166(EventSub16 var1) {
      if (this.isEnabled121()) {
         this.positionDirectionRecord = null;
         this.forwardsBackwardsRecord = var1.getForwardsBackwardsRecord2();
         if (!var1.getForwardsBackwardsRecord2().equals(ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8)) {
            this.positionDirectionRecord = client.onyx.module.player.scaffold.Util.getPositionDirectionRecordForForwardsBackwardsRecord(
               var1.getForwardsBackwardsRecord2()
            );
         }
      }
   }

   public PositionDirectionRecord getPositionDirectionRecord2() {
      return this.positionDirectionRecord;
   }

   private static int getIntForItemStack(ItemStack var0) {
      return Util2.isItemStack9(var0) ? var0.stackSize : 0;
   }

   private record IndexStackRecord(int index, ItemStack stack) {
   }

   public static enum OffOnEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      OFF("Off"),
      ON("On"),
      FALLING("Falling"),
      HYPIXEL("Hypixel"),
      HYPIXEL2("Hypixel2");
      private final String string;


      @Override
      public String getString5() {
         return this.string;
      }

      private OffOnEnum(String var3) {
         this.string = var3;
      }
   }
}
