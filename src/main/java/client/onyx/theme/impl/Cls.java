package client.onyx.theme.impl;

public final class Cls {
   private final double double_;
   private final double double_2;
   private final int int_;
   private final double double_3;

   public Cls getCls(double var1) {
      return getClsForDouble(this.double_, this.double_2, var1);
   }

   public Cls getCls3(double var1) {
      return getClsForDouble(this.double_, var1, this.double_3);
   }

   private Cls(double var1, double var3, double var5, int var7) {
      this.double_ = var1;
      this.double_2 = var3;
      this.double_3 = var5;
      this.int_ = var7;
   }

   public static Cls getClsForDouble(double var0, double var2, double var4) {
      return getClsForInt(getIntForDouble(var0, var2, var4));
   }

   public double getDouble() {
      return this.double_;
   }

   public double getDouble3() {
      return this.double_3;
   }

   private static Cls3 getCls3ForDouble(double var0, double var2, double var4) {
      double var6 = 0.0;
      double var8 = 100.0;
      double var10 = 1000.0;
      Cls3 var12 = null;

      while (Math.abs(var6 - var8) > 0.01) {
         double var13;
         int var15;
         double var16 = Util2.getDoubleForInt2(var15 = Cls3.getCls3ForDouble(var13 = var6 + (var8 - var6) / 2.0, var2, var0).getInt());
         if (Math.abs(var4 - var16) < 0.2) {
            Cls3 var20;
            Cls3 var10000 = var20 = Cls3.getCls3ForInt(var15);
            double var18;
            if ((var18 = var10000.getDouble(Cls3.getCls3ForDouble(var10000.double_6, var2, var0))) <= 1.0 && var18 <= var10) {
               var10 = var18;
               var12 = var20;
            }
         }

         if (var16 < var4) {
            var6 = var13;
         } else {
            var8 = var13;
         }
      }

      return var12;
   }

   public double getDouble2() {
      return this.double_2;
   }

   private static int getIntForDouble(double var0, double var2, double var4) {
      if (!(var2 < 1.0) && Math.round(var4) > 0L && Math.round(var4) < 100L) {
         var0 = Util2.getDoubleForDouble(var0);
         double var6 = 0.0;
         double var8 = var2;
         var2 = var2;
         boolean var10 = true;
         Cls3 var11 = null;
         double var10000 = var6;

         while (Math.abs(var10000 - var8) >= 0.4) {
            Cls3 var12 = getCls3ForDouble(var0, var2, var4);
            if (var10) {
               if (var12 != null) {
                  return var12.getInt();
               }

               var10 = false;
               var2 = var6 + (var8 - var6) / 2.0;
               var10000 = var6;
            } else {
               if (var12 == null) {
                  var8 = var2;
                  var10000 = var6;
               } else {
                  var11 = var12;
                  var10000 = var6 = var2;
               }

               var2 = var10000 + (var8 - var6) / 2.0;
               var10000 = var6;
            }
         }

         return var11 == null ? Util2.getIntForDouble(var4) : var11.getInt();
      } else {
         return Util2.getIntForDouble(var4);
      }
   }

   public int getInt() {
      return this.int_;
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 8;
      byte var12 = 32;
      int var10000 = var10002;

      for (byte var2 = 95; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var10002 = var5--;
         var1[var10002] = (char)(var10.charAt(var10002) ^ var4);
      }

      return new String(var1);
   }

   public static Cls getClsForInt(int var0) {
      Cls3 var2 = Cls3.getCls3ForInt(var0);
      return new Cls(var2.double_, var2.double_2, Util2.getDoubleForInt2(var0), var0 | 0xFF000000);
   }

   public Cls getCls2(double var1) {
      return getClsForDouble(var1, this.double_2, this.double_3);
   }
}
