package client.onyx.module.player.scaffold.extra;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub4;
import client.onyx.setting.Setting;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.util.Util2;
import meteordevelopment.orbit.EventHandler;

public class DiagonalSpeedSettingGroup extends SettingGroup implements MinecraftAccess {
   public ValueSettingSub3 valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString("Straight speed", 0.48, 0.49, 0.1, 1.0);
   public static final DiagonalSpeedSettingGroup DIAGONAL_SPEED_SETTING_GROUP = new DiagonalSpeedSettingGroup();
   public ValueSettingSub3 valueSettingSub32 = ValueSettingSub3.getValueSettingSub3ForString("Diagonal speed", 0.48, 0.49, 0.1, 1.0);

   private DiagonalSpeedSettingGroup() {
      super("Strafe on jump", false);
      this.getSetting2(Setting.BOOLEAN_SUPPLIER);
   }

   @EventHandler
   private void handleEventSub44(EventSub4 var1) {
      if (MINECRAFT.thePlayer != null) {
         boolean var2 = (float)(Math.rint((Util2.getFloatForEntityPlayerSP3(MINECRAFT.thePlayer) + 180.0F) / 45.0F) * 45.0) % 90.0F == 0.0F;
         ValueSettingSub3 var3 = var2 ? this.valueSettingSub3 : this.valueSettingSub32;
         Util2.handleEntity3(MINECRAFT.thePlayer, Util2.getVec3ForVec34(Util2.getVec3ForEntity3(MINECRAFT.thePlayer), var3.getDouble()));
      }
   }
}
