package client.onyx.event.impl;

import client.onyx.event.Event;
import client.onyx.util.ForwardsBackwardsRecord;

public class EventSub16 extends Event {
   private boolean bool2;
   private boolean bool3;
   private ForwardsBackwardsRecord forwardsBackwardsRecord;

   public void handleBool4(boolean var1) {
      this.bool2 = var1;
   }

   public EventSub16(ForwardsBackwardsRecord var1, boolean var2, boolean var3) {
      this.forwardsBackwardsRecord = var1;
      this.bool3 = var2;
      this.bool2 = var3;
   }

   public boolean isEnabled5() {
      return this.bool3;
   }

   public ForwardsBackwardsRecord getForwardsBackwardsRecord2() {
      return this.forwardsBackwardsRecord;
   }

   public void handleForwardsBackwardsRecord(ForwardsBackwardsRecord var1) {
      this.forwardsBackwardsRecord = var1;
   }

   public void handleBool3(boolean var1) {
      this.bool3 = var1;
   }

   public boolean isEnabled6() {
      return this.bool2;
   }
}
