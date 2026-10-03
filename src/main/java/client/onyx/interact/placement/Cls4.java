package client.onyx.interact.placement;

import client.onyx.MinecraftAccess;
import net.minecraft.util.Vec3;

public class Cls4 implements MinecraftAccess {
   private final boolean bool;
   private static final float FLOAT = 1.54F;
   private static final float FLOAT2 = 1.62F;
   private final Vec3 vec3;

   public boolean isEnabled2() {
      return this.bool;
   }

   public float getFloat() {
      return getFloatForBool(this.bool);
   }

   public Vec3 getVec32() {
      return this.vec3;
   }

   public Cls4(Vec3 var1, boolean var2) {
      this.vec3 = var1;
      this.bool = var2;
   }

   public Vec3 getVec3() {
      return this.vec3.add(0.0, this.getFloat(), 0.0);
   }

   public static float getFloatForBool(boolean var0) {
      return var0 ? 1.54F : 1.62F;
   }

   public Cls4(Vec3 var1) {
      this(var1, MINECRAFT.thePlayer != null && MINECRAFT.thePlayer.isSneaking());
   }
}
