package client.onyx.render;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public final class Util22 {
   private static float float_;
   private static float float_2;
   private static float float_3;
   private static boolean bool;
   private static float float_4;
   private static float float_5;
   private static float float_6;
   private static float float_7;
   private static float float_8;
   private static float float_9;
   private static boolean bool2;
   private static float float_10;

   private Util22() {
   }

   public static void handleFloat(float var0, float var1, float var2, float var3) {
      float_3 = var0;
      float_4 = var1;
      float_2 = var2;
      float_ = var3;
      bool2 = true;
   }

   public static void run() {
      bool2 = false;
   }

   public static void handleEntity(Entity var0) {
      if (bool && var0 != null) {
         var0.rotationYaw = float_5;
         var0.rotationPitch = float_6;
         var0.prevRotationYaw = float_9;
         var0.prevRotationPitch = float_7;
         if (var0 instanceof EntityLivingBase var10000) {
            ((EntityLivingBase)var0).rotationYawHead = float_8;
            var10000.prevRotationYawHead = float_10;
         }

         bool = false;
      }
   }

   public static boolean isEntity(Entity var0) {
      if (bool2 && var0 != null && !bool) {
         float_5 = var0.rotationYaw;
         float_6 = var0.rotationPitch;
         float_9 = var0.prevRotationYaw;
         float_7 = var0.prevRotationPitch;
         var0.rotationYaw = float_3;
         var0.rotationPitch = float_4;
         var0.prevRotationYaw = float_2;
         var0.prevRotationPitch = float_;
         if (var0 instanceof EntityLivingBase var10000) {
            EntityLivingBase var10001 = (EntityLivingBase)var0;
            float_8 = ((EntityLivingBase)var0).rotationYawHead;
            float_10 = var10000.prevRotationYawHead;
            var10001.rotationYawHead = float_3;
            var10000.prevRotationYawHead = float_2;
         }

         bool = true;
         return true;
      } else {
         return false;
      }
   }

   public static boolean isEnabled() {
      return bool2;
   }
}
