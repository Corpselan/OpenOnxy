package client.onyx.skin;

import net.minecraft.util.ResourceLocation;

public final class Util {
   private static volatile ResourceLocation resourceLocation;
   private static volatile String string;

   public static boolean isEnabled() {
      return resourceLocation != null;
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 23;
      byte var10001 = 46;
      int var10000 = var10002;

      for (byte var2 = 93; var10000 >= 0; var10000 = var5) {
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

   public static ResourceLocation getResourceLocation() {
      return resourceLocation;
   }

   private Util() {
   }

   public static void handleResourceLocation(ResourceLocation var0, String var1) {
      resourceLocation = var0;
      string = var1 == null ? "default" : var1;
   }

   public static void run() {
      resourceLocation = null;
      string = null;
   }

   public static String getString() {
      return string;
   }
}
