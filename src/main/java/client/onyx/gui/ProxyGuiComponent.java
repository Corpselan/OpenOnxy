package client.onyx.gui;

import client.onyx.gui.component.AddressGuiComponent;
import client.onyx.gui.component.GuiComponentSub10;
import client.onyx.gui.component.GuiComponentSub2;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.theme.Util5;

public class ProxyGuiComponent extends GuiComponent {
   private static final float FLOAT = 12.0F;
   private final GuiComponentSub10 guiComponentSub10;
   private static final float FLOAT2 = 420.0F;
   private final AddressGuiComponent addressGuiComponent = new AddressGuiComponent();
   private static final float FLOAT3 = 4.0F;
   private static final String STRING = "Proxy";
   private float float_5;
   private final GuiComponentSub2 guiComponentSub2 = new GuiComponentSub2();
   private static final float FLOAT4 = 46.0F;

   private float getFloat126() {
      return this.float_ + 23.0F;
   }

   public float getFloat125() {
      return this.float_ + this.float_2 / 2.0F;
   }

   public void run189() {
      this.addressGuiComponent.run191();
   }

   @Override
   public boolean isCodepointModifiersRecord(CodepointModifiersRecord var1) {
      return this.addressGuiComponent.isCodepointModifiersRecord(var1);
   }

   @Override
   protected void run185() {
      this.guiComponentSub10.handleFloat80(this.float_3 + this.float_4 - 12.0F - 30.0F, this.getFloat126() - 15.0F, 30.0F, 30.0F);
      this.addressGuiComponent.handleFloat80(this.float_3 + 12.0F, this.float_ + 46.0F, this.float_4 - 24.0F, this.float_2 - 46.0F - 12.0F);
      this.guiComponentSub2.handleFloat80(this.float_3, this.float_, this.float_4, this.float_2);
   }

   public void handleFloat84(float var1) {
      this.float_5 = var1;
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      return super.isFloat17(var1, var2, var3) || this.isFloat15(var1, var2);
   }

   @Override
   public void handleCls28(Cls2 var1) {
      super.handleCls28(var1);
      this.guiComponentSub2.handleCls28(var1);
   }

   public void handleFloat85(float var1, float var2) {
      float var4 = Math.round((var1 - this.float_4) / 2.0F);
      float var5 = this.float_2;
      float var9 = Math.round((var2 - var5) / 2.0F);
      float var10 = this.float_4;
      this.handleFloat80(var4, var9, var10, this.float_2);
   }

   @Override
   public void handleCls27(Cls2 var1) {
      Sampler0 var2 = var1.sampler0;
      Sampler0 var10001 = var1.sampler0;
      var2.handleFloat10(this.float_5);
      var2.handleFloat25(this.float_3, this.float_, this.float_4, this.float_2, 28.0F, 3);
      Util14.handleSampler0(var2, this.float_3, this.float_, this.float_4, this.float_2, 28.0F, Util5.getIntForInt(2, var1.getPrimaryOnPrimaryRecord()));
      var2.run40();
      var2.handleFloat10(this.float_5);
      var2.handleOpticalWeightRecord9(
         client.onyx.theme.Util2.getOpticalWeightRecord2(),
         "Proxy",
         this.float_3 + 12.0F + 4.0F,
         this.getFloat126(),
         var1.getPrimaryOnPrimaryRecord().onSurface()
      );
      super.handleCls27(var1);
      var10001.run40();
      this.guiComponentSub2.handleCls27(var1);
   }

   public ProxyGuiComponent(Runnable var1) {
      this.float_5 = 1.0F;
      this.float_4 = 420.0F;
      this.float_2 = 46.0F + AddressGuiComponent.getFloat134() + 12.0F;
      this.guiComponentSub10 = new GuiComponentSub10("\ue5cd", var1);
      this.addressGuiComponent.handleConsumer3(this.guiComponentSub2::handleString20);
      this.addressGuiComponent.handleConsumer2(var1x -> this.guiComponentSub2.handleString21(var1x, "\ue001"));
      this.list.add(this.guiComponentSub10);
      this.list.add(this.addressGuiComponent);
   }

   @Override
   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      return this.addressGuiComponent.isKeyScancodeRecord3(var1);
   }

   public float getFloat124() {
      return this.float_3 + this.float_4 / 2.0F;
   }
}
