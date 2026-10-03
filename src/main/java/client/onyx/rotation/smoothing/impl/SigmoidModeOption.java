package client.onyx.rotation.smoothing.impl;

import client.onyx.rotation.Cls2;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.smoothing.ModeOptionSub2;
import client.onyx.rotation.smoothing.XYRecord;
import client.onyx.rotation.util.Util;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub3;

public class SigmoidModeOption extends ModeOptionSub2 {
   private final ValueSettingSub3 valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString("Horizontal turn speed", 180.0, 180.0, 0.0, 180.0)
      .getValueSettingSub3("°/t");
   private final ValueSettingSub3 valueSettingSub32 = ValueSettingSub3.getValueSettingSub3ForString("Vertical turn speed", 180.0, 180.0, 0.0, 180.0)
      .getValueSettingSub3("°/t");
   private final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Slowdown sharpness", 10.0, 0.0, 20.0, 0.1)
      .getBooleanSetting("How abruptly the aim shifts between slow (near the target) and full speed (far from it)");
   private final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Half speed distance", 0.3, 0.0, 1.0, 0.01)
      .getBooleanSetting("Fraction of a 120° turn left to the target at which the aim moves at half speed");

   private float getFloat29(float var1, float var2) {
      double var3 = var1 / 120.0F;
      return Util.getFloatForFloat10(
         (float)(1.0 / (1.0 + Math.exp(-this.valueSettingSub10.lambda15() * (var3 - this.valueSettingSub102.lambda15()))) * var2), 0.0F, 180.0F
      );
   }

   @Override
   public XYRecord getXYRecord3(Cls2 var1, YawPitchRecord var2, YawPitchRecord var3) {
      float var4 = var2.getFloat(var3);
      float var5;
      float var6;
      if (var1 != null) {
         var5 = this.valueSettingSub3.getFloat3();
         var6 = this.valueSettingSub32.getFloat3();
      } else {
         var5 = this.valueSettingSub3.getFloat4();
         var6 = this.valueSettingSub32.getFloat4();
      }

      return new XYRecord(this.getFloat29(var4, var5), this.getFloat29(var4, var6));
   }

   public SigmoidModeOption() {
      super("Sigmoid");
   }
}
