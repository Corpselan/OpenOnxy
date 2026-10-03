package client.onyx.module.combat;

import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub10;
import client.onyx.event.impl.EventSub6;
import client.onyx.interact.DoNotHideHideBothEnum;
import client.onyx.interact.Util;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.OffStrictEnum;
import client.onyx.system.Util4;
import client.onyx.system.Util6;
import client.onyx.system.Util8;
import client.onyx.system.YawPitchRecord;
import client.onyx.util.Cls7;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockBed.EnumPartType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class BedBreakerModule extends Module {
   private boolean bool2;
   public ValueSettingSub9 valueSettingSub9;
   public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Range", 4.5, 1.0, 6.0, 0.05).getValueSettingSub10("m");
   public ValueSettingSub9 valueSettingSub92;
   private BlockPos blockPos;
   private int int_;
   private BlockPos blockPos2;
   public ValueSettingSub9 valueSettingSub93;
   private BlockPos blockPos3;
   public ValueSettingSub11<OffStrictEnum> valueSettingSub112 = new ValueSettingSub11<>("Move fix", OffStrictEnum.SILENT)
      .getBooleanSetting("Keeps movement consistent with the rotation the server sees");
   private static final long LONG = 10L;
   public ValueSettingSub11<DoNotHideHideBothEnum> valueSettingSub113 = new ValueSettingSub11<>("Swing", DoNotHideHideBothEnum.DO_NOT_HIDE)
      .getBooleanSetting("How the mining swing is shown");
   private static final long LONG2 = 400L;
   private final Cls7 cls7;
   private final Cls7 cls72;

   private EnumFacing getEnumFacing2(BlockPos var1, YawPitchRecord var2) {
      Vec3 var3 = Util4.getVec323();
      Vec3 var6 = Util4.getVec3ForFloat5(var2.yaw(), var2.pitch());
      double var4 = this.valueSettingSub10.getFloat5() + 1.0;
      Vec3 var7 = var3.addVector(var6.xCoord * var4, var6.yCoord * var4, var6.zCoord * var4);
      MovingObjectPosition var8;
      return (var8 = MINECRAFT.theWorld.rayTraceBlocks(var3, var7, false, false, false)) != null
            && var8.typeOfHit == MovingObjectType.BLOCK
            && var1.equals(var8.getBlockPos())
            && var8.sideHit != null
         ? var8.sideHit
         : this.getEnumFacing(var1);
   }

   private BlockPos getBlockPos5(BlockPos var1) {
      Vec3 var17 = Util4.getVec323();
      boolean var18 = false;
      BlockPos var4 = null;
      double var5 = -1.0;
      double var7 = Double.MAX_VALUE;
      boolean var9 = false;
      BlockPos[] var10;
      int var11 = (var10 = this.getBlockPosArray(var1)).length;

      int var12;
      for (int var10000 = var12 = 0; var10000 < var11; var10000 = ++var12) {
         BlockPos var13 = var10[var12];
         EnumFacing[] var25 = new EnumFacing[5];
         boolean var10002 = true;
         var25[0] = EnumFacing.UP;
         var25[1] = EnumFacing.NORTH;
         var25[2] = EnumFacing.EAST;
         var25[3] = EnumFacing.SOUTH;
         var25[4] = EnumFacing.WEST;
         EnumFacing[] var14 = var25;
         int var15 = var25.length;

         int var16;
         for (int var26 = var16 = 0; var26 < var15; var26 = ++var16) {
            EnumFacing var23 = var14[var16];
            BlockPos var24 = var13.offset(var23);
            Block var3 = MINECRAFT.theWorld.getBlockState(var24).getBlock();
            if (this.isBlockPos5(var24, var3)) {
               var18 = true;
            } else {
               double var19;
               if (!(var3 instanceof BlockBed) && this.isBlockPos4(var24) && !((var19 = this.getDouble28(var24, var3)) <= 0.0)) {
                  if (var24.equals(this.blockPos3)) {
                     var9 = true;
                  }

                  double var21 = var17.squareDistanceTo(Util4.getVec3ForVec310(var17, this.getAxisAlignedBB6(var24)));
                  if (var19 > var5 || var19 == var5 && var21 < var7) {
                     var5 = var19;
                     var7 = var21;
                     var4 = var24;
                  }
               }
            }
         }
      }

      if (var18) {
         return var1;
      } else {
         return var9 ? this.blockPos3 : var4;
      }
   }

   private float getFloat91(ItemStack var1, Block var2) {
      if (var1 == null) {
         return 1.0F;
      } else {
         float var3 = !var1.canHarvestBlock(var2) && var1.getItem() instanceof ItemPickaxe ? 1.0F : var1.getStrVsBlock(var2);
         int var8;
         if (var1.getItem() instanceof ItemTool && var3 > 1.0F && (var8 = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var1)) > 0) {
            float var6 = var8 * var8 + 1;
            var3 += var6;
         }

         return var3;
      }
   }

   @EventHandler
   public void handleEventSub102(EventSub10 var1) {
      if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
         if (this.valueSettingSub9.isEnabled17() && OnyxClient.cls.killAuraModule.isEnabled55()) {
            if (OnyxClient.cls.killAuraModule.getEntityLivingBase4() != null) {
               this.cls72.run();
            }

            if (!this.cls72.isLong2(400L)) {
               this.run128();
               return;
            }
         }

         BlockPos var4;
         if ((var4 = this.getBlockPos4()) == null) {
            this.run128();
         } else {
            BlockPos var3;
            if ((var3 = this.getBlockPos5(var4)) == null) {
               this.run128();
            } else {
               this.blockPos = var4;
               YawPitchRecord var5 = Util8.getYawPitchRecordForVec32(this.getVec317(var3), Util6.getYawPitchRecord25());
               this.handleBlockPos3(var3, var5);
               EnumFacing var6 = this.getEnumFacing2(var3, var5);
               this.handleBlockPos2(var3);
               MINECRAFT.playerController.onPlayerDamageBlock(var3, var6);
               this.valueSettingSub113.lambda15().run2();
               this.blockPos2 = var3;
               this.blockPos3 = var3;
            }
         }
      }
   }

   private void handleBlockPos2(BlockPos var1) {
      Block var8 = MINECRAFT.theWorld.getBlockState(var1).getBlock();
      int var2 = MINECRAFT.thePlayer.inventory.currentItem;
      int var3 = MINECRAFT.thePlayer.inventory.currentItem;
      float var4 = this.getFloat91(MINECRAFT.thePlayer.inventory.getStackInSlot(var2), var8);

      int var7;
      for (int var10000 = var7 = 0; var10000 < 9; var10000 = ++var7) {
         float var6;
         if ((var6 = this.getFloat91(MINECRAFT.thePlayer.inventory.getStackInSlot(var7), var8)) > var4) {
            var4 = var6;
            var3 = var7;
         }
      }

      if (var3 != var2) {
         if (this.int_ == -1) {
            this.int_ = var2;
         }

         MINECRAFT.thePlayer.inventory.currentItem = var3;
      }
   }

   private double getDouble28(BlockPos var1, Block var2) {
      float var3;
      if ((var3 = var2.getBlockHardness(MINECRAFT.theWorld, var1)) < 0.0F) {
         return -1.0;
      } else {
         return var3 == 0.0F ? Double.MAX_VALUE : this.getFloat90(var2) / var3;
      }
   }

   private void handleBlockPos3(BlockPos var1, YawPitchRecord var2) {
      if (this.valueSettingSub93.isEnabled17()) {
         Util6.handleYawPitchRecord3(var2, this.valueSettingSub112.lambda15());
      } else if (!var1.equals(this.blockPos2)) {
         Util6.handleYawPitchRecord3(var2, this.valueSettingSub112.lambda15());
         this.cls7.run();
         this.bool2 = true;
      } else {
         if (this.bool2 && this.cls7.isLong2(10L)) {
            Util6.run183();
            this.bool2 = false;
         }
      }
   }

   public BedBreakerModule() {
      super("BedBreaker", "Breaks nearby beds with the best tool", ModuleCategory.COMBAT);
      this.valueSettingSub93 = new ValueSettingSub9("Keep rotation", false)
         .getBooleanSetting("Holds the aim on the block the whole time instead of a brief flick per block");
      this.valueSettingSub92 = new ValueSettingSub9("Ignore own bed", true)
         .getBooleanSetting("Skips your team's bed, found from the BedWars start message and base teleport");
      this.valueSettingSub9 = new ValueSettingSub9("Prioritize KillAura", false)
         .getBooleanSetting("Pauses bed breaking while KillAura has a target so attacks take priority");
      this.int_ = -1;
      this.cls7 = new Cls7();
      this.cls72 = new Cls7();
   }

   @Override
   protected void run79() {
      this.run128();
   }

   private BlockPos[] getBlockPosArray(BlockPos var1) {
      IBlockState var6;
      if (!((var6 = MINECRAFT.theWorld.getBlockState(var1)).getBlock() instanceof BlockBed)) {
         return new BlockPos[]{var1};
      } else {
         EnumPartType var3 = var6.getValue(BlockBed.PART);
         EnumFacing var7 = var6.getValue(BlockBed.FACING);
         BlockPos var8 = var1.offset(var3 == EnumPartType.HEAD ? var7.getOpposite() : var7);
         return new BlockPos[]{var1, var8};
      }
   }

   public BlockPos getBlockPos3() {
      return this.blockPos3;
   }

   private float getFloat90(Block var1) {
      float var4 = 1.0F;

      int var3;
      for (int var10000 = var3 = 0; var10000 < 9; var10000 = var3) {
         ItemStack var10002 = MINECRAFT.thePlayer.inventory.getStackInSlot(var3);
         var3++;
         var4 = Math.max(var4, this.getFloat91(var10002, var1));
      }

      return var4;
   }

   private void run128() {
      if (this.blockPos3 != null) {
         MINECRAFT.playerController.resetBlockRemoving();
         this.blockPos3 = null;
      }

      if (this.int_ != -1) {
         if (MINECRAFT.thePlayer != null) {
            MINECRAFT.thePlayer.inventory.currentItem = this.int_;
            if (MINECRAFT.playerController != null) {
               MINECRAFT.playerController.syncCurrentPlayItem();
            }
         }

         this.int_ = -1;
      }

      this.blockPos2 = null;
      this.blockPos = null;
      this.bool2 = false;
      Util6.run183();
   }

   private EnumFacing getEnumFacing(BlockPos var1) {
      Vec3 var9 = Util4.getVec323();
      EnumFacing var3 = EnumFacing.UP;
      double var4 = Double.MAX_VALUE;
      EnumFacing[] var6;
      int var7 = (var6 = EnumFacing.values()).length;

      int var8;
      for (int var10000 = var8 = 0; var10000 < var7; var10000 = ++var8) {
         EnumFacing var13 = var6[var8];
         if (Util.isBlockPos2(var1.offset(var13))) {
            Vec3 var10 = new Vec3(
               var1.getX() + 0.5 + var13.getFrontOffsetX() * 0.5,
               var1.getY() + 0.5 + var13.getFrontOffsetY() * 0.5,
               var1.getZ() + 0.5 + var13.getFrontOffsetZ() * 0.5
            );
            double var11;
            if ((var11 = var9.squareDistanceTo(var10)) < var4) {
               var4 = var11;
               var3 = var13;
            }
         }
      }

      return var3;
   }

   private boolean isBlockPos4(BlockPos var1) {
      double var2 = this.valueSettingSub10.getFloat5();
      Vec3 var10000 = Util4.getVec323();
      return var10000.squareDistanceTo(Util4.getVec3ForVec310(var10000, this.getAxisAlignedBB6(var1))) <= var2 * var2;
   }

   @EventHandler
   public void handleEventSub610(EventSub6 var1) {
      this.run128();
   }

   private AxisAlignedBB getAxisAlignedBB6(BlockPos var1) {
      return Util.getAxisAlignedBBForBlockPos(var1).offset(var1.getX(), var1.getY(), var1.getZ());
   }

   public BlockPos getBlockPos6() {
      return this.blockPos;
   }

   private boolean isBlockPos5(BlockPos var1, Block var2) {
      return Util.isBlockPos2(var1) || var2.getMaterial().isReplaceable();
   }

   private BlockPos getBlockPos4() {
      double var1;
      double var10001 = var1 = this.valueSettingSub10.getFloat5();
      double var3 = var10001 * var10001;
      Vec3 var5 = Util4.getVec323();
      if (this.blockPos != null
         && MINECRAFT.theWorld.getBlockState(this.blockPos).getBlock() instanceof BlockBed
         && (!this.valueSettingSub92.isEnabled17() || !Cls.CLS.isBlockPos6(this.blockPos))
         && var5.squareDistanceTo(Util4.getVec3ForVec310(var5, this.getAxisAlignedBB6(this.blockPos))) <= var3) {
         return this.blockPos;
      } else {
         BlockPos var6 = new BlockPos(MINECRAFT.thePlayer);
         int var15 = (int)Math.ceil(var1);
         BlockPos var8 = null;
         var1 = Double.MAX_VALUE;

         int var9;
         int var10;
         for (int var10000 = var9 = -var15; var10000 <= var15; var10000 = ++var9) {
            int var11;
            for (int var17 = var10 = -var15; var17 <= var15; var17 = ++var10) {
               for (int var18 = var11 = -var15; var18 <= var15; var18 = ++var11) {
                  BlockPos var12 = var6.add(var9, var10, var11);
                  double var13;
                  if (MINECRAFT.theWorld.getBlockState(var12).getBlock() instanceof BlockBed
                     && (!this.valueSettingSub92.isEnabled17() || !Cls.CLS.isBlockPos6(var12))
                     && !((var13 = var5.squareDistanceTo(Util4.getVec3ForVec310(var5, this.getAxisAlignedBB6(var12)))) > var3)
                     && var13 < var1) {
                     var1 = var13;
                     var8 = var12;
                  }
               }
            }
         }

         return var8;
      }
   }

   private Vec3 getVec317(BlockPos var1) {
      return Util4.getVec3ForVec310(Util4.getVec323(), this.getAxisAlignedBB6(var1));
   }
}
