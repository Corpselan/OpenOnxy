package client.onyx.gui.component;

import client.onyx.gui.GuiComponent;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.BooleanSettingSub;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public final class SettingComponentSub2 extends SettingComponent {
   private static final float FLOAT5 = 8.0F;
   private final GuiComponentSub9 guiComponentSub9;
   private Cls2 cls22;
   private float float_5;
   private final List<Cls2> list2 = new ArrayList();
   private static final float FLOAT6 = 13.0F;

   public SettingComponentSub2(BooleanSettingSub var1) {
      super(var1);
      Stream var10000 = var1.getList2().stream();
      Objects.requireNonNull(BooleanSetting.class);
      var10000 = var10000.filter(BooleanSetting.class::isInstance);
      Objects.requireNonNull(BooleanSetting.class);
      List var2 = var10000.map(BooleanSetting.class::cast).toList();
      List var6;
      if ((var6 = var1.getList5()).size() != var2.size()) {
         throw new IllegalArgumentException("Tabbed setting labels must match child groups");
      } else {
         Iterator var7;
         for(Iterator var9 = var7 = var2.iterator(); var9.hasNext(); var9 = var7) {
            BooleanSetting var5 = (BooleanSetting)var7.next();
            ArrayList var4 = new ArrayList();
            if (var5.getValueSettingSub9() != null) {
               var4.add(var5.getValueSettingSub9());
            }

            var4.addAll(var5.getList2());
            Cls2 var8 = new Cls2();
            var8.handleList(var4);
            this.list2.add(var8);
         }

         this.guiComponentSub9 = new GuiComponentSub9((String[])var6.toArray((var0) -> {
            return new String[var0];
         }), this::lambda266);
         this.list.add(this.guiComponentSub9);
         if (!this.list2.isEmpty()) {
            this.lambda266(0);
         }

      }
   }

   protected float getFloat182(client.onyx.gui.Cls2 var1) {
      return this.list2.isEmpty() ? this.getFloat178() : this.getFloat141() - this.float_ + this.float_5 + (this.float_5 > 0.5F ? 6.0F : 0.0F);
   }

   protected void handleCls226(client.onyx.gui.Cls2 var1, float var2) {
      this.handleCls225(var1, this.float_4);
      if (this.cls22 != null && this.float_5 > 0.5F) {
         var1.sampler0.handleFloat28(this.float_3 + 3.0F, this.getFloat141(), 1.0F, this.float_5, Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().outlineVariant(), var2 * 0.7F));
         this.cls22.handleSampler0(var1.sampler0, this.getFloat138(), this.getFloat139(), var1.getPrimaryOnPrimaryRecord().outlineVariant(), var2);
      }

      Iterator var3;
      for(Iterator var10000 = var3 = this.list.iterator(); var10000.hasNext(); var10000 = var3) {
         ((GuiComponent)var3.next()).handleCls27(var1);
      }

   }

   protected OpticalWeightRecord getOpticalWeightRecord3() {
      return Util2.OPTICAL_WEIGHT_RECORD18;
   }

   private float getFloat139() {
      return Math.max(0.0F, this.float_4 - 13.0F);
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      this.guiComponentSub9.handleFloat80(this.getFloat138(), this.getFloat140(), this.getFloat139(), 30.0F);
      this.float_5 = this.cls22 == null ? 0.0F : this.cls22.getFloat(this.getFloat138(), this.getFloat141(), this.getFloat139());
      super.handleCls28(var1);
   }

   private float getFloat140() {
      return this.float_ + this.getFloat178();
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (!this.isEnabled163()) {
         return false;
      } else if (this.guiComponentSub9.isFloat17(var1, var2, var3)) {
         return true;
      } else {
         if (this.cls22 != null) {
            Iterator var5 = this.cls22.getList().iterator();

            while(var5.hasNext()) {
               if (((SettingComponent)var5.next()).isFloat17(var1, var2, var3)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   private float getFloat141() {
      return this.getFloat140() + 30.0F + 8.0F;
   }

   private void lambda266(int var1) {
      if (var1 >= 0 && var1 < this.list2.size()) {
         if (this.cls22 != null) {
            List var2 = this.list;
            List var3 = this.cls22.getList();
            var2.removeAll(var3);
         }

         Cls2 var7 = (Cls2)this.list2.get(var1);
         this.cls22 = var7;
         List var8 = this.list;
         List var9 = this.cls22.getList();
         var8.addAll(var9);
      }
   }

   private float getFloat138() {
      return this.float_3 + 13.0F;
   }
}
