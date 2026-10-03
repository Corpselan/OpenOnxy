package client.onyx.module.player.scaffold;

import java.util.concurrent.ThreadLocalRandom;

public final class Cls {
   private int int_;

   public float getFloat(float var1, double var2) {
      if (var2 <= 0.0) {
         return var1;
      } else {
         double var4;
         return (var4 = client.onyx.rotation.util.Util.getDouble16()) <= 0.0
            ? var1
            : (float)(var1 + this.getInt(Math.max(1, (int)Math.floor(var2 / var4))) * var4);
      }
   }

   public static String decrypt(String var0) {
      int var10002 = 112 ^ 1 << 1;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var12 = var5 = var10003 - 1;
      char[] var1 = var10004;
      int var4 = var10002;
      int var13 = 108;
      int var10000 = var12;

      for (byte var2 = 118; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var13 = var5--;
         var1[var13] = (char)(var10.charAt(var13) ^ var4);
      }

      return new String(var1);
   }

   private int getInt(int var1) {
      if (var1 <= 1) {
         return this.int_ = this.int_ > 0 ? -1 : 1;
      } else {
         int var3;
         do {
            while ((var3 = ThreadLocalRandom.current().nextInt(-var1, var1 + 1)) == 0) {
            }
         } while (var3 == this.int_);

         return this.int_ = var3;
      }
   }
}
