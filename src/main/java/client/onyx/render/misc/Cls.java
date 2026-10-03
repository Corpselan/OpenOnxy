package client.onyx.render.misc;

public final class Cls {
   private float float_;
   private Iface iface = Util.IFACE6;
   private float float_2;
   private float float_3;
   private float float_4;

   public Cls getCls2(float var1, float var2, Iface var3) {
      if (var1 == this.float_3) {
         return this;
      } else {
         this.float_4 = this.getFloat();
         this.float_3 = var1;
         this.float_2 = Math.max(var2, 0.0F);
         this.iface = var3;
         this.float_ = 0.0F;
         return this;
      }
   }

   public static String decrypt(String var0) {
      int var10000 = 96 ^ 2 << 2 ^ 1;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 116;
      byte var13 = 95;
      var10000 = var10002;

      for (int var2 = var10000; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var10002 = var5--;
         var1[var10002] = (char)(var10.charAt(var10002) ^ var4);
      }

      return new String(var1);
   }

   public float getFloat2() {
      return this.float_3;
   }

   public boolean isEnabled() {
      return this.float_2 <= 0.0F || this.float_ >= this.float_2;
   }

   public void handleFloat(float var1) {
      if (!this.isEnabled()) {
         float var4 = Math.min(this.float_ + var1, this.float_2);
         this.float_ = var4;
      }
   }

   public float getFloat() {
      if (this.float_2 <= 0.0F) {
         return this.float_3;
      } else {
         float var2 = (float)this.iface.getDouble(this.float_ / this.float_2);
         return this.float_4 + (this.float_3 - this.float_4) * var2;
      }
   }

   public Cls(float var1) {
      this.float_4 = var1;
      this.float_3 = var1;
      this.float_2 = 0.0F;
      this.float_ = 0.0F;
   }

   public Cls getCls(float var1) {
      this.float_4 = var1;
      this.float_3 = var1;
      this.float_2 = 0.0F;
      this.float_ = 0.0F;
      return this;
   }
}
