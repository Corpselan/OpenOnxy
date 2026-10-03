package client.onyx.module.player.scaffold.extra;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub2;
import client.onyx.setting.Setting;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.util.Util2;
import client.onyx.util.Util6;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class StrafeSettingGroup extends SettingGroup implements MinecraftAccess {
   private transient int int_3;
   public ValueSettingSub9 valueSettingSub92;
   public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Speed", 0.247, 0.0, 5.0, 0.001);
   public static final StrafeSettingGroup STRAFE_SETTING_GROUP = new StrafeSettingGroup();
   public ValueSettingSub9 valueSettingSub93;

   @EventHandler
   private void handleEventSub29(EventSub2 var1) {
      if (MINECRAFT.thePlayer != null) {
         StrafeSettingGroup var10000;
         if (Util2.isEntityPlayerSP(MINECRAFT.thePlayer)) {
            this.int_3++;
            var10000 = this;
         } else {
            this.int_3 = 0;
            var10000 = this;
         }

         if (!var10000.valueSettingSub93.lambda15() || MINECRAFT.thePlayer.onGround) {
            if (this.valueSettingSub92.lambda15()) {
               double var2 = 0.207;
               PotionEffect var4;
               if (((var4 = MINECRAFT.thePlayer.getActivePotionEffect(Potion.moveSpeed)) != null ? var4.getAmplifier() : -1) >= 0) {
                  var2 = 0.295;
               }

               if (MINECRAFT.thePlayer.ticksExisted % 20 == 0 || this.int_3 <= 7) {
                  var2 = 0.09800000190734863;
               }

               Util2.handleEntity3(MINECRAFT.thePlayer, Util2.getVec3ForVec34(Util2.getVec3ForEntity3(MINECRAFT.thePlayer), var2));
            } else {
               Util2.handleEntity3(MINECRAFT.thePlayer, Util2.getVec3ForVec34(Util2.getVec3ForEntity3(MINECRAFT.thePlayer), this.valueSettingSub10.getFloat5()));
            }
         }
      }
   }

   @Override
   protected void run4() {
      if (this.valueSettingSub92.lambda15() && MINECRAFT.thePlayer != null) {
         Util2.handleEntity3(MINECRAFT.thePlayer, Util6.getVec3ForVec37(Util2.getVec3ForEntity3(MINECRAFT.thePlayer), 0.5, 1.0, 0.5));
      }
   }

   @Override
   protected void run3() {
      this.int_3 = 0;
   }

   private StrafeSettingGroup() {
      super("Strafe", false);
      this.valueSettingSub92 = new ValueSettingSub9("Hypixel", false);
      this.valueSettingSub93 = new ValueSettingSub9("Only on ground", false);
      this.getSetting2(Setting.BOOLEAN_SUPPLIER);
   }
}
