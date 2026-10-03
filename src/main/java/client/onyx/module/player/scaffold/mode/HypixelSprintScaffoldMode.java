package client.onyx.module.player.scaffold.mode;

import client.onyx.event.impl.EventSub10;
import client.onyx.event.impl.EventSub15;
import client.onyx.event.impl.EventSub16;
import client.onyx.event.impl.EventSub17;
import client.onyx.event.impl.EventSub8;
import client.onyx.interact.Util;
import client.onyx.interact.placement.InteractedBlockPosPlacedBlockRecord;
import client.onyx.module.player.DelayModule;
import client.onyx.rotation.Cls;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.mode.OffStrictEnum;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.OutlineColliderEnum;
import client.onyx.util.Util11;
import client.onyx.util.Util2;
import client.onyx.util.math.PositionDirectionRecord;
import java.util.ArrayList;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class HypixelSprintScaffoldMode extends ScaffoldMode {
   private float float_;
   private static final int INT = 2;
   private boolean bool2;
   private static final double DOUBLE = 4.5;
   private static final int INT2 = 10;
   private float float_2;
   private static final float FLOAT = 90.0F;
   private static final float FLOAT2 = 200.0F;
   public static final HypixelSprintScaffoldMode HYPIXEL_SPRINT_SCAFFOLD_MODE = new HypixelSprintScaffoldMode();
   private boolean bool3;
   private static final float FLOAT3 = 83.0F;
   private int int_3;
   private static final float[] FLOAT_ARRAY = getFloatArrayForFloat2(180.0F);
   private static final float FLOAT4 = 60.0F;
   private float float_3;
   private boolean bool4;
   private static final float[] FLOAT_ARRAY2 = getFloatArrayForFloat2(90.0F);
   private static final List<ForwardsBackwardsRecord> LIST = List.of(
      ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD5,
      ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD,
      ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD3,
      ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD2,
      ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD6,
      ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD4,
      ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD9,
      ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD7
   );
   private static final float FLOAT5 = 45.0F;
   private static final int INT3 = 3;
   private float float_4;
   private static final float FLOAT6 = 0.1F;

   private float getFloat93() {
      float var6 = MINECRAFT.thePlayer.rotationYaw;
      boolean var5 = MINECRAFT.gameSettings.keyBindForward.isKeyDown();
      boolean var4 = MINECRAFT.gameSettings.keyBindBack.isKeyDown();
      boolean var3 = MINECRAFT.gameSettings.keyBindLeft.isKeyDown();
      boolean var2 = MINECRAFT.gameSettings.keyBindRight.isKeyDown();
      if (var5 && !var4) {
         if (var3 && !var2) {
            float var11;
            float var17;
            return (var17 = (var11 = var6 - 45.0F) % 360.0F) < 0.0F ? var17 + 360.0F : var17;
         }

         if (var2 && !var3) {
            float var10;
            float var16;
            return (var16 = (var10 = var6 + 45.0F) % 360.0F) < 0.0F ? var16 + 360.0F : var16;
         }
      } else if (var4 && !var5) {
         var6 += 180.0F;
         if (var3 && !var2) {
            float var9;
            float var14;
            return (var14 = (var9 = var6 + 45.0F) % 360.0F) < 0.0F ? var14 + 360.0F : var14;
         }

         if (var2 && !var3) {
            float var8;
            float var13;
            return (var13 = (var8 = var6 - 45.0F) % 360.0F) < 0.0F ? var13 + 360.0F : var13;
         }
      } else {
         if (var3 && !var2) {
            float var7;
            float var12;
            return (var12 = (var7 = var6 - 90.0F) % 360.0F) < 0.0F ? var12 + 360.0F : var12;
         }

         if (var2 && !var3) {
            var6 += 90.0F;
         }
      }

      float var15;
      return (var15 = var6 % 360.0F) < 0.0F ? var15 + 360.0F : var15;
   }

   private HypixelSprintScaffoldMode() {
      super("HypixelSprint");
   }

   @Override
   public InteractedBlockPosPlacedBlockRecord getInteractedBlockPosPlacedBlockRecord(Vec3 var1, boolean var2, PositionDirectionRecord var3, ItemStack var4) {
      return null;
   }

   private ForwardsBackwardsRecord getForwardsBackwardsRecord3(float var1) {
      ForwardsBackwardsRecord var2 = ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD5;
      float var3 = Float.MAX_VALUE;

      for (ForwardsBackwardsRecord var7 : LIST) {
         float var6;
         if ((var6 = Math.abs(MathHelper.wrapAngleTo180_float(Util2.getFloatForFloat20(this.float_3, var7) - var1))) < var3) {
            var3 = var6;
            var2 = var7;
         }
      }

      return var2;
   }

   @Override
   protected void run3() {
      this.bool4 = false;
      this.bool2 = false;
      this.bool3 = false;
      this.int_3 = 0;
      if (MINECRAFT.thePlayer != null) {
         this.float_3 = MINECRAFT.thePlayer.rotationYaw;
         this.float_2 = 83.0F;
         this.float_4 = this.getFloat93() - 180.0F;
         this.float_ = 83.0F;
      }
   }

   @EventHandler
   private void handleEventSub178(EventSub17 var1) {
      if (MINECRAFT.thePlayer != null) {
         float var2 = this.getFloat93() - 180.0F;
         MINECRAFT.thePlayer.rotationYawHead = var2;
         MINECRAFT.thePlayer.renderYawOffset = var2;
      }
   }

   @Override
   protected void run4() {
      Cls.CLS.handleYawPitchRecord(null);
   }

   @EventHandler(
      priority = -500
   )
   private void handleEventSub1610(EventSub16 var1) {
      ForwardsBackwardsRecord var3 = var1.getForwardsBackwardsRecord2();
      if (getOffStrictEnum3() == OffStrictEnum.SILENT && var3.isEnabled()) {
         float var4 = Util2.getFloatForFloat20(MINECRAFT.thePlayer.rotationYaw, var3);
         var1.handleForwardsBackwardsRecord(this.getForwardsBackwardsRecord3(var4));
      }
   }

   private YawPitchRecord getYawPitchRecord17() {
      float var1 = this.float_3;
      return new YawPitchRecord(var1, this.float_2, true);
   }

   private MovingObjectPosition getMovingObjectPosition2(float var1, float var2) {
      Entity var3;
      Vec3 var5 = (var3 = MINECRAFT.getRenderViewEntity()).getPositionEyes(1.0F);
      return Util11.getMovingObjectPositionForDouble3(4.5, OutlineColliderEnum.COLLIDER, false, var5, Vec3.directionFromRotation(var2, var1), var3);
   }

   private MovingObjectPosition getMovingObjectPosition3(BlockPos var1) {
      if (!Util.isIBlockState(Util.getIBlockStateForBlockPos2(var1), var1, null)) {
         return null;
      } else {
         BlockPos var13 = null;
         EnumFacing var9 = null;
         double var4 = Double.MAX_VALUE;

         int var6;
         int var7;
         for (int var10000 = var6 = -3; var10000 <= 3; var10000 = ++var6) {
            int var8;
            for (int var14 = var7 = -2; var14 <= 0; var14 = ++var7) {
               for (int var15 = var8 = -3; var15 <= 3; var15 = ++var8) {
                  BlockPos var3;
                  EnumFacing var10;
                  double var11;
                  if (!Util.isBlockPos2(var3 = var1.add(var6, var7, var8))
                     && (var10 = getEnumFacingForBlockPos(var3, var1)) != EnumFacing.DOWN
                     && !((var11 = MINECRAFT.thePlayer.getDistanceSqToCenter(var3)) >= var4)) {
                     var4 = var11;
                     var13 = var3;
                     var9 = var10;
                  }
               }
            }
         }

         return var13 == null ? null : new MovingObjectPosition(Vec3.atCenterOf(var13), var9, var13);
      }
   }

   @EventHandler(
      priority = -500
   )
   private void handleEventSub15(EventSub15 var1) {
      OffStrictEnum var3;
      if ((var3 = getOffStrictEnum3()) == OffStrictEnum.SILENT || var3 == OffStrictEnum.STRICT) {
         var1.handleFloat2(this.float_3);
      }
   }

   private static EnumFacing getEnumFacingForBlockPos(BlockPos var0, BlockPos var1) {
      int var4 = var1.getX() - var0.getX();
      int var2 = var1.getY() - var0.getY();
      int var3 = var1.getZ() - var0.getZ();
      if (Math.abs(var4) >= Math.abs(var2) && Math.abs(var4) >= Math.abs(var3)) {
         return var4 > 0 ? EnumFacing.EAST : EnumFacing.WEST;
      } else if (Math.abs(var2) < Math.abs(var4) || Math.abs(var2) < Math.abs(var3)) {
         return var3 > 0 ? EnumFacing.SOUTH : EnumFacing.NORTH;
      } else {
         return var2 > 0 ? EnumFacing.UP : EnumFacing.DOWN;
      }
   }

   private YawPitchRecord getYawPitchRecord18(MovingObjectPosition var1) {
      float var10 = this.getFloat93() + 90.0F;
      float[] var12 = FLOAT_ARRAY;
      int var4 = FLOAT_ARRAY.length;

      int var5;
      for (int var10000 = var5 = 0; var10000 < var4; var10000 = ++var5) {
         float var6 = var12[var5];
         float[] var7 = FLOAT_ARRAY2;
         int var8 = FLOAT_ARRAY2.length;

         int var9;
         for (int var15 = var9 = 0; var15 < var8; var15 = ++var9) {
            float var13 = var7[var9];
            float var11 = var10 + var6;
            var13 = MathHelper.clamp_float(var13, -90.0F, 90.0F);
            MovingObjectPosition var3;
            if ((var3 = this.getMovingObjectPosition2(var11, var13)) != null
               && var3.typeOfHit == MovingObjectType.BLOCK
               && var3.getBlockPos().equals(var1.getBlockPos())
               && var3.sideHit == var1.sideHit) {
               return new YawPitchRecord(var11, var13);
            }
         }
      }

      return null;
   }

   private void run163() {
      if (!this.bool2) {
         this.bool2 = true;
         float var3 = (float)(200.0 - Math.random());
         this.float_3 = this.float_3 + MathHelper.clamp_float(MathHelper.wrapAngleTo180_float(this.float_4 - this.float_3), -var3, var3);
         float var2 = MINECRAFT.thePlayer.rotationYaw;
         this.float_3 = MINECRAFT.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(this.float_3 - var2);
         this.float_2 = this.float_2 + MathHelper.clamp_float(MathHelper.wrapAngleTo180_float(this.float_ - this.float_2), -var3, var3);
         this.bool4 = Math.abs(MathHelper.wrapAngleTo180_float(this.float_3 - this.float_4)) <= 0.1F
            && Math.abs(MathHelper.wrapAngleTo180_float(this.float_2 - this.float_)) <= 0.1F;
      }
   }

   private void handleBlockPos7(BlockPos var1) {
      MovingObjectPosition var3;
      if ((var3 = this.getMovingObjectPosition3(var1)) != null) {
         YawPitchRecord var2;
         if ((var2 = this.getYawPitchRecord18(var3)) == null) {
            this.bool4 = false;
            this.bool2 = true;
         } else {
            this.float_4 = var2.yaw2();
            this.float_ = var2.pitch2();
            this.run163();
            if (MINECRAFT.gameSettings.keyBindJump.isKeyDown() && MINECRAFT.thePlayer.onGround) {
               this.bool4 = false;
            }

            if (this.bool4) {
               if (this.isBlockPos14(var3.getBlockPos())) {
                  Util.isMovingObjectPosition(var3);
                  MINECRAFT.thePlayer.swingItem();
               }

               this.int_3 = 10;
            }
         }
      }
   }

   @EventHandler(
      priority = 1000
   )
   private void handleEventSub109(EventSub10 var1) {
      if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null && MINECRAFT.playerController != null) {
         if (this.int_3 > 0) {
            int var5 = this.int_3 - 1;
            this.int_3 = var5;
         }

         this.bool2 = false;
         boolean var7 = DelayModule.DELAY_MODULE.isEnabled119();
         BlockPos var3 = new BlockPos(MINECRAFT.thePlayer).down();
         if (var7 && Util.isBlockPos2(var3)) {
            this.handleBlockPos7(var3);
         }

         float var8;
         float var9 = Math.abs(MathHelper.wrapAngleTo180_float((var8 = this.getFloat93() + 45.0F) - this.float_3));
         int var10 = 10 - (var9 > 60.0F ? 2 : 1);
         if (this.int_3 == var10 && !MINECRAFT.gameSettings.keyBindJump.isKeyDown() && this.bool3) {
            this.float_3 = var8;
         }

         if (MINECRAFT.thePlayer.onGround && MINECRAFT.gameSettings.keyBindJump.isKeyDown()) {
            float var6 = this.getFloat93();
            this.float_3 = var6;
         }

         HypixelSprintScaffoldMode var10000;
         if (getOffStrictEnum3() == OffStrictEnum.CHANGE_LOOK) {
            client.onyx.rotation.util.Util.handleEntityPlayerSP(MINECRAFT.thePlayer, this.getYawPitchRecord17());
            Cls.CLS.handleYawPitchRecord(null);
            var10000 = this;
         } else {
            Cls.CLS.handleYawPitchRecord(this.getYawPitchRecord17());
            var10000 = this;
         }

         var10000.bool3 = true;
      }
   }

   private boolean isBlockPos14(BlockPos var1) {
      double var2 = MINECRAFT.playerController.getBlockReachDistance();
      return MINECRAFT.thePlayer.getPositionEyes(1.0F).squareDistanceTo(Vec3.atCenterOf(var1)) <= var2 * var2;
   }

   @EventHandler(
      priority = -500
   )
   private void handleEventSub82(EventSub8 var1) {
      OffStrictEnum var2;
      float var3 = (var2 = getOffStrictEnum3()) != OffStrictEnum.SILENT && var2 != OffStrictEnum.STRICT ? var1.getFloat2() : this.float_3;
      Vec3 var4 = var1.getVec33();
      float var5 = var1.getFloat();
      Vec3 var6 = Util2.getVec3ForVec37(var4, var5, var3);
      var1.handleVec32(var6);
   }

   private static float[] getFloatArrayForFloat2(float var0) {
      ArrayList var1;
      (var1 = new ArrayList()).add(0.0F);
      float var4 = 1.0F;

      for (float var10000 = var4; var10000 <= 20.0F; var10000 = ++var4) {
         var1.add(-var4);
         var1.add(var4);
      }

      for (float var13 = var4 = 22.0F; var13 <= var0; var13 = var4) {
         var1.add(-var4);
         var1.add(var4);
         var4 += 2.0F;
      }

      float[] var12 = new float[var1.size()];

      int var3;
      for (int var14 = var3 = 0; var14 < var12.length; var14 = var3) {
         float var9 = (Float)var1.get(var3);
         int var10 = var3++;
         var12[var10] = var9;
      }

      return var12;
   }

   private static OffStrictEnum getOffStrictEnum3() {
      return DelayModule.DELAY_MODULE.considerInventoryBooleanSetting.getOffStrictEnum();
   }
}
