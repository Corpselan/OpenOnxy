package client.onyx.render.hud;

import client.onyx.OnyxClient;
import client.onyx.module.hud.CustomGuiModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.GL11;

public final class Util {
   private static final client.onyx.render.misc.Cls CLS = new client.onyx.render.misc.Cls(1.0F);
   private static final float FLOAT = 100.0F;
   private static final client.onyx.render.Cls2 CLS2 = new client.onyx.render.Cls2(false);
   private static boolean bool2;
   private static boolean bool = true;
   private static boolean bool3;
   private static final float FLOAT2 = 16.0F;
   private static long long_;

   public static void handleGuiScreen(GuiScreen var0) {
      if (isGuiScreen(var0)) {
         CustomGuiModule var2;
         if ((var2 = Util4.getCustomGuiModule()) != null) {
            long_ = 0L;
            CLS.getCls(0.0F).getCls2(1.0F, var2.durationBooleanSetting.valueSettingSub10.getFloat5(), client.onyx.render.misc.Util.IFACE7);
         }
      }
   }

   public static void run4() {
      if (bool3) {
         GlStateManager.popMatrix();
         bool3 = false;
      } else if (bool2) {
         bool2 = false;
         Minecraft var10000 = Minecraft.getMinecraft();
         handleMinecraft(var10000);
         handleMinecraft3(var10000);
      }
   }

   private static float getFloat2() {
      CustomGuiModule var0;
      float var1 = (var0 = Util4.getCustomGuiModule()) == null ? 0.92F : var0.durationBooleanSetting.valueSettingSub102.getFloat5();
      float var2 = 1.0F - var1;
      float var3 = CLS.getFloat();
      float var4 = var2 * var3;
      return var1 + var4;
   }

   public static boolean isEnabled2() {
      return bool2;
   }

   public static void run() {
      CLS.getCls(1.0F);
      bool2 = false;
      bool3 = false;
   }

   private Util() {
   }

   private static void handleMinecraft(Minecraft var0) {
      OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
      Framebuffer var2 = var0.getFramebuffer();
      if (OpenGlHelper.isFramebufferEnabled() && var2 != null) {
         var2.bindFramebuffer(true);
      } else {
         int var3 = var0.displayWidth;
         GlStateManager.viewport(0, 0, var3, var0.displayHeight);
      }
   }

   public static void run3() {
      bool2 = false;
      bool3 = false;
      Minecraft var0 = Minecraft.getMinecraft();
      if (isEnabled() && isGuiScreen(var0.currentScreen) && !CLS.isEnabled()) {
         run2();
         if (Util4.getCustomGuiModule().durationBooleanSetting.valueSettingSub92.isEnabled17() && bool && OpenGlHelper.framebufferSupported) {
            try {
               CLS2.isInt(var0.displayWidth, var0.displayHeight);
               CLS2.run();
               bool2 = true;
            } catch (Throwable var2) {
               bool = false;
               CLS2.run2();
               OnyxClient.LOGGER.warn("GUI open animation fell back to scaling after a target failure", var2);
               bool3 = true;
               handleMinecraft2(var0);
            }
         } else {
            bool3 = true;
            handleMinecraft2(var0);
         }
      }
   }

   private static void handleMinecraft3(Minecraft var0) {
      ScaledResolution var10000 = new ScaledResolution(var0);
      float var5 = var10000.getScaledWidth();
      float var2 = var10000.getScaledHeight();
      float var6 = getFloat2();
      float var4 = CLS.getFloat();
      float var1 = var5 * (1.0F - var6) / 2.0F;
      var6 = var2 * (1.0F - var6) / 2.0F;
      GlStateManager.enableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.disableDepth();
      GlStateManager.disableLighting();
      GlStateManager.bindTexture(CLS2.getInt3());
      GlStateManager.tryBlendFuncSeparate(1, 771, 1, 771);
      GlStateManager.color(var4, var4, var4, var4);
      GL11.glBegin(7);
      GL11.glTexCoord2f(0.0F, 1.0F);
      GL11.glVertex2f(var1, var6);
      GL11.glTexCoord2f(0.0F, 0.0F);
      GL11.glVertex2f(var1, var2 - var6);
      GL11.glTexCoord2f(1.0F, 0.0F);
      GL11.glVertex2f(var5 - var1, var2 - var6);
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex2f(var5 - var1, var6);
      GL11.glEnd();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.enableAlpha();
      GlStateManager.enableDepth();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.resetColor();
   }

   private static boolean isEnabled() {
      CustomGuiModule var0;
      return (var0 = Util4.getCustomGuiModule()) != null && var0.isEnabled55() && var0.durationBooleanSetting.isEnabled5();
   }

   private static boolean isGuiScreen(GuiScreen var0) {
      if (var0 == null || var0 instanceof GuiChat) {
         return false;
      } else {
         return !isEnabled() ? false : var0 instanceof GuiContainer || var0 instanceof GuiIngameMenu;
      }
   }

   private static void run2() {
      long var0 = System.nanoTime();
      float var2 = long_ == 0L ? 16.0F : Math.min((float)(var0 - long_) / 1000000.0F, 100.0F);
      long_ = var0;
      CLS.handleFloat(var2);
   }

   private static void handleMinecraft2(Minecraft var0) {
      ScaledResolution var10000 = new ScaledResolution(var0);
      float var1 = var10000.getScaledWidth();
      float var4 = var10000.getScaledHeight();
      float var3 = getFloat2();
      GlStateManager.pushMatrix();
      GlStateManager.translate(var1 / 2.0F, var4 / 2.0F, 0.0F);
      GlStateManager.scale(var3, var3, 1.0F);
      GlStateManager.translate(-var1 / 2.0F, -var4 / 2.0F, 0.0F);
   }

   public static float getFloat() {
      return isEnabled() ? CLS.getFloat() : 1.0F;
   }
}
