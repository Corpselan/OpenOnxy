package client.onyx.account;

import client.onyx.account.auth.OnyxException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.UUID;
import net.minecraft.util.Session;

public abstract class Abstract_ {
   protected String string;
   private final OfflineAccessTokenEnum offlineAccessTokenEnum;
   protected long long_;
   protected UUID uUID;

   protected static long getLongForJsonObject(JsonObject var0, String var1, long var2) {
      JsonObject var10000 = var0;
      String var4 = var1;
      JsonObject var6 = var10000;
      JsonElement var5;
      return (var5 = var6.get(var4)) != null && var5.isJsonPrimitive() && var5.getAsJsonPrimitive().isNumber() ? var5.getAsLong() : var2;
   }

   protected Abstract_(OfflineAccessTokenEnum var1, String var2) {
      this.offlineAccessTokenEnum = var1;
      this.string = var2;
      this.long_ = System.currentTimeMillis();
   }

   public String getString() {
      return this.string;
   }

   public abstract void run() throws OnyxException;

   public UUID getUUID() {
      return this.uUID;
   }

   public String getString3() {
      return null;
   }

   public String getString2() {
      return null;
   }

   protected static String getStringForJsonObject(JsonObject var0, String var1) {
      JsonElement var2;
      return (var2 = var0.get(var1)) != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isString() ? var2.getAsString() : null;
   }

   public long getLong2() {
      return 0L;
   }

   public abstract Session getSession() throws OnyxException;

   public final JsonObject getJsonObject() {
      JsonObject var2 = new JsonObject();
      var2.addProperty("type", this.offlineAccessTokenEnum.getString2());
      var2.addProperty("name", this.string);
      var2.addProperty("addedAt", (Number)this.long_);
      if (this.uUID != null) {
         var2.addProperty("uuid", this.uUID.toString());
      }

      this.handleJsonObject2(var2);
      return var2;
   }

   protected abstract void handleJsonObject2(JsonObject var1);

   protected static boolean isJsonObject(JsonObject var0, String var1, boolean var2) {
      JsonElement var3;
      return (var3 = var0.get(var1)) != null && var3.isJsonPrimitive() && var3.getAsJsonPrimitive().isBoolean() ? var3.getAsBoolean() : var2;
   }

   public long getLong() {
      return this.long_;
   }

   public static Abstract_ getAbstract_ForJsonObject(JsonObject var0) {
      OfflineAccessTokenEnum var1;
      if ((var1 = OfflineAccessTokenEnum.getOfflineAccessTokenEnumForString(getStringForJsonObject(var0, "type"))) == null) {
         return null;
      } else {
         String var4;
         if ((var4 = getStringForJsonObject(var0, "name")) != null && !var4.isBlank()) {
            Object var10000;
            switch(var1) {
            case OFFLINE:
               var10000 = new Cls(var4);
               break;
            case ACCESS_TOKEN:
               var10000 = new TokenAccount(var4);
               break;
            case MICROSOFT:
               var10000 = new MicrosoftAccount(var4);
               break;
            default:
               throw new MatchException((String)null, (Throwable)null);
            }

            Object var7;
            JsonObject var8;
            label37: {
               var7 = var10000;
               if ((var4 = getStringForJsonObject(var0, "uuid")) != null) {
                  label35: {
                     try {
                        ((Abstract_)var7).uUID = UUID.fromString(var4);
                     } catch (IllegalArgumentException var6) {
                        break label35;
                     }

                     var8 = var0;
                     break label37;
                  }
               }

               var8 = var0;
            }

            JsonElement var3;
            if ((var3 = var8.get("addedAt")) != null && var3.isJsonPrimitive() && var3.getAsJsonPrimitive().isNumber()) {
               ((Abstract_)var7).long_ = var3.getAsLong();
            }

            ((Abstract_)var7).handleJsonObject(var0);
            return (Abstract_)var7;
         } else {
            return null;
         }
      }
   }

   protected abstract void handleJsonObject(JsonObject var1);

   public OfflineAccessTokenEnum getOfflineAccessTokenEnum() {
      return this.offlineAccessTokenEnum;
   }
}
