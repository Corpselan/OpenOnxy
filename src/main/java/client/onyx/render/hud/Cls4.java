package client.onyx.render.hud;

import client.onyx.module.hud.CustomGuiModule;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public final class Cls4 {
   private static final float FLOAT = 7.0F;
   private static final int INT = 9;
   private final CustomGuiModule customGuiModule;
   private float float_;
   private static final float FLOAT2 = 22.0F;
   private static final float FLOAT3 = 3.0F;
   private static final float FLOAT4 = 2.5F;
   private static final float FLOAT5 = 16.0F;
   private final ItemStack[] itemStackArray;
   private static final float FLOAT6 = 4.0F;
   private final client.onyx.render.misc.Cls cls = new client.onyx.render.misc.Cls(0.0F);
   private static final OpticalWeightRecord OPTICAL_WEIGHT_RECORD;
   private final client.onyx.render.misc.Cls[] clsArray;
   private static final float FLOAT7 = 0.0F;
   private static final int INT2 = 134217728;
   private static final float FLOAT8 = 6.0F;
   private static final float FLOAT9 = 1.5F;
   private static final float FLOAT10 = 2.0F;
   private static final float FLOAT11 = 0.5F;
   private static final int INT3 = -11740828;
   private static final float FLOAT12 = 4.0F;
   private float float_2;
   private float float_3;
   private static final float FLOAT13 = 0.55F;
   private static final float FLOAT14 = 0.0F;
   private static final float FLOAT15 = 1.0F;
   private static final float FLOAT16 = 2.0F;
   private static final float FLOAT17 = 1.0F;
   private float float_4;
   private static final int INT4 = -50384;
   private static final int INT5 = 3;
   private static final float FLOAT18 = 4.0F;

   public void handleSampler0(Sampler0 var1, float var2, float var3, float var4) {
      Minecraft var5;
      EntityPlayerSP var6;
      if ((var6 = (var5 = Minecraft.getMinecraft()).thePlayer) != null) {
         float var10 = this.customGuiModule.hotbarBooleanSetting.valueSettingSub10.getFloat5();
         float var8 = 204.0F;
         float var9 = 28.0F;
         this.float_3 = var8 * var10;
         this.float_ = var9 * var10;
         this.handleEntityPlayer(var6, var4);
         this.float_4 = (var2 - this.float_3) / 2.0F;
         this.float_2 = (var2 = var3 - 4.0F - this.float_ - Util6.getFloat()) - this.getFloat3(var6, var5) * var10;
         Util14.handleBool(this.customGuiModule.hotbarBooleanSetting.valueSettingSub93.isEnabled17());
         var1.run36();
         var1.handleFloat11(this.float_4, var2);
         var1.handleFloat12(var10, 0.0F, 0.0F);
         this.handleSampler04(var1, var5, var6, var8, var9);
         var1.run43();
      }
   }

   private void handleSampler02(Sampler0 var1, PrimaryOnPrimaryRecord var2, Minecraft var3, EntityPlayer var4, float var5) {
      if (isMinecraft(var3)) {
         float var7 = var5 - 0.0F;
         float var6 = -10.0F;
         var1.handleFloat7(0.0F, var6, var7, 6.0F, Float.MAX_VALUE, var2.surfaceContainerHighest());
         if ((var7 *= Math.clamp(var4.experience, 0.0F, 1.0F)) > 0.5F) {
            var1.handleFloat7(0.0F, var6, var7, 6.0F, Float.MAX_VALUE, var2.tertiary());
         }

         if (var4.experienceLevel > 0) {
            var7 = var6 - 1.0F - client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD12.lineHeight() / 2.0F;
            var1.handleOpticalWeightRecord4(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD12, String.valueOf(var4.experienceLevel), var5 / 2.0F, var7, var2.tertiary());
         }
      }
   }

   private void handleSampler04(Sampler0 var1, Minecraft var2, EntityPlayer var3, float var4, float var5) {
      PrimaryOnPrimaryRecord var6 = client.onyx.theme.Util4.getPrimaryOnPrimaryRecord();
      int var7 = client.onyx.theme.Util5.getIntForInt(3, var6);
      var1.handleFloat25(0.0F, 0.0F, var4, var5, 7.0F, 3);
      Util14.handleSampler02(var1, 0.0F, 0.0F, var4, var5, 7.0F, var7, this.customGuiModule.hotbarBooleanSetting.valueSettingSub93.isEnabled17());
      var5 = 22.0F;
      float var9;
      var1.handleFloat7(var9 = 3.0F + this.cls.getFloat() * 22.0F + 0.0F, 3.0F, var5, var5, 7.0F, client.onyx.theme.Util4.getIntForInt2(var6.primary(), 0.28F));
      var1.handleFloat18(var9, 3.0F, var5, var5, 7.0F, 1.5F, var6.primary());

      int var8;
      for(int var10000 = var8 = 0; var10000 < 9; var10000 = var8) {
         this.handleSampler03(var1, var6, var3.inventory.mainInventory[var8], var8++);
      }

      this.handleSampler02(var1, var6, var2, var3, var4);
   }

   private void handleSampler05(Sampler0 var1, ItemStack var2, float var3, float var4) {
      float var7 = 1.0F - (float)var2.getItemDamage() / (float)var2.getMaxDamage();
      float var6 = 12.0F;
      var3 -= var6 / 2.0F;
      var4 = var4 + 8.0F - 2.0F - 2.0F;
      var1.handleFloat7(var3, var4, var6, 2.0F, Float.MAX_VALUE, -1728053248);
      if (!((var6 *= var7) <= 0.5F)) {
         var1.handleFloat7(var3, var4, var6, 2.0F, Float.MAX_VALUE, client.onyx.render.misc.Cls2.getIntForInt(-50384, -11740828, var7));
      }
   }

   private static boolean isMinecraft(Minecraft var0) {
      return var0.playerController.gameIsSurvivalOrAdventure() && !var0.thePlayer.isRidingHorse();
   }

   public float getFloat() {
      return this.float_4;
   }

   private static boolean isItemStack(ItemStack var0, ItemStack var1) {
      if (var0 != null && var1 != null) {
         if (var0.getItem() != var1.getItem()) {
            return true;
         } else {
            return !var1.isItemStackDamageable() && var0.getMetadata() != var1.getMetadata();
         }
      } else {
         return var0 != var1;
      }
   }

   public boolean isEnabled() {
      Minecraft var2 = Minecraft.getMinecraft();
      return this.customGuiModule.isEnabled55() && this.customGuiModule.hotbarBooleanSetting.isEnabled5() && var2.thePlayer != null && !var2.playerController.isSpectator();
   }

   public float getFloat4() {
      return this.float_2;
   }

   static {
      OPTICAL_WEIGHT_RECORD = new OpticalWeightRecord(client.onyx.render.font.Util.Pt9Pt24Enum.PT9, client.onyx.render.font.Util.ThinExtraLightEnum.BOLD, 9.0F, 11.0F);
   }

   public float getFloat2() {
      return this.float_4 + this.float_3;
   }

   public void run() {
      this.cls.getCls(0.0F);
      int var2 = 0;

      for(int var10000 = var2; var10000 < 9; var10000 = var2) {
         this.clsArray[var2].getCls(1.0F);
         this.itemStackArray[var2++] = null;
      }

   }

   private void handleEntityPlayer(EntityPlayer var1, float var2) {
      int var4 = var1.inventory.currentItem;
      Cls4 var10000;
      if (this.customGuiModule.hotbarBooleanSetting.valueSettingSub92.isEnabled17()) {
         this.cls.getCls2((float)var4, 200.0F, client.onyx.render.misc.Util.IFACE2);
         this.cls.handleFloat(var2);
         var10000 = this;
      } else {
         this.cls.getCls((float)var4);
         var10000 = this;
      }

      boolean var7 = var10000.customGuiModule.hotbarBooleanSetting.valueSettingSub94.isEnabled17();

      int var6;
      for(int var8 = var6 = 0; var8 < 9; var8 = var6) {
         ItemStack var5 = var1.inventory.mainInventory[var6];
         if (isItemStack(this.itemStackArray[var6], var5)) {
            this.itemStackArray[var6] = var5;
            if (var7 && var5 != null) {
               this.clsArray[var6].getCls(0.55F).getCls2(1.0F, 250.0F, client.onyx.render.misc.Util.IFACE2);
            }
         }

         this.clsArray[var6++].handleFloat(var2);
      }

   }

   private float getFloat3(EntityPlayer var1, Minecraft var2) {
      return isMinecraft(var2) ? 10.0F : 0.0F;
   }

   private void handleSampler03(Sampler0 var1, PrimaryOnPrimaryRecord var2, ItemStack var3, int var4) {
      if (var3 != null && var3.getItem() != null) {
         float var5 = 3.0F + (float)var4 * 22.0F + 11.0F;
         float var6 = 14.0F;
         float var9 = this.clsArray[var4].getFloat();
         var1.run36();
         var1.handleFloat12(var9, var5, var6);
         var1.handleFloat17(var5 - 8.0F + 4.0F, var6 - 8.0F + 4.0F, 8.0F, 8.0F, 4.0F, 2.5F, 1.0F, 134217728);
         var1.handleItemStack(var3, var5 - 8.0F, var6 - 8.0F);
         var1.run43();
         if (var3.stackSize > 1) {
            String var10 = String.valueOf(var3.stackSize);
            float var7 = var5 + 8.0F;
            float var8 = var6 + 8.0F - 1.5F;
            Util2.getFloatForSampler09(var1, OPTICAL_WEIGHT_RECORD, var10, var7 - var1.getFloat17(OPTICAL_WEIGHT_RECORD, var10), var1.getFloat19(OPTICAL_WEIGHT_RECORD, var8), var2.onSurface());
         }

         if (var3.isItemDamaged()) {
            this.handleSampler05(var1, var3, var5, var6);
         }

      }
   }

   public Cls4(CustomGuiModule var1) {
      client.onyx.render.misc.Cls[] var10001 = new client.onyx.render.misc.Cls[9];
      boolean var10003 = true;
      this.clsArray = var10001;
      ItemStack[] var4 = new ItemStack[9];
      var10003 = true;
      this.itemStackArray = var4;
      int var10000 = 0;
      this.customGuiModule = var1;

      for(int var2 = 0; var10000 < 9; var10000 = var2) {
         client.onyx.render.misc.Cls[] var3 = this.clsArray;
         int var5 = var2;
         client.onyx.render.misc.Cls var10002 = new client.onyx.render.misc.Cls(1.0F);
         ++var2;
         var3[var5] = var10002;
      }

   }
}
