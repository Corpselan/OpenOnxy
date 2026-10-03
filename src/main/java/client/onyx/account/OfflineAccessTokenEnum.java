package client.onyx.account;

public enum OfflineAccessTokenEnum {
   // 顺序按原 $VALUES 数组（即 ordinal）
   OFFLINE("offline", "Offline", false),
   ACCESS_TOKEN("access_token", "Access Token", true),
   MICROSOFT("microsoft", "Microsoft", true);
   private final String string;
   private final String string2;
   private final boolean bool;


   public String getString2() {
      return this.string;
   }

   private OfflineAccessTokenEnum(String var3, String var4, boolean var5) {
      this.string = var3;
      this.string2 = var4;
      this.bool = var5;
   }

   public static OfflineAccessTokenEnum getOfflineAccessTokenEnumForString(String var0) {
      OfflineAccessTokenEnum[] var1;
      int var2 = (var1 = values()).length;

      int var5;
      for (int var10000 = var5 = 0; var10000 < var2; var10000 = ++var5) {
         OfflineAccessTokenEnum var4;
         if ((var4 = var1[var5]).string.equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }

   public boolean isEnabled() {
      return this.bool;
   }

   public String getString() {
      return this.string2;
   }
}
