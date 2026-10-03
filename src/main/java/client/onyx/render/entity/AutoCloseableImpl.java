package client.onyx.render.entity;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.render.extra.Cls;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public final class AutoCloseableImpl implements AutoCloseable, MinecraftAccess {
   private static final float FLOAT = 0.84F;
   private static final float FLOAT2 = 1.22F;
   private Cls cls;
   private static final float FLOAT3 = 1.0F;
   public static final int INT = 220;
   private static final float FLOAT4 = 0.96F;
   private boolean bool;
   private boolean bool2 = true;
   private static final long LONG = 180000000000L;

   private void handleList8(List<PositionBodyYawRecord> var1, ShaderFillScaleRecord var2, Vec3 var3, int var4, int var5) {
      int var6 = getIntForInt20(var4, var5);
      var4 = getIntForInt20(var4, (int)(var5 * 0.45F));
      boolean var10 = var2.shaderFill() && this.isEnabled48();
      Tessellator var7;
      WorldRenderer var8 = (var7 = Tessellator.getInstance()).getWorldRenderer();
      var8.begin(4, DefaultVertexFormats.POSITION_COLOR);
      final var var4_c = var4;
      handleList10(var1, var2, var3, (var3x, var4x, var5x) -> handleWorldRenderer14(var8, var4x, var5x, 1.0F, var3x.shape().getXYRecordArray(), var6, var4_c));
      var7.draw();
      if (var10) {
         Cls.run2();
      }
   }

   private static int getIntForInt19(int var0, int var1, float var2) {
      int var3 = getIntForInt18(var0, 24) + (int)((getIntForInt18(var1, 24) - getIntForInt18(var0, 24)) * var2);
      int var4 = getIntForInt18(var0, 16) + (int)((getIntForInt18(var1, 16) - getIntForInt18(var0, 16)) * var2);
      int var5 = getIntForInt18(var0, 8) + (int)((getIntForInt18(var1, 8) - getIntForInt18(var0, 8)) * var2);
      var1 = getIntForInt18(var0, 0) + (int)((getIntForInt18(var1, 0) - getIntForInt18(var0, 0)) * var2);
      return var3 << 24 | var4 << 16 | var5 << 8 | var1;
   }

   private void handleList11(List<PositionBodyYawRecord> var1, ShaderFillScaleRecord var2, Vec3 var3, int var4, int var5, int var6) {
      int var7 = getIntForInt20(var4, (int)(var6 * 0.22F));
      var4 = getIntForInt20(var4, 0);
      var6 = getIntForInt20(var5, (int)(var6 * 0.26F));
      var5 = getIntForInt20(var5, 0);
      Tessellator var8;
      WorldRenderer var9 = (var8 = Tessellator.getInstance()).getWorldRenderer();
      var9.begin(4, DefaultVertexFormats.POSITION_COLOR);
      final var var6_c = var6;
      final var var5_c = var5;
      final var var4_c = var4;
      handleList10(var1, var2, var3, (var5x, var6x, var7x) -> {
         XYRecord[] var8x = var5x.shape().getXYRecordArray();
         handleWorldRenderer14(var9, var6x, var7x, 1.22F, var8x, var7, var4_c);
         handleWorldRenderer14(var9, var6x, var7x, 0.84F, var8x, var6_c, var5_c);
      });
      var8.draw();
   }

   @Override
   public void close() {
      this.bool2 = true;
      this.bool = false;
      this.cls = null;
   }

   private static int getIntForInt20(int var0, int var1) {
      return Math.clamp((long)var1, 0, 255) << 24 | var0 & 16777215;
   }

   private static int getIntForInt17(int var0, float var1) {
      return getIntForInt20(var0, Math.clamp((long)((int)(getIntForInt16(var0) * var1)), 0, 255));
   }

   private void handleList9(List<PositionBodyYawRecord> var1, ShaderFillScaleRecord var2, Vec3 var3, int var4, int var5, int var6) {
      var4 = getIntForInt20(var4, (int)Math.min(255.0F, var6 * 0.95F));
      var5 = getIntForInt20(var5, (int)(var6 * 0.2F));
      float var9 = var2.opacity();
      int var11 = Math.round(8.0F * var9);
      int var15 = (int)(getIntForInt16(var5) * 0.75F);
      int var16 = Math.max(var11, var15);
      var6 = getIntForInt20(var5, var16);
      Tessellator var7;
      WorldRenderer var8 = (var7 = Tessellator.getInstance()).getWorldRenderer();
      GL11.glLineWidth(2.2F);
      var8.begin(1, DefaultVertexFormats.POSITION_COLOR);
      final var var5_c = var5;
      final var var6_c = var6;
      final var var4_c = var4;
      handleList10(var1, var2, var3, (var4x, var5x, var6x) -> {
         var var4_l = var4_c;
         AngelicDragonEnum var16x;
         XYRecord[] var7x = (var16x = var4x.shape()).getXYRecordArray();

         int var8x;
         for (int var10000 = var8x = 0; var10000 < var7x.length; var10000 = var8x) {
            XYRecord var9x = var7x[var8x];
            int var11x = var7x.length;
            int var12 = (var8x + 1) % var11x;
            XYRecord var10 = var7x[var12];
            handleWorldRenderer13(var8, var5x, var6x * var9x.x() * 1.0F, var9x.y() * 1.0F, var4_l);
            float var10002 = var6x * var10.x() * 1.0F;
            float var10003 = var10.y();
            var8x++;
            handleWorldRenderer13(var8, var5x, var10002, var10003 * 1.0F, var4_l);
         }

         int[] var17;
         int var18x = (var17 = var16x.getIntArray()).length;

         int var19x;
         for (int var20x = var19x = 0; var20x < var18x; var20x = ++var19x) {
            if ((var4_l = var17[var19x]) < var7x.length) {
               XYRecord var15x = var7x[var4_l];
               handleWorldRenderer13(var8, var5x, 0.0F, 0.0F, var6_c);
               handleWorldRenderer13(var8, var5x, var6x * var15x.x() * 0.96F, var15x.y() * 0.96F, getIntForInt17(var5_c, var15x.alphaMul()));
            }
         }
      });
      var7.draw();
      GL11.glLineWidth(1.0F);
   }

   private static void handleBool14(boolean var0) {
      GlStateManager.pushMatrix();
      GlStateManager.disableTexture2D();
      GlStateManager.disableLighting();
      GlStateManager.disableFog();
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.disableCull();
      GlStateManager.depthMask(false);
      GlStateManager.shadeModel(7425);
      if (var0) {
         GlStateManager.disableDepth();
      }

      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
   }

   private static Matrix4f getMatrix4fForMatrix4f2(Matrix4f var0, PositionBodyYawRecord var1, float var2) {
      PreTranslateYPreTranslateZRecord var3 = var1.pose();
      Matrix4f var5 = new Matrix4f(var0);
      var5.translate(new Vector3f(var2 * var3.sideOffset(), 0.0F, var3.sideZOffset()));
      var5.rotate((float)Math.toRadians(var2 * var1.open()), new Vector3f(0.0F, 1.0F, 0.0F));
      var5.rotate((float)Math.toRadians(var2 * var3.sideRoll()), new Vector3f(0.0F, 0.0F, 1.0F));
      var5.rotate((float)Math.toRadians(var3.sidePitch()), new Vector3f(1.0F, 0.0F, 0.0F));
      return var5;
   }

   private static void handleWorldRenderer14(WorldRenderer var0, Matrix4f var1, float var2, float var3, XYRecord[] var4, int var5, int var6) {
      int var7;
      for (int var10000 = var7 = 0; var10000 < var4.length; var10000 = var7) {
         XYRecord var8 = var4[var7];
         int var11 = var4.length;
         int var12 = (var7 + 1) % var11;
         XYRecord var10 = var4[var12];
         handleWorldRenderer13(var0, var1, 0.0F, 0.0F, var5);
         handleWorldRenderer13(var0, var1, var2 * var8.x() * var3, var8.y() * var3, getIntForInt17(var6, var8.alphaMul()));
         float var10002 = var2 * var10.x() * var3;
         float var10003 = var10.y() * var3;
         var7++;
         handleWorldRenderer13(var0, var1, var10002, var10003, getIntForInt17(var6, var10.alphaMul()));
      }
   }

   private static Matrix4f getMatrix4fForPositionBodyYawRecord(PositionBodyYawRecord var0, ShaderFillScaleRecord var1, Vec3 var2) {
      PreTranslateYPreTranslateZRecord var5 = var0.pose();
      Matrix4f var4 = new Matrix4f();
      var4.translate(
         new Vector3f(
            (float)(var0.position().xCoord - var2.xCoord), (float)(var0.position().yCoord - var2.yCoord), (float)(var0.position().zCoord - var2.zCoord)
         )
      );
      var4.rotate((float)Math.toRadians(180.0F - var0.bodyYaw()), new Vector3f(0.0F, 1.0F, 0.0F));
      if (var5.preTranslateY() != 0.0F || var5.preTranslateZ() != 0.0F) {
         var4.translate(new Vector3f(0.0F, var5.preTranslateY(), var5.preTranslateZ()));
      }

      if (var5.pitchRotation() != 0.0F) {
         var4.rotate((float)Math.toRadians(var5.pitchRotation()), new Vector3f(1.0F, 0.0F, 0.0F));
      }

      if (var5.yawRotation() != 0.0F) {
         var4.rotate((float)Math.toRadians(var5.yawRotation()), new Vector3f(0.0F, 1.0F, 0.0F));
      }

      if (var5.rollRotation() != 0.0F) {
         var4.rotate((float)Math.toRadians(var5.rollRotation()), new Vector3f(0.0F, 0.0F, 1.0F));
      }

      var4.translate(new Vector3f(0.0F, var5.anchorY() + var1.heightOffset(), var5.anchorZ() + var1.depthOffset()));
      float var6 = var1.scale() * var5.scaleMultiplier();
      var4.scale(new Vector3f(var6, var6, var6));
      return var4;
   }

   private static void handleList10(List<PositionBodyYawRecord> var0, ShaderFillScaleRecord var1, Vec3 var2, AutoCloseableImpl.Iface var3) {
      Iterator var4;
      Iterator var10000 = var4 = var0.iterator();

      while (var10000.hasNext()) {
         PositionBodyYawRecord var7;
         Matrix4f var6 = getMatrix4fForPositionBodyYawRecord(var7 = (PositionBodyYawRecord)var4.next(), var1, var2);
         var10000 = var4;
         var3.handlePositionBodyYawRecord(var7, getMatrix4fForMatrix4f2(var6, var7, -1.0F), -1.0F);
         var3.handlePositionBodyYawRecord(var7, getMatrix4fForMatrix4f2(var6, var7, 1.0F), 1.0F);
      }
   }

   public void handleFloat35(float var1, List<PositionBodyYawRecord> var2, ShaderFillScaleRecord var3) {
      if (this.bool2 && !var2.isEmpty()) {
         Entity var8;
         if ((var8 = MINECRAFT.getRenderViewEntity()) != null) {
            Vec3 var10 = new Vec3(
               var8.prevPosX + (var8.posX - var8.prevPosX) * var1,
               var8.prevPosY + (var8.posY - var8.prevPosY) * var1,
               var8.prevPosZ + (var8.posZ - var8.prevPosZ) * var1
            );
            int var11;
            int var5 = getIntForInt19(var11 = var3.color() | 0xFF000000, -1, 0.28F);
            int var6 = getIntForInt19(var11, -1, 0.55F);
            int var7 = Math.round(255.0F * var3.opacity());

            try {
               handleBool14(var3.throughWalls());
               this.handleList11(var2, var3, var10, var5, var6, var7);
               this.handleList8(var2, var3, var10, var11, var7);
               this.handleList9(var2, var3, var10, var11, var5, var7);
               run73();
            } catch (Throwable var9) {
               this.bool2 = false;
               OnyxClient.LOGGER.warn("Wings renderer has been disabled after a render failure", var9);
            }
         }
      }
   }

   private boolean isEnabled48() {
      if (!this.bool) {
         this.bool = true;
         this.cls = Cls.getClsForString("onyx_wings_aurora");
      }

      if (this.cls != null && this.cls.isEnabled()) {
         this.cls.run3();
         this.cls.handleString("uTime", (float)(System.nanoTime() % 180000000000L) / 1.0E9F);
         this.cls.handleString2("uResolution", MINECRAFT.displayWidth, MINECRAFT.displayHeight);
         return true;
      } else {
         return false;
      }
   }

   private static void handleWorldRenderer13(WorldRenderer var0, Matrix4f var1, float var2, float var3, int var4) {
      Vector4f var5 = new Vector4f(var2, var3, 0.0F, 1.0F);
      Vector4f var7 = Matrix4f.transform(var1, var5, null);
      var0.pos(var7.x, var7.y, var7.z).color(getIntForInt18(var4, 16), getIntForInt18(var4, 8), getIntForInt18(var4, 0), getIntForInt16(var4)).endVertex();
   }

   private static int getIntForInt18(int var0, int var1) {
      return var0 >> var1 & 0xFF;
   }

   private static int getIntForInt16(int var0) {
      return var0 >> 24 & 0xFF;
   }

   private static void run73() {
      GL11.glDisable(2848);
      GlStateManager.shadeModel(7424);
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableCull();
      GlStateManager.disableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.blendFunc(770, 771);
      GlStateManager.disableFog();
      GlStateManager.enableLighting();
      GlStateManager.enableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.popMatrix();
   }

   private interface Iface {
      void handlePositionBodyYawRecord(PositionBodyYawRecord var1, Matrix4f var2, float var3);
   }
}
