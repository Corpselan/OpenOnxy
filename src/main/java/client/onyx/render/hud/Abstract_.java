package client.onyx.render.hud;

import client.onyx.MinecraftAccess;
import client.onyx.render.Sampler0;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;

public abstract class Abstract_ implements MinecraftAccess {
   protected static final float FLOAT = 10.0F;
   private boolean bool;
   private final ValueSettingSub10 valueSettingSub10;
   private boolean bool2;
   private final ValueSettingSub10 valueSettingSub102;
   private float float_;
   private final String string;
   private boolean bool3;
   private static final float FLOAT2 = 7.0F;
   private static final float FLOAT3 = 8.0F;
   private float float_2;
   private static final float FLOAT4 = 1.0F;
   private float float_3;
   private float float_4;
   private float float_5;
   private final ValueSettingSub10 valueSettingSub103;
   private client.onyx.render.guide.Util3.XYRecord xYRecord;
   private float float_6;
   private final client.onyx.render.guide.Cls cls = new client.onyx.render.guide.Cls();

   public final void run74() {
      client.onyx.render.guide.Util.handleString(this.string);
      this.bool = false;
      this.bool2 = false;
   }

   protected abstract boolean isBool(boolean var1);

   protected abstract void handleSampler04(Sampler0 var1, float var2, float var3, float var4);

   private boolean isEnabled49() {
      return Mouse.isButtonDown(0);
   }

   private void handleSampler06(Sampler0 var1, boolean var2) {
      PrimaryOnPrimaryRecord var3 = client.onyx.theme.Util4.getPrimaryOnPrimaryRecord();
      int var4 = !var2 && !this.bool && !this.bool2 ? var3.outlineVariant() : var3.primary();
      var1.handleFloat18(this.float_3, this.float_6, this.float_, this.float_2, 4.0F, 1.0F, var4);
      var1.handleFloat7(this.float_3 + this.float_ - 7.0F, this.float_6 + this.float_2 - 7.0F, 7.0F, 7.0F, 4.0F, var4);
   }

   public final boolean isDouble3(double var1, double var3) {
      return var1 >= (double)this.float_3 && var1 < (double)(this.float_3 + this.float_) && var3 >= (double)this.float_6 && var3 < (double)(this.float_6 + this.float_2);
   }

   protected abstract float getFloat26(Sampler0 var1);

   protected static float getFloatForValueSettingSub102(ValueSettingSub10 var0, float var1) {
      return var1 <= 0.0F ? 0.0F : (float)((double)var1 * (Double)var0.lambda15() / 100.0D);
   }

   protected static void handleValueSettingSub102(ValueSettingSub10 var0, float var1, float var2) {
      if (!(var2 <= 0.0F)) {
         var0.handleObject2((double)Math.clamp(var1 / var2, 0.0F, 1.0F) * 100.0D);
      }
   }

   private boolean isBool2(boolean var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      float var8;
      boolean var10;
      boolean var11;
      float var13;
      boolean var10000;
      label49: {
         var8 = (float)Minecraft.getScaledMouseX() * var6 / (float)MINECRAFT.displayWidth;
         float var17 = (float)Minecraft.getScaledMouseY() * var7 / (float)MINECRAFT.displayHeight;
         var13 = var7 - var17 - 1.0F;
         var10 = this.isEnabled49();
         var11 = this.isDouble3((double)var8, (double)var13);
         float var22 = this.float_3 + this.float_ - 7.0F;
         if (var8 >= var22) {
            float var25 = this.float_3 + this.float_;
            if (var8 < var25) {
               float var29 = this.float_6 + this.float_2 - 7.0F;
               if (var13 >= var29) {
                  float var32 = this.float_6 + this.float_2;
                  if (var13 < var32) {
                     var10000 = true;
                     break label49;
                  }
               }
            }
         }

         var10000 = false;
      }

      boolean var12 = var10000;
      Abstract_ var35;
      if (var1 && var10) {
         if (!this.bool3 && var11) {
            this.bool = !(this.bool2 = var12);
            this.float_5 = var8 - this.float_3;
            this.float_4 = var13 - this.float_6;
         }

         var35 = this;
      } else {
         var35 = this;
         this.bool = false;
         this.bool2 = false;
         this.xYRecord = client.onyx.render.guide.Util3.X_Y_RECORD;
      }

      var35.bool3 = var10;
      if (this.bool2) {
         float var34 = Math.max(var8 - this.float_3, var13 - this.float_6);
         var2 = Math.max(var8 - this.float_3 >= var13 - this.float_6 ? var2 : var3, 1.0F);
         this.valueSettingSub10.handleObject2((double)(var34 / var2));
         this.xYRecord = client.onyx.render.guide.Util3.X_Y_RECORD;
         return var11;
      } else {
         if (this.bool) {
            this.xYRecord = client.onyx.render.guide.Util3.getXYRecordForFloat2(var8 - this.float_5, var13 - this.float_4, this.float_, this.float_2, var6, var7, 10.0F, client.onyx.render.guide.Util.getListForString(this.string));
            handleValueSettingSub102(this.valueSettingSub102, this.xYRecord.x() - 10.0F, var4);
            handleValueSettingSub102(this.valueSettingSub103, this.xYRecord.y() - 10.0F, var5);
         }

         return var11;
      }
   }

