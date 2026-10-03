package client.onyx.render.hud;

import client.onyx.module.hud.CustomGuiModule;
import client.onyx.render.PixelsSmoothEnum;
import client.onyx.render.Sampler0;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;

public final class Cls3 {
   private static final float FLOAT = 0.2F;
   private static final float FLOAT2 = 2.0F;
   private final CustomGuiModule customGuiModule;
   private static final int INT = 10;
   private static final float FLOAT3 = 471.0F;
   private static final float FLOAT4 = 8.0F;
   private final Cls3.Cls5 cls56 = new Cls3.Cls5();
   private static final Cls3.ContainerUContainerVRecord CONTAINER_U_CONTAINER_V_RECORD = new Cls3.ContainerUContainerVRecord(16.0F, 9.0F, 34.0F, 9.0F, 1.06F);
   public static final float FLOAT5 = 103.0F;
   private static final float FLOAT6 = 22.0F;
   private static final float FLOAT7 = 8.0F;
   private static final float FLOAT8 = 9.0F;
   private static final int INT2 = -4668204;
   private final Cls3.Cls5 cls55 = new Cls3.Cls5();
   private static final Cls3.ContainerUContainerVRecord CONTAINER_U_CONTAINER_V_RECORD2 = new Cls3.ContainerUContainerVRecord(52.0F, 9.0F, 88.0F, 9.0F);
   private float float_;
   private static final float FLOAT9 = 0.6F;
   private final Cls3.Cls5 cls54 = new Cls3.Cls5();
   private final Cls3.Cls5 cls53 = new Cls3.Cls5();
   private static final float FLOAT10 = 250.0F;
   private static final float FLOAT11 = 0.006F;
   private static final float FLOAT12 = 0.5F;
   private static final float FLOAT13 = 0.006F;
   private final Cls3.Cls5 cls5 = new Cls3.Cls5();
   private static final int INT3 = -5211588;
   private static final float FLOAT14 = 1.6F;
   private float float_3;
   private static final float FLOAT15 = 2.0F;
   private float float_4;
   private static final int INT4 = -45745;
   private static final int INT5 = 256;
   private final Cls3.Cls5 cls52 = new Cls3.Cls5();
   private float float_6 = 20.0F;
   private static final Cls3.ContainerUContainerVRecord CONTAINER_U_CONTAINER_V_RECORD3 = new Cls3.ContainerUContainerVRecord(25.0F, 18.0F, 16.0F, 18.0F);
   private static final int INT6 = -15043;
   private static final int INT7 = -11688193;
   private static final float FLOAT16 = 0.25F;
   private static final int INT8 = -2047904;
   private float float_5 = Float.NaN;
   private static final float FLOAT17 = 4.0F;
   private static final float FLOAT18 = 8.0F;
   private float float_2 = -1.0F;
   private static final float FLOAT19 = 6.0F;

   public void handleSampler0(Sampler0 var1, float var2, float var3, float var4, float var5) {
      EntityPlayerSP var6;
      if ((var6 = Minecraft.getMinecraft().thePlayer) != null) {
         this.float_3 = (this.float_3 + var5) % 100000.0F;
         this.handleEntityPlayer(var6);
         this.handleFloat(var5);
         PrimaryOnPrimaryRecord var7 = client.onyx.theme.Util4.getPrimaryOnPrimaryRecord();
         var4 -= 2.0F;
         if (this.customGuiModule.modeBooleanSetting.valueSettingSub11.isEnum3(CustomGuiModule.IconsBarsEnum.ICONS)) {
            this.handleSampler08(var1, var7, var6, var2, var3, var4);
         } else {
            this.handleSampler03(var1, var7, var6, var2, var3, var4);
         }
      }
   }

