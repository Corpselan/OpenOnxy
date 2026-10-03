package client.onyx.module.hud.style;

import client.onyx.setting.DisplayNamed;

public enum AccentStaticEnum implements DisplayNamed {
   // 顺序按原 $VALUES 数组（即 ordinal）
   ACCENT("Accent"),
   STATIC("Static"),
   FADE("Fade"),
   GRADIENT("Gradient"),
   RAINBOW("Rainbow"),
   CATEGORY("Category");
   private final String string;

   @Override
   public String getString5() {
      return this.string;
   }

   public boolean isEnabled6() {
      return this == FADE || this == GRADIENT;
   }

   private AccentStaticEnum(String var3) {
      this.string = var3;
   }

   public boolean isEnabled5() {
      return this == FADE || this == RAINBOW;
   }

}
