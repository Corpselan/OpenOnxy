package client.onyx.render;

import java.nio.ByteBuffer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureUtil;
import org.lwjgl.opengl.GL11;

public final class Cls2 {
   private int int_;
   private int int_2;
   private int int_3;
   private int int_4 = -1;
   private final boolean bool;
   private int int_5;

   public int getInt() {
      return this.int_2;
   }

   public void run() {
      this.run3();
      GlStateManager.clearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GlStateManager.clearDepth(1.0);
      GlStateManager.clear(this.bool ? 16640 : 16384);
   }

   public int getInt3() {
      return this.int_4;
   }

   public void run3() {
      OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, this.int_);
      int var1 = this.int_5;
      GlStateManager.viewport(0, 0, var1, this.int_2);
   }

   public Cls2(boolean var1) {
      this.int_ = -1;
      this.int_3 = -1;
      this.bool = var1;
   }

   public int getInt2() {
      return this.int_5;
   }

   public boolean isInt(int var1, int var2) {
      var1 = Math.max(1, var1);
      var2 = Math.max(1, var2);
      if (this.int_4 != -1 && this.int_5 == var1 && this.int_2 == var2) {
         return false;
      } else {
         this.run2();
         this.int_4 = TextureUtil.glGenTextures();
         GlStateManager.bindTexture(this.int_4);
         GL11.glTexImage2D(3553, 0, 32856, var1, var2, 0, 6408, 5121, (ByteBuffer)null);
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
         GL11.glTexParameteri(3553, 10242, 33071);
         GL11.glTexParameteri(3553, 10243, 33071);
         this.int_ = OpenGlHelper.glGenFramebuffers();
         OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, this.int_);
         OpenGlHelper.glFramebufferTexture2D(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_COLOR_ATTACHMENT0, 3553, this.int_4, 0);
         if (this.bool) {
            this.int_3 = OpenGlHelper.glGenRenderbuffers();
            OpenGlHelper.glBindRenderbuffer(OpenGlHelper.GL_RENDERBUFFER, this.int_3);
            OpenGlHelper.glRenderbufferStorage(OpenGlHelper.GL_RENDERBUFFER, 33190, var1, var2);
            OpenGlHelper.glFramebufferRenderbuffer(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_DEPTH_ATTACHMENT, OpenGlHelper.GL_RENDERBUFFER, this.int_3);
         }

         int var3 = OpenGlHelper.glCheckFramebufferStatus(OpenGlHelper.GL_FRAMEBUFFER);
         OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
         if (var3 != OpenGlHelper.GL_FRAMEBUFFER_COMPLETE) {
            this.run2();
            throw new IllegalStateException(new StringBuilder().insert(0, "Could not create a hand effect target, status ").append(var3).toString());
         } else {
            this.int_5 = var1;
            this.int_2 = var2;
            return true;
         }
      }
   }

   public void run2() {
      if (this.int_ != -1) {
         OpenGlHelper.glDeleteFramebuffers(this.int_);
         this.int_ = -1;
      }

      if (this.int_3 != -1) {
         OpenGlHelper.glDeleteRenderbuffers(this.int_3);
         this.int_3 = -1;
      }

      if (this.int_4 != -1) {
         TextureUtil.deleteTexture(this.int_4);
         this.int_4 = -1;
      }

      this.int_2 = this.int_5 = 0;
   }
}
