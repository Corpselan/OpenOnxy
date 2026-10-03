package client.onyx.module.player.scaffold.extra;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub13;
import client.onyx.event.impl.EventSub14;
import client.onyx.event.impl.EventSub16;
import client.onyx.event.impl.EventSub2;
import client.onyx.event.impl.EventSub4;
import client.onyx.event.impl.EventSub6;
import client.onyx.event.impl.IncomingOutgoingEnum;
import client.onyx.module.movement.NoSlowModule;
import client.onyx.module.player.DelayModule;
import client.onyx.module.player.scaffold.Cls;
import client.onyx.rotation.Cls2;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.mode.OffStrictEnum;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.Setting;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.util.Cls7;
import client.onyx.util.Util2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;

public class ModeSettingGroup extends SettingGroup implements MinecraftAccess {
   private final transient Cls7 cls7;
   private final transient List<Packet> list2;
   private transient boolean bool2;
   public ValueSettingSub9 valueSettingSub92;
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub11<ModeSettingGroup.DoNotChangeForceSprintEnum> valueSettingSub11;
   public static final ModeSettingGroup MODE_SETTING_GROUP = new ModeSettingGroup();
   private transient boolean bool3;
   private static final long LONG = 329L;
   private transient boolean bool4;
   public ValueSettingSub10 valueSettingSub102;
   private final transient Cls cls;

