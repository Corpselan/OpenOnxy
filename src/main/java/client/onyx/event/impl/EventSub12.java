package client.onyx.event.impl;

import client.onyx.event.Event;

public class EventSub12 extends Event {
   private boolean bool2 = false;

   public boolean isEnabled2() {
      return this.bool2;
   }

   public void handleBool(boolean var1) {
      this.bool2 = var1;
   }
}
