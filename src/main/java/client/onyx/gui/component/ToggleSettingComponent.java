package client.onyx.gui.component;

import client.onyx.input.KeyScancodeRecord;
import client.onyx.module.ToggleHoldEnum;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.render.misc.Util;
import client.onyx.setting.impl.NoneValueSetting;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;

public class ToggleSettingComponent extends SettingComponent {
   private final client.onyx.render.misc.Cls cls3;
   private boolean bool6;
   private static final float FLOAT5 = 12.0F;
   private final client.onyx.gui.Cls[] clsArray;
   private final client.onyx.gui.Cls cls4 = new client.onyx.gui.Cls();
   private static final ToggleHoldEnum[] TOGGLE_HOLD_ENUM_ARRAY;
   private static final String[] STRING_ARRAY;
   private boolean bool7;
   private static final float FLOAT6 = 20.0F;
   private static final float FLOAT7 = 8.0F;
   private float float_5;
   private float float_6;
   private final NoneValueSetting noneValueSetting;

   public ToggleSettingComponent(NoneValueSetting var1) {
      super(var1);
      client.onyx.gui.Cls[] var10001 = new client.onyx.gui.Cls[2];
      boolean var10003 = true;
      var10001[0] = new client.onyx.gui.Cls();
      var10001[1] = new client.onyx.gui.Cls();
      this.clsArray = var10001;
      this.cls3 = new client.onyx.render.misc.Cls(0.0F);
      this.noneValueSetting = var1;
   }

   private boolean isEnabled158() {
      return this.noneValueSetting.getValueSettingSub11() != null;
   }

   private String getString40() {
      return this.bool7 ? "Press a key..." : this.noneValueSetting.getString12();
   }

   private float getFloat145(client.onyx.gui.Cls2 var1) {
      return Math.max(58.0F, var1.sampler0.getFloat17(Util2.OPTICAL_WEIGHT_RECORD16, this.getString40()) + 20.0F);
   }

   private int getInt65(float var1, float var2) {
      if (!this.isEnabled157()) {
         return -1;
      } else if (!(var2 < this.getFloat143()) && !(var2 >= this.getFloat143() + 20.0F)) {
         return !((var1 -= this.float_6) < 0.0F) && !(var1 >= this.getFloat149()) ? (int)(var1 / this.float_5) : -1;
      } else {
         return -1;
      }
   }

   private int getInt66(int var1) {
      float var2 = this.getFloat179();
      float var3 = this.cls3.getFloat();
      float var4 = var2 * var3;
      float var7 = (float)client.onyx.theme.impl.Util2.getIntForInt6(var1) / 255.0F;
      float var8 = var4 * var7;
      return Util4.getIntForInt2(var1, var8);
   }

   private boolean isEnabled157() {
      return this.isEnabled158() && this.cls3.getFloat() > 0.95F;
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      float var2 = this.isEnabled158() && this.noneValueSetting.isEnabled19() ? 1.0F : 0.0F;
      ToggleSettingComponent var10000;
      if (!this.bool6) {
         this.bool6 = true;
         var10000 = this;
         this.cls3.getCls(var2);
      } else {
         if (this.cls3.getFloat2() != var2) {
            this.cls3.getCls2(var2, 200.0F, Util.IFACE6);
         }

         var10000 = this;
      }

      boolean var10;
      label40: {
         var10000.cls3.handleFloat(var1.float_);
         this.float_5 = this.getFloat144(var1);
         this.float_6 = this.getFloat148(var1);
         if (var1.float_3 >= this.getFloat147(var1)) {
            float var4 = var1.float_3;
            float var6 = this.float_3 + this.float_4;
            if (var4 < var6 && var1.float_2 >= this.getFloat143() && var1.float_2 < this.getFloat143() + 20.0F) {
               var10 = true;
               break label40;
            }
         }

         var10 = false;
      }

      boolean var8 = var10;
      this.cls4.handleFloat(var1.float_, var8, this.bool7);
      int var9 = this.getInt65(var1.float_3, var1.float_2);

      int var3;
      for(int var11 = var3 = 0; var11 < this.clsArray.length; var11 = var3) {
         client.onyx.gui.Cls var12 = this.clsArray[var3];
         boolean var10002 = var9 == var3;
         ++var3;
         var12.handleFloat(var1.float_, var10002, false);
      }

   }

   private float getFloat146(int var1) {
      return this.float_6 + (float)var1 * this.float_5;
   }

   private float getFloat149() {
      return this.float_5 * (float)TOGGLE_HOLD_ENUM_ARRAY.length;
   }

   private float getFloat148(client.onyx.gui.Cls2 var1) {
      return this.getFloat147(var1) - 8.0F - this.getFloat149();
   }

   private float getFloat144(client.onyx.gui.Cls2 var1) {
      float var7 = 0.0F;
      String[] var5;
      int var4 = (var5 = STRING_ARRAY).length;

      int var3;
      for(int var10000 = var3 = 0; var10000 < var4; var10000 = var3) {
         String var6 = var5[var3];
         ++var3;
         var7 = Math.max(var7, var1.sampler0.getFloat17(Util2.OPTICAL_WEIGHT_RECORD16, var6));
      }

      return var7 + 24.0F;
   }

