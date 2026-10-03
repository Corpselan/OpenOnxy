package client.onyx.interact.placement;

public class Cls3 {
   private final HitVecStrategy hitVecStrategy;
   private final boolean bool;

   public Cls3(HitVecStrategy var1) {
      this(var1, false);
   }

   public Cls3(HitVecStrategy var1, boolean var2) {
      this.hitVecStrategy = var1;
      this.bool = var2;
   }

   public HitVecStrategy getHitVecStrategy() {
      return this.hitVecStrategy;
   }

   public boolean isEnabled() {
      return this.bool;
   }
}
