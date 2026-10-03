package client.onyx.setting.impl;

import client.onyx.setting.ValueSetting;
import client.onyx.util.Cls6;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.item.ItemStack;

public class ValueSettingSub5 extends ValueSetting<List<Cls6>> {
   public ValueSettingSub5 getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public void handleCls6(Cls6 var1) {
      if (this.isCls6(var1)) {
         this.handleCls62(var1);
      } else {
         this.handleCls63(var1);
      }
   }

   public ValueSettingSub5 getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public ValueSettingSub5(String var1, String... var2) {
      super(var1, getListForStringArray(var2));
   }

   public boolean isItemStack(ItemStack var1) {
      Iterator var3 = this.lambda15().iterator();

      while (var3.hasNext()) {
         if (((Cls6)var3.next()).isItemStack(var1)) {
            return true;
         }
      }

      return false;
   }

   public void handleCls63(Cls6 var1) {
      if (var1 != null && !this.isCls6(var1)) {
         ArrayList var2;
         (var2 = new ArrayList<>(this.lambda15())).add(var1);
         this.handleObject2(var2);
      }
   }

   private static List<Cls6> getListForStringArray(String... var0) {
      ArrayList var6 = new ArrayList();
      String[] var5 = var0;
      int var4 = var0.length;

      int var3;
      for (int var10000 = var3 = 0; var10000 < var4; var10000 = ++var3) {
         Cls6 var2;
         if ((var2 = Cls6.getCls6ForString2(var5[var3])) != null && !var6.contains(var2)) {
            var6.add(var2);
         }
      }

      return var6;
   }

   public ValueSettingSub5 getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public ValueSettingSub5 getModeSetting3(Consumer<List<Cls6>> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   @Override
   public JsonElement getJsonElement() {
      JsonArray var1 = new JsonArray();
      Iterator var4;
      Iterator var10000 = var4 = this.lambda15().iterator();

      while (var10000.hasNext()) {
         Cls6 var3 = (Cls6)var4.next();
         var10000 = var4;
         var1.add(new JsonPrimitive(var3.getString2()));
      }

      return var1;
   }

   protected List<Cls6> getObject2(List<Cls6> var1) {
      ArrayList var4 = new ArrayList();
      if (var1 == null) {
         return var4;
      } else {
         Iterator var5 = var1.iterator();

         while (var5.hasNext()) {
            Cls6 var3;
            if ((var3 = (Cls6)var5.next()) != null && !var4.contains(var3)) {
               var4.add(var3);
            }
         }

         return var4;
      }
   }

   public <O> ValueSettingSub5 getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonArray()) {
         ArrayList var2 = new ArrayList();
         Iterator var5 = var1.getAsJsonArray().iterator();

         label31:
         while (true) {
            for (Iterator var10000 = var5; var10000.hasNext(); var10000 = var5) {
               JsonElement var4;
               if (!(var4 = (JsonElement)var5.next()).isJsonPrimitive()) {
                  continue label31;
               }

               if (var4.getAsJsonPrimitive().isString()) {
                  Cls6 var6;
                  if ((var6 = Cls6.getCls6ForString2(var4.getAsString())) != null && !var2.contains(var6)) {
                     var2.add(var6);
                  }
                  continue label31;
               }
            }

            this.handleObject2(var2);
            return;
         }
      }
   }

   public void handleCls62(Cls6 var1) {
      if (var1 != null && this.isCls6(var1)) {
         ArrayList var2;
         (var2 = new ArrayList<>(this.lambda15())).remove(var1);
         this.handleObject2(var2);
      }
   }

   public boolean isCls6(Cls6 var1) {
      return this.lambda15().contains(var1);
   }

   public void run8() {
      ArrayList var1 = new ArrayList();
      this.handleObject2(var1);
   }
}
