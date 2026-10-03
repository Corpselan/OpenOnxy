package client.onyx.system;

import client.onyx.MinecraftAccess;
import java.util.Locale;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;

public final class Util10 {
   private static final String STRING = "BED WARS";
   private static final int INT = 1;

   public static boolean isEnabled2() {
      ServerData var0;
      return (var0 = MinecraftAccess.MINECRAFT.getCurrentServerData()) != null
         && var0.serverIP != null
         && var0.serverIP.toLowerCase(Locale.ROOT).contains("hypixel.net");
   }

   private static String getStringForString(String var0) {
      return var0 == null ? "" : EnumChatFormatting.getTextWithoutFormattingCodes(var0);
   }

   private static ScoreObjective getScoreObjective() {
      if (MinecraftAccess.MINECRAFT.theWorld == null) {
         return null;
      } else {
         Scoreboard var0;
         return (var0 = MinecraftAccess.MINECRAFT.theWorld.getScoreboard()) == null ? null : var0.getObjectiveInDisplaySlot(1);
      }
   }

   public static String decrypt(String var0) {
      int var10002 = 4 << 4 ^ 3;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var12 = var5 = var10003 - 1;
      char[] var1 = var10004;
      int var4 = var10002;
      int var13 = 5;
      int var10000 = var12;

      for (byte var2 = 2; var10000 >= 0; var10000 = var5) {
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

   public static boolean isEnabled() {
      return isEnabled2() && getString().toUpperCase(Locale.ROOT).contains("BED WARS");
   }

   private static String getString() {
      ScoreObjective var0;
      return (var0 = getScoreObjective()) == null ? "" : getStringForString(var0.getDisplayName());
   }

   private Util10() {
   }
}
