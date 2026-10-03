package client.onyx.gui.component;

import client.onyx.OnyxClient;
import client.onyx.gui.ContainerComponent;
import client.onyx.gui.GuiComponent;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.theme.Util2;
import java.util.Locale;
import java.util.function.Consumer;

public class NoModulesMatchContainerComponent extends ContainerComponent {
   private String string = "";
   private final Consumer<Module> consumer;
   private ModuleCategory moduleCategory;

   public void handleString19(String var1) {
      if (!(var1 = var1.trim().toLowerCase(Locale.ROOT)).equals(this.string)) {
         this.string = var1;
         this.run190();
      }
   }

   public NoModulesMatchContainerComponent(ModuleCategory var1, Consumer<Module> var2) {
      this.consumer = var2;
      this.moduleCategory = var1;
      this.run190();
   }

   private static float getFloat130() {
      return 5.0F;
   }

   public ModuleCategory getModuleCategory2() {
      return this.moduleCategory;
   }

   public int getInt60() {
      return this.list.size();
   }

   public void handleModuleCategory(ModuleCategory var1) {
      if (this.moduleCategory != var1) {
         this.moduleCategory = var1;
         this.run190();
      }
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      if (this.list.isEmpty()) {
         Sampler0 var10000 = var1.sampler0;
         OpticalWeightRecord var10001 = Util2.getOpticalWeightRecord3();
         String var10002;
         NoModulesMatchContainerComponent var10003;
         if (this.isEnabled150()) {
            var10002 = "No modules match";
            var10003 = this;
         } else {
            var10002 = "No modules here yet";
            var10003 = this;
         }

         var10000.handleOpticalWeightRecord4(
            var10001, var10002, var10003.float_3 + this.float_4 / 2.0F, this.float_ + this.float_2 / 2.0F, var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()
         );
      } else {
         super.handleCls27(var1);
      }
   }

   private static int getInt59() {
      return 1;
   }

   @Override
   protected int getInt57() {
      return getInt59();
   }

   @Override
   protected void handleCls212(client.onyx.gui.Cls2 var1) {
      float var8 = GuiComponentSub.getFloat131();
      float var6 = getFloat130();
      int var7 = getInt59();
      float var4 = (this.float_4 - 9.0F - var6 * (var7 - 1)) / var7;
      float var5 = this.float_ - this.cls.getFloat();

      int var2;
      for (int var10000 = var2 = 0; var10000 < this.list.size(); var10000 = var2) {
         GuiComponent var10 = this.list.get(var2);
         float var10001 = this.float_3 + var2 % var7 * (var4 + var6);
         float var10002 = var5 + var2 / var7 * (var8 + var6);
         var2++;
         var10.handleFloat80(var10001, var10002, var4, var8);
      }

      this.float_6 = (var2 = (this.list.size() + var7 - 1) / var7) == 0 ? 0.0F : var2 * (var8 + var6) - var6;
   }

   public boolean isEnabled150() {
      return !this.string.isEmpty();
   }

   public Module getModule2() {
      GuiComponent var3 = this.getGuiComponent();
      return var3 instanceof GuiComponentSub ? ((GuiComponentSub)var3).getModule3() : null;
   }

   private boolean isModule(Module var1) {
      return var1.getString20().toLowerCase(Locale.ROOT).contains(this.string)
         || var1.getString18().toLowerCase(Locale.ROOT).contains(this.string)
         || var1.getModuleCategory().getString2().toLowerCase(Locale.ROOT).contains(this.string);
   }

   private void run190() {
      this.list.clear();
      this.run187();
      this.float_5 = 0.0F;
      this.cls.getCls(0.0F);

      for (Module var4 : OnyxClient.cls.getArrayList()) {
         boolean var3 = this.isEnabled150() ? this.isModule(var4) : var4.getModuleCategory() == this.moduleCategory;
         if (var3) {
            this.list.add(new GuiComponentSub(var4, this.consumer));
         }
      }
   }
}
