package client.onyx.module.hud;

import client.onyx.OnyxClient;
import client.onyx.discord.DiscordIpc;
import client.onyx.event.impl.EventSub11;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub9;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.multiplayer.ServerData;
import org.apache.logging.log4j.Logger;

public class DiscordRPCModule extends Module {
   private volatile String string3;
   private long long_;
   private ScheduledExecutorService scheduledExecutorService;
   private static final String STRING = "https://discord.gg/onyxmcclient";
   private static final String STRING2 = "1543222663961382952";
   public ValueSettingSub9 valueSettingSub9;
   private static final int INT = 5;
   private DiscordIpc discordIpc;
   private static final String STRING3 = "onyx";
   private String string4;
   public ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Show Server", true)
      .getBooleanSetting("Reveal the current server IP in the status; off keeps it private");

   @Override
   protected void run79() {
      ScheduledExecutorService var3 = this.scheduledExecutorService;
      DiscordIpc var2 = this.discordIpc;
      this.scheduledExecutorService = null;
      this.discordIpc = null;
      if (var3 != null) {
         var3.execute(() -> {
            if (var2 != null) {
               var2.run();
            }
         });
         var3.shutdown();
      }
   }

   @Override
   protected void run80() {
      this.long_ = System.currentTimeMillis() / 1000L;
      this.string4 = null;
      this.discordIpc = new DiscordIpc();
      this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(var0 -> {
         Thread var10000 = new Thread(var0, "Onyx-DiscordRPC");
         var10000.setDaemon(true);
         return var10000;
      });
      this.scheduledExecutorService.scheduleWithFixedDelay(() -> {
         DiscordIpc var1 = this.discordIpc;
         if (this.discordIpc != null) {
            try {
               if (!var1.isEnabled()) {
                  if (!var1.isString("1543222663961382952")) {
                     return;
                  }

                  this.string4 = null;
                  OnyxClient.LOGGER.info("Discord RPC: connected to Discord");
               }

               String var3;
               if (!(var3 = this.getString25()).equals(this.string4)) {
                  var1.handleInt(1, getStringForString5(var3));
                  this.string4 = var3;
                  Logger var4 = OnyxClient.LOGGER;
                  Object[] var5 = new Object[]{var3};
                  var4.info("Discord RPC: pushed activity {}", var5);
               }
            } catch (IOException var6) {
               var1.run();
               this.string4 = null;
               OnyxClient.LOGGER.warn("Discord RPC update failed; will reconnect", var6);
            } catch (Throwable var7) {
               OnyxClient.LOGGER.warn("Discord RPC tick failed", var7);
            }
         }
      }, 0L, 5L, TimeUnit.SECONDS);
   }

   private String getString24() {
      if (MINECRAFT.theWorld == null) {
         return "In the Main Menu";
      } else if (MINECRAFT.isSingleplayer()) {
         return "Playing Singleplayer";
      } else {
         ServerData var2;
         return (var2 = MINECRAFT.getCurrentServerData()) != null && this.valueSettingSub92.isEnabled17()
            ? new StringBuilder().insert(0, "Playing on ").append(var2.serverIP).toString()
            : "Playing Multiplayer";
      }
   }

   private String getString25() {
      StringBuilder var2;
      (var2 = new StringBuilder("{")).append("\"details\":\"").append(getStringForString4(this.string3)).append("\",");
      var2.append("\"state\":\"")
         .append(getStringForString4(new StringBuilder().insert(0, "Username: ").append(OnyxClient.getString()).toString()))
         .append("\",");
      if (this.valueSettingSub9.isEnabled17()) {
         var2.append("\"timestamps\":{\"start\":").append(this.long_).append("},");
      }

      var2.append("\"assets\":{").append("\"large_image\":\"").append(getStringForString4("onyx")).append("\",").append("\"large_text\":\"Onyx Client\"},");
      var2.append("\"buttons\":[{\"label\":\"Join our Discord\",\"url\":\"").append(getStringForString4("https://discord.gg/onyxmcclient")).append("\"}]");
      var2.append("}");
      return var2.toString();
   }

   public DiscordRPCModule() {
      super("DiscordRPC", "Shows Onyx as your Discord status", ModuleCategory.HUD);
      this.valueSettingSub9 = new ValueSettingSub9("Elapsed Time", true).getBooleanSetting("Show how long the client has been running");
      this.string3 = "In the Main Menu";
      this.handleBool16(true);
   }

   @EventHandler
   private void handleEventSub115(EventSub11 var1) {
      String var2 = this.getString24();
      this.string3 = var2;
   }

   private static String getStringForString5(String var0) {
      return new StringBuilder()
         .insert(0, "{\"cmd\":\"SET_ACTIVITY\",\"nonce\":\"")
         .append(UUID.randomUUID())
         .append("\",\"args\":{\"pid\":")
         .append(ProcessHandle.current().pid())
         .append(",\"activity\":")
         .append(var0)
         .append("}}")
         .toString();
   }

   private static String getStringForString4(String var0) {
      StringBuilder var4 = new StringBuilder(var0.length() + 8);

      int var2;
      for (int var10000 = var2 = 0; var10000 < var0.length(); var10000 = ++var2) {
         char var3;
         switch (var3 = var0.charAt(var2)) {
            case '\t':

               var4.append("\\t");
               break;
            case '\n':
               var4.append("\\n");
               break;
            case '\r':
               var4.append("\\r");
               break;
            case '"':
               var4.append("\\\"");
               break;
            case '\\':
               var4.append("\\\\");
               break;
            default:
               if (var3 < ' ') {
                  Object[] var5 = new Object[1];
                  Integer var6 = Integer.valueOf(var3);
                  var5[0] = var6;
                  String var7 = String.format("\\u%04x", var5);
                  StringBuilder var8 = var4.append(var7);
               } else {
                  var4.append(var3);
               }
         }
      }

      return var4.toString();
   }
}
