package client.onyx.interact.placement;

import client.onyx.rotation.data.YawPitchRecord;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public record InteractedBlockPosPlacedBlockRecord(
   BlockPos interactedBlockPos, BlockPos placedBlock, EnumFacing direction, double minPlacementY, YawPitchRecord rotation
) {
   public boolean isMovingObjectPosition(MovingObjectPosition var1) {
      if (var1 == null) {
         return false;
      } else if (var1.typeOfHit != MovingObjectType.BLOCK) {
         return false;
      } else if (!var1.getBlockPos().equals(this.interactedBlockPos)) {
         return false;
      } else {
         return var1.sideHit != this.direction ? false : !(var1.hitVec.yCoord < this.minPlacementY);
      }
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 122;
      byte var12 = 33;
      int var10000 = var10002;

      for (byte var2 = 38; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var10002 = var5--;
         var1[var10002] = (char)(var10.charAt(var10002) ^ var4);
      }

      return new String(var1);
   }

   public MovingObjectPosition getMovingObjectPosition() {
      Vec3 var1 = Vec3.atCenterOf(this.interactedBlockPos);
      EnumFacing var2 = this.direction;
      return new MovingObjectPosition(var1, var2, this.interactedBlockPos);
   }
}