   private void handleSampler08(Sampler0 var1, PrimaryOnPrimaryRecord var2, EntityPlayer var3, float var4, float var5, float var6) {
      float var14 = var6 - 8.0F;
      boolean var16 = var3.getTotalArmorValue() > 0;
      boolean var7 = isEntityPlayer(var3);
      float var8 = this.getFloat4(var1, var3, var4, var14);
      float var10000;
      if (getEntityLivingBaseForEntityPlayer(var3) != null) {
         this.handleSampler07(var1, CONTAINER_U_CONTAINER_V_RECORD2, this.cls52, var5, var14, false, 1.0F, 0.0F);
         var10000 = var8;
      } else {
         this.handleSampler07(var1, getContainerUContainerVRecordForEntityPlayer3(var3), this.cls55, var5, var14, false, 1.0F, 0.0F);
         var10000 = var8;
      }

      float var15 = var10000 - 8.0F - 2.0F;
      float var9 = var14 - 8.0F - 2.0F;
      if (var16) {
         Cls3.ContainerUContainerVRecord var10 = CONTAINER_U_CONTAINER_V_RECORD;
         Cls3.Cls5 var11 = this.cls54;
         this.handleSampler07(var1, var10, var11, var4, var15, true, 1.0F, 0.0F);
      }

      if (var7) {
         Cls3.ContainerUContainerVRecord var12 = CONTAINER_U_CONTAINER_V_RECORD3;
         Cls3.Cls5 var13 = this.cls53;
         this.handleSampler07(var1, var12, var13, var5, var9, false, 1.0F, 0.0F);
      }

      float var10001;
      boolean var10002;
      if (var16) {
         var10001 = var15;
         var10002 = var7;
      } else {
         var10001 = var8;
         var10002 = var7;
      }

      this.float_5 = Math.min(var10001, var10002 ? var9 : var14);
   }

   private static Cls3.ContainerUContainerVRecord getContainerUContainerVRecordForEntityPlayer(EntityPlayer var0) {
      float var1 = var0.isPotionActive(Potion.poison) ? 52.0F : (var0.isPotionActive(Potion.wither) ? 88.0F : 16.0F);
      float var3 = var0.worldObj.getWorldInfo().isHardcoreModeEnabled() ? 45.0F : 0.0F;
      return new Cls3.ContainerUContainerVRecord(16.0F, var3, var1 + 36.0F, var3);
   }

   private float getFloat() {
      return this.float_4 <= 0.0F ? 0.0F : (float)Math.sin((double)(this.float_3 * 0.05F)) * 1.6F * this.float_4;
   }

   public boolean isEnabled() {
      Minecraft var2 = Minecraft.getMinecraft();
      return this.customGuiModule.isEnabled55() && this.customGuiModule.modeBooleanSetting.isEnabled5() && var2.thePlayer != null && var2.playerController.shouldDrawHUD();
   }

   private void handleSampler07(Sampler0 var1, Cls3.ContainerUContainerVRecord var2, Cls3.Cls5 var3, float var4, float var5, boolean var6, float var7, float var8) {
      float var9 = var3.getFloat() * 10.0F;
      float var10 = var3.getFloat3() * 10.0F;
      boolean var11 = this.customGuiModule.modeBooleanSetting.valueSettingSub93.isEnabled17();
      boolean var12 = this.customGuiModule.modeBooleanSetting.valueSettingSub92.isEnabled17();
      var1.handleFloat10(var7);

      int var15;
      for(int var10000 = var15 = 0; var10000 < 10; var10000 = var15) {
         float var16;
         float var10001;
         if (var6) {
            var16 = var4 + (float)var15 * 8.0F;
            var10001 = var8;
         } else {
            var16 = var4 - (float)(var15 + 1) * 8.0F;
            var10001 = var8;
         }

         float var13 = var16 + var10001;
         float var14 = var11 ? this.getFloat3(var15, var3) : 1.0F;
         var1.run36();
         var1.handleFloat12(var14, var13 + 4.0F, var5 + 4.0F);
         this.handleSampler04(var1, var2, var13, var5);
         if (var12) {
            this.handleSampler06(var1, var2, var13, var5, Math.clamp(var10 - (float)var15, 0.0F, 1.0F), var6, 0.45F);
         }

         float var10005 = Math.clamp(var9 - (float)var15, 0.0F, 1.0F);
         ++var15;
         this.handleSampler06(var1, var2, var13, var5, var10005, var6, 1.0F);
         var1.run43();
      }

      var1.run40();
   }

   private void handleSampler04(Sampler0 var1, Cls3.ContainerUContainerVRecord var2, float var3, float var4) {
      Sampler0 var10000 = var1;
      float var7 = var2.getFloat();
      float var6 = var2.getFloat2();
      var10000.handleResourceLocation4(Gui.icons, var3 + var6, var4 + var6, var7, var7, var2.containerU(), var2.containerV(), 9.0F, 9.0F, 256, 256, -1, PixelsSmoothEnum.PIXELS);
   }

   private float getFloat5() {
      return this.customGuiModule.modeBooleanSetting.valueSettingSub93.isEnabled17() && !(this.cls56.getFloat() > 0.2F) ? 1.0F - 0.25F * (0.5F + 0.5F * (float)Math.sin((double)(this.float_3 * 0.006F) * 3.141592653589793D)) : 1.0F;
   }

