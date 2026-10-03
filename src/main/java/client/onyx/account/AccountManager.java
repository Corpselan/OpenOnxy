package client.onyx.account;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.util.Util4;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import net.minecraft.util.Session;
import org.apache.logging.log4j.Logger;

public class AccountManager implements MinecraftAccess {
   private static final String STRING = "accounts.json";
   private final ProxyConfig proxyConfig;
   private static final int INT = 1;
   private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
   private final List<Abstract_> list = new ArrayList<>();
   private Session session;
   private static final String STRING2 = UUID.randomUUID().toString();
   private static final String STRING3 = "accounts.json.tmp";
   private Abstract_ abstract_;

   public Proxy getProxy2() {
      return this.proxyConfig.getProxy3();
   }

   public void run170() {
      Path var4 = this.getPath();
      LinkOption[] var5 = new LinkOption[0];
      if (Files.isRegularFile(var4, var5)) {
         JsonObject var1;
         try {
            String var3 = new String(Files.readAllBytes(this.getPath()), StandardCharsets.UTF_8);
            var1 = new JsonParser().parse(var3).getAsJsonObject();
         } catch (RuntimeException | IOException var8) {
            OnyxClient.LOGGER.error("Failed to read accounts", var8);
            return;
         }

         JsonElement var11;
         if ((var11 = var1.get("proxy")) != null && var11.isJsonObject()) {
            this.proxyConfig.handleJsonObject(var11.getAsJsonObject());
         }

         JsonElement var9;
         if ((var9 = var1.get("accounts")) != null && var9.isJsonArray()) {
            this.list.clear();
            Iterator var10 = var9.getAsJsonArray().iterator();

            label43:
            while (true) {
               for (Iterator var10000 = var10; var10000.hasNext(); var10000 = var10) {
                  if ((var11 = (JsonElement)var10.next()).isJsonObject()) {
                     try {
                        Abstract_ var13;
                        if ((var13 = Abstract_.getAbstract_ForJsonObject(var11.getAsJsonObject())) != null) {
                           this.list.add(var13);
                        }
                     } catch (RuntimeException var7) {
                        OnyxClient.LOGGER.warn("Skipping malformed account entry", var7);
                     }
                     continue label43;
                  }
               }

               return;
            }
         }
      }
   }

   public Abstract_ getAbstract_() {
      return this.abstract_;
   }

   private void handleSession(Session var1) {
      if (this.session == null) {
         this.session = MINECRAFT.getSession();
      }

      MINECRAFT.setSession(var1);
   }

   public void handleAbstract_2(Abstract_ var1) {
      this.list.add(var1);
      this.isEnabled135();
   }

   public boolean isEnabled135() {
      JsonArray var4 = new JsonArray();
      List var7 = this.list;
      synchronized (var7) {
         Iterator var6;
         Iterator var10000 = var6 = this.list.iterator();

         while (var10000.hasNext()) {
            Abstract_ var1 = (Abstract_)var6.next();
            var10000 = var6;
            var4.add(var1.getJsonObject());
         }
      }

      JsonObject var2 = new JsonObject();
      var2.addProperty("version", 1);
      var2.add("accounts", var4);
      var2.add("proxy", this.proxyConfig.getJsonObject());
      Path var24 = this.getPath2().resolve("accounts.json.tmp");

      try {
         Path var8 = this.getPath2();
         FileAttribute[] var9 = new FileAttribute[0];
         Path var10 = Files.createDirectories(var8, var9);
         byte[] var12 = GSON.toJson((JsonElement)var2).getBytes(StandardCharsets.UTF_8);
         OpenOption[] var13 = new OpenOption[0];
         Path var14 = Files.write(var24, var12, var13);

         try {
            Path var15 = this.getPath();
            CopyOption[] var16 = new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING};
            Path var17 = Files.move(var24, var15, var16);
         } catch (AtomicMoveNotSupportedException var21) {
            Path var18 = this.getPath();
            CopyOption[] var19 = new CopyOption[]{StandardCopyOption.REPLACE_EXISTING};
            Path var20 = Files.move(var24, var18, var19);
         }

         return true;
      } catch (IOException var22) {
         OnyxClient.LOGGER.error("Failed to save accounts", var22);
         return false;
      }
   }

   public Path getPath2() {
      return new File(MINECRAFT.mcDataDir, "onyx").toPath();
   }

   public AccountManager() {
      this.proxyConfig = new ProxyConfig();
   }

   public Path getPath() {
      return this.getPath2().resolve("accounts.json");
   }

   public ProxyConfig getProxyConfig() {
      return this.proxyConfig;
   }

   public Proxy getProxy() {
      return this.proxyConfig.getProxy();
   }

   public List<Abstract_> getList25() {
      return List.copyOf(this.list);
   }

   public static String getString33() {
      return STRING2;
   }

   public CompletableFuture<Void> getCompletableFuture() {
      Abstract_ var2 = this.abstract_;
      return this.abstract_ == null ? CompletableFuture.completedFuture(null) : this.getCompletableFuture3(var2);
   }

   public CompletableFuture<Void> getCompletableFuture3(Abstract_ var1) {
      return CompletableFuture.runAsync(() -> {
         Session var2;
         try {
            var2 = var1.getSession();
         } catch (client.onyx.account.auth.OnyxException var8) {
            throw new AccountManager.OnyxException(var8.getMessage());
         } catch (RuntimeException var9) {
            Logger var5 = OnyxClient.LOGGER;
            Object[] var6 = new Object[2];
            String var7 = var1.getString();
            var6[0] = var7;
            var6[1] = var9;
            var5.error("Unexpected error logging into '{}'", var6);
            throw new AccountManager.OnyxException(new StringBuilder().insert(0, "Unexpected error: ").append(var9).toString());
         }

         this.isEnabled135();
         MINECRAFT.addScheduledTask(() -> {
            this.handleSession(var2);
            this.abstract_ = var1;
         });
      }, Util4.getExecutor());
   }

   public CompletableFuture<Void> getCompletableFuture2(Abstract_ var1) {
      return CompletableFuture.runAsync(() -> {
         try {
            var1.run();
         } catch (client.onyx.account.auth.OnyxException var2) {
            throw new AccountManager.OnyxException(var2.getMessage());
         }

         this.isEnabled135();
      }, Util4.getExecutor());
   }

   public void handleAbstract_(Abstract_ var1) {
      if (this.list.remove(var1)) {
         if (this.abstract_ == var1) {
            this.abstract_ = null;
         }

         this.isEnabled135();
      }
   }

   public void run169() {
      if (this.session != null) {
         MINECRAFT.setSession(this.session);
         this.abstract_ = null;
      }
   }

   public static class OnyxException extends RuntimeException {
      public OnyxException(String var1) {
         super(var1);
      }
   }
}
