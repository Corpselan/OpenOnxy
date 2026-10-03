package client.onyx.module.player.scaffold.mode;

import client.onyx.event.impl.EventSub16;
import client.onyx.event.impl.EventSub2;
import client.onyx.event.impl.EventSub4;
import client.onyx.interact.placement.Cls;
import client.onyx.interact.placement.Cls3;
import client.onyx.interact.placement.Cls4;
import client.onyx.interact.placement.HitVecStrategySub2;
import client.onyx.interact.placement.InteractedBlockPosPlacedBlockRecord;
import client.onyx.interact.placement.NoOffsetNormalEnum;
import client.onyx.interact.placement.Util;
import client.onyx.module.player.DelayModule;
import client.onyx.module.player.scaffold.ConsiderInventoryBooleanSetting;
import client.onyx.rotation.Cls2;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.mode.api.Iface;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.Setting;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.Util11;
import client.onyx.util.Util2;
import client.onyx.util.Util6;
import client.onyx.util.math.PositionDirectionRecord;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class HypixelKeepYScaffoldMode extends ScaffoldMode {
   private static final float FLOAT = 99.0F;
   private transient boolean bool2;
   private transient boolean bool3;
   private transient int int_3;
   public ValueSettingSub9 valueSettingSub92;
   public ValueSettingSub10 valueSettingSub10;
   public static final HypixelKeepYScaffoldMode HYPIXEL_KEEP_Y_SCAFFOLD_MODE = new HypixelKeepYScaffoldMode();
   private final transient Iface iface;
   private static final float FLOAT2 = 84.0F;
   private transient int int_4;
   private transient int int_5;
   public ValueSettingSub10 valueSettingSub102;
   public ValueSettingSub9 valueSettingSub93;
   private transient boolean bool4;
   public ValueSettingSub9 valueSettingSub94;
   private static final long LONG = 500L;
   private transient long long_;
   private static final float FLOAT3 = 39.0F;
   public ValueSettingSub10 valueSettingSub103;
   public ValueSettingSub10 valueSettingSub104;
   private transient float float_;
   public ValueSettingSub10 valueSettingSub105;
   private transient boolean bool5;
   public ValueSettingSub10 valueSettingSub106;
   private static final double DOUBLE = 4.0;
   public ValueSettingSub11<HypixelKeepYScaffoldMode.DiagonalBackEnum> valueSettingSub11 = new ValueSettingSub11<>(
         "Rotation style", HypixelKeepYScaffoldMode.DiagonalBackEnum.DIAGONAL
      )
      .getBooleanSetting("Where the aim sits on the block face; falls back to Normal while moving diagonally")
      .getSetting2(Setting.BOOLEAN_SUPPLIER);

   @EventHandler
   private void handleEventSub4(EventSub4 var1) {
      this.bool5 = false;
   }

   private YawPitchRecord getYawPitchRecord11() {
      BlockPos var3 = new BlockPos(MINECRAFT.thePlayer.posX, MINECRAFT.thePlayer.posY - 1.0, MINECRAFT.thePlayer.posZ);
      YawPitchRecord var2 = YawPitchRecord.getYawPitchRecordForVec32(
         new Vec3(var3.getX() + 0.5, var3.getY() + 1.0, var3.getZ() + 0.5), MINECRAFT.thePlayer.getPositionEyes(1.0F)
      );
      return this.getYawPitchRecord12(var3, EnumFacing.UP, var2, true);
   }

   private int getInt51() {
      return this.isBool14(false) ? this.valueSettingSub10.getInt10() : this.valueSettingSub103.getInt10();
   }

   private YawPitchRecord getYawPitchRecord12(BlockPos var1, EnumFacing var2, YawPitchRecord var3, boolean var4) {
      float var5 = var3.pitch2();
      float var12 = this.getFloat92();
      switch (this.getDiagonalBackEnum()) {
         case NORMAL:

            boolean var15 = this.isBlockPos12(var1, var2, var12 - 135.0F, var5) || this.isBlockPos12(var1, var2, var12 + 135.0F, var5);
            boolean var17 = this.isBlockPos12(var1, var2, var12 - 180.0F, var5);
            float var9;
            if (!var4 && !var15 && !var17) {
               var9 = var3.yaw2();
            } else if (!var4 && this.isBool14(true)) {
               var9 = var17 ? var12 - 180.0F : var3.yaw2();
            } else if (!var4 && !var15) {
               var9 = var12 - 180.0F;
            } else {
               BlockPos var18 = new BlockPos(
                  Math.floor(MINECRAFT.thePlayer.posX), Math.floor(MINECRAFT.thePlayer.posY) - 1.0, Math.floor(MINECRAFT.thePlayer.posZ)
               );
               double var10 = var18.getX() + 0.5 - MINECRAFT.thePlayer.posX;
               if (MathHelper.wrapAngleTo180_float((float)(Math.toDegrees(Math.atan2(var18.getZ() + 0.5 - MINECRAFT.thePlayer.posZ, var10)) - 90.0) - var12)
                  > 0.0F) {
                  var9 = var12 + 135.0F;
                  if (this.valueSettingSub94.lambda15() && !this.isBlockPos12(var1, var2, var9, var5)) {
                     var9 = var12 - 135.0F;
                  }
               } else {
                  var9 = var12 - 135.0F;
                  if (this.valueSettingSub94.lambda15() && !this.isBlockPos12(var1, var2, var9, var5)) {
                     var9 = var12 + 135.0F;
                  }
               }
            }

            return new YawPitchRecord(var9, var5);
         case DIAGONAL:
            if (var4) {
               return new YawPitchRecord(var12 - 180.0F, var5);
            }

            boolean var14 = this.isBlockPos12(var1, var2, var12 - 135.0F, var5) || this.isBlockPos12(var1, var2, var12 + 135.0F, var5);
            boolean var16 = !this.isBlockPos12(var1, var2, var12 - 180.0F, var5) && (this.valueSettingSub94.lambda15() || !var14);
            float var10002;
            float var10003;
            if (var16) {
               var10002 = var3.yaw2();
               var10003 = var5;
            } else {
               var10002 = var12 - 180.0F;
               var10003 = var5;
            }

            YawPitchRecord var10000 = new YawPitchRecord(var10002, var10003);
            return var10000;
         case OFFSET:
            float var7 = var3.yaw2();
            if (this.isBlockPos12(var1, var2, var12 - 180.0F, var5)) {
               var7 = var12 - 180.0F;
            } else if (this.isBlockPos12(var1, var2, var12 - 135.0F, var5)) {
               var7 = var12 - 135.0F;
            } else if (this.isBlockPos12(var1, var2, var12 + 135.0F, var5)) {
               var7 = var12 + 135.0F;
            }

            return new YawPitchRecord(var7, var5);
         case BACK:
            YawPitchRecord var8 = YawPitchRecord.getYawPitchRecordForVec32(this.getVec318(var1, var2), MINECRAFT.thePlayer.getPositionEyes(1.0F));
            if (this.valueSettingSub94.lambda15() && !this.isBlockPos12(var1, var2, var8.yaw2(), var8.pitch2())) {
               return new YawPitchRecord(var3.yaw2(), var8.pitch2());
            }

            return var8;
         default:
            throw new MatchException(null, null);
      }
   }

   private boolean isBool14(boolean var1) {
      float var3;
      if ((var3 = this.getFloat92() % 360.0F) < 0.0F) {
         var3 += 360.0F;
      }

      float var4;
      return (var4 = var3 % 90.0F) > (var1 ? 10.0F : 20.0F) && var4 < (var1 ? 80.0F : 70.0F);
   }

   private long getLong4() {
      if (MINECRAFT.getNetHandler() == null) {
         return 0L;
      } else {
         NetworkPlayerInfo var2;
         return (var2 = MINECRAFT.getNetHandler().getPlayerInfo(MINECRAFT.thePlayer.getUniqueID())) == null ? 0L : Math.max(0, var2.getResponseTime());
      }
   }

   private HypixelKeepYScaffoldMode() {
      super("HypixelKeepY");
      this.valueSettingSub106 = new ValueSettingSub10("Rotation offset", 0.15, 0.0, 1.0, 0.01)
         .getBooleanSetting("Shifts the aim point from the face centre towards the player")
         .getSetting2(() -> this.valueSettingSub11.isEnum3(HypixelKeepYScaffoldMode.DiagonalBackEnum.OFFSET));
      this.valueSettingSub92 = new ValueSettingSub9("Aim check", true)
         .getBooleanSetting("Only place once the crosshair raytrace actually lands on the target block")
         .getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub94 = new ValueSettingSub9("Strict aim check", true)
         .getBooleanSetting("Require the raytrace to hit the exact face, not just the block")
         .getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub103 = new ValueSettingSub10("Straight jump blocks", 0.0, 0.0, 3.0, 1.0)
         .getBooleanSetting("Blocks laid on the ground before jumping while bridging straight")
         .getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub10 = new ValueSettingSub10("Diagonal jump blocks", 0.0, 0.0, 3.0, 1.0)
         .getBooleanSetting("Blocks laid on the ground before jumping while bridging diagonally")
         .getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub105 = new ValueSettingSub10("Straight air delay", 1.0, 0.0, 4.0, 1.0)
         .getValueSettingSub10(" ticks")
         .getBooleanSetting("Ticks to wait after the target appears in the arc before placing (straight)")
         .getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub102 = new ValueSettingSub10("Diagonal air delay", 1.0, 0.0, 4.0, 1.0)
         .getValueSettingSub10(" ticks")
         .getBooleanSetting("Ticks to wait after the target appears in the arc before placing (diagonal)")
         .getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub93 = new ValueSettingSub9("Keep Y on right click", false)
         .getBooleanSetting("Only pin the Y level while the use key is held")
         .getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub104 = new ValueSettingSub10("Idle aim speed", 100.0, 1.0, 180.0, 1.0)
         .getValueSettingSub10("°/t")
         .getBooleanSetting("How fast the aim turns back under your feet once you stop placing");
      this.float_ = 99.0F;
      this.iface = (var1, var2, var3) -> var2.getYawPitchRecord4(var3, this.float_, 39.0F);
   }

   @Override
   public Cls2 getCls213(YawPitchRecord var1, ConsiderInventoryBooleanSetting var2, boolean var3) {
      Cls2 var4 = var2.getCls210(var1, var3);
      return new Cls2(var1, null, List.of(this.iface), var4.getInt21(), var4.getFloat27(), var3, var4.getOffStrictEnum2(), null);
   }

   public void run162() {
      if (this.isEnabled8() && MINECRAFT.thePlayer != null) {
         if (MINECRAFT.thePlayer.onGround) {
            this.int_3++;
         } else {
            this.int_3 = 0;
         }
      }
   }

   @Override
   public InteractedBlockPosPlacedBlockRecord getInteractedBlockPosPlacedBlockRecord(Vec3 var1, boolean var2, PositionDirectionRecord var3, ItemStack var4) {
      BlockPos var5 = Util6.getBlockPosForVec3(var1);
      BlockPos var6;
      if (this.isEnabled128()) {
         if (this.int_5 > MINECRAFT.thePlayer.posY - 1.0) {
            return null;
         }

         var6 = new BlockPos(var5.getX(), this.int_5, var5.getZ());
      } else {
         var6 = DelayModule.DELAY_MODULE.getBlockPos10(var5);
      }

      Cls var7 = new Cls(
         new client.onyx.interact.placement.Cls2(NoOffsetNormalEnum.NORMAL.getList(), this.getComparator5(var1, var3)),
         new Cls3(HitVecStrategySub2.HIT_VEC_STRATEGY_SUB2),
         var4,
         new Cls4(var1, var2)
      );
      InteractedBlockPosPlacedBlockRecord var8;
      if ((var8 = Util.getInteractedBlockPosPlacedBlockRecordForBlockPos(var6, var7)) != null && !this.bool5) {
         this.bool3 = this.bool5 = true;
         this.int_4 = 0;
      }

      return var8;
   }

   @EventHandler(
      priority = 1000
   )
   private void handleEventSub26(EventSub2 var1) {
      if (MINECRAFT.thePlayer != null) {
         this.run161();
         if (this.bool3) {
            int var3 = this.int_4 + 1;
            this.int_4 = var3;
         }
      }
   }

   @Override
   public MovingObjectPosition getMovingObjectPosition(InteractedBlockPosPlacedBlockRecord var1, YawPitchRecord var2) {
      if (var1 == null) {
         return null;
      } else if (this.isEnabled128() && this.int_4 < this.getInt52() && this.int_3 >= this.getInt51()) {
         return null;
      } else {
         this.bool3 = false;
         this.long_ = System.currentTimeMillis();
         MovingObjectPosition var3;
         if ((var3 = super.getMovingObjectPosition(var1, var2)) != null && var1.isMovingObjectPosition(var3)) {
            return var3;
         } else if (!this.valueSettingSub92.lambda15()) {
            return var1.getMovingObjectPosition();
         } else {
            return !this.valueSettingSub94.lambda15()
                  && var3 != null
                  && var3.typeOfHit == MovingObjectType.BLOCK
                  && var3.getBlockPos().equals(var1.interactedBlockPos())
               ? var1.getMovingObjectPosition()
               : null;
         }
      }
   }

   private Vec3 getVec318(BlockPos var1, EnumFacing var2) {
      Vec3 var13 = new Vec3(
         var1.getX() + 0.5 + var2.getFrontOffsetX() * 0.5, var1.getY() + 0.5 + var2.getFrontOffsetY() * 0.5, var1.getZ() + 0.5 + var2.getFrontOffsetZ() * 0.5
      );
      Vec3 var4 = MINECRAFT.thePlayer.getPositionEyes(1.0F);
      double var5 = var2.getFrontOffsetX() != 0 ? var13.xCoord : MathHelper.clamp_double(var4.xCoord, var1.getX(), var1.getX() + 1.0);
      double var7 = var2.getFrontOffsetY() != 0 ? var13.yCoord : MathHelper.clamp_double(var4.yCoord, var1.getY(), var1.getY() + 1.0);
      double var9 = var2.getFrontOffsetZ() != 0 ? var13.zCoord : MathHelper.clamp_double(var4.zCoord, var1.getZ(), var1.getZ() + 1.0);
      double var11 = this.valueSettingSub106.lambda15();
      return new Vec3(var13.xCoord + (var5 - var13.xCoord) * var11, var13.yCoord + (var7 - var13.yCoord) * var11, var13.zCoord + (var9 - var13.zCoord) * var11);
   }

   @Override
   protected void run3() {
      if (MINECRAFT.thePlayer != null) {
         this.int_5 = MathHelper.floor_double(MINECRAFT.thePlayer.posY) - 1;
         this.bool4 = false;
         this.int_3 = 0;
         this.bool5 = false;
         this.bool3 = !MINECRAFT.thePlayer.onGround;
         this.int_4 = this.bool3 ? -1 : 0;
         this.bool2 = false;
         this.long_ = System.currentTimeMillis() - 600L;
      }
   }

   @EventHandler
   private void handleEventSub168(EventSub16 var1) {
      if (MINECRAFT.thePlayer != null && MINECRAFT.currentScreen == null) {
         if (this.isEnabled128()) {
            if (var1.getForwardsBackwardsRecord2().isEnabled()) {
               if (MINECRAFT.thePlayer.onGround) {
                  if (DelayModule.DELAY_MODULE.getInt48() > 0) {
                     if (this.int_3 >= this.getInt51()) {
                        var1.handleBool3(true);
                     }
                  }
               }
            }
         }
      }
   }

   private boolean isEnabled128() {
      return MINECRAFT.thePlayer.isPotionActive(Potion.jump) ? false : !this.valueSettingSub93.lambda15() || MINECRAFT.gameSettings.keyBindUseItem.isKeyDown();
   }

   private boolean isBlockPos12(BlockPos var1, EnumFacing var2, float var3, float var4) {
      MovingObjectPosition var5;
      if ((var5 = Util11.getMovingObjectPositionForYawPitchRecord2(new YawPitchRecord(var3, var4), 4.0)) != null && var5.typeOfHit == MovingObjectType.BLOCK) {
         return !var5.getBlockPos().equals(var1) ? false : !this.valueSettingSub94.lambda15() || var5.sideHit == var2;
      } else {
         return false;
      }
   }

   private HypixelKeepYScaffoldMode.DiagonalBackEnum getDiagonalBackEnum() {
      return this.isBool14(false) ? HypixelKeepYScaffoldMode.DiagonalBackEnum.NORMAL : this.valueSettingSub11.lambda15();
   }

   private int getInt52() {
      return this.isBool14(false) ? this.valueSettingSub102.getInt10() : this.valueSettingSub105.getInt10();
   }

   private float getFloat92() {
      ForwardsBackwardsRecord var2;
      return (var2 = DelayModule.DELAY_MODULE.getForwardsBackwardsRecord2()) != null && var2.isEnabled()
         ? Util2.getFloatForEntityPlayerSP4(MINECRAFT.thePlayer, var2)
         : MINECRAFT.thePlayer.rotationYaw;
   }

   @Override
   public YawPitchRecord getYawPitchRecord16(InteractedBlockPosPlacedBlockRecord var1) {
      if (MINECRAFT.thePlayer == null) {
         return null;
      } else {
         if (MINECRAFT.thePlayer.onGround) {
            this.bool2 = false;
         }

         if (System.currentTimeMillis() - this.long_ > this.getLong4() + 500L && DelayModule.DELAY_MODULE.getInt48() > 0) {
            this.float_ = this.valueSettingSub104.getFloat5();
            return this.getYawPitchRecord11();
         } else if (var1 == null) {
            return client.onyx.rotation.Cls.CLS.getYawPitchRecord();
         } else {
            boolean var3 = this.isEnabled128();
            boolean var10000;
            if (this.bool2) {
               var10000 = var3;
               this.float_ = 39.0F;
            } else if (var3) {
               this.float_ = (float)ThreadLocalRandom.current().nextDouble(84.0, 99.0);
               var10000 = var3;
            } else {
               this.float_ = this.valueSettingSub104.getFloat5();
               var10000 = var3;
            }

            if (var10000 && !MINECRAFT.thePlayer.onGround) {
               this.bool2 = true;
            }

            return this.getYawPitchRecord12(var1.interactedBlockPos(), var1.direction(), var1.rotation(), false);
         }
      }
   }

   private void run161() {
      int var2 = MathHelper.floor_double(MINECRAFT.thePlayer.posY) - 1;
      if (!this.isEnabled128()) {
         this.int_5 = var2;
         this.bool4 = false;
      } else if (MINECRAFT.gameSettings.keyBindJump.isKeyDown()) {
         this.int_5 = var2;
         this.bool4 = true;
      } else {
         if (this.bool4 || MINECRAFT.thePlayer.onGround) {
            this.int_5 = var2;
            this.bool4 = false;
         }
      }
   }

   public static enum DiagonalBackEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      DIAGONAL("Diagonal"),
      BACK("Back"),
      NORMAL("Normal"),
      OFFSET("Offset");
      private final String string;


      @Override
      public String getString5() {
         return this.string;
      }

      private DiagonalBackEnum(String var3) {
         this.string = var3;
      }
   }
}
