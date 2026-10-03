package client.onyx.module.hud;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.hud.style.AccentBarPillsEnum;
import client.onyx.module.hud.style.AccentStaticEnum;
import client.onyx.module.hud.style.SlideFadeEnum;
import client.onyx.module.hud.style.Util;
import client.onyx.module.hud.style.WidthDescWidthAscEnum;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.guide.Util3;
import client.onyx.render.misc.Cls2;
import client.onyx.setting.Setting;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import org.lwjgl.input.Mouse;

public final class StyleModule extends Module {
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub10 valueSettingSub102;
   public ValueSettingSub11<WidthDescWidthAscEnum> valueSettingSub112;
   private static final float FLOAT = 100.0F;
   public ValueSettingSub9 valueSettingSub9;
   private static final float FLOAT2 = 1.0F;
   private final client.onyx.render.misc.Cls cls;
   public ValueSettingSub6 valueSettingSub6;
   private final client.onyx.render.misc.Cls cls2;
   public ValueSettingSub<ModuleCategory> valueSettingSub;
   private boolean bool2;
   private final client.onyx.render.misc.Cls cls3;
   private float float_;
   public ValueSettingSub6 valueSettingSub62;
   private boolean bool3;
   public ValueSettingSub10 valueSettingSub103;
   public ValueSettingSub10 valueSettingSub104;
   public ValueSettingSub9 valueSettingSub92;
   public ValueSettingSub10 valueSettingSub105;
   private long long_;
   private final client.onyx.render.guide.Cls cls4;
   private final client.onyx.gui.Cls cls5;
   private float float_2;
   private float float_3;
   public ValueSettingSub9 valueSettingSub93;
   private boolean bool4;
   public ValueSettingSub11<SlideFadeEnum> valueSettingSub113;
   public ValueSettingSub9 valueSettingSub94;
   private float float_4;
   public ValueSettingSub10 valueSettingSub106;
   public ValueSettingSub9 valueSettingSub95;
   private static final float FLOAT3 = 2.0F;
   private boolean bool5;
   private Util3.XYRecord xYRecord;
   private final List<Module> list2;
   public ValueSettingSub9 valueSettingSub96;
   private float float_5;
   private float float_6;
   private static final float FLOAT4 = 3.0F;
   private final Map<Module, Util> map;
   private static final float FLOAT5 = 14.0F;
   public ValueSettingSub11<AccentBarPillsEnum> valueSettingSub114;
   private static final float FLOAT6 = 140.0F;
   private static final float FLOAT7 = 4.0F;
   public ValueSettingSub10 valueSettingSub107;
   public ValueSettingSub6 valueSettingSub63;
   private static final float FLOAT8 = 14.0F;
   private static final String STRING = "arraylist";
   private static final float FLOAT9 = 0.0F;
   public ValueSettingSub11<AccentStaticEnum> valueSettingSub115;

   private float getFloat82() {
      switch((AccentBarPillsEnum)this.valueSettingSub114.lambda15()) {
      case ACCENT_BAR:

         return 4.0F;
      case PILLS:
         return 5.0F;
      case TEXT:
         return 0.0F;
      default:
         throw new MatchException((String)null, (Throwable)null);
      }
   }

   protected void run80() {
      this.bool3 = false;
      this.long_ = 0L;
   }

