package client.onyx.setting.impl;

import client.onyx.setting.ValueSetting;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ValueSettingSub10 extends ValueSetting<Double> {
   private String string3 = "";
   private final double double_;
   private final double double_2;
   private final double double_3;

   public ValueSettingSub10 getValueSettingSub10(String var1) {
      this.string3 = var1;
      return this;
   }

   protected Double getObject2(Double var1) {
      double var2 = Math.clamp(var1, this.double_2, this.double_);
      return this.double_3 <= 0.0
         ? var2
         : Math.round(Math.clamp(this.double_2 + Math.round((var2 - this.double_2) / this.double_3) * this.double_3, this.double_2, this.double_) * 1000000.0)
            / 1000000.0;
   }

   public String getString10() {
      return this.string3;
   }

   public void handleDouble3(double var1) {
      this.handleObject2(this.double_2 + Math.clamp(var1, 0.0, 1.0) * (this.double_ - this.double_2));
   }

   public <O> ValueSettingSub10 getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   public double getDouble13() {
      return this.double_2;
   }

   public double getDouble10() {
      return this.double_;
   }

   public int getInt10() {
      return (int)Math.round(this.lambda15());
   }

   public ValueSettingSub10 getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public ValueSettingSub10 getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public String getString11() {
      StringBuilder var10000 = new StringBuilder();
      String var10001;
      if (this.isEnabled18()) {
         var10001 = String.valueOf(this.getInt10());
      } else {
         Object[] var10002 = new Object[1];
         boolean var10004 = true;
         var10002[0] = this.lambda15();
         var10001 = String.format("%.2f", var10002);
      }

      return var10000.append(var10001).append(this.string3).toString();
   }

   public float getFloat5() {
      return this.lambda15().floatValue();
   }

   public double getDouble12() {
      return this.double_ == this.double_2 ? 0.0 : (this.lambda15() - this.double_2) / (this.double_ - this.double_2);
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isNumber()) {
         this.handleObject2(var1.getAsDouble());
      }
   }

   public ValueSettingSub10(String var1, double var2, double var4, double var6, double var8) {
      super(var1, var2);
      this.double_2 = var4;
      this.double_ = var6;
      this.double_3 = var8;
      this.handleObject2(this.getObject2(var2));
   }

   public boolean isEnabled18() {
      return this.double_3 >= 1.0 && this.double_3 == Math.floor(this.double_3);
   }

   @Override
   public JsonElement getJsonElement() {
      return new JsonPrimitive(this.lambda15());
   }

   public ValueSettingSub10 getModeSetting3(Consumer<Double> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   public ValueSettingSub10 getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public double getDouble11() {
      return this.double_3;
   }
}
