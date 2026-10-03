package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.render.Sampler0;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;

public class GuiComponentSub4 extends GuiComponent {
   private static final float FLOAT = 16.0F;
   private static final float FLOAT2 = 6.0F;
   private String string;
   public static final float FLOAT3 = 30.0F;
   private static final float FLOAT4 = 18.0F;
   private static final float FLOAT5 = 900.0F;
   private final Runnable runnable;
   private static final float FLOAT6 = 12.0F;
   private String string2;
   private final client.onyx.gui.Cls cls = new client.onyx.gui.Cls();
   private static final float FLOAT7 = 1.8F;
   private final GuiComponentSub4.FilledTonalEnum filledTonalEnum;
   private boolean bool4;
   private static final float FLOAT8 = 12.0F;
   private float float_5;

   private boolean isEnabled155() {
      return this.bool2 && !this.bool4;
   }

   private void handleSampler048(Sampler0 var1, int var2) {
      float var6 = var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD14, this.string2);
      float var4 = this.string == null ? 0.0F : 22.0F;
      var6 = this.float_3 + (this.float_4 - var6 - var4) / 2.0F;
      float var5 = this.float_ + this.float_2 / 2.0F;
      if (this.string != null) {
         var1.handleString6(this.string, var6 + 8.0F, var5, 16.0F, var2);
         var6 += var4;
      }

      var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD14, this.string2, var6, var5, var2);
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (var3 == 0 && this.isEnabled155() && this.isFloat15(var1, var2)) {
         this.bool3 = true;
         this.runnable.run();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      boolean var10002;
      GuiComponentSub4 var10003;
      if (this.bool && this.isEnabled155()) {
         var10002 = true;
         var10003 = this;
      } else {
         var10002 = false;
         var10003 = this;
      }

      this.cls.handleFloat(var1.float_, var10002, var10003.bool3 && this.isEnabled155());
      if (this.bool4) {
         float var4 = (this.float_5 + var1.float_) % 900.0F;
         this.float_5 = var4;
      }
   }

   @Override
   public boolean isFloat19(float var1, float var2, int var3) {
      return this.bool3 = false;
   }

   public void handleString25(String var1) {
      this.string = var1;
   }

   public void handleBool26(boolean var1) {
      this.bool4 = var1;
   }

   public void handleString24(String var1) {
      this.string2 = var1;
   }

   public GuiComponentSub4(GuiComponentSub4.FilledTonalEnum var1, String var2, String var3, Runnable var4) {
      this.filledTonalEnum = var1;
      this.string2 = var2;
      this.string = var3;
      this.runnable = var4;
      this.float_2 = 30.0F;
   }

   public GuiComponentSub4(GuiComponentSub4.FilledTonalEnum var1, String var2, Runnable var3) {
      this(var1, var2, null, var3);
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var5 = var1.sampler0;
      int var3 = this.getInt62(var1);
      int var4 = this.getInt63(var1);
      if (!this.isEnabled155()) {
         var3 = Util4.getIntForInt(var3);
      }

      if (var4 != 0) {
         var5.handleFloat7(
            this.float_3,
            this.float_,
            this.float_4,
            this.float_2,
            Float.MAX_VALUE,
            this.isEnabled155() ? var4 : Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurface(), 0.12F)
         );
      }

      if (this.filledTonalEnum == GuiComponentSub4.FilledTonalEnum.OUTLINED) {
         var5.handleFloat18(
            this.float_3,
            this.float_,
            this.float_4,
            this.float_2,
            Float.MAX_VALUE,
            1.0F,
            this.isEnabled155() ? var1.getPrimaryOnPrimaryRecord().outline() : Util4.getIntForInt(var1.getPrimaryOnPrimaryRecord().outline())
         );
      }

      this.cls.handleSampler0(var5, this.float_3, this.float_, this.float_4, this.float_2, Float.MAX_VALUE, var3);
      GuiComponentSub4 var10000;
      if (this.bool4) {
         var10000 = this;
         var5.handleFloat20(this.float_3 + this.float_4 / 2.0F, this.float_ + this.float_2 / 2.0F, 6.0F, 1.8F, this.float_5 / 900.0F, var3);
      } else {
         var10000 = this;
         this.handleSampler048(var5, var3);
      }

      if (var10000.bool && this.isEnabled155()) {
         var5.run41();
      }
   }

   public float getFloat142(Sampler0 var1) {
      float var2 = this.filledTonalEnum == GuiComponentSub4.FilledTonalEnum.TEXT ? 12.0F : 18.0F;
      float var4 = var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD14, this.string2);
      float var3 = this.string == null ? 0.0F : 22.0F;
      return var2 * 2.0F + var4 + var3;
   }

   public boolean isEnabled156() {
      return this.bool4;
   }

   private int getInt63(client.onyx.gui.Cls2 var1) {
      switch (this.filledTonalEnum) {
         case FILLED:

            return var1.getPrimaryOnPrimaryRecord().primary();
         case TONAL:
            return var1.getPrimaryOnPrimaryRecord().secondaryContainer();
         case OUTLINED:
         case TEXT:
            return 0;
         default:
            throw new MatchException(null, null);
      }
   }

   private int getInt62(client.onyx.gui.Cls2 var1) {
      switch (this.filledTonalEnum) {
         case FILLED:

            return var1.getPrimaryOnPrimaryRecord().onPrimary();
         case TONAL:
            return var1.getPrimaryOnPrimaryRecord().onSecondaryContainer();
         case OUTLINED:
         case TEXT:
            return var1.getPrimaryOnPrimaryRecord().primary();
         default:
            throw new MatchException(null, null);
      }
   }

   public static enum FilledTonalEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      FILLED,
      TONAL,
      OUTLINED,
      TEXT;

   }
}
