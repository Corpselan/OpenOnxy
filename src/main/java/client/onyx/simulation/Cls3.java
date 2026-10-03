package client.onyx.simulation;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub5;
import client.onyx.util.Util2;
import client.onyx.util.Util6;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Cls3 implements Iface, MinecraftAccess {
   private Vec3 vec3;
   private boolean bool;
   private double double_;
   private static final double DOUBLE = 1.0;
   private float float_;
   private Vec3 vec32;
   private int int_;
   private boolean bool2;
   private boolean bool3;
   private int int_2;
   private final EntityPlayer entityPlayer;
   private float float_2;
   private boolean bool4;
   private boolean bool5;
   private Cls2 cls2;
   private boolean bool6;
   private AxisAlignedBB axisAlignedBB;

   private boolean isEnabled29() {
      return this.getWorld().isMaterialInBB(this.axisAlignedBB.expand(-0.1F, -0.4F, -0.1F), Material.lava);
   }

   private void run20() {
      this.double_ = 0.0;
   }

   public boolean isEnabled33() {
      return this.bool;
   }

   public static Cls3 getCls3ForCls2(Cls2 var0) {
      return getCls3ForEntityPlayer2(MINECRAFT.thePlayer, var0, Util2.getVec3ForEntity3(MINECRAFT.thePlayer));
   }

   public boolean isEnabled36() {
      return this.bool3;
   }

   public void handleCls2(Cls2 var1) {
      this.cls2 = var1;
   }

   private boolean isEnabled28() {
      Block var2;
      return (
               var2 = this.getIBlockState2(
                     new BlockPos(
                        MathHelper.floor_double(this.vec3.xCoord), MathHelper.floor_double(this.axisAlignedBB.minY), MathHelper.floor_double(this.vec3.zCoord)
                     )
                  )
                  .getBlock()
            )
            == Blocks.ladder
         || var2 == Blocks.vine;
   }

   public void handleVec34(Vec3 var1) {
      this.vec3 = var1;
      this.axisAlignedBB = Util2.getAxisAlignedBBForVec3(var1);
   }

   public float getFloat13() {
      return this.float_;
   }

   public Cls2 getCls24() {
      return this.cls2;
   }

   public void handleBool7(boolean var1) {
      this.bool2 = var1;
   }

   public int getInt14() {
      return this.int_;
   }

   private IBlockState getIBlockState2(BlockPos var1) {
      return this.getWorld().getBlockState(var1);
   }

   private boolean isAxisAlignedBB(AxisAlignedBB var1) {
      return this.getWorld().getCollidingBoundingBoxes(this.entityPlayer, var1).isEmpty();
   }

   public boolean isEnabled37() {
      return this.bool5;
   }

   public Cls3 getCls3() {
      return new Cls3(
         this.entityPlayer,
         this.cls2,
         this.vec3,
         this.vec32,
         this.axisAlignedBB,
         this.float_2,
         this.float_,
         this.bool4,
         this.double_,
         this.int_,
         this.bool2,
         this.bool3,
         this.bool5,
         this.bool
      );
   }

   private float getFloat10() {
      float var2 = 0.02F;
      return this.cls2.isEnabled25() ? (float)(var2 + var2 * 0.3) : var2;
   }

   public void handleVec3(Vec3 var1) {
      this.vec32 = var1;
   }

   private Vec3 getVec39(Vec3 var1) {
      if (!this.isEnabled28()) {
         return var1;
      } else {
         this.run20();
         double var2 = MathHelper.clamp_double(var1.xCoord, -0.15F, 0.15F);
         double var4 = MathHelper.clamp_double(var1.zCoord, -0.15F, 0.15F);
         double var6;
         if ((var6 = Math.max(var1.yCoord, -0.15F)) < 0.0 && this.cls2.forwardBackwardRecord.shift()) {
            var6 = 0.0;
         }

         return new Vec3(var2, var6, var4);
      }
   }

   public void handleInt9(int var1) {
      this.int_2 = var1;
   }

   public void handleBool10(boolean var1) {
      this.bool3 = var1;
   }

   public Vec3 getVec38() {
      return this.vec32;
   }

   private float getFloat12() {
      return this.entityPlayer.getAIMoveSpeed();
   }

   private static Cls3 getCls3ForEntityPlayer2(EntityPlayer var0, Cls2 var1, Vec3 var2) {
      Vec3 var10004 = Util2.getVec3ForEntity2(var0);
      AxisAlignedBB var10006 = var0.getEntityBoundingBox();
      float var10007 = var0.rotationYaw;
      float var10008 = var0.rotationPitch;
      boolean var10009 = var0.isSprinting();
      double var10010 = var0.fallDistance;
      EntityPlayerSP var3;
      boolean var10012;
      EntityPlayer var10013;
      if (var0 instanceof EntityPlayerSP && (var3 = (EntityPlayerSP)var0).movementInput != null && var3.movementInput.jump) {
         var10012 = true;
         var10013 = var0;
      } else {
         var10012 = false;
         var10013 = var0;
      }

      Cls3 var10000 = new Cls3(
         var0,
         var1,
         var10004,
         var2,
         var10006,
         var10007,
         var10008,
         var10009,
         var10010,
         0,
         var10012,
         var10013.onGround,
         var0.isCollidedHorizontally,
         var0.isCollidedVertically
      );
      return var10000;
   }

   private boolean isEnabled34() {
      return this.getWorld().isMaterialInBB(this.axisAlignedBB.expand(0.0, -0.4F, 0.0).contract(0.001, 0.001, 0.001), Material.water);
   }

   public void handleDouble4(double var1) {
      this.double_ = var1;
   }

   public boolean isEnabled30() {
      return this.bool2;
   }

   public float getFloat11() {
      return this.float_2;
   }

   public int getInt13() {
      return this.int_2;
   }

   private void handleFloat3(float var1, Vec3 var2) {
      Vec3 var3 = this.vec32;
      Vec3 var4 = Util2.getVec3ForVec37(var2, var1, this.float_2);
      Vec3 var5 = var3.add(var4);
      this.vec32 = var5;
   }

   private IBlockState getIBlockState() {
      return this.getIBlockState2(
         new BlockPos(
            MathHelper.floor_double(this.vec3.xCoord), MathHelper.floor_double(this.axisAlignedBB.minY) - 1, MathHelper.floor_double(this.vec3.zCoord)
         )
      );
   }

   public void run18() {
      this.vec32 = Util6.getVec3ForVec38(this.vec32, 0.42F);
      PotionEffect var2;
      if ((var2 = this.entityPlayer.getActivePotionEffect(Potion.jump)) != null) {
         this.vec32 = this.vec32.add(0.0, (var2.getAmplifier() + 1) * 0.1F, 0.0);
      }

      if (this.bool4) {
         float var3 = this.float_2 * (float) (Math.PI / 180.0);
         this.vec32 = this.vec32.add(-MathHelper.sin(var3) * 0.2F, 0.0, MathHelper.cos(var3) * 0.2F);
      }
   }

   private void handleVec33(Vec3 var1) {
      EventSub5 var5 = new EventSub5(var1);
      OnyxClient.I_EVENT_BUS.post(var5);
      var1 = var5.getVec3();
      if (this.isEnabled27()) {
         var1 = var1.multiply(0.25, 0.05F, 0.25);
         this.vec32 = Vec3.ZERO;
      }

      Vec3 var2;
      if ((var2 = this.getVec312(var1 = this.getVec310(var1))).lengthSqr() > 1.0E-7) {
         this.vec3 = this.vec3.add(var2);
         this.axisAlignedBB = Util2.getAxisAlignedBBForVec3(this.vec3);
      }

      boolean var4 = var1.xCoord != var2.xCoord;
      boolean var3 = var1.zCoord != var2.zCoord;
      this.bool5 = var4 || var3;
      this.bool = var1.yCoord != var2.yCoord;
      this.bool3 = this.bool && var1.yCoord < 0.0;
      Cls3 var10000;
      if (this.bool3) {
         var10000 = this;
         this.run20();
      } else {
         if (var2.yCoord < 0.0) {
            this.double_ = this.double_ - var2.yCoord;
         }

         var10000 = this;
      }

      var1 = var10000.vec32;
      if (this.bool5 || this.bool) {
         double var10003;
         Cls3 var10004;
         if (var4) {
            var10003 = 0.0;
            var10004 = this;
         } else {
            var10003 = var1.xCoord;
            var10004 = this;
         }

         double var9;
         boolean var10005;
         if (var10004.bool3) {
            var9 = 0.0;
            var10005 = var3;
         } else {
            var9 = var1.yCoord;
            var10005 = var3;
         }

         Vec3 var10001 = new Vec3(var10003, var9, var10005 ? 0.0 : var1.zCoord);
         this.vec32 = var10001;
      }
   }

   public void run19() {
      this.run18();
   }

   public void handleAxisAlignedBB(AxisAlignedBB var1) {
      this.axisAlignedBB = var1;
   }

   private Vec3 getVec312(Vec3 var1) {
      Iterator var36 = null;
      double var2 = var1.xCoord;
      double var4 = var1.yCoord;
      double var6 = var1.zCoord;
      double var8 = var2;
      double var10 = var6;
      AxisAlignedBB var12 = this.axisAlignedBB;
      AxisAlignedBB var13 = this.axisAlignedBB;
      List var14;
      Iterator var33;
      Iterator var10000 = var33 = (var14 = this.getWorld().getCollidingBoundingBoxes(this.entityPlayer, var13.addCoord(var2, var4, var6))).iterator();

      while (var10000.hasNext()) {
         AxisAlignedBB var16 = (AxisAlignedBB)var33.next();
         var10000 = var33;
         var4 = var16.calculateYOffset(var13, var4);
      }

      var13 = var13.offset(0.0, var4, 0.0);
      boolean var58 = this.bool3 || var1.yCoord != var4 && var1.yCoord < 0.0;
      Iterator var47;
      var10000 = var47 = var14.iterator();

      while (var10000.hasNext()) {
         AxisAlignedBB var17 = (AxisAlignedBB)var47.next();
         var10000 = var47;
         var2 = var17.calculateXOffset(var13, var2);
      }

      var13 = var13.offset(var2, 0.0, 0.0);
      var10000 = var47 = var14.iterator();

      while (var10000.hasNext()) {
         AxisAlignedBB var52 = (AxisAlignedBB)var47.next();
         var10000 = var47;
         var6 = var52.calculateZOffset(var13, var6);
      }

      var13 = var13.offset(0.0, 0.0, var6);
      float var49 = this.entityPlayer.stepHeight;
      if (this.entityPlayer.stepHeight > 0.0F && var58 && (var8 != var2 || var10 != var6)) {
         double var53 = var2;
         double var19 = var4;
         double var21 = var6;
         var4 = var49;
         List var34 = this.getWorld().getCollidingBoundingBoxes(this.entityPlayer, var12.addCoord(var8, var4, var10));
         AxisAlignedBB var59 = var12.addCoord(var8, 0.0, var10);
         double var23 = var4;

         Iterator var25;
         for (Iterator var67 = var25 = var34.iterator(); var67.hasNext(); var67 = var25) {
            var23 = ((AxisAlignedBB)var25.next()).calculateYOffset(var59, var23);
         }

         AxisAlignedBB var44 = var12.offset(0.0, var23, 0.0);
         double var54 = var8;

         Iterator var27;
         for (Iterator var68 = var27 = var34.iterator(); var68.hasNext(); var68 = var27) {
            var54 = ((AxisAlignedBB)var27.next()).calculateXOffset(var44, var54);
         }

         AxisAlignedBB var45 = var44.offset(var54, 0.0, 0.0);
         double var55 = var10;
         var10000 = var33 = var34.iterator();

         while (var10000.hasNext()) {
            AxisAlignedBB var29 = (AxisAlignedBB)var33.next();
            var10000 = var33;
            var55 = var29.calculateZOffset(var45, var55);
         }

         AxisAlignedBB var46 = var45.offset(0.0, 0.0, var55);
         AxisAlignedBB var61 = var12;
         double var56 = var4;

         Iterator var31;
         for (Iterator var70 = var31 = var34.iterator(); var70.hasNext(); var70 = var31) {
            var56 = ((AxisAlignedBB)var31.next()).calculateYOffset(var61, var56);
         }

         AxisAlignedBB var62 = var61.offset(0.0, var56, 0.0);
         double var57 = var8;

         for (Iterator var71 = var36 = var34.iterator(); var71.hasNext(); var71 = var36) {
            var57 = ((AxisAlignedBB)var36.next()).calculateXOffset(var62, var57);
         }

         AxisAlignedBB var63 = var62.offset(var57, 0.0, 0.0);
         var8 = var10;
         Iterator var38;
         var10000 = var38 = var34.iterator();

         while (var10000.hasNext()) {
            AxisAlignedBB var50 = (AxisAlignedBB)var38.next();
            var10000 = var38;
            var8 = var50.calculateZOffset(var63, var8);
         }

         AxisAlignedBB var64 = var63.offset(0.0, 0.0, var8);
         List var73;
         if (var54 * var54 + var55 * var55 > var57 * var57 + var8 * var8) {
            var2 = var54;
            var6 = var55;
            var4 = -var23;
            var13 = var46;
            var73 = var34;
         } else {
            var2 = var57;
            var6 = var8;
            var4 = -var56;
            var13 = var64;
            var73 = var34;
         }

         Iterator var39;
         var10000 = var39 = var73.iterator();

         while (var10000.hasNext()) {
            AxisAlignedBB var51 = (AxisAlignedBB)var39.next();
            var10000 = var39;
            var4 = var51.calculateYOffset(var13, var4);
         }

         if (var53 * var53 + var21 * var21 >= var2 * var2 + var6 * var6) {
            var2 = var53;
            var4 = var19;
            var6 = var21;
         }
      }

      return new Vec3(var2, var4, var6);
   }

   public void handleBool6(boolean var1) {
      this.bool5 = var1;
   }

   public static Cls3 getCls3ForEntityPlayer(EntityPlayer var0, Cls2 var1) {
      Vec3 var2 = Util2.getVec3ForEntity2(var0);
      Vec3 var3 = Util2.getVec3ForEntity4(var0);
      Vec3 var4 = var2.subtract(var3);
      return getCls3ForEntityPlayer2(var0, var1, var4);
   }

   @Override
   public Vec3 getVec37() {
      return this.vec3;
   }

   private void handleVec32(Vec3 var1) {
      boolean var7 = this.entityPlayer.capabilities.isFlying;
      double var3 = this.vec32.yCoord;
      if (this.isEnabled34() && !var7) {
         double var25 = this.vec3.yCoord;
         float var27 = 0.8F;
         float var26 = 0.02F;
         float var9;
         if ((var9 = EnchantmentHelper.getDepthStriderModifier(this.entityPlayer)) > 3.0F) {
            var9 = 3.0F;
         }

         if (!this.bool3) {
            var9 *= 0.5F;
         }

         if (var9 > 0.0F) {
            float var13 = (0.54600006F - var27) * var9 / 3.0F;
            var27 += var13;
            float var19 = (this.getFloat12() * 1.0F - var26) * var9 / 3.0F;
            var26 += var19;
         }

         this.handleFloat3(var26, var1);
         this.handleVec33(this.vec32);
         this.vec32 = this.vec32.multiply(var27, 0.8F, var27).add(0.0, -0.02, 0.0);
         if (this.bool5 && this.isDouble(this.vec32.xCoord, this.vec32.yCoord + 0.6F - this.vec3.yCoord + var25, this.vec32.zCoord)) {
            this.vec32 = Util6.getVec3ForVec38(this.vec32, 0.3F);
            return;
         }
      } else if (this.isEnabled29() && !var7) {
         double var24 = this.vec3.yCoord;
         this.handleFloat3(0.02F, var1);
         this.handleVec33(this.vec32);
         this.vec32 = this.vec32.scale(0.5).add(0.0, -0.02, 0.0);
         if (this.bool5 && this.isDouble(this.vec32.xCoord, this.vec32.yCoord + 0.6F - this.vec3.yCoord + var24, this.vec32.zCoord)) {
            this.vec32 = Util6.getVec3ForVec38(this.vec32, 0.3F);
            return;
         }
      } else {
         float var5 = 0.91F;
         if (this.bool3) {
            var5 = this.getIBlockState().getBlock().slipperiness * 0.91F;
         }

         float var22 = var5 * var5 * var5;
         float var6 = 0.16277136F / var22;
         float var10 = this.bool3 ? this.getFloat12() * var6 : this.getFloat10();
         this.handleFloat3(var10, var1);
         this.vec32 = this.getVec39(this.vec32);
         this.handleVec33(this.vec32);
         if (this.bool5 && this.isEnabled28()) {
            this.vec32 = Util6.getVec3ForVec38(this.vec32, 0.2);
         }

         double var8 = var7 ? var3 * 0.6 : (this.vec32.yCoord - 0.08) * 0.98F;
         this.vec32 = new Vec3(this.vec32.xCoord * var5, var8, this.vec32.zCoord * var5);
         if (var7) {
            this.run20();
         }
      }
   }

   public AxisAlignedBB getAxisAlignedBB() {
      return this.axisAlignedBB;
   }

   public Vec3 getVec311() {
      return this.vec3;
   }

   public EntityPlayer getEntityPlayer() {
      return this.entityPlayer;
   }

   private boolean isDouble(double var1, double var3, double var5) {
      AxisAlignedBB var7;
      return this.isAxisAlignedBB(var7 = this.axisAlignedBB.offset(var1, var3, var5)) && !this.getWorld().isAnyLiquid(var7);
   }

   public void handleBool9(boolean var1) {
      this.bool4 = var1;
   }

   public boolean isEnabled35() {
      return this.bool4;
   }

   private Vec3 getVec310(Vec3 var1) {
      if (this.bool3 && !(var1.yCoord > 0.0)) {
         double var2 = var1.xCoord;
         double var4 = var1.zCoord;
         double var6 = 0.05;
         double var10000 = var2;

         while (var10000 != 0.0 && this.isAxisAlignedBB(this.axisAlignedBB.offset(var2, -1.0, 0.0))) {
            var10000 = var2 < var6 && var2 >= -var6 ? (var2 = 0.0) : (var2 > 0.0 ? (var2 -= var6) : (var2 += var6));
         }

         var10000 = var4;

         while (var10000 != 0.0 && this.isAxisAlignedBB(this.axisAlignedBB.offset(0.0, -1.0, var4))) {
            var10000 = var4 < var6 && var4 >= -var6 ? (var4 = 0.0) : (var4 > 0.0 ? (var4 -= var6) : (var4 += var6));
         }

         var10000 = var2;

         while (var10000 != 0.0 && var4 != 0.0 && this.isAxisAlignedBB(this.axisAlignedBB.offset(var2, -1.0, var4))) {
            if (var2 < var6 && var2 >= -var6) {
               var2 = 0.0;
               var10000 = var4;
            } else if (var2 > 0.0) {
               var2 -= var6;
               var10000 = var4;
            } else {
               var2 += var6;
               var10000 = var4;
            }

            if (var10000 < var6 && var4 >= -var6) {
               var4 = 0.0;
               var10000 = var2;
            } else if (var4 > 0.0) {
               var4 -= var6;
               var10000 = var2;
            } else {
               var4 += var6;
               var10000 = var2;
            }
         }

         if (var1.xCoord != var2 || var1.zCoord != var4) {
            this.bool6 = true;
         }

         return !this.isEnabled31() ? var1 : new Vec3(var2, var1.yCoord, var4);
      } else {
         return var1;
      }
   }

   public void handleBool8(boolean var1) {
      this.bool = var1;
   }

   public Cls3(
      EntityPlayer var1,
      Cls2 var2,
      Vec3 var3,
      Vec3 var4,
      AxisAlignedBB var5,
      float var6,
      float var7,
      boolean var8,
      double var9,
      int var11,
      boolean var12,
      boolean var13,
      boolean var14,
      boolean var15
   ) {
      this.entityPlayer = var1;
      this.cls2 = var2;
      this.vec3 = var3;
      this.vec32 = var4;
      this.axisAlignedBB = var5;
      this.float_2 = var6;
      this.float_ = var7;
      this.bool4 = var8;
      this.double_ = var9;
      this.int_ = var11;
      this.bool2 = var12;
      this.bool3 = var13;
      this.bool5 = var14;
      this.bool = var15;
   }

   @Override
   public void run17() {
      this.bool6 = false;
      if (!(this.vec3.yCoord <= -70.0)) {
         this.cls2.run16();
         if (this.int_ > 0) {
            int var8 = this.int_ - 1;
            this.int_ = var8;
         }

         this.bool2 = this.cls2.forwardBackwardRecord.jump();
         double var1 = this.vec32.xCoord;
         double var3 = this.vec32.yCoord;
         double var5 = this.vec32.zCoord;
         if (Math.abs(var1) < 0.005) {
            var1 = 0.0;
         }

         if (Math.abs(var3) < 0.005) {
            var3 = 0.0;
         }

         if (Math.abs(var5) < 0.005) {
            var5 = 0.0;
         }

         Cls3 var10000;
         label36: {
            this.vec32 = new Vec3(var1, var3, var5);
            if (this.bool2) {
               if (this.isEnabled34() || this.isEnabled29()) {
                  var10000 = this;
                  this.vec32 = this.vec32.add(0.0, 0.04F, 0.0);
                  break label36;
               }

               if (this.bool3 && this.int_ == 0) {
                  var10000 = this;
                  this.run18();
                  this.int_ = 10;
                  break label36;
               }
            } else {
               this.int_ = 0;
            }

            var10000 = this;
         }

         var1 = var10000.cls2.getFloat6() * 0.98;
         var3 = this.cls2.getFloat8() * 0.98;
         this.handleVec32(new Vec3(var1, 0.0, var3));
         this.int_2++;
      }
   }

   public double getDouble14() {
      return this.double_;
   }

   public void handleInt8(int var1) {
      this.int_ = var1;
   }

   private boolean isEnabled27() {
      BlockPos var2 = Util6.getBlockPosForVec3(this.vec3);
      return this.getIBlockState2(var2).getBlock() == Blocks.web;
   }

   public void handleFloat4(float var1) {
      this.float_2 = var1;
   }

   public boolean isEnabled32() {
      return this.bool6;
   }

   private boolean isEnabled31() {
      return !this.cls2.isEnabled24() && (this.cls2.forwardBackwardRecord.shift() || this.cls2.isEnabled26());
   }

   private World getWorld() {
      return this.entityPlayer.worldObj;
   }

   public void handleFloat2(float var1) {
      this.float_ = var1;
   }
}
