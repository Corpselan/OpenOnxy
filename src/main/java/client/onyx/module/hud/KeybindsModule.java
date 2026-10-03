package client.onyx.module.hud;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.guide.Util3;
import client.onyx.render.misc.Util;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import client.onyx.theme.Util5;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import org.lwjgl.input.Mouse;

public final class KeybindsModule extends Module {
   private static final float FLOAT = 31.0F;
   public ValueSettingSub10 valueSettingSub10;
   private boolean bool2;
   private final client.onyx.gui.Cls cls;
   private static final float FLOAT2 = 100.0F;
   private static final float FLOAT3 = 1.0F;
   private float float_;
   private static final float FLOAT4 = 16.0F;
   private static final float FLOAT5 = 20.0F;
   private final Map<Module, KeybindsModule.Cls2> map;
   private static final float FLOAT6 = 6.0F;
   private static final float FLOAT7 = 1.0F;
   private float float_2;
   private float float_3;
   public ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Scale", 0.85, 0.5, 2.0, 0.05)
      .getValueSettingSub10("x")
      .getBooleanSetting("Keybind list size");
   private static final float FLOAT8 = 12.0F;
   private static final int INT = 3;
   public ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Position X", 6.78, 0.0, 100.0, 0.01).getSetting2(() -> false);
   private static final float FLOAT9 = 6.0F;
   private static final float FLOAT10 = 4.0F;
   private final client.onyx.render.guide.Cls cls2;
   private boolean bool3;
   private static final float FLOAT11 = 0.94F;
   private boolean bool4;
   private final client.onyx.render.misc.Cls cls3;
   private static final float FLOAT12 = 10.0F;
   private float float_4;
   private final client.onyx.render.misc.Cls cls4;
   private Util3.XYRecord xYRecord;
   private static final float FLOAT13 = 5.0F;
   private final client.onyx.render.misc.Cls cls5;
   private static final float FLOAT14 = 5.0F;
   private static final float FLOAT15 = 20.0F;
   private long long_;
   private float float_5;
   private static final float FLOAT16 = 5.0F;
   private static final float FLOAT17 = 100.0F;
   private static final float FLOAT18 = 3.0F;
   private static final String STRING = "keybinds";
   private float float_6;

