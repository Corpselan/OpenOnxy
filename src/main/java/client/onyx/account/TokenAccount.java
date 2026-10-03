package client.onyx.account;

import client.onyx.account.auth.MicrosoftAuth;
import client.onyx.account.auth.OnyxException;
import com.google.gson.JsonObject;
import com.mojang.util.UUIDTypeAdapter;
import net.minecraft.util.Session;

public class TokenAccount extends Abstract_ {
   private String string2;

   @Override
   protected void handleJsonObject(JsonObject var1) {
      this.string2 = getStringForJsonObject(var1, "accessToken");
   }

   @Override
   public Session getSession() throws OnyxException {
      if (this.string2 != null && !this.string2.isBlank()) {
         if (this.uUID == null) {
            this.run();
         }

         String var1 = this.string;
         String var2 = UUIDTypeAdapter.fromUUID(this.uUID);
         return new Session(var1, var2, this.string2, "mojang");
      } else {
         throw new OnyxException("No access token stored for this account");
      }
   }

   @Override
   protected void handleJsonObject2(JsonObject var1) {
      if (this.string2 != null) {
         var1.addProperty("accessToken", this.string2);
      }
   }

   public TokenAccount(String var1) {
      super(OfflineAccessTokenEnum.ACCESS_TOKEN, var1);
   }

   public static TokenAccount getTokenAccountForString(String var0) throws OnyxException {
      MicrosoftAuth.UuidNameRecord var3 = MicrosoftAuth.getUuidNameRecordForString(var0);
      TokenAccount var2 = new TokenAccount(var3.name());
      var2.uUID = var3.uuid();
      var2.string2 = var0.trim();
      return var2;
   }

   @Override
   public void run() throws OnyxException {
      MicrosoftAuth.UuidNameRecord var2;
      this.string = (var2 = MicrosoftAuth.getUuidNameRecordForString(this.string2)).name();
      this.uUID = var2.uuid();
   }

   @Override
   public String getString3() {
      return this.string2;
   }
}
