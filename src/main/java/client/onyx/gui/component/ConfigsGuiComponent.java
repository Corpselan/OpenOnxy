package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.gui.Util;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.function.Consumer;

public class ConfigsGuiComponent extends GuiComponent {
   private final client.onyx.gui.Cls[] clsArray;
   private int int_;
   private final client.onyx.gui.Cls cls;
   private ModuleCategory moduleCategory;
   private final client.onyx.render.misc.Cls cls2;
   private boolean bool4;
   private boolean bool5;
   private final Runnable runnable;
   private final Consumer<ModuleCategory> consumer;
   private final client.onyx.render.misc.Cls cls3;

   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var7;
      (var7 = var1.sampler0).handleFloat7(this.float_3 + (this.float_4 - this.cls2.getFloat()) / 2.0F, this.float_ + this.cls3.getFloat() + 2.0F, this.cls2.getFloat(), getFloat171(), Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().secondaryContainer());
      ModuleCategory[] var3;
      int var4 = (var3 = ModuleCategory.values()).length;

      int var5;
      for(int var10000 = var5 = 0; var10000 < var4; var10000 = var5) {
         ModuleCategory var6 = var3[var5];
         int var2 = var6.ordinal();
         float var8 = this.getFloat169(var2);
         float var9 = this.float_3 + this.float_4 / 2.0F;
         boolean var10 = var6 == this.moduleCategory;
         this.clsArray[var2].handleSampler0(var7, this.float_3 + (this.float_4 - getFloat167()) / 2.0F, var8 + 2.0F, getFloat167(), getFloat171(), Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().onSurface());
         var2 = var10 ? var1.getPrimaryOnPrimaryRecord().onSecondaryContainer() : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant();
         Util.handleSampler04(var7, var6, var9, var8 + 2.0F + getFloat171() / 2.0F, 16.0F, var2);
         var2 = var10 ? var1.getPrimaryOnPrimaryRecord().onSurface() : Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.9F);
         OpticalWeightRecord var10001 = Util2.getOpticalWeightRecord5();
         String var10002 = var6.getString2();
         float var10005 = getFloat172();
         ++var5;
         var7.handleOpticalWeightRecord4(var10001, var10002, var9, var8 + var10005, var2);
      }

      float var11 = this.float_ + this.float_2 - getFloat168();
      float var12 = this.float_3 + this.float_4 / 2.0F;
      this.cls.handleSampler0(var7, this.float_3 + (this.float_4 - getFloat167()) / 2.0F, var11 + 2.0F, getFloat167(), getFloat171(), Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().onSurface());
      var7.handleString6("\ue161", var12, var11 + 2.0F + getFloat171() / 2.0F, 16.0F, var1.getPrimaryOnPrimaryRecord().onSurfaceVariant());
      var7.handleOpticalWeightRecord4(Util2.getOpticalWeightRecord5(), "Configs", var12, var11 + getFloat172(), Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.9F));
   }

   private static float getFloat167() {
      return 46.0F;
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      if (!this.bool5) {
         this.bool5 = true;
         this.cls3.getCls(this.getFloat170(this.moduleCategory.ordinal()));
         this.cls2.getCls(getFloat167());
      }

      this.int_ = -1;
      this.bool4 = false;
      ModuleCategory[] var2;
      int var5 = (var2 = ModuleCategory.values()).length;

      int var4;
      for(int var10000 = var4 = 0; var10000 < var5; var10000 = var4) {
         int var3;
         boolean var12;
         label41: {
            var3 = var2[var4].ordinal();
            if (var1.float_3 >= this.float_3) {
               float var7 = var1.float_3;
               float var9 = this.float_3 + this.float_4;
               if (var7 < var9 && var1.float_2 >= this.getFloat169(var3) && var1.float_2 < this.getFloat169(var3) + getFloat168()) {
                  var12 = true;
                  break label41;
               }
            }

            var12 = false;
         }

         boolean var6 = var12;
         if (var6) {
            this.int_ = var3;
         }

         client.onyx.gui.Cls var13 = this.clsArray[var3];
         ++var4;
         var13.handleFloat(var1.float_, var6, false);
      }

      float var11 = this.float_ + this.float_2 - getFloat168();
      this.bool4 = var1.float_3 >= this.float_3 && var1.float_3 < this.float_3 + this.float_4 && var1.float_2 >= var11 && var1.float_2 < var11 + getFloat168();
      this.cls.handleFloat(var1.float_, this.bool4, false);
      this.cls3.handleFloat(var1.float_);
      this.cls2.handleFloat(var1.float_);
   }

   private static float getFloat172() {
      return 36.0F;
   }

   private float getFloat170(int var1) {
      return (float)var1 * getFloat168();
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (var3 != 0) {
         return false;
      } else if (this.bool4) {
         this.runnable.run();
         return true;
      } else if (this.int_ < 0) {
         return false;
      } else {
         this.handleModuleCategory2(ModuleCategory.values()[this.int_]);
         return true;
      }
   }

   public ConfigsGuiComponent(ModuleCategory var1, Consumer<ModuleCategory> var2, Runnable var3) {
      client.onyx.gui.Cls[] var10001 = new client.onyx.gui.Cls[ModuleCategory.values().length];
      boolean var10003 = true;
      this.clsArray = var10001;
      int var10000 = 0;
      this.cls = new client.onyx.gui.Cls();
      this.cls3 = new client.onyx.render.misc.Cls(0.0F);
      this.cls2 = new client.onyx.render.misc.Cls(0.0F);
      this.int_ = -1;
      this.moduleCategory = var1;
      this.consumer = var2;
      this.runnable = var3;

      for(int var4 = 0; var10000 < this.clsArray.length; var10000 = var4) {
         client.onyx.gui.Cls[] var5 = this.clsArray;
         int var6 = var4;
         client.onyx.gui.Cls var10002 = new client.onyx.gui.Cls();
         ++var4;
         var5[var6] = var10002;
      }

   }

   private static float getFloat171() {
      return 26.0F;
   }

   private static float getFloat168() {
      return 50.0F;
   }

   private float getFloat169(int var1) {
      return this.float_ + this.getFloat170(var1);
   }

   public void handleModuleCategory2(ModuleCategory var1) {
      if (this.moduleCategory != var1) {
         this.moduleCategory = var1;
         this.cls3.getCls2(this.getFloat170(var1.ordinal()), 300.0F, client.onyx.render.misc.Util.IFACE2);
         this.cls2.getCls(getFloat167() * 0.6F).getCls2(getFloat167(), 300.0F, client.onyx.render.misc.Util.IFACE2);
         this.consumer.accept(var1);
      }
   }

   public ModuleCategory getModuleCategory3() {
      return this.moduleCategory;
   }
}
