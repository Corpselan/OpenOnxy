package client.onyx.module.player.scaffold.watchdog;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub17;
import client.onyx.setting.ModeOption;
import client.onyx.util.Util2;
import meteordevelopment.orbit.EventHandler;

public class WatchdogModeOption extends ModeOption implements MinecraftAccess {
   public static final WatchdogModeOption WATCHDOG_MODE_OPTION = new WatchdogModeOption();
   private static final float FLOAT = 0.8F;

   private WatchdogModeOption() {
      super("Watchdog");
   }

   @EventHandler
   private void handleEventSub177(EventSub17 var1) {
      if (MINECRAFT.thePlayer != null) {
         if (MINECRAFT.gameSettings.keyBindJump.isKeyDown()) {
            if (MINECRAFT.thePlayer.onGround && !isEnabled127()) {
               MINECRAFT.thePlayer.jump();
            }

            if (Util2.getDoubleForEntity(MINECRAFT.thePlayer) == 0.0) {
               switch (Util2.getIntForEntityPlayerSP(MINECRAFT.thePlayer)) {
                  case 4:

                     MINECRAFT.thePlayer.motionY -= 0.03;
                     return;
                  case 5:
                     MINECRAFT.thePlayer.motionY -= 0.5;
                     return;
               }
            }
         }
      }
   }

   private static boolean isEnabled127() {
      return Math.abs(MINECRAFT.thePlayer.moveForward) >= 0.8F || Math.abs(MINECRAFT.thePlayer.moveStrafing) >= 0.8F;
   }
}
