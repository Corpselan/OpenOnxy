package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.entity.AngelicDragonEnum;
import client.onyx.render.entity.AutoCloseableImpl;
import client.onyx.render.entity.PositionBodyYawRecord;
import client.onyx.render.entity.PreTranslateYPreTranslateZRecord;
import client.onyx.render.entity.ShaderFillScaleRecord;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.Util3;
import client.onyx.system.Util7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public final class WingsModule extends Module {
   private final List<PositionBodyYawRecord> list2;
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub11<WingsModule.SolidShaderEnum> valueSettingSub112;
   private static final float FLOAT = 1.5F;
   public ValueSettingSub6 valueSettingSub6;
   public ValueSettingSub10 valueSettingSub102;
   public ValueSettingSub11<AngelicDragonEnum> valueSettingSub113 = new ValueSettingSub11<>("Wing type", AngelicDragonEnum.ANGELIC)
      .getBooleanSetting("Silhouette the wings are cut from");
   public ValueSettingSub10 valueSettingSub103;
   public ValueSettingSub<WingsModule.SelfPlayersEnum> valueSettingSub;
   public ValueSettingSub10 valueSettingSub104;
   public ValueSettingSub9 valueSettingSub9;
   public ValueSettingSub10 valueSettingSub105;
   private final AutoCloseableImpl autoCloseableImpl;
   public ValueSettingSub9 valueSettingSub92;
   public ValueSettingSub10 valueSettingSub106;
   public ValueSettingSub10 valueSettingSub107;
   private static final float FLOAT2 = 0.15F;

   private float getFloat43(EntityPlayer var1, float var2) {
      return var1 == MINECRAFT.thePlayer && Util3.isEntity7(var1)
         ? Util3.getFloatForFloat21(var2)
         : var1.prevRenderYawOffset + MathHelper.wrapAngleTo180_float(var1.renderYawOffset - var1.prevRenderYawOffset) * var2;
   }

   public WingsModule() {
      super("Wings", "Draws a pair of wings on player backs", ModuleCategory.RENDER);
      this.valueSettingSub112 = new ValueSettingSub11<>("Fill", WingsModule.SolidShaderEnum.SHADER)
         .getBooleanSetting("Flat colour, or an animated aurora inside the membrane");
      WingsModule.SelfPlayersEnum[] var10005 = new WingsModule.SelfPlayersEnum[1];
      boolean var10007 = true;
      var10005[0] = WingsModule.SelfPlayersEnum.SELF;
      this.valueSettingSub = new ValueSettingSub<>("Targets", WingsModule.SelfPlayersEnum.class, var10005).getBooleanSetting("Who the wings are drawn on");
      this.valueSettingSub105 = new ValueSettingSub10("Scale", 1.0, 0.3, 3.0, 0.1).getValueSettingSub10(Util7.decrypt("j"));
      this.valueSettingSub10 = new ValueSettingSub10("Angle", 20.0, 0.0, 90.0, 1.0)
         .getValueSettingSub10("°")
         .getBooleanSetting("How far the wings sweep back from the shoulders");
      this.valueSettingSub102 = new ValueSettingSub10("Height", 1.5, 0.8, 2.5, 0.05).getBooleanSetting("How high on the back the wings sit");
      this.valueSettingSub104 = new ValueSettingSub10("Depth", 0.15F, 0.0, 0.5, 0.01).getBooleanSetting("How far the wings stand off the back");
      this.valueSettingSub92 = new ValueSettingSub9("Flapping", true);
      this.valueSettingSub107 = new ValueSettingSub10("Flap strength", 30.0, 5.0, 60.0, 1.0)
         .getBooleanSetting("How far the wings swing on every beat")
         .getModeSetting(this.valueSettingSub92);
      this.valueSettingSub103 = new ValueSettingSub10("Flap speed", 3.0, 0.5, 8.0, 0.5)
         .getBooleanSetting("How quickly the wings beat")
         .getModeSetting(this.valueSettingSub92);
      this.valueSettingSub9 = new ValueSettingSub9("Through walls", false);
      this.valueSettingSub6 = new ValueSettingSub6("Color", -1).getValueSettingSub6();
      this.valueSettingSub106 = new ValueSettingSub10("Opacity", 100.0, 5.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Overall opacity of the wings");
      this.autoCloseableImpl = new AutoCloseableImpl();
      this.list2 = new ArrayList<>();
   }

   private void handleEntityPlayer(EntityPlayer var1, float var2) {
      PreTranslateYPreTranslateZRecord var3;
      if ((var3 = this.getPreTranslateYPreTranslateZRecord2(var1)) != null) {
         Vec3 var4 = new Vec3(
            var1.prevPosX + (var1.posX - var1.prevPosX) * var2,
            var1.prevPosY + (var1.posY - var1.prevPosY) * var2,
            var1.prevPosZ + (var1.posZ - var1.prevPosZ) * var2
         );
         this.list2
            .add(new PositionBodyYawRecord(var4, this.getFloat43(var1, var2), this.getFloat44(var1, var3, var2), this.valueSettingSub113.lambda15(), var3));
      }
   }

   private ShaderFillScaleRecord getShaderFillScaleRecord() {
      return new ShaderFillScaleRecord(
         this.valueSettingSub112.isEnum3(WingsModule.SolidShaderEnum.SHADER),
         this.valueSettingSub105.getFloat5(),
         this.valueSettingSub102.getFloat5() - 1.5F,
         this.valueSettingSub104.getFloat5() - 0.15F,
         this.valueSettingSub9.isEnabled17(),
         this.valueSettingSub6.getInt8(),
         this.valueSettingSub106.getFloat5() / 100.0F
      );
   }

   private PreTranslateYPreTranslateZRecord getPreTranslateYPreTranslateZRecord2(EntityPlayer var1) {
      return var1.isInWater() ? null : this.getPreTranslateYPreTranslateZRecord(var1);
   }

   private PreTranslateYPreTranslateZRecord getPreTranslateYPreTranslateZRecord(EntityPlayer var1) {
      return var1.isSneaking()
         ? new PreTranslateYPreTranslateZRecord(0.0F, 0.0F, 0.96F, 0.1F, 18.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.18F, 4.5F, 0.06F, 0.02F, -11.0F, -4.0F, 0.12F)
         : new PreTranslateYPreTranslateZRecord(0.0F, 0.0F, 1.38F, 0.1F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.18F, 4.5F, 0.06F, 0.02F, -11.0F, -4.0F, 0.12F);
   }

   public void handleFloat48(float var1) {
      if (this.isEnabled55() && MINECRAFT.theWorld != null && MINECRAFT.thePlayer != null) {
         this.list2.clear();
         if (this.valueSettingSub.isEnum(WingsModule.SelfPlayersEnum.SELF)
            && MINECRAFT.gameSettings.thirdPersonView != 0
            && MINECRAFT.thePlayer.isEntityAlive()) {
            this.handleEntityPlayer(MINECRAFT.thePlayer, var1);
         }

         if (this.valueSettingSub.isEnum(WingsModule.SelfPlayersEnum.PLAYERS)) {
            Iterator var4 = MINECRAFT.theWorld.playerEntities.iterator();

            label33:
            while (true) {
               Iterator var10000 = var4;

               while (true) {
                  if (!var10000.hasNext()) {
                     break label33;
                  }

                  EntityPlayer var3;
                  if ((var3 = (EntityPlayer)var4.next()) == MINECRAFT.thePlayer) {
                     break;
                  }

                  if (!var3.isEntityAlive()) {
                     var10000 = var4;
                  } else {
                     this.handleEntityPlayer(var3, var1);
                     var10000 = var4;
                  }
               }
            }
         }

         this.autoCloseableImpl.handleFloat35(var1, this.list2, this.getShaderFillScaleRecord());
      }
   }

   @Override
   protected void run79() {
      this.list2.clear();
      this.autoCloseableImpl.close();
   }

   private float getFloat44(EntityPlayer var1, PreTranslateYPreTranslateZRecord var2, float var3) {
      float var4 = 0.0F;
      if (this.valueSettingSub92.isEnabled17()) {
         float var5 = var2.flapSpeed() * (this.valueSettingSub103.getFloat5() / 3.0F);
         float var6 = var2.flapAmplitude() * (this.valueSettingSub107.getFloat5() / 30.0F);
         var4 = (float)Math.sin((var1.ticksExisted + var3) * var5) * var6;
      }

      float var7 = Math.clamp((float)Math.sqrt(var1.motionX * var1.motionX + var1.motionZ * var1.motionZ) * 10.0F, 0.0F, 1.0F);
      return (var4 + var7 * var2.motionSpreadBoost() - this.valueSettingSub10.getFloat5()) * var2.openMultiplier();
   }

   public static enum SelfPlayersEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      SELF,
      PLAYERS;

   }

   public static enum SolidShaderEnum {
      SOLID,
      SHADER;

   }
}
