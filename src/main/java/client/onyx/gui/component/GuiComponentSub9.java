package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.render.Sampler0;
import client.onyx.render.misc.Util;
import client.onyx.theme.Util2;
import java.util.function.IntConsumer;

public class GuiComponentSub9 extends GuiComponent {
   private final client.onyx.render.misc.Cls cls3 = new client.onyx.render.misc.Cls(0.0F);
   private final client.onyx.render.misc.Cls cls = new client.onyx.render.misc.Cls(0.0F);
   private final client.onyx.gui.Cls[] clsArray;
   private static final float FLOAT = 14.0F;
   private static final float FLOAT2 = 5.0F;
   private boolean bool4;
   public static final float FLOAT3 = 30.0F;
   private final client.onyx.render.misc.Cls cls2 = new client.onyx.render.misc.Cls(0.0F);
   private final String[] stringArray;
   private static final float FLOAT4 = 2.0F;
   private int int_;
   private final IntConsumer intConsumer;
   private int int_2 = -1;

   private int getInt71(float var1, float var2) {
      return !this.isFloat15(var1, var2) ? -1 : Math.clamp((long)((int)((var1 - this.float_3 - 2.0F) / this.getFloat176())), 0, this.stringArray.length - 1);
   }

   public void handleInt19(int var1) {
      if (var1 != this.int_) {
         this.int_ = var1;
         this.cls3.getCls2(this.getFloat177(var1), 300.0F, Util.IFACE2);
         this.cls.getCls2(this.getFloat176(), 300.0F, Util.IFACE2);
         this.cls2.getCls(0.0F).getCls2(19.0F, 300.0F, Util.IFACE2);
         this.intConsumer.accept(var1);
      }
   }

   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var2 = var1.sampler0;
      int var10000 = 0;
      var2.handleFloat18(this.float_3, this.float_, this.float_4, this.float_2, Float.MAX_VALUE, 1.0F, var1.getPrimaryOnPrimaryRecord().outline());
      var2.handleFloat7(this.cls3.getFloat(), this.float_ + 2.0F, this.cls.getFloat(), this.float_2 - 4.0F, Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().secondaryContainer());

      for(int var8 = 0; var10000 < this.stringArray.length; var10000 = var8) {
         boolean var4 = var8 == this.int_;
         this.clsArray[var8].handleSampler0(var2, this.getFloat177(var8), this.float_ + 2.0F, this.getFloat176(), this.float_2 - 4.0F, Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().onSurface());
         int var5 = var4 ? var1.getPrimaryOnPrimaryRecord().onSecondaryContainer() : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant();
         float var9 = var4 ? this.cls2.getFloat() : 0.0F;
         float var6 = var2.getFloat17(Util2.OPTICAL_WEIGHT_RECORD14, this.stringArray[var8]);
         var6 = this.getFloat177(var8) + (this.getFloat176() - var6 - var9) / 2.0F;
         float var7 = this.float_ + this.float_2 / 2.0F;
         if (var9 > 0.5F) {
            var2.handleFloat24(var6, this.float_, var9, this.float_2);
            client.onyx.gui.Util.handleSampler06(var2, var6 + 7.0F, var7, 14.0F, var5);
            var2.run38();
         }

         var2.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD14, this.stringArray[var8], var6 + var9, var7, var5);
         if (var8 > 0 && var8 != this.int_ && var8 - 1 != this.int_) {
            var2.handleFloat28(this.getFloat177(var8), this.float_ + 2.0F, 1.0F, this.float_2 - 4.0F, var1.getPrimaryOnPrimaryRecord().outline());
         }

         ++var8;
      }

      if (this.int_2 >= 0) {
         var2.run41();
      }

   }

   public GuiComponentSub9(String[] var1, IntConsumer var2) {
      this.stringArray = var1;
      this.intConsumer = var2;
      this.float_2 = 30.0F;
      client.onyx.gui.Cls[] var10001 = new client.onyx.gui.Cls[var1.length];
      boolean var10003 = true;
      this.clsArray = var10001;

      int var3;
      for(int var10000 = var3 = 0; var10000 < var1.length; var10000 = var3) {
         client.onyx.gui.Cls[] var4 = this.clsArray;
         int var5 = var3;
         client.onyx.gui.Cls var10002 = new client.onyx.gui.Cls();
         ++var3;
         var4[var5] = var10002;
      }

   }

   private float getFloat176() {
      return (this.float_4 - 4.0F) / (float)this.stringArray.length;
   }

   public int getInt70() {
      return this.int_;
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      int var4 = this.getInt71(var1, var2);
      if (var3 == 0 && var4 >= 0) {
         this.handleInt19(var4);
         return true;
      } else {
         return false;
      }
   }

   private float getFloat177(int var1) {
      return this.float_3 + 2.0F + this.getFloat176() * (float)var1;
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      if (!this.bool4) {
         this.bool4 = true;
         this.cls3.getCls(this.getFloat177(this.int_));
         this.cls.getCls(this.getFloat176());
         this.cls2.getCls(19.0F);
      }

      float var3 = var1.float_3;
      int var4 = this.getInt71(var3, var1.float_2);
      this.int_2 = var4;

      int var2;
      for(int var10000 = var2 = 0; var10000 < this.clsArray.length; var10000 = var2) {
         client.onyx.gui.Cls var5 = this.clsArray[var2];
         boolean var10002 = var2 == this.int_2;
         ++var2;
         var5.handleFloat(var1.float_, var10002, false);
      }

      this.cls3.handleFloat(var1.float_);
      this.cls.handleFloat(var1.float_);
      this.cls2.handleFloat(var1.float_);
   }
}
