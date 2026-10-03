package client.onyx.simulation;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub16;
import client.onyx.event.impl.EventSub2;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.Util2;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.player.EntityPlayer;

public final class Cls5 implements MinecraftAccess {
   private Cls cls;
   public static final Cls5 CLS5 = new Cls5();
   private final Map<EntityPlayer, Cls> map;

   @EventHandler(
      priority = -10
   )
   private void handleEventSub16(EventSub16 var1) {
      this.handleForwardsBackwardsRecord(var1.getForwardsBackwardsRecord2(), true);
   }

   public Cls getCls() {
      Cls var2 = this.cls;
      if (this.cls != null) {
         return var2;
      } else {
         Cls3 var3 = Cls3.getCls3ForCls2(Cls2.getCls2ForForwardsBackwardsRecord(Util2.getForwardsBackwardsRecordForEntityPlayerSP(MINECRAFT.thePlayer)));
         var2 = new Cls(var3);
         return this.cls = var2;
      }
   }

   @EventHandler(
      priority = 1000
   )
   private void handleEventSub2(EventSub2 var1) {
      this.map.clear();
   }

   private void handleForwardsBackwardsRecord(ForwardsBackwardsRecord var1, boolean var2) {
      if (MINECRAFT.thePlayer != null) {
         if (!var2 || this.cls == null || !this.cls.getCls3().getCls24().getForwardsBackwardsRecord().equals(var1)) {
            Cls3 var4 = Cls3.getCls3ForCls2(Cls2.getCls2ForForwardsBackwardsRecord(var1));
            Cls var3 = new Cls(var4);
            this.cls = var3;
         }
      }
   }

   public Cls getCls4(EntityPlayer var1) {
      return this.map.computeIfAbsent(var1, var0 -> new Cls(Cls3.getCls3ForEntityPlayer(var0, Cls2.getCls2ForEntityPlayer(var0))));
   }

   @EventHandler(
      priority = 500
   )
   private void handleEventSub163(EventSub16 var1) {
      this.cls = null;
      this.handleForwardsBackwardsRecord(var1.getForwardsBackwardsRecord2(), false);
   }

   @EventHandler
   private void handleEventSub162(EventSub16 var1) {
      this.handleForwardsBackwardsRecord(var1.getForwardsBackwardsRecord2(), true);
   }

   private Cls5() {
      ConcurrentHashMap var1 = new ConcurrentHashMap();
      this.map = var1;
   }
}
