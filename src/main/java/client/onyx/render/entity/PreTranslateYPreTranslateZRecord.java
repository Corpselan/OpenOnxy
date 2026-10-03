package client.onyx.render.entity;

public record PreTranslateYPreTranslateZRecord(
   float preTranslateY,
   float preTranslateZ,
   float anchorY,
   float anchorZ,
   float pitchRotation,
   float yawRotation,
   float rollRotation,
   float openMultiplier,
   float scaleMultiplier,
   float motionSpreadBoost,
   float flapAmplitude,
   float sideOffset,
   float sideZOffset,
   float sideRoll,
   float sidePitch,
   float flapSpeed
) {
   private static float getFloatForFloat(float var0, float var1, float var2) {
      float var4 = (var2 - var1) * var0;
      return var1 + var4;
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 12;
      byte var10001 = 96;
      int var10000 = var10002;

      for (byte var2 = 41; var10000 >= 0; var10000 = var5) {
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

   public static PreTranslateYPreTranslateZRecord getPreTranslateYPreTranslateZRecordForPreTranslateYPreTranslateZRecord(
      PreTranslateYPreTranslateZRecord var0, PreTranslateYPreTranslateZRecord var1, float var2
   ) {
      if (var2 <= 0.0F) {
         return var0;
      } else {
         return var2 >= 1.0F
            ? var1
            : new PreTranslateYPreTranslateZRecord(
               getFloatForFloat(var2, var0.preTranslateY, var1.preTranslateY),
               getFloatForFloat(var2, var0.preTranslateZ, var1.preTranslateZ),
               getFloatForFloat(var2, var0.anchorY, var1.anchorY),
               getFloatForFloat(var2, var0.anchorZ, var1.anchorZ),
               getFloatForFloat(var2, var0.pitchRotation, var1.pitchRotation),
               getFloatForFloat(var2, var0.yawRotation, var1.yawRotation),
               getFloatForFloat(var2, var0.rollRotation, var1.rollRotation),
               getFloatForFloat(var2, var0.openMultiplier, var1.openMultiplier),
               getFloatForFloat(var2, var0.scaleMultiplier, var1.scaleMultiplier),
               getFloatForFloat(var2, var0.motionSpreadBoost, var1.motionSpreadBoost),
               getFloatForFloat(var2, var0.flapAmplitude, var1.flapAmplitude),
               getFloatForFloat(var2, var0.sideOffset, var1.sideOffset),
               getFloatForFloat(var2, var0.sideZOffset, var1.sideZOffset),
               getFloatForFloat(var2, var0.sideRoll, var1.sideRoll),
               getFloatForFloat(var2, var0.sidePitch, var1.sidePitch),
               getFloatForFloat(var2, var0.flapSpeed, var1.flapSpeed)
            );
      }
   }
}
