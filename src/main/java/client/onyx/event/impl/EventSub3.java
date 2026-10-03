package client.onyx.event.impl;

import client.onyx.event.Event;

public class EventSub3 extends Event {
   private final int int_;
   private final Object object;

   public EventSub3(Object var1, int var2) {
      this.object = var1;
      this.int_ = var2;
   }

   public int getInt() {
      return this.int_;
   }

   public Object getObject() {
      return this.object;
   }
}
