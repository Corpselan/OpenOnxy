package client.onyx.render;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.module.render.DistanceModule;
import java.nio.ByteBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.GL11;

public final class Util2 implements MinecraftAccess {
   private static boolean bool2 = true;
   private static final int INT = 5889;
   private static client.onyx.render.extra.Cls cls;
   private static int int_6 = -1;
   private static client.onyx.render.extra.Cls cls2;
   private static final int INT2 = 5888;
   private static int int_5 = -1;
   private static int int_4;
   private static boolean bool;
   private static int int_2 = -1;
   private static client.onyx.render.extra.Cls cls3;
   private static final int INT3 = 2;
   private static int int_ = -1;
   private static final int INT4 = 10496;
   private static int int_7 = -1;
   private static final float FLOAT = 0.05F;
   private static int int_3 = -1;
   private static int int_8;

   private static void handleInt11(int var0, int var1) {
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + var0);
      GlStateManager.bindTexture(var1);
   }

   private static void run30() {
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

   private static void handleCls(client.onyx.render.extra.Cls var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, var2);
      GlStateManager.viewport(0, 0, var3, var4);
      handleInt11(0, var1);
      var0.run3();
      var0.handleString5("Sampler0", 0);
      var0.handleString2("uSourceSize", var5, var6);
      run30();
   }

   private static void handleDistanceModule(DistanceModule var0, float var1, Framebuffer var2, int var3, int var4) {
      if (var2 != null) {
         var2.bindFramebuffer(false);
      } else {
         OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
      }

      GlStateManager.viewport(0, 0, var3, var4);
      float var6 = Math.max(1.05F, MINECRAFT.gameSettings.renderDistanceChunks * 16.0F * 4.0F);
      cls3.run3();
      cls3.handleString5("BlurSampler", 1);
      cls3.handleString5("DepthSampler", 2);
      cls3.handleString4("uCamera", 0.05F, var6, var1, 0.0F);
      cls3.handleString4(
         "uFog",
         var0.valueSettingSub102.getFloat5(),
         var0.valueSettingSub103.getFloat5(),
         var0.valueSettingSub10.getFloat5(),
         var0.valueSettingSub92.isEnabled17() ? 1.0F : 0.0F
      );
      int var5 = client.onyx.theme.Util4.getPrimaryOnPrimaryRecord().primary();
      int var7 = client.onyx.theme.Util4.getPrimaryOnPrimaryRecord().tertiary();
      cls3.handleString7("uColor1", var5);
      cls3.handleString7("uColor2", var5);
      cls3.handleString7("uColor3", var7);
      cls3.handleString7("uColor4", var7);
      handleInt11(1, int_2);
      handleInt11(2, int_5);
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 771);
      run30();
      GlStateManager.disableBlend();
      handleInt11(2, 0);
      handleInt11(1, 0);
      handleInt11(0, 0);
   }

   private static void handleInt12(int var0) {
      int var1 = Math.max(1, int_8 / 2);
      int var5 = Math.max(1, int_4 / 2);
      int var3 = Math.max(1, var1 / 2);
      int var4 = Math.max(1, var5 / 2);
      handleCls(cls, var0, int_7, var1, var5, int_8, int_4);
      handleCls(cls, int_2, int_3, var3, var4, var1, var5);
      handleCls(cls2, int_, int_7, var1, var5, var3, var4);
   }

   private static void run27() {
      client.onyx.render.extra.Cls.run2();
      GlStateManager.matrixMode(5889);
      GlStateManager.popMatrix();
      GlStateManager.matrixMode(5888);
      GlStateManager.popMatrix();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableAlpha();
      GlStateManager.enableFog();
      GlStateManager.enableLighting();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.resetColor();
   }

   private static void run31() {
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10242, 33071);
      GL11.glTexParameteri(3553, 10243, 33071);
   }

   private static int getIntForInt(int var0) {
      int var3;
      if ((var3 = OpenGlHelper.glGenFramebuffers()) == -1) {
         return -1;
      } else {
         OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, var3);
         OpenGlHelper.glFramebufferTexture2D(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_COLOR_ATTACHMENT0, 3553, var0, 0);
         int var2 = OpenGlHelper.glCheckFramebufferStatus(OpenGlHelper.GL_FRAMEBUFFER);
         OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
         return var2 == OpenGlHelper.GL_FRAMEBUFFER_COMPLETE ? var3 : -1;
      }
   }

   private static void handleInt15(int var0, int var1) {
      handleInt11(0, int_5);
      GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, var0, var1);
   }

   private Util2() {
   }

   private static void handleFramebuffer2(Framebuffer var0, boolean var1) {
      if (var1) {
         handleInt11(0, var0.framebufferTexture);
         handleInt13(var0.framebufferFilter, 10496);
         handleInt11(0, 0);
      }
   }

   public static void run26() {
      if (bool2 && OnyxClient.cls != null) {
         if (OpenGlHelper.shadersSupported) {
            DistanceModule var0 = OnyxClient.cls.Da;
            Minecraft var1 = MinecraftAccess.MINECRAFT;
            if (var0.isEnabled55() && var1.theWorld != null) {
               float var2 = var0.valueSettingSub9.isEnabled17() ? 1.0F - Math.clamp(OnyxClient.cls.zoomModule.getFloat35(), 0.0F, 1.0F) : 1.0F;
               if (!(var2 <= 0.01F)) {
                  Framebuffer var3 = var1.getFramebuffer();
                  boolean var4 = OpenGlHelper.isFramebufferEnabled() && var3 != null;
                  int var5 = var4 ? var3.framebufferWidth : var1.displayWidth;
                  int var6 = var4 ? var3.framebufferHeight : var1.displayHeight;
                  if (var5 > 0 && var6 > 0) {
                     if (!bool) {
                        bool = true;
                        cls = client.onyx.render.extra.Cls.getClsForString("onyx_fog_down");
                        cls2 = client.onyx.render.extra.Cls.getClsForString("onyx_fog_up");
                        cls3 = client.onyx.render.extra.Cls.getClsForString("onyx_fog_composite");
                     }

                     if (cls != null && cls2 != null && cls3 != null && cls.isEnabled() && cls2.isEnabled() && cls3.isEnabled()) {
                        try {
                           handleInt14(var5, var6, var4);
                           int var8 = getIntForFramebuffer(var3, var4, var5, var6);
                           handleInt15(var5, var6);
                           run29();
                           handleInt12(var8);
                           handleFramebuffer2(var3, var4);
                           Framebuffer var10002;
                           int var10003;
                           if (var4) {
                              var10002 = var3;
                              var10003 = var5;
                           } else {
                              var10002 = null;
                              var10003 = var5;
                           }

                           handleDistanceModule(var0, var2, var10002, var10003, var6);
                           run27();
                        } catch (Throwable var7) {
                           handleThrowable2(var7);
                        }
                     } else {
                        bool2 = false;
                     }
                  }
               }
            }
         }
      }
   }

   private static int getIntForInt3(int var0, int var1) {
      int var3;
      GlStateManager.bindTexture(var3 = TextureUtil.glGenTextures());
      GL11.glTexImage2D(3553, 0, 33190, var0, var1, 0, 6402, 5126, (ByteBuffer)null);
      run31();
      return var3;
   }

   private static void handleThrowable2(Throwable var0) {
      bool2 = false;

      try {
         run28();
      } catch (Throwable var1) {
      }

      OnyxClient.LOGGER.warn("Fog Blur failed, disabled for this session", var0);
   }

   private static void run29() {
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

   private static int getIntForFramebuffer(Framebuffer var0, boolean var1, int var2, int var3) {
      if (var1) {
         handleInt11(0, var0.framebufferTexture);
         handleInt13(9729, 33071);
         return var0.framebufferTexture;
      } else {
         handleInt11(0, int_6);
         GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, var2, var3);
         return int_6;
      }
   }

   private static void run28() {
      if (int_7 != -1) {
         OpenGlHelper.glDeleteFramebuffers(int_7);
         int_7 = -1;
      }

      if (int_3 != -1) {
         OpenGlHelper.glDeleteFramebuffers(int_3);
         int_3 = -1;
      }

      int[] var10000 = new int[4];
      boolean var10002 = true;
      var10000[0] = int_6;
      var10000[1] = int_5;
      var10000[2] = int_2;
      var10000[3] = int_;
      int[] var0 = var10000;
      int var1 = var10000.length;

      int var2;
      for (int var4 = var2 = 0; var4 < var1; var4 = ++var2) {
         int var3;
         if ((var3 = var0[var2]) != -1) {
            TextureUtil.deleteTexture(var3);
         }
      }

      int_6 = -1;
      int_5 = -1;
      int_2 = -1;
      int_ = -1;
      int_8 = 0;
      int_4 = 0;
   }

   private static void handleInt14(int var0, int var1, boolean var2) {
      if (int_2 == -1 || int_8 != var0 || int_4 != var1 || !var2 && int_6 == -1) {
         run28();
         int var3 = Math.max(1, var0 / 2);
         int var4 = Math.max(1, var1 / 2);
         int var5 = Math.max(1, var3 / 2);
         int var6 = Math.max(1, var4 / 2);
         if (!var2) {
            int_6 = getIntForInt2(var0, var1);
         }

         int_2 = getIntForInt2(var3, var4);
         int_ = getIntForInt2(var5, var6);
         int_5 = getIntForInt3(var0, var1);
         int_7 = getIntForInt(int_2);
         int_3 = getIntForInt(int_);
         if (int_7 != -1 && int_3 != -1) {
            int_8 = var0;
            int_4 = var1;
         } else {
            throw new IllegalStateException("could not create fog blur render targets");
         }
      }
   }

   private static int getIntForInt2(int var0, int var1) {
      int var3;
      GlStateManager.bindTexture(var3 = TextureUtil.glGenTextures());
      GL11.glTexImage2D(3553, 0, 32856, var0, var1, 0, 6408, 5121, (ByteBuffer)null);
      run31();
      return var3;
   }

   private static void handleInt13(int var0, int var1) {
      GL11.glTexParameteri(3553, 10241, var0);
      GL11.glTexParameteri(3553, 10240, var0);
      GL11.glTexParameteri(3553, 10242, var1);
      GL11.glTexParameteri(3553, 10243, var1);
   }
}
