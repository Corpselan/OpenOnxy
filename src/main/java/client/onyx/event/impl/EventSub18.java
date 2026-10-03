package client.onyx.event.impl;

import client.onyx.event.Event;

public class EventSub18 extends Event {
   private final int int_;
   private final int int_2;
   private final int int_3;

   public int getInt2() {
      return this.int_;
   }

   public int getInt4() {
      return this.int_2;
   }

   public int getInt3() {
      return this.int_3;
   }

   public EventSub18(int var1, int var2, int var3) {
      this.int_2 = var1;
      this.int_ = var2;
      this.int_3 = var3;
   }
}
