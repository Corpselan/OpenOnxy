package client.onyx.module.combat;

import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub10;
import client.onyx.event.impl.EventSub14;
import client.onyx.event.impl.EventSub17;
import client.onyx.event.impl.EventSub6;
import client.onyx.event.impl.IncomingOutgoingEnum;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.player.DelayModule;
import client.onyx.setting.impl.NoneValueSetting;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.RotationsBooleanSetting;
import client.onyx.system.Util4;
import client.onyx.system.Util6;
import client.onyx.system.Util7;
import client.onyx.system.YawPitchRecord;
import client.onyx.util.Cls7;
import java.util.Iterator;
import java.util.Random;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S19PacketEntityStatus;

public class KillAuraModule extends Module {
   private static final long LONG = 25L;
   private EntityLivingBase entityLivingBase;
   public ValueSettingSub9 valueSettingSub9;
   private final Random random;
   public ValueSettingSub10 valueSettingSub10;
   private EntityLivingBase entityLivingBase2;
   public RotationsBooleanSetting rotationsBooleanSetting;
   private long long_;
   private final Cls2 cls2;
   private final client.onyx.system.Cls cls;
   public ValueSettingSub11<KillAuraModule.OffWatchdogEnum> valueSettingSub112;
   public ValueSettingSub10 valueSettingSub102;
   public ValueSettingSub11<KillAuraModule.OffAngleEnum> valueSettingSub113;
   private final Cls7 cls7;
   private boolean bool2;
   private int int_;
   public ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Distance", 3.0, 3.0, 6.0, 0.05);
   private boolean bool3;
   public NoneValueSetting noneValueSetting2;
   public ValueSettingSub11<KillAuraModule.AlwaysHoldEnum> valueSettingSub114;
   public ValueSettingSub10 valueSettingSub104;
   public ValueSettingSub10 valueSettingSub105;
   public ValueSettingSub9 valueSettingSub92;
   public ValueSettingSub<KillAuraModule.PlayersTeammatesEnum2> valueSettingSub;

   private double getDouble29(Entity var1) {
      return Util4.getDoubleForEntity5(var1);
   }

   @EventHandler
   public void handleEventSub147(EventSub14 var1) {
      if (var1.getIncomingOutgoingEnum() == IncomingOutgoingEnum.OUTGOING) {
         this.cls2.handleEventSub145(var1);
      } else if (this.isEnabled114()) {
         Packet var3 = var1.getPacket();
         if (var3 instanceof S19PacketEntityStatus) {
            S19PacketEntityStatus var5;
            if ((var5 = (S19PacketEntityStatus)var3).getOpCode() == 2) {
               if (MINECRAFT.thePlayer != null && var5.getEntityId() == MINECRAFT.thePlayer.getEntityId()) {
                  this.cls2.run132();
               }
            }
         }
      }
   }

   private boolean isEnabled111() {
      if (this.valueSettingSub9.isEnabled17() && !Cls2.isEnabled102()) {
         return false;
      } else {
         int var1 = this.int_;
         int var2 = this.valueSettingSub105.getInt10();
         if (var1 < var2) {
            return false;
         } else {
            EntityLivingBase var3 = this.entityLivingBase2;
            return !this.isEntity4(var3) ? false : this.isYawPitchRecord(Util6.getYawPitchRecord25());
         }
      }
   }

   public static boolean isEnabled112() {
      KillAuraModule var0 = OnyxClient.cls == null ? null : OnyxClient.cls.killAuraModule;
      return var0 == null || var0.cls2.isEnabled103();
   }

   private boolean isYawPitchRecord(YawPitchRecord var1) {
      switch ((KillAuraModule.OffAngleEnum)this.valueSettingSub113.lambda15()) {
         case RAYCAST:

            return true;
         case OFF:
            if (this.cls.getFloat97(var1) <= this.valueSettingSub104.getFloat5()) {
               return true;
            }

            return false;
         case ANGLE:
            return this.cls.isEntity6(this.entityLivingBase2, var1, this.valueSettingSub103.lambda15());
         default:
            throw new MatchException(null, null);
      }
   }

