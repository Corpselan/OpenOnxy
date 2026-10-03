package client.onyx.event.impl;

import client.onyx.event.Event;
import net.minecraft.util.Vec3;

public class EventSub5 extends Event {
   private Vec3 vec3;

   public Vec3 getVec3() {
      return this.vec3;
   }

   public EventSub5(Vec3 var1) {
      this.vec3 = var1;
   }

   public void handleVec3(Vec3 var1) {
      this.vec3 = var1;
   }
}
