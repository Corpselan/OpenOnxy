package client.onyx.module.hud;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.guide.Util;
import client.onyx.render.guide.Util3;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import client.onyx.theme.Util5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

public final class PotionHUDModule extends Module {
   private Util3.XYRecord xYRecord;
   private static final float FLOAT = 3.0F;
   private static final int INT = 200;
   private final client.onyx.gui.Cls cls;
   private static final float FLOAT2 = 10.0F;
   private final client.onyx.render.misc.Cls cls2;
   private static final float FLOAT3 = 100.0F;
   public final ValueSettingSub11<PotionHUDModule.DurationNameEnum> valueSettingSub112;
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub9 valueSettingSub92;
   private float float_;
   private static final float FLOAT4 = 5.0F;
   private static final float FLOAT5 = 10.0F;
   public final ValueSettingSub9 valueSettingSub93;
   private boolean bool2;
   public final ValueSettingSub10 valueSettingSub10;
   private static final float FLOAT6 = 5.0F;
   private static final float FLOAT7 = 12.0F;
   private float float_2;
   private final client.onyx.render.misc.Cls cls3;
   private static final float FLOAT8 = 6.0F;
   private static final float FLOAT9 = 5.0F;
   private float float_3;
   private float float_4;
   private static final float FLOAT10 = 1.0F;
   private static final float FLOAT11 = 1.0F;
   private static final float FLOAT12 = 0.94F;
   private static final float FLOAT13 = 18.0F;
   private long long_;
   private boolean bool3;
   private final Map<Integer, PotionHUDModule.Cls2> map;
   private static final float FLOAT14 = 16.0F;
   private final client.onyx.render.misc.Cls cls4;
   private static final float FLOAT15 = 110.0F;
   private static final float FLOAT16 = 6.0F;
   private final client.onyx.render.guide.Cls cls5;
   private static final int INT2 = 3;
   private float float_5;
   public final ValueSettingSub9 valueSettingSub94;
   public final ValueSettingSub9 valueSettingSub95;
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("textures/gui/container/inventory.png");
   private static final float FLOAT17 = 31.0F;
   private boolean bool4;
   public final ValueSettingSub9 valueSettingSub96;
   public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Scale", 0.85, 0.5, 2.0, 0.05)
      .getValueSettingSub10("x")
      .getBooleanSetting("Potion list size");
   private static final float FLOAT18 = 20.0F;
   public final ValueSettingSub10 valueSettingSub103;
   private static final float FLOAT19 = 4.0F;
   private static final String STRING = "potions";
   private float float_6;
   private static final String[] STRING_ARRAY;

   private boolean isBool9(boolean var1, float var2, float var3, float var4, float var5) {
      float var6 = Minecraft.getScaledMouseX() * var4 / MINECRAFT.displayWidth;
      float var14 = Minecraft.getScaledMouseY() * var5 / MINECRAFT.displayHeight;
      float var10 = var5 - var14 - 1.0F;
      boolean var8 = this.isEnabled87();
      boolean var9 = this.isDouble8(var6, var10);
      PotionHUDModule var10000;
      if (var1 && var8) {
         if (!this.bool2 && var9) {
            this.bool4 = true;
            this.float_6 = var6 - this.float_4;
            this.float_3 = var10 - this.float_2;
         }

         var10000 = this;
      } else {
         var10000 = this;
         this.bool4 = false;
         this.xYRecord = Util3.X_Y_RECORD;
      }

      var10000.bool2 = var8;
      if (this.bool4) {
         this.xYRecord = Util3.getXYRecordForFloat2(
            var6 - this.float_6, var10 - this.float_3, this.float_, this.float_5, var4, var5, 10.0F, Util.getListForString("potions")
         );
         handleValueSettingSub107(this.valueSettingSub103, this.xYRecord.x() - 10.0F, var2);
         handleValueSettingSub107(this.valueSettingSub10, this.xYRecord.y() - 10.0F, var3);
      }

      return var9;
   }

   @Override
   protected void run80() {
      this.bool3 = false;
      this.long_ = 0L;
   }

