package client.onyx.system;

import client.onyx.module.player.NameChangerModule;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public final class Util {
   public static String decrypt(String var0) {
      int var10003 = (var0 = (String)var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 96;
      boolean var10001 = true;
      int var10000 = var10002;

      for(byte var2 = 103; var10000 >= 0; var10000 = var5) {
         char var6 = var0.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var10002 = var5--;
         var1[var10002] = (char)(var0.charAt(var10002) ^ var4);
      }

      return new String(var1);
   }

   private static String getStringForString(String var0, String var1, String var2) {
      return !var0.isEmpty() && var0.contains(var1) ? Pattern.compile((new StringBuilder()).insert(0, "\\b").append(Pattern.quote(var1)).append("\\b").toString()).matcher(var0).replaceAll(Matcher.quoteReplacement(var2)) : var0;
   }

   private static IChatComponent getIChatComponentForIChatComponent2(IChatComponent var0, String var1, String var2) {
      Object var8;
      Object var10000;
      if (var0 instanceof ChatComponentText) {
         ChatComponentText var11 = (ChatComponentText)var0;
         var10000 = var8 = new ChatComponentText(getStringForString(var11.getChatComponentText_TextValue(), var1, var2));
      } else {
         if (!(var0 instanceof ChatComponentTranslation)) {
            return var0;
         }

         ChatComponentTranslation var4;
         Object[] var6;
         Object[] var15 = new Object[(var6 = (var4 = (ChatComponentTranslation)var0).getFormatArgs()).length];
         boolean var10002 = true;
         Object[] var7 = var15;

         int var3;
         for(int var16 = var3 = 0; var16 < var6.length; var16 = var3) {
            Object var9;
            if ((var9 = var6[var3]) instanceof IChatComponent) {
               IChatComponent var10 = (IChatComponent)var9;
               var7[var3] = getIChatComponentForIChatComponent2(var10, var1, var2);
            } else if (var9 instanceof String) {
               String var13 = (String)var9;
               var7[var3] = getStringForString(var13, var1, var2);
            } else {
               var7[var3] = var9;
            }

            ++var3;
         }

         var10000 = var8 = new ChatComponentTranslation(var4.getKey(), var7);
      }

      ((IChatComponent)var10000).setChatStyle(var0.getChatStyle());
      Iterator var14 = var0.getSiblings().iterator();
      Iterator var17 = var14;

      while(var17.hasNext()) {
         IChatComponent var12 = (IChatComponent)var14.next();
         var17 = var14;
         ((IChatComponent)var8).appendSibling(getIChatComponentForIChatComponent2(var12, var1, var2));
      }

      return (IChatComponent)var8;
   }

   public static IChatComponent getIChatComponentForIChatComponent(IChatComponent var0) {
      if (!NameChangerModule.isEnabled122()) {
         return var0;
      } else {
         String var1 = Minecraft.getMinecraft().thePlayer.getGameProfile().getName();
         String var3 = NameChangerModule.getString32();
         return !var1.isEmpty() && !var3.isEmpty() ? getIChatComponentForIChatComponent2(var0, var1, var3) : var0;
      }
   }

   private Util() {
   }
}
