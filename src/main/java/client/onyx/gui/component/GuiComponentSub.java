package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.module.Module;
import client.onyx.render.Sampler0;
import client.onyx.render.misc.Util;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public class GuiComponentSub extends GuiComponent {
   private final client.onyx.gui.Cls cls = new client.onyx.gui.Cls();
   private final client.onyx.render.misc.Cls2 cls2 = new client.onyx.render.misc.Cls2(0);
   private final Module module;
   private boolean bool4;
   private final Consumer<Module> consumer;
   private final GuiComponentSub7 guiComponentSub7;

   public Module getModule3() {
      return this.module;
   }

   private static float getFloat132() {
      return 12.0F;
   }

   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var2;
      Sampler0 var10000 = var2 = var1.sampler0;
      boolean var3 = this.module.isEnabled55();
      var10000.handleFloat7(this.float_3, this.float_, this.float_4, this.float_2, 12.0F, this.cls2.getInt());
      this.cls.handleSampler0(var2, this.float_3, this.float_, this.float_4, this.float_2, 12.0F, var1.getPrimaryOnPrimaryRecord().onSurface());
      int var4 = var3 ? var1.getPrimaryOnPrimaryRecord().onSecondaryContainer() : var1.getPrimaryOnPrimaryRecord().onSurface();
      int var7 = var3 ? Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSecondaryContainer(), 0.72F) : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant();
      client.onyx.gui.Cls2 var10001 = var1;
      float var6 = this.float_3 + getFloat132();
      float var5 = this.guiComponentSub7.getFloat118() - 8.0F - var6;
      var2.handleOpticalWeightRecord9(Util2.getOpticalWeightRecord4(), var2.getString17(Util2.getOpticalWeightRecord4(), this.module.getString20(), var5), var6, this.float_ + this.float_2 * 0.32F, var4);
      var2.handleOpticalWeightRecord9(Util2.getOpticalWeightRecord5(), var2.getString17(Util2.getOpticalWeightRecord5(), this.module.getString18(), var5), var6, this.float_ + this.float_2 * 0.7F, var7);
      super.handleCls27(var10001);
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.guiComponentSub7.isFloat17(var1, var2, var3)) {
         return true;
      } else if (!this.isFloat15(var1, var2)) {
         return false;
      } else if (var3 == 0) {
         boolean var10000 = this.bool3 = true;
         this.module.lambda35();
         return var10000;
      } else if (var3 == 1) {
         this.consumer.accept(this.module);
         return true;
      } else {
         return false;
      }
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      int var2 = this.module.isEnabled55() ? var1.getPrimaryOnPrimaryRecord().secondaryContainer() : var1.getPrimaryOnPrimaryRecord().surfaceContainerHigh();
      if (!this.bool4) {
         this.bool4 = true;
         this.cls2.getCls2(var2);
      }

      this.cls2.getCls22(var2, 250.0F, Util.IFACE6);
      this.cls2.handleFloat(var1.float_);
      client.onyx.gui.Cls var10000 = this.cls;
      float var10001 = var1.float_;
      boolean var10002;
      GuiComponentSub var10003;
      if (this.bool && !this.guiComponentSub7.isEnabled146()) {
         var10002 = true;
         var10003 = this;
      } else {
         var10002 = false;
         var10003 = this;
      }

      var10000.handleFloat(var10001, var10002, var10003.bool3);
   }

   public GuiComponentSub(Module var1, Consumer<Module> var2) {
      this.module = var1;
      this.consumer = var2;
      this.float_2 = getFloat131();
      Objects.requireNonNull(var1);
      BooleanSupplier var10003 = var1::isEnabled55;
      Objects.requireNonNull(var1);
      this.guiComponentSub7 = new GuiComponentSub7(var10003, var1::handleBool16);
      boolean var4 = this.list.add(this.guiComponentSub7);
   }

   public static float getFloat131() {
      return 46.0F;
   }

   protected void run185() {
      this.guiComponentSub7.handleBool23(true);
      this.guiComponentSub7.handleFloat80(this.float_3 + this.float_4 - 38.0F - getFloat132(), this.float_ + (this.float_2 - 22.0F) / 2.0F, 38.0F, 22.0F);
   }

   public boolean isFloat19(float var1, float var2, int var3) {
      this.bool3 = false;
      return super.isFloat19(var1, var2, var3);
   }
}
