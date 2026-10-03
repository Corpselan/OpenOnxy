package client.onyx.event.impl;

import client.onyx.event.Event;
import client.onyx.util.ForwardsBackwardsRecord;

public class EventSub13 extends Event {
   private final ForwardsBackwardsRecord forwardsBackwardsRecord;
   private boolean bool2;

   public ForwardsBackwardsRecord getForwardsBackwardsRecord() {
      return this.forwardsBackwardsRecord;
   }

   public void handleBool2(boolean var1) {
      this.bool2 = var1;
   }

   public boolean isEnabled3() {
      return this.bool2;
   }

   public EventSub13(ForwardsBackwardsRecord var1, boolean var2) {
      this.forwardsBackwardsRecord = var1;
      this.bool2 = var2;
   }
}
