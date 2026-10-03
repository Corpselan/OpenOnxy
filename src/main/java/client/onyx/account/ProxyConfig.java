package client.onyx.account;

import client.onyx.OnyxClient;
import client.onyx.proxy.LocalProxyRelay;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.net.Proxy.Type;
import org.apache.logging.log4j.Logger;

public final class ProxyConfig {
   private final Object object;
   private volatile ProxyConfig.ProtocolEnabledRecord protocolEnabledRecord = ProxyConfig.ProtocolEnabledRecord.getProtocolEnabledRecord();
   private LocalProxyRelay localProxyRelay;
   private volatile String string;

   public ProxyConfig() {
      Object var1 = new Object();
      this.object = var1;
   }

   private static String getStringForString(String var0) {
      return var0 == null ? "" : var0.trim();
   }

   private Proxy getProxy4() {
      try {
         return this.getProxy2();
      } catch (RuntimeException var3) {
         this.string = var3.getMessage();
         OnyxClient.LOGGER.warn("Falling back to a direct connection", var3);
         return Proxy.NO_PROXY;
      }
   }

   public String getString4() {
      return this.protocolEnabledRecord.password();
   }

   public String getString() {
      return this.protocolEnabledRecord.username();
   }

   public Proxy getProxy() {
      return this.getProxy4();
   }

   public Proxy getProxy3() {
      return this.protocolEnabledRecord.useForAuth() ? this.getProxy4() : Proxy.NO_PROXY;
   }

   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void handleProxyProtocol(ProxyConfig.ProxyProtocol var1, boolean var2, boolean var3, String var4, String var5, String var6) {
      var4 = getStringForString(var4);
      var5 = getStringForString(var5);
      String var7 = var6 == null ? "" : var6;
      ProxyConfig.ProtocolEnabledRecord var10002;
      if (var2) {
         var10002 = new ProxyConfig.ProtocolEnabledRecord(var1, true, var3, var4, var5, var7, getHostPortRecordForString(var4));
      } else {
         var10002 = new ProxyConfig.ProtocolEnabledRecord(var1, false, var3, var4, var5, var7, null);
      }

      ProxyConfig.ProtocolEnabledRecord var12 = var10002;
      Object var9 = this.object;
      Object var11 = var9;
      synchronized (var9) {
         Object var10000;
         label30: {
            this.protocolEnabledRecord = var12;
            this.string = null;
            if (this.localProxyRelay != null) {
               if (var12.enabled()) {
                  this.localProxyRelay.handleProxyProtocol(var12.protocol(), var12.getInetSocketAddress(), var12.username(), var12.password());
                  var10000 = var11;
                  break label30;
               }

               this.run();
            }

            var10000 = var11;
         }

         // $VF: monitorexit
      }
   }

   private static ProxyConfig.HostPortRecord getHostPortRecordForString(String var0) {
      int var3;
      if ((var3 = var0.lastIndexOf(58)) > 0 && var3 != var0.length() - 1) {
         String var2;
         if ((var2 = var0.substring(0, var3).trim()).startsWith("[") && var2.endsWith("]")) {
            int var5 = var2.length() - 1;
            var2 = var2.substring(1, var5);
         }

         if (var2.isBlank()) {
            throw new IllegalArgumentException("Enter a proxy host");
         } else {
            try {
               var3 = Integer.parseInt(var0.substring(var3 + 1));
            } catch (NumberFormatException var8) {
               throw new IllegalArgumentException("Enter a valid proxy port");
            }

            if (var3 >= 1 && var3 <= 65535) {
               try {
                  return new ProxyConfig.HostPortRecord(var2, var3, new InetSocketAddress(InetAddress.getByName(var2), var3));
               } catch (UnknownHostException var7) {
                  throw new IllegalArgumentException("Could not resolve the proxy host");
               }
            } else {
               throw new IllegalArgumentException("Enter a valid proxy port");
            }
         }
      } else {
         throw new IllegalArgumentException("Enter proxy address as host:port");
      }
   }

   public boolean isEnabled2() {
      return this.protocolEnabledRecord.enabled();
   }

   public Proxy getProxy2() {
      ProxyConfig.ProtocolEnabledRecord var2 = this.protocolEnabledRecord;
      if (!this.protocolEnabledRecord.enabled()) {
         return Proxy.NO_PROXY;
      } else {
         this.string = null;

         try {
            return new Proxy(Type.HTTP, this.getLocalProxyRelay(var2).getInetSocketAddress());
         } catch (IOException var3) {
            throw new IllegalStateException("Could not start the local proxy bridge", var3);
         }
      }
   }

   public ProxyConfig.ProxyProtocol getProxyProtocol() {
      return this.protocolEnabledRecord.protocol();
   }

   public String getString3() {
      return this.string;
   }

   public InetSocketAddress getInetSocketAddress() {
      return this.protocolEnabledRecord.getInetSocketAddress();
   }

