package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.NoneValueSetting;
import client.onyx.setting.impl.ValueSettingSub10;

public final class ZoomModule extends Module {
   public NoneValueSetting noneValueSetting2 = new NoneValueSetting("Zoom Key", 47);
   private float float_;
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Distance", 4.0, 1.5, 12.0, 0.5).getValueSettingSub10("x");
   private long long_;

   public ZoomModule() {
      super("Zoom", "Smooth hold-to-zoom camera", ModuleCategory.RENDER);
      this.valueSettingSub10 = new ValueSettingSub10("Animation", 180.0, 0.0, 500.0, 10.0).getValueSettingSub10(" ms");
   }

   public float getFloat36(float var1) {
      long var2 = System.nanoTime();
      float var4 = this.long_ == 0L ? 0.0F : Math.min((float)(var2 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var2;
      boolean var8 = this.isEnabled55() && this.noneValueSetting2.isEnabled19() && MINECRAFT.currentScreen == null && this.noneValueSetting2.isEnabled22();
      float var5 = var8 ? 1.0F : 0.0F;
      float var3;
      float var10000;
      if ((var3 = this.valueSettingSub10.getFloat5()) <= 0.0F) {
         var10000 = var1;
         this.float_ = var5;
      } else {
         if (var4 > 0.0F) {
            float var7 = Math.clamp(var4 / var3, 0.0F, 1.0F);
            var7 = 1.0F - (float)Math.pow(1.0F - var7, 3.0);
            this.float_ = this.float_ + (var5 - this.float_) * var7;
            if (Math.abs(var5 - this.float_) < 0.001F) {
               this.float_ = var5;
            }
         }

         var10000 = var1;
      }

      return var1 + (var10000 / this.valueSettingSub102.getFloat5() - var1) * getFloatForFloat12(this.float_);
   }

   private static float getFloatForFloat12(float var0) {
      float var1;
      float var10000 = var1 = Math.clamp(var0, 0.0F, 1.0F);
      return var10000 * var10000 * (3.0F - 2.0F * var1);
   }

   @Override
   protected void run79() {
      this.long_ = 0L;
   }

   public boolean isEnabled57() {
      return this.isEnabled55() && this.float_ > 0.02F;
   }

   public float getFloat35() {
      return this.isEnabled55() ? this.float_ : 0.0F;
   }
}
