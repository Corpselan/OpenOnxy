package client.onyx.module.player.scaffold.extra;

import client.onyx.interact.placement.InteractedBlockPosPlacedBlockRecord;
import client.onyx.rotation.data.YawPitchRecord;

@FunctionalInterface
public interface Iface {
   JumpSneakTimeRecord getJumpSneakTimeRecord2(InteractedBlockPosPlacedBlockRecord var1, YawPitchRecord var2);
}
