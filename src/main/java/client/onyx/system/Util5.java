package client.onyx.system;

import java.util.regex.Pattern;

public final class Util5 {
   private static final Pattern PATTERN = Pattern.compile("(?i)§[0-9A-FK-OR]");

   public static String getStringForString(String var0) {
      if (var0 != null && var0.indexOf(167) >= 0) {
         return PATTERN.matcher(var0).replaceAll("").replace("§", "");
      } else {
         return var0 == null ? "" : var0;
      }
   }

   private Util5() {
   }
}
