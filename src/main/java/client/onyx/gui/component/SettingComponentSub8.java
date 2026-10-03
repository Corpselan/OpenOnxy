package client.onyx.gui.component;

import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import client.onyx.render.misc.Util;
import client.onyx.setting.MinMaxRecord;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;

public class SettingComponentSub8 extends SettingComponent {
   private final client.onyx.render.misc.Cls cls3;
   private static final float FLOAT5 = 5.0F;
   private int int_;
   private int int_2;
   private float float_5;
   private static final float FLOAT6 = 16.0F;
   private static final float FLOAT7 = 3.0F;
   private static final float FLOAT8 = 3.0F;
   private static final float FLOAT9 = 3.0F;
   private final client.onyx.render.misc.Cls cls4 = new client.onyx.render.misc.Cls(3.0F);
   private final ValueSettingSub3 valueSettingSub3;

   private void handleFloat88(float var1) {
      double var2 = this.valueSettingSub3.getDouble2((var1 - this.getFloat191()) / this.getFloat188());
      double var4 = this.int_2 == 0 ? this.valueSettingSub3.getDouble6() : this.valueSettingSub3.getDouble8();
      this.valueSettingSub3.handleObject2(new MinMaxRecord(var4, var2));
      if (var2 < var4) {
         this.int_2 = 0;
      } else {
         if (var2 > var4) {
            this.int_2 = 1;
         }
      }
   }

