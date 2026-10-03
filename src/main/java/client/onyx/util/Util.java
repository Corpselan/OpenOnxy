package client.onyx.util;

public final class Util {
   public static final int INT = -500;
   public static final int INT2 = -50;
   public static final int INT3 = -10;
   public static final int INT4 = -100;
   public static final int INT5 = 500;
   public static final int INT6 = 1000;
   public static final int INT7 = -1000;

   private Util() {
   }

   public static String decrypt(String var0) {
      int var10002 = 4 << 4 ^ 6;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var12 = var5 = var10003 - 1;
      char[] var1 = var10004;
      int var4 = var10002;
      byte var10001 = 19;
      int var10000 = var12;

      for (byte var2 = 112; var10000 >= 0; var10000 = var5) {
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
