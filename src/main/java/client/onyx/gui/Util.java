package client.onyx.gui;

import client.onyx.module.ModuleCategory;
import client.onyx.module.hud.WatermarkModule;
import client.onyx.render.Sampler0;

public final class Util {
   public static final String STRING = "\ue566";
   public static final String STRING2 = "\ue5c4";
   public static final String STRING3 = "\ue87d";
   public static final String STRING4 = "\ue7fe";
   public static final String STRING5 = "\ue640";
   public static final String STRING6 = "\ue7fd";
   public static final String STRING7 = "\ue9e0";
   public static final String STRING8 = "\ue5d5";
   public static final String STRING9 = "\ue8f4";
   public static final String STRING10 = "\ue5cd";
   public static final String STRING11 = "\ue8b6";
   public static final String STRING12 = "\ue5ca";
   public static final String STRING13 = "\uea77";
   public static final String STRING14 = "\ue001";
   public static final String STRING15 = "\ue9ba";
   private static final float FLOAT = 0.06F;
   public static final String STRING16 = "\ue8b8";
   public static final String STRING17 = "\ue14d";
   public static final String STRING18 = "\ue872";
   public static final String STRING19 = "\ue7f4";
   public static final String STRING20 = "\ue73c";
   public static final String STRING21 = "\ue161";
   public static final String STRING22 = "\uea4b";
   public static final String STRING23 = "\ue88e";
   public static final String STRING24 = "\ue875";
   public static final String STRING25 = "\ue405";
   public static final String STRING26 = "\ue002";
   public static final String STRING27 = "\ue871";
   public static final String STRING28 = "\ue145";
   public static final String STRING29 = "\ue2c4";
   public static final String STRING30 = "\ue2c8";
   public static final String STRING31 = "\ue5d4";
   public static final String STRING32 = "\ue9e4";
   public static final String STRING33 = "\ue5cf";
   public static final String STRING34 = "\ue202";
   public static final String STRING35 = "\ue89e";
   public static final String STRING36 = "\ue312";

   public static void handleSampler02(Sampler0 var0, float var1, float var2, float var3, int var4) {
      var0.handleString6("\ue5c4", var1, var2, var3, var4);
   }

   public static void handleSampler07(Sampler0 var0, float var1, float var2, float var3, int var4) {
      var0.handleString6("\ue5cf", var1, var2, var3, var4);
   }

   public static void handleSampler0(Sampler0 var0, float var1, float var2, float var3, int var4) {
      var0.handleString6("\ue5cd", var1, var2, var3, var4);
   }

   public static void handleSampler05(Sampler0 var0, WatermarkModule.FpsUsernameEnum var1, float var2, float var3, float var4, int var5) {
      var0.handleString6(getStringForFpsUsernameEnum(var1), var2, var3, var4, var5);
   }

   private static String getStringForFpsUsernameEnum(WatermarkModule.FpsUsernameEnum var0) {
      switch (var0) {
         case FPS:

            return "\ue9e4";
         case USERNAME:
            return "\ue7fd";
         case PING:
            return "\ue640";
         case PACKET_LOSS:
            return "\ue202";
         case SERVER:
            return "\ue875";
         default:
            throw new MatchException(null, null);
      }
   }

   public static void handleSampler06(Sampler0 var0, float var1, float var2, float var3, int var4) {
      float var5 = var3 * 0.06F;
      var0.handleString7("\ue5ca", var1, var2, var3, var4, var5);
   }

   private static String getStringForModuleCategory(ModuleCategory var0) {
      switch (var0) {
         case COMBAT:

            return "\ue9e0";
         case MOVEMENT:
            return "\ue566";
         case PLAYER:
            return "\ue7fd";
         case RENDER:
            return "\ue8f4";
         case HUD:
            return "\ue871";
         default:
            throw new MatchException(null, null);
      }
   }

   public static void handleSampler04(Sampler0 var0, ModuleCategory var1, float var2, float var3, float var4, int var5) {
      var0.handleString6(getStringForModuleCategory(var1), var2, var3, var4, var5);
   }

   private Util() {
   }

   public static String decrypt(String var0) {
      int var10001 = 3 << 3 ^ 3;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 58;
      int var10000 = var10002;

      for (byte var2 = 39; var10000 >= 0; var10000 = var5) {
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

   public static void handleSampler03(Sampler0 var0, float var1, float var2, float var3, int var4) {
      var0.handleString6("\ue8b6", var1, var2, var3, var4);
   }
}