   @Override
   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      return this.getFloat187() - this.float_ + 3.0F + 6.0F;
   }

   public SettingComponentSub8(ValueSettingSub3 var1) {
      super(var1);
      this.cls3 = new client.onyx.render.misc.Cls(3.0F);
      this.int_2 = -1;
      this.int_ = -1;
      this.valueSettingSub3 = var1;
   }

   private float getFloat189() {
      return this.getFloat187() + 1.5F;
   }

   @Override
   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      Sampler0 var7;
      Sampler0 var10000 = var7 = var1.sampler0;
      float var10 = var1.sampler0.getFloat17(Util2.OPTICAL_WEIGHT_RECORD2, this.valueSettingSub3.getString7());
      this.handleCls225(var1, this.float_4 - var10 - 12.0F);
      var10000.handleOpticalWeightRecord6(
         Util2.OPTICAL_WEIGHT_RECORD2,
         this.valueSettingSub3.getString7(),
         this.float_3 + this.float_4,
         this.getFloat181(),
         this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant())
      );
      var10 = this.getFloat189();
      float var5 = this.getFloat190(this.valueSettingSub3.getDouble8());
      float var6 = this.getFloat190(this.valueSettingSub3.getDouble6());
      float var3 = this.cls4.getFloat() / 2.0F;
      float var8 = this.cls3.getFloat() / 2.0F;
      float var9;
      if ((var9 = var5 - var3 - 5.0F) > this.float_3) {
         var7.handleFloat7(
            this.float_3, var10 - 1.5F, var9 - this.float_3, 3.0F, Float.MAX_VALUE, this.getInt72(var1.getPrimaryOnPrimaryRecord().surfaceContainerHighest())
         );
      }

      var3 = var5 + var3 + 5.0F;
      if ((var9 = var6 - var8 - 5.0F) > var3) {
         var7.handleFloat7(var3, var10 - 1.5F, var9 - var3, 3.0F, Float.MAX_VALUE, this.getInt72(var1.getPrimaryOnPrimaryRecord().primary()));
      }

      if ((var3 = var6 + var8 + 5.0F) < this.float_3 + this.float_4) {
         var7.handleFloat7(
            var3,
            var10 - 1.5F,
            this.float_3 + this.float_4 - var3,
            3.0F,
            Float.MAX_VALUE,
            this.getInt72(var1.getPrimaryOnPrimaryRecord().surfaceContainerHighest())
         );
      }

      this.handleCls227(var1, var2, var5, var10, this.cls4.getFloat(), 0);
      this.handleCls227(var1, var2, var6, var10, this.cls3.getFloat(), 1);
   }

   private float getFloat191() {
      return this.float_3 + 3.0F;
   }

   @Override
   public boolean isFloat19(float var1, float var2, int var3) {
      boolean var4 = this.int_2 >= 0;
      this.int_2 = -1;
      return var4;
   }

   private void handleCls8(client.onyx.render.misc.Cls var1, int var2) {
      float var4 = this.int_2 == var2 ? 1.5F : (this.int_ == var2 ? 4.5F : 3.0F);
      if (var1.getFloat2() != var4) {
         var1.getCls2(var4, 150.0F, Util.IFACE6);
      }
   }

   private float getFloat190(double var1) {
      return this.getFloat191() + this.getFloat188() * (float)this.valueSettingSub3.getDouble5(var1);
   }

   private double getDouble34() {
      return this.valueSettingSub3.getDouble4() > 0.0
         ? this.valueSettingSub3.getDouble4()
         : (this.valueSettingSub3.getDouble3() - this.valueSettingSub3.getDouble9()) / 100.0;
   }

   private int getInt73(float var1) {
      float var2 = Math.abs(var1 - this.getFloat190(this.valueSettingSub3.getDouble8()));
      var1 = Math.abs(var1 - this.getFloat190(this.valueSettingSub3.getDouble6()));
      return var2 <= var1 ? 0 : 1;
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      this.int_ = -1;
      this.float_5 = var1.float_3;
      if (Math.abs(var1.float_2 - this.getFloat189()) <= 16.0F) {
         float var2 = Math.abs(var1.float_3 - this.getFloat190(this.valueSettingSub3.getDouble8()));
         float var3 = Math.abs(var1.float_3 - this.getFloat190(this.valueSettingSub3.getDouble6()));
         if (Math.min(var2, var3) <= 8.0F) {
            this.int_ = var2 <= var3 ? 0 : 1;
         }
      }

      this.handleCls8(this.cls4, 0);
      this.handleCls8(this.cls3, 1);
      this.cls4.handleFloat(var1.float_);
      this.cls3.handleFloat(var1.float_);
      if (this.int_2 >= 0) {
         this.handleFloat88(var1.float_3);
      }
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (!this.isEnabled163() || var3 != 0 || !this.isFloat15(var1, var2)) {
         return false;
      } else if (var2 < this.getFloat185()) {
         return false;
      } else {
         this.int_2 = this.getInt73(var1);
         this.handleFloat88(var1);
         return true;
      }
   }

   private void handleCls227(client.onyx.gui.Cls2 var1, float var2, float var3, float var4, float var5, int var6) {
      Sampler0 var8 = var1.sampler0;
      if (this.int_ == var6 || this.int_2 == var6) {
         var8.handleFloat23(var3, var4, 11.0F, Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().primary(), var2 * (this.int_2 == var6 ? 0.1F : 0.08F)));
      }

      var8.handleFloat7(var3 - var5 / 2.0F, var4 - 8.0F, var5, 16.0F, Float.MAX_VALUE, this.getInt72(var1.getPrimaryOnPrimaryRecord().primary()));
   }

   private float getFloat188() {
      return this.float_4 - 6.0F;
   }

   @Override
   public boolean isFloat18(float var1, float var2, int var3, float var4, float var5) {
      if (this.int_2 < 0) {
         return false;
      } else {
         this.handleFloat88(var1);
         return true;
      }
   }

   @Override
   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      if (this.isEnabled163() && this.bool) {
         // 按字节码还原：203 = 左方向键，205 = 右方向键
         double var2 = switch (var1.key()) {
            case 203 -> -this.getDouble34();
            case 205 -> this.getDouble34();
            default -> 0.0;
         };
         if (var2 == 0.0) {
            return false;
         } else {
            if (this.getInt73(this.float_5) == 0) {
               this.valueSettingSub3.handleDouble(this.valueSettingSub3.getDouble8() + var2);
            } else {
               this.valueSettingSub3.handleDouble2(this.valueSettingSub3.getDouble6() + var2);
            }

            return true;
         }
      } else {
         return false;
      }
   }
}
