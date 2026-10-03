package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.render.Sampler0;
import client.onyx.theme.Util4;

public class GuiComponentSub10 extends GuiComponent {
   private final client.onyx.gui.Cls cls = new client.onyx.gui.Cls();
   public static final float FLOAT = 30.0F;
   private String string;
   private final Runnable runnable;
   private Integer integer;
   private static final float FLOAT2 = 18.0F;

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var2 = var1.sampler0;
      int var4 = this.integer != null ? this.integer : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant();
      this.cls.handleSampler0(var2, this.float_3, this.float_, this.float_4, this.float_2, Float.MAX_VALUE, var4);
      var2.handleString6(
         this.string, this.float_3 + this.float_4 / 2.0F, this.float_ + this.float_2 / 2.0F, 18.0F, this.bool2 ? var4 : Util4.getIntForInt(var4)
      );
      if (this.bool) {
         var2.run41();
      }
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      this.cls.handleFloat(var1.float_, this.bool, this.bool3);
   }

   @Override
   public boolean isFloat19(float var1, float var2, int var3) {
      return this.bool3 = false;
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (var3 == 0 && this.bool2 && this.isFloat15(var1, var2)) {
         this.bool3 = true;
         this.runnable.run();
         return true;
      } else {
         return false;
      }
   }

   public void handleString27(String var1) {
      this.string = var1;
   }

   public GuiComponentSub10(String var1, Runnable var2) {
      this.string = var1;
      this.runnable = var2;
      this.float_4 = 30.0F;
      this.float_2 = 30.0F;
   }

   public void handleInteger(Integer var1) {
      this.integer = var1;
   }
}