   public void handleSampler036(Sampler0 var1, float var2, float var3) {
      float var4 = this.getFloat75();
      boolean var5 = this.isEnabled55() && MINECRAFT.currentScreen instanceof GuiChat;
      List var6;
      boolean var13 = this.isList(var6 = this.getList22(var5), var4);
      float var10001;
      boolean var10002;
      if (var13) {
         var10001 = 1.0F;
         var10002 = var13;
      } else {
         var10001 = 0.0F;
         var10002 = var13;
      }

      float var15;
      boolean var10003;
      if (var10002) {
         var15 = 300.0F;
         var10003 = var13;
      } else {
         var15 = 200.0F;
         var10003 = var13;
      }

      this.cls3.getCls2(var10001, var15, var10003 ? client.onyx.render.misc.Util.IFACE7 : client.onyx.render.misc.Util.IFACE);
      this.cls3.handleFloat(var4);
      if (this.map.isEmpty() && this.cls3.isEnabled() && this.cls3.getFloat() <= 0.0F) {
         this.run118();
         this.float_ = 0.0F;
         this.float_5 = 0.0F;
         this.bool2 = this.isEnabled87();
      } else {
         PrimaryOnPrimaryRecord var14 = Util4.getPrimaryOnPrimaryRecord();
         this.handleSampler039(var1, var6, var4);
         float var8 = this.valueSettingSub102.getFloat5() * (0.94F + 0.060000002F * this.cls3.getFloat());
         this.float_ = this.cls2.getFloat() * var8;
         this.float_5 = this.cls4.getFloat() * var8;
         float var9 = var2 - this.float_ - 20.0F;
         float var10 = var3 - this.float_5 - 20.0F;
         this.float_4 = 10.0F + getFloatForValueSettingSub107(this.valueSettingSub103, var9);
         this.float_2 = 10.0F + getFloatForValueSettingSub107(this.valueSettingSub10, var10);
         Util.handleString2("potions", this.float_4, this.float_2, this.float_, this.float_5);
         boolean var11 = this.isBool9(var5, var9, var10, var2, var3);
         if (var5 && var11 && !this.bool4) {
            float[] var12;
            if ((var12 = this.cls5.getFloatArray(true))[0] != 0.0F || var12[1] != 0.0F) {
               handleValueSettingSub107(this.valueSettingSub103, getFloatForValueSettingSub107(this.valueSettingSub103, var9) + var12[0], var9);
               handleValueSettingSub107(this.valueSettingSub10, getFloatForValueSettingSub107(this.valueSettingSub10, var10) + var12[1], var10);
            }
         } else {
            this.cls5.getFloatArray(false);
         }

         this.float_4 = 10.0F + getFloatForValueSettingSub107(this.valueSettingSub103, var9);
         this.float_2 = 10.0F + getFloatForValueSettingSub107(this.valueSettingSub10, var10);
         PotionHUDModule var17;
         if (var5 && var11) {
            var10002 = true;
            var17 = this;
         } else {
            var10002 = false;
            var17 = this;
         }

         this.cls.handleFloat(var4, var10002, var17.bool4);
         if (this.bool4) {
            Util3.handleSampler02(var1, var2, var3, this.xYRecord);
         }

         Util14.run();
         var1.handleFloat10(this.cls3.getFloat());
         var1.run36();
         var1.handleFloat11(this.float_4, this.float_2 + (1.0F - this.cls3.getFloat()) * 5.0F);
         var1.handleFloat12(var8, 0.0F, 0.0F);
         this.handleSampler038(var1, var14, var6);
         var1.run43();
         var1.run40();
         this.run118();
      }
   }

   private static void handleValueSettingSub107(ValueSettingSub10 var0, float var1, float var2) {
      if (!(var2 <= 0.0F)) {
         var0.handleObject2(Math.clamp(var1 / var2, 0.0F, 1.0F) * 100.0);
      }
   }

   static {
      String[] var0 = new String[]{"", "II", "III", "IV", "V", "VI", "VII", "VIII"};
      STRING_ARRAY = var0;
   }

   private void handleSampler039(Sampler0 var1, List<PotionHUDModule.IdPotionRecord> var2, float var3) {
      float var4 = 29.0F + var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, "Potions");

