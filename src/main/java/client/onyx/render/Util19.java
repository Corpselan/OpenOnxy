package client.onyx.render;

import client.onyx.module.render.HandModule;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;

public final class Util19 {
   private static final long LONG2 = System.nanoTime();
   private static client.onyx.render.extra.Cls cls;
   private static final Cls2 CLS25 = new Cls2(false);
   private static final long LONG = 3600000000000L;
   private static final float FLOAT = 0.9F;
   private static final float FLOAT2 = 2.0F;
   private static final float FLOAT3 = 16.0F;
   private static final Cls2 CLS22 = new Cls2(false);
   private static final Cls2 CLS2 = new Cls2(false);
   private static final float FLOAT4 = 0.05F;
   private static final float FLOAT5 = 2.2F;
   private static client.onyx.render.extra.Cls cls2;
   private static client.onyx.render.extra.Cls cls3;
   private static final Cls2 CLS24 = new Cls2(false);
   private static final Cls2 CLS23 = new Cls2(false);
   private static final float FLOAT6 = 4.0F;
   private static client.onyx.render.extra.Cls cls4;
   private static final float FLOAT7 = 24.0F;
   private static final float FLOAT8 = 8.0F;
   private static boolean bool;

   static float getFloatForGlintBooleanSetting2(HandModule.GlintBooleanSetting var0, float var1) {
      float var2 = var0.valueSettingSub105.getFloat5() * var1;
      float var4 = var0.valueSettingSub102.getFloat5() * var1;
      return getFloatForFloat2(var2, var4) + getFloatForFloat3(var2, var4, getFloatForGlintBooleanSetting(var0, var1));
   }

   private static float getFloatForGlintBooleanSetting(HandModule.GlintBooleanSetting var0, float var1) {
      return Math.min(8.0F, var0.valueSettingSub104.getFloat5() * var1);
   }

   private static float getFloatForFloat4(float var0) {
      return var0 < 0.05F ? 0.0F : 2.0F * Math.clamp((float)Math.ceil(var0 * 0.5F), 1.0F, 16.0F);
   }

   static void run() {
      CLS25.run2();
      CLS22.run2();
      CLS2.run2();
      CLS24.run2();
      CLS23.run2();
   }

   private static void handleCls25(Cls2 var0, Cls2 var1, float var2, float var3, float var4) {
      var1.run3();
      Util.handleInt10(0, var0.getInt3());
      cls4.run3();
      cls4.handleString5("Sampler0", 0);
      cls4.handleString2("uSourceSize", var0.getInt2(), var0.getInt());
      cls4.handleString2("uDirection", var2, var3);
      cls4.handleString("uPadding", var4);
      Util.run24();
   }

   private static void handleCls2(Cls2 var0, Cls2 var1, float var2, float var3, float var4) {
      var1.run3();
      Util.handleInt10(0, var0.getInt3());
      cls.run3();
      cls.handleString5("Sampler0", 0);
      cls.handleString2("uSourceSize", var0.getInt2(), var0.getInt());
      cls.handleString2("uDirection", var2, var3);
      cls.handleString("uRadius", var4);
      Util.run24();
   }

   private static void handleCls22(Cls2 var0, Cls2 var1, HandModule.GlintBooleanSetting var2, float var3, int var4, int var5) {
      var1.run3();
      Util.handleInt10(0, var0.getInt3());
      int var8 = var2.valueSettingSub62.getInt8();
      int var6 = var2.valueSettingSub6.getInt8();
      float var7 = var2.valueSettingSub106.getFloat5() / 100.0F;
      cls3.run3();
      cls3.handleString5("Sampler0", 0);
      cls3.handleString2("uMaskSize", var0.getInt2(), var0.getInt());
      cls3.handleString2("uOutSize", var4, var5);
      cls3.handleString4(
         "uColorPrimary",
         client.onyx.theme.impl.Util2.getIntForInt7(var8) / 255.0F,
         client.onyx.theme.impl.Util2.getIntForInt(var8) / 255.0F,
         client.onyx.theme.impl.Util2.getIntForInt2(var8) / 255.0F,
         var7
      );
      cls3.handleString4(
         "uColorSecondary",
         client.onyx.theme.impl.Util2.getIntForInt7(var6) / 255.0F,
         client.onyx.theme.impl.Util2.getIntForInt(var6) / 255.0F,
         client.onyx.theme.impl.Util2.getIntForInt2(var6) / 255.0F,
         var2.valueSettingSub10.getFloat5() / 100.0F
      );
      cls3.handleString4("uMotion", getFloat(), var2.valueSettingSub107.getFloat5(), 2.0F, getFloatForGlintBooleanSetting(var2, var3));
      cls3.handleString4("uOptions", var2.valueSettingSub103.getFloat5() / 100.0F, var2.valueSettingSub92.isEnabled17() ? 1.0F : 0.0F, 0.0F, 0.0F);
      Util.run24();
   }

