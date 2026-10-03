package client.onyx.gui.component;

import client.onyx.gui.Util;
import client.onyx.render.Sampler0;
import client.onyx.setting.impl.ValueSettingSub2;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.block.Block;

public class SearchBlocksSettingComponent extends SettingComponent {
   private final GuiComponentSub8 guiComponentSub8 = new GuiComponentSub8("Search blocks");
   private static final int INT = 6;
   private final List<Block> list2 = new ArrayList();
   private float float_5;
   private final List<Block> list4 = new ArrayList();
   private final List<float[]> list3 = new ArrayList();
   private static final float FLOAT5 = 22.0F;
   private static final float FLOAT6 = 9.0F;
   private String string = "";
   private static final float FLOAT7 = 10.0F;
   private float float_6 = 60.0F;
   private static final float FLOAT8 = 6.0F;
   private int int_ = -1;
   private int int_2 = -1;
   private static final float FLOAT9 = 5.0F;
   private final ValueSettingSub2 valueSettingSub2;
   private static final float FLOAT10 = 22.0F;

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      int var10000 = 0;
      this.guiComponentSub8.handleFloat80(this.float_3, this.getFloat187(), this.float_4, 40.0F);
      this.float_5 = this.getFloat187() + 40.0F + 6.0F;
      this.int_ = -1;

      float var3;
      for(int var6 = 0; var10000 < this.list2.size(); var10000 = var6) {
         var3 = this.float_5 + (float)var6 * 22.0F;
         if (var1.float_3 >= this.float_3) {
            float var7 = var1.float_3;
            float var9 = this.float_3 + this.float_4;
            if (var7 < var9 && var1.float_2 >= var3 && var1.float_2 < var3 + 22.0F) {
               this.int_ = var6;
            }
         }

         ++var6;
      }

      this.list4.clear();
      this.list4.addAll((Collection)this.valueSettingSub2.lambda15());
      this.list3.clear();
      float var22 = this.float_3;
      var3 = this.float_5 + (float)this.list2.size() * 22.0F + (this.list2.isEmpty() ? 0.0F : 6.0F);
      var10000 = 0;
      this.int_2 = -1;

      for(int var4 = 0; var10000 < this.list4.size(); var10000 = var4) {
         Block var13 = (Block)this.list4.get(var4);
         float var5 = Math.min(this.getFloat195(var1, var13), this.float_4);
         if (var22 > this.float_3) {
            float var17 = this.float_3 + this.float_4;
            if (var22 + var5 > var17) {
               var22 = this.float_3;
               var3 += 27.0F;
            }
         }

         List var19 = this.list3;
         float[] var20 = new float[]{var22, var3, var5};
         var19.add(var20);
         if (var1.float_3 >= var22 && var1.float_3 < var22 + var5 && var1.float_2 >= var3 && var1.float_2 < var3 + 22.0F) {
            this.int_2 = var4;
         }

         ++var4;
         var22 += var5 + 5.0F;
      }

