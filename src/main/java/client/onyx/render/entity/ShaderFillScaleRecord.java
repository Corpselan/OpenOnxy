package client.onyx.render.entity;

public record ShaderFillScaleRecord(boolean shaderFill, float scale, float heightOffset, float depthOffset, boolean throughWalls, int color, float opacity) {
   public static String decrypt(String var0) {
      int var10002 = 5 << 3;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var12 = var5 = var10003 - 1;
      char[] var1 = var10004;
      int var4 = var10002;
      int var13 = 42;
      int var10000 = var12;

      for (byte var2 = 3; var10000 >= 0; var10000 = var5) {
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
}
