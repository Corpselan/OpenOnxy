package client.onyx.module.hud.targethud;

import client.onyx.render.font.Ayg;
import java.util.Locale;

public final class Util {
   public static final String STRING = "{name} {health} {max} {hearts} {distance} {status}";

   private static String getStringForFloat(float var0) {
      Locale var1 = Locale.ROOT;
      Object[] var2 = new Object[1];
      Float var3 = var0;
      var2[0] = var3;
      return String.format(var1, "%.1f", var2);
   }

   public static String getStringForAyg(Ayg var0, String var1) {
      int var2;
      for(int var10000 = var2 = 0; var10000 < var1.length(); var10000 = var2) {
         if (!var0.isChar2(var1.charAt(var2))) {
            StringBuilder var4;
            (var4 = new StringBuilder(var1.length())).append(var1, 0, var2);
            int var3 = var2;

            for(var10000 = var2; var10000 < var1.length(); var10000 = var3) {
               char var5 = var1.charAt(var3);
               var4.append(var0.isChar2(var5) ? var5 : '?');
               ++var3;
            }

            return var4.toString();
         }

         ++var2;
      }

      return var1;
   }

   private Util() {
   }

   private static String getStringForString2(String var0, Util.NameHealthRecord var1, NumberHeartsEnum var2) {
      byte var10000;
      label63: {
         String var3 = var0.toLowerCase(Locale.ROOT);
         byte var5 = -1;
         byte var6;
         switch(var3.hashCode()) {
         case -1221262756:

            if (var3.equals("health")) {
               var10000 = var6 = 1;
               break label63;
            }
            break;
         case -1221256979:
            if (var3.equals("hearts")) {
               var10000 = var6 = 3;
               break label63;
            }
            break;
         case -892481550:
            if (var3.equals("status")) {
               var5 = 5;
            }
            break;
         case 107876:
            if (var3.equals("max")) {
               var10000 = var6 = 2;
               break label63;
            }
            break;
         case 3373707:
            if (var3.equals("name")) {
               var10000 = var6 = 0;
               break label63;
            }
            break;
         case 288459765:
            if (var3.equals("distance")) {
               var10000 = var6 = 4;
               break label63;
            }
         }

         var10000 = var5;
      }

      switch(var10000) {
      case 0:

         return var1.name();
      case 1:
         return getStringForFloat(var2.isEnabled8() ? var1.health() / 2.0F : var1.health());
      case 2:
         return getStringForFloat(var2.isEnabled8() ? var1.max() / 2.0F : var1.max());
      case 3:
         return getStringForFloat(var1.health() / 2.0F);
      case 4:
         return String.valueOf(Math.round(var1.distance()));
      case 5:
         return var1.status();
      default:
         return null;
      }
   }

   public static String getStringForString(String var0, Util.NameHealthRecord var1, NumberHeartsEnum var2) {
      if (var0 != null && !var0.isEmpty()) {
         if (var0.indexOf(123) < 0) {
            return var0;
         } else {
            StringBuilder var4 = new StringBuilder(var0.length() + 8);
            int var8;
            int var10000 = var8 = 0;

            StringBuilder var9;
            while(true) {
               if (var10000 >= var0.length()) {
                  var9 = var4;
                  break;
               }

               int var5;
               if ((var5 = var0.indexOf(123, var8)) < 0) {
                  var9 = var4;
                  var4.append(var0, var8, var0.length());
                  break;
               }

               int var6;
               if ((var6 = var0.indexOf(125, var5 + 1)) < 0) {
                  var4.append(var0, var8, var0.length());
                  var9 = var4;
                  break;
               }

               var4.append(var0, var8, var5);
               String var7 = getStringForString2(var0.substring(var5 + 1, var6), var1, var2);
               var4.append(var7 != null ? var7 : var0.substring(var5, var6 + 1));
               var8 = var6 + 1;
               var10000 = var8;
            }

            return var9.toString();
         }
      } else {
         return "";
      }
   }

   public static String decrypt(String var0) {
      int var10002 = 48 ^ 1;
      int var10003 = (var0 = (String)var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var10 = var10003 - 1;
      var10003 = var10002;
      int var5;
      var10002 = var5 = var10;
      char[] var1 = var10004;
      int var4 = var10003;
      boolean var11 = true;
      int var10000 = var10002;

      for(byte var2 = 33; var10000 >= 0; var10000 = var5) {
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

   public static record NameHealthRecord(String name, float health, float max, float distance, String status) {
      public String name() {
         return this.name;
      }

      public float distance() {
         return this.distance;
      }

      public String status() {
         return this.status;
      }

      public float health() {
         return this.health;
      }

      public float max() {
         return this.max;
      }

   }
}
