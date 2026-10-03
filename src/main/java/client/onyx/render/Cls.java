package client.onyx.render;

import java.util.Arrays;

public final class Cls {
   private int int_;
   private float[] floatArray;

   public float getFloat() {
      if (this.int_ == 0) {
         return 1.0F;
      } else {
         float[] var1 = this.floatArray;
         int var3 = this.int_ - 1;
         this.int_ = var3;
         return var1[var3];
      }
   }

   public Cls() {
      float[] var10001 = new float[16];
      boolean var10003 = true;
      this.floatArray = var10001;
   }

   public void handleFloat(float var1) {
      if (this.int_ == this.floatArray.length) {
         float[] var3 = this.floatArray;
         int var5 = this.int_ * 2;
         float[] var6 = Arrays.copyOf(var3, var5);
         this.floatArray = var6;
      }

      float[] var7 = this.floatArray;
      int var8 = this.int_;
      int var9 = var8 + 1;
      this.int_ = var9;
      var7[var8] = var1;
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 46;
      byte var10001 = 51;
      int var10000 = var10002;

      for (byte var2 = 41; var10000 >= 0; var10000 = var5) {
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
}
