package client.onyx.gui;

import client.onyx.render.Sampler0;
import client.onyx.theme.Util4;

public final class Cls {
   private final client.onyx.render.misc.Cls cls;

   public Cls() {
      client.onyx.render.misc.Cls var1 = new client.onyx.render.misc.Cls(0.0F);
      this.cls = var1;
   }

   public void handleSampler0(Sampler0 var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      float var9;
      if (!((var9 = this.cls.getFloat()) <= 0.001F)) {
         var1.handleFloat7(var2, var3, var4, var5, var6, Util4.getIntForInt2(var7, var9));
      }
   }

   public void handleFloat(float var1, boolean var2, boolean var3) {
      float var5 = var3 ? 0.1F : (var2 ? 0.08F : 0.0F);
      if (this.cls.getFloat2() != var5) {
         this.cls.getCls2(var5, var3 ? 100.0F : 150.0F, client.onyx.render.misc.Util.IFACE6);
      }

      this.cls.handleFloat(var1);
   }
}
