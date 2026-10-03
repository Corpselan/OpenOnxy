package client.onyx.render;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.module.render.HandModule;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import java.nio.FloatBuffer;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;

public final class Util4 implements MinecraftAccess {
   private static final float FLOAT = 0.07F;
   private static final float FLOAT2 = 0.03F;
   private static final FloatBuffer FLOAT_BUFFER = BufferUtils.createFloatBuffer(16);
   private static boolean bool;
   private static float float_;
   private static float float_2;
   private static final float FLOAT3 = 70.0F;
   private static float float_3;
   private static boolean bool2;
   private static final Matrix4f MATRIX4F = new Matrix4f();
   private static float float_4;
   private static float float_5;
   private static final float FLOAT4 = 0.08F;
   private static final Matrix4f MATRIX4F2 = new Matrix4f();
   private static final float FLOAT5 = 1.05F;
   private static float float_6;
   private static long long_;
   private static boolean bool3;
   private static final client.onyx.render.misc.Cls CLS3 = new client.onyx.render.misc.Cls(0.0F);
   private static final client.onyx.render.misc.Cls CLS2 = new client.onyx.render.misc.Cls(0.0F);
   private static final float FLOAT6 = 0.05F;
   private static final client.onyx.render.misc.Cls CLS = new client.onyx.render.misc.Cls(0.0F);
   private static boolean bool4;
   private static final float FLOAT7 = 55.0F;
   private static final float FLOAT8 = 70.0F;
   private static final float FLOAT9 = 22.0F;
   private static boolean bool5;
   private static float float_8;
   private static float float_9;
   private static final float FLOAT10 = 14.0F;
   private static final float FLOAT11 = 72.0F;
   private static boolean bool6;
   private static final float FLOAT12 = 30.0F;
   private static float float_10;
   private static float float_7 = 1.0F;
   private static float float_11;

   private static float getFloat15() {
      long var0 = System.nanoTime();
      long var2 = long_;
      long_ = var0;
      return var2 == 0L ? 0.0F : Math.min((float)(var0 - var2) / 1000000.0F, 100.0F);
   }

   private Util4() {
   }

   private static Util4.XYRecord getXYRecord() {
      if (OnyxClient.cls != null && MINECRAFT.thePlayer != null) {
         HandModule var0 = OnyxClient.cls.handModule;
         if (!OnyxClient.cls.handModule.isEnabled55()) {
            return null;
         } else {
            HandModule.ResetToVanillaBooleanSetting var1 = var0.resetToVanillaBooleanSetting;
            ValueSettingSub10 var2 = var1.valueSettingSub102;
            ValueSettingSub10 var3 = var1.valueSettingSub109;
            ValueSettingSub10 var4 = var1.valueSettingSub106;
            ValueSettingSub10 var5 = var1.valueSettingSub108;
            ValueSettingSub10 var6 = var1.valueSettingSub105;
            return new Util4.XYRecord(var2, var3, var4, var5, var6, var1.valueSettingSub107);
         }
      } else {
         return null;
      }
   }

   public static boolean isDouble2(double var0) {
      if (!bool3 && !bool2) {
         return false;
      } else {
         Util4.XYRecord var2;
         if ((var2 = getXYRecord()) == null) {
            return false;
         } else {
            if (GuiScreen.isShiftKeyDown()) {
               if (var2.isEnabled2()) {
                  var2.z.handleObject2(var2.z.lambda15() + var0 * 0.03F);
               }
            } else if (var2.isEnabled()) {
               double var3 = Math.pow(1.05F, var0);
               handleValueSettingSub10(var2.sx(), var3, var0);
               handleValueSettingSub10(var2.sy(), var3, var0);
               handleValueSettingSub10(var2.sz(), var3, var0);
            }

            return true;
         }
      }
   }

