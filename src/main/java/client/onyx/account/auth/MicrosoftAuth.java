package client.onyx.account.auth;

import client.onyx.OnyxClient;
import com.google.gson.JsonObject;
import java.util.UUID;
import org.apache.logging.log4j.Logger;

public final class MicrosoftAuth {
   private static final long LONG = 2148916238L;
   private static final int INT = 401;
   private static final String STRING = "{\"Properties\":{\"SandboxId\":\"RETAIL\",\"UserTokens\":[\"%s\"]},\"RelyingParty\":\"rp://api.minecraftservices.com/\",\"TokenType\":\"JWT\"}";
   private static final String STRING2 = "{\"Properties\":{\"AuthMethod\":\"RPS\",\"SiteName\":\"user.auth.xboxlive.com\",\"RpsTicket\":\"%s\"},\"RelyingParty\":\"http://auth.xboxlive.com\",\"TokenType\":\"JWT\"}";
   private static final String STRING3 = "https://user.auth.xboxlive.com/user/authenticate";
   private static final long LONG2 = 2148916235L;
   private static final int INT2 = 403;
   private static final String STRING4 = "https://login.microsoftonline.com/consumers/oauth2/v2.0/authorize";
   public static final String STRING5 = "c36a9fb6-4f2a-41ff-90bd-ae7cc92031eb";
   private static final long LONG3 = 2148916233L;
   private static final String STRING6 = "{\"identityToken\":\"XBL3.0 x=%s;%s\"}";
   private static final int INT3 = 500;
   private static final String STRING7 = "https://api.minecraftservices.com/minecraft/profile";
   private static final int INT4 = 429;
   private static final String STRING8 = "https://xsts.auth.xboxlive.com/xsts/authorize";
   private static final String STRING9 = "https://api.minecraftservices.com/authentication/login_with_xbox";

   private MicrosoftAuth() {
   }

   private static OnyxException getOnyxExceptionForHttpResponse2(HttpUtil.HttpResponse var0) {
      long var1;
      long var10000;
      label24: {
         try {
            var1 = HttpUtil.getLongForJsonObject(var0.getJsonObject(), "XErr", 0L);
         } catch (OnyxException var3) {
            var10000 = var1 = 0L;
            break label24;
         }

         var10000 = var1;
      }

      if (var10000 == 2148916233L) {
         return new OnyxException("This Microsoft account has no Xbox profile");
      } else if (var1 == 2148916235L) {
         return new OnyxException("Xbox Live is unavailable in this region");
      } else {
         return var1 == 2148916238L
            ? new OnyxException("Child account — must be added to a Microsoft family")
            : new OnyxException(new StringBuilder().insert(0, "Xbox Live security check failed (").append(var0.status()).append(")").toString());
      }
   }

   public static boolean isEnabled() {
      return MicrosoftAuth.OAuthClientFlavour.AZURE.isEnabled();
   }

   public static MicrosoftAuth.MicrosoftTokens getMicrosoftTokensForString2(String var0, String var1) throws OnyxException {
      handleOAuthClientFlavour(MicrosoftAuth.OAuthClientFlavour.AZURE);
      return getMicrosoftTokensForString(
         new StringBuilder()
            .insert(0, "client_id=")
            .append(HttpUtil.getStringForString(MicrosoftAuth.OAuthClientFlavour.AZURE.getString2()))
            .append("&redirect_uri=")
            .append(HttpUtil.getStringForString(var1))
            .append("&scope=")
            .append(HttpUtil.getStringForString(MicrosoftAuth.OAuthClientFlavour.AZURE.getString5()))
            .append("&grant_type=authorization_code&code=")
            .append(HttpUtil.getStringForString(var0))
            .toString(),
         MicrosoftAuth.OAuthClientFlavour.AZURE
      );
   }

   public static MicrosoftAuth.MicrosoftTokens getMicrosoftTokensForString4(String var0, MicrosoftAuth.OAuthClientFlavour var1) throws OnyxException {
      handleOAuthClientFlavour(var1);
      if (var0 != null && !var0.isBlank()) {
         String var2 = var0.replaceAll("\\s", "");
         String var3 = new StringBuilder()
            .insert(0, "client_id=")
            .append(HttpUtil.getStringForString(var1.getString2()))
            .append("&grant_type=refresh_token")
            .toString();
         if (var1.getString4() != null) {
            var3 = new StringBuilder().insert(0, var3).append("&redirect_uri=").append(HttpUtil.getStringForString(var1.getString4())).toString();
         }

         return getMicrosoftTokensForString(
            new StringBuilder()
               .insert(0, var3)
               .append("&refresh_token=")
               .append(HttpUtil.getStringForString(var2))
               .append("&scope=")
               .append(HttpUtil.getStringForString(var1.getString5()))
               .toString(),
            var1
         );
      } else {
         throw new OnyxException("No refresh token stored for this account");
      }
   }

