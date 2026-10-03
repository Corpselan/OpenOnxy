package client.onyx.module.combat;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub14;
import client.onyx.event.impl.EventSub2;
import client.onyx.event.impl.EventSub6;
import client.onyx.event.impl.IncomingOutgoingEnum;
import client.onyx.util.Cls7;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.BlockBed;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.BlockPos;

public final class Cls implements MinecraftAccess {
   private final Set<BlockPos> set = new HashSet<>();
   private final Cls7 cls7 = new Cls7();
   public static final Cls CLS = new Cls();
   private static final long LONG = 3000L;
   private static final int INT = 15;
   private BlockPos blockPos;
   private boolean bool;
   private static final int INT2 = 35;
   private boolean bool2;

   public boolean isBlockPos6(BlockPos var1) {
      return this.set.contains(var1);
   }

   @EventHandler
   public void handleEventSub24(EventSub2 var1) {
      if (this.bool && this.cls7.isLong(3000L)) {
         this.bool = false;
         this.run130();
      }
   }

   public BlockPos getBlockPos7() {
      if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null && !this.set.isEmpty()) {
         BlockPos var1 = new BlockPos(MINECRAFT.thePlayer);
         BlockPos var6 = null;
         double var3 = Double.MAX_VALUE;
         Iterator var9 = this.set.iterator();

         label25:
         while (true) {
            for (Iterator var10000 = var9; var10000.hasNext(); var10000 = var9) {
               BlockPos var2 = (BlockPos)var9.next();
               if (MINECRAFT.theWorld.getBlockState(var2).getBlock() instanceof BlockBed) {
                  double var7;
                  if ((var7 = var2.distanceSq(var1.getX(), var1.getY(), var1.getZ())) < var3) {
                     var3 = var7;
                     var6 = var2;
                  }
                  continue label25;
               }
            }

            return var6;
         }
      } else {
         return null;
      }
   }

   private void run130() {
      if (this.blockPos != null && MINECRAFT.theWorld != null) {
         int var1;
         int var2;
         for (int var10000 = var1 = -35; var10000 <= 35; var10000 = ++var1) {
            int var3;
            for (int var6 = var2 = -15; var6 <= 15; var6 = ++var2) {
               for (int var7 = var3 = -35; var7 <= 35; var7 = ++var3) {
                  BlockPos var5 = this.blockPos.add(var1, var2, var3);
                  if (MINECRAFT.theWorld.getBlockState(var5).getBlock() instanceof BlockBed) {
                     this.set.add(var5);
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void handleEventSub144(EventSub14 var1) {
      if (var1.getIncomingOutgoingEnum() == IncomingOutgoingEnum.INCOMING) {
         Packet var3;
         if ((var3 = var1.getPacket()) instanceof S02PacketChat) {
            String var2;
            if ((var2 = ((S02PacketChat)var3).getChatComponent().getUnformattedText()).contains("Protect your bed and destroy the enemy bed")
               || var2.contains("Destroy the enemy bed and then eliminate them")) {
               this.bool2 = true;
               return;
            }
         } else if (var3 instanceof S08PacketPlayerPosLook var4 && this.bool2) {
            this.bool2 = false;
            this.blockPos = new BlockPos(var4.getX(), var4.getY(), var4.getZ());
            this.bool = true;
            this.cls7.run();
         }
      }
   }

   @EventHandler
   public void handleEventSub611(EventSub6 var1) {
      this.run129();
   }

   private void run129() {
      this.set.clear();
      this.bool2 = false;
      this.bool = false;
      this.blockPos = null;
   }

   private Cls() {
   }
}
