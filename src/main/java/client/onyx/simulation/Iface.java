package client.onyx.simulation;

import net.minecraft.util.Vec3;

public interface Iface {
   Vec3 getVec37();

   void run17();

   public record PosRecord(Vec3 pos) implements Iface {
      @Override
      public Vec3 getVec37() {
         return this.pos;
      }

      @Override
      public void run17() {
      }
   }
}
