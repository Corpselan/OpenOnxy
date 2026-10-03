package client.onyx.gui.component;

import client.onyx.render.Sampler0;
import client.onyx.setting.impl.SettingSub;
import client.onyx.theme.Util2;

public class SettingComponentSub11 extends SettingComponent {
   private static final float FLOAT5 = 30.0F;
   private final SettingSub settingSub;
   private final client.onyx.gui.Cls cls3 = new client.onyx.gui.Cls();

   @Override
   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      return 30.0F;
   }

   public SettingComponentSub11(SettingSub var1) {
      super(var1);
      this.settingSub = var1;
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.isEnabled163() && var3 == 0 && this.isFloat15(var1, var2)) {
         this.settingSub.run7();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      this.cls3.handleFloat(var1.float_, this.bool, this.bool3);
   }

   @Override
   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      Sampler0 var5;
      Sampler0 var10000 = var5 = var1.sampler0;
      Sampler0 var10001 = var1.sampler0;
      int var4 = this.getInt72(var1.getPrimaryOnPrimaryRecord().onSecondaryContainer());
      var10001.handleFloat7(
         this.float_3, this.float_, this.float_4, 30.0F, Float.MAX_VALUE, this.getInt72(var1.getPrimaryOnPrimaryRecord().secondaryContainer())
      );
      this.cls3.handleSampler0(var5, this.float_3, this.float_, this.float_4, 30.0F, Float.MAX_VALUE, var4);
      var10000.handleOpticalWeightRecord4(
         Util2.OPTICAL_WEIGHT_RECORD14, this.settingSub.getString6(), this.float_3 + this.float_4 / 2.0F, this.float_ + 15.0F, var4
      );
      if (this.bool && this.isEnabled163()) {
         var5.run41();
      }
   }
}
