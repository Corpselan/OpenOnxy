package client.onyx.setting.impl;

import client.onyx.setting.ValueSetting;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ValueSettingSub<E extends Enum<E>> extends ValueSetting<EnumSet<E>> {
   private final Class<E> class_;
   private final List<E> list;
   private boolean bool = true;

   public ValueSettingSub<E> getValueSettingSub(boolean var1) {
      this.bool = var1;
      return this;
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonArray()) {
         EnumSet var2 = EnumSet.noneOf(this.class_);
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
                        var2.add((E)var5);
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

   public void handleEnum2(E var1, boolean var2) {
      if (this.isEnum((E)var1) != var2) {
         this.handleEnum((E)var1);
      }
   }

   public <O> ValueSettingSub<E> getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   public boolean isEnum(E var1) {
      return this.lambda15().contains(var1);
   }

   public ValueSettingSub<E> getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public boolean isEnabled9() {
      return this.lambda15().isEmpty();
   }

   public Class<E> getClass2() {
      return this.class_;
   }

   public ValueSettingSub<E> getModeSetting3(Consumer<EnumSet<E>> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   public void handleEnum(E var1) {
      EnumSet var3;
      if (!(var3 = EnumSet.copyOf(this.lambda15())).remove(var1)) {
         var3.add((E)var1);
      }

      this.handleObject2(var3);
   }

   protected EnumSet<E> getObject2(EnumSet<E> var1) {
      return !this.bool && var1.isEmpty() && this.lambda15() != null ? this.lambda15() : EnumSet.copyOf(var1);
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

   public boolean isEnabled10() {
      return this.bool;
   }

   @SafeVarargs
   public ValueSettingSub(String var1, Class<E> var2, E... var3) {
      super(var1, var3.length == 0 ? EnumSet.noneOf(var2) : EnumSet.copyOf(List.of((E[])var3)));
      this.class_ = var2;
      this.list = List.of((E[])var2.getEnumConstants());
   }

   public List<E> getList6() {
      return this.list;
   }

   public ValueSettingSub<E> getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public ValueSettingSub<E> getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }
}
