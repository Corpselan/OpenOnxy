package client.onyx.interact.placement;

import client.onyx.util.Util2;
import client.onyx.util.math.PositionDirectionRecord;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class HitVecStrategySub extends HitVecStrategy {
   private final EyePosRandomNumberRecord eyePosRandomNumberRecord;
   private final PositionDirectionRecord positionDirectionRecord;

   public PositionDirectionRecord getPositionDirectionRecord() {
      return this.positionDirectionRecord;
   }

   @Override
   public Vec3 getVec34(client.onyx.util.math.Cls2 var1, BlockPos var2) {
      var1 = this.getCls23(var1).getCls25(var2);
      client.onyx.util.math.Cls2 var3;
      if ((var3 = this.getCls22(MINECRAFT.thePlayer, var1)) == null) {
         var3 = var1;
      }

      return new HitVecStrategySub4(this.eyePosRandomNumberRecord).getVec33(var2, var3.getCls24(new Vec3(-var2.getX(), -var2.getY(), -var2.getZ())));
   }

   private client.onyx.util.math.Cls2 getCls22(EntityPlayerSP var1, client.onyx.util.math.Cls2 var2) {
      if (this.positionDirectionRecord == null) {
         return null;
      } else {
         Vec3 var5 = Util2.getVec3ForEntity2(var1);
         Vec3 var3 = this.positionDirectionRecord.getVec34(var5);
         var3 = var5.subtract(var3).normalize();
         PositionDirectionRecord var4 = new PositionDirectionRecord(this.eyePosRandomNumberRecord.eyePos(), this.positionDirectionRecord.getVec3());
         Vec3 var10;
         if ((var10 = var2.getCls3().getVec32(var4)) == null) {
            return null;
         } else {
            var3 = var5.add(var3.scale(2.0));
            AxisAlignedBB var6 = new AxisAlignedBB(var10.xCoord, var5.yCoord - 2.0, var10.zCoord, var3.xCoord, var5.yCoord + 1.0, var3.zCoord);
            client.onyx.util.math.Cls2 var7;
            return (var7 = var2.getCls23(var6)).getDouble() < 1.0E-4 ? null : var7;
         }
      }
   }

   public HitVecStrategySub(EyePosRandomNumberRecord var1, PositionDirectionRecord var2) {
      this.eyePosRandomNumberRecord = var1;
      this.positionDirectionRecord = var2;
   }

   public EyePosRandomNumberRecord getEyePosRandomNumberRecord() {
      return this.eyePosRandomNumberRecord;
   }
}
