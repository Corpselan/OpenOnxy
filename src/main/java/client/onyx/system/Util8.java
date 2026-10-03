package client.onyx.system;

import client.onyx.MinecraftAccess;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Util8 implements MinecraftAccess {
   public static float getFloatForFloat25(float var0, float var1, float var2, float var3, float var4) {
      if ((var1 = getFloatForFloat26(var0, var1, var2)) >= var3 && var1 <= var4) {
         return var1;
      } else if (var2 <= 0.0F) {
         return MathHelper.clamp_float(var1, var3, var4);
      } else {
         var1 = var1 > var4 ? var4 : var3;
         double var5 = (var1 - var0) / var2;
         return (float)(var0 + (double)((long)var5) * var2);
      }
   }

   public static float getFloatForFloat26(float var0, float var1, float var2) {
      if (var2 <= 0.0F) {
         return var1;
      } else {
         double var3 = var1 - var0;
         return (float)(var0 + (double)Math.round(var3 / var2) * var2);
      }
   }

   public static YawPitchRecord getYawPitchRecordForVec32(Vec3 var0, YawPitchRecord var1) {
      Vec3 var9 = Util4.getVec323();
      double var3 = var0.xCoord - var9.xCoord;
      double var5 = var0.yCoord - var9.yCoord;
      double var7 = var0.zCoord - var9.zCoord;
      if (var3 * var3 + var5 * var5 + var7 * var7 < 1.0E-8) {
         return var1;
      } else {
         float var11 = (float)(MathHelper.atan2(var7, var3) * 180.0 / Math.PI) - 90.0F;
         float var10 = (float)(-(MathHelper.atan2(var5, Math.sqrt(var3 * var3 + var7 * var7)) * 180.0 / Math.PI));
         return new YawPitchRecord(var1.yaw() + MathHelper.wrapAngleTo180_float(var11 - var1.yaw()), MathHelper.clamp_float(var10, -90.0F, 90.0F));
      }
   }

   public static float getFloat104() {
      double var0;
      double var10000 = var0 = MINECRAFT.gameSettings.mouseSensitivity * 0.6F + 0.2F;
      return (float)(var10000 * var10000 * var0 * 8.0) * 0.15F;
   }

   public static YawPitchRecord getYawPitchRecordForVec3(Vec3 var0) {
      YawPitchRecord var1 = new YawPitchRecord(MINECRAFT.thePlayer.rotationYaw, MINECRAFT.thePlayer.rotationPitch);
      return getYawPitchRecordForVec32(var0, var1);
   }

   public static float getFloatForFloat24(float var0, float var1, float var2) {
      float var5 = MathHelper.wrapAngleTo180_float(var1 - var0) * var2;
      return var0 + var5;
   }
}