   private static void handleSampler02(Sampler0 var0, PrimaryOnPrimaryRecord var1, float var2, float var3) {
      float var4;
      if (!((var4 = CLS.getFloat()) <= 0.01F)) {
         Util4.XYRecord var5;
         if ((var5 = getXYRecord()) != null) {
            float var9 = getFloatForFloat(var3);
            var2 = var2 / 2.0F + float_10 / var9;
            var3 = var3 / 2.0F - float_ / var9 - 30.0F;
            var9 = CLS2.getFloat();
            float var7 = 14.0F + 4.0F * var9;
            int var8 = var1.primary();
            var0.handleFloat10(var4);
            var0.handleFloat23(var2, var3, var7, client.onyx.theme.Util4.getIntForInt2(var8, 0.05F + 0.13F * var9));
            var0.handleFloat22(var2, var3, var7, 1.5F, client.onyx.theme.Util4.getIntForInt2(var8, 0.4F + 0.5F * var9));
            var0.handleFloat23(var2, var3, 1.5F + var9, client.onyx.theme.Util4.getIntForInt2(var8, 0.6F + 0.4F * var9));
            if (var9 > 0.01F) {
               StringBuilder var18 = new StringBuilder();
               if (var5.isEnabled2()) {
                  Locale var10001 = Locale.ROOT;
                  Object[] var10003 = new Object[3];
                  boolean var10005 = true;
                  var10003[0] = var5.x.lambda15();
                  var10003[1] = var5.y.lambda15();
                  var10003[2] = var5.z.lambda15();
                  var18.append(String.format(var10001, "%.2f  %.2f  %.2f", var10003));
               }

               if (var5.isEnabled()) {
                  if (var18.length() > 0) {
                     var18.append("  ");
                  }

                  Locale var10 = Locale.ROOT;
                  Object[] var11 = new Object[1];
                  Object var12 = var5.sy.lambda15();
                  var11[0] = var12;
                  String var13 = String.format(var10, "x%.2f", var11);
                  StringBuilder var14 = var18.append(var13);
               }

               String var19 = var18.toString();
               float var20 = var0.getFloat17(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD11, var19) + 14.0F;
               var3 = var3 + var7 + 7.0F;
               var0.handleFloat10(var9);
               var0.handleFloat7(var2 - var20 / 2.0F, var3, var20, 17.0F, 8.5F, var1.surfaceContainerHigh());
               var0.handleOpticalWeightRecord4(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD11, var19, var2, var3 + 8.5F, var1.onSurface());
               var0.run40();
            }

            var0.run40();
         }
      }
   }

   private static void handleFloat6(float var0, boolean var1) {
      float var3 = (float)Math.exp(-var0 / 70.0F);
      var1 = var1 && bool6 && bool && getXYRecord() != null;
      CLS.getCls2(var1 ? 1.0F : 0.0F, 200.0F, client.onyx.render.misc.Util.IFACE6);
      CLS.handleFloat(var0);
      CLS2.getCls2(bool5 ? 1.0F : 0.0F, 150.0F, client.onyx.render.misc.Util.IFACE6);
      CLS2.handleFloat(var0);
      CLS3.getCls2(bool2 ? 1.0F : 0.0F, bool2 ? 250.0F : 200.0F, bool2 ? client.onyx.render.misc.Util.IFACE7 : client.onyx.render.misc.Util.IFACE6);
      CLS3.handleFloat(var0);
      if (!bool2) {
         float_3 *= var3;
         float_9 *= var3;
         float_4 *= var3;
      }
   }

   private static void handleFloat5(float var0, float var1, float var2) {
      Util4.XYRecord var5;
      if ((var5 = getXYRecord()) != null && var5.isEnabled2()) {
         float var4 = getFloatForFloat(float_7);
         float_6 = getFloatForFloat2(float_6 + (var0 - float_8) * var4, var5.x);
         float_11 = getFloatForFloat2(float_11 - (var1 - float_2) * var4, var5.y);
         float_8 = var0;
         float_2 = var1;
         var1 = 1.0F - (float)Math.exp(-var2 / 55.0F);
         float_3 = getFloatForValueSettingSub10(var5.x, float_3, float_6, var1);
         float_9 = getFloatForValueSettingSub10(var5.y, float_9, float_11, var1);
      } else {
         bool2 = false;
      }
   }

   private static boolean isEnabled40() {
      if (!(MINECRAFT.currentScreen instanceof GuiChat)) {
         return false;
      } else if (MINECRAFT.thePlayer == null) {
         return false;
      } else if (MINECRAFT.gameSettings.thirdPersonView != 0) {
         return false;
      } else {
         return OnyxClient.cls == null ? false : OnyxClient.cls.handModule.isEnabled55();
      }
   }

   public static void run32() {
      bool6 = true;
      float var0 = CLS3.getFloat();
      GlStateManager.translate(float_3, float_9 + 0.05F * var0, float_4 + 0.07F * var0);
   }

   public static void run34() {
      Matrix4f.invert(getMatrix4fForMatrix4f(MATRIX4F2), MATRIX4F);
      bool = false;
      bool6 = false;
   }

   public static boolean isEnabled39() {
      return isEnabled40() && OnyxClient.cls != null && getXYRecord() != null;
   }

