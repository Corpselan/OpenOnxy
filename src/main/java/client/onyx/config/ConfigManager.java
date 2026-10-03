package client.onyx.config;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.Setting;
import client.onyx.setting.Util;
import client.onyx.setting.ValueSetting;
import client.onyx.util.BrowserOpener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.apache.logging.log4j.Logger;

public class ConfigManager implements MinecraftAccess {
   private static final String STRING = ".json";
   private static final Pattern PATTERN = Pattern.compile("[a-zA-Z0-9_-]{1,64}");
   public static final String STRING2 = "default";
   private String string;
   private static final int INT = 1;
   private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();

   public ConfigManager.CopiedFailedRecord getCopiedFailedRecord(String var1, List<String> var2) {
      Object var3 = var2 == null ? Set.of() : new LinkedHashSet(var2);
      ArrayList var9 = new ArrayList();
      JsonObject var4;
      if ((var4 = getJsonObjectForJsonObject(this.getJsonObject2(var1))) == null) {
         var9.addAll((Collection)var3);
         return new ConfigManager.CopiedFailedRecord(0, List.copyOf(var9));
      } else {
         int var5 = 0;
         Iterator var10 = ((Set)var3).iterator();

         label40:
         while(true) {
            Iterator var10000 = var10;

            while(true) {
               while(var10000.hasNext()) {
                  String var6 = (String)var10.next();
                  if (!var1.equals(var6) && this.isString8(var6)) {
                     JsonObject var7;
                     JsonObject var8;
                     if ((var8 = getJsonObjectForJsonObject(var7 = this.getJsonObject2(var6))) != null) {
                        handleJsonObject2(var4, var8);
                        if (this.isString7(var6, var7)) {
                           ++var5;
                        } else {
                           var9.add(var6);
                        }
                        continue label40;
                     }

                     var10000 = var10;
                     var9.add(var6);
                  } else {
                     var9.add(var6);
                     var10000 = var10;
                  }
               }

               return new ConfigManager.CopiedFailedRecord(var5, List.copyOf(var9));
            }
         }
      }
   }

   public String getString45(String var1) {
      if (!this.isString8(var1)) {
         return var1;
      } else {
         int var2;
         for(int var10000 = var2 = 2; var10000 < 10000; var10000 = var2) {
            String var5 = (new StringBuilder()).insert(0, "_").append(var2).toString();
            int var4 = Math.min(var1.length(), 64 - var5.length());
            StringBuilder var6 = new StringBuilder();
            String var7 = var1.substring(0, var4);
            var5 = var6.insert(0, var7).append(var5).toString();
            if (!this.isString8(var5)) {
               return var5;
            }

            ++var2;
         }

         return null;
      }
   }

   public String getString48(String var1) {
      if (!this.isString8(var1)) {
         return null;
      } else {
         int var2;
         for(int var10000 = var2 = 1; var10000 < 10000; var10000 = var2) {
            String var5 = var2 == 1 ? "_copy" : (new StringBuilder()).insert(0, "_copy_").append(var2).toString();
            int var4 = Math.min(var1.length(), 64 - var5.length());
            StringBuilder var6 = new StringBuilder();
            String var7 = var1.substring(0, var4);
            var5 = var6.insert(0, var7).append(var5).toString();
            if (!this.isString8(var5)) {
               try {
                  Path var11 = this.getPath5(var1);
                  Path var12 = this.getPath5(var5);
                  CopyOption[] var13 = new CopyOption[0];
                  Files.copy(var11, var12, var13);
                  return var5;
               } catch (IOException var17) {
                  Logger var15 = OnyxClient.LOGGER;
                  Object[] var16 = new Object[]{var1, var5, var17};
                  var15.error("Failed to duplicate config '{}' as '{}'", var16);
                  return null;
               }
            }

            ++var2;
         }

         return null;
      }
   }

   private Path getPath3() {
      return this.getPath6().resolve("last-config.txt");
   }

   private boolean isString7(String var1, JsonObject var2) {
      try {
         Path var3 = this.getPath4();
         FileAttribute[] var4 = new FileAttribute[0];
         Files.createDirectories(var3, var4);
         Path var6 = this.getPath5(var1);
         byte[] var8 = GSON.toJson((JsonElement)var2).getBytes(StandardCharsets.UTF_8);
         OpenOption[] var9 = new OpenOption[0];
         Files.write(var6, var8, var9);
         return true;
      } catch (IOException var13) {
         Logger var11 = OnyxClient.LOGGER;
         Object[] var12 = new Object[]{var1, var13};
         var11.error("Failed to write config '{}'", var12);
         return false;
      }
   }

