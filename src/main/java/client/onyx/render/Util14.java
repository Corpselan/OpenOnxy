package client.onyx.render;

import client.onyx.OnyxClient;

public final class Util14 {
   public static boolean isEnabled() {
      return Util3.isEnabled() && OnyxClient.cls != null && OnyxClient.cls.clickGUIModule.valueSettingSub9.isEnabled17();
   }

   public static void handleSampler02(Sampler0 var0, float var1, float var2, float var3, float var4, float var5, int var6, boolean var7) {
      if (isBool(var7)) {
         var0.isFloat2(var1, var2, var3, var4, var5, var6);
      } else {
         var0.handleFloat7(var1, var2, var3, var4, var5, var6);
      }
   }

   public static void handleSampler0(Sampler0 var0, float var1, float var2, float var3, float var4, float var5, int var6) {
      handleSampler02(var0, var1, var2, var3, var4, var5, var6, true);
   }

   public static void run2() {
      if (isEnabled()) {
         Util3.run4();
      }
   }

   public static boolean isBool(boolean var0) {
      return var0 && isEnabled();
   }

   private Util14() {
   }

   public static String decrypt(String var0) {
      int var10000 = 4 << 4 ^ 10;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 119;
      var10000 = var10002;

      for (byte var2 = 116; var10000 >= 0; var10000 = var5) {
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

   public static void handleBool(boolean var0) {
      if (isBool(var0)) {
         Util3.run();
      }
   }

   public static void run() {
      handleBool(true);
   }
}
