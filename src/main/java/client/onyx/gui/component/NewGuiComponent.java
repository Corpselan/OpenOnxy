package client.onyx.gui.component;

import client.onyx.OnyxClient;
import client.onyx.config.ConfigManager;
import client.onyx.gui.GuiComponent;
import client.onyx.gui.Util2;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class NewGuiComponent extends GuiComponent {
   private NoConfigsSavedYetContainerComponent noConfigsSavedYetContainerComponent;
   private static final float FLOAT = 120.0F;
   private final GuiComponentSub8 guiComponentSub8 = new GuiComponentSub8("Config name");
   private static final float FLOAT2 = 10.0F;
   private GuiComponentSub2 guiComponentSub2;
   private GuiComponentSub5 guiComponentSub5;
   private LoadGuiComponent loadGuiComponent;
   private String string;
   private boolean bool4;
   private final GuiComponentSub4 guiComponentSub4 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.TONAL, "New", "\ue145", () -> {
      String var3;
      if (!(var3 = this.guiComponentSub8.getString39().trim()).isEmpty() && !this.getConfigManager().lambda317(var3)) {
         this.guiComponentSub2.handleString21("Use 1-64 letters, digits, - or _", "\ue001");
      } else if (!var3.isEmpty() && this.getConfigManager().isString8(var3)) {
         this.guiComponentSub2.handleString21("Config already exists; use its menu to overwrite", "\ue001");
      } else {
         String var2x = var3.isEmpty() ? this.getConfigManager().getString45("new") : var3;
         if (var2x != null && this.getConfigManager().isString9(var2x)) {
            this.noConfigsSavedYetContainerComponent.run201();
            this.guiComponentSub8.handleString23("");
            this.guiComponentSub8.handleBool24(false);
            this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Created ").append(var2x).toString());
         } else {
            this.guiComponentSub2.handleString21("Could not create a config", "\ue001");
         }
      }
   });
   private List<String> list2;
   private final GuiComponentSub4 guiComponentSub42 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.OUTLINED, "Save as", "\ue161", this::lambda271);
   private final Set<String> set;
   private static final float FLOAT3 = 8.0F;
   private final GuiComponentSub5 guiComponentSub52;
   private final GuiComponentSub4 guiComponentSub43 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.TEXT, "Open folder", "\ue2c8", () -> {
      this.getConfigManager().run207();
      this.guiComponentSub2.handleString20("Opened config folder");
   });

   @Override
   public boolean isFloat19(float var1, float var2, int var3) {
      return this.guiComponentSub8.isFloat19(var1, var2, var3)
         | this.guiComponentSub4.isFloat19(var1, var2, var3)
         | this.guiComponentSub42.isFloat19(var1, var2, var3)
         | this.guiComponentSub43.isFloat19(var1, var2, var3)
         | this.noConfigsSavedYetContainerComponent.isFloat19(var1, var2, var3);
   }

   private void handleLoadGuiComponent(LoadGuiComponent var1) {
      String var3;
      if ((var3 = this.getConfigManager().getString48(var1.getString43())) == null) {
         this.guiComponentSub2.handleString21(new StringBuilder().insert(0, "Could not duplicate ").append(var1.getString43()).toString(), "\ue001");
      } else {
         this.noConfigsSavedYetContainerComponent.run201();
         this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Duplicated as ").append(var3).toString());
      }
   }

   private void handleLoadGuiComponent2(LoadGuiComponent var1) {
      String var2 = var1.getString43();
      if (this.getConfigManager().isString6(var2)) {
         this.noConfigsSavedYetContainerComponent.run201();
         this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Deleted ").append(var2).toString());
      } else {
         this.guiComponentSub2.handleString21(new StringBuilder().insert(0, "Could not delete ").append(var2).toString(), "\ue001");
      }
   }

   private void handleLoadGuiComponent4(LoadGuiComponent var1) {
      this.list2 = this.getConfigManager().getList31().stream().filter(var1x -> !var1x.equals(var1.getString43())).toList();
      if (this.list2.isEmpty()) {
         this.guiComponentSub2.handleString21("No other configs to copy visuals to", "\ue001");
      } else {
         this.string = var1.getString43();
         this.set.clear();
         this.bool4 = true;
      }
   }

   private ConfigManager getConfigManager() {
      return OnyxClient.configManager;
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      this.guiComponentSub8.handleCls27(var1);
      this.guiComponentSub4.handleCls27(var1);
      this.guiComponentSub42.handleCls27(var1);
      this.guiComponentSub43.handleCls27(var1);
      this.noConfigsSavedYetContainerComponent.handleCls27(var1);
      this.guiComponentSub52.handleCls27(var1);
      this.guiComponentSub5.handleCls27(var1);
      this.guiComponentSub2.handleCls27(var1);
   }

   private List<GuiComponentSub5.GlyphLabelRecord> getList29(LoadGuiComponent var1) {
      ArrayList var3;
      (var3 = new ArrayList())
         .add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString("\ue161", "Overwrite with current", () -> this.handleLoadGuiComponent3(var1)));
      var3.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString("\ue14d", "Duplicate", () -> this.handleLoadGuiComponent(var1)));
      var3.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString("\ue14d", "Copy visuals to", () -> this.handleLoadGuiComponent4(var1)));
      var3.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecord());
      var3.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString2("\ue872", "Delete", () -> this.handleLoadGuiComponent2(var1)));
      return var3;
   }

   @Override
   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      if (this.guiComponentSub5.isKeyScancodeRecord3(var1)) {
         return true;
      } else if (this.guiComponentSub52.isKeyScancodeRecord3(var1)) {
         return true;
      } else if (this.guiComponentSub8.isKeyScancodeRecord3(var1)) {
         return true;
      } else if (Util2.isKeyScancodeRecord10(var1)) {
         this.guiComponentSub8.handleBool24(true);
         this.guiComponentSub8.run195();
         return true;
      } else if (Util2.isKeyScancodeRecord9(var1) && !this.guiComponentSub8.getString39().isBlank()) {
         this.lambda271();
         return true;
      } else if (var1.key() == 200) {
         return this.noConfigsSavedYetContainerComponent.isInt6(0, -1);
      } else if (var1.key() == 208) {
         return this.noConfigsSavedYetContainerComponent.isInt6(0, 1);
      } else if (Util2.isKeyScancodeRecord6(var1) && this.noConfigsSavedYetContainerComponent.getLoadGuiComponent() != null) {
         this.lambda273(this.noConfigsSavedYetContainerComponent.getLoadGuiComponent());
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.guiComponentSub5.isFloat17(var1, var2, var3)) {
         return true;
      } else if (this.guiComponentSub52.isFloat17(var1, var2, var3)) {
         return true;
      } else if (this.guiComponentSub8.isFloat17(var1, var2, var3)) {
         return true;
      } else if (this.guiComponentSub4.isFloat17(var1, var2, var3)) {
         return true;
      } else if (this.guiComponentSub42.isFloat17(var1, var2, var3)) {
         return true;
      } else {
         return this.guiComponentSub43.isFloat17(var1, var2, var3) ? true : this.noConfigsSavedYetContainerComponent.isFloat17(var1, var2, var3);
      }
   }

   private boolean lambda281() {
      return !this.list2.isEmpty() && this.set.containsAll(this.list2);
   }

   public String getString41() {
      int var2;
      return (var2 = this.noConfigsSavedYetContainerComponent.getInt68()) == 1 ? "1 config" : var2 + " configs";
   }

   @Override
   public boolean isCodepointModifiersRecord(CodepointModifiersRecord var1) {
      return this.guiComponentSub8.isCodepointModifiersRecord(var1);
   }

   private void handleCls223(client.onyx.gui.Cls2 var1) {
      Sampler0 var6 = var1.sampler0;
      float var2 = this.guiComponentSub4.getFloat142(var6);
      float var5 = this.guiComponentSub42.getFloat142(var6);
      float var7 = this.guiComponentSub43.getFloat142(var6);
      float var4 = Math.max(120.0F, this.float_4 - var2 - var5 - var7 - 30.0F);
      float var3 = this.float_ + 5.0F;
      this.guiComponentSub8.handleFloat80(this.float_3, this.float_, var4, 40.0F);
      this.guiComponentSub4.handleFloat80(this.guiComponentSub8.getFloat118() + this.guiComponentSub8.getFloat119() + 10.0F, var3, var2, 30.0F);
      this.guiComponentSub42.handleFloat80(this.guiComponentSub4.getFloat118() + var2 + 10.0F, var3, var5, 30.0F);
      this.guiComponentSub43.handleFloat80(this.float_3 + this.float_4 - var7, var3, var7, 30.0F);
      this.noConfigsSavedYetContainerComponent.handleFloat80(this.float_3, this.float_ + 40.0F + 8.0F, this.float_4, this.float_2 - 40.0F - 8.0F);
      this.guiComponentSub2.handleFloat80(this.float_3, this.float_, this.float_4, this.float_2);
   }

   private void handleString26(String var1) {
      if (!this.set.add(var1)) {
         this.set.remove(var1);
      }
   }

   private void lambda271() {
      String var2 = this.guiComponentSub8.getString39().trim();
      if (!this.getConfigManager().lambda317(var2)) {
         this.guiComponentSub2.handleString21("Use 1-64 letters, digits, - or _", "\ue001");
      } else if (this.getConfigManager().isString8(var2)) {
         this.guiComponentSub2.handleString21("Config already exists; use its menu to overwrite", "\ue001");
      } else if (!this.getConfigManager().isString4(var2)) {
         this.guiComponentSub2.handleString21(new StringBuilder().insert(0, "Could not save ").append(var2).toString(), "\ue001");
      } else {
         this.noConfigsSavedYetContainerComponent.run201();
         this.guiComponentSub8.handleString23("");
         this.guiComponentSub8.handleBool24(false);
         this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Saved ").append(var2).toString());
      }
   }

   public void run200() {
      this.noConfigsSavedYetContainerComponent.run201();
      this.guiComponentSub8.handleString23("");
      this.guiComponentSub8.handleBool24(false);
      this.guiComponentSub52.run196();
      this.guiComponentSub5.run196();
      this.set.clear();
   }

   public void run199() {
      this.guiComponentSub8.handleBool24(false);
      this.guiComponentSub52.run196();
      this.guiComponentSub5.run196();
      this.guiComponentSub2.run193();
   }

   @Override
   public boolean isFloat16(float var1, float var2, double var3) {
      if (this.guiComponentSub5.isFloat16(var1, var2, var3)) {
         return true;
      } else {
         return this.guiComponentSub52.isFloat16(var1, var2, var3) ? true : this.noConfigsSavedYetContainerComponent.isFloat16(var1, var2, var3);
      }
   }

   @Override
   public boolean isFloat18(float var1, float var2, int var3, float var4, float var5) {
      return this.guiComponentSub8.isFloat18(var1, var2, var3, var4, var5);
   }

   public NewGuiComponent() {
      Consumer<LoadGuiComponent> var1 = this::lambda273;
      NoConfigsSavedYetContainerComponent var2 = new NoConfigsSavedYetContainerComponent(var1, var1x -> {
         String var2x = var1x.getString43();
         if (this.getConfigManager().isString4(var2x)) {
            this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Saved ").append(var2x).toString());
         } else {
            this.guiComponentSub2.handleString21(new StringBuilder().insert(0, "Could not save ").append(var2x).toString(), "\ue001");
         }
      }, var1x -> {
         this.guiComponentSub5.run196();
         this.loadGuiComponent = var1x;
      });
      this.noConfigsSavedYetContainerComponent = var2;
      this.guiComponentSub52 = new GuiComponentSub5();
      this.guiComponentSub5 = new GuiComponentSub5();
      this.guiComponentSub2 = new GuiComponentSub2();
      this.set = new LinkedHashSet<>();
      this.list2 = List.of();
      this.guiComponentSub8.handleRunnable(this::lambda271);
   }

   private List<GuiComponentSub5.GlyphLabelRecord> getList30() {
      ArrayList var4;
      (var4 = new ArrayList()).add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString3("Select all", this::lambda281, () -> {
         if (this.lambda281()) {
            this.set.clear();
         } else {
            this.set.addAll(this.list2);
         }
      }));
      var4.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecord());
      Iterator var2 = this.list2.iterator();

      for (Iterator var10000 = var2; var10000.hasNext(); var10000 = var2) {
         String var3 = (String)var2.next();
         var4.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString3(var3, () -> this.set.contains(var3), () -> this.handleString26(var3)));
      }

      var4.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecord());
      var4.add(
         GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString4(
            "\ue14d",
            "Copy to selected",
            () -> {
               if (this.set.isEmpty()) {
                  this.guiComponentSub2.handleString21("Select at least one config", "\ue001");
               } else {
                  ConfigManager.CopiedFailedRecord var2x;
                  if ((var2x = this.getConfigManager().getCopiedFailedRecord(this.string, new ArrayList<>(this.set))).copied() == 0) {
                     this.guiComponentSub2.handleString21("Could not copy visuals", "\ue001");
                  } else {
                     NewGuiComponent var10000x;
                     if (!var2x.failed().isEmpty()) {
                        this.guiComponentSub2
                           .handleString21(
                              new StringBuilder()
                                 .insert(0, "Copied to ")
                                 .append(var2x.copied())
                                 .append("; failed: ")
                                 .append(String.join(", ", var2x.failed()))
                                 .toString(),
                              "\ue001"
                           );
                        var10000x = this;
                     } else {
                        this.guiComponentSub2
                           .handleString20(new StringBuilder().insert(0, "Copied visuals to ").append(var2x.copied()).append(" config(s)").toString());
                        var10000x = this;
                     }

                     var10000x.set.clear();
                     this.guiComponentSub5.run196();
                  }
               }
            }
         )
      );
      return var4;
   }

   private void handleLoadGuiComponent3(LoadGuiComponent var1) {
      String var2 = var1.getString43();
      if (this.getConfigManager().isString4(var2)) {
         this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Updated ").append(var2).toString());
      } else {
         this.guiComponentSub2.handleString21(new StringBuilder().insert(0, "Could not update ").append(var2).toString(), "\ue001");
      }
   }

   @Override
   public void handleCls28(client.onyx.gui.Cls2 var1) {
      this.handleCls223(var1);
      this.guiComponentSub8.handleCls28(var1);
      this.guiComponentSub4.handleCls28(var1);
      this.guiComponentSub42.handleCls28(var1);
      this.guiComponentSub43.handleCls28(var1);
      this.noConfigsSavedYetContainerComponent.handleCls28(var1);
      if (this.loadGuiComponent != null) {
         this.guiComponentSub52.handleList18(this.getList29(this.loadGuiComponent), this.loadGuiComponent.getGuiComponent3(), this, var1.sampler0);
         this.loadGuiComponent = null;
      }

      if (this.bool4) {
         this.guiComponentSub5.handleList17(this.getList30(), this.guiComponentSub52, this, var1.sampler0);
         this.bool4 = false;
      }

      this.guiComponentSub52.handleCls28(var1);
      this.guiComponentSub5.handleCls28(var1);
      this.guiComponentSub2.handleCls28(var1);
   }

   private void lambda273(LoadGuiComponent var1) {
      String var2 = var1.getString43();
      if (this.getConfigManager().isString3(var2)) {
         this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Loaded ").append(var2).toString());
      } else {
         this.guiComponentSub2.handleString21(new StringBuilder().insert(0, "Could not load ").append(var2).toString(), "\ue001");
      }
   }
}
