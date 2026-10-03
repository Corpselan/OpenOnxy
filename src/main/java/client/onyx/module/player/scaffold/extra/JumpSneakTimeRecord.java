package client.onyx.module.player.scaffold.extra;

public record JumpSneakTimeRecord(boolean jump, int sneakTime, boolean stopInput, boolean stepBack) {
   public static final JumpSneakTimeRecord JUMP_SNEAK_TIME_RECORD = new JumpSneakTimeRecord(false, 0, false, false);
}
