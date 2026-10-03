package client.onyx.account.auth;

import client.onyx.OnyxClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.net.Proxy.Type;
import java.nio.charset.StandardCharsets;

public final class HttpUtil {
   private static final int INT = 20000;
   private static final String STRING = "okhttp/4.12.0";

   public static HttpUtil.HttpResponse getHttpResponseForString(String var0, int var1) throws OnyxException {
      Proxy var3 = OnyxClient.accountManager.getProxyConfig().getProxy2();
      String[] var4 = new String[0];
      return getHttpResponseForString4(var0, "GET", (String)null, var1, var3, var4);
   }

   public static String getStringForString(String var0) {
      return URLEncoder.encode(var0, StandardCharsets.UTF_8);
   }

   public static HttpUtil.HttpResponse getHttpResponseForString6(String var0, String... var1) throws OnyxException {
      return getHttpResponseForString2(var0, 20000, var1);
   }

   // 由 Fernflower 展开的 try-with-resources / finally 按原逻辑整理（行为不变）
   // 由 Fernflower 展开的 try-with-resources / finally 按原逻辑整理（行为不变）
   private static HttpUtil.HttpResponse getHttpResponseForString4(String var0, String var1, String var2, int var3, Proxy var4, String... var5) throws OnyxException {
      HttpURLConnection var6;
      try {
         var6 = (HttpURLConnection)(new URL(var0)).openConnection(var4);
      } catch (ClassCastException | IOException var17) {
         throw new OnyxException("Invalid request URL", var17);
      }

      try {
         var6.setConnectTimeout(var3);
         var6.setReadTimeout(var3);
         var6.setInstanceFollowRedirects(false);
         var6.setRequestMethod(var1);
         var6.setRequestProperty("User-Agent", "okhttp/4.12.0");

         // 额外请求头：按 (名, 值) 成对传入
         for (int i = 0; i + 1 < var5.length; i += 2) {
            var6.setRequestProperty(var5[i], var5[i + 1]);
         }

         if (var2 != null) {
            byte[] body = var2.getBytes(StandardCharsets.UTF_8);
            var6.setDoOutput(true);
            var6.setFixedLengthStreamingMode(body.length);
            try (OutputStream out = var6.getOutputStream()) {
               out.write(body);
            }
         }

         int status = var6.getResponseCode();
         InputStream in = status >= 400 ? var6.getErrorStream() : var6.getInputStream();
         String text = "";
         if (in != null) {
            try (InputStream stream = in) {
               text = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            }
         }

         return new HttpUtil.HttpResponse(status, text);
      } catch (IOException var22) {
         String proxyHint = var4.type() == Type.DIRECT ? null : OnyxClient.accountManager.getProxyConfig().getString3();
         String message = proxyHint != null && !proxyHint.isBlank() ? proxyHint : var22.getMessage();
         throw new OnyxException(new StringBuilder().insert(0, "Network error: ").append(message).toString(), var22);
      } finally {
         var6.disconnect();
      }
   }

   public static String getStringForJsonObject(JsonObject var0, String var1) {
      JsonElement var2;
      return (var2 = var0.get(var1)) != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isString() ? var2.getAsString() : null;
   }

   public static HttpUtil.HttpResponse getHttpResponseForString3(String var0, String var1) throws OnyxException {
      Proxy var2 = getProxy();
      String[] var3 = new String[]{"Content-Type", "application/x-www-form-urlencoded"};
      return getHttpResponseForString4(var0, "POST", var1, 20000, var2, var3);
   }

   public static JsonObject getJsonObjectForJsonObject(JsonObject var0) {
      JsonElement var2;
      if ((var2 = var0.get("DisplayClaims")) != null && var2.isJsonObject()) {
         if ((var2 = var2.getAsJsonObject().get("xui")) != null && var2.isJsonArray()) {
            JsonArray var3;
            return (var3 = var2.getAsJsonArray()).size() != 0 && var3.get(0).isJsonObject() ? var3.get(0).getAsJsonObject() : null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public static HttpUtil.HttpResponse getHttpResponseForString5(String var0, String var1, String... var2) throws OnyxException {
      String[] var10000 = new String[var2.length + 4];
      boolean var10002 = true;
      String[] var4 = var10000;
      var4[0] = "Content-Type";
      var4[1] = "application/json";
      var4[2] = "Accept";
      var4[3] = "application/json";
      System.arraycopy(var2, 0, var4, 4, var2.length);
      return getHttpResponseForString4(var0, "POST", var1, 20000, getProxy(), var4);
   }

   public static HttpUtil.HttpResponse getHttpResponseForString2(String var0, int var1, String... var2) throws OnyxException {
      return getHttpResponseForString4(var0, "GET", (String)null, var1, getProxy(), var2);
   }

   private HttpUtil() {
   }

   private static Proxy getProxy() {
      return OnyxClient.accountManager.getProxy2();
   }

   public static long getLongForJsonObject(JsonObject var0, String var1, long var2) {
      JsonObject var10000 = var0;
      String var4 = var1;
      JsonObject var6 = var10000;
      JsonElement var5;
      return (var5 = var6.get(var4)) != null && var5.isJsonPrimitive() && var5.getAsJsonPrimitive().isNumber() ? var5.getAsLong() : var2;
   }

   public static record HttpResponse(int status, String body) {
      public JsonObject getJsonObject() throws OnyxException {
         try {
            JsonElement var2;
            if ((var2 = (new JsonParser()).parse(this.body)) != null && var2.isJsonObject()) {
               return var2.getAsJsonObject();
            } else {
               throw new OnyxException("Malformed response from the server");
            }
         } catch (RuntimeException var3) {
            throw new OnyxException("Malformed response from the server", var3);
         }
      }


      public int status() {
         return this.status;
      }

      public String body() {
         return this.body;
      }

      public boolean isEnabled() {
         return this.status >= 200 && this.status < 300;
      }
   }
}
