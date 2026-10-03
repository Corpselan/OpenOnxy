package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.render.misc.Util;
import client.onyx.theme.Util4;

public abstract class GuiComponentSub3 extends GuiComponent {
   private Sampler0 sampler0;
   private boolean bool4;
   protected final client.onyx.render.misc.Cls cls;
   protected final Cls cls2 = new Cls();
   private float float_5;
   private long long_;
   private int int_;
   private static final float FLOAT = 3.0F;
   private float float_6;
   private static final long LONG = 320L;
   private static final float FLOAT2 = 0.32F;
   private static final float FLOAT3 = 1.2F;
   protected boolean bool5;
   private static GuiComponentSub3 guiComponentSub3;

   public String getString39() {
      return this.cls2.getString2();
   }

   private int getInt61(float var1) {
      return this.cls2.getInt3(var1 - this.getFloat137() + this.float_6, this.getIface());
   }

   @Override
   public boolean isCodepointModifiersRecord(CodepointModifiersRecord var1) {
      return this.bool5 && this.cls2.isCodepointModifiersRecord(var1);
   }

   protected abstract float getFloat137();

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      this.sampler0 = var1.sampler0;
      this.cls.handleFloat(var1.float_);
      this.cls2.handleFloat(var1.float_);
   }

   public static boolean isEnabled153() {
      return guiComponentSub3 != null;
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (var3 != 0) {
         return false;
      } else if (!this.isFloat15(var1, var2)) {
         this.handleBool24(false);
         return false;
      } else {
         return this.isFloat21(var1, false);
      }
   }

   public void handleBool24(boolean var1) {
      if (this.bool5 != var1) {
         this.bool5 = var1;
         this.bool4 = false;
         GuiComponentSub3 var10000;
         if (var1) {
            if (guiComponentSub3 != null && guiComponentSub3 != this) {
               guiComponentSub3.handleBool24(false);
            }

            var10000 = guiComponentSub3 = this;
         } else {
            if (guiComponentSub3 == this) {
               guiComponentSub3 = null;
            }

            var10000 = this;
         }

         var10000.cls2.run();
         if (!var1) {
            this.cls2.run2();
         }

         this.cls.getCls2(var1 ? 1.0F : 0.0F, 200.0F, Util.IFACE6);
      }
   }

   public boolean isEnabled152() {
      return this.cls2.isEnabled7();
   }

   protected abstract float getFloat136();

   public GuiComponentSub3() {
      this.cls = new client.onyx.render.misc.Cls(0.0F);
   }

   public void handleString23(String var1) {
      this.cls2.handleString2(var1);
      this.float_6 = 0.0F;
   }

   @Override
   public boolean isFloat18(float var1, float var2, int var3, float var4, float var5) {
      if (this.bool4 && var3 == 0) {
         this.cls2.handleInt2(this.getInt61(var1), true);
         return true;
      } else {
         return false;
      }
   }

   public static void run194() {
      if (guiComponentSub3 != null) {
         guiComponentSub3.handleBool24(false);
      }
   }

   protected boolean isFloat21(float var1, boolean var2) {
      long var3 = System.currentTimeMillis();
      boolean var5 = Math.abs(var1 - this.float_5) <= 3.0F;
      this.int_ = var3 - this.long_ <= 320L && var5 ? this.int_ + 1 : 0;
      this.long_ = var3;
      this.float_5 = var1;
      this.handleBool24(true);
      if (this.int_ == 1) {
         this.cls2.handleInt(this.getInt61(var1));
         return true;
      } else if (this.int_ >= 2) {
         this.cls2.run3();
         return true;
      } else {
         this.cls2.handleInt2(this.getInt61(var1), var2);
         this.bool4 = true;
         return true;
      }
   }

   public boolean isEnabled154() {
      return this.bool5;
   }

   protected float getFloat135() {
      return Math.max(0.0F, this.getFloat136() - this.getFloat137());
   }

   public void run195() {
      this.cls2.run3();
   }

   protected abstract OpticalWeightRecord getOpticalWeightRecord2();

   public void handleBool25(boolean var1) {
      this.cls2.handleBool(var1);
   }

   @Override
   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      return this.bool5 && this.cls2.isKeyScancodeRecord(var1);
   }

   private Cls.Iface getIface() {
      Sampler0 var3 = this.sampler0;
      OpticalWeightRecord var2 = this.getOpticalWeightRecord2();
      return var3 == null ? var0 -> 0.0F : var2x -> var3.getFloat17(var2, var2x);
   }

   @Override
   public boolean isFloat19(float var1, float var2, int var3) {
      return this.bool4 = false;
   }

   protected void handleCls215(client.onyx.gui.Cls2 var1, float var2, float var3, int var4) {
      Sampler0 var5 = var1.sampler0;
      Cls.Iface var6 = this.getIface();
      String var7 = this.cls2.getString();
      float var11 = this.getFloat135();
      float var9;
      if ((var9 = this.cls2.getFloat2(var6)) - this.float_6 > var11) {
         this.float_6 = var9 - var11;
      }

      if (var9 - this.float_6 < 0.0F) {
         this.float_6 = var9;
      }

      this.float_6 = Math.clamp(this.float_6, 0.0F, Math.max(0.0F, var6.getFloat(var7) - var11));
      float var10 = this.getFloat137() - this.float_6;
      var5.handleFloat24(this.getFloat137(), this.float_, var11, this.float_2);
      if (this.cls2.isEnabled()) {
         Cls var12 = this.cls2;
         int var13 = this.cls2.getInt2();
         float var14 = var12.getFloat(var13, var6);
         var11 = var10 + var14;
         Cls var16 = this.cls2;
         int var17 = this.cls2.getInt5();
         float var18 = var16.getFloat(var17, var6);
         float var20 = var10 + var18;
         var5.handleFloat7(var11, var2 - var3 / 2.0F, var20 - var11, var3, 0.0F, Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().primary(), 0.32F));
      }

      if (!var7.isEmpty()) {
         var5.handleOpticalWeightRecord9(this.getOpticalWeightRecord2(), var7, var10, var2, var4);
      }

      if (this.bool5 && this.cls2.isEnabled8()) {
         var5.handleFloat7(var10 + var9, var2 - var3 / 2.0F, 1.2F, var3, Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().primary());
      }

      var5.run38();
   }
}
