package client.onyx.module.movement.mode;

import client.onyx.event.impl.EventSub12;
import client.onyx.setting.ModeOption;
import meteordevelopment.orbit.EventHandler;

public class SafeModeOption extends ModeOption {
   @EventHandler
   private void handleEventSub12(EventSub12 var1) {
      var1.handleBool(true);
   }

   public SafeModeOption() {
      super("Safe");
   }
}
