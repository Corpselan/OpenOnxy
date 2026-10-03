package client.onyx.gui.component;

import client.onyx.render.Sampler0;
import client.onyx.render.misc.Util;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.Util4;

public class SettingComponentSub10 extends SettingComponent {
   private static final float FLOAT5 = 13.0F;
   private static final float FLOAT6 = 15.0F;
   private final client.onyx.render.misc.Cls cls3;
   private final ValueSettingSub9 valueSettingSub9;
   private boolean bool6;
   private boolean bool7;
   private final client.onyx.gui.Cls cls4 = new client.onyx.gui.Cls();

   @Override
   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      return this.getFloat178();
   }

   private float getFloat197() {
      return this.float_3 + this.float_4 - 15.0F;
   }

   private float getFloat196() {
      return this.getFloat181() - 7.5F;
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      if (!this.bool6) {
         this.bool6 = true;
         this.bool7 = this.valueSettingSub9.lambda15();
         this.cls3.getCls(this.bool7 ? 1.0F : 0.0F);
      }

      if (this.valueSettingSub9.lambda15() != this.bool7) {
         boolean var5 = this.valueSettingSub9.lambda15();
         this.bool7 = var5;
         this.cls3.getCls2(this.bool7 ? 1.0F : 0.0F, 200.0F, Util.IFACE2);
      }

      this.cls3.handleFloat(var1.float_);
      this.cls4.handleFloat(var1.float_, this.bool, this.bool3);
   }

   public SettingComponentSub10(ValueSettingSub9 var1) {
      super(var1);
      this.cls3 = new client.onyx.render.misc.Cls(0.0F);
      this.valueSettingSub9 = var1;
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.isEnabled163() && var3 == 0 && this.isFloat15(var1, var2)) {
         this.valueSettingSub9.run10();
         return true;
      } else {
         return false;
      }
   }

   @Override
   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      Sampler0 var8 = var1.sampler0;
      float var6 = this.getFloat197();
      float var4 = this.getFloat196();
      float var5 = this.cls3.getFloat();
      this.handleCls225(var1, var6 - 10.0F - this.float_3);
      this.cls4.handleSampler0(var8, var6 - 6.0F, var4 - 6.0F, 27.0F, 27.0F, Float.MAX_VALUE, this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurface()));
      if (var5 > 0.01F) {
         float var7 = (1.0F - var5) * 15.0F / 2.0F;
         var8.handleFloat7(var6 + var7, var4 + var7, 15.0F - var7 * 2.0F, 15.0F - var7 * 2.0F, 4.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().primary()));
      }

      if (var5 < 0.99F) {
         var8.handleFloat18(var6, var4, 15.0F, 15.0F, 4.0F, 1.5F, this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()));
      }

      if (var5 > 0.15F) {
         float var9 = Math.clamp((var5 - 0.15F) / 0.85F, 0.0F, 1.0F);
         client.onyx.gui.Util.handleSampler06(
            var8,
            var6 + 7.5F,
            var4 + 7.5F,
            13.0F * (0.7F + 0.3F * var9),
            this.getInt72(Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onPrimary(), var9))
         );
      }
   }
}
