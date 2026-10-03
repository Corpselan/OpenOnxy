package client.onyx.render.hud;

import client.onyx.OnyxClient;
import client.onyx.module.hud.CustomGuiModule;
import client.onyx.render.font.Ayg;
import client.onyx.render.font.OpticalWeightRecord;
import java.util.Random;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public final class Util3 {
   private static final Random RANDOM = new Random();
   private static final float FLOAT = 1.0F;
   private static client.onyx.render.font.Util.ThinExtraLightEnum thinExtraLightEnum;
   private static final int INT = 16579836;
   private static float float_;
   private static OpticalWeightRecord opticalWeightRecord;
   private static final float FLOAT2 = 0.2F;
   private static OpticalWeightRecord opticalWeightRecord2;
   private static final float FLOAT3 = 7.0F;
   private static final float FLOAT4 = 7.0F;
   private static boolean bool;
   private static final String STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
   private static boolean bool2;

   private static float getFloatForFontRenderer3(FontRenderer var0, char var1, float var2, float var3, int var4, boolean var5) {
      String var6 = String.valueOf(var1);
      bool2 = true;

      float var10;
      try {
         var0.drawString(var6, var2, var3, var4, false);
         var10 = (float)var0.getCharWidth(var1) + (var5 ? var0.offsetBold : 0.0F);
      } finally {
         bool2 = false;
         GlStateManager.enableTexture2D();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      }

      return var10;
   }

   public static boolean isChar(char var0) {
      try {
         return var0 == 167 || var0 == ' ' || getOpticalWeightRecordForBool(false).getAyg().isChar2(var0);
      } catch (Throwable var3) {
         bool = true;
         OnyxClient.LOGGER.warn("Custom GUI font stood down to the bitmap font after a failure", var3);
         return false;
      }
   }

   public static float getFloatForChar(char var0) {
      OpticalWeightRecord var2;
      return var0 == 167 ? -1.0F : (var2 = getOpticalWeightRecordForBool(false)).getAyg().getFloat(var0) * var2.getFloat2() + getFloat();
   }

   private static void handleFontRenderer(FontRenderer var0, String var1, float var2, float var3, int var4, boolean var5) {
      if (!var1.isEmpty()) {
         OpticalWeightRecord var20;
         Ayg var7 = (var20 = getOpticalWeightRecordForBool(false)).getAyg();
         Ayg var8 = getOpticalWeightRecordForBool(true).getAyg();

         int var9;
         int var10000;
         for(var10000 = var9 = 0; var10000 < var1.length(); var10000 = var9) {
            var7.getU0V0Record2(var1.charAt(var9));
            var8.getU0V0Record2(var1.charAt(var9++));
         }

         if (var7.getInt() != -1) {
            float var25 = var20.getFloat2();
            var4 = var4;
            GlStateManager.enableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            var2 = var2;
            int var27 = var4;
            boolean var10 = false;
            boolean var11 = false;
            boolean var12 = false;
            boolean var13 = false;
            boolean var14 = false;

            int var15;
            for(var10000 = var15 = 0; var10000 < var1.length(); var10000 = var15) {
               char var16;
               char var17;
               if ((var16 = var1.charAt(var15)) == 167 && var15 < var1.length() - 1) {
                  ++var15;
                  var17 = Character.toLowerCase(var1.charAt(var15));
                  if ("0123456789abcdef".indexOf(var17) >= 0) {
                     var14 = false;
                     var13 = false;
                     var12 = false;
                     var11 = false;
                     var10 = false;
                     int var26 = var0.getColorCode(var17);
                     var27 = var4 & -16777216 | (var5 ? (var26 & 16579836) >> 2 : var26) & 16777215;
                  } else {
                     switch(var17) {
                     case 'k':

                        var12 = true;
                        break;
                     case 'l':
                        var10 = true;
                        break;
                     case 'm':
                        var14 = true;
                        break;
                     case 'n':
                        var13 = true;
                        break;
                     case 'o':
                        var11 = true;
                     case 'p':
                     case 'q':
                     default:
                        break;
                     case 'r':
                        var14 = false;
                        var13 = false;
                        var12 = false;
                        var11 = false;
                        var10 = false;
                        var27 = var4;
                     }
                  }
               } else {
                  var17 = var12 ? getCharForChar(var16) : var16;
                  if (!isChar(var17)) {
                     float var21 = getFloatForFontRenderer3(var0, var17, var2, var3, var27, var10);
                     float var22 = getFloat();
                     float var23 = var21 + var22;
                     var2 += var23;
                  } else {
                     Ayg var18 = var10 ? var8 : var7;
                     float var19 = var7.getFloat(var16) * var25 + getFloat() + (var10 ? getFloatForFontRenderer(var0) : 0.0F);
                     handleAyg(var18, var17, var2, var3, var25, var27, var11);
                     if (var14) {
                        handleFloat(var2, var3 + 3.8500001F, var19, var27);
                     }

                     if (var13) {
                        handleFloat(var2, var3 + 7.0F + 1.0F, var19, var27);
                     }

                     var2 += var19;
                  }
               }

               ++var15;
            }

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.resetColor();
         }
      }
   }

   private static int getIntForFontRenderer3(FontRenderer var0, String var1, float var2, float var3, int var4, boolean var5) {
      if (var1 == null) {
         return 0;
      } else {
         if ((var4 & -67108864) == 0) {
            var4 |= -16777216;
         }

         if (var5) {
            handleFontRenderer(var0, var1, var2 + 1.0F, var3 + 1.0F, getIntForInt(var4), true);
         }

         handleFontRenderer(var0, var1, var2, var3, var4, false);
         return (int)(var2 + (float)getIntForFontRenderer(var0, var1));
      }
   }

   private static float getFloatForFontRenderer2(FontRenderer var0, char var1) {
      bool2 = true;

      float var5;
      try {
         var5 = (float)var0.getCharWidth(var1);
      } finally {
         bool2 = false;
      }

      return var5;
   }

   private static char getCharForChar(char var0) {
      return var0 == ' ' ? var0 : "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(RANDOM.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".length()));
   }

   private static client.onyx.render.font.Util.ThinExtraLightEnum getThinExtraLightEnumForThinExtraLightEnum(client.onyx.render.font.Util.ThinExtraLightEnum var0) {
      switch(var0) {
      case REGULAR:
         client.onyx.render.font.Util.ThinExtraLightEnum var10000 = client.onyx.render.font.Util.ThinExtraLightEnum.SEMI_BOLD;


         return var10000;
      case MEDIUM:
         return client.onyx.render.font.Util.ThinExtraLightEnum.BOLD;
      default:
         return client.onyx.render.font.Util.ThinExtraLightEnum.BOLD;
      }
   }

   private static OpticalWeightRecord getOpticalWeightRecordForBool(boolean var0) {
      CustomGuiModule var1;
      float var4 = (var1 = Util4.getCustomGuiModule()) == null ? 1.0F : var1.fontBooleanSetting.valueSettingSub10.getFloat5();
      client.onyx.render.font.Util.ThinExtraLightEnum var3 = var1 == null ? client.onyx.render.font.Util.ThinExtraLightEnum.REGULAR : ((CustomGuiModule.RegularMediumEnum)var1.fontBooleanSetting.valueSettingSub11.lambda15()).getThinExtraLightEnum();
      if (opticalWeightRecord2 == null || var4 != float_ || var3 != thinExtraLightEnum) {
         opticalWeightRecord2 = getOpticalWeightRecordForThinExtraLightEnum(var3, var4);
         opticalWeightRecord = getOpticalWeightRecordForThinExtraLightEnum(getThinExtraLightEnumForThinExtraLightEnum(var3), var4);
         float_ = var4;
         thinExtraLightEnum = var3;
      }

      return var0 ? opticalWeightRecord : opticalWeightRecord2;
   }

   private static float getFloat() {
      CustomGuiModule var0;
      return (var0 = Util4.getCustomGuiModule()) == null ? 0.0F : var0.fontBooleanSetting.valueSettingSub102.getFloat5();
   }

   public static int getIntForFontRenderer2(FontRenderer var0, String var1, float var2, float var3, int var4, boolean var5) {
      try {
         return getIntForFontRenderer3(var0, var1, var2, var3, var4, var5);
      } catch (Throwable var8) {
         bool = true;
         bool2 = false;
         OnyxClient.LOGGER.warn("Custom GUI font stood down to the bitmap font after a failure", var8);
         return var0.drawString(var1, var2, var3, var4, var5);
      }
   }

   private Util3() {
   }

   public static void run() {
      opticalWeightRecord2 = null;
      opticalWeightRecord = null;
      bool = false;
   }

   public static int getIntForFontRenderer(FontRenderer var0, String var1) {
      if (var1 != null && !var1.isEmpty()) {
         float var7 = 0.0F;
         boolean var4 = false;

         int var3;
         for(int var10000 = var3 = 0; var10000 < var1.length(); var10000 = var3) {
            char var5;
            if ((var5 = var1.charAt(var3)) == 167 && var3 < var1.length() - 1) {
               ++var3;
               char var6;
               if ((var6 = Character.toLowerCase(var1.charAt(var3))) == 'l') {
                  var4 = true;
               } else if (var6 == 'r' || "0123456789abcdef".indexOf(var6) >= 0) {
                  var4 = false;
               }
            } else {
               var7 += isChar(var5) ? getFloatForChar(var5) : getFloatForFontRenderer2(var0, var5) + getFloat();
               if (var4) {
                  var7 += var0.offsetBold;
               }
            }

            ++var3;
         }

         return Math.round(var7);
      } else {
         return 0;
      }
   }

   private static void handleFloat(float var0, float var1, float var2, int var3) {
      GlStateManager.disableTexture2D();
      GL11.glColor4f((float)(var3 >> 16 & 255) / 255.0F, (float)(var3 >> 8 & 255) / 255.0F, (float)(var3 & 255) / 255.0F, (float)(var3 >>> 24) / 255.0F);
      GL11.glBegin(7);
      GL11.glVertex2f(var0, var1);
      GL11.glVertex2f(var0, var1 + 1.0F);
      GL11.glVertex2f(var0 + var2, var1 + 1.0F);
      GL11.glVertex2f(var0 + var2, var1);
      GL11.glEnd();
      GlStateManager.enableTexture2D();
   }

   private static int getIntForInt(int var0) {
      return var0 & -16777216 | (var0 & 16579836) >> 2;
   }

   public static boolean isEnabled2() {
      if (!bool && !bool2 && Util4.isEnabled10()) {
         CustomGuiModule var0;
         return (var0 = Util4.getCustomGuiModule()) != null && var0.isEnabled55() && var0.fontBooleanSetting.isEnabled5();
      } else {
         return false;
      }
   }

   private static float getFloatForFontRenderer(FontRenderer var0) {
      return var0.offsetBold;
   }

   private static void handleAyg(Ayg var0, char var1, float var2, float var3, float var4, int var5, boolean var6) {
      Ayg.U0V0Record var9;
      if (!(var9 = var0.getU0V0Record2(var1)).isEnabled()) {
         int var7;
         if ((var7 = var0.getInt()) != -1) {
            GlStateManager.bindTexture(var7);
            GL11.glColor4f((float)(var5 >> 16 & 255) / 255.0F, (float)(var5 >> 8 & 255) / 255.0F, (float)(var5 & 255) / 255.0F, (float)(var5 >>> 24) / 255.0F);
            var2 += var9.bearingX() * var4;
            float var10 = var3 + 7.0F + var9.bearingY() * var4;
            float var12 = var2 + var9.width() * var4;
            var4 = var10 + var9.height() * var4;
            float var8 = var6 ? (var3 + 7.0F - var10) * 0.2F : 0.0F;
            float var11 = var6 ? (var3 + 7.0F - var4) * 0.2F : 0.0F;
            GL11.glBegin(7);
            GL11.glTexCoord2f(var9.u0(), var9.v0());
            GL11.glVertex2f(var2 + var8, var10);
            GL11.glTexCoord2f(var9.u0(), var9.v1());
            GL11.glVertex2f(var2 + var11, var4);
            GL11.glTexCoord2f(var9.u1(), var9.v1());
            GL11.glVertex2f(var12 + var11, var4);
            GL11.glTexCoord2f(var9.u1(), var9.v0());
            GL11.glVertex2f(var12 + var8, var10);
            GL11.glEnd();
         }
      }
   }

   public static boolean isEnabled() {
      CustomGuiModule var0;
      return (var0 = Util4.getCustomGuiModule()) == null || var0.fontBooleanSetting.valueSettingSub92.isEnabled17();
   }

   private static OpticalWeightRecord getOpticalWeightRecordForThinExtraLightEnum(client.onyx.render.font.Util.ThinExtraLightEnum var0, float var1) {
      float var3;
      client.onyx.render.font.Util.Pt9Pt24Enum var5;
      float var4 = (var3 = client.onyx.render.font.Util.getAygForPt9Pt24Enum(var5 = client.onyx.render.font.Util.Pt9Pt24Enum.PT24, var0).getFloat5() / var5.getFloat()) > 0.0F ? 7.0F / var3 : var5.getFloat();
      return new OpticalWeightRecord(var5, var0, var4 * var1, 9.0F);
   }
}
