package client.onyx.module;

import client.onyx.setting.DisplayNamed;

public enum ModuleCategory implements DisplayNamed {
   // 顺序按原 $VALUES 数组（即 ordinal）
   COMBAT("Combat"),
   MOVEMENT("Movement"),
   PLAYER("Player"),
   RENDER("Render"),
   HUD("HUD");

   private final String string;

   @Override
   public String getString5() {
      return this.string;
   }

   public String getString2() {
      return this.string;
   }


   private ModuleCategory(String var3) {
      this.string = var3;
   }
}