   protected Abstract_(String var1, ValueSettingSub10 var2, ValueSettingSub10 var3, ValueSettingSub10 var4) {
      this.xYRecord = client.onyx.render.guide.Util3.X_Y_RECORD;
      this.string = var1;
      this.valueSettingSub102 = var2;
      this.valueSettingSub103 = var3;
      this.valueSettingSub10 = var4;
   }

   protected abstract float getFloat25(Sampler0 var1);

   protected void handleFloat36(float var1) {
   }

   public final void handleSampler05(Sampler0 var1, float var2, float var3, boolean var4) {
      float var5 = Util4.getFloat();
      this.handleFloat36(var5);
      if (!this.isBool(var4)) {
         client.onyx.render.guide.Util.handleString(this.string);
         this.bool3 = this.isEnabled49();
      } else {
         float var13 = this.valueSettingSub10.getFloat5();
         float var7 = Math.max(8.0F, this.getFloat26(var1));
         float var8 = Math.max(8.0F, this.getFloat25(var1));
         this.float_ = var7 * var13;
         this.float_2 = var8 * var13;
         float var9 = var2 - this.float_ - 20.0F;
         float var10 = var3 - this.float_2 - 20.0F;
         this.float_3 = 10.0F + getFloatForValueSettingSub102(this.valueSettingSub102, var9);
         this.float_6 = 10.0F + getFloatForValueSettingSub102(this.valueSettingSub103, var10);
         client.onyx.render.guide.Util.handleString2(this.string, this.float_3, this.float_6, this.float_, this.float_2);
         boolean var11 = this.isBool2(var4, var7, var8, var9, var10, var2, var3);
         if (var4 && var11 && !this.bool && !this.bool2) {
            float[] var12;
            if ((var12 = this.cls.getFloatArray(true))[0] != 0.0F || var12[1] != 0.0F) {
               handleValueSettingSub102(this.valueSettingSub102, getFloatForValueSettingSub102(this.valueSettingSub102, var9) + var12[0], var9);
               handleValueSettingSub102(this.valueSettingSub103, getFloatForValueSettingSub102(this.valueSettingSub103, var10) + var12[1], var10);
            }
         } else {
            this.cls.getFloatArray(false);
         }

         var13 = this.valueSettingSub10.getFloat5();
         this.float_ = var7 * var13;
         this.float_2 = var8 * var13;
         this.float_3 = 10.0F + getFloatForValueSettingSub102(this.valueSettingSub102, var9);
         this.float_6 = 10.0F + getFloatForValueSettingSub102(this.valueSettingSub103, var10);
         if (this.bool || this.bool2) {
            client.onyx.render.guide.Util3.handleSampler02(var1, var2, var3, this.xYRecord);
         }

         var1.run36();
         var1.handleFloat11(this.float_3, this.float_6);
         var1.handleFloat12(var13, 0.0F, 0.0F);
         this.handleSampler04(var1, var7, var8, var5);
         var1.run43();
         if (var4) {
            this.handleSampler06(var1, var11);
         }

      }
   }
}