   private void handleValueSetting(ValueSetting<?> var1, JsonElement var2) {
      if (var2 != null && !var2.isJsonNull()) {
         try {
            var1.handleJsonElement(var2);
         } catch (RuntimeException var6) {
            Logger var3 = OnyxClient.LOGGER;
            Object[] var4 = new Object[2];
            String var5 = var1.getString3();
            var4[0] = var5;
            var4[1] = var6;
            var3.warn("Failed to load setting '{}'", var4);
         }
      }
   }

   public String getString44() {
      return this.string;
   }

   public boolean isString4(String var1) {
      if (!this.lambda317(var1)) {
         return false;
      } else {
         JsonObject var4 = new JsonObject();
         var4.addProperty("version", (int)1);
         var4.add("modules", this.getJsonObject());
         Path var3 = this.getPath4().resolve((new StringBuilder()).insert(0, var1).append(".json").append(".tmp").toString());

         try {
            Path var5 = this.getPath4();
            FileAttribute[] var6 = new FileAttribute[0];
            Files.createDirectories(var5, var6);
            byte[] var9 = GSON.toJson((JsonElement)var4).getBytes(StandardCharsets.UTF_8);
            OpenOption[] var10 = new OpenOption[0];
            Files.write(var3, var9, var10);

            try {
               Path var12 = this.getPath5(var1);
               CopyOption[] var13 = new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING};
               Files.move(var3, var12, var13);
            } catch (AtomicMoveNotSupportedException var20) {
               Path var15 = this.getPath5(var1);
               CopyOption[] var16 = new CopyOption[]{StandardCopyOption.REPLACE_EXISTING};
               Files.move(var3, var15, var16);
            }

            return true;
         } catch (IOException var21) {
            Logger var18 = OnyxClient.LOGGER;
            Object[] var19 = new Object[]{var1, var21};
            var18.error("Failed to save config '{}'", var19);
            return false;
         }
      }
   }

   private JsonObject getJsonObject2(String var1) {
      if (!this.isString8(var1)) {
         return null;
      } else {
         try {
            String var4 = new String(Files.readAllBytes(this.getPath5(var1)), StandardCharsets.UTF_8);
            JsonElement var3;
            return (var3 = (new JsonParser()).parse(var4)).isJsonObject() ? var3.getAsJsonObject() : null;
         } catch (RuntimeException | IOException var7) {
            Logger var5 = OnyxClient.LOGGER;
            Object[] var6 = new Object[]{var1, var7};
            var5.error("Failed to read config '{}'", var6);
            return null;
         }
      }
   }

   private static void handleSetting3(Setting var0) {
      if (var0 instanceof ValueSetting) {
         ValueSetting var4;
         (var4 = (ValueSetting)var0).run5();
      } else {
         if (var0 instanceof BooleanSetting) {
            BooleanSetting var2;
            if ((var2 = (BooleanSetting)var0).getValueSettingSub9() != null) {
               var2.getValueSettingSub9().run5();
            }

            Iterator var3;
            for(Iterator var10000 = var3 = var2.getList2().iterator(); var10000.hasNext(); var10000 = var3) {
               handleSetting3((Setting)var3.next());
            }
         }

      }
   }

   public void run208() {
      String var2;
      if ((var2 = this.getString46()) == null || !this.isString3(var2)) {
         this.isString3("default");
      }
   }

   private void handleString30(String var1) {
      try {
         Path var4 = this.getPath6();
         FileAttribute[] var5 = new FileAttribute[0];
         Files.createDirectories(var4, var5);
         Path var7 = this.getPath3();
         byte[] var8 = var1.getBytes(StandardCharsets.UTF_8);
         OpenOption[] var9 = new OpenOption[0];
         Files.write(var7, var8, var9);
      } catch (IOException var13) {
         Logger var11 = OnyxClient.LOGGER;
         Object[] var12 = new Object[]{var1, var13};
         var11.error("Failed to remember config '{}'", var12);
      }
   }

   public boolean isString9(String var1) {
      if (this.lambda317(var1) && !this.isString8(var1)) {
         this.run205();
         return this.isString4(var1);
      } else {
         return false;
      }
   }

   public String getString47() {
      return this.string == null ? "default" : this.string;
   }

   private static void handleJsonObject2(JsonObject var0, JsonObject var1) {
      Iterator var7 = OnyxClient.cls.getArrayList().iterator();

      label39:
      while(true) {
         Iterator var10000 = var7;

         while(true) {
            while(var10000.hasNext()) {
               Module var3;
               if ((var3 = (Module)var7.next()).getModuleCategory() != ModuleCategory.RENDER && var3.getModuleCategory() != ModuleCategory.HUD) {
                  var10000 = var7;
               } else {
                  JsonElement var4;
                  if ((var4 = var0.get(var3.getString20())) == null) {
                     continue label39;
                  }

                  if (!var4.isJsonObject()) {
                     var10000 = var7;
                  } else {
                     JsonObject var8 = var4.getAsJsonObject();
                     JsonElement var5;
                     JsonObject var6 = (var5 = var1.get(var3.getString20())) != null && var5.isJsonObject() ? var5.getAsJsonObject() : new JsonObject();
                     var10000 = var7;
                     handleJsonObject3(var8, var6, "enabled");
                     handleJsonObject3(var8, var6, "settings");
                     var1.add(var3.getString20(), var6);
                  }
               }
            }

            return;
         }
      }
   }

   public boolean lambda317(String var1) {
      return var1 != null && PATTERN.matcher(var1).matches();
   }

   public Path getPath6() {
      return (new File(MINECRAFT.mcDataDir, "onyx")).toPath();
   }

   private void handleString29(String var1) {
      this.handleString30(this.string = var1);
   }

   public Path getPath5(String var1) {
      return this.getPath4().resolve((new StringBuilder()).insert(0, var1).append(".json").toString());
   }

   private void handleJsonObject(JsonObject var1, int var2) {
      Iterator var9 = OnyxClient.cls.getArrayList().iterator();

      while(true) {
         label51:
         while(true) {
            Iterator var10000 = var9;

            while(true) {
               while(var10000.hasNext()) {
                  Module var7 = (Module)var9.next();
                  JsonElement var4;
                  if ((var4 = var1.get(var7.getString20())) == null) {
                     continue label51;
                  }

                  if (!var4.isJsonObject()) {
                     var10000 = var9;
                  } else {
                     JsonObject var10;
                     JsonObject var12 = var10 = var4.getAsJsonObject();
                     this.handleValueSetting(var7.getNoneValueSetting2(), var10.get("bind"));
                     this.handleValueSetting(var7.getValueSettingSub112(), var10.get("bindMode"));
                     JsonElement var5;
                     if ((var5 = var12.get("settings")) != null && var5.isJsonObject()) {
                        JsonObject var6 = var5.getAsJsonObject();

                        Iterator var11;
                        for(var10000 = var11 = var7.getList11().iterator(); var10000.hasNext(); var10000 = var11) {
                           BooleanSetting.handleSetting((Setting)var11.next(), var6);
                        }
                     }

                     if (var7 instanceof Iface) {
                        Iface var8 = (Iface)var7;
                        var8.run();
                     }

                     if (var7.isEnabled54()) {
                        JsonElement var13;
                        if ((var13 = var10.get("enabled")) != null && var13.isJsonPrimitive() && var13.getAsJsonPrimitive().isBoolean()) {
                           var7.handleBool16(var13.getAsBoolean());
                        }
                        continue label51;
                     }

                     var10000 = var9;
                  }
               }

               return;
            }
         }
      }
   }

   private static JsonObject getJsonObjectForJsonObject(JsonObject var0) {
      if (var0 == null) {
         return null;
      } else {
         JsonElement var2;
         return (var2 = var0.get("modules")) != null && var2.isJsonObject() ? var2.getAsJsonObject() : null;
      }
   }

   public boolean isEnabled166() {
      String var1 = this.getString47();
      return this.isString4(var1);
   }

   public boolean isString5(String var1) {
      return var1 != null && var1.equals(this.string);
   }

   private void run205() {
      Util.handleRunnable(() -> {
         Iterator var0;
         for(Iterator var10000 = var0 = OnyxClient.cls.getArrayList().iterator(); var10000.hasNext(); var10000 = var0) {
            Module var1;
            if ((var1 = (Module)var0.next()).isEnabled54()) {
               var1.handleBool16(false);
            }

            Iterator var2;
            for(var10000 = var2 = var1.getList11().iterator(); var10000.hasNext(); var10000 = var2) {
               handleSetting3((Setting)var2.next());
            }

            if (var1 instanceof Iface) {
               Iface var3 = (Iface)var1;
               var3.run();
            }

            var1.run82();
         }

      });
   }

   public boolean isString8(String var1) {
      if (this.lambda317(var1)) {
         Path var2 = this.getPath5(var1);
         LinkOption[] var3 = new LinkOption[0];
         if (Files.isRegularFile(var2, var3)) {
            return true;
         }
      }

      return false;
   }

   private String getString46() {
      Path var2;
      Path var10000 = var2 = this.getPath3();
      LinkOption[] var10001 = new LinkOption[0];
      boolean var10003 = true;
      if (!Files.isRegularFile(var10000, var10001)) {
         return null;
      } else {
         try {
            String var4 = (new String(Files.readAllBytes(var2), StandardCharsets.UTF_8)).trim();
            return this.isString8(var4) ? var4 : null;
         } catch (IOException var3) {
            OnyxClient.LOGGER.error((String)"Failed to read the last config", (Throwable)var3);
            return null;
         }
      }
   }

   private static JsonElement getJsonElementForJsonElement(JsonElement var0) {
      return (new JsonParser()).parse(var0.toString());
   }

   public void run207() {
      try {
         Path var3 = this.getPath4();
         FileAttribute[] var4 = new FileAttribute[0];
         Files.createDirectories(var3, var4);
      } catch (IOException var6) {
         OnyxClient.LOGGER.error((String)"Failed to create config folder", (Throwable)var6);
         return;
      }

      BrowserOpener.handlePath(this.getPath4());
   }

   public boolean isString3(String var1) {
      if (!this.isString8(var1)) {
         return false;
      } else {
         JsonObject var2;
         try {
            String var5 = new String(Files.readAllBytes(this.getPath5(var1)), StandardCharsets.UTF_8);
            var2 = (new JsonParser()).parse(var5).getAsJsonObject();
         } catch (RuntimeException | IOException var8) {
            Logger var6 = OnyxClient.LOGGER;
            Object[] var7 = new Object[]{var1, var8};
            var6.error("Failed to read config '{}'", var7);
            return false;
         }

         int var10 = 1;
         JsonElement var4;
         if ((var4 = var2.get("version")) != null && var4.isJsonPrimitive() && var4.getAsJsonPrimitive().isNumber()) {
            var10 = var4.getAsInt();
         }

         JsonElement var9;
         if ((var9 = var2.get("modules")) != null && var9.isJsonObject()) {
            var2 = var9.getAsJsonObject();
            JsonObject modules = var2;
            int version = var10;
            Util.handleRunnable(() -> {
               this.handleJsonObject(modules, version);
            });
            if (var10 < 1) {
               this.isString4(var1);
            }

            this.handleString29(var1);
            return true;
         } else {
            return false;
         }
      }
   }

   private JsonObject getJsonObject() {
      JsonObject var4 = new JsonObject();
      Iterator var6;
      Iterator var10000 = var6 = OnyxClient.cls.getArrayList().iterator();

      while(var10000.hasNext()) {
         Module var8 = (Module)var6.next();
         JsonObject var1 = new JsonObject();
         if (var8.isEnabled54()) {
            var1.addProperty("enabled", var8.isEnabled55());
         }

         var1.add("bind", var8.getNoneValueSetting2().getJsonElement());
         var1.add("bindMode", var8.getValueSettingSub112().getJsonElement());
         JsonObject var5 = new JsonObject();
         Iterator var2;
         var10000 = var2 = var8.getList11().iterator();

         while(var10000.hasNext()) {
            Setting var7;
            if (!(var7 = (Setting)var2.next()).isEnabled3()) {
               var10000 = var2;
            } else {
               var5.add(var7.getString3(), var7.getJsonElement());
               var10000 = var2;
            }
         }

         var1.add("settings", var5);
         var10000 = var6;
         var4.add(var8.getString20(), var1);
      }

      return var4;
   }

   public boolean isString6(String var1) {
      if (!this.lambda317(var1)) {
         return false;
      } else {
         try {
            boolean var3;
            if ((var3 = Files.deleteIfExists(this.getPath5(var1))) && this.isString5(var1)) {
               this.string = null;
               this.run206();
            }

            return var3;
         } catch (IOException var6) {
            Logger var4 = OnyxClient.LOGGER;
            Object[] var5 = new Object[]{var1, var6};
            var4.error("Failed to delete config '{}'", var5);
            return false;
         }
      }
   }

   private static void handleJsonObject3(JsonObject var0, JsonObject var1, String var2) {
      JsonElement var3;
      if ((var3 = var0.get(var2)) == null) {
         var1.remove(var2);
      } else {
         var1.add(var2, getJsonElementForJsonElement(var3));
      }
   }

   public Path getPath4() {
      return this.getPath6().resolve("configs");
   }

   public List<String> getList31() {
      Path var5 = this.getPath4();
      LinkOption[] var6 = new LinkOption[0];
      if (!Files.isDirectory(var5, var6)) {
         return List.of();
      } else {
         try (Stream<Path> var4 = Files.list(this.getPath4())) {
            return var4.filter(var0 -> Files.isRegularFile(var0))
               .map(var0 -> var0.getFileName().toString())
               .filter(var0 -> var0.endsWith(".json"))
               .map(var0 -> var0.substring(0, var0.length() - ".json".length()))
               .filter(this::lambda317)
               .sorted()
               .toList();
         } catch (IOException var10) {
            OnyxClient.LOGGER.error((String)"Failed to list configs", (Throwable)var10);
            return List.of();
         }
      }
   }

   private void run206() {
      try {
         Files.deleteIfExists(this.getPath3());
      } catch (IOException var3) {
         OnyxClient.LOGGER.error((String)"Failed to forget the last config", (Throwable)var3);
      }
   }

   public static record CopiedFailedRecord(int copied, List<String> failed) {
      public int copied() {
         return this.copied;
      }


      public List<String> failed() {
         return this.failed;
      }
   }
}
