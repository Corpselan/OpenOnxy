package client.onyx.module.player.scaffold.mode;

import client.onyx.event.impl.EventSub16;
import client.onyx.interact.Util;
import client.onyx.interact.placement.Cls;
import client.onyx.interact.placement.Cls2;
import client.onyx.interact.placement.Cls3;
import client.onyx.interact.placement.Cls4;
import client.onyx.interact.placement.HitVecStrategySub2;
import client.onyx.interact.placement.InteractedBlockPosPlacedBlockRecord;
import client.onyx.interact.placement.NoOffsetNormalEnum;
import client.onyx.module.player.DelayModule;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.Util2;
import client.onyx.util.Util6;
import client.onyx.util.math.PositionDirectionRecord;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;

public class BreezilyScaffoldMode extends ScaffoldMode {
   private transient double double_;
   public ValueSettingSub3 valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString("Edge distance", 0.45, 0.5, 0.25, 0.5)
      .getValueSettingSub3(" blocks");
   private transient long long_;
   private transient float float_;
   public static final BreezilyScaffoldMode BREEZILY_SCAFFOLD_MODE = new BreezilyScaffoldMode();

   private BreezilyScaffoldMode() {
      super("Breezily");
      this.double_ = 0.45;
   }

   private YawPitchRecord getYawPitchRecord14(float var1) {
      return new YawPitchRecord(var1, 80.0F);
   }

   private static boolean isBlockPos13(BlockPos var0) {
      IBlockState var2;
      return (var2 = Util.getIBlockStateForBlockPos(var0)) == null || var2.getBlock().getMaterial() == Material.air;
   }

   @EventHandler(
      priority = -50
   )
   private void handleEventSub169(EventSub16 var1) {
      if (MINECRAFT.thePlayer != null) {
         if (var1.getForwardsBackwardsRecord2().forwards() && !MINECRAFT.thePlayer.isSneaking()) {
            if (isBlockPos13(new BlockPos(MINECRAFT.thePlayer).add(0, -1, 0))) {
               this.long_ = System.currentTimeMillis();
            } else if (System.currentTimeMillis() - this.long_ > 500L) {
               return;
            }

            float var9;
            BreezilyScaffoldMode var10000;
            label74: {
               double var2 = MINECRAFT.thePlayer.posX - Math.floor(MINECRAFT.thePlayer.posX);
               double var4 = MINECRAFT.thePlayer.posZ - Math.floor(MINECRAFT.thePlayer.posZ);
               double var6 = 1.0 - this.double_;
               var9 = 0.0F;
               switch (EnumFacing.fromAngle(MINECRAFT.thePlayer.rotationYaw)) {
                  case SOUTH:

                     if (var2 > var6) {
                        var9 = 1.0F;
                     }

                     if (var2 < this.double_) {
                        var9 = -1.0F;
                        var10000 = this;
                        break label74;
                     }
                     break;
                  case NORTH:
                     if (var2 > var6) {
                        var9 = -1.0F;
                     }

                     if (var2 < this.double_) {
                        var9 = 1.0F;
                        var10000 = this;
                        break label74;
                     }
                     break;
                  case EAST:
                     if (var4 > var6) {
                        var9 = -1.0F;
                     }

                     if (var4 < this.double_) {
                        var9 = 1.0F;
                        var10000 = this;
                        break label74;
                     }
                     break;
                  case WEST:
                     if (var4 > var6) {
                        var9 = 1.0F;
                     }

                     if (var4 < this.double_) {
                        var9 = -1.0F;
                        var10000 = this;
                        break label74;
                     }
               }

               var10000 = this;
            }

            if (var10000.float_ != var9 && var9 != 0.0F) {
               this.float_ = var9;
               this.double_ = this.valueSettingSub3.getDouble();
            }

            boolean var10003 = var1.getForwardsBackwardsRecord2().forwards();
            boolean var10004 = var1.getForwardsBackwardsRecord2().backwards();
            boolean var10005;
            BreezilyScaffoldMode var10006;
            if (this.float_ == -1.0F) {
               var10005 = true;
               var10006 = this;
            } else {
               var10005 = false;
               var10006 = this;
            }

            ForwardsBackwardsRecord var10001 = new ForwardsBackwardsRecord(var10003, var10004, var10005, var10006.float_ == 1.0F);
            var1.handleForwardsBackwardsRecord(var10001);
         }
      }
   }

   private YawPitchRecord getYawPitchRecord13(float var1) {
      return new YawPitchRecord(var1, 75.6F);
   }

   private YawPitchRecord getYawPitchRecord15(InteractedBlockPosPlacedBlockRecord var1) {
      float var2 = (float)(Math.floor(var1.rotation().yaw2() / 90.0F) * 90.0);
      return new YawPitchRecord(var2 + 45.0F, 75.0F);
   }

   @Override
   public InteractedBlockPosPlacedBlockRecord getInteractedBlockPosPlacedBlockRecord(Vec3 var1, boolean var2, PositionDirectionRecord var3, ItemStack var4) {
      Cls var5 = new Cls(
         new Cls2(NoOffsetNormalEnum.NORMAL.getList(), Cls.getComparatorForVec3(var1)),
         new Cls3(HitVecStrategySub2.HIT_VEC_STRATEGY_SUB2),
         var4,
         new Cls4(var1, var2)
      );
      return client.onyx.interact.placement.Util.getInteractedBlockPosPlacedBlockRecordForBlockPos(
         DelayModule.DELAY_MODULE.getBlockPos10(Util6.getBlockPosForVec3(var1)), var5
      );
   }

   @Override
   public YawPitchRecord getYawPitchRecord16(InteractedBlockPosPlacedBlockRecord var1) {
      if (DelayModule.DELAY_MODULE.getForwardsBackwardsRecord2().equals(ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8)) {
         return var1 == null ? null : this.getYawPitchRecord15(var1);
      } else {
         float var3;
         boolean var2 = (
                  var3 = (float)(
                     Math.rint((Util2.getFloatForEntityPlayerSP4(MINECRAFT.thePlayer, DelayModule.DELAY_MODULE.getForwardsBackwardsRecord2()) + 180.0F) / 45.0F)
                        * 45.0
                  )
               )
               % 90.0F
            == 0.0F;
         return var2 ? this.getYawPitchRecord14(var3) : this.getYawPitchRecord13(var3);
      }
   }
}
