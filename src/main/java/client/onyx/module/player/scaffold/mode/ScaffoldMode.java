package client.onyx.module.player.scaffold.mode;

import client.onyx.MinecraftAccess;
import client.onyx.interact.placement.Cls;
import client.onyx.interact.placement.InteractedBlockPosPlacedBlockRecord;
import client.onyx.module.player.scaffold.ConsiderInventoryBooleanSetting;
import client.onyx.rotation.Cls2;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.setting.ModeOption;
import client.onyx.util.Util11;
import client.onyx.util.math.PositionDirectionRecord;
import java.util.Comparator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public abstract class ScaffoldMode extends ModeOption implements MinecraftAccess {
   public abstract InteractedBlockPosPlacedBlockRecord getInteractedBlockPosPlacedBlockRecord(
      Vec3 var1, boolean var2, PositionDirectionRecord var3, ItemStack var4
   );

   protected Comparator<BlockPos> getComparator5(Vec3 var1, PositionDirectionRecord var2) {
      return var2 != null ? Cls.getComparatorForPositionDirectionRecord(var2) : Cls.getComparatorForVec3(var1);
   }

   public YawPitchRecord getYawPitchRecord16(InteractedBlockPosPlacedBlockRecord var1) {
      return var1 == null ? null : var1.rotation();
   }

   public MovingObjectPosition getMovingObjectPosition(InteractedBlockPosPlacedBlockRecord var1, YawPitchRecord var2) {
      return Util11.getMovingObjectPositionForYawPitchRecord(var2);
   }

   protected ScaffoldMode(String var1) {
      super(var1);
   }

   public Cls2 getCls213(YawPitchRecord var1, ConsiderInventoryBooleanSetting var2, boolean var3) {
      return var2.getCls210(var1, var3);
   }
}
