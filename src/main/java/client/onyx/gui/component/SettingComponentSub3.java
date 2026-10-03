package client.onyx.gui.component;

import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.render.misc.Util;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import java.util.ArrayList;
import java.util.List;

public class SettingComponentSub3<E extends Enum<E>> extends SettingComponent {
   private static final float FLOAT5 = 24.0F;
   private static final float FLOAT6 = 8.0F;
   private final List<client.onyx.render.misc.Cls> list2;
   private final List<client.onyx.gui.Cls> list3;
   private int int_;
   private final ValueSettingSub11<E> valueSettingSub11;
   private boolean bool6;
   private static final float FLOAT7 = 1.5F;
   private static final float FLOAT8 = 4.0F;

   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      return this.getFloat158() - this.float_ + (float)this.valueSettingSub11.getList9().size() * 24.0F - 8.0F + 6.0F;
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      int var10000 = 0;
      super.handleCls28(var1);
      this.int_ = -1;

      for(int var6 = 0; var10000 < this.valueSettingSub11.getList9().size(); var10000 = var6) {
         boolean var5;
         boolean var11;
         label53: {
            var5 = this.valueSettingSub11.lambda15() == this.valueSettingSub11.getList9().get(var6);
            if (var1.float_3 >= this.float_3) {
               float var7 = var1.float_3;
               float var9 = this.float_3 + this.float_4;
               if (var7 < var9 && var1.float_2 >= this.getFloat159(var6) && var1.float_2 < this.getFloat159(var6) + 24.0F) {
                  var11 = true;
                  break label53;
               }
            }

            var11 = false;
         }

         boolean var4 = var11;
         if (var4) {
            this.int_ = var6;
         }

         client.onyx.render.misc.Cls var3 = (client.onyx.render.misc.Cls)this.list2.get(var6);
         client.onyx.render.misc.Cls var12;
         if (!this.bool6) {
            var3.getCls(var5 ? 1.0F : 0.0F);
            var12 = var3;
         } else {
            if (var3.getFloat2() != (var5 ? 1.0F : 0.0F)) {
               var3.getCls2(var5 ? 1.0F : 0.0F, 200.0F, Util.IFACE2);
            }

            var12 = var3;
         }

         var12.handleFloat(var1.float_);
         client.onyx.gui.Cls var13 = (client.onyx.gui.Cls)this.list3.get(var6);
         ++var6;
         var13.handleFloat(var1.float_, var4, false);
      }

      this.bool6 = true;
   }

   private float getFloat158() {
      return this.getFloat187() - 1.5F;
   }

   public SettingComponentSub3(ValueSettingSub11<E> var1) {
      super(var1);
      int var10000 = 0;
      this.list2 = new ArrayList();
      this.list3 = new ArrayList();
      this.int_ = -1;
      this.valueSettingSub11 = var1;

      for(int var2 = 0; var10000 < var1.getList9().size(); var10000 = var2) {
         this.list2.add(new client.onyx.render.misc.Cls(0.0F));
         ++var2;
         this.list3.add(new client.onyx.gui.Cls());
      }

   }

   private float getFloat159(int var1) {
      return this.getFloat158() - 4.0F + (float)var1 * 24.0F;
   }

   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      Sampler0 var9 = var1.sampler0;
      int var10000 = 0;
      this.handleCls225(var1, this.float_4);

      for(int var3 = 0; var10000 < this.valueSettingSub11.getList9().size(); var10000 = var3) {
         Enum var4 = (Enum)this.valueSettingSub11.getList9().get(var3);
         float var8;
         float var6 = (var8 = this.getFloat159(var3)) + 12.0F;
         boolean var7 = this.valueSettingSub11.lambda15() == var4;
         ((client.onyx.gui.Cls)this.list3.get(var3)).handleSampler0(var9, this.float_3 - 4.0F, var8, this.float_4 + 8.0F, 24.0F, 8.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurface()));
         int var10 = var7 ? var1.getPrimaryOnPrimaryRecord().primary() : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant();
         var9.handleFloat22(this.float_3 + 8.0F, var6, 8.0F, 1.5F, this.getInt72(var10));
         if ((var8 = ((client.onyx.render.misc.Cls)this.list2.get(var3)).getFloat()) > 0.01F) {
            var9.handleFloat23(this.float_3 + 8.0F, var6, 4.0F * var8, this.getInt72(var1.getPrimaryOnPrimaryRecord().primary()));
         }

         OpticalWeightRecord var10001 = Util2.OPTICAL_WEIGHT_RECORD15;
         String var10002 = ValueSettingSub11.getStringForEnum(var4);
         float var10003 = this.float_3 + 16.0F + 9.0F;
         PrimaryOnPrimaryRecord var10006 = var1.getPrimaryOnPrimaryRecord();
         ++var3;
         var9.handleOpticalWeightRecord9(var10001, var10002, var10003, var6, this.getInt72(var10006.onSurface()));
      }

   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.isEnabled163() && var3 == 0 && this.int_ >= 0) {
         ValueSettingSub11 var4 = this.valueSettingSub11;
         Enum var7 = (Enum)this.valueSettingSub11.getList9().get(this.int_);
         var4.handleObject2(var7);
         return true;
      } else {
         return false;
      }
   }
}
