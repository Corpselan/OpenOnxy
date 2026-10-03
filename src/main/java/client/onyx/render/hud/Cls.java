package client.onyx.render.hud;

public final class Cls {
   private float float_ = Float.NaN;
   private static final float FLOAT = 1100.0F;
   private float float_2;
   private static final float FLOAT2 = 60.0F;
   private static final float FLOAT3 = 0.15F;
   private float float_3;
   private long long_;
   private static final float FLOAT4 = 350.0F;
   private static final float FLOAT5 = 0.028F;

   public float getFloat2(float var1) {
      float var2 = this.getFloat();
      if (!Float.isNaN(this.float_) && !(Math.abs(var1 - this.float_) > 60.0F)) {
         if (Math.abs(var1 - this.float_) > 0.01F) {
            this.float_2 = 0.0F;
         }

         this.float_ = this.float_ + (var1 - this.float_) * Math.clamp(0.028F * var2, 0.0F, 1.0F);
         this.float_3 = 0.0F;
         return this.float_;
      } else {
         this.float_ = var1;
         this.float_2 = 0.0F;
         return this.float_;
      }
   }

   public float getFloat3() {
      if (this.float_2 < 350.0F) {
         return 1.0F;
      } else {
         float var3;
         float var2 = (var3 = this.float_3 % 1100.0F / 1100.0F) < 0.5F ? var3 * 2.0F : (1.0F - var3) * 2.0F;
         return 0.15F + 0.85F * (float)client.onyx.render.misc.Util.IFACE6.getDouble(var2);
      }
   }

   private float getFloat() {
      long var1 = System.nanoTime();
      float var4 = this.long_ == 0L ? 16.0F : Math.min((float)(var1 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var1;
      this.float_2 += var4;
      this.float_3 += var4;
      return var4;
   }

   public void run() {
      this.float_ = Float.NaN;
      this.float_2 = 0.0F;
      this.float_3 = 0.0F;
      this.long_ = 0L;
   }
}