   private static boolean isEnabled() {
      if (!bool) {
         bool = true;
         cls4 = client.onyx.render.extra.Cls.getClsForString2("onyx_hand_expand", "onyx_post", "onyx_hand_expand");
         cls = client.onyx.render.extra.Cls.getClsForString2("onyx_hand_smooth", "onyx_post", "onyx_hand_smooth");
         cls3 = client.onyx.render.extra.Cls.getClsForString2("onyx_hand_aurora", "onyx_post", "onyx_hand_aurora");
         cls2 = client.onyx.render.extra.Cls.getClsForString2("onyx_hand_blit", "onyx_post", "onyx_hand_blit");
      }

      return cls4 != null && cls4.isEnabled() && cls != null && cls.isEnabled() && cls3 != null && cls3.isEnabled() && cls2 != null && cls2.isEnabled();
   }

   static void handleCls24(Cls2 var0, Framebuffer var1, HandModule.GlintBooleanSetting var2, int var3, int var4) {
      if (isEnabled()) {
         int var11 = var0.getInt2();
         int var6 = var0.getInt();
         float var7 = var11 / Math.max(1.0F, (float)var3);
         CLS25.isInt(var11, var6);
         CLS22.isInt(var11, var6);
         CLS2.isInt(var11, var6);
         CLS24.isInt(var11, var6);
         CLS23.isInt(var11, var6);
         Util.run25();
         float var8 = var2.valueSettingSub105.getFloat5() * var7;
         float var9 = var2.valueSettingSub102.getFloat5() * var7;
         float var10;
         Util17.handleFloat2((var10 = getFloatForFloat2(var8, var9)) + getFloatForFloat3(var8, var9, getFloatForGlintBooleanSetting(var2, var7)), var11, var6);
         CLS25.run();
         CLS22.run();
         CLS2.run();
         CLS24.run();
         CLS23.run();
         Util17.handleFloat2(var10, var11, var6);
         handleCls25(var0, CLS25, 1.0F, 0.0F, var8);
         handleCls25(CLS25, CLS22, 0.0F, 1.0F, var8);
         handleCls2(CLS22, CLS2, 1.0F, 0.0F, var9);
         handleCls2(CLS2, CLS24, 0.0F, 1.0F, var9);
         handleCls22(CLS24, CLS23, var2, var7, var3, var4);
         Util17.handleFloat2(var10 / Math.max(var7, 1.0E-4F), var3, var4);
         handleCls23(CLS23, var1, var3, var4);
         Util17.run3();
         Util.handleFramebuffer(var1);
      }
   }

   private static float getFloatForFloat2(float var0, float var1) {
      return 2.0F * (getFloatForFloat(var0) + getFloatForFloat4(var1)) + 4.0F;
   }

   private static float getFloat() {
      return (float)((System.nanoTime() - LONG2) % 3600000000000L) / 1.0E9F;
   }

   private static float getFloatForFloat(float var0) {
      return Math.clamp((float)Math.ceil(var0), 0.0F, 24.0F);
   }

   private Util19() {
   }

   private static void handleCls23(Cls2 var0, Framebuffer var1, int var2, int var3) {
      var1.bindFramebuffer(false);
      GlStateManager.viewport(0, 0, var2, var3);
      Util.handleInt10(0, var0.getInt3());
      cls2.run3();
      cls2.handleString5("Sampler0", 0);
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 771);
      Util.run24();
      GlStateManager.disableBlend();
   }

   private static float getFloatForFloat3(float var0, float var1, float var2) {
      var2 = (float)Math.ceil(var2 * 2.2F + 0.9F);
      return Math.max(Math.max(getFloatForFloat(var0), getFloatForFloat4(var1)), var2) + 4.0F;
   }
}
