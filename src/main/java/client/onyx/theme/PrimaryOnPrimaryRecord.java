package client.onyx.theme;

import client.onyx.theme.impl.Cls;
import client.onyx.theme.impl.Cls2;

public record PrimaryOnPrimaryRecord(
   int primary,
   int onPrimary,
   int primaryContainer,
   int onPrimaryContainer,
   int secondary,
   int onSecondary,
   int secondaryContainer,
   int onSecondaryContainer,
   int tertiary,
   int onTertiary,
   int tertiaryContainer,
   int onTertiaryContainer,
   int error,
   int onError,
   int errorContainer,
   int onErrorContainer,
   int surface,
   int onSurface,
   int surfaceVariant,
   int onSurfaceVariant,
   int surfaceDim,
   int surfaceBright,
   int surfaceContainerLowest,
   int surfaceContainerLow,
   int surfaceContainer,
   int surfaceContainerHigh,
   int surfaceContainerHighest,
   int outline,
   int outlineVariant,
   int inverseSurface,
   int inverseOnSurface,
   int inversePrimary,
   int scrim,
   int shadow
) {
   private static final double DOUBLE = 36.0;
   private static final double DOUBLE2 = 56.0;
   private static final double DOUBLE3 = 30.0;
   private static final double DOUBLE4 = 50.0;
   private static final double DOUBLE5 = 64.0;

   public static PrimaryOnPrimaryRecord getPrimaryOnPrimaryRecordForInt(int var0, float var1) {
      Cls var3;
      float[] var4;
      return getPrimaryOnPrimaryRecordForDouble(
         (var3 = Cls.getClsForInt(
               client.onyx.theme.impl.Util2.getIntForFloat((var4 = client.onyx.theme.impl.Util2.getFloatArrayForInt(var0))[0], var4[1], 1.0F, 255)
            ))
            .getDouble(),
         var3.getDouble2(),
         var4[1],
         var4[2],
         var1
      );
   }

   private static double getDoubleForDouble(double var0, double var2) {
      return Math.clamp(var0 - var2 * var0 / 100.0, 0.0, 100.0);
   }

   public static PrimaryOnPrimaryRecord getPrimaryOnPrimaryRecordForDouble(double var0, double var2, float var4, float var5, float var6) {
      double var7 = Math.clamp(var6, 0.0F, 1.0F) * Math.clamp(var4, 0.0F, 1.0F);
      double var9;
      double var11 = (var9 = 1.0 - Math.clamp(var5, 0.0F, 1.0F)) * 30.0;
      var9 *= 50.0;
      Cls2 var18 = Cls2.getCls2ForDouble(var0, var2);
      Cls2 var16 = Cls2.getCls2ForDouble(var0, var2 / 3.0);
      Cls2 var15 = Cls2.getCls2ForDouble(var0 + 60.0, var2 / 2.0);
      Cls2 var13 = Cls2.getCls2ForDouble(var0, 36.0 * var7);
      Cls2 var3 = Cls2.getCls2ForDouble(var0, 56.0 * var7);
      Cls2 var1 = Cls2.getCls2ForDouble(var0, 64.0 * var7);
      Cls2 var19 = Cls2.getCls2ForDouble(25.0, 84.0);
      return new PrimaryOnPrimaryRecord(
         var18.getInt(getDoubleForDouble(80.0, var11)),
         var18.getInt2(20),
         var18.getInt(getDoubleForDouble(30.0, var11)),
         var18.getInt2(90),
         var16.getInt(getDoubleForDouble(80.0, var11)),
         var16.getInt2(20),
         var16.getInt(getDoubleForDouble(30.0, var11)),
         var16.getInt2(90),
         var15.getInt(getDoubleForDouble(80.0, var11)),
         var15.getInt2(20),
         var15.getInt(getDoubleForDouble(30.0, var11)),
         var15.getInt2(90),
         var19.getInt2(80),
         var19.getInt2(20),
         var19.getInt2(30),
         var19.getInt2(90),
         var3.getInt(getDoubleForDouble(6.0, var9)),
         var13.getInt2(90),
         var1.getInt(getDoubleForDouble(30.0, var9)),
         var1.getInt2(80),
         var3.getInt(getDoubleForDouble(6.0, var9)),
         var3.getInt(getDoubleForDouble(24.0, var9)),
         var3.getInt(getDoubleForDouble(4.0, var9)),
         var3.getInt(getDoubleForDouble(10.0, var9)),
         var3.getInt(getDoubleForDouble(12.0, var9)),
         var3.getInt(getDoubleForDouble(17.0, var9)),
         var3.getInt(getDoubleForDouble(22.0, var9)),
         var1.getInt(getDoubleForDouble(60.0, var9)),
         var1.getInt(getDoubleForDouble(30.0, var9)),
         var13.getInt2(90),
         var13.getInt2(20),
         var18.getInt(getDoubleForDouble(40.0, var11)),
         var13.getInt2(0),
         var13.getInt2(0)
      );
   }
}
