package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.render.misc.Util;
import client.onyx.theme.Util2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuiComponentSub2 extends GuiComponent {
   private float float_5;
   private static final float FLOAT = 12.0F;
   private static final float FLOAT2 = 34.0F;
   private final client.onyx.render.misc.Cls cls;
   private boolean bool4;
   private static final float FLOAT3 = 16.0F;
   private static final float FLOAT4 = 13.0F;
   private static final int INT = 4;
   private String string;
   private static final float FLOAT5 = 10.0F;
   private static final float FLOAT6 = 10.0F;
   private static final float FLOAT7 = 16.0F;
   private String string2;
   private static final int INT2 = 3;
   private static final float FLOAT8 = 380.0F;

   public void handleString21(String var1, String var2) {
      this.handleString22(var1, var2, true);
   }

   private boolean isEnabled151() {
      return this.string2 != null && (this.cls.getFloat() > 0.001F || this.cls.getFloat2() > 0.0F);
   }

   public void run193() {
      this.float_5 = 0.0F;
      this.cls.getCls2(0.0F, 200.0F, Util.IFACE6);
   }

   public void handleString20(String var1) {
      this.handleString22(var1, (String)null, false);
   }

   public void handleCls27(client.onyx.gui.Cls2 var1) {
      if (this.isEnabled151()) {
         Sampler0 var2 = var1.sampler0;
         float var6 = this.cls.getFloat();
         int var11 = this.bool4 ? var1.getPrimaryOnPrimaryRecord().errorContainer() : var1.getPrimaryOnPrimaryRecord().inverseSurface();
         int var12 = this.bool4 ? var1.getPrimaryOnPrimaryRecord().onErrorContainer() : var1.getPrimaryOnPrimaryRecord().inverseOnSurface();
         float var5 = this.string == null ? 0.0F : 26.0F;
         float var3 = Math.min(380.0F, this.float_4) - 32.0F - var5;
         List var13 = this.getList28(var2, var3);
         float var7 = 0.0F;

         Iterator var8;
         Iterator var10000;
         for(var10000 = var8 = var13.iterator(); var10000.hasNext(); var10000 = var8) {
            String var9 = (String)var8.next();
            var7 = Math.max(var7, var2.getFloat17(Util2.OPTICAL_WEIGHT_RECORD15, var9));
         }

         float var16 = 32.0F + var5 + var7;
         float var17 = Math.max(34.0F, 21.0F + (float)var13.size() * 13.0F);
         var7 = this.float_3 + (this.float_4 - var16) / 2.0F;
         float var10 = this.float_ + this.float_2 - 12.0F - var17 + 10.0F * (1.0F - var6);
         var2.run35();
         var2.handleFloat10(var6);
         var2.handleFloat25(var7, var10, var16, var17, 4.0F, 3);
         var2.handleFloat7(var7, var10, var16, var17, 4.0F, var11);
         var6 = var7 + 16.0F;
         float var18 = var10 + var17 / 2.0F;
         if (this.string != null) {
            var2.handleString6(this.string, var6 + 8.0F, var18, 16.0F, var12);
            var6 += var5;
         }

         var18 -= (float)(var13.size() - 1) * 13.0F / 2.0F;

         Iterator var15;
         for(var10000 = var15 = var13.iterator(); var10000.hasNext(); var18 += 13.0F) {
            String var14 = (String)var15.next();
            var10000 = var15;
            var2.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD15, var14, var6, var18, var12);
         }

         var2.run40();
      }
   }

   private List<String> getList28(Sampler0 var1, float var2) {
      ArrayList var4 = new ArrayList();
      StringBuilder var10 = new StringBuilder();
      String[] var5;
      int var6 = (var5 = this.string2.split(" ")).length;
      int var7;
      int var10000 = var7 = 0;

      ArrayList var12;
      while(true) {
         if (var10000 >= var6) {
            var12 = var4;
            break;
         }

         String var8;
         if (!(var8 = var5[var7]).isEmpty()) {
            String var9 = var10.isEmpty() ? var8 : var10 + KeyScancodeRecord.decrypt("i") + var8;
            if (!(var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD15, var9) <= var2) && !var10.isEmpty()) {
               var4.add(var10.toString());
               var10.setLength(0);
               var10.append(var8);
               if (var4.size() == 4) {
                  var12 = var4;
                  break;
               }
            } else {
               var10.setLength(0);
               var10.append(var9);
            }
         }

         ++var7;
         var10000 = var7;
      }

      if (var12.size() < 4 && !var10.isEmpty()) {
         var4.add(var10.toString());
      }

      int var11;
      for(var10000 = var11 = 0; var10000 < var4.size(); var10000 = var11) {
         int var10001 = var11;
         OpticalWeightRecord var10003 = Util2.OPTICAL_WEIGHT_RECORD15;
         String var10004 = (String)var4.get(var11);
         ++var11;
         var4.set(var10001, var1.getString17(var10003, var10004, var2));
      }

      return var4;
   }

   public GuiComponentSub2() {
      client.onyx.render.misc.Cls var1 = new client.onyx.render.misc.Cls(0.0F);
      this.cls = var1;
   }

   public void handleString22(String var1, String var2, boolean var3) {
      this.string2 = var1;
      this.string = var2;
      this.bool4 = var3;
      this.float_5 = 800.0F * (var3 ? 2.0F : 1.0F);
      this.cls.getCls2(1.0F, 300.0F, Util.IFACE7);
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      if (this.string2 != null) {
         if (this.float_5 > 0.0F) {
            this.float_5 -= var1.float_;
            if (this.float_5 <= 0.0F) {
               this.run193();
            }
         }

         this.cls.handleFloat(var1.float_);
         if (this.cls.getFloat2() == 0.0F && this.cls.isEnabled()) {
            this.string2 = null;
         }

      }
   }
}
