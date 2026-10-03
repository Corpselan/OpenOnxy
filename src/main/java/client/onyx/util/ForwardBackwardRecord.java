package client.onyx.util;

public record ForwardBackwardRecord(boolean forward, boolean backward, boolean left, boolean right, boolean jump, boolean shift, boolean sprint) {
   public static final ForwardBackwardRecord FORWARD_BACKWARD_RECORD = new ForwardBackwardRecord(false, false, false, false, false, false, false);
}
