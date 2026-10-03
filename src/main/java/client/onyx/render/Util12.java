package client.onyx.render;

import client.onyx.module.render.GlowESPModule;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.Shader;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderManager;
import net.minecraft.client.shader.ShaderUniform;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public final class Util12 {
   private static final float FLOAT = 24.0F;
   private static final long LONG = System.nanoTime();
   private static final int INT = 9729;
   private static final float FLOAT2 = 10000.0F;
   private static final float FLOAT3 = 4.0F;
   private static final float FLOAT4 = 2.0F;
   private static final float FLOAT5 = 0.1F;
   private static final float FLOAT6 = 6.0F;
   private static final FloatBuffer FLOAT_BUFFER = BufferUtils.createFloatBuffer(4);
   private static final float FLOAT7 = 1.0F;
   private static boolean bool;
   private static final float FLOAT8 = 1.6F;

   private static void handleShaderManager2(ShaderManager var0, String var1, float var2, float var3, float var4) {
      ShaderUniform var5;
      if ((var5 = var0.getShaderUniform(var1)) != null) {
         var5.set(var2, var3, var4);
      }
   }

   private static void handleShaderManager3(ShaderManager var0, String var1, float var2, float var3, float var4, float var5) {
      ShaderUniform var6;
      if ((var6 = var0.getShaderUniform(var1)) != null) {
         var6.set(var2, var3, var4, var5);
      }
   }

   private Util12() {
   }

   private static float getFloat() {
      GlowESPModule var0;
      float var1 = (var0 = GlowESPModule.getGlowESPModule()) == null ? 24.0F : Math.clamp(var0.valueSettingSub102.getFloat5(), 2.0F, 24.0F);
      return var1 * 1.6F + 6.0F;
   }

   public static boolean isEnabled() {
      return bool;
   }

   public static float getFloat3() {
      GlowESPModule var0;
      return (var0 = GlowESPModule.getGlowESPModule()) != null && var0.isEnabled66() ? 4.0F : getFloat();
   }

   public static void run() {
      bool = false;
      GL11.glTexEnvi(8960, 8704, 8448);
   }

   private static void handleShaderGroup3(ShaderGroup var0, float var1, float var2) {
      float var6 = Math.max(1, Minecraft.getMinecraft().displayWidth);
      float var4 = var1 * 1.6F + 6.0F;
      List var5 = var0.getListShaders();

      int var9;
      for (int var10000 = var9 = 0; var10000 < var5.size(); var10000 = ++var9) {
         Shader var10 = (Shader)var5.get(var9);
         ShaderManager var7 = var10.getShaderManager();
         float var8 = var10.framebufferIn.framebufferTextureWidth / var6;
         handleShaderManager(var7, "Radius", Math.max(1.0F, var1 * var8));
         handleShaderManager(var7, "Intensity", var2);
         Util16.handleShader(var10, var9 == 0 ? var4 * 2.0F : var4);
      }

      handleShaderGroup4(var0, "final");
      handleShaderGroup4(var0, "blurx");
      handleShaderGroup4(var0, "halo");
   }

   public static float getFloat2() {
      GlowESPModule var0;
      return (var0 = GlowESPModule.getGlowESPModule()) != null && var0.isEnabled66() ? 8.0F : 3.0F * getFloat();
   }

   public static void handleInt(int var0) {
      bool = true;
      FLOAT_BUFFER.clear();
      FLOAT_BUFFER.put((var0 >> 16 & 0xFF) / 255.0F).put((var0 >> 8 & 0xFF) / 255.0F).put((var0 & 0xFF) / 255.0F).put(1.0F);
      FLOAT_BUFFER.flip();
      GL11.glTexEnv(8960, 8705, FLOAT_BUFFER);
      GL11.glTexEnvi(8960, 8704, 34160);
      GL11.glTexEnvi(8960, 34161, 7681);
      GL11.glTexEnvi(8960, 34176, 34166);
      GL11.glTexEnvi(8960, 34192, 768);
      GL11.glTexEnvi(8960, 34162, 8448);
      GL11.glTexEnvi(8960, 34184, 5890);
      GL11.glTexEnvi(8960, 34200, 770);
      GL11.glTexEnvi(8960, 34185, 34167);
      GL11.glTexEnvi(8960, 34201, 770);
   }

   private static void handleShaderGroup2(ShaderGroup var0, float var1) {
      float var2 = (float)(System.nanoTime() - LONG) / 1.0E9F % 10000.0F;

      Iterator var5;
      for (Iterator var10000 = var5 = var0.getListShaders().iterator(); var10000.hasNext(); var10000 = var5) {
         Shader var6 = (Shader)var5.next();
         ShaderManager var4 = var6.getShaderManager();
         handleShaderManager3(var4, "BaseColor", 0.0F, 0.0F, 0.0F, var1);
         handleShaderManager3(var4, "EffectData", var2, 0.0F, 0.0F, 0.0F);
         Util16.handleShader(var6, 4.0F);
      }
   }

   private static void handleShaderGroup4(ShaderGroup var0, String var1) {
      Framebuffer var2;
      if ((var2 = var0.getFramebufferRaw(var1)) != null && var2.framebufferFilter != 9729) {
         GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
         var2.setFramebufferFilter(9729);
      }
   }

   private static void handleShaderManager(ShaderManager var0, String var1, float var2) {
      ShaderUniform var3;
      if ((var3 = var0.getShaderUniform(var1)) != null) {
         var3.set(var2);
      }
   }

   public static void handleShaderGroup(ShaderGroup var0) {
      GlowESPModule var3 = GlowESPModule.getGlowESPModule();
      if (var0 != null && var3 != null && var3.isEnabled55()) {
         float var2 = Math.clamp(var3.valueSettingSub10.getFloat5() / 100.0F, 0.1F, 1.0F);
         if (var3.isEnabled66()) {
            handleShaderGroup2(var0, var2);
         } else {
            handleShaderGroup3(var0, Math.clamp(var3.valueSettingSub102.getFloat5(), 2.0F, 24.0F), var2);
         }
      }
   }
}
