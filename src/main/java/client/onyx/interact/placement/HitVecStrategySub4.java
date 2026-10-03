package client.onyx.interact.placement;

import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.util.math.Iface;
import client.onyx.util.math.PositionDirectionRecord;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class HitVecStrategySub4 extends HitVecStrategy {
   private final EyePosRandomNumberRecord eyePosRandomNumberRecord;

   public HitVecStrategySub4(EyePosRandomNumberRecord var1) {
      this.eyePosRandomNumberRecord = var1;
   }

   public EyePosRandomNumberRecord getEyePosRandomNumberRecord2() {
      return this.eyePosRandomNumberRecord;
   }

   public Vec3 getVec33(BlockPos var1, client.onyx.util.math.Cls2 var2) {
      if (Iface.isDouble(var2.getDouble(), 0.0)) {
         return var2.getVec3();
      } else {
         YawPitchRecord var3 = client.onyx.rotation.Cls.CLS.getYawPitchRecord5();
         PositionDirectionRecord var4 = new PositionDirectionRecord(
            this.eyePosRandomNumberRecord.eyePos().subtract(var1.getX(), var1.getY(), var1.getZ()), var3.getVec3()
         );
         return var2.getVec34(var4);
      }
   }

   @Override
   public Vec3 getVec34(client.onyx.util.math.Cls2 var1, BlockPos var2) {
      client.onyx.util.math.Cls2 var3 = this.getCls23(var1);
      return this.getVec33(var2, var3);
   }
}
