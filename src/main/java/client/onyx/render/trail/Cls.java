package client.onyx.render.trail;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
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

public final class Cls implements MinecraftAccess {
   private boolean bool = true;
   private static final float FLOAT = 0.8F;
   private static final float FLOAT2 = 0.004F;
   private static final float FLOAT3 = 2.5F;

   private static int getIntForInt13(int var0) {
      return var0 >> 24 & 0xFF;
   }

   public void run71() {
      this.bool = true;
   }

   private static void handleBool13(boolean var0) {
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

   public void handleFloat34(float var1, List<PositionTimeRecord> var2, float var3, ModeColorRecord var4) {
      if (this.bool) {
         Entity var8;
         if ((var8 = MINECRAFT.getRenderViewEntity()) != null) {
            Vec3 var10 = new Vec3(
               var8.prevPosX + (var8.posX - var8.prevPosX) * var1,
               var8.prevPosY + (var8.posY - var8.prevPosY) * var1,
               var8.prevPosZ + (var8.posZ - var8.prevPosZ) * var1
            );
            long var6 = System.currentTimeMillis();

            try {
               switch (var4.mode()) {
                  case WALL:

                     if (var2.size() >= 2) {
                        this.handleList6(var2, var3, var4, var10, var6);
                        return;
                     }
                     break;
                  case POINTS:
                     if (var2.isEmpty()) {
                        break;
                     }

                     this.handleList7(var2, var4, var10, var6);
                  default:
                     return;
               }
            } catch (Throwable var9) {
               this.bool = false;
               OnyxClient.LOGGER.warn("Trails renderer has been disabled after a render failure", var9);
            }
         }
      }
   }

   private static int getIntForInt15(int var0, int var1) {
      return Math.clamp((long)var1, 0, 255) << 24 | var0 & 16777215;
   }

   private void handleTessellator(Tessellator var1, WorldRenderer var2, List<PositionTimeRecord> var3, float var4, ModeColorRecord var5, Vec3 var6, long var7) {
      var2.begin(3, DefaultVertexFormats.POSITION_COLOR);
      Iterator var10;
      Iterator var10000 = var10 = var3.iterator();

      while (var10000.hasNext()) {
         PositionTimeRecord var9 = (PositionTimeRecord)var10.next();
         var10000 = var10;
         handleWorldRenderer12(var2, var9.position(), var4, var6, getIntForModeColorRecord2(var5, getFloatForPositionTimeRecord(var9, var5, var7)));
      }

      var1.draw();
   }

   private static int getIntForInt14(int var0, int var1) {
      return var0 >> var1 & 0xFF;
   }

   private static void handleWorldRenderer12(WorldRenderer var0, Vec3 var1, float var2, Vec3 var3, int var4) {
      var0.pos(var1.xCoord - var3.xCoord, var1.yCoord + var2 - var3.yCoord, var1.zCoord - var3.zCoord)
         .color(getIntForInt14(var4, 16), getIntForInt14(var4, 8), getIntForInt14(var4, 0), getIntForInt13(var4))
         .endVertex();
   }

   private static int getIntForModeColorRecord2(ModeColorRecord var0, float var1) {
      return getIntForInt15(var0.color(), (int)(255.0F * Math.min(1.0F, var0.opacity() * 2.5F) * var1));
   }

   private static float getFloatForPositionTimeRecord(PositionTimeRecord var0, ModeColorRecord var1, long var2) {
      return 1.0F - Math.clamp((float)(var2 - var0.time()) / (float)var1.lifetime(), 0.0F, 1.0F);
   }

   private static int getIntForModeColorRecord(ModeColorRecord var0, float var1) {
      return getIntForInt15(var0.color(), (int)(255.0F * var0.opacity() * var1));
   }

   private void handleList6(List<PositionTimeRecord> var1, float var2, ModeColorRecord var3, Vec3 var4, long var5) {
      Tessellator var7;
      WorldRenderer var14 = (var7 = Tessellator.getInstance()).getWorldRenderer();
      int var10000 = 0;
      handleBool13(var3.throughWalls());
      var14.begin(7, DefaultVertexFormats.POSITION_COLOR);

      for (int var9 = 0; var10000 < var1.size() - 1; var10000 = var9) {
         PositionTimeRecord var10 = (PositionTimeRecord)var1.get(var9);
         PositionTimeRecord var11;
         PositionTimeRecord var10001 = var11 = (PositionTimeRecord)var1.get(var9 + 1);
         int var12 = getIntForModeColorRecord(var3, getFloatForPositionTimeRecord(var10, var3, var5));
         int var13 = getIntForModeColorRecord(var3, getFloatForPositionTimeRecord(var10001, var3, var5));
         handleWorldRenderer12(var14, var10.position(), 0.0F, var4, var12);
         handleWorldRenderer12(var14, var10.position(), var2, var4, var12);
         handleWorldRenderer12(var14, var11.position(), var2, var4, var13);
         Vec3 var15 = var11.position();
         var9++;
         handleWorldRenderer12(var14, var15, 0.0F, var4, var13);
      }

      var7.draw();
      GL11.glLineWidth(var3.lineWidth());
      this.handleTessellator(var7, var14, var1, 0.004F, var3, var4, var5);
      this.handleTessellator(var7, var14, var1, var2 - 0.004F, var3, var4, var5);
      run70();
   }

   private void handleList7(List<PositionTimeRecord> var1, ModeColorRecord var2, Vec3 var3, long var4) {
      Tessellator var6;
      WorldRenderer var7 = (var6 = Tessellator.getInstance()).getWorldRenderer();
      handleBool13(var2.throughWalls());
      GL11.glEnable(2832);
      GL11.glHint(3153, 4354);
      GL11.glPointSize(var2.pointSize());
      var7.begin(0, DefaultVertexFormats.POSITION_COLOR);
      Iterator var9;
      Iterator var10000 = var9 = var1.iterator();

      while (var10000.hasNext()) {
         PositionTimeRecord var8 = (PositionTimeRecord)var9.next();
         var10000 = var9;
         handleWorldRenderer12(var7, var8.position(), 0.8F, var3, getIntForModeColorRecord2(var2, getFloatForPositionTimeRecord(var8, var2, var4)));
      }

      var6.draw();
      GL11.glPointSize(1.0F);
      GL11.glDisable(2832);
      run70();
   }

   private static void run70() {
      GL11.glLineWidth(1.0F);
      GL11.glDisable(2848);
      GlStateManager.shadeModel(7424);
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
}
