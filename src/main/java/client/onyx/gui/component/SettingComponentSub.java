package client.onyx.gui.component;

import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.render.misc.Util;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.ArrayList;
import java.util.List;

public class SettingComponentSub<E extends Enum<E>> extends SettingComponent {
   private final List<float[]> list2;
   private float float_5;
   private static final float FLOAT5 = 9.0F;
   private final List<client.onyx.render.misc.Cls> list3;
   private final ValueSettingSub<E> valueSettingSub;
   private static final float FLOAT6 = 5.0F;
   private boolean bool6;
   private static final float FLOAT7 = 12.0F;
   private static final float FLOAT8 = 23.0F;

   public SettingComponentSub(ValueSettingSub<E> var1) {
      super(var1);
      int var10000 = 0;
      this.list3 = new ArrayList();
      this.list2 = new ArrayList();
      this.float_5 = 50.0F;
      this.valueSettingSub = var1;

      for(int var2 = 0; var10000 < var1.getList6().size(); var10000 = var2) {
         this.list3.add(new client.onyx.render.misc.Cls(0.0F));
         float[] var10002 = new float[3];
         boolean var10004 = true;
         var10002[0] = 0.0F;
         var10002[1] = 0.0F;
         ++var2;
         var10002[2] = 0.0F;
         this.list2.add(var10002);
      }

   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.isEnabled163() && var3 == 0) {
         for(int var10000 = var3 = 0; var10000 < this.list2.size(); var10000 = var3) {
            float[] var5 = (float[])this.list2.get(var3);
            if (var1 >= var5[0] && var1 < var5[0] + var5[2] && var2 >= var5[1] && var2 < var5[1] + 23.0F) {
               ValueSettingSub var6 = this.valueSettingSub;
               Enum var9 = (Enum)this.valueSettingSub.getList6().get(var3);
               var6.handleEnum(var9);
               return true;
            }

            ++var3;
         }

         return false;
      } else {
         return false;
      }
   }

   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      return this.float_5;
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      float var6 = this.float_3;
      float var5 = this.getFloat187();
      float var4 = 23.0F;

      int var8;
      for(int var10000 = var8 = 0; var10000 < this.valueSettingSub.getList6().size(); var10000 = var8) {
         ValueSettingSub var9 = this.valueSettingSub;
         Enum var12 = (Enum)this.valueSettingSub.getList6().get(var8);
         boolean var2 = var9.isEnum(var12);
         client.onyx.render.misc.Cls var7 = (client.onyx.render.misc.Cls)this.list3.get(var8);
         client.onyx.render.misc.Cls var18;
         if (!this.bool6) {
            var7.getCls(var2 ? 1.0F : 0.0F);
            var18 = var7;
         } else {
            if (var7.getFloat2() != (var2 ? 1.0F : 0.0F)) {
               var7.getCls2(var2 ? 1.0F : 0.0F, 250.0F, Util.IFACE2);
            }

            var18 = var7;
         }

         var18.handleFloat(var1.float_);
         float var17 = this.getFloat133(var1, var8, var7.getFloat());
         if (var6 > this.float_3) {
            float var15 = this.float_3 + this.float_4;
            if (var6 + var17 > var15) {
               var6 = this.float_3;
               var5 += var4 + 5.0F;
            }
         }

         ((float[])this.list2.get(var8))[0] = var6;
         ((float[])this.list2.get(var8))[1] = var5;
         ((float[])this.list2.get(var8))[2] = var17;
         ++var8;
         var6 += var17 + 5.0F;
      }

      this.bool6 = true;
      this.float_5 = var5 + var4 + 6.0F - this.float_;
   }

   private float getFloat133(client.onyx.gui.Cls2 var1, int var2, float var3) {
      String var5 = ValueSettingSub11.getStringForEnum((Enum)this.valueSettingSub.getList6().get(var2));
      float var4 = var1.sampler0.getFloat17(Util2.OPTICAL_WEIGHT_RECORD16, var5);
      return 18.0F + var4 + 16.0F * var3;
   }

   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      Sampler0 var10 = var1.sampler0;
      int var10000 = 0;
      this.handleCls225(var1, this.float_4);

      for(int var5 = 0; var10000 < this.valueSettingSub.getList6().size(); var10000 = var5) {
         float[] var9 = (float[])this.list2.get(var5);
         float var3 = ((client.onyx.render.misc.Cls)this.list3.get(var5)).getFloat();
         float var12 = var9[0];
         float var6 = var9[1];
         float var7 = var9[2];
         boolean var8 = var1.float_3 >= var12 && var1.float_3 < var12 + var7 && var1.float_2 >= var6 && var1.float_2 < var6 + 23.0F;
         if (var3 > 0.01F) {
            var10.handleFloat7(var12, var6, var7, 23.0F, 8.0F, this.getInt72(Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().secondaryContainer(), var3)));
         }

         if (var3 < 0.99F) {
            var10.handleFloat18(var12, var6, var7, 23.0F, 8.0F, 1.0F, this.getInt72(Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().outline(), 1.0F - var3)));
         }

         if (var8) {
            var10.handleFloat7(var12, var6, var7, 23.0F, 8.0F, this.getInt72(Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurface(), 0.08F)));
         }

         var7 = var12 + 9.0F + 16.0F * var3;
         int var11 = var3 > 0.5F ? var1.getPrimaryOnPrimaryRecord().onSecondaryContainer() : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant();
         if (var3 > 0.05F) {
            client.onyx.gui.Util.handleSampler06(var10, var12 + 9.0F + 6.0F, var6 + 11.5F, 12.0F * (0.7F + 0.3F * var3), this.getInt72(Util4.getIntForInt2(var11, var3)));
         }

         OpticalWeightRecord var13 = Util2.OPTICAL_WEIGHT_RECORD16;
         String var14 = ValueSettingSub11.getStringForEnum((Enum)this.valueSettingSub.getList6().get(var5));
         float var10004 = var6 + 11.5F;
         ++var5;
         var10.handleOpticalWeightRecord9(var13, var14, var7, var10004, this.getInt72(var11));
      }

   }
}
