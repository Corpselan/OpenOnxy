package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Util13;
import client.onyx.render.Util7;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.impl.Util2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public final class TrajectoriesModule extends Module {
   private static final double DOUBLE = 0.03;
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub6 valueSettingSub6 = new ValueSettingSub6("Color", -8857601)
      .getValueSettingSub6()
      .getBooleanSetting("Colour of the predicted path");
   public final ValueSettingSub10 valueSettingSub10;
   public final ValueSettingSub9 valueSettingSub92;
   private static final double DOUBLE2 = 0.05;
   public final ValueSettingSub6 valueSettingSub62 = new ValueSettingSub6("Impact color", -38302).getBooleanSetting("Colour of the landing marker");
   public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Line width", 1.5, 0.5, 5.0, 0.5).getValueSettingSub10(" px");
   public final TrajectoriesModule.ProjectilesBooleanSetting projectilesBooleanSetting;
   private static final double DOUBLE3 = 0.99;

   public void handleFloat53(float var1) {
      if (this.isEnabled55() && MINECRAFT.theWorld != null && MINECRAFT.thePlayer != null) {
         TrajectoriesModule.PearlSnowballEnum var7;
         if ((var7 = this.getPearlSnowballEnum(MINECRAFT.thePlayer.getHeldItem())) != null) {
            float var3;
            if (!((var3 = this.getFloat57(var7)) <= 0.0F)) {
               TrajectoriesModule.PointsHitRecord var10;
               if ((var10 = this.getPointsHitRecord(var7, var3, var1)).points().size() >= 2) {
                  if (Util13.isFloat5(var1, this.valueSettingSub9.isEnabled17(), this.valueSettingSub102.getFloat5())) {
                     int var9;
                     int var10002 = var9 = this.valueSettingSub6.lambda15();
                     int var4 = Util2.getIntForInt3(var10002, Util2.getIntForInt6(var10002) / 255.0F * 0.35F);
                     Util13.handleList(var10.points(), var9, var4);
                     Util13.run60();
                     if (this.valueSettingSub92.isEnabled17() && var10.hit() != null) {
                        if (Util7.isFloat3(var1, this.valueSettingSub9.isEnabled17())) {
                           int var8 = this.valueSettingSub62.lambda15();
                           double var5 = 0.12;
                           Util7.handleAxisAlignedBB2(
                              AxisAlignedBB.fromBounds(
                                 var10.hit().xCoord - var5,
                                 var10.hit().yCoord - var5,
                                 var10.hit().zCoord - var5,
                                 var10.hit().xCoord + var5,
                                 var10.hit().yCoord + var5,
                                 var10.hit().zCoord + var5
                              ),
                              var8,
                              this.valueSettingSub102.getFloat5(),
                              Util2.getIntForInt3(var8, Util2.getIntForInt6(var8) / 255.0F * 0.25F)
                           );
                           Util7.run49();
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public TrajectoriesModule() {
      super("Trajectories", "Predicts where thrown items will land", ModuleCategory.RENDER);
      this.valueSettingSub92 = new ValueSettingSub9("Impact marker", true).getBooleanSetting("Draw a box where the projectile lands");
      this.valueSettingSub9 = new ValueSettingSub9("Through walls", false);
      this.valueSettingSub10 = new ValueSettingSub10("Max ticks", 120.0, 20.0, 300.0, 10.0).getBooleanSetting("How far ahead to simulate");
      this.projectilesBooleanSetting = new TrajectoriesModule.ProjectilesBooleanSetting();
   }

   private TrajectoriesModule.PearlSnowballEnum getPearlSnowballEnum(ItemStack var1) {
      if (var1 == null) {
         return null;
      } else if (var1.getItem() instanceof ItemEnderPearl) {
         return this.projectilesBooleanSetting.valueSettingSub96.isEnabled17() ? TrajectoriesModule.PearlSnowballEnum.PEARL : null;
      } else if (!(var1.getItem() instanceof ItemSnowball) && !(var1.getItem() instanceof ItemEgg)) {
         if (var1.getItem() instanceof ItemPotion) {
            return this.projectilesBooleanSetting.valueSettingSub92.isEnabled17() && ItemPotion.isSplash(var1.getMetadata())
               ? TrajectoriesModule.PearlSnowballEnum.POTION
               : null;
         } else if (!(var1.getItem() instanceof ItemBow)) {
            return null;
         } else {
            return this.projectilesBooleanSetting.valueSettingSub94.isEnabled17() ? TrajectoriesModule.PearlSnowballEnum.ARROW : null;
         }
      } else {
         return this.projectilesBooleanSetting.valueSettingSub93.isEnabled17() ? TrajectoriesModule.PearlSnowballEnum.SNOWBALL : null;
      }
   }

   private float getFloat57(TrajectoriesModule.PearlSnowballEnum var1) {
      if (var1 != TrajectoriesModule.PearlSnowballEnum.ARROW) {
         return var1.getFloat2();
      } else if (!MINECRAFT.thePlayer.isUsingItem()) {
         return 0.0F;
      } else {
         float var2;
         float var10000 = var2 = MINECRAFT.thePlayer.getItemInUseDuration() / 20.0F;
         float var3;
         if ((var3 = (var10000 * var10000 + var2 * 2.0F) / 3.0F) < 0.1F) {
            return 0.0F;
         } else {
            if (var3 > 1.0F) {
               var3 = 1.0F;
            }

            return var3 * 2.0F * 1.5F;
         }
      }
   }

   private Vec3 getVec316(Vec3 var1, Vec3 var2) {
      if (!this.projectilesBooleanSetting.valueSettingSub95.isEnabled17()) {
         return null;
      } else {
         AxisAlignedBB var3 = AxisAlignedBB.fromBounds(
               Math.min(var1.xCoord, var2.xCoord),
               Math.min(var1.yCoord, var2.yCoord),
               Math.min(var1.zCoord, var2.zCoord),
               Math.max(var1.xCoord, var2.xCoord),
               Math.max(var1.yCoord, var2.yCoord),
               Math.max(var1.zCoord, var2.zCoord)
            )
            .expand(1.0, 1.0, 1.0);
         Vec3 var4 = null;
         double var5 = Double.MAX_VALUE;
         Iterator var10 = MINECRAFT.theWorld.getEntitiesWithinAABBExcludingEntity(MINECRAFT.thePlayer, var3).iterator();

         label35:
         while (true) {
            Iterator var10000 = var10;

            while (var10000.hasNext()) {
               Entity var7;
               if (!(var7 = (Entity)var10.next()).canBeCollidedWith()) {
                  continue label35;
               }

               if (var7 == MINECRAFT.thePlayer) {
                  var10000 = var10;
               } else {
                  MovingObjectPosition var11;
                  if ((var11 = var7.getEntityBoundingBox().expand(0.3, 0.3, 0.3).calculateIntercept(var1, var2)) == null) {
                     continue label35;
                  }

                  if (var11.hitVec != null) {
                     double var8;
                     if ((var8 = var1.squareDistanceTo(var11.hitVec)) < var5) {
                        var5 = var8;
                        var4 = var11.hitVec;
                     }
                     continue label35;
                  }

                  var10000 = var10;
               }
            }

            return var4;
         }
      }
   }

   private TrajectoriesModule.PointsHitRecord getPointsHitRecord(TrajectoriesModule.PearlSnowballEnum var1, float var2, float var3) {
      var3 = MINECRAFT.thePlayer.rotationYaw;
      float var4 = MINECRAFT.thePlayer.rotationPitch;
      double var5 = var3 / 180.0 * Math.PI;
      double var7 = var4 / 180.0 * Math.PI;
      double var9 = (var4 + var1.getFloat()) / 180.0 * Math.PI;
      double var11 = MINECRAFT.thePlayer.posX - Math.cos(var5) * 0.16;
      double var13 = MINECRAFT.thePlayer.posY + MINECRAFT.thePlayer.getEyeHeight() - 0.1F;
      double var15 = MINECRAFT.thePlayer.posZ - Math.sin(var5) * 0.16;
      double var17 = -Math.sin(var5) * Math.cos(var7);
      var5 = Math.cos(var5) * Math.cos(var7);
      var7 = -Math.sin(var9);
      if ((var9 = Math.sqrt(var17 * var17 + var7 * var7 + var5 * var5)) < 1.0E-6) {
         return new TrajectoriesModule.PointsHitRecord(List.of(), null);
      } else {
         var17 = var17 / var9 * var2;
         var7 = var7 / var9 * var2;
         var5 = var5 / var9 * var2;
         var9 = var1.getDouble();
         ArrayList var21 = new ArrayList();
         var21.add(new Vec3(var11, var13, var15));
         int var22 = this.valueSettingSub10.getInt10();
         int var24 = 0;

         for (int var10000 = var24; var10000 < var22; var10000 = var24) {
            Vec3 var25 = new Vec3(var11, var13, var15);
            var11 += var17;
            var13 += var7;
            var15 += var5;
            Vec3 var19 = new Vec3(var11, var13, var15);
            MovingObjectPosition var20;
            if ((var20 = MINECRAFT.theWorld.rayTraceBlocks(var25, var19, false, true, false)) != null && var20.hitVec != null) {
               var21.add(var20.hitVec);
               return new TrajectoriesModule.PointsHitRecord(var21, var20.hitVec);
            }

            Vec3 var26;
            if ((var26 = this.getVec316(var25, var19)) != null) {
               var21.add(var26);
               return new TrajectoriesModule.PointsHitRecord(var21, var26);
            }

            var21.add(var19);
            if (var13 < 0.0) {
               return new TrajectoriesModule.PointsHitRecord(var21, null);
            }

            var17 *= 0.99;
            var7 *= 0.99;
            var5 *= 0.99;
            var24++;
            var7 -= var9;
         }

         return new TrajectoriesModule.PointsHitRecord(var21, null);
      }
   }

   private static enum PearlSnowballEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      PEARL(1.5F, 0.03, 0.0F),
      SNOWBALL(1.5F, 0.03, 0.0F),
      POTION(0.5F, 0.05, -20.0F),
      ARROW(0.0F, 0.05, 0.0F);
      private final double double_;
      private final float float_;
      private final float float_2;

      float getFloat2() {
         return this.float_;
      }

      double getDouble() {
         return this.double_;
      }

      private PearlSnowballEnum(float var3, double var4, float var6) {
         this.float_ = var3;
         this.double_ = var4;
         this.float_2 = var6;
      }

      float getFloat() {
         return this.float_2;
      }

   }

   private record PointsHitRecord(List<Vec3> points, Vec3 hit) {
   }

   public static final class ProjectilesBooleanSetting extends BooleanSetting {
      public final ValueSettingSub9 valueSettingSub92;
      public final ValueSettingSub9 valueSettingSub93;
      public final ValueSettingSub9 valueSettingSub94;
      public final ValueSettingSub9 valueSettingSub95;
      public final ValueSettingSub9 valueSettingSub96 = new ValueSettingSub9("Ender pearls", true);

      private ProjectilesBooleanSetting() {
         super("Projectiles");
         this.valueSettingSub93 = new ValueSettingSub9("Snowballs and eggs", true);
         this.valueSettingSub92 = new ValueSettingSub9("Splash potions", true);
         this.valueSettingSub94 = new ValueSettingSub9("Bows", true);
         this.valueSettingSub95 = new ValueSettingSub9("Stop at entities", true).getBooleanSetting("End the path where it would hit a player or mob");
      }
   }
}
