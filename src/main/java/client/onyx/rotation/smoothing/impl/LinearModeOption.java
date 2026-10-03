package client.onyx.rotation.smoothing.impl;

import client.onyx.rotation.Cls2;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.smoothing.ModeOptionSub2;
import client.onyx.rotation.smoothing.XYRecord;
import client.onyx.setting.impl.ValueSettingSub3;

public class LinearModeOption extends ModeOptionSub2 {
   private final ValueSettingSub3 valueSettingSub3;
   private final ValueSettingSub3 valueSettingSub32;

   public LinearModeOption() {
      this(180.0F, 180.0F, 180.0F, 180.0F);
   }

   @Override
   public XYRecord getXYRecord3(Cls2 var1, YawPitchRecord var2, YawPitchRecord var3) {
      return var1 != null
         ? new XYRecord(this.valueSettingSub3.getFloat3(), this.valueSettingSub32.getFloat3())
         : new XYRecord(this.valueSettingSub3.getFloat4(), this.valueSettingSub32.getFloat4());
   }

   public LinearModeOption(float var1, float var2, float var3, float var4) {
      super("Linear");
      this.valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString("Horizontal turn speed", var1, var2, 0.0, 180.0).getValueSettingSub3("°/t");
      this.valueSettingSub32 = ValueSettingSub3.getValueSettingSub3ForString("Vertical turn speed", var3, var4, 0.0, 180.0).getValueSettingSub3("°/t");
   }
}
