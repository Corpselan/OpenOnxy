package client.onyx.render.anim;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.src.Config;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import org.lwjgl.opengl.GL11;

public final class Util implements MinecraftAccess {
   private static boolean bool2 = true;
   private static final int INT = 256;
   private static client.onyx.render.extra.Cls cls;
   private static boolean bool;
   private static final long LONG = System.nanoTime();
   private static final double DOUBLE = 0.001;

   private static void handleFloat32(
      float var0, BlockPos var1, IBlockState var2, Block var3, Entity var4, AxisAlignedBB var5, AxisAlignedBB var6, float var7, ThemeColorRecord var8
   ) {
      double var9 = var4.prevPosX + (var4.posX - var4.prevPosX) * var0;
      double var11 = var4.prevPosY + (var4.posY - var4.prevPosY) * var0;
      double var13 = var4.prevPosZ + (var4.posZ - var4.prevPosZ) * var0;
      AxisAlignedBB var34 = Cls.getAxisAlignedBBForBlockPos2(var1);
      double var15 = getDoubleForDouble2(var5.maxX - var5.minX, var34.maxX - var34.minX);
      double var17 = getDoubleForDouble2(var5.maxY - var5.minY, var34.maxY - var34.minY);
      double var19 = getDoubleForDouble2(var5.maxZ - var5.minZ, var34.maxZ - var34.minZ);
      double var21 = (var34.minX + var34.maxX) / 2.0 - var9;
      double var23 = (var34.minY + var34.maxY) / 2.0 - var11;
      double var25 = (var34.minZ + var34.maxZ) / 2.0 - var13;
      double var27 = (var5.minX + var5.maxX - var34.minX - var34.maxX) / 2.0;
      double var29 = (var5.minY + var5.maxY - var34.minY - var34.maxY) / 2.0;
      double var31 = (var5.minZ + var5.maxZ - var34.minZ - var34.maxZ) / 2.0;
      handleBool11(var8.throughWalls());
      GlStateManager.translate(var27, var29, var31);
      GlStateManager.translate(var21, var23, var25);
      GlStateManager.scale(var15, var17, var19);
      GlStateManager.translate(-var21, -var23, -var25);
      cls.run3();
      cls.handleString5("Sampler0", 0);
      cls.handleString4("uColorPrimary", getFloatForInt3(var8.color()), getFloatForInt(var8.color()), getFloatForInt2(var8.color()), var7);
      cls.handleString4(
         "uColorSecondary", getFloatForInt3(var8.secondColor()), getFloatForInt(var8.secondColor()), getFloatForInt2(var8.secondColor()), var8.glintAmount()
      );
      cls.handleString4("uMotion", getFloat23(), var8.glintSpeed(), var8.glintScale(), var8.glintGlow());
      cls.handleString4("uOrigin", (float)(var34.minX - var9), (float)(var34.minY - var11), (float)(var34.minZ - var13), 0.0F);
      if (var6 == null) {
         cls.handleString4("uCrop", 0.0F, 0.0F, 0.0F, 0.0F);
      } else {
         cls.handleString4(
            "uCrop",
            (float)getDoubleForDouble3(var6.minY - var11, var23, var17, var29),
            (float)getDoubleForDouble3(var6.maxY - var11, var23, var17, var29),
            1.0F,
            0.0F
         );
      }

      cls.handleString4("uWorld", Math.floorMod(var1.getX(), 256), Math.floorMod(var1.getY(), 256), Math.floorMod(var1.getZ(), 256), 0.0F);
      cls.handleString("uFogEnabled", GL11.glIsEnabled(2912) ? 1.0F : 0.0F);
      Tessellator var33;
      WorldRenderer var35 = (var33 = Tessellator.getInstance()).getWorldRenderer();
      var35.begin(7, DefaultVertexFormats.BLOCK);
      var35.setTranslation(-var9, -var11, -var13);
      handleWorldRenderer4(var35, var34);
      if (var6 != null) {
         boolean var36;
         var9 = (var36 = var8.progressUpward()) ? var6.maxY : var6.minY;
         handleWorldRenderer5(var35, var34, getDoubleForDouble3(var9 - var11, var23, var17, var29) + var11, var36);
      }

      var33.draw();
      var35.setTranslation(0.0, 0.0, 0.0);
      client.onyx.render.extra.Cls.run2();
      run57();
   }

   private static float getFloatForInt(int var0) {
      return (var0 >> 8 & 0xFF) / 255.0F;
   }

   private static void handleWorldRenderer3(WorldRenderer var0, double var1, double var3, double var5) {
      var0.pos(var1, var3, var5).color(255, 255, 255, 255).tex(0.0, 0.0).lightmap(240, 240).endVertex();
   }

   private Util() {
   }

   private static float getFloatForInt3(int var0) {
      return (var0 >> 16 & 0xFF) / 255.0F;
   }

