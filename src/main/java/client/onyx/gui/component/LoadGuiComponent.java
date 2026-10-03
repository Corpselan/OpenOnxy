package client.onyx.gui.component;

import client.onyx.OnyxClient;
import client.onyx.gui.GuiComponent;
import client.onyx.render.Sampler0;
import client.onyx.render.misc.Util;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.function.Consumer;

public class LoadGuiComponent extends GuiComponent {
   private static final float FLOAT = 6.0F;
   private final GuiComponentSub4 guiComponentSub4;
   private final GuiComponentSub10 guiComponentSub10;
   private boolean bool4;
   private final String string;
   public static final float FLOAT2 = 50.0F;
   private static final float FLOAT3 = 8.0F;
   private static final float FLOAT4 = 76.0F;
   private final Consumer<LoadGuiComponent> consumer;
   private final client.onyx.gui.Cls cls = new client.onyx.gui.Cls();
   private final Consumer<LoadGuiComponent> consumer2;
   private final client.onyx.render.misc.Cls2 cls2 = new client.onyx.render.misc.Cls2(0);
   private final Consumer<LoadGuiComponent> consumer3;

   public boolean isFloat19(float var1, float var2, int var3) {
      this.bool3 = false;
      return super.isFloat19(var1, var2, var3);
   }

   public String getString43() {
      return this.string;
   }

   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var2 = var1.sampler0;
      boolean var8 = this.isEnabled165();
      var2.handleFloat7(this.float_3, this.float_, this.float_4, this.float_2, 12.0F, this.cls2.getInt());
      this.cls.handleSampler0(var2, this.float_3, this.float_, this.float_4, this.float_2, 12.0F, var1.getPrimaryOnPrimaryRecord().onSurface());
      float var4 = this.float_3 + 12.0F;
      float var5 = this.guiComponentSub4.getFloat118() - 6.0F - var4;
      String var6 = var8 ? "Loaded" : "Saved config";
      int var7 = var8 ? var1.getPrimaryOnPrimaryRecord().onSecondaryContainer() : var1.getPrimaryOnPrimaryRecord().onSurface();
      int var9 = var8 ? Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSecondaryContainer(), 0.72F) : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant();
      var2.handleOpticalWeightRecord9(Util2.getOpticalWeightRecord4(), var2.getString17(Util2.getOpticalWeightRecord4(), this.string, var5), var4, this.float_ + this.float_2 * 0.33F, var7);
      var2.handleOpticalWeightRecord9(Util2.getOpticalWeightRecord5(), var6, var4, this.float_ + this.float_2 * 0.7F, var9);
      super.handleCls27(var1);
   }

   public LoadGuiComponent(String var1, Consumer<LoadGuiComponent> var2, Consumer<LoadGuiComponent> var3, Consumer<LoadGuiComponent> var4) {
      this.string = var1;
      this.consumer = var2;
      this.consumer3 = var3;
      this.consumer2 = var4;
      this.guiComponentSub4 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.TEXT, "Load", "\ue2c4", () -> {
         if (this.isEnabled165()) {
            this.consumer3.accept(this);
         } else {
            this.consumer.accept(this);
         }
      });
      this.guiComponentSub10 = new GuiComponentSub10("\ue5d4", () -> {
         var4.accept(this);
      });
      this.float_2 = 50.0F;
      this.list.add(this.guiComponentSub4);
      this.list.add(this.guiComponentSub10);
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.guiComponentSub4.isFloat17(var1, var2, var3)) {
         return true;
      } else if (this.guiComponentSub10.isFloat17(var1, var2, var3)) {
         return true;
      } else if (!this.isFloat15(var1, var2)) {
         return false;
      } else if (var3 == 0) {
         this.bool3 = true;
         if (!this.isEnabled165()) {
            this.consumer.accept(this);
         }

         return true;
      } else if (var3 == 1) {
         this.consumer2.accept(this);
         return true;
      } else {
         return false;
      }
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      boolean var3 = this.isEnabled165();
      this.guiComponentSub4.handleString24(var3 ? "Save" : "Load");
      this.guiComponentSub4.handleString25(var3 ? "\ue161" : "\ue2c4");
      super.handleCls28(var1);
      int var4 = var3 ? var1.getPrimaryOnPrimaryRecord().secondaryContainer() : var1.getPrimaryOnPrimaryRecord().surfaceContainerHigh();
      if (!this.bool4) {
         this.bool4 = true;
         this.cls2.getCls2(var4);
      }

      this.cls2.getCls22(var4, 250.0F, Util.IFACE6);
      this.cls2.handleFloat(var1.float_);
      client.onyx.gui.Cls var10000 = this.cls;
      float var10001 = var1.float_;
      boolean var10002;
      LoadGuiComponent var10003;
      if (this.bool && !this.guiComponentSub4.isEnabled146() && !this.guiComponentSub10.isEnabled146()) {
         var10002 = true;
         var10003 = this;
      } else {
         var10002 = false;
         var10003 = this;
      }

      var10000.handleFloat(var10001, var10002, var10003.bool3);
   }

   protected void run185() {
      this.guiComponentSub10.handleFloat80(this.float_3 + this.float_4 - 30.0F - 8.0F, this.float_ + (this.float_2 - 30.0F) / 2.0F, 30.0F, 30.0F);
      this.guiComponentSub4.handleFloat80(this.guiComponentSub10.getFloat118() - 6.0F - 76.0F, this.float_ + (this.float_2 - 30.0F) / 2.0F, 76.0F, 30.0F);
   }

   private boolean isEnabled165() {
      return OnyxClient.configManager.isString5(this.string);
   }

   public GuiComponent getGuiComponent3() {
      return this.guiComponentSub10;
   }
}
