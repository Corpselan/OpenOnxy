package client.onyx.account;

import client.onyx.account.auth.HttpUtil;
import client.onyx.account.auth.MicrosoftAuth;
import client.onyx.account.auth.OnyxException;
import com.google.gson.JsonObject;
import com.mojang.util.UUIDTypeAdapter;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import net.minecraft.util.Session;

public class Cls extends Abstract_ {
   private static final String STRING = "https://api.mojang.com/users/profiles/minecraft/";
   private boolean bool;
   private static final String STRING2 = "-";

   public void handleBool(boolean var1) {
      this.bool = var1;
   }

   @Override
   public Session getSession() throws OnyxException {
      if (this.uUID == null) {
         this.run();
      }

      String var1 = this.string;
      String var2 = UUIDTypeAdapter.fromUUID(this.uUID);
      return new Session(var1, var2, "-", "legacy");
   }

   @Override
   protected void handleJsonObject(JsonObject var1) {
      this.bool = isJsonObject(var1, "premiumUuid", false);
   }

   @Override
   public void run() throws OnyxException {
      if (!this.bool) {
         UUID var5 = getUUIDForString(this.string);
         this.uUID = var5;
      } else {
         String var10000 = new StringBuilder()
            .insert(0, "https://api.mojang.com/users/profiles/minecraft/")
            .append(HttpUtil.getStringForString(this.string))
            .toString();
         String[] var10001 = new String[0];
         boolean var10003 = true;
         HttpUtil.HttpResponse var3;
         if (!(var3 = HttpUtil.getHttpResponseForString6(var10000, var10001)).isEnabled()) {
            UUID var7 = getUUIDForString(this.string);
            this.uUID = var7;
         } else {
            JsonObject var11 = var3.getJsonObject();
            String var10 = HttpUtil.getStringForJsonObject(var11, "id");
            String var2 = HttpUtil.getStringForJsonObject(var11, "name");
            if (var10 == null) {
               UUID var9 = getUUIDForString(this.string);
               this.uUID = var9;
            } else {
               if (var2 != null) {
                  this.string = var2;
               }

               this.uUID = MicrosoftAuth.getUUIDForString(var10);
            }
         }
      }
   }

   public boolean isEnabled() {
      return this.bool;
   }

   public static UUID getUUIDForString(String var0) {
      return UUID.nameUUIDFromBytes(new StringBuilder().insert(0, "OfflinePlayer:").append(var0).toString().getBytes(StandardCharsets.UTF_8));
   }

   public Cls(String var1) {
      super(OfflineAccessTokenEnum.OFFLINE, var1);
      this.uUID = getUUIDForString(var1);
   }

   @Override
   protected void handleJsonObject2(JsonObject var1) {
      var1.addProperty("premiumUuid", this.bool);
   }
}
