package client.onyx.render.particle;

import client.onyx.module.render.ParticlesModule;
import client.onyx.theme.impl.Util2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public final class Cls {
   private static final float FLOAT = 0.1F;
   private double double_;
   private boolean bool;
   private final int int_;
   private final int int_2;
   private final ParticlesModule particlesModule;
   private final Cls.AttackWalkingEnum attackWalkingEnum;
   private double double_2;
   private final World world;
   private double double_3;
   private double double_4;
   private float float_;
   private static final double DOUBLE = 1.0E-7;
   private final long long_ = System.currentTimeMillis();
   private double double_5;
   private double double_6;

   public void run2() {
      if (this.bool) {
         if (!this.isEnabled2()) {
            this.run();
         } else {
            long var1;
            if ((var1 = this.getLong()) >= this.attackWalkingEnum.long_) {
               this.run();
            } else {
               Cls var10000;
               if (this.particlesModule.valueSettingSub92.isEnabled17()) {
                  this.handleDouble(this.particlesModule.valueSettingSub104.lambda15());
                  var10000 = this;
               } else {
                  this.double_3 = this.double_3 + this.double_5;
                  var10000 = this;
                  this.double_4 = this.double_4 + this.double_;
                  this.double_6 = this.double_6 + this.double_2;
               }

               var10000.float_ = Util.getFloatForLong(var1, this.attackWalkingEnum.long_2);
            }
         }
      }
   }

   public void run() {
      this.bool = false;
   }

   private boolean isDouble(double var1, double var3, double var5) {
      BlockPos var11 = new BlockPos(var1, var3, var5);
      if (!this.world.isBlockLoaded(var11)) {
         return false;
      } else {
         Block var9 = this.world.getBlockState(var11).getBlock();
         return this.isBlock(var9);
      }
   }

   private boolean isBlock(Block var1) {
      return !(var1 instanceof BlockAir)
         && !(var1 instanceof BlockBush)
         && !(var1 instanceof BlockButton)
         && !(var1 instanceof BlockTorch)
         && !(var1 instanceof BlockLever)
         && !(var1 instanceof BlockBasePressurePlate)
         && !(var1 instanceof BlockCarpet)
         && !(var1 instanceof BlockLiquid);
   }

   public Cls(ParticlesModule var1, World var2, Cls.AttackWalkingEnum var3, int var4, int var5, Vec3 var6, Vec3 var7) {
      this.bool = true;
      this.particlesModule = var1;
      this.world = var2;
      this.attackWalkingEnum = var3;
      this.int_ = var4;
      this.int_2 = var5;
      this.double_3 = var6.xCoord;
      this.double_4 = var6.yCoord;
      this.double_6 = var6.zCoord;
      this.double_5 = Util.getDoubleForDouble(var7.xCoord);
      this.double_ = Util.getDoubleForDouble(var7.yCoord);
      this.double_2 = Util.getDoubleForDouble(var7.zCoord);
   }

   private long getLong2() {
      return Math.max(0L, System.currentTimeMillis() - this.long_);
   }

   private boolean isEnabled2() {
      return this.particlesModule != null && this.particlesModule.isEnabled55() && ParticlesModule.MINECRAFT.theWorld == this.world;
   }

   public boolean isEnabled() {
      return this.bool;
   }

   private double getDouble(double var1, double var3, double var5) {
      BlockPos var9 = new BlockPos(var1, var3 - 1.0E-7, var5);
      if (!this.world.isBlockLoaded(var9)) {
         return Double.NaN;
      } else {
         IBlockState var8;
         if (!this.isBlock((var8 = this.world.getBlockState(var9)).getBlock())) {
            return Double.NaN;
         } else {
            AxisAlignedBB var10;
            if ((var10 = var8.getBlock().getCollisionBoundingBox(this.world, var9, var8)) == null) {
               return Double.NaN;
            } else if (var1 + 1.0E-7 < var10.minX || var1 - 1.0E-7 > var10.maxX || var5 + 1.0E-7 < var10.minZ || var5 - 1.0E-7 > var10.maxZ) {
               return Double.NaN;
            } else {
               return var3 <= var10.maxY + 1.0E-7 ? var10.maxY : Double.NaN;
            }
         }
      }
   }

   private long getLong() {
      return Util.getLongForLong(this.getLong2(), this.particlesModule.valueSettingSub105.lambda15());
   }

   public void handleWorldRenderer2(WorldRenderer var1, Vec3 var2, float var3, float var4, float var5, float var6, float var7) {
      if (this.bool && !(this.float_ <= 0.0F)) {
         int var17 = this.particlesModule.getInt26(this.int_, this.int_2);
         int var9 = Math.round((float)Math.pow(Math.clamp(this.float_, 0.0F, 1.0F), 0.72) * 255.0F);
         float var10 = 0.1F * this.particlesModule.valueSettingSub10.getFloat5();
         double var11 = this.double_3 - var2.xCoord;
         double var13 = this.double_4 - var2.yCoord;
         double var15 = this.double_6 - var2.zCoord;
         handleWorldRenderer(
            var1,
            var11,
            var13,
            var15,
            var10,
            Util2.getIntForInt7(var17),
            Util2.getIntForInt(var17),
            Util2.getIntForInt2(var17),
            var9,
            var3,
            var4,
            var5,
            var6,
            var7
         );
         handleWorldRenderer(var1, var11, var13, var15, var10 * 0.5F, 255, 255, 255, var9, var3, var4, var5, var6, var7);
      }
   }

   private void handleDouble(double var1) {
      if (this.isDouble(this.double_3, this.double_4, this.double_6 + this.double_2 * var1)) {
         this.double_2 *= -0.8;
      }

      double var3 = 0.1F * this.particlesModule.valueSettingSub10.lambda15() + 1.0E-7;
      double var5 = this.double_ <= 0.0 ? this.getDouble(this.double_3, this.double_4 + this.double_ * var1 - var3, this.double_6) : Double.NaN;
      boolean var10 = this.double_ <= 0.0 ? Double.isFinite(var5) : this.isDouble(this.double_3, this.double_4 + this.double_ * var1, this.double_6);
      if (var10) {
         this.double_5 *= 0.999;
         this.double_2 *= 0.999;
         this.double_ *= -0.7;
      }

      if (this.isDouble(this.double_3 + this.double_5 * var1, this.double_4, this.double_6)) {
         this.double_5 *= -0.8;
      }

      double var8 = this.double_4 + this.double_ * var1;
      if (Double.isFinite(var5)) {
         var8 = Math.max(var8, var5 + var3);
      }

      this.double_3 = this.double_3 + this.double_5 * var1;
      this.double_4 = var8;
      this.double_6 = this.double_6 + this.double_2 * var1;
      var3 = Math.pow(0.999999, var1);
      this.double_5 /= var3;
      this.double_ -= 5.0E-5 * var1;
      this.double_2 /= var3;
   }

   private static void handleWorldRenderer(
      WorldRenderer var0,
      double var1,
      double var3,
      double var5,
      float var7,
      int var8,
      int var9,
      int var10,
      int var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16
   ) {
      var0.pos(var1 - var12 * var7 - var15 * var7, var3 - var13 * var7, var5 - var14 * var7 - var16 * var7)
         .tex(0.0, 0.0)
         .color(var8, var9, var10, var11)
         .endVertex();
      var0.pos(var1 - var12 * var7 + var15 * var7, var3 + var13 * var7, var5 - var14 * var7 + var16 * var7)
         .tex(0.0, 1.0)
         .color(var8, var9, var10, var11)
         .endVertex();
      var0.pos(var1 + var12 * var7 + var15 * var7, var3 + var13 * var7, var5 + var14 * var7 + var16 * var7)
         .tex(1.0, 1.0)
         .color(var8, var9, var10, var11)
         .endVertex();
      var0.pos(var1 + var12 * var7 - var15 * var7, var3 - var13 * var7, var5 + var14 * var7 - var16 * var7)
         .tex(1.0, 0.0)
         .color(var8, var9, var10, var11)
         .endVertex();
   }

   public static enum AttackWalkingEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      ATTACK(5000L, 2000L),
      WALKING(3500L, 3000L);
      final long long_;
      final long long_2;

      private AttackWalkingEnum(long var3, long var5) {
         this.long_ = var3;
         this.long_2 = var5;
      }

   }
}
