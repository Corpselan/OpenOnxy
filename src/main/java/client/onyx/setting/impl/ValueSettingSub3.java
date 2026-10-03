package client.onyx.setting.impl;

import client.onyx.setting.MinMaxRecord;
import client.onyx.setting.ValueSetting;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ValueSettingSub3 extends ValueSetting<MinMaxRecord> {
   private final double double_;
   private final double double_2;
   private final double double_3;
   private String string3 = "";

   public static ValueSettingSub3 getValueSettingSub3ForString2(String var0, int var1, int var2, int var3, int var4) {
      return new ValueSettingSub3(var0, var1, var2, var3, var4, 1.0);
   }

   public float getFloat2() {
      return (float)this.lambda15().max();
   }

   public double getDouble8() {
      return this.lambda15().min();
   }

   protected MinMaxRecord getObject2(MinMaxRecord var1) {
      return new MinMaxRecord(this.getDouble7(var1.min()), this.getDouble7(var1.max()));
   }

   public <O> ValueSettingSub3 getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   public double getDouble3() {
      return this.double_2;
   }

   public ValueSettingSub3 getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public float getFloat4() {
      return (float)this.lambda15().min();
   }

   public ValueSettingSub3 getValueSettingSub3(String var1) {
      this.string3 = var1;
      return this;
   }

   public int getInt4() {
      MinMaxRecord var10000 = this.lambda15();
      int var3 = (int)Math.round(var10000.min());
      int var2;
      return (var2 = (int)Math.round(var10000.max())) <= var3 ? var3 : ThreadLocalRandom.current().nextInt(var3, var2 + 1);
   }

   public String getString7() {
      if (this.isEnabled11()) {
         return this.getInt3() == this.getInt2() ? this.getInt3() + this.string3 : this.getInt3() + this.string3 + " - " + this.getInt2() + this.string3;
      } else {
         Object[] var10001 = new Object[1];
         boolean var10003 = true;
         var10001[0] = this.getDouble8();
         String var3 = String.format("%.2f", var10001);
         var10001 = new Object[1];
         var10003 = true;
         var10001[0] = this.getDouble6();
         String var2 = String.format("%.2f", var10001);
         boolean var10000 = var3.equals(var2);
         StringBuilder var10002;
         if (var10000) {
            var10002 = new StringBuilder();
            return var10002.insert(0, var3).append(this.string3).toString();
         } else {
            var10002 = new StringBuilder();
            return var10002.insert(0, var3).append(this.string3).append(" - ").append(var2).append(this.string3).toString();
         }
      }
   }

   public double getDouble2(double var1) {
      return this.getDouble7(this.double_ + Math.clamp(var1, 0.0, 1.0) * (this.double_2 - this.double_));
   }

   public ValueSettingSub3 getModeSetting3(Consumer<MinMaxRecord> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   public void handleDouble2(double var1) {
      this.handleObject2(new MinMaxRecord(this.getDouble8(), Math.max(this.getDouble7(var1), this.getDouble8())));
   }

   public int getInt2() {
      return (int)Math.round(this.lambda15().max());
   }

   public void handleDouble(double var1) {
      this.handleObject2(new MinMaxRecord(Math.min(this.getDouble7(var1), this.getDouble6()), this.getDouble6()));
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonObject()) {
         JsonObject var10000 = var1.getAsJsonObject();
         var1 = var10000.get("min");
         JsonElement var2 = var10000.get("max");
         if (var1 != null && var2 != null && var1.isJsonPrimitive() && var2.isJsonPrimitive()) {
            if (var1.getAsJsonPrimitive().isNumber() && var2.getAsJsonPrimitive().isNumber()) {
               this.handleObject2(new MinMaxRecord(var1.getAsDouble(), var2.getAsDouble()));
            }
         }
      }
   }

   public int getInt3() {
      return (int)Math.round(this.lambda15().min());
   }

   private double getDouble7(double var1) {
      var1 = Math.clamp(var1, this.double_, this.double_2);
      return this.double_3 <= 0.0
         ? var1
         : Math.round(Math.clamp(this.double_ + Math.round((var1 - this.double_) / this.double_3) * this.double_3, this.double_, this.double_2) * 1000000.0)
            / 1000000.0;
   }

   @Override
   public JsonElement getJsonElement() {
      JsonObject var2 = new JsonObject();
      var2.addProperty("min", this.getDouble8());
      var2.addProperty("max", this.getDouble6());
      return var2;
   }

   public float getFloat3() {
      return (float)this.getDouble();
   }

   public static ValueSettingSub3 getValueSettingSub3ForString(String var0, double var1, double var3, double var5, double var7) {
      return new ValueSettingSub3(var0, var1, var3, var5, var7, 0.01);
   }

   public double getDouble9() {
      return this.double_;
   }

   public ValueSettingSub3 getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public double getDouble() {
      MinMaxRecord var2;
      return (var2 = this.lambda15()).getDouble() <= 0.0 ? var2.min() : ThreadLocalRandom.current().nextDouble(var2.min(), var2.max());
   }

   public ValueSettingSub3(String var1, double var2, double var4, double var6, double var8, double var10) {
      super(var1, new MinMaxRecord(var2, var4));
      this.double_ = var6;
      this.double_2 = var8;
      this.double_3 = var10;
      this.handleObject2(this.getObject2(this.lambda15()));
   }

   public String getString8() {
      return this.string3;
   }

   public ValueSettingSub3 getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public double getDouble6() {
      return this.lambda15().max();
   }

   public boolean isEnabled11() {
      return this.double_3 >= 1.0 && this.double_3 == Math.floor(this.double_3);
   }

   public double getDouble4() {
      return this.double_3;
   }

   public double getDouble5(double var1) {
      return this.double_2 == this.double_ ? 0.0 : (var1 - this.double_) / (this.double_2 - this.double_);
   }
}
