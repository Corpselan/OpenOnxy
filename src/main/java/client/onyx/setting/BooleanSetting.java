package client.onyx.setting;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.util.Iface;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import org.apache.logging.log4j.Logger;

public class BooleanSetting extends Setting implements Iface {
   private boolean bool;
   private final ValueSettingSub9 valueSettingSub9;
   private final List<Setting> list = new ArrayList();

   public boolean isEnabled5() {
      return this.valueSettingSub9 == null || (Boolean)this.valueSettingSub9.lambda15();
   }

   protected BooleanSetting(String var1, boolean var2) {
      super(var1);
      this.valueSettingSub9 = new ValueSettingSub9("Enabled", var2);
      this.valueSettingSub9.getModeSetting3((var1x) -> {
         this.run();
      });
   }

   protected BooleanSetting(String var1) {
      super(var1);
      this.valueSettingSub9 = null;
   }

   protected void run3() {
   }

   private void handleObject(Object var1, Class<?> var2) {
      Class var7;
      for(Class var10000 = var7 = var1.getClass(); var10000 != null && var7 != var2; var10000 = var7 = var7.getSuperclass()) {
         Field[] var4;
         int var5 = (var4 = var7.getDeclaredFields()).length;

         int var6;
         for(int var14 = var6 = 0; var14 < var5; var14 = var6) {
            Field var9 = var4[var6];
            if (Setting.class.isAssignableFrom(var9.getType()) && !Modifier.isStatic(var9.getModifiers()) && !Modifier.isTransient(var9.getModifiers())) {
               try {
                  var9.setAccessible(true);
                  Object var8;
                  if ((var8 = var9.get(var1)) != null) {
                     this.list.add((Setting)var8);
                  }
               } catch (IllegalAccessException var13) {
                  Logger var10 = OnyxClient.LOGGER;
                  Object[] var11 = new Object[2];
                  String var12 = var9.getName();
                  var11[0] = var12;
                  var11[1] = var13;
                  var10.error("Failed to read setting field '{}'", var11);
               }
            }

            ++var6;
         }
      }

   }

   public void handleJsonElement(JsonElement var1) {
      if (this.valueSettingSub9 != null && var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isBoolean()) {
         this.valueSettingSub9.handleJsonElement(var1);
      } else if (var1.isJsonObject()) {
         JsonObject var3 = var1.getAsJsonObject();
         if (this.valueSettingSub9 != null) {
            handleSetting(this.valueSettingSub9, var3);
         }

         Iterator var2;
         for(Iterator var10000 = var2 = this.list.iterator(); var10000.hasNext(); var10000 = var2) {
            handleSetting((Setting)var2.next(), var3);
         }

      }
   }

   public BooleanSetting getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public void handleBool(boolean var1) {
      BooleanSetting var10000;
      label27: {
         var1 = var1 && this.isEnabled5();
         if (var1 != this.bool) {
            if (this.bool = var1) {
               OnyxClient.I_EVENT_BUS.subscribe((Object)this);
               var10000 = this;
               this.run3();
               break label27;
            }

            OnyxClient.I_EVENT_BUS.unsubscribe((Object)this);
            this.run4();
         }

         var10000 = this;
      }

      Iterator var2;
      for(Iterator var3 = var2 = var10000.list.iterator(); var3.hasNext(); var3 = var2) {
         ((Setting)var2.next()).handleBool(var1);
      }

   }

   public ValueSettingSub9 getValueSettingSub9() {
      return this.valueSettingSub9;
   }

   protected void run4() {
   }

   public BooleanSetting getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public JsonElement getJsonElement() {
      JsonObject var1 = new JsonObject();
      if (this.valueSettingSub9 != null) {
         var1.add(this.valueSettingSub9.getString3(), this.valueSettingSub9.getJsonElement());
      }

      Iterator var4;
      Iterator var10000 = var4 = this.list.iterator();

      while(var10000.hasNext()) {
         Setting var3;
         if (!(var3 = (Setting)var4.next()).isEnabled3()) {
            var10000 = var4;
         } else {
            var1.add(var3.getString3(), var3.getJsonElement());
            var10000 = var4;
         }
      }

      return var1;
   }

   public List<Setting> getList2() {
      return this.list;
   }

   public List<Setting> getList3() {
      return this.list.stream().filter(Setting::isEnabled4).toList();
   }

   public boolean isEnabled6() {
      return this.valueSettingSub9 != null;
   }

   public boolean isEnabled136() {
      return this.bool;
   }

   public static void handleSetting(Setting var0, JsonObject var1) {
      if (var0.isEnabled3()) {
         JsonElement var4;
         if ((var4 = var1.get(var0.getString3())) != null && !var4.isJsonNull()) {
            try {
               var0.handleJsonElement(var4);
            } catch (RuntimeException var8) {
               Logger var5 = OnyxClient.LOGGER;
               Object[] var6 = new Object[2];
               String var7 = var0.getString4();
               var6[0] = var7;
               var6[1] = var8;
               var5.warn("Failed to load setting '{}'", var6);
            }
         } else {
            if (var0 instanceof BooleanSetting) {
               BooleanSetting var3;
               if ((var3 = (BooleanSetting)var0).getValueSettingSub9() != null) {
                  handleSetting(var3.getValueSettingSub9(), var1);
               }

               Iterator var9;
               for(Iterator var10000 = var9 = var3.getList2().iterator(); var10000.hasNext(); var10000 = var9) {
                  handleSetting((Setting)var9.next(), var1);
               }
            }

         }
      }
   }

   public void handleModule(Module var1, Setting var2) {
      super.handleModule(var1, var2);
      if (this.valueSettingSub9 != null) {
         this.valueSettingSub9.handleModule(var1, this);
      }

      this.list.clear();
      this.handleObject(this, BooleanSetting.class);
      this.list.sort(Comparator.comparingInt(Setting::getInt));
      HashSet var10 = new HashSet();

      Iterator var4;
      for(Iterator var10000 = var4 = this.list.iterator(); var10000.hasNext(); var10000 = var4) {
         Setting var5 = (Setting)var4.next();
         if (!var10.add(var5.getString3())) {
            Logger var6 = OnyxClient.LOGGER;
            Object[] var7 = new Object[2];
            String var8 = var5.getString3();
            var7[0] = var8;
            String var9 = this.getString4();
            var7[1] = var9;
            var6.warn("Duplicate setting name '{}' in group '{}'", var7);
         }

         var5.handleModule(var1, this);
      }

   }
}
