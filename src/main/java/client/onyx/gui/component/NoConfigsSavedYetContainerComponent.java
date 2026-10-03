package client.onyx.gui.component;

import client.onyx.OnyxClient;
import client.onyx.gui.ContainerComponent;
import client.onyx.gui.GuiComponent;
import client.onyx.theme.Util2;
import java.util.Iterator;
import java.util.function.Consumer;

public class NoConfigsSavedYetContainerComponent extends ContainerComponent {
   private static final float FLOAT = 9.0F;
   private final Consumer<LoadGuiComponent> consumer;
   private static final float FLOAT2 = 5.0F;
   private final Consumer<LoadGuiComponent> consumer2;
   private final Consumer<LoadGuiComponent> consumer3;

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      return this.isFloat15(var1, var2) && super.isFloat17(var1, var2, var3);
   }

   public NoConfigsSavedYetContainerComponent(Consumer<LoadGuiComponent> var1, Consumer<LoadGuiComponent> var2, Consumer<LoadGuiComponent> var3) {
      this.consumer2 = var1;
      this.consumer = var2;
      this.consumer3 = var3;
      this.run201();
   }

   public LoadGuiComponent getLoadGuiComponent() {
      GuiComponent var3 = this.getGuiComponent();
      return var3 instanceof LoadGuiComponent ? (LoadGuiComponent)var3 : null;
   }

   @Override
   protected void handleCls212(client.onyx.gui.Cls2 var1) {
      float var3 = this.float_ - this.cls.getFloat();

      Iterator var2;
      for (Iterator var10000 = var2 = this.list.iterator(); var10000.hasNext(); var10000 = var2) {
         ((GuiComponent)var2.next()).handleFloat80(this.float_3, var3, this.float_4 - 9.0F, 50.0F);
         var3 += 55.0F;
      }

      this.float_6 = this.list.isEmpty() ? 0.0F : this.list.size() * 55.0F - 5.0F;
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      if (this.list.isEmpty()) {
         var1.sampler0
            .handleOpticalWeightRecord4(
               Util2.getOpticalWeightRecord3(),
               "No configs saved yet",
               this.float_3 + this.float_4 / 2.0F,
               this.float_ + this.float_2 / 2.0F,
               var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()
            );
      } else {
         super.handleCls27(var1);
      }
   }

   public void run201() {
      this.list.clear();
      this.run187();
      this.float_5 = 0.0F;
      this.cls.getCls(0.0F);
      Iterator var3 = OnyxClient.configManager.getList31().iterator();
      Iterator var10000 = var3;

      while (var10000.hasNext()) {
         String var2 = (String)var3.next();
         var10000 = var3;
         this.list.add(new LoadGuiComponent(var2, this.consumer2, this.consumer, this.consumer3));
      }
   }

   public int getInt68() {
      return this.list.size();
   }
}
