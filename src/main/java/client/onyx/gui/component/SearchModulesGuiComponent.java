package client.onyx.gui.component;

import client.onyx.gui.Util;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.function.Consumer;

public class SearchModulesGuiComponent extends GuiComponentSub3 {
   private final client.onyx.gui.Cls cls3 = new client.onyx.gui.Cls();
   public static final float FLOAT4 = 26.0F;
   private static final float FLOAT5 = 9.0F;
   private static final float FLOAT6 = 16.0F;
   private static final float FLOAT7 = 12.0F;
   private static final float FLOAT8 = 7.0F;
   private final client.onyx.gui.Cls cls4 = new client.onyx.gui.Cls();
   private static final float FLOAT9 = 2.0F;
   private static final String STRING = "Search modules";
   private static final float FLOAT10 = 22.0F;

   public SearchModulesGuiComponent(Consumer<String> var1) {
      this.float_2 = 26.0F;
      this.cls2.handleConsumer(var1);
      this.cls2.handleRunnable2(() -> this.handleBool24(false));
      this.cls2.handleRunnable(() -> {
         if (!this.isEnabled149()) {
            this.handleBool24(false);
         }
      });
   }

   private boolean isFloat20(float var1, float var2) {
      return !this.cls2.isEnabled4() && Math.abs(var1 - this.getFloat127()) <= 11.0F && this.isFloat15(var1, var2);
   }

   public boolean isEnabled149() {
      return this.cls2.isEnabled5();
   }

   @Override
   protected float getFloat136() {
      return this.cls2.isEnabled4() ? this.float_3 + this.float_4 - 9.0F : this.getFloat127() - 16.0F;
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      boolean var2 = this.isFloat20(var1.float_3, var1.float_2);
      this.cls3.handleFloat(var1.float_, this.bool && !var2, false);
      this.cls4.handleFloat(var1.float_, var2, false);
   }

   @Override
   protected float getFloat137() {
      return this.getFloat128() + 16.0F - 2.0F + 7.0F;
   }

   private float getFloat128() {
      return this.float_3 + 9.0F - 2.0F;
   }

   public boolean isCodepointModifiersRecord2(CodepointModifiersRecord var1) {
      this.handleBool24(true);
      return this.cls2.isCodepointModifiersRecord(var1);
   }

   public String getString38() {
      return this.cls2.getString2();
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (var3 == 0 && this.isFloat20(var1, var2)) {
         this.isEnabled149();
         this.handleBool24(true);
         return true;
      } else {
         return super.isFloat17(var1, var2, var3);
      }
   }

   public static float getFloat129() {
      return 26.0F;
   }

   @Override
   protected OpticalWeightRecord getOpticalWeightRecord2() {
      return Util2.getOpticalWeightRecord3();
   }

   private float getFloat127() {
      return this.float_3 + this.float_4 - 9.0F + 2.0F - 8.0F;
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var2 = var1.sampler0;
      var1.sampler0
         .handleFloat7(this.float_3, this.float_, this.float_4, this.float_2, Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().surfaceContainerHigh());
      this.cls3.handleSampler0(var2, this.float_3, this.float_, this.float_4, this.float_2, Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().onSurface());
      float var3;
      if ((var3 = this.cls.getFloat()) > 0.01F) {
         var2.handleFloat18(
            this.float_3, this.float_, this.float_4, this.float_2, Float.MAX_VALUE, 1.5F, Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().primary(), var3)
         );
      }

      var3 = this.float_ + this.float_2 / 2.0F;
      Util.handleSampler03(var2, this.getFloat128() + 8.0F, var3, 16.0F, var1.getPrimaryOnPrimaryRecord().onSurfaceVariant());
      if (this.cls2.isEnabled4() && !this.isEnabled154()) {
         var2.handleOpticalWeightRecord9(
            this.getOpticalWeightRecord2(),
            "Search modules",
            this.getFloat137(),
            var3,
            Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.7F)
         );
      }

      this.handleCls215(var1, var3, 12.0F, var1.getPrimaryOnPrimaryRecord().onSurface());
      if (!this.cls2.isEnabled4()) {
         this.cls4.handleSampler0(var2, this.getFloat127() - 11.0F, var3 - 11.0F, 22.0F, 22.0F, Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().onSurface());
         Util.handleSampler0(var2, this.getFloat127(), var3, 16.0F, var1.getPrimaryOnPrimaryRecord().onSurfaceVariant());
      }

      float var4 = var1.float_3;
      if (this.isFloat20(var4, var1.float_2)) {
         var2.run41();
      } else {
         if (this.bool) {
            var2.run44();
         }
      }
   }
}
