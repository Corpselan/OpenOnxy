package client.onyx.render.entity;

import net.minecraft.util.Vec3;

public record PositionBodyYawRecord(Vec3 position, float bodyYaw, float open, AngelicDragonEnum shape, PreTranslateYPreTranslateZRecord pose) {
   public static String decrypt(String var0) {
      int var10000 = 4 << 4;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 12;
      var10000 = var10002;

      for (byte var2 = 103; var10000 >= 0; var10000 = var5) {
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
