package client.onyx.event.impl;

import client.onyx.event.Event;

public class EventSub15 extends Event {
   private float float_;
   private float float_2;

   public void handleFloat2(float var1) {
      this.float_ = var1;
   }

   public float getFloat4() {
      return this.float_;
   }

   public float getFloat3() {
      return this.float_2;
   }

   public EventSub15(float var1, float var2) {
      this.float_2 = var1;
      this.float_ = var2;
   }

   public void handleFloat(float var1) {
      this.float_2 = var1;
   }
}
