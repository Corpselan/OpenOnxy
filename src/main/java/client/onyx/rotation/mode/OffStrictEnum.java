package client.onyx.rotation.mode;

import client.onyx.setting.DisplayNamed;

public enum OffStrictEnum implements DisplayNamed {
   // 顺序按原 $VALUES 数组（即 ordinal）
   OFF("Off"),
   STRICT("Strict"),
   SILENT("Silent"),
   CHANGE_LOOK("Change look");
   private final String string;


   @Override
   public String getString5() {
      return this.string;
   }

   private OffStrictEnum(String var3) {
      this.string = var3;
   }
}
