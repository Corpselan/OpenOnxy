package client.onyx.rotation.smoothing.impl;

import client.onyx.rotation.Cls;
import client.onyx.rotation.Cls2;
import client.onyx.rotation.data.DeltaYawDeltaPitchRecord;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.smoothing.ModeOptionSub;
import client.onyx.rotation.smoothing.XYRecord;
import client.onyx.rotation.util.Util;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.util.Util2;
import client.onyx.util.Util5;
import net.minecraft.entity.Entity;

public class AccelerationModeOption extends ModeOptionSub {
   private final AccelerationModeOption.ConstantErrorSettingGroup constantErrorSettingGroup;
   private final ValueSettingSub3 valueSettingSub3;
   private final ValueSettingSub3 valueSettingSub32 = ValueSettingSub3.getValueSettingSub3ForString("Yaw acceleration", 20.0, 25.0, 1.0, 180.0)
      .getValueSettingSub3("°/t²");
   private final AccelerationModeOption.SigmoidDecelerationSettingGroup sigmoidDecelerationSettingGroup;
   private final AccelerationModeOption.PitchCrosshairAccelerationSettingGroup pitchCrosshairAccelerationSettingGroup;
   private final AccelerationModeOption.AccelerationErrorSettingGroup accelerationErrorSettingGroup;

   private XYRecord getXYRecord4(DeltaYawDeltaPitchRecord var1, DeltaYawDeltaPitchRecord var2, boolean var3, double var4) {
      float var6 = this.sigmoidDecelerationSettingGroup.isEnabled5() ? this.sigmoidDecelerationSettingGroup.getFloat28(var2.getFloat()) : 1.0F;
      boolean var7 = this.pitchCrosshairAccelerationSettingGroup.isEnabled5() && var3;
      float var10 = (float)(this.pitchCrosshairAccelerationSettingGroup.valueSettingSub10.lambda15() * var4);
      float var10002;
      AccelerationModeOption var10003;
      if (this.accelerationErrorSettingGroup.isEnabled5()) {
         var10002 = this.accelerationErrorSettingGroup.valueSettingSub10.lambda15().floatValue();
         var10003 = this;
      } else {
         var10002 = 0.0F;
         var10003 = this;
      }

      AccelerationModeOption.AccelerationErrorConstantErrorRecord var16 = new AccelerationModeOption.AccelerationErrorConstantErrorRecord(
         var10002, var10003.constantErrorSettingGroup.isEnabled5() ? this.constantErrorSettingGroup.valueSettingSub10.lambda15().floatValue() : 0.0F
      );
      AccelerationModeOption.AccelerationErrorConstantErrorRecord var14 = var16;
      if (this.accelerationErrorSettingGroup.isEnabled5()) {
         var10002 = this.accelerationErrorSettingGroup.valueSettingSub102.lambda15().floatValue();
         var10003 = this;
      } else {
         var10002 = 0.0F;
         var10003 = this;
      }

      var16 = new AccelerationModeOption.AccelerationErrorConstantErrorRecord(
         var10002, var10003.constantErrorSettingGroup.isEnabled5() ? this.constantErrorSettingGroup.valueSettingSub102.lambda15().floatValue() : 0.0F
      );
      AccelerationModeOption.AccelerationErrorConstantErrorRecord var5 = var16;
      ValueSettingSub3 var8 = var7 ? this.pitchCrosshairAccelerationSettingGroup.valueSettingSub3 : this.valueSettingSub32;
      ValueSettingSub3 var15 = var7 ? this.pitchCrosshairAccelerationSettingGroup.valueSettingSub32 : this.valueSettingSub3;
      float var12 = this.getFloat30(var2.deltaYaw(), var1.deltaYaw(), -var8.getFloat3() + var10, var8.getFloat3() + var10, var6);
      float var11 = this.getFloat30(var2.deltaPitch(), var1.deltaPitch(), -var15.getFloat3() + var10, var15.getFloat3() + var10, var6);
      return new XYRecord(var1.deltaYaw() + var12 + var14.getFloat(var12), var1.deltaPitch() + var11 + var5.getFloat(var11));
   }

   public AccelerationModeOption() {
      super("Acceleration");
      this.valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString("Pitch acceleration", 20.0, 25.0, 1.0, 180.0).getValueSettingSub3("°/t²");
      this.accelerationErrorSettingGroup = new AccelerationModeOption.AccelerationErrorSettingGroup();
      this.constantErrorSettingGroup = new AccelerationModeOption.ConstantErrorSettingGroup();
      this.pitchCrosshairAccelerationSettingGroup = new AccelerationModeOption.PitchCrosshairAccelerationSettingGroup();
      this.sigmoidDecelerationSettingGroup = new AccelerationModeOption.SigmoidDecelerationSettingGroup();
   }

