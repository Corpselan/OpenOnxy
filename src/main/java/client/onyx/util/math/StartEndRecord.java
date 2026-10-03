package client.onyx.util.math;

import client.onyx.util.Util6;
import net.minecraft.util.Vec3;

public record StartEndRecord(Vec3 start, Vec3 end) implements Iface {
   @Override
   public UnboundedForwardEnum getUnboundedForwardEnum() {
      return UnboundedForwardEnum.SEGMENT_01;
   }

   public StartEndRecord(Vec3 start, Vec3 end) {
      if (Util6.isVec33(end.subtract(start))) {
         throw new IllegalArgumentException(
            new StringBuilder().insert(0, "Line segment must not have zero length, actual: ").append(start).append(" -> ").append(end).toString()
         );
      } else {
         this.start = start;
         this.end = end;
      }
   }

   @Override
   public Vec3 getVec35() {
      return this.start;
   }

   public double getDouble5() {
      return this.getVec3().length();
   }

   @Override
   public Vec3 getVec3() {
      return this.end.subtract(this.start);
   }
}
