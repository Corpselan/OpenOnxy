package client.onyx.system;

import client.onyx.MinecraftAccess;
import client.onyx.command.Abstract_;
import client.onyx.module.hud.NotificationsModule;
import client.onyx.module.hud.notification.InfoSuccessEnum;

public final class Util2 implements MinecraftAccess {
   public static void handleString17(String var0, String var1, InfoSuccessEnum var2) {
      MINECRAFT.addScheduledTask(() -> {
         NotificationsModule.handleString14(var0, var1, var2);
         if (var2 != InfoSuccessEnum.ERROR && var2 != InfoSuccessEnum.WARNING) {
            Abstract_.handleString2(new StringBuilder().insert(0, var0).append(": ").append(var1).toString());
         } else {
            Abstract_.handleString3(new StringBuilder().insert(0, var0).append(": ").append(var1).toString());
         }
      });
   }

   private Util2() {
   }
}
