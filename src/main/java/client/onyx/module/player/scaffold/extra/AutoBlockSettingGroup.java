package client.onyx.module.player.scaffold.extra;

import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;

public class AutoBlockSettingGroup extends SettingGroup {
   public static final AutoBlockSettingGroup AUTO_BLOCK_SETTING_GROUP = new AutoBlockSettingGroup();
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Always hold block", false)
      .getBooleanSetting("Keeps the block slot held server-side the whole time instead of swapping to it only on the tick a block goes out");
   public ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Slot reset delay", 5.0, 0.0, 40.0, 1.0)
      .getValueSettingSub10(" ticks")
      .getBooleanSetting("How long the silent slot is held after a placement before the real slot comes back");

   private AutoBlockSettingGroup() {
      super("Auto block", true);
      this.valueSettingSub10 = new ValueSettingSub10("Do not use below count", 1.0, 0.0, 64.0, 1.0)
         .getBooleanSetting("Leaves a stack alone once it is down to this many blocks");
   }
}
