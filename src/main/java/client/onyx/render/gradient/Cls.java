package client.onyx.render.gradient;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.theme.impl.Util2;
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
   private static final int INT = -1;
   private static final float FLOAT = 2.0F;
   private static final float FLOAT2 = 0.07F;
   private static final float FLOAT3 = 0.14F;
   private static final float FLOAT4 = (float) (Math.PI * 2);
   private final int[] intArray;
   private static final int INT2 = 48;
   private static final float FLOAT5 = 1.01F;
   private static final float[] FLOAT_ARRAY = new float[49];
   private static final float FLOAT6 = 0.12F;
   private static final int INT3 = 8;
   private boolean bool = true;
   private static final float FLOAT7 = 0.22F;
   private static final int INT4 = 48;
   private static final float[] FLOAT_ARRAY2 = new float[49];
   private static final float FLOAT8 = 0.012F;
   private static final float FLOAT9 = 1.35F;

   private static void run65() {
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
   }

   private void handleRadiusHeightRecord(RadiusHeightRecord var1) {
      int var3;
      for (int var10000 = var3 = 0; var10000 <= 48; var10000 = var3) {
         int[] var4 = this.intArray;
         float var5 = var3;
         float var7 = (float) (Math.PI * 2) * var5 / 48.0F;
         int var8 = getIntForRadiusHeightRecord(var1, var7);
         int var9 = var3++;
         var4[var9] = var8;
      }
   }

   private static void handleBool12(boolean var0) {
      GlStateManager.pushMatrix();
      GlStateManager.disableTexture2D();
      GlStateManager.disableLighting();
      GlStateManager.disableFog();
      GlStateManager.enableBlend();
      run65();
      GlStateManager.disableCull();
      GlStateManager.depthMask(false);
      GlStateManager.shadeModel(7425);
      if (var0) {
         GlStateManager.disableDepth();
      }

      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
   }

   private void handleList5(List<PivotLiftRecord> var1, RadiusHeightRecord var2, Vec3 var3) {
      Tessellator var4;
      WorldRenderer var5 = (var4 = Tessellator.getInstance()).getWorldRenderer();
      var5.begin(7, DefaultVertexFormats.POSITION_COLOR);
      int var17 = (int)(255.0F * var2.opacity() * 0.7F);

      for (PivotLiftRecord var7 : var1) {
         Cls.Cls2 var18 = new Cls.Cls2(var7, var3);

         int var8;
         for (int var21 = var8 = 0; var21 < 8; var21 = ++var8) {
            float var9 = var8 / 8.0F;
            float var10 = (var8 + 1) / 8.0F;
            float var11 = var2.radius() * getFloatForFloat4(var9);
            float var12 = var2.radius() * getFloatForFloat4(var10);
            var9 = var2.height() * getFloatForFloat5(var9);
            var10 = var2.height() * getFloatForFloat5(var10);

            int var16;
            for (int var22 = var16 = 0; var22 < 48; var22 = var16) {
               int var14 = getIntForInt8(this.intArray[var16], var17);
               int var15 = getIntForInt8(this.intArray[var16 + 1], var17);
               var18.handleWorldRenderer(var5, var11 * FLOAT_ARRAY[var16], var9, var11 * FLOAT_ARRAY2[var16], var14);
               var18.handleWorldRenderer(var5, var11 * FLOAT_ARRAY[var16 + 1], var9, var11 * FLOAT_ARRAY2[var16 + 1], var15);
               var18.handleWorldRenderer(var5, var12 * FLOAT_ARRAY[var16 + 1], var10, var12 * FLOAT_ARRAY2[var16 + 1], var15);
               float var10002 = var12 * FLOAT_ARRAY[var16];
               float var10005 = FLOAT_ARRAY2[var16];
               var16++;
               var18.handleWorldRenderer(var5, var10002, var10, var12 * var10005, var14);
            }
         }
      }

      var4.draw();
   }

   private static int getIntForRadiusHeightRecord2(RadiusHeightRecord var0, float var1, float var2) {
      var2 = getFloatForFloat3(var2);
      return getIntForInt8(getIntForInt9(getIntForRadiusHeightRecord(var0, var1), -1, 0.35F * var2), (int)(255.0F * var0.opacity() * 0.8F * var2));
   }

   private static void run62() {
      GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
   }

   private static int getIntForInt7(int var0) {
      return var0 >> 24 & 0xFF;
   }

   private void handleList2(List<PivotLiftRecord> var1, RadiusHeightRecord var2, Vec3 var3) {
      Tessellator var4;
      WorldRenderer var5 = (var4 = Tessellator.getInstance()).getWorldRenderer();
      GL11.glLineWidth(2.0F);
      var5.begin(1, DefaultVertexFormats.POSITION_COLOR);
      int var19 = (int)(255.0F * var2.opacity());
      float var6 = var2.radius();
      float var7 = var2.height() * getFloatForFloat5(0.0F);
      Iterator var8 = var1.iterator();

      label36:
      while (true) {
         for (Iterator var25 = var8; var25.hasNext(); var25 = var8) {
            PivotLiftRecord var9 = (PivotLiftRecord)var8.next();
            Cls.Cls2 var10 = new Cls.Cls2(var9, var3);

            int var18;
            for (int var26 = var18 = 0; var26 < 48; var26 = var18) {
               var10.handleWorldRenderer(var5, var6 * FLOAT_ARRAY[var18], var7, var6 * FLOAT_ARRAY2[var18], getIntForInt8(this.intArray[var18], var19));
               float var10002 = var6 * FLOAT_ARRAY[var18 + 1];
               float var10004 = var6 * FLOAT_ARRAY2[var18 + 1];
               int var10005 = this.intArray[var18 + 1];
               var18++;
               var10.handleWorldRenderer(var5, var10002, var7, var10004, getIntForInt8(var10005, var19));
            }

            if (var2.trail()) {
               float var23;
               float var20 = (float)Math.cos(var23 = var9.phase() + var2.sweep());
               float var12 = (float)Math.sin(var23);
               var18 = getIntForInt8(getIntForRadiusHeightRecord(var2, var23), var19);

               int var13;
               for (int var27 = var13 = 0; var27 < 8; var27 = var13) {
                  float var14 = var13 / 8.0F;
                  float var15 = (var13 + 1) / 8.0F;
                  float var16 = var2.radius() * getFloatForFloat4(var14) * 1.01F;
                  float var17 = var2.radius() * getFloatForFloat4(var15) * 1.01F;
                  var14 = var2.height() * (getFloatForFloat5(var14) + 0.012F);
                  var15 = var2.height() * (getFloatForFloat5(var15) + 0.012F);
                  var10.handleWorldRenderer(var5, var16 * var20, var14, var16 * var12, var18);
                  float var28 = var17 * var20;
                  var13++;
                  var10.handleWorldRenderer(var5, var28, var15, var17 * var12, var18);
               }
               continue label36;
            }
         }

         var4.draw();
         GL11.glLineWidth(1.0F);
         return;
      }
   }

   private static float getFloatForFloat3(float var0) {
      float var2;
      float var10000 = var2 = Math.clamp(1.0F - var0, 0.0F, 1.0F);
      return var10000 * var10000 * (3.0F - 2.0F * var2);
   }

   static void handleWorldRenderer9(WorldRenderer var0, double var1, double var3, double var5, int var7) {
      var0.pos(var1, var3, var5).color(getIntForInt10(var7, 16), getIntForInt10(var7, 8), getIntForInt10(var7, 0), getIntForInt7(var7)).endVertex();
   }

   private static int getIntForInt9(int var0, int var1, float var2) {
      int var3 = getIntForInt10(var0, 16) + (int)((getIntForInt10(var1, 16) - getIntForInt10(var0, 16)) * var2);
      int var4 = getIntForInt10(var0, 8) + (int)((getIntForInt10(var1, 8) - getIntForInt10(var0, 8)) * var2);
      var1 = getIntForInt10(var0, 0) + (int)((getIntForInt10(var1, 0) - getIntForInt10(var0, 0)) * var2);
      return var0 & 0xFF000000 | var3 << 16 | var4 << 8 | var1;
   }

   private void handleList4(List<PivotLiftRecord> var1, RadiusHeightRecord var2, Vec3 var3) {
      Tessellator var4;
      WorldRenderer var5 = (var4 = Tessellator.getInstance()).getWorldRenderer();
      var5.begin(7, DefaultVertexFormats.POSITION_COLOR);

      for (PivotLiftRecord var6 : var1) {
         Cls.Cls2 var7 = new Cls.Cls2(var6, var3);
         float var23 = var6.phase() + var2.sweep();

         int var8;
         for (int var10000 = var8 = 0; var10000 < 48; var10000 = ++var8) {
            float var9 = var23 - var2.trailSpan() * var8 / 48.0F;
            float var20 = var23 - var2.trailSpan() * (var8 + 1) / 48.0F;
            int var11 = getIntForRadiusHeightRecord2(var2, var9, var8 / 48.0F);
            int var12 = getIntForRadiusHeightRecord2(var2, var20, (var8 + 1) / 48.0F);
            if (getIntForInt7(var11) != 0 || getIntForInt7(var12) != 0) {
               float var13 = (float)Math.cos(var9);
               var9 = (float)Math.sin(var9);
               float var14 = (float)Math.cos(var20);
               float var21 = (float)Math.sin(var20);

               int var15;
               for (int var27 = var15 = 0; var27 < 8; var27 = var15) {
                  float var16 = var15 / 8.0F;
                  float var17 = (var15 + 1) / 8.0F;
                  float var18 = var2.radius() * getFloatForFloat4(var16) * 1.01F;
                  float var19 = var2.radius() * getFloatForFloat4(var17) * 1.01F;
                  var16 = var2.height() * (getFloatForFloat5(var16) + 0.012F);
                  var17 = var2.height() * (getFloatForFloat5(var17) + 0.012F);
                  var7.handleWorldRenderer(var5, var18 * var13, var16, var18 * var9, var11);
                  var7.handleWorldRenderer(var5, var19 * var13, var17, var19 * var9, var11);
                  var7.handleWorldRenderer(var5, var19 * var14, var17, var19 * var21, var12);
                  float var10002 = var18 * var14;
                  var15++;
                  var7.handleWorldRenderer(var5, var10002, var16, var18 * var21, var12);
               }
            }
         }
      }

      var4.draw();
   }

   private static float getFloatForFloat5(float var0) {
      return (float)Math.pow(var0, 1.35F) + 0.12F * (float)Math.pow(1.0F - var0, 5.0);
   }

   private static int getIntForInt10(int var0, int var1) {
      return var0 >> var1 & 0xFF;
   }

   public Cls() {
      int[] var10001 = new int[49];
      boolean var10003 = true;
      this.intArray = var10001;
   }

   private static int getIntForRadiusHeightRecord(RadiusHeightRecord var0, float var1) {
      switch (var0.colors()) {
         case STATIC:

            return var0.color();
         case GRADIENT:
            return getIntForInt9(var0.color(), var0.secondColor(), 0.5F - 0.5F * (float)Math.cos(var1 + var0.colorPhase()));
         case RAINBOW:
            float[] var3;
            return Util2.getIntForFloat(
               (var3 = Util2.getFloatArrayForInt(var0.color()))[0] + (float)Math.toDegrees(var1 + var0.colorPhase()), var3[1], var3[2], 255
            );
         default:
            throw new MatchException(null, null);
      }
   }

   public void handleFloat33(float var1, List<PivotLiftRecord> var2, RadiusHeightRecord var3) {
      if (this.bool && !var2.isEmpty()) {
         Entity var5;
         if ((var5 = MINECRAFT.getRenderViewEntity()) != null) {
            Vec3 var7 = new Vec3(
               var5.prevPosX + (var5.posX - var5.prevPosX) * var1,
               var5.prevPosY + (var5.posY - var5.prevPosY) * var1,
               var5.prevPosZ + (var5.posZ - var5.prevPosZ) * var1
            );

            try {
               this.handleRadiusHeightRecord(var3);
               handleBool12(var3.throughWalls());
               this.handleList5(var2, var3, var7);
               if (var3.trail()) {
                  this.handleList4(var2, var3, var7);
               }

               if (var3.glow()) {
                  this.handleList3(var2, var3, var7);
               }

               this.handleList2(var2, var3, var7);
               run63();
            } catch (Throwable var6) {
               this.bool = false;
               OnyxClient.LOGGER.warn("ChinaHat renderer has been disabled after a render failure", var6);
            }
         }
      }
   }

   private static int getIntForInt8(int var0, int var1) {
      return Math.clamp((long)var1, 0, 255) << 24 | var0 & 16777215;
   }

   private static float getFloatForFloat4(float var0) {
      return 1.0F - var0;
   }

   static {
      int var0;
      for (int var10000 = var0 = 0; var10000 <= 48; var10000 = var0) {
         float var1 = (float) (Math.PI * 2) * var0 / 48.0F;
         FLOAT_ARRAY[var0] = (float)Math.cos(var1);
         float[] var4 = FLOAT_ARRAY2;
         int var10001 = var0;
         float var10002 = (float)Math.sin(var1);
         var0++;
         var4[var10001] = var10002;
      }
   }

   public void run64() {
      this.bool = true;
   }

   private void handleList3(List<PivotLiftRecord> var1, RadiusHeightRecord var2, Vec3 var3) {
      Tessellator var4;
      WorldRenderer var5 = (var4 = Tessellator.getInstance()).getWorldRenderer();
      run62();
      var5.begin(7, DefaultVertexFormats.POSITION_COLOR);
      int var18 = (int)(255.0F * var2.opacity() * 0.22F);
      float var19 = var2.radius();
      float var6 = var2.height() * getFloatForFloat5(0.0F);
      float var7 = var2.radius() * 1.07F;
      float var8 = var2.radius() * getFloatForFloat4(0.14F);
      float var9 = var2.height() * getFloatForFloat5(0.14F);

      for (PivotLiftRecord var11 : var1) {
         Cls.Cls2 var20 = new Cls.Cls2(var11, var3);

         int var17;
         for (int var21 = var17 = 0; var21 < 48; var21 = var17) {
            int var13 = getIntForInt8(this.intArray[var17], var18);
            int var14 = getIntForInt8(this.intArray[var17 + 1], var18);
            int var15 = getIntForInt8(var13, 0);
            int var16 = getIntForInt8(var14, 0);
            var20.handleWorldRenderer(var5, var19 * FLOAT_ARRAY[var17], var6, var19 * FLOAT_ARRAY2[var17], var13);
            var20.handleWorldRenderer(var5, var19 * FLOAT_ARRAY[var17 + 1], var6, var19 * FLOAT_ARRAY2[var17 + 1], var14);
            var20.handleWorldRenderer(var5, var7 * FLOAT_ARRAY[var17 + 1], var6, var7 * FLOAT_ARRAY2[var17 + 1], var16);
            var20.handleWorldRenderer(var5, var7 * FLOAT_ARRAY[var17], var6, var7 * FLOAT_ARRAY2[var17], var15);
            var20.handleWorldRenderer(var5, var19 * FLOAT_ARRAY[var17], var6, var19 * FLOAT_ARRAY2[var17], var13);
            var20.handleWorldRenderer(var5, var19 * FLOAT_ARRAY[var17 + 1], var6, var19 * FLOAT_ARRAY2[var17 + 1], var14);
            var20.handleWorldRenderer(var5, var8 * FLOAT_ARRAY[var17 + 1], var9, var8 * FLOAT_ARRAY2[var17 + 1], var16);
            float var22 = var8 * FLOAT_ARRAY[var17];
            float var10005 = FLOAT_ARRAY2[var17];
            var17++;
            var20.handleWorldRenderer(var5, var22, var9, var8 * var10005, var15);
         }
      }

      var4.draw();
      run65();
   }

   private static void run63() {
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

   private static final class Cls2 {
      private final float float_;
      private final float float_2;
      private final float float_3;
      private final float float_4;
      private final float float_5;
      private final double double_;
      private final double double_2;
      private final double double_3;

      void handleWorldRenderer(WorldRenderer var1, float var2, float var3, float var4, int var5) {
         float var7;
         float var6 = (var7 = var3 + this.float_) * this.float_4 - var4 * this.float_2;
         var3 = var7 * this.float_2 + var4 * this.float_4;
         Cls.handleWorldRenderer9(
            var1,
            this.double_3 + var2 * this.float_5 - var3 * this.float_3,
            this.double_ + var6,
            this.double_2 + var2 * this.float_3 + var3 * this.float_5,
            var5
         );
      }

      private Cls2(PivotLiftRecord var1, Vec3 var2) {
         this.double_3 = var1.pivot().xCoord - var2.xCoord;
         this.double_ = var1.pivot().yCoord - var2.yCoord;
         this.double_2 = var1.pivot().zCoord - var2.zCoord;
         this.float_ = var1.lift();
         float var3 = (float)Math.toRadians(var1.pitch());
         float var4 = (float)Math.toRadians(var1.yaw());
         this.float_4 = (float)Math.cos(var3);
         this.float_2 = (float)Math.sin(var3);
         this.float_5 = (float)Math.cos(var4);
         this.float_3 = (float)Math.sin(var4);
      }
   }
}
