package client.onyx.module.movement;

import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub10;
import client.onyx.event.impl.EventSub6;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.combat.KillAuraModule;
import client.onyx.module.player.DelayModule;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.OffStrictEnum;
import client.onyx.system.Util6;
import client.onyx.system.YawPitchRecord;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;

public class NoSlowModule extends Module {
   private boolean bool2;
   public ValueSettingSub9 valueSettingSub9 = new ValueSettingSub9("Pause on KillAura", true)
      .getBooleanSetting("Fully disables NoSlow while KillAura is enabled, so the two never trade rotations");
   private boolean bool3;

   private void run125() {
      this.bool3 = false;
      if (this.bool2) {
         Util6.run183();
         this.bool2 = false;
      }
   }

   private static NoSlowModule getNoSlowModule() {
      return OnyxClient.cls == null ? null : OnyxClient.cls.noSlowModule;
   }

   public static boolean isEnabled93() {
      NoSlowModule var0;
      return (var0 = getNoSlowModule()) == null || !isEnabled97() || !var0.bool2
         ? false
         : MINECRAFT.thePlayer != null && var0.isEnabled94() && !MINECRAFT.thePlayer.isRiding();
   }

   public static void run127() {
      NoSlowModule var0;
      if ((var0 = getNoSlowModule()) != null && isEnabled97() && var0.bool2) {
         if (MINECRAFT.thePlayer != null && MINECRAFT.thePlayer.movementInput != null) {
            if (!MINECRAFT.thePlayer.isCollidedHorizontally) {
               if (!(MINECRAFT.thePlayer.movementInput.moveForward <= 0.0F)) {
                  MINECRAFT.thePlayer.setSprinting(true);
               }
            }
         }
      }
   }

   public static void run126() {
      NoSlowModule var0;
      if ((var0 = getNoSlowModule()) != null && isEnabled97()) {
         if (MINECRAFT.thePlayer != null && MINECRAFT.thePlayer.movementInput != null) {
            if (isEnabled93() && isEnabled98()) {
               MovementInput var1 = MINECRAFT.thePlayer.movementInput;
               float var3 = var1.moveForward * 0.2F;
               var1.moveForward = var3;
               MovementInput var4 = MINECRAFT.thePlayer.movementInput;
               float var6 = var4.moveStrafe * 0.2F;
               var4.moveStrafe = var6;
            }

            if (var0.bool3) {
               MINECRAFT.thePlayer.movementInput.jump = false;
            }
         }
      }
   }

   public NoSlowModule() {
      super("NoSlow", "Stops KillAura's blocking from slowing you down", ModuleCategory.MOVEMENT);
   }

   private boolean isEnabled95() {
      if (!this.valueSettingSub9.isEnabled17()) {
         return false;
      } else {
         KillAuraModule var2 = OnyxClient.cls == null ? null : OnyxClient.cls.killAuraModule;
         return var2 != null && var2.isEnabled55();
      }
   }

   public static boolean isEnabled97() {
      NoSlowModule var0;
      return (var0 = getNoSlowModule()) != null && var0.isEnabled55() && !DelayModule.DELAY_MODULE.isEnabled55() && !var0.isEnabled95();
   }

   public static boolean isEnabled99() {
      NoSlowModule var0;
      return (var0 = getNoSlowModule()) != null && var0.bool2;
   }

   private boolean isEnabled94() {
      return MINECRAFT.thePlayer.isUsingItem();
   }

   private static float getFloat89() {
      GameSettings var0 = MINECRAFT.gameSettings;
      float var1 = 180.0F;
      if (var0.keyBindBack.isKeyDown()) {
         var1 = 0.0F;
         if (var0.keyBindRight.isKeyDown()) {
            var1 -= 45.0F;
         }

         if (var0.keyBindLeft.isKeyDown()) {
            var1 += 45.0F;
         }
      } else if (var0.keyBindForward.isKeyDown()) {
         if (var0.keyBindRight.isKeyDown()) {
            var1 = 225.0F;
         }

         if (var0.keyBindLeft.isKeyDown()) {
            var1 -= 45.0F;
         }
      } else {
         if (var0.keyBindRight.isKeyDown()) {
            var1 = 270.0F;
         }

         if (var0.keyBindLeft.isKeyDown()) {
            var1 -= 90.0F;
         }
      }

      return (MathHelper.wrapAngleTo180_float(MINECRAFT.thePlayer.rotationYaw) + var1 % 360.0F + 360.0F) % 360.0F;
   }

   private boolean isEnabled100() {
      ItemStack var2;
      return (var2 = MINECRAFT.thePlayer.getHeldItem()) != null && var2.getItem() != Items.bow;
   }

   private static boolean isEnabled98() {
      GameSettings var0 = MINECRAFT.gameSettings;
      return MINECRAFT.gameSettings.keyBindRight.isKeyDown() || var0.keyBindLeft.isKeyDown() || var0.keyBindForward.isKeyDown() || var0.keyBindBack.isKeyDown();
   }

   @EventHandler
   public void handleEventSub69(EventSub6 var1) {
      this.run125();
   }

   private boolean isEnabled96() {
      KillAuraModule var2 = OnyxClient.cls.killAuraModule;
      return OnyxClient.cls.killAuraModule.isEnabled55() && var2.getEntityLivingBase3() != null;
   }

   @EventHandler(
      priority = -50
   )
   public void handleEventSub10(EventSub10 var1) {
      this.bool3 = false;
      if (MINECRAFT.thePlayer == null || MINECRAFT.theWorld == null || !isEnabled97()) {
         this.run125();
      } else if (this.isEnabled96()) {
         this.bool2 = false;
      } else if (this.isEnabled94() && this.isEnabled100()) {
         float var2 = getFloat89() + 180.0F;
         if (!MINECRAFT.gameSettings.keyBindJump.isKeyDown() || !MINECRAFT.thePlayer.onGround) {
            var2 -= 45.0F;
            this.bool3 = true;
         }

         Util6.handleYawPitchRecord3(new YawPitchRecord(var2, MINECRAFT.thePlayer.rotationPitch), OffStrictEnum.SILENT);
         this.bool2 = true;
      } else {
         this.run125();
      }
   }

   public static float getFloat88() {
      return isEnabled93() ? 0.1F : 0.8F;
   }

   @Override
   protected void run79() {
      this.run125();
   }
}