      this.float_6 = (this.list4.isEmpty() ? var3 : var3 + 22.0F) + 6.0F - this.float_;
      super.handleCls28(var1);
   }

   public SearchBlocksSettingComponent(ValueSettingSub2 var1) {
      super(var1);
      this.valueSettingSub2 = var1;
      this.guiComponentSub8.handleConsumer4((var1x) -> {
         this.string = var1x == null ? "" : var1x.trim().toLowerCase(Locale.ROOT);
         this.list2.clear();
         if (!this.string.isEmpty()) {
            Iterator var3 = Block.blockRegistry.iterator();

            label34:
            do {
               for(Iterator var10000 = var3; var10000.hasNext(); var10000 = var3) {
                  Block var2;
                  if (ValueSettingSub2.lambda14(var2 = (Block)var3.next()).contains(this.string) || var2.getLocalizedName().toLowerCase(Locale.ROOT).contains(this.string)) {
                     this.list2.add(var2);
                     continue label34;
                  }
               }

               return;
            } while(this.list2.size() < 6);

         }
      });
      boolean var3 = this.list.add(this.guiComponentSub8);
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.isEnabled163() && var3 == 0) {
         if (this.guiComponentSub8.isFloat17(var1, var2, var3)) {
            return true;
         } else if (this.int_ >= 0) {
            ValueSettingSub2 var4 = this.valueSettingSub2;
            Block var6 = (Block)this.list2.get(this.int_);
            var4.handleBlock(var6);
            return true;
         } else if (this.int_2 >= 0) {
            ValueSettingSub2 var7 = this.valueSettingSub2;
            Block var9 = (Block)this.list4.get(this.int_2);
            var7.handleBlock3(var9);
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      return this.float_6;
   }

   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      Sampler0 var18 = var1.sampler0;
      String var11 = this.list4.size() + " selected";
      float var4 = var18.getFloat17(Util2.OPTICAL_WEIGHT_RECORD2, var11);
      this.handleCls225(var1, this.float_4 - var4 - 12.0F);
      var18.handleOpticalWeightRecord6(Util2.OPTICAL_WEIGHT_RECORD2, var11, this.float_3 + this.float_4, this.getFloat181(), this.getInt72(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()));
      this.guiComponentSub8.handleCls27(var1);

      float var5;
      int var10000;
      int var22;
      for(var10000 = var22 = 0; var10000 < this.list2.size(); var10000 = var22) {
         Block var19 = (Block)this.list2.get(var22);
         var5 = this.float_5 + (float)var22 * 22.0F;
         boolean var6 = this.valueSettingSub2.isBlock2(var19);
         if (this.int_ == var22) {
            var18.handleFloat7(this.float_3, var5, this.float_4, 22.0F, 4.0F, this.getInt72(Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurface(), 0.08F)));
         }

         var18.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD15, var18.getString17(Util2.OPTICAL_WEIGHT_RECORD15, getStringForBlock2(var19), this.float_4 - 30.0F), this.float_3 + 8.0F, var5 + 11.0F, this.getInt72(var6 ? var1.getPrimaryOnPrimaryRecord().primary() : var1.getPrimaryOnPrimaryRecord().onSurface()));
         if (var6) {
            float var14 = this.float_3 + this.float_4 - 14.0F;
            int var16 = var1.getPrimaryOnPrimaryRecord().primary();
            int var17 = this.getInt72(var16);
            Util.handleSampler06(var18, var14, var5 + 11.0F, 12.0F, var17);
         }

         ++var22;
      }

      for(var10000 = var22 = 0; var10000 < this.list3.size(); var10000 = var22) {
         float[] var20 = (float[])this.list3.get(var22);
         var5 = var20[0];
         float var21 = var20[1];
         float var7 = var20[2];
         var18.handleFloat7(var5, var21, var7, 22.0F, 8.0F, this.getInt72(var1.getPrimaryOnPrimaryRecord().secondaryContainer()));
         if (this.int_2 == var22) {
            var18.handleFloat7(var5, var21, var7, 22.0F, 8.0F, this.getInt72(Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurface(), 0.08F)));
         }

         int var8 = var1.getPrimaryOnPrimaryRecord().onSecondaryContainer();
         float var9 = var7 - 18.0F - 10.0F - 5.0F;
         var18.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD16, var18.getString17(Util2.OPTICAL_WEIGHT_RECORD16, getStringForBlock2((Block)this.list4.get(var22)), var9), var5 + 9.0F, var21 + 11.0F, this.getInt72(var8));
         var7 = var5 + var7 - 9.0F - 5.0F;
         var9 = var21 + 11.0F;
         float var10 = 4.0F;
         var18.handleFloat9(var7 - var10, var9 - var10, var7 + var10, var9 + var10, 1.4F, this.getInt72(var8));
         float var10001 = var7 - var10;
         float var10002 = var9 + var10;
         float var10003 = var7 + var10;
         float var10004 = var9 - var10;
         ++var22;
         var18.handleFloat9(var10001, var10002, var10003, var10004, 1.4F, this.getInt72(var8));
      }

   }

   private float getFloat195(client.onyx.gui.Cls2 var1, Block var2) {
      return 18.0F + var1.sampler0.getFloat17(Util2.OPTICAL_WEIGHT_RECORD16, getStringForBlock2(var2)) + 10.0F + 5.0F;
   }

   private static String getStringForBlock2(Block var0) {
      return var0.getLocalizedName();
   }
}
