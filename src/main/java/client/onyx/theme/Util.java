package client.onyx.theme;

public final class Util {
   public static final float FLOAT = 50.0F;
   public static final float FLOAT2 = 350.0F;
   public static final float FLOAT3 = 450.0F;
   public static final float FLOAT4 = 400.0F;
   public static final float FLOAT5 = 700.0F;
   public static final float FLOAT6 = 200.0F;
   public static final float FLOAT7 = 550.0F;
   public static final float FLOAT8 = 300.0F;
   public static final float FLOAT9 = 800.0F;
   public static final float FLOAT10 = 1000.0F;
   public static final float FLOAT11 = 500.0F;
   public static final float FLOAT12 = 600.0F;
   public static final float FLOAT13 = 900.0F;
   public static final float FLOAT14 = 150.0F;
   public static final float FLOAT15 = 250.0F;
   public static final float FLOAT16 = 100.0F;

   private Util() {
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
      byte var12 = 109;
      int var10000 = var10002;

      for (byte var2 = 32; var10000 >= 0; var10000 = var5) {
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
}
