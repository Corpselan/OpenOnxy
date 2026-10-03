package client.onyx.module.player.scaffold.mode.settings;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub16;
import client.onyx.event.impl.EventSub2;
import client.onyx.event.impl.EventSub4;
import client.onyx.module.player.DelayModule;
import client.onyx.rotation.Cls;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.util.Util2;
import meteordevelopment.orbit.EventHandler;

public class TellySettingGroup extends SettingGroup implements MinecraftAccess {
   private transient int int_3;
   private transient int int_4;
   public ValueSettingSub3 valueSettingSub3;
   public static final TellySettingGroup TELLY_SETTING_GROUP = new TellySettingGroup();
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub11<TellySettingGroup.ReverseResetEnum> valueSettingSub11 = new ValueSettingSub11<>(
         "Jump aim", TellySettingGroup.ReverseResetEnum.RESET
      )
      .getBooleanSetting("What the aim does while the jump goes out: keep the spoofed aim pitched down, or hand it back to your real look");

   private TellySettingGroup() {
      super("Telly", false);
      this.valueSettingSub10 = new ValueSettingSub10("Straight ticks", 0.0, 0.0, 5.0, 1.0)
         .getValueSettingSub10(" ticks")
         .getBooleanSetting("Air ticks after the jump during which the aim stays straight ahead");
      this.valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString2("Jump delay", 0, 0, 0, 10)
         .getValueSettingSub3(" ticks")
         .getBooleanSetting("Ground ticks to wait between jumps");
      this.int_4 = this.valueSettingSub3.getInt4();
   }

   @EventHandler
   private void handleEventSub27(EventSub2 var1) {
      if (MINECRAFT.thePlayer != null) {
         if (MINECRAFT.thePlayer.onGround) {
            int var3 = this.int_3 + 1;
            this.int_3 = var3;
         }
      }
   }

   public boolean isEnabled131() {
      return Util2.getIntForEntityPlayerSP(MINECRAFT.thePlayer) <= this.valueSettingSub10.getInt10() && this.int_3 >= this.int_4;
   }

   public boolean isEnabled130() {
      return this.int_3 >= this.int_4 && Util2.isEntityPlayerSP(MINECRAFT.thePlayer) && this.isEnabled5();
   }

   @EventHandler
   private void handleEventSub43(EventSub4 var1) {
      this.int_3 = 0;
      this.int_4 = this.valueSettingSub3.getInt4();
   }

   @Override
   protected void run3() {
      this.int_3 = 0;
      this.int_4 = this.valueSettingSub3.getInt4();
   }

   @EventHandler
   private void handleEventSub1612(EventSub16 var1) {
      if (MINECRAFT.thePlayer != null) {
         if (Util2.isEntityPlayerSP(MINECRAFT.thePlayer) && DelayModule.DELAY_MODULE.getInt48() > 0 && MINECRAFT.thePlayer.onGround) {
            boolean var3 = Cls.CLS.getYawPitchRecord() == null || this.valueSettingSub10.getInt10() == 0;
            switch ((TellySettingGroup.ReverseResetEnum)this.valueSettingSub11.lambda15()) {
               case REVERSE:

                  var1.handleBool3(true);
                  return;
               case RESET:
                  if (var3 && this.int_3 >= this.int_4) {
                     var1.handleBool3(true);
                  }
            }
         }
      }
   }

   public static enum ReverseResetEnum implements DisplayNamed {
      REVERSE("Look down"),
      RESET("Free look");
      private final String string;

      @Override
      public String getString5() {
         return this.string;
      }

      private ReverseResetEnum(String var3) {
         this.string = var3;
      }

   }
}
