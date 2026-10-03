package client.onyx.module.render;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Util;
import client.onyx.render.Util4;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.SettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import java.util.Locale;
import java.util.function.BooleanSupplier;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public final class HandModule extends Module {
   private static final double DOUBLE = 45.0;
   private static final double DOUBLE2 = -0.52;
   public final HandModule.AnimationSettingGroup animationSettingGroup;
   private static final double DOUBLE3 = 0.4;
   private static final float FLOAT = 0.5F;
   private static final double DOUBLE4 = -0.72;
   private static final double DOUBLE5 = 0.56;
   public final HandModule.EffectsSettingGroup effectsSettingGroup = new HandModule.EffectsSettingGroup();
   private static final long LONG = 140000000L;
   private static final long LONG2 = 300000000L;
   private float float_;
   private final HandModule.Cls2 cls2;
   private long long_;
   private static final long LONG3 = 260000000L;
   private float float_2;
   private static final float FLOAT2 = 0.25F;
   public final HandModule.ResetToVanillaBooleanSetting resetToVanillaBooleanSetting = new HandModule.ResetToVanillaBooleanSetting("Main hand");

   public boolean isItemStack3(ItemStack var1, float var2) {
      if (!this.isItemStack2(var1)) {
         return false;
      } else {
         float var3;
         HandModule var10000;
         if (Util.isEnabled38()) {
            var10000 = this;
            var3 = this.float_2;
         } else {
            var3 = Math.max(Math.clamp(var2, 0.0F, 1.0F), this.getFloat63());
            var10000 = this;
            this.float_2 = var3;
         }

         var10000.handleFloat61(var3);
         return true;
      }
   }

   private void handleFloat65(float var1) {
      float var2 = -0.4F * (float)Math.sin(Math.sqrt(var1) * Math.PI);
      float var3 = 0.2F * (float)Math.sin(Math.sqrt(var1) * Math.PI * 2.0);
      float var4 = -0.2F * (float)Math.sin(var1 * Math.PI);
      GlStateManager.translate(var2, var3, var4);
      this.handleFloat62(var1);
   }

   private boolean isEnabled73() {
      return this.isEnabled55()
         && MINECRAFT.thePlayer != null
         && MINECRAFT.thePlayer.isBlocking()
         && MINECRAFT.thePlayer.getHeldItem() != null
         && MINECRAFT.thePlayer.getHeldItem().getItem() instanceof ItemSword;
   }

   public void run102() {
      float var2 = Util4.getFloat14();
      GlStateManager.scale(
         this.resetToVanillaBooleanSetting.valueSettingSub108.getFloat5() * var2,
         this.resetToVanillaBooleanSetting.valueSettingSub105.getFloat5() * var2,
         this.resetToVanillaBooleanSetting.valueSettingSub107.getFloat5() * var2
      );
   }

   private float getFloat63() {
      if (!MINECRAFT.gameSettings.keyBindAttack.isKeyDown()) {
         this.long_ = -1L;
         return 0.0F;
      } else {
         if (this.long_ < 0L) {
            this.long_ = System.nanoTime();
         }

         return (float)((System.nanoTime() - this.long_) % 260000000L) / 2.6E8F;
      }
   }

   public float getFloat66() {
      return this.effectsSettingGroup.trailBooleanSetting.valueSettingSub92.isEnabled17() ? 0.0F : 1.0F;
   }

   private boolean isEnabled70() {
      ItemStack var2;
      return !this.animationSettingGroup.valueSettingSub92.isEnabled17()
         ? true
         : (var2 = MINECRAFT.thePlayer.getHeldItem()) != null && var2.getItem() instanceof ItemSword;
   }

   private int getInt37() {
      if (MINECRAFT.thePlayer == null) {
         return -1;
      } else {
         ItemStack var2;
         if ((var2 = MINECRAFT.thePlayer.getHeldItem()) != null && var2.getItem() != null) {
            String var3;
            if ((var3 = var2.getItem().getUnlocalizedName().toLowerCase(Locale.ROOT)).contains("diamond")) {
               return -11149856;
            } else if (var3.contains("gold")) {
               return -11174;
            } else if (var3.contains("iron")) {
               return -2564376;
            } else if (var3.contains("emerald")) {
               return -13250449;
            } else if (var3.contains("redstone")) {
               return -1950917;
            } else {
               return !var3.contains("lapis") && !var3.contains("dyepowder") ? -1644826 : -13543724;
            }
         } else {
            return -1;
         }
      }
   }

   private boolean isEnabled74() {
      return this.animationSettingGroup.isEnabled5() && this.animationSettingGroup.valueSettingSub94.isEnabled17() && this.isEnabled70();
   }

   public int getInt36() {
      HandModule.TrailBooleanSetting var2 = this.effectsSettingGroup.trailBooleanSetting;
      return this.effectsSettingGroup.trailBooleanSetting.valueSettingSub92.isEnabled17() ? this.getInt37() : var2.valueSettingSub6.lambda15();
   }

   public float getFloat64() {
      return 0.5F;
   }

   public HandModule.TrailBooleanSetting getTrailBooleanSetting() {
      if (!this.isEnabled55() || MINECRAFT.thePlayer == null) {
         return null;
      } else {
         return this.effectsSettingGroup.isEnabled5() && this.effectsSettingGroup.valueSettingSub11.isEnum3(HandModule.GlintSmokeEnum.SMOKE)
            ? this.effectsSettingGroup.trailBooleanSetting
            : null;
      }
   }

   public HandModule() {
      super("Hand", "Adjust the first-person hand and replace the sword swing", ModuleCategory.RENDER);
      this.animationSettingGroup = new HandModule.AnimationSettingGroup();
      this.cls2 = new HandModule.Cls2();
      this.long_ = -1L;
      this.animationSettingGroup.valueSettingSub1011.getModeSetting3(var1 -> this.cls2.run2());
   }

   static ValueSettingSub10 getValueSettingSub10ForString(String var0, double var1) {
      return new ValueSettingSub10(var0, var1, -360.0, 360.0, 1.0).getValueSettingSub10("deg");
   }

   private static float getFloatForFloat15(float var0, float var1, float var2) {
      float var4 = (var1 - var0) * var2;
      return var0 + var4;
   }

   private static float getFloatForLinearSmoothEnum(HandModule.LinearSmoothEnum var0, float var1) {
      switch (var0) {
         case LINEAR:

            return var1;
         case SMOOTH:
            return var1 * var1 * (3.0F - 2.0F * var1);
         case EASE_OUT:
            float var6 = (1.0F - var1) * (1.0F - var1);
            return 1.0F - var6;
         case SIN:
            return (float)Math.sin(var1 * Math.PI / 2.0);
         case SQRT:
            return (float)Math.sqrt(var1);
         default:
            throw new MatchException(null, null);
      }
   }

   private static float getFloatForFloat14(float var0, float var1) {
      return Math.max(0.01F, getFloatForFloat15(1.0F, var0, var1));
   }

   @Override
   protected void run79() {
      this.cls2.run2();
   }

   private static void handleFloat63(float var0, float var1, float var2, float var3) {
      if (var0 != 0.0F) {
         GlStateManager.rotate(var0, var1, var2, var3);
      }
   }

   private boolean isEnabled72() {
      return OnyxClient.cls.killAuraModule.isEnabled55() && OnyxClient.cls.killAuraModule.getEntityLivingBase3() != null;
   }

   private void handleFloat61(float var1) {
      float var2;
      GlStateManager.translate(0.0F, (var2 = -((float)Math.sin(Math.sqrt(var1) * Math.PI)) * 2.0F) / 10.0F + 0.1F, 0.0F);
      handleFloat63(var2 * 10.0F, 0.0F, 1.0F, 0.0F);
      handleFloat63(250.0F, 0.2F, 1.0F, -0.6F);
      handleFloat63(-10.0F, 1.0F, 0.5F, 1.0F);
      handleFloat63(-var2 * 20.0F, 1.0F, 0.5F, 1.0F);
   }

   private float getFloat65(float var1) {
      if (this.isEnabled72()) {
         long var2 = HandModule.Cls2.getLongForLong(140000000L, this.animationSettingGroup.valueSettingSub1011.getFloat5());
         return this.cls2.getFloat2(var2);
      } else {
         this.cls2.run();
         return this.cls2.getFloat(var1, HandModule.Cls2.getLongForLong(300000000L, this.animationSettingGroup.valueSettingSub1011.getFloat5()));
      }
   }

   public boolean isFloat11(float var1) {
      if (!this.isEnabled55() || MINECRAFT.thePlayer == null) {
         return false;
      } else if (this.isEnabled71()) {
         return true;
      } else if (!this.animationSettingGroup.isEnabled5()) {
         this.cls2.run2();
         this.handleFloat65(var1);
         return true;
      } else if (!this.isEnabled70()) {
         return false;
      } else if (this.animationSettingGroup.valueSettingSub93.isEnabled17()) {
         this.handleFloat65(var1);
         return this.isEnabled74();
      } else {
         float var2;
         HandModule var10000;
         if (Util.isEnabled38()) {
            var2 = this.float_;
            var10000 = this;
         } else {
            float var3 = this.animationSettingGroup.valueSettingSub106.getFloat5() / 100.0F;
            var1 = this.getFloat65(Math.clamp(var1, 0.0F, 1.0F));
            var2 = (float)Math.sin(getFloatForLinearSmoothEnum(this.animationSettingGroup.valueSettingSub11.lambda15(), var1) * Math.PI) * var3;
            var10000 = this;
            this.float_ = var2;
         }

         var10000.handleFloat64(var2);
         return this.isEnabled74();
      }
   }

   private void handleFloat64(float var1) {
      GlStateManager.translate(
         this.animationSettingGroup.valueSettingSub10.getFloat5() * var1,
         this.animationSettingGroup.valueSettingSub107.getFloat5() * var1,
         this.animationSettingGroup.valueSettingSub103.getFloat5() * var1
      );
      handleFloat63(this.animationSettingGroup.valueSettingSub108.getFloat5() * var1, 1.0F, 0.0F, 0.0F);
      handleFloat63(this.animationSettingGroup.valueSettingSub109.getFloat5() * var1, 0.0F, 1.0F, 0.0F);
      handleFloat63(this.animationSettingGroup.valueSettingSub102.getFloat5() * var1, 0.0F, 0.0F, 1.0F);
      GlStateManager.scale(
         getFloatForFloat14(this.animationSettingGroup.valueSettingSub1010.getFloat5(), var1),
         getFloatForFloat14(this.animationSettingGroup.valueSettingSub105.getFloat5(), var1),
         getFloatForFloat14(this.animationSettingGroup.valueSettingSub104.getFloat5(), var1)
      );
   }

   public HandModule.GlintBooleanSetting getGlintBooleanSetting() {
      if (!this.isEnabled55() || MINECRAFT.thePlayer == null) {
         return null;
      } else {
         return this.effectsSettingGroup.isEnabled5() && this.effectsSettingGroup.valueSettingSub11.isEnum3(HandModule.GlintSmokeEnum.GLINT)
            ? this.effectsSettingGroup.glintBooleanSetting
            : null;
      }
   }

   private void handleFloat62(float var1) {
      float var2 = (float)Math.sin(var1 * var1 * Math.PI);
      var1 = (float)Math.sin(Math.sqrt(var1) * Math.PI);
      handleFloat63(var2 * -20.0F, 0.0F, 1.0F, 0.0F);
      handleFloat63(var1 * -20.0F, 0.0F, 0.0F, 1.0F);
      handleFloat63(var1 * -80.0F, 1.0F, 0.0F, 0.0F);
   }

   private boolean isEnabled71() {
      return this.isEnabled73() && this.animationSettingGroup.isEnabled5();
   }

   public boolean isFloat10(float var1, float var2) {
      if (this.isEnabled55() && MINECRAFT.thePlayer != null) {
         GlStateManager.translate(
            this.resetToVanillaBooleanSetting.valueSettingSub102.getFloat5(),
            this.resetToVanillaBooleanSetting.valueSettingSub109.getFloat5() - var1 * 0.6F,
            this.resetToVanillaBooleanSetting.valueSettingSub106.getFloat5()
         );
         Util4.run32();
         handleFloat63(this.resetToVanillaBooleanSetting.valueSettingSub103.getFloat5(), 1.0F, 0.0F, 0.0F);
         handleFloat63(this.resetToVanillaBooleanSetting.valueSettingSub10.getFloat5(), 0.0F, 1.0F, 0.0F);
         handleFloat63(this.resetToVanillaBooleanSetting.valueSettingSub104.getFloat5(), 0.0F, 0.0F, 1.0F);
         this.handleFloat62(Math.clamp(var2, 0.0F, 1.0F));
         this.run102();
         return true;
      } else {
         return false;
      }
   }

   public boolean isFloat9(float var1) {
      if (this.isEnabled55() && MINECRAFT.thePlayer != null) {
         boolean var2 = !this.isEnabled71();
         float var4 = this.isEnabled74() ? 0.0F : var1 * 0.6F;
         GlStateManager.translate(
            this.resetToVanillaBooleanSetting.valueSettingSub102.getFloat5(),
            this.resetToVanillaBooleanSetting.valueSettingSub109.getFloat5() - var4,
            this.resetToVanillaBooleanSetting.valueSettingSub106.getFloat5()
         );
         Util4.run32();
         if (var2) {
            handleFloat63(this.resetToVanillaBooleanSetting.valueSettingSub103.getFloat5(), 1.0F, 0.0F, 0.0F);
            handleFloat63(this.resetToVanillaBooleanSetting.valueSettingSub10.getFloat5(), 0.0F, 1.0F, 0.0F);
            handleFloat63(this.resetToVanillaBooleanSetting.valueSettingSub104.getFloat5(), 0.0F, 0.0F, 1.0F);
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean isItemStack2(ItemStack var1) {
      return this.isEnabled71() && var1 != null && var1.getItem() instanceof ItemSword;
   }

   public static final class AnimationSettingGroup extends SettingGroup {
      public final ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Swords only", false);
      public ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub11<HandModule.LinearSmoothEnum> valueSettingSub11;
      public final ValueSettingSub10 valueSettingSub102;
      public ValueSettingSub10 valueSettingSub103;
      public ValueSettingSub10 valueSettingSub104;
      public ValueSettingSub10 valueSettingSub105;
      public ValueSettingSub10 valueSettingSub106;
      public ValueSettingSub10 valueSettingSub107;
      public ValueSettingSub10 valueSettingSub108;
      public final ValueSettingSub9 valueSettingSub93;
      public final ValueSettingSub10 valueSettingSub109;
      public final ValueSettingSub10 valueSettingSub1010;
      public final ValueSettingSub10 valueSettingSub1011;
      public final ValueSettingSub9 valueSettingSub94 = new ValueSettingSub9("Replace vanilla swing", true);

      private ValueSettingSub10 getValueSettingSub104(String var1) {
         return new ValueSettingSub10(var1, 1.0, 0.1, 3.0, 0.01);
      }

      private ValueSettingSub10 getValueSettingSub103(String var1, double var2) {
         return new ValueSettingSub10(var1, var2, -720.0, 720.0, 1.0).getValueSettingSub10("deg");
      }

      private AnimationSettingGroup() {
         super("Animation", true);
         this.valueSettingSub93 = new ValueSettingSub9("Match vanilla", false).getBooleanSetting("Uses vanilla's own swing motion instead of the curve below");
         this.valueSettingSub106 = new ValueSettingSub10("Strength", 100.0, 0.0, 200.0, 5.0).getValueSettingSub10("%");
         this.valueSettingSub11 = new ValueSettingSub11<>("Curve", HandModule.LinearSmoothEnum.SMOOTH);
         this.valueSettingSub1011 = new ValueSettingSub10("Speed", 1.0, 0.1, 5.0, 0.05).getValueSettingSub10("x");
         this.valueSettingSub10 = this.getValueSettingSub102("Animation X");
         this.valueSettingSub107 = this.getValueSettingSub102("Animation Y");
         this.valueSettingSub103 = this.getValueSettingSub102("Animation Z");
         this.valueSettingSub108 = this.getValueSettingSub103("Animation rotation X", -51.0);
         this.valueSettingSub109 = this.getValueSettingSub103("Animation rotation Y", 0.0);
         this.valueSettingSub102 = this.getValueSettingSub103("Animation rotation Z", 0.0);
         this.valueSettingSub1010 = this.getValueSettingSub104("Animation scale X");
         this.valueSettingSub105 = this.getValueSettingSub104("Animation scale Y");
         this.valueSettingSub104 = this.getValueSettingSub104("Animation scale Z");
      }

      private ValueSettingSub10 getValueSettingSub102(String var1) {
         return new ValueSettingSub10(var1, 0.0, -2.0, 2.0, 0.01);
      }
   }

   private static final class Cls2 {
      private float float_;
      private long long_;
      private long long_2 = -1L;
      private static final float FLOAT = 1.0E-4F;
      private long long_3;

      void run2() {
         this.long_2 = -1L;
         this.long_ = 300000000L;
         this.float_ = 0.0F;
         this.long_3 = -1L;
      }

      private Cls2() {
         this.long_ = 300000000L;
         this.long_3 = -1L;
      }

      float getFloat(float var1, long var2) {
         long var4 = System.nanoTime();
         boolean var10 = var1 > 1.0E-4F && (this.float_ <= 1.0E-4F || var1 + 1.0E-4F < this.float_);
         this.float_ = var1;
         if (var10) {
            this.long_2 = var4;
            this.long_ = var2;
         }

         if (this.long_2 < 0L) {
            return 0.0F;
         } else {
            float var8;
            if ((var8 = (float)(var4 - this.long_2) / (float)this.long_) >= 1.0F) {
               this.long_2 = -1L;
               return 0.0F;
            } else {
               return Math.clamp(var8, 0.0F, 1.0F);
            }
         }
      }

      static long getLongForLong(long var0, float var2) {
         return Math.max(1L, (long)((float)var0 / Math.max(var2, 0.01F)));
      }

      float getFloat2(long var1) {
         long var3 = System.nanoTime();
         if (this.long_3 < 0L) {
            this.long_3 = var3;
         }

         return (float)((var3 - this.long_3) % var1) / (float)var1;
      }

      void run() {
         this.long_3 = -1L;
      }
   }

   public static final class EffectsSettingGroup extends SettingGroup {
      public final HandModule.TrailBooleanSetting trailBooleanSetting;
      public final ValueSettingSub11<HandModule.GlintSmokeEnum> valueSettingSub11 = new ValueSettingSub11<>("Effect", HandModule.GlintSmokeEnum.GLINT);
      public final HandModule.GlintBooleanSetting glintBooleanSetting = new HandModule.GlintBooleanSetting()
         .getSetting2(() -> this.valueSettingSub11.isEnum3(HandModule.GlintSmokeEnum.GLINT));

      private EffectsSettingGroup() {
         super("Effects", false);
         HandModule.TrailBooleanSetting var1 = new HandModule.TrailBooleanSetting();
         BooleanSupplier var2 = () -> this.valueSettingSub11.isEnum3(HandModule.GlintSmokeEnum.SMOKE);
         HandModule.TrailBooleanSetting var3 = var1.getSetting2(var2);
         this.trailBooleanSetting = var3;
      }
   }

   public static final class GlintBooleanSetting extends BooleanSetting {
      public ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub9 valueSettingSub92;
      public final ValueSettingSub10 valueSettingSub102;
      public ValueSettingSub10 valueSettingSub103;
      public final ValueSettingSub6 valueSettingSub6;
      public ValueSettingSub10 valueSettingSub104;
      public final ValueSettingSub6 valueSettingSub62 = new ValueSettingSub6("Color", -3105793).getValueSettingSub6();
      public ValueSettingSub10 valueSettingSub105;
      public ValueSettingSub10 valueSettingSub106;
      public ValueSettingSub10 valueSettingSub107;

      public HandModule.GlintBooleanSetting getSetting2(BooleanSupplier var1) {
         super.getSetting2(var1);
         return this;
      }

      private GlintBooleanSetting() {
         super("Glint");
         this.valueSettingSub6 = new ValueSettingSub6("Color 2", -6559745)
            .getValueSettingSub6()
            .getValueSettingSub63(14.0)
            .getBooleanSetting("When following the accent, shifted slightly so the glint keeps a gradient");
         this.valueSettingSub106 = new ValueSettingSub10("Alpha", 100.0, 0.0, 100.0, 5.0).getValueSettingSub10("%");
         this.valueSettingSub92 = new ValueSettingSub9("Outline only", false);
         this.valueSettingSub104 = new ValueSettingSub10("Outline", 2.0, 0.0, 8.0, 0.5).getValueSettingSub10(" px");
         this.valueSettingSub103 = new ValueSettingSub10("Glow", 125.0, 0.0, 200.0, 5.0).getValueSettingSub10("%");
         this.valueSettingSub10 = new ValueSettingSub10("Fill", 35.0, 0.0, 200.0, 5.0)
            .getValueSettingSub10("%")
            .getSetting2(() -> !this.valueSettingSub92.isEnabled17());
         this.valueSettingSub105 = new ValueSettingSub10("Padding", 16.0, 0.0, 20.0, 1.0)
            .getValueSettingSub10(" px")
            .getBooleanSetting("Distance the glint sits away from the item");
         this.valueSettingSub102 = new ValueSettingSub10("Smoothing", 30.0, 0.0, 32.0, 0.5)
            .getValueSettingSub10(" px")
            .getBooleanSetting("Softens the silhouette before the glint traces it");
         this.valueSettingSub107 = new ValueSettingSub10("Speed", 1.0, 0.1, 5.0, 0.05).getValueSettingSub10("x");
      }
   }

   public static enum GlintSmokeEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      GLINT("Glint"),
      SMOKE("Smoke");
      private final String string;


      private GlintSmokeEnum(String var3) {
         this.string = var3;
      }

      @Override
      public String getString5() {
         return this.string;
      }
   }

   public static enum LinearSmoothEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      LINEAR("Linear"),
      SMOOTH("Smooth"),
      EASE_OUT("Ease out"),
      SIN("Sin"),
      SQRT("Square root");
      private final String string;

      @Override
      public String getString5() {
         return this.string;
      }


      private LinearSmoothEnum(String var3) {
         this.string = var3;
      }
   }

   public static final class ResetToVanillaBooleanSetting extends BooleanSetting {
      public ValueSettingSub10 valueSettingSub10;
      public final SettingSub settingSub = new SettingSub("Reset to vanilla", () -> {
         this.valueSettingSub102.handleObject2(0.56);
         this.valueSettingSub109.handleObject2(-0.52);
         this.valueSettingSub106.handleObject2(-0.72);
         this.valueSettingSub108.handleObject2(0.4);
         this.valueSettingSub105.handleObject2(0.4);
         this.valueSettingSub107.handleObject2(0.4);
         this.valueSettingSub103.handleObject2(0.0);
         this.valueSettingSub10.handleObject2(45.0);
         this.valueSettingSub104.handleObject2(0.0);
      }).getBooleanSetting("Restore the hand transform to Minecraft's own first-person placement");
      public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Position X", 0.56, -2.0, 2.0, 0.01);
      public ValueSettingSub10 valueSettingSub103;
      public ValueSettingSub10 valueSettingSub104;
      public ValueSettingSub10 valueSettingSub105;
      public ValueSettingSub10 valueSettingSub106;
      public ValueSettingSub10 valueSettingSub107;
      public ValueSettingSub10 valueSettingSub108;
      public final ValueSettingSub10 valueSettingSub109 = new ValueSettingSub10("Position Y", -0.52, -2.0, 2.0, 0.01);

      private ResetToVanillaBooleanSetting(String var1) {
         super(var1);
         this.valueSettingSub106 = new ValueSettingSub10("Position Z", -0.72, -2.0, 2.0, 0.01);
         this.valueSettingSub108 = new ValueSettingSub10("Scale X", 0.4, 0.02, 3.0, 0.01);
         this.valueSettingSub105 = new ValueSettingSub10("Scale Y", 0.4, 0.02, 3.0, 0.01);
         this.valueSettingSub107 = new ValueSettingSub10("Scale Z", 0.4, 0.02, 3.0, 0.01);
         this.valueSettingSub103 = HandModule.getValueSettingSub10ForString("Rotation X", 0.0);
         this.valueSettingSub10 = HandModule.getValueSettingSub10ForString("Rotation Y", 45.0);
         this.valueSettingSub104 = HandModule.getValueSettingSub10ForString("Rotation Z", 0.0);
      }
   }

   public static final class TrailBooleanSetting extends BooleanSetting {
      public final ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub10 valueSettingSub102;
      public final ValueSettingSub10 valueSettingSub103;
      public final ValueSettingSub6 valueSettingSub6;
      public final ValueSettingSub10 valueSettingSub104;
      public final ValueSettingSub10 valueSettingSub105;
      public final ValueSettingSub10 valueSettingSub106;
      public final ValueSettingSub10 valueSettingSub107;
      public final ValueSettingSub10 valueSettingSub108;
      public final ValueSettingSub10 valueSettingSub109;
      public final ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Item color", true)
         .getBooleanSetting("Takes the trail color from the hand and the held item");

      public float getFloat40() {
         return 0.25F;
      }

      public HandModule.TrailBooleanSetting getSetting2(BooleanSupplier var1) {
         super.getSetting2(var1);
         return this;
      }

      private TrailBooleanSetting() {
         super("Trail");
         this.valueSettingSub6 = new ValueSettingSub6("Color", -10079233).getValueSettingSub6().getSetting2(() -> !this.valueSettingSub92.isEnabled17());
         this.valueSettingSub106 = new ValueSettingSub10("Intensity", 0.85, 0.1, 1.5, 0.01);
         this.valueSettingSub109 = new ValueSettingSub10("Speed", 1.15, 0.2, 3.0, 0.05).getValueSettingSub10("x");
         this.valueSettingSub104 = new ValueSettingSub10("Length", 0.72, 0.1, 1.0, 0.05);
         this.valueSettingSub103 = new ValueSettingSub10("Trail fade", 0.91, 0.55, 0.98, 0.01);
         this.valueSettingSub107 = new ValueSettingSub10("Trail softness", 1.35, 0.45, 2.5, 0.05);
         this.valueSettingSub10 = new ValueSettingSub10("Trail blur", 1.55, 0.2, 3.0, 0.05);
         this.valueSettingSub105 = new ValueSettingSub10("Hand softness", 1.3, 0.45, 2.5, 0.05);
         this.valueSettingSub102 = new ValueSettingSub10("Hand blur", 1.45, 0.2, 3.0, 0.05);
         this.valueSettingSub108 = new ValueSettingSub10("Smoke", 0.55, 0.0, 0.8, 0.05);
      }
   }
}
