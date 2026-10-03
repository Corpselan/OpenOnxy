package client.onyx.render;

import client.onyx.MinecraftAccess;
import client.onyx.render.font.Ayg;
import client.onyx.render.font.OpticalWeightRecord;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public final class Sampler0 implements MinecraftAccess {
   private static final int INT = 64;
   private final Cls cls3 = new Cls();
   private static final float FLOAT = 7.0F;
   private static client.onyx.render.extra.Cls cls;
   private static final float FLOAT2 = 0.72F;
   private static final float FLOAT3 = 0.99F;
   private static final float FLOAT4 = 40.0F;
   private static client.onyx.render.extra.Cls cls2;
   private static final float FLOAT5 = 8.0F;
   private static final float FLOAT6 = 0.5F;
   private static final int INT2 = -1;
   private static final FloatBuffer FLOAT_BUFFER;
   private final Cls cls5 = new Cls();
   private static final float FLOAT7 = 8.0F;
   private static final float FLOAT8 = 8.0F;
   private static final IntBuffer INT_BUFFER;
   private static client.onyx.render.extra.Cls cls4;
   private static final float[] FLOAT_ARRAY;
   private static final int INT3 = 7425;
   private static final float FLOAT9 = 0.70710677F;
   private static final long LONG = System.nanoTime();
   private final Deque<int[]> deque = new ArrayDeque();
   private static final int INT4 = 24;
   private static final int INT5 = 7424;
   private static final FloatBuffer FLOAT_BUFFER2;
   private float float_2 = 1.0F;
   private static final float FLOAT10 = 0.88F;
   private static final FloatBuffer FLOAT_BUFFER3;
   private float float_ = 1.0F;
   private static final float FLOAT11 = 6.2831855F;
   private boolean bool = true;

   public float getFloat18(String var1, float var2) {
      return client.onyx.render.font.Util.getAyg().getFloat4(var1) * (var2 / 16.0F);
   }

   public void handleOpticalWeightRecord2(OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      this.handleOpticalWeightRecord8(var1, var2, var3, var4 + var1.getFloat4() - 7.0F * var1.getFloat2(), var5);
   }

   private void handleString8(String var1, float var2, float var3, float var4, int var5) {
      this.run36();
      GlStateManager.translate(var2, var3, 0.0F);
      GlStateManager.scale(var4, var4, 1.0F);
      this.handleAyg(client.onyx.render.font.Util.getAyg(), var1, var5);
      this.run43();
   }

   public void run40() {
      float var2 = this.cls3.getFloat();
      this.float_2 = var2;
   }

   public void handleFloat17(float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      if (!(var6 <= 0.0F)) {
         float var9 = var6 * 2.0F;
         this.handleFloat14(var1, var2 + var7, var3, var4, var5, var5, var5, var5, var6, var9, var8, var8, var8, var8);
      }
   }

   public void handleOpticalWeightRecord9(OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      this.handleOpticalWeightRecord8(var1, var2, var3, this.getFloat19(var1, var4), var5);
   }

   public float getFloat19(OpticalWeightRecord var1, float var2) {
      return var2 + var1.getFloat4() / 2.0F - 7.0F * var1.getFloat2();
   }

   static {
      float[] var0 = new float[]{1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, -1.0F, 0.70710677F, 0.70710677F, 0.70710677F, -0.70710677F, -0.70710677F, 0.70710677F, -0.70710677F, -0.70710677F};
      FLOAT_ARRAY = var0;
      FLOAT_BUFFER3 = BufferUtils.createFloatBuffer(16);
      FLOAT_BUFFER2 = BufferUtils.createFloatBuffer(16);
      INT_BUFFER = BufferUtils.createIntBuffer(16);
      FLOAT_BUFFER = BufferUtils.createFloatBuffer(3);
   }

   public void handleFloat28(float var1, float var2, float var3, float var4, int var5) {
      this.handleFloat7(var1, var2, var3, var4, 0.0F, var5);
   }

   public void run43() {
      GlStateManager.popMatrix();
      float var2 = this.cls5.getFloat();
      this.float_ = var2;
   }

   public void handleResourceLocation2(ResourceLocation var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, int var11) {
      this.handleResourceLocation3(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, -1);
   }

   private int getInt15(int var1) {
      if (this.float_2 >= 1.0F) {
         return var1;
      } else {
         float var5 = (float)client.onyx.theme.impl.Util2.getIntForInt6(var1) / 255.0F * this.float_2;
         return client.onyx.theme.impl.Util2.getIntForInt3(var1, var5);
      }
   }

   public void handleOpticalWeightRecord7(OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      this.handleOpticalWeightRecord8(var1, var2, var3 - this.getFloat17(var1, var2), var4, var5);
   }

   private static void handleFloat8(float var0, float var1, float var2, float var3, int var4) {
      GL11.glColor4f((float)(var4 >> 16 & 255) / 255.0F, (float)(var4 >> 8 & 255) / 255.0F, (float)(var4 & 255) / 255.0F, (float)(var4 >>> 24) / 255.0F);
      GL11.glTexCoord2f(var0 - var2, var1 - var3);
      GL11.glVertex2f(var0, var1);
   }

   public void handleFloat10(float var1) {
      this.cls3.handleFloat(this.float_2);
      this.float_2 = Math.clamp(this.float_2 * var1, 0.0F, 1.0F);
   }

   public void run36() {
      this.cls5.handleFloat(this.float_);
      GlStateManager.pushMatrix();
   }

   public float getFloat17(OpticalWeightRecord var1, String var2) {
      return var1.getAyg().getFloat4(var2) * var1.getFloat2();
   }

   public void handleFloat24(float var1, float var2, float var3, float var4) {
      float var5 = var1 + var3;
      int[] var7 = getIntArrayForFloat(var1, var2, var5, var2 + var4);
      int[] var8;
      if ((var8 = (int[])this.deque.peek()) != null) {
         var7 = getIntArrayForIntArray(var7, var8);
      }

      this.deque.push(var7);
      handleIntArray(var7);
   }

   public void handleFloat21(float var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8, int var9) {
      this.handleFloat16(var1, var2, var3, var4, var5, var5, var5, var5, var6, var7, var8, var9);
   }

   private void handleFloat14(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, int var11, int var12, int var13, int var14) {
      if (!(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         float var15 = var3 / 2.0F;
         float var16 = var4 / 2.0F;
         float var17 = var1 + var15;
         float var18 = var2 + var16;
         float var19 = var1 - var10;
         float var20 = var2 - var10;
         var1 = var1 + var3 + var10;
         var2 = var2 + var4 + var10;
         int var21 = this.getInt15(var11);
         var11 = this.getInt15(var12);
         var12 = this.getInt15(var13);
         var13 = this.getInt15(var14);
         client.onyx.render.extra.Cls var22 = getCls7();
         GlStateManager.disableTexture2D();
         Sampler0 var10000;
         if (var22.isEnabled()) {
            var22.run3();
            var22.handleString2("uHalfExtents", var15, var16);
            var22.handleString4("uCornerRadii", client.onyx.theme.Util3.getFloatForFloat(var5, var3, var4), client.onyx.theme.Util3.getFloatForFloat(var6, var3, var4), client.onyx.theme.Util3.getFloatForFloat(var7, var3, var4), client.onyx.theme.Util3.getFloatForFloat(var8, var3, var4));
            var22.handleString("uSoftness", var9);
            var10000 = this;
            var22.handleString("uPixel", this.float_);
         } else {
            if (var9 != 0.0F) {
               return;
            }

            var10000 = this;
         }

         var10000.handleFloat19(var19, var20, var1, var2, var17, var18, var21, var11, var12, var13);
         client.onyx.render.extra.Cls.run2();
      }
   }

   public void handleOpticalWeightRecord3(OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      this.handleOpticalWeightRecord8(var1, var2, var3 - this.getFloat17(var1, var2) / 2.0F, var4, var5);
   }

   private static void handleIntArray(int[] var0) {
      GL11.glEnable(3089);
      GL11.glScissor(var0[0], var0[1], var0[2], var0[3]);
   }

   private static int[] getIntArrayForIntArray(int[] var0, int[] var1) {
      int var2 = Math.max(var0[0], var1[0]);
      int var3 = Math.max(var0[1], var1[1]);
      int var4 = Math.min(var0[0] + var0[2], var1[0] + var1[2]);
      int var8 = Math.min(var0[1] + var0[3], var1[1] + var1[3]);
      int[] var5 = new int[]{var2, var3, 0, 0};
      int var6 = Math.max(0, var4 - var2);
      var5[2] = var6;
      int var7 = Math.max(0, var8 - var3);
      var5[3] = var7;
      return var5;
   }

   private static float[] getFloatArrayForFloat(float var0, float var1) {
      FLOAT_BUFFER.clear();
      GLU.gluProject(var0, var1, 0.0F, FLOAT_BUFFER3, FLOAT_BUFFER2, INT_BUFFER, FLOAT_BUFFER);
      float[] var2 = new float[2];
      float var3 = FLOAT_BUFFER.get(0);
      var2[0] = var3;
      float var4 = FLOAT_BUFFER.get(1);
      var2[1] = var4;
      return var2;
   }

   private static client.onyx.render.extra.Cls getCls5() {
      if (cls2 == null) {
         cls2 = client.onyx.render.extra.Cls.getClsForString("onyx_clouds");
      }

      return cls2;
   }

   public void handleFloat11(float var1, float var2) {
      GlStateManager.translate(var1, var2, 0.0F);
   }

   public float getFloat16(OpticalWeightRecord var1, float var2) {
      return var2 + 7.0F * var1.getFloat2();
   }

   private static int getIntForInt4(int var0) {
      int var2 = 1 + FLOAT_ARRAY.length / 2;
      return client.onyx.theme.impl.Util2.getIntForInt3(var0, 1.0F - (float)Math.pow((double)(1.0F - (float)client.onyx.theme.impl.Util2.getIntForInt6(var0) / 255.0F), (double)(1.0F / (float)var2)));
   }

   public void handleOpticalWeightRecord8(OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      this.handleOpticalWeightRecord(var1, var2, var3, var4, this.getInt15(var5));
   }

   public void run44() {
      if (this.bool) {
         Util20.handleDefaultPointerEnum(Util20.DefaultPointerEnum.TEXT);
      }

   }

   public void handleItemStack(ItemStack var1, float var2, float var3) {
      if (var1 != null && var1.getItem() != null) {
         client.onyx.render.extra.Cls.run2();
         GlStateManager.enableTexture2D();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.enableDepth();
         GlStateManager.enableRescaleNormal();
         GlStateManager.enableAlpha();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         RenderHelper.enableGUIStandardItemLighting();
         GlStateManager.pushMatrix();
         GlStateManager.translate(var2, var3, 0.0F);
         MINECRAFT.getRenderItem().renderItemAndEffectIntoGUI(var1, 0, 0);
         GlStateManager.popMatrix();
         RenderHelper.disableStandardItemLighting();
         GlStateManager.disableRescaleNormal();
         GlStateManager.disableFog();
         GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
         GlStateManager.disableTexture2D();
         GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
         GL11.glTexEnvi(8960, 8704, 8448);
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 771);
         GlStateManager.disableAlpha();
         GlStateManager.disableDepth();
         GlStateManager.shadeModel(7425);
         GlStateManager.resetColor();
      }
   }

   private void handleAyg(Ayg var1, String var2, int var3) {
      if (!var2.isEmpty() && var3 >>> 24 != 0) {
         int var10000;
         int var4;
         for(var10000 = var4 = 0; var10000 < var2.length(); var10000 = var4) {
            var1.getU0V0Record2(var2.charAt(var4++));
         }

         if ((var4 = var1.getInt()) != -1) {
            GlStateManager.enableTexture2D();
            GlStateManager.bindTexture(var4);
            GL11.glColor4f((float)(var3 >> 16 & 255) / 255.0F, (float)(var3 >> 8 & 255) / 255.0F, (float)(var3 & 255) / 255.0F, (float)(var3 >>> 24) / 255.0F);
            GL11.glBegin(7);
            float var11 = 0.0F;

            for(var10000 = var4 = 0; var10000 < var2.length(); var10000 = var4) {
               Ayg.U0V0Record var10;
               if (!(var10 = var1.getU0V0Record2(var2.charAt(var4))).isEnabled()) {
                  float var6 = var11 + var10.bearingX();
                  float var7 = 7.0F + var10.bearingY();
                  float var8 = var6 + var10.width();
                  float var9 = var7 + var10.height();
                  GL11.glTexCoord2f(var10.u0(), var10.v0());
                  GL11.glVertex2f(var6, var7);
                  GL11.glTexCoord2f(var10.u0(), var10.v1());
                  GL11.glVertex2f(var6, var9);
                  GL11.glTexCoord2f(var10.u1(), var10.v1());
                  GL11.glVertex2f(var8, var9);
                  GL11.glTexCoord2f(var10.u1(), var10.v0());
                  GL11.glVertex2f(var8, var7);
               }

               ++var4;
               var11 += var10.advance();
            }

            GL11.glEnd();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.resetColor();
         }
      }
   }

   private static client.onyx.render.extra.Cls getCls7() {
      if (cls == null) {
         cls = client.onyx.render.extra.Cls.getClsForString("onyx_shape");
      }

      return cls;
   }

   private static int[] getIntArrayForFloat(float var0, float var1, float var2, float var3) {
      FLOAT_BUFFER3.clear();
      FLOAT_BUFFER2.clear();
      INT_BUFFER.clear();
      GL11.glGetFloat(2982, FLOAT_BUFFER3);
      GL11.glGetFloat(2983, FLOAT_BUFFER2);
      GL11.glGetInteger(2978, INT_BUFFER);
      float[] var8 = getFloatArrayForFloat(var0, var1);
      float[] var10 = getFloatArrayForFloat(var2, var3);
      float[] var10003 = var8;
      float[] var10004 = var8;
      float[] var10005 = var8;
      int var9 = Math.round(Math.min(var8[0], var10[0]));
      int var12 = Math.round(Math.min(var10005[1], var10[1]));
      int var4 = Math.round(Math.max(var10004[0], var10[0]));
      int var11 = Math.round(Math.max(var10003[1], var10[1]));
      int[] var5 = new int[]{var9, var12, 0, 0};
      int var6 = Math.max(0, var4 - var9);
      var5[2] = var6;
      int var7 = Math.max(0, var11 - var12);
      var5[3] = var7;
      return var5;
   }

   public Sampler0 getSampler0() {
      this.bool = false;
      return this;
   }

   public void handleFloat9(float var1, float var2, float var3, float var4, float var5, int var6) {
      float var7 = var3 - var1;
      float var8 = var4 - var2;
      float var10;
      if (!((var10 = (float)Math.sqrt((double)(var7 * var7 + var8 * var8))) < 1.0E-4F)) {
         this.run36();
         this.getCls32().getCls35((var1 + var3) / 2.0F, (var2 + var4) / 2.0F);
         this.getCls32().getCls32((float)Math.atan2((double)var8, (double)var7));
         this.handleFloat7(-var10 / 2.0F, -var5 / 2.0F, var10, var5, Float.MAX_VALUE, var6);
         this.run43();
      }
   }

   public void handleFloat27(float var1, float var2, float var3, float var4, float var5, int var6) {
      if (!((var5 = client.onyx.theme.Util3.getFloatForFloat(var5, var3, var4)) <= 0.0F)) {
         this.handleFloat14(var1 - var5, var2 - var5, var3 + var5 * 2.0F, var4 + var5 * 2.0F, var5 * 2.0F, var5 * 2.0F, var5 * 2.0F, var5 * 2.0F, -var5, 0.0F, var6, var6, var6, var6);
      }
   }

   public void handleResourceLocation(ResourceLocation var1, float var2, float var3, float var4) {
      this.handleResourceLocation2(var1, var2, var3, var4, var4, 8.0F, 8.0F, 8.0F, 8.0F, 64, 64);
      this.handleResourceLocation2(var1, var2, var3, var4, var4, 40.0F, 8.0F, 8.0F, 8.0F, 64, 64);
   }

   private void handleFloat19(float var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9, int var10) {
      GL11.glBegin(7);
      handleFloat8(var1, var2, var5, var6, var7);
      handleFloat8(var1, var4, var5, var6, var10);
      handleFloat8(var3, var4, var5, var6, var9);
      handleFloat8(var3, var2, var5, var6, var8);
      GL11.glEnd();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.resetColor();
   }

   public void run41() {
      if (this.bool) {
         Util20.handleDefaultPointerEnum(Util20.DefaultPointerEnum.POINTER);
      }

   }

   public void run37() {
   }

   private void handleFloat26(float var1, float var2, float var3, float var4, int var5) {
      GL11.glColor4f((float)((var5 = this.getInt15(var5)) >> 16 & 255) / 255.0F, (float)(var5 >> 8 & 255) / 255.0F, (float)(var5 & 255) / 255.0F, (float)(var5 >>> 24) / 255.0F);
      GL11.glTexCoord2f(var3, var4);
      GL11.glVertex2f(var1, var2);
   }

   public void run42() {
      boolean var10006 = true;
      this.float_ = 1.0F / (float)Math.max(1, (new ScaledResolution(MINECRAFT)).getScaleFactor());
      GlStateManager.disableLighting();
      GlStateManager.disableFog();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
      GL11.glTexEnvi(8960, 8704, 8448);
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 771);
      GlStateManager.disableAlpha();
      GlStateManager.disableDepth();
      GlStateManager.shadeModel(7425);
   }

   public String getString17(OpticalWeightRecord var1, String var2, float var3) {
      if (this.getFloat17(var1, var2) <= var3) {
         return var2;
      } else {
         String var4 = "...";
         var3 -= this.getFloat17(var1, var4);
         int var8 = 0;
         int var6 = var2.length();

         while(var8 < var6) {
            int var7 = (var8 + var6 + 1) / 2;
            if (this.getFloat17(var1, var2.substring(0, var7)) <= var3) {
               var8 = var7;
            } else {
               var6 = var7 - 1;
            }
         }

         StringBuilder var9 = new StringBuilder();
         String var10 = var2.substring(0, var8);
         return var9.insert(0, var10).append(var4).toString();
      }
   }

   public void handleString7(String var1, float var2, float var3, float var4, int var5, float var6) {
      Ayg var8 = client.onyx.render.font.Util.getAyg();
      var4 /= 16.0F;
      float var9 = var8.getFloat4(var1) * var4;
      var2 -= var9 / 2.0F;
      var3 += var4 * 1.0F;
      var5 = this.getInt15(var5);
      if (var6 <= 0.0F) {
         this.handleString8(var1, var2, var3, var4, var5);
      } else {
         var5 = getIntForInt4(var5);
         var6 /= 2.0F;

         int var10;
         for(int var10000 = var10 = 0; var10000 < FLOAT_ARRAY.length; var10000 = var10) {
            float var10002 = var2 + FLOAT_ARRAY[var10] * var6;
            float var10003 = var3 + FLOAT_ARRAY[var10 + 1] * var6;
            var10 += 2;
            this.handleString8(var1, var10002, var10003, var4, var5);
         }

         this.handleString8(var1, var2, var3, var4, var5);
      }
   }

   private void handleOpticalWeightRecord(OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      float var7 = var1.getFloat2();
      this.run36();
      GlStateManager.translate(var3, var4, 0.0F);
      GlStateManager.scale(var7, var7, 1.0F);
      this.handleAyg(var1.getAyg(), var2, var5);
      this.run43();
   }

   public boolean isFloat2(float var1, float var2, float var3, float var4, float var5, int var6) {
      int var7 = Util3.getInt();
      client.onyx.render.extra.Cls var8 = getCls6();
      if (var7 != -1 && var8.isEnabled()) {
         int[] var9 = getIntArrayForFloat(var1, var2, var1 + var3, var2 + var4);
         Util3.handleInt7(var9[0], var9[1], var9[2], var9[3]);
         GlStateManager.enableTexture2D();
         GlStateManager.bindTexture(var7);
         var8.run3();
         var8.handleString5("Sampler0", 0);
         var8.handleString2("uHalfExtents", var3 / 2.0F, var4 / 2.0F);
         var8.handleString4("uCornerRadii", client.onyx.theme.Util3.getFloatForFloat(var5, var3, var4), client.onyx.theme.Util3.getFloatForFloat(var5, var3, var4), client.onyx.theme.Util3.getFloatForFloat(var5, var3, var4), client.onyx.theme.Util3.getFloatForFloat(var5, var3, var4));
         var8.handleString2("uResolution", (float)MINECRAFT.displayWidth, (float)MINECRAFT.displayHeight);
         var8.handleString("uPixel", this.float_);
         var8.handleString("uTint", (float)client.onyx.theme.impl.Util2.getIntForInt6(var6) / 255.0F * 0.88F);
         int var10 = this.getInt15(var6 | -16777216);
         this.handleFloat19(var1, var2, var1 + var3, var2 + var4, var1 + var3 / 2.0F, var2 + var4 / 2.0F, var10, var10, var10, var10);
         client.onyx.render.extra.Cls.run2();
         return true;
      } else {
         this.handleFloat7(var1, var2, var3, var4, var5, var6);
         return false;
      }
   }

   public void handleOpticalWeightRecord5(OpticalWeightRecord var1, String var2, float var3, float var4, int var5, float var6) {
      if (!(var6 <= 0.0F) && !var2.isEmpty() && var5 >>> 24 != 0) {
         var5 = getIntForInt4(this.getInt15(var5));

         int var7;
         for(int var10000 = var7 = 0; var10000 < FLOAT_ARRAY.length; var10000 = var7) {
            float var10003 = var3 + FLOAT_ARRAY[var7] * var6;
            float var10005 = FLOAT_ARRAY[var7 + 1] * var6;
            var7 += 2;
            this.handleOpticalWeightRecord(var1, var2, var10003, var4 + var10005, var5);
         }

         this.handleOpticalWeightRecord(var1, var2, var3, var4, var5);
      }
   }

   public void run35() {
   }

   public void handleEntityLivingBase(EntityLivingBase var1, float var2, float var3, int var4) {
      if (var1 != null && var4 > 0) {
         client.onyx.render.extra.Cls.run2();
         GlStateManager.enableTexture2D();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.enableDepth();
         GlStateManager.enableAlpha();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.pushMatrix();
         GlStateManager.translate(var2, var3, 0.0F);
         GuiInventory.drawEntityOnScreen(0, 0, var4, 0.0F, 0.0F, var1);
         GlStateManager.popMatrix();
         RenderHelper.disableStandardItemLighting();
         GlStateManager.disableRescaleNormal();
         GlStateManager.disableColorMaterial();
         GlStateManager.disableFog();
         GlStateManager.disableLighting();
         GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
         GlStateManager.disableTexture2D();
         GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
         GL11.glTexEnvi(8960, 8704, 8448);
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 771);
         GlStateManager.disableAlpha();
         GlStateManager.disableDepth();
         GlStateManager.shadeModel(7425);
         GlStateManager.resetColor();
      }
   }

   public void handleOpticalWeightRecord6(OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      this.handleOpticalWeightRecord7(var1, var2, var3, this.getFloat19(var1, var4), var5);
   }

   public void handleString6(String var1, float var2, float var3, float var4, int var5) {
      this.handleString7(var1, var2, var3, var4, var5, 0.0F);
   }

   public void handleResourceLocation3(ResourceLocation var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, int var11, int var12) {
      this.handleResourceLocation4(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, PixelsSmoothEnum.PIXELS);
   }

   public void handleFloat7(float var1, float var2, float var3, float var4, float var5, int var6) {
      this.handleFloat15(var1, var2, var3, var4, var5, var5, var5, var5, var6);
   }

   private static client.onyx.render.extra.Cls getCls6() {
      if (cls4 == null) {
         cls4 = client.onyx.render.extra.Cls.getClsForString("onyx_frost");
      }

      return cls4;
   }

   public Cls3 getCls32() {
      return Cls3.CLS3;
   }

   public void handleFloat15(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      this.handleFloat16(var1, var2, var3, var4, var5, var6, var7, var8, var9, var9, var9, var9);
   }

   public void run39() {
      Sampler0 var10000 = this;

      while(!var10000.deque.isEmpty()) {
         var10000 = this;
         this.run38();
      }

      client.onyx.render.extra.Cls.run2();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.resetColor();
      GlStateManager.shadeModel(7424);
      GlStateManager.enableTexture2D();
      GlStateManager.enableDepth();
      GlStateManager.enableAlpha();
      GlStateManager.disableBlend();
      if (this.bool) {
         Util20.run2();
      }

   }

   public void handleOpticalWeightRecord4(OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      this.handleOpticalWeightRecord3(var1, var2, var3, this.getFloat19(var1, var4), var5);
   }

   public void handleFloat25(float var1, float var2, float var3, float var4, float var5, int var6) {
      float var8;
      if (!((var8 = client.onyx.theme.Util5.getFloatForInt(var6)) <= 0.0F)) {
         int var7 = client.onyx.theme.Util4.getPrimaryOnPrimaryRecord().shadow();
         this.handleFloat17(var1, var2, var3, var4, var5, var8, 0.0F, client.onyx.theme.Util4.getIntForInt2(var7, 0.055F));
         this.handleFloat17(var1, var2, var3, var4, var5, var8 * 1.5F, var8 * 0.5F, client.onyx.theme.Util4.getIntForInt2(var7, 0.075F));
      }
   }

   public void run38() {
      if (!this.deque.isEmpty()) {
         this.deque.pop();
         int[] var2;
         if ((var2 = (int[])this.deque.peek()) == null) {
            GL11.glDisable(3089);
         } else {
            handleIntArray(var2);
         }
      }
   }

   public void handleResourceLocation4(ResourceLocation var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, int var11, int var12, PixelsSmoothEnum var13) {
      var12 = this.getInt15(var12);
      MINECRAFT.getTextureManager().bindTexture(var1);
      GlStateManager.enableTexture2D();
      int var17 = var13.getInt();
      GL11.glColor4f((float)(var12 >> 16 & 255) / 255.0F, (float)(var12 >> 8 & 255) / 255.0F, (float)(var12 & 255) / 255.0F, (float)(var12 >>> 24) / 255.0F);
      float var18 = var8 < (float)var10 ? var13.getFloat() / (float)var10 : 0.0F;
      float var14 = var9 < (float)var11 ? var13.getFloat() / (float)var11 : 0.0F;
      float var15 = var6 / (float)var10 + var18;
      float var16 = var7 / (float)var11 + var14;
      var6 = (var6 + var8) / (float)var10 - var18;
      var7 = (var7 + var9) / (float)var11 - var14;
      GL11.glBegin(7);
      GL11.glTexCoord2f(var15, var16);
      GL11.glVertex2f(var2, var3);
      GL11.glTexCoord2f(var15, var7);
      GL11.glVertex2f(var2, var3 + var5);
      GL11.glTexCoord2f(var6, var7);
      GL11.glVertex2f(var2 + var4, var3 + var5);
      GL11.glTexCoord2f(var6, var16);
      GL11.glVertex2f(var2 + var4, var3);
      GL11.glEnd();
      var13.handleInt(var17);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.resetColor();
   }

   public void handleFloat22(float var1, float var2, float var3, float var4, int var5) {
      this.handleFloat18(var1 - var3, var2 - var3, var3 * 2.0F, var3 * 2.0F, Float.MAX_VALUE, var4, var5);
   }

   public void handleFloat23(float var1, float var2, float var3, int var4) {
      this.handleFloat7(var1 - var3, var2 - var3, var3 * 2.0F, var3 * 2.0F, Float.MAX_VALUE, var4);
   }

   public void handleFloat16(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, int var10, int var11, int var12) {
      this.handleFloat14(var1, var2, var3, var4, var5, var6, var7, var8, 0.0F, 0.0F, var9, var10, var11, var12);
   }

   public void handleFloat12(float var1, float var2, float var3) {
      GlStateManager.translate(var2, var3, 0.0F);
      GlStateManager.scale(var1, var1, 1.0F);
      GlStateManager.translate(-var2, -var3, 0.0F);
      if (var1 > 0.0F) {
         float var5 = this.float_ / var1;
         this.float_ = var5;
      }

   }

   public void handleFloat13(float var1, float var2, float var3, float var4) {
      if (!(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         client.onyx.theme.impl.Cls var10000 = client.onyx.theme.impl.Cls.getClsForInt(client.onyx.theme.Util4.getInt());
         double var6 = var10000.getDouble();
         double var8 = var10000.getDouble2() * 0.6D;
         int var5 = client.onyx.theme.impl.Cls2.getCls2ForDouble(var6 - 25.0D, var8).getInt2(15);
         int var10 = client.onyx.theme.impl.Cls2.getCls2ForDouble(var6 + 20.0D, var8).getInt2(27);
         int var11 = client.onyx.theme.impl.Cls2.getCls2ForDouble(var6 + 60.0D, var8).getInt2(41);
         int var12 = client.onyx.theme.impl.Cls2.getCls2ForDouble(var6 - 45.0D, var8).getInt2(57);
         client.onyx.render.extra.Cls var7;
         if (!(var7 = getCls5()).isEnabled()) {
            this.handleFloat21(var1, var2, var3, var4, 0.0F, var10, var11, var5, var5);
         } else {
            GlStateManager.disableTexture2D();
            var7.run3();
            var7.handleString("uAspect", var3 / var4);
            var7.handleString("uTime", (float)(System.nanoTime() - LONG) / 1.0E9F);
            var7.handleString7("uGlow", var12);
            var7.handleString7("uMid", var10);
            var7.handleString7("uAccent", var11);
            var7.handleString7("uDeep", var5);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glBegin(7);
            GL11.glTexCoord2f(0.0F, 0.0F);
            GL11.glVertex2f(var1, var2);
            GL11.glTexCoord2f(0.0F, 1.0F);
            GL11.glVertex2f(var1, var2 + var4);
            GL11.glTexCoord2f(1.0F, 1.0F);
            GL11.glVertex2f(var1 + var3, var2 + var4);
            GL11.glTexCoord2f(1.0F, 0.0F);
            GL11.glVertex2f(var1 + var3, var2);
            GL11.glEnd();
            client.onyx.render.extra.Cls.run2();
            GlStateManager.resetColor();
         }
      }
   }

   public void handleResourceLocation5(ResourceLocation var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8, int var9) {
      MINECRAFT.getTextureManager().bindTexture(var1);
      GlStateManager.enableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.shadeModel(7425);
      GlStateManager.disableCull();
      GlStateManager.disableAlpha();
      GlStateManager.depthMask(false);
      GlStateManager.tryBlendFuncSeparate(770, 1, 0, 1);
      int var10 = PixelsSmoothEnum.MINIFIED.getInt();
      GL11.glBegin(7);
      this.handleFloat26(var2, var3, 0.0F, 0.99F, var6);
      this.handleFloat26(var2, var3 + var5, 0.99F, 0.99F, var7);
      this.handleFloat26(var2 + var4, var3 + var5, 0.99F, 0.0F, var8);
      this.handleFloat26(var2 + var4, var3, 0.0F, 0.0F, var9);
      GL11.glEnd();
      PixelsSmoothEnum.MINIFIED.handleInt(var10);
      GlStateManager.depthMask(true);
      GlStateManager.enableAlpha();
      GlStateManager.enableCull();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.resetColor();
   }

   public void handleFloat18(float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      this.handleFloat14(var1, var2, var3, var4, var5, var5, var5, var5, -var6, 0.0F, var7, var7, var7, var7);
   }

   public void handleFloat20(float var1, float var2, float var3, float var4, float var5, int var6) {
      var5 *= 6.2831855F;

      int var7;
      for(int var10000 = var7 = 0; var10000 < 24; var10000 = var7) {
         float var9 = var5 + 4.523894F * ((float)var7 / 24.0F);
         float var10001 = var1 + (float)Math.cos((double)var9) * var3;
         float var10002 = var2 + (float)Math.sin((double)var9) * var3;
         ++var7;
         this.handleFloat23(var10001, var10002, var4 / 2.0F, var6);
      }

   }
}