   private float getFloat74() {
      long var1 = System.nanoTime();
      float var4 = this.long_ == 0L ? 16.0F : Math.min((float)(var1 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var1;
      return var4;
   }

   public boolean isDouble7(double var1, double var3) {
      return var1 >= this.float_4 && var1 < this.float_4 + this.float_5 && var3 >= this.float_2 && var3 < this.float_2 + this.float_3;
   }

   @Override
   protected void run80() {
      this.bool2 = false;
      this.long_ = 0L;
   }

   private static String getStringForString6(String var0) {
      String var1;
      String[] var7;
      if ((var7 = (var1 = var0.trim().toUpperCase(Locale.ROOT)).split("\\s+")).length > 1) {
         StringBuilder var3 = new StringBuilder(var7.length);
         String[] var8;
         int var4 = (var8 = var7).length;

         int var5;
         for (int var10000 = var5 = 0; var10000 < var4; var10000 = ++var5) {
            String var6;
            if (!(var6 = var8[var5]).isEmpty()) {
               var3.append(var6.charAt(0));
            }
         }

         return var3.substring(0, Math.min(var3.length(), 3));
      } else {
         return var1.substring(0, Math.min(var1.length(), 3));
      }
   }

   public void handleSampler034(Sampler0 var1, float var2, float var3) {
      float var4 = this.getFloat74();
      boolean var5 = this.isEnabled55() && MINECRAFT.currentScreen instanceof GuiChat;
      boolean var12 = this.isBool7(var5, var4);
      float var10001;
      boolean var10002;
      if (var12) {
         var10001 = 1.0F;
         var10002 = var12;
      } else {
         var10001 = 0.0F;
         var10002 = var12;
      }

      float var14;
      boolean var10003;
      if (var10002) {
         var14 = 300.0F;
         var10003 = var12;
      } else {
         var14 = 200.0F;
         var10003 = var12;
      }

      this.cls3.getCls2(var10001, var14, var10003 ? Util.IFACE7 : Util.IFACE);
      this.cls3.handleFloat(var4);
      if (this.map.isEmpty() && this.cls3.isEnabled() && this.cls3.getFloat() <= 0.0F) {
         this.run117();
         this.float_5 = 0.0F;
         this.float_3 = 0.0F;
         this.bool3 = this.isEnabled84();
      } else {
         PrimaryOnPrimaryRecord var13 = Util4.getPrimaryOnPrimaryRecord();
         this.handleSampler033(var1, var4);
         float var7 = this.valueSettingSub102.getFloat5() * (0.94F + 0.060000002F * this.cls3.getFloat());
         this.float_5 = this.cls5.getFloat() * var7;
         this.float_3 = this.cls4.getFloat() * var7;
         float var8 = var2 - this.float_5 - 20.0F;
         float var9 = var3 - this.float_3 - 20.0F;
         this.float_4 = 10.0F + getFloatForValueSettingSub106(this.valueSettingSub103, var8);
         this.float_2 = 10.0F + getFloatForValueSettingSub106(this.valueSettingSub10, var9);
         client.onyx.render.guide.Util.handleString2("keybinds", this.float_4, this.float_2, this.float_5, this.float_3);
         boolean var10 = this.isBool8(var5, var8, var9, var2, var3);
         if (var5 && var10 && !this.bool4) {
            float[] var11;
            if ((var11 = this.cls2.getFloatArray(true))[0] != 0.0F || var11[1] != 0.0F) {
               handleValueSettingSub106(this.valueSettingSub103, getFloatForValueSettingSub106(this.valueSettingSub103, var8) + var11[0], var8);
               handleValueSettingSub106(this.valueSettingSub10, getFloatForValueSettingSub106(this.valueSettingSub10, var9) + var11[1], var9);
            }
         } else {
            this.cls2.getFloatArray(false);
         }

         this.float_4 = 10.0F + getFloatForValueSettingSub106(this.valueSettingSub103, var8);
         this.float_2 = 10.0F + getFloatForValueSettingSub106(this.valueSettingSub10, var9);
         KeybindsModule var16;
         if (var5 && var10) {
            var10002 = true;
            var16 = this;
         } else {
            var10002 = false;
            var16 = this;
         }

         this.cls.handleFloat(var4, var10002, var16.bool4);
         if (this.bool4) {
            Util3.handleSampler02(var1, var2, var3, this.xYRecord);
         }

         Util14.run();
         var1.handleFloat10(this.cls3.getFloat());
         var1.run36();
         var1.handleFloat11(this.float_4, this.float_2 + (1.0F - this.cls3.getFloat()) * 5.0F);
         var1.handleFloat12(var7, 0.0F, 0.0F);
         this.handleSampler035(var1, var13);
         var1.run43();
         var1.run40();
         this.run117();
      }
   }

   public boolean isEnabled85() {
      return MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null && (this.isEnabled55() || this.bool2);
   }

   private static float getFloatForValueSettingSub106(ValueSettingSub10 var0, float var1) {
      return var1 <= 0.0F ? 0.0F : (float)(var1 * var0.lambda15() / 100.0);
   }

   public KeybindsModule() {
      super("Keybinds", "Shows enabled modules with assigned keybinds", ModuleCategory.HUD);
      this.valueSettingSub10 = new ValueSettingSub10("Position Y", 18.79, 0.0, 100.0, 0.01).getSetting2(() -> false);
      this.map = new IdentityHashMap<>();
      this.cls3 = new client.onyx.render.misc.Cls(0.0F);
      this.cls5 = new client.onyx.render.misc.Cls(38.0F);
      this.cls4 = new client.onyx.render.misc.Cls(57.0F);
      this.cls = new client.onyx.gui.Cls();
      this.xYRecord = Util3.X_Y_RECORD;
      this.cls2 = new client.onyx.render.guide.Cls();
   }

   @Override
   protected void run79() {
      this.bool2 = true;
      this.bool4 = false;
   }

   private boolean isEnabled84() {
      return Mouse.isButtonDown(0);
   }

   private void handleSampler033(Sampler0 var1, float var2) {
      float var4 = 29.0F + var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, "Keybinds");
      Iterator var7;
      Iterator var10000 = var7 = OnyxClient.cls.getArrayList().iterator();

      while (var10000.hasNext()) {
         Module var5 = (Module)var7.next();
         if (this.map.get(var5) == null) {
            var10000 = var7;
         } else {
            float var6 = Math.min(var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD8, var5.getString20()), 100.0F);
            var4 = Math.max(var4, 38.0F + var6);
            var10000 = var7;
         }
      }

      int var9 = this.map.size();
      float var8 = 37.0F + var9 * 20.0F + Math.max(0, var9 - 1) * 4.0F;
      this.cls5.getCls2(var4, 300.0F, Util.IFACE2);
      this.cls4.getCls2(var8, 300.0F, Util.IFACE2);
      this.cls5.handleFloat(var2);
      this.cls4.handleFloat(var2);
   }

