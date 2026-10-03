package client.onyx.skin;

import client.onyx.account.auth.HttpUtil;
import client.onyx.account.auth.OnyxException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import javax.imageio.ImageIO;

public final class SkinLookup {
   private static final int INT = 15000;
   private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor(var0 -> {
      Thread var10000 = new Thread(var0, "onyx-skin-lookup");
      var10000.setDaemon(true);
      return var10000;
   });

   private SkinLookup() {
   }

   private static String getStringForString(String var0) throws OnyxException {
      String var10000 = new StringBuilder().insert(0, "https://api.mojang.com/users/profiles/minecraft/").append(HttpUtil.getStringForString(var0)).toString();
      String[] var10001 = new String[0];
      boolean var10003 = true;
      HttpUtil.HttpResponse var2;
      if ((var2 = HttpUtil.getHttpResponseForString6(var10000, var10001)).status() == 204 || var2.status() == 404) {
         throw new OnyxException(new StringBuilder().insert(0, "No account named ").append(var0).toString());
      } else if (!var2.isEnabled()) {
         throw new OnyxException(new StringBuilder().insert(0, "Mojang lookup failed (").append(var2.status()).append(")").toString());
      } else {
         String var3;
         if ((var3 = HttpUtil.getStringForJsonObject(var2.getJsonObject(), "id")) != null && var3.length() == 32) {
            return var3;
         } else {
            throw new OnyxException(new StringBuilder().insert(0, "Malformed profile for ").append(var0).toString());
         }
      }
   }

   private static JsonObject getJsonObjectForString(String var0) throws OnyxException {
      String var10000 = new StringBuilder().insert(0, "https://sessionserver.mojang.com/session/minecraft/profile/").append(var0).toString();
      String[] var10001 = new String[0];
      boolean var10003 = true;
      HttpUtil.HttpResponse var1;
      if (!(var1 = HttpUtil.getHttpResponseForString6(var10000, var10001)).isEnabled()) {
         throw new OnyxException(new StringBuilder().insert(0, "Profile fetch failed (").append(var1.status()).append(")").toString());
      } else {
         JsonElement var7;
         if ((var7 = var1.getJsonObject().get("properties")) != null && var7.isJsonArray()) {
            Iterator var8 = var7.getAsJsonArray().iterator();

            label47:
            while (true) {
               Iterator var12 = var8;

               while (var12.hasNext()) {
                  JsonElement var5;
                  if (!(var5 = (JsonElement)var8.next()).isJsonObject()) {
                     var12 = var8;
                  } else {
                     JsonObject var9 = var5.getAsJsonObject();
                     if ("textures".equals(HttpUtil.getStringForJsonObject(var9, "name"))) {
                        String var10;
                        if ((var10 = HttpUtil.getStringForJsonObject(var9, "value")) == null) {
                           throw new OnyxException("Profile has no textures");
                        }

                        try {
                           String var11 = new String(Base64.getDecoder().decode(var10), StandardCharsets.UTF_8);
                           JsonElement var4;
                           JsonElement var3 = (var4 = new JsonParser().parse(var11)).isJsonObject() ? var4.getAsJsonObject().get("textures") : null;
                           if (var3 != null && var3.isJsonObject()) {
                              return var3.getAsJsonObject();
                           }
                           continue label47;
                        } catch (RuntimeException var6) {
                           throw new OnyxException("Malformed texture property", var6);
                        }
                     }

                     var12 = var8;
                  }
               }

               throw new OnyxException("Profile has no textures");
            }
         } else {
            throw new OnyxException("Profile has no textures");
         }
      }
   }

   public static void handleString(String var0, Consumer<SkinLookup.ImageModelTypeRecord> var1, Consumer<String> var2) {
      EXECUTOR_SERVICE.submit(() -> {
         try {
            var1.accept(getImageModelTypeRecordForString(var0));
         } catch (OnyxException var3) {
            var2.accept(var3.getMessage());
         }
      });
   }

   private static SkinLookup.ImageModelTypeRecord getImageModelTypeRecordForString(String var0) throws OnyxException {
      JsonElement var3;
      if ((var3 = getJsonObjectForString(getStringForString(var0)).get("SKIN")) != null && var3.isJsonObject()) {
         String var2;
         if ((var2 = HttpUtil.getStringForJsonObject(var3.getAsJsonObject(), "url")) == null) {
            throw new OnyxException(new StringBuilder().insert(0, var0).append(" has no custom skin").toString());
         } else {
            return new SkinLookup.ImageModelTypeRecord(getBufferedImageForString(var2), getStringForJsonObject(var3.getAsJsonObject()));
         }
      } else {
         throw new OnyxException(new StringBuilder().insert(0, var0).append(" has no custom skin").toString());
      }
   }

   private static BufferedImage getBufferedImageForString(String var0) throws OnyxException {
      HttpURLConnection var1 = null;

      BufferedImage var4;
      try {
         var1 = (HttpURLConnection)new URL(var0).openConnection();
         var1.setConnectTimeout(15000);
         var1.setReadTimeout(15000);
         var1.setRequestProperty("User-Agent", "onyx");
         InputStream var6 = var1.getInputStream();

         try {
            BufferedImage var3;
            if ((var3 = ImageIO.read(var6)) == null) {
               throw new OnyxException("Skin download was not an image");
            }

            var4 = var3;
         } catch (Throwable var12) {
            if (var6 != null) {
               try {
                  var6.close();
               } catch (Throwable var11) {
                  var12.addSuppressed(var11);
                  throw var12;
               }

               throw var12;
            }

            throw var12;
         }

         if (var6 != null) {
            var6.close();
         }
      } catch (IOException var13) {
         throw new OnyxException("Couldn't download the skin", var13);
      } finally {
         if (var1 != null) {
            var1.disconnect();
         }
      }

      return var4;
   }

   private static String getStringForJsonObject(JsonObject var0) {
      JsonElement var2;
      if ((var2 = var0.get("metadata")) != null && var2.isJsonObject()) {
         String var3 = HttpUtil.getStringForJsonObject(var2.getAsJsonObject(), "model");
         if ("slim".equals(var3)) {
            return "slim";
         }
      }

      return "default";
   }

   public record ImageModelTypeRecord(BufferedImage image, String modelType) {
   }
}
