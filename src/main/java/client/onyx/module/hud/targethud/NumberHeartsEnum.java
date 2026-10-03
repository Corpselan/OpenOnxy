package client.onyx.module.hud.targethud;

import client.onyx.setting.DisplayNamed;

public enum NumberHeartsEnum implements DisplayNamed {
   NUMBER("Points"),
   HEARTS("Hearts"),
   ICON("Hearts + icon");

   private final String string;


   @Override
   public String getString5() {
      return this.string;
   }

   public boolean isEnabled8() {
      return this != NUMBER;
   }

   private NumberHeartsEnum(String var3) {
      this.string = var3;
   }

   public boolean isEnabled7() {
      return this == ICON;
   }
}
