package client.onyx.module.render;

import client.onyx.event.impl.EventSub11;
import client.onyx.event.impl.EventSub6;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Util22;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.MathHelper;

public final class FreelookModule extends Module {
   private float float_;
   private float float_2;
   private boolean bool2;
   private float float_3;
   public final ValueSettingSub10 valueSettingSub10;
   private int int_;
   private static final double DOUBLE = 0.15;
   public final ValueSettingSub11<FreelookModule.BackFrontEnum> valueSettingSub112 = new ValueSettingSub11<>("Perspective", FreelookModule.BackFrontEnum.BACK)
      .getBooleanSetting("Which way the detached camera faces");
   private float float_4;

   @EventHandler
   private void handleEventSub65(EventSub6 var1) {
      this.run94();
   }

   @Override
   protected void run79() {
      this.run94();
   }

   private void run94() {
      if (this.bool2) {
         this.bool2 = false;
         MINECRAFT.gameSettings.thirdPersonView = this.int_;
      }
   }

   @EventHandler
   private void handleEventSub113(EventSub11 var1) {
      this.float_3 = this.float_4;
      this.float_ = this.float_2;
   }

   public boolean isFloat8(float var1, float var2) {
      if (this.isEnabled55() && MINECRAFT.thePlayer != null) {
         this.run95();
         double var3 = 0.15 * (this.valueSettingSub10.getFloat5() / 100.0);
         this.float_4 += (float)(var1 * var3);
         this.float_2 = MathHelper.clamp_float((float)(this.float_2 - var2 * var3), -90.0F, 90.0F);
         return true;
      } else {
         return false;
      }
   }

   public FreelookModule() {
      super("Freelook", "Look around without turning your player", ModuleCategory.RENDER);
      this.valueSettingSub10 = new ValueSettingSub10("Sensitivity", 100.0, 25.0, 200.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Mouse speed while looking around");
   }

   @Override
   protected void run80() {
      this.bool2 = false;
   }

   public void run96() {
      if (this.isEnabled55() && MINECRAFT.thePlayer != null) {
         this.run95();
         Util22.handleFloat(this.float_4, this.float_2, this.float_3, this.float_);
      }
   }

   private void run95() {
      if (!this.bool2 && MINECRAFT.thePlayer != null) {
         this.float_3 = MINECRAFT.thePlayer.rotationYaw;
         this.float_4 = MINECRAFT.thePlayer.rotationYaw;
         this.float_ = MINECRAFT.thePlayer.rotationPitch;
         this.float_2 = MINECRAFT.thePlayer.rotationPitch;
         this.int_ = MINECRAFT.gameSettings.thirdPersonView;
         MINECRAFT.gameSettings.thirdPersonView = this.valueSettingSub112.lambda15().getInt();
         this.bool2 = true;
      }
   }

   public static enum BackFrontEnum implements DisplayNamed {
      BACK("Behind", 1),
      FRONT("In front", 2);
      private final int int_;
      private final String string;

      private BackFrontEnum(String var3, int var4) {
         this.string = var3;
         this.int_ = var4;
      }

      public int getInt() {
         return this.int_;
      }

      @Override
      public String getString5() {
         return this.string;
      }

   }
}
