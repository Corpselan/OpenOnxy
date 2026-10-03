package client.onyx.render.misc;

import client.onyx.theme.impl.Util2;

public final class Cls2 {
   private int int_;
   private int int_2;
   private final Cls cls = new Cls(1.0F);

   public Cls2 getCls22(int var1, float var2, Iface var3) {
      if (var1 == this.int_) {
         return this;
      } else {
         this.int_2 = this.getInt();
         this.int_ = var1;
         this.cls.getCls(0.0F).getCls2(1.0F, var2, var3);
         return this;
      }
   }

   public void handleFloat(float var1) {
      this.cls.handleFloat(var1);
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 22;
      byte var12 = 53;
      int var10000 = var10002;

      for (byte var2 = 47; var10000 >= 0; var10000 = var5) {
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

   public Cls2(int var1) {
      this.int_2 = var1;
      this.int_ = var1;
   }

   private static double[] getDoubleArrayForInt(int var0) {
      double[] var10000 = new double[3];
      boolean var10002 = true;
      var10000[0] = Util2.getDoubleForInt(Util2.getIntForInt7(var0));
      var10000[1] = Util2.getDoubleForInt(Util2.getIntForInt(var0));
      var10000[2] = Util2.getDoubleForInt(Util2.getIntForInt2(var0));
      return var10000;
   }

   public static int getIntForInt(int var0, int var1, float var2) {
      double[] var7 = getDoubleArrayForInt(var0);
      double[] var4 = getDoubleArrayForInt(var1);
      int var5 = Util2.getIntForDouble3(var7[0] + (var4[0] - var7[0]) * var2);
      int var6 = Util2.getIntForDouble3(var7[1] + (var4[1] - var7[1]) * var2);
      int var8 = Util2.getIntForDouble3(var7[2] + (var4[2] - var7[2]) * var2);
      return Util2.getIntForInt5(Math.round(Util2.getIntForInt6(var0) + (Util2.getIntForInt6(var1) - Util2.getIntForInt6(var0)) * var2), var5, var6, var8);
   }

   public int getInt() {
      float var2;
      if ((var2 = this.cls.getFloat()) <= 0.0F) {
         return this.int_2;
      } else {
         return var2 >= 1.0F ? this.int_ : getIntForInt(this.int_2, this.int_, var2);
      }
   }

   public Cls2 getCls2(int var1) {
      this.int_2 = var1;
      this.int_ = var1;
      this.cls.getCls(1.0F);
      return this;
   }
}
