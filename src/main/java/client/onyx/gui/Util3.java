package client.onyx.gui;

public final class Util3 {
   private static final client.onyx.render.misc.Cls CLS = new client.onyx.render.misc.Cls(1.0F);
   private static long long_;

   public static void handleBool(boolean var0) {
      long var1 = System.nanoTime();
      float var4 = long_ == 0L ? 16.0F : Math.min((float)(var1 - long_) / 1000000.0F, 100.0F);
      long_ = var1;
      float var5 = var0 ? 1.0F : 0.0F;
      if (CLS.getFloat2() != var5) {
         CLS.getCls2(var5, 300.0F, client.onyx.render.misc.Util.IFACE2);
      }

      CLS.handleFloat(var4);
   }

   public static float getFloat() {
      return CLS.getFloat();
   }

   private Util3() {
   }
}
