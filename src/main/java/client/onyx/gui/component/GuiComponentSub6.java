package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.gui.Util3;
import client.onyx.render.Sampler0;
import client.onyx.render.misc.Util;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;

public class GuiComponentSub6 extends GuiComponent {
   private final client.onyx.render.misc.Cls cls = new client.onyx.render.misc.Cls(0.0F);
   private float float_5 = 1.0F;
   private static final float FLOAT = 12.0F;
   private final Runnable runnable;
   private static final float FLOAT2 = 0.16F;
   private static final float FLOAT3 = 0.62F;
   private final String string;

   public void handleFloat86(float var1) {
      this.float_5 = var1;
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      float var3 = this.bool ? 1.0F : 0.0F;
      if (this.cls.getFloat2() != var3) {
         this.cls.getCls2(var3, 150.0F, Util.IFACE6);
      }

      this.cls.handleFloat(var1.float_);
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (var3 == 0 && this.bool2 && this.isFloat15(var1, var2)) {
         this.runnable.run();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var8 = var1.sampler0;
      PrimaryOnPrimaryRecord var5;
      PrimaryOnPrimaryRecord var9 = var5 = var1.getPrimaryOnPrimaryRecord();
      float var4 = this.cls.getFloat();
      float var3 = this.float_4 / this.float_5;
      float var2 = this.float_2 / this.float_5;
      int var6 = var9.onSecondaryContainer();
      var8.handleFloat10(Util3.getFloat());
      var8.run36();
      var8.getCls32().getCls35(this.float_3, this.float_).getCls33(this.float_5, this.float_5);
      var8.handleFloat25(0.0F, 0.0F, var3, var2, 12.0F, 1);
      var8.isFloat2(0.0F, 0.0F, var3, var2, 12.0F, Util4.getIntForInt2(var5.secondaryContainer(), 0.62F + 0.16F * var4));
      if (var4 > 0.001F) {
         int var7 = Util4.getIntForInt2(var6, 0.08F * var4);
         var8.handleFloat7(0.0F, 0.0F, var3, var2, 12.0F, var7);
      }

      var8.handleOpticalWeightRecord4(Util2.OPTICAL_WEIGHT_RECORD14, this.string, var3 / 2.0F, var2 / 2.0F, var6);
      var8.run43();
      var8.run40();
      if (this.bool) {
         var8.run41();
      }
   }

   public GuiComponentSub6(String var1, Runnable var2) {
      this.string = var1;
      this.runnable = var2;
   }
}
