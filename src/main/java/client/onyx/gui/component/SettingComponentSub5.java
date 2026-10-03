package client.onyx.gui.component;

import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import client.onyx.render.misc.Util;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;

public class SettingComponentSub5 extends SettingComponent {
   private boolean bool6;
   private static final float FLOAT5 = 3.0F;
   private static final float FLOAT6 = 3.0F;
   private static final float FLOAT7 = 16.0F;
   private static final float FLOAT8 = 5.0F;
   private final client.onyx.render.misc.Cls cls3 = new client.onyx.render.misc.Cls(3.0F);
   private final ValueSettingSub10 valueSettingSub10;
   private static final float FLOAT9 = 3.0F;

   private double getDouble33() {
      return this.valueSettingSub10.getDouble11() > 0.0
         ? this.valueSettingSub10.getDouble11()
         : (this.valueSettingSub10.getDouble10() - this.valueSettingSub10.getDouble13()) / 100.0;
   }

   @Override
   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      if (this.isEnabled163() && this.bool) {
         switch (var1.key()) {
            case 203:

               this.valueSettingSub10.handleObject2(this.valueSettingSub10.lambda15() - this.getDouble33());
               return true;
            case 205:
               this.valueSettingSub10.handleObject2(this.valueSettingSub10.lambda15() + this.getDouble33());
               return true;
            default:
               return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      return this.getFloat187() - this.float_ + 3.0F + 6.0F;
   }

   @Override
   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      Sampler0 var5;
      Sampler0 var10000 = var5 = var1.sampler0;
      float var8 = var1.sampler0.getFloat17(Util2.OPTICAL_WEIGHT_RECORD2, this.valueSettingSub10.getString11());
      this.handleCls225(var1, this.float_4 - var8 - 12.0F);
      var10000.handleOpticalWeightRecord6(
         Util2.OPTICAL_WEIGHT_RECORD2,
         this.valueSettingSub10.getString11(),
         this.float_3 + this.float_4,
         this.getFloat181(),
         this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant())
      );
      var8 = this.getFloat166();
      float var3 = (float)this.valueSettingSub10.getDouble12();
      var3 = this.getFloat164() + this.getFloat165() * var3;
      float var6 = this.cls3.getFloat() / 2.0F;
      float var7;
      if ((var7 = var3 - var6 - 5.0F) > this.float_3) {
         var5.handleFloat7(this.float_3, var8 - 1.5F, var7 - this.float_3, 3.0F, Float.MAX_VALUE, this.getInt72(var1.getPrimaryOnPrimaryRecord().primary()));
      }

      if ((var7 = var3 + var6 + 5.0F) < this.float_3 + this.float_4) {
         var5.handleFloat7(
            var7,
            var8 - 1.5F,
            this.float_3 + this.float_4 - var7,
            3.0F,
            Float.MAX_VALUE,
            this.getInt72(var1.getPrimaryOnPrimaryRecord().surfaceContainerHighest())
         );
      }

      if (this.bool || this.bool6) {
         var5.handleFloat23(var3, var8, 11.0F, Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().primary(), var2 * (this.bool6 ? 0.1F : 0.08F)));
      }

      var5.handleFloat7(var3 - var6, var8 - 8.0F, this.cls3.getFloat(), 16.0F, Float.MAX_VALUE, this.getInt72(var1.getPrimaryOnPrimaryRecord().primary()));
   }

   @Override
   public boolean isFloat18(float var1, float var2, int var3, float var4, float var5) {
      if (!this.bool6) {
         return false;
      } else {
         this.handleFloat87(var1);
         return true;
      }
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (!this.isEnabled163() || var3 != 0 || !this.isFloat15(var1, var2)) {
         return false;
      } else if (var2 < this.getFloat185()) {
         return false;
      } else {
         this.bool6 = true;
         this.handleFloat87(var1);
         return true;
      }
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      float var3 = this.bool6 ? 1.5F : (this.bool ? 4.5F : 3.0F);
      if (this.cls3.getFloat2() != var3) {
         this.cls3.getCls2(var3, 150.0F, Util.IFACE6);
      }

      this.cls3.handleFloat(var1.float_);
      if (this.bool6) {
         this.handleFloat87(var1.float_3);
      }
   }

   private float getFloat165() {
      return this.float_4 - 6.0F;
   }

   private void handleFloat87(float var1) {
      this.valueSettingSub10.handleDouble3((var1 - this.getFloat164()) / this.getFloat165());
   }

   public SettingComponentSub5(ValueSettingSub10 var1) {
      super(var1);
      this.valueSettingSub10 = var1;
   }

   private float getFloat166() {
      return this.getFloat187() + 1.5F;
   }

   @Override
   public boolean isFloat19(float var1, float var2, int var3) {
      boolean var4 = this.bool6;
      this.bool6 = false;
      return var4;
   }

   private float getFloat164() {
      return this.float_3 + 3.0F;
   }
}
