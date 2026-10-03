package client.onyx.render;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;

public final class Util20 {
   private static final int INT = -1;
   private static boolean bool;
   private static final int INT2 = 16;
   private static final int INT3 = 0;
   private static Cursor cursor;
   private static Cursor cursor2;
   private static boolean bool2;
   private static final int INT4 = -16777216;
   private static final String[] STRING_ARRAY;
   private static final String[] STRING_ARRAY2;
   private static Util20.DefaultPointerEnum defaultPointerEnum2 = Util20.DefaultPointerEnum.DEFAULT;
   private static Util20.DefaultPointerEnum defaultPointerEnum = Util20.DefaultPointerEnum.DEFAULT;

   private static void run() {
      if (!bool2) {
         bool2 = true;
         if ((Cursor.getCapabilities() & 1) != 0 && Cursor.getMinCursorSize() <= 16 && Cursor.getMaxCursorSize() >= 16) {
            cursor = getCursorForStringArray(STRING_ARRAY, 5, 0);
            cursor2 = getCursorForStringArray(STRING_ARRAY2, 5, 7);
            if (cursor == null || cursor2 == null) {
               bool = true;
            }
         } else {
            bool = true;
         }
      }
   }

   private Util20() {
   }

   public static void run3() {
      defaultPointerEnum2 = Util20.DefaultPointerEnum.DEFAULT;
      if (!bool && defaultPointerEnum != Util20.DefaultPointerEnum.DEFAULT) {
         try {
            Mouse.setNativeCursor(null);
         } catch (RuntimeException | LWJGLException var1) {
         }

         defaultPointerEnum = Util20.DefaultPointerEnum.DEFAULT;
      }
   }

   public static void handleDefaultPointerEnum(Util20.DefaultPointerEnum var0) {
      if (var0.ordinal() > defaultPointerEnum2.ordinal()) {
         defaultPointerEnum2 = var0;
      }
   }

   static {
      String[] var0 = new String[]{
         "     ##         ",
         "    #..#        ",
         "    #..#        ",
         "    #..#        ",
         "    #..#        ",
         "    #..# ##     ",
         "    #..##..#    ",
         "    #..#..#.#   ",
         " ## #..#..#..#  ",
         "#..##........#  ",
         "#............#  ",
         " #...........#  ",
         "  #..........#  ",
         "  #.........#   ",
         "   #........#   ",
         "   #########    "
      };
      STRING_ARRAY = var0;
      String[] var1 = new String[]{
         "                ",
         "   ##  ##       ",
         "   #.##.#       ",
         "    #..#        ",
         "    #..#        ",
         "    #..#        ",
         "    #..#        ",
         "    #..#        ",
         "    #..#        ",
         "    #..#        ",
         "    #..#        ",
         "    #..#        ",
         "    #..#        ",
         "   #.##.#       ",
         "   ##  ##       ",
         "                "
      };
      STRING_ARRAY2 = var1;
   }

   public static void run2() {
      Util20.DefaultPointerEnum var0 = defaultPointerEnum2;
      defaultPointerEnum2 = Util20.DefaultPointerEnum.DEFAULT;
      if (!bool && var0 != defaultPointerEnum) {
         run();
         if (!bool) {
            Cursor var1 = switch (var0) {
               case DEFAULT -> {
                  yield null;

               }
               case TEXT -> cursor;
               case POINTER -> cursor2;
            };

            try {
               Mouse.setNativeCursor(var1);
               defaultPointerEnum = var0;
            } catch (RuntimeException | LWJGLException var3) {
               bool = true;
            }
         }
      }
   }

   private static Cursor getCursorForStringArray(String[] var0, int var1, int var2) {
      IntBuffer var3 = BufferUtils.createIntBuffer(256);

      int var7;
      for (int var10000 = var7 = 15; var10000 >= 0; var10000 = --var7) {
         String var5 = var0[var7];

         int var6;
         for (int var9 = var6 = 0; var9 < 16; var9 = ++var6) {
            var3.put(switch (var5.charAt(var6)) {
               case '#' -> {
                  yield -16777216;

               }
               case '.' -> -1;
               default -> 0;
            });
         }
      }

      var3.flip();

      try {
         return new Cursor(16, 16, var1, 15 - var2, 1, var3, null);
      } catch (RuntimeException | LWJGLException var8) {
         return null;
      }
   }

   public static enum DefaultPointerEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      DEFAULT,
      POINTER,
      TEXT;

   }
}
