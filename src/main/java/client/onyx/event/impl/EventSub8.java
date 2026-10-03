package client.onyx.event.impl;

import client.onyx.event.Event;
import net.minecraft.util.Vec3;

public class EventSub8 extends Event {
   private final float float_;
   private Vec3 vec3;
   private final float float_2;
   private final Vec3 vec32;

   public float getFloat2() {
      return this.float_2;
   }

   public Vec3 getVec33() {
      return this.vec32;
   }

   public EventSub8(Vec3 var1, float var2, float var3, Vec3 var4) {
      this.vec32 = var1;
      this.float_ = var2;
      this.float_2 = var3;
      this.vec3 = var4;
   }

   public float getFloat() {
      return this.float_;
   }

   public Vec3 getVec32() {
      return this.vec3;
   }

   public void handleVec32(Vec3 var1) {
      this.vec3 = var1;
   }
}
