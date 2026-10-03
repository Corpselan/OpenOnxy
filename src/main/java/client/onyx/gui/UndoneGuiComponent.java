package client.onyx.gui;

import client.onyx.OnyxClient;
import client.onyx.config.ConfigManager;
import client.onyx.gui.component.ConfigsGuiComponent;
import client.onyx.gui.component.ContainerComponentSub;
import client.onyx.gui.component.GuiComponentSub2;
import client.onyx.gui.component.NewGuiComponent;
import client.onyx.gui.component.NoModulesMatchContainerComponent;
import client.onyx.gui.component.SearchModulesGuiComponent;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.theme.Util4;
import client.onyx.theme.Util5;

public class UndoneGuiComponent extends GuiComponent {
   private static final float FLOAT = 36.0F;
   private static final float FLOAT2 = 640.0F;
   private float float_5;
   private float float_6;
   private float float_7;
   private final SearchModulesGuiComponent searchModulesGuiComponent;
   private static final String STRING = "onyx client";
   private final NewGuiComponent newGuiComponent;
   private final client.onyx.render.misc.Cls cls;
   private boolean bool4;
   private final Cls cls2;
   private static float float_8;
   private static final float FLOAT3 = 420.0F;
   private float float_9;
   private static final float FLOAT4 = 96.0F;
   private final ConfigsGuiComponent configsGuiComponent;
   private float float_10;
   private float float_11;
   private static float float_12;
   private boolean bool5;
   private static ModuleCategory moduleCategory = ModuleCategory.COMBAT;
   private boolean bool6;
   private float float_13;
   private final ContainerComponentSub containerComponentSub = new ContainerComponentSub();
   private NoModulesMatchContainerComponent noModulesMatchContainerComponent;
   private final GuiComponentSub2 guiComponentSub2;

