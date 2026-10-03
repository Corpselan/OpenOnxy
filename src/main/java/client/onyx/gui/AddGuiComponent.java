package client.onyx.gui;

import client.onyx.OnyxClient;
import client.onyx.account.Abstract_;
import client.onyx.account.AccountManager;
import client.onyx.account.OfflineAccessTokenEnum;
import client.onyx.gui.component.AddressGuiComponent;
import client.onyx.gui.component.ExpiredGuiComponent;
import client.onyx.gui.component.GuiComponentSub10;
import client.onyx.gui.component.GuiComponentSub2;
import client.onyx.gui.component.GuiComponentSub4;
import client.onyx.gui.component.GuiComponentSub5;
import client.onyx.gui.component.UsernameGuiComponent;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.theme.Util4;
import client.onyx.theme.Util5;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import net.minecraft.client.gui.GuiScreen;

public class AddGuiComponent extends GuiComponent {
   private final GuiComponentSub2 guiComponentSub2;
   private float float_5;
   private static final float FLOAT = 34.0F;
   private boolean bool4;
   private final GuiComponentSub5 guiComponentSub5;
   private static final float FLOAT2 = 36.0F;
   private float float_6;
   private final client.onyx.render.misc.Cls cls;
   private final NoAccountsYetContainerComponent noAccountsYetContainerComponent;
   private float float_7;
   private static float float_8;
   private static final float FLOAT3 = 12.0F;
   private float float_9;
   private static float float_10;
   private final GuiComponentSub10 guiComponentSub10;
   private static final float FLOAT4 = 82.0F;
   private boolean bool5;
   private final UsernameGuiComponent usernameGuiComponent = new UsernameGuiComponent();
   private static final float FLOAT5 = 12.0F;
   private float float_11;
   private float float_12;
   private final GuiComponentSub4 guiComponentSub4;
   private float float_13;
   private static final float FLOAT6 = 400.0F;
   private boolean bool6;
   private static final float FLOAT7 = 4.0F;
   private final AddressGuiComponent addressGuiComponent = new AddressGuiComponent();
   private static final float FLOAT8 = 96.0F;
   private static final String STRING = "Accounts";
   private final GuiComponentSub4 guiComponentSub42;
   private static final float FLOAT9 = 46.0F;
   private final GuiComponentSub4 guiComponentSub43;
   private ExpiredGuiComponent expiredGuiComponent;
   private static final float FLOAT10 = 560.0F;

   @Override
   public boolean isFloat19(float var1, float var2, int var3) {
      this.bool6 = false;
      if (this.bool5) {
         return this.usernameGuiComponent.isFloat19(var1, var2, var3);
      } else {
         return this.bool4
            ? this.addressGuiComponent.isFloat19(var1, var2, var3)
            : this.guiComponentSub42.isFloat19(var1, var2, var3)
               | this.guiComponentSub4.isFloat19(var1, var2, var3)
               | this.guiComponentSub43.isFloat19(var1, var2, var3)
               | this.noAccountsYetContainerComponent.isFloat19(var1, var2, var3);
      }
   }

   private void handleCls214(Cls2 var1, Sampler0 var2) {
      float var3 = this.float_ + this.float_2 - 17.0F;
      var2.handleFloat28(
         this.float_3 + 12.0F, this.float_ + this.float_2 - 34.0F, this.float_4 - 24.0F, 1.0F, var1.getPrimaryOnPrimaryRecord().outlineVariant()
      );
      var2.handleOpticalWeightRecord9(
         client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2,
         var2.getString17(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2, this.getString37(), this.guiComponentSub4.getFloat118() - this.float_3 - 24.0F),
         this.float_3 + 12.0F + 4.0F,
         var3,
         var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()
      );
      this.guiComponentSub4.handleCls27(var1);
      this.guiComponentSub43.handleCls27(var1);
   }

   private void handleFloat83(float var1, float var2) {
      this.handleFloat80(
         Math.round(Math.clamp(var1, 96.0F - this.float_4, this.float_13 - 96.0F)),
         Math.round(Math.clamp(var2, 0.0F, this.float_9 - 46.0F)),
         this.float_4,
         this.float_2
      );
      float_8 = this.float_3 - this.float_12;
      float_10 = this.float_ - this.float_7;
   }

