package client.onyx.render;

import client.onyx.MinecraftAccess;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public final class Util13 implements MinecraftAccess {
   private static Vec3 vec3 = new Vec3(0.0, 0.0, 0.0);
   private static boolean bool;
   private static boolean bool2;

   public static void handleVec37(Vec3 var0, Vec3 var1, int var2, int var3) {
      if (bool) {
         WorldRenderer var5 = Tessellator.getInstance().getWorldRenderer();
         handleWorldRenderer6(var5, var0, var2);
         handleWorldRenderer6(var5, var1, var3);
      }
   }

   public static void run58() {
      if (bool) {
         bool = false;
         Tessellator.getInstance().draw();
      }
   }

   public static void handleList(List<Vec3> var0, int var1, int var2) {
      if (bool2 && var0.size() >= 2) {
         Tessellator var6;
         WorldRenderer var4 = (var6 = Tessellator.getInstance()).getWorldRenderer();
         var4.begin(3, DefaultVertexFormats.POSITION_COLOR);
         int var5 = var0.size() - 1;

         int var7;
         for (int var10000 = var7 = 0; var10000 <= var5; var10000 = var7) {
            Vec3 var10001 = (Vec3)var0.get(var7);
            float var10004 = var7;
            float var10005 = var5;
            var7++;
            handleWorldRenderer6(var4, var10001, getIntForInt5(var1, var2, var10004 / var10005));
         }

         var6.draw();
      }
   }

   private static int getIntForInt6(int var0, int var1, float var2) {
      return Math.round(var0 + (var1 - var0) * var2);
   }

   public static void handleVec35(Vec3 var0, float var1, int var2) {
      if (bool2) {
         Tessellator var10000 = Tessellator.getInstance();
         WorldRenderer var4 = var10000.getWorldRenderer();
         GL11.glPointSize(var1);
         GL11.glEnable(2832);
         var4.begin(0, DefaultVertexFormats.POSITION_COLOR);
         handleWorldRenderer6(var4, var0, var2);
         var10000.draw();
         GL11.glDisable(2832);
         GL11.glPointSize(1.0F);
      }
   }

   private static int getIntForInt5(int var0, int var1, float var2) {
      return var0 == var1
         ? var0
         : client.onyx.theme.impl.Util2.getIntForInt5(
            getIntForInt6(client.onyx.theme.impl.Util2.getIntForInt6(var0), client.onyx.theme.impl.Util2.getIntForInt6(var1), var2),
            getIntForInt6(client.onyx.theme.impl.Util2.getIntForInt7(var0), client.onyx.theme.impl.Util2.getIntForInt7(var1), var2),
            getIntForInt6(client.onyx.theme.impl.Util2.getIntForInt(var0), client.onyx.theme.impl.Util2.getIntForInt(var1), var2),
            getIntForInt6(client.onyx.theme.impl.Util2.getIntForInt2(var0), client.onyx.theme.impl.Util2.getIntForInt2(var1), var2)
         );
   }

   private Util13() {
   }

   public static void handleVec36(Vec3 var0, Vec3 var1, int var2, int var3) {
      if (bool2) {
         run59();
         handleVec37(var0, var1, var2, var3);
         run58();
      }
   }

   public static boolean isFloat5(float var0, boolean var1, float var2) {
      Entity var4;
      if ((var4 = MINECRAFT.getRenderViewEntity()) == null) {
         return false;
      } else {
         vec3 = new Vec3(
            var4.prevPosX + (var4.posX - var4.prevPosX) * var0,
            var4.prevPosY + (var4.posY - var4.prevPosY) * var0,
            var4.prevPosZ + (var4.posZ - var4.prevPosZ) * var0
         );
         GlStateManager.pushMatrix();
         GlStateManager.disableTexture2D();
         GlStateManager.disableLighting();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.disableCull();
         GlStateManager.depthMask(false);
         GlStateManager.shadeModel(7425);
         if (var1) {
            GlStateManager.disableDepth();
         }

         GL11.glEnable(2848);
         GL11.glHint(3154, 4354);
         GL11.glLineWidth(var2);
         bool2 = true;
         return true;
      }
   }

   private static void handleWorldRenderer6(WorldRenderer var0, Vec3 var1, int var2) {
      var0.pos(var1.xCoord - vec3.xCoord, var1.yCoord - vec3.yCoord, var1.zCoord - vec3.zCoord)
         .color(
            client.onyx.theme.impl.Util2.getIntForInt7(var2),
            client.onyx.theme.impl.Util2.getIntForInt(var2),
            client.onyx.theme.impl.Util2.getIntForInt2(var2),
            client.onyx.theme.impl.Util2.getIntForInt6(var2)
         )
         .endVertex();
   }

   public static void run60() {
      if (bool2) {
         run58();
         bool2 = false;
         GL11.glDisable(2848);
         GL11.glLineWidth(1.0F);
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

   public static void run59() {
      if (bool2 && !bool) {
         Tessellator.getInstance().getWorldRenderer().begin(1, DefaultVertexFormats.POSITION_COLOR);
         bool = true;
      }
   }
}
