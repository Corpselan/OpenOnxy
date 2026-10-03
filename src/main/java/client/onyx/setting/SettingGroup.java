package client.onyx.setting;

import java.util.function.BooleanSupplier;

public class SettingGroup extends BooleanSetting {
   protected SettingGroup(String var1) {
      this(var1, false);
   }

   protected SettingGroup(String var1, boolean var2) {
      super(var1, var2);
   }

   public SettingGroup getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public SettingGroup getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }
}
