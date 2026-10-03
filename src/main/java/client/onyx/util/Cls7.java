package client.onyx.util;

public class Cls7 {
   private long long_;

   public void handleLong2(long var1) {
      this.long_ = var1;
   }

   public long getLong() {
      return System.currentTimeMillis() - this.long_;
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 110;
      byte var10001 = 41;
      int var10000 = var10002;

      for (byte var2 = 106; var10000 >= 0; var10000 = var5) {
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

   public void handleLong(long var1) {
      this.long_ = Math.max(this.long_, System.currentTimeMillis() + var1);
   }

   public void run() {
      this.handleLong2(System.currentTimeMillis());
   }

   public boolean isLong2(long var1) {
      return this.long_ + var1 <= System.currentTimeMillis();
   }

   public boolean isLong(long var1) {
      return this.long_ + var1 < System.currentTimeMillis();
   }

   public long getLong2(long var1) {
      return var1 - this.long_;
   }

   public Cls7() {
      this(0L);
   }

   public Cls7(long var1) {
      this.long_ = var1;
   }

   public boolean isEnabled() {
      return this.isLong(0L);
   }
}
