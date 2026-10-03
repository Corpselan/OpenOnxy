package client.onyx.theme.impl;

import java.util.HashMap;
import java.util.Map;

public final class Cls2 {
   private final double double_;
   private final double double_2;
   private final Map<Integer, Integer> map = new HashMap<>();

   public Cls getCls(double var1) {
      return Cls.getClsForDouble(this.double_, this.double_2, var1);
   }

   public static Cls2 getCls2ForDouble(double var0, double var2) {
      return new Cls2(var0, var2);
   }

   public static Cls2 getCls2ForInt(int var0) {
      Cls var2 = Cls.getClsForInt(var0);
      return new Cls2(var2.getDouble(), var2.getDouble2());
   }

   public int getInt(double var1) {
      return Cls.getClsForDouble(this.double_, this.double_2, var1).getInt();
   }

   private Cls2(double var1, double var3) {
      this.double_ = var1;
      this.double_2 = var3;
   }

   public double getDouble2() {
      return this.double_2;
   }

   public Map<Integer, Integer> getMap() {
      return this.map;
   }

   public int getInt2(int var1) {
      return this.map.computeIfAbsent(var1, var1x -> Cls.getClsForDouble(this.double_, this.double_2, var1x.intValue()).getInt());
   }

   public static String decrypt(String var0) {
      int var10002 = 4 << 4 ^ 2 << 2 ^ 3;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var12 = var5 = var10003 - 1;
      char[] var1 = var10004;
      int var4 = var10002;
      byte var10001 = 118;
      int var10000 = var12;

      for (byte var2 = 49; var10000 >= 0; var10000 = var5) {
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

   public double getDouble() {
      return this.double_;
   }
}
