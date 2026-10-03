package client.onyx.setting.impl;

import client.onyx.setting.ValueSetting;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ValueSettingSub8<E extends Enum<E>> extends ValueSetting<List<E>> {
   private final Class<E> class_;
   private final List<E> list;

   @SafeVarargs
   public ValueSettingSub8(String var1, Class<E> var2, E... var3) {
      super(var1, List.of((E[])var3));
      this.class_ = var2;
      this.list = List.of((E[])var2.getEnumConstants());
   }

   public ValueSettingSub8<E> getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public boolean isEnabled16() {
      return this.lambda15().isEmpty();
   }

   public Class<E> getClass3() {
      return this.class_;
   }

   @Override
   public JsonElement getJsonElement() {
      JsonArray var1 = new JsonArray();
      Iterator var4;
      Iterator var10000 = var4 = this.lambda15().iterator();

      while (var10000.hasNext()) {
         Enum var3 = (Enum)var4.next();
         var10000 = var4;
         var1.add(new JsonPrimitive(var3.name()));
      }

      return var1;
   }

   public void handleEnum3(E var1) {
      ArrayList var3;
      if (!(var3 = new ArrayList<>(this.lambda15())).remove(var1)) {
         var3.add(var1);
      }

      this.handleObject2(var3);
   }

   public void handleEnum4(E var1, boolean var2) {
      if (this.isEnum2((E)var1) != var2) {
         this.handleEnum3((E)var1);
      }
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonArray()) {
         ArrayList var2 = new ArrayList();
         Iterator var6 = var1.getAsJsonArray().iterator();

         label37:
         while (true) {
            for (Iterator var10000 = var6; var10000.hasNext(); var10000 = var6) {
               JsonElement var3;
               if (!(var3 = (JsonElement)var6.next()).isJsonPrimitive()) {
                  continue label37;
               }

               if (var3.getAsJsonPrimitive().isString()) {
                  String var7 = var3.getAsString();
                  Iterator var4 = this.list.iterator();

                  while (var4.hasNext()) {
                     Enum var5;
                     if ((var5 = (Enum)var4.next()).name().equals(var7)) {
                        var2.add(var5);
                     }
                  }
                  continue label37;
               }
            }

            this.handleObject2(var2);
            return;
         }
      }
   }

   public boolean isEnum2(E var1) {
      return this.lambda15().contains(var1);
   }

   public List<E> getList8() {
      return this.list;
   }

   public ValueSettingSub8<E> getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public void handleInt5(int var1, int var2) {
      List var4 = this.lambda15();
      if (var1 >= 0 && var1 < var4.size()) {
         if ((var2 = Math.clamp((long)var2, 0, var4.size() - 1)) != var1) {
            ArrayList var7;
            Enum var5 = (Enum)(var7 = new ArrayList<>(var4)).remove(var1);
            var7.add(var2, var5);
            this.handleObject2(var7);
         }
      }
   }

   public <O> ValueSettingSub8<E> getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   protected List<E> getObject2(List<E> var1) {
      ArrayList var4 = new ArrayList();
      Iterator var5 = var1.iterator();

      while (var5.hasNext()) {
         Enum var3;
         if ((var3 = (Enum)var5.next()) != null && !var4.contains(var3)) {
            var4.add(var3);
         }
      }

      return List.copyOf(var4);
   }

   public ValueSettingSub8<E> getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public ValueSettingSub8<E> getModeSetting3(Consumer<List<E>> var1) {
      super.getModeSetting3(var1);
      return this;
   }
}
