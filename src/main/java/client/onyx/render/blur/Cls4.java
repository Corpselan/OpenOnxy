package client.onyx.render.blur;

import client.onyx.MinecraftAccess;
import client.onyx.theme.impl.Util2;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public final class Cls4 implements MinecraftAccess {
   private static final float[] FLOAT_ARRAY;
   private static final float[][] FLOAT_ARRAY_ARRAY;
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("onyx", "textures/effect/target_bloom.png");
   private static final int[][] INT_ARRAY_ARRAY;

   private void handleVec39(Vec3 var1, EntityLivingBase var2, float var3, long var4, float var6, BloomSizeRecord var7, Cls2 var8) {
      GlStateManager.enableTexture2D();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      MINECRAFT.getTextureManager().bindTexture(RESOURCE_LOCATION);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GlStateManager.blendFunc(770, 1);
      Tessellator var9;
      WorldRenderer var10 = (var9 = Tessellator.getInstance()).getWorldRenderer();
      var10.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      Vec3 var29 = getVec3ForEntity(var2, var6);
      float var11 = Util.getFloatForFloat4(var2.width);
      float var12 = Util.getFloatForFloat(var3);
      float var13 = var3 * 0.2F * var7.bloom();
      int var14 = Util.getIntForInt(var7.bloomColor(), var13);
      float var15 = Util.getFloatForFloat3(1.5F * var7.size(), var3);
      float var16 = Util.getFloatForFloat3(0.6F * var7.size(), var3);
      Vec3 var17 = var29.addVector(0.0, var2.height / 2.0F, 0.0);

      int var18;
      for (int var10000 = var18 = 0; var10000 < 18; var10000 = var18) {
         Vec3 var30 = getVec3ForVec3(var29, var2.height, var18, var11, var12, var4, var3);
         float var27 = var8.getFloat(var18);
         Vec3 var31 = getVec3ForVec32(var30, var17, var27, var7.reach());
         double var21 = var31.xCoord - var1.xCoord;
         double var23 = var31.yCoord - var1.yCoord;
         double var25 = var31.zCoord - var1.zCoord;
         int var20 = var27 <= 0.0F ? var14 : Util.getIntForInt(Util.getIntForInt4(var7.bloomColor(), var7.strikeColor(), var27), var13 * (1.0F + var27 * 0.7F));
         float var28 = 1.0F + var27 * 0.8F;
         handleWorldRenderer11(var10, var21, var23, var25, var15 * var28, var20);
         var18++;
         handleWorldRenderer11(var10, var21, var23, var25, var16 * var28, var20);
      }

      var9.draw();
   }

   static Vec3 getVec3ForEntity(Entity var0, float var1) {
      return new Vec3(
         var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * var1,
         var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * var1,
         var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * var1
      );
   }

   private static Vec3 getVec3ForVec32(Vec3 var0, Vec3 var1, float var2, float var3) {
      return var2 <= 0.0F ? var0 : var0.add(var1.subtract(var0).scale(var2 * var3));
   }

   public void handleEntityLivingBase6(EntityLivingBase var1, float var2, long var3, float var5, BloomSizeRecord var6, Cls2 var7) {
      Entity var9;
      if ((var9 = MINECRAFT.getRenderViewEntity()) != null) {
         Vec3 var10 = new Vec3(
            var9.prevPosX + (var9.posX - var9.prevPosX) * var5,
            var9.prevPosY + (var9.posY - var9.prevPosY) * var5,
            var9.prevPosZ + (var9.posZ - var9.prevPosZ) * var5
         );
         GlStateManager.pushMatrix();
         GlStateManager.disableLighting();
         GlStateManager.enableBlend();
         GlStateManager.disableDepth();
         GlStateManager.depthMask(false);
         GlStateManager.disableCull();
         GlStateManager.disableAlpha();
         this.handleVec38(var10, var1, var2, var3, var5, var6, var7);
         this.handleVec39(var10, var1, var2, var3, var5, var6, var7);
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.enableAlpha();
         GlStateManager.enableCull();
         GlStateManager.depthMask(true);
         GlStateManager.enableDepth();
         GlStateManager.disableBlend();
         GlStateManager.enableTexture2D();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.popMatrix();
      }
   }

   static {
      float[][] var0 = new float[6][];
      float[] var1 = new float[]{0.0F, 1.5F, 0.0F};
      var0[0] = var1;
      float[] var2 = new float[]{0.0F, -1.5F, 0.0F};
      var0[1] = var2;
      float[] var3 = new float[]{1.0F, 0.0F, 0.0F};
      var0[2] = var3;
      float[] var4 = new float[]{-1.0F, 0.0F, 0.0F};
      var0[3] = var4;
      float[] var5 = new float[]{0.0F, 0.0F, 1.0F};
      var0[4] = var5;
      float[] var6 = new float[]{0.0F, 0.0F, -1.0F};
      var0[5] = var6;
      FLOAT_ARRAY_ARRAY = var0;
      int[][] var7 = new int[8][];
      int[] var8 = new int[]{0, 4, 2};
      var7[0] = var8;
      int[] var9 = new int[]{0, 3, 4};
      var7[1] = var9;
      int[] var10 = new int[]{0, 5, 3};
      var7[2] = var10;
      int[] var11 = new int[]{0, 2, 5};
      var7[3] = var11;
      int[] var12 = new int[]{1, 2, 4};
      var7[4] = var12;
      int[] var13 = new int[]{1, 4, 3};
      var7[5] = var13;
      int[] var14 = new int[]{1, 3, 5};
      var7[6] = var14;
      int[] var15 = new int[]{1, 5, 2};
      var7[7] = var15;
      INT_ARRAY_ARRAY = var7;
      float[] var16 = new float[]{1.0F, 0.8F, 0.6F, 0.9F, 0.7F, 0.5F, 0.4F, 0.6F};
      FLOAT_ARRAY = var16;
   }

   static void handleWorldRenderer11(WorldRenderer var0, double var1, double var3, double var5, float var7, int var8) {
      float var18 = var7 / 2.0F;
      float var9 = ActiveRenderInfo.getRotationX();
      float var10 = ActiveRenderInfo.getRotationXZ();
      float var11 = ActiveRenderInfo.getRotationZ();
      float var12 = ActiveRenderInfo.getRotationYZ();
      float var13 = ActiveRenderInfo.getRotationXY();
      int var14 = Util2.getIntForInt7(var8);
      int var15 = Util2.getIntForInt(var8);
      int var16 = Util2.getIntForInt2(var8);
      var8 = Util2.getIntForInt6(var8);
      var0.pos(var1 - var9 * var18 - var12 * var18, var3 - var10 * var18, var5 - var11 * var18 - var13 * var18)
         .tex(0.0, 0.0)
         .color(var14, var15, var16, var8)
         .endVertex();
      var0.pos(var1 - var9 * var18 + var12 * var18, var3 + var10 * var18, var5 - var11 * var18 + var13 * var18)
         .tex(0.0, 1.0)
         .color(var14, var15, var16, var8)
         .endVertex();
      var0.pos(var1 + var9 * var18 + var12 * var18, var3 + var10 * var18, var5 + var11 * var18 + var13 * var18)
         .tex(1.0, 1.0)
         .color(var14, var15, var16, var8)
         .endVertex();
      var0.pos(var1 + var9 * var18 - var12 * var18, var3 - var10 * var18, var5 + var11 * var18 - var13 * var18)
         .tex(1.0, 0.0)
         .color(var14, var15, var16, var8)
         .endVertex();
   }

   private static float[] getFloatArrayForFloatArray(float[] var0, Vec3 var1) {
      float var14 = (float)var1.xCoord;
      float var2 = (float)var1.yCoord;
      float var3 = (float)var1.zCoord;
      float var15 = -var14;
      float var4;
      if ((var4 = var3 * var3 + var15 * var15) < 1.0E-12F) {
         if (var2 >= 0.0F) {
            float[] var20 = new float[3];
            boolean var21 = true;
            var20[0] = var0[0];
            var20[1] = var0[1];
            var20[2] = var0[2];
            return var20;
         } else {
            float[] var19 = new float[3];
            boolean var10002 = true;
            var19[0] = var0[0];
            var19[1] = -var0[1];
            var19[2] = -var0[2];
            return var19;
         }
      } else {
         var4 = (float)Math.sqrt(var4);
         var3 /= var4;
         float var16 = var15 / var4;
         float var5 = var0[0];
         float var6 = var0[1];
         float var7 = var0[2];
         float var8 = -var16 * var6;
         float var9 = var16 * var5 - var3 * var7;
         float var10 = var3 * var6;
         float var11 = var3 * var5 + var16 * var7;
         float var12 = 1.0F - var2;
         return new float[]{var5 * var2 + var8 * var4 + var3 * var11 * var12, var6 * var2 + var9 * var4, var7 * var2 + var10 * var4 + var16 * var11 * var12};
      }
   }

   private void handleVec38(Vec3 var1, EntityLivingBase var2, float var3, long var4, float var6, BloomSizeRecord var7, Cls2 var8) {
      GlStateManager.disableTexture2D();
      GlStateManager.blendFunc(770, 1);
      Tessellator var9;
      WorldRenderer var10 = (var9 = Tessellator.getInstance()).getWorldRenderer();
      var10.begin(4, DefaultVertexFormats.POSITION_COLOR);
      Vec3 var34 = getVec3ForEntity(var2, var6);
      float var11 = Util.getFloatForFloat4(var2.width);
      float var12 = Util.getFloatForFloat(var3);
      int var13 = Util.getIntForInt(var7.crystalColor(), var3 * var7.crystal());
      Vec3 var14 = var34.addVector(0.0, var2.height / 2.0F, 0.0);

      int var15;
      for (int var10000 = var15 = 0; var10000 < 18; var10000 = ++var15) {
         Vec3 var16;
         Vec3 var37 = var16 = getVec3ForVec3(var34, var2.height, var15, var11, var12, var4, var3);
         float var32 = var8.getFloat(var15);
         Vec3 var38 = getVec3ForVec32(var37, var14, var32, var7.reach());
         double var19 = var38.xCoord - var1.xCoord;
         double var21 = var38.yCoord - var1.yCoord;
         double var23 = var38.zCoord - var1.zCoord;
         var16 = new Vec3(var14.xCoord - var16.xCoord, var14.yCoord - var16.yCoord, var14.zCoord - var16.zCoord).normalize();
         int var18 = var32 <= 0.0F ? var13 : Util.getIntForInt4(var13, var7.strikeColor(), var32);
         float var25 = 0.1F * (1.0F + var32 * 0.5F);
         float var33 = 1.0F + var32 * 0.6F;

         int var26;
         for (int var39 = var26 = 0; var39 < INT_ARRAY_ARRAY.length; var39 = ++var26) {
            int var27 = Util.getIntForInt3(var18, FLOAT_ARRAY[var26] * var33);
            int[] var28;
            int var29 = (var28 = INT_ARRAY_ARRAY[var26]).length;

            int var30;
            for (int var40 = var30 = 0; var40 < var29; var40 = var30) {
               int var31 = var28[var30];
               float[] var36 = getFloatArrayForFloatArray(FLOAT_ARRAY_ARRAY[var31], var16);
               WorldRenderer var41 = var10.pos(var19 + var36[0] * var25, var21 + var36[1] * var25, var23 + var36[2] * var25);
               int var10001 = Util2.getIntForInt7(var27);
               int var10002 = Util2.getIntForInt(var27);
               int var10003 = Util2.getIntForInt2(var27);
               var30++;
               var41.color(var10001, var10002, var10003, Util2.getIntForInt6(var27)).endVertex();
            }
         }
      }

      var9.draw();
   }

   private static Vec3 getVec3ForVec3(Vec3 var0, float var1, int var2, float var3, float var4, long var5, float var7) {
      float var13;
      float var12 = (float)Math.sin(var13 = Util.getFloatForInt2(var2, var5, var7)) * var3 * var4;
      float var9 = (float)Math.cos(var13) * var3 * var4;
      var1 = Util.getFloatForInt(var2, var1);
      return new Vec3(var0.xCoord + var12, var0.yCoord + var1, var0.zCoord + var9);
   }
}