   private boolean isKeyScancodeRecord(KeyScancodeRecord var1) {
      if (Util2.isKeyScancodeRecord9(var1)) {
         this.run184();
         return true;
      } else if (Util2.isKeyScancodeRecord(var1)) {
         this.guiComponentSub2.handleString20(client.onyx.setting.Util.isEnabled2() ? "Undone" : "Nothing to undo");
         return true;
      } else if (Util2.isKeyScancodeRecord4(var1)) {
         this.guiComponentSub2.handleString20(client.onyx.setting.Util.isEnabled() ? "Redone" : "Nothing to redo");
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (var3 == 0 && this.isFloat14(var1, var2)) {
         this.isEnabled142();
         return true;
      } else {
         if (this.bool6) {
            if (this.bool4) {
               if (this.newGuiComponent.isFloat17(var1, var2, var3)) {
                  return true;
               }
            } else if (this.containerComponentSub.isFloat17(var1, var2, var3)) {
               return true;
            }

            if (var3 == 1 && this.isFloat15(var1, var2)) {
               this.isEnabled142();
               return true;
            }
         } else {
            if (this.searchModulesGuiComponent.isFloat17(var1, var2, var3)) {
               return true;
            }

            if (this.configsGuiComponent.isFloat17(var1, var2, var3)) {
               return true;
            }

            if (this.noModulesMatchContainerComponent.isFloat17(var1, var2, var3)) {
               return true;
            }
         }

         if (var3 == 0 && var1 >= this.float_3) {
            float var5 = this.float_3 + this.float_4;
            if (var1 < var5 && var2 >= this.float_ && var2 < this.float_ + getFloat107()) {
               this.bool5 = true;
               this.float_6 = var1 - this.float_3;
               this.float_13 = var2 - this.float_;
               return true;
            }
         }

         return this.isFloat15(var1, var2);
      }
   }

   private float getFloat106() {
      return this.float_ + getFloat107() / 2.0F;
   }

   public float getFloat112() {
      return this.float_3 + this.float_4 / 2.0F;
   }

   @Override
   public void handleCls27(Cls2 var1) {
      Sampler0 var4 = var1.sampler0;
      var4.handleFloat10(this.float_7);
      var4.handleFloat25(this.float_3, this.float_, this.float_4, this.float_2, 28.0F, 3);
      Util14.handleSampler0(var4, this.float_3, this.float_, this.float_4, this.float_2, 28.0F, Util5.getIntForInt(2, var1.getPrimaryOnPrimaryRecord()));
      var4.run40();
      float var3;
      this.handleCls26(var1, var3 = this.cls.getFloat());
      if (var3 < 0.999F) {
         var4.handleFloat10(this.float_7 * (1.0F - var3));
         var4.run36();
         var4.handleFloat11(-36.0F * var3, 0.0F);
         this.configsGuiComponent.handleCls27(var1);
         this.noModulesMatchContainerComponent.handleCls27(var1);
         var4.run43();
         var4.run40();
      }

      if (var3 > 0.001F) {
         var4.handleFloat10(this.float_7 * var3);
         var4.run36();
         var4.handleFloat11(36.0F * (1.0F - var3), 0.0F);
         Sampler0 var10000;
         if (this.bool4) {
            this.newGuiComponent.handleCls27(var1);
            var10000 = var4;
         } else {
            this.containerComponentSub.handleCls27(var1);
            var10000 = var4;
         }

         var10000.run43();
         var4.run40();
      }

      this.guiComponentSub2.handleCls27(var1);
   }

   private String getString36() {
      if (!this.noModulesMatchContainerComponent.isEnabled150()) {
         return this.configsGuiComponent.getModuleCategory3().getString2();
      } else {
         int var2;
         return (var2 = this.noModulesMatchContainerComponent.getInt60()) == 1 ? "1 result" : var2 + " results";
      }
   }

   @Override
   public boolean isFloat18(float var1, float var2, int var3, float var4, float var5) {
      if (this.bool5) {
         this.handleFloat79(var1 - this.float_6, var2 - this.float_13);
         return true;
      } else if (!this.bool6) {
         return this.searchModulesGuiComponent.isFloat18(var1, var2, var3, var4, var5);
      } else {
         return this.bool4 ? this.newGuiComponent.isFloat18(var1, var2, var3, var4, var5) : this.containerComponentSub.isFloat18(var1, var2, var3, var4, var5);
      }
   }

   @Override
   public boolean isFloat19(float var1, float var2, int var3) {
      this.bool5 = false;
      if (this.bool6) {
         return this.bool4 ? this.newGuiComponent.isFloat19(var1, var2, var3) : this.containerComponentSub.isFloat19(var1, var2, var3);
      } else {
         return this.noModulesMatchContainerComponent.isFloat19(var1, var2, var3);
      }
   }

   private static float getFloat105() {
      return 10.0F;
   }

   private boolean isKeyScancodeRecord2(KeyScancodeRecord var1) {
      switch (var1.key()) {
         case 200:

            return this.noModulesMatchContainerComponent.isInt6(0, -1);
         case 201:
         case 202:
         case 204:
         case 206:
         case 207:
         default:
            return false;
         case 203:
            if (!this.searchModulesGuiComponent.isEnabled154() && this.noModulesMatchContainerComponent.isInt6(-1, 0)) {
               return true;
            }

            return false;
         case 205:
            if (!this.searchModulesGuiComponent.isEnabled154() && this.noModulesMatchContainerComponent.isInt6(1, 0)) {
               return true;
            }

            return false;
         case 208:
            return this.noModulesMatchContainerComponent.isInt6(0, 1);
      }
   }

   private static float getFloat108() {
      return 62.0F;
   }

   @Override
   public boolean isCodepointModifiersRecord(CodepointModifiersRecord var1) {
      if (this.bool6) {
         return this.bool4 ? this.newGuiComponent.isCodepointModifiersRecord(var1) : this.containerComponentSub.isCodepointModifiersRecord(var1);
      } else if (this.searchModulesGuiComponent.isEnabled154()) {
         return this.searchModulesGuiComponent.isCodepointModifiersRecord(var1);
      } else {
         return Util2.isCodepointModifiersRecord(var1) && !Character.isWhitespace(var1.codepoint())
            ? this.searchModulesGuiComponent.isCodepointModifiersRecord2(var1)
            : false;
      }
   }

   public boolean isEnabled145() {
      return this.bool6;
   }

   @Override
   protected void run185() {
      float var1 = this.float_ + getFloat107();
      float var3 = this.float_2 - getFloat107() - getFloat105();
      this.configsGuiComponent.handleFloat80(this.float_3 + getFloat105(), var1, getFloat108(), var3);
      this.containerComponentSub.handleFloat80(this.float_3 + getFloat105(), var1, this.float_4 - getFloat105() * 2.0F, var3);
      this.newGuiComponent.handleFloat80(this.float_3 + getFloat105(), var1, this.float_4 - getFloat105() * 2.0F, var3);
      this.guiComponentSub2.handleFloat80(this.float_3, this.float_, this.float_4, this.float_2);
   }

   private void handleFloat79(float var1, float var2) {
      this.handleFloat80(
         Math.round(Math.clamp(var1, 96.0F - this.float_4, this.float_10 - 96.0F)),
         Math.round(Math.clamp(var2, 0.0F, this.float_5 - getFloat107())),
         this.float_4,
         this.float_2
      );
      float_12 = this.float_3 - this.float_11;
      float_8 = this.float_ - this.float_9;
   }

   private boolean isFloat14(float var1, float var2) {
      return this.bool6
         && var1 >= this.getFloat109()
         && var1 < this.getFloat109() + getFloat114()
         && var2 >= this.getFloat113()
         && var2 < this.getFloat113() + getFloat114();
   }

   public float getFloat110() {
      return this.float_ + this.float_2 / 2.0F;
   }

   public void lambda230(Module var1) {
      this.searchModulesGuiComponent.handleBool24(false);
      this.containerComponentSub.handleModule2(var1);
      this.bool4 = false;
      this.bool6 = true;
      this.cls.getCls2(1.0F, 300.0F, client.onyx.render.misc.Util.IFACE2);
   }

   private void handleCls26(Cls2 var1, float var2) {
      Sampler0 var4 = var1.sampler0;
      if (var2 < 0.999F) {
         float var3;
         float var10003 = var3 = this.float_7 * (1.0F - var2);
         var4.handleOpticalWeightRecord9(
            client.onyx.theme.Util2.getOpticalWeightRecord2(),
            "onyx client",
            this.float_3 + getFloat105() + 6.0F,
            this.getFloat106(),
            Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurface(), var3)
         );
         var4.handleOpticalWeightRecord6(
            client.onyx.theme.Util2.getOpticalWeightRecord5(),
            this.getString36(),
            this.float_3 + this.float_4 - getFloat105() - 6.0F,
            this.getFloat106(),
            Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant(), var3)
         );
         var4.handleFloat10(var10003);
         this.searchModulesGuiComponent.handleCls27(var1);
         var4.run40();
      }

