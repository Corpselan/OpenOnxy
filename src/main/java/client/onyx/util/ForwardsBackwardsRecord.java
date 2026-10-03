package client.onyx.util;

import net.minecraft.util.MovementInput;

public record ForwardsBackwardsRecord(boolean forwards, boolean backwards, boolean left, boolean right) {
   public static final ForwardsBackwardsRecord FORWARDS_BACKWARDS_RECORD8 = new ForwardsBackwardsRecord(false, false, false, false);
   public static final ForwardsBackwardsRecord FORWARDS_BACKWARDS_RECORD5 = new ForwardsBackwardsRecord(true, false, false, false);
   public static final ForwardsBackwardsRecord FORWARDS_BACKWARDS_RECORD6 = new ForwardsBackwardsRecord(false, true, false, false);
   public static final ForwardsBackwardsRecord FORWARDS_BACKWARDS_RECORD9 = new ForwardsBackwardsRecord(false, false, true, false);
   public static final ForwardsBackwardsRecord FORWARDS_BACKWARDS_RECORD3 = new ForwardsBackwardsRecord(false, false, false, true);
   public static final ForwardsBackwardsRecord FORWARDS_BACKWARDS_RECORD7 = new ForwardsBackwardsRecord(true, false, true, false);
   public static final ForwardsBackwardsRecord FORWARDS_BACKWARDS_RECORD = new ForwardsBackwardsRecord(true, false, false, true);
   public static final ForwardsBackwardsRecord FORWARDS_BACKWARDS_RECORD4 = new ForwardsBackwardsRecord(false, true, true, false);
   public static final ForwardsBackwardsRecord FORWARDS_BACKWARDS_RECORD2 = new ForwardsBackwardsRecord(false, true, false, true);

   public float getFloat2() {
      if (this.forwards == this.backwards) {
         return 0.0F;
      } else {
         return this.forwards ? 1.0F : -1.0F;
      }
   }

   public ForwardsBackwardsRecord(float var1, float var2) {
      this(var1 > 0.0F, var1 < 0.0F, var2 > 0.0F, var2 < 0.0F);
   }

   public float getFloat() {
      if (this.left == this.right) {
         return 0.0F;
      } else {
         return this.left ? 1.0F : -1.0F;
      }
   }

   public ForwardsBackwardsRecord getForwardsBackwardsRecord() {
      boolean var1 = this.backwards;
      boolean var2 = this.forwards;
      boolean var3 = this.right;
      return new ForwardsBackwardsRecord(var1, var2, var3, this.left);
   }

   public ForwardsBackwardsRecord(MovementInput var1) {
      this(var1.moveForward, var1.moveStrafe);
   }

   public boolean isEnabled() {
      return this.forwards != this.backwards || this.left != this.right;
   }
}
