package client.onyx.gui.component;

import client.onyx.render.Sampler0;
import client.onyx.render.misc.Util;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.theme.Util4;
import client.onyx.theme.impl.Util2;

public class UseAccentColourSettingComponent extends SettingComponent {
   private final client.onyx.gui.Cls cls3;
   private static final float FLOAT5 = 6.0F;
   private float float_5;
   private final client.onyx.render.misc.Cls cls4 = new client.onyx.render.misc.Cls(0.0F);
   private static final float FLOAT6 = 1.0F;
   private boolean bool6;
   private float float_6;
   private final ValueSettingSub6 valueSettingSub6;
   private static final int[] INT_ARRAY;
   private static final float FLOAT7 = 3.0F;
   private static final float FLOAT8 = 11.0F;
   private final client.onyx.gui.Cls cls5;
   private static final float FLOAT9 = 15.0F;
   private static final float FLOAT10 = 12.0F;
   private static final float FLOAT11 = 120.0F;
   private static final float FLOAT12 = 0.32F;
   private float float_7;
   private static final float FLOAT13 = 9.0F;
   private static final float FLOAT14 = 13.0F;
   private final client.onyx.render.misc.Cls cls6;
   private int int_;
   private static final float FLOAT15 = 15.0F;
   private UseAccentColourSettingComponent.NoneShadeEnum noneShadeEnum;
   private static final float FLOAT16 = 14.0F;
   private static final float FLOAT17 = 18.0F;

   private boolean isFloat22(float var1, float var2) {
      if (var1 >= this.float_3) {
         float var4 = this.float_3 + this.float_4;
         if (var1 < var4 && var2 >= this.float_ && var2 < this.float_ + this.getFloat178()) {
            return true;
         }
      }

      return false;
   }

   private float getFloat155() {
      return this.float_4 - 30.0F * this.getFloat152() - 3.0F;
   }

   private float getFloat156() {
      return this.getFloat157() + 18.0F + 12.0F;
   }

   private float getFloat153() {
      return this.float_3 + this.float_4 - 11.0F - 8.0F - 9.0F;
   }

