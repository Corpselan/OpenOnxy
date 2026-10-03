package client.onyx.interact;

import client.onyx.MinecraftAccess;
import client.onyx.util.Cls3;
import java.util.function.BooleanSupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Util implements MinecraftAccess {
   public static final AxisAlignedBB AXIS_ALIGNED_B_B = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);

   public static boolean isMovingObjectPosition(MovingObjectPosition var0) {
      ItemStack var3;
      int var2 = (var3 = MINECRAFT.thePlayer.inventory.getStackInSlot(Cls3.CLS3.getInt55())) == null ? 0 : var3.stackSize;
      if (!MINECRAFT.playerController.onPlayerRightClick(MINECRAFT.thePlayer, MINECRAFT.theWorld, var3, var0.getBlockPos(), var0.sideHit, var0.hitVec)) {
         return false;
      } else {
         if (var3 != null && var3.stackSize == 0) {
            MINECRAFT.thePlayer.inventory.mainInventory[Cls3.CLS3.getInt55()] = null;
         } else if (var3 != null && (var3.stackSize != var2 || MINECRAFT.playerController.isInCreativeMode())) {
            MINECRAFT.entityRenderer.itemRenderer.resetEquippedProgress();
         }

         return true;
      }
   }

   public static AxisAlignedBB getAxisAlignedBBForIBlockState(IBlockState var0, BlockPos var1) {
      Block var3;
      (var3 = var0.getBlock()).setBlockBoundsBasedOnState(MINECRAFT.theWorld, var1);
      AxisAlignedBB var4;
      boolean var5 = (var4 = new AxisAlignedBB(
                  var3.getBlockBoundsMinX(),
                  var3.getBlockBoundsMinY(),
                  var3.getBlockBoundsMinZ(),
                  var3.getBlockBoundsMaxX(),
                  var3.getBlockBoundsMaxY(),
                  var3.getBlockBoundsMaxZ()
               ))
               .getXsize()
            <= 0.0
         || var4.getYsize() <= 0.0
         || var4.getZsize() <= 0.0;
      return var5 ? AXIS_ALIGNED_B_B : var4;
   }

   public static BlockPos getBlockPosForMovingObjectPosition(MovingObjectPosition var0) {
      return var0.getBlockPos().offset(var0.sideHit);
   }

   public static Block getBlockForBlockPos(BlockPos var0) {
      IBlockState var2;
      return (var2 = getIBlockStateForBlockPos(var0)) == null ? null : var2.getBlock();
   }

   public static boolean isBlockPos2(BlockPos var0) {
      Block var2;
      return (var2 = getBlockForBlockPos(var0)) == null || var2.getMaterial() == Material.air;
   }

   public static IBlockState getIBlockStateForBlockPos2(BlockPos var0) {
      IBlockState var2;
      return (var2 = getIBlockStateForBlockPos(var0)) != null ? var2 : Blocks.air.getDefaultState();
   }

   public static void handleMovingObjectPosition(MovingObjectPosition var0) {
      handleMovingObjectPosition2(var0, () -> true, () -> true, DoNotHideHideBothEnum.DO_NOT_HIDE);
   }

   public static boolean isIBlockState(IBlockState var0, BlockPos var1, ItemStack var2) {
      return var0.getBlock().isReplaceable(MINECRAFT.theWorld, var1);
   }

   public static IBlockState getIBlockStateForBlockPos(BlockPos var0) {
      return MINECRAFT.theWorld == null ? null : MINECRAFT.theWorld.getBlockState(var0);
   }

   public static void handleMovingObjectPosition2(MovingObjectPosition var0, BooleanSupplier var1, BooleanSupplier var2, DoNotHideHideBothEnum var3) {
      ItemStack var6;
      int var5 = (var6 = MINECRAFT.thePlayer.inventory.getStackInSlot(Cls3.CLS3.getInt55())) == null ? 0 : var6.stackSize;
      if (!MINECRAFT.playerController.onPlayerRightClick(MINECRAFT.thePlayer, MINECRAFT.theWorld, var6, var0.getBlockPos(), var0.sideHit, var0.hitVec)) {
         if (var6 != null) {
            if (MINECRAFT.playerController.sendUseItem(MINECRAFT.thePlayer, MINECRAFT.theWorld, var6)) {
               if (var2.getAsBoolean()) {
                  var3.run2();
               }

               MINECRAFT.entityRenderer.itemRenderer.resetEquippedProgress2();
            }
         }
      } else {
         if (var1.getAsBoolean()) {
            var3.run2();
         }

         if (var6 != null && var6.stackSize == 0) {
            MINECRAFT.thePlayer.inventory.mainInventory[Cls3.CLS3.getInt55()] = null;
         } else {
            if (var6 != null && (var6.stackSize != var5 || MINECRAFT.playerController.isInCreativeMode())) {
               MINECRAFT.entityRenderer.itemRenderer.resetEquippedProgress();
            }
         }
      }
   }

   public static AxisAlignedBB getAxisAlignedBBForBlockPos(BlockPos var0) {
      IBlockState var2;
      return (var2 = getIBlockStateForBlockPos(var0)) != null && var2.getBlock().getMaterial() != Material.air
         ? getAxisAlignedBBForIBlockState(var2, var0)
         : AXIS_ALIGNED_B_B;
   }

   public static boolean isBlock(Block var0) {
      return var0 instanceof BlockSlab || var0 instanceof BlockStairs;
   }

   public static boolean isBlockPos(BlockPos var0) {
      return getIBlockStateForBlockPos(var0) != null && World.doesBlockHaveSolidTopSurface(MINECRAFT.theWorld, var0);
   }
}
