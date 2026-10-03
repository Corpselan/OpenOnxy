package client.onyx.gui.component;

import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.function.Consumer;

public class GuiComponentSub8 extends GuiComponentSub3 {
   private final client.onyx.gui.Cls cls3 = new client.onyx.gui.Cls();
   private Runnable runnable;
   private static final float FLOAT4 = 11.0F;
   private static final float FLOAT5 = 2.0F;
   public static final float FLOAT6 = 40.0F;
   private static final float FLOAT7 = 1.0F;
   private static final float FLOAT8 = 12.0F;
   private static final float FLOAT9 = 9.0F;
   private Consumer<String> consumer;
   private static final float FLOAT10 = 12.0F;
   private final String string;

   @Override
   protected float getFloat137() {
      return this.float_3 + 12.0F;
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      this.cls3.handleFloat(var1.float_, this.bool, false);
   }

   public void handleConsumer4(Consumer<String> var1) {
      this.consumer = var1;
   }

   public GuiComponentSub8(String var1) {
      this.string = var1;
      this.float_2 = 40.0F;
      this.cls2.handleConsumer(var1x -> {
         if (this.consumer != null) {
            this.consumer.accept(var1x);
         }
      });
      this.cls2.handleRunnable2(() -> {
         if (this.runnable != null) {
            this.runnable.run();
         }
      });
      this.cls2.handleRunnable(() -> this.handleBool24(false));
   }

   @Override
   protected OpticalWeightRecord getOpticalWeightRecord2() {
      return Util2.getOpticalWeightRecord3();
   }

   public void handleRunnable(Runnable var1) {
      this.runnable = var1;
   }

   @Override
   protected float getFloat136() {
      return this.float_3 + this.float_4 - 12.0F;
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var2 = var1.sampler0;
      float var3 = this.cls.getFloat();
      boolean var4 = this.isEnabled154() || !this.cls2.isEnabled4();
      var2.handleFloat7(this.float_3, this.float_, this.float_4, this.float_2, 4.0F, var1.getPrimaryOnPrimaryRecord().surfaceContainerHighest());
      this.cls3.handleSampler0(var2, this.float_3, this.float_, this.float_4, this.float_2, 4.0F, var1.getPrimaryOnPrimaryRecord().onSurface());
      var2.handleFloat18(
         this.float_3,
         this.float_,
         this.float_4,
         this.float_2,
         4.0F,
         1.0F + 1.0F * var3,
         client.onyx.render.misc.Cls2.getIntForInt(var1.getPrimaryOnPrimaryRecord().outline(), var1.getPrimaryOnPrimaryRecord().primary(), var3)
      );
      GuiComponentSub8 var10000;
      if (var4) {
         var2.handleOpticalWeightRecord9(
            Util2.getOpticalWeightRecord5(),
            this.string,
            this.getFloat137(),
            this.float_ + 9.0F,
            var3 > 0.5F ? var1.getPrimaryOnPrimaryRecord().primary() : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()
         );
         var10000 = this;
      } else {
         var2.handleOpticalWeightRecord9(
            this.getOpticalWeightRecord2(),
            this.string,
            this.getFloat137(),
            this.float_ + this.float_2 / 2.0F,
            Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.7F)
         );
         var10000 = this;
      }

      var10000.handleCls215(
         var1, var4 ? this.float_ + this.float_2 - 11.0F : this.float_ + this.float_2 / 2.0F, 12.0F, var1.getPrimaryOnPrimaryRecord().onSurface()
      );
      if (this.bool) {
         var2.run44();
      }
   }
}
