package client.onyx.render.blur;

import client.onyx.MinecraftAccess;
import client.onyx.theme.impl.Util2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public final class Cls implements MinecraftAccess {
   private float float_;
   private static final int INT = 400;
   private static final float[] FLOAT_ARRAY;
   private static final int INT2 = 24;
   private float float_2;
   private static final float[] FLOAT_ARRAY2;
   private boolean bool;
   private final List<Cls.Cls5> list = new ArrayList<>();
   private static final int INT3 = 160;
   private final Random random = new Random();
   private float float_3;
   private static final float FLOAT = 130.0F;
   private static final int INT4 = 96;
   private float float_4;
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("onyx", "textures/effect/target_bloom.png");
   private int int_;

   private static int getIntForInt12(int var0, int var1, float var2) {
      float var3;
      float var10000 = var3 = Math.clamp(var2, 0.0F, 1.0F);
      var2 = var10000 * var10000 * (3.0F - 2.0F * var3);
      return Util2.getIntForInt5(
         getIntForInt11(Util2.getIntForInt6(var0), Util2.getIntForInt6(var1), var2),
         getIntForInt11(Util2.getIntForInt7(var0), Util2.getIntForInt7(var1), var2),
         getIntForInt11(Util2.getIntForInt(var0), Util2.getIntForInt(var1), var2),
         getIntForInt11(Util2.getIntForInt2(var0), Util2.getIntForInt2(var1), var2)
      );
   }

   private void handleFloatArray5(float[] var1, Vec3 var2, float var3, float var4) {
      if (!this.list.isEmpty()) {
         GlStateManager.enableTexture2D();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         MINECRAFT.getTextureManager().bindTexture(RESOURCE_LOCATION);
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
         GlStateManager.blendFunc(770, 1);
         Tessellator var5;
         WorldRenderer var6 = (var5 = Tessellator.getInstance()).getWorldRenderer();
         var6.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
         Iterator var7;
         Iterator var10000 = var7 = this.list.iterator();

         while (var10000.hasNext()) {
            Cls.Cls5 var17 = (Cls.Cls5)var7.next();
            float var9;
            if ((var9 = 1.0F - (float)var17.int_ / Math.max(1, var17.int_2)) <= 0.0F) {
               var10000 = var7;
            } else {
               double var10 = var17.double_ + (var17.double_2 - var17.double_) * var3 - var2.xCoord;
               double var12 = var17.double_10 + (var17.double_7 - var17.double_10) * var3 - var2.yCoord;
               double var14 = var17.double_6 + (var17.double_5 - var17.double_6) * var3 - var2.zCoord;
               float var16 = 0.72F + 0.28F * (float)Math.sin((var17.int_ + var17.int_3) * 0.7F);
               var16 = var4 * var9 * var16 * 0.82F;
               var9 = var17.float_ * (0.75F + var9 * 0.45F);
               var10000 = var7;
               Cls4.handleWorldRenderer11(var6, var10, var12, var14, var9 * 5.4F * 2.0F, this.getInt18(var1, var17.int_3, var16 * 0.24F));
               Cls4.handleWorldRenderer11(var6, var10, var12, var14, var9 * 2.0F, this.getInt18(var1, var17.int_3, var16));
            }
         }

         var5.draw();
      }
   }

   private float getFloat24(float var1) {
      return (float)((Math.sin(Math.toRadians(var1 + this.float_)) + 1.0) * 0.5);
   }

   private void handleFloatArray(float[] var1, double var2, double var4, double var6, float var8, float var9, float var10) {
      Cls var13 = this;
      Tessellator var11;
      WorldRenderer var12 = (var11 = Tessellator.getInstance()).getWorldRenderer();
      int var10000 = 0;
      var12.begin(3, DefaultVertexFormats.POSITION_COLOR);

      for (int var17 = 0; var10000 <= 160; var10000 = var17) {
         float var14;
         double var15 = Math.toRadians(var14 = var17 / 160.0F * 360.0F);
         double var10001 = var2 + Math.cos(var15) * var8;
         double var10003 = var6 + Math.sin(var15) * var8;
         int var10006 = (int)(var14 + var9);
         var17++;
         handleWorldRenderer10(var12, var10001, var4, var10003, var13.getInt18(var1, var10006, var10));
      }

      var11.draw();
   }

   private void handleFloatArray3(float[] var1, double var2, double var4, double var6, float var8, float var9, float var10, float var11) {
      Cls var12 = this;
      GlStateManager.disableTexture2D();
      GlStateManager.blendFunc(770, 1);
      GlStateManager.shadeModel(7425);
      int var14;
      if (var11 > 0.0F) {
         for (int var10000 = var14 = 0; var10000 < FLOAT_ARRAY.length; var10000 = ++var14) {
            float var13;
            if (!((var13 = FLOAT_ARRAY2[var14] * var11) <= 0.0F)) {
               var12.handleFloatArray2(var1, var2, var4, var6, var8, var9, var10 * Math.min(1.0F, var13), var8 * FLOAT_ARRAY[var14]);
            }
         }
      }

      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glLineWidth(1.4F);
      var12.handleFloatArray(var1, var2, var4, var6, var8, var9, var10);
      GL11.glLineWidth(1.0F);
      GL11.glDisable(2848);
      GlStateManager.shadeModel(7424);
   }

   private static void handleWorldRenderer10(WorldRenderer var0, double var1, double var3, double var5, int var7) {
      var0.pos(var1, var3, var5).color(Util2.getIntForInt7(var7), Util2.getIntForInt(var7), Util2.getIntForInt2(var7), Util2.getIntForInt6(var7)).endVertex();
   }

   private int getInt18(float[] var1, int var2, float var3) {
      int var7 = Math.clamp((long)((int)(255.0F * var3)), 0, 255);
      int var6 = Util2.getIntForFloat(var1[0] + (this.bool ? var2 : 0), var1[1], var1[2], var7);
      if (this.float_3 <= 0.0F) {
         return var6;
      } else {
         int var4 = Util2.getIntForInt5(var7, 255, 32, 32);
         return getIntForInt12(var6, var4, this.float_3);
      }
   }

   private void handleFloatArray4(float[] var1, double var2, double var4, double var6, float var8, float var9, float var10, float var11, float var12) {
      Cls var23 = this;
      if (!(var11 <= 0.0F)) {
         Tessellator var13;
         WorldRenderer var14 = (var13 = Tessellator.getInstance()).getWorldRenderer();
         var12 = 130.0F * var12;
         GlStateManager.disableTexture2D();
         GlStateManager.blendFunc(770, 1);
         GlStateManager.shadeModel(7425);

         int var15;
         for (int var10000 = var15 = 0; var10000 < 24; var10000 = var15) {
            double var16 = var4 + var8 * var23.getFloat24(var10 - var12 * var15 / 24.0F);
            double var18 = var4 + var8 * var23.getFloat24(var10 - var12 * (var15 + 1) / 24.0F);
            float var20 = getFloatForFloat6(var15 / 24.0F);
            float var21 = getFloatForFloat6((var15 + 1) / 24.0F);
            var10000 = 0;
            var14.begin(5, DefaultVertexFormats.POSITION_COLOR);

            for (int var22 = 0; var10000 <= 96; var10000 = var22) {
               float var29;
               double var24 = Math.toRadians(var29 = var22 / 96.0F * 360.0F);
               double var26 = var2 + Math.cos(var24) * var9;
               var24 = var6 + Math.sin(var24) * var9;
               float var28 = getFloatForFloat7(var29, var10);
               int var30 = (int)(var29 + var10);
               handleWorldRenderer10(var14, var26, var16, var24, var23.getInt18(var1, var30, var11 * var20 * var28));
               float var10007 = var11 * var21;
               var22++;
               handleWorldRenderer10(var14, var26, var18, var24, var23.getInt18(var1, var30, var10007 * var28));
            }

            var15++;
            var13.draw();
         }

         GlStateManager.shadeModel(7424);
      }
   }

   static {
      float[] var0 = new float[]{0.3F, 0.13F, 0.05F};
      FLOAT_ARRAY = var0;
      float[] var1 = new float[]{0.16F, 0.26F, 0.42F};
      FLOAT_ARRAY2 = var1;
   }

   public void run69() {
      this.list.clear();
      this.float_3 = 0.0F;
      this.int_ = 0;
      this.float_2 = 0.0F;
      this.float_4 = 0.0F;
   }

   public void handleEntityLivingBase5(EntityLivingBase var1, float var2, ColorSizeRecord var3) {
      this.float_ = var3.startPhase();
      if (var1 == null) {
         this.run69();
      } else {
         this.handleEntityLivingBase4(var1, var3);
         this.float_4 = this.float_2;
         this.float_2 = this.float_2 + var3.speed() * 6.0F;
         this.run68();
         if (var3.particles() && this.list.size() < 400) {
            int var4 = (int)((3 + this.random.nextInt(4)) * Math.max(0.15F, var2));

            int var5;
            for (int var10000 = var5 = 0; var10000 < var4 && this.list.size() < 400; var10000 = var5) {
               var5++;
               this.handleEntityLivingBase3(var1, var2, var3);
            }
         }
      }
   }

   private static float getFloatForFloat6(float var0) {
      float var2;
      float var10000 = var2 = 1.0F - var0;
      return var10000 * var10000 * var2 * 0.55F;
   }

   private void handleEntityLivingBase4(EntityLivingBase var1, ColorSizeRecord var2) {
      if (var2.redOnImpact() && var1 != null) {
         int var3;
         Cls var10000;
         if ((var3 = var1.hurtTime) <= this.int_ && (var3 <= 0 || this.int_ != 0)) {
            if (var3 > 0) {
               this.float_3 = Math.min(var2.impactIntensity(), this.float_3 + var2.impactFadeIn() * 0.5F);
               var10000 = this;
            } else {
               this.float_3 = Math.max(0.0F, this.float_3 - var2.impactFadeOut());
               var10000 = this;
            }
         } else {
            var10000 = this;
            this.float_3 = Math.min(var2.impactIntensity(), this.float_3 + var2.impactFadeIn());
         }

         var10000.int_ = var3;
      } else {
         this.float_3 = 0.0F;
         this.int_ = 0;
      }
   }

   public void handleEntityLivingBase2(EntityLivingBase var1, float var2, float var3, ColorSizeRecord var4) {
      Entity var17;
      if ((var17 = MINECRAFT.getRenderViewEntity()) != null) {
         Vec3 var21 = new Vec3(
            var17.prevPosX + (var17.posX - var17.prevPosX) * var3,
            var17.prevPosY + (var17.posY - var17.prevPosY) * var3,
            var17.prevPosZ + (var17.posZ - var17.prevPosZ) * var3
         );
         this.bool = var4.gradient();
         this.float_ = var4.startPhase();
         float var6 = 0.72F + 0.28F * var2;
         var6 = (var1.width * 0.86F + 0.18F) * var4.size() * var6;
         float var7 = this.float_4 + (this.float_2 - this.float_4) * var3;
         var2 *= var2;
         Vec3 var8 = Cls4.getVec3ForEntity(var1, var3);
         double var9 = var8.xCoord - var21.xCoord;
         double var11;
         double var13 = (var11 = var8.yCoord - var21.yCoord) + var1.height * this.getFloat24(var7);
         double var15 = var8.zCoord - var21.zCoord;
         float[] var20 = Util2.getFloatArrayForInt(var4.color());
         GlStateManager.pushMatrix();
         GlStateManager.enableBlend();
         GlStateManager.disableCull();
         GlStateManager.disableLighting();
         GlStateManager.disableAlpha();
         GlStateManager.enableDepth();
         GlStateManager.depthMask(false);
         if (var4.trail()) {
            this.handleFloatArray4(var20, var9, var11, var15, var1.height, var6, var7, var2 * var4.trailOpacity(), var4.trailLength());
         }

         this.handleFloatArray3(var20, var9, var13, var15, var6, var7, var2 * 0.92F, var4.glow());
         if (var4.particles()) {
            this.handleFloatArray5(var20, var21, var3, var2);
         }

         GlStateManager.depthMask(true);
         GlStateManager.enableAlpha();
         GlStateManager.enableCull();
         GlStateManager.disableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.blendFunc(770, 771);
         GlStateManager.enableTexture2D();
         GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.popMatrix();
      }
   }

   private void run68() {
      Iterator var1 = this.list.iterator();

      while (var1.hasNext()) {
         Cls.Cls5 var3;
         Cls.Cls5 var10000 = var3 = (Cls.Cls5)var1.next();
         var10000.double_ = var10000.double_2;
         var10000.double_10 = var10000.double_7;
         var10000.double_6 = var10000.double_5;
         var10000.double_2 = var10000.double_2 + var3.double_3;
         var10000.double_7 = var10000.double_7 + var3.double_9;
         var10000.double_5 = var10000.double_5 + var3.double_8;
         var10000.double_3 *= 0.96;
         var10000.double_9 -= 0.0022;
         var10000.double_8 *= 0.96;
         var10000.int_++;
         if (var10000.int_ >= var3.int_2 || var3.double_7 < var3.double_4) {
            var1.remove();
         }
      }
   }

   private static int getIntForInt11(int var0, int var1, float var2) {
      return (int)(var0 + (var1 - var0) * var2);
   }

   private void handleFloatArray2(float[] var1, double var2, double var4, double var6, float var8, float var9, float var10, double var11) {
      Cls var17 = this;
      Tessellator var13;
      WorldRenderer var14 = (var13 = Tessellator.getInstance()).getWorldRenderer();

      byte var15;
      for (int var10000 = var15 = -1; var10000 <= 1; var10000 = var15) {
         var10000 = 0;
         var14.begin(5, DefaultVertexFormats.POSITION_COLOR);

         for (int var16 = 0; var10000 <= 160; var10000 = var16) {
            double var18;
            float var31;
            double var20 = Math.cos(var18 = Math.toRadians(var31 = var16 / 160.0F * 360.0F));
            var18 = Math.sin(var18);
            double var23 = var2 + var20 * var8;
            double var25 = var6 + var18 * var8;
            double var27 = -var20 * var4;
            var20 = var20 * var23 + var18 * var25;
            var18 = -var18 * var4;
            double var29;
            if ((var29 = Math.sqrt(var27 * var27 + var20 * var20 + var18 * var18)) < 1.0E-6) {
               var27 = 0.0;
               var20 = 1.0;
               var18 = 0.0;
               var29 = 1.0;
            }

            var27 = var27 / var29 * var11 * var15;
            var20 = var20 / var29 * var11 * var15;
            var18 = var18 / var29 * var11 * var15;
            int var22 = var17.getInt18(var1, (int)(var31 + var9), var10);
            int var32 = var17.getInt18(var1, (int)(var31 + var9), 0.0F);
            handleWorldRenderer10(var14, var23, var4, var25, var22);
            double var10001 = var23 + var27;
            double var10002 = var4 + var20;
            var16++;
            handleWorldRenderer10(var14, var10001, var10002, var25 + var18, var32);
         }

         var15 += 2;
         var13.draw();
      }
   }

   private static float getFloatForFloat7(float var0, float var1) {
      double var2 = Math.sin(Math.toRadians(var0 * 3.0F + var1 * 1.3F));
      double var4 = Math.sin(Math.toRadians(var0 * 7.0F - var1 * 0.6F));
      return (float)(0.4 + 0.6 * (0.5 + 0.5 * var2) * (0.65 + 0.35 * var4));
   }

   private void handleEntityLivingBase3(EntityLivingBase var1, float var2, ColorSizeRecord var3) {
      float var4 = (var1.width * 0.86F + 0.18F) * var3.size() * var2;
      float var5 = this.getFloat24(this.float_2);
      double var6 = var1.posX;
      double var8 = var1.posY + 0.03;
      double var10;
      double var12 = var8 + ((var10 = var1.posY + var1.height - 0.03) - var8) * var5;
      double var14 = var1.posZ;
      double var16 = this.random.nextDouble() * Math.PI * 2.0;
      double var18 = var4 * (0.88 + this.random.nextDouble() * 0.22);
      double var20 = var1.height * var3.particleHeight();
      double var10000;
      if (var3.particleHeight() >= 0.98F) {
         double var22;
         var10000 = var22 = var8 + this.random.nextDouble() * (var10 - var8);
      } else {
         double var24 = var20 * 0.5;
         double var31 = var12 + (this.random.nextDouble() - 0.5) * var20;
         double var26 = Math.max(var8, var12 - var24);
         double var28;
         if ((var28 = Math.min(var10, var12 + var24)) > var26) {
            var31 = Math.max(var26, Math.min(var28, var31));
         }

         var10000 = var31;
      }

      double var32 = var10000 + (this.random.nextDouble() - 0.5) * 0.025;
      var32 = Math.max(var8, Math.min(var10, var32));
      double var34 = Math.cos(var16);
      double var35 = Math.sin(var16);
      double var36 = (this.random.nextDouble() - 0.5) * 0.01;
      Cls.Cls5 var30 = new Cls.Cls5(
         var6 + var34 * var18,
         var32,
         var14 + var35 * var18,
         var34 * var36,
         -8.0E-4 - this.random.nextDouble() * 0.006,
         var35 * var36,
         var8 - 0.08,
         Math.max(1, (int)((34 + this.random.nextInt(28)) * var3.particleLife())),
         (0.0065F + this.random.nextFloat() * 0.014F) * var3.size() * var2,
         this.random.nextInt(360)
      );
      this.list.add(var30);
   }

   private static final class Cls5 {
      double double_;
      int int_;
      double double_2;
      double double_3;
      final int int_2;
      final double double_4;
      final int int_3;
      double double_5;
      final float float_;
      double double_6;
      double double_7;
      double double_8;
      double double_9;
      double double_10;

      private Cls5(double var1, double var3, double var5, double var7, double var9, double var11, double var13, int var15, float var16, int var17) {
         this.double_ = var1;
         this.double_10 = var3;
         this.double_6 = var5;
         this.double_2 = var1;
         this.double_7 = var3;
         this.double_5 = var5;
         this.double_3 = var7;
         this.double_9 = var9;
         this.double_8 = var11;
         this.double_4 = var13;
         this.int_2 = var15;
         this.float_ = var16;
         this.int_3 = var17;
      }
   }
}
