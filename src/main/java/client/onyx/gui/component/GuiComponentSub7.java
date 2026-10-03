package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.render.Sampler0;
import client.onyx.render.misc.Util;
import client.onyx.theme.Util4;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public class GuiComponentSub7 extends GuiComponent {
   private static final float FLOAT = 10.0F;
   private final client.onyx.render.misc.Cls2 cls2;
   public static final float FLOAT2 = 22.0F;
   private final client.onyx.render.misc.Cls2 cls22;
   private final client.onyx.render.misc.Cls cls;
   public static final float FLOAT3 = 38.0F;
   private final client.onyx.render.misc.Cls cls3 = new client.onyx.render.misc.Cls(0.0F);
   private static final float FLOAT4 = 6.0F;
   private static final float FLOAT5 = 8.5F;
   private boolean bool4;
   private final Consumer<Boolean> consumer;
   private boolean bool5;
   private final BooleanSupplier booleanSupplier;

   public GuiComponentSub7(BooleanSupplier var1, Consumer<Boolean> var2) {
      this.cls = new client.onyx.render.misc.Cls(6.0F);
      this.cls2 = new client.onyx.render.misc.Cls2(0);
      this.cls22 = new client.onyx.render.misc.Cls2(0);
      this.booleanSupplier = var1;
      this.consumer = var2;
      this.float_4 = 38.0F;
      this.float_2 = 22.0F;
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var4 = var1.sampler0;
      Sampler0 var10001 = var1.sampler0;
      float var3 = this.float_ + this.float_2 / 2.0F;
      float var6 = this.float_4 - 22.0F;
      var6 = this.float_3 + 11.0F + var6 * this.cls3.getFloat();
      float var5 = this.cls.getFloat();
      var10001.handleFloat7(this.float_3, this.float_, this.float_4, this.float_2, Float.MAX_VALUE, this.cls2.getInt());
      if (this.cls3.getFloat() < 0.999F) {
         var4.handleFloat18(
            this.float_3,
            this.float_,
            this.float_4,
            this.float_2,
            Float.MAX_VALUE,
            1.5F,
            Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().outline(), 1.0F - this.cls3.getFloat())
         );
      }

      if (this.bool) {
         int var10004;
         GuiComponentSub7 var10005;
         if (this.booleanSupplier.getAsBoolean()) {
            var10004 = var1.getPrimaryOnPrimaryRecord().primary();
            var10005 = this;
         } else {
            var10004 = var1.getPrimaryOnPrimaryRecord().onSurface();
            var10005 = this;
         }

         var4.handleFloat23(var6, var3, 14.0F, Util4.getIntForInt2(var10004, var10005.bool3 ? 0.1F : 0.08F));
      }

      var4.handleFloat23(var6, var3, var5, this.cls22.getInt());
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (var3 == 0 && this.isFloat15(var1, var2)) {
         this.bool3 = true;
         this.consumer.accept(!this.booleanSupplier.getAsBoolean());
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean isFloat19(float var1, float var2, int var3) {
      return this.bool3 = false;
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      boolean var5;
      int var3 = (var5 = this.booleanSupplier.getAsBoolean())
         ? var1.getPrimaryOnPrimaryRecord().primary()
         : var1.getPrimaryOnPrimaryRecord().surfaceContainerHighest();
      int var4 = var5 ? var1.getPrimaryOnPrimaryRecord().onPrimary() : var1.getPrimaryOnPrimaryRecord().outline();
      if (!this.bool4) {
         this.bool4 = true;
         this.bool5 = var5;
         this.cls3.getCls(var5 ? 1.0F : 0.0F);
         this.cls.getCls(var5 ? 8.5F : 6.0F);
         this.cls2.getCls2(var3);
         this.cls22.getCls2(var4);
      }

      if (var5 != this.bool5) {
         this.bool5 = var5;
         this.cls3.getCls2(var5 ? 1.0F : 0.0F, 300.0F, Util.IFACE2);
      }

      this.cls2.getCls22(var3, 300.0F, Util.IFACE6);
      this.cls22.getCls22(var4, 300.0F, Util.IFACE6);
      float var6 = this.bool3 ? 10.0F : (var5 ? 8.5F : 6.0F);
      if (this.cls.getFloat2() != var6) {
         this.cls.getCls2(var6, 150.0F, Util.IFACE6);
      }

      this.cls3.handleFloat(var1.float_);
      this.cls.handleFloat(var1.float_);
      this.cls2.handleFloat(var1.float_);
      this.cls22.handleFloat(var1.float_);
   }
}
