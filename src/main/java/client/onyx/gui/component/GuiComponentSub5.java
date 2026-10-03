package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import client.onyx.render.misc.Util;
import client.onyx.theme.Util2;
import client.onyx.theme.Util5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;

public class GuiComponentSub5 extends GuiComponent {
   private final List<client.onyx.gui.Cls> list2;
   private static final float FLOAT = 10.0F;
   private static final float FLOAT2 = 6.0F;
   private static final float FLOAT3 = 16.0F;
   private static final float FLOAT4 = 7.0F;
   private float float_5;
   private final client.onyx.render.misc.Cls cls;
   private static final float FLOAT5 = 10.0F;
   private final List<GuiComponentSub5.GlyphLabelRecord> list3 = new ArrayList<>();
   private static final float FLOAT6 = 0.85F;
   private static final float FLOAT7 = 30.0F;
   private float float_6;
   private float float_7;
   private static final int INT = 2;
   private float float_8;
   private static final float FLOAT8 = 12.0F;
   private boolean bool4;
   private static final float FLOAT9 = 150.0F;
   private boolean bool5;
   private static final float FLOAT10 = 14.0F;

   public boolean isEnabled159() {
      return this.bool5;
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (!this.bool5) {
         return false;
      } else if (!this.isFloat15(var1, var2)) {
         this.run196();
         return true;
      } else if (var3 != 0) {
         return true;
      } else {
         int var4;
         if ((var4 = this.getInt67(var2)) >= 0) {
            GuiComponentSub5.GlyphLabelRecord var10000 = this.list3.get(var4);
            Runnable var5 = var10000.action();
            if (!var10000.keepOpen()) {
               this.run196();
            }

            if (var5 != null) {
               var5.run();
            }
         }

         return true;
      }
   }

   public GuiComponentSub5() {
      this.list2 = new ArrayList<>();
      this.cls = new client.onyx.render.misc.Cls(0.0F);
   }

   public void handleList18(List<GuiComponentSub5.GlyphLabelRecord> var1, GuiComponent var2, GuiComponent var3, Sampler0 var4) {
      this.handleList16(var1, var3, var4);
      float var5 = var2.getFloat118() + var2.getFloat119();
      float var6 = var2.getFloat115() + var2.getFloat116();
      this.float_3 = Math.clamp(var5 - this.float_4, var3.getFloat118() + 6.0F, var3.getFloat118() + var3.getFloat119() - this.float_4 - 6.0F);
      this.bool4 = var6 + this.float_2 > var3.getFloat115() + var3.getFloat116() - 6.0F;
      float var10001;
      GuiComponent var10002;
      if (this.bool4) {
         var10001 = var2.getFloat115() - this.float_2;
         var10002 = var3;
      } else {
         var10001 = var6;
         var10002 = var3;
      }

      this.float_ = Math.clamp(var10001, var10002.getFloat115() + 6.0F, var3.getFloat115() + var3.getFloat116() - this.float_2 - 6.0F);
      this.float_5 = var5;
      this.float_6 = this.bool4 ? this.float_ + this.float_2 : this.float_;
      this.cls.getCls(0.0F).getCls2(1.0F, 200.0F, Util.IFACE7);
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      if (this.bool5) {
         this.cls.handleFloat(var1.float_);
         this.bool = this.isFloat15(var1.float_3, var1.float_2);
         int var2 = this.bool ? this.getInt67(var1.float_2) : -1;

         int var3;
         for (int var10000 = var3 = 0; var10000 < this.list2.size(); var10000 = var3) {
            client.onyx.gui.Cls var4 = this.list2.get(var3);
            boolean var10002 = var3 == var2;
            var3++;
            var4.handleFloat(var1.float_, var10002, false);
         }
      }
   }

   public void run196() {
      if (this.bool5) {
         this.bool5 = false;
         this.list3.clear();
         this.list2.clear();
         this.float_7 = 0.0F;
         this.float_8 = 0.0F;
      }
   }

