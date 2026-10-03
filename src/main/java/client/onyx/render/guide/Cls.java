package client.onyx.render.guide;

import org.lwjgl.input.Keyboard;

public final class Cls {
   private boolean bool;
   private boolean bool2;
   private boolean bool3;
   private boolean bool4;
   private static final float FLOAT = 1.0F;
   private static final float[] FLOAT_ARRAY;

   static {
      float[] var0 = new float[]{0.0F, 0.0F};
      FLOAT_ARRAY = var0;
   }

   public float[] getFloatArray(boolean var1) {
      boolean var6 = var1 && Keyboard.isKeyDown(203);
      boolean var5 = var1 && Keyboard.isKeyDown(205);
      boolean var4 = var1 && Keyboard.isKeyDown(200);
      var1 = var1 && Keyboard.isKeyDown(208);
      float var7 = 0.0F;
      float var2 = 0.0F;
      if (var6 && !this.bool4) {
         var7--;
      }

      if (var5 && !this.bool) {
         var7++;
      }

      if (var4 && !this.bool2) {
         var2--;
      }

      if (var1 && !this.bool3) {
         var2++;
      }

      this.bool4 = var6;
      this.bool = var5;
      this.bool2 = var4;
      this.bool3 = var1;
      return var7 == 0.0F && var2 == 0.0F ? FLOAT_ARRAY : new float[]{var7, var2};
   }
}