   private void lambda188() {
      MINECRAFT.thePlayer.swingItem();
      MINECRAFT.playerController.attackEntity(MINECRAFT.thePlayer, this.entityLivingBase2);
   }

   private boolean isEnabled114() {
      if (!this.valueSettingSub112.isEnum3(KillAuraModule.OffWatchdogEnum.WATCHDOG)) {
         return false;
      } else {
         switch ((KillAuraModule.AlwaysHoldEnum)this.valueSettingSub114.lambda15()) {
            case TOGGLE:

               return true;
            case ALWAYS:
               if (this.noneValueSetting2.isEnabled19() && this.bool3) {
                  return true;
               }

               return false;
            case HOLD:
               if (this.noneValueSetting2.isEnabled19() && !this.bool2) {
                  return false;
               }

               return true;
            default:
               throw new MatchException(null, null);
         }
      }
   }

   @Override
   protected void run79() {
      this.entityLivingBase2 = null;
      this.entityLivingBase = null;
      this.int_ = 0;
      this.long_ = 0L;
      this.bool2 = false;
      this.bool3 = false;
      this.cls2.handleBool21(true);
      this.cls.run178();
   }

   public static boolean isEnabled115() {
      KillAuraModule var0 = OnyxClient.cls == null ? null : OnyxClient.cls.killAuraModule;
      return var0 != null && var0.isEnabled55() && var0.cls2.isEnabled104();
   }

   private boolean isEntityLivingBase10(EntityLivingBase var1) {
      if (var1 instanceof EntityPlayer) {
         EntityPlayer var5;
         if (AntiBotModule.isEntityPlayer3(var5 = (EntityPlayer)var1)) {
            return false;
         } else {
            boolean var3 = var1.getTotalArmorValue() == 0;
            boolean var4 = var1.isInvisible();
            boolean var2 = this.valueSettingSub.isEnum(KillAuraModule.PlayersTeammatesEnum2.PLAYERS);
            if (var3 && this.valueSettingSub.isEnum(KillAuraModule.PlayersTeammatesEnum2.NAKED)) {
               var2 = true;
            }

            if (var4 && this.valueSettingSub.isEnum(KillAuraModule.PlayersTeammatesEnum2.INVISIBLE)) {
               var2 = true;
            }

            if (var3 && var4 && this.valueSettingSub.isEnum(KillAuraModule.PlayersTeammatesEnum2.NAKED_INVISIBLE)) {
               var2 = true;
            }

            return isBool12(Util7.isEntityPlayer3(MINECRAFT.thePlayer, var5), this.valueSettingSub.isEnum(KillAuraModule.PlayersTeammatesEnum2.TEAMMATES), var2);
         }
      } else if (var1 instanceof EntityAnimal) {
         return this.valueSettingSub.isEnum(KillAuraModule.PlayersTeammatesEnum2.ANIMALS);
      } else {
         return var1 instanceof EntityLiving ? this.valueSettingSub.isEnum(KillAuraModule.PlayersTeammatesEnum2.MOBS) : false;
      }
   }

   private void run149() {
      if (this.long_ == 0L || this.cls7.isLong2(this.long_ - 25L)) {
         if (this.isEnabled111()) {
            this.lambda188();
            this.long_ = this.getLong2();
            this.cls7.run();
         }
      }
   }

   private void run151() {
      this.entityLivingBase = this.entityLivingBase2 = null;
      this.int_ = 0;
      this.bool2 = false;
      this.bool3 = false;
      this.cls2.handleBool21(true);
      this.cls.run178();
   }

   public EntityLivingBase getEntityLivingBase3() {
      return this.entityLivingBase2;
   }

   private boolean isEntity4(Entity var1) {
      return this.valueSettingSub92.isEnabled17() || MINECRAFT.thePlayer.canEntityBeSeen(var1);
   }

   @EventHandler
   public void handleEventSub176(EventSub17 var1) {
      this.cls2.run136();
   }

