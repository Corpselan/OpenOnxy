package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Sampler0;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.Util4;
import client.onyx.theme.impl.Util2;

public class CrosshairModule extends Module {
   public ValueSettingSub9 valueSettingSub9;
   public ValueSettingSub11<CrosshairModule.RainbowAccentEnum> valueSettingSub112;
   private float float_;
   public ValueSettingSub9 valueSettingSub92;
   private boolean bool2;
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Size", 5.0, 2.0, 16.0, 0.5)
      .getValueSettingSub10("px")
      .getBooleanSetting("Radius of the ring");
   private float float_2;
   private float float_3;
   private float float_4;
   public ValueSettingSub6 valueSettingSub6;
   private long long_;
   public ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Thickness", 1.5, 0.5, 4.0, 0.25).getValueSettingSub10("px");
   private static final long LONG = System.nanoTime();

   private int getInt35(float var1) {
      switch ((CrosshairModule.RainbowAccentEnum)this.valueSettingSub112.lambda15()) {
         case RAINBOW:

            return Util2.getIntForFloat(var1 * 60.0F % 360.0F, 0.75F, 1.0F, 255);
         case ACCENT:
            return Util4.getPrimaryOnPrimaryRecord().primary() | 0xFF000000;
         case CUSTOM:
            return this.valueSettingSub6.lambda15();
         default:
            throw new MatchException(null, null);
      }
   }

   public CrosshairModule() {
      super("Crosshair", "Animated dynamic crosshair", ModuleCategory.RENDER);
      this.valueSettingSub9 = new ValueSettingSub9("Center dot", true);
      this.valueSettingSub112 = new ValueSettingSub11<>("Color", CrosshairModule.RainbowAccentEnum.ACCENT)
         .getBooleanSetting("Rainbow shimmer, the global accent, or a fixed colour");
      this.valueSettingSub6 = new ValueSettingSub6("Custom colour", -1)
         .getValueSettingSub62()
         .getSetting2(() -> this.valueSettingSub112.isEnum3(CrosshairModule.RainbowAccentEnum.CUSTOM));
      this.valueSettingSub10 = new ValueSettingSub10("Follow", 40.0, 0.0, 100.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How much the crosshair drifts with view movement");
      this.valueSettingSub92 = new ValueSettingSub9("Pulse", true).getBooleanSetting("Breathe with the idle animation");
   }

   public void handleSampler016(Sampler0 var1, float var2, float var3) {
      float var4 = this.getFloat58();
      float var7 = (float)(System.nanoTime() - LONG) / 1.0E9F;
      this.handleFloat54(var4);
      var2 = var2 / 2.0F + this.float_4;
      var3 = var3 / 2.0F + this.float_;
      var4 = this.valueSettingSub92.isEnabled17() ? this.getFloat59(var7) : 1.0F;
      var4 = this.valueSettingSub102.getFloat5() * var4;
      float var6 = this.valueSettingSub103.getFloat5();
      int var12 = this.getInt35(var7);
      var1.handleFloat22(var2, var3, var4, var6, var12);
      if (this.valueSettingSub9.isEnabled17()) {
         var1.handleFloat23(var2, var3, Math.max(var6 * 0.9F, 0.75F), var12);
      }
   }

   private float getFloat58() {
      long var1 = System.nanoTime();
      float var4 = this.long_ == 0L ? 16.0F : Math.min((float)(var1 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var1;
      return var4;
   }

   private float getFloat59(float var1) {
      return 1.0F + 0.05F * (float)Math.sin(var1 * 2.2F);
   }

   public boolean isEnabled64() {
      return this.isEnabled55() && MINECRAFT.thePlayer != null && MINECRAFT.gameSettings.thirdPersonView == 0;
   }

   private static float getFloatForFloat13(float var0) {
      float var2;
      if ((var2 = var0 % 360.0F) >= 180.0F) {
         var2 -= 360.0F;
      }

      if (var2 < -180.0F) {
         var2 += 360.0F;
      }

      return var2;
   }

   private void handleFloat54(float var1) {
      float var2 = MINECRAFT.thePlayer.rotationYaw;
      float var6 = MINECRAFT.thePlayer.rotationPitch;
      if (!this.bool2) {
         this.bool2 = true;
         this.float_3 = var2;
         this.float_2 = var6;
      }

      float var4 = getFloatForFloat13(var2 - this.float_3);
      float var5 = var6 - this.float_2;
      this.float_3 = var2;
      this.float_2 = var6;
      var2 = this.valueSettingSub10.getFloat5() / 100.0F * 1.1F;
      var6 = this.valueSettingSub102.getFloat5() * 2.0F;
      var4 = Math.clamp(-var4 * var2, -var6, var6);
      var2 = Math.clamp(-var5 * var2, -var6, var6);
      var1 = 1.0F - (float)Math.exp(-var1 / 70.0F);
      this.float_4 = this.float_4 + (var4 - this.float_4) * var1;
      this.float_ = this.float_ + (var2 - this.float_) * var1;
   }

   public static enum RainbowAccentEnum {
      RAINBOW,
      ACCENT,
      CUSTOM;

   }
}
