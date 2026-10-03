package client.onyx.module.player.scaffold.mode.settings;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub12;
import client.onyx.event.impl.EventSub16;
import client.onyx.interact.Util;
import client.onyx.setting.Setting;
import client.onyx.setting.SettingGroup;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.BlockPos;

public class DownSettingGroup extends SettingGroup implements MinecraftAccess {
   public static final DownSettingGroup DOWN_SETTING_GROUP = new DownSettingGroup();

   private DownSettingGroup() {
      super("Down", false);
      this.getSetting2(Setting.BOOLEAN_SUPPLIER);
   }

   public static boolean isEnabled133() {
      return MINECRAFT.thePlayer == null ? false : isEnabled132() && Util.isBlockPos(new BlockPos(MINECRAFT.thePlayer).add(0, -2, 0));
   }

   public static boolean isEnabled132() {
      return DOWN_SETTING_GROUP.isEnabled5() && MINECRAFT.gameSettings.keyBindSneak.isKeyDown();
   }

   @EventHandler(
      priority = -100
   )
   private void handleEventSub122(EventSub12 var1) {
      if (isEnabled133()) {
         var1.handleBool(false);
      }
   }

   @EventHandler(
      priority = -100
   )
   private void handleEventSub1614(EventSub16 var1) {
      if (isEnabled133()) {
         var1.handleBool4(false);
      }
   }
}
