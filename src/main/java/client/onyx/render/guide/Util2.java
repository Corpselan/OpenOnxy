package client.onyx.render.guide;

import client.onyx.OnyxClient;
import client.onyx.module.hud.KeybindsModule;
import client.onyx.module.hud.NotificationsModule;
import client.onyx.module.hud.PotionHUDModule;
import client.onyx.module.hud.Singleplayer;
import client.onyx.module.hud.StyleModule;
import client.onyx.module.hud.TargetHUDModule;
import client.onyx.module.hud.WatermarkModule;
import client.onyx.module.render.BedESPModule;
import client.onyx.module.render.CrosshairModule;
import client.onyx.module.render.TNTTimerModule;
import client.onyx.render.Sampler0;
import client.onyx.render.Util4;
import client.onyx.render.hud.Util5;
import net.minecraft.client.gui.ScaledResolution;

public final class Util2 {
   private static final Sampler0 SAMPLER0 = new Sampler0().getSampler0();

   private Util2() {
   }

   public static void handleScaledResolution(ScaledResolution var0, float var1) {
      if (OnyxClient.cls != null) {
         TargetHUDModule var22 = OnyxClient.cls.targetHUDModule;
         KeybindsModule var24 = OnyxClient.cls.keybindsModule;
         PotionHUDModule var4 = OnyxClient.cls.potionHUDModule;
         NotificationsModule var5 = OnyxClient.cls.notificationsModule;
         StyleModule var6 = OnyxClient.cls.styleModule;
         WatermarkModule var7;
         WatermarkModule var10000 = var7 = OnyxClient.cls.watermarkModule;
         Singleplayer var8 = OnyxClient.cls.watermarkModule.getSingleplayer();
         BedESPModule var9 = OnyxClient.cls.Ga;
         CrosshairModule var10 = OnyxClient.cls.crosshairModule;
         TNTTimerModule var11 = OnyxClient.cls.tNTTimerModule;
         boolean var12 = var22.isEnabled89();
         boolean var13 = var24.isEnabled85();
         boolean var14 = var4.isEnabled86();
         boolean var15 = var5.isEnabled80();
         boolean var16 = var6.isEnabled91();
         boolean var17 = var10000.isEnabled82();
         boolean var18 = var8.isEnabled76();
         boolean var19 = var9.isEnabled61();
         boolean var20 = var10.isEnabled64();
         boolean var21 = var11.isEnabled55();
         boolean var25 = Util4.isEnabled39();
         boolean var23 = Util5.isEnabled();
         if (var12 || var13 || var16 || var17 || var18 || var20 || var21 || var25 || var23 || var14 || var15 || var19) {
            float var26 = var0.getScaledWidth();
            float var3 = var0.getScaledHeight();
            SAMPLER0.run42();
            if (var23) {
               Util5.handleSampler0(SAMPLER0, var26, var3);
            }

            if (var21) {
               var11.handleSampler07(SAMPLER0, var26, var3, var1);
            }

            if (var20) {
               var10.handleSampler016(SAMPLER0, var26, var3);
            }

            if (var12) {
               var22.handleSampler040(SAMPLER0, var26, var3, var1);
            }

            if (var13) {
               var24.handleSampler034(SAMPLER0, var26, var3);
            }

            if (var14) {
               var4.handleSampler036(SAMPLER0, var26, var3);
            }

            if (var19) {
               var9.handleSampler015(SAMPLER0, var26, var3);
            }

            if (var16) {
               var6.handleSampler045(SAMPLER0, var26, var3);
            }

            if (var17) {
               var7.handleSampler025(SAMPLER0, var26, var3);
            }

            if (var18) {
               var8.handleSampler018(SAMPLER0, var26, var3);
            }

            if (var15) {
               var5.handleSampler022(SAMPLER0, var26, var3);
            }

            Util4.handleSampler0(SAMPLER0, var26, var3);
            SAMPLER0.run39();
         }
      }
   }
}
