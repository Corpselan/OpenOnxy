package client.onyx;

import client.onyx.account.AccountManager;
import client.onyx.config.ConfigManager;
import client.onyx.module.Cls;
import client.onyx.simulation.Cls5;
import client.onyx.system.FreezeWatchdog;
import client.onyx.util.Cls2;
import client.onyx.util.Cls3;
import client.onyx.util.Util2;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.IEventBus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OnyxClient {
   public static Cls cls;
   public static client.onyx.command.Cls cls2;
   private static final OnyxClient ONYX_CLIENT = new OnyxClient();
   public static final Logger LOGGER = LogManager.getLogger("onyx");
   public static AccountManager accountManager;
   public static final IEventBus I_EVENT_BUS = new EventBus();
   public static ConfigManager configManager;

   public static String getString() {
      String var0;
      return (var0 = System.getProperty("onyx.user")) != null && !var0.isEmpty() ? var0 : "dev";
   }

   public void run2() {
      I_EVENT_BUS.registerLambdaFactory("client.onyx", (var0, var1) -> {
         Object[] var2 = new Object[]{var1, null};
         Lookup var3 = MethodHandles.lookup();
         var2[1] = var3;
         return (Lookup)var0.invoke(null, var2);
      });
      cls = new Cls();
      I_EVENT_BUS.subscribe(cls);
      I_EVENT_BUS.subscribe(Util2.UTIL2);
      I_EVENT_BUS.subscribe(Cls3.CLS3);
      I_EVENT_BUS.subscribe(client.onyx.module.combat.Cls.CLS);
      I_EVENT_BUS.subscribe(Cls2.CLS2);
      I_EVENT_BUS.subscribe(client.onyx.rotation.Cls.CLS);
      I_EVENT_BUS.subscribe(Cls5.CLS5);
      accountManager = new AccountManager();
      accountManager.run170();
      cls2 = new client.onyx.command.Cls();
      configManager = new ConfigManager();
      configManager.run208();
      FreezeWatchdog.run2();
      LOGGER.info("onyx client initialised");
   }

   public static OnyxClient getOnyxClient() {
      return ONYX_CLIENT;
   }

   public void run() {
      if (accountManager != null) {
         accountManager.isEnabled135();
      }

      if (configManager != null) {
         configManager.isEnabled166();
      }
   }
}
