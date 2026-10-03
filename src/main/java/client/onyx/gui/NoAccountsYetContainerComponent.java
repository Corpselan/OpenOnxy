package client.onyx.gui;

import client.onyx.OnyxClient;
import client.onyx.account.Abstract_;
import client.onyx.gui.component.ExpiredGuiComponent;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class NoAccountsYetContainerComponent extends ContainerComponent {
   private final Consumer<ExpiredGuiComponent> consumer;
   private static final float FLOAT = 5.0F;
   private static final float FLOAT2 = 9.0F;
   private final Consumer<ExpiredGuiComponent> consumer2;

   public NoAccountsYetContainerComponent(Consumer<ExpiredGuiComponent> var1, Consumer<ExpiredGuiComponent> var2) {
      this.consumer = var1;
      this.consumer2 = var2;
      this.run186();
   }

   public void run186() {
      this.list.clear();
      this.float_5 = 0.0F;
      this.cls.getCls(0.0F);
      List var1;
      int var3 = (var1 = OnyxClient.accountManager.getList25()).size() - 1;

      for (int var10000 = var3; var10000 >= 0; var10000 = var3) {
         List var4 = this.list;
         Abstract_ var10003 = (Abstract_)var1.get(var3);
         var3--;
         var4.add(new ExpiredGuiComponent(var10003, this.consumer, this.consumer2));
      }
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      return this.isFloat15(var1, var2) && super.isFloat17(var1, var2, var3);
   }

   @Override
   public void handleCls27(Cls2 var1) {
      if (this.list.isEmpty()) {
         var1.sampler0
            .handleOpticalWeightRecord4(
               client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD15,
               "No accounts yet",
               this.float_3 + this.float_4 / 2.0F,
               this.float_ + this.float_2 / 2.0F,
               var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()
            );
      } else {
         super.handleCls27(var1);
      }
   }

   @Override
   protected void handleCls212(Cls2 var1) {
      float var3 = this.float_ - this.cls.getFloat();

      Iterator var2;
      for (Iterator var10000 = var2 = this.list.iterator(); var10000.hasNext(); var10000 = var2) {
         ((GuiComponent)var2.next()).handleFloat80(this.float_3, var3, this.float_4 - 9.0F, 56.0F);
         var3 += 61.0F;
      }

      this.float_6 = this.list.isEmpty() ? 0.0F : this.list.size() * 61.0F - 5.0F;
   }
}
