package client.onyx.render.guide;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class Util {
   private static final Map<String, float[]> MAP = new LinkedHashMap<>();

   public static void handleString(String var0) {
      MAP.remove(var0);
   }

   private Util() {
   }

   public static List<float[]> getListForString(String var0) {
      ArrayList var1 = new ArrayList(MAP.size());
      Iterator var4 = MAP.entrySet().iterator();

      while (var4.hasNext()) {
         Entry var3;
         if (!((String)(var3 = (Entry)var4.next()).getKey()).equals(var0)) {
            var1.add((float[])var3.getValue());
         }
      }

      return var1;
   }

   public static void handleString2(String var0, float var1, float var2, float var3, float var4) {
      Map var5 = MAP;
      float[] var6 = new float[]{var1, var2, var3, var4};
      Object var7 = var5.put(var0, var6);
   }
}
