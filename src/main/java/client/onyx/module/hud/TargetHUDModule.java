package client.onyx.module.hud;

import client.onyx.OnyxClient;
import client.onyx.gui.Reset;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.hud.targethud.AvatarNameEnum;
import client.onyx.module.hud.targethud.NumberHeartsEnum;
import client.onyx.module.hud.targethud.TextSettingGroup;
import client.onyx.module.hud.targethud.Util;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.Util8;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.render.guide.Util3;
import client.onyx.render.misc.Cls2;
import client.onyx.setting.impl.SettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import client.onyx.theme.Util5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Vec3;
import org.lwjgl.input.Mouse;

public class TargetHUDModule extends Module {
   public TextSettingGroup aa;
   private static final float Ea = 1.0F;
   private static final float La = 0.94F;
   private static final float Ma = 3.0F;
   public SettingSub ba = (new SettingSub("Edit layout", () -> {
      MINECRAFT.displayGuiScreen(new Reset(MINECRAFT.currentScreen));
   })).getBooleanSetting("Move, rescale, recolour and retitle the card's elements");
   private final client.onyx.gui.Cls Ia;
   private static final float Fa = 400.0F;
   private float Ja;
   private static final float ja = 9.0F;
   private static final float ma = 0.5F;
   private static final float da = 28.0F;
   private final client.onyx.render.misc.Cls fa;
   private static final float Ka = 6.0F;
   private float ha;
   private float Ha;
   private static final float ia = 8.0F;
   public TextSettingGroup Da;
   private final client.onyx.render.misc.Cls la;
   private static final float Ga = 8.0F;
   private static final float ga = 1.0F;
   private static final float ca = 100.0F;
   public ValueSettingSub10 valueSettingSub10;
   private float float_;
   private final Cls2 cls2;
   public ValueSettingSub10 valueSettingSub106 = (new ValueSettingSub10("Scale", 0.85D, 0.5D, 2.0D, 0.05D)).getValueSettingSub10("x").getBooleanSetting("Card size");
   private boolean bool2;
   public TextSettingGroup textSettingGroup;
   private static final float FLOAT = 8.0F;
   private EntityLivingBase entityLivingBase;
   private float float_2;
   private final client.onyx.render.misc.Cls cls;
   private static final float FLOAT2 = 1.35F;
   private static final float FLOAT3 = 0.8F;
   private float float_3;
   private static final float FLOAT4 = 12.0F;
   private EntityLivingBase entityLivingBase2;
   private float float_4;
   private static final float FLOAT5 = 0.55F;
   private static final float FLOAT6 = 4.0F;
   private List<TextSettingGroup> list2;
   private static final double DOUBLE = 0.05D;
   private float float_5;
   public ValueSettingSub11<TargetHUDModule.ScreenWorldEnum> valueSettingSub112;
   private float float_6;
   private float float_7;
   private final client.onyx.render.misc.Cls cls3;
   private long long_;
   private Util3.XYRecord xYRecord;
   public ValueSettingSub10 valueSettingSub103;
   private static final float FLOAT7 = 2.0F;
   private final client.onyx.render.guide.Cls cls4;
   private final client.onyx.render.misc.Cls cls5;
   private static final float FLOAT8 = 80.0F;
   public TextSettingGroup textSettingGroup2;
   private static final String STRING = " · ";
   private static final float FLOAT9 = 0.5F;
   private static final float FLOAT10 = 11.0F;
   public TextSettingGroup textSettingGroup3;
   private boolean bool3;
   private static final float FLOAT11 = 10.0F;
   public ValueSettingSub10 valueSettingSub104;
   private boolean bool4;
   private final client.onyx.render.misc.Cls cls6;
   public ValueSettingSub10 valueSettingSub105;
   private final Cls2 cls22;
   public ValueSettingSub10 valueSettingSub102 = (new ValueSettingSub10("Linger", 1.0D, 0.0D, 3.0D, 0.1D)).getValueSettingSub10("s").getBooleanSetting("How long the card holds a target it has lost");
   private float float_8;
   private static final float FLOAT12 = 0.3F;
   public TextSettingGroup textSettingGroup4;
   private static final String STRING2 = "target-hud";
   private static final float FLOAT13 = 62.0F;
   private static final float FLOAT14 = 26.0F;
   private static final int INT = 3;

