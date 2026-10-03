package client.onyx.module.movement;

import client.onyx.event.impl.EventSub11;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import meteordevelopment.orbit.EventHandler;

public class AutoSprintModule extends Module {
   public AutoSprintModule() {
      super("AutoSprint", "Automatically sprints for you", ModuleCategory.MOVEMENT);
   }

   @Override
   protected void run79() {
      MINECRAFT.gameSettings.keyBindSprint.setPressed(false);
      if (MINECRAFT.thePlayer != null) {
         MINECRAFT.thePlayer.setSprinting(false);
      }
   }

   @EventHandler
   public void handleEventSub116(EventSub11 var1) {
      MINECRAFT.gameSettings.keyBindSprint.setPressed(true);
   }
}
