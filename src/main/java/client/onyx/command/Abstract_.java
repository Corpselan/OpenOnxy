package client.onyx.command;

import client.onyx.MinecraftAccess;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public abstract class Abstract_ implements MinecraftAccess {
   private final String[] stringArray;
   private final String string;
   private final String string2;
   private final String string3;

   public String getString13() {
      return this.string3;
   }

   public abstract void handleStringArray(String[] var1);

   public boolean isString2(String var1) {
      if (this.string.equalsIgnoreCase(var1)) {
         return true;
      } else {
         String[] var4 = this.stringArray;
         int var3 = this.stringArray.length;

         int var5;
         for (int var10000 = var5 = 0; var10000 < var3; var10000 = ++var5) {
            if (var4[var5].equalsIgnoreCase(var1)) {
               return true;
            }
         }

         return false;
      }
   }

   public static void handleString3(String var0) {
      handleIChatComponent(new ChatComponentText(var0).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
   }

   protected Abstract_(String var1, String var2, String var3, String... var4) {
      this.string = var1;
      this.string3 = var2;
      this.string2 = var3;
      this.stringArray = var4;
   }

   public static void handleIChatComponent(IChatComponent var0) {
      if (MINECRAFT.ingameGUI != null) {
         MINECRAFT.ingameGUI
            .getChatGUI()
            .printChatMessage(
               new ChatComponentText("")
                  .appendSibling(new ChatComponentText("[").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GRAY)))
                  .appendSibling(new ChatComponentText("onyx").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.AQUA)))
                  .appendSibling(new ChatComponentText("] ").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GRAY)))
                  .appendSibling(var0)
            );
      }
   }

   public static void handleString2(String var0) {
      handleIChatComponent(new ChatComponentText(var0).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GRAY)));
   }

   public String[] getStringArray() {
      return this.stringArray;
   }

   public String getString15() {
      return this.string2;
   }

   public String getString14() {
      return this.string;
   }
}
