package client.onyx.gui.component;

import client.onyx.OnyxClient;
import client.onyx.account.Abstract_;
import client.onyx.account.MicrosoftAccount;
import client.onyx.account.TokenAccount;
import client.onyx.account.auth.LocalLoginServer;
import client.onyx.account.auth.MicrosoftAuth;
import client.onyx.account.auth.OnyxException;
import client.onyx.gui.GuiComponent;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.function.Consumer;
import net.minecraft.client.gui.GuiScreen;

public class UsernameGuiComponent extends GuiComponent {
   private static final int INT = 0;
   private String string;
   private static final int INT2 = 1;
   private Consumer<String> consumer;
   private static final float FLOAT = 8.0F;
   private static final float FLOAT2 = 10.0F;
   private LocalLoginServer localLoginServer;
   private Consumer<String> consumer2;
   private final GuiComponentSub9 guiComponentSub9;
   private static final float FLOAT3 = 10.0F;
   private GuiComponentSub4 guiComponentSub4;
   private GuiComponentSub4 guiComponentSub42;
   private final GuiComponentSub7 guiComponentSub7;
   private boolean bool4;
   private GuiComponentSub4 guiComponentSub43;
   private static final float FLOAT4 = 16.0F;
   private GuiComponentSub8 guiComponentSub8;
   private static final int INT3 = 3;
   private GuiComponentSub4 guiComponentSub44;
   private static final float FLOAT5 = 14.0F;
   private GuiComponentSub8 guiComponentSub82;
   private static final float FLOAT6 = 96.0F;
   private static final float FLOAT7 = 14.0F;
   private final GuiComponentSub4 guiComponentSub45;
   private GuiComponentSub8 guiComponentSub83;
   private static final String[] STRING_ARRAY;
   private Consumer<Abstract_> consumer3;
   private static final int INT4 = 2;

