package client.onyx.util.math;

import net.minecraft.util.Vec3;

public record PositionDirectionRecord(Vec3 position, Vec3 direction) implements Iface {
   @Override
   public Vec3 getVec3() {
      return this.direction;
   }

   public PositionDirectionRecord(Vec3 position, Vec3 direction) {
      Iface.handleVec3(direction);
      this.position = position;
      this.direction = direction;
   }

   @Override
   public UnboundedForwardEnum getUnboundedForwardEnum() {
      return UnboundedForwardEnum.UNBOUNDED;
   }

   @Override
   public Vec3 getVec35() {
      return this.position;
   }

   public static PositionDirectionRecord getPositionDirectionRecordForVec3(Vec3 var0, Vec3 var1) {
      Vec3 var2 = var1.subtract(var0);
      return new PositionDirectionRecord(var0, var2);
   }
}