   static {
      ToggleHoldEnum[] var0 = new ToggleHoldEnum[]{ToggleHoldEnum.TOGGLE, ToggleHoldEnum.HOLD};
      TOGGLE_HOLD_ENUM_ARRAY = var0;
      String[] var1 = new String[]{"Toggle", "Hold"};
      STRING_ARRAY = var1;
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.isEnabled163() && this.isFloat15(var1, var2)) {
         int var4;
         if ((var4 = this.getInt65(var1, var2)) >= 0) {
            if (var3 != 0) {
               return true;
            } else {
               this.noneValueSetting.getValueSettingSub11().handleObject2(TOGGLE_HOLD_ENUM_ARRAY[var4]);
               return true;
            }
         } else if (var3 == 1) {
            this.noneValueSetting.run11();
            this.bool7 = false;
            return true;
         } else if (var3 == 0) {
            this.bool7 = !this.bool7;
            return true;
         } else if (this.bool7 && var3 >= 2) {
            this.bool7 = false;
            this.noneValueSetting.handleInt6(var3);
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private float getFloat143() {
      return this.getFloat181() - 10.0F;
   }

   private float getFloat147(client.onyx.gui.Cls2 var1) {
      float var3 = this.float_3 + this.float_4;
      float var4 = this.getFloat145(var1);
      return var3 - var4;
   }

   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      if (!this.bool7) {
         return false;
      } else {
         this.bool7 = false;
         if (var1.key() == 1) {
            this.noneValueSetting.run11();
         } else {
            this.noneValueSetting.handleInt7(var1.key());
         }

         return true;
      }
   }

   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      Sampler0 var7 = var1.sampler0;
      float var4 = this.getFloat145(var1);
      float var3 = this.getFloat147(var1);
      float var5 = this.getFloat143();
      float var6 = (this.cls3.getFloat() > 0.01F ? this.float_6 : var3) - 10.0F - this.float_3;
      this.handleCls225(var1, var6);
      this.handleCls216(var1, var5);
      ToggleSettingComponent var10000;
      if (this.bool7) {
         var7.handleFloat7(var3, var5, var4, 20.0F, Float.MAX_VALUE, this.getInt72(var1.getPrimaryOnPrimaryRecord().secondaryContainer()));
         var10000 = this;
      } else {
         var7.handleFloat18(var3, var5, var4, 20.0F, Float.MAX_VALUE, 1.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().outline()));
         var10000 = this;
      }

      var10000.cls4.handleSampler0(var7, var3, var5, var4, 20.0F, Float.MAX_VALUE, this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurface()));
      var7.handleOpticalWeightRecord4(Util2.OPTICAL_WEIGHT_RECORD16, this.getString40(), var3 + var4 / 2.0F, this.getFloat181(), this.getInt72(this.bool7 ? var1.getPrimaryOnPrimaryRecord().onSecondaryContainer() : var1.getPrimaryOnPrimaryRecord().onSurface()));
   }

   private int getInt64() {
      return this.noneValueSetting.getValueSettingSub11() != null && this.noneValueSetting.getValueSettingSub11().isEnum3(ToggleHoldEnum.HOLD) ? 1 : 0;
   }

   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      return this.getFloat178();
   }

   private void handleCls216(client.onyx.gui.Cls2 var1, float var2) {
      if (this.isEnabled158() && !(this.cls3.getFloat() <= 0.01F)) {
         Sampler0 var6;
         Sampler0 var10000 = var6 = var1.sampler0;
         int var4 = this.getInt64();
         float var5 = 10.0F;
         var10000.handleFloat18(this.float_6, var2, this.getFloat149(), 20.0F, Float.MAX_VALUE, 1.0F, this.getInt66(var1.getPrimaryOnPrimaryRecord().outline()));

         int var11;
         for(int var13 = var11 = 0; var13 < TOGGLE_HOLD_ENUM_ARRAY.length; var13 = var11) {
            float var7 = this.getFloat146(var11);
            boolean var8 = var11 == 0;
            boolean var9 = var11 == TOGGLE_HOLD_ENUM_ARRAY.length - 1;
            float var10 = var8 ? var5 : 0.0F;
            float var12 = var9 ? var5 : 0.0F;
            if (var11 == var4) {
               var6.handleFloat15(var7, var2, this.float_5, 20.0F, var10, var12, var12, var10, this.getInt66(var1.getPrimaryOnPrimaryRecord().secondaryContainer()));
            }

            this.clsArray[var11].handleSampler0(var6, var7, var2, this.float_5, 20.0F, Math.max(var10, var12), this.getInt66(var1.getPrimaryOnPrimaryRecord().onSurface()));
            if (!var8) {
               var6.handleFloat28(var7, var2, 1.0F, 20.0F, this.getInt66(var1.getPrimaryOnPrimaryRecord().outline()));
            }

            OpticalWeightRecord var10001 = Util2.OPTICAL_WEIGHT_RECORD16;
            String var10002 = STRING_ARRAY[var11];
            float var10003 = var7 + this.float_5 / 2.0F;
            float var10004 = this.getFloat181();
            int var10005 = this.getInt66(var11 == var4 ? var1.getPrimaryOnPrimaryRecord().onSecondaryContainer() : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant());
            ++var11;
            var6.handleOpticalWeightRecord4(var10001, var10002, var10003, var10004, var10005);
         }

      }
   }
}
