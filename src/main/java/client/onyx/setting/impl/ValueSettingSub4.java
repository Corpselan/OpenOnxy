package client.onyx.setting.impl;

import client.onyx.setting.ValueSetting;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ValueSettingSub4 extends ValueSetting<String> {
   public ValueSettingSub4 getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   @Override
   public JsonElement getJsonElement() {
      return new JsonPrimitive(this.lambda15());
   }

   public ValueSettingSub4 getModeSetting3(Consumer<String> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   public ValueSettingSub4 getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public ValueSettingSub4 getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public ValueSettingSub4(String var1, String var2) {
      super(var1, var2);
   }

   public <O> ValueSettingSub4 getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   protected String getObject2(String var1) {
      return var1 == null ? "" : var1;
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isString()) {
         this.handleObject2(var1.getAsString());
      }
   }
}