      Module var6 = this.containerComponentSub.getModule4();
      if (var2 > 0.001F && (this.bool4 || var6 != null)) {
         var2 = this.float_7 * var2;
         this.cls2
            .handleSampler0(
               var4, this.getFloat109(), this.getFloat113(), getFloat114(), getFloat114(), Float.MAX_VALUE, var1.getPrimaryOnPrimaryRecord().onSurface()
            );
         Util.handleSampler02(
            var4,
            this.getFloat109() + getFloat114() / 2.0F,
            this.getFloat113() + getFloat114() / 2.0F,
            15.0F,
            Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurface(), var2)
         );
         OpticalWeightRecord var10001 = client.onyx.theme.Util2.getOpticalWeightRecord2();
         UndoneGuiComponent var9;
         String var10002;
         if (this.bool4) {
            var10002 = "Configs";
            var9 = this;
         } else {
            var10002 = var6.getString20();
            var9 = this;
         }

         var4.handleOpticalWeightRecord9(
            var10001,
            var10002,
            var9.getFloat109() + getFloat114() + 8.0F,
            this.getFloat106(),
            Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurface(), var2)
         );
         var10001 = client.onyx.theme.Util2.getOpticalWeightRecord5();
         if (this.bool4) {
            var10002 = this.newGuiComponent.getString41();
            var9 = this;
         } else {
            var10002 = var6.getModuleCategory().getString2();
            var9 = this;
         }

         var4.handleOpticalWeightRecord6(
            var10001,
            var10002,
            var9.float_3 + this.float_4 - getFloat105() - 6.0F,
            this.getFloat106(),
            Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant(), var2)
         );
      }
   }

   private float getFloat113() {
      return this.getFloat106() - getFloat114() / 2.0F;
   }

   private void handleCls25(Cls2 var1) {
      Sampler0 var4 = var1.sampler0;
      float var5 = this.float_3 + getFloat105() + 6.0F + var4.getFloat17(client.onyx.theme.Util2.getOpticalWeightRecord2(), "onyx client");
      float var6 = Math.max(this.float_3 + getFloat105() + getFloat108() + getFloat105(), var5 + getFloat111());
      float var2 = var4.getFloat17(client.onyx.theme.Util2.getOpticalWeightRecord5(), this.getString36());
      float var3 = this.float_ + getFloat107();
      var2 = this.float_3 + this.float_4 - getFloat105() - 6.0F - var2 - getFloat111();
      this.searchModulesGuiComponent
         .handleFloat80(var6, this.getFloat106() - SearchModulesGuiComponent.getFloat129() / 2.0F, var2 - var6, SearchModulesGuiComponent.getFloat129());
      this.noModulesMatchContainerComponent
         .handleFloat80(var6, var3, this.float_3 + this.float_4 - getFloat105() - var6, this.float_2 - getFloat107() - getFloat105());
   }

   private boolean isEnabled143() {
      Module var2;
      if ((var2 = this.noModulesMatchContainerComponent.getModule2()) == null) {
         return false;
      } else {
         this.lambda230(var2);
         return true;
      }
   }

   public boolean isEnabled142() {
      if (!this.bool6) {
         return false;
      } else {
         if (this.bool4) {
            this.newGuiComponent.run199();
         }

         this.bool6 = false;
         this.cls.getCls2(0.0F, 300.0F, client.onyx.render.misc.Util.IFACE2);
         return true;
      }
   }

   public void lambda228() {
      this.searchModulesGuiComponent.handleBool24(false);
      this.newGuiComponent.run200();
      this.bool4 = true;
      this.bool6 = true;
      this.cls.getCls2(1.0F, 300.0F, client.onyx.render.misc.Util.IFACE2);
   }

   public void handleFloat78(float var1, float var2) {
      this.float_10 = var1;
      this.float_5 = var2;
      this.float_11 = (var1 - this.float_4) / 2.0F;
      this.float_9 = (var2 - this.float_2) / 2.0F;
      this.handleFloat79(this.float_11 + float_12, this.float_9 + float_8);
   }

   private static float getFloat107() {
      return 38.0F;
   }

   @Override
   public void handleCls28(Cls2 var1) {
      this.handleCls25(var1);
      this.cls.handleFloat(var1.float_);
      this.cls2.handleFloat(var1.float_, this.isFloat14(var1.float_3, var1.float_2), false);
      this.bool = this.isFloat15(var1.float_3, var1.float_2);
      float var2;
      if ((var2 = this.cls.getFloat()) < 0.999F) {
         this.configsGuiComponent.handleCls28(var1);
         this.searchModulesGuiComponent.handleCls28(var1);
         this.noModulesMatchContainerComponent.handleCls28(var1);
      }

      UndoneGuiComponent var10000;
      label17: {
         if (var2 > 0.001F) {
            if (this.bool4) {
               this.newGuiComponent.handleCls28(var1);
               var10000 = this;
               break label17;
            }

            this.containerComponentSub.handleCls28(var1);
         }

         var10000 = this;
      }

      var10000.guiComponentSub2.handleCls28(var1);
   }

   public UndoneGuiComponent() {
      this.newGuiComponent = new NewGuiComponent();
      this.searchModulesGuiComponent = new SearchModulesGuiComponent(var1 -> this.noModulesMatchContainerComponent.handleString19(var1));
      this.guiComponentSub2 = new GuiComponentSub2();
      this.cls2 = new Cls();
      this.cls = new client.onyx.render.misc.Cls(0.0F);
      this.float_7 = 1.0F;
      this.float_4 = 640.0F;
      this.float_2 = 420.0F;
      this.noModulesMatchContainerComponent = new NoModulesMatchContainerComponent(moduleCategory, this::lambda230);
      this.configsGuiComponent = new ConfigsGuiComponent(moduleCategory, var1 -> {
         moduleCategory = var1;
         this.searchModulesGuiComponent.isEnabled149();
         this.noModulesMatchContainerComponent.handleModuleCategory(var1);
      }, this::lambda228);
      this.list.add(this.configsGuiComponent);
      this.list.add(this.searchModulesGuiComponent);
      this.list.add(this.noModulesMatchContainerComponent);
      this.list.add(this.containerComponentSub);
      this.list.add(this.newGuiComponent);
   }

   private boolean isEnabled144() {
      Module var2;
      if ((var2 = this.noModulesMatchContainerComponent.getModule2()) == null) {
         return false;
      } else {
         var2.lambda35();
         return true;
      }
   }

   private void run184() {
      ConfigManager var1 = OnyxClient.configManager;
      String var3 = OnyxClient.configManager.getString47();
      GuiComponentSub2 var10000 = this.guiComponentSub2;
      boolean var10001 = var1.isString4(var3);
      StringBuilder var10003;
      String var4;
      if (var10001) {
         var10003 = new StringBuilder();
         var4 = var10003.insert(0, "Saved ").append(var3).toString();
      } else {
         var10003 = new StringBuilder();
         var4 = var10003.insert(0, "Could not save ").append(var3).toString();
      }

      var10000.handleString20(var4);
   }

   private static float getFloat114() {
      return 26.0F;
   }

   public void handleFloat77(float var1) {
      this.float_7 = var1;
   }

   @Override
   public boolean isFloat16(float var1, float var2, double var3) {
      if (this.bool6) {
         return this.bool4 ? this.newGuiComponent.isFloat16(var1, var2, var3) : this.containerComponentSub.isFloat16(var1, var2, var3);
      } else {
         return this.noModulesMatchContainerComponent.isFloat16(var1, var2, var3);
      }
   }

   @Override
   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      if (!this.bool6) {
         if (Util2.isKeyScancodeRecord3(var1)) {
            this.searchModulesGuiComponent.handleBool24(true);
            this.searchModulesGuiComponent.run195();
            return true;
         } else if (this.isKeyScancodeRecord(var1)) {
            return true;
         } else if (this.isKeyScancodeRecord2(var1)) {
            return true;
         } else if (Util2.isKeyScancodeRecord6(var1) && this.isEnabled143()) {
            return true;
         } else if (this.searchModulesGuiComponent.isKeyScancodeRecord3(var1)) {
            return true;
         } else {
            return var1.key() == 57 && this.isEnabled144() ? true : Util2.isKeyScancodeRecord11(var1) && !this.searchModulesGuiComponent.isEnabled154();
         }
      } else if (this.bool4 ? !this.newGuiComponent.isKeyScancodeRecord3(var1) : !this.containerComponentSub.isKeyScancodeRecord3(var1)) {
         if (this.isKeyScancodeRecord(var1)) {
            return true;
         } else {
            return Util2.isKeyScancodeRecord11(var1) ? this.isEnabled142() : false;
         }
      } else {
         return true;
      }
   }

   private static float getFloat111() {
      return 12.0F;
   }

   private float getFloat109() {
      return this.float_3 + getFloat105();
   }
}
