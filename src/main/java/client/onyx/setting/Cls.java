package client.onyx.setting;

import client.onyx.setting.impl.ValueSettingSub3;

public class Cls {
   private double double_;
   private final boolean bool;
   private final ValueSettingSub3 valueSettingSub3;

   public void run() {
      this.double_ = this.bool ? this.valueSettingSub3.getInt4() : this.valueSettingSub3.getDouble();
   }

   public Cls(ValueSettingSub3 var1) {
      this.valueSettingSub3 = var1;
      this.bool = var1.isEnabled11();
      var1.getModeSetting3(var1x -> this.run());
      this.run();
   }

   public int getInt() {
      return (int)Math.round(this.double_);
   }

   public float getFloat() {
      return (float)this.double_;
   }

   public double getDouble() {
      return this.double_;
   }
}