   @Override
   public YawPitchRecord getYawPitchRecord9(Cls2 var1, YawPitchRecord var2, YawPitchRecord var3) {
      YawPitchRecord var4;
      if ((var4 = Cls.CLS.getYawPitchRecord3()) == null) {
         var4 = Util2.getYawPitchRecordForEntity2(MINECRAFT.thePlayer);
      }

      DeltaYawDeltaPitchRecord var11 = var4.getDeltaYawDeltaPitchRecord(var2);
      DeltaYawDeltaPitchRecord var10 = var2.getDeltaYawDeltaPitchRecord(var3);
      Entity var8;
      double var5 = (var8 = var1.getEntity()) != null ? Util2.getDoubleForEntity4(MINECRAFT.thePlayer, var8) : 0.0;
      boolean var7 = var8 != null && Util5.getMovingObjectPositionForEntity(var8, Math.max(3.0, var5), var2) != null;
      XYRecord var9 = this.getXYRecord4(var11, var10, var7, var5);
      return new YawPitchRecord(var2.yaw2() + var9.x(), var2.pitch2() + var9.y());
   }

   @Override
   public int getInt22(YawPitchRecord var1, YawPitchRecord var2) {
      YawPitchRecord var3;
      if ((var3 = Cls.CLS.getYawPitchRecord3()) == null) {
         var3 = Util2.getYawPitchRecordForEntity2(MINECRAFT.thePlayer);
      }

      DeltaYawDeltaPitchRecord var10 = var3.getDeltaYawDeltaPitchRecord(var1);
      DeltaYawDeltaPitchRecord var8;
      if (isFloat7((var8 = var1.getDeltaYawDeltaPitchRecord(var2)).deltaYaw(), 0.0F) && isFloat7(var8.deltaPitch(), 0.0F)) {
         return 0;
      } else {
         XYRecord var9;
         if ((!isFloat7((var9 = this.getXYRecord4(var10, var8, false, 0.0)).x(), 0.0F) || !isFloat7(var9.y(), 0.0F))
            && (!(Math.abs(var8.deltaYaw()) < Math.abs(var9.x())) || !(Math.abs(var8.deltaPitch()) < Math.abs(var9.y())))) {
            double var4 = Math.floor(Math.abs(var8.deltaYaw()) / Math.abs(var9.x()));
            double var6 = Math.floor(Math.abs(var8.deltaPitch()) / Math.abs(var9.y()));
            return !Double.isNaN(var4) && !Double.isNaN(var6) ? (int)Math.max(var4, var6) : 0;
         } else {
            return 0;
         }
      }
   }

   private float getFloat30(float var1, float var2, float var3, float var4, float var5) {
      return Util.getFloatForFloat10(Util.getFloatForFloat9(var1, var2), var3, var4) * var5;
   }

   private static boolean isFloat7(float var0, float var1) {
      return Math.abs(var1 - var0) < 1.0E-5F;
   }

   private record AccelerationErrorConstantErrorRecord(float accelerationError, float constantError) {
      float getFloat(float var1) {
         float var2 = getFloatForFloat(-this.accelerationError, this.accelerationError);
         float var4 = getFloatForFloat(-this.constantError, this.constantError);
         return var1 * var2 + var4;
      }

      private static float getFloatForFloat(float var0, float var1) {
         return var1 <= var0 ? var0 : (float)(var0 + Math.random() * (var1 - var0));
      }
   }

   private static class AccelerationErrorSettingGroup extends SettingGroup {
      final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Yaw error", 0.1, 0.01, 1.0, 0.01);
      final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Pitch error", 0.1, 0.01, 1.0, 0.01);

      AccelerationErrorSettingGroup() {
         super("Acceleration error", true);
      }
   }

   private static class ConstantErrorSettingGroup extends SettingGroup {
      final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Yaw error", 0.1, 0.01, 1.0, 0.01);
      final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Pitch error", 0.1, 0.01, 1.0, 0.01);

      ConstantErrorSettingGroup() {
         super("Constant error", true);
      }
   }

   private static class PitchCrosshairAccelerationSettingGroup extends SettingGroup {
      final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Distance factor", -1.393, -2.0, 2.0, 0.001)
         .getBooleanSetting("How much the distance to the target scales the acceleration below");
      final ValueSettingSub3 valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString("Yaw crosshair acceleration", 17.0, 20.0, 1.0, 180.0)
         .getValueSettingSub3("°/t²");
      final ValueSettingSub3 valueSettingSub32 = ValueSettingSub3.getValueSettingSub3ForString("Pitch crosshair acceleration", 17.0, 20.0, 1.0, 180.0)
         .getValueSettingSub3("°/t²");

      PitchCrosshairAccelerationSettingGroup() {
         super("Dynamic acceleration", false);
      }
   }

   private static class SigmoidDecelerationSettingGroup extends SettingGroup {
      private final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Slowdown sharpness", 10.0, 0.0, 20.0, 0.1)
         .getBooleanSetting("How abruptly the aim shifts between slow (near the target) and full speed (far from it)");
      private final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Half speed distance", 0.3, 0.0, 1.0, 0.01)
         .getBooleanSetting("Fraction of a 120° turn left to the target at which the aim moves at half speed");

      SigmoidDecelerationSettingGroup() {
         super("Sigmoid deceleration", false);
      }

      float getFloat28(float var1) {
         double var2 = var1 / 120.0F;
         return Util.getFloatForFloat10(
            (float)(1.0 / (1.0 + Math.exp(-this.valueSettingSub10.lambda15() * (var2 - this.valueSettingSub102.lambda15())))), 0.0F, 180.0F
         );
      }
   }
}
