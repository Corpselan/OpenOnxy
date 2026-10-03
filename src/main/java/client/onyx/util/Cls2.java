package client.onyx.util;

import client.onyx.event.impl.EventSub14;
import client.onyx.event.impl.EventSub6;
import java.util.Objects;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import net.minecraft.network.play.server.S2EPacketCloseWindow;

public final class Cls2 {
   private boolean bool;
   public static final Cls2 CLS2 = new Cls2();

   private Cls2() {
   }

   public boolean isEnabled() {
      return Minecraft.getMinecraft().currentScreen instanceof GuiInventory || this.bool;
   }

   @EventHandler(
      priority = -1000
   )
   private void handleEventSub14(EventSub14 var1) {
      if (!var1.isEnabled()) {
         Object var3 = var1.getPacket();
         Object var4 = Objects.requireNonNull(var3);
         switch (var3) {
            case C0EPacketClickWindow var6:

               if (((C0EPacketClickWindow)var3).getWindowId() == 0) {
                  this.bool = true;
                  return;
               }
               this.bool = false;  // 原代码这里贯穿到 C0DPacketCloseWindow 分支
               return;
            case C0DPacketCloseWindow var7:
               this.bool = false;
               return;
            case S2EPacketCloseWindow var8:
               this.bool = false;
               return;
            case S2DPacketOpenWindow var9:
               this.bool = false;
               return;
            default:
         }
      }
   }

   @EventHandler
   private void handleEventSub6(EventSub6 var1) {
      this.bool = false;
   }
}
