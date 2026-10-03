package client.onyx.util;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub2;
import client.onyx.event.impl.EventSub3;
import client.onyx.event.impl.EventSub6;
import meteordevelopment.orbit.EventHandler;

public class Cls3 implements MinecraftAccess {
   private int int_;
   private Cls3.EnforcedHotbarSlotRequesterRecord enforcedHotbarSlotRequesterRecord;
   public static final Cls3 CLS3 = new Cls3();

   private int getInt54() {
      return MINECRAFT.thePlayer == null ? 0 : MINECRAFT.thePlayer.inventory.currentItem;
   }

   public int getInt56() {
      return this.enforcedHotbarSlotRequesterRecord != null ? this.enforcedHotbarSlotRequesterRecord.clientsideSlot : this.getInt54();
   }

   public boolean isObject(Object var1) {
      return this.enforcedHotbarSlotRequesterRecord != null && this.enforcedHotbarSlotRequesterRecord.requester == var1;
   }

   public int getInt55() {
      return this.enforcedHotbarSlotRequesterRecord != null ? this.enforcedHotbarSlotRequesterRecord.enforcedHotbarSlot : this.getInt54();
   }

   public boolean isObject2(Object var1, int var2, int var3) {
      if (!isInt5(var2)) {
         throw new IllegalArgumentException(new StringBuilder().insert(0, "Invalid hotbar slot: ").append(var2).toString());
      } else {
         EventSub3 var4 = new EventSub3(var1, var2);
         OnyxClient.I_EVENT_BUS.post(var4);
         if (var4.isEnabled()) {
            return false;
         } else {
            this.enforcedHotbarSlotRequesterRecord = new Cls3.EnforcedHotbarSlotRequesterRecord(var2, var1, var3, this.getInt56());
            this.int_ = 0;
            return true;
         }
      }
   }

   private Cls3() {
   }

   public boolean isEnabled137() {
      return this.enforcedHotbarSlotRequesterRecord != null;
   }

   public void handleObject4(Object var1) {
      if (this.enforcedHotbarSlotRequesterRecord != null && this.enforcedHotbarSlotRequesterRecord.requester == var1) {
         this.enforcedHotbarSlotRequesterRecord = null;
      }
   }

   @EventHandler
   public void handleEventSub620(EventSub6 var1) {
      this.enforcedHotbarSlotRequesterRecord = null;
      this.int_ = 0;
   }

   @EventHandler(
      priority = 1001
   )
   public void handleEventSub212(EventSub2 var1) {
      if (this.enforcedHotbarSlotRequesterRecord != null) {
         if (this.int_ >= this.enforcedHotbarSlotRequesterRecord.ticksUntilReset) {
            this.enforcedHotbarSlotRequesterRecord = null;
         } else {
            int var4 = this.int_ + 1;
            this.int_ = var4;
         }
      }
   }

   public static boolean isInt5(int var0) {
      return var0 >= 0 && var0 < 9;
   }

   private record EnforcedHotbarSlotRequesterRecord(int enforcedHotbarSlot, Object requester, int ticksUntilReset, int clientsideSlot) {
   }
}
