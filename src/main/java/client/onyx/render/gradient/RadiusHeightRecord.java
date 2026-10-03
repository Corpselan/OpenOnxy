package client.onyx.render.gradient;

public record RadiusHeightRecord(
   float radius,
   float height,
   StaticGradientEnum colors,
   int color,
   int secondColor,
   float colorPhase,
   float opacity,
   boolean glow,
   boolean trail,
   float trailSpan,
   float sweep,
   boolean throughWalls
) {
   public static String decrypt(String var0) {
      int var10001 = 3 << 3 ^ 5;
      int var10002 = 3 << 3 ^ 7;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var13 = var5 = var10003 - 1;
      char[] var1 = var10004;
      int var4 = var10002;
      byte var12 = 47;
      int var10000 = var13;

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
}
