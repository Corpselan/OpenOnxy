package client.onyx.account.auth;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.util.BrowserOpener;
import client.onyx.util.Util4;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public final class LocalLoginServer implements MinecraftAccess {
   private static final int INT = 1337;
   private final String string;
   private static final String STRING = "<!doctype html><meta charset=\"utf-8\"><title>%s</title>\n<body style=\"background:#141218;color:#e6e0e9;font-family:system-ui,sans-serif;\ndisplay:flex;align-items:center;justify-content:center;height:100vh;margin:0\">\n<div style=\"text-align:center\"><h1 style=\"font-weight:500\">%s</h1>\n<p style=\"opacity:.7\">You can close this tab and return to Minecraft.</p></div>";
   private final Consumer<MicrosoftAuth.MicrosoftTokens> consumer;
   private static final String STRING2 = "127.0.0.1";
   private static final String STRING3 = "/";
   private static LocalLoginServer localLoginServer;
   private final HttpServer httpServer;
   private final String string2;
   private final Consumer<String> consumer2;
   private static final int INT2 = 300;
   private final AtomicBoolean atomicBoolean = new AtomicBoolean();

   public static synchronized LocalLoginServer getLocalLoginServerForConsumer(Consumer<MicrosoftAuth.MicrosoftTokens> var0, Consumer<String> var1) throws OnyxException {
      if (!MicrosoftAuth.isEnabled()) {
         throw new OnyxException("No Azure client id configured — set MicrosoftAuth.CLIENT_ID");
      } else {
         run174();

         HttpServer var2;
         try {
            var2 = HttpServer.create(new InetSocketAddress("127.0.0.1", 1337), 0);
         } catch (BindException var5) {
            throw new OnyxException("Microsoft sign-in requires local port 1337 to be available", var5);
         } catch (IOException var6) {
            throw new OnyxException("Could not open the local login server", var6);
         }

         LocalLoginServer var4 = new LocalLoginServer(var2, 1337, var0, var1);
         var2.createContext("/", var1x -> {
            Map var4x;
            String var3 = (String)(var4x = getMapForString(var1x.getRequestURI().getRawQuery())).get("code");
            String var6x = var4x.get("error_description") != null ? (String)var4x.get("error_description") : (String)var4x.get("error");
            if (var3 == null) {
               var4.handleHttpExchange(var1x, "Sign-in failed");
               var4.handleString16(var6x != null ? var6x : "Microsoft did not return an authorization code");
            } else if (var4.atomicBoolean.compareAndSet(false, true)) {
               MicrosoftAuth.MicrosoftTokens var7;
               try {
                  var7 = MicrosoftAuth.getMicrosoftTokensForString2(var3, var4.string);
               } catch (OnyxException var5x) {
                  OnyxClient.LOGGER.warn("Microsoft sign-in failed", var5x);
                  var4.handleHttpExchange(var1x, "Sign-in failed");
                  var4.run172();
                  MINECRAFT.addScheduledTask(() -> var4.consumer2.accept(var5x.getMessage()));
                  return;
               }

               var4.handleHttpExchange(var1x, "Signed in");
               var4.run172();
               MINECRAFT.addScheduledTask(() -> var4.consumer.accept(var7));
            }
         });
         var2.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
         var2.start();
         localLoginServer = var4;
         Util4.handleRunnable(() -> {
            try {
               Thread.sleep(300000L);
            } catch (InterruptedException var1x) {
               Thread.currentThread().interrupt();
               return;
            }

            var4.handleString16("Sign-in timed out");
         });
         return var4;
      }
   }

   public String getString35() {
      return this.string2;
   }

   private void handleHttpExchange(HttpExchange var1, String var2) {
      Object[] var5 = new Object[]{var2, var2};
      byte[] var12 = "<!doctype html><meta charset=\"utf-8\"><title>%s</title>\n<body style=\"background:#141218;color:#e6e0e9;font-family:system-ui,sans-serif;\ndisplay:flex;align-items:center;justify-content:center;height:100vh;margin:0\">\n<div style=\"text-align:center\"><h1 style=\"font-weight:500\">%s</h1>\n<p style=\"opacity:.7\">You can close this tab and return to Minecraft.</p></div>"
         .formatted(var5)
         .getBytes(StandardCharsets.UTF_8);

      try {
         OutputStream var11 = var1.getResponseBody();

         try {
            var1.getResponseHeaders().add("Content-Type", "text/html; charset=utf-8");
            var1.sendResponseHeaders(200, var12.length);
            var11.write(var12);
         } catch (Throwable var9) {
            if (var11 != null) {
               try {
                  var11.close();
               } catch (Throwable var8) {
                  var9.addSuppressed(var8);
                  throw var9;
               }

               throw var9;
            }

            throw var9;
         }

         if (var11 != null) {
            var11.close();
            return;
         }
      } catch (IOException var10) {
         OnyxClient.LOGGER.warn("Failed to answer the OAuth callback", var10);
      }
   }

   public static synchronized void run174() {
      if (localLoginServer != null) {
         localLoginServer.run171();
      }
   }

   public String getString34() {
      return this.string;
   }

   public void run171() {
      if (this.atomicBoolean.compareAndSet(false, true)) {
         this.run172();
      }
   }

   public void run173() {
      BrowserOpener.handleString(this.string2);
   }

   private LocalLoginServer(HttpServer var1, int var2, Consumer<MicrosoftAuth.MicrosoftTokens> var3, Consumer<String> var4) {
      this.httpServer = var1;
      this.consumer = var3;
      this.consumer2 = var4;
      this.string = new StringBuilder().insert(0, "http://127.0.0.1:").append(var2).append("/").toString();
      this.string2 = MicrosoftAuth.getStringForString(this.string);
   }

   private static Map<String, String> getMapForString(String var0) {
      HashMap var7 = new HashMap();
      if (var0 != null && !var0.isEmpty()) {
         String[] var6;
         int var5 = (var6 = var0.split("&")).length;

         int var4;
         for (int var10000 = var4 = 0; var10000 < var5; var10000 = ++var4) {
            int var2;
            String var3;
            if ((var2 = (var3 = var6[var4]).indexOf(61)) > 0) {
               var7.put(URLDecoder.decode(var3.substring(0, var2), StandardCharsets.UTF_8), URLDecoder.decode(var3.substring(var2 + 1), StandardCharsets.UTF_8));
            }
         }

         return var7;
      } else {
         return var7;
      }
   }

   private void run172() {
      this.httpServer.stop(0);
      synchronized (LocalLoginServer.class) {
         if (localLoginServer == this) {
            localLoginServer = null;
         }
      }
   }

   private void handleString16(String var1) {
      if (this.atomicBoolean.compareAndSet(false, true)) {
         this.run172();
         MINECRAFT.addScheduledTask(() -> this.consumer2.accept(var1));
      }
   }
}
