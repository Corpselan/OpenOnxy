package client.onyx.module.render;

import client.onyx.event.impl.EventSub11;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub10;
import meteordevelopment.orbit.EventHandler;

public class FullbrightModule extends Module {
   public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Gamma", 100.0, 1.0, 100.0, 1.0)
      .getBooleanSetting("Gamma to apply (vanilla max brightness is 1)");
   private float float_;

   @Override
   protected void run80() {
      this.float_ = MINECRAFT.gameSettings.gammaSetting;
      this.run87();
   }

   @Override
   protected void run79() {
      MINECRAFT.gameSettings.gammaSetting = this.float_;
   }

   @EventHandler
   private void handleEventSub112(EventSub11 var1) {
      this.run87();
   }

   private void run87() {
      MINECRAFT.gameSettings.gammaSetting = this.valueSettingSub10.getFloat5();
   }

   public FullbrightModule() {
      super("Fullbright", "Makes the world brighter", ModuleCategory.RENDER);
   }
}
