package client.onyx.interact.placement;

import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public final class HitVecStrategySub3 extends HitVecStrategy {
   public static final HitVecStrategySub3 HIT_VEC_STRATEGY_SUB3 = new HitVecStrategySub3();

   private HitVecStrategySub3() {
   }

   @Override
   public Vec3 getVec34(client.onyx.util.math.Cls2 var1, BlockPos var2) {
      return this.getCls23(var1).getVec32();
   }
}
