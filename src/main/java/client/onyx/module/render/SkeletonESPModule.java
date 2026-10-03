package client.onyx.module.render;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.combat.AntiBotModule;
import client.onyx.render.Util13;
import client.onyx.render.skeleton.Util;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.impl.Util2;
import java.util.Iterator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

public final class SkeletonESPModule extends Module {
   public final ValueSettingSub10 valueSettingSub10;
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub10 valueSettingSub102;
   public final ValueSettingSub9 valueSettingSub92;
   public final ValueSettingSub6 valueSettingSub6 = (new ValueSettingSub6("Color", -8857601)).getValueSettingSub6().getBooleanSetting("Colour of the bones");
   public final ValueSettingSub9 valueSettingSub93 = (new ValueSettingSub9("Health color", false)).getBooleanSetting("Fade the bones from green to red as the target loses health");
   public final ValueSettingSub10 valueSettingSub103 = (new ValueSettingSub10("Line width", 1.5D, 0.5D, 5.0D, 0.5D)).getValueSettingSub10(" px");
   public final ValueSettingSub9 valueSettingSub94 = (new ValueSettingSub9("Joints", true)).getBooleanSetting("Draw a dot at every joint");

   public SkeletonESPModule() {
      super("SkeletonESP", "Draws the bones of nearby players", ModuleCategory.RENDER);
      this.valueSettingSub10 = (new ValueSettingSub10("Joint size", 3.0D, 1.0D, 8.0D, 0.5D)).getValueSettingSub10(" px").getModeSetting(this.valueSettingSub94);
      this.valueSettingSub92 = new ValueSettingSub9("Through walls", true);
      this.valueSettingSub102 = (new ValueSettingSub10("Range", 128.0D, 8.0D, 256.0D, 8.0D)).getValueSettingSub10(" m");
      this.valueSettingSub9 = (new ValueSettingSub9("Mobs", false)).getBooleanSetting("Also draw bones for non-player mobs");
   }

   private void handleVec312(Vec3 var1, Vec3 var2, int var3) {
      Util13.handleVec37(var1, var2, var3, var3);
   }

   private void handleHeadNeckRecord(Util.HeadNeckRecord var1, int var2) {
      Util13.run59();
      this.handleVec312(var1.head(), var1.neck(), var2);
      this.handleVec312(var1.neck(), var1.hip(), var2);
      this.handleVec312(var1.neck(), var1.rightShoulder(), var2);
      this.handleVec312(var1.neck(), var1.leftShoulder(), var2);
      this.handleVec312(var1.rightShoulder(), var1.rightHand(), var2);
      this.handleVec312(var1.leftShoulder(), var1.leftHand(), var2);
      this.handleVec312(var1.hip(), var1.rightHipJoint(), var2);
      this.handleVec312(var1.hip(), var1.leftHipJoint(), var2);
      this.handleVec312(var1.rightHipJoint(), var1.rightFoot(), var2);
      this.handleVec312(var1.leftHipJoint(), var1.leftFoot(), var2);
      Util13.run58();
      if (this.valueSettingSub94.isEnabled17()) {
         float var3 = this.valueSettingSub10.getFloat5();
         Util13.handleVec35(var1.head(), var3, var2);
         Util13.handleVec35(var1.neck(), var3, var2);
         Util13.handleVec35(var1.hip(), var3, var2);
         Util13.handleVec35(var1.rightShoulder(), var3, var2);
         Util13.handleVec35(var1.leftShoulder(), var3, var2);
         Util13.handleVec35(var1.rightHand(), var3, var2);
         Util13.handleVec35(var1.leftHand(), var3, var2);
         Util13.handleVec35(var1.rightFoot(), var3, var2);
         Util13.handleVec35(var1.leftFoot(), var3, var2);
      }
   }

   public void handleFloat39(float var1) {
      if (this.isEnabled55() && MINECRAFT.theWorld != null && MINECRAFT.thePlayer != null) {
         double var2 = (Double)this.valueSettingSub102.lambda15();
         boolean var4 = false;
         Iterator var5 = MINECRAFT.theWorld.loadedEntityList.iterator();

         label62:
         while(true) {
            Iterator var10000 = var5;

            while(true) {
               while(var10000.hasNext()) {
                  Object var7;
                  EntityLivingBase var8;
                  if (!((var7 = var5.next()) instanceof EntityLivingBase) || (var8 = (EntityLivingBase)var7) == MINECRAFT.thePlayer) {
                     continue label62;
                  }

                  if (!var8.isEntityAlive()) {
                     var10000 = var5;
                  } else if (AntiBotModule.isEntity5(var8)) {
                     var10000 = var5;
                  } else if (!(var8 instanceof EntityPlayer) && !this.valueSettingSub9.isEnabled17()) {
                     var10000 = var5;
                  } else if (var8.isInvisible() && !this.isEntityLivingBase2(var8)) {
                     var10000 = var5;
                  } else if ((double)MINECRAFT.thePlayer.getDistanceToEntity(var8) > var2) {
                     var10000 = var5;
                  } else {
                     if (!var4) {
                        if (!Util13.isFloat5(var1, this.valueSettingSub92.isEnabled17(), this.valueSettingSub103.getFloat5())) {
                           return;
                        }

                        var4 = true;
                     }

                     this.handleHeadNeckRecord(Util.getHeadNeckRecordForEntityLivingBase(var8, var1), this.getInt23(var8));
                     var10000 = var5;
                  }
               }

               if (var4) {
                  Util13.run60();
               }

               return;
            }
         }
      }
   }

   private boolean isEntityLivingBase2(EntityLivingBase var1) {
      return OnyxClient.cls != null && OnyxClient.cls.ca.isEntityLivingBase4(var1);
   }

   private int getInt23(EntityLivingBase var1) {
      int var2 = this.valueSettingSub6.lambda15();
      if (!this.valueSettingSub93.isEnabled17()) {
         return var2;
      } else {
         float var4 = var1.getMaxHealth() <= 0.0F ? 1.0F : Math.clamp(var1.getHealth() / var1.getMaxHealth(), 0.0F, 1.0F);
         int var5 = Math.round(255.0F - 100.0F * var4);
         int var6 = Math.round(90.0F + 137.0F * var4);
         return Util2.getIntForInt5(Util2.getIntForInt6(var2), var5, var6, 98);
      }
   }
}
