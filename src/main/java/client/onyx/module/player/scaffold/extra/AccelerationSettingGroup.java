package client.onyx.module.player.scaffold.extra;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub2;
import client.onyx.setting.Setting;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.util.Util2;
import client.onyx.util.Util6;
import meteordevelopment.orbit.EventHandler;

public class AccelerationSettingGroup extends SettingGroup implements MinecraftAccess {
   public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Speed multiplier", 0.6, 0.1, 3.0, 0.01);
   public ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Only on ground", false);
   public static final AccelerationSettingGroup ACCELERATION_SETTING_GROUP = new AccelerationSettingGroup();

   @EventHandler
   private void handleEventSub28(EventSub2 var1) {
      if (MINECRAFT.thePlayer != null) {
         if (!this.valueSettingSub92.lambda15() || MINECRAFT.thePlayer.onGround) {
            double var2 = this.valueSettingSub10.getFloat5();
            Util2.handleEntity3(MINECRAFT.thePlayer, Util6.getVec3ForVec37(Util2.getVec3ForEntity3(MINECRAFT.thePlayer), var2, 1.0, var2));
         }
      }
   }

   private AccelerationSettingGroup() {
      super("Acceleration", false);
      this.getSetting2(Setting.BOOLEAN_SUPPLIER);
   }
}
