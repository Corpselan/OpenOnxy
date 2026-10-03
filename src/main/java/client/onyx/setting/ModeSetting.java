package client.onyx.setting;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.apache.logging.log4j.Logger;

public class ModeSetting<M extends ModeOption> extends ValueSetting<M> {
   private final List<M> list;

   public ModeSetting<M> getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public <O> ModeSetting<M> getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   public ModeSetting<M> getModeSetting3(Consumer<M> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   public M getModeOption() {
      return this.lambda15();
   }

   public void handleModeOption(ModeOption var1) {
      Iterator var4 = this.list.iterator();

      while (var4.hasNext()) {
         ModeOption var3;
         if ((var3 = (ModeOption)var4.next()) == var1) {
            this.handleObject2((M)var3);
            return;
         }
      }
   }

   @Override
   public JsonElement getJsonElement() {
      JsonObject var4;
      (var4 = new JsonObject()).addProperty("mode", this.lambda15().getString3());
      JsonObject var2 = new JsonObject();
      Iterator var5;
      Iterator var10000 = var5 = this.list.iterator();

      while (var10000.hasNext()) {
         ModeOption var1;
         if (!(var1 = (ModeOption)var5.next()).isEnabled3()) {
            var10000 = var5;
         } else {
            var2.add(var1.getString3(), var1.getJsonElement());
            var10000 = var5;
         }
      }

      var4.add("modes", var2);
      return var4;
   }

   public ModeSetting<M> getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public List<M> getList4() {
      return this.list;
   }

   @Override
   public List<Setting> getList2() {
      return List.copyOf(this.list);
   }

   public boolean isModeOption(M var1) {
      return this.lambda15() == var1;
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isString()) {
         this.handleString(var1.getAsString());
      } else if (var1.isJsonObject()) {
         JsonElement var6;
         JsonObject var11;
         if ((var6 = (var11 = var1.getAsJsonObject()).get("modes")) != null && var6.isJsonObject()) {
            JsonObject var3 = var6.getAsJsonObject();
            Iterator var13 = this.list.iterator();

            label49:
            while (true) {
               Iterator var10000 = var13;

               while (true) {
                  if (!var10000.hasNext()) {
                     break label49;
                  }

                  ModeOption var4;
                  if (!(var4 = (ModeOption)var13.next()).isEnabled3()) {
                     var10000 = var13;
                  } else {
                     JsonElement var5;
                     if ((var5 = var3.get(var4.getString3())) == null) {
                        break;
                     }

                     if (!var5.isJsonNull()) {
                        try {
                           var4.handleJsonElement(var5);
                        } catch (RuntimeException var10) {
                           Logger var7 = OnyxClient.LOGGER;
                           Object[] var8 = new Object[2];
                           String var9 = var4.getString4();
                           var8[0] = var9;
                           var8[1] = var10;
                           var7.warn("Failed to load mode '{}'", var8);
                        }
                        break;
                     }

                     var10000 = var13;
                  }
               }
            }
         }

         JsonElement var12;
         if ((var12 = var11.get("mode")) != null && var12.isJsonPrimitive() && var12.getAsJsonPrimitive().isString()) {
            this.handleString(var12.getAsString());
         }
      }
   }

   public void handleString(String var1) {
      var1 = getStringForString(var1);
      Iterator var4 = this.list.iterator();

      while (var4.hasNext()) {
         ModeOption var3;
         if (getStringForString((var3 = (ModeOption)var4.next()).getString3()).equals(var1)) {
            this.handleObject2((M)var3);
            return;
         }
      }
   }

   @Override
   public void handleBool(boolean var1) {
      Iterator var4;
      for (Iterator var10000 = var4 = this.list.iterator(); var10000.hasNext(); var10000 = var4) {
         ModeOption var3;
         (var3 = (ModeOption)var4.next()).handleBool(var1 && var3 == this.lambda15());
      }
   }

   public ModeSetting<M> getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   @Override
   public void handleModule(Module var1, Setting var2) {
      super.handleModule(var1, var2);
      Iterator var4;
      Iterator var10000 = var4 = this.list.iterator();

      while (var10000.hasNext()) {
         ModeOption var3 = (ModeOption)var4.next();
         var10000 = var4;
         var3.handleModeSetting(this);
         var3.handleModule(var1, this);
      }
   }

   @SafeVarargs
   public ModeSetting(String var1, M var2, M... var3) {
      super(var1, (M)var2);
      this.list = List.of((M[])var3);
      if (!this.list.contains(var2)) {
         throw new IllegalArgumentException(
            new StringBuilder().insert(0, "Default mode '").append(var2.getString3()).append("' is not part of '").append(var1).append("'").toString()
         );
      }
   }

   public void handleObject2(M var1) {
      ModeOption var3 = this.lambda15();
      super.handleObject2(var1);
      if (this.lambda15() != var3) {
         this.run();
      }
   }

   private static String getStringForString(String var0) {
      if (var0 == null) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder(var0.length());

         int var4;
         for (int var10000 = var4 = 0; var10000 < var0.length(); var10000 = ++var4) {
            char var3;
            if (Character.isLetterOrDigit(var3 = var0.charAt(var4))) {
               var1.append(Character.toLowerCase(var3));
            }
         }

         return var1.toString();
      }
   }

   public boolean isString(String var1) {
      return this.lambda15().getString3().equals(var1);
   }
}
