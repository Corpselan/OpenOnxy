package client.onyx.input;

import java.util.Arrays;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public final class Util {
   private static final boolean[] BOOL_ARRAY = new boolean[256];
   private static boolean bool = true;

   private Util() {
   }

   private static boolean isInt2(int var0, int var1) {
      return isInt(var0) || isInt(var1);
   }

   private static boolean isInt(int var0) {
      if (!BOOL_ARRAY[var0]) {
         return false;
      } else if (Keyboard.isKeyDown(var0)) {
         return true;
      } else {
         BOOL_ARRAY[var0] = false;
         return false;
      }
   }

   public static boolean isEnabled4() {
      return isInt2(42, 54);
   }

   public static void run2() {
      Arrays.fill(BOOL_ARRAY, false);
   }

   public static boolean isEnabled() {
      return isInt2(29, 157);
   }

   public static void run() {
      boolean var0;
      if (!(var0 = Display.isActive()) || !bool) {
         run2();
      }

      bool = var0;
   }

   public static boolean isEnabled3() {
      return isInt2(56, 184);
   }

   public static boolean isEnabled2() {
      return isInt2(219, 220);
   }

   public static void handleInt(int var0, boolean var1) {
      if (var0 > 0 && var0 < BOOL_ARRAY.length) {
         BOOL_ARRAY[var0] = var1;
      }
   }
}
