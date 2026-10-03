package client.onyx.render.blur;

public final class Cls2 {
   private static final float FLOAT = 260.0F;
   private int int_;
   private static final float FLOAT2 = 0.3F;
   private final float[] floatArray;
   private final float[] floatArray2;
   private static final int INT = 7;
   private static final float FLOAT3 = 80.0F;

   public void run() {
      int var2;
      for (int var10000 = var2 = 0; var10000 < this.floatArray.length; var10000 = var2) {
         this.floatArray[var2] = 0.0F;
         this.floatArray2[var2++] = 0.0F;
      }

      this.int_ = 0;
   }

   private int getInt(int var1) {
      int var2;
      for (int var10000 = var2 = 0; var10000 < this.floatArray.length; var10000 = ++var2) {
         int var4 = (var1 + var2) % this.floatArray.length;
         if (this.floatArray2[var4] <= 0.0F) {
            return var4;
         }
      }

      return var1;
   }

   public void handleFloat(float var1) {
      int var3;
      for (int var10000 = var3 = 0; var10000 < this.floatArray.length; var10000 = ++var3) {
         if (!(this.floatArray2[var3] <= 0.0F)) {
            this.floatArray[var3] = this.floatArray[var3] + Math.max(0.0F, var1);
            if (this.floatArray[var3] >= this.floatArray2[var3]) {
               this.floatArray2[var3] = 0.0F;
            }
         }
      }
   }

   public void handleInt(int var1, float var2) {
      var2 = 1.0F / Math.max(var2, 0.1F);
      var1 = Math.clamp((long)var1, 1, this.floatArray.length);
      int var4 = Math.max(1, this.floatArray.length / var1);

      int var6;
      for (int var10000 = var6 = 0; var10000 < var1; var10000 = var6) {
         int var7 = this.int_ + var6 * var4;
         int var9 = this.floatArray.length;
         int var10 = var7 % var9;
         int var5 = this.getInt(var10);
         this.floatArray[var5] = -var6 * 80.0F * var2;
         float var10002 = 260.0F * var2;
         var6++;
         this.floatArray2[var5] = var10002;
      }

      int var14 = (this.int_ + 7) % this.floatArray.length;
      this.int_ = var14;
   }

   public static String decrypt(String var0) {
      int var10001 = 4 << 4 ^ 12;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 81;
      int var10000 = var10002;

      for (byte var2 = 34; var10000 >= 0; var10000 = var5) {
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

   public Cls2() {
      float[] var10003 = new float[18];
      boolean var10005 = true;
      this.floatArray = var10003;
      float[] var10001 = new float[18];
      boolean var1 = true;
      this.floatArray2 = var10001;
   }

   private static float getFloatForFloat(float var0) {
      return var0 * var0 * (3.0F - 2.0F * var0);
   }

   public float getFloat(int var1) {
      float var2;
      if ((var2 = this.floatArray2[var1]) <= 0.0F) {
         return 0.0F;
      } else {
         float var3;
         if ((var3 = this.floatArray[var1] / var2) <= 0.0F || var3 >= 1.0F) {
            return 0.0F;
         } else {
            return var3 < 0.3F ? getFloatForFloat(var3 / 0.3F) : 1.0F - getFloatForFloat((var3 - 0.3F) / 0.7F);
         }
      }
   }
}