   @Override
   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      float var4 = this.getFloat178();
      float var3 = this.isEnabled160() ? 29.0F : 0.0F;
      return var4 + (this.getFloat187() - this.float_ + 120.0F + var3 + 6.0F - var4) * this.cls4.getFloat();
   }

   private void run197() {
      if (this.valueSettingSub6.getInt7() != this.int_) {
         float[] var2;
         if ((var2 = Util2.getFloatArrayForInt(this.valueSettingSub6.getInt7()))[1] > 0.001F) {
            this.float_7 = var2[0];
         }

         this.float_5 = var2[1];
         this.float_6 = var2[2];
         this.int_ = this.valueSettingSub6.getInt7();
      }
   }

   private boolean isFloat24(float var1, float var2) {
      float var4 = this.getFloat154();
      if (var1 >= this.float_3) {
         float var6 = this.float_3 + this.float_4;
         if (var1 < var6 && var2 >= var4 && var2 < var4 + 15.0F) {
            return true;
         }
      }

      return false;
   }

   private void handleCls222(client.onyx.gui.Cls2 var1) {
      Sampler0 var2 = var1.sampler0;
      float var5 = this.getFloat187();
      float var4 = this.getFloat156();
      var2.handleFloat7(var4, var5, 18.0F, 120.0F, Float.MAX_VALUE, this.getInt72(var1.getPrimaryOnPrimaryRecord().surfaceContainerHighest()));
      var2.handleFloat21(
         var4, var5, 18.0F, 120.0F, Float.MAX_VALUE, this.getInt72(this.valueSettingSub6.getInt6()), this.getInt72(this.valueSettingSub6.getInt6()), 0, 0
      );
      this.handleCls219(var1, var4, var5 + (1.0F - Util2.getIntForInt6(this.valueSettingSub6.getInt7()) / 255.0F) * 120.0F);
   }

   private boolean isEnabled160() {
      return this.valueSettingSub6.isEnabled14();
   }

   private float getFloat154() {
      return this.getFloat187() + 120.0F + 14.0F;
   }

   private void handleCls220(client.onyx.gui.Cls2 var1) {
      float var2 = this.getFloat187();
      switch (this.noneShadeEnum) {
         case SHADE:

            this.float_5 = Math.clamp((var1.float_3 - this.float_3) / this.getFloat155(), 0.0F, 1.0F);
            this.float_6 = 1.0F - Math.clamp((var1.float_2 - var2) / 120.0F, 0.0F, 1.0F);
            this.run198();
            return;
         case HUE:
            this.float_7 = Math.clamp((var1.float_2 - var2) / 120.0F, 0.0F, 1.0F) * 360.0F;
            this.run198();
            return;
         case ALPHA:
            float var3 = 1.0F - Math.clamp((var1.float_2 - var2) / 120.0F, 0.0F, 1.0F);
            this.int_ = Util2.getIntForInt3(this.valueSettingSub6.getInt7(), var3);
            this.valueSettingSub6.handleObject2(this.int_);
            return;
      }
   }

   @Override
   public boolean isFloat19(float var1, float var2, int var3) {
      boolean var4 = this.noneShadeEnum != UseAccentColourSettingComponent.NoneShadeEnum.NONE;
      this.noneShadeEnum = UseAccentColourSettingComponent.NoneShadeEnum.NONE;
      return var4;
   }

   private float getFloat157() {
      return this.float_3 + this.getFloat155() + 12.0F;
   }

   private void run198() {
      int var2;
      this.int_ = var2 = Util2.getIntForFloat(this.float_7, this.float_5, this.float_6, Util2.getIntForInt6(this.valueSettingSub6.getInt7()));
      this.valueSettingSub6.handleObject2(var2);
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (!this.isEnabled163() || var3 != 0) {
         return false;
      } else if (this.isFloat22(var1, var2)) {
         this.bool6 = !this.bool6;
         this.cls4.getCls2(this.bool6 ? 1.0F : 0.0F, 300.0F, Util.IFACE2);
         return true;
      } else if (this.cls4.getFloat() < 0.5F) {
         return false;
      } else if (this.isEnabled160() && this.isFloat24(var1, var2)) {
         this.valueSettingSub6.handleBool2(!this.valueSettingSub6.isEnabled13());
         return true;
      } else if (this.valueSettingSub6.isEnabled13()) {
         return false;
      } else {
         if (this.isFloat23(var1, var2, this.float_3, this.getFloat155())) {
            this.noneShadeEnum = UseAccentColourSettingComponent.NoneShadeEnum.SHADE;
         } else if (this.isFloat23(var1, var2, this.getFloat157(), 18.0F)) {
            this.noneShadeEnum = UseAccentColourSettingComponent.NoneShadeEnum.HUE;
         } else {
            if (!this.valueSettingSub6.isEnabled12()) {
               return false;
            }

            float var4 = this.getFloat156();
            if (!this.isFloat23(var1, var2, var4, 18.0F)) {
               return false;
            }

            this.noneShadeEnum = UseAccentColourSettingComponent.NoneShadeEnum.ALPHA;
         }

         return true;
      }
   }

   private void handleCls218(client.onyx.gui.Cls2 var1) {
      Sampler0 var7 = var1.sampler0;
      float var8 = this.getFloat154();
      float var4 = this.float_3 + this.float_4 - 15.0F;
      float var5 = var8 + 0.0F;
      float var6 = var8 + 7.5F;
      float var2 = this.cls6.getFloat();
      this.cls5
         .handleSampler0(var7, this.float_3 - 6.0F, var8 - 6.0F, this.float_4 + 12.0F, 27.0F, 8.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurface()));
      var7.handleOpticalWeightRecord9(
         client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD15, "Use accent colour", this.float_3, var6, this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurface())
      );
      if (var2 > 0.01F) {
         var8 = (1.0F - var2) * 15.0F / 2.0F;
         var7.handleFloat7(var4 + var8, var5 + var8, 15.0F - var8 * 2.0F, 15.0F - var8 * 2.0F, 4.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().primary()));
      }

      if (var2 < 0.99F) {
         var7.handleFloat18(var4, var5, 15.0F, 15.0F, 4.0F, 1.5F, this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()));
      }

      if (var2 > 0.15F) {
         var8 = Math.clamp((var2 - 0.15F) / 0.85F, 0.0F, 1.0F);
         client.onyx.gui.Util.handleSampler06(
            var7,
            var4 + 7.5F,
            var5 + 7.5F,
            13.0F * (0.7F + 0.3F * var8),
            this.getInt72(Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onPrimary(), var8))
         );
      }
   }

   static {
      int[] var0 = new int[]{-65536, -256, -16711936, -16711681, -16776961, -65281, -65536};
      INT_ARRAY = var0;
   }

   private float getFloat152() {
      return this.valueSettingSub6.isEnabled12() ? 2.0F : 1.0F;
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      this.cls4.handleFloat(var1.float_);
      this.cls3.handleFloat(var1.float_, this.isFloat22(var1.float_3, var1.float_2), false);
      boolean var2 = this.isEnabled160() && this.cls4.getFloat() > 0.5F && this.isFloat24(var1.float_3, var1.float_2);
      this.cls5.handleFloat(var1.float_, var2, false);
      if (this.cls6.getFloat2() != (this.valueSettingSub6.isEnabled13() ? 1.0F : 0.0F)) {
         this.cls6.getCls2(this.valueSettingSub6.isEnabled13() ? 1.0F : 0.0F, 200.0F, Util.IFACE2);
      }

      this.cls6.handleFloat(var1.float_);
      if (this.noneShadeEnum == UseAccentColourSettingComponent.NoneShadeEnum.NONE) {
         this.run197();
      } else {
         this.handleCls220(var1);
      }
   }

   private boolean isFloat23(float var1, float var2, float var3, float var4) {
      float var6 = this.getFloat187();
      return var1 >= var3 && var1 < var3 + var4 && var2 >= var6 && var2 < var6 + 120.0F;
   }

   @Override
   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      Sampler0 var5 = var1.sampler0;
      this.cls3
         .handleSampler0(
            var5, this.float_3 - 6.0F, this.float_, this.float_4 + 12.0F, this.getFloat178(), 8.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurface())
         );
      String var3 = this.valueSettingSub6.getString9();
      float var4 = this.getFloat153() - 9.0F - 8.0F;
      this.handleCls225(var1, var4 - var5.getFloat17(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2, var3) - 12.0F - this.float_3);
      var5.handleOpticalWeightRecord6(
         client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2, var3, var4, this.getFloat181(), this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant())
      );
      var5.handleFloat23(this.getFloat153(), this.getFloat181(), 9.0F, this.getInt72(this.valueSettingSub6.getInt8()));
      var5.handleFloat22(this.getFloat153(), this.getFloat181(), 9.0F, 1.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().outline()));
      var5.run36();
      var5.getCls32().getCls35(this.float_3 + this.float_4 - 5.5F, this.getFloat181());
      var5.getCls32().getCls32((float) Math.PI * this.cls4.getFloat());
      client.onyx.gui.Util.handleSampler07(var5, 0.0F, 0.0F, 11.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()));
      var5.run43();
      float var6 = this.cls4.getFloat();
      if (!(var6 <= 0.01F)) {
         var5.handleFloat24(this.float_3 - 6.0F, this.float_, this.float_4 + 12.0F, this.float_2);
         var5.handleFloat10(var6);
         var5.handleFloat10(1.0F - 0.68F * this.cls6.getFloat());
         this.handleCls217(var1);
         this.handleCls221(var1);
         if (this.valueSettingSub6.isEnabled12()) {
            this.handleCls222(var1);
         }

         var5.run40();
         if (this.isEnabled160()) {
            this.handleCls218(var1);
         }

         var5.run40();
         var5.run38();
      }
   }

   private void handleCls221(client.onyx.gui.Cls2 var1) {
      Sampler0 var7 = var1.sampler0;
      float var3 = this.getFloat187();
      float var4 = this.getFloat157();
      float var5 = 20.0F;
      float var6 = 9.0F;

      int var14;
      for (int var10000 = var14 = 0; var10000 < 6; var10000 = var14) {
         float var8;
         float var9 = (var8 = var3 + var14 * var5) + var5 + (var14 == 5 ? 0.0F : 1.0F);
         float var10 = var14 == 0 ? var6 : 0.0F;
         float var11 = var14 == 5 ? var6 : 0.0F;
         int var12 = INT_ARRAY[var14];
         int var13 = Util2.getIntForFloat((var9 - var3) / 120.0F * 360.0F, 1.0F, 1.0F, 255);
         float var10004 = var9 - var8;
         int var10009 = this.getInt72(var12);
         int var10010 = this.getInt72(var12);
         int var10011 = this.getInt72(var13);
         var14++;
         var7.handleFloat16(var4, var8, 18.0F, var10004, var10, var10, var11, var11, var10009, var10010, var10011, this.getInt72(var13));
      }

      this.handleCls219(var1, var4, var3 + this.float_7 / 360.0F * 120.0F);
   }

   private void handleCls219(client.onyx.gui.Cls2 var1, float var2, float var3) {
      Sampler0 var5 = var1.sampler0;
      var5.handleFloat7(var2 - 3.0F, var3 - 3.0F, 24.0F, 6.0F, Float.MAX_VALUE, this.getInt72(-1));
      var5.handleFloat18(
         var2 - 3.0F, var3 - 3.0F, 24.0F, 6.0F, Float.MAX_VALUE, 1.0F, this.getInt72(Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().scrim(), 0.35F))
      );
   }

   private void handleCls217(client.onyx.gui.Cls2 var1) {
      Sampler0 var4 = var1.sampler0;
      float var6 = this.getFloat187();
      float var2 = this.getFloat155();
      int var5 = Util2.getIntForFloat(this.float_7, 1.0F, 1.0F, 255);
      var4.handleFloat21(this.float_3, var6, var2, 120.0F, 12.0F, this.getInt72(-1), this.getInt72(var5), this.getInt72(var5), this.getInt72(-1));
      var4.handleFloat21(this.float_3, var6, var2, 120.0F, 12.0F, 0, 0, this.getInt72(-16777216), this.getInt72(-16777216));
      var4.handleFloat18(this.float_3, var6, var2, 120.0F, 12.0F, 1.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().outlineVariant()));
      float var7 = this.float_3 + this.float_5 * var2;
      var6 += (1.0F - this.float_6) * 120.0F;
      var4.handleFloat23(var7, var6, 6.0F, this.getInt72(-1));
      var4.handleFloat23(var7, var6, 4.5F, this.getInt72(this.valueSettingSub6.getInt6()));
   }

   public UseAccentColourSettingComponent(ValueSettingSub6 var1) {
      super(var1);
      this.cls3 = new client.onyx.gui.Cls();
      this.cls5 = new client.onyx.gui.Cls();
      this.cls6 = new client.onyx.render.misc.Cls(0.0F);
      this.noneShadeEnum = UseAccentColourSettingComponent.NoneShadeEnum.NONE;
      this.valueSettingSub6 = var1;
      float[] var2;
      this.float_7 = (var2 = Util2.getFloatArrayForInt(var1.getInt7()))[0];
      this.float_5 = var2[1];
      this.float_6 = var2[2];
      this.int_ = var1.getInt7();
      this.cls6.getCls(var1.isEnabled13() ? 1.0F : 0.0F);
   }

   private static enum NoneShadeEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      NONE,
      SHADE,
      HUE,
      ALPHA;

   }
}