   private float getFloat81() {
      long var1 = System.nanoTime();
      float var4 = this.long_ == 0L ? 16.0F : Math.min((float)(var1 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var1;
      return var4;
   }

   public void handleSampler044(Sampler0 var1, PrimaryOnPrimaryRecord var2, TargetHUDModule.WidthHeightRecord var3, boolean var4) {
      float var5 = var3.width();
      float var6 = var3.height();
      int var7 = Util5.getIntForInt(3, var2);
      var1.handleFloat25(0.0F, 0.0F, var5, var6, 12.0F, 3);
      Util14.handleSampler0(var1, 0.0F, 0.0F, var5, var6, 12.0F, var7);
      var1.handleFloat10(this.cls.getFloat());
      Iterator var8 = var3.parts().iterator();

      while(true) {
         while(var8.hasNext()) {
            TargetHUDModule.SettingsTextRecord var9 = (TargetHUDModule.SettingsTextRecord)var8.next();
            switch(var9.getAvatarNameEnum().getAvatarTextEnum()) {
            case AVATAR:

               this.handleSampler043(var1, var2, var9, var7);
               break;
            case BAR:
               this.handleSampler042(var1, var2, var9, var3.shield());
               break;
            default:
               this.handleSampler041(var1, var2, var9);
            }
         }

         var1.run40();
         if (var4) {
            client.onyx.gui.Cls var10 = this.Ia;
            int var11 = var2.onSurface();
            var10.handleSampler0(var1, 0.0F, 0.0F, var5, var6, 12.0F, var11);
         }

         var1.handleFloat18(0.0F, 0.0F, var5, var6, 12.0F, 1.0F, Cls2.getIntForInt(var2.outlineVariant(), var2.primary(), var4 ? this.cls3.getFloat() : 0.0F));
         return;
      }
   }

   private static void handleValueSettingSub108(ValueSettingSub10 var0, float var1, float var2) {
      if (!(var2 <= 0.0F)) {
         var0.handleObject2((double)Math.clamp(var1 / var2, 0.0F, 1.0F) * 100.0D);
      }
   }

   private void handleSampler042(Sampler0 var1, PrimaryOnPrimaryRecord var2, TargetHUDModule.SettingsTextRecord var3, float var4) {
      float var5 = var3.width();
      float var6 = var3.height();
      if (!(var5 <= 0.0F)) {
         int var7 = this.getInt43(var3.settings(), var2);
         float var8;
         if ((var8 = var3.settings().valueSettingSub10.getFloat5()) > 0.0F) {
            var1.handleFloat17(var3.x(), var3.y(), var5 * this.la.getFloat(), var6, Float.MAX_VALUE, var8, 0.0F, var7);
         }

         float var10 = this.la.getFloat() * var5;
         float var15 = this.getFloat78(var1, var3, 0.0F, var5, var10, var7);
         if (var3.settings().valueSettingSub93.isEnabled17()) {
            float var12 = var4 * var5;
            int var13 = var2.tertiary();
            var15 = this.getFloat78(var1, var3, var15, var5, var12, var13);
         }

         if (var3.settings().valueSettingSub92.isEnabled17()) {
            var15 = this.getFloat78(var1, var3, var15, var5, (this.cls6.getFloat() - this.la.getFloat()) * var5, Util4.getIntForInt2(var2.error(), 0.55F));
         }

         var4 = var15 > 0.0F ? var15 + 3.0F : 0.0F;
         if (var5 - var4 > 0.5F) {
            var1.handleFloat7(var3.x() + var4, var3.y(), var5 - var4, var6, Float.MAX_VALUE, var2.surfaceContainerHighest());
         }

      }
   }

   private float getFloat79(OpticalWeightRecord var1) {
      return var1.getFloat4() * 1.35F;
   }

   public TargetHUDModule() {
      super("TargetHUD", "Card showing your target's health and distance", ModuleCategory.HUD);
      this.Da = new TextSettingGroup(AvatarNameEnum.AVATAR, true, "", () -> {
         return Util4.getPrimaryOnPrimaryRecord().surfaceContainerHighest();
      });
      this.textSettingGroup2 = new TextSettingGroup(AvatarNameEnum.NAME, true, "{name}", () -> {
         return Util4.getPrimaryOnPrimaryRecord().onSurface();
      });
      this.textSettingGroup4 = new TextSettingGroup(AvatarNameEnum.HEALTH, true, "{health}", () -> {
         return Util4.getPrimaryOnPrimaryRecord().primary();
      });
      this.textSettingGroup = new TextSettingGroup(AvatarNameEnum.DISTANCE, true, "{distance}m", () -> {
         return Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant();
      });
      this.textSettingGroup3 = new TextSettingGroup(AvatarNameEnum.STATUS, true, "{status}", () -> {
         return Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant();
      });
      this.aa = new TextSettingGroup(AvatarNameEnum.HEALTH_BAR, true, "", () -> {
         return Util4.getPrimaryOnPrimaryRecord().primary();
      });
      this.valueSettingSub112 = (new ValueSettingSub11("Position", TargetHUDModule.ScreenWorldEnum.SCREEN)).getBooleanSetting("Fixed on the screen, or floating above the target in the world");
      this.valueSettingSub104 = (new ValueSettingSub10("Height offset", 0.6D, -3.0D, 3.0D, 0.1D)).getValueSettingSub10("m").getBooleanSetting("How far above the target's head the card floats").getModeSetting2(this.valueSettingSub112, (var0) -> {
         return var0 == TargetHUDModule.ScreenWorldEnum.WORLD;
      });
      this.valueSettingSub103 = (new ValueSettingSub10("Opacity", 100.0D, 5.0D, 100.0D, 1.0D)).getValueSettingSub10("%").getBooleanSetting("Overall opacity of the card - the rendered mob avatar is drawn by the game and stays solid");
      this.valueSettingSub10 = (new ValueSettingSub10("Position X", 50.0D, 0.0D, 100.0D, 0.01D)).getSetting2(() -> {
         return false;
      });
      this.valueSettingSub105 = (new ValueSettingSub10("Position Y", 78.26D, 0.0D, 100.0D, 0.01D)).getSetting2(() -> {
         return false;
      });
      this.cls5 = new client.onyx.render.misc.Cls(0.0F);
      this.cls = new client.onyx.render.misc.Cls(1.0F);
      this.fa = new client.onyx.render.misc.Cls(62.0F);
      this.la = new client.onyx.render.misc.Cls(1.0F);
      this.cls6 = new client.onyx.render.misc.Cls(1.0F);
      this.cls3 = new client.onyx.render.misc.Cls(0.0F);
      this.cls2 = new Cls2(Util4.getPrimaryOnPrimaryRecord().primary());
      this.cls22 = new Cls2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant());
      this.Ia = new client.onyx.gui.Cls();
      this.Ja = 1.0F;
      this.xYRecord = Util3.X_Y_RECORD;
      this.cls4 = new client.onyx.render.guide.Cls();
   }

   public List<TextSettingGroup> getList23() {
      if (this.list2 == null) {
         TextSettingGroup var1 = this.Da;
         TextSettingGroup var2 = this.textSettingGroup2;
         TextSettingGroup var3 = this.textSettingGroup4;
         TextSettingGroup var4 = this.textSettingGroup;
         List var5 = List.of(var1, var2, var3, var4, this.textSettingGroup3, this.aa);
         this.list2 = var5;
      }

      return this.list2;
   }

   private String getString28(TextSettingGroup var1, OpticalWeightRecord var2, Util.NameHealthRecord var3) {
      String var4 = Util.getStringForString((String)var1.valueSettingSub4.lambda15(), var3, (NumberHeartsEnum)var1.valueSettingSub112.lambda15());
      return Util.getStringForAyg(var2.getAyg(), var4);
   }

   public boolean isEnabled89() {
      return this.isEnabled55() && MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null;
   }

   private boolean isBool10(boolean var1, float var2, float var3, float var4, float var5) {
      float var6 = (float)Minecraft.getScaledMouseX() * var4 / (float)MINECRAFT.displayWidth;
      float var14 = (float)Minecraft.getScaledMouseY() * var5 / (float)MINECRAFT.displayHeight;
      float var10 = var5 - var14 - 1.0F;
      boolean var8 = this.isEnabled88();
      boolean var9 = this.isDouble9((double)var6, (double)var10);
      TargetHUDModule var10000;
      if (var1 && var8) {
         if (!this.bool2 && var9) {
            this.bool4 = true;
            this.ha = var6 - this.float_;
            this.Ha = var10 - this.float_8;
         }

         var10000 = this;
      } else {
         var10000 = this;
         this.bool4 = false;
         this.xYRecord = Util3.X_Y_RECORD;
      }

      var10000.bool2 = var8;
      if (this.bool4) {
         this.xYRecord = Util3.getXYRecordForFloat2(var6 - this.ha, var10 - this.Ha, this.float_4, this.float_5, var4, var5, 10.0F, client.onyx.render.guide.Util.getListForString("target-hud"));
         handleValueSettingSub108(this.valueSettingSub10, this.xYRecord.x() - 10.0F, var2);
         handleValueSettingSub108(this.valueSettingSub105, this.xYRecord.y() - 10.0F, var3);
      }

      return var9;
   }

   private void handleBool20(boolean var1, float var2) {
      Object var3 = var1 ? MINECRAFT.thePlayer : this.getEntityLivingBase2();
      if (var3 != null) {
         this.entityLivingBase2 = (EntityLivingBase)var3;
         this.float_2 = 0.0F;
      } else {
         if (this.entityLivingBase2 != null) {
            this.float_2 += var2;
            if (this.float_2 >= this.valueSettingSub102.getFloat5() * 1000.0F) {
               this.entityLivingBase2 = null;
            }
         }

      }
   }

   private int getInt43(TextSettingGroup var1, PrimaryOnPrimaryRecord var2) {
      if (!var1.valueSettingSub6.isEnabled13()) {
         return var1.valueSettingSub6.lambda15();
      } else {
         switch(var1.getAvatarNameEnum()) {
         case AVATAR:

            return var2.surfaceContainerHighest();
         case NAME:
            return var2.onSurface();
         case HEALTH:
         case HEALTH_BAR:
            return this.cls2.getInt();
         case DISTANCE:
            return var2.onSurfaceVariant();
         case STATUS:
            return this.cls22.getInt();
         default:
            throw new MatchException((String)null, (Throwable)null);
         }
      }
   }

   public float getFloat76() {
      return this.valueSettingSub106.getFloat5();
   }

   private void handleFloat73(float var1, float var2) {
      this.float_ = Math.clamp(this.float_6 - this.float_4 * 0.5F, 10.0F, Math.max(10.0F, var1 - this.float_4 - 10.0F));
      this.float_8 = Math.clamp(this.float_7 - this.float_5, 10.0F, Math.max(10.0F, var2 - this.float_5 - 10.0F));
   }

   private void handleFloat72(float var1, float var2) {
      if (var1 < this.Ja) {
         this.float_3 = 0.0F;
      }

      this.Ja = var1;
      this.la.getCls2(var1, 250.0F, client.onyx.render.misc.Util.IFACE2);
      this.la.handleFloat(var2);
      TargetHUDModule var10000;
      if (var1 > this.cls6.getFloat2()) {
         var10000 = this;
         this.cls6.getCls2(var1, 250.0F, client.onyx.render.misc.Util.IFACE2);
      } else {
         if (var1 < this.cls6.getFloat2()) {
            this.float_3 += var2;
            if (this.float_3 >= 400.0F) {
               this.cls6.getCls2(var1, 500.0F, client.onyx.render.misc.Util.IFACE);
            }
         }

         var10000 = this;
      }

      var10000.cls6.handleFloat(var2);
   }

   private void handleSampler043(Sampler0 var1, PrimaryOnPrimaryRecord var2, TargetHUDModule.SettingsTextRecord var3, int var4) {
      float var5 = var3.x();
      float var6 = var3.y();
      float var7 = var3.width();
      int var10 = this.getInt43(var3.settings(), var2);
      float var12;
      if ((var12 = var3.settings().valueSettingSub10.getFloat5()) > 0.0F) {
         var1.handleFloat17(var5, var6, var7, var7, 4.0F, var12, 0.0F, var10);
      }

      var1.handleFloat7(var5, var6, var7, var7, 4.0F, var10);
      EntityLivingBase var8 = this.entityLivingBase;
      Sampler0 var10000;
      if (var8 instanceof AbstractClientPlayer) {
         AbstractClientPlayer var11 = (AbstractClientPlayer)var8;
         var10000 = var1;
         var1.handleResourceLocation(var11.getLocationSkin(), var5, var6, var7);
      } else {
         int var13 = (int)Math.max(1.0F, 0.8F * var7 / Math.max(0.5F, this.entityLivingBase.height));
         var10000 = var1;
         var1.handleEntityLivingBase(this.entityLivingBase, var5 + var7 / 2.0F, var6 + var7, var13);
      }

      var10000.handleFloat27(var5, var6, var7, var7, 4.0F, var4);
   }

   private static float getFloatForValueSettingSub108(ValueSettingSub10 var0, float var1) {
      return var1 <= 0.0F ? 0.0F : (float)((double)var1 * (Double)var0.lambda15() / 100.0D);
   }

   private float getFloat78(Sampler0 var1, TargetHUDModule.SettingsTextRecord var2, float var3, float var4, float var5, int var6) {
      float var8 = var3 > 0.0F ? var3 + 3.0F : 0.0F;
      if ((var4 = Math.min(var5, var4 - var8)) <= 0.5F) {
         return var3;
      } else {
         var1.handleFloat7(var2.x() + var8, var2.y(), var4, var2.height(), Float.MAX_VALUE, var6);
         return var8 + var4;
      }
   }

   private boolean isFloat13(float var1, float var2, float var3) {
      if (this.entityLivingBase != null && this.entityLivingBase.isEntityAlive() && this.entityLivingBase2 != null) {
         if (!Util8.isEnabled44()) {
            return this.isFloat12(var1, var2);
         } else {
            Vec3 var5;
            if ((var5 = new Vec3(this.entityLivingBase.lastTickPosX + (this.entityLivingBase.posX - this.entityLivingBase.lastTickPosX) * (double)var3, this.entityLivingBase.lastTickPosY + (this.entityLivingBase.posY - this.entityLivingBase.lastTickPosY) * (double)var3 + (double)this.entityLivingBase.height + (double)this.valueSettingSub104.getFloat5(), this.entityLivingBase.lastTickPosZ + (this.entityLivingBase.posZ - this.entityLivingBase.lastTickPosZ) * (double)var3)).subtract(Util8.getVec313()).dotProduct(Util8.getVec315()) <= 0.05D) {
               return this.bool3 = false;
            } else {
               float[] var6;
               if ((var6 = Util8.getFloatArrayForVec3(var5, var1, var2)) == null) {
                  return this.bool3 = false;
               } else {
                  float var4 = this.bool3 ? 28.0F : 0.0F;
                  if (!(var6[0] < -var4) && !(var6[0] > var1 + var4) && !(var6[1] < -var4) && !(var6[1] > var2 + var4)) {
                     this.float_6 = var6[0];
                     this.float_7 = var6[1];
                     this.bool3 = true;
                     this.handleFloat73(var1, var2);
                     return true;
                  } else {
                     this.bool3 = false;
                     return false;
                  }
               }
            }
         }
      } else {
         return this.isFloat12(var1, var2);
      }
   }

   private void handleSampler041(Sampler0 var1, PrimaryOnPrimaryRecord var2, TargetHUDModule.SettingsTextRecord var3) {
      if (!var3.text().isEmpty()) {
         OpticalWeightRecord var4 = var3.style();
         int var7 = this.getInt43(var3.settings(), var2);
         float var5 = var3.settings().valueSettingSub10.getFloat5();
         float var6 = var3.y() + var3.height() / 2.0F;
         var1.handleOpticalWeightRecord5(var4, var3.text(), var3.x(), var1.getFloat19(var4, var6), var7, var5);
         var1.handleOpticalWeightRecord9(var4, var3.text(), var3.x(), var6, var7);
         if (((NumberHeartsEnum)var3.settings().valueSettingSub112.lambda15()).isEnabled7()) {
            float var8 = this.getFloat79(var4);
            var1.handleString6("\ue87d", var3.x() + var3.width() - var8 / 2.0F, var6, var8, var7);
         }
      }
   }

   protected void run79() {
      this.entityLivingBase = null;
      this.entityLivingBase2 = null;
      this.bool3 = false;
      this.bool4 = false;
      this.float_2 = 0.0F;
      this.long_ = 0L;
      this.float_4 = 0.0F;
      this.float_5 = 0.0F;
      this.cls5.getCls(0.0F);
      this.cls.getCls(1.0F);
      client.onyx.render.guide.Util.handleString("target-hud");
   }

   private EntityLivingBase getEntityLivingBase2() {
      EntityLivingBase var2;
      return (var2 = OnyxClient.cls.killAuraModule.getEntityLivingBase3()) != null && var2.isEntityAlive() ? var2 : null;
   }

   public boolean isDouble9(double var1, double var3) {
      return var1 >= (double)this.float_ && var1 < (double)(this.float_ + this.float_4) && var3 >= (double)this.float_8 && var3 < (double)(this.float_8 + this.float_5);
   }

   private void handleList15(List<TargetHUDModule.SettingsTextRecord> var1, TextSettingGroup var2, String var3, OpticalWeightRecord var4, float var5, float var6, float var7, float var8) {
      if (var2.isEnabled92()) {
         var1.add(new TargetHUDModule.SettingsTextRecord(var2, var3, var4, var5 + var2.valueSettingSub102.getFloat5(), var6 + var2.valueSettingSub103.getFloat5(), var7, var8));
      }
   }

   private float getFloat77(float var1) {
      if (MINECRAFT.thePlayer != null && this.entityLivingBase != MINECRAFT.thePlayer && MINECRAFT.thePlayer.isEntityAlive() && this.entityLivingBase.isEntityAlive() && Float.isFinite(var1)) {
         float var4 = Math.max(MINECRAFT.thePlayer.getMaxHealth(), 1.0F);
         var4 = Math.clamp(MINECRAFT.thePlayer.getHealth(), 0.0F, var4);
         float var3 = Math.max(MINECRAFT.thePlayer.getAbsorptionAmount(), 0.0F);
         return var4 + var3 - var1;
      } else {
         return 0.0F;
      }
   }

   private int getInt42(PrimaryOnPrimaryRecord var1, boolean var2, float var3) {
      if (var2) {
         return var1.primary();
      } else {
         float var4;
         if ((var4 = this.getFloat77(var3)) > 1.0F) {
            return var1.primary();
         } else {
            return var4 < -1.0F ? var1.error() : var1.onSurfaceVariant();
         }
      }
   }

   private float getFloat80(TextSettingGroup var1, OpticalWeightRecord var2) {
      return ((NumberHeartsEnum)var1.valueSettingSub112.lambda15()).isEnabled7() ? 2.0F + this.getFloat79(var2) : 0.0F;
   }

   public void handleSampler040(Sampler0 var1, float var2, float var3, float var4) {
      float var5 = this.getFloat81();
      boolean var6 = MINECRAFT.currentScreen instanceof GuiChat;
      this.handleBool20(var6, var5);
      this.handleFloat71(var5);
      boolean var13 = this.entityLivingBase2 == null;
      client.onyx.render.misc.Cls var10000 = this.cls5;
      float var10001;
      boolean var10002;
      if (var13) {
         var10001 = 0.0F;
         var10002 = var13;
      } else {
         var10001 = 1.0F;
         var10002 = var13;
      }

      float var19;
      boolean var10003;
      if (var10002) {
         var19 = 200.0F;
         var10003 = var13;
      } else {
         var19 = 300.0F;
         var10003 = var13;
      }

      var10000.getCls2(var10001, var19, var10003 ? client.onyx.render.misc.Util.IFACE : client.onyx.render.misc.Util.IFACE7);
      this.cls5.handleFloat(var5);
      if (this.entityLivingBase == null) {
         this.float_4 = 0.0F;
         this.float_5 = 0.0F;
         this.bool2 = this.isEnabled88();
         client.onyx.render.guide.Util.handleString("target-hud");
      } else {
         Util14.run();
         PrimaryOnPrimaryRecord var16 = Util4.getPrimaryOnPrimaryRecord();
         TargetHUDModule.WidthHeightRecord var8 = this.getWidthHeightRecord2(var1, var16, var6, var5);
         float var9 = this.valueSettingSub106.getFloat5() * (0.94F + 0.060000002F * this.cls5.getFloat());
         this.float_4 = var8.width() * var9;
         this.float_5 = var8.height() * var9;
         boolean var10 = this.valueSettingSub112.isEnum3(TargetHUDModule.ScreenWorldEnum.WORLD) && !var6 && this.isFloat13(var2, var3, var4);
         boolean var14 = false;
         TargetHUDModule var17;
         if (var10) {
            var17 = this;
            this.bool2 = this.isEnabled88();
            this.cls4.getFloatArray(false);
            client.onyx.render.guide.Util.handleString("target-hud");
         } else {
            float var15 = var2 - this.float_4 - 20.0F;
            float var11 = var3 - this.float_5 - 20.0F;
            this.float_ = 10.0F + getFloatForValueSettingSub108(this.valueSettingSub10, var15);
            this.float_8 = 10.0F + getFloatForValueSettingSub108(this.valueSettingSub105, var11);
            client.onyx.render.guide.Util.handleString2("target-hud", this.float_, this.float_8, this.float_4, this.float_5);
            var14 = this.isBool10(var6, var15, var11, var2, var3);
            if (var6 && var14 && !this.bool4) {
               float[] var12;
               if ((var12 = this.cls4.getFloatArray(true))[0] != 0.0F || var12[1] != 0.0F) {
                  handleValueSettingSub108(this.valueSettingSub10, getFloatForValueSettingSub108(this.valueSettingSub10, var15) + var12[0], var15);
                  handleValueSettingSub108(this.valueSettingSub105, getFloatForValueSettingSub108(this.valueSettingSub105, var11) + var12[1], var11);
               }
            } else {
               this.cls4.getFloatArray(false);
            }

            var17 = this;
            this.float_ = 10.0F + getFloatForValueSettingSub108(this.valueSettingSub10, var15);
            this.float_8 = 10.0F + getFloatForValueSettingSub108(this.valueSettingSub105, var11);
         }

         var17.cls3.getCls2(var6 ? 1.0F : 0.0F, 250.0F, client.onyx.render.misc.Util.IFACE2);
         this.cls3.handleFloat(var5);
         client.onyx.gui.Cls var18 = this.Ia;
         TargetHUDModule var20;
         if (var6 && var14) {
            var10002 = true;
            var20 = this;
         } else {
            var10002 = false;
            var20 = this;
         }

         var18.handleFloat(var5, var10002, var20.bool4);
         if (this.bool4) {
            Util3.handleSampler02(var1, var2, var3, this.xYRecord);
         }

         var1.handleFloat10(this.cls5.getFloat());
         var1.handleFloat10(this.valueSettingSub103.getFloat5() / 100.0F);
         var1.run36();
         var1.handleFloat11(this.float_, this.float_8);
         var1.handleFloat12(var9, 0.0F, 0.0F);
         this.handleSampler044(var1, var16, var8, true);
         var1.run43();
         var1.run40();
         var1.run40();
      }
   }

   private void handleEntityLivingBase7(EntityLivingBase var1) {
      EntityLivingBase var10001 = this.entityLivingBase = var1;
      this.bool3 = false;
      float var2 = Math.clamp(var10001.getHealth() / Math.max(var1.getMaxHealth(), 1.0F), 0.0F, 1.0F);
      this.la.getCls(var2);
      this.cls6.getCls(var2);
      this.Ja = var2;
      this.float_3 = 0.0F;
   }

   private void handlePrimaryOnPrimaryRecord2(PrimaryOnPrimaryRecord var1, boolean var2, float var3, float var4, float var5) {
      this.cls2.getCls22(var3 <= 0.3F ? var1.error() : var1.primary(), 250.0F, client.onyx.render.misc.Util.IFACE2);
      this.cls2.handleFloat(var5);
      this.cls22.getCls22(this.getInt42(var1, var2, var4), 250.0F, client.onyx.render.misc.Util.IFACE2);
      this.cls22.handleFloat(var5);
   }

   private boolean isEnabled88() {
      return Mouse.isButtonDown(0);
   }

   public TargetHUDModule.WidthHeightRecord getWidthHeightRecord(Sampler0 var1, PrimaryOnPrimaryRecord var2, float var3) {
      if (MINECRAFT.thePlayer == null) {
         return null;
      } else {
         this.entityLivingBase = MINECRAFT.thePlayer;
         this.entityLivingBase2 = MINECRAFT.thePlayer;
         this.cls.getCls(1.0F);
         this.cls5.getCls(1.0F);
         return this.getWidthHeightRecord2(var1, var2, false, var3);
      }
   }

   private String getString29(boolean var1, float var2) {
      if (var1) {
         return "Drag to move";
      } else {
         float var3;
         if ((var3 = this.getFloat77(var2)) > 1.0F) {
            return "Winning";
         } else {
            return var3 < -1.0F ? "Losing" : "Even";
         }
      }
   }

   private boolean isFloat12(float var1, float var2) {
      if (!this.bool3) {
         return false;
      } else {
         this.handleFloat73(var1, var2);
         return true;
      }
   }

   public TargetHUDModule.WidthHeightRecord getWidthHeightRecord2(Sampler0 var1, PrimaryOnPrimaryRecord var2, boolean var3, float var4) {
      PrimaryOnPrimaryRecord var10002 = var2;
      float var27 = Math.max(this.entityLivingBase.getMaxHealth(), 1.0F);
      float var25 = Math.clamp(this.entityLivingBase.getHealth(), 0.0F, var27);
      float var6 = Math.max(this.entityLivingBase.getAbsorptionAmount(), 0.0F);
      float var7;
      this.handleFloat72(var7 = var25 / var27, var4);
      this.handlePrimaryOnPrimaryRecord2(var10002, var3, var7, var25 + var6, var4);
      boolean var31 = this.aa.valueSettingSub93.isEnabled17();
      Util.NameHealthRecord var35 = new Util.NameHealthRecord(client.onyx.system.Util5.getStringForString(this.entityLivingBase.getName()), var25 + (var31 ? var6 : 0.0F), var27, (float)Math.sqrt(client.onyx.system.Util4.getDoubleForEntity5(this.entityLivingBase)), this.getString29(var3, var25 + var6));
      OpticalWeightRecord var32 = this.getOpticalWeightRecord(this.textSettingGroup2, Util2.OPTICAL_WEIGHT_RECORD9);
      OpticalWeightRecord var8 = this.getOpticalWeightRecord(this.textSettingGroup4, Util2.OPTICAL_WEIGHT_RECORD9);
      OpticalWeightRecord var9 = this.getOpticalWeightRecord(this.textSettingGroup, Util2.OPTICAL_WEIGHT_RECORD8);
      OpticalWeightRecord var10 = this.getOpticalWeightRecord(this.textSettingGroup3, Util2.OPTICAL_WEIGHT_RECORD8);
      String var11 = var1.getString17(var32, this.getString28(this.textSettingGroup2, var32, var35), 80.0F * this.textSettingGroup2.valueSettingSub104.getFloat5());
      String var12 = this.getString28(this.textSettingGroup4, var8, var35);
      String var28 = var3 ? "" : this.getString28(this.textSettingGroup, var9, var35);
      String var36 = this.getString28(this.textSettingGroup3, var10, var35);
      if (this.textSettingGroup.isEnabled92() && this.textSettingGroup3.isEnabled92() && !var28.isEmpty()) {
         var28 = (new StringBuilder()).insert(0, var28).append(" · ").toString();
      }

      float var13 = this.Da.isEnabled92() ? 26.0F * this.Da.valueSettingSub104.getFloat5() : 0.0F;
      float var14 = 11.0F + (this.Da.isEnabled92() ? var13 + 9.0F : 0.0F);
      float var15 = this.textSettingGroup2.isEnabled92() ? var1.getFloat17(var32, var11) : 0.0F;
      float var16 = this.textSettingGroup4.isEnabled92() ? var1.getFloat17(var8, var12) + this.getFloat80(this.textSettingGroup4, var8) : 0.0F;
      float var17 = this.textSettingGroup.isEnabled92() ? var1.getFloat17(var9, var28) : 0.0F;
      float var18 = this.textSettingGroup3.isEnabled92() ? var1.getFloat17(var10, var36) : 0.0F;
      float var26 = var15 + var16 + (this.textSettingGroup2.isEnabled92() && this.textSettingGroup4.isEnabled92() ? 8.0F : 0.0F);
      float var19 = var17 + var18;
      this.fa.getCls2(Math.max(62.0F, Math.max(var26, var19)), 300.0F, client.onyx.render.misc.Util.IFACE2);
      this.fa.handleFloat(var4);
      var26 = var14 + this.fa.getFloat() + 11.0F;
      var4 = this.aa.valueSettingSub105.getFloat5();
      float var10000;
      TargetHUDModule var10001;
      if (this.textSettingGroup2.isEnabled92()) {
         var10000 = var32.getFloat3();
         var10001 = this;
      } else {
         var10000 = 0.0F;
         var10001 = this;
      }

      var19 = Math.max(var10000, var10001.textSettingGroup4.isEnabled92() ? var8.getFloat3() : 0.0F);
      if (this.textSettingGroup.isEnabled92()) {
         var10000 = var9.getFloat3();
         var10001 = this;
      } else {
         var10000 = 0.0F;
         var10001 = this;
      }

      float var20 = Math.max(var10000, var10001.textSettingGroup3.isEnabled92() ? var10.getFloat3() : 0.0F);
      float var21 = var19 + var20 + (var19 > 0.0F && var20 > 0.0F ? 4.0F : 0.0F);
      float var22 = Math.max(var13, var21);
      float var23 = 8.0F + (var22 - var13) / 2.0F;
      float var24;
      var19 = (var24 = 8.0F + (var22 - var21) / 2.0F) + var19 / 2.0F;
      var20 = var24 + var21 - var20 / 2.0F;
      var21 = 8.0F + var22 + 6.0F;
      var22 = (this.aa.isEnabled92() ? var21 + var4 : 8.0F + var22) + 8.0F;
      ArrayList var34 = new ArrayList(6);
      this.handleList15(var34, this.Da, (String)null, (OpticalWeightRecord)null, 11.0F, var23, var13, var13);
      this.handleList15(var34, this.textSettingGroup2, var11, var32, var14, var19 - var32.getFloat3() / 2.0F, var15, var32.getFloat3());
      this.handleList15(var34, this.textSettingGroup4, var12, var8, var26 - 11.0F - var16, var19 - var8.getFloat3() / 2.0F, var16, var8.getFloat3());
      this.handleList15(var34, this.textSettingGroup, var28, var9, var14, var20 - var9.getFloat3() / 2.0F, var17, var9.getFloat3());
      this.handleList15(var34, this.textSettingGroup3, var36, var10, var14 + var17, var20 - var10.getFloat3() / 2.0F, var18, var10.getFloat3());
      this.handleList15(var34, this.aa, (String)null, (OpticalWeightRecord)null, 11.0F, var21, Math.max(0.0F, var26 - 22.0F), var4);
      float var29 = var22;

      Iterator var30;
      for(Iterator var33 = var30 = var34.iterator(); var33.hasNext(); var33 = var30) {
         TargetHUDModule.SettingsTextRecord var37 = (TargetHUDModule.SettingsTextRecord)var30.next();
         var29 = Math.max(var29, var37.y() + var37.height() + 8.0F);
      }

      return new TargetHUDModule.WidthHeightRecord(var26, var29, var34, var6 / var27);
   }

   public void run122() {
      this.entityLivingBase2 = this.entityLivingBase = null;
      this.bool3 = false;
      this.cls5.getCls(0.0F);
   }

   private OpticalWeightRecord getOpticalWeightRecord(TextSettingGroup var1, OpticalWeightRecord var2) {
      client.onyx.render.font.Util.ThinExtraLightEnum var3 = (client.onyx.render.font.Util.ThinExtraLightEnum)var1.valueSettingSub11.lambda15();
      float var4;
      return (var4 = var1.valueSettingSub104.getFloat5()) == 1.0F && var3 == var2.weight() ? var2 : new OpticalWeightRecord(var2.optical(), var3, var2.size() * var4, var2.lineHeight() * var4);
   }

   private void handleFloat71(float var1) {
      this.cls.handleFloat(var1);
      if (this.entityLivingBase2 == this.entityLivingBase) {
         if (this.entityLivingBase != null && this.cls.getFloat2() < 1.0F) {
            this.cls.getCls2(1.0F, 150.0F, client.onyx.render.misc.Util.IFACE7);
         }

      } else if (this.entityLivingBase2 == null) {
         if (this.cls5.isEnabled() && this.cls5.getFloat() <= 0.0F) {
            this.entityLivingBase = null;
         }

      } else if (this.entityLivingBase != null && !(this.cls5.getFloat() <= 0.0F)) {
         if (this.cls.getFloat2() > 0.0F) {
            this.cls.getCls2(0.0F, 100.0F, client.onyx.render.misc.Util.IFACE);
         } else {
            if (this.cls.isEnabled()) {
               this.handleEntityLivingBase7(this.entityLivingBase2);
               this.cls.getCls(0.0F).getCls2(1.0F, 150.0F, client.onyx.render.misc.Util.IFACE7);
            }

         }
      } else {
         this.handleEntityLivingBase7(this.entityLivingBase2);
         this.cls.getCls(1.0F);
      }
   }

   public static enum ScreenWorldEnum {
      SCREEN,
      WORLD;

   }

   public static record WidthHeightRecord(float width, float height, List<TargetHUDModule.SettingsTextRecord> parts, float shield) {
      public float width() {
         return this.width;
      }

      public float shield() {
         return this.shield;
      }

      public List<TargetHUDModule.SettingsTextRecord> parts() {
         return this.parts;
      }


      public float height() {
         return this.height;
      }
   }

   public static record SettingsTextRecord(TextSettingGroup settings, String text, OpticalWeightRecord style, float x, float y, float width, float height) {
      public OpticalWeightRecord style() {
         return this.style;
      }

      public TextSettingGroup settings() {
         return this.settings;
      }

      public float y() {
         return this.y;
      }

      public float x() {
         return this.x;
      }

      public float height() {
         return this.height;
      }

      public float width() {
         return this.width;
      }

      public AvatarNameEnum getAvatarNameEnum() {
         return this.settings.getAvatarNameEnum();
      }


      public String text() {
         return this.text;
      }
   }
}
