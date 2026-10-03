package client.onyx.module.render;

import client.onyx.event.impl.EventSub6;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Util9;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.impl.Util2;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.MathHelper;

public final class HurtcamModule extends Module {
   private long long_;
   public final ValueSettingSub10 valueSettingSub10;
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub10 valueSettingSub102;
   private static final float FLOAT = 100.0F;
   private float float_;
   public final ValueSettingSub6 valueSettingSub6 = new ValueSettingSub6("Color", -49088).getBooleanSetting("Tint of the damage wash");
   private int int_;
   private client.onyx.render.extra.Cls cls;
   private boolean bool2;
   public final ValueSettingSub10 valueSettingSub103;
   private float float_2;
   public final ValueSettingSub9 valueSettingSub92;
   private float float_3;

   public HurtcamModule() {
      super("Hurtcam", "Soft red flash around the screen when you take damage", ModuleCategory.RENDER);
      this.valueSettingSub10 = new ValueSettingSub10("Intensity", 45.0, 5.0, 100.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How strong the wash gets at full health loss");
      this.valueSettingSub103 = new ValueSettingSub10("Size", 55.0, 10.0, 100.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How far in from the edge the wash reaches");
      this.valueSettingSub102 = new ValueSettingSub10("Duration", 450.0, 100.0, 1500.0, 50.0)
         .getValueSettingSub10("ms")
         .getBooleanSetting("How long the wash takes to fade out");
      this.valueSettingSub9 = new ValueSettingSub9("Scale with damage", true).getBooleanSetting("Bigger hits flash brighter");
      this.valueSettingSub92 = new ValueSettingSub9("Directional", false).getBooleanSetting("Bias the wash towards where the hit came from");
   }

   private void run88() {
      this.float_3 = this.float_2 = 0.0F;
      this.int_ = 0;
      this.float_ = 0.0F;
      this.long_ = 0L;
   }

   @Override
   protected void run80() {
      this.run88();
   }

   @Override
   protected void run79() {
      this.run88();
   }

   public void run90() {
      if (this.isEnabled55() && MINECRAFT.thePlayer != null) {
         this.run89();
         if (!(this.float_2 <= 0.002F)) {
            if (Util9.isEnabled45()) {
               if (!this.bool2) {
                  this.cls = client.onyx.render.extra.Cls.getClsForString2("onyx_hurt", "onyx_post", "onyx_hurt");
                  this.bool2 = true;
               }

               if (this.cls != null && this.cls.isEnabled()) {
                  int var1 = this.valueSettingSub6.lambda15();
                  float var2 = this.float_2 * (this.valueSettingSub10.getFloat5() / 100.0F);
                  float var3 = this.valueSettingSub103.getFloat5() / 100.0F;
                  boolean var5 = this.valueSettingSub92.isEnabled17();
                  Util9.handleCls5(this.cls, var5x -> {
                     var5x.handleString3("uTint", Util2.getIntForInt7(var1) / 255.0F, Util2.getIntForInt(var1) / 255.0F, Util2.getIntForInt2(var1) / 255.0F);
                     var5x.handleString("uStrength", var2 * (Util2.getIntForInt6(var1) / 255.0F));
                     var5x.handleString("uReach", var3);
                     var5x.handleString("uBias", this.float_);
                     var5x.handleString("uDirectional", var5 ? 1.0F : 0.0F);
                  });
               }
            }
         }
      }
   }

   private void run89() {
      long var1 = System.nanoTime();
      float var4 = this.long_ == 0L ? 16.0F : Math.min((float)(var1 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var1;
      int var5 = MINECRAFT.thePlayer.hurtTime;
      if (MINECRAFT.thePlayer.hurtTime > this.int_) {
         this.float_3 = 1.0F;
         if (this.valueSettingSub9.isEnabled17()) {
            float var2 = Math.max(1.0F, (float)MINECRAFT.thePlayer.maxHurtTime);
            this.float_3 = MathHelper.clamp_float(var5 / var2, 0.35F, 1.0F);
         }

         this.float_2 = Math.max(this.float_2, this.float_3);
         this.float_ = MINECRAFT.thePlayer.attackedAtYaw;
      }

      this.int_ = var5;
      float var6 = this.valueSettingSub102.getFloat5();
      this.float_2 = this.float_2 - (var6 <= 0.0F ? this.float_2 : var4 / var6 * this.float_3);
      if (this.float_2 < 0.0F) {
         this.float_2 = 0.0F;
      }
   }

   @EventHandler
   private void handleEventSub63(EventSub6 var1) {
      this.run88();
   }
}
