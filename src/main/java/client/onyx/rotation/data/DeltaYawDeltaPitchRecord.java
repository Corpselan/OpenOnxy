package client.onyx.rotation.data;

public record DeltaYawDeltaPitchRecord(float deltaYaw, float deltaPitch) {
   public float getFloat() {
      return (float)Math.hypot(this.deltaYaw, this.deltaPitch);
   }
}