   private static OnyxException getOnyxExceptionForHttpResponse(HttpUtil.HttpResponse var0) {
      Logger var5 = OnyxClient.LOGGER;
      Object[] var6 = new Object[2];
      Integer var8 = var0.status();
      var6[0] = var8;
      String var9 = var0.body();
      var6[1] = var9;
      var5.error("Microsoft token endpoint returned {}: {}", var6);
      if (var0.status() == 429) {
         return new OnyxException("You are rate limited, try again in a moment");
      } else if (var0.status() >= 500) {
         return new OnyxException("Microsoft services are unavailable");
      } else {
         String var12;
         try {
            JsonObject var11 = var0.getJsonObject();
            String var2 = HttpUtil.getStringForJsonObject(var11, "error_description");
            String var3 = HttpUtil.getStringForJsonObject(var11, "error");
            var12 = var2 != null ? var2 : var3;
         } catch (OnyxException var10) {
            String var4;
            return (var4 = null) == null
               ? new OnyxException(new StringBuilder().insert(0, "Microsoft rejected the login (").append(var0.status()).append(")").toString())
               : new OnyxException(var4.replaceAll("\\s+", " ").trim());
         }

         return var12 == null
            ? new OnyxException(new StringBuilder().insert(0, "Microsoft rejected the login (").append(var0.status()).append(")").toString())
            : new OnyxException(var12.replaceAll("\\s+", " ").trim());
      }
   }

