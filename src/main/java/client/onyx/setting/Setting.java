package client.onyx.setting;

import client.onyx.MinecraftAccess;
import client.onyx.module.Module;
import com.google.gson.JsonElement;
import java.util.List;
import java.util.function.BooleanSupplier;

public abstract class Setting implements MinecraftAccess {
   private Module module;
   public static final BooleanSupplier BOOLEAN_SUPPLIER = () -> false;
   private final String string;
   private String string2;
   private final int int_2 = int_++;
   private Setting setting;
   static int int_ = 0;
   private BooleanSupplier booleanSupplier;

   public abstract JsonElement getJsonElement();

   public void handleBool(boolean var1) {
   }

   protected void run() {
      if (this.module != null) {
         this.module.run82();
      }
   }

   public String getString2() {
      return this.string2;
   }

   public int getInt() {
      return this.int_2;
   }

   public Setting getSetting() {
      return this.setting;
   }

   public String getString4() {
      return this.setting == null ? this.string : new StringBuilder().insert(0, this.setting.getString4()).append(".").append(this.string).toString();
   }

   public boolean isEnabled3() {
      return this.booleanSupplier != BOOLEAN_SUPPLIER;
   }

   public Setting getBooleanSetting(String var1) {
      this.string2 = var1;
      return this;
   }

   public Setting getSetting2(BooleanSupplier var1) {
      this.booleanSupplier = var1;
      return this;
   }

   public abstract void handleJsonElement(JsonElement var1);

   public boolean isEnabled4() {
      return this.booleanSupplier.getAsBoolean();
   }

   public void handleModule(Module var1, Setting var2) {
      this.module = var1;
      this.setting = var2;
   }

   protected Setting(String var1) {
      this.string2 = "";
      this.booleanSupplier = () -> true;
      this.string = var1;
   }

   public List<Setting> getList2() {
      return List.of();
   }

   public Module getModule() {
      return this.module;
   }

   public String getString3() {
      return this.string;
   }
}
