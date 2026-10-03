package client.onyx.module.player.scaffold.extra;

import client.onyx.MinecraftAccess;
import client.onyx.interact.placement.InteractedBlockPosPlacedBlockRecord;
import client.onyx.module.player.DelayModule;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.util.Util2;

public class Util implements MinecraftAccess {
   public static JumpSneakTimeRecord getJumpSneakTimeRecordForInteractedBlockPosPlacedBlockRecord(
      InteractedBlockPosPlacedBlockRecord var0, YawPitchRecord var1, Iface var2
   ) {
      if (Util2.isEntityPlayerSP5(MINECRAFT.thePlayer)) {
         int var6 = ClutchSettingGroup.CLUTCH_SETTING_GROUP.isEnabled5()
            ? ClutchSettingGroup.CLUTCH_SETTING_GROUP.getInt53(var1)
            : DelayModule.DELAY_MODULE.considerInventoryBooleanSetting.getInt20(var1);
         boolean var4 = DelayModule.DELAY_MODULE.getInt48() <= 0;
         boolean var5 = var6 >= 1;
         if (var4 || var5) {
            int var7 = Math.max(1, var6);
            return new JumpSneakTimeRecord(false, var7, false, false);
         }
      }

      if (var2 == null) {
         return JumpSneakTimeRecord.JUMP_SNEAK_TIME_RECORD;
      } else {
         JumpSneakTimeRecord var9;
         return (var9 = var2.getJumpSneakTimeRecord2(var0, var1)) != null ? var9 : JumpSneakTimeRecord.JUMP_SNEAK_TIME_RECORD;
      }
   }
}
