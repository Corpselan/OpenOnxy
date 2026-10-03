package client.onyx.setting.impl;

import client.onyx.setting.Setting;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import java.util.function.BooleanSupplier;

public class SettingSub extends Setting {
   private final Runnable runnable;
   private String string3;

   public SettingSub getSettingSub(String var1) {
      this.string3 = var1;
      return this;
   }

   @Override
   public JsonElement getJsonElement() {
      return JsonNull.INSTANCE;
   }

   public SettingSub getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public SettingSub getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public String getString6() {
      return this.string3;
   }

   public SettingSub(String var1, Runnable var2) {
      super(var1);
      this.runnable = var2;
      this.string3 = var1;
   }

   @Override
   public void handleJsonElement(JsonElement var1) {
   }

   public void run7() {
      this.runnable.run();
   }
}
