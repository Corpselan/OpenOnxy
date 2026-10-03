package client.onyx.setting;

public record MinMaxRecord(double min, double max) {
   public MinMaxRecord(double min, double max) {
      if (min > max) {
         double var10000 = min;
         min = max;
         max = var10000;
      }

      this.min = min;
      this.max = max;
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 99;
      byte var12 = 100;
      int var10000 = var10002;

      for (byte var2 = 10; var10000 >= 0; var10000 = var5) {
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

   public boolean isDouble(double var1) {
      return var1 >= this.min && var1 <= this.max;
   }

   public double getDouble() {
      return this.max - this.min;
   }
}
