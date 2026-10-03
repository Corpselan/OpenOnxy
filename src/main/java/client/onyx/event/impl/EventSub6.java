package client.onyx.event.impl;

import client.onyx.event.Event;
import net.minecraft.client.multiplayer.WorldClient;

public class EventSub6 extends Event {
   private final WorldClient worldClient;

   public EventSub6(WorldClient var1) {
      this.worldClient = var1;
   }

   public WorldClient getWorldClient() {
      return this.worldClient;
   }
}