   private boolean isBool8(boolean var1, float var2, float var3, float var4, float var5) {
      float var6 = Minecraft.getScaledMouseX() * var4 / MINECRAFT.displayWidth;
      float var14 = Minecraft.getScaledMouseY() * var5 / MINECRAFT.displayHeight;
      float var10 = var5 - var14 - 1.0F;
      boolean var8 = this.isEnabled84();
      boolean var9 = this.isDouble7(var6, var10);
      KeybindsModule var10000;
      if (var1 && var8) {
         if (!this.bool3 && var9) {
            this.bool4 = true;
            this.float_ = var6 - this.float_4;
            this.float_6 = var10 - this.float_2;
         }

         var10000 = this;
      } else {
         var10000 = this;
         this.bool4 = false;
         this.xYRecord = Util3.X_Y_RECORD;
      }

      var10000.bool3 = var8;
      if (this.bool4) {
         this.xYRecord = Util3.getXYRecordForFloat2(
            var6 - this.float_, var10 - this.float_6, this.float_5, this.float_3, var4, var5, 10.0F, client.onyx.render.guide.Util.getListForString("keybinds")
         );
         handleValueSettingSub106(this.valueSettingSub103, this.xYRecord.x() - 10.0F, var2);
         handleValueSettingSub106(this.valueSettingSub10, this.xYRecord.y() - 10.0F, var3);
      }

      return var9;
   }

   private void handleSampler035(Sampler0 var1, PrimaryOnPrimaryRecord var2) {
      float var5 = this.cls5.getFloat();
      float var4 = this.cls4.getFloat();
      int var10 = Util5.getIntForInt(3, var2);
      var1.handleFloat25(0.0F, 0.0F, var5, var4, 12.0F, 3);
      Util14.handleSampler0(var1, 0.0F, 0.0F, var5, var4, 12.0F, var10);
      float var14 = 14.0F;
      var1.handleString6("\ue312", 12.0F, var14, 12.0F, var2.primary());
      var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, "Keybinds", 23.0F, var14, var2.onSurface());
      var1.handleFloat28(6.0F, 25.0F, var5 - 12.0F, 1.0F, Util4.getIntForInt2(var2.outlineVariant(), 0.7F));
      float var15 = 31.0F;
      Iterator var6;
      Iterator var10000 = var6 = OnyxClient.cls.getArrayList().iterator();

