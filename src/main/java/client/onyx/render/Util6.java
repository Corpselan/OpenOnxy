package client.onyx.render;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.module.render.SkyboxModule;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.GL11;

public final class Util6 implements MinecraftAccess {
   private static final int INT = 5889;
   private static boolean bool;
   private static int int_;
   private static final Cls2 CLS2 = new Cls2(false);
   private static final int INT2 = 5888;
   private static final int INT3 = 24;
   private static final int INT4 = 48;
   private static boolean bool3 = true;
   private static final float FLOAT = 16.0F;
   private static boolean bool4;
   private static client.onyx.render.extra.Cls cls;
   private static client.onyx.render.extra.Cls cls2;
   private static boolean bool2 = true;

   private static void run46() {
      if (int_ == 0) {
         int_ = GLAllocation.generateDisplayLists(1);
         GL11.glNewList(int_, 4864);
         GL11.glBegin(4);
         run48();
         GL11.glEnd();
         GL11.glEndList();
      }

      GL11.glCallList(int_);
   }

   private static void run48() {
      int var0;
      for (int var10000 = var0 = 0; var10000 < 24; var10000 = ++var0) {
         float var1 = (float)(Math.PI * var0 / 24.0 - (Math.PI / 2));
         float var2 = (float)(Math.PI * (var0 + 1) / 24.0 - (Math.PI / 2));
         float var3 = (float)Math.sin(var1);
         var1 = (float)Math.cos(var1);
         float var4 = (float)Math.sin(var2);
         var2 = (float)Math.cos(var2);

         int var5;
         for (int var22 = var5 = 0; var22 < 48; var22 = var5) {
            float var6 = (float)((Math.PI * 2) * var5 / 48.0);
            float var7 = (float)((Math.PI * 2) * (var5 + 1) / 48.0);
            float var8 = (float)Math.cos(var6);
            var6 = (float)Math.sin(var6);
            float var9 = (float)Math.cos(var7);
            var7 = (float)Math.sin(var7);
            float var10 = var1 * var8;
            float var11 = var1 * var6;
            float var12 = var1 * var9;
            float var13 = var1 * var7;
            var8 = var2 * var8;
            var6 = var2 * var6;
            var9 = var2 * var9;
            var7 = var2 * var7;
            handleFloat29(var10, var3, var11);
            handleFloat29(var8, var4, var6);
            handleFloat29(var9, var4, var7);
            handleFloat29(var10, var3, var11);
            handleFloat29(var9, var4, var7);
            var5++;
            handleFloat29(var12, var3, var13);
         }
      }
   }

   private static void handleSkyboxModule(SkyboxModule var0) {
      int var2 = var0.getInt32();
      GlStateManager.pushMatrix();
      GlStateManager.disableTexture2D();
      GlStateManager.disableLighting();
      GlStateManager.disableAlpha();
      GlStateManager.disableBlend();
      GlStateManager.disableFog();
      GlStateManager.depthMask(false);
      GlStateManager.disableCull();
      cls.run3();
      cls.handleString4(
         "uColorModulator",
         client.onyx.theme.impl.Util2.getIntForInt7(var2) / 255.0F,
         client.onyx.theme.impl.Util2.getIntForInt(var2) / 255.0F,
         client.onyx.theme.impl.Util2.getIntForInt2(var2) / 255.0F,
         var0.getFloat51()
      );
      cls.handleString3("uParams", var0.getInt33(), var0.getInt34(), var0.getFloat47());
      cls.handleString4("uKnobs", var0.getFloat49(), var0.getFloat48(), var0.getFloat53(), var0.getFloat52());
      cls.handleString("uStrikeGlow", var0.getFloat46());
      cls.handleString4("uFogColor", 0.0F, 0.0F, 0.0F, 0.0F);
      run46();
      client.onyx.render.extra.Cls.run2();
      GlStateManager.enableCull();
      GlStateManager.depthMask(true);
      GlStateManager.enableFog();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
      GlStateManager.enableLighting();
      GlStateManager.popMatrix();
   }

   private static void handleFloat29(float var0, float var1, float var2) {
      GL11.glVertex3f(var0 * 16.0F, var1 * 16.0F, var2 * 16.0F);
   }

   private static boolean isSkyboxModule(SkyboxModule var0) {
      float var1 = var0.getFloat50();
      if (!bool2 || var1 >= 0.999F) {
         return false;
      } else if (OpenGlHelper.isFramebufferEnabled() && OpenGlHelper.shadersSupported) {
         Framebuffer var3;
         if ((var3 = MINECRAFT.getFramebuffer()) != null && var3.framebufferWidth > 0 && var3.framebufferHeight > 0) {
            if (!bool) {
               bool = true;
               cls2 = client.onyx.render.extra.Cls.getClsForString2("onyx_sky_blit", "onyx_post", "onyx_hand_blit");
            }

            if (cls2 != null && cls2.isEnabled()) {
               try {
                  CLS2.isInt(Math.round(var3.framebufferWidth * var1), Math.round(var3.framebufferHeight * var1));
               } catch (Throwable var4) {
                  bool2 = false;
                  CLS2.run2();
                  OnyxClient.LOGGER.warn("Skybox is falling back to full resolution", var4);
                  return false;
               }

               CLS2.run();
               handleSkyboxModule(var0);
               var3.bindFramebuffer(false);
               GlStateManager.viewport(0, 0, var3.framebufferWidth, var3.framebufferHeight);
               run47();
               return true;
            } else {
               bool2 = false;
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private Util6() {
   }

   public static boolean isEnabled43() {
      if (bool3 && OnyxClient.cls != null) {
         SkyboxModule var0 = OnyxClient.cls.skyboxModule;
         if (!OnyxClient.cls.skyboxModule.isEnabled62()) {
            return false;
         } else {
            if (!bool4) {
               bool4 = true;
               cls = client.onyx.render.extra.Cls.getClsForString("onyx_sky");
            }

            if (cls != null && cls.isEnabled()) {
               try {
                  if (!isSkyboxModule(var0)) {
                     handleSkyboxModule(var0);
                  }

                  return true;
               } catch (Throwable var2) {
                  bool3 = false;
                  CLS2.run2();
                  OnyxClient.LOGGER.warn("Custom skybox unavailable", var2);
                  return false;
               }
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private static void run47() {
      GlStateManager.matrixMode(5889);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      GL11.glOrtho(0.0, 1.0, 0.0, 1.0, -1.0, 1.0);
      GlStateManager.matrixMode(5888);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      GlStateManager.disableAlpha();
      GlStateManager.disableDepth();
      GlStateManager.depthMask(false);
      GlStateManager.disableLighting();
      GlStateManager.disableFog();
      GlStateManager.enableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 771);
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
      GlStateManager.bindTexture(CLS2.getInt3());
      cls2.run3();
      cls2.handleString5("Sampler0", 0);
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
      client.onyx.render.extra.Cls.run2();
      GlStateManager.matrixMode(5889);
      GlStateManager.popMatrix();
      GlStateManager.matrixMode(5888);
      GlStateManager.popMatrix();
      GlStateManager.disableBlend();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableAlpha();
      GlStateManager.enableFog();
      GlStateManager.resetColor();
   }
}
