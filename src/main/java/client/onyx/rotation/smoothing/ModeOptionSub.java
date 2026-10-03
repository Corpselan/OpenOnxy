package client.onyx.rotation.smoothing;

import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.mode.api.Iface;
import client.onyx.setting.ModeOption;

public abstract class ModeOptionSub extends ModeOption implements Iface {
   protected ModeOptionSub(String var1) {
      super(var1);
   }

   public abstract int getInt22(YawPitchRecord var1, YawPitchRecord var2);
}
