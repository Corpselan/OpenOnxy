package client.onyx.event.impl;

import client.onyx.event.Event;

public class EventSub extends Event {
   private final double double_;
   private final double double_2;
   private final double double_3;

   public double getDouble() {
      return this.double_;
   }

   public double getDouble3() {
      return this.double_3;
   }

   public double getDouble2() {
      return this.double_2;
   }

   public EventSub(double var1, double var3, double var5) {
      this.double_3 = var1;
      this.double_ = var3;
      this.double_2 = var5;
   }
}
