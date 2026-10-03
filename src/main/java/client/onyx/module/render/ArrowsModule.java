package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Sampler0;
import client.onyx.render.Util8;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.theme.impl.Util2;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

public final class ArrowsModule extends Module {
   private long long_;
   public final ValueSettingSub10 valueSettingSub10;
   public final ValueSettingSub10 valueSettingSub102;
   private final Sampler0 sampler0;
   public final ValueSettingSub6 valueSettingSub6;
   public final ValueSettingSub11<ArrowsModule.OutlineSolidEnum> valueSettingSub112 = new ValueSettingSub11<>("Design", ArrowsModule.OutlineSolidEnum.OUTLINE)
      .getBooleanSetting("Which arrow is drawn");
   private static final ResourceLocation RESOURCE_LOCATION3 = new ResourceLocation("onyx", "textures/pointers/outline.png");
   private static final float FLOAT = 100.0F;
   private float float_;
   public final ValueSettingSub10 valueSettingSub103;
   private static final float FLOAT2 = 100.0F;
   public final ValueSettingSub10 valueSettingSub104;
   public final ValueSettingSub10 valueSettingSub105;
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("onyx", "textures/pointers/solid.png");
   public final ValueSettingSub6 valueSettingSub62;
   private static final ResourceLocation RESOURCE_LOCATION2 = new ResourceLocation("onyx", "textures/pointers/chevron.png");
   private static final double DOUBLE = 90.0;

