package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.render.misc.Util;
import client.onyx.setting.ModeOption;
import client.onyx.setting.ModeSetting;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingComponentSub4<M extends ModeOption> extends SettingComponent {
   private boolean bool6;
   private static final float FLOAT5 = 13.0F;
   private static final float FLOAT6 = 4.0F;
   private final client.onyx.render.misc.Cls cls3;
   private final List<client.onyx.gui.Cls> list2;
   private final Cls2 cls22;
   private static final float FLOAT7 = 7.0F;
   private static final float FLOAT8 = 24.0F;
   private static final float FLOAT9 = 8.0F;
   private final ModeSetting<M> modeSetting;
   private static final float FLOAT10 = 1.5F;
   private M modeOption;
   private int int_;
   private float float_5;
   private final List<client.onyx.render.misc.Cls> list3;

   private float getFloat161() {
      int var4 = this.modeSetting.getList4().size() - 1;
      return this.getFloat162(var4) + 24.0F - 4.0F;
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      ModeOption var7 = this.modeOption;
      Object var8 = this.modeSetting.lambda15();
      if (var7 != var8) {
         this.run202();
      }

      this.float_5 = this.cls22.getFloat(this.float_3 + 13.0F, this.getFloat160(), Math.max(0.0F, this.float_4 - 13.0F));
      SettingComponentSub4 var10000;
      if (!this.bool6) {
         this.cls3.getCls(this.float_5);
         var10000 = this;
      } else {
         if (this.cls3.getFloat2() != this.float_5) {
            client.onyx.render.misc.Cls var10 = this.cls3.getCls2(this.float_5, 300.0F, Util.IFACE2);
         }

         var10000 = this;
      }

      var10000.cls3.handleFloat(var1.float_);
      int var15 = 0;
      this.int_ = -1;

      for(int var6 = 0; var15 < this.modeSetting.getList4().size(); var15 = var6) {
         boolean var5;
         boolean var16;
         label66: {
            var5 = this.modeSetting.lambda15() == this.modeSetting.getList4().get(var6);
            if (var1.float_3 >= this.float_3) {
               float var11 = var1.float_3;
               float var13 = this.float_3 + this.float_4;
               if (var11 < var13 && var1.float_2 >= this.getFloat162(var6) && var1.float_2 < this.getFloat162(var6) + 24.0F) {
                  var16 = true;
                  break label66;
               }
            }

            var16 = false;
         }

         boolean var4 = var16;
         if (var4) {
            this.int_ = var6;
         }

         client.onyx.render.misc.Cls var3 = (client.onyx.render.misc.Cls)this.list3.get(var6);
         client.onyx.render.misc.Cls var17;
         if (!this.bool6) {
            var3.getCls(var5 ? 1.0F : 0.0F);
            var17 = var3;
         } else {
            if (var3.getFloat2() != (var5 ? 1.0F : 0.0F)) {
               var3.getCls2(var5 ? 1.0F : 0.0F, 200.0F, Util.IFACE2);
            }

            var17 = var3;
         }

         var17.handleFloat(var1.float_);
         client.onyx.gui.Cls var18 = (client.onyx.gui.Cls)this.list2.get(var6);
         ++var6;
         var18.handleFloat(var1.float_, var4, false);
      }

      this.bool6 = true;
      super.handleCls28(var1);
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.isEnabled163() && var3 == 0) {
         if (this.int_ >= 0) {
            ModeSetting var6 = this.modeSetting;
            ModeOption var9 = (ModeOption)this.modeSetting.getList4().get(this.int_);
            var6.handleObject2(var9);
            return true;
         } else {
            Iterator var5 = this.list.iterator();

            do {
               if (!var5.hasNext()) {
                  return false;
               }
            } while(!((GuiComponent)var5.next()).isFloat17(var1, var2, var3));

            return true;
         }
      } else {
         return false;
      }
   }

   private float getFloat163() {
      return this.getFloat187() - 1.5F;
   }

   private float getFloat162(int var1) {
      return this.getFloat163() - 4.0F + (float)var1 * 24.0F;
   }

   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      Sampler0 var4 = var1.sampler0;
      int var10000 = 0;
      this.handleCls225(var1, this.float_4);

      for(int var9 = 0; var10000 < this.modeSetting.getList4().size(); var10000 = var9) {
         ModeOption var5 = (ModeOption)this.modeSetting.getList4().get(var9);
         float var6;
         float var7 = (var6 = this.getFloat162(var9)) + 12.0F;
         boolean var8 = this.modeSetting.lambda15() == var5;
         ((client.onyx.gui.Cls)this.list2.get(var9)).handleSampler0(var4, this.float_3 - 4.0F, var6, this.float_4 + 8.0F, 24.0F, 8.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurface()));
         int var12 = var8 ? var1.getPrimaryOnPrimaryRecord().primary() : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant();
         var4.handleFloat22(this.float_3 + 8.0F, var7, 8.0F, 1.5F, this.getInt72(var12));
         float var13;
         if ((var13 = ((client.onyx.render.misc.Cls)this.list3.get(var9)).getFloat()) > 0.01F) {
            var4.handleFloat23(this.float_3 + 8.0F, var7, 4.0F * var13, this.getInt72(var1.getPrimaryOnPrimaryRecord().primary()));
         }

         OpticalWeightRecord var10001 = Util2.OPTICAL_WEIGHT_RECORD15;
         String var10002 = var5.getString3();
         float var10003 = this.float_3 + 16.0F + 9.0F;
         PrimaryOnPrimaryRecord var10006 = var1.getPrimaryOnPrimaryRecord();
         ++var9;
         var4.handleOpticalWeightRecord9(var10001, var10002, var10003, var7, this.getInt72(var10006.onSurface()));
      }

      float var14;
      if (!((var14 = this.cls3.getFloat()) <= 0.5F)) {
         var4.handleFloat24(this.float_3, this.getFloat160(), this.float_4, var14);
         var4.handleFloat28(this.float_3 + 3.0F, this.getFloat160(), 1.0F, var14, Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().outlineVariant(), var2 * 0.7F));
         this.cls22.handleSampler0(var4, this.float_3 + 13.0F, Math.max(0.0F, this.float_4 - 13.0F), var1.getPrimaryOnPrimaryRecord().outlineVariant(), var2);
         Iterator var10;
         Iterator var15 = var10 = this.list.iterator();

         while(var15.hasNext()) {
            GuiComponent var11 = (GuiComponent)var10.next();
            var15 = var10;
            var11.handleCls27(var1);
         }

         var4.run38();
      }
   }

   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      float var2 = this.cls3.getFloat();
      return this.getFloat161() - this.float_ + (var2 > 0.5F ? 7.0F + var2 : 0.0F) + 6.0F;
   }

   private float getFloat160() {
      return this.getFloat161() + 7.0F;
   }

   public SettingComponentSub4(ModeSetting<M> var1) {
      super(var1);
      this.list3 = new ArrayList();
      this.list2 = new ArrayList();
      this.cls22 = new Cls2();
      this.cls3 = new client.onyx.render.misc.Cls(0.0F);
      this.int_ = -1;
      this.modeSetting = var1;

      for(int var2 = 0; var2 < var1.getList4().size(); ) {
         this.list3.add(new client.onyx.render.misc.Cls(0.0F));
         ++var2;
         this.list2.add(new client.onyx.gui.Cls());
      }

      this.run202();
   }

   private void run202() {
      this.modeOption = (M)this.modeSetting.lambda15();
      this.list.clear();
      this.cls22.handleList(this.modeOption.getList2());
      this.list.addAll(this.cls22.getList());
      this.float_5 = 0.0F;
   }
}
