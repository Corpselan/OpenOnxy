package client.onyx.render.trail2;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.module.render.JumpCirclesModule;
import client.onyx.render.font.Ayg;
import client.onyx.render.font.Util;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public final class Cls implements MinecraftAccess {
   private static final String STRING = "  ";
   private boolean bool;
   private static final float FLOAT = 0.49F;
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("onyx", "textures/effect/jump_circle.png");
   private final Cls2 cls2 = new Cls2();
   private static final float FLOAT2 = 0.35F;
   private static final float FLOAT3 = (float) (Math.PI * 2);
   private static final float FLOAT4 = 0.015F;

   private static int getIntForModeColorRecord3(ModeColorRecord var0, float var1) {
      return Math.clamp((long)((int)(255.0F * var0.opacity() * Math.max(0.0F, var1))), 0, 255) << 24 | var0.color() & 16777215;
   }

   private static void handleBool15(boolean var0) {
      GlStateManager.pushMatrix();
      GlStateManager.enableTexture2D();
      GlStateManager.disableLighting();
      GlStateManager.disableFog();
      GlStateManager.disableAlpha();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 1);
      GlStateManager.disableCull();
      GlStateManager.depthMask(false);
      GlStateManager.shadeModel(7425);
      if (var0) {
         GlStateManager.disableDepth();
      }
   }

   public void handleFloat37(float var1, List<PositionTimeRecord> var2, ModeColorRecord var3) {
      if (this.bool && !var2.isEmpty()) {
         Entity var7;
         if ((var7 = MINECRAFT.getRenderViewEntity()) != null) {
            Vec3 var9 = new Vec3(
               var7.prevPosX + (var7.posX - var7.prevPosX) * var1,
               var7.prevPosY + (var7.posY - var7.prevPosY) * var1,
               var7.prevPosZ + (var7.posZ - var7.prevPosZ) * var1
            );
            long var5 = System.currentTimeMillis();

            try {
               this.cls2.handleList14(var2, var3, var5);
               handleBool15(var3.throughWalls());
               this.handleList13(var2, var3, var9, var5);
               if (var3.mode() == JumpCirclesModule.RingTextEnum.TEXT) {
                  this.handleList12(var2, var3, var9, var5);
               }

               run77();
            } catch (Throwable var8) {
               this.bool = false;
               OnyxClient.LOGGER.warn("JumpCircles renderer has been disabled after a render failure", var8);
            }
         }
      }
   }

   private void handleList13(List<PositionTimeRecord> var1, ModeColorRecord var2, Vec3 var3, long var4) {
      MINECRAFT.getTextureManager().bindTexture(RESOURCE_LOCATION);
      Tessellator var6;
      WorldRenderer var7 = (var6 = Tessellator.getInstance()).getWorldRenderer();
      var7.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      Iterator var12;
      Iterator var10000 = var12 = var1.iterator();

      while (var10000.hasNext()) {
         PositionTimeRecord var8;
         float var9;
         float var11;
         if ((var11 = getFloatForModeColorRecord(var2, var9 = getFloatForPositionTimeRecord3(var8 = (PositionTimeRecord)var12.next(), var2, var4)) / 0.49F)
            <= 0.0F) {
            var10000 = var12;
         } else {
            int var14 = getIntForModeColorRecord3(var2, getFloatForFloat8(var9));
            Vec3 var13 = var8.position().subtract(var3);
            var10000 = var12;
            handleWorldRenderer15(var7, var13, -var11, -var11, 0.0F, 0.0F, var14);
            handleWorldRenderer15(var7, var13, -var11, var11, 0.0F, 1.0F, var14);
            handleWorldRenderer15(var7, var13, var11, var11, 1.0F, 1.0F, var14);
            handleWorldRenderer15(var7, var13, var11, -var11, 1.0F, 0.0F, var14);
         }
      }

      var6.draw();
   }

   private static void handleWorldRenderer15(WorldRenderer var0, Vec3 var1, float var2, float var3, float var4, float var5, int var6) {
      var0.pos(var1.xCoord + var2, var1.yCoord + 0.015F, var1.zCoord + var3)
         .tex(var4, var5)
         .color(getIntForInt21(var6, 16), getIntForInt21(var6, 8), getIntForInt21(var6, 0), getIntForInt21(var6, 24))
         .endVertex();
   }

   private static float getFloatForFloat8(float var0) {
      return 1.0F - var0;
   }

   private static int getIntForInt21(int var0, int var1) {
      return var0 >> var1 & 0xFF;
   }

   private void handleList12(List<PositionTimeRecord> var1, ModeColorRecord var2, Vec3 var3, long var4) {
      String var6;
      if (!(var6 = var2.text().trim()).isEmpty() && !(var2.radius() <= 0.0F)) {
         Ayg var7 = Util.getAygForPt9Pt24Enum(Util.Pt9Pt24Enum.PT36, Util.ThinExtraLightEnum.BOLD);
         var6 = new StringBuilder().insert(0, var6).append("  ").toString();

         int var8;
         for (int var10000 = var8 = 0; var10000 < var6.length(); var10000 = var8) {
            var7.getU0V0Record2(var6.charAt(var8++));
         }

         if ((var8 = var7.getInt()) != -1) {
            GlStateManager.bindTexture(var8);
            float var28 = var2.textHeight() / var7.getFloat5();
            float var9;
            if (!((var9 = var2.radius() - var2.textHeight() * 1.35F) <= 0.0F)) {
               float var10;
               if (!((var10 = var7.getFloat4(var6) * var28) <= 0.0F)) {
                  float var11 = (float) (Math.PI * 2) * var9;
                  int var12 = Math.max(1, Math.round(var11 / var10));
                  var10 = var11 / (var12 * var10);
                  Iterator var25;
                  Iterator var34 = var25 = var1.iterator();

                  while (var34.hasNext()) {
                     float var13;
                     float var22;
                     PositionTimeRecord var30;
                     if ((var22 = getFloatForFloat8(var13 = getFloatForPositionTimeRecord3(var30 = (PositionTimeRecord)var25.next(), var2, var4))) <= 0.0F) {
                        var34 = var25;
                     } else if ((var13 = getFloatForModeColorRecord(var2, var13) / var2.radius()) <= 0.0F) {
                        var34 = var25;
                     } else {
                        float var15 = var28 * var13;
                        var13 = var9 * var13;
                        int var23;
                        GL11.glColor4f(
                           getIntForInt21(var23 = getIntForModeColorRecord3(var2, var22), 16) / 255.0F,
                           getIntForInt21(var23, 8) / 255.0F,
                           getIntForInt21(var23, 0) / 255.0F,
                           getIntForInt21(var23, 24) / 255.0F
                        );
                        GL11.glBegin(7);
                        Vec3 var24 = var30.position().subtract(var3);
                        var11 = (float)Math.toRadians(var2.spin() * getFloatForPositionTimeRecord2(var30, var4));
                        float var16 = 0.0F;

                        int var17;
                        int var18;
                        for (int var35 = var17 = 0; var35 < var12; var35 = ++var17) {
                           for (int var36 = var18 = 0; var36 < var6.length(); var36 = var18) {
                              Ayg.U0V0Record var19;
                              if (!(var19 = var7.getU0V0Record2(var6.charAt(var18))).isEnabled()) {
                                 float var20 = var19.width() * var15;
                                 float var21 = var16 + (var19.bearingX() * var15 + var20 / 2.0F) * var10;
                                 handleVec311(var24, var19, var11 + var21 / var13, var13, var20 / 2.0F, var19.bearingY() * var15, var19.height() * var15);
                              }

                              float var10001 = var19.advance() * var15;
                              var18++;
                              var16 += var10001 * var10;
                           }
                        }

                        GL11.glEnd();
                        var34 = var25;
                     }
                  }

                  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                  GlStateManager.resetColor();
               }
            }
         }
      }
   }

   private static void run77() {
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

   private static void handleVec310(Vec3 var0, double var1, double var3, double var5, double var7, float var9, float var10) {
      GL11.glTexCoord2f(var9, var10);
      GL11.glVertex3d(var0.xCoord + var5 * var1 - var7 * var3, var0.yCoord + 0.015F, var0.zCoord + var5 * var3 + var7 * var1);
   }

   private static float getFloatForModeColorRecord(ModeColorRecord var0, float var1) {
      return var0.radius() * (1.0F - (float)Math.pow(1.0F - var1, 4.0));
   }

   private static void handleVec311(Vec3 var0, Ayg.U0V0Record var1, float var2, float var3, float var4, float var5, float var6) {
      double var7 = Math.cos(var2);
      double var9 = Math.sin(var2);
      double var11;
      double var13 = (var11 = var3 - var5) - var6;
      handleVec310(var0, var7, var9, var11, -var4, var1.u0(), var1.v0());
      handleVec310(var0, var7, var9, var13, -var4, var1.u0(), var1.v1());
      handleVec310(var0, var7, var9, var13, var4, var1.u1(), var1.v1());
      handleVec310(var0, var7, var9, var11, var4, var1.u1(), var1.v0());
   }

   private static float getFloatForPositionTimeRecord3(PositionTimeRecord var0, ModeColorRecord var1, long var2) {
      return Math.clamp((float)(var2 - var0.time()) / (float)var1.lifetime(), 0.0F, 1.0F);
   }

   public Cls() {
      this.bool = true;
   }

   private static float getFloatForPositionTimeRecord2(PositionTimeRecord var0, long var1) {
      return (float)(var1 - var0.time()) / 1000.0F;
   }

   public void run76() {
      this.bool = true;
   }
}
