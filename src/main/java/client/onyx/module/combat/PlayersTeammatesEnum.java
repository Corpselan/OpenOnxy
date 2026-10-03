package client.onyx.module.combat;

import client.onyx.MinecraftAccess;
import client.onyx.system.Util4;
import client.onyx.system.Util7;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public enum PlayersTeammatesEnum implements MinecraftAccess {
   // 顺序按原 $VALUES 数组（即 ordinal）
   PLAYERS,
   TEAMMATES,
   MOBS,
   ANIMALS;

   private static boolean isEntity3(Entity var0, float var1) {
      if (var1 >= 360.0F) {
         return true;
      } else {
         double var2 = var0.posX - MINECRAFT.thePlayer.posX;
         double var4 = var0.posZ - MINECRAFT.thePlayer.posZ;
         return Math.abs(MathHelper.wrapAngleTo180_float((float)Math.toDegrees(Math.atan2(-var2, var4)) - MINECRAFT.thePlayer.rotationYaw)) <= var1 / 2.0F;
      }
   }

   public static boolean isDouble11(double var0, float var2, Set<PlayersTeammatesEnum> var3) {
      float var6 = var2;
      if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
         double var4 = var0 * var0;
         Iterator var1 = MINECRAFT.theWorld.loadedEntityList.iterator();

         label49:
         while (true) {
            Iterator var10000 = var1;

            while (var10000.hasNext()) {
               Entity var7;
               if (!((var7 = (Entity)var1.next()) instanceof EntityLivingBase)) {
                  continue label49;
               }

               EntityLivingBase var8;
               if ((var8 = (EntityLivingBase)var7) == MINECRAFT.thePlayer) {
                  var10000 = var1;
               } else if (!var8.isEntityAlive()) {
                  var10000 = var1;
               } else if (var8 instanceof EntityArmorStand) {
                  var10000 = var1;
               } else if (var8 instanceof EntityPlayer && ((EntityPlayer)var8).isSpectator()) {
                  var10000 = var1;
               } else if (!isEntityLivingBase9(var8, var3)) {
                  var10000 = var1;
               } else if (Util4.getDoubleForEntity5(var8) > var4) {
                  var10000 = var1;
               } else {
                  if (isEntity3(var8, var6)) {
                     return true;
                  }

                  var10000 = var1;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }


   private static boolean isEntityLivingBase9(EntityLivingBase var0, Set<PlayersTeammatesEnum> var1) {
      if (var0 instanceof EntityPlayer) {
         EntityPlayer var2;
         if (AntiBotModule.isEntityPlayer3(var2 = (EntityPlayer)var0)) {
            return false;
         } else {
            return Util7.isEntityPlayer3(MINECRAFT.thePlayer, var2) ? var1.contains(TEAMMATES) : var1.contains(PLAYERS);
         }
      } else if (var0 instanceof EntityAnimal) {
         return var1.contains(ANIMALS);
      } else {
         return var0 instanceof EntityLiving ? var1.contains(MOBS) : false;
      }
   }
}
