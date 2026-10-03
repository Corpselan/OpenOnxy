package client.onyx.module.hud.style;

import client.onyx.setting.DisplayNamed;

public enum AccentBarPillsEnum implements DisplayNamed {
   ACCENT_BAR("Accent Bar"),
   PILLS("Pills"),
   TEXT("Text");
   private final String string;

   private AccentBarPillsEnum(String var3) {
      this.string = var3;
   }

   @Override
   public String getString5() {
      return this.string;
   }

}
