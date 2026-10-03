package client.onyx.event.impl;

import client.onyx.event.Event;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class EventSub9 extends Event {
   private final EntityPlayer entityPlayer;
   private final Entity entity;

   public Entity getEntity() {
      return this.entity;
   }

   public EntityPlayer getEntityPlayer() {
      return this.entityPlayer;
   }

   public EventSub9(EntityPlayer var1, Entity var2) {
      this.entityPlayer = var1;
      this.entity = var2;
   }
}
