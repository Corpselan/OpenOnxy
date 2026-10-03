package client.onyx.render;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.module.render.AmbienceModule;

public final class Util21 implements MinecraftAccess {
   private static client.onyx.render.extra.Cls cls;
   private static boolean bool;
   private static final long LONG = System.nanoTime();

   private Util21() {
   }

   public static void run72() {
      if (OnyxClient.cls != null) {
         AmbienceModule var0 = OnyxClient.cls.ambienceModule;
         if (OnyxClient.cls.ambienceModule.isEnabled75() && Util9.isEnabled45()) {
            if (!bool) {
               bool = true;
               cls = client.onyx.render.extra.Cls.getClsForString("onyx_ambience");
            }

            if (cls != null && cls.isEnabled()) {
               boolean var1 = var0.colorBooleanSetting.isEnabled5();
               boolean var2 = var0.saturationBooleanSetting.isEnabled5();
               int var3 = var1 ? var0.colorBooleanSetting.valueSettingSub6.getInt8() : -1;
               float var8 = var1 ? var0.colorBooleanSetting.valueSettingSub10.getFloat5() / 100.0F : 0.0F;
               float var4 = var2 ? var0.saturationBooleanSetting.valueSettingSub102.getFloat5() / 100.0F : 1.0F;
               float var5 = var2 ? var0.saturationBooleanSetting.valueSettingSub104.getFloat5() / 100.0F : 1.0F;
               float var6 = var2 ? var0.saturationBooleanSetting.valueSettingSub10.getFloat5() / 100.0F : 0.0F;
               float var9 = var2 ? var0.saturationBooleanSetting.valueSettingSub103.getFloat5() / 100.0F : 0.0F;
               float var7 = (float)(System.nanoTime() - LONG) / 1.0E9F;
               Util9.handleCls5(
                  cls,
                  var7x -> {
                     var7x.handleString4(
                        "uLightColorAndStrength",
                        client.onyx.theme.impl.Util2.getIntForInt7(var3) / 255.0F,
                        client.onyx.theme.impl.Util2.getIntForInt(var3) / 255.0F,
                        client.onyx.theme.impl.Util2.getIntForInt2(var3) / 255.0F,
                        var8
                     );
                     var7x.handleString4("uGradeParams", var4, var5, var6, var9);
                     var7x.handleString("uTime", var7);
                  }
               );
            }
         }
      }
   }
}
