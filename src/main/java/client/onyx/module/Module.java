package client.onyx.module;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.setting.Setting;
import client.onyx.setting.Util;
import client.onyx.setting.impl.NoneValueSetting;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.util.Iface;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.Logger;

public class Module implements MinecraftAccess, Iface {
   private final ValueSettingSub11<ToggleHoldEnum> valueSettingSub11;
   private final String string;
   private final NoneValueSetting noneValueSetting = new NoneValueSetting("Bind");
   private final List<Setting> list;
   private boolean bool;
   private final String string2;
   private final ModuleCategory moduleCategory;

   public boolean isEnabled56() {
      return true;
   }

   public ModuleCategory getModuleCategory() {
      return this.moduleCategory;
   }

   public boolean isEnabled54() {
      return true;
   }

   private void handleObject3(Object var1, Class<?> var2) {
      Class var7;
      for (Class var10000 = var7 = var1.getClass(); var10000 != null && var7 != var2; var10000 = var7 = var7.getSuperclass()) {
         Field[] var4;
         int var5 = (var4 = var7.getDeclaredFields()).length;

         int var6;
         for (int var14 = var6 = 0; var14 < var5; var14 = ++var6) {
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
         }
      }
   }

   public ValueSettingSub11<ToggleHoldEnum> getValueSettingSub112() {
      return this.valueSettingSub11;
   }

   public boolean isEnabled55() {
      return this.bool;
   }

   @Override
   public boolean isEnabled136() {
      return this.bool;
   }

   public void handleBool16(boolean var1) {
      if (this.bool != var1) {
         this.lambda35();
      }
   }

   public Module(String var1, String var2, ModuleCategory var3) {
      this.valueSettingSub11 = new ValueSettingSub11<>("Bind Mode", ToggleHoldEnum.TOGGLE);
      this.list = new ArrayList<>();
      this.bool = false;
      this.string2 = var1;
      this.string = var2;
      this.moduleCategory = var3;
   }

   public void lambda35() {
      Util.handleObject(null, this::lambda35, this::lambda35);
      if (this.bool) {
         this.bool = false;
         this.run82();
         this.run79();
         OnyxClient.I_EVENT_BUS.unsubscribe(this);
      } else {
         this.bool = true;
         OnyxClient.I_EVENT_BUS.subscribe(this);
         this.run80();
         this.run82();
      }
   }

   public String getString18() {
      return this.string;
   }

   public List<Setting> getList12() {
      return this.list.stream().filter(Setting::isEnabled4).toList();
   }

   public String getString20() {
      return this.string2;
   }

   public String getString19() {
      return null;
   }

   public void run82() {
      Iterator var2;
      for (Iterator var10000 = var2 = this.list.iterator(); var10000.hasNext(); var10000 = var2) {
         ((Setting)var2.next()).handleBool(this.bool);
      }
   }

   public NoneValueSetting getNoneValueSetting2() {
      return this.noneValueSetting;
   }

   public List<Setting> getList11() {
      return this.list;
   }

   protected void run79() {
   }

   public void run81() {
      this.noneValueSetting.handleModule(this, null);
      this.valueSettingSub11.handleModule(this, null);
      if (this.isEnabled56()) {
         NoneValueSetting var6 = this.noneValueSetting.getNoneValueSetting(this.valueSettingSub11);
      }

      this.list.clear();
      this.handleObject3(this, Module.class);
      this.list.sort(Comparator.comparingInt(Setting::getInt));
      HashSet var1 = new HashSet();

      Iterator var2;
      for (Iterator var10000 = var2 = this.list.iterator(); var10000.hasNext(); var10000 = var2) {
         Setting var4 = (Setting)var2.next();
         if (!var1.add(var4.getString3())) {
            Logger var7 = OnyxClient.LOGGER;
            Object[] var8 = new Object[2];
            String var9 = var4.getString3();
            var8[0] = var9;
            var8[1] = this.string2;
            var7.warn("Duplicate setting name '{}' in module '{}'", var8);
         }

         var4.handleModule(this, null);
      }
   }

   protected void run80() {
   }
}
