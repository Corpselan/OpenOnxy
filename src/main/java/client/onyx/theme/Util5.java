package client.onyx.theme;

public final class Util5 {
   public static final float[] FLOAT_ARRAY;

   private Util5() {
   }

   public static float getFloatForInt(int var0) {
      return FLOAT_ARRAY[Math.clamp((long)var0, 0, FLOAT_ARRAY.length - 1)];
   }

   public static int getIntForInt(int var0, PrimaryOnPrimaryRecord var1) {
      switch (Math.clamp((long)var0, 0, 5)) {
         case 0:

            return var1.surface();
         case 1:
            return var1.surfaceContainerLow();
         case 2:
            return var1.surfaceContainer();
         case 3:
            return var1.surfaceContainerHigh();
         default:
            return var1.surfaceContainerHighest();
      }
   }

   static {
      float[] var0 = new float[]{0.0F, 1.0F, 3.0F, 6.0F, 8.0F, 12.0F};
      FLOAT_ARRAY = var0;
   }
}
