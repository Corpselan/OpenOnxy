package client.onyx.module.player.scaffold.mode;

import client.onyx.event.impl.EventSub4;
import client.onyx.interact.placement.CenterRandomEnum;
import client.onyx.interact.placement.Cls;
import client.onyx.interact.placement.Cls2;
import client.onyx.interact.placement.Cls3;
import client.onyx.interact.placement.Cls4;
import client.onyx.interact.placement.EyePosRandomNumberRecord;
import client.onyx.interact.placement.HitVecStrategy;
import client.onyx.interact.placement.HitVecStrategySub;
import client.onyx.interact.placement.HitVecStrategySub2;
import client.onyx.interact.placement.HitVecStrategySub3;
import client.onyx.interact.placement.HitVecStrategySub4;
import client.onyx.interact.placement.HitVecStrategySub5;
import client.onyx.interact.placement.InteractedBlockPosPlacedBlockRecord;
import client.onyx.interact.placement.NoOffsetNormalEnum;
import client.onyx.interact.placement.Util;
import client.onyx.module.player.DelayModule;
import client.onyx.module.player.scaffold.mode.settings.DownSettingGroup;
import client.onyx.module.player.scaffold.mode.settings.SneakSettingGroup;
import client.onyx.module.player.scaffold.mode.settings.StabilizeMovementSettingGroup;
import client.onyx.module.player.scaffold.mode.settings.TellySettingGroup;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.util.Util2;
import client.onyx.util.Util6;
import client.onyx.util.math.PositionDirectionRecord;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class NormalScaffoldMode extends ScaffoldMode {
   public StabilizeMovementSettingGroup stabilizeMovementSettingGroup;
   public SneakSettingGroup sneakSettingGroup;
   public TellySettingGroup tellySettingGroup;
   public ValueSettingSub11<CenterRandomEnum> valueSettingSub11 = new ValueSettingSub11<>("Rotation mode", CenterRandomEnum.STABILIZED);
   public static final NormalScaffoldMode NORMAL_SCAFFOLD_MODE = new NormalScaffoldMode();
   private transient double double_;
   public DownSettingGroup downSettingGroup;

   @Override
   public YawPitchRecord getYawPitchRecord16(InteractedBlockPosPlacedBlockRecord var1) {
      if (TellySettingGroup.TELLY_SETTING_GROUP.isEnabled5() && TellySettingGroup.TELLY_SETTING_GROUP.isEnabled131()) {
         switch ((TellySettingGroup.ReverseResetEnum)TellySettingGroup.TELLY_SETTING_GROUP.valueSettingSub11.lambda15()) {
            case REVERSE:
               return new YawPitchRecord(
                  (float)(Math.rint(Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer).yaw2() / 45.0F) * 45.0),
                  MINECRAFT.thePlayer.rotationPitch < 45.0F ? 45.0F : MINECRAFT.thePlayer.rotationPitch
               );
            case RESET:

               return null;
            default:
               throw new MatchException(null, null);
         }
      } else {
         return super.getYawPitchRecord16(var1);
      }
   }

   private HitVecStrategy getHitVecStrategy(Vec3 var1, boolean var2, PositionDirectionRecord var3) {
      EyePosRandomNumberRecord var5 = new EyePosRandomNumberRecord(var1.add(0.0, Cls4.getFloatForBool(var2), 0.0), this.double_);
      switch ((CenterRandomEnum)this.valueSettingSub11.lambda15()) {
         case CENTER:

            return HitVecStrategySub2.HIT_VEC_STRATEGY_SUB2;
         case RANDOM:
            return HitVecStrategySub3.HIT_VEC_STRATEGY_SUB3;
         case STABILIZED:
            return new HitVecStrategySub(var5, var3);
         case NEAREST_ROTATION:
            return new HitVecStrategySub4(var5);
         case EDGE_POINT:
            return new HitVecStrategySub5(var5);
         default:
            throw new MatchException(null, null);
      }
   }

   @Override
   public MovingObjectPosition getMovingObjectPosition(InteractedBlockPosPlacedBlockRecord var1, YawPitchRecord var2) {
      if (var1 == null) {
         return null;
      } else {
         MovingObjectPosition var3;
         if ((var3 = super.getMovingObjectPosition(var1, var2)) != null && var1.isMovingObjectPosition(var3)) {
            return var3;
         } else {
            return DownSettingGroup.isEnabled132() ? var1.getMovingObjectPosition() : null;
         }
      }
   }

   @EventHandler(
      priority = -50
   )
   private void handleEventSub42(EventSub4 var1) {
      this.double_ = ThreadLocalRandom.current().nextDouble(-0.01, 0.01);
   }

   private NormalScaffoldMode() {
      super("Normal");
      this.sneakSettingGroup = SneakSettingGroup.SNEAK_SETTING_GROUP;
      this.tellySettingGroup = TellySettingGroup.TELLY_SETTING_GROUP;
      this.downSettingGroup = DownSettingGroup.DOWN_SETTING_GROUP;
      this.stabilizeMovementSettingGroup = StabilizeMovementSettingGroup.STABILIZE_MOVEMENT_SETTING_GROUP;
      this.double_ = ThreadLocalRandom.current().nextDouble(-0.02, 0.02);
   }

   @Override
   public InteractedBlockPosPlacedBlockRecord getInteractedBlockPosPlacedBlockRecord(Vec3 var1, boolean var2, PositionDirectionRecord var3, ItemStack var4) {
      Comparator var5 = this.getComparator5(var1, var3);
      List var6;
      NormalScaffoldMode var10000;
      if (DownSettingGroup.isEnabled132()) {
         var6 = NoOffsetNormalEnum.DOWN.getList();
         var10000 = this;
      } else {
         var6 = NoOffsetNormalEnum.NORMAL.getList();
         var10000 = this;
      }

      HitVecStrategy var8 = var10000.getHitVecStrategy(var1, var2, var3);
      Cls var7 = new Cls(new Cls2(var6, var5), new Cls3(var8, DownSettingGroup.isEnabled132()), var4, new Cls4(var1, var2));
      return Util.getInteractedBlockPosPlacedBlockRecordForBlockPos(DelayModule.DELAY_MODULE.getBlockPos10(Util6.getBlockPosForVec3(var1)), var7);
   }
}