   @Override
   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      if (this.bool5 && var1.key() == 1) {
         this.run196();
         return true;
      } else {
         return false;
      }
   }

   private float getFloat150() {
      float var4 = 12.0F;

      Iterator var2;
      for (Iterator var10000 = var2 = this.list3.iterator(); var10000.hasNext(); var10000 = var2) {
         GuiComponentSub5.GlyphLabelRecord var3 = (GuiComponentSub5.GlyphLabelRecord)var2.next();
         var4 += var3.divider() ? 7.0F : 30.0F;
      }

      return var4;
   }

   private void handleList16(List<GuiComponentSub5.GlyphLabelRecord> var1, GuiComponent var2, Sampler0 var3) {
      this.list3.clear();
      this.list2.clear();
      this.list3.addAll(var1);
      Iterator var4 = var1.iterator();
      Iterator var10000 = var4;

      while (var10000.hasNext()) {
         GuiComponentSub5.GlyphLabelRecord var5 = (GuiComponentSub5.GlyphLabelRecord)var4.next();
         var10000 = var4;
         this.list2.add(new client.onyx.gui.Cls());
      }

      this.float_4 = this.getFloat151(var3);
      this.float_7 = this.getFloat150();
      this.float_2 = Math.min(this.float_7, var2.getFloat116() - 12.0F);
      this.float_8 = 0.0F;
      this.bool5 = true;
   }

   public void handleList17(List<GuiComponentSub5.GlyphLabelRecord> var1, GuiComponent var2, GuiComponent var3, Sampler0 var4) {
      this.handleList16(var1, var3, var4);
      float var5;
      boolean var6 = (var5 = var2.getFloat118() + var2.getFloat119()) + this.float_4 > var3.getFloat118() + var3.getFloat119() - 6.0F;
      float var10001;
      GuiComponent var10002;
      if (var6) {
         var10001 = var2.getFloat118() - this.float_4;
         var10002 = var3;
      } else {
         var10001 = var5;
         var10002 = var3;
      }

      this.float_3 = Math.clamp(var10001, var10002.getFloat118() + 6.0F, var3.getFloat118() + var3.getFloat119() - this.float_4 - 6.0F);
      this.float_ = Math.clamp(var2.getFloat115(), var3.getFloat115() + 6.0F, var3.getFloat115() + var3.getFloat116() - this.float_2 - 6.0F);
      this.bool4 = var6;
      this.float_5 = var6 ? this.float_3 + this.float_4 : this.float_3;
      this.float_6 = this.float_;
      this.cls.getCls(0.0F).getCls2(1.0F, 200.0F, Util.IFACE7);
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      if (this.bool5) {
         Sampler0 var2;
         Sampler0 var10000 = var2 = var1.sampler0;
         float var11 = this.cls.getFloat();
         var2.run35();
         var2.handleFloat10(var11);
         var2.run36();
         var2.handleFloat12(0.85F + 0.14999998F * var11, this.float_5, this.float_6);
         var2.handleFloat25(this.float_3, this.float_, this.float_4, this.float_2, 4.0F, 2);
         var2.handleFloat7(this.float_3, this.float_, this.float_4, this.float_2, 4.0F, Util5.getIntForInt(2, var1.getPrimaryOnPrimaryRecord()));
         var10000.handleFloat24(this.float_3, this.float_, this.float_4, this.float_2);
         var11 = this.float_ + 6.0F - this.float_8;

         int var4;
         for (int var23 = var4 = 0; var23 < this.list3.size(); var23 = ++var4) {
            GuiComponentSub5.GlyphLabelRecord var5;
            if ((var5 = this.list3.get(var4)).divider()) {
               if (var11 + 7.0F >= this.float_) {
                  float var13 = this.float_ + this.float_2;
                  if (var11 <= var13) {
                     var2.handleFloat28(this.float_3 + 12.0F, var11 + 3.5F, this.float_4 - 24.0F, 1.0F, var1.getPrimaryOnPrimaryRecord().outlineVariant());
                  }
               }

               var11 += 7.0F;
            } else {
               if (!(var11 + 30.0F < this.float_)) {
                  float var16 = this.float_ + this.float_2;
                  if (!(var11 > var16)) {
                     int var6 = var5.destructive() ? var1.getPrimaryOnPrimaryRecord().error() : var1.getPrimaryOnPrimaryRecord().onSurface();
                     this.list2.get(var4).handleSampler0(var2, this.float_3, var11, this.float_4, 30.0F, 0.0F, var6);
                     float var7 = this.float_3 + 12.0F;
                     if (var5.checked() != null) {
                        boolean var8 = var5.checked().getAsBoolean();
                        float var9 = var7 + 1.0F;
                        float var10 = var11 + 8.0F;
                        float var24;
                        if (var8) {
                           var2.handleFloat7(var9, var10, 14.0F, 14.0F, 4.0F, var1.getPrimaryOnPrimaryRecord().primary());
                           var24 = var7;
                           client.onyx.gui.Util.handleSampler06(var2, var9 + 7.0F, var10 + 7.0F, 10.0F, var1.getPrimaryOnPrimaryRecord().onPrimary());
                        } else {
                           var2.handleFloat18(var9, var10, 14.0F, 14.0F, 4.0F, 1.0F, var1.getPrimaryOnPrimaryRecord().onSurfaceVariant());
                           var24 = var7;
                        }

                        var7 = var24 + 26.0F;
                        var10000 = var2;
                     } else {
                        if (var5.glyph() != null) {
                           var2.handleString6(
                              var5.glyph(), var7 + 8.0F, var11 + 15.0F, 16.0F, var5.destructive() ? var6 : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()
                           );
                           var7 += 26.0F;
                        }

                        var10000 = var2;
                     }

                     var10000.handleOpticalWeightRecord9(
                        Util2.OPTICAL_WEIGHT_RECORD14,
                        var2.getString17(Util2.OPTICAL_WEIGHT_RECORD14, var5.label(), this.float_3 + this.float_4 - 12.0F - var7),
                        var7,
                        var11 + 15.0F,
                        var6
                     );
                     var11 += 30.0F;
                     continue;
                  }
               }

               var11 += 30.0F;
            }
         }

         var2.run38();
         float var18;
         if ((var18 = Math.max(0.0F, this.float_7 - this.float_2)) > 0.0F) {
            float var19 = this.float_2 - 12.0F;
            float var20 = Math.max(24.0F, var19 * this.float_2 / this.float_7);
            float var21 = this.float_ + 6.0F + (var19 - var20) * this.float_8 / var18;
            var2.handleFloat7(this.float_3 + this.float_4 - 5.0F, var21, 3.0F, var20, Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().outlineVariant());
         }

         var2.run43();
         var2.run40();
         if (this.bool) {
            var2.run41();
         }
      }
   }

   private int getInt67(float var1) {
      float var6 = this.float_ + 6.0F - this.float_8;

      int var3;
      for (int var10000 = var3 = 0; var10000 < this.list3.size(); var10000 = var3) {
         GuiComponentSub5.GlyphLabelRecord var4;
         float var5 = (var4 = this.list3.get(var3)).divider() ? 7.0F : 30.0F;
         if (!var4.divider() && var1 >= var6 && var1 < var6 + var5) {
            return var3;
         }

         var3++;
         var6 += var5;
      }

      return -1;
   }

   private float getFloat151(Sampler0 var1) {
      float var2 = 150.0F;
      Iterator var3;
      Iterator var10000 = var3 = this.list3.iterator();

      while (var10000.hasNext()) {
         GuiComponentSub5.GlyphLabelRecord var7;
         if ((var7 = (GuiComponentSub5.GlyphLabelRecord)var3.next()).divider()) {
            var10000 = var3;
         } else {
            float var5 = var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD14, var7.label());
            float var6 = var7.glyph() == null && var7.checked() == null ? 0.0F : 26.0F;
            var2 = Math.max(var2, 24.0F + var6 + var5);
            var10000 = var3;
         }
      }

      return var2;
   }

   @Override
   public boolean isFloat16(float var1, float var2, double var3) {
      if (!this.bool5) {
         return false;
      } else if (!this.isFloat15(var1, var2)) {
         return true;
      } else {
         float var6 = Math.max(0.0F, this.float_7 - this.float_2);
         this.float_8 = Math.clamp(this.float_8 - (float)var3 * 30.0F, 0.0F, var6);
         return true;
      }
   }

   public record GlyphLabelRecord(String glyph, String label, boolean destructive, boolean divider, BooleanSupplier checked, boolean keepOpen, Runnable action) {
      public static GuiComponentSub5.GlyphLabelRecord getGlyphLabelRecordForString(String var0, String var1, Runnable var2) {
         return new GuiComponentSub5.GlyphLabelRecord(var0, var1, false, false, null, false, var2);
      }

      public static GuiComponentSub5.GlyphLabelRecord getGlyphLabelRecord() {
         return new GuiComponentSub5.GlyphLabelRecord(null, null, false, true, null, false, null);
      }

      public static GuiComponentSub5.GlyphLabelRecord getGlyphLabelRecordForString4(String var0, String var1, Runnable var2) {
         return new GuiComponentSub5.GlyphLabelRecord(var0, var1, false, false, null, true, var2);
      }

      public static GuiComponentSub5.GlyphLabelRecord getGlyphLabelRecordForString3(String var0, BooleanSupplier var1, Runnable var2) {
         return new GuiComponentSub5.GlyphLabelRecord(null, var0, false, false, var1, true, var2);
      }

      public static GuiComponentSub5.GlyphLabelRecord getGlyphLabelRecordForString2(String var0, String var1, Runnable var2) {
         return new GuiComponentSub5.GlyphLabelRecord(var0, var1, true, false, null, false, var2);
      }
   }
}