   private static String getStringForThrowable(Throwable var0) {
      Throwable var2 = var0.getCause() == null ? var0 : var0.getCause();
      return var2.getMessage() == null ? var2.toString() : var2.getMessage();
   }

   private void handleString18(String var1, String var2) {
      if (var2 != null && !var2.isBlank()) {
         GuiScreen.setClipboardString(var2);
         this.guiComponentSub2.handleString20(new StringBuilder().insert(0, var1).append(" copied").toString());
      } else {
         this.lambda239("Nothing to copy");
      }
   }

   @Override
   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.guiComponentSub5.isFloat17(var1, var2, var3)) {
         return true;
      } else {
         if (this.bool5) {
            if (this.guiComponentSub10.isFloat17(var1, var2, var3)) {
               return true;
            }

            if (this.usernameGuiComponent.isFloat17(var1, var2, var3)) {
               return true;
            }
         } else if (this.bool4) {
            if (this.guiComponentSub10.isFloat17(var1, var2, var3)) {
               return true;
            }

            if (this.addressGuiComponent.isFloat17(var1, var2, var3)) {
               return true;
            }
         } else {
            if (this.guiComponentSub42.isFloat17(var1, var2, var3)) {
               return true;
            }

            if (this.guiComponentSub4.isFloat17(var1, var2, var3)) {
               return true;
            }

            if (this.guiComponentSub43.isFloat17(var1, var2, var3)) {
               return true;
            }

            if (this.noAccountsYetContainerComponent.isFloat17(var1, var2, var3)) {
               return true;
            }
         }

         if (var3 == 0 && var1 >= this.float_3) {
            float var5 = this.float_3 + this.float_4;
            if (var1 < var5 && var2 >= this.float_ && var2 < this.float_ + 46.0F) {
               this.bool6 = true;
               this.float_11 = var1 - this.float_3;
               this.float_5 = var2 - this.float_;
               return true;
            }
         }

         return this.isFloat15(var1, var2);
      }
   }

   public float getFloat123() {
      return this.float_3 + this.float_4 / 2.0F;
   }

   private AccountManager getAccountManager() {
      return OnyxClient.accountManager;
   }

   @Override
   public boolean isFloat16(float var1, float var2, double var3) {
      return this.guiComponentSub5.isFloat16(var1, var2, var3)
         ? true
         : !this.bool5 && !this.bool4 && this.noAccountsYetContainerComponent.isFloat16(var1, var2, var3);
   }

   private List<GuiComponentSub5.GlyphLabelRecord> getList27(ExpiredGuiComponent var1) {
      Abstract_ var2 = var1.getAbstract_2();
      ArrayList var4;
      (var4 = new ArrayList())
         .add(
            GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString("\ue7fd", "Copy username", () -> this.handleString18("Username", var2.getString()))
         );
      var4.add(
         GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString(
            "\ue14d", "Copy UUID", () -> this.handleString18("UUID", var2.getUUID() == null ? null : var2.getUUID().toString())
         )
      );
      if (var2.getOfflineAccessTokenEnum() != OfflineAccessTokenEnum.OFFLINE) {
         var4.add(
            GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString(
               "\ue73c", "Copy access token", () -> this.handleString18("Access token", var2.getString3())
            )
         );
         if (var2.getString2() != null) {
            var4.add(
               GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString(
                  "\ue73c", "Copy OAuth refresh token", () -> this.handleString18("Refresh token", var2.getString2())
               )
            );
         }

         var4.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecord());
         var4.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString("\ue5d5", "Refresh tokens", () -> this.handleExpiredGuiComponent(var1)));
      }

      var4.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecord());
      var4.add(GuiComponentSub5.GlyphLabelRecord.getGlyphLabelRecordForString2("\ue872", "Delete", () -> this.handleAbstract_3(var2)));
      return var4;
   }

   private void handleExpiredGuiComponent(ExpiredGuiComponent var1) {
      var1.handleBool27(true);
      this.getAccountManager().getCompletableFuture2(var1.getAbstract_2()).whenComplete((var2, var3) -> MINECRAFT.addScheduledTask(() -> {
         var1.handleBool27(false);
         if (var3 == null) {
            this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Refreshed ").append(var1.getAbstract_2().getString()).toString());
         } else {
            this.lambda239(getStringForThrowable(var3));
         }
      }));
   }

   @Override
   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      if (this.guiComponentSub5.isKeyScancodeRecord3(var1)) {
         return true;
      } else {
         return this.bool5 ? this.usernameGuiComponent.isKeyScancodeRecord3(var1) : this.bool4 && this.addressGuiComponent.isKeyScancodeRecord3(var1);
      }
   }

   private String getString37() {
      Abstract_ var2 = this.getAccountManager().getAbstract_();
      return new StringBuilder().insert(0, "Session: ").append(var2 == null ? MINECRAFT.getSession().getUsername() : var2.getString()).toString();
   }

   public void handleFloat81(float var1) {
      this.float_6 = var1;
   }

   public AddGuiComponent() {
      this.guiComponentSub5 = new GuiComponentSub5();
      this.guiComponentSub2 = new GuiComponentSub2();
      this.cls = new client.onyx.render.misc.Cls(0.0F);
      this.float_6 = 1.0F;
      this.float_4 = 560.0F;
      this.float_2 = 400.0F;
      this.noAccountsYetContainerComponent = new NoAccountsYetContainerComponent(var1x -> {
         if (var1x.getAbstract_2() != this.getAccountManager().getAbstract_()) {
            var1x.handleBool27(true);
            this.getAccountManager().getCompletableFuture3(var1x.getAbstract_2()).whenComplete((var2x, var3x) -> MINECRAFT.addScheduledTask(() -> {
               var1x.handleBool27(false);
               if (var3x == null) {
                  this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Logged in as ").append(var1x.getAbstract_2().getString()).toString());
               } else {
                  this.lambda239(getStringForThrowable(var3x));
               }
            }));
         }
      }, var1x -> this.expiredGuiComponent = var1x);
      this.guiComponentSub42 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.FILLED, "Add", "\ue145", this::lambda232);
      this.guiComponentSub4 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.TEXT, "Proxy settings", "\ue8b8", () -> {
         if (!this.bool5 && !this.bool4) {
            this.guiComponentSub5.run196();
            this.addressGuiComponent.run191();
            this.bool4 = true;
            this.cls.getCls2(1.0F, 300.0F, client.onyx.render.misc.Util.IFACE2);
         }
      });
      this.guiComponentSub43 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.TEXT, "Restore launcher", () -> {
         this.getAccountManager().run169();
         this.guiComponentSub2.handleString20("Restored the launcher account");
      });
      this.guiComponentSub10 = new GuiComponentSub10("\ue5c4", this::lambda246);
      this.usernameGuiComponent.handleConsumer5(var1x -> {
         this.noAccountsYetContainerComponent.run186();
         this.lambda246();
         this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Added ").append(var1x.getString()).toString());
      });
      this.usernameGuiComponent.handleConsumer7(this::lambda239);
      UsernameGuiComponent var1 = this.usernameGuiComponent;
      GuiComponentSub2 var2 = this.guiComponentSub2;
      Object var3 = Objects.requireNonNull(var2);
      Consumer<String> var4 = var2::handleString20;
      var1.handleConsumer6(var4);
      AddressGuiComponent var5 = this.addressGuiComponent;
      GuiComponentSub2 var6 = this.guiComponentSub2;
      Object var7 = Objects.requireNonNull(var6);
      Consumer<String> var8 = var6::handleString20;
      var5.handleConsumer3(var8);
      this.addressGuiComponent.handleConsumer2(this::lambda239);
      this.list.add(this.guiComponentSub42);
      this.list.add(this.noAccountsYetContainerComponent);
      this.list.add(this.guiComponentSub4);
      this.list.add(this.guiComponentSub43);
      this.list.add(this.guiComponentSub10);
      this.list.add(this.usernameGuiComponent);
      this.list.add(this.addressGuiComponent);
   }

   public void lambda232() {
      if (!this.bool5 && !this.bool4) {
         this.guiComponentSub5.run196();
         this.usernameGuiComponent.run203();
         this.bool5 = true;
         this.cls.getCls2(1.0F, 300.0F, client.onyx.render.misc.Util.IFACE2);
      }
   }

   @Override
   protected void run185() {
      float var1 = this.float_ + 46.0F;
      float var3 = this.float_4 - 24.0F;
      this.guiComponentSub10.handleFloat80(this.float_3 + 12.0F, this.getFloat122() - 15.0F, 30.0F, 30.0F);
      this.guiComponentSub42.handleFloat80(this.float_3 + this.float_4 - 12.0F - 82.0F, this.getFloat122() - 15.0F, 82.0F, 30.0F);
      this.noAccountsYetContainerComponent.handleFloat80(this.float_3 + 12.0F, var1, var3, this.float_2 - 46.0F - 34.0F);
      this.usernameGuiComponent.handleFloat80(this.float_3 + 12.0F, var1, var3, this.float_2 - 46.0F - 12.0F);
      this.addressGuiComponent.handleFloat80(this.float_3 + 12.0F, var1, var3, this.float_2 - 46.0F - 12.0F);
      this.guiComponentSub2.handleFloat80(this.float_3, this.float_, this.float_4, this.float_2);
   }

   private void handleCls213(Cls2 var1) {
      Sampler0 var4 = var1.sampler0;
      float var2 = this.float_ + this.float_2 - 17.0F;
      float var3 = this.guiComponentSub43.getFloat142(var4);
      this.guiComponentSub43.handleFloat80(this.float_3 + this.float_4 - 12.0F - var3, var2 - 15.0F, var3, 30.0F);
      this.guiComponentSub43.handleBool23(this.getAccountManager().getAbstract_() != null);
      float var5 = this.guiComponentSub4.getFloat142(var4);
      this.guiComponentSub4.handleFloat80(this.guiComponentSub43.getFloat118() - var5, var2 - 15.0F, var5, 30.0F);
   }

   @Override
   public void handleCls28(Cls2 var1) {
      this.handleCls213(var1);
      this.cls.handleFloat(var1.float_);
      this.bool = this.isFloat15(var1.float_3, var1.float_2);
      float var2;
      if ((var2 = this.cls.getFloat()) < 0.999F) {
         this.guiComponentSub42.handleCls28(var1);
         this.noAccountsYetContainerComponent.handleCls28(var1);
         this.guiComponentSub4.handleCls28(var1);
         this.guiComponentSub43.handleCls28(var1);
      }

      AddGuiComponent var10000;
      label21: {
         if (var2 > 0.001F) {
            this.guiComponentSub10.handleCls28(var1);
            if (this.bool5) {
               this.usernameGuiComponent.handleCls28(var1);
               var10000 = this;
               break label21;
            }

            this.addressGuiComponent.handleCls28(var1);
         }

         var10000 = this;
      }

      if (var10000.expiredGuiComponent != null) {
         this.guiComponentSub5.handleList18(this.getList27(this.expiredGuiComponent), this.expiredGuiComponent.getGuiComponent2(), this, var1.sampler0);
         this.expiredGuiComponent = null;
      }

      this.guiComponentSub5.handleCls28(var1);
      this.guiComponentSub2.handleCls28(var1);
   }

   private float getFloat122() {
      return this.float_ + 23.0F;
   }

   @Override
   public boolean isCodepointModifiersRecord(CodepointModifiersRecord var1) {
      return this.bool5 ? this.usernameGuiComponent.isCodepointModifiersRecord(var1) : this.bool4 && this.addressGuiComponent.isCodepointModifiersRecord(var1);
   }

   @Override
   public void handleCls27(Cls2 var1) {
      Sampler0 var5 = var1.sampler0;
      Sampler0 var10000 = var1.sampler0;
      Sampler0 var10003 = var1.sampler0;
      Sampler0 var10002 = var1.sampler0;
      var5.handleFloat10(this.float_6);
      var10003.handleFloat25(this.float_3, this.float_, this.float_4, this.float_2, 28.0F, 3);
      var10002.run40();
      Util14.handleSampler0(
         var10000,
         this.float_3,
         this.float_,
         this.float_4,
         this.float_2,
         28.0F,
         Util4.getIntForInt2(Util5.getIntForInt(2, var1.getPrimaryOnPrimaryRecord()), this.float_6)
      );
      float var3;
      if ((var3 = this.cls.getFloat()) < 0.999F) {
         float var4;
         float var10004 = var4 = this.float_6 * (1.0F - var3);
         var5.handleOpticalWeightRecord9(
            client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD18,
            "Accounts",
            this.float_3 + 12.0F + 4.0F,
            this.getFloat122(),
            Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurface(), var4)
         );
         var5.handleFloat10(var10004);
         this.guiComponentSub42.handleCls27(var1);
         var5.run40();
         var5.handleFloat10(var4);
         var5.run36();
         var5.handleFloat11(-36.0F * var3, 0.0F);
         this.noAccountsYetContainerComponent.handleCls27(var1);
         this.handleCls214(var1, var5);
         var5.run43();
         var5.run40();
      }

      if (var3 > 0.001F) {
         float var6;
         var5.handleFloat10(var6 = this.float_6 * var3);
         this.guiComponentSub10.handleCls27(var1);
         String var8;
         AddGuiComponent var9;
         if (this.bool5) {
            var8 = "Add account";
            var9 = this;
         } else {
            var8 = "Proxy settings";
            var9 = this;
         }

         var5.handleOpticalWeightRecord9(
            client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD18,
            var8,
            var9.guiComponentSub10.getFloat118() + 30.0F + 6.0F,
            this.getFloat122(),
            var1.getPrimaryOnPrimaryRecord().onSurface()
         );
         var5.run40();
         var5.handleFloat10(var6);
         var5.run36();
         var5.handleFloat11(36.0F * (1.0F - var3), 0.0F);
         if (this.bool5) {
            this.usernameGuiComponent.handleCls27(var1);
            var10000 = var5;
         } else {
            this.addressGuiComponent.handleCls27(var1);
            var10000 = var5;
         }

         var10000.run43();
         var5.run40();
      }

      this.guiComponentSub5.handleCls27(var1);
      this.guiComponentSub2.handleCls27(var1);
   }

   public void handleFloat82(float var1, float var2) {
      this.float_13 = var1;
      this.float_9 = var2;
      this.float_12 = (var1 - this.float_4) / 2.0F;
      this.float_7 = (var2 - this.float_2) / 2.0F;
      this.handleFloat83(this.float_12 + float_8, this.float_7 + float_10);
   }

   @Override
   public boolean isFloat18(float var1, float var2, int var3, float var4, float var5) {
      if (!this.bool6) {
         return false;
      } else {
         this.handleFloat83(var1 - this.float_11, var2 - this.float_5);
         return true;
      }
   }

   public float getFloat121() {
      return this.float_ + this.float_2 / 2.0F;
   }

   private void handleAbstract_3(Abstract_ var1) {
      client.onyx.account.Util.handleUUID(var1.getUUID());
      this.getAccountManager().handleAbstract_(var1);
      this.noAccountsYetContainerComponent.run186();
      this.guiComponentSub2.handleString20(new StringBuilder().insert(0, "Removed ").append(var1.getString()).toString());
   }

   public boolean lambda246() {
      if (!this.bool5 && !this.bool4) {
         return false;
      } else {
         if (this.bool5) {
            this.usernameGuiComponent.run203();
         }

         this.bool5 = false;
         this.bool4 = false;
         this.cls.getCls2(0.0F, 300.0F, client.onyx.render.misc.Util.IFACE2);
         return true;
      }
   }

   private void lambda239(String var1) {
      this.guiComponentSub2.handleString21(var1, "\ue001");
   }
}
