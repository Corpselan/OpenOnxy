package client.onyx.module.render;

import client.onyx.gui.GuiScreenImpl3;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.Util4;

public class ClickGUIModule extends Module {
   public ValueSettingSub6 valueSettingSub6 = new ValueSettingSub6("Accent", -10006364)
      .getValueSettingSub65()
      .getBooleanSetting("Seed colour the whole theme is generated from")
      .getModeSetting3(Util4::handleInt);
   public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Background tint", 25.0, 0.0, 100.0, 5.0)
      .getValueSettingSub10("%")
      .getBooleanSetting("How much the accent colours the panel background")
      .getModeSetting3(var0 -> Util4.handleFloat2(var0.floatValue() / 100.0F));
   public ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Scale", 1.0, 0.5, 1.5, 0.05)
      .getValueSettingSub10("x")
      .getBooleanSetting("Interface size")
      .getModeSetting3(var0 -> Util4.handleFloat(var0.floatValue()));
   public ValueSettingSub9 valueSettingSub9 = new ValueSettingSub9("Frosted glass", true)
      .getBooleanSetting("Blur the world behind the panel instead of the whole screen");

   @Override
   public boolean isEnabled54() {
      return false;
   }

   @Override
   protected void run80() {
      if (!(MINECRAFT.currentScreen instanceof GuiScreenImpl3)) {
         MINECRAFT.displayGuiScreen(new GuiScreenImpl3(this, MINECRAFT.currentScreen));
      }
   }

   @Override
   public boolean isEnabled56() {
      return false;
   }

   public ClickGUIModule() {
      super("ClickGUI", "Opens click GUI", ModuleCategory.RENDER);
      this.getNoneValueSetting2().handleObject2(54);
   }
}
