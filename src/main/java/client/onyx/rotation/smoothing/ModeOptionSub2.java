package client.onyx.rotation.smoothing;

import client.onyx.rotation.Cls2;
import client.onyx.rotation.data.YawPitchRecord;

public abstract class ModeOptionSub2 extends ModeOptionSub {
   @Override
   public YawPitchRecord getYawPitchRecord9(Cls2 var1, YawPitchRecord var2, YawPitchRecord var3) {
      XYRecord var4 = this.getXYRecord3(var1, var2, var3);
      return var2.getYawPitchRecord4(var3, var4.x(), var4.y());
   }

   @Override
   public int getInt22(YawPitchRecord var1, YawPitchRecord var2) {
      int var3 = -1;

      do {
         XYRecord var4 = this.getXYRecord3(null, var1, var2);
         float var10002 = var4.x();
         var3++;
         var1 = var1.getYawPitchRecord4(var2, var10002, var4.y());
      } while (!var1.isYawPitchRecord(var2) && var3 < 80);

      return var3;
   }

   protected ModeOptionSub2(String var1) {
      super(var1);
   }

   public abstract XYRecord getXYRecord3(Cls2 var1, YawPitchRecord var2, YawPitchRecord var3);
}
