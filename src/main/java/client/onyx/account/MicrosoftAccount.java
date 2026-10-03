package client.onyx.account;

import client.onyx.account.auth.MicrosoftAuth;
import client.onyx.account.auth.OnyxException;
import com.google.gson.JsonObject;
import com.mojang.util.UUIDTypeAdapter;
import net.minecraft.util.Session;

public class MicrosoftAccount extends Abstract_ {
   private long long_2;
   private String string2;
   private String string3;
   private String string4;
   private MicrosoftAuth.OAuthClientFlavour oAuthClientFlavour = MicrosoftAuth.OAuthClientFlavour.LEGACY;
   private static final long LONG = 60000L;

   public static MicrosoftAccount getMicrosoftAccountForString(String var0) throws OnyxException {
      try {
         return getMicrosoftAccountForString2(var0, MicrosoftAuth.OAuthClientFlavour.LEGACY);
      } catch (OnyxException var5) {
         if (!MicrosoftAuth.OAuthClientFlavour.AZURE.isEnabled()) {
            throw var5;
         } else {
            try {
               return getMicrosoftAccountForString2(var0, MicrosoftAuth.OAuthClientFlavour.AZURE);
            } catch (OnyxException var4) {
               throw new OnyxException(
                  new StringBuilder()
                     .insert(0, "No client id accepted this token. Live: ")
                     .append(var5.getMessage())
                     .append(" | Azure: ")
                     .append(var4.getMessage())
                     .toString()
               );
            }
         }
      }
   }

   @Override
   protected void handleJsonObject2(JsonObject var1) {
      var1.addProperty("refreshToken", this.string2);
      var1.addProperty("flavour", this.oAuthClientFlavour.getString6());
      if (this.string3 != null) {
         var1.addProperty("accessToken", this.string3);
         var1.addProperty("expiresAt", this.long_2);
         if (this.string4 != null) {
            var1.addProperty("xuid", this.string4);
         }
      }
   }

   @Override
   public void run() throws OnyxException {
      String var1 = this.string2;
      MicrosoftAuth.OAuthClientFlavour var2 = this.oAuthClientFlavour;
      MicrosoftAuth.MicrosoftTokens var3 = MicrosoftAuth.getMicrosoftTokensForString4(var1, var2);
      this.handleMicrosoftTokens(var3);
   }

   @Override
   public Session getSession() throws OnyxException {
      if (this.string3 == null || System.currentTimeMillis() > this.long_2 - 60000L) {
         this.run();
      }

      String var1 = this.string;
      String var2 = UUIDTypeAdapter.fromUUID(this.uUID);
      return new Session(var1, var2, this.string3, "mojang");
   }

   @Override
   public String getString3() {
      return this.string3;
   }

   public static MicrosoftAccount getMicrosoftAccountForMicrosoftTokens(MicrosoftAuth.MicrosoftTokens var0) {
      MicrosoftAccount var10000 = new MicrosoftAccount(var0.name());
      var10000.handleMicrosoftTokens(var0);
      return var10000;
   }

   @Override
   public String getString2() {
      return this.string2;
   }

   public static MicrosoftAccount getMicrosoftAccountForString2(String var0, MicrosoftAuth.OAuthClientFlavour var1) throws OnyxException {
      return getMicrosoftAccountForMicrosoftTokens(MicrosoftAuth.getMicrosoftTokensForString4(var0, var1));
   }

   public MicrosoftAuth.OAuthClientFlavour getOAuthClientFlavour() {
      return this.oAuthClientFlavour;
   }

   @Override
   protected void handleJsonObject(JsonObject var1) {
      this.string2 = getStringForJsonObject(var1, "refreshToken");
      this.oAuthClientFlavour = MicrosoftAuth.OAuthClientFlavour.getOAuthClientFlavourForString(getStringForJsonObject(var1, "flavour"));
      this.string3 = getStringForJsonObject(var1, "accessToken");
      this.long_2 = getLongForJsonObject(var1, "expiresAt", 0L);
      this.string4 = getStringForJsonObject(var1, "xuid");
   }

   @Override
   public long getLong2() {
      return this.long_2;
   }

   private void handleMicrosoftTokens(MicrosoftAuth.MicrosoftTokens var1) {
      this.string = var1.name();
      this.uUID = var1.uuid();
      this.oAuthClientFlavour = var1.flavour();
      this.string2 = var1.refreshToken();
      this.string3 = var1.accessToken();
      this.long_2 = var1.expiresAt();
      this.string4 = var1.xuid();
   }

   public String getString4() {
      return this.string2;
   }

   public MicrosoftAccount(String var1) {
      super(OfflineAccessTokenEnum.MICROSOFT, var1);
   }
}