   private static MicrosoftAuth.MicrosoftTokens getMicrosoftTokensForString3(String var0, String var1, MicrosoftAuth.OAuthClientFlavour var2) throws OnyxException {
      Object[] var10002 = new Object[1];
      boolean var10004 = true;
      boolean var10007 = false;
      var10002[0] = var2.getString() + var0;
      String var10001 = "{\"Properties\":{\"AuthMethod\":\"RPS\",\"SiteName\":\"user.auth.xboxlive.com\",\"RpsTicket\":\"%s\"},\"RelyingParty\":\"http://auth.xboxlive.com\",\"TokenType\":\"JWT\"}"
         .formatted(var10002);
      String[] var25 = new String[0];
      var10004 = true;
      HttpUtil.HttpResponse var9;
      if (!(var9 = HttpUtil.getHttpResponseForString5("https://user.auth.xboxlive.com/user/authenticate", var10001, var25)).isEnabled()) {
         throw new OnyxException(new StringBuilder().insert(0, "Xbox Live rejected the login (").append(var9.status()).append(")").toString());
      } else {
         JsonObject var10000 = var9.getJsonObject();
         String var13 = HttpUtil.getStringForJsonObject(var10000, "Token");
         JsonObject var4 = HttpUtil.getJsonObjectForJsonObject(var10000);
         if (var13 != null && var4 != null) {
            String var10;
            if ((var10 = HttpUtil.getStringForJsonObject(var4, "uhs")) == null) {
               throw new OnyxException("Xbox Live returned no user hash");
            } else {
               var10002 = new Object[1];
               var10004 = true;
               var10002[0] = var13;
               var10001 = "{\"Properties\":{\"SandboxId\":\"RETAIL\",\"UserTokens\":[\"%s\"]},\"RelyingParty\":\"rp://api.minecraftservices.com/\",\"TokenType\":\"JWT\"}"
                  .formatted(var10002);
               String[] var27 = new String[0];
               var10004 = true;
               if (!(var9 = HttpUtil.getHttpResponseForString5("https://xsts.auth.xboxlive.com/xsts/authorize", var10001, var27)).isEnabled()) {
                  throw getOnyxExceptionForHttpResponse2(var9);
               } else {
                  String var5;
                  JsonObject var15;
                  if ((var5 = HttpUtil.getStringForJsonObject(var15 = var9.getJsonObject(), "Token")) == null) {
                     throw new OnyxException("Xbox Live returned no security token");
                  } else {
                     JsonObject var16;
                     String var6 = (var16 = HttpUtil.getJsonObjectForJsonObject(var15)) == null ? null : HttpUtil.getStringForJsonObject(var16, "xid");
                     var10002 = new Object[2];
                     var10004 = true;
                     var10002[0] = var10;
                     var10002[1] = var5;
                     var10001 = "{\"identityToken\":\"XBL3.0 x=%s;%s\"}".formatted(var10002);
                     String[] var29 = new String[0];
                     var10004 = true;
                     if ((var9 = HttpUtil.getHttpResponseForString5("https://api.minecraftservices.com/authentication/login_with_xbox", var10001, var29))
                           .status()
                        == 403) {
                        throw new OnyxException("This build's Azure app is not approved for the Minecraft API");
                     } else if (!var9.isEnabled()) {
                        throw new OnyxException(
                           new StringBuilder().insert(0, "Minecraft services rejected the login (").append(var9.status()).append(")").toString()
                        );
                     } else {
                        String var11;
                        JsonObject var18;
                        if ((var11 = HttpUtil.getStringForJsonObject(var18 = var9.getJsonObject(), "access_token")) == null) {
                           throw new OnyxException("Minecraft services returned no access token");
                        } else {
                           long var7 = System.currentTimeMillis() + HttpUtil.getLongForJsonObject(var18, "expires_in", 86400L) * 1000L;
                           String[] var24 = new String[4];
                           boolean var10003 = true;
                           var24[0] = "Authorization";
                           var24[1] = new StringBuilder().insert(0, "Bearer ").append(var11).toString();
                           var24[2] = "Accept";
                           var24[3] = "application/json";
                           if (!(var9 = HttpUtil.getHttpResponseForString6("https://api.minecraftservices.com/minecraft/profile", var24)).isEnabled()) {
                              throw new OnyxException("This account does not own Minecraft");
                           } else {
                              var10000 = var9.getJsonObject();
                              String var20 = HttpUtil.getStringForJsonObject(var10000, "name");
                              var5 = HttpUtil.getStringForJsonObject(var10000, "id");
                              if (var20 != null && var5 != null) {
                                 return new MicrosoftAuth.MicrosoftTokens(var2, var1, var11, var7, getUUIDForString(var5), var20, var6);
                              } else {
                                 throw new OnyxException("Minecraft returned an incomplete profile");
                              }
                           }
                        }
                     }
                  }
               }
            }
         } else {
            throw new OnyxException("Xbox Live returned no token");
         }
      }
   }

   private static MicrosoftAuth.MicrosoftTokens getMicrosoftTokensForString(String var0, MicrosoftAuth.OAuthClientFlavour var1) throws OnyxException {
      HttpUtil.HttpResponse var4;
      if (!(var4 = HttpUtil.getHttpResponseForString3(var1.getString3(), var0)).isEnabled()) {
         throw getOnyxExceptionForHttpResponse(var4);
      } else {
         JsonObject var10000 = var4.getJsonObject();
         String var5 = HttpUtil.getStringForJsonObject(var10000, "access_token");
         String var3 = HttpUtil.getStringForJsonObject(var10000, "refresh_token");
         if (var5 == null) {
            throw new OnyxException("Microsoft did not return an access token");
         } else if (var3 == null) {
            throw new OnyxException("Microsoft did not return a refresh token");
         } else {
            return getMicrosoftTokensForString3(var5, var3, var1);
         }
      }
   }

   private static void handleOAuthClientFlavour(MicrosoftAuth.OAuthClientFlavour var0) throws OnyxException {
      if (!var0.isEnabled()) {
         throw new OnyxException("No Azure client id configured — set MicrosoftAuth.CLIENT_ID");
      }
   }

