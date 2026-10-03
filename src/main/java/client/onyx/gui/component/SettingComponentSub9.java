package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.setting.BooleanSetting;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.Iterator;

public class SettingComponentSub9 extends SettingComponent {
   private float float_5;
   protected static final float FLOAT5 = 13.0F;
   private final Cls2 cls22 = new Cls2();
   private final GuiComponentSub7 guiComponentSub7;
   private final BooleanSetting booleanSetting;

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      if (this.guiComponentSub7 != null) {
         this.guiComponentSub7.handleFloat80(this.float_3 + this.float_4 - 38.0F, this.float_ + (this.getFloat193() - 22.0F) / 2.0F, 38.0F, 22.0F);
      }

      this.float_5 = this.cls22.getFloat(this.getFloat194(), this.float_ + this.getFloat193(), this.getFloat192());
      super.handleCls28(var1);
   }

   public SettingComponentSub9(BooleanSetting var1) {
      super(var1);
      this.booleanSetting = var1;
      this.cls22.handleList(var1.getList2());
      this.list.addAll(this.cls22.getList());
      if (var1.isEnabled6()) {
         this.guiComponentSub7 = new GuiComponentSub7(() -> {
            return (Boolean)var1.getValueSettingSub9().lambda15();
         }, (var1x) -> {
            var1.getValueSettingSub9().handleObject2(var1x);
         });
         boolean var3 = this.list.add(this.guiComponentSub7);
      } else {
         this.guiComponentSub7 = null;
      }
   }

   protected OpticalWeightRecord getOpticalWeightRecord3() {
      return Util2.OPTICAL_WEIGHT_RECORD18;
   }

   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      return this.getFloat193() + this.float_5 + (this.float_5 > 0.5F ? 6.0F : 0.0F);
   }

   private float getFloat193() {
      float var2 = this.getFloat178();
      return this.guiComponentSub7 == null ? var2 : Math.max(var2, 34.0F);
   }

   private float getFloat194() {
      return this.float_3 + 13.0F;
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (!this.isEnabled163()) {
         return false;
      } else {
         Iterator var5 = this.list.iterator();

         do {
            if (!var5.hasNext()) {
               if (this.guiComponentSub7 != null && var3 == 0 && var1 >= this.float_3) {
                  float var7 = this.float_3 + this.float_4;
                  if (var1 < var7 && var2 >= this.float_ && var2 < this.float_ + this.getFloat193()) {
                     this.booleanSetting.getValueSettingSub9().run10();
                     return true;
                  }
               }

               return false;
            }
         } while(!((GuiComponent)var5.next()).isFloat17(var1, var2, var3));

         return true;
      }
   }

   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      float var3 = this.guiComponentSub7 == null ? 0.0F : 48.0F;
      this.handleCls225(var1, this.float_4 - var3);
      if (this.float_5 > 0.5F) {
         var1.sampler0.handleFloat28(this.float_3 + 3.0F, this.float_ + this.getFloat193(), 1.0F, this.float_5, Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().outlineVariant(), var2 * 0.7F));
      }

      this.cls22.handleSampler0(var1.sampler0, this.getFloat194(), this.getFloat192(), var1.getPrimaryOnPrimaryRecord().outlineVariant(), var2);

      Iterator var4;
      for(Iterator var10000 = var4 = this.list.iterator(); var10000.hasNext(); var10000 = var4) {
         ((GuiComponent)var4.next()).handleCls27(var1);
      }

   }

   private float getFloat192() {
      return Math.max(0.0F, this.float_4 - 13.0F);
   }
}
