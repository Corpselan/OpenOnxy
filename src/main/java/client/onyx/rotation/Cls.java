package client.onyx.rotation;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub14;
import client.onyx.event.impl.EventSub2;
import client.onyx.event.impl.EventSub7;
import client.onyx.event.impl.EventSub8;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.mode.OffStrictEnum;
import client.onyx.rotation.util.Util;
import client.onyx.system.Util6;
import client.onyx.util.Cls5;
import client.onyx.util.Iface;
import client.onyx.util.NotImportantNormalEnum;
import client.onyx.util.Util2;
import java.util.Objects;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.Vec3;

public class Cls implements MinecraftAccess {
   private YawPitchRecord yawPitchRecord;
   private final client.onyx.util.Cls<Cls2> cls = new client.onyx.util.Cls<>();
   public static final Cls CLS = new Cls();
   private YawPitchRecord yawPitchRecord2;
   private YawPitchRecord yawPitchRecord3;
   private YawPitchRecord yawPitchRecord4;
   private Cls2 cls2;
   private YawPitchRecord yawPitchRecord5;

   public void handleYawPitchRecord(YawPitchRecord var1) {
      Cls var10000;
      if (var1 == null) {
         this.yawPitchRecord2 = null;
         var10000 = this;
      } else if (this.yawPitchRecord3 != null) {
         this.yawPitchRecord2 = this.yawPitchRecord3;
         var10000 = this;
      } else {
         this.yawPitchRecord2 = MINECRAFT.thePlayer != null ? Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer) : YawPitchRecord.YAW_PITCH_RECORD;
         var10000 = this;
      }

