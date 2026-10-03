package client.onyx.util;

import client.onyx.MinecraftAccess;
import client.onyx.rotation.data.YawPitchRecord;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public final class Util5 implements MinecraftAccess {
   public static MovingObjectPosition getMovingObjectPositionForEntity(Entity var0, double var1, YawPitchRecord var3) {
      Entity var4;
      if ((var4 = MINECRAFT.getRenderViewEntity()) != null && var0 != null) {
         Vec3 var11 = var4.getPositionEyes(1.0F);
         Vec3 var6 = var3.getVec3();
         Vec3 var7 = var11.addVector(var6.xCoord * var1, var6.yCoord * var1, var6.zCoord * var1);
         float var9 = var0.getCollisionBorderSize();
         MovingObjectPosition var8;
         return (var8 = var0.getEntityBoundingBox().expand(var9, var9, var9).calculateIntercept(var11, var7)) == null
            ? null
            : new MovingObjectPosition(var0, var8.hitVec);
      } else {
         return null;
      }
   }

   private Util5() {
   }
}
