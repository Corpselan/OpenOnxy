package client.onyx.module.player.scaffold.mode;

import client.onyx.interact.placement.Cls;
import client.onyx.interact.placement.Cls2;
import client.onyx.interact.placement.Cls3;
import client.onyx.interact.placement.Cls4;
import client.onyx.interact.placement.HitVecStrategySub2;
import client.onyx.interact.placement.InteractedBlockPosPlacedBlockRecord;
import client.onyx.interact.placement.NoOffsetNormalEnum;
import client.onyx.interact.placement.Util;
import client.onyx.module.player.DelayModule;
import client.onyx.module.player.scaffold.extra.Iface;
import client.onyx.module.player.scaffold.extra.JumpSneakTimeRecord;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.simulation.Cls5;
import client.onyx.simulation.PosFallDistanceRecord;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.OutlineColliderEnum;
import client.onyx.util.Util11;
import client.onyx.util.Util2;
import client.onyx.util.Util6;
import client.onyx.util.math.PositionDirectionRecord;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class GodBridgeScaffoldMode extends ScaffoldMode implements Iface {
   public ValueSettingSub<GodBridgeScaffoldMode.JumpSneakEnum> valueSettingSub;
   private static final float FLOAT = (float) (Math.PI / 180.0);
   private static final double DOUBLE = 0.08;
   private static final double DOUBLE2 = 0.42F;
   private static final double DOUBLE3 = 0.98;
   public static final GodBridgeScaffoldMode GOD_BRIDGE_SCAFFOLD_MODE = new GodBridgeScaffoldMode();
   private transient boolean bool2;
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub3 valueSettingSub3;

   private JumpSneakTimeRecord getJumpSneakTimeRecord(GodBridgeScaffoldMode.JumpSneakEnum var1) {
      switch (var1) {
         case JUMP:
            return new JumpSneakTimeRecord(true, 0, false, false);
         case SNEAK:
            int var4 = this.valueSettingSub3.getInt4();
            return new JumpSneakTimeRecord(false, var4, false, false);
         case STOP_INPUT:
            return new JumpSneakTimeRecord(false, 0, true, false);
         case BACKWARDS:
            return new JumpSneakTimeRecord(false, 0, false, true);
         default:
            throw new MatchException(null, null);
      }
   }

   private GodBridgeScaffoldMode() {
      super("GodBridge");
      GodBridgeScaffoldMode.JumpSneakEnum[] var10005 = new GodBridgeScaffoldMode.JumpSneakEnum[1];
      boolean var10007 = true;
      var10005[0] = GodBridgeScaffoldMode.JumpSneakEnum.JUMP;
      this.valueSettingSub = new ValueSettingSub<>("Modes", GodBridgeScaffoldMode.JumpSneakEnum.class, var10005).getValueSettingSub(false);
      this.valueSettingSub10 = new ValueSettingSub10("Force sneak below count", 3.0, 0.0, 10.0, 1.0);
      this.valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString2("Sneak time", 1, 1, 1, 10).getValueSettingSub3(" ticks");
   }

   private YawPitchRecord getYawPitchRecord21(InteractedBlockPosPlacedBlockRecord var1) {
      float var2 = (float)(Math.floor(var1.rotation().yaw2() / 90.0F) * 90.0);
      return new YawPitchRecord(var2 + 45.0F, 75.0F);
   }

   private double getDouble30() {
      double var1 = 0.42F;
      if (MINECRAFT.thePlayer.isPotionActive(Potion.jump)) {
         var1 += (MINECRAFT.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F;
      }

      return var1;
   }

   @Override
   public YawPitchRecord getYawPitchRecord16(InteractedBlockPosPlacedBlockRecord var1) {
      if (DelayModule.DELAY_MODULE.getForwardsBackwardsRecord2().equals(ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8)) {
         return var1 == null ? null : this.getYawPitchRecord21(var1);
      } else {
         float var3;
         boolean var2 = (
                  var3 = (float)(
                     Math.rint((Util2.getFloatForEntityPlayerSP4(MINECRAFT.thePlayer, DelayModule.DELAY_MODULE.getForwardsBackwardsRecord2()) + 180.0F) / 45.0F)
                        * 45.0
                  )
               )
               % 90.0F
            == 0.0F;
         return var2 ? this.getYawPitchRecord19(var3) : this.getYawPitchRecord20(var3);
      }
   }

   @Override
   public InteractedBlockPosPlacedBlockRecord getInteractedBlockPosPlacedBlockRecord(Vec3 var1, boolean var2, PositionDirectionRecord var3, ItemStack var4) {
      Cls var5 = new Cls(
         new Cls2(NoOffsetNormalEnum.NORMAL.getList(), Cls.getComparatorForVec3(var1)),
         new Cls3(HitVecStrategySub2.HIT_VEC_STRATEGY_SUB2),
         var4,
         new Cls4(var1, var2)
      );
      return Util.getInteractedBlockPosPlacedBlockRecordForBlockPos(DelayModule.DELAY_MODULE.getBlockPos10(Util6.getBlockPosForVec3(var1)), var5);
   }

   private boolean isEnabled129() {
      double var1 = this.getDouble30();
      double var3 = 0.0;

      for (double var10000 = var1; var10000 > 0.0; var10000 = var1 = (var1 - 0.08) * 0.98) {
         var3 += var1;
      }

      return var3 >= 2.0;
   }

   private YawPitchRecord getYawPitchRecord20(float var1) {
      return new YawPitchRecord(var1, 75.6F);
   }

   private YawPitchRecord getYawPitchRecord19(float var1) {
      if (MINECRAFT.thePlayer.onGround) {
         this.bool2 = Math.floor(MINECRAFT.thePlayer.posX + (float)Math.cos(var1 * (float) (Math.PI / 180.0)) * 0.5) != Math.floor(MINECRAFT.thePlayer.posX)
            || Math.floor(MINECRAFT.thePlayer.posZ + (float)Math.sin(var1 * (float) (Math.PI / 180.0)) * 0.5) != Math.floor(MINECRAFT.thePlayer.posZ);
         EnumFacing var4 = EnumFacing.fromAngle(var1);
         BlockPos var10 = Util6.getBlockPosForVec3(
            Util2.getVec3ForEntity2(MINECRAFT.thePlayer).addVector(var4.getFrontOffsetX() * 0.6, var4.getFrontOffsetY() * 0.6, var4.getFrontOffsetZ() * 0.6)
         );
         boolean var3 = isBlockPos15(new BlockPos(MINECRAFT.thePlayer).add(0, -1, 0));
         boolean var11 = isBlockPos15(var10.add(0, -1, 0));
         if (var3 && var11) {
            this.bool2 = !this.bool2;
         }
      }

      return new YawPitchRecord(var1 + (this.bool2 ? 45 : -45), 75.7F);
   }

   @Override
   public JumpSneakTimeRecord getJumpSneakTimeRecord2(InteractedBlockPosPlacedBlockRecord var1, YawPitchRecord var2) {
      if (!this.isEnabled8()) {
         return JumpSneakTimeRecord.JUMP_SNEAK_TIME_RECORD;
      } else {
         PosFallDistanceRecord var4;
         if (!(var4 = Cls5.CLS5.getCls().getPosFallDistanceRecord(1)).clipLedged()) {
            return JumpSneakTimeRecord.JUMP_SNEAK_TIME_RECORD;
         } else {
            Vec3 var10 = var4.pos().add(0.0, MINECRAFT.thePlayer.getEyeHeight(), 0.0);
            MovingObjectPosition var7 = Util11.getMovingObjectPositionForDouble2(
               Util11.getDouble32(), OutlineColliderEnum.OUTLINE, false, var10, var2.getVec3()
            );
            if (var1 == null) {
               return JumpSneakTimeRecord.JUMP_SNEAK_TIME_RECORD;
            } else {
               boolean var5 = var1.isMovingObjectPosition(var7);
               boolean var8 = DelayModule.DELAY_MODULE.isMovingObjectPosition3(var7);
               if (var5 && var8) {
                  return JumpSneakTimeRecord.JUMP_SNEAK_TIME_RECORD;
               } else {
                  GodBridgeScaffoldMode.JumpSneakEnum var6 = DelayModule.DELAY_MODULE.getInt48() < this.valueSettingSub10.getInt10()
                     ? GodBridgeScaffoldMode.JumpSneakEnum.SNEAK
                     : getJumpSneakEnumForEnumSet(this.valueSettingSub.lambda15());
                  GodBridgeScaffoldMode.JumpSneakEnum var9;
                  GodBridgeScaffoldMode var10000;
                  if (var6 == GodBridgeScaffoldMode.JumpSneakEnum.JUMP && this.isEnabled129()) {
                     EnumSet var11;
                     (var11 = EnumSet.copyOf(this.valueSettingSub.lambda15())).remove(GodBridgeScaffoldMode.JumpSneakEnum.JUMP);
                     GodBridgeScaffoldMode.JumpSneakEnum var12 = getJumpSneakEnumForEnumSet(var11);
                     var9 = var12 != null ? var12 : GodBridgeScaffoldMode.JumpSneakEnum.SNEAK;
                     var10000 = this;
                  } else {
                     var9 = var6;
                     var10000 = this;
                  }

                  return var10000.getJumpSneakTimeRecord(var9);
               }
            }
         }
      }
   }

   private static boolean isBlockPos15(BlockPos var0) {
      IBlockState var2;
      return (var2 = client.onyx.interact.Util.getIBlockStateForBlockPos(var0)) == null || var2.getBlock().getMaterial() == Material.air;
   }

   private static GodBridgeScaffoldMode.JumpSneakEnum getJumpSneakEnumForEnumSet(EnumSet<GodBridgeScaffoldMode.JumpSneakEnum> var0) {
      if (var0.isEmpty()) {
         return null;
      } else {
         ArrayList var2 = new ArrayList(var0);
         ThreadLocalRandom var3 = ThreadLocalRandom.current();
         int var4 = var2.size();
         int var5 = var3.nextInt(var4);
         return (GodBridgeScaffoldMode.JumpSneakEnum)var2.get(var5);
      }
   }

   public static enum JumpSneakEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      JUMP("Jump"),
      SNEAK("Sneak"),
      STOP_INPUT("Stop input"),
      BACKWARDS("Backwards");

      private final String string;

      @Override
      public String getString5() {
         return this.string;
      }


      private JumpSneakEnum(String var3) {
         this.string = var3;
      }
   }
}
