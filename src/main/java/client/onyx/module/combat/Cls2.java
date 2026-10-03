package client.onyx.module.combat;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub14;
import client.onyx.util.Cls7;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class Cls2 implements MinecraftAccess {
   private volatile boolean bool = true;
   private final Cls7 cls7;
   private boolean bool2;
   private boolean bool3;
   private boolean bool4;
   private EntityLivingBase entityLivingBase;
   private boolean bool5;
   private boolean bool6;
   private boolean bool7;
   private boolean bool8;
   private boolean bool9;
   private boolean bool10;
   private static final long LONG = 329L;
   private volatile int int_;
   private boolean bool11;
   private int int_2;
   private static final int INT = 2;
   private boolean bool12;
   private final List<Packet> list = new CopyOnWriteArrayList<>();

   public void run136() {
      if (this.bool10) {
         switch (this.int_2) {
            case 7:

               this.run134();
               this.int_2 = 10;
               return;
            case 8:
               this.run134();
               this.run135();
               this.run133();
               this.int_2 = 9;
               return;
            case 11:
               this.run135();
               this.run133();
               this.int_2 = 0;
            case 9:
            case 10:
         }
      }
   }

   public void handleEventSub145(EventSub14 var1) {
      if (!this.bool2) {
         if (!var1.isEnabled()) {
            Packet var3 = var1.getPacket();
            if (MINECRAFT.isCallingFromMinecraftThread()) {
               this.handlePacket3(var3);
               if (this.bool3) {
                  this.list.add(var3);
                  var1.run();
               }
            }
         }
      }
   }

   public void handleBool21(boolean var1) {
      if (var1) {
         this.int_ = 0;
      }

      if (this.bool4) {
         this.run135();
         this.bool3 = false;
         this.bool4 = false;
      }

      if (MINECRAFT.thePlayer == null) {
         this.run140();
      } else if (!isEnabled102()) {
         this.run139();
         this.bool10 = false;
         this.bool7 = false;
         this.entityLivingBase = null;
      } else {
         if (this.bool9) {
            this.run131();
         }

         if (!this.bool10 || !this.isEnabled101() || this.isEnabled105()) {
            if (this.int_ <= 0) {
               this.run139();
            }

            this.bool10 = false;
            this.bool7 = false;
            this.entityLivingBase = null;
         }
      }
   }

   private boolean isEnabled105() {
      if (!this.isEnabled101()) {
         return true;
      } else if (isEnabled102() && !this.bool11 && !this.bool12 && !this.bool8) {
         this.handlePacket2(new C07PacketPlayerDigging(Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
         this.bool7 = false;
         return true;
      } else {
         return false;
      }
   }

   private void run139() {
      if (this.bool5) {
         this.bool5 = false;
         if (MINECRAFT.thePlayer != null) {
            MINECRAFT.thePlayer.stopUsingItem();
         }
      }
   }

   public Cls2() {
      this.cls7 = new Cls7(System.currentTimeMillis());
   }

   public void run132() {
      this.int_ = 2;
   }

   public boolean isEntityLivingBase8(EntityLivingBase var1, Runnable var2) {
      if (this.bool9) {
         this.run131();
         this.handleBool21(true);
         return true;
      } else {
         if (this.bool5 && !MINECRAFT.thePlayer.isUsingItem()) {
            this.bool5 = false;
         }

         if (this.int_ > 0) {
            this.int_--;
            if (this.int_ > 0) {
               this.handleBool21(false);
               return false;
            }
         }

         this.entityLivingBase = var1;
         if (!this.bool10) {
            this.bool7 = !this.bool5 && MINECRAFT.thePlayer.isUsingItem();
            this.int_2 = this.bool7 ? 0 : 1;
            this.bool10 = true;
            this.run137();
         }

         Cls2 var10000;
         label111: {
            if (this.int_2 == 0 || this.int_2 == 3 || this.int_2 == 5) {
               this.run133();
               if (this.int_2 != 0) {
                  if (this.int_2 == 3) {
                     var10000 = this;
                     this.int_2 = 6;
                  } else {
                     var10000 = this;
                     this.int_2 = 1;
                  }
                  break label111;
               }

               if (this.isEnabled105()) {
                  var10000 = this;
                  this.int_2 = 3;
                  break label111;
               }
            } else if (this.int_2 == 1 || this.int_2 == 6) {
               this.int_2 = 2;
            }

            var10000 = this;
         }

         if (var10000.int_2 == 10) {
            this.int_2 = 11;
         } else if (this.int_2 == 9) {
            this.int_2 = 0;
         } else {
            boolean var3 = this.cls7.getLong() >= 329L;
            if (this.int_2 == 2 || this.int_2 == 5 || this.int_2 == 6 || var3) {
               boolean var4 = this.isRunnable(var2);
               if (this.int_2 != 5 && this.int_2 != 6 && (var4 || var3)) {
                  this.int_2 = 7;
               }
            }
         }

         return true;
      }
   }

   public void run140() {
      this.list.clear();
      this.bool3 = false;
      this.bool4 = false;
      this.bool2 = false;
      this.bool10 = false;
      this.bool7 = false;
      this.int_2 = 0;
      this.int_ = 0;
      this.entityLivingBase = null;
      this.bool5 = false;
      this.bool = true;
      this.bool9 = false;
      this.run131();
      this.cls7.run();
   }

   private void handlePacket3(Packet<?> var1) {
      if (var1 instanceof C02PacketUseEntity) {
         C02PacketUseEntity var2;
         C02PacketUseEntity var10000 = var2 = (C02PacketUseEntity)var1;
         this.bool8 = true;
         if (var10000.getAction() != net.minecraft.network.play.client.C02PacketUseEntity.Action.ATTACK || var2.getHitVec() != null) {
            this.bool11 = true;
         }
      }

      if (var1 instanceof C07PacketPlayerDigging) {
         this.bool12 = true;
      }

      if (var1 instanceof C08PacketPlayerBlockPlacement) {
         this.bool11 = true;
      }

      if (var1 instanceof C09PacketHeldItemChange var3 && MINECRAFT.thePlayer != null && var3.getSlotId() != MINECRAFT.thePlayer.inventory.currentItem) {
         this.bool12 = true;
      }

      if (var1 instanceof C0APacketAnimation) {
         this.bool6 = true;
      }

      if (var1 instanceof C03PacketPlayer) {
         this.bool = true;
         this.bool8 = false;
         this.bool11 = false;
         this.bool12 = false;
         this.bool6 = false;
      }
   }

   private boolean isRunnable(Runnable var1) {
      if (!this.isEnabled101() && !this.bool6 && !this.bool12 && !this.bool11) {
         var1.run();
         return true;
      } else {
         return false;
      }
   }

   private void run137() {
      ItemStack var2;
      if ((var2 = MINECRAFT.thePlayer.getHeldItem()) != null) {
         EntityPlayerSP var3 = MINECRAFT.thePlayer;
         int var4 = var2.getMaxItemUseDuration();
         var3.setItemInUse(var2, var4);
         this.bool5 = true;
      }
   }

   private void run133() {
      this.bool3 = true;
      this.bool4 = true;
   }

   public static boolean isEnabled102() {
      ItemStack var0;
      return MINECRAFT.thePlayer == null ? false : (var0 = MINECRAFT.thePlayer.getHeldItem()) != null && var0.getItem() instanceof ItemSword;
   }

   public void run138() {
      this.bool9 = !this.bool;
      this.bool = false;
   }

   public boolean isEnabled106() {
      return this.bool10 || this.bool5;
   }

   private void handlePacket2(Packet<?> var1) {
      if (MINECRAFT.getNetHandler() != null) {
         MINECRAFT.getNetHandler().addToSendQueue(var1);
      }
   }

   private boolean isEnabled101() {
      return this.bool10 ? this.bool7 : MINECRAFT.thePlayer.isUsingItem();
   }

   private void run131() {
      this.bool8 = false;
      this.bool11 = false;
      this.bool12 = false;
      this.bool6 = false;
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void run135() {
      this.cls7.run();
      this.run131();
      if (!this.list.isEmpty()) {
         ArrayList var2 = new ArrayList<>(this.list);
         this.list.clear();
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

   public boolean isEnabled104() {
      return (this.bool10 || this.bool5) && !this.bool7;
   }

   public boolean isEnabled103() {
      return MINECRAFT.thePlayer == null ? false : !this.isEnabled101() && !this.bool6 && !this.bool12 && !this.bool11;
   }

   private void run134() {
      if (!this.isEnabled101()) {
         if (isEnabled102()) {
            ItemStack var2 = MINECRAFT.thePlayer.getHeldItem();
            this.handlePacket2(new C08PacketPlayerBlockPlacement(var2));
            this.run137();
            this.bool7 = true;
         }
      }
   }
}
