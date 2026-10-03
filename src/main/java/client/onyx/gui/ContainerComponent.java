package client.onyx.gui;

import client.onyx.render.Sampler0;
import client.onyx.theme.Util4;

public abstract class ContainerComponent extends GuiComponent {
   protected int int_;
   protected float float_5;
   protected final client.onyx.render.misc.Cls cls = new client.onyx.render.misc.Cls(0.0F);
   protected final client.onyx.render.misc.Cls cls2 = new client.onyx.render.misc.Cls(0.0F);
   protected float float_6;
   private float float_7;

   protected void handleCls211(Cls2 var1) {
      GuiComponent var3;
      if ((var3 = this.getGuiComponent()) != null) {
         var1.sampler0
            .handleFloat18(
               var3.getFloat118(),
               var3.getFloat115(),
               var3.getFloat119(),
               var3.getFloat116(),
               this.getFloat120(),
               2.0F,
               var1.getPrimaryOnPrimaryRecord().primary()
            );
      }
   }

   public boolean isInt6(int var1, int var2) {
      if (this.list.isEmpty()) {
         return false;
      } else {
         int var3 = Math.max(1, this.getInt57());
         if ((var1 = var1 + var2 * var3) == 0) {
            return false;
         } else {
            this.int_ = this.int_ < 0 ? (var1 > 0 ? 0 : this.list.size() - 1) : Math.clamp((long)(this.int_ + var1), 0, this.list.size() - 1);
            this.run188();
            return true;
         }
      }
   }

   @Override
   public boolean isFloat16(float var1, float var2, double var3) {
      if (!this.isFloat15(var1, var2)) {
         return super.isFloat16(var1, var2, var3);
      } else {
         float var6;
         if ((var6 = Math.max(0.0F, this.float_6 - this.float_2)) <= 0.0F) {
            return false;
         } else {
            this.float_5 = Math.clamp(this.float_5 - (float)var3 * 32.0F, 0.0F, var6);
            this.float_7 = 0.0F;
            return true;
         }
      }
   }

   public int getInt58() {
      return this.int_;
   }

   public void run187() {
      this.int_ = -1;
   }

   protected int getInt57() {
      return 1;
   }

   @Override
   public void handleCls28(Cls2 var1) {
      this.handleCls212(var1);
      float var3 = Math.max(0.0F, this.float_6 - this.float_2);
      this.float_5 = Math.clamp(this.float_5, 0.0F, var3);
      if (this.cls.getFloat2() != this.float_5) {
         client.onyx.render.misc.Cls var5 = this.cls.getCls2(this.float_5, 250.0F, client.onyx.render.misc.Util.IFACE5);
      }

      int var6 = this.int_;
      int var7 = this.list.size();
      if (var6 >= var7) {
         this.int_ = this.list.isEmpty() ? -1 : this.list.size() - 1;
      }

      this.cls.handleFloat(var1.float_);
      this.float_7 = this.float_7 + var1.float_;
      boolean var8 = var3 > 0.0F && (this.bool || this.float_7 < 900.0F);
      if (this.cls2.getFloat2() != (var8 ? 1.0F : 0.0F)) {
         this.cls2.getCls2(var8 ? 1.0F : 0.0F, 200.0F, client.onyx.render.misc.Util.IFACE6);
      }

      this.cls2.handleFloat(var1.float_);
      super.handleCls28(var1);
   }

   private void handleCls210(Cls2 var1) {
      float var2 = this.cls2.getFloat();
      float var8 = this.float_6 - this.float_2;
      float var6 = Math.max(0.0F, var8);
      if (!(var2 <= 0.01F) && !(var6 <= 0.0F)) {
         float var4 = this.float_2 - 8.0F;
         float var5 = Math.max(24.0F, var4 * (this.float_2 / this.float_6));
         var6 = this.float_ + 4.0F + (var4 - var5) * (this.cls.getFloat() / var6);
         var1.sampler0
            .handleFloat7(
               this.float_3 + this.float_4 - 7.0F,
               var6,
               4.0F,
               var5,
               Float.MAX_VALUE,
               Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().outlineVariant(), var2 * 0.8F)
            );
      }
   }

   public ContainerComponent() {
      this.int_ = -1;
   }

   private void run188() {
      GuiComponent var3;
      if ((var3 = this.getGuiComponent()) != null) {
         float var2;
         float var9 = (var2 = var3.getFloat115() + this.cls.getFloat() - this.float_) + var3.getFloat116();
         if (var2 < this.float_5) {
            this.float_5 = var2;
         }

         float var5 = this.float_5 + this.float_2;
         if (var9 > var5) {
            float var7 = this.float_2;
            float var8 = var9 - var7;
            this.float_5 = var8;
         }

         this.float_7 = 0.0F;
      }
   }

   protected float getFloat120() {
      return 12.0F;
   }

   protected abstract void handleCls212(Cls2 var1);

   public GuiComponent getGuiComponent() {
      if (this.int_ >= 0) {
         int var1 = this.int_;
         int var2 = this.list.size();
         if (var1 < var2) {
            return this.list.get(this.int_);
         }
      }

      return null;
   }

   @Override
   public void handleCls27(Cls2 var1) {
      Sampler0 var2 = var1.sampler0;
      var2.handleFloat24(this.float_3, this.float_, this.float_4, this.float_2);
      this.handleCls29(var1);
      super.handleCls27(var1);
      this.handleCls211(var1);
      var2.run38();
      this.handleCls210(var1);
   }

   protected void handleCls29(Cls2 var1) {
   }
}