      var10000.yawPitchRecord3 = var1;
   }

   public YawPitchRecord getYawPitchRecord2() {
      return this.yawPitchRecord;
   }

   public boolean isCls2(Cls2 var1) {
      if (!this.isEnabled52()) {
         return false;
      } else {
         return !var1.isEnabled53() ? true : !client.onyx.util.Cls2.CLS2.isEnabled() && !(MINECRAFT.currentScreen instanceof GuiContainer);
      }
   }

   public Cls2 getCls25() {
      return this.cls2;
   }

   public Cls2 getCls27() {
      Cls2 var2;
      return (var2 = this.getCls26()) != null ? var2 : this.cls2;
   }

   private boolean isEnabled50() {
      return MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null;
   }

   private Cls2 getCls26() {
      return this.cls.getObject();
   }

   public YawPitchRecord getYawPitchRecord5() {
      return this.yawPitchRecord;
   }

   public YawPitchRecord getYawPitchRecord() {
      return this.yawPitchRecord3;
   }

   @EventHandler(
      priority = -10
   )
   private void handleEventSub8(EventSub8 var1) {
      if (this.isEnabled50()) {
         if (!Util6.isEnabled140()) {
            Cls2 var3;
            if ((var3 = this.getCls27()) == null || var3.getOffStrictEnum2() != OffStrictEnum.OFF) {
               if (this.yawPitchRecord3 != null) {
                  Vec3 var4 = var1.getVec33();
                  float var5 = var1.getFloat();
                  float var6 = this.yawPitchRecord3.yaw2();
                  Vec3 var7 = Util2.getVec3ForVec37(var4, var5, var6);
                  var1.handleVec32(var7);
               }
            }
         }
      }
   }

   public void handleFloat38(float var1) {
      if (this.isEnabled50()) {
         Cls2 var3;
         if ((var3 = this.getCls27()) != null) {
            if (this.isCls2(var3) && var3.getOffStrictEnum2() == OffStrictEnum.CHANGE_LOOK) {
               if (this.yawPitchRecord4 != null && this.yawPitchRecord3 != null) {
                  EntityPlayerSP var4 = MINECRAFT.thePlayer;
                  YawPitchRecord var6 = this.yawPitchRecord4.getYawPitchRecord3(this.yawPitchRecord3, var1);
                  Util.handleEntityPlayerSP(var4, var6);
               }
            }
         }
      }
   }

   public void handleDouble6(double var1, double var3) {
      if (this.isEnabled50()) {
         Cls2 var6;
         if ((var6 = this.getCls27()) != null) {
            if (this.isCls2(var6) && var6.getOffStrictEnum2() == OffStrictEnum.CHANGE_LOOK) {
               if (this.yawPitchRecord4 != null) {
                  this.yawPitchRecord4 = Util.getYawPitchRecordForYawPitchRecord(this.yawPitchRecord4, var1, var3);
               }

               if (this.yawPitchRecord3 != null) {
                  this.handleYawPitchRecord(Util.getYawPitchRecordForYawPitchRecord(this.yawPitchRecord3, var1, var3));
               }
            }
         }
      }
   }

   public void run78() {
      YawPitchRecord var1 = Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer);
      this.yawPitchRecord4 = var1;
      Cls2 var5;
      if ((var5 = this.getCls27()) != null) {
         Cls var10000;
         label57: {
            Cls2 var3 = this.getCls26();
            if (this.isCls2(var5)) {
               YawPitchRecord var4 = this.yawPitchRecord3 != null ? this.yawPitchRecord3 : var1;
               var4 = var5.getYawPitchRecord8(var4, var3 == null).getYawPitchRecord();
               float var6 = var4.getFloat(var1);
               if (var3 == null && (var5.getOffStrictEnum2() == OffStrictEnum.CHANGE_LOOK || var5.getList10().isEmpty() || var6 <= var5.getFloat27())) {
                  if (this.yawPitchRecord3 != null) {
                     MINECRAFT.thePlayer.rotationYaw = Util.getFloatForEntityPlayerSP(MINECRAFT.thePlayer, this.yawPitchRecord3);
                     MINECRAFT.thePlayer.renderArmYaw = MINECRAFT.thePlayer.rotationYaw;
                     MINECRAFT.thePlayer.prevRenderArmYaw = MINECRAFT.thePlayer.rotationYaw;
                  }

                  var10000 = this;
                  this.handleYawPitchRecord(null);
                  this.cls2 = null;
                  break label57;
               }

               this.handleYawPitchRecord(var4);
               this.cls2 = var5;
               if (var3 != null && var3.getCls52() != null) {
                  var3.getCls52().run();
               }
            }

            var10000 = this;
         }

         var10000.cls.run();
      }
   }

   @EventHandler(
      priority = -1000
   )
   private void handleEventSub14(EventSub14 var1) {
      Object var6 = var1.getPacket();
      Object var7 = Objects.requireNonNull(var6);
      YawPitchRecord var2;
      EventSub14 var10000;
      switch (var6) {
         case C03PacketPlayer var10:

            C03PacketPlayer var9;
            if (!(var9 = (C03PacketPlayer)var6).getRotating()) {
               return;
            }

            var2 = new YawPitchRecord(var9.getYaw(), var9.getPitch(), true);
            var10000 = var1;
            break;
         case S08PacketPlayerPosLook var5:
            var2 = new YawPitchRecord(var5.getYaw(), var5.getPitch(), true);
            var10000 = var1;
            break;
         default:
            return;
      }

      if (!var10000.isEnabled()) {
         Util6.handleFloat76((this.yawPitchRecord = var2).yaw2(), var2.pitch2());
      }

      this.yawPitchRecord5 = var2;
   }

   private Cls() {
      this.yawPitchRecord = YawPitchRecord.YAW_PITCH_RECORD;
      this.yawPitchRecord5 = YawPitchRecord.YAW_PITCH_RECORD;
   }

   public void handleYawPitchRecord2(YawPitchRecord var1, boolean var2, RotationsBooleanSetting var3, NotImportantNormalEnum var4, Iface var5, Cls5 var6) {
      this.handleCls24(var3.getCls29(var1, null, var2, var6), var4, var5);
   }

   private boolean isEnabled52() {
      return true;
   }

   public YawPitchRecord getYawPitchRecord4() {
      return this.yawPitchRecord4;
   }

   public YawPitchRecord getYawPitchRecord3() {
      return this.yawPitchRecord2;
   }

   public boolean isEnabled51() {
      if (MINECRAFT.thePlayer == null) {
         return false;
      } else {
         return this.yawPitchRecord3 != null
            ? this.yawPitchRecord3.equals(this.yawPitchRecord2)
            : Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer).equals(Util2.getYawPitchRecordForEntity2(MINECRAFT.thePlayer));
      }
   }

   @EventHandler(
      priority = 1000
   )
   private void handleEventSub22(EventSub2 var1) {
      if (this.isEnabled50()) {
         OnyxClient.I_EVENT_BUS.post(new EventSub7());
         this.run78();
      }
   }

   public void handleCls24(Cls2 var1, NotImportantNormalEnum var2, Iface var3) {
      if (this.isEnabled52()) {
         client.onyx.util.Cls var10000 = this.cls;
         int var10003;
         NotImportantNormalEnum var10004;
         if (var1.getOffStrictEnum2() == OffStrictEnum.CHANGE_LOOK) {
            var10003 = 1;
            var10004 = var2;
         } else {
            var10003 = var1.getInt21();
            var10004 = var2;
         }

         client.onyx.util.Cls.Cls8 var10001 = new client.onyx.util.Cls.Cls8(var10003, var10004.getInt(), var3, var1);
         var10000.handleCls8(var10001);
      }
   }
}