   @EventHandler(
      priority = -10
   )
   private void handleEventSub13(EventSub13 var1) {
      switch ((ModeSettingGroup.DoNotChangeForceSprintEnum)this.valueSettingSub11.lambda15()) {
         case DO_NOT_CHANGE:
         default:
            break;
         case FORCE_SPRINT:

            if (var1.getForwardsBackwardsRecord().isEnabled()) {
               var1.handleBool2(true);
               return;
            }
            break;
         case FORCE_NO_SPRINT:
            var1.handleBool2(false);
            return;
         case NO_SPRINT_ON_PLACE:
            if (this.bool3 && !MINECRAFT.thePlayer.willJumpThisTick()) {
               var1.handleBool2(false);
               return;
            }
            break;
         case NO_SPRINT_ON_GROUND:
            var1.handleBool2(!MINECRAFT.thePlayer.onGround);
            return;
         case KEEP_Y:
            if (!var1.getForwardsBackwardsRecord().isEnabled()) {
               return;
            }

            if (this.bool3 && !MINECRAFT.thePlayer.willJumpThisTick()) {
               var1.handleBool2(false);
               return;
            }

            if (MINECRAFT.thePlayer.movementInput.moveForward >= NoSlowModule.getFloat88()) {
               var1.handleBool2(true);
               return;
            }
      }
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void run166() {
      this.bool4 = false;
      if (!this.list2.isEmpty()) {
         ArrayList var2 = new ArrayList<>(this.list2);
         this.list2.clear();
         if (MINECRAFT.getNetHandler() != null) {
            this.bool2 = true;

            try {
               MINECRAFT.getNetHandler().getNetworkManager().sendGrouped(var2);
            } catch (Throwable var4) {
               this.bool2 = false;
               throw var4;
            }

            this.bool2 = false;
         }
      }
   }

   @Override
   protected void run4() {
      this.run166();
   }

   public boolean isEnabled134() {
      return this.isEnabled136()
         && (
            this.valueSettingSub11.isEnum3(ModeSettingGroup.DoNotChangeForceSprintEnum.FORCE_SPRINT)
               || this.valueSettingSub11.isEnum3(ModeSettingGroup.DoNotChangeForceSprintEnum.KEEP_Y)
         );
   }

   @Override
   protected void run3() {
      this.bool3 = false;
      this.run165();
   }

   @EventHandler(
      priority = -500
   )
   private void handleEventSub1615(EventSub16 var1) {
      if (this.valueSettingSub11.isEnum3(ModeSettingGroup.DoNotChangeForceSprintEnum.KEEP_Y) && MINECRAFT.thePlayer != null) {
         if (!this.bool3) {
            if (var1.getForwardsBackwardsRecord2().isEnabled()) {
               if (MINECRAFT.thePlayer.willJumpThisTick(var1.isEnabled5())) {
                  Cls2 var2;
                  if ((var2 = client.onyx.rotation.Cls.CLS.getCls27()) != null && var2.getOffStrictEnum2() != OffStrictEnum.OFF) {
                     if (ThreadLocalRandom.current().nextInt(100) < this.valueSettingSub102.getInt10()) {
                        float var3 = Util2.getFloatForEntityPlayerSP4(MINECRAFT.thePlayer, var1.getForwardsBackwardsRecord2());
                        YawPitchRecord var5;
                        if ((var5 = client.onyx.rotation.Cls.CLS.getYawPitchRecord()) == null) {
                           var5 = Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer);
                        }

                        if (!(Math.abs(client.onyx.rotation.util.Util.getFloatForFloat9(var3, var5.yaw2())) > this.valueSettingSub10.getFloat5())) {
                           float var6 = (float)ThreadLocalRandom.current().nextDouble(60.0, 70.0);
                           float var4 = this.cls.getFloat(var3, DelayModule.DELAY_MODULE.considerInventoryBooleanSetting.valueSettingSub103.lambda15());
                           client.onyx.rotation.Cls.CLS.handleYawPitchRecord(new YawPitchRecord(var4, var6).getYawPitchRecord());
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private ModeSettingGroup() {
      super("Sprint control", false);
      ModeSettingGroup.DoNotChangeForceSprintEnum var1 = ModeSettingGroup.DoNotChangeForceSprintEnum.DO_NOT_CHANGE;
      ModeSettingGroup.DoNotChangeForceSprintEnum[] var2 = new ModeSettingGroup.DoNotChangeForceSprintEnum[]{
         ModeSettingGroup.DoNotChangeForceSprintEnum.DO_NOT_CHANGE,
         ModeSettingGroup.DoNotChangeForceSprintEnum.FORCE_SPRINT,
         ModeSettingGroup.DoNotChangeForceSprintEnum.FORCE_NO_SPRINT,
         ModeSettingGroup.DoNotChangeForceSprintEnum.KEEP_Y
      };
      ValueSettingSub11 var3 = new ValueSettingSub11<>("Mode", var1, var2);
      this.valueSettingSub11 = var3;
      this.valueSettingSub102 = new ValueSettingSub10("Jump forward chance", 100.0, 0.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Chance to redirect the sprint jump impulse along the movement direction")
         .getSetting2(() -> this.valueSettingSub11.isEnum3(ModeSettingGroup.DoNotChangeForceSprintEnum.KEEP_Y));
      this.valueSettingSub10 = new ValueSettingSub10("Max flick", 75.0, 0.0, 180.0, 1.0)
         .getValueSettingSub10("°")
         .getBooleanSetting("Skips the jump-forward snap when it would flick the sent yaw further than this")
         .getSetting2(() -> this.valueSettingSub11.isEnum3(ModeSettingGroup.DoNotChangeForceSprintEnum.KEEP_Y));
      this.valueSettingSub92 = new ValueSettingSub9("Blink jump", true)
         .getBooleanSetting("Holds outgoing packets from the jump until the next placement, so the rotation flip and the ascent arrive as one lag burst")
         .getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.cls = new Cls();
      this.list2 = new CopyOnWriteArrayList<>();
      this.cls7 = new Cls7(System.currentTimeMillis());
   }

   private void run165() {
      this.bool4 = false;
      this.bool2 = false;
      this.list2.clear();
   }

   @EventHandler
   private void handleEventSub45(EventSub4 var1) {
      if (this.valueSettingSub11.isEnum3(ModeSettingGroup.DoNotChangeForceSprintEnum.KEEP_Y) && this.valueSettingSub92.lambda15()) {
         if (MINECRAFT.thePlayer != null && Util2.isEntityPlayerSP(MINECRAFT.thePlayer)) {
            this.run166();
            this.bool4 = true;
            this.cls7.run();
         }
      }
   }

   public void run167() {
      this.bool3 = true;
   }

   @EventHandler
   private void handleEventSub618(EventSub6 var1) {
      this.run165();
   }

   @EventHandler(
      priority = 500
   )
   private void handleEventSub148(EventSub14 var1) {
      if (!this.bool2 && !var1.isEnabled()) {
         if (var1.getIncomingOutgoingEnum() == IncomingOutgoingEnum.INCOMING) {
            if (var1.getPacket() instanceof S08PacketPlayerPosLook) {
               this.run166();
            }
         } else if (this.bool4) {
            if (var1.getPacket() instanceof C08PacketPlayerBlockPlacement) {
               this.run166();
            } else {
               this.list2.add(var1.getPacket());
               var1.run();
            }
         }
      }
   }

   @EventHandler(
      priority = 1000
   )
   private void handleEventSub210(EventSub2 var1) {
      if (this.bool3) {
         this.bool3 = false;
      }

      if (this.bool4 && MINECRAFT.thePlayer != null && (MINECRAFT.thePlayer.onGround || this.cls7.isLong(329L))) {
         this.run166();
      }
   }

   public static enum DoNotChangeForceSprintEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      DO_NOT_CHANGE("Do not change"),
      FORCE_SPRINT("Force sprint"),
      FORCE_NO_SPRINT("Force no sprint"),
      NO_SPRINT_ON_PLACE("No sprint on place"),
      NO_SPRINT_ON_GROUND("No sprint on ground"),
      KEEP_Y("Keep Y");
      private final String string;

      static {
         ModeSettingGroup.DoNotChangeForceSprintEnum[] var0 = new ModeSettingGroup.DoNotChangeForceSprintEnum[]{
            DO_NOT_CHANGE, FORCE_SPRINT, FORCE_NO_SPRINT, NO_SPRINT_ON_PLACE, NO_SPRINT_ON_GROUND, KEEP_Y
         };
      }

      @Override
      public String getString5() {
         return this.string;
      }

      private DoNotChangeForceSprintEnum(String var3) {
         this.string = var3;
      }
   }
}
