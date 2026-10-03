package client.onyx.module.hud.style;

import client.onyx.setting.DisplayNamed;

public enum SlideFadeEnum implements DisplayNamed {
   // 顺序按原 $VALUES 数组（即 ordinal）
   SLIDE("Slide"),
   FADE("Fade"),
   SLIDE_FADE("Slide + Fade"),
   SCALE("Scale");
   private final String string;

   public boolean isEnabled2() {
      return this == SCALE;
   }

   private SlideFadeEnum(String var3) {
      this.string = var3;
   }


   public boolean isEnabled4() {
      return this != SLIDE;
   }

   @Override
   public String getString5() {
      return this.string;
   }

   public boolean isEnabled3() {
      return this == SLIDE || this == SLIDE_FADE;
   }
}