      Iterator var5;
      for (Iterator var10000 = var5 = var2.iterator(); var10000.hasNext(); var10000 = var5) {
         PotionHUDModule.IdPotionRecord var6 = (PotionHUDModule.IdPotionRecord)var5.next();
         float var8 = Math.min(var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD8, this.getString26(var6)), 110.0F);
         var8 = 18.0F + var8;
         if (this.valueSettingSub9.isEnabled17()) {
            var8 += 18.0F;
         }

         if (this.valueSettingSub94.isEnabled17()) {
            var8 += 10.0F + var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD8, this.getString27(var6));
         }

         var4 = Math.max(var4, var8);
      }

      int var9 = var2.size();
      float var10 = 37.0F + var9 * 20.0F + Math.max(0, var9 - 1) * 4.0F;
      this.cls2.getCls2(var4, 300.0F, client.onyx.render.misc.Util.IFACE2);
      this.cls4.getCls2(var10, 300.0F, client.onyx.render.misc.Util.IFACE2);
      this.cls2.handleFloat(var3);
      this.cls4.handleFloat(var3);
   }

   private String getString26(PotionHUDModule.IdPotionRecord var1) {
      String var2 = this.lambda150(var1);
      if (this.valueSettingSub93.isEnabled17() && var1.effect() != null) {
         int var3;
         return (var3 = var1.effect().getAmplifier()) > 0 && var3 < STRING_ARRAY.length
            ? new StringBuilder().insert(0, var2).append(" ").append(STRING_ARRAY[var3]).toString()
            : var2;
      } else {
         return var2;
      }
   }

   private void handleSampler037(Sampler0 var1, PrimaryOnPrimaryRecord var2, PotionHUDModule.IdPotionRecord var3, float var4, float var5) {
      float var6 = 6.0F;
      int var7 = var3.potion() == null ? var2.primary() : 0xFF000000 | var3.potion().getLiquidColor();
      if (this.valueSettingSub9.isEnabled17()) {
         if (this.valueSettingSub95.isEnabled17()) {
            var1.handleFloat7(6.0F, var4 + 1.0F, 18.0F, 18.0F, 4.0F, Util4.getIntForInt2(var7, 0.22F));
         }

         if (var3.potion() != null && var3.potion().hasStatusIcon()) {
            int var8 = var3.potion().getStatusIconIndex();
            var1.handleResourceLocation2(RESOURCE_LOCATION, 7.0F, var4 + 1.0F + 1.0F, 16.0F, 16.0F, var8 % 8 * 18, 198 + var8 / 8 * 18, 18.0F, 18.0F, 256, 256);
         }

         var6 += 24.0F;
      }

      String var10 = var1.getString17(Util2.OPTICAL_WEIGHT_RECORD8, this.getString26(var3), 110.0F);
      var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD8, var10, var6, var4 + 10.0F, this.valueSettingSub95.isEnabled17() ? var7 : var2.onSurface());
      if (this.valueSettingSub94.isEnabled17()) {
         boolean var9 = this.valueSettingSub96.isEnabled17()
            && var3.effect() != null
            && !var3.effect().getIsPotionDurationMax()
            && var3.effect().getDuration() < 200;
         var1.handleOpticalWeightRecord6(
            Util2.OPTICAL_WEIGHT_RECORD8, this.getString27(var3), var5 - 6.0F, var4 + 10.0F, var9 ? var2.error() : var2.onSurfaceVariant()
         );
      }
   }

   private boolean isEnabled87() {
      return Mouse.isButtonDown(0);
   }

   private String getString27(PotionHUDModule.IdPotionRecord var1) {
      if (var1.effect() == null) {
         return "0:00";
      } else {
         return var1.effect().getIsPotionDurationMax() ? "**:**" : Potion.getDurationString(var1.effect());
      }
   }

   private boolean isList(List<PotionHUDModule.IdPotionRecord> var1, float var2) {
      Iterator var6 = null;
      boolean var4 = false;

      for (Iterator var10000 = var6 = var1.iterator(); var10000.hasNext(); var4 = true) {
         PotionHUDModule.IdPotionRecord var5 = (PotionHUDModule.IdPotionRecord)var6.next();
         PotionHUDModule.Cls2 var7 = this.map.computeIfAbsent(var5.id(), var0 -> new PotionHUDModule.Cls2());
         var10000 = var6;
         var7.bool = true;
         var7.cls.getCls2(1.0F, 150.0F, client.onyx.render.misc.Util.IFACE7);
         var7.cls.handleFloat(var2);
      }

      this.map.entrySet().removeIf(var1x -> {
         PotionHUDModule.Cls2 var2x;
         if (!(var2x = var1x.getValue()).bool) {
            var2x.cls.getCls2(0.0F, 100.0F, client.onyx.render.misc.Util.IFACE);
            var2x.cls.handleFloat(var2);
         }

         var2x.bool = false;
         return var2x.cls.isEnabled() && var2x.cls.getFloat() <= 0.0F && var2x.cls.getFloat2() <= 0.0F;
      });
      return var4;
   }

   @Override
   protected void run79() {
      this.bool3 = true;
      this.bool4 = false;
   }

   private Comparator<PotionHUDModule.IdPotionRecord> getComparator2() {
      switch ((PotionHUDModule.DurationNameEnum)this.valueSettingSub112.lambda15()) {
         case DURATION:

            return Comparator.comparingInt(var0 -> var0.effect() == null ? Integer.MAX_VALUE : var0.effect().getDuration());
         case LEVEL:
            return Comparator.comparing(this::lambda150, String.CASE_INSENSITIVE_ORDER);
         case NAME:
            return Comparator.<PotionHUDModule.IdPotionRecord>comparingInt(var0 -> var0.effect() == null ? 0 : -var0.effect().getAmplifier())
               .thenComparing(this::lambda150, String.CASE_INSENSITIVE_ORDER);
         default:
            throw new MatchException(null, null);
      }
   }

   private String lambda150(PotionHUDModule.IdPotionRecord var1) {
      if (var1.potion() == null) {
         return "Effect";
      } else {
         String var3 = var1.potion().getName();
         Object[] var4 = new Object[0];
         return I18n.format(var3, var4);
      }
   }

   public PotionHUDModule() {
      super("PotionHUD", "Shows your active potion effects", ModuleCategory.HUD);
      this.valueSettingSub112 = new ValueSettingSub11<>("Sort", PotionHUDModule.DurationNameEnum.DURATION).getBooleanSetting("Row order");
      this.valueSettingSub9 = new ValueSettingSub9("Icons", true).getBooleanSetting("Show the vanilla effect icon");
      this.valueSettingSub94 = new ValueSettingSub9("Duration", true).getBooleanSetting("Show the time remaining");
      this.valueSettingSub93 = new ValueSettingSub9("Amplifier", true).getBooleanSetting("Show the effect level as a roman numeral");
      this.valueSettingSub95 = new ValueSettingSub9("Potion color", true).getBooleanSetting("Tint each row with the potion's own colour");
      this.valueSettingSub96 = new ValueSettingSub9("Low time warning", true).getBooleanSetting("Turn the timer red as an effect runs out");
      this.valueSettingSub92 = new ValueSettingSub9("Hide ambient", false).getBooleanSetting("Skip beacon effects");
      this.valueSettingSub103 = new ValueSettingSub10("Position X", 6.78, 0.0, 100.0, 0.01).getSetting2(() -> false);
      this.valueSettingSub10 = new ValueSettingSub10("Position Y", 45.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
      this.map = new HashMap<>();
      this.cls3 = new client.onyx.render.misc.Cls(0.0F);
      this.cls2 = new client.onyx.render.misc.Cls(36.0F);
      this.cls4 = new client.onyx.render.misc.Cls(57.0F);
      this.cls = new client.onyx.gui.Cls();
      this.xYRecord = Util3.X_Y_RECORD;
      this.cls5 = new client.onyx.render.guide.Cls();
   }

   public boolean isDouble8(double var1, double var3) {
      return var1 >= this.float_4 && var1 < this.float_4 + this.float_ && var3 >= this.float_2 && var3 < this.float_2 + this.float_5;
   }

   private void handleSampler038(Sampler0 var1, PrimaryOnPrimaryRecord var2, List<PotionHUDModule.IdPotionRecord> var3) {
      float var14 = this.cls2.getFloat();
      float var4 = this.cls4.getFloat();
      int var10 = Util5.getIntForInt(3, var2);
      var1.handleFloat25(0.0F, 0.0F, var14, var4, 12.0F, 3);
      Util14.handleSampler0(var1, 0.0F, 0.0F, var14, var4, 12.0F, var10);
      float var15 = 14.0F;
      var1.handleString6("\uea4b", 12.0F, var15, 12.0F, var2.primary());
      var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, "Potions", 23.0F, var15, var2.onSurface());
      var1.handleFloat28(6.0F, 25.0F, var14 - 12.0F, 1.0F, Util4.getIntForInt2(var2.outlineVariant(), 0.7F));
      float var16 = 31.0F;

      Iterator var6;
      for (Iterator var17 = var6 = var3.iterator(); var17.hasNext(); var16 += 24.0F) {
         PotionHUDModule.IdPotionRecord var7 = (PotionHUDModule.IdPotionRecord)var6.next();
         PotionHUDModule.Cls2 var8;
         float var9 = (var8 = this.map.get(var7.id())) == null ? 1.0F : var8.cls.getFloat();
         var17 = var6;
         var1.handleFloat10(var9);
         var1.run36();
         var1.handleFloat11((1.0F - var9) * 5.0F, 0.0F);
         this.handleSampler037(var1, var2, var7, var16, var14);
         var1.run43();
         var1.run40();
      }

      client.onyx.gui.Cls var11 = this.cls;
      int var12 = var2.onSurface();
      var11.handleSampler0(var1, 0.0F, 0.0F, var14, var4, 12.0F, var12);
      int var13 = var2.outlineVariant();
      var1.handleFloat18(0.0F, 0.0F, var14, var4, 12.0F, 1.0F, var13);
   }

   private float getFloat75() {
      long var1 = System.nanoTime();
      float var4 = this.long_ == 0L ? 16.0F : Math.min((float)(var1 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var1;
      return var4;
   }

   public boolean isEnabled86() {
      return MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null && (this.isEnabled55() || this.bool3);
   }

   private List<PotionHUDModule.IdPotionRecord> getList22(boolean var1) {
      ArrayList var4 = new ArrayList();
      if (this.isEnabled55() && MINECRAFT.thePlayer != null) {
         Iterator var3;
         Iterator var10000 = var3 = new ArrayList<>(MINECRAFT.thePlayer.getActivePotionEffects()).iterator();

         while (var10000.hasNext()) {
            PotionEffect var6;
            if ((var6 = (PotionEffect)var3.next()) == null) {
               var10000 = var3;
            } else if (this.valueSettingSub92.isEnabled17() && var6.getIsAmbient()) {
               var10000 = var3;
            } else {
               Potion var5 = var6.getPotionID() >= 0 && var6.getPotionID() < Potion.potionTypes.length ? Potion.potionTypes[var6.getPotionID()] : null;
               if (var5 == null) {
                  var10000 = var3;
               } else {
                  var4.add(new PotionHUDModule.IdPotionRecord(var6.getPotionID(), var5, var6));
                  var10000 = var3;
               }
            }
         }
      }

      if (var4.isEmpty() && var1) {
         PotionHUDModule.IdPotionRecord var7 = new PotionHUDModule.IdPotionRecord(-1, null, null);
         boolean var8 = var4.add(var7);
      }

      var4.sort(this.getComparator2());
      return var4;
   }

   private void run118() {
      if (!this.isEnabled55() && this.map.isEmpty() && this.cls3.isEnabled() && !(this.cls3.getFloat() > 0.0F)) {
         this.bool3 = false;
         this.long_ = 0L;
         this.float_ = 0.0F;
         this.float_5 = 0.0F;
         Util.handleString("potions");
      }
   }

   private static float getFloatForValueSettingSub107(ValueSettingSub10 var0, float var1) {
      return var1 <= 0.0F ? 0.0F : (float)(var1 * var0.lambda15() / 100.0);
   }

   private static final class Cls2 {
      final client.onyx.render.misc.Cls cls;
      boolean bool;

      private Cls2() {
         client.onyx.render.misc.Cls var1 = new client.onyx.render.misc.Cls(0.0F);
         this.cls = var1;
      }
   }

   public static enum DurationNameEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      DURATION("Time left"),
      NAME("Name"),
      LEVEL("Level");

      private final String string;

      private DurationNameEnum(String var3) {
         this.string = var3;
      }


      @Override
      public String getString5() {
         return this.string;
      }
   }

   private record IdPotionRecord(int id, Potion potion, PotionEffect effect) {
   }
}