   private static Cls3.ContainerUContainerVRecord getContainerUContainerVRecordForEntityPlayer3(EntityPlayer var0) {
      boolean var10000 = var0.isPotionActive(Potion.hunger);
      Cls3.ContainerUContainerVRecord var10002;
      if (var10000) {
         var10002 = new Cls3.ContainerUContainerVRecord(133.0F, 27.0F, 88.0F, 27.0F);
         return var10002;
      } else {
         var10002 = new Cls3.ContainerUContainerVRecord(16.0F, 27.0F, 52.0F, 27.0F);
         return var10002;
      }
   }

   private void handleSampler05(Sampler0 var1, Cls3.ContainerUContainerVRecord var2, float var3, float var4, float var5, float var6, float var7) {
      if (!(var6 <= var5)) {
         float var8 = var2.getFloat();
         float var11 = var2.getFloat2();
         boolean var10 = var5 <= 0.0F && var6 >= 1.0F;
         var1.handleFloat10(var7);
         if (!var10) {
            var1.handleFloat24(var3 + var11 + var8 * var5, var4 + var11, var8 * (var6 - var5), var8);
         }

         var1.handleResourceLocation4(Gui.icons, var3 + var11, var4 + var11, var8, var8, var2.fillU(), var2.fillV(), 9.0F, 9.0F, 256, 256, -1, PixelsSmoothEnum.PIXELS);
         if (!var10) {
            var1.run38();
         }

         var1.run40();
      }
   }

   private static Cls3.ContainerUContainerVRecord getContainerUContainerVRecordForEntityPlayer2(EntityPlayer var0) {
      float var1 = var0.isPotionActive(Potion.poison) ? 52.0F : (var0.isPotionActive(Potion.wither) ? 88.0F : 16.0F);
      float var3 = var0.worldObj.getWorldInfo().isHardcoreModeEnabled() ? 45.0F : 0.0F;
      return new Cls3.ContainerUContainerVRecord(16.0F, var3, var1 + 144.0F, var3);
   }

   private void handleEntityPlayer(EntityPlayer var1) {
      this.float_6 = Math.max((float)var1.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue(), 1.0F);
      this.float_ = Math.max(var1.getAbsorptionAmount(), 0.0F);
      float var2 = var1.getHealth();
      this.cls56.handleFloat2(var2, this.float_6);
      this.cls5.handleFloat2(this.float_, this.float_6);
      this.cls54.handleFloat2((float)var1.getTotalArmorValue(), 20.0F);
      this.cls55.handleFloat2((float)var1.getFoodStats().getFoodLevel(), 20.0F);
      this.cls53.handleFloat2(isEntityPlayer(var1) ? (float)var1.getAir() : 300.0F, 300.0F);
      EntityLivingBase var3;
      if ((var3 = getEntityLivingBaseForEntityPlayer(var1)) != null) {
         this.cls52.handleFloat2(var3.getHealth(), var3.getMaxHealth());
      }

      float var4 = var2 + this.float_;
      if (this.customGuiModule.modeBooleanSetting.valueSettingSub93.isEnabled17() && this.float_2 >= 0.0F && var4 < this.float_2 - 0.01F) {
         this.float_4 = 1.0F;
      }

      this.float_2 = var4;
   }

   public void run() {
      this.float_4 = 0.0F;
      this.float_2 = -1.0F;
      this.float_5 = Float.NaN;
   }

   private void handleFloat(float var1) {
      this.cls56.handleFloat(var1);
      this.cls5.handleFloat(var1);
      this.cls54.handleFloat(var1);
      this.cls55.handleFloat(var1);
      this.cls53.handleFloat(var1);
      this.cls52.handleFloat(var1);
      this.float_4 = Math.max(0.0F, this.float_4 - var1 * 0.006F);
   }

   private static boolean isEntityPlayer(EntityPlayer var0) {
      return var0.isInsideOfMaterial(Material.water) || var0.getAir() < 300;
   }

   private void handleSampler06(Sampler0 var1, Cls3.ContainerUContainerVRecord var2, float var3, float var4, float var5, boolean var6, float var7) {
      if (!(var5 <= 0.0F)) {
         if (var6) {
            this.handleSampler05(var1, var2, var3, var4, 0.0F, var5, var7);
         } else {
            this.handleSampler05(var1, var2, var3, var4, 1.0F - var5, 1.0F, var7);
         }
      }
   }

