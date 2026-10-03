package client.onyx.interact.placement;

import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public final class HitVecStrategySub2 extends HitVecStrategy {
   public static final HitVecStrategySub2 HIT_VEC_STRATEGY_SUB2 = new HitVecStrategySub2();

   @Override
   public Vec3 getVec34(client.onyx.util.math.Cls2 var1, BlockPos var2) {
      return var1.getVec35();
   }

   private HitVecStrategySub2() {
   }
}
