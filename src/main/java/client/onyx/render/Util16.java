package client.onyx.render;

import client.onyx.module.render.GlowESPModule;
import java.nio.FloatBuffer;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.Shader;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public final class Util16 {
   private static final FloatBuffer FLOAT_BUFFER2 = BufferUtils.createFloatBuffer(16);
   private static float float_;
   private static float float_2;
   private static final float FLOAT = 1.0E-4F;
   private static final double DOUBLE = 0.5;
   private static final FloatBuffer FLOAT_BUFFER = BufferUtils.createFloatBuffer(16);
   private static final float[] FLOAT_ARRAY = new float[2];
   private static boolean bool;
   private static boolean bool2;
   private static float float_3;
   private static final int[] INT_ARRAY = new int[4];
   private static float float_4;
   private static int int_ = 1;
   private static int int_2 = 1;

   public static void handleFloat2(float var0, int var1, int var2) {
      if (bool) {
         handleFloat(var0, var1, var2);
         GL11.glEnable(3089);
         GL11.glScissor(INT_ARRAY[0], INT_ARRAY[1], INT_ARRAY[2], INT_ARRAY[3]);
         bool2 = true;
      }
   }

   private static void handleFloat(float var0, int var1, int var2) {
      float var6 = (float)var1 / int_;
      float var4 = (float)var2 / int_2;
      int var5 = Math.clamp((long)((int)Math.floor((float_3 - var0) * var6) - 1), 0, var1 - 1);
      int var3 = Math.clamp((long)((int)Math.floor((float_4 - var0) * var4) - 1), 0, var2 - 1);
      var1 = Math.clamp((long)((int)Math.ceil((float_ + var0) * var6) + 1), var5 + 1, var1);
      var2 = Math.clamp((long)((int)Math.ceil((float_2 + var0) * var4) + 1), var3 + 1, var2);
      INT_ARRAY[0] = var5;
      INT_ARRAY[1] = var3;
      INT_ARRAY[2] = var1 - var5;
      INT_ARRAY[3] = var2 - var3;
   }

   private static boolean isFloat(float var0, float var1, float var2) {
      float var3 = FLOAT_BUFFER2.get(0) * var0 + FLOAT_BUFFER2.get(4) * var1 + FLOAT_BUFFER2.get(8) * var2 + FLOAT_BUFFER2.get(12);
      float var4 = FLOAT_BUFFER2.get(1) * var0 + FLOAT_BUFFER2.get(5) * var1 + FLOAT_BUFFER2.get(9) * var2 + FLOAT_BUFFER2.get(13);
      var1 = FLOAT_BUFFER2.get(2) * var0 + FLOAT_BUFFER2.get(6) * var1 + FLOAT_BUFFER2.get(10) * var2 + FLOAT_BUFFER2.get(14);
      if (!((var2 = FLOAT_BUFFER.get(3) * var3 + FLOAT_BUFFER.get(7) * var4 + FLOAT_BUFFER.get(11) * var1 + FLOAT_BUFFER.get(15)) > 1.0E-4F)) {
         return false;
      } else {
         float var5 = FLOAT_BUFFER.get(0) * var3 + FLOAT_BUFFER.get(4) * var4 + FLOAT_BUFFER.get(8) * var1 + FLOAT_BUFFER.get(12);
         var1 = FLOAT_BUFFER.get(1) * var3 + FLOAT_BUFFER.get(5) * var4 + FLOAT_BUFFER.get(9) * var1 + FLOAT_BUFFER.get(13);
         FLOAT_ARRAY[0] = (var5 / var2 * 0.5F + 0.5F) * int_;
         FLOAT_ARRAY[1] = (var1 / var2 * 0.5F + 0.5F) * int_2;
         return Float.isFinite(FLOAT_ARRAY[0]) && Float.isFinite(FLOAT_ARRAY[1]);
      }
   }

   public static void handleList(List<Entity> var0, float var1, double var2, double var4, double var6) {
      List var13 = var0;
      bool = false;
      if (GlowESPModule.isEnabled65() && !var0.isEmpty()) {
         Minecraft var8 = Minecraft.getMinecraft();
         int_ = Math.max(1, var8.displayWidth);
         int_2 = Math.max(1, var8.displayHeight);
         FLOAT_BUFFER2.clear();
         FLOAT_BUFFER.clear();
         GL11.glGetFloat(2982, FLOAT_BUFFER2);
         GL11.glGetFloat(2983, FLOAT_BUFFER);
         float var24 = Float.MAX_VALUE;
         float var9 = Float.MAX_VALUE;
         float var10 = -Float.MAX_VALUE;
         float var11 = -Float.MAX_VALUE;
         int var12 = 0;

         for (int var10000 = var12; var10000 < var13.size(); var10000 = ++var12) {
            Entity var22;
            Entity var28 = var22 = (Entity)var13.get(var12);
            AxisAlignedBB var14 = var28.getEntityBoundingBox();
            double var15 = var28.lastTickPosX + (var22.posX - var22.lastTickPosX) * var1 - var22.posX - var2;
            double var17 = var22.lastTickPosY + (var22.posY - var22.lastTickPosY) * var1 - var22.posY - var4;
            double var19 = var28.lastTickPosZ + (var22.posZ - var22.lastTickPosZ) * var1 - var22.posZ - var6;
            float var23 = (float)(var14.minX + var15 - 0.5);
            float var25 = (float)(var14.minY + var17 - 0.5);
            float var21 = (float)(var14.minZ + var19 - 0.5);
            float var26 = (float)(var14.maxX + var15 + 0.5);
            float var16 = (float)(var14.maxY + var17 + 0.5);
            float var27 = (float)(var14.maxZ + var19 + 0.5);

            int var18;
            for (int var30 = var18 = 0; var30 < 8; var30 = var18) {
               float var31;
               int var32;
               if ((var18 & 1) == 0) {
                  var31 = var23;
                  var32 = var18;
               } else {
                  var31 = var26;
                  var32 = var18;
               }

               float var33;
               int var34;
               if ((var32 & 2) == 0) {
                  var33 = var25;
                  var34 = var18;
               } else {
                  var33 = var16;
                  var34 = var18;
               }

               if (!isFloat(var31, var33, (var34 & 4) == 0 ? var21 : var27)) {
                  return;
               }

               var24 = Math.min(var24, FLOAT_ARRAY[0]);
               var9 = Math.min(var9, FLOAT_ARRAY[1]);
               var10 = Math.max(var10, FLOAT_ARRAY[0]);
               var18++;
               var11 = Math.max(var11, FLOAT_ARRAY[1]);
            }
         }

         float_3 = var24;
         float_4 = var9;
         float_ = var10;
         float_2 = var11;
         bool = true;
      }
   }

   public static boolean isEnabled() {
      return bool;
   }

   public static void handleShader(Shader var0, float var1) {
      if (!bool) {
         var0.clearScissor();
      } else {
         Framebuffer var3 = var0.framebufferOut;
         handleFloat(var1, var3.framebufferTextureWidth, var3.framebufferTextureHeight);
         var0.setScissor(INT_ARRAY[0], INT_ARRAY[1], INT_ARRAY[2], INT_ARRAY[3]);
      }
   }

   public static void run() {
      if (bool2) {
         GL11.glDisable(3089);
         bool2 = false;
      }
   }

   private Util16() {
   }
}
