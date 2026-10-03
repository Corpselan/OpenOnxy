package client.onyx.rotation;

import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.mode.OffStrictEnum;
import client.onyx.rotation.smoothing.ModeOptionSub;
import client.onyx.rotation.smoothing.impl.AccelerationModeOption;
import client.onyx.rotation.smoothing.impl.LinearModeOption;
import client.onyx.rotation.smoothing.impl.SigmoidModeOption;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.ModeSetting;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.util.Cls5;
import java.util.List;
import net.minecraft.entity.Entity;

public class RotationsBooleanSetting extends BooleanSetting {
   private final ModeSetting<ModeOptionSub> modeSetting;
   private final ValueSettingSub11<OffStrictEnum> valueSettingSub11;
   private final ValueSettingSub10 valueSettingSub10;
   private final ValueSettingSub10 valueSettingSub102;

   public RotationsBooleanSetting(OffStrictEnum var1) {
      super("Rotations");
      LinearModeOption var3 = new LinearModeOption();
      ModeOptionSub[] var4 = new ModeOptionSub[]{var3, null, null};
      AccelerationModeOption var5 = new AccelerationModeOption();
      var4[1] = var5;
      SigmoidModeOption var6 = new SigmoidModeOption();
      var4[2] = var6;
      ModeSetting var7 = new ModeSetting<>("Angle smooth", var3, var4);
      this.modeSetting = var7;
      this.valueSettingSub11 = new ValueSettingSub11<>("Movement correction", var1);
      this.valueSettingSub10 = new ValueSettingSub10("Reset threshold", 2.0, 1.0, 180.0, 1.0)
         .getValueSettingSub10("°")
         .getBooleanSetting("How close the aim has to get to your real look while easing back before control snaps to you");
      this.valueSettingSub102 = new ValueSettingSub10("Ticks until reset", 5.0, 1.0, 30.0, 1.0)
         .getValueSettingSub10(" ticks")
         .getBooleanSetting("How long the last aim is held after the module stops updating it, before it eases back");
   }

   public Cls2 getCls29(YawPitchRecord var1, Entity var2, boolean var3, Cls5 var4) {
      List var6 = List.of(this.modeSetting.lambda15());
      return new Cls2(
         var1,
         var2,
         var6,
         (int)Math.round(this.valueSettingSub102.lambda15()),
         this.valueSettingSub10.lambda15().floatValue(),
         var3,
         this.valueSettingSub11.lambda15(),
         var4
      );
   }

   public RotationsBooleanSetting() {
      this(OffStrictEnum.SILENT);
   }

   public int getInt20(YawPitchRecord var1) {
      return this.modeSetting.lambda15().getInt22(Cls.CLS.getYawPitchRecord2(), var1);
   }

   public Cls2 getCls28(YawPitchRecord var1) {
      return this.getCls29(var1, null, false, null);
   }

   public OffStrictEnum getOffStrictEnum() {
      return this.valueSettingSub11.lambda15();
   }

   public Cls2 getCls210(YawPitchRecord var1, boolean var2) {
      return this.getCls29(var1, null, var2, null);
   }
}