   private float getFloat60() {
      long var1 = System.nanoTime();
      float var4 = this.long_ == 0L ? 16.0F : Math.min((float)(var1 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var1;
      return var4;
   }

   private static int getIntForInt23(int var0, int var1, float var2) {
      int var3 = Math.round(Util2.getIntForInt6(var0) + (Util2.getIntForInt6(var1) - Util2.getIntForInt6(var0)) * var2);
      int var4 = Math.round(Util2.getIntForInt7(var0) + (Util2.getIntForInt7(var1) - Util2.getIntForInt7(var0)) * var2);
      int var5 = Math.round(Util2.getIntForInt(var0) + (Util2.getIntForInt(var1) - Util2.getIntForInt(var0)) * var2);
      var1 = Math.round(Util2.getIntForInt2(var0) + (Util2.getIntForInt2(var1) - Util2.getIntForInt2(var0)) * var2);
      return Util2.getIntForInt5(var3, var4, var5, var1);
   }

   private void handleFloat57(float var1, int var2, int var3) {
      this.sampler0
         .handleResourceLocation5(
            this.getResourceLocation2(),
            -var1 / 2.0F + var1 / 18.0F,
            -var1 / 2.0F,
            var1,
            var1,
            var2,
            getIntForInt23(var2, var3, 0.33333334F),
            getIntForInt23(var2, var3, 0.6666667F),
            var3
         );
   }

   private void handleFloat56(float var1, float var2, float var3, float var4, float var5, float var6) {
      int var7 = Util2.getIntForInt3(this.valueSettingSub6.lambda15(), Util2.getIntForInt6(this.valueSettingSub6.lambda15()) / 255.0F * var5);
      int var10 = Util2.getIntForInt3(this.valueSettingSub62.lambda15(), Util2.getIntForInt6(this.valueSettingSub62.lambda15()) / 255.0F * var5);
      this.sampler0.run36();
      this.sampler0.getCls32().getCls35(var1, var2);
      this.sampler0.getCls32().getCls32(var3);
      if (var6 > 0.0F) {
         var1 = var4 * (1.0F + 0.5F * Math.min(var6, 2.0F));
         var2 = 0.22F * Math.min(var6, 1.5F);
         this.handleFloat57(
            var1, Util2.getIntForInt3(var7, Util2.getIntForInt6(var7) / 255.0F * var2), Util2.getIntForInt3(var10, Util2.getIntForInt6(var10) / 255.0F * var2)
         );
      }

      this.handleFloat57(var4, var7, var10);
      this.sampler0.run43();
   }

   public void handleFloat55(float var1) {
      if (this.isEnabled55() && MINECRAFT.theWorld != null && MINECRAFT.thePlayer != null) {
         if (MINECRAFT.gameSettings.thirdPersonView == 0) {
            ScaledResolution var18 = new ScaledResolution(MINECRAFT);
            float var30 = var18.getScaledWidth();
            float var17 = var18.getScaledHeight();
            float var4 = this.valueSettingSub102.getFloat5() + (MINECRAFT.currentScreen instanceof GuiInventory ? 100.0F : 0.0F);
            this.float_ = this.float_ + (var4 - this.float_) * (float)(1.0 - Math.exp(-this.getFloat60() / 90.0));
            double var5;
            double var7;
            float var35;
            if (Util8.isEnabled44()) {
               Vec3 var9 = Util8.getVec313();
               Vec3 var10;
               Vec3 var10000 = var10 = Util8.getVec315();
               var5 = var9.xCoord;
               var7 = var9.zCoord;
               var35 = var4 = (float)Math.toDegrees(Math.atan2(-var10000.xCoord, var10.zCoord));
            } else {
               var5 = MINECRAFT.thePlayer.lastTickPosX + (MINECRAFT.thePlayer.posX - MINECRAFT.thePlayer.lastTickPosX) * var1;
               var7 = MINECRAFT.thePlayer.lastTickPosZ + (MINECRAFT.thePlayer.posZ - MINECRAFT.thePlayer.lastTickPosZ) * var1;
               var35 = var4 = MINECRAFT.thePlayer.prevRotationYaw + (MINECRAFT.thePlayer.rotationYaw - MINECRAFT.thePlayer.prevRotationYaw) * var1;
            }

            double var28 = Math.cos(Math.toRadians(var35));
            double var11 = Math.sin(Math.toRadians(var4));
            float var31 = var30 / 2.0F;
            var17 /= 2.0F;
            var4 = this.valueSettingSub103.getFloat5() / 100.0F;
            float var13 = this.valueSettingSub105.getFloat5() / 100.0F;
            float var14 = this.valueSettingSub10.getFloat5();
            double var15 = this.valueSettingSub104.lambda15();
            ArrayList var36 = new ArrayList<>(MINECRAFT.theWorld.playerEntities);
            this.sampler0.run42();
            Iterator var3 = var36.iterator();

            label47:
            while (true) {
               Iterator var37 = var3;

               while (var37.hasNext()) {
                  EntityPlayer var25;
                  if ((var25 = (EntityPlayer)var3.next()) == null) {
                     continue label47;
                  }

                  if (var25 == MINECRAFT.thePlayer) {
                     var37 = var3;
                  } else {
                     if (!var25.isEntityAlive()) {
                        continue label47;
                     }

                     if (var25.isInvisible()) {
                        var37 = var3;
                     } else if (MINECRAFT.thePlayer.getDistanceToEntity(var25) > var15) {
                        var37 = var3;
                     } else {
                        double var19 = var25.lastTickPosX + (var25.posX - var25.lastTickPosX) * var1 - var5;
                        double var21;
                        double var23 = -((var21 = var25.lastTickPosZ + (var25.posZ - var25.lastTickPosZ) * var1 - var7) * var28 - var19 * var11);
                        var19 = -(var19 * var28 + var21 * var11);
                        float var34 = (float)Math.atan2(var23, var19);
                        var37 = var3;
                        float var33 = (float)(this.float_ * Math.cos(var34)) + var31;
                        float var20 = (float)(this.float_ * Math.sin(var34)) + var17;
                        this.handleFloat56(var33, var20, var34, var14, var4, var13);
                     }
                  }
               }

               this.sampler0.run39();
               return;
            }
         }
      }
   }

   public ArrowsModule() {
      super("Arrows", "Points at the players around you", ModuleCategory.RENDER);
      this.valueSettingSub102 = new ValueSettingSub10("Distance", 60.0, 20.0, 150.0, 1.0)
         .getValueSettingSub10(" px")
         .getBooleanSetting("How far the pointers sit from the cursor");
      this.valueSettingSub10 = new ValueSettingSub10("Size", 18.0, 8.0, 40.0, 1.0).getValueSettingSub10(" px").getBooleanSetting("How large each pointer is");
      this.valueSettingSub6 = new ValueSettingSub6("Color", -8857601).getValueSettingSub6().getBooleanSetting("Colour the pointer starts from");
      this.valueSettingSub62 = new ValueSettingSub6("Second color", -4879105)
         .getValueSettingSub6()
         .getValueSettingSub63(60.0)
         .getBooleanSetting("Colour the pointer runs into");
      this.valueSettingSub103 = new ValueSettingSub10("Opacity", 49.0, 5.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How solid the pointers are");
      this.valueSettingSub105 = new ValueSettingSub10("Glow", 100.0, 0.0, 250.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How much light the pointers throw");
      this.valueSettingSub104 = new ValueSettingSub10("Range", 128.0, 8.0, 256.0, 8.0)
         .getValueSettingSub10(" m")
         .getBooleanSetting("Farthest a player can be and still get a pointer");
      this.sampler0 = new Sampler0().getSampler0();
   }

   @Override
   protected void run79() {
      this.float_ = 0.0F;
      this.long_ = 0L;
   }

   private ResourceLocation getResourceLocation2() {
      switch ((ArrowsModule.OutlineSolidEnum)this.valueSettingSub112.lambda15()) {
         case SOLID:

            return RESOURCE_LOCATION;
         case CHEVRON:
            return RESOURCE_LOCATION2;
         default:
            return RESOURCE_LOCATION3;
      }
   }

   public static enum OutlineSolidEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      OUTLINE,
      SOLID,
      CHEVRON;

   }
}
