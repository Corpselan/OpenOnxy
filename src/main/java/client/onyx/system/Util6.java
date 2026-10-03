package client.onyx.system;

import client.onyx.MinecraftAccess;
import net.minecraft.client.entity.EntityPlayerSP;

public class Util6 implements MinecraftAccess {
   private static boolean bool4 = false;
   private static float float_3 = 0.0F;
   private static float float_4 = 0.0F;
   private static OffStrictEnum offStrictEnum = OffStrictEnum.OFF;
   private static float float_ = 0.0F;
   private static float float_7 = 0.0F;
   private static boolean bool2 = false;
   private static boolean bool = false;
   private static float float_5 = 0.0F;
   private static float float_8 = 0.0F;
   private static float float_6 = 0.0F;
   private static float float_2 = 0.0F;
   private static boolean bool3 = false;
   private static EntityPlayerSP entityPlayerSP = null;

   public static void run181() {
      if (bool) {
         bool = false;
         if (MINECRAFT.thePlayer != null) {
            MINECRAFT.thePlayer.rotationYaw = float_5;
            MINECRAFT.thePlayer.rotationPitch = float_8;
         }
      }
   }

   public static boolean isEnabled141() {
      return !isEnabled139() && bool4 && offStrictEnum != OffStrictEnum.OFF && MINECRAFT.thePlayer != null;
   }

   public static boolean isEnabled138() {
      return bool2;
   }

   public static YawPitchRecord getYawPitchRecord25() {
      return bool3 ? new YawPitchRecord(float_6, float_2) : new YawPitchRecord(float_, float_7);
   }

   public static float getFloat103() {
      return float_7;
   }

   public static float getFloat100() {
      return float_3;
   }

   public static float getFloat102() {
      return float_4;
   }

   public static void handleFloat76(float var0, float var1) {
      float_6 = var0;
      float_2 = var1;
      bool3 = true;
      float_ = var0;
      float_7 = var1;
   }

   public static float getFloat101() {
      return float_;
   }

   public static void run183() {
      bool4 = false;
      offStrictEnum = OffStrictEnum.OFF;
   }

   public static void run182() {
      if (MINECRAFT.thePlayer != null) {
         if (entityPlayerSP != MINECRAFT.thePlayer) {
            entityPlayerSP = MINECRAFT.thePlayer;
            float_ = MINECRAFT.thePlayer.rotationYaw;
            float_7 = MINECRAFT.thePlayer.rotationPitch;
            float_6 = float_;
            float_2 = float_7;
            bool3 = true;
            bool2 = false;
         }

         if (isEnabled139()) {
            client.onyx.rotation.data.YawPitchRecord var0;
            if ((var0 = client.onyx.rotation.Cls.CLS.getYawPitchRecord()) == null) {
               var0 = client.onyx.util.Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer);
            }

            bool = false;
            bool2 = true;
            float_ = var0.yaw2();
            float_7 = var0.pitch2();
            Util3.handleFloat75(float_, float_7);
         } else {
            if (bool4) {
               if (bool3) {
                  MINECRAFT.thePlayer.lastReportedYaw = float_6;
                  MINECRAFT.thePlayer.lastReportedPitch = float_2;
               }

               float_5 = MINECRAFT.thePlayer.rotationYaw;
               float_8 = MINECRAFT.thePlayer.rotationPitch;
               bool = true;
               MINECRAFT.thePlayer.rotationYaw = float_3;
               MINECRAFT.thePlayer.rotationPitch = float_4;
            }

            bool2 = bool4;
            float_ = MINECRAFT.thePlayer.rotationYaw;
            float_7 = MINECRAFT.thePlayer.rotationPitch;
            Util3.handleFloat75(MINECRAFT.thePlayer.rotationYaw, MINECRAFT.thePlayer.rotationPitch);
         }
      }
   }

   public static boolean isEnabled140() {
      return bool4;
   }

   private static boolean isEnabled139() {
      return bool4 ? false : client.onyx.rotation.Cls.CLS.getYawPitchRecord() != null || client.onyx.rotation.Cls.CLS.getCls27() != null;
   }

   public static OffStrictEnum getOffStrictEnum4() {
      return offStrictEnum;
   }

   public static void handleYawPitchRecord3(YawPitchRecord var0, OffStrictEnum var1) {
      float_3 = var0.yaw();
      float_4 = var0.pitch();
      offStrictEnum = var1;
      bool4 = true;
   }
}
