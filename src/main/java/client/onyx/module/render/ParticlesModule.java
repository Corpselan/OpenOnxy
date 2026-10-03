package client.onyx.module.render;

import client.onyx.event.impl.EventSub17;
import client.onyx.event.impl.EventSub6;
import client.onyx.event.impl.EventSub9;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.particle.Util;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.Util4;
import client.onyx.theme.impl.Util2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public final class ParticlesModule extends Module {
   private final List<client.onyx.render.particle.Cls> list2;
   public final ValueSettingSub9 valueSettingSub9;
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("onyx", "textures/particle/firefly.png");
   public final ValueSettingSub10 valueSettingSub10;
   public final ValueSettingSub10 valueSettingSub102;
   public final ValueSettingSub<ParticlesModule.AttackWalkingEnum> valueSettingSub;
   public final ValueSettingSub10 valueSettingSub103;
   public final ValueSettingSub9 valueSettingSub92;
   private int int_;
   public final ValueSettingSub10 valueSettingSub104;
   public final ValueSettingSub10 valueSettingSub105;
   private final Random random;
   private int int_2;

   private void run84() {
      this.list2.removeIf((var0) -> {
         return !var0.isEnabled();
      });
   }

   private void run83() {
      Iterator var2;
      for(Iterator var10000 = var2 = this.list2.iterator(); var10000.hasNext(); var10000 = var2) {
         ((client.onyx.render.particle.Cls)var2.next()).run();
      }

      this.list2.clear();
      this.int_ = 0;
      this.int_2 = 0;
   }

   private void handleVec313(Vec3 var1, Vec3 var2, client.onyx.render.particle.Cls.AttackWalkingEnum var3, int var4) {
      if (MINECRAFT.theWorld != null) {
         this.list2.add(new client.onyx.render.particle.Cls(this, MINECRAFT.theWorld, var3, var4, this.getInt25(), var1, var2));
      }
   }

   @EventHandler
   private void handleEventSub9(EventSub9 var1) {
      if (this.valueSettingSub.isEnum(ParticlesModule.AttackWalkingEnum.ATTACK) && var1.getEntityPlayer() == MINECRAFT.thePlayer) {
         Entity var8;
         if ((var8 = var1.getEntity()) != null) {
            int var2;
            for(int var10000 = var2 = 0; var10000 < this.valueSettingSub103.getInt10(); var10000 = var2) {
               Vec3 var3 = new Vec3(var8.posX, var8.posY + this.random.nextDouble() * (double)var8.height, var8.posZ);
               Vec3 var4 = new Vec3(this.getDouble17(-2.0D, 2.0D), 0.0D, this.getDouble17(-2.0D, 2.0D));
               client.onyx.render.particle.Cls.AttackWalkingEnum var5 = client.onyx.render.particle.Cls.AttackWalkingEnum.ATTACK;
               int var6 = this.int_;
               ++var2;
               int var7 = var6 + 1;
               this.int_ = var7;
               this.handleVec313(var3, var4, var5, var6);
            }

         }
      }
   }

   public ParticlesModule() {
      super("Particles", "Glowing fireflies on attacks and while walking", ModuleCategory.RENDER);
      ParticlesModule.AttackWalkingEnum[] var1 = new ParticlesModule.AttackWalkingEnum[]{ParticlesModule.AttackWalkingEnum.ATTACK, ParticlesModule.AttackWalkingEnum.WALKING};
      ValueSettingSub var2 = new ValueSettingSub("Spawn at", ParticlesModule.AttackWalkingEnum.class, var1);
      this.valueSettingSub = var2;
      this.valueSettingSub103 = (new ValueSettingSub10("Particles on hit", 3.0D, 1.0D, 25.0D, 1.0D)).getModeSetting2(this.valueSettingSub, (var0) -> {
         return var0.contains(ParticlesModule.AttackWalkingEnum.ATTACK);
      });
      this.valueSettingSub102 = (new ValueSettingSub10("Particles while walking", 2.0D, 1.0D, 15.0D, 1.0D)).getModeSetting2(this.valueSettingSub, (var0) -> {
         return var0.contains(ParticlesModule.AttackWalkingEnum.WALKING);
      });
      this.valueSettingSub9 = new ValueSettingSub9("Random color", false);
      this.valueSettingSub10 = (new ValueSettingSub10("Size", 1.0D, 0.5D, 2.5D, 0.05D)).getValueSettingSub10("x");
      this.valueSettingSub105 = (new ValueSettingSub10("Duration", 1.0D, 0.25D, 3.0D, 0.05D)).getValueSettingSub10("x");
      this.valueSettingSub92 = new ValueSettingSub9("Physics", true);
      this.valueSettingSub104 = (new ValueSettingSub10("Physics speed", 1.0D, 0.25D, 3.0D, 0.05D)).getValueSettingSub10("x").getModeSetting(this.valueSettingSub92);
      this.list2 = new ArrayList();
      this.random = new Random();
   }

   public int getInt26(int var1, int var2) {
      return this.valueSettingSub9.isEnabled17() ? var2 : Util.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().primary(), Util4.getPrimaryOnPrimaryRecord().tertiary(), var1, System.currentTimeMillis());
   }

   protected void run80() {
      this.run83();
   }

   @EventHandler
   private void handleEventSub6(EventSub6 var1) {
      this.run83();
   }

   protected void run79() {
      this.run83();
   }

   private double getDouble17(double var1, double var3) {
      return var1 + this.random.nextDouble() * (var3 - var1);
   }

   private int getInt25() {
      return Util2.getIntForFloat(this.random.nextFloat() * 360.0F, 0.75F + this.random.nextFloat() * 0.25F, 0.75F + this.random.nextFloat() * 0.25F, 255);
   }

   public void handleFloat42(float var1) {
      if (this.isEnabled55()) {
         this.run84();
         Iterator var10;
         Iterator var10000 = var10 = this.list2.iterator();

         while(var10000.hasNext()) {
            client.onyx.render.particle.Cls var3 = (client.onyx.render.particle.Cls)var10.next();
            var10000 = var10;
            var3.run2();
         }

         this.run84();
         if (!this.list2.isEmpty()) {
            Entity var12;
            if ((var12 = MINECRAFT.getRenderViewEntity()) != null) {
               Vec3 var11 = new Vec3(var12.prevPosX + (var12.posX - var12.prevPosX) * (double)var1, var12.prevPosY + (var12.posY - var12.prevPosY) * (double)var1, var12.prevPosZ + (var12.posZ - var12.prevPosZ) * (double)var1);
               var1 = ActiveRenderInfo.getRotationX();
               float var13 = ActiveRenderInfo.getRotationXZ();
               float var4 = ActiveRenderInfo.getRotationZ();
               float var5 = ActiveRenderInfo.getRotationYZ();
               float var6 = ActiveRenderInfo.getRotationXY();
               GlStateManager.pushMatrix();
               GlStateManager.disableLighting();
               GlStateManager.enableBlend();
               GlStateManager.blendFunc(770, 1);
               GlStateManager.depthMask(false);
               GlStateManager.disableCull();
               GlStateManager.disableAlpha();
               GlStateManager.enableTexture2D();
               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               MINECRAFT.getTextureManager().bindTexture(RESOURCE_LOCATION);
               GL11.glTexParameteri(3553, 10241, 9729);
               GL11.glTexParameteri(3553, 10240, 9729);
               Tessellator var7;
               WorldRenderer var8 = (var7 = Tessellator.getInstance()).getWorldRenderer();
               var8.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);

               Iterator var9;
               for(var10000 = var9 = this.list2.iterator(); var10000.hasNext(); var10000 = var9) {
                  ((client.onyx.render.particle.Cls)var9.next()).handleWorldRenderer2(var8, var11, var1, var13, var4, var5, var6);
               }

               var7.draw();
               GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
               GlStateManager.enableAlpha();
               GlStateManager.enableCull();
               GlStateManager.depthMask(true);
               GlStateManager.disableBlend();
               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               GlStateManager.popMatrix();
            }
         }
      }
   }

   @EventHandler
   private void handleEventSub17(EventSub17 var1) {
      this.run84();
      if (this.valueSettingSub.isEnum(ParticlesModule.AttackWalkingEnum.WALKING) && MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
         if (MINECRAFT.gameSettings.thirdPersonView != 0) {
            if (MINECRAFT.thePlayer.prevPosX != MINECRAFT.thePlayer.posX || MINECRAFT.thePlayer.prevPosY != MINECRAFT.thePlayer.posY || MINECRAFT.thePlayer.prevPosZ != MINECRAFT.thePlayer.posZ) {
               int var9;
               for(int var10000 = var9 = 0; var10000 < this.valueSettingSub102.getInt10(); var10000 = var9) {
                  Vec3 var5 = new Vec3(MINECRAFT.thePlayer.posX + this.getDouble17(-0.5D, 0.5D), MINECRAFT.thePlayer.posY + this.random.nextDouble() * (double)MINECRAFT.thePlayer.height, MINECRAFT.thePlayer.posZ + this.getDouble17(-0.5D, 0.5D));
                  double var3 = 2.0D * (1.0D + this.random.nextDouble());
                  Vec3 var10 = (new Vec3(MINECRAFT.thePlayer.motionX + this.getDouble17(-0.1D, 0.1D), 0.0D, MINECRAFT.thePlayer.motionZ + this.getDouble17(-0.1D, 0.1D))).scale(var3);
                  client.onyx.render.particle.Cls.AttackWalkingEnum var6 = client.onyx.render.particle.Cls.AttackWalkingEnum.WALKING;
                  int var7 = this.int_2;
                  ++var9;
                  int var8 = var7 + 1;
                  this.int_2 = var8;
                  this.handleVec313(var5, var10, var6, var7);
               }

            }
         }
      }
   }

   public static enum AttackWalkingEnum implements DisplayNamed {
      ATTACK("Attack"),
      WALKING("Walking");

      private final String string;

      public String getString5() {
         return this.string;
      }


      private AttackWalkingEnum(String var3) {
         this.string = var3;
      }
   }
}
