package client.onyx.gui;

import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;

public final class Util2 {
   public static boolean isKeyScancodeRecord10(KeyScancodeRecord var0) {
      return isKeyScancodeRecord7(var0, 49);
   }

   public static boolean isKeyScancodeRecord2(KeyScancodeRecord var0) {
      return var0.isEnabled() || var0.isEnabled4();
   }

   public static boolean isCodepointModifiersRecord(CodepointModifiersRecord var0) {
      int var2;
      return (var2 = var0.codepoint()) >= 32 && var2 != 127 && Character.isDefined(var2);
   }

   public static boolean isKeyScancodeRecord11(KeyScancodeRecord var0) {
      return var0.key() == 14 && !isKeyScancodeRecord2(var0) && !var0.isEnabled2();
   }

   public static boolean isKeyScancodeRecord8(KeyScancodeRecord var0) {
      return isKeyScancodeRecord2(var0) || var0.isEnabled2();
   }

   public static boolean isKeyScancodeRecord7(KeyScancodeRecord var0, int var1) {
      return var0.key() == var1 && isKeyScancodeRecord2(var0) && !var0.isEnabled3() && !var0.isEnabled2();
   }

   public static boolean isKeyScancodeRecord3(KeyScancodeRecord var0) {
      return isKeyScancodeRecord7(var0, 33);
   }

   public static boolean isKeyScancodeRecord9(KeyScancodeRecord var0) {
      return isKeyScancodeRecord7(var0, 31);
   }

   public static String decrypt(String var0) {
      int var10001 = 4 << 4 ^ 14;
      int var10002 = 4 << 4;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var12 = var5 = var10003 - 1;
      char[] var1 = var10004;
      int var4 = var10002;
      int var10000 = var12;

      for (byte var2 = 46; var10000 >= 0; var10000 = var5) {
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

   public static boolean isKeyScancodeRecord(KeyScancodeRecord var0) {
      return isKeyScancodeRecord7(var0, 44);
   }

   public static boolean isKeyScancodeRecord6(KeyScancodeRecord var0) {
      return var0.key() == 28 || var0.key() == 156;
   }

   public static boolean isKeyScancodeRecord4(KeyScancodeRecord var0) {
      return isKeyScancodeRecord7(var0, 21) || isKeyScancodeRecord5(var0, 44);
   }

   public static boolean isKeyScancodeRecord5(KeyScancodeRecord var0, int var1) {
      return var0.key() == var1 && isKeyScancodeRecord2(var0) && var0.isEnabled3() && !var0.isEnabled2();
   }

   private Util2() {
   }
}
