package client.onyx.interact.placement;

import client.onyx.util.Util12;
import client.onyx.util.Util2;
import client.onyx.util.Util7;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class HitVecStrategySub5 extends HitVecStrategy {
   private final EyePosRandomNumberRecord eyePosRandomNumberRecord;

   @Override
   public Vec3 getVec34(client.onyx.util.math.Cls2 var1, BlockPos var2) {
      var1 = this.getCls23(var1);
      if (!Util7.isForwardsBackwardsRecord(Util2.getForwardsBackwardsRecordForEntityPlayerSP(MINECRAFT.thePlayer))) {
         return this.getVec35(var2, var1);
      } else {
         Vec3 var3;
         return (var3 = this.getVec36(var2, var1)) != null ? var3 : this.getVec35(var2, var1);
      }
   }

   private Vec3 getVec36(BlockPos var1, client.onyx.util.math.Cls2 var2) {
      Vec3 var12 = var2.getVec3();
      Vec3 var3 = var2.getVec36();
      AxisAlignedBB var13 = new AxisAlignedBB(var12.xCoord, var12.yCoord, var12.zCoord, var3.xCoord, var3.yCoord, var3.zCoord);
      Vec3 var11 = Util2.getVec3ForEntity2(MINECRAFT.thePlayer).subtract(var1.getX(), var1.getY(), var1.getZ());
      var3 = null;
      double var4 = Double.NEGATIVE_INFINITY;
      Vec3[] var14;
      int var6 = (var14 = Util12.getVec3ArrayForAxisAlignedBB(var13)).length;

      int var7;
      for (int var16 = var7 = 0; var16 < var6; var16 = ++var7) {
         Vec3 var8;
         double var9;
         if ((var9 = (var8 = var14[var7]).distanceToSqr(var11)) > var4) {
            var4 = var9;
            var3 = var8;
         }
      }

      return var3;
   }

   public HitVecStrategySub5(EyePosRandomNumberRecord var1) {
      this.eyePosRandomNumberRecord = var1;
   }

   private Vec3 getVec35(BlockPos var1, client.onyx.util.math.Cls2 var2) {
      return new HitVecStrategySub4(this.eyePosRandomNumberRecord).getVec33(var1, var2);
   }

   public EyePosRandomNumberRecord getEyePosRandomNumberRecord3() {
      return this.eyePosRandomNumberRecord;
   }
}
