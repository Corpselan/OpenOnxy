package client.onyx.module.combat;

import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub;
import client.onyx.event.impl.EventSub11;
import client.onyx.event.impl.EventSub16;
import client.onyx.event.impl.EventSub17;
import client.onyx.event.impl.EventSub6;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.player.DelayModule;
import client.onyx.setting.Setting;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.OffStrictEnum;
import client.onyx.system.Util6;
import client.onyx.system.YawPitchRecord;
import client.onyx.util.Cls7;
import client.onyx.util.ForwardsBackwardsRecord;
import java.util.concurrent.ThreadLocalRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;

public class JumpResetModule extends Module {
   private boolean bool2;
   public ValueSettingSub9 valueSettingSub9;
   public ValueSettingSub<PlayersTeammatesEnum> valueSettingSub;
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub10 valueSettingSub102;
   public ValueSettingSub9 valueSettingSub92;
   private static final long LONG = 550L;
   private boolean bool3;
   private int int_;
   private volatile boolean bool4;
   private static final int INT = 3;
   public ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Chance", 100.0, 0.0, 100.0, 1.0).getValueSettingSub10("%");
   private final Cls7 cls7;

   public boolean isEnabled108() {
      if (MINECRAFT.thePlayer == null) {
         return false;
      } else if (this.valueSettingSub9.isEnabled17() && !new ForwardsBackwardsRecord(MINECRAFT.thePlayer.movementInput).isEnabled()) {
         return false;
      } else if (ThreadLocalRandom.current().nextDouble(100.0) >= this.valueSettingSub103.lambda15()) {
         return false;
      } else if (MINECRAFT.thePlayer.isPotionActive(Potion.jump)) {
         return false;
      } else {
         return !this.bool4 ? false : MINECRAFT.thePlayer.isSprinting();
      }
   }

   @EventHandler
   private void handleEventSub175(EventSub17 var1) {
      if (this.int_ > 0) {
         int var3 = this.int_ - 1;
         this.int_ = var3;
      } else {
         if (this.bool2 && this.cls7.isLong(550L)) {
            Util6.run183();
            this.bool2 = false;
         }
      }
   }

   private void run141() {
      this.bool3 = false;
      this.int_ = 0;
      if (this.bool2) {
         Util6.run183();
         this.bool2 = false;
      }
   }

   @EventHandler
   private void handleEventSub612(EventSub6 var1) {
      this.run141();
   }

   public JumpResetModule() {
      super("JumpReset", "Jump resets and reduces knockback in combat", ModuleCategory.COMBAT);
      this.valueSettingSub10 = new ValueSettingSub10("FOV", 180.0, 0.0, 360.0, 1.0).getValueSettingSub10("°").getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub102 = new ValueSettingSub10("Range", 5.0, 1.0, 8.0, 0.1);
      this.valueSettingSub9 = new ValueSettingSub9("Require moving", true);
      this.valueSettingSub92 = new ValueSettingSub9("Reduce", false)
         .getBooleanSetting("Silently faces the knockback source so the forced input runs into it")
         .getSetting2(Setting.BOOLEAN_SUPPLIER);
      PlayersTeammatesEnum[] var10005 = new PlayersTeammatesEnum[1];
      boolean var10007 = true;
      var10005[0] = PlayersTeammatesEnum.PLAYERS;
      this.valueSettingSub = new ValueSettingSub<>("Targets", PlayersTeammatesEnum.class, var10005);
      this.cls7 = new Cls7();
   }

   @EventHandler
   private void handleEventSub165(EventSub16 var1) {
      if (this.bool3) {
         this.bool3 = false;
         ForwardsBackwardsRecord var3 = var1.getForwardsBackwardsRecord2();
         var1.handleForwardsBackwardsRecord(new ForwardsBackwardsRecord(true, false, var3.left(), var3.right()));
         var1.handleBool3(true);
      }
   }

   public static boolean isEnabled107() {
      JumpResetModule var0 = OnyxClient.cls == null ? null : OnyxClient.cls.jumpResetModule;
      return var0 != null && var0.isEnabled55() && var0.isEnabled108();
   }

   @EventHandler
   private void handleEventSub117(EventSub11 var1) {
      this.bool4 = MINECRAFT.thePlayer != null
         && PlayersTeammatesEnum.isDouble11(this.valueSettingSub102.lambda15(), this.valueSettingSub10.getFloat5(), this.valueSettingSub.lambda15());
   }

   @Override
   protected void run79() {
      this.run141();
   }

   @EventHandler
   private void handleEventSub(EventSub var1) {
      if (!(var1.getDouble() <= 0.0)) {
         if (this.isEnabled108()) {
            this.bool3 = true;
            this.int_ = 3;
            if (this.valueSettingSub92.isEnabled17() && !Util6.isEnabled140() && !DelayModule.DELAY_MODULE.isEnabled55()) {
               float var2 = (float)MathHelper.wrapAngleTo180_double(Math.toDegrees(Math.atan2(-var1.getDouble3(), var1.getDouble2())) - 180.0);
               Util6.handleYawPitchRecord3(new YawPitchRecord(var2, MINECRAFT.thePlayer.rotationPitch), OffStrictEnum.SILENT);
               this.bool2 = true;
               this.cls7.run();
            }
         }
      }
   }
}
