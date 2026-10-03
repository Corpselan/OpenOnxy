package client.onyx.render.font;

import java.util.Locale;

public final class Util {
   public static final float FLOAT = 16.0F;
   private static Ayg ayg;
   private static final String STRING = "/assets/onyx/font/ttf/";
   private static final Ayg[][] AYG_ARRAY_ARRAY = new Ayg[Util.Pt9Pt24Enum.values().length][Util.ThinExtraLightEnum.values().length];

   private Util() {
   }

   public static Ayg getAyg() {
      if (ayg == null) {
         ayg = Ayg.getAygForString("/assets/onyx/font/ttf/materialicons-regular.ttf", 16.0F);
      }

      return ayg;
   }

   public static Ayg getAygForPt9Pt24Enum(Util.Pt9Pt24Enum var0, Util.ThinExtraLightEnum var1) {
      Ayg var3;
      if ((var3 = AYG_ARRAY_ARRAY[var0.ordinal()][var1.ordinal()]) != null) {
         return var3;
      } else {
         var3 = Ayg.getAygForString(
            new StringBuilder()
               .insert(0, "/assets/onyx/font/ttf/googlesansflex_")
               .append(var0.getString())
               .append("-")
               .append(var1.name().toLowerCase(Locale.ROOT).replace("_", ""))
               .append(".ttf")
               .toString(),
            var0.getFloat()
         );
         AYG_ARRAY_ARRAY[var0.ordinal()][var1.ordinal()] = var3;
         return var3;
      }
   }

   public static enum Pt9Pt24Enum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      PT9("9pt", 18.0F),
      PT24("24pt", 24.0F),
      PT36("36pt", 36.0F),
      PT72("72pt", 54.0F),
      PT120("120pt", 144.0F);

      private final String string;
      private final float float_;

      public String getString() {
         return this.string;
      }

      private Pt9Pt24Enum(String var3, float var4) {
         this.string = var3;
         this.float_ = var4;
      }

      public float getFloat() {
         return this.float_;
      }

   }

   public static enum ThinExtraLightEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      THIN,
      EXTRA_LIGHT,
      LIGHT,
      REGULAR,
      MEDIUM,
      SEMI_BOLD,
      BOLD,
      EXTRA_BOLD,
      BLACK;

   }
}