   private EntityLivingBase getEntityLivingBase5() {
      EntityLivingBase var5 = null;
      double var2 = this.valueSettingSub103.lambda15() * this.valueSettingSub103.lambda15();
      Iterator var8 = MINECRAFT.theWorld.loadedEntityList.iterator();

      label45:
      while (true) {
         Iterator var10000 = var8;

         while (var10000.hasNext()) {
            Entity var1;
            if (!((var1 = (Entity)var8.next()) instanceof EntityLivingBase)) {
               continue label45;
            }

            EntityLivingBase var11;
            if ((var11 = (EntityLivingBase)var1) == MINECRAFT.thePlayer) {
               var10000 = var8;
            } else if (!var11.isEntityAlive()) {
               var10000 = var8;
            } else if (var11 instanceof EntityArmorStand) {
               var10000 = var8;
            } else if (var11 instanceof EntityPlayer var9 && var9.isSpectator()) {
               var10000 = var8;
            } else if (!this.isEntityLivingBase10(var11)) {
               var10000 = var8;
            } else if (!this.isEntity4(var11)) {
               var10000 = var8;
            } else {
               double var6;
               if ((var6 = this.getDouble29(var11)) > var2) {
                  var10000 = var8;
               } else {
                  var5 = var11;
                  var2 = var6;
                  var10000 = var8;
               }
            }
         }

         return var5;
      }
   }

