package client.onyx.render;

import client.onyx.MinecraftAccess;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public final class Util7 implements MinecraftAccess {
   private static boolean bool;
   private static final int[][] INT_ARRAY_ARRAY;
   private static Vec3 vec3 = new Vec3(0.0, 0.0, 0.0);

   public static void handleAxisAlignedBB2(AxisAlignedBB var0, int var1, float var2, int var3) {
      if (bool) {
         double var4 = var0.minX - vec3.xCoord;
         double var6 = var0.minY - vec3.yCoord;
         double var8 = var0.minZ - vec3.zCoord;
         double var10 = var0.maxX - vec3.xCoord;
         double var12 = var0.maxY - vec3.yCoord;
         double var14 = var0.maxZ - vec3.zCoord;
         double[][] var10000 = new double[8][];
         int var10002 = 1;
         double[] var22 = new double[3];
         boolean var10004 = true;
         var22[0] = var4;
         var22[1] = var6;
         var22[2] = var8;
         var10000[0] = var22;
         double[] var23 = new double[3];
         var10004 = true;
         var23[0] = var10;
         var23[1] = var6;
         var23[2] = var8;
         var10000[1] = var23;
         double[] var24 = new double[3];
         var10004 = true;
         var24[0] = var4;
         var24[1] = var6;
         var24[2] = var14;
         var10000[2] = var24;
         double[] var10003 = new double[3];
         boolean var10005 = true;
         var10003[0] = var10;
         var10003[1] = var6;
         var10003[2] = var14;
         var10000[3] = var10003;
         var10003 = new double[3];
         var10005 = true;
         var10003[0] = var4;
         var10003[1] = var12;
         var10003[2] = var8;
         var10000[4] = var10003;
         var10003 = new double[3];
         var10005 = true;
         var10003[0] = var10;
         var10003[1] = var12;
         var10003[2] = var8;
         var10000[5] = var10003;
         var10003 = new double[3];
         var10005 = true;
         var10003[0] = var4;
         var10003[1] = var12;
         var10003[2] = var14;
         var10000[6] = var10003;
         var10003 = new double[3];
         var10005 = true;
         var10003[0] = var10;
         var10003[1] = var12;
         var10003[2] = var14;
         var10000[7] = var10003;
         double[][] var18 = var10000;
         Tessellator var5;
         WorldRenderer var19 = (var5 = Tessellator.getInstance()).getWorldRenderer();
         if (client.onyx.theme.impl.Util2.getIntForInt6(var3) > 0) {
            var19.begin(7, DefaultVertexFormats.POSITION_COLOR);
            handleWorldRenderer2(var19, var18, var3, 0, 1, 3, 2);
            handleWorldRenderer2(var19, var18, var3, 4, 5, 7, 6);
            handleWorldRenderer2(var19, var18, var3, 0, 1, 5, 4);
            handleWorldRenderer2(var19, var18, var3, 2, 3, 7, 6);
            handleWorldRenderer2(var19, var18, var3, 0, 2, 6, 4);
            handleWorldRenderer2(var19, var18, var3, 1, 3, 7, 5);
            var5.draw();
         }

         if (client.onyx.theme.impl.Util2.getIntForInt6(var1) > 0) {
            GL11.glLineWidth(var2);
            var19.begin(1, DefaultVertexFormats.POSITION_COLOR);
            int[][] var16 = INT_ARRAY_ARRAY;
            var3 = INT_ARRAY_ARRAY.length;

            int var7;
            for (int var21 = var7 = 0; var21 < var3; var21 = var7) {
               int[] var20 = var16[var7];
               handleWorldRenderer(var19, var18[var20[0]], var1);
               var10002 = var20[1];
               var7++;
               handleWorldRenderer(var19, var18[var10002], var1);
            }

            var5.draw();
         }
      }
   }

   static {
      int[][] var0 = new int[12][];
      int[] var1 = new int[]{0, 1};
      var0[0] = var1;
      int[] var2 = new int[]{1, 3};
      var0[1] = var2;
      int[] var3 = new int[]{3, 2};
      var0[2] = var3;
      int[] var4 = new int[]{2, 0};
      var0[3] = var4;
      int[] var5 = new int[]{4, 5};
      var0[4] = var5;
      int[] var6 = new int[]{5, 7};
      var0[5] = var6;
      int[] var7 = new int[]{7, 6};
      var0[6] = var7;
      int[] var8 = new int[]{6, 4};
      var0[7] = var8;
      int[] var9 = new int[]{0, 4};
      var0[8] = var9;
      int[] var10 = new int[]{1, 5};
      var0[9] = var10;
      int[] var11 = new int[]{2, 6};
      var0[10] = var11;
      int[] var12 = new int[]{3, 7};
      var0[11] = var12;
      INT_ARRAY_ARRAY = var0;
   }

   private Util7() {
   }

   public static boolean isFloat3(float var0, boolean var1) {
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
         GlStateManager.depthMask(false);
         if (var1) {
            GlStateManager.disableDepth();
         }

         GL11.glEnable(2848);
         GL11.glHint(3154, 4354);
         bool = true;
         return true;
      }
   }

   private static void handleWorldRenderer2(WorldRenderer var0, double[][] var1, int var2, int var3, int var4, int var5, int var6) {
      handleWorldRenderer(var0, var1[var3], var2);
      handleWorldRenderer(var0, var1[var4], var2);
      handleWorldRenderer(var0, var1[var5], var2);
      handleWorldRenderer(var0, var1[var6], var2);
   }

   public static void run49() {
      if (bool) {
         bool = false;
         GL11.glDisable(2848);
         GL11.glLineWidth(1.0F);
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

   private static void handleWorldRenderer(WorldRenderer var0, double[] var1, int var2) {
      var0.pos(var1[0], var1[1], var1[2])
         .color(
            client.onyx.theme.impl.Util2.getIntForInt7(var2),
            client.onyx.theme.impl.Util2.getIntForInt(var2),
            client.onyx.theme.impl.Util2.getIntForInt2(var2),
            client.onyx.theme.impl.Util2.getIntForInt6(var2)
         )
         .endVertex();
   }
}
