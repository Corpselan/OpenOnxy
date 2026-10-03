package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.render.misc.Util;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.BooleanSettingSub;
import client.onyx.setting.ModeSetting;
import client.onyx.setting.Setting;
import client.onyx.setting.impl.NoneValueSetting;
import client.onyx.setting.impl.SettingSub;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub2;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.setting.impl.ValueSettingSub4;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub8;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;

public abstract class SettingComponent extends GuiComponent {
   private final client.onyx.render.misc.Cls cls = new client.onyx.render.misc.Cls(0.0F);
   private final client.onyx.render.misc.Cls cls2 = new client.onyx.render.misc.Cls(0.0F);
   protected final Setting setting;
   protected static final float FLOAT = 6.0F;
   protected static final float FLOAT2 = 3.0F;
   protected static final float FLOAT3 = 13.5F;
   private boolean bool4;
   protected static final OpticalWeightRecord OPTICAL_WEIGHT_RECORD = Util2.OPTICAL_WEIGHT_RECORD15;
   private boolean bool5;
   public static final float FLOAT4 = 15.0F;
   protected static final OpticalWeightRecord OPTICAL_WEIGHT_RECORD2 = Util2.OPTICAL_WEIGHT_RECORD2;

   protected float getFloat185() {
      return this.isEnabled162() ? this.getFloat180() + OPTICAL_WEIGHT_RECORD2.getFloat4() : this.getFloat186();
   }

   protected float getFloat178() {
      return this.getFloat185() - this.float_ + 6.0F;
   }

   protected float getFloat180() {
      return this.getFloat186() + this.getOpticalWeightRecord3().getFloat() + 3.0F;
   }

   public float getFloat183() {
      return this.cls.getFloat();
   }

   public Setting getSetting3() {
      return this.setting;
   }

   protected void handleCls224(client.onyx.gui.Cls2 var1, float var2) {
      if (this.isEnabled162()) {
         var1.sampler0
            .handleOpticalWeightRecord2(
               OPTICAL_WEIGHT_RECORD2,
               var1.sampler0.getString17(OPTICAL_WEIGHT_RECORD2, this.setting.getString2(), var2),
               this.float_3,
               this.getFloat180(),
               this.getInt72(Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.85F))
            );
      }
   }

   protected float getFloat186() {
      return this.float_ + 6.0F + this.getOpticalWeightRecord3().getFloat4();
   }

   protected abstract void handleCls226(client.onyx.gui.Cls2 var1, float var2);

   protected float getFloat179() {
      return this.cls2.getFloat();
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      float var3;
      if (!((var3 = this.cls2.getFloat()) <= 0.01F)) {
         this.handleCls226(var1, var3);
      }
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      return this.isEnabled163() && super.isFloat17(var1, var2, var3);
   }

   protected float getFloat187() {
      return this.getFloat185() + 13.5F;
   }

   protected int getInt72(int var1) {
      float var2 = this.getFloat179();
      float var5 = client.onyx.theme.impl.Util2.getIntForInt6(var1) / 255.0F;
      float var6 = var2 * var5;
      return Util4.getIntForInt2(var1, var6);
   }

   protected boolean isEnabled162() {
      return !this.setting.getString2().isEmpty();
   }

   public static SettingComponent getSettingComponentForSetting(Setting var0) {
      if (var0 instanceof ValueSettingSub9 var15) {
         return new SettingComponentSub10(var15);
      } else if (var0 instanceof ValueSettingSub10 var14) {
         return new SettingComponentSub5(var14);
      } else if (var0 instanceof ValueSettingSub3 var13) {
         return new SettingComponentSub8(var13);
      } else if (var0 instanceof ValueSettingSub11 var12) {
         return new SettingComponentSub3(var12);
      } else if (var0 instanceof ValueSettingSub var11) {
         return new SettingComponentSub(var11);
      } else if (var0 instanceof ValueSettingSub8 var10) {
         return new SettingComponentSub7(var10);
      } else if (var0 instanceof ValueSettingSub6 var9) {
         return new UseAccentColourSettingComponent(var9);
      } else if (var0 instanceof SettingSub var8) {
         return new SettingComponentSub11(var8);
      } else if (var0 instanceof NoneValueSetting var7) {
         return new ToggleSettingComponent(var7);
      } else if (var0 instanceof ValueSettingSub2 var6) {
         return new SearchBlocksSettingComponent(var6);
      } else if (var0 instanceof ValueSettingSub4 var5) {
         return new SettingComponentSub6(var5);
      } else if (var0 instanceof ModeSetting var4) {
         return new SettingComponentSub4(var4);
      } else if (var0 instanceof BooleanSettingSub var3) {
         return new SettingComponentSub2(var3);
      } else {
         return var0 instanceof BooleanSetting var2 ? new SettingComponentSub9(var2) : null;
      }
   }

   protected SettingComponent(Setting var1) {
      this.setting = var1;
   }

   protected void handleCls225(client.onyx.gui.Cls2 var1, float var2) {
      var1.sampler0
         .handleOpticalWeightRecord2(
            this.getOpticalWeightRecord3(),
            var1.sampler0.getString17(this.getOpticalWeightRecord3(), this.setting.getString3(), var2),
            this.float_3,
            this.float_ + 6.0F,
            this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurface())
         );
      this.handleCls224(var1, var2);
   }

   public float getFloat184() {
      return this.cls2.getFloat();
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      boolean var4 = this.setting.isEnabled4();
      float var3 = this.getFloat182(var1);
      if (!this.bool5) {
         this.bool5 = true;
         this.bool4 = var4;
         this.cls.getCls(var4 ? var3 : 0.0F);
         this.cls2.getCls(var4 ? 1.0F : 0.0F);
      }

      SettingComponent var10000;
      if (var4 != this.bool4) {
         this.bool4 = var4;
         this.cls.getCls2(var4 ? var3 : 0.0F, 300.0F, Util.IFACE2);
         this.cls2.getCls2(var4 ? 1.0F : 0.0F, 200.0F, Util.IFACE6);
         var10000 = this;
      } else {
         if (var4 && this.cls.isEnabled() && this.cls.getFloat2() != var3) {
            this.cls.getCls(var3);
         }

         var10000 = this;
      }

      var10000.cls.handleFloat(var1.float_);
      this.cls2.handleFloat(var1.float_);
   }

   protected abstract float getFloat182(client.onyx.gui.Cls2 var1);

   protected OpticalWeightRecord getOpticalWeightRecord3() {
      return OPTICAL_WEIGHT_RECORD;
   }

   protected boolean isEnabled163() {
      return this.cls2.getFloat() > 0.95F;
   }

   protected float getFloat181() {
      return this.float_ + 6.0F + this.getOpticalWeightRecord3().getFloat4() / 2.0F;
   }
}
