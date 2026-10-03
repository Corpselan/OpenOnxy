package client.onyx.render;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;

public final class Util18 implements MinecraftAccess {
   private static client.onyx.render.extra.Cls cls;
   private static boolean bool;
   private static boolean bool2;
   private static final Cls2 CLS2 = new Cls2(false);
   private static boolean bool3;

   public static void run67() {
      bool = false;
   }

   public static void run66() {
      if (!bool2 && OnyxClient.cls != null) {
         float var0;
         if ((var0 = OnyxClient.cls.cameraModule.getFloat34()) <= 0.0F) {
            bool = false;
         } else if (Util9.isEnabled45()) {
            if (!bool3) {
               bool3 = true;
               cls = client.onyx.render.extra.Cls.getClsForString2("onyx_motion_blur", "onyx_post", "onyx_motion_blur");
            }

            if (cls != null && cls.isEnabled()) {
               int var1 = Util9.getInt17();
               int var2 = Util9.getInt16();
               if (var1 > 0 && var2 > 0) {
                  try {
                     if (CLS2.isInt(var1, var2)) {
                        bool = false;
                     }

                     if (bool) {
                        Util9.handleCls5(cls, var1x -> {
                           Util.handleInt10(1, CLS2.getInt3());
                           var1x.handleString5("Sampler1", 1);
                           var1x.handleString("uAmount", var0);
                           GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
                        });
                        Util.handleInt10(1, 0);
                        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
                     }

                     GlStateManager.bindTexture(CLS2.getInt3());
                     GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, var1, var2);
                     GlStateManager.bindTexture(0);
                     bool = true;
                  } catch (Throwable var4) {
                     OnyxClient.LOGGER.error("Motion blur disabled", var4);
                     bool2 = true;
                     bool = false;
                     CLS2.run2();
                  }
               }
            }
         }
      }
   }

   private Util18() {
   }
}