   private float getFloat4(Sampler0 var1, EntityPlayer var2, float var3, float var4) {
      Cls3.ContainerUContainerVRecord var24 = getContainerUContainerVRecordForEntityPlayer(var2);
      Cls3.ContainerUContainerVRecord var5 = getContainerUContainerVRecordForEntityPlayer2(var2);
      float var6 = this.float_6 + this.float_;
      int var25 = Math.max(1, MathHelper.ceiling_float_int(var6 / 2.0F));
      int var7 = Math.max(1, MathHelper.ceiling_float_int((float)var25 / 10.0F));
      float var8 = Math.max(10.0F - (float)(var7 - 2), 3.0F);
      float var9 = this.cls56.getFloat() * this.float_6;
      float var10 = this.cls56.getFloat3() * this.float_6;
      float var11 = this.float_6 + this.cls5.getFloat() * this.float_6;
      float var12 = this.float_6 + this.cls5.getFloat3() * this.float_6;
      int var13 = MathHelper.floor_float(this.float_6 / 2.0F);
      boolean var14 = this.customGuiModule.modeBooleanSetting.valueSettingSub93.isEnabled17();
      boolean var15 = this.customGuiModule.modeBooleanSetting.valueSettingSub92.isEnabled17();
      float var16 = this.getFloat();
      var1.handleFloat10(this.getFloat5());

      int var17;
      for(int var26 = var17 = 0; var26 < var25; var26 = var17) {
         float var18 = var3 + (float)(var17 % 10) * 8.0F + var16;
         float var19 = var4 - (float)(var17 / 10) * var8;
         float var23;
         boolean var21 = (var23 = (float)var17 * 2.0F) >= this.float_6;
         float var27;
         if (var14) {
            int var10001;
            boolean var10002;
            if (var21) {
               var10001 = Math.max(var17 - var13, 0);
               var10002 = var21;
            } else {
               var10001 = var17 % 10;
               var10002 = var21;
            }

            var27 = this.getFloat3(var10001, var10002 ? this.cls5 : this.cls56);
         } else {
            var27 = 1.0F;
         }

         float var22 = var27;
         var1.run36();
         var1.handleFloat12(var22, var18 + 4.0F, var19 + 4.0F);
         this.handleSampler04(var1, var24, var18, var19);
         if (var15) {
            this.handleSampler05(var1, var24, var18, var19, 0.0F, getFloatForFloat(var10 - var23), 0.45F);
            this.handleSampler05(var1, var5, var18, var19, getFloatForFloat(this.float_6 - var23), getFloatForFloat(var12 - var23), 0.45F);
         }

         this.handleSampler05(var1, var24, var18, var19, 0.0F, getFloatForFloat(var9 - var23), 1.0F);
         float var10005 = getFloatForFloat(this.float_6 - var23);
         float var10006 = getFloatForFloat(var11 - var23);
         ++var17;
         this.handleSampler05(var1, var5, var18, var19, var10005, var10006, 1.0F);
         var1.run43();
      }

      var1.run40();
      return var4 - (float)(var7 - 1) * var8;
   }

   private void handleSampler02(Sampler0 var1, PrimaryOnPrimaryRecord var2, Cls3.Cls5 var3, int var4, float var5, float var6, float var7, float var8, float var9) {
      var1.handleFloat10(var8);
      var1.handleFloat7(var5, var6, var7, 6.0F, Float.MAX_VALUE, var2.surfaceContainerHighest());
      float var10;
      if (this.customGuiModule.modeBooleanSetting.valueSettingSub92.isEnabled17() && (var10 = var7 * var3.getFloat3()) > 0.5F) {
         var1.handleFloat7(var5, var6, var10, 6.0F, Float.MAX_VALUE, client.onyx.theme.Util4.getIntForInt2(var4, 0.4F));
      }

      if ((var10 = var7 * var3.getFloat()) > 0.5F) {
         var1.handleFloat7(var5, var6, var10, 6.0F, Float.MAX_VALUE, var4);
      }

      if (var9 > 0.0F && (var10 = var7 * Math.clamp(var9, 0.0F, 1.0F)) > 0.5F) {
         var1.handleFloat7(var5, var6, var10, 6.0F, Float.MAX_VALUE, client.onyx.theme.Util4.getIntForInt2(-15043, 0.85F));
      }

      var1.run40();
   }

   public float getFloat2() {
      return this.float_5;
   }

