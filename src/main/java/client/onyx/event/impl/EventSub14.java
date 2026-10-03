package client.onyx.event.impl;

import client.onyx.event.Event;
import net.minecraft.network.Packet;

public class EventSub14 extends Event {
   private final Packet<?> packet;
   private final boolean bool2;
   private final IncomingOutgoingEnum incomingOutgoingEnum;

   public Packet<?> getPacket() {
      return this.packet;
   }

   public EventSub14(IncomingOutgoingEnum var1, Packet<?> var2, boolean var3) {
      this.incomingOutgoingEnum = var1;
      this.packet = var2;
      this.bool2 = var3;
   }

   public boolean isEnabled4() {
      return this.bool2;
   }

   public IncomingOutgoingEnum getIncomingOutgoingEnum() {
      return this.incomingOutgoingEnum;
   }

   public EventSub14(IncomingOutgoingEnum var1, Packet<?> var2) {
      this(var1, var2, true);
   }
}
