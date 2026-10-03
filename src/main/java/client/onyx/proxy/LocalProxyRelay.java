package client.onyx.proxy;

import client.onyx.account.ProxyConfig;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public final class LocalProxyRelay implements Closeable {
   private volatile LocalProxyRelay.ProtocolUpstreamRecord protocolUpstreamRecord;
   private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
   private volatile boolean bool;
   private final Set<Socket> set = ConcurrentHashMap.newKeySet();
   private static final int INT = 32768;
   private final Consumer<String> consumer;
   private final ServerSocket serverSocket;
   private static final int INT2 = 10000;

   private static void handleSocket3(Socket var0, Exception var1) {
      try {
         byte[] var5 = getStringForException(var1).getBytes(StandardCharsets.UTF_8);
         String var2 = (new StringBuilder()).insert(0, "HTTP/1.1 502 Bad Gateway\r\nContent-Type: text/plain; charset=utf-8\r\nContent-Length: ").append(var5.length).append("\r\nConnection: close\r\n\r\n").toString();
         OutputStream var3 = var0.getOutputStream();
         var3.write(var2.getBytes(StandardCharsets.US_ASCII));
         var3.write(var5);
         var3.flush();
      } catch (IOException var4) {
      }
   }

   private static void handleSocket4(Socket var0, Socket var1, boolean var2) {
      try {
         var0.getInputStream().transferTo(var1.getOutputStream());
         var1.getOutputStream().flush();
         if (var2 && !var1.isOutputShutdown()) {
            var1.shutdownOutput();
            return;
         }
      } catch (IOException var3) {
      }

   }

   private static LocalProxyRelay.HostPortRecord getHostPortRecordForInputStream(InputStream var0) throws IOException {
      int var2;
      String var3;
      String[] var4;
      if ((var4 = ((var2 = (var3 = getStringForInputStream(var0)).indexOf("\r\n")) < 0 ? var3 : var3.substring(0, var2)).split("\\s+", 3)).length >= 3 && var4[0].equalsIgnoreCase("CONNECT")) {
         return LocalProxyRelay.HostPortRecord.getHostPortRecordForString(var4[1]);
      } else {
         throw new IOException("Proxy bridge only supports HTTPS CONNECT requests");
      }
   }

   private static void handleOutputStream(OutputStream var0, int var1) throws IOException {
      var0.write(var1 >>> 8 & 255);
      var0.write(var1 & 255);
   }

   public LocalProxyRelay(ProxyConfig.ProxyProtocol var1, InetSocketAddress var2, String var3, String var4, Consumer<String> var5) throws IOException {
      this.consumer = var5;
      this.handleProxyProtocol(var1, var2, var3, var4);
      this.serverSocket = new ServerSocket();
      this.serverSocket.bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 0), 32);
      this.executorService.execute(() -> {
         label30:
         while(true) {
            for(LocalProxyRelay var10000 = this; !var10000.bool; var10000 = this) {
               try {
                  Socket client = this.serverSocket.accept();
                  this.set.add(client);
                  this.executorService.execute(() -> {
                     this.handleSocket(client);
                  });
               } catch (SocketException se) {
                  if (this.bool) {
                     continue label30;
                  }

                  throw new IllegalStateException("Proxy bridge stopped unexpectedly", se);
               } catch (IOException ioe) {
                  if (this.bool) {
                     continue label30;
                  }

                  throw new IllegalStateException("Proxy bridge failed to accept a connection", ioe);
               }
            }

            return;
         }
      });
   }

   private static String getStringForInputStream(InputStream var0) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      int var2 = 0;

      do {
         if (var1.size() >= 32768) {
            throw new IOException("Proxy request headers are too large");
         }

         int var4;
         if ((var4 = var0.read()) < 0) {
            throw new IOException("Proxy connection closed while reading headers");
         }

         var1.write(var4);
         int var10000;
         switch(var2) {
         case 0:

            var10000 = var4 == 13 ? 1 : 0;
            break;
         case 1:
            var10000 = var4 == 10 ? 2 : (var4 == 13 ? 1 : 0);
            break;
         case 2:
            var10000 = var4 == 13 ? 3 : 0;
            break;
         case 3:
            var10000 = var4 == 10 ? 4 : 0;
            break;
         default:
            var10000 = var2;
         }

         var2 = var10000;
      } while(var2 != 4);

      return var1.toString(StandardCharsets.US_ASCII);
   }

   public void close() {
      this.bool = true;
      handleCloseable(this.serverSocket);

      Iterator var2;
      for(Iterator var10000 = var2 = this.set.iterator(); var10000.hasNext(); var10000 = var2) {
         handleCloseable((Socket)var2.next());
      }

      this.set.clear();
      this.executorService.shutdownNow();
   }

   private static String getStringForInt(int var0) {
      switch(var0) {
      case 1:

         return "general failure";
      case 2:
         return "connection not allowed by ruleset";
      case 3:
         return "network unreachable";
      case 4:
         return "host unreachable";
      case 5:
         return "connection refused";
      case 6:
         return "TTL expired";
      case 7:
         return "command not supported";
      case 8:
         return "address type not supported";
      default:
         return (new StringBuilder()).insert(0, "status ").append(var0).toString();
      }
   }

   private Socket getSocket(LocalProxyRelay.HostPortRecord var1) throws IOException {
      LocalProxyRelay.ProtocolUpstreamRecord var2 = this.protocolUpstreamRecord;
      Socket var4 = new Socket();
      this.set.add(var4);

      try {
         var4.setTcpNoDelay(true);
         var4.connect(var2.upstream(), 10000);
         var4.setSoTimeout(10000);
         if (var2.protocol() == ProxyConfig.ProxyProtocol.SOCKS5) {
            this.handleSocket2(var4, var1, var2);
            return var4;
         } else {
            handleSocket5(var4, var1, var2);
            return var4;
         }
      } catch (RuntimeException | IOException var5) {
         this.set.remove(var4);
         handleCloseable(var4);
         throw var5;
      }
   }

   private static void handleCloseable(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var1) {
         }
      }
   }

   public void handleProxyProtocol(ProxyConfig.ProxyProtocol var1, InetSocketAddress var2, String var3, String var4) {
      String var10005;
      String var10006;
      if (var3 == null) {
         var10005 = "";
         var10006 = var4;
      } else {
         var10005 = var3;
         var10006 = var4;
      }

      LocalProxyRelay.ProtocolUpstreamRecord var10001 = new LocalProxyRelay.ProtocolUpstreamRecord(var1, var2, var10005, var10006 == null ? "" : var4);
      this.protocolUpstreamRecord = var10001;
   }

   private static int getIntForInputStream(InputStream var0) throws IOException {
      int var2;
      if ((var2 = var0.read()) < 0) {
         throw new IOException("Proxy connection closed unexpectedly");
      } else {
         return var2;
      }
   }

   private static byte[] getByteArrayForInputStream(InputStream var0, int var1) throws IOException {
      byte[] var3;
      if ((var3 = var0.readNBytes(var1)).length != var1) {
         throw new IOException("Proxy connection closed unexpectedly");
      } else {
         return var3;
      }
   }

   private static void handleInputStream(InputStream var0, int var1) throws IOException {
      int var10000;
      label17:
      switch(var1) {
      case 1:
         var10000 = 4;

         while(true) {
            if (true) {
               break label17;
            }
         }
      case 2:
      default:
         throw new IOException("SOCKS5 proxy returned an invalid address type");
      case 3:
         var10000 = getIntForInputStream(var0);
         break;
      case 4:
         var10000 = 16;
      }

      var1 = var10000;
      getByteArrayForInputStream(var0, var1);
   }

   private static void handleInputStream2(InputStream var0, OutputStream var1, LocalProxyRelay.ProtocolUpstreamRecord var2) throws IOException {
      LocalProxyRelay.ProtocolUpstreamRecord var10000 = var2;
      byte[] var4 = var2.username().getBytes(StandardCharsets.UTF_8);
      byte[] var3 = var10000.password().getBytes(StandardCharsets.UTF_8);
      if (var4.length != 0 && var4.length <= 255 && var3.length <= 255) {
         var1.write(1);
         var1.write(var4.length);
         var1.write(var4);
         var1.write(var3.length);
         var1.write(var3);
         var1.flush();
         if (getIntForInputStream(var0) != 1 || getIntForInputStream(var0) != 0) {
            throw new IOException("SOCKS5 proxy rejected the username or password");
         }
      } else {
         throw new IOException("SOCKS5 credentials must be between 1 and 255 bytes");
      }
   }

   private static void handleSocket5(Socket var0, LocalProxyRelay.HostPortRecord var1, LocalProxyRelay.ProtocolUpstreamRecord var2) throws IOException {
      String var5 = var1.getString();
      StringBuilder var6 = (new StringBuilder()).insert(0, "CONNECT ").append(var5).append(" HTTP/1.1\r\n").append("Host: ").append(var5).append("\r\n").append("Proxy-Connection: keep-alive\r\n");
      if (!var2.username().isBlank()) {
         String var3 = (new StringBuilder()).insert(0, var2.username()).append(":").append(var2.password()).toString();
         var6.append("Proxy-Authorization: Basic ").append(Base64.getEncoder().encodeToString(var3.getBytes(StandardCharsets.UTF_8))).append("\r\n");
      }
         int var9;

      var6.append("\r\n");
      OutputStream var10002 = var0.getOutputStream();
      var10002.write(var6.toString().getBytes(StandardCharsets.US_ASCII));
      var10002.flush();
      var5 = getStringForInputStream(var0.getInputStream());
      String[] var7 = var5.substring(0, var5.indexOf("\r\n")).split("\\s+", 3);
      if (var7.length < 2) {
         throw new IOException("HTTP proxy returned an invalid response");
      } else {
         int var8;
         try {
            var8 = Integer.parseInt(var7[1]);
         } catch (NumberFormatException var4) {
            throw new IOException("HTTP proxy returned an invalid status", var4);
         }

         if (var8 < 200 || var8 >= 300) {
            throw new IOException((new StringBuilder()).insert(0, "HTTP proxy CONNECT failed: ").append(var8).toString());
         }
      }
   }

   private static String getStringForException(Exception var0) {
      return var0.getMessage() == null ? "Proxy connection failed" : var0.getMessage();
   }

   private void handleSocket2(Socket var1, LocalProxyRelay.HostPortRecord var2, LocalProxyRelay.ProtocolUpstreamRecord var3) throws IOException {
      Socket var10000 = var1;
      InputStream var8 = var1.getInputStream();
      OutputStream var4 = var10000.getOutputStream();
      boolean var5 = !var3.username().isBlank();
      byte[] var10001 = new byte[3];
      boolean var10003 = true;
      var10001[0] = 5;
      var10001[1] = 1;
      var10001[2] = (byte)(var5 ? 2 : 0);
      var4.write(var10001);
      var4.flush();
      int var6 = getIntForInputStream(var8);
      int var7 = getIntForInputStream(var8);
      if (var6 == 5 && var7 != 255) {
         LocalProxyRelay.HostPortRecord var12;
         if (var7 == 2) {
            var12 = var2;
            handleInputStream2(var8, var4, var3);
         } else {
            if (var7 != 0 || var5) {
               throw new IOException("SOCKS5 proxy did not accept username/password authentication");
            }

            var12 = var2;
         }

         byte[] var10;
         if ((var10 = var12.host().getBytes(StandardCharsets.UTF_8)).length != 0 && var10.length <= 255) {
            var4.write(5);
            var4.write(1);
            var4.write(0);
            var4.write(3);
            var4.write(var10.length);
            var4.write(var10);
            handleOutputStream(var4, var2.port());
            var4.flush();
            int var9 = getIntForInputStream(var8);
            int var11 = getIntForInputStream(var8);
            getIntForInputStream(var8);
            handleInputStream(var8, getIntForInputStream(var8));
            getByteArrayForInputStream(var8, 2);
            if (var9 != 5 || var11 != 0) {
               throw new IOException((new StringBuilder()).insert(0, "SOCKS5 CONNECT failed: ").append(getStringForInt(var11)).toString());
            }
         } else {
            throw new IOException("SOCKS5 target host is invalid");
         }
      } else {
         throw new IOException("SOCKS5 proxy rejected authentication methods");
      }
   }

   private void handleSocket(Socket var1) {
      Socket var2 = null;

      label47: {
         try {
            try {
               var1.setTcpNoDelay(true);
               var1.setSoTimeout(10000);
               LocalProxyRelay.HostPortRecord var3 = getHostPortRecordForInputStream(var1.getInputStream());
               var2 = this.getSocket(var3);
               OutputStream var4 = var1.getOutputStream();
               var4.write("HTTP/1.1 200 Connection Established\r\n\r\n".getBytes(StandardCharsets.US_ASCII));
               var4.flush();
               var1.setSoTimeout(0);
               var2.setSoTimeout(0);
               Socket upstream = var2;
               Future var10000 = this.executorService.submit(() -> {
                  handleSocket4(var1, upstream, true);
               });
               handleSocket4(var2, var1, false);
               var10000.cancel(true);
               break label47;
            } catch (Exception var7) {
               if (this.consumer != null) {
                  this.consumer.accept(getStringForException(var7));
               }

               handleSocket3(var1, var7);
            }
         } catch (Throwable var8) {
            this.set.remove(var2);
            this.set.remove(var1);
            handleCloseable(var2);
            handleCloseable(var1);
            throw var8;
         }

         this.set.remove(var2);
         this.set.remove(var1);
         handleCloseable(var2);
         handleCloseable(var1);
         return;
      }

      this.set.remove(var2);
      this.set.remove(var1);
      handleCloseable(var2);
      handleCloseable(var1);
   }

   public InetSocketAddress getInetSocketAddress() {
      return (InetSocketAddress)this.serverSocket.getLocalSocketAddress();
   }

   private static record ProtocolUpstreamRecord(ProxyConfig.ProxyProtocol protocol, InetSocketAddress upstream, String username, String password) {
      public ProxyConfig.ProxyProtocol protocol() {
         return this.protocol;
      }


      public String username() {
         return this.username;
      }

      public String password() {
         return this.password;
      }

      public InetSocketAddress upstream() {
         return this.upstream;
      }
   }

   private static record HostPortRecord(String host, int port) {
      String getString() {
         String var2 = this.host.indexOf(58) >= 0 ? (new StringBuilder()).insert(0, "[").append(this.host).append("]").toString() : this.host;
         return (new StringBuilder()).insert(0, var2).append(":").append(this.port).toString();
      }

      public String host() {
         return this.host;
      }


      static LocalProxyRelay.HostPortRecord getHostPortRecordForString(String var0) throws IOException {
         NumberFormatException var8;
         label46: {
            String var10000;
            String var1;
            boolean var10001;
            int var4;
            if (var0.startsWith("[")) {
               if ((var4 = var0.indexOf(93)) < 0 || var4 + 2 > var0.length() || var0.charAt(var4 + 1) != ':') {
                  throw new IOException("Invalid CONNECT target");
               }

               var1 = var0.substring(1, var4);
               var10000 = var0.substring(var4 + 2);
            } else {
               if ((var4 = var0.lastIndexOf(58)) <= 0 || var4 == var0.length() - 1) {
                  throw new IOException("Invalid CONNECT target");
               }

               var1 = var0.substring(0, var4);
               String var2 = var0.substring(var4 + 1);

               try {
                  var10000 = var2;
               } catch (NumberFormatException var6) {
                  var8 = var6;
                  var10001 = false;
                  break label46;
               }
            }

            try {
               if ((var4 = Integer.parseInt(var10000)) >= 1 && var4 <= 65535) {
                  return new LocalProxyRelay.HostPortRecord(var1, var4);
               }

               throw new IOException("Invalid CONNECT target port");
            } catch (NumberFormatException var5) {
               var8 = var5;
               var10001 = false;
            }
         }

         NumberFormatException var7 = var8;
         throw new IOException("Invalid CONNECT target port", var7);
      }

      public int port() {
         return this.port;
      }
   }
}
