package client.onyx.setting;

import java.util.function.BooleanSupplier;

public class ModeOption extends BooleanSetting {
   private transient ModeSetting<?> modeSetting;

   public ModeOption getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public boolean isEnabled8() {
      return this.modeSetting != null && this.modeSetting.lambda15() == this;
   }

   void handleModeSetting(ModeSetting<?> var1) {
      this.modeSetting = var1;
   }

   protected ModeOption(String var1) {
      super(var1);
   }

   public void run6() {
      if (this.modeSetting != null) {
         this.modeSetting.handleModeOption(this);
      }
   }

   public ModeOption getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }
}