   private static float getFloatForFloat(float var0) {
      return Math.clamp(var0 / 2.0F, 0.0F, 1.0F);
   }

   private float getFloat3(int var1, Cls3.Cls5 var2) {
      float var3;
      if ((var3 = var2.getFloat2() - (float)var1 * 22.0F) < 0.0F) {
         return 0.6F;
      } else {
         return var3 >= 250.0F ? 1.0F : 0.6F + 0.39999998F * (float)client.onyx.render.misc.Util.IFACE7.getDouble((double)(var3 / 250.0F));
      }
   }

   public Cls3(CustomGuiModule var1) {
      this.customGuiModule = var1;
   }

   private static EntityLivingBase getEntityLivingBaseForEntityPlayer(EntityPlayer var0) {
      Entity var3 = var0.ridingEntity;
      return var3 instanceof EntityLivingBase ? (EntityLivingBase)var3 : null;
   }

   private void handleSampler03(Sampler0 var1, PrimaryOnPrimaryRecord var2, EntityPlayer var3, float var4, float var5, float var6) {
      float var7 = (var5 - var4 - 8.0F) / 2.0F;
      var5 -= var7;
      var6 -= 6.0F;
      boolean var8 = var3.getTotalArmorValue() > 0;
      EntityPlayer var10000 = var3;
      boolean var12 = isEntityPlayer(var3);
      this.handleSampler02(var1, var2, this.cls56, -45745, var4 + this.getFloat(), var6, var7, this.getFloat5(), this.cls5.getFloat());
      float var13;
      if (getEntityLivingBaseForEntityPlayer(var10000) != null) {
         this.handleSampler02(var1, var2, this.cls52, -2047904, var5, var6, var7, 1.0F, 0.0F);
         var13 = var6;
      } else {
         this.handleSampler02(var1, var2, this.cls55, -5211588, var5, var6, var7, 1.0F, 0.0F);
         var13 = var6;
      }

      float var9 = var13 - 6.0F - 4.0F;
      if (var8) {
         Cls3.Cls5 var10 = this.cls54;
         this.handleSampler02(var1, var2, var10, -4668204, var4, var9, var7, 1.0F, 0.0F);
      }

      if (var12) {
         Cls3.Cls5 var11 = this.cls53;
         this.handleSampler02(var1, var2, var11, -11688193, var5, var9, var7, 1.0F, 0.0F);
      }

      this.float_5 = !var8 && !var12 ? var6 : var9;
   }

   private static final class Cls5 {
      private final client.onyx.render.misc.Cls cls = new client.onyx.render.misc.Cls(0.0F);
      private float float_;
      private final client.onyx.render.misc.Cls cls2 = new client.onyx.render.misc.Cls(0.0F);
      private float float_2 = 471.0F;

      void handleFloat(float var1) {
         this.float_2 = Math.min(this.float_2 + var1, 471.0F);
         this.cls.getCls2(this.float_, 200.0F, client.onyx.render.misc.Util.IFACE2);
         this.cls.handleFloat(var1);
         if (this.float_ >= this.cls2.getFloat()) {
            this.cls2.getCls(Math.max(this.float_, this.cls.getFloat()));
         } else {
            this.cls2.getCls2(this.float_, 500.0F, client.onyx.render.misc.Util.IFACE);
            this.cls2.handleFloat(var1);
         }
      }

      float getFloat() {
         return this.cls.getFloat();
      }

      void handleFloat2(float var1, float var2) {
         float var4 = var2 <= 0.0F ? 0.0F : Math.clamp(var1 / var2, 0.0F, 1.0F);
         if (var4 > this.float_) {
            this.float_2 = 0.0F;
         }

         this.float_ = var4;
      }

      float getFloat3() {
         return this.cls2.getFloat();
      }

      float getFloat2() {
         return this.float_2;
      }
   }

   private static record ContainerUContainerVRecord(float containerU, float containerV, float fillU, float fillV, float scale) {
      float getFloat2() {
         return (8.0F - this.getFloat()) / 2.0F;
      }


      ContainerUContainerVRecord(float var1, float var2, float var3, float var4) {
         this(var1, var2, var3, var4, 1.0F);
      }

      public float containerU() {
         return this.containerU;
      }

      public float containerV() {
         return this.containerV;
      }

      public float fillV() {
         return this.fillV;
      }

      float getFloat() {
         return 8.0F * this.scale;
      }

      public float fillU() {
         return this.fillU;
      }

      public float scale() {
         return this.scale;
      }
   }
}
