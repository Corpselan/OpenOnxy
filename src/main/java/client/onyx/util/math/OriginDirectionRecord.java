package client.onyx.util.math;

import net.minecraft.util.Vec3;

public record OriginDirectionRecord(Vec3 origin, Vec3 direction) implements Iface {
   @Override
   public Vec3 getVec35() {
      return this.origin;
   }

   public static OriginDirectionRecord getOriginDirectionRecordForVec3(Vec3 var0, Vec3 var1) {
      Vec3 var2 = var1.subtract(var0);
      return new OriginDirectionRecord(var0, var2);
   }

   @Override
   public Vec3 getVec3() {
      return this.direction;
   }

   @Override
   public UnboundedForwardEnum getUnboundedForwardEnum() {
      return UnboundedForwardEnum.FORWARD;
   }

   public OriginDirectionRecord(Vec3 origin, Vec3 direction) {
      Iface.handleVec3(direction);
      this.origin = origin;
      this.direction = direction;
   }
}
