package client.onyx.module.hud;

import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.render.misc.Util;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util5;

final class Cls {
   private final client.onyx.gui.Cls[] clsArray;
   private float float_;
   private static final float FLOAT = 6.0F;
   private static final float FLOAT2 = 12.0F;
   private static final float FLOAT3 = 22.0F;
   private boolean bool;
   private final WatermarkModule watermarkModule;
   private float float_2;
   private static final float FLOAT4 = 13.0F;
   private float float_3;
   private static final float FLOAT5 = 8.0F;
   private static final float FLOAT6 = 8.0F;
   private static final float FLOAT7 = 6.0F;
   private final client.onyx.render.misc.Cls cls;
   private static final int INT = 3;
   private static final float FLOAT8 = 1.0F;
   private static final float FLOAT9 = 3.0F;
   private float float_4;
   private static final WatermarkModule.FpsUsernameEnum[] FPS_USERNAME_ENUM_ARRAY = WatermarkModule.FpsUsernameEnum.values();

   Cls(WatermarkModule var1) {
      client.onyx.gui.Cls[] var10001 = new client.onyx.gui.Cls[FPS_USERNAME_ENUM_ARRAY.length];
      boolean var10003 = true;
      this.clsArray = var10001;
      int var10000 = 0;
      this.cls = new client.onyx.render.misc.Cls(0.0F);
      this.watermarkModule = var1;

      for (int var2 = 0; var10000 < this.clsArray.length; var10000 = var2) {
         client.onyx.gui.Cls[] var3 = this.clsArray;
         int var4 = var2;
         client.onyx.gui.Cls var10002 = new client.onyx.gui.Cls();
         var2++;
         var3[var4] = var10002;
      }
   }

   boolean isEnabled2() {
      return this.bool;
   }

   void handleSampler0(Sampler0 var1, float var2, float var3, float var4, float var5) {
      this.bool = true;
      this.float_3 = getFloatForSampler0(var1);
      this.float_4 = 6.0F + 22.0F * FPS_USERNAME_ENUM_ARRAY.length;
      this.float_2 = Math.clamp(var2, 6.0F, Math.max(6.0F, var4 - this.float_3 - 6.0F));
      this.float_ = Math.clamp(var3, 6.0F, Math.max(6.0F, var5 - this.float_4 - 6.0F));
      this.cls.getCls2(1.0F, 200.0F, Util.IFACE7);
   }

   private static float getFloatForSampler0(Sampler0 var0) {
      float var6 = 0.0F;
      WatermarkModule.FpsUsernameEnum[] var4 = FPS_USERNAME_ENUM_ARRAY;
      int var3 = FPS_USERNAME_ENUM_ARRAY.length;

      int var2;
      for (int var10000 = var2 = 0; var10000 < var3; var10000 = var2) {
         WatermarkModule.FpsUsernameEnum var5 = var4[var2];
         OpticalWeightRecord var10002 = Util2.OPTICAL_WEIGHT_RECORD16;
         String var10003 = var5.getString5();
         var2++;
         var6 = Math.max(var6, var0.getFloat17(var10002, var10003));
      }

      return 57.0F + var6;
   }

   void handleFloat(float var1, float var2, float var3) {
      int var10000 = 0;
      this.cls.handleFloat(var1);

      for (int var6 = 0; var10000 < this.clsArray.length; var10000 = var6) {
         boolean var5 = this.bool && this.isInt(var6, var2, var3);
         client.onyx.gui.Cls var7 = this.clsArray[var6];
         var6++;
         var7.handleFloat(var1, var5, false);
      }
   }

   void handleSampler02(Sampler0 var1, PrimaryOnPrimaryRecord var2) {
      float var5;
      if (!((var5 = this.cls.getFloat()) <= 0.01F)) {
         Util14.run();
         int var4 = Util5.getIntForInt(3, var2);
         float var9 = (1.0F - var5) * 6.0F;
         int var10000 = 0;
         var1.handleFloat10(var5);
         var1.run36();
         var1.handleFloat11(0.0F, var9);
         var1.handleFloat25(this.float_2, this.float_, this.float_3, this.float_4, 12.0F, 3);
         Util14.handleSampler0(var1, this.float_2, this.float_, this.float_3, this.float_4, 12.0F, var4);

         for (int var11 = 0; var10000 < FPS_USERNAME_ENUM_ARRAY.length; var10000 = var11) {
            WatermarkModule.FpsUsernameEnum var10 = FPS_USERNAME_ENUM_ARRAY[var11];
            float var6 = (var9 = this.float_ + 3.0F + var11 * 22.0F) + 11.0F;
            boolean var7 = this.watermarkModule.valueSettingSub8.isEnum2(var10);
            this.clsArray[var11].handleSampler0(var1, this.float_2 + 2.0F, var9, this.float_3 - 4.0F, 22.0F, 8.0F, var2.onSurface());
            var9 = this.float_2 + 8.0F;
            float var8 = var6 - 6.0F;
            float var16;
            if (var7) {
               var1.handleFloat7(var9, var8, 12.0F, 12.0F, 4.0F, var2.primary());
               var16 = var9;
               client.onyx.gui.Util.handleSampler06(var1, var9 + 6.0F, var8 + 6.0F, 9.6F, var2.onPrimary());
            } else {
               var1.handleFloat18(var9, var8, 12.0F, 12.0F, 4.0F, 1.5F, var2.onSurfaceVariant());
               var16 = var9;
            }

            float var10001 = var9 = var16 + 12.0F + 8.0F;
            client.onyx.gui.Util.handleSampler05(var1, var10, var9 + 6.5F, var6, 13.0F, var2.onSurfaceVariant());
            var9 = var10001 + 13.0F + 8.0F;
            OpticalWeightRecord var17 = Util2.OPTICAL_WEIGHT_RECORD16;
            String var10002 = var10.getString5();
            var11++;
            var1.handleOpticalWeightRecord9(var17, var10002, var9, var6, var2.onSurface());
         }

         var1.handleFloat18(this.float_2, this.float_, this.float_3, this.float_4, 12.0F, 1.0F, var2.outlineVariant());
         var1.run43();
         var1.run40();
      }
   }

   boolean isEnabled() {
      return this.bool || this.cls.getFloat() > 0.001F || !this.cls.isEnabled();
   }

   private boolean isInt(int var1, float var2, float var3) {
      float var7 = this.float_ + 3.0F + var1 * 22.0F;
      if (var2 >= this.float_2) {
         float var5 = this.float_2 + this.float_3;
         if (var2 < var5 && var3 >= var7 && var3 < var7 + 22.0F) {
            return true;
         }
      }

      return false;
   }

   void run() {
      if (this.bool) {
         this.bool = false;
         this.cls.getCls2(0.0F, 100.0F, Util.IFACE);
      }
   }

   boolean isFloat(float var1, float var2) {
      if (!this.bool) {
         return false;
      } else {
         if (!(var1 < this.float_2)) {
            float var6 = this.float_2 + this.float_3;
            if (!(var1 >= var6) && !(var2 < this.float_)) {
               float var9 = this.float_ + this.float_4;
               if (!(var2 >= var9)) {
                  int var4;
                  for (int var10000 = var4 = 0; var10000 < FPS_USERNAME_ENUM_ARRAY.length; var10000 = ++var4) {
                     if (this.isInt(var4, var1, var2)) {
                        this.watermarkModule.valueSettingSub8.handleEnum3(FPS_USERNAME_ENUM_ARRAY[var4]);
                        break;
                     }
                  }

                  return true;
               }
            }
         }

         return false;
      }
   }
}
