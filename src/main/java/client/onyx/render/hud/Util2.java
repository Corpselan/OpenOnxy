package client.onyx.render.hud;

import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public final class Util2 {
   private static final int[] INT_ARRAY;
   private static final float FLOAT = 0.26F;
   private static final float FLOAT2 = 7.0F;
   private static final float FLOAT3 = 0.5F;
   private static final String STRING = "0123456789abcdef";
   private static final char CHAR = '§';
   private static final float FLOAT4 = 2.0F;
   private static final float FLOAT5 = 0.8F;
   private static final float FLOAT6 = 0.12F;
   private static final float FLOAT7 = 1.0F;

   static {
      int[] var0 = new int[]{
         -16777216, -16777046, -16733696, -16733526, -5636096, -5635926, -22016, -5592406, -11184811, -11184641, -11141291, -11141121, -43691, -43521, -171, -1
      };
      INT_ARRAY = var0;
   }

   private static Util2.AtlasIconEnum getAtlasIconEnumForOpticalWeightRecord(OpticalWeightRecord var0, char var1) {
      if (var0.getAyg().isChar2(var1)) {
         return Util2.AtlasIconEnum.ATLAS;
      } else {
         return getStringForChar(var1) != null ? Util2.AtlasIconEnum.ICON : Util2.AtlasIconEnum.BITMAP;
      }
   }

   private static float getFloatForOpticalWeightRecord(OpticalWeightRecord var0, String var1) {
      FontRenderer var3;
      return (var3 = Minecraft.getMinecraft().fontRendererObj) == null ? 0.0F : var3.getStringWidth(var1) * (var0.getFloat4() / 7.0F);
   }

   private static float getFloatForSampler07(Sampler0 var0, OpticalWeightRecord var1, String var2) {
      float var6 = var1.getFloat4() / 0.8F;
      float var5 = 0.0F;

      int var4;
      for (int var10000 = var4 = 0; var10000 < var2.length(); var10000 = var4) {
         float var10001 = var0.getFloat18(getStringForChar(var2.charAt(var4)), var6);
         var4++;
         var5 += var10001 + 1.0F;
      }

      return var5;
   }

   private static String getStringForChar(char var0) {
      switch (var0) {
         case '☑':
         case '✅':
         case '✓':
         case '✔':

            return "\ue5ca";
         case '☒':
         case '✕':
         case '✖':
         case '✗':
         case '✘':
         case '❌':
            return "\ue5cd";
         default:
            return null;
      }
   }

   public static String getStringForString(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(var0.length());

         int var4;
         for (int var10000 = var4 = 0; var10000 < var0.length(); var10000 = ++var4) {
            char var3;
            if ((var3 = var0.charAt(var4)) == 167 && var4 < var0.length() - 1) {
               var4++;
            } else {
               var1.append(var3);
            }
         }

         return var1.toString();
      } else {
         return "";
      }
   }

   public static float getFloatForSampler02(Sampler0 var0, OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      return getFloatForSampler011(var0, var1, var2, var3 - getFloatForSampler04(var0, var1, var2), var4, var5);
   }

   private Util2() {
   }

   private static int getIntForFloat(float var0) {
      return (int)(Math.clamp(var0, 0.0F, 1.0F) * 255.0F) << 24;
   }

   public static float getFloatForSampler04(Sampler0 var0, OpticalWeightRecord var1, String var2) {
      if ((var2 = getStringForString(var2)).isEmpty()) {
         return 0.0F;
      } else {
         float var6 = 0.0F;
         int var4 = 0;
         Util2.AtlasIconEnum var5 = getAtlasIconEnumForOpticalWeightRecord(var1, var2.charAt(0));

         int var3;
         for (int var10000 = var3 = 1; var10000 <= var2.length(); var10000 = ++var3) {
            Util2.AtlasIconEnum var7 = var3 < var2.length() ? getAtlasIconEnumForOpticalWeightRecord(var1, var2.charAt(var3)) : null;
            if (var3 >= var2.length() || var7 != var5) {
               String var8 = var2.substring(var4, var3);

               var6 += switch (var5) {
                  case ATLAS -> {

                     yield var0.getFloat17(var1, var8);
                  }
                  case ICON -> getFloatForSampler07(var0, var1, var8);
                  case BITMAP -> getFloatForOpticalWeightRecord(var1, var8);
               };
               var4 = var3;
               var5 = var7;
            }
         }

         return var6;
      }
   }

   public static float getFloatForSampler011(Sampler0 var0, OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      if (var2 != null && !var2.isEmpty()) {
         int var6 = var5 & 0xFF000000;
         int var7 = var5;
         float var8 = var3;
         int var9 = 0;

         int var10;
         for (int var10000 = var10 = 0; var10000 < var2.length(); var10000 = ++var10) {
            if (var2.charAt(var10) == 167 && var10 < var2.length() - 1) {
               var8 += getFloatForSampler06(var0, var1, var2, var9, var10, var8, var4, var7);
               char var11 = Character.toLowerCase(var2.charAt(var10 + 1));
               int var12;
               if ((var12 = "0123456789abcdef".indexOf(var11)) >= 0) {
                  var7 = var6 | INT_ARRAY[var12] & 16777215;
               } else if (var11 == 'r') {
                  var7 = var5;
               }

               var9 = ++var10 + 1;
            }
         }

         return var8 + getFloatForSampler06(var0, var1, var2, var9, var2.length(), var8, var4, var7) - var3;
      } else {
         return 0.0F;
      }
   }

   public static float getFloatForSampler09(Sampler0 var0, OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      if (var2 != null && !var2.isEmpty()) {
         String var6 = getStringForString(var2);
         float var7 = (var5 >>> 24) / 255.0F;
         getFloatForSampler011(var0, var1, var6, var3 + 2.0F, var4 + 2.0F, getIntForFloat(0.12F * var7));
         getFloatForSampler011(var0, var1, var6, var3 + 1.0F, var4 + 1.0F, getIntForFloat(0.26F * var7));
         return getFloatForSampler011(var0, var1, var2, var3, var4, var5);
      } else {
         return 0.0F;
      }
   }

   private static float getFloatForSampler03(Sampler0 var0, OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      float var6 = var1.getFloat4() / 0.8F;
      float var9 = var0.getFloat16(var1, var4) - var1.getFloat4() / 2.0F;
      var4 = var3;

      int var7;
      for (int var10000 = var7 = 0; var10000 < var2.length(); var10000 = var7) {
         String var8;
         String var10001 = var8 = getStringForChar(var2.charAt(var7));
         float var11 = var0.getFloat18(var8, var6) + 1.0F;
         var0.handleString6(var10001, var4 + var11 / 2.0F, var9, var6, var5);
         var7++;
         var4 += var11;
      }

      return var4 - var3;
   }

   public static float getFloatForSampler010(Sampler0 var0, OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      return getFloatForSampler011(var0, var1, var2, var3 - getFloatForSampler04(var0, var1, var2) / 2.0F, var4, var5);
   }

   private static float getFloatForSampler0(Sampler0 var0, OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      var0.handleOpticalWeightRecord8(var1, var2, var3, var4, var5);
      return var0.getFloat17(var1, var2);
   }

   private static float getFloatForSampler08(Sampler0 var0, OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      FontRenderer var7;
      if ((var7 = Minecraft.getMinecraft().fontRendererObj) == null) {
         return 0.0F;
      } else {
         float var9 = var1.getFloat4() / 7.0F;
         float var8 = var0.getFloat16(var1, var4) - 7.0F * var9;
         client.onyx.render.extra.Cls.run2();
         var0.run36();
         var0.handleFloat11(var3, var8);
         var0.handleFloat12(var9, 0.0F, 0.0F);
         var7.drawString(var2, 0.0F, 0.0F, var5, false);
         var0.run43();
         return getFloatForOpticalWeightRecord(var1, var2);
      }
   }

   private static float getFloatForSampler06(Sampler0 var0, OpticalWeightRecord var1, String var2, int var3, int var4, float var5, float var6, int var7) {
      if (var4 <= var3) {
         return 0.0F;
      } else {
         float var8 = var5;
         int var9 = var3;
         Util2.AtlasIconEnum var10 = getAtlasIconEnumForOpticalWeightRecord(var1, var2.charAt(var3));

         for (int var10000 = ++var3; var10000 <= var4; var10000 = ++var3) {
            Util2.AtlasIconEnum var11 = var3 < var4 ? getAtlasIconEnumForOpticalWeightRecord(var1, var2.charAt(var3)) : null;
            if (var3 >= var4 || var11 != var10) {
               String var12 = var2.substring(var9, var3);

               var8 += switch (var10) {
                  case ATLAS -> {

                     yield getFloatForSampler0(var0, var1, var12, var8, var6, var7);
                  }
                  case ICON -> getFloatForSampler03(var0, var1, var12, var8, var6, var7);
                  case BITMAP -> getFloatForSampler08(var0, var1, var12, var8, var6, var7);
               };
               var9 = var3;
               var10 = var11;
            }
         }

         return var8 - var5;
      }
   }

   public static float getFloatForSampler05(Sampler0 var0, OpticalWeightRecord var1, String var2, float var3, float var4, int var5) {
      return getFloatForSampler09(var0, var1, var2, var3 - getFloatForSampler04(var0, var1, var2) / 2.0F, var4, var5);
   }

   private static enum AtlasIconEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      ATLAS,
      ICON,
      BITMAP;

   }
}
