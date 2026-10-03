package client.onyx.simulation;

import net.minecraft.util.Vec3;

public class Cls4 implements Iface {
   private int int_;
   private final Cls cls;

   public Cls4(Cls var1) {
      this.cls = var1;
   }

   public int getInt() {
      return this.int_;
   }

   @Override
   public Vec3 getVec37() {
      return this.cls.getPosFallDistanceRecord(this.int_).pos();
   }

   @Override
   public void run17() {
      int var2 = this.int_ + 1;
      this.int_ = var2;
   }

   public Cls getCls() {
      return this.cls;
   }
}
