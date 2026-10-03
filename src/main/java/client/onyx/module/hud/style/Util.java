package client.onyx.module.hud.style;

import client.onyx.render.misc.Cls;

public final class Util {
   public String string;
   public boolean bool;
   public final Cls cls = new Cls(0.0F);
   public int int_;
   public float float_;
   public final Cls cls2;

   public Util(float var1) {
      this.cls2 = new Cls(var1);
   }

   public static String decrypt(String var0) {
      int var10000 = 4 << 4 ^ 5;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 16;
      byte var13 = 17;
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
}