   private static void handleValueSettingSub10(ValueSettingSub10 var0, double var1, double var3) {
      double var5;
      if (Math.abs((var1 = (var5 = var0.lambda15()) * var1) - var5) < var0.getDouble11()) {
         var1 = var5 + Math.signum(var3) * var0.getDouble11();
      }

      var0.handleObject2(var1);
   }

   public static float getFloat14() {
      return 1.0F + 0.08F * CLS3.getFloat();
   }

   private static float getFloatForFloat(float var0) {
      float var2 = Math.max(0.1F, -float_5);
      return (float)(2.0 * var2 * Math.tan(Math.toRadians(35.0)) / var0);
   }

   public static void handleSampler0(Sampler0 var0, float var1, float var2) {
      float var6 = getFloat15();
      boolean var4 = isEnabled40();
      float_7 = Math.max(1.0F, var2);
      float var9 = Minecraft.getScaledMouseX() * var1 / MINECRAFT.displayWidth;
      float var13 = Minecraft.getScaledMouseY() * var2 / MINECRAFT.displayHeight;
      float var3 = var2 - var13 - 1.0F;
      boolean var7 = Mouse.isButtonDown(0);
      boolean var10000;
      if (var4 && var7) {
         Util4.XYRecord var8;
         if (!bool4 && !bool2 && isFloat(var9, var3, var1, var2, 22.0F) && (var8 = getXYRecord()) != null) {
            bool2 = true;
            float_8 = var9;
            float_2 = var3;
            float_6 = var8.x.getFloat5();
            float_11 = var8.y.getFloat5();
         }

         var10000 = var7;
      } else {
         bool2 = false;
         var10000 = var7;
      }

      bool4 = var10000;
      bool5 = var4 && (bool2 || isFloat(var9, var3, var1, var2, 22.0F));
      bool3 = var4 && (bool2 || isFloat(var9, var3, var1, var2, 72.0F));
      if (bool2) {
         handleFloat5(var9, var3, var6);
      }

      handleFloat6(var6, var4);
      if (var4) {
         handleSampler02(var0, client.onyx.theme.Util4.getPrimaryOnPrimaryRecord(), var1, var2);
         if (bool5) {
            var0.run41();
         }
      }
   }

   private static boolean isFloat(float var0, float var1, float var2, float var3, float var4) {
      if (bool6 && bool && getXYRecord() != null) {
         float var6 = getFloatForFloat(var3);
         var2 = var2 / 2.0F + float_10 / var6 - var0;
         var1 = var3 / 2.0F - float_ / var6 - 30.0F - var1;
         float var7 = var2 * var2;
         float var8 = var1 * var1;
         float var9 = var7 + var8;
         float var10 = var4 * var4;
         return var9 < var10;
      } else {
         return false;
      }
   }

   private static Matrix4f getMatrix4fForMatrix4f(Matrix4f var0) {
      FLOAT_BUFFER.clear();
      GL11.glGetFloat(2982, FLOAT_BUFFER);
      FLOAT_BUFFER.rewind();
      var0.load(FLOAT_BUFFER);
      return var0;
   }

   public static void run33() {
      if (OnyxClient.cls != null) {
         Matrix4f var2 = getMatrix4fForMatrix4f(MATRIX4F2);
         Vector4f var3 = new Vector4f(0.0F, 0.0F, 0.0F, 1.0F);
         Vector4f var0 = Matrix4f.transform(var2, var3, null);
         Vector4f var1 = Matrix4f.transform(MATRIX4F, var0, null);
         float_10 = var1.x;
         float_ = var1.y;
         float_5 = var1.z;
         bool = true;
      }
   }

   private static float getFloatForFloat2(float var0, ValueSettingSub10 var1) {
      return Math.clamp(var0, (float)var1.getDouble13(), (float)var1.getDouble10());
   }

   private static float getFloatForValueSettingSub10(ValueSettingSub10 var0, float var1, float var2, float var3) {
      var1 = var0.getFloat5() + var1;
      float var5;
      var0.handleObject2((double)(var5 = var1 + (var2 - var1) * var3));
      return var5 - var0.getFloat5();
   }

   private record XYRecord(ValueSettingSub10 x, ValueSettingSub10 y, ValueSettingSub10 z, ValueSettingSub10 sx, ValueSettingSub10 sy, ValueSettingSub10 sz) {

      public boolean isEnabled2() {
         return this.x != null && this.y != null && this.z != null;
      }

      public boolean isEnabled() {
         return this.sx != null && this.sy != null && this.sz != null;
      }
   }
}
