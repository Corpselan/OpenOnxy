package client.onyx.module.player.scaffold.mode.settings;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub16;
import client.onyx.module.player.DelayModule;
import client.onyx.setting.SettingGroup;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.Util2;
import client.onyx.util.Util3;
import client.onyx.util.Util6;
import client.onyx.util.math.PositionDirectionRecord;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Vec3;

public class StabilizeMovementSettingGroup extends SettingGroup implements MinecraftAccess {
   private static final double DOUBLE = 0.075;
   public static final StabilizeMovementSettingGroup STABILIZE_MOVEMENT_SETTING_GROUP = new StabilizeMovementSettingGroup();
   private static final double DOUBLE2 = 0.2;

   private StabilizeMovementSettingGroup() {
      super("Stabilize movement", true);
   }

   @EventHandler(
      priority = -10
   )
   private void handleEventSub1611(EventSub16 var1) {
      if (MINECRAFT.thePlayer != null) {
         if (!var1.isEnabled5() || !MINECRAFT.thePlayer.onGround) {
            PositionDirectionRecord var9;
            if ((var9 = DelayModule.DELAY_MODULE.getPositionDirectionRecord2()) != null) {
               ForwardsBackwardsRecord var3 = var1.getForwardsBackwardsRecord2();
               Vec3 var4 = Util2.getVec3ForEntity2(MINECRAFT.thePlayer);
               Vec3 var10;
               Vec3 var5 = (var10 = var9.getVec34(var4)).subtract(var4);
               Vec3 var6 = Util6.getVec3ForVec38(Util2.getVec3ForEntity3(MINECRAFT.thePlayer), 0.0);
               boolean var14 = var5.dotProduct(var6) > 0.0;
               double var7 = var14 ? 0.075 : 0.2;
               if (!(var10.distanceToSqr(var4) < var7 * var7)) {
                  float var11 = Util3.getFloatForVec3(var10.subtract(var4), MINECRAFT.thePlayer.rotationYaw);
                  ForwardsBackwardsRecord var12 = Util3.getForwardsBackwardsRecordForForwardsBackwardsRecord2(
                     ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8, var11, 0.0F
                  );
                  boolean var13 = var3.forwards() || var3.backwards();
                  boolean var15 = var3.right() || var3.left();
                  boolean var10003;
                  boolean var10004;
                  if (var13) {
                     var10003 = var3.forwards();
                     var10004 = var13;
                  } else {
                     var10003 = var12.forwards();
                     var10004 = var13;
                  }

                  boolean var10005;
                  if (var10004) {
                     var10004 = var3.backwards();
                     var10005 = var15;
                  } else {
                     var10004 = var12.backwards();
                     var10005 = var15;
                  }

                  boolean var10006;
                  if (var10005) {
                     var10005 = var3.left();
                     var10006 = var15;
                  } else {
                     var10005 = var12.left();
                     var10006 = var15;
                  }

                  ForwardsBackwardsRecord var10001 = new ForwardsBackwardsRecord(var10003, var10004, var10005, var10006 ? var3.right() : var12.right());
                  var1.handleForwardsBackwardsRecord(var10001);
               }
            }
         }
      }
   }
}
