package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.gradient.PivotLiftRecord;
import client.onyx.render.gradient.RadiusHeightRecord;
import client.onyx.render.gradient.StaticGradientEnum;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.Util3;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public final class ChinaHatModule extends Module {
   private static final float FLOAT = 1.5F;
   private final client.onyx.render.gradient.Cls cls;
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub10 valueSettingSub102;
   private float float_;
   public ValueSettingSub6 valueSettingSub6;
   private static final float FLOAT2 = 0.22F;
   private long long_;
   public ValueSettingSub10 valueSettingSub103;
   public ValueSettingSub10 valueSettingSub104;
   public ValueSettingSub9 valueSettingSub9;
   private float float_2;
   public ValueSettingSub9 valueSettingSub92;
   public ValueSettingSub6 valueSettingSub62;
   public ValueSettingSub10 valueSettingSub105;
   public ValueSettingSub10 valueSettingSub106;
   public ValueSettingSub10 valueSettingSub107 = new ValueSettingSub10("Radius", 0.65, 0.2, 3.0, 0.05).getBooleanSetting("How wide the brim sits");
   public ValueSettingSub11<StaticGradientEnum> valueSettingSub112;
   private static final float FLOAT3 = (float) (Math.PI * 2);
   public ValueSettingSub9 valueSettingSub93;
   private final List<PivotLiftRecord> list2;
   public ValueSettingSub10 valueSettingSub108;

   private void run98() {
      long var1 = System.nanoTime();
      if (this.long_ == 0L) {
         this.long_ = var1;
      } else {
         float var4 = Math.min((float)(var1 - this.long_) / 1.0E9F, 0.25F);
         this.long_ = var1;
         this.float_2 = (this.float_2 + (float)Math.toRadians(this.valueSettingSub108.lambda15()) * var4) % (float) (Math.PI * 2);
         this.float_ = (this.float_ + (float)Math.toRadians(this.valueSettingSub103.lambda15()) * var4) % (float) (Math.PI * 2);
      }
   }

   public ChinaHatModule() {
      super("ChinaHat", "Floats a conical hat over your head", ModuleCategory.RENDER);
      this.valueSettingSub104 = new ValueSettingSub10("Height", 0.35, 0.05, 1.5, 0.05).getBooleanSetting("How tall the cone stands");
      this.valueSettingSub102 = new ValueSettingSub10("Offset", -0.02, -0.5, 1.5, 0.02).getBooleanSetting("How far above the head the brim sits");
      this.valueSettingSub105 = new ValueSettingSub10("Tilt", 100.0, 0.0, 100.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How much of the head's pitch the hat takes on");
      this.valueSettingSub112 = new ValueSettingSub11<>("Colors", StaticGradientEnum.STATIC)
         .getBooleanSetting("Hold one colour, blend two around the hat, or walk the hue right round it");
      this.valueSettingSub62 = new ValueSettingSub6("Color", -10178561).getValueSettingSub6();
      this.valueSettingSub6 = new ValueSettingSub6("Second color", -4949761)
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 == StaticGradientEnum.GRADIENT)
         .getBooleanSetting("The colour the first one blends into");
      this.valueSettingSub103 = new ValueSettingSub10("Color speed", 40.0, 0.0, 360.0, 5.0)
         .getValueSettingSub10("°/s")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 != StaticGradientEnum.STATIC)
         .getBooleanSetting("How fast the colours travel around the hat - zero holds them still");
      this.valueSettingSub106 = new ValueSettingSub10("Opacity", 90.0, 5.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Overall opacity of the hat");
      this.valueSettingSub108 = new ValueSettingSub10("Spin speed", 65.0, 0.0, 360.0, 5.0)
         .getValueSettingSub10("°/s")
         .getBooleanSetting("How fast the line travels around the hat");
      this.valueSettingSub9 = new ValueSettingSub9("Glow", true).getBooleanSetting("Soft halo right on the rim");
      this.valueSettingSub93 = new ValueSettingSub9("Trail", true).getBooleanSetting("Line sweeping around the hat, and the fading wake behind it");
      this.valueSettingSub10 = new ValueSettingSub10("Trail length", 350.0, 20.0, 360.0, 10.0)
         .getValueSettingSub10("°")
         .getBooleanSetting("How far back the wake reaches")
         .getModeSetting(this.valueSettingSub93);
      this.valueSettingSub92 = new ValueSettingSub9("Through walls", false);
      this.cls = new client.onyx.render.gradient.Cls();
      this.list2 = new ArrayList<>();
   }

   public void handleFloat51(float var1) {
      if (this.isEnabled55() && MINECRAFT.theWorld != null && MINECRAFT.thePlayer != null) {
         this.run98();
         this.list2.clear();
         if (MINECRAFT.gameSettings.thirdPersonView != 0 && MINECRAFT.thePlayer.isEntityAlive()) {
            this.handleFloat50(var1);
         }

         this.cls.handleFloat33(var1, this.list2, this.getRadiusHeightRecord());
      }
   }

   private RadiusHeightRecord getRadiusHeightRecord() {
      return new RadiusHeightRecord(
         this.valueSettingSub107.getFloat5(),
         this.valueSettingSub104.getFloat5(),
         this.valueSettingSub112.lambda15(),
         this.valueSettingSub62.getInt8(),
         this.valueSettingSub6.getInt8(),
         this.float_,
         this.valueSettingSub106.getFloat5() / 100.0F,
         this.valueSettingSub9.isEnabled17(),
         this.valueSettingSub93.isEnabled17(),
         (float)Math.toRadians(this.valueSettingSub10.lambda15()),
         this.float_2,
         this.valueSettingSub92.isEnabled17()
      );
   }

   @Override
   protected void run80() {
      this.long_ = 0L;
   }

   private float getFloat56(float var1) {
      return Util3.isEntity7(MINECRAFT.thePlayer)
         ? Util3.getFloatForFloat23(var1)
         : MINECRAFT.thePlayer.prevRotationYawHead
            + MathHelper.wrapAngleTo180_float(MINECRAFT.thePlayer.rotationYawHead - MINECRAFT.thePlayer.prevRotationYawHead) * var1;
   }

   private float getFloat55(float var1) {
      return Util3.isEntity7(MINECRAFT.thePlayer)
         ? Util3.getFloatForFloat22(var1)
         : MINECRAFT.thePlayer.prevRotationPitch
            + MathHelper.wrapAngleTo180_float(MINECRAFT.thePlayer.rotationPitch - MINECRAFT.thePlayer.prevRotationPitch) * var1;
   }

   private void handleFloat50(float var1) {
      EntityPlayerSP var5 = MINECRAFT.thePlayer;
      double var3 = MINECRAFT.thePlayer.prevPosY + (var5.posY - var5.prevPosY) * var1 + 1.5;
      if (var5.isSneaking()) {
         var3 -= 0.22F;
      }

      Vec3 var6 = new Vec3(var5.prevPosX + (var5.posX - var5.prevPosX) * var1, var3, var5.prevPosZ + (var5.posZ - var5.prevPosZ) * var1);
      float var7 = var5.height + this.valueSettingSub102.getFloat5() - 1.5F;
      this.list2.add(new PivotLiftRecord(var6, var7, this.getFloat56(var1), this.getFloat55(var1) * (this.valueSettingSub105.getFloat5() / 100.0F), 0.0F));
   }

   @Override
   protected void run79() {
      this.list2.clear();
      this.cls.run64();
   }
}
