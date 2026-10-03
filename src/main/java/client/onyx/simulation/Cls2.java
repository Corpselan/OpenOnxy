package client.onyx.simulation;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub12;
import client.onyx.util.ForwardBackwardRecord;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.Util2;
import client.onyx.util.Util3;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Cls2 implements MinecraftAccess {
   private float float_;
   private boolean bool;
   private static final double DOUBLE = 0.121;
   private float float_2;
   private boolean bool2;
   private boolean bool3;
   private final ForwardsBackwardsRecord forwardsBackwardsRecord;
   public ForwardBackwardRecord forwardBackwardRecord;

   public boolean isEnabled24() {
      return this.bool2;
   }

   public void handleBool3(boolean var1) {
      this.bool3 = var1;
   }

   @Override
   public String toString() {
      return new StringBuilder()
         .insert(0, "SimulatedPlayerInput(forwards={")
         .append(this.forwardBackwardRecord.forward())
         .append("}, backwards={")
         .append(this.forwardBackwardRecord.backward())
         .append("}, left={")
         .append(this.forwardBackwardRecord.left())
         .append("}, right={")
         .append(this.forwardBackwardRecord.right())
         .append("}, jumping={")
         .append(this.forwardBackwardRecord.jump())
         .append("}, sprinting=")
         .append(this.bool)
         .append(", slowDown=")
         .append(this.forwardBackwardRecord.shift())
         .append(")")
         .toString();
   }

   public float getFloat9() {
      return this.float_;
   }

   public boolean isEnabled26() {
      return this.bool3;
   }

   public boolean isEnabled25() {
      return this.bool;
   }

   public ForwardBackwardRecord getForwardBackwardRecord() {
      return this.forwardBackwardRecord;
   }

   public float getFloat6() {
      return this.float_;
   }

   public Cls2(ForwardsBackwardsRecord var1, boolean var2, boolean var3, boolean var4) {
      this(var1, var2, var3, var4, false);
   }

   public ForwardsBackwardsRecord getForwardsBackwardsRecord() {
      return this.forwardsBackwardsRecord;
   }

   public static Cls2 getCls2ForForwardsBackwardsRecord2(ForwardsBackwardsRecord var0, boolean var1, boolean var2, boolean var3) {
      Cls2 var4 = new Cls2(var0, var1, var2, var3);
      EventSub12 var5 = new EventSub12();
      OnyxClient.I_EVENT_BUS.post(var5);
      if (var5.isEnabled2()) {
         var4.bool3 = true;
      }

      return var4;
   }

   public void handleBool5(boolean var1) {
      this.bool2 = var1;
   }

   public float getFloat8() {
      return this.float_2;
   }

   public Cls2(ForwardsBackwardsRecord var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.forwardsBackwardsRecord = var1;
      this.bool = var3;
      this.bool2 = var5;
      this.forwardBackwardRecord = new ForwardBackwardRecord(var1.forwards(), var1.backwards(), var1.left(), var1.right(), var2, var4, var3);
   }

   public float getFloat7() {
      return this.float_2;
   }

   public void handleBool4(boolean var1) {
      this.bool = var1;
   }

   public static Cls2 getCls2ForForwardsBackwardsRecord(ForwardsBackwardsRecord var0) {
      return getCls2ForForwardsBackwardsRecord2(
         var0,
         MINECRAFT.thePlayer.movementInput != null && MINECRAFT.thePlayer.movementInput.jump,
         MINECRAFT.thePlayer.isSprinting(),
         MINECRAFT.thePlayer.isSneaking()
      );
   }

   public static Cls2 getCls2ForEntityPlayer(EntityPlayer var0) {
      double var2;
      Vec3 var5;
      boolean var4 = (var2 = (var5 = Util2.getVec3ForEntity2(var0).subtract(Util2.getVec3ForEntity4(var0))).horizontalDistanceSqr()) >= 0.014641;
      ForwardsBackwardsRecord var6;
      if (var2 > 0.0025000000000000005) {
         float var7 = Util3.getFloatForVec3(var5, var0.rotationYaw);
         var6 = Util3.getForwardsBackwardsRecordForForwardsBackwardsRecord(
            ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8, MathHelper.wrapAngleTo180_float(var7)
         );
      } else {
         var6 = ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8;
      }

      boolean var10003;
      boolean var10004;
      if (!var0.onGround) {
         var10003 = true;
         var10004 = var4;
      } else {
         var10003 = false;
         var10004 = var4;
      }

      Cls2 var10000 = new Cls2(var6, var10003, var10004, var0.isSneaking());
      return var10000;
   }

   public void run16() {
      float var1;
      Cls2 var10000;
      if (this.forwardBackwardRecord.forward() != this.forwardBackwardRecord.backward()) {
         var1 = this.forwardBackwardRecord.forward() ? 1.0F : -1.0F;
         var10000 = this;
      } else {
         var1 = 0.0F;
         var10000 = this;
      }

      float var3;
      if (var10000.forwardBackwardRecord.left() == this.forwardBackwardRecord.right()) {
         var3 = 0.0F;
         var10000 = this;
      } else if (this.forwardBackwardRecord.left()) {
         var3 = 1.0F;
         var10000 = this;
      } else {
         var3 = -1.0F;
         var10000 = this;
      }

      if (var10000.forwardBackwardRecord.shift()) {
         var3 = (float)(var3 * 0.3);
         var1 = (float)(var1 * 0.3);
      }

      this.float_ = var3;
      this.float_2 = var1;
   }
}
