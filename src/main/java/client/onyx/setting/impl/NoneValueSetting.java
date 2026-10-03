package client.onyx.setting.impl;

import client.onyx.module.ToggleHoldEnum;
import client.onyx.setting.ValueSetting;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class NoneValueSetting extends ValueSetting<Integer> {
   public static final int INT = 0;
   private ValueSettingSub11<ToggleHoldEnum> valueSettingSub11;

   public boolean isInt3(int var1) {
      return this.isEnabled19() && this.lambda15() < 0 && this.lambda15() == -var1 - 1;
   }

   public NoneValueSetting getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public boolean isInt2(int var1) {
      return this.isEnabled19() && this.lambda15() == var1;
   }

   public <O> NoneValueSetting getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   public int getInt11() {
      return this.isEnabled20() ? -this.lambda15() - 1 : -1;
   }

   @Override
   public JsonElement getJsonElement() {
      return new JsonPrimitive(this.lambda15());
   }

   public NoneValueSetting getModeSetting3(Consumer<Integer> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   public boolean isEnabled22() {
      if (this.isEnabled21()) {
         return Keyboard.isKeyDown(this.getInt12());
      } else {
         return this.isEnabled20() ? Mouse.isButtonDown(this.getInt11()) : false;
      }
   }

   public void run11() {
      this.handleObject2(0);
   }

   public int getInt12() {
      return this.isEnabled21() ? this.lambda15() : 0;
   }

   public NoneValueSetting(String var1, int var2) {
      super(var1, var2);
   }

   public NoneValueSetting getNoneValueSetting(ValueSettingSub11<ToggleHoldEnum> var1) {
      this.valueSettingSub11 = var1;
      return this;
   }

   public NoneValueSetting getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public ValueSettingSub11<ToggleHoldEnum> getValueSettingSub11() {
      return this.valueSettingSub11;
   }

   public void handleInt7(int var1) {
      if (var1 == 0) {
         this.run11();
      } else {
         if (var1 > 0) {
            this.handleObject2(var1);
         }
      }
   }

   public boolean isEnabled21() {
      return this.isEnabled19() && this.lambda15() > 0;
   }

   public boolean isEnabled19() {
      return this.lambda15() != 0;
   }

   public String getString12() {
      if (!this.isEnabled19()) {
         return "None";
      } else if (this.isEnabled21()) {
         String var3;
         return (var3 = Keyboard.getKeyName(this.lambda15())) == null ? "None" : var3;
      } else {
         int var2;
         switch (var2 = this.getInt11()) {
            case 0:

               return "LMB";
            case 1:
               return "RMB";
            case 2:
               return "MMB";
            case 3:
               return "Mouse 4";
            case 4:
               return "Mouse 5";
            default:
               return new StringBuilder().insert(0, "Mouse ").append(var2 + 1).toString();
         }
      }
   }

   public NoneValueSetting(String var1) {
      this(var1, 0);
   }

   public boolean isEnabled20() {
      return this.isEnabled19() && this.lambda15() < 0;
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isNumber()) {
         this.handleObject2(var1.getAsInt());
      }
   }

   public NoneValueSetting getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public void handleInt6(int var1) {
      if (var1 >= 0) {
         this.handleObject2(-var1 - 1);
      }
   }
}
