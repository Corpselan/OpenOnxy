package client.onyx.interact;

import client.onyx.MinecraftAccess;
import client.onyx.setting.DisplayNamed;
import net.minecraft.network.play.client.C0APacketAnimation;

public enum DoNotHideHideBothEnum implements DisplayNamed, Runnable, MinecraftAccess {
   // 顺序按原 $VALUES 数组（即 ordinal）
   DO_NOT_HIDE("Do not hide", true),
   HIDE_BOTH("Hide for both", false),
   HIDE_CLIENT("Hide for client", true),
   HIDE_SERVER("Hide for server", false);

   private final boolean bool;
   private final String string;

   public boolean isEnabled() {
      return this.bool;
   }

   private DoNotHideHideBothEnum(String var3, boolean var4) {
      this.string = var3;
      this.bool = var4;
   }

   @Override
   public void run() {
      switch (this) {
         case DO_NOT_HIDE:

            MINECRAFT.thePlayer.swingItem();
            return;
         case HIDE_BOTH:
            return;
         case HIDE_CLIENT:
            MINECRAFT.getNetHandler().addToSendQueue(new C0APacketAnimation());
            return;
         case HIDE_SERVER:
            MINECRAFT.thePlayer.swingItemClientOnly();
      }
   }

   @Override
   public String getString5() {
      return this.string;
   }

   public void run2() {
      this.run();
   }

   public String getString() {
      return this.string;
   }

}
