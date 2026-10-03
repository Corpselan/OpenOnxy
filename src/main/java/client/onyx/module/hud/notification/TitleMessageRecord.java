package client.onyx.module.hud.notification;

public record TitleMessageRecord(String title, String message, InfoSuccessEnum level, Integer accent) {
   public TitleMessageRecord(String var1, String var2, InfoSuccessEnum var3) {
      this(var1, var2, var3, null);
   }
}
