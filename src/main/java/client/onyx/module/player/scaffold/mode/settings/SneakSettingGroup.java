package client.onyx.module.player.scaffold.mode.settings;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub16;
import client.onyx.setting.Cls;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.Util2;
import meteordevelopment.orbit.EventHandler;

public class SneakSettingGroup extends SettingGroup implements MinecraftAccess {
   private final transient Cls cls;
   private transient int int_3;
   public ValueSettingSub3 valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString2("Blocks to sneak", 0, 0, 0, 10)
      .getBooleanSetting("How many blocks to place between sneaks");
   private final transient Cls cls2;
   public ValueSettingSub3 valueSettingSub32 = ValueSettingSub3.getValueSettingSub3ForString("Edge distance", 0.01, 0.05, 0.01, 1.3)
      .getValueSettingSub3(" blocks");
   public ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Only on ground", true);
   public static final SneakSettingGroup SNEAK_SETTING_GROUP = new SneakSettingGroup();

   public void run164() {
      if (this.isEnabled5()) {
         this.int_3++;
         if (this.int_3 > this.cls2.getInt()) {
            this.int_3 = 0;
            this.cls2.run();
            this.cls.run();
         }
      }
   }

   @EventHandler(
      priority = -50
   )
   private void handleEventSub1613(EventSub16 var1) {
      if (!var1.isEnabled6() && this.isForwardsBackwardsRecord(var1.getForwardsBackwardsRecord2())) {
         var1.handleBool4(true);
      }
   }

   private SneakSettingGroup() {
      super("Sneak", false);
      this.cls2 = new Cls(this.valueSettingSub3);
      this.cls = new Cls(this.valueSettingSub32);
   }

   public boolean isForwardsBackwardsRecord(ForwardsBackwardsRecord var1) {
      if (MINECRAFT.thePlayer == null) {
         return false;
      } else if (DownSettingGroup.isEnabled133()) {
         return false;
      } else if (!MINECRAFT.thePlayer.onGround && this.valueSettingSub92.lambda15()) {
         return false;
      } else {
         boolean var3 = !MINECRAFT.thePlayer.capabilities.isFlying && this.int_3 == 0;
         return var3 && Util2.isEntityPlayerSP3(MINECRAFT.thePlayer, var1, this.cls.getDouble());
      }
   }
}
