package client.onyx.module.combat;

import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub10;
import client.onyx.event.impl.EventSub6;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub9;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;

public class AntiBotModule extends Module {
   public ValueSettingSub9 valueSettingSub9;
   private volatile Set<String> set;
   public ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Tab check", false)
      .getBooleanSetting("Also flags any player whose name is absent from the tab list");

   public static boolean isEntityPlayer3(EntityPlayer var0) {
      AntiBotModule var2;
      if ((var2 = getAntiBotModule()) == null || !var2.isEnabled55()) {
         return false;
      } else if (MINECRAFT.isSingleplayer()) {
         return false;
      } else if (var2.valueSettingSub92.isEnabled17() && !var2.set.contains(var0.getName())) {
         return true;
      } else if (var0 instanceof EntityPlayerSP) {
         return false;
      } else {
         NetHandlerPlayClient var3;
         if ((var3 = MINECRAFT.getNetHandler()) == null) {
            return false;
         } else {
            NetworkPlayerInfo var4;
            if ((var4 = var3.getPlayerInfo(var0.getName())) == null) {
               return true;
            } else if (var0.getName().startsWith("§k")) {
               return var0.isInvisible();
            } else if (var4.getResponseTime() < 1) {
               return true;
            } else {
               ScorePlayerTeam var5;
               if ((var5 = var4.getPlayerTeam()) == null) {
                  return false;
               } else {
                  return !var5.getRegisteredName().isEmpty() ? false : var5.getColorPrefix().equals("§c");
               }
            }
         }
      }
   }

   public static boolean isEntity5(Entity var0) {
      AntiBotModule var2;
      return (var2 = getAntiBotModule()) == null || !var2.isEnabled55() || !var2.valueSettingSub9.isEnabled17()
         ? false
         : var0 instanceof EntityPlayer && isEntityPlayer3((EntityPlayer)var0);
   }

   public AntiBotModule() {
      super("AntiBot", "Stops the combat modules from targeting bots", ModuleCategory.COMBAT);
      this.valueSettingSub9 = new ValueSettingSub9("Hide visuals", true)
         .getBooleanSetting(
            "Also keep the render modules off flagged bots - no ESP, glow, chams, boxes, skeleton or name tag on a player the combat modules already ignore"
         );
      this.set = new HashSet<>();
   }

   private static AntiBotModule getAntiBotModule() {
      return OnyxClient.cls == null ? null : OnyxClient.cls.antiBotModule;
   }

   @EventHandler
   public void handleEventSub106(EventSub10 var1) {
      if (MINECRAFT.thePlayer != null && MINECRAFT.getNetHandler() != null) {
         HashSet var5 = new HashSet();
         Iterator var4;
         Iterator var10000 = var4 = MINECRAFT.getNetHandler().getPlayerInfoMap().iterator();

         while (var10000.hasNext()) {
            NetworkPlayerInfo var3;
            if ((var3 = (NetworkPlayerInfo)var4.next()).getGameProfile().getId().equals(MINECRAFT.thePlayer.getUniqueID())) {
               var10000 = var4;
            } else {
               var5.add(var3.getGameProfile().getName());
               var10000 = var4;
            }
         }

         this.set = var5;
      }
   }

   @EventHandler
   public void handleEventSub615(EventSub6 var1) {
      HashSet var2 = new HashSet();
      this.set = var2;
   }

   @Override
   protected void run79() {
      HashSet var1 = new HashSet();
      this.set = var1;
   }
}