   static {
      String[] var0 = new String[]{"Offline", "Access", "Refresh", "Microsoft"};
      STRING_ARRAY = var0;
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.guiComponentSub9.isFloat17(var1, var2, var3)) {
         return true;
      } else {
         switch(this.getInt74()) {
         case 0:

            return this.guiComponentSub83.isFloat17(var1, var2, var3) || this.guiComponentSub7.isFloat17(var1, var2, var3) || this.guiComponentSub43.isFloat17(var1, var2, var3);
         case 1:
            if (!this.guiComponentSub8.isFloat17(var1, var2, var3) && !this.guiComponentSub44.isFloat17(var1, var2, var3)) {
               return false;
            }

            return true;
         case 2:
            if (!this.guiComponentSub82.isFloat17(var1, var2, var3) && !this.guiComponentSub42.isFloat17(var1, var2, var3)) {
               return false;
            }

            return true;
         default:
            if (!this.guiComponentSub4.isFloat17(var1, var2, var3) && !this.guiComponentSub45.isFloat17(var1, var2, var3)) {
               return false;
            } else {
               return true;
            }
         }
      }
   }

   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      switch(this.getInt74()) {
      case 0:

         return this.guiComponentSub83.isKeyScancodeRecord3(var1);
      case 1:
         return this.guiComponentSub8.isKeyScancodeRecord3(var1);
      case 2:
         return this.guiComponentSub82.isKeyScancodeRecord3(var1);
      default:
         return false;
      }
   }

   private void handleCls231(client.onyx.gui.Cls2 var1, Sampler0 var2, String var3, float var4) {
      var2.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD15, var2.getString17(Util2.OPTICAL_WEIGHT_RECORD15, var3, this.float_4), this.float_3, var4 + 8.0F + 7.0F, Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.9F));
   }

   private void handleString28(String var1) {
      if (this.consumer != null) {
         this.consumer.accept(var1);
      }

   }

   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var2 = var1.sampler0;
      this.guiComponentSub9.handleCls27(var1);
      switch(this.getInt74()) {
      case 0:

         this.handleCls233(var1, var2);
         return;
      case 1:
         this.handleCls230(var1, var2);
         return;
      case 2:
         this.handleCls232(var1, var2);
         return;
      default:
         this.handleCls229(var1, var2);
      }
   }

   private void handleCls233(client.onyx.gui.Cls2 var1, Sampler0 var2) {
      this.guiComponentSub83.handleCls27(var1);
      this.guiComponentSub7.handleCls27(var1);
      this.guiComponentSub43.handleCls27(var1);
      var2.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD15, "Resolve premium UUID", this.guiComponentSub7.getFloat118() + 38.0F + 10.0F, this.guiComponentSub7.getFloat115() + 11.0F, var1.getPrimaryOnPrimaryRecord().onSurface());
      this.handleCls231(var1, var2, "Looks the name up on Mojang so the real skin and UUID are used.", this.guiComponentSub43.getFloat115() + 30.0F);
   }

   public boolean isFloat19(float var1, float var2, int var3) {
      switch(this.getInt74()) {
      case 0:

         return this.guiComponentSub7.isFloat19(var1, var2, var3) | this.guiComponentSub43.isFloat19(var1, var2, var3);
      case 1:
         return this.guiComponentSub44.isFloat19(var1, var2, var3);
      case 2:
         return this.guiComponentSub42.isFloat19(var1, var2, var3);
      default:
         return this.guiComponentSub4.isFloat19(var1, var2, var3) | this.guiComponentSub45.isFloat19(var1, var2, var3);
      }
   }

   public boolean isCodepointModifiersRecord(CodepointModifiersRecord var1) {
      switch(this.getInt74()) {
      case 0:

         return this.guiComponentSub83.isCodepointModifiersRecord(var1);
      case 1:
         return this.guiComponentSub8.isCodepointModifiersRecord(var1);
      case 2:
         return this.guiComponentSub82.isCodepointModifiersRecord(var1);
      default:
         return false;
      }
   }

   public void handleConsumer5(Consumer<Abstract_> var1) {
      this.consumer3 = var1;
   }

   private void handleAbstract_4(Abstract_ var1) {
      OnyxClient.accountManager.handleAbstract_2(var1);
      if (this.consumer3 != null) {
         this.consumer3.accept(var1);
      }

   }

   public UsernameGuiComponent() {
      GuiComponentSub9 var1 = new GuiComponentSub9(STRING_ARRAY, (var1x) -> {
         this.guiComponentSub83.handleBool24(false);
         this.guiComponentSub8.handleBool24(false);
         this.guiComponentSub82.handleBool24(false);
         if (var1x != 3) {
            this.run204();
         }

      });
      this.guiComponentSub9 = var1;
      this.guiComponentSub83 = new GuiComponentSub8("Username");
      this.guiComponentSub8 = new GuiComponentSub8("Minecraft access token");
      this.guiComponentSub82 = new GuiComponentSub8("Microsoft OAuth refresh token");
      this.guiComponentSub7 = new GuiComponentSub7(() -> {
         return this.bool4;
      }, (var1x) -> {
         this.bool4 = var1x;
      });
      this.guiComponentSub43 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.FILLED, "Add", () -> {
         String var2;
         if ((var2 = this.guiComponentSub83.getString39().trim()).isEmpty()) {
            this.handleString28("Enter a username");
         } else {
            client.onyx.account.Cls var3;
            (var3 = new client.onyx.account.Cls(var2)).handleBool(this.bool4);
            if (!this.bool4) {
               this.handleAbstract_4(var3);
            } else {
               this.guiComponentSub43.handleBool26(true);
               client.onyx.util.Util4.handleRunnable(() -> {
                  try {
                     var3.run();
                  } catch (OnyxException var2e) {
                  }

                  MINECRAFT.addScheduledTask(() -> {
                     this.guiComponentSub43.handleBool26(false);
                     this.handleAbstract_4(var3);
                  });
               });
            }
         }
      });
      this.guiComponentSub44 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.FILLED, "Add", () -> {
         String var2;
         if ((var2 = this.guiComponentSub8.getString39().trim()).isEmpty()) {
            this.handleString28("Paste an access token");
         } else {
            this.guiComponentSub44.handleBool26(true);
            client.onyx.util.Util4.handleRunnable(() -> {
               TokenAccount var4;
               try {
                  var4 = TokenAccount.getTokenAccountForString(var2);
               } catch (OnyxException var3) {
                  MINECRAFT.addScheduledTask(() -> {
                     this.guiComponentSub44.handleBool26(false);
                     this.handleString28(var3.getMessage());
                  });
                  return;
               }

               MINECRAFT.addScheduledTask(() -> {
                  this.guiComponentSub44.handleBool26(false);
                  this.handleAbstract_4(var4);
               });
            });
         }
      });
      this.guiComponentSub42 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.FILLED, "Add", () -> {
         String var2;
         if ((var2 = this.guiComponentSub82.getString39().trim()).isEmpty()) {
            this.handleString28("Paste a refresh token");
         } else {
            this.guiComponentSub42.handleBool26(true);
            client.onyx.util.Util4.handleRunnable(() -> {
               MicrosoftAccount var4;
               try {
                  var4 = MicrosoftAccount.getMicrosoftAccountForString(var2);
               } catch (OnyxException var3) {
                  MINECRAFT.addScheduledTask(() -> {
                     this.guiComponentSub42.handleBool26(false);
                     this.handleString28(var3.getMessage());
                  });
                  return;
               }

               MINECRAFT.addScheduledTask(() -> {
                  this.guiComponentSub42.handleBool26(false);
                  this.handleAbstract_4(var4);
               });
            });
         }
      });
      this.guiComponentSub4 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.FILLED, "Sign in with Microsoft", "\ue89e", () -> {
         if (this.localLoginServer != null) {
            this.run204();
         } else {
            try {
               LocalLoginServer var4 = LocalLoginServer.getLocalLoginServerForConsumer((tokens) -> {
                  this.run204();
                  this.handleAbstract_4(MicrosoftAccount.getMicrosoftAccountForMicrosoftTokens(tokens));
               }, (error) -> {
                  this.run204();
                  this.handleString28(error);
               });
               this.localLoginServer = var4;
            } catch (OnyxException var5) {
               this.handleString28(var5.getMessage());
               return;
            }

            this.localLoginServer.run173();
            this.guiComponentSub4.handleString24("Cancel");
            this.guiComponentSub4.handleString25("\ue5cd");
            this.string = "Waiting for the browser…";
         }
      });
      this.guiComponentSub45 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.TEXT, "Copy link", () -> {
         if (this.localLoginServer == null) {
            this.handleString28("Start the sign-in first");
         } else {
            GuiScreen.setClipboardString(this.localLoginServer.getString35());
            if (this.consumer2 != null) {
               this.consumer2.accept("Sign-in link copied");
            }

         }
      });
      this.guiComponentSub8.handleBool25(true);
      this.guiComponentSub82.handleBool25(true);
      this.guiComponentSub83.handleRunnable(() -> {
         String var2;
         if ((var2 = this.guiComponentSub83.getString39().trim()).isEmpty()) {
            this.handleString28("Enter a username");
         } else {
            client.onyx.account.Cls var3;
            (var3 = new client.onyx.account.Cls(var2)).handleBool(this.bool4);
            if (!this.bool4) {
               this.handleAbstract_4(var3);
            } else {
               this.guiComponentSub43.handleBool26(true);
               client.onyx.util.Util4.handleRunnable(() -> {
                  try {
                     var3.run();
                  } catch (OnyxException var2e) {
                  }

                  MINECRAFT.addScheduledTask(() -> {
                     this.guiComponentSub43.handleBool26(false);
                     this.handleAbstract_4(var3);
                  });
               });
            }
         }
      });
      this.guiComponentSub8.handleRunnable(() -> {
         String var2;
         if ((var2 = this.guiComponentSub8.getString39().trim()).isEmpty()) {
            this.handleString28("Paste an access token");
         } else {
            this.guiComponentSub44.handleBool26(true);
            client.onyx.util.Util4.handleRunnable(() -> {
               TokenAccount var4;
               try {
                  var4 = TokenAccount.getTokenAccountForString(var2);
               } catch (OnyxException var3) {
                  MINECRAFT.addScheduledTask(() -> {
                     this.guiComponentSub44.handleBool26(false);
                     this.handleString28(var3.getMessage());
                  });
                  return;
               }

               MINECRAFT.addScheduledTask(() -> {
                  this.guiComponentSub44.handleBool26(false);
                  this.handleAbstract_4(var4);
               });
            });
         }
      });
      this.guiComponentSub82.handleRunnable(() -> {
         String var2;
         if ((var2 = this.guiComponentSub82.getString39().trim()).isEmpty()) {
            this.handleString28("Paste a refresh token");
         } else {
            this.guiComponentSub42.handleBool26(true);
            client.onyx.util.Util4.handleRunnable(() -> {
               MicrosoftAccount var4;
               try {
                  var4 = MicrosoftAccount.getMicrosoftAccountForString(var2);
               } catch (OnyxException var3) {
                  MINECRAFT.addScheduledTask(() -> {
                     this.guiComponentSub42.handleBool26(false);
                     this.handleString28(var3.getMessage());
                  });
                  return;
               }

               MINECRAFT.addScheduledTask(() -> {
                  this.guiComponentSub42.handleBool26(false);
                  this.handleAbstract_4(var4);
               });
            });
         }
      });
      this.list.add(this.guiComponentSub9);
      this.list.add(this.guiComponentSub83);
      this.list.add(this.guiComponentSub7);
      this.list.add(this.guiComponentSub43);
      this.list.add(this.guiComponentSub8);
      this.list.add(this.guiComponentSub44);
      this.list.add(this.guiComponentSub82);
      this.list.add(this.guiComponentSub42);
      this.list.add(this.guiComponentSub4);
      this.list.add(this.guiComponentSub45);
   }

   private void handleCls228(client.onyx.gui.Cls2 var1) {
      float var2 = this.float_ + 30.0F + 14.0F;
      float var3 = this.guiComponentSub4.getFloat142(var1.sampler0);
      float var4 = this.guiComponentSub45.getFloat142(var1.sampler0);
      this.guiComponentSub4.handleFloat80(this.float_3, var2, var3, 30.0F);
      this.guiComponentSub45.handleFloat80(this.float_3 + var3 + 10.0F, var2, var4, 30.0F);
      this.guiComponentSub45.handleBool23(this.localLoginServer != null);
   }

   private void run204() {
      if (this.localLoginServer != null) {
         this.localLoginServer.run171();
      }

      this.localLoginServer = null;
      this.string = null;
      this.guiComponentSub4.handleString24("Sign in with Microsoft");
      this.guiComponentSub4.handleString25("\ue89e");
   }

   public boolean isEnabled164() {
      return this.guiComponentSub83.isEnabled154() || this.guiComponentSub8.isEnabled154() || this.guiComponentSub82.isEnabled154();
   }

   private void handleCls229(client.onyx.gui.Cls2 var1, Sampler0 var2) {
      this.guiComponentSub4.handleCls27(var1);
      this.guiComponentSub45.handleCls27(var1);
      float var3 = this.guiComponentSub4.getFloat115() + 30.0F;
      if (!MicrosoftAuth.isEnabled()) {
         float var4 = var3 + 8.0F + 7.0F;
         var2.handleString6("\ue001", this.float_3 + 8.0F, var4, 16.0F, var1.getPrimaryOnPrimaryRecord().error());
         var2.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD15, "No Azure client id is configured for this build.", this.float_3 + 16.0F + 10.0F, var4, var1.getPrimaryOnPrimaryRecord().error());
      } else {
         if (this.string != null) {
            var2.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD15, this.string, this.float_3, var3 + 8.0F + 7.0F, var1.getPrimaryOnPrimaryRecord().primary());
         }

         this.handleCls231(var1, var2, "Opens your browser. Use Copy link if it does not open by itself.", var3 + (this.string == null ? 0.0F : 14.0F));
      }
   }

   public void handleConsumer7(Consumer<String> var1) {
      this.consumer = var1;
   }

   private int getInt74() {
      return this.guiComponentSub9.getInt70();
   }

   private void handleCls232(client.onyx.gui.Cls2 var1, Sampler0 var2) {
      this.guiComponentSub82.handleCls27(var1);
      this.guiComponentSub42.handleCls27(var1);
      this.handleCls231(var1, var2, "The msaartifacts refresh token from a launcher. Works without an Azure app.", this.guiComponentSub42.getFloat115() + 30.0F);
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      this.handleCls228(var1);
      this.bool = this.isFloat15(var1.float_3, var1.float_2);
      this.guiComponentSub9.handleCls28(var1);
      switch(this.getInt74()) {
      case 0:

         this.guiComponentSub83.handleCls28(var1);
         this.guiComponentSub7.handleCls28(var1);
         this.guiComponentSub43.handleCls28(var1);
         return;
      case 1:
         this.guiComponentSub8.handleCls28(var1);
         this.guiComponentSub44.handleCls28(var1);
         return;
      case 2:
         this.guiComponentSub82.handleCls28(var1);
         this.guiComponentSub42.handleCls28(var1);
         return;
      default:
         this.guiComponentSub4.handleCls28(var1);
         this.guiComponentSub45.handleCls28(var1);
      }
   }

   public void run203() {
      this.run204();
      this.guiComponentSub83.handleString23("");
      this.guiComponentSub8.handleString23("");
      this.guiComponentSub82.handleString23("");
      this.guiComponentSub83.handleBool24(false);
      this.guiComponentSub8.handleBool24(false);
      this.guiComponentSub82.handleBool24(false);
      this.string = null;
   }

   public void handleConsumer6(Consumer<String> var1) {
      this.consumer2 = var1;
   }

   protected void run185() {
      this.guiComponentSub9.handleFloat80(this.float_3, this.float_, this.float_4, 30.0F);
      float var2 = this.float_ + 30.0F + 14.0F;
      this.guiComponentSub83.handleFloat80(this.float_3, var2, this.float_4, 40.0F);
      this.guiComponentSub8.handleFloat80(this.float_3, var2, this.float_4, 40.0F);
      this.guiComponentSub82.handleFloat80(this.float_3, var2, this.float_4, 40.0F);
      var2 = var2 + 40.0F + 10.0F;
      this.guiComponentSub7.handleFloat80(this.float_3, var2 + 4.0F, 38.0F, 22.0F);
      this.guiComponentSub43.handleFloat80(this.float_3 + this.float_4 - 96.0F, var2, 96.0F, 30.0F);
      this.guiComponentSub44.handleFloat80(this.float_3 + this.float_4 - 96.0F, var2, 96.0F, 30.0F);
      this.guiComponentSub42.handleFloat80(this.float_3 + this.float_4 - 96.0F, var2, 96.0F, 30.0F);
   }

   private void handleCls230(client.onyx.gui.Cls2 var1, Sampler0 var2) {
      this.guiComponentSub8.handleCls27(var1);
      this.guiComponentSub44.handleCls27(var1);
      this.handleCls231(var1, var2, "A Minecraft session token from a launcher. Expires in ~24h and cannot be renewed.", this.guiComponentSub44.getFloat115() + 30.0F);
   }
}