   public KillAuraModule() {
      super("KillAura", "Automatically aims and kills enemies", ModuleCategory.COMBAT);
      KillAuraModule.PlayersTeammatesEnum2[] var10005 = new KillAuraModule.PlayersTeammatesEnum2[4];
      boolean var10007 = true;
      var10005[0] = KillAuraModule.PlayersTeammatesEnum2.PLAYERS;
      var10005[1] = KillAuraModule.PlayersTeammatesEnum2.NAKED;
      var10005[2] = KillAuraModule.PlayersTeammatesEnum2.NAKED_INVISIBLE;
      var10005[3] = KillAuraModule.PlayersTeammatesEnum2.INVISIBLE;
      this.valueSettingSub = new ValueSettingSub<>("Targets", KillAuraModule.PlayersTeammatesEnum2.class, var10005)
         .getBooleanSetting("Teammates are excluded unless explicitly selected");
      this.valueSettingSub92 = new ValueSettingSub9("Through walls", false).getBooleanSetting("Allows targeting and attacking entities behind blocks");
      this.valueSettingSub113 = new ValueSettingSub11<>("Hit check", KillAuraModule.OffAngleEnum.RAYCAST)
         .getBooleanSetting("Holds the attack until the sent rotation actually covers the target");
      this.valueSettingSub104 = new ValueSettingSub10("Hit angle", 8.0, 1.0, 45.0, 1.0)
         .getValueSettingSub10("°")
         .getSetting2(() -> this.valueSettingSub113.isEnum3(KillAuraModule.OffAngleEnum.ANGLE));
      this.valueSettingSub105 = new ValueSettingSub10("Switch delay", 0.0, 0.0, 20.0, 1.0)
         .getValueSettingSub10("t")
         .getBooleanSetting("Extra ticks to hold the attack after the target changes");
      this.valueSettingSub10 = new ValueSettingSub10("CPS min", 7.0, 1.0, 20.0, 1.0);
      this.valueSettingSub102 = new ValueSettingSub10("CPS max", 10.0, 1.0, 20.0, 1.0);
      this.valueSettingSub9 = new ValueSettingSub9("Only sword", false).getBooleanSetting("Only attacks while a sword is held in hand");
      this.valueSettingSub112 = new ValueSettingSub11<>("Autoblock", KillAuraModule.OffWatchdogEnum.OFF).getBooleanSetting("Automatically blocks sword");
      this.valueSettingSub114 = new ValueSettingSub11<>("Autoblock trigger", KillAuraModule.AlwaysHoldEnum.ALWAYS)
         .getBooleanSetting("Whether the autoblock runs on its own, only while a key is held, or on a key that toggles it")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 != KillAuraModule.OffWatchdogEnum.OFF);
      this.noneValueSetting2 = new NoneValueSetting("Autoblock key")
         .getBooleanSetting("The key the hold and toggle triggers watch")
         .getSetting2(
            () -> !this.valueSettingSub112.isEnum3(KillAuraModule.OffWatchdogEnum.OFF)
               && !this.valueSettingSub114.isEnum3(KillAuraModule.AlwaysHoldEnum.ALWAYS)
         );
      this.rotationsBooleanSetting = new RotationsBooleanSetting();
      this.cls = new client.onyx.system.Cls(this.rotationsBooleanSetting);
      this.random = new Random();
      this.cls2 = new Cls2();
      this.cls7 = new Cls7();
   }

   private long getLong2() {
      float var1 = Math.min(this.valueSettingSub10.getFloat5(), this.valueSettingSub102.getFloat5());
      float var3 = Math.max(this.valueSettingSub10.getFloat5(), this.valueSettingSub102.getFloat5());
      return (long)(1000.0 / (var1 + this.random.nextFloat() * (var3 - var1)));
   }

   private void run150() {
      boolean var2 = MINECRAFT.currentScreen == null && this.noneValueSetting2.isEnabled19() && this.noneValueSetting2.isEnabled22();
      if (var2 && !this.bool3 && this.valueSettingSub114.isEnum3(KillAuraModule.AlwaysHoldEnum.TOGGLE)) {
         this.bool2 = !this.bool2;
      }

      this.bool3 = var2;
   }

   @EventHandler
   public void handleEventSub105(EventSub10 var1) {
      if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
         this.run150();
         this.cls2.run138();
         if (!MINECRAFT.thePlayer.isEntityAlive()) {
            this.run151();
         } else if (DelayModule.DELAY_MODULE.isEnabled55()) {
            this.run151();
         } else {
            BedBreakerModule var2 = OnyxClient.cls.bedBreakerModule;
            if (OnyxClient.cls.bedBreakerModule.isEnabled55() && !var2.valueSettingSub9.isEnabled17() && var2.getBlockPos3() != null) {
               this.run151();
            } else {
               EntityLivingBase var3 = this.entityLivingBase2;
               this.entityLivingBase = this.getEntityLivingBase5();
               this.entityLivingBase2 = this.entityLivingBase;
               if (this.entityLivingBase2 != null && (!this.valueSettingSub9.isEnabled17() || Cls2.isEnabled102())) {
                  this.int_ = this.entityLivingBase2 == var3 ? this.int_ + 1 : 0;
                  boolean var4 = false;
                  boolean var10000;
                  if (this.isEnabled114() && Cls2.isEnabled102()) {
                     var10000 = this.cls2.isEntityLivingBase8(this.entityLivingBase2, this::lambda188);
                  } else {
                     this.cls2.handleBool21(true);
                     var10000 = var4;
                  }

                  if (!var10000) {
                     this.run149();
                  }

                  this.cls.handleEntity4(this.entityLivingBase2, this.valueSettingSub103.lambda15());
               } else {
                  this.entityLivingBase2 = null;
                  this.int_ = 0;
                  this.cls2.handleBool21(true);
                  this.cls.run178();
               }
            }
         }
      }
   }

   static boolean isBool12(boolean var0, boolean var1, boolean var2) {
      return var0 ? var1 : var2;
   }

   @EventHandler
   public void handleEventSub614(EventSub6 var1) {
      this.cls2.run140();
      this.run151();
   }

   public static boolean isEnabled113() {
      KillAuraModule var0 = OnyxClient.cls == null ? null : OnyxClient.cls.killAuraModule;
      return var0 != null && var0.isEnabled55() && var0.cls2.isEnabled106();
   }

   public EntityLivingBase getEntityLivingBase4() {
      return this.entityLivingBase;
   }

   public static enum AlwaysHoldEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      ALWAYS,
      HOLD,
      TOGGLE;

   }

   public static enum OffAngleEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      OFF,
      ANGLE,
      RAYCAST;

   }

   public static enum OffWatchdogEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      OFF,
      WATCHDOG;

   }

   public static enum PlayersTeammatesEnum2 {
      // 顺序按原 $VALUES 数组（即 ordinal）
      PLAYERS,
      TEAMMATES,
      NAKED,
      NAKED_INVISIBLE,
      INVISIBLE,
      MOBS,
      ANIMALS;

      static {
         KillAuraModule.PlayersTeammatesEnum2[] var0 = new KillAuraModule.PlayersTeammatesEnum2[]{
            PLAYERS, TEAMMATES, NAKED, NAKED_INVISIBLE, INVISIBLE, MOBS, ANIMALS
         };
      }
   }
}
