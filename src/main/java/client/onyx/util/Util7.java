package client.onyx.util;

public class Util7 {
   public static boolean isForwardBackwardRecord(ForwardBackwardRecord var0) {
      return var0.forward() || var0.backward() || var0.left() || var0.right();
   }

   public static ForwardBackwardRecord getForwardBackwardRecordForForwardBackwardRecord(
      ForwardBackwardRecord var0, boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7
   ) {
      return new ForwardBackwardRecord(var1, var2, var3, var4, var5, var6, var7);
   }

   public static boolean isForwardsBackwardsRecord(ForwardsBackwardsRecord var0) {
      return var0.forwards() || var0.backwards() || var0.left() || var0.right();
   }
}
