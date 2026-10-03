package client.onyx.module.render;

import client.onyx.event.impl.EventSub6;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Util18;
import client.onyx.render.Util22;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;

public class CameraModule extends Module {
   private boolean bool2;
   private double double_;
   private static final double DOUBLE = 6.0;
   private double double_2;
   private double double_3;
   private float float_;
   private float float_2;
   private boolean bool3;
   private long long_;
   private float float_3;
   private double double_4;
   private double double_5;
   public CameraModule.AmountBooleanSetting amountBooleanSetting;
   private long long_2;
   private double double_6;
   private float float_4;
   private boolean bool4;
   public CameraModule.SmoothingBooleanSetting smoothingBooleanSetting;
   private double double_7;
   private float float_5;
   private double double_8;
   private float float_6;
   public ValueSettingSub10 valueSettingSub10;
   private double double_9;
   private static final double DOUBLE2 = 8.0;
   private long long_3;
   public ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Smoothing", 95.0, 0.0, 95.0, 5.0)
      .getValueSettingSub10("%")
      .getBooleanSetting("How far the camera lags behind you");

   public double getDouble25() {
      return this.double_8;
   }

   public float getFloat32() {
      return this.float_2;
   }

   public double getDouble23() {
      return this.double_3;
   }

   public void handleFloat43(float var1, float var2) {
      long var3 = System.nanoTime();
      float var6 = this.long_2 == 0L ? 16.0F : Math.min((float)(var3 - this.long_2) / 1000000.0F, 100.0F);
      this.long_2 = var3;
      if (!this.bool3) {
         this.bool3 = true;
         this.float_2 = var1;
         this.float_5 = var2;
      } else {
         double var7 = this.getDouble21(var6);
         this.float_2 = this.float_2 + getFloatForFloat11(var1 - this.float_2) * (float)var7;
         this.float_5 = this.float_5 + (var2 - this.float_5) * (float)var7;
      }
   }

   public float getFloat34() {
      if (this.isEnabled55() && this.amountBooleanSetting.isEnabled5()) {
         float var4 = this.amountBooleanSetting.valueSettingSub10.getFloat5() / 100.0F;
         if (this.amountBooleanSetting.valueSettingSub92.isEnabled17() && MINECRAFT.thePlayer != null) {
            double var2 = Math.sqrt(MINECRAFT.thePlayer.motionX * MINECRAFT.thePlayer.motionX + MINECRAFT.thePlayer.motionZ * MINECRAFT.thePlayer.motionZ);
            return var4 * (float)Math.min(1.0, var2 / 0.14);
         } else {
            return var4;
         }
      } else {
         return 0.0F;
      }
   }

   @EventHandler
   private void handleEventSub62(EventSub6 var1) {
      Util18.run67();
      this.bool4 = false;
      this.bool2 = false;
   }

   public void handleEntity2(Entity var1) {
      if (this.isEnabled55() && this.smoothingBooleanSetting.isEnabled5() && var1 != null) {
         if (MINECRAFT.gameSettings.thirdPersonView == 0 && !MINECRAFT.gameSettings.debugCamEnable) {
            float var7 = var1.rotationYaw;
            float var2 = var1.rotationPitch;
            long var3 = System.nanoTime();
            float var5 = this.long_ == 0L ? 16.0F : Math.min((float)(var3 - this.long_) / 1000000.0F, 100.0F);
            this.long_ = var3;
            CameraModule var9;
            if (!this.bool4) {
               this.bool4 = true;
               this.float_6 = var7;
               this.float_3 = var7;
               this.float_ = this.float_4 = var2;
               var9 = this;
            } else {
               this.float_6 = this.float_3;
               this.float_4 = this.float_;
               double var8;
               float var6 = (var8 = this.smoothingBooleanSetting.valueSettingSub10.getFloat5() / 100.0 * 260.0) <= 0.0
                  ? 1.0F
                  : (float)(1.0 - Math.exp(-var5 / var8));
               this.float_3 = this.float_3 + getFloatForFloat11(var7 - this.float_3) * var6;
               if (this.smoothingBooleanSetting.valueSettingSub92.isEnabled17()) {
                  this.float_ = this.float_ + (var2 - this.float_) * var6;
                  var9 = this;
               } else {
                  this.float_ = var2;
                  var9 = this;
               }
            }

            Util22.handleFloat(var9.float_3, this.float_, this.float_3, this.float_);
         } else {
            this.bool4 = false;
         }
      }
   }

