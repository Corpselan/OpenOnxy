package client.onyx.render;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import java.nio.ByteBuffer;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.GL11;

public final class Util9 implements MinecraftAccess {
   private static int int_ = -1;
   private static int int_2;
   private static boolean bool = true;
   private static final int INT = 5889;
   private static int int_3;
   private static final int INT2 = 5888;

   public static void handleCls7(client.onyx.render.extra.Cls var0, Consumer<client.onyx.render.extra.Cls> var1, Util9.XYRecord var2) {
      if (isEnabled45() && var0 != null && var0.isEnabled()) {
         Minecraft var6 = MinecraftAccess.MINECRAFT;
         Framebuffer var4 = MinecraftAccess.MINECRAFT.getFramebuffer();
         boolean var5 = OpenGlHelper.isFramebufferEnabled() && var4 != null;
         int var3 = var5 ? var4.framebufferWidth : var6.displayWidth;
         int var7 = var5 ? var4.framebufferHeight : var6.displayHeight;
         if (var3 > 0 && var7 > 0) {
            Util9.XYRecord var10 = var2 == null ? null : var2.getXYRecord2(var3, var7);
            if (var2 == null || var10 != null) {
               var2 = var10 == null ? null : var10.getXYRecord(var10.reach()).getXYRecord2(var3, var7);

               try {
                  GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
                  handleInt17(var3, var7);
                  GlStateManager.bindTexture(int_);
                  int var10000;
                  if (var2 == null) {
                     GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, var3, var7);
                     var10000 = var3;
                  } else {
                     GL11.glCopyTexSubImage2D(3553, 0, var2.x(), var2.y(), var2.x(), var2.y(), var2.width(), var2.height());
                     var10000 = var3;
                  }

                  handleInt16(var10000, var7);
                  if (var5) {
                     var4.bindFramebuffer(false);
                  }

                  GlStateManager.bindTexture(int_);
                  var0.run3();
                  var0.handleString5("Sampler0", 0);
                  var0.handleString2("uResolution", var3, var7);
                  var1.accept(var0);
                  handleXYRecord(var10, var3, var7);
                  run52();
               } catch (Throwable var8) {
                  handleThrowable3(var8);
               }
            }
         }
      }
   }

   public static int getInt17() {
      Framebuffer var0 = MinecraftAccess.MINECRAFT.getFramebuffer();
      return OpenGlHelper.isFramebufferEnabled() && var0 != null ? var0.framebufferWidth : MinecraftAccess.MINECRAFT.displayWidth;
   }

   public static void handleCls5(client.onyx.render.extra.Cls var0, Consumer<client.onyx.render.extra.Cls> var1) {
      handleCls7(var0, var1, null);
   }

   private Util9() {
   }

   public static int getInt16() {
      Framebuffer var0 = MinecraftAccess.MINECRAFT.getFramebuffer();
      return OpenGlHelper.isFramebufferEnabled() && var0 != null ? var0.framebufferHeight : MinecraftAccess.MINECRAFT.displayHeight;
   }

   private static void handleThrowable3(Throwable var0) {
      bool = false;

      try {
         run51();
      } catch (Throwable var1) {
      }

      OnyxClient.LOGGER.warn("Post-processing unavailable, effects disabled for this session", var0);
   }

   public static boolean isEnabled45() {
      return bool && OpenGlHelper.shadersSupported;
   }

   private static void handleXYRecord(Util9.XYRecord var0, int var1, int var2) {
      float var3 = 0.0F;
      float var4 = 0.0F;
      float var5 = 1.0F;
      float var7 = 1.0F;
      if (var0 != null) {
         var3 = (float)var0.x() / var1;
         var4 = (float)var0.y() / var2;
         var5 = (float)(var0.x() + var0.width()) / var1;
         var7 = (float)(var0.y() + var0.height()) / var2;
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glBegin(7);
      GL11.glTexCoord2f(var3, var4);
      GL11.glVertex2f(var3, var4);
      GL11.glTexCoord2f(var5, var4);
      GL11.glVertex2f(var5, var4);
      GL11.glTexCoord2f(var5, var7);
      GL11.glVertex2f(var5, var7);
      GL11.glTexCoord2f(var3, var7);
      GL11.glVertex2f(var3, var7);
      GL11.glEnd();
   }

   private static void handleInt17(int var0, int var1) {
      if (int_ == -1 || int_3 != var0 || int_2 != var1) {
         run51();
         int_ = TextureUtil.glGenTextures();
         GlStateManager.bindTexture(int_);
         GL11.glTexImage2D(3553, 0, 32856, var0, var1, 0, 6408, 5121, (ByteBuffer)null);
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
         GL11.glTexParameteri(3553, 10242, 33071);
         GL11.glTexParameteri(3553, 10243, 33071);
         int var2;
         if ((var2 = GL11.glGetError()) != 0) {
            throw new IllegalStateException(new StringBuilder().insert(0, "post target allocation failed, GL error ").append(var2).toString());
         } else {
            int_3 = var0;
            int_2 = var1;
         }
      }
   }

   private static void handleInt16(int var0, int var1) {
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
      GlStateManager.enableTexture2D();
      GlStateManager.viewport(0, 0, var0, var1);
   }

   private static void run52() {
      client.onyx.render.extra.Cls.run2();
      GlStateManager.matrixMode(5889);
      GlStateManager.popMatrix();
      GlStateManager.matrixMode(5888);
      GlStateManager.popMatrix();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableAlpha();
      GlStateManager.enableLighting();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.resetColor();
   }

   private static void run51() {
      if (int_ != -1) {
         TextureUtil.deleteTexture(int_);
         int_ = -1;
      }

      int_3 = 0;
      int_2 = 0;
   }

   public record XYRecord(int x, int y, int width, int height, int reach) {
      public Util9.XYRecord getXYRecord2(int var1, int var2) {
         int var4 = Math.max(0, this.x);
         int var5 = Math.max(0, this.y);
         int var7 = this.x + this.width;
         var1 = Math.min(var1, var7);
         int var10 = this.y + this.height;
         var2 = Math.min(var2, var10);
         if (var1 > var4 && var2 > var5) {
            int var12 = var1 - var4;
            return new Util9.XYRecord(var4, var5, var12, var2 - var5, this.reach);
         } else {
            return null;
         }
      }

      public Util9.XYRecord getXYRecord(int var1) {
         return new Util9.XYRecord(this.x - var1, this.y - var1, this.width + var1 * 2, this.height + var1 * 2, this.reach);
      }
   }
}
