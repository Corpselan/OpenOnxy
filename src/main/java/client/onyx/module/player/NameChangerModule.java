package client.onyx.module.player;

import client.onyx.OnyxClient;
import client.onyx.module.Cls;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub4;
import client.onyx.setting.impl.ValueSettingSub9;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;

public final class NameChangerModule extends Module {
   public ValueSettingSub9 valueSettingSub9;
   public ValueSettingSub4 valueSettingSub4 = new ValueSettingSub4("Display name", "").getBooleanSetting("Shown instead of your real name, locally only");
   public ValueSettingSub9 valueSettingSub92;
   public ValueSettingSub9 valueSettingSub93;
   public ValueSettingSub9 valueSettingSub94 = new ValueSettingSub9("Tab list", true);

   public static String getString32() {
      NameChangerModule var0;
      return (var0 = getNameChangerModule()) == null ? "" : var0.valueSettingSub4.lambda15();
   }

   private static NameChangerModule getNameChangerModule() {
      Cls var0 = OnyxClient.cls;
      return OnyxClient.cls == null ? null : var0.nameChangerModule;
   }

   private static boolean isGameProfile(GameProfile var0) {
      return MINECRAFT.thePlayer != null && var0 != null && var0.getId() != null && var0.getId().equals(MINECRAFT.thePlayer.getGameProfile().getId());
   }

   public static String getStringForEntityPlayer(EntityPlayer var0) {
      return isEntityLivingBase11(var0) ? getString32() : var0.getName();
   }

   private boolean isEnabled123() {
      return this.isEnabled55() && !this.valueSettingSub4.lambda15().isBlank();
   }

   public static String getStringForString8(String var0) {
      NameChangerModule var2;
      if ((var2 = getNameChangerModule()) == null || !var2.isEnabled123() || !var2.valueSettingSub92.isEnabled17()) {
         return var0;
      } else {
         return MINECRAFT.thePlayer != null && var0.equals(MINECRAFT.thePlayer.getGameProfile().getName()) ? var2.valueSettingSub4.lambda15() : var0;
      }
   }

   public NameChangerModule() {
      super("NameChanger", "Overrides your own displayed name locally", ModuleCategory.PLAYER);
      this.valueSettingSub92 = new ValueSettingSub9("Scoreboard", true);
      this.valueSettingSub9 = new ValueSettingSub9("Chat", true).getBooleanSetting("Substitute your name inside chat messages too");
      this.valueSettingSub93 = new ValueSettingSub9("Nametag", true).getBooleanSetting("Your own in-world nametag (third person)");
   }

   public static boolean isEntityLivingBase11(EntityLivingBase var0) {
      NameChangerModule var2;
      return (var2 = getNameChangerModule()) != null && var2.isEnabled123() && var2.valueSettingSub93.isEnabled17() && var0 == MINECRAFT.thePlayer;
   }

   public static String getStringForNetworkPlayerInfo(NetworkPlayerInfo var0, String var1) {
      NameChangerModule var3;
      return (var3 = getNameChangerModule()) != null && var3.isEnabled123() && var3.valueSettingSub94.isEnabled17() && isGameProfile(var0.getGameProfile())
         ? ScorePlayerTeam.formatPlayerName(var0.getPlayerTeam(), var3.valueSettingSub4.lambda15())
         : var1;
   }

   public static boolean isEnabled122() {
      NameChangerModule var0;
      return (var0 = getNameChangerModule()) != null && var0.isEnabled123() && var0.valueSettingSub9.isEnabled17() && MINECRAFT.thePlayer != null;
   }
}