   private static void handleWorldRenderer4(WorldRenderer var0, AxisAlignedBB var1) {
      EnumFacing[] var4;
      int var3 = (var4 = EnumFacing.values()).length;

      int var2;
      for (int var10000 = var2 = 0; var10000 < var3; var10000 = ++var2) {
         EnumFacing var5 = var4[var2];
         switch (var5) {
            case DOWN:

               handleWorldRenderer3(var0, var1.minX, var1.minY, var1.minZ);
               handleWorldRenderer3(var0, var1.maxX, var1.minY, var1.minZ);
               handleWorldRenderer3(var0, var1.maxX, var1.minY, var1.maxZ);
               handleWorldRenderer3(var0, var1.minX, var1.minY, var1.maxZ);
               break;
            case UP:
               handleWorldRenderer3(var0, var1.minX, var1.maxY, var1.maxZ);
               handleWorldRenderer3(var0, var1.maxX, var1.maxY, var1.maxZ);
               handleWorldRenderer3(var0, var1.maxX, var1.maxY, var1.minZ);
               handleWorldRenderer3(var0, var1.minX, var1.maxY, var1.minZ);
               break;
            case NORTH:
               handleWorldRenderer3(var0, var1.minX, var1.minY, var1.minZ);
               handleWorldRenderer3(var0, var1.minX, var1.maxY, var1.minZ);
               handleWorldRenderer3(var0, var1.maxX, var1.maxY, var1.minZ);
               handleWorldRenderer3(var0, var1.maxX, var1.minY, var1.minZ);
               break;
            case SOUTH:
               handleWorldRenderer3(var0, var1.minX, var1.minY, var1.maxZ);
               handleWorldRenderer3(var0, var1.maxX, var1.minY, var1.maxZ);
               handleWorldRenderer3(var0, var1.maxX, var1.maxY, var1.maxZ);
               handleWorldRenderer3(var0, var1.minX, var1.maxY, var1.maxZ);
               break;
            case WEST:
               handleWorldRenderer3(var0, var1.minX, var1.minY, var1.minZ);
               handleWorldRenderer3(var0, var1.minX, var1.minY, var1.maxZ);
               handleWorldRenderer3(var0, var1.minX, var1.maxY, var1.maxZ);
               handleWorldRenderer3(var0, var1.minX, var1.maxY, var1.minZ);
               break;
            case EAST:
               handleWorldRenderer3(var0, var1.maxX, var1.minY, var1.minZ);
               handleWorldRenderer3(var0, var1.maxX, var1.maxY, var1.minZ);
               handleWorldRenderer3(var0, var1.maxX, var1.maxY, var1.maxZ);
               handleWorldRenderer3(var0, var1.maxX, var1.minY, var1.maxZ);
         }
      }
   }

   public static boolean isFloat4(float var0, BlockPos var1, AxisAlignedBB var2, AxisAlignedBB var3, float var4, ThemeColorRecord var5) {
      if (!bool2 || MINECRAFT.theWorld == null) {
         return false;
      } else if (!OpenGlHelper.shadersSupported) {
         return false;
      } else if (Config.isShaders()) {
         return false;
      } else {
         Entity var6;
         if ((var6 = MINECRAFT.getRenderViewEntity()) == null) {
            return false;
         } else {
            IBlockState var7;
            Block var8;
            if ((var8 = (var7 = MINECRAFT.theWorld.getBlockState(var1)).getBlock()).getRenderType() != 3) {
               return false;
            } else {
               if (!bool) {
                  bool = true;
                  cls = client.onyx.render.extra.Cls.getClsForString("onyx_block_glint");
               }

               if (cls != null && cls.isEnabled()) {
                  try {
                     handleFloat32(var0, var1, var7, var8, var6, var2, var3, var4, var5);
                     return true;
                  } catch (Throwable var9) {
                     bool2 = false;
                     OnyxClient.LOGGER.warn("Block overlay glint has been disabled after a render failure", var9);
                     return false;
                  }
               } else {
                  bool2 = false;
                  return false;
               }
            }
         }
      }
   }

   private static void run57() {
      GlStateManager.doPolygonOffset(0.0F, 0.0F);
      GlStateManager.disablePolygonOffset();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableCull();
      GlStateManager.enableAlpha();
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

   private static void handleBool11(boolean var0) {
      GlStateManager.pushMatrix();
      MINECRAFT.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
      GlStateManager.enableTexture2D();
      GlStateManager.disableLighting();
      GlStateManager.disableFog();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      GlStateManager.disableAlpha();
      GlStateManager.enableCull();
      GlStateManager.depthMask(false);
      GlStateManager.doPolygonOffset(-1.0F, -10.0F);
      GlStateManager.enablePolygonOffset();
      if (var0) {
         GlStateManager.disableDepth();
      }
   }

   private static float getFloat23() {
      return (float)((System.nanoTime() - LONG) % 3600000000000L) / 1.0E9F;
   }

   static void run56() {
      bool2 = true;
   }

   private static double getDoubleForDouble2(double var0, double var2) {
      return var0 / Math.max(var2, 1.0E-4);
   }

   private static float getFloatForInt2(int var0) {
      return (var0 & 0xFF) / 255.0F;
   }

   private static void handleWorldRenderer5(WorldRenderer var0, AxisAlignedBB var1, double var2, boolean var4) {
      double var5 = var4 ? var2 - 0.001 : var2 + 0.001;
      handleWorldRenderer3(var0, var1.minX, var5, var1.maxZ);
      handleWorldRenderer3(var0, var1.maxX, var5, var1.maxZ);
      handleWorldRenderer3(var0, var1.maxX, var5, var1.minZ);
      handleWorldRenderer3(var0, var1.minX, var5, var1.minZ);
      handleWorldRenderer3(var0, var1.minX, var5, var1.minZ);
      handleWorldRenderer3(var0, var1.maxX, var5, var1.minZ);
      handleWorldRenderer3(var0, var1.maxX, var5, var1.maxZ);
      handleWorldRenderer3(var0, var1.minX, var5, var1.maxZ);
   }

   private static double getDoubleForDouble3(double var0, double var2, double var4, double var6) {
      return (var0 - var2 - var6) / Math.max(var4, 1.0E-4) + var2;
   }
}
