package client.onyx.setting.impl;

import client.onyx.setting.ValueSetting;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ValueSettingSub9 extends ValueSetting<Boolean> {
   public ValueSettingSub9 getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public ValueSettingSub9(String var1, boolean var2) {
      super(var1, var2);
   }

   public void run10() {
      this.handleObject2(!this.lambda15());
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isBoolean()) {
         this.handleObject2(var1.getAsBoolean());
      }
   }

   @Override
   public JsonElement getJsonElement() {
      return new JsonPrimitive(this.lambda15());
   }

   public ValueSettingSub9 getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public ValueSettingSub9 getModeSetting3(Consumer<Boolean> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   public ValueSettingSub9 getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public boolean isEnabled17() {
      return this.lambda15();
   }

   public <O> ValueSettingSub9 getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }
}
