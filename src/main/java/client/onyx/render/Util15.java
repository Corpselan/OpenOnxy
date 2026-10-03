package client.onyx.render;

import client.onyx.MinecraftAccess;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public final class Util15 implements MinecraftAccess {
   private static Vec3 vec3 = new Vec3(0.0, 0.0, 0.0);
   private static boolean bool;

   private static void handleWorldRenderer8(WorldRenderer var0, double var1, double var3, double var5, int var7) {
      var0.pos(var1, var3, var5)
         .color(
            client.onyx.theme.impl.Util2.getIntForInt7(var7),
            client.onyx.theme.impl.Util2.getIntForInt(var7),
            client.onyx.theme.impl.Util2.getIntForInt2(var7),
            client.onyx.theme.impl.Util2.getIntForInt6(var7)
         )
         .endVertex();
   }

   public static void run61() {
      if (bool) {
         bool = false;
         GlStateManager.shadeModel(7424);
         GlStateManager.depthMask(true);
         GlStateManager.enableDepth();
         GlStateManager.enableCull();
         GlStateManager.disableBlend();
         GlStateManager.enableLighting();
         GlStateManager.enableTexture2D();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.popMatrix();
      }
   }

   private Util15() {
   }

   private static void handleWorldRenderer7(
      WorldRenderer var0, double var1, double var3, double var5, double var7, double var9, double var11, int var13, int var14
   ) {
      handleWorldRenderer8(var0, var1, var9, var3, var13);
      handleWorldRenderer8(var0, var5, var9, var7, var13);
      handleWorldRenderer8(var0, var5, var11, var7, var14);
      handleWorldRenderer8(var0, var1, var11, var3, var14);
   }

   public static boolean isFloat6(float var0, boolean var1) {
      Entity var3;
      if ((var3 = MINECRAFT.getRenderViewEntity()) == null) {
         return false;
      } else {
         vec3 = new Vec3(
            var3.prevPosX + (var3.posX - var3.prevPosX) * var0,
            var3.prevPosY + (var3.posY - var3.prevPosY) * var0,
            var3.prevPosZ + (var3.posZ - var3.prevPosZ) * var0
         );
         GlStateManager.pushMatrix();
         GlStateManager.disableTexture2D();
         GlStateManager.disableLighting();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.disableCull();
         GlStateManager.shadeModel(7425);
         GlStateManager.depthMask(false);
         if (var1) {
            GlStateManager.disableDepth();
         }

         bool = true;
         return true;
      }
   }

   public static void handleDouble5(double var0, double var2, double var4, double var6, double var8, int var10, int var11) {
      if (bool) {
         var8 /= 2.0;
         double var12 = var0 - var8 - vec3.xCoord;
         double var14 = var0 + var8 - vec3.xCoord;
         double var16 = var2 - var8 - vec3.zCoord;
         var2 = var2 + var8 - vec3.zCoord;
         var4 -= vec3.yCoord;
         var6 -= vec3.yCoord;
         Tessellator var10000 = Tessellator.getInstance();
         WorldRenderer var23 = var10000.getWorldRenderer();
         var23.begin(7, DefaultVertexFormats.POSITION_COLOR);
         handleWorldRenderer7(var23, var12, var16, var14, var16, var4, var6, var10, var11);
         handleWorldRenderer7(var23, var14, var16, var14, var2, var4, var6, var10, var11);
         handleWorldRenderer7(var23, var14, var2, var12, var2, var4, var6, var10, var11);
         handleWorldRenderer7(var23, var12, var2, var12, var16, var4, var6, var10, var11);
         var10000.draw();
      }
   }
}
