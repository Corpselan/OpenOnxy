package client.onyx.gui.component;

import client.onyx.setting.impl.ValueSettingSub4;
import client.onyx.theme.Util4;

public class SettingComponentSub6 extends SettingComponent {
   private final GuiComponentSub8 guiComponentSub8;
   private final ValueSettingSub4 valueSettingSub4;
   private String string;
   private static final float FLOAT5 = 6.0F;

   @Override
   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      this.guiComponentSub8.handleCls27(var1);
      if (this.isEnabled162()) {
         var2 = this.float_ + 6.0F + 40.0F + 6.0F;
         var1.sampler0
            .handleOpticalWeightRecord2(
               OPTICAL_WEIGHT_RECORD2,
               var1.sampler0.getString17(OPTICAL_WEIGHT_RECORD2, this.setting.getString2(), this.float_4),
               this.float_3,
               var2,
               this.getInt72(Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.85F))
            );
      }
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      if (!this.valueSettingSub4.lambda15().equals(this.string)) {
         String var4 = this.valueSettingSub4.lambda15();
         this.string = var4;
         this.guiComponentSub8.handleString23(this.string);
      }
   }

   @Override
   protected void run185() {
      this.guiComponentSub8.handleFloat80(this.float_3, this.float_ + 6.0F, this.float_4, 40.0F);
   }

   public SettingComponentSub6(ValueSettingSub4 var1) {
      super(var1);
      this.valueSettingSub4 = var1;
      this.guiComponentSub8 = new GuiComponentSub8(var1.getString3());
      this.string = var1.lambda15();
      this.guiComponentSub8.handleString23(this.string);
      this.guiComponentSub8.handleConsumer4(var1::handleObject2);
      boolean var3 = this.list.add(this.guiComponentSub8);
   }

   @Override
   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      float var2 = 46.0F;
      if (this.isEnabled162()) {
         var2 += 6.0F + OPTICAL_WEIGHT_RECORD2.getFloat4();
      }

      return var2 + 6.0F;
   }
}
