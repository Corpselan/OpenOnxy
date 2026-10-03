package client.onyx.render;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.module.render.HandModule;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.GL11;

public final class Util implements MinecraftAccess {
   private static final int INT = 5889;
   private static boolean bool;
   private static boolean bool2;
   private static int int_;
   private static client.onyx.render.extra.Cls cls;
   private static final int INT2 = 5888;
   private static final Cls2 CLS2 = new Cls2(true);
   private static boolean bool3;
   private static int int_2;
   private static boolean bool4 = true;

   private Util() {
   }

   private static void handleItemRenderer2(ItemRenderer var0, float var1, Framebuffer var2, float var3, int var4, HandModule.GlintBooleanSetting var5) {
      CLS2.isInt(Math.round(int_2 * var3), Math.round(int_ * var3));
      if (var5 != null) {
         Util17.handleFloat2(Util19.getFloatForGlintBooleanSetting2(var5, (float)CLS2.getInt2() / int_2), CLS2.getInt2(), CLS2.getInt());
      }

      CLS2.run();
      cls.run3();
      cls.handleString5("Sampler0", 0);
      cls.handleString4(
         "uColor",
         client.onyx.theme.impl.Util2.getIntForInt7(var4) / 255.0F,
         client.onyx.theme.impl.Util2.getIntForInt(var4) / 255.0F,
         client.onyx.theme.impl.Util2.getIntForInt2(var4) / 255.0F,
         1.0F
      );
      GlStateManager.disableBlend();
      GlStateManager.enableDepth();
      GlStateManager.depthMask(true);
      GlStateManager.pushMatrix();
      bool2 = true;

      try {
         var0.renderItemInFirstPerson(var1);
      } finally {
         bool2 = false;
      }

      GlStateManager.popMatrix();
      client.onyx.render.extra.Cls.run2();
      Util17.run3();
      var2.bindFramebuffer(false);
      GlStateManager.viewport(0, 0, int_2, int_);
   }

   public static boolean isEnabled38() {
      return bool2;
   }

   public static void handleFramebuffer(Framebuffer var0) {
      client.onyx.render.extra.Cls.run2();
      handleInt10(2, 0);
      handleInt10(1, 0);
      handleInt10(0, 0);
      var0.bindFramebuffer(false);
      GlStateManager.viewport(0, 0, int_2, int_);
      GlStateManager.matrixMode(5889);
      GlStateManager.popMatrix();
      GlStateManager.matrixMode(5888);
      GlStateManager.popMatrix();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableAlpha();
      GlStateManager.disableLighting();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.resetColor();
   }

   public static void handleInt10(int var0, int var1) {
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + var0);
      GlStateManager.bindTexture(var1);
   }

   public static void run25() {
      GlStateManager.matrixMode(5889);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      GL11.glOrtho(0.0, 1.0, 0.0, 1.0, -1.0, 1.0);
      GlStateManager.matrixMode(5888);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      GlStateManager.disableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.disableDepth();
      GlStateManager.depthMask(false);
      GlStateManager.disableLighting();
      GlStateManager.disableFog();
      GlStateManager.enableTexture2D();
   }

   static void handleThrowable(Throwable var0) {
      bool4 = false;
      Util17.run3();
      CLS2.run2();
      Util19.run();
      Util5.run45();
      if (!bool3) {
         bool3 = true;
         OnyxClient.LOGGER.warn("Hand effects have been disabled after a render failure", var0);
      }
   }

   public static void handleItemRenderer(ItemRenderer var0, float var1) {
      if (bool4 && OnyxClient.cls != null) {
         if (OpenGlHelper.shadersSupported) {
            HandModule var5 = OnyxClient.cls.handModule;
            HandModule.GlintBooleanSetting var7;
            HandModule.TrailBooleanSetting var4 = (var7 = OnyxClient.cls.handModule.getGlintBooleanSetting()) == null ? var5.getTrailBooleanSetting() : null;
            if (var7 == null && var4 == null) {
               Util5.run45();
            } else {
               Framebuffer var2 = MinecraftAccess.MINECRAFT.getFramebuffer();
               if (OpenGlHelper.isFramebufferEnabled() && var2 != null) {
                  int_2 = var2.framebufferWidth;
                  int_ = var2.framebufferHeight;
                  if (int_2 > 0 && int_ > 0) {
                     try {
                        if (!bool) {
                           bool = true;
                           cls = client.onyx.render.extra.Cls.getClsForString("onyx_hand_mask");
                        }

                        if (cls != null && cls.isEnabled()) {
                           float var6 = var7 != null ? var5.getFloat64() : var4.getFloat40();
                           int var10004;
                           HandModule.GlintBooleanSetting var10005;
                           if (var7 != null) {
                              var10004 = var7.valueSettingSub62.getInt8();
                              var10005 = var7;
                           } else {
                              var10004 = -1;
                              var10005 = var7;
                           }

                           handleItemRenderer2(var0, var1, var2, var6, var10004, var10005);
                           if (var7 != null) {
                              Util19.handleCls24(CLS2, var2, var7, int_2, int_);
                           } else {
                              Util5.handleCls23(CLS2, var2, var4, var5.getInt36(), var5.getFloat66(), int_2, int_, var1);
                           }
                        } else {
                           bool4 = false;
                        }
                     } catch (Throwable var8) {
                        handleThrowable(var8);
                     }
                  }
               }
            }
         }
      }
   }

   public static void run24() {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glBegin(7);
      GL11.glTexCoord2f(0.0F, 0.0F);
      GL11.glVertex2f(0.0F, 0.0F);
      GL11.glTexCoord2f(1.0F, 0.0F);
      GL11.glVertex2f(1.0F, 0.0F);
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex2f(1.0F, 1.0F);
      GL11.glTexCoord2f(0.0F, 1.0F);
      GL11.glVertex2f(0.0F, 1.0F);
      GL11.glEnd();
   }
}
