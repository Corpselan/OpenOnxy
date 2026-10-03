package client.onyx.system;

import client.onyx.MinecraftAccess;
import client.onyx.module.combat.AntiBotModule;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;

public enum SelfEnemyEnum {
   // 顺序按原 $VALUES 数组（即 ordinal）
   SELF,
   ENEMY,
   TEAM,
   MOBS;

   public static final String[] STRING_ARRAY;

   static {
      SelfEnemyEnum[] var0 = new SelfEnemyEnum[]{SELF, ENEMY, TEAM, MOBS};
      String[] var1 = new String[]{"Self", "Enemy", "Team", "Mobs"};
      STRING_ARRAY = var1;
   }

   public static SelfEnemyEnum getSelfEnemyEnumForEntityLivingBase(EntityLivingBase var0) {
      Minecraft var3 = MinecraftAccess.MINECRAFT;
      if (MinecraftAccess.MINECRAFT.thePlayer == null || var3.theWorld == null) {
         return null;
      } else if (!var0.isEntityAlive()) {
         return null;
      } else if (var0 instanceof EntityArmorStand) {
         return null;
      } else if (var0 instanceof EntityPlayer var4 && var4.isSpectator()) {
         return null;
      } else if (AntiBotModule.isEntity5(var0)) {
         return null;
      } else if (var0 == var3.thePlayer) {
         return var3.gameSettings.thirdPersonView == 0 ? null : SELF;
      } else if (var0 instanceof EntityPlayer var2) {
         return Util7.isEntityPlayer3(var3.thePlayer, var2) ? TEAM : ENEMY;
      } else {
         return MOBS;
      }
   }
}