   public void handleJsonObject(JsonObject var1) {
      ProxyConfig.ProxyProtocol var2 = ProxyConfig.ProxyProtocol.getProxyProtocolForString(getStringForJsonElement(var1.get("protocol")));
      boolean var3 = isJsonElement(var1.get("enabled"));

      try {
         this.handleProxyProtocol(
            var2,
            var3,
            isJsonElement(var1.get("auth")),
            getStringForJsonElement(var1.get("address")),
            getStringForJsonElement(var1.get("username")),
            getStringForJsonElement(var1.get("password"))
         );
      } catch (IllegalArgumentException var4) {
         this.protocolEnabledRecord = ProxyConfig.ProtocolEnabledRecord.getProtocolEnabledRecord();
      }
   }

   private static boolean isJsonElement(JsonElement var0) {
      return var0 != null && var0.isJsonPrimitive() && var0.getAsJsonPrimitive().isBoolean() && var0.getAsBoolean();
   }

   public JsonObject getJsonObject() {
      ProxyConfig.ProtocolEnabledRecord var3 = this.protocolEnabledRecord;
      JsonObject var2 = new JsonObject();
      var2.addProperty("protocol", var3.protocol().string);
      var2.addProperty("enabled", var3.enabled());
      var2.addProperty("auth", var3.useForAuth());
      var2.addProperty("address", var3.address());
      var2.addProperty("username", var3.username());
      var2.addProperty("password", var3.password());
      return var2;
   }

   public String getString2() {
      return this.protocolEnabledRecord.address();
   }

   public boolean isEnabled() {
      return this.protocolEnabledRecord.useForAuth();
   }

   public static String decrypt(String var0) {
      int var10000 = 96 ^ 1 << 1;
      int var10001 = 96 ^ 1 << 1;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 88;
      var10000 = var10002;

      for (int var2 = var10000; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var10002 = var5--;
         var1[var10002] = (char)(var10.charAt(var10002) ^ var4);
      }

      return new String(var1);
   }

   private static String getStringForJsonElement(JsonElement var0) {
      return var0 != null && var0.isJsonPrimitive() && var0.getAsJsonPrimitive().isString() ? var0.getAsString() : "";
   }

   private void run() {
      if (this.localProxyRelay != null) {
         this.localProxyRelay.close();
      }

      this.localProxyRelay = null;
   }

   private LocalProxyRelay getLocalProxyRelay(ProxyConfig.ProtocolEnabledRecord var1) throws IOException {
      Object var4 = this.object;
      synchronized (var4) {
         if (this.localProxyRelay != null) {
            this.localProxyRelay.handleProxyProtocol(var1.protocol(), var1.getInetSocketAddress(), var1.username(), var1.password());
            return this.localProxyRelay;
         } else {
            this.localProxyRelay = new LocalProxyRelay(var1.protocol(), var1.getInetSocketAddress(), var1.username(), var1.password(), var1x -> {
               this.string = var1x;
               Logger var2 = OnyxClient.LOGGER;
               Object[] var3 = new Object[]{var1x};
               var2.warn("Proxy tunnel failed: {}", var3);
            });
            Logger var10000 = OnyxClient.LOGGER;
            Object[] var10002 = new Object[2];
            boolean var10004 = true;
            var10002[0] = var1.protocol().getString();
            var10002[1] = this.localProxyRelay.getInetSocketAddress();
            var10000.info("Started local proxy bridge for {} at {}", var10002);
            return this.localProxyRelay;
         }
      }
   }

   private record HostPortRecord(String host, int port, InetSocketAddress socket) {
   }

   private record ProtocolEnabledRecord(
      ProxyConfig.ProxyProtocol protocol,
      boolean enabled,
      boolean useForAuth,
      String address,
      String username,
      String password,
      ProxyConfig.HostPortRecord endpoint
   ) {
      static ProxyConfig.ProtocolEnabledRecord getProtocolEnabledRecord() {
         return new ProxyConfig.ProtocolEnabledRecord(ProxyConfig.ProxyProtocol.SOCKS5, false, false, "", "", "", null);
      }

      InetSocketAddress getInetSocketAddress() {
         return this.endpoint == null ? null : this.endpoint.socket();
      }

      private String getString() {
         return this.endpoint == null ? "" : this.endpoint.host();
      }

      private int getInt() {
         return this.endpoint == null ? 0 : this.endpoint.port();
      }
   }

   public static enum ProxyProtocol {
      // 顺序按原 $VALUES 数组（即 ordinal）
      SOCKS5("socks5", "SOCKS5"),
      HTTP("http", "HTTP/HTTPS");
      final String string;
      private final String string2;


      private ProxyProtocol(String var3, String var4) {
         this.string = var3;
         this.string2 = var4;
      }

      public String getString() {
         return this.string2;
      }

      public static ProxyConfig.ProxyProtocol getProxyProtocolForString(String var0) {
         ProxyConfig.ProxyProtocol[] var1;
         int var2 = (var1 = values()).length;

         int var5;
         for (int var10000 = var5 = 0; var10000 < var2; var10000 = ++var5) {
            ProxyConfig.ProxyProtocol var4;
            if ((var4 = var1[var5]).string.equalsIgnoreCase(var0)) {
               return var4;
            }
         }

         return SOCKS5;
      }
   }
}