   public void handleDouble7(double var1, double var3, double var5) {
      this.double_8 = var1;
      this.double_6 = var3;
      this.double_ = var5;
      long var7 = System.nanoTime();
      float var9 = this.long_3 == 0L ? 16.0F : Math.min((float)(var7 - this.long_3) / 1000000.0F, 100.0F);
      this.long_3 = var7;
      double var18 = var1 - this.double_2;
      double var11 = var3 - this.double_9;
      double var13 = var5 - this.double_4;
      boolean var17 = var18 * var18 + var11 * var11 + var13 * var13 > 64.0;
      this.double_2 = var1;
      this.double_9 = var3;
      this.double_4 = var5;
      if (this.bool2 && !var17) {
         double var19 = this.getDouble21(var9);
         this.double_5 = this.double_5 + (var1 - this.double_5) * var19;
         this.double_7 = this.double_7 + (var3 - this.double_7) * var19;
         this.double_3 = this.double_3 + (var5 - this.double_3) * var19;
         double var20 = var1 - this.double_5;
         var11 = var3 - this.double_7;
         var13 = var5 - this.double_3;
         double var15;
         if ((var15 = var20 * var20 + var11 * var11 + var13 * var13) > 36.0) {
            var15 = 6.0 / Math.sqrt(var15);
            this.double_5 = var1 - var20 * var15;
            this.double_7 = var3 - var11 * var15;
            this.double_3 = var5 - var13 * var15;
         }
      } else {
         this.bool2 = true;
         this.double_5 = var1;
         this.double_7 = var3;
         this.double_3 = var5;
      }
   }

   @Override
   protected void run79() {
      Util18.run67();
      this.bool4 = false;
      this.long_ = 0L;
      this.bool3 = false;
      this.long_2 = 0L;
      this.bool2 = false;
      this.long_3 = 0L;
      this.double_2 = 0.0;
      this.double_9 = 0.0;
      this.double_4 = 0.0;
   }

   public double getDouble21(float var1) {
      float var5;
      if ((var5 = this.valueSettingSub102.getFloat5()) <= 0.0F) {
         return 1.0;
      } else {
         double var3 = var5 / 100.0 * 400.0;
         return 1.0 - Math.exp(-var1 / var3);
      }
   }

   public double getDouble19() {
      return this.double_5;
   }

   public CameraModule() {
      super("Camera", "Smooth trailing camera position and third-person orbit", ModuleCategory.RENDER);
      this.valueSettingSub10 = new ValueSettingSub10("Distance", 50.0, 50.0, 160.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Third-person camera distance");
      this.smoothingBooleanSetting = new CameraModule.SmoothingBooleanSetting();
      this.amountBooleanSetting = new CameraModule.AmountBooleanSetting();
   }

   public double getDouble24() {
      return this.valueSettingSub10.getFloat5() / 100.0;
   }

   private static float getFloatForFloat11(float var0) {
      float var2;
      if ((var2 = var0 % 360.0F) >= 180.0F) {
         var2 -= 360.0F;
      }

      if (var2 < -180.0F) {
         var2 += 360.0F;
      }

      return var2;
   }

   public double getDouble18() {
      return this.double_;
   }

   public float getFloat33() {
      return this.float_5;
   }

   public double getDouble22() {
      return this.double_7;
   }

   public double getDouble20() {
      return this.double_6;
   }

   public static final class AmountBooleanSetting extends BooleanSetting {
      public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Amount", 45.0, 5.0, 90.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How much of the previous frame is kept");
      public ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Only when moving", true).getBooleanSetting("Fade the blur in with your speed");

      private AmountBooleanSetting() {
         super("Motion blur", false);
      }
   }

   public static final class SmoothingBooleanSetting extends BooleanSetting {
      public ValueSettingSub9 valueSettingSub92;
      public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Smoothing", 40.0, 5.0, 90.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How far the first-person view lags your aim");

      private SmoothingBooleanSetting() {
         super("First person", false);
         this.valueSettingSub92 = new ValueSettingSub9("Smooth pitch", true).getBooleanSetting("Also ease vertical movement, not just turning");
      }
   }
}
