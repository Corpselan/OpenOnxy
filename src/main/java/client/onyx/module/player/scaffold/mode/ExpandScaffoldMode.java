package client.onyx.module.player.scaffold.mode;

import client.onyx.interact.placement.Cls;
import client.onyx.interact.placement.Cls2;
import client.onyx.interact.placement.Cls3;
import client.onyx.interact.placement.Cls4;
import client.onyx.interact.placement.HitVecStrategySub2;
import client.onyx.interact.placement.InteractedBlockPosPlacedBlockRecord;
import client.onyx.interact.placement.Util;
import client.onyx.module.player.DelayModule;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.util.Util6;
import client.onyx.util.math.PositionDirectionRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class ExpandScaffoldMode extends ScaffoldMode {
   public ValueSettingSub10 valueSettingSub10 = (new ValueSettingSub10("Length", 4.0D, 1.0D, 10.0D, 1.0D)).getValueSettingSub10(" blocks");
   public static final ExpandScaffoldMode EXPAND_SCAFFOLD_MODE = new ExpandScaffoldMode();
   private static final float FLOAT = 0.017453292F;

   public MovingObjectPosition getMovingObjectPosition(InteractedBlockPosPlacedBlockRecord var1, YawPitchRecord var2) {
      if (var1 == null) {
         return null;
      } else {
         MovingObjectPosition var3;
         return (var3 = super.getMovingObjectPosition(var1, var2)) != null && var1.isMovingObjectPosition(var3) ? var3 : var1.getMovingObjectPosition();
      }
   }

   private ExpandScaffoldMode() {
      super("Expand");
   }

   public YawPitchRecord getYawPitchRecord16(InteractedBlockPosPlacedBlockRecord var1) {
      return var1 == null ? null : YawPitchRecord.getYawPitchRecordForVec32(Util6.getVec3ForVec3i2(var1.placedBlock()), MINECRAFT.thePlayer.getPositionEyes(1.0F));
   }

   public InteractedBlockPosPlacedBlockRecord getInteractedBlockPosPlacedBlockRecord(Vec3 var1, boolean var2, PositionDirectionRecord var3, ItemStack var4) {
      Cls var5 = new Cls(Cls2.getCls2(), new Cls3(HitVecStrategySub2.HIT_VEC_STRATEGY_SUB2, true), var4, new Cls4(var1, var2));

      int var6;
      for(int var10000 = var6 = 0; var10000 <= this.valueSettingSub10.getInt10(); var10000 = var6) {
         InteractedBlockPosPlacedBlockRecord var7;
         if ((var7 = Util.getInteractedBlockPosPlacedBlockRecordForBlockPos(DelayModule.DELAY_MODULE.getBlockPos10(this.getBlockPos13(var1, var6)), var5)) != null) {
            return var7;
         }

         ++var6;
      }

      return null;
   }

   private BlockPos getBlockPos13(Vec3 var1, int var2) {
      float var4 = MINECRAFT.thePlayer.rotationYaw;
      return Util6.getBlockPosForVec3(var1).add((int)(-((float)Math.sin((double)(var4 * 0.017453292F))) * (float)var2), 0, (int)((float)Math.cos((double)(var4 * 0.017453292F)) * (float)var2));
   }
}
