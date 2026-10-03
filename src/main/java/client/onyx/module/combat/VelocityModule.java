package client.onyx.module.combat;

import client.onyx.event.impl.EventSub;
import client.onyx.event.impl.EventSub10;
import client.onyx.event.impl.EventSub11;
import client.onyx.event.impl.EventSub14;
import client.onyx.event.impl.EventSub6;
import client.onyx.event.impl.IncomingOutgoingEnum;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.combat.mode.LagModeOption;
import client.onyx.setting.ModeOption;
import client.onyx.setting.ModeSetting;
import client.onyx.setting.Setting;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.util.ForwardsBackwardsRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.ThreadQuickExitException;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.server.S00PacketKeepAlive;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class VelocityModule extends Module {
   public ValueSettingSub<PlayersTeammatesEnum> valueSettingSub;
   public ValueSettingSub9 valueSettingSub9;
   public ValueSettingSub9 valueSettingSub92;
   private volatile int int_;
   public ValueSettingSub9 valueSettingSub93;
   public ValueSettingSub9 valueSettingSub94;
   public ValueSettingSub10 valueSettingSub10;
   public ModeSetting<ModeOption> modeSetting = getModeSetting4();
   private boolean bool2;
   private boolean bool3;
   public ValueSettingSub9 valueSettingSub95;
   private volatile boolean bool4;
   public ValueSettingSub3 valueSettingSub3;
   public ValueSettingSub10 valueSettingSub102;
   private volatile boolean bool5;
   private final List<Packet> list2;
   private int int_2;
   private static final double DOUBLE = 10.0D;
   private boolean bool6;
   private volatile boolean bool7;
   private volatile boolean bool8;
   private int int_3;
   private static final double DOUBLE2 = 3.0D;
   public ValueSettingSub9 valueSettingSub96;
   public ValueSettingSub10 valueSettingSub103;

   protected void run80() {
      int var1 = this.getInt45();
      this.int_2 = var1;
   }

   private EntityPlayer getEntityPlayer2(double var1) {
      Vec3 var8 = MINECRAFT.thePlayer.getPositionEyes(1.0F);
      Vec3 var4 = MINECRAFT.thePlayer.getLook(1.0F);
      var4 = var8.addVector(var4.xCoord * var1, var4.yCoord * var1, var4.zCoord * var1);
      EntityPlayer var5 = null;
      var1 = Double.MAX_VALUE;
      Iterator var6 = MINECRAFT.theWorld.playerEntities.iterator();

      while(true) {
         EntityPlayer var7;
         double var9;
         double var14;
         label37:
         while(true) {
            label30:
            while(true) {
               Iterator var10000 = var6;

               while(var10000.hasNext()) {
                  if ((var7 = (EntityPlayer)var6.next()) == MINECRAFT.thePlayer) {
                     var10000 = var6;
                  } else {
                     if (!var7.isEntityAlive()) {
                        continue label30;
                     }

                     if (!var7.isSpectator()) {
                        float var11 = var7.getCollisionBorderSize();
                        AxisAlignedBB var13 = var7.getEntityBoundingBox().expand((double)var11, (double)var11, (double)var11);
                        MovingObjectPosition var12 = var13.calculateIntercept(var8, var4);
                        if (var13.isVecInside(var8)) {
                           var14 = var9 = 0.0D;
                           break label37;
                        }

                        if (var12 != null) {
                           var14 = var9 = var8.distanceTo(var12.hitVec);
                           break label37;
                        }
                        continue label30;
                     }

                     var10000 = var6;
                  }
               }

               return var5;
            }
         }

         if (var14 < var1) {
            var5 = var7;
            var1 = var9;
         }
      }
   }

   private static ModeSetting<ModeOption> getModeSetting4() {
      LagModeOption var0 = new LagModeOption();
      ModeOption[] var1 = new ModeOption[]{var0};
      return new ModeSetting("Mode", var0, var1);
   }

   private boolean isPacket(Packet<?> var1, EventSub14 var2) {
      if (var1 instanceof S00PacketKeepAlive) {
         return false;
      } else if (!(var1 instanceof S01PacketJoinGame) && !(var1 instanceof S07PacketRespawn)) {
         if (var1 instanceof S19PacketEntityStatus) {
            S19PacketEntityStatus var3 = (S19PacketEntityStatus)var1;
            boolean var4 = MINECRAFT.thePlayer != null && var3.getEntityId() == MINECRAFT.thePlayer.getEntityId() && var3.getOpCode() == 2;
            if (!var4) {
               return false;
            }
         }

         this.list2.add(var1);
         var2.run();
         return true;
      } else {
         this.run142();
         return false;
      }
   }

   private void run142() {
      this.bool8 = false;
      if (!this.list2.isEmpty()) {
         ArrayList var4 = new ArrayList(this.list2);
         this.list2.clear();
         NetHandlerPlayClient var2;
         if ((var2 = MINECRAFT.getNetHandler()) != null) {
            Iterator var7 = var4.iterator();

            while(var7.hasNext()) {
               Packet var3 = (Packet)var7.next();

               try {
                  var3.processPacket(var2);
               } catch (ThreadQuickExitException var5) {
               } catch (Throwable var6) {
               }
            }

         }
      }
   }

   @EventHandler
   private void handleEventSub146(EventSub14 var1) {
      if (var1.getIncomingOutgoingEnum() == IncomingOutgoingEnum.INCOMING) {
         if (!var1.isEnabled()) {
            Packet var2 = var1.getPacket();
            if (!this.bool8 || !this.isPacket(var2, var1)) {
               if (var2 instanceof S12PacketEntityVelocity) {
                  S12PacketEntityVelocity var3 = (S12PacketEntityVelocity)var2;
                  if (MINECRAFT.thePlayer != null && var3.getEntityID() == MINECRAFT.thePlayer.getEntityId()) {
                     if (this.valueSettingSub95.isEnabled17()) {
                        if (!JumpResetModule.isEnabled107() || !MINECRAFT.thePlayer.onGround) {
                           if (this.bool4) {
                              if (this.bool5) {
                                 this.bool5 = false;
                              } else {
                                 this.list2.add(var3);
                                 this.int_ = 0;
                                 this.bool8 = true;
                                 var1.run();
                              }
                           }
                        }
                     }
                  }
               } else {
                  if (var2 instanceof S19PacketEntityStatus) {
                     S19PacketEntityStatus var4;
                     if ((var4 = (S19PacketEntityStatus)var2).getOpCode() == 2 && MINECRAFT.thePlayer != null && var4.getEntityId() == MINECRAFT.thePlayer.getEntityId()) {
                        this.bool4 = true;
                        return;
                     }
                  } else {
                     S27PacketExplosion var5;
                     if (var2 instanceof S27PacketExplosion && ((var5 = (S27PacketExplosion)var2).func_149149_c() != 0.0F || var5.func_149144_d() != 0.0F || var5.func_149147_e() != 0.0F)) {
                        this.bool5 = true;
                     }
                  }

               }
            }
         }
      }
   }

   private boolean isEnabled109() {
      if (ThreadLocalRandom.current().nextDouble(100.0D) >= (Double)this.valueSettingSub102.lambda15()) {
         return false;
      } else if (this.valueSettingSub9.isEnabled17() && MINECRAFT.gameSettings.keyBindBack.isKeyDown()) {
         return false;
      } else if (!this.bool7) {
         return false;
      } else {
         return !this.valueSettingSub96.isEnabled17() || (new ForwardsBackwardsRecord(MINECRAFT.thePlayer.movementInput)).isEnabled();
      }
   }

   protected void run79() {
      this.run144();
      this.bool6 = false;
      this.bool3 = false;
      this.int_3 = 0;
   }

   private void run144() {
      this.int_2 = this.getInt45();
      if (this.bool8) {
         this.run142();
      }

      this.int_ = 0;
      this.bool4 = false;
      this.bool5 = false;
      this.bool2 = false;
   }

   @EventHandler
   private void handleEventSub613(EventSub6 var1) {
      this.run143();
   }

   private void run143() {
      this.list2.clear();
      this.bool8 = false;
      this.int_ = 0;
      this.bool4 = false;
      this.bool5 = false;
      this.bool6 = false;
      this.int_3 = 0;
      this.bool3 = false;
      this.bool2 = false;
      this.bool7 = false;
      this.int_2 = this.getInt45();
   }

   private int getInt45() {
      return this.valueSettingSub3.getInt4();
   }

   public VelocityModule() {
      super("Velocity", "Delays and counter-hit reduces the velocity received", ModuleCategory.COMBAT);
      this.valueSettingSub95 = (new ValueSettingSub9("Delay knockback", true)).getBooleanSetting("Holds the knockback after a melee hit so it lands a moment late").getSetting2(Setting.BOOLEAN_SUPPLIER);
      ValueSettingSub3 var10001 = ValueSettingSub3.getValueSettingSub3ForString2("Delay ticks", 3, 3, 1, 20).getValueSettingSub3("t").getBooleanSetting("How long the knockback is held before it is applied");
      ValueSettingSub9 var10002 = this.valueSettingSub95;
      Objects.requireNonNull(var10002);
      this.valueSettingSub3 = var10001.getSetting2(var10002::isEnabled17);
      this.valueSettingSub92 = (new ValueSettingSub9("Release on ground", true)).getBooleanSetting("Stops holding the moment you touch the ground").getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub94 = (new ValueSettingSub9("Release after reduce", false)).getBooleanSetting("Stops holding once a counter-hit has reduced the knockback").getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub93 = (new ValueSettingSub9("Reduce knockback", true)).getBooleanSetting("Counter-hits the attacker in your crosshair to cut the knockback you take").getSetting2(Setting.BOOLEAN_SUPPLIER);
      ValueSettingSub10 var1 = (new ValueSettingSub10("Reduce window", 5.0D, 0.0D, 20.0D, 1.0D)).getValueSettingSub10("t").getBooleanSetting("How long after knockback the counter-hit may still fire");
      var10002 = this.valueSettingSub93;
      Objects.requireNonNull(var10002);
      this.valueSettingSub10 = var1.getSetting2(var10002::isEnabled17);
      this.valueSettingSub102 = (new ValueSettingSub10("Chance", 100.0D, 0.0D, 100.0D, 1.0D)).getValueSettingSub10("%").getBooleanSetting("Chance to reduce each incoming knockback");
      this.valueSettingSub103 = (new ValueSettingSub10("FOV", 360.0D, 0.0D, 360.0D, 1.0D)).getValueSettingSub10("°").getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub9 = (new ValueSettingSub9("Pause while backpedaling", false)).getSetting2(Setting.BOOLEAN_SUPPLIER);
      this.valueSettingSub96 = (new ValueSettingSub9("Only while moving", false)).getSetting2(Setting.BOOLEAN_SUPPLIER);
      PlayersTeammatesEnum[] var10005 = new PlayersTeammatesEnum[2];
      boolean var10007 = true;
      var10005[0] = PlayersTeammatesEnum.PLAYERS;
      var10005[1] = PlayersTeammatesEnum.TEAMMATES;
      this.valueSettingSub = new ValueSettingSub("Targets", PlayersTeammatesEnum.class, var10005);
      this.list2 = new CopyOnWriteArrayList();
   }

   @EventHandler
   private void handleEventSub3(EventSub var1) {
      if (this.bool5) {
         this.bool5 = false;
      } else {
         this.bool6 = true;
         this.bool3 = this.valueSettingSub93.isEnabled17();
         this.int_3 = 0;
      }
   }

   @EventHandler
   private void handleEventSub118(EventSub11 var1) {
      if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
         this.bool7 = PlayersTeammatesEnum.isDouble11(10.0D, this.valueSettingSub103.getFloat5(), (Set)this.valueSettingSub.lambda15());
         if (this.bool6) {
            int var3 = this.int_3 + 1;
            this.int_3 = var3;
            int var4 = this.valueSettingSub10.getInt10();
            if (var3 >= var4) {
               this.bool3 = this.bool6 = false;
               this.int_3 = 0;
            }
         }

         if (this.valueSettingSub9.isEnabled17() && MINECRAFT.gameSettings.keyBindBack.isKeyDown()) {
            this.run144();
         }

         if (!this.bool7) {
            this.run144();
         }

         if (this.bool8) {
            ++this.int_;
            if (this.int_ >= this.int_2 || this.valueSettingSub92.isEnabled17() && MINECRAFT.thePlayer.onGround || this.valueSettingSub94.isEnabled17() && this.bool2 || MINECRAFT.thePlayer.isInWater() || MINECRAFT.thePlayer.isInLava()) {
               this.run144();
            }
         }

      } else {
         this.run143();
      }
   }

   @EventHandler
   private void handleEventSub103(EventSub10 var1) {
      if (this.bool3 && this.bool6) {
         if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
            EntityPlayer var2;
            if ((var2 = this.getEntityPlayer2(3.0D)) != null) {
               if (this.isEnabled109()) {
                  if (MINECRAFT.thePlayer.isSprinting()) {
                     if (!MINECRAFT.thePlayer.isInWeb) {
                        if (KillAuraModule.isEnabled112()) {
                           MINECRAFT.thePlayer.swingItem();
                           MINECRAFT.getNetHandler().addToSendQueue(new C02PacketUseEntity(var2, Action.ATTACK));
                           EntityPlayerSP var10000 = MINECRAFT.thePlayer;
                           var10000.motionX *= 0.6D;
                           var10000 = MINECRAFT.thePlayer;
                           var10000.motionZ *= 0.6D;
                           MINECRAFT.thePlayer.setSprinting(false);
                           this.bool2 = true;
                           this.bool3 = false;
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