      while (var10000.hasNext()) {
         Module var7 = (Module)var6.next();
         KeybindsModule.Cls2 var8;
         if ((var8 = this.map.get(var7)) == null) {
            var10000 = var6;
         } else {
            float var9 = var8.cls.getFloat();
            var1.handleFloat10(var9);
            var1.run36();
            var1.handleFloat11((1.0F - var9) * 5.0F, 0.0F);
            var1.handleFloat7(6.0F, var15, 20.0F, 20.0F, 4.0F, var2.secondaryContainer());
            var1.handleOpticalWeightRecord4(Util2.OPTICAL_WEIGHT_RECORD8, getStringForString6(var8.string), 16.0F, var15 + 10.0F, var2.onSecondaryContainer());
            String var13 = var1.getString17(Util2.OPTICAL_WEIGHT_RECORD8, var7.getString20(), 100.0F);
            var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD8, var13, 32.0F, var15 + 10.0F, var2.onSurface());
            var1.run43();
            var1.run40();
            var15 += 24.0F;
            var10000 = var6;
         }
      }

      client.onyx.gui.Cls var11 = this.cls;
      int var12 = var2.onSurface();
      var11.handleSampler0(var1, 0.0F, 0.0F, var5, var4, 12.0F, var12);
      var1.handleFloat18(0.0F, 0.0F, var5, var4, 12.0F, 1.0F, var2.outlineVariant());
   }

   private static void handleValueSettingSub106(ValueSettingSub10 var0, float var1, float var2) {
      if (!(var2 <= 0.0F)) {
         var0.handleObject2(Math.clamp(var1 / var2, 0.0F, 1.0F) * 100.0);
      }
   }

   private void run117() {
      if (!this.isEnabled55() && this.map.isEmpty() && this.cls3.isEnabled() && !(this.cls3.getFloat() > 0.0F)) {
         this.bool2 = false;
         this.long_ = 0L;
         this.float_5 = 0.0F;
         this.float_3 = 0.0F;
         client.onyx.render.guide.Util.handleString("keybinds");
      }
   }

   private boolean isBool7(boolean var1, float var2) {
      boolean var7 = false;
      Iterator var4 = OnyxClient.cls.getArrayList().iterator();

      label79:
      while (true) {
         Iterator var10000 = var4;

         while (var10000.hasNext()) {
            Module var8;
            if ((var8 = (Module)var4.next()) == this) {
               continue label79;
            }

            if (var8 == OnyxClient.cls.clickGUIModule) {
               var10000 = var4;
            } else {
               boolean var6 = this.isEnabled55() && var8.getNoneValueSetting2().isEnabled19() && (var1 || var8.isEnabled55());
               KeybindsModule.Cls2 var3 = this.map.get(var8);
               if (var6 && var3 == null) {
                  var3 = new KeybindsModule.Cls2(var8.getNoneValueSetting2().getString12());
                  this.map.put(var8, var3);
               }

               if (var3 != null) {
                  if (var8.getNoneValueSetting2().isEnabled19()) {
                     var3.string = var8.getNoneValueSetting2().getString12();
                  }

                  float var10001;
                  boolean var10002;
                  if (var6) {
                     var10001 = 1.0F;
                     var10002 = var6;
                  } else {
                     var10001 = 0.0F;
                     var10002 = var6;
                  }

                  float var9;
                  boolean var10003;
                  if (var10002) {
                     var9 = 150.0F;
                     var10003 = var6;
                  } else {
                     var9 = 100.0F;
                     var10003 = var6;
                  }

                  var3.cls.getCls2(var10001, var9, var10003 ? Util.IFACE7 : Util.IFACE);
                  var3.cls.handleFloat(var2);
                  if (var6) {
                     var7 = true;
                  }

                  if (!var6 && var3.cls.isEnabled() && var3.cls.getFloat() <= 0.0F) {
                     this.map.remove(var8);
                  }
                  continue label79;
               }

               var10000 = var4;
            }
         }

         return var7;
      }
   }

   private static final class Cls2 {
      final client.onyx.render.misc.Cls cls = new client.onyx.render.misc.Cls(0.0F);
      String string;

      private Cls2(String var1) {
         this.string = var1;
      }
   }
}
