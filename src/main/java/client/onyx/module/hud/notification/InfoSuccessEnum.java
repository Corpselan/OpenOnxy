package client.onyx.module.hud.notification;

import client.onyx.setting.DisplayNamed;
import client.onyx.theme.PrimaryOnPrimaryRecord;

public enum InfoSuccessEnum implements DisplayNamed {
   // 顺序按原 $VALUES 数组（即 ordinal）
   INFO("Info"),
   SUCCESS("Success"),
   WARNING("Warning"),
   ERROR("Error");
   private final String string;


   private InfoSuccessEnum(String var3) {
      this.string = var3;
   }

   @Override
   public String getString5() {
      return this.string;
   }

   public String getString3() {
      switch (this) {
         case SUCCESS:

            return "\ue88e";
         case ERROR:
            return "\ue5ca";
         case INFO:
            return "\ue002";
         case WARNING:
            return "\ue001";
         default:
            throw new MatchException(null, null);
      }
   }

   public int getInt4(PrimaryOnPrimaryRecord var1) {
      switch (this) {
         case SUCCESS:

            return var1.primary();
         case ERROR:
            return var1.tertiary();
         case INFO:
            return var1.secondary();
         case WARNING:
            return var1.error();
         default:
            throw new MatchException(null, null);
      }
   }
}
