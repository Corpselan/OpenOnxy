package client.onyx.module.hud.style;

import client.onyx.setting.DisplayNamed;

public enum WidthDescWidthAscEnum implements DisplayNamed {
   // 顺序按原 $VALUES 数组（即 ordinal）
   WIDTH_DESC("Longest first"),
   WIDTH_ASC("Shortest first"),
   ALPHABETICAL("A-Z");

   private final String string;

   private WidthDescWidthAscEnum(String var3) {
      this.string = var3;
   }


   @Override
   public String getString5() {
      return this.string;
   }
}
