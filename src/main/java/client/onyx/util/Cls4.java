package client.onyx.util;

import client.onyx.MinecraftAccess;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.Packet;

public class Cls4 implements MinecraftAccess {
   private final List<Packet> list;

   public void run176() {
      if (!this.list.isEmpty() && MINECRAFT.getNetHandler() != null) {
         MINECRAFT.getNetHandler().getNetworkManager().sendGrouped(this.list);
         this.list.clear();
      }
   }

   public Cls4 getCls42(Packet var1) {
      if (var1 != null) {
         this.list.add(var1);
      }

      return this;
   }

   public Cls4() {
      ArrayList var1 = new ArrayList();
      this.list = var1;
   }
}
