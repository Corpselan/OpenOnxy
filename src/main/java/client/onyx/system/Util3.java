package client.onyx.system;

import client.onyx.MinecraftAccess;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Util3 implements MinecraftAccess {
   private static EntityPlayerSP entityPlayerSP = null;
   private static boolean bool = false;
   private static float float_7 = 0.0F;
   private static final float FLOAT = 50.0F;
   private static float float_6 = 0.0F;
   private static float float_3 = 0.0F;
   private static float float_8 = 0.0F;
   private static float float_ = 0.0F;
   private static float float_5 = 0.0F;
   private static float float_2 = 0.0F;
   private static float float_4 = 0.0F;

   private static float getFloat99() {
      double var0 = MINECRAFT.thePlayer.posX - MINECRAFT.thePlayer.prevPosX;
      double var2 = MINECRAFT.thePlayer.posZ - MINECRAFT.thePlayer.prevPosZ;
      float var4 = float_;
      if ((float)(var0 * var0 + var2 * var2) > 0.0025000002F) {
         float var5 = (float)(MathHelper.atan2(var2, var0) * 180.0 / Math.PI) - 90.0F;
         float var6 = Math.abs(MathHelper.wrapAngleTo180_float(float_3) - var5);
         var4 = 95.0F <= var6 && var6 < 265.0F ? var5 - 180.0F : var5;
      }

      if (MINECRAFT.thePlayer.swingProgress > 0.0F) {
         var4 = float_3;
      }

      float var11 = float_ + MathHelper.wrapAngleTo180_float(var4 - float_) * 0.3F;
      float var12;
      if (Math.abs(var12 = MathHelper.wrapAngleTo180_float(float_3 - var11)) > 50.0F) {
         float var8 = Math.signum(var12) * 50.0F;
         float var9 = var12 - var8;
         var11 += var9;
      }

      return var11;
   }

   public static void run180() {
      if (MINECRAFT.thePlayer != null) {
         float_5 = float_3;
         float_2 = float_8;
         float_4 = float_;
         float_3 = float_7;
         float_8 = float_6;
         float_ = getFloat99();
      }
   }

   public static boolean isEntity7(Entity var0) {
      return bool && var0 == MINECRAFT.thePlayer;
   }

   public static float getFloatForFloat21(float var0) {
      return Util8.getFloatForFloat24(float_4, float_, var0);
   }

   public static float getFloatForFloat23(float var0) {
      return Util8.getFloatForFloat24(float_5, float_3, var0);
   }

   public static float getFloatForFloat22(float var0) {
      return float_2 + (float_8 - float_2) * var0;
   }

   public static void handleFloat75(float var0, float var1) {
      float_7 = var0;
      float_6 = var1;
      bool = Util6.isEnabled138();
      if (entityPlayerSP != MINECRAFT.thePlayer) {
         entityPlayerSP = MINECRAFT.thePlayer;
         float_5 = var0;
         float_3 = var0;
         float_2 = var1;
         float_8 = var1;
         float_4 = var0;
         float_ = var0;
      }
   }
}
