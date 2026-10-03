package client.onyx.setting.impl;

import client.onyx.setting.DisplayNamed;
import client.onyx.setting.ValueSetting;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ValueSettingSub11<E extends Enum<E>> extends ValueSetting<E> {
   private final List<E> list;

   @SafeVarargs
   public ValueSettingSub11(String var1, E var2, E... var3) {
      super(var1, (E)var2);
      this.list = List.of((E[])var3);
      if (!this.list.contains(var2)) {
         throw new IllegalArgumentException(
            new StringBuilder().insert(0, "Default '").append(var2).append("' is not offered by '").append(var1).append("'").toString()
         );
      }
   }

   public <O> ValueSettingSub11<E> getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   public static String getStringForEnum(Enum<?> var0) {
      if (var0 instanceof DisplayNamed var7) {
         return var7.getString5();
      } else {
         StringBuilder var6 = new StringBuilder(var0.name().length());
         String[] var5;
         int var4 = (var5 = var0.name().toLowerCase().split("_")).length;

         int var3;
         for (int var10000 = var3 = 0; var10000 < var4; var10000 = ++var3) {
            String var2;
            if (!(var2 = var5[var3]).isEmpty()) {
               StringBuilder var9;
               if (var6.isEmpty()) {
                  var6.append(Character.toUpperCase(var2.charAt(0)));
                  var9 = var6;
               } else {
                  var6.append(' ').append(var2.charAt(0));
                  var9 = var6;
               }

               var9.append(var2, 1, var2.length());
            }
         }

         return var6.toString();
      }
   }

   @Override
   public JsonElement getJsonElement() {
      return new JsonPrimitive(this.lambda15().name());
   }

   public ValueSettingSub11(String var1, E var2) {
      super(var1, (E)var2);
      this.list = List.of((E[])var2.getDeclaringClass().getEnumConstants());
   }

   public ValueSettingSub11<E> getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isString()) {
         String var4 = var1.getAsString();
         Iterator var2 = this.list.iterator();

         while (var2.hasNext()) {
            Enum var3;
            if ((var3 = (Enum)var2.next()).name().equals(var4)) {
               this.handleObject2((E)var3);
               return;
            }
         }
      }
   }

   public ValueSettingSub11<E> getModeSetting3(Consumer<E> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   public List<E> getList9() {
      return this.list;
   }

   public ValueSettingSub11<E> getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public boolean isEnum3(E var1) {
      return this.lambda15() == var1;
   }

   public void run12() {
      List var1 = this.list;
      List var2 = this.list;
      Object var3 = this.lambda15();
      int var5 = var2.indexOf(var3) + 1;
      int var6 = this.list.size();
      int var7 = var5 % var6;
      Enum var9 = (Enum)var1.get(var7);
      this.handleObject2((E)var9);
   }

   public ValueSettingSub11<E> getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }
}
