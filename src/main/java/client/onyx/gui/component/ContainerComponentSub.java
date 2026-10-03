package client.onyx.gui.component;

import client.onyx.gui.ContainerComponent;
import client.onyx.module.Module;
import client.onyx.theme.Util2;
import java.util.ArrayList;

public class ContainerComponentSub extends ContainerComponent {
   private static final float FLOAT = 460.0F;
   private final Cls2 cls22;
   private Module module;

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      if (this.module != null) {
         if (this.cls22.isEnabled()) {
            var1.sampler0
               .handleOpticalWeightRecord4(
                  Util2.OPTICAL_WEIGHT_RECORD15,
                  "This module has no settings",
                  this.float_3 + this.float_4 / 2.0F,
                  this.float_ + this.float_2 / 2.0F,
                  var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()
               );
         } else {
            super.handleCls27(var1);
         }
      }
   }

   public Module getModule4() {
      return this.module;
   }

   private float getFloat175() {
      return Math.min(this.float_4 - 12.0F, 460.0F);
   }

   public void handleModule2(Module var1) {
      if (this.module != var1) {
         this.module = var1;
         this.list.clear();
         this.cls22.run();
         this.float_5 = 0.0F;
         this.cls.getCls(0.0F);
         if (var1 != null) {
            ArrayList var2;
            (var2 = new ArrayList()).add(var1.getNoneValueSetting2());
            var2.addAll(var1.getList11());
            this.cls22.handleList(var2);
            this.list.addAll(this.cls22.getList());
         }
      }
   }

   @Override
   protected void handleCls29(client.onyx.gui.Cls2 var1) {
      this.cls22.handleSampler0(var1.sampler0, this.getFloat174(), this.getFloat175(), var1.getPrimaryOnPrimaryRecord().outlineVariant(), 1.0F);
   }

   private float getFloat174() {
      float var1 = this.float_3;
      float var2 = this.float_4;
      float var3 = this.getFloat175();
      float var5 = (var2 - var3) / 2.0F;
      return var1 + var5;
   }

   @Override
   protected void handleCls212(client.onyx.gui.Cls2 var1) {
      Cls2 var2 = this.cls22;
      float var3 = this.getFloat174();
      float var4 = this.float_;
      float var5 = this.cls.getFloat();
      float var6 = var4 - var5;
      float var7 = this.getFloat175();
      float var8 = var2.getFloat(var3, var6, var7);
      this.float_6 = var8;
   }

   public ContainerComponentSub() {
      Cls2 var1 = new Cls2();
      this.cls22 = var1;
   }
}