   private float getFloat85(Sampler0 var1, Module var2, Util var3) {
      float var4 = Math.min(var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, this.getString30(var2)), 140.0F);
      return var3.string == null ? var4 : var4 + 3.0F + var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD8, var3.string);
   }

   public boolean isDouble10(double var1, double var3) {
      return var1 >= (double)this.float_2 && var1 < (double)(this.float_2 + this.float_4) && var3 >= (double)this.float_ && var3 < (double)(this.float_ + this.float_6);
   }

   public void handleSampler045(Sampler0 var1, float var2, float var3) {
      float var4 = this.getFloat86();
      boolean var5 = this.isEnabled55() && MINECRAFT.currentScreen instanceof GuiChat;
      boolean var6 = this.isSampler0(var1, var5, var4);
      client.onyx.render.misc.Cls var10000 = this.cls;
      float var10001;
      StyleModule var10002;
      if (var6) {
         var10001 = 1.0F;
         var10002 = this;
      } else {
         var10001 = 0.0F;
         var10002 = this;
      }

      var10000.getCls2(var10001, var10002.getFloat84(var6 ? 300.0F : 200.0F), var6 ? client.onyx.render.misc.Util.IFACE7 : client.onyx.render.misc.Util.IFACE);
      this.cls.handleFloat(var4);
      if (this.map.isEmpty() && this.cls.isEnabled() && this.cls.getFloat() <= 0.0F) {
         this.run123();
         this.float_4 = 0.0F;
         this.float_6 = 0.0F;
         this.bool4 = this.isEnabled90();
      } else {
         PrimaryOnPrimaryRecord var13 = Util4.getPrimaryOnPrimaryRecord();
         float var7 = this.valueSettingSub102.getFloat5();
         this.float_4 = this.cls3.getFloat() * var7;
         this.float_6 = this.cls2.getFloat() * var7;
         float var8 = var2 - this.float_4 - 0.0F;
         float var12 = var3 - this.float_6 - 0.0F;
         this.float_2 = 0.0F + getFloatForValueSettingSub109(this.valueSettingSub103, var8);
         this.float_ = 0.0F + getFloatForValueSettingSub109(this.valueSettingSub106, var12);
         client.onyx.render.guide.Util.handleString2("arraylist", this.float_2, this.float_, this.float_4, this.float_6);
         boolean var10 = this.isBool11(var5, var8, var12, var2, var3);
         if (var5 && var10 && !this.bool2) {
            float[] var11;
            if ((var11 = this.cls4.getFloatArray(true))[0] != 0.0F || var11[1] != 0.0F) {
               handleValueSettingSub109(this.valueSettingSub103, getFloatForValueSettingSub109(this.valueSettingSub103, var8) + var11[0], var8);
               handleValueSettingSub109(this.valueSettingSub106, getFloatForValueSettingSub109(this.valueSettingSub106, var12) + var11[1], var12);
            }
         } else {
            this.cls4.getFloatArray(false);
         }

         this.float_2 = 0.0F + getFloatForValueSettingSub109(this.valueSettingSub103, var8);
         this.float_ = 0.0F + getFloatForValueSettingSub109(this.valueSettingSub106, var12);
         this.float_2 = (float)Math.round(this.float_2);
         this.float_ = (float)Math.round(this.float_);
         this.bool5 = (Double)this.valueSettingSub103.lambda15() > 50.0D;
         client.onyx.gui.Cls var14 = this.cls5;
         boolean var15;
         StyleModule var10003;
         if (var5 && var10) {
            var15 = true;
            var10003 = this;
         } else {
            var15 = false;
            var10003 = this;
         }

         var14.handleFloat(var4, var15, var10003.bool2);
         if (this.bool2) {
            Util3.handleSampler02(var1, var2, var3, this.xYRecord);
         }

         var1.handleFloat10(this.cls.getFloat());
         var1.run36();
         var1.handleFloat11(this.float_2, this.float_);
         var1.handleFloat12(var7, 0.0F, 0.0F);
         this.handleSampler046(var1, var13);
         var1.run43();
         var1.run40();
         this.run123();
      }
   }

   private boolean isEnabled90() {
      return Mouse.isButtonDown(0);
   }

   private static String getStringForModule(Module var0) {
      String var3;
      if ((var3 = var0.getString19()) != null && !var3.isEmpty()) {
         return var3;
      } else {
         Iterator var4 = var0.getList12().iterator();

         Setting var2;
         do {
            if (!var4.hasNext()) {
               return null;
            }
         } while(!((var2 = (Setting)var4.next()) instanceof ValueSettingSub11));

         return ValueSettingSub11.getStringForEnum((Enum)((ValueSettingSub11)var2).lambda15());
      }
   }

   public StyleModule() {
      super("Array List", "Lists every enabled module", ModuleCategory.HUD);
      this.valueSettingSub114 = (new ValueSettingSub11("Style", AccentBarPillsEnum.ACCENT_BAR)).getBooleanSetting("How each row is painted");
      this.valueSettingSub113 = (new ValueSettingSub11("Animation", SlideFadeEnum.SLIDE_FADE)).getBooleanSetting("How rows enter and leave");
      this.valueSettingSub112 = (new ValueSettingSub11("Sort", WidthDescWidthAscEnum.WIDTH_DESC)).getBooleanSetting("Row ordering");
      this.valueSettingSub115 = (new ValueSettingSub11("Colors", AccentStaticEnum.ACCENT)).getBooleanSetting("Where each row's colour comes from");
      this.valueSettingSub6 = (new ValueSettingSub6("Color", -8691201)).getModeSetting2(this.valueSettingSub115, (var0) -> {
         return var0 == AccentStaticEnum.STATIC;
      });
      this.valueSettingSub62 = (new ValueSettingSub6("First Color", -8691201)).getModeSetting2(this.valueSettingSub115, AccentStaticEnum::isEnabled6).getBooleanSetting("Gradient: the top row. Fade: one end of the pulse");
      this.valueSettingSub63 = (new ValueSettingSub6("Second Color", -12598785)).getModeSetting2(this.valueSettingSub115, AccentStaticEnum::isEnabled6).getBooleanSetting("Gradient: the bottom row. Fade: the other end of the pulse");
      this.valueSettingSub107 = (new ValueSettingSub10("Color Speed", 1.0D, 0.1D, 5.0D, 0.1D)).getValueSettingSub10("x").getModeSetting2(this.valueSettingSub115, AccentStaticEnum::isEnabled5);
      this.valueSettingSub105 = (new ValueSettingSub10("Color Spread", 12.0D, 0.0D, 60.0D, 1.0D)).getModeSetting2(this.valueSettingSub115, AccentStaticEnum::isEnabled5).getBooleanSetting("How far the colour shifts between neighbouring rows");
      this.valueSettingSub93 = (new ValueSettingSub9("Suffix", true)).getBooleanSetting("Show the module's mode next to its name");
      this.valueSettingSub96 = (new ValueSettingSub9("Lowercase", false)).getBooleanSetting("Write every row in lower case");
      ModuleCategory[] var10005 = new ModuleCategory[4];
      boolean var10007 = true;
      var10005[0] = ModuleCategory.COMBAT;
      var10005[1] = ModuleCategory.MOVEMENT;
      var10005[2] = ModuleCategory.PLAYER;
      var10005[3] = ModuleCategory.RENDER;
      this.valueSettingSub = (new ValueSettingSub("Categories", ModuleCategory.class, var10005)).getBooleanSetting("Which categories the list shows");
      this.valueSettingSub92 = (new ValueSettingSub9("Background", true)).getSetting2(() -> {
         return !this.valueSettingSub114.isEnum3(AccentBarPillsEnum.TEXT);
      });
      this.valueSettingSub94 = (new ValueSettingSub9("Blur", false)).getSetting2(() -> {
         return !this.valueSettingSub114.isEnum3(AccentBarPillsEnum.TEXT) && this.valueSettingSub92.isEnabled17();
      }).getBooleanSetting("Frost each row over what is behind it (needs ClickGui's frosted glass)");
      this.valueSettingSub9 = (new ValueSettingSub9("Text Shadow", true)).getSetting2(() -> {
         return this.valueSettingSub114.isEnum3(AccentBarPillsEnum.TEXT);
      });
      this.valueSettingSub95 = (new ValueSettingSub9("Outline", false)).getSetting2(() -> {
         return this.valueSettingSub114.isEnum3(AccentBarPillsEnum.PILLS);
      });
      this.valueSettingSub102 = (new ValueSettingSub10("Scale", 1.0D, 0.5D, 2.0D, 0.05D)).getValueSettingSub10("x").getBooleanSetting("Array list size");
      this.valueSettingSub104 = new ValueSettingSub10("Row Spacing", 0.0D, 0.0D, 6.0D, 0.5D);
      this.valueSettingSub10 = (new ValueSettingSub10("Animation Speed", 1.0D, 0.25D, 3.0D, 0.05D)).getValueSettingSub10("x");
      this.valueSettingSub103 = (new ValueSettingSub10("Position X", 100.0D, 0.0D, 100.0D, 0.01D)).getSetting2(() -> {
         return false;
      });
      this.valueSettingSub106 = (new ValueSettingSub10("Position Y", 0.0D, 0.0D, 100.0D, 0.01D)).getSetting2(() -> {
         return false;
      });
      this.map = new IdentityHashMap();
      this.list2 = new ArrayList();
      this.cls = new client.onyx.render.misc.Cls(0.0F);
      this.cls3 = new client.onyx.render.misc.Cls(0.0F);
      this.cls2 = new client.onyx.render.misc.Cls(0.0F);
      this.cls5 = new client.onyx.gui.Cls();
      this.cls4 = new client.onyx.render.guide.Cls();
      this.bool5 = true;
      this.xYRecord = Util3.X_Y_RECORD;
   }

   private int getInt44(int var1, int var2, Module var3, PrimaryOnPrimaryRecord var4) {
      switch((AccentStaticEnum)this.valueSettingSub115.lambda15()) {
      case ACCENT:

         return var4.primary();
      case STATIC:
         return this.valueSettingSub6.lambda15();
      case FADE:
         double var8 = getDouble27() * (double)this.valueSettingSub107.getFloat5() + Math.toRadians((double)((float)var1 * this.valueSettingSub105.getFloat5()));
         return Cls2.getIntForInt(this.valueSettingSub62.lambda15(), this.valueSettingSub63.lambda15(), (float)(Math.sin(var8) + 1.0D) / 2.0F);
      case GRADIENT:
         return Cls2.getIntForInt(this.valueSettingSub62.lambda15(), this.valueSettingSub63.lambda15(), var2 <= 1 ? 0.0F : (float)var1 / (float)(var2 - 1));
      case RAINBOW:
         float var5;
         return client.onyx.theme.impl.Util2.getIntForFloat((var5 = (float)(getDouble27() * 60.0D * (double)this.valueSettingSub107.getFloat5() + (double)((float)var1 * this.valueSettingSub105.getFloat5())) % 360.0F) < 0.0F ? var5 + 360.0F : var5, 0.75F, 1.0F, 255);
      case CATEGORY:
         return client.onyx.theme.impl.Util2.getIntForFloat((float)var3.getModuleCategory().ordinal() * 67.0F % 360.0F, 0.7F, 1.0F, 255);
      default:
         throw new MatchException((String)null, (Throwable)null);
      }
   }

   private boolean isSampler0(Sampler0 var1, boolean var2, float var3) {
      this.list2.clear();
      Iterator var12 = OnyxClient.cls.getArrayList().iterator();

      while(true) {
         label111:
         while(true) {
            Iterator var10000 = var12;

            while(true) {
               while(var10000.hasNext()) {
                  Module var4;
                  if ((var4 = (Module)var12.next()) == this) {
                     continue label111;
                  }

                  if (var4 == OnyxClient.cls.clickGUIModule) {
                     var10000 = var12;
                  } else {
                     boolean var5 = this.isEnabled55() && var4.isEnabled55() && this.valueSettingSub.isEnum(var4.getModuleCategory());
                     Util var7 = (Util)this.map.get(var4);
                     if (var5 && var7 == null) {
                        var7 = new Util(0.0F);
                        this.map.put(var4, var7);
                     }

                     if (var7 != null) {
                        if (var5) {
                           var7.string = this.valueSettingSub93.isEnabled17() ? getStringForModule(var4) : null;
                           if (var7.string != null && this.valueSettingSub96.isEnabled17()) {
                              String var9 = var7.string.toLowerCase(Locale.ROOT);
                              var7.string = var9;
                           }

                           var7.float_ = this.getFloat85(var1, var4, var7);
                           this.list2.add(var4);
                        }

                        client.onyx.render.misc.Cls var17 = var7.cls;
                        float var10001;
                        StyleModule var10002;
                        if (var5) {
                           var10001 = 1.0F;
                           var10002 = this;
                        } else {
                           var10001 = 0.0F;
                           var10002 = this;
                        }

                        var17.getCls2(var10001, var10002.getFloat84(var5 ? 250.0F : 200.0F), var5 ? client.onyx.render.misc.Util.IFACE7 : client.onyx.render.misc.Util.IFACE);
                        var7.cls.handleFloat(var3);
                        var7.cls2.handleFloat(var3);
                        if (!var5 && var7.cls.isEnabled() && var7.cls.getFloat() <= 0.0F) {
                           this.map.remove(var4);
                        }
                        continue label111;
                     }

                     var10000 = var12;
                  }
               }

               this.list2.sort(this.getComparator3());
               float var13 = 14.0F + this.valueSettingSub104.getFloat5();
               float var14 = this.getFloat82();
               float var15 = 0.0F;

               int var16;
               for(int var18 = var16 = 0; var18 < this.list2.size(); var18 = var16) {
                  Util var10;
                  Util var19 = var10 = (Util)this.map.get(this.list2.get(var16));
                  var19.int_ = var16;
                  float var20;
                  if (var19.bool) {
                     var10.cls2.getCls2((float)var16 * var13, this.getFloat84(100.0F), client.onyx.render.misc.Util.IFACE2);
                     var20 = var15;
                  } else {
                     var10.cls2.getCls((float)var16 * var13);
                     var10.bool = true;
                     var20 = var15;
                  }

                  ++var16;
                  var15 = Math.max(var20, var10.float_);
               }

               float var11 = (var16 = this.list2.size()) == 0 ? 0.0F : var15 + var14 * 2.0F + this.getFloat83();
               var14 = var16 == 0 ? 0.0F : (float)var16 * var13 - this.valueSettingSub104.getFloat5();
               if (var16 > 0) {
                  this.cls3.getCls2(var11, this.getFloat84(300.0F), client.onyx.render.misc.Util.IFACE2);
                  this.cls2.getCls2(var14, this.getFloat84(300.0F), client.onyx.render.misc.Util.IFACE2);
               }

               this.cls3.handleFloat(var3);
               this.cls2.handleFloat(var3);
               if (var16 > 0) {
                  return true;
               }

               return false;
            }
         }
      }
   }

   private void handleSampler046(Sampler0 var1, PrimaryOnPrimaryRecord var2) {
      AccentBarPillsEnum var10 = (AccentBarPillsEnum)this.valueSettingSub114.lambda15();
      boolean var4 = this.valueSettingSub92.isEnabled17() && var10 != AccentBarPillsEnum.TEXT && this.valueSettingSub94.isEnabled17();
      Util14.handleBool(var4);
      float var5 = this.cls3.getFloat();
      float var6 = this.cls2.getFloat();
      float var7 = this.getFloat82();
      int var8 = this.list2.size();
      Iterator var9 = this.map.entrySet().iterator();

      label58:
      while(true) {
         for(Iterator var10000 = var9; var10000.hasNext(); var10000 = var9) {
            Entry var3;
            Module var11 = (Module)(var3 = (Entry)var9.next()).getKey();
            float var12;
            Util var21;
            if (!((var12 = (var21 = (Util)var3.getValue()).cls.getFloat()) <= 0.001F)) {
               int var13 = this.getInt44(var21.int_, var8, var11, var2);
               float var14 = var21.float_ + var7 * 2.0F + this.getFloat83();
               float var15 = this.bool5 ? var5 - var14 : 0.0F;
               float var16 = var21.cls2.getFloat();
               SlideFadeEnum var17;
               if ((var17 = (SlideFadeEnum)this.valueSettingSub113.lambda15()).isEnabled4()) {
                  var1.handleFloat10(var12);
               }

               var1.run36();
               if (var17.isEnabled3()) {
                  float var18 = (1.0F - var12) * 14.0F;
                  var1.handleFloat11(this.bool5 ? var18 : -var18, 0.0F);
               }

               if (var17.isEnabled2()) {
                  var1.handleFloat11(var15 + (this.bool5 ? var14 : 0.0F), var16 + 7.0F);
                  var1.handleFloat12(0.9F + 0.1F * var12, 0.0F, 0.0F);
                  var1.handleFloat11(-(var15 + (this.bool5 ? var14 : 0.0F)), -(var16 + 7.0F));
               }

               this.handleSampler047(var1, var2, var10, var11, var21, var15, var16, var14, var7, var13, var4);
               var1.run43();
               if (var17.isEnabled4()) {
                  var1.run40();
               }
               continue label58;
            }
         }

         client.onyx.gui.Cls var19 = this.cls5;
         int var20 = var2.onSurface();
         var19.handleSampler0(var1, 0.0F, 0.0F, var5, var6, 0.0F, var20);
         return;
      }
   }

   private static double getDouble27() {
      return (double)System.nanoTime() / 1.0E9D;
   }

   private String getString30(Module var1) {
      return this.valueSettingSub96.isEnabled17() ? var1.getString20().toLowerCase(Locale.ROOT) : var1.getString20();
   }

   private float getFloat86() {
      long var1 = System.nanoTime();
      float var4 = this.long_ == 0L ? 16.0F : Math.min((float)(var1 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var1;
      return var4;
   }

   private float getFloat84(float var1) {
      return var1 / this.valueSettingSub10.getFloat5();
   }

   private static float getFloatForValueSettingSub109(ValueSettingSub10 var0, float var1) {
      return var1 <= 0.0F ? 0.0F : (float)((double)var1 * (Double)var0.lambda15() / 100.0D);
   }

   private static void handleValueSettingSub109(ValueSettingSub10 var0, float var1, float var2) {
      if (!(var2 <= 0.0F)) {
         var0.handleObject2((double)Math.clamp(var1 / var2, 0.0F, 1.0F) * 100.0D);
      }
   }

   public boolean isEnabled91() {
      return MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null && (this.isEnabled55() || this.bool3);
   }

   private void handleSampler047(Sampler0 var1, PrimaryOnPrimaryRecord var2, AccentBarPillsEnum var3, Module var4, Util var5, float var6, float var7, float var8, float var9, int var10, boolean var11) {
      float var12 = this.getFloat83();
      float var13 = var6 + var8 - var9 - (this.bool5 ? var12 : 0.0F);
      var9 = var6 + var9 + (this.bool5 ? 0.0F : var12);
      float var14 = var7 + 7.0F;
      int var15 = var3 == AccentBarPillsEnum.ACCENT_BAR ? var2.onSurface() : var10;
      int var16 = Util4.getIntForInt2(var3 == AccentBarPillsEnum.TEXT ? var10 : var2.onSurface(), 0.6F);
      Sampler0 var10000;
      switch(var3) {
      case ACCENT_BAR:

         label79: {
            if (this.valueSettingSub92.isEnabled17()) {
               int var17 = Util4.getIntForInt2(var2.surface(), 0.55F);
               if (this.valueSettingSub104.getFloat5() > 0.0F) {
                  Util14.handleSampler02(var1, var6, var7, var8, 14.0F, 0.0F, var17, var11);
                  var10000 = var1;
                  break label79;
               }

               var1.handleFloat24(var6, var7, var8, 14.0F);
               Util14.handleSampler02(var1, var6, var7 - 4.0F, var8, 22.0F, 0.0F, var17, var11);
               var1.run38();
            }

            var10000 = var1;
         }

         float var10001 = var6;
         float var10002;
         if (this.bool5) {
            var10001 = var6 + var8 - var12;
            var10002 = var7;
         } else {
            var10002 = var7;
         }

         var10000.handleFloat28(var10001, var10002, var12, 14.0F, var10);
         var10000 = var1;
         break;
      case PILLS:
         if (this.valueSettingSub92.isEnabled17()) {
            Util14.handleSampler02(var1, var6, var7, var8, 14.0F, 8.0F, Util4.getIntForInt2(var2.surface(), 0.72F), var11);
            var1.handleFloat7(var6, var7, var8, 14.0F, 8.0F, Util4.getIntForInt2(var10, 0.22F));
         }

         if (this.valueSettingSub95.isEnabled17()) {
            var10000 = var1;
            var1.handleFloat18(var6, var7, var8, 14.0F, 8.0F, 1.0F, Util4.getIntForInt2(var10, 0.5F));
            break;
         }
      case TEXT:
      default:
         var10000 = var1;
      }

      String var19;
      float var20;
      String var21;
      StyleModule var22;
      label72: {
         var21 = var10000.getString17(Util2.OPTICAL_WEIGHT_RECORD9, this.getString30(var4), 140.0F);
         var20 = (var19 = var5.string) == null ? 0.0F : var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD8, var19) + 3.0F;
         if (var3 == AccentBarPillsEnum.TEXT && this.valueSettingSub9.isEnabled17()) {
            int var18 = Util4.getIntForInt2(var2.shadow(), 0.075F);
            if (this.bool5) {
               var1.handleOpticalWeightRecord6(Util2.OPTICAL_WEIGHT_RECORD9, var21, var13 - var20 + 1.0F, var14 + 1.0F, var18);
               if (var19 != null) {
                  var22 = this;
                  var1.handleOpticalWeightRecord6(Util2.OPTICAL_WEIGHT_RECORD8, var19, var13 + 1.0F, var14 + 1.0F, var18);
                  break label72;
               }
            } else {
               var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, var21, var9 + 1.0F, var14 + 1.0F, var18);
               if (var19 != null) {
                  var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD8, var19, var9 + var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var21) + 3.0F + 1.0F, var14 + 1.0F, var18);
               }
            }
         }

         var22 = this;
      }

      if (var22.bool5) {
         var1.handleOpticalWeightRecord6(Util2.OPTICAL_WEIGHT_RECORD9, var21, var13 - var20, var14, var15);
         if (var19 != null) {
            var1.handleOpticalWeightRecord6(Util2.OPTICAL_WEIGHT_RECORD8, var19, var13, var14, var16);
            return;
         }
      } else {
         var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, var21, var9, var14, var15);
         if (var19 != null) {
            var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD8, var19, var9 + var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var21) + 3.0F, var14, var16);
         }
      }

   }

   protected void run79() {
      this.bool3 = true;
      this.bool2 = false;
   }

   private Comparator<Module> getComparator3() {
      switch((WidthDescWidthAscEnum)this.valueSettingSub112.lambda15()) {
      case WIDTH_DESC:

         return Comparator.comparingDouble((Module var1) -> {
            return (double)(-((Util)this.map.get(var1)).float_);
         }).thenComparing(Module::getString20);
      case WIDTH_ASC:
         return Comparator.comparingDouble((Module var1) -> {
            return (double)((Util)this.map.get(var1)).float_;
         }).thenComparing(Module::getString20);
      case ALPHABETICAL:
         return Comparator.comparing(Module::getString20);
      default:
         throw new MatchException((String)null, (Throwable)null);
      }
   }

   private float getFloat83() {
      return this.valueSettingSub114.isEnum3(AccentBarPillsEnum.ACCENT_BAR) ? 2.0F : 0.0F;
   }

   private void run123() {
      if (!this.isEnabled55() && this.map.isEmpty() && this.cls.isEnabled() && !(this.cls.getFloat() > 0.0F)) {
         this.bool3 = false;
         this.long_ = 0L;
         this.float_4 = 0.0F;
         this.float_6 = 0.0F;
         client.onyx.render.guide.Util.handleString("arraylist");
      }
   }

   private boolean isBool11(boolean var1, float var2, float var3, float var4, float var5) {
      float var6 = (float)Minecraft.getScaledMouseX() * var4 / (float)MINECRAFT.displayWidth;
      float var14 = (float)Minecraft.getScaledMouseY() * var5 / (float)MINECRAFT.displayHeight;
      float var10 = var5 - var14 - 1.0F;
      boolean var8 = this.isEnabled90();
      boolean var9 = this.isDouble10((double)var6, (double)var10);
      StyleModule var10000;
      if (var1 && var8) {
         if (!this.bool4 && var9) {
            this.bool2 = true;
            this.float_3 = var6 - this.float_2;
            this.float_5 = var10 - this.float_;
         }

         var10000 = this;
      } else {
         var10000 = this;
         this.bool2 = false;
         this.xYRecord = Util3.X_Y_RECORD;
      }

      var10000.bool4 = var8;
      if (this.bool2) {
         this.xYRecord = Util3.getXYRecordForFloat2(var6 - this.float_3, var10 - this.float_5, this.float_4, this.float_6, var4, var5, 0.0F, client.onyx.render.guide.Util.getListForString("arraylist"));
         handleValueSettingSub109(this.valueSettingSub103, this.xYRecord.x() - 0.0F, var2);
         handleValueSettingSub109(this.valueSettingSub106, this.xYRecord.y() - 0.0F, var3);
      }

      return var9;
   }
}
