package client.onyx.input;

import net.minecraft.client.gui.GuiScreen;

public record KeyScancodeRecord(int key, int scancode, int modifiers, char typedChar) {
   public boolean isEnabled4() {
      return this.isEnabled();
   }

   public boolean isEnabled() {
      return GuiScreen.isCtrlKeyDown() && GuiScreen.isCtrlCharTyped(this.typedChar);
   }

   public boolean isEnabled3() {
      return GuiScreen.isShiftKeyDown();
   }

   public boolean isEnabled2() {
      return GuiScreen.isAltKeyDown();
   }

   public static String decrypt(String var0) {
      int var10001 = 4 << 4 ^ 2 << 2 ^ 1;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 41;
      byte var12 = 20;
      int var10000 = var10002;

      for (int var2 = var10001; var10000 >= 0; var10000 = var5) {
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

   public KeyScancodeRecord(int var1) {
      this(var1, 0, 0, '\u0000');
   }

   public KeyScancodeRecord(int var1, int var2, int var3) {
      this(var1, var2, var3, '\u0000');
   }
}
