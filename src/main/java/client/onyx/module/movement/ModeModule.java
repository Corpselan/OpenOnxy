package client.onyx.module.movement;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.movement.mode.SafeModeOption;
import client.onyx.module.movement.mode.SneakModeOption;
import client.onyx.setting.ModeOption;
import client.onyx.setting.ModeSetting;
import client.onyx.setting.NoneModeOption;

public class ModeModule extends Module {
   public ModeSetting<ModeOption> modeSetting = getModeSettingForString("Mode");

   public static ModeSetting<ModeOption> getModeSettingForString(String var0) {
      NoneModeOption var1 = new NoneModeOption();
      SafeModeOption var4 = new SafeModeOption();
      SneakModeOption var3 = new SneakModeOption();
      ModeOption[] var5 = new ModeOption[]{var1, var4, var3};
      return new ModeSetting<>(var0, var4, var5);
   }

   public ModeModule() {
      super("SafeWalk", "Prevents you from falling down as if you were sneaking", ModuleCategory.MOVEMENT);
   }
}
