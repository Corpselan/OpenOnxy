package client.onyx.util.math;

import java.util.Arrays;

final class Cls {
   private double[] doubleArray;
   private int int_;

   double getDouble(int var1) {
      return this.doubleArray[var1];
   }

   int getInt() {
      return this.int_;
   }

   void run() {
      if (this.int_ > 1) {
         int var5;
         for (int var10000 = var5 = 1; var10000 < this.int_; var10000 = var5) {
            double var2 = this.doubleArray[var5];

            int var4;
            for (int var8 = var4 = var5; var8 > 0 && this.doubleArray[var4 - 1] > var2; var8 = var4) {
               int var10001 = var4;
               double var10002 = this.doubleArray[var4 - 1];
               var4--;
               this.doubleArray[var10001] = var10002;
            }

            var5++;
            this.doubleArray[var4] = var2;
         }

         var5 = 1;

         int var6;
         for (int var9 = var6 = 1; var9 < this.int_; var9 = ++var6) {
            double var3;
            if ((var3 = this.doubleArray[var6]) != this.doubleArray[var5 - 1]) {
               this.doubleArray[var5++] = var3;
            }
         }

         this.int_ = var5;
      }
   }

   Cls(int var1) {
      double[] var10001 = new double[var1];
      boolean var10003 = true;
      this.doubleArray = var10001;
   }

   void handleDouble2(double var1) {
      if (Double.isFinite(var1)) {
         this.handleDouble(var1);
      }
   }

   void handleDouble(double var1) {
      if (this.int_ == this.doubleArray.length) {
         double[] var4 = this.doubleArray;
         int var6 = this.int_ * 2;
         int var7 = Math.max(4, var6);
         double[] var8 = Arrays.copyOf(var4, var7);
         this.doubleArray = var8;
      }

      this.doubleArray[this.int_++] = var1;
   }
}