   public static MicrosoftAuth.UuidNameRecord getUuidNameRecordForString(String var0) throws OnyxException {
      if (var0 != null && !var0.isBlank()) {
         String[] var10001 = new String[4];
         boolean var10003 = true;
         var10001[0] = "Authorization";
         boolean var10006 = true;
         var10001[1] = "Bearer " + var0.trim();
         var10001[2] = "Accept";
         var10001[3] = "application/json";
         HttpUtil.HttpResponse var3;
         if ((var3 = HttpUtil.getHttpResponseForString6("https://api.minecraftservices.com/minecraft/profile", var10001)).status() == 401) {
            throw new OnyxException("Access token is invalid or expired");
         } else if (!var3.isEnabled()) {
            throw new OnyxException(new StringBuilder().insert(0, "Minecraft services rejected the token (").append(var3.status()).append(")").toString());
         } else {
            JsonObject var10000 = var3.getJsonObject();
            String var4 = HttpUtil.getStringForJsonObject(var10000, "name");
            String var2 = HttpUtil.getStringForJsonObject(var10000, "id");
            if (var4 != null && var2 != null) {
               return new MicrosoftAuth.UuidNameRecord(getUUIDForString(var2), var4);
            } else {
               throw new OnyxException("Minecraft returned an incomplete profile");
            }
         }
      } else {
         throw new OnyxException("No access token provided");
      }
   }

   public static UUID getUUIDForString(String var0) throws OnyxException {
      String var2;
      if ((var2 = var0.replace("-", "").trim()).length() != 32) {
         throw new OnyxException("Malformed profile id");
      } else {
         try {
            return UUID.fromString(
               new StringBuilder()
                  .insert(0, var2.substring(0, 8))
                  .append("-")
                  .append(var2.substring(8, 12))
                  .append("-")
                  .append(var2.substring(12, 16))
                  .append("-")
                  .append(var2.substring(16, 20))
                  .append("-")
                  .append(var2.substring(20))
                  .toString()
            );
         } catch (IllegalArgumentException var3) {
            throw new OnyxException("Malformed profile id", var3);
         }
      }
   }

   public static String getStringForString(String var0) {
      return new StringBuilder()
         .insert(0, "https://login.microsoftonline.com/consumers/oauth2/v2.0/authorize?client_id=")
         .append(HttpUtil.getStringForString(MicrosoftAuth.OAuthClientFlavour.AZURE.getString2()))
         .append("&redirect_uri=")
         .append(HttpUtil.getStringForString(var0))
         .append("&response_type=code&display=touch&scope=")
         .append(HttpUtil.getStringForString(MicrosoftAuth.OAuthClientFlavour.AZURE.getString5()))
         .append("&prompt=select_account")
         .toString();
   }

   public record MicrosoftTokens(
      MicrosoftAuth.OAuthClientFlavour flavour, String refreshToken, String accessToken, long expiresAt, UUID uuid, String name, String xuid
   ) {
   }

   public static enum OAuthClientFlavour {
      LEGACY(
         "legacy",
         "00000000402b5328",
         "service::user.auth.xboxlive.com::MBI_SSL",
         "t=",
         "https://login.live.com/oauth20_desktop.srf",
         "https://login.live.com/oauth20_token.srf"
      ),
      AZURE(
         "azure",
         "c36a9fb6-4f2a-41ff-90bd-ae7cc92031eb",
         "XboxLive.SignIn XboxLive.offline_access",
         "d=",
         null,
         "https://login.microsoftonline.com/consumers/oauth2/v2.0/token"
      );

      private final String string;
      private final String string2;
      private final String string3;
      private final String string4;
      private final String string5;
      private final String string6;

      public String getString5() {
         return this.string2;
      }

      public boolean isEnabled() {
         return !this.string5.isBlank();
      }

      public String getString2() {
         return this.string5;
      }

      private OAuthClientFlavour(String var3, String var4, String var5, String var6, String var7, String var8) {
         this.string3 = var3;
         this.string5 = var4;
         this.string2 = var5;
         this.string4 = var6;
         this.string6 = var7;
         this.string = var8;
      }

      public String getString6() {
         return this.string3;
      }

      public static MicrosoftAuth.OAuthClientFlavour getOAuthClientFlavourForString(String var0) {
         MicrosoftAuth.OAuthClientFlavour[] var1;
         int var2 = (var1 = values()).length;

         int var5;
         for (int var10000 = var5 = 0; var10000 < var2; var10000 = ++var5) {
            MicrosoftAuth.OAuthClientFlavour var4;
            if ((var4 = var1[var5]).string3.equalsIgnoreCase(var0)) {
               return var4;
            }
         }

         return LEGACY;
      }

      public String getString() {
         return this.string4;
      }

      public String getString4() {
         return this.string6;
      }


      public String getString3() {
         return this.string;
      }
   }

   public record UuidNameRecord(UUID uuid, String name) {
   }
}
