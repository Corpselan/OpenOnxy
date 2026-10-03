package client.onyx.render;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.module.render.HandModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public final class Util5 implements MinecraftAccess {
   private static client.onyx.render.extra.Cls cls;
   private static client.onyx.render.extra.Cls cls2;
   private static float float_;
   private static long long_;
   private static float float_2;
   private static final int INT = 36;
   private static client.onyx.render.extra.Cls cls3;
   private static client.onyx.render.extra.Cls cls4;
   private static boolean bool;
   private static final float FLOAT = 3.0F;
   private static float float_3;
   private static final float FLOAT2 = 0.25F;
   private static float float_4;
   private static final long LONG = System.nanoTime();
   private static float float_5;
   private static boolean bool2;
   private static final Cls2 CLS26 = new Cls2(false);
   private static float float_7;
   private static final Cls2 CLS22 = new Cls2(false);
   private static final Cls2 CLS27 = new Cls2(false);
   private static final Cls2 CLS24 = new Cls2(false);
   private static client.onyx.render.extra.Cls cls5;
   private static final float FLOAT3 = 2.0F;
   private static boolean bool3;
   private static final double DOUBLE = 3600.0;
   private static client.onyx.render.extra.Cls cls6;
   private static float float_8;
   private static client.onyx.render.extra.Cls cls7;
   private static float float_9;
   private static final Cls2 CLS25 = new Cls2(false);
   private static final Cls2 CLS23 = new Cls2(false);
   private static final Cls2 CLS2 = new Cls2(false);
   private static long long_2;
   private static float float_10 = 0.016666668F;
   private static float float_6 = 1.0F;
   private static final int INT2 = 64;
   private static final long LONG2 = 250L;
   private static Vec3 vec3 = new Vec3(0.0, 0.0, 0.0);

   private static void handleCls22(Cls2 var0, Cls2 var1) {
      var1.run3();
      Util.handleInt10(0, var0.getInt3());
      cls2.run3();
      cls2.handleString5("Sampler0", 0);
      cls2.handleString2("uSourceSize", var0.getInt2(), var0.getInt());
      cls2.handleString2("uOutSize", var1.getInt2(), var1.getInt());
      Util.run24();
   }

   static void run45() {
      long_ = 0L;
      long_2 = 0L;
      bool = false;
      vec3 = new Vec3(0.0, 0.0, 0.0);
      float_3 = 0.0F;
      float_5 = 0.0F;
      float_9 = 0.0F;
      CLS26.run2();
      CLS22.run2();
      CLS27.run2();
      CLS24.run2();
      CLS25.run2();
      CLS23.run2();
      CLS2.run2();
   }

   private static boolean isEnabled42() {
      if (!bool2) {
         bool2 = true;
         cls3 = client.onyx.render.extra.Cls.getClsForString2("onyx_trail_mask", "onyx_post", "onyx_trail_mask");
         cls2 = client.onyx.render.extra.Cls.getClsForString2("onyx_trail_near", "onyx_post", "onyx_trail_near");
         cls4 = client.onyx.render.extra.Cls.getClsForString2("onyx_trail_step", "onyx_post", "onyx_trail_step");
         cls7 = client.onyx.render.extra.Cls.getClsForString2("onyx_trail_down", "onyx_post", "onyx_trail_down");
         cls = client.onyx.render.extra.Cls.getClsForString2("onyx_trail_up", "onyx_post", "onyx_trail_up");
         cls6 = client.onyx.render.extra.Cls.getClsForString2("onyx_trail_smoke", "onyx_post", "onyx_trail_smoke");
         cls5 = client.onyx.render.extra.Cls.getClsForString2("onyx_hand_blit", "onyx_post", "onyx_hand_blit");
      }

      return isCls(cls3) && isCls(cls2) && isCls(cls4) && isCls(cls7) && isCls(cls) && isCls(cls6) && isCls(cls5);
   }

   private static void handleCls3(client.onyx.render.extra.Cls var0, Cls2 var1, Cls2 var2) {
      var2.run3();
      Util.handleInt10(0, var1.getInt3());
      var0.run3();
      var0.handleString5("Sampler0", 0);
      Util.run24();
   }

   private static void handleMinecraft2(Minecraft var0, float var1) {
      float_ = 0.0F;
      float_2 = 0.0F;
      if (var0.getRenderViewEntity() != null && Util8.isEnabled44()) {
         float var2 = var0.getRenderViewEntity().prevRotationYaw + (var0.getRenderViewEntity().rotationYaw - var0.getRenderViewEntity().prevRotationYaw) * var1;
         var1 = var0.getRenderViewEntity().prevRotationPitch + (var0.getRenderViewEntity().rotationPitch - var0.getRenderViewEntity().prevRotationPitch) * var1;
         Vec3 var3 = Util8.getVec313();
         if (bool) {
            float var4 = Util8.getFloat22();
            float var5 = Util8.getFloat21();
            float_ = (float)Math.toRadians(MathHelper.wrapAngleTo180_float(var2 - float_8)) * var4 * 0.5F;
            float_2 = -((float)Math.toRadians(var1 - float_4)) * var5 * 0.5F;
            Vec3 var6 = var3.subtract(vec3);
            Vec3 var7 = getVec3ForFloat2(var2, var1);
            Vec3 var8 = getVec3ForFloat(var2);
            float_ = float_ + (float)var6.dotProduct(var8) * var4 * 0.5F / 2.0F;
            float_2 = float_2 + (float)var6.dotProduct(var8.crossProduct(var7)) * var5 * 0.5F / 2.0F;
            float_ = Math.clamp(float_, -0.25F, 0.25F);
            float_2 = Math.clamp(float_2, -0.25F, 0.25F);
         }

         float_8 = var2;
         float_4 = var1;
         vec3 = var3;
         bool = true;
      } else {
         bool = false;
      }
   }

   private static boolean isCls(client.onyx.render.extra.Cls var0) {
      return var0 != null && var0.isEnabled();
   }

   private static void handleCls4(client.onyx.render.extra.Cls var0, Cls2 var1, Cls2 var2, float var3) {
      var2.run3();
      Util.handleInt10(0, var1.getInt3());
      var0.run3();
      var0.handleString5("Sampler0", 0);
      var0.handleString2("uSourceSize", var1.getInt2(), var1.getInt());
      var0.handleString("uBlur", var3);
      Util.run24();
   }

   static void handleCls23(Cls2 var0, Framebuffer var1, HandModule.TrailBooleanSetting var2, int var3, float var4, int var5, int var6, float var7) {
      if (isEnabled42()) {
         Minecraft var8 = MinecraftAccess.MINECRAFT;
         long var9;
         boolean var12 = (var9 = System.currentTimeMillis()) - long_ > 250L;
         long_ = var9;
         handleMinecraft(var8, var7);
         int var14 = var0.getInt2();
         int var15 = var0.getInt();
         var12 = var12
            | CLS26.isInt(var5, var6)
            | CLS22.isInt(var14, var15)
            | CLS27.isInt(64, 36)
            | CLS24.isInt(var14, var15)
            | CLS25.isInt(var14, var15)
            | CLS23.isInt(var14, var15)
            | CLS2.isInt(var14, var15);
         Util.handleInt10(0, CLS26.getInt3());
         GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, var5, var6);
         Util.run25();
         handleCls3(cls3, var0, CLS22);
         handleCls22(CLS22, CLS27);
         handleTrailBooleanSetting(var2, var3, var4, var12, var5, var6);
         handleCls3(cls5, CLS25, CLS24);
         float var13 = Math.max(1.0F, 1.0F + var2.valueSettingSub10.getFloat5()) * var2.getFloat40();
         handleCls4(cls7, CLS25, CLS23, var13);
         handleCls4(cls7, CLS23, CLS2, var13 * 2.0F);
         handleCls4(cls, CLS2, CLS23, var13 * 2.0F);
         handleCls4(cls, CLS23, CLS2, var13);
         handleTrailBooleanSetting2(var2, var1, var5, var6);
         Util.handleFramebuffer(var1);
      }
   }

   private static void handleTrailBooleanSetting2(HandModule.TrailBooleanSetting var0, Framebuffer var1, int var2, int var3) {
      var1.bindFramebuffer(false);
      GlStateManager.viewport(0, 0, var2, var3);
      Util.handleInt10(0, CLS26.getInt3());
      Util.handleInt10(1, CLS2.getInt3());
      Util.handleInt10(2, CLS22.getInt3());
      cls6.run3();
      cls6.handleString5("SceneSampler", 0);
      cls6.handleString5("SmokeSampler", 1);
      cls6.handleString5("MaskSampler", 2);
      float var4 = var0.valueSettingSub108.getFloat5();
      if (isEnabled41()) {
         var4 *= 0.4F;
      } else if (bool3) {
         var4 *= 0.55F;
      }

      cls6.handleString2("uMaskSize", CLS22.getInt2(), CLS22.getInt());
      cls6.handleString4("uSmokeParams", var0.valueSettingSub106.getFloat5(), var0.valueSettingSub105.getFloat5(), var0.valueSettingSub102.getFloat5(), var4);
      cls6.handleString4("uSmokeExtra", float_3, 0.0F, 0.0F, 0.0F);
      Util.run24();
   }

   private static Vec3 getVec3ForFloat2(float var0, float var1) {
      double var2 = Math.toRadians(var0);
      double var4;
      double var6 = Math.cos(var4 = Math.toRadians(var1));
      return new Vec3(-Math.sin(var2) * var6, -Math.sin(var4), Math.cos(var2) * var6);
   }

   private Util5() {
   }

   private static float getFloat20() {
      return (float)((System.nanoTime() - LONG) / 1.0E9 % 3600.0);
   }

   private static void handleTrailBooleanSetting(HandModule.TrailBooleanSetting var0, int var1, float var2, boolean var3, int var4, int var5) {
      CLS25.run3();
      Util.handleInt10(0, CLS24.getInt3());
      Util.handleInt10(1, CLS26.getInt3());
      Util.handleInt10(2, CLS22.getInt3());
      Util.handleInt10(3, CLS27.getInt3());
      cls4.run3();
      cls4.handleString5("PrevSampler", 0);
      cls4.handleString5("SceneSampler", 1);
      cls4.handleString5("MaskSampler", 2);
      cls4.handleString5("NearSampler", 3);
      cls4.handleString2("uOutSize", CLS25.getInt2(), CLS25.getInt());
      boolean var9 = isEnabled41();
      float var10 = var0.valueSettingSub103.getFloat5();
      float var6 = var0.valueSettingSub108.getFloat5();
      float var8 = var0.valueSettingSub104.getFloat5();
      if (var9) {
         var10 = Math.min(var10, 0.72F);
         var6 *= 0.4F;
         var8 *= 0.4F;
      } else if (bool3) {
         var10 = Math.min(var10, 0.8F);
         var6 *= 0.55F;
         var8 *= 0.55F;
      }

      cls4.handleString4("uTrailMotion", getFloat20(), var0.valueSettingSub106.getFloat5(), var0.valueSettingSub109.getFloat5(), var8);
      cls4.handleString4("uTrailShape", var0.valueSettingSub107.getFloat5(), var0.valueSettingSub10.getFloat5(), var6, float_3);
      cls4.handleString4("uTrailSwing", var10, float_5, float_6, float_7);
      float var10004;
      float var10005;
      if (var3) {
         var10004 = 1.0F;
         var10005 = var2;
      } else {
         var10004 = 0.0F;
         var10005 = var2;
      }

      cls4.handleString4("uTrailCamera", float_, float_2, var10004, var10005);
      cls4.handleString4("uTrailTiming", float_10, var0.getFloat40(), float_9, 0.0F);
      cls4.handleString4(
         "uGlowColor",
         client.onyx.theme.impl.Util2.getIntForInt7(var1) / 255.0F,
         client.onyx.theme.impl.Util2.getIntForInt(var1) / 255.0F,
         client.onyx.theme.impl.Util2.getIntForInt2(var1) / 255.0F,
         1.0F
      );
      Util.run24();
      Util.handleInt10(3, 0);
   }

   private static void handleMinecraft(Minecraft var0, float var1) {
      long var2 = System.currentTimeMillis();
      float var12 = long_2 > 0L ? (float)(var2 - long_2) / 1000.0F : 0.016666668F;
      long_2 = var2;
      if (var12 <= 0.0F || var12 > 0.05F) {
         var12 = float_10;
      }

      var12 = Math.clamp(var12, 0.0069444445F, 0.033333335F);
      float_10 = float_10 + (var12 - float_10) * 0.1F;
      var12 = float_10;
      EntityPlayerSP var13 = var0.thePlayer;
      boolean var3 = var0.thePlayer != null && var13.isBlocking() && var13.getHeldItem() != null && var13.getHeldItem().getItem() instanceof ItemSword;
      boolean var6 = var13 != null && var13.isSwingInProgress && !var3;
      bool3 = var6;
      float var7 = var13 != null ? Math.clamp(var13.getSwingProgress(var1), 0.0F, 1.0F) : 0.0F;
      float var8 = isEnabled41() ? 0.3F : 0.5F;
      float var9 = var13 == null
         ? 0.0F
         : (float)Math.min(1.0, Math.sqrt(var13.motionX * var13.motionX + var13.motionY * var13.motionY + var13.motionZ * var13.motionZ) * 2.2);
      float var10 = var6 ? (1.0F - Math.min(1.0F, var7)) * var8 : 0.0F;
      float var11 = var13 != null && var13.isUsingItem() && !var3 ? 0.55F + Math.min(0.45F, var13.getItemInUseDuration() * 0.06F) : 0.0F;
      float var5 = Math.max(Math.max(var10, var11), var9);
      float_3 = float_3 + (var5 - float_3) * (1.0F - (float)Math.exp(-var12 * 6.0));
      float_7 = var13 == null ? 0.0F : 1.0F;
      Minecraft var10000;
      if (var6) {
         float_9 = var7;
         float_5 = (float)Math.sin(Math.PI * var7) * var8;
         float_6 = 1.0F;
         var10000 = var0;
      } else {
         float_5 = Math.max(0.0F, float_5 - var12 * 3.0F);
         var10000 = var0;
      }

      handleMinecraft2(var10000, var1);
   }

   private static boolean isEnabled41() {
      return OnyxClient.cls != null && OnyxClient.cls.killAuraModule.isEnabled55() && OnyxClient.cls.killAuraModule.getEntityLivingBase3() != null;
   }

   private static Vec3 getVec3ForFloat(float var0) {
      double var1 = Math.toRadians(var0);
      return new Vec3(-Math.cos(var1), 0.0, -Math.sin(var1));
   }
}
