package client.onyx.util;

import java.util.Comparator;

public class ComparatorImpl<T> implements Comparator<T> {
   private final Comparator<? super T>[] comparatorArray;

   @SafeVarargs
   public ComparatorImpl(Comparator<? super T>... var1) {
      this.comparatorArray = var1;
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 18;
      byte var12 = 84;
      int var10000 = var10002;

      for (byte var2 = 117; var10000 >= 0; var10000 = var5) {
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

   @Override
   public int compare(T var1, T var2) {
      Comparator[] var5 = this.comparatorArray;
      int var4 = this.comparatorArray.length;

      int var7;
      for (int var10000 = var7 = 0; var10000 < var4; var10000 = ++var7) {
         int var6;
         if ((var6 = var5[var7].compare(var1, var2)) != 0) {
            return var6;
         }
      }

      return 0;
   }
}
