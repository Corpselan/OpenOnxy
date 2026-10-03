package client.onyx.gui.component;

import client.onyx.OnyxClient;
import client.onyx.account.ProxyConfig;
import client.onyx.account.auth.HttpUtil;
import client.onyx.account.auth.OnyxException;
import client.onyx.gui.GuiComponent;
import client.onyx.gui.Util2;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import client.onyx.util.Util4;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public class AddressGuiComponent extends GuiComponent {
   private GuiComponentSub4 guiComponentSub4;
   private static final float FLOAT = 14.0F;
   private Consumer<String> consumer;
   private static final float FLOAT2 = 10.0F;
   private boolean bool4;
   private static final float FLOAT3 = 144.0F;
   private boolean bool5;
   private final GuiComponentSub9 guiComponentSub9;
   private static final float FLOAT4 = 28.0F;
   private final GuiComponentSub4 guiComponentSub42;
   private static final float FLOAT5 = 88.0F;
   private final GuiComponentSub8 guiComponentSub8;
   private final GuiComponentSub8 guiComponentSub82;
   private final GuiComponentSub8 guiComponentSub83;
   private static final int INT = 8000;
   private final GuiComponentSub7 guiComponentSub7;
   private Consumer<String> consumer2;
   private static final String STRING = "https://api.minecraftservices.com/publickeys";
   private static final float FLOAT6 = 10.0F;
   private final GuiComponentSub7 guiComponentSub72;
   private static final float FLOAT7 = 8.0F;

   public static float getFloat134() {
      return 308.0F;
   }

   private void run192() {
      OnyxClient.accountManager
         .getProxyConfig()
         .handleProxyProtocol(
            this.getProxyProtocol(),
            this.bool5,
            this.bool4,
            this.guiComponentSub83.getString39(),
            this.guiComponentSub82.getString39(),
            this.guiComponentSub8.getString39()
         );
      OnyxClient.accountManager.isEnabled135();
   }

   @Override
   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      if (super.isKeyScancodeRecord3(var1)) {
         return true;
      } else if (Util2.isKeyScancodeRecord9(var1)) {
         this.lambda262();
         return true;
      } else {
         return var1.key() == 15 ? this.isBool15(var1.isEnabled3()) : false;
      }
   }

   public void handleConsumer3(Consumer<String> var1) {
      this.consumer2 = var1;
   }

   public AddressGuiComponent() {
      BooleanSupplier var1 = () -> this.bool5;
      GuiComponentSub7 var2 = new GuiComponentSub7(var1, var1x -> this.bool5 = var1x);
      this.guiComponentSub72 = var2;
      BooleanSupplier var3 = () -> this.bool4;
      GuiComponentSub7 var4 = new GuiComponentSub7(var3, var1x -> this.bool4 = var1x);
      this.guiComponentSub7 = var4;
      String[] var5 = new String[]{"SOCKS5", "HTTP/HTTPS"};
      GuiComponentSub9 var6 = new GuiComponentSub9(var5, var1x -> {
         if (var1x < 0 || var1x >= ProxyConfig.ProxyProtocol.values().length) {
            ;
         }
      });
      this.guiComponentSub9 = var6;
      this.guiComponentSub83 = new GuiComponentSub8("Address");
      this.guiComponentSub82 = new GuiComponentSub8("Username");
      this.guiComponentSub8 = new GuiComponentSub8("Password");
      this.guiComponentSub4 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.OUTLINED, "Test connection", () -> {
         if (!this.bool5) {
            if (this.consumer != null) {
               this.consumer.accept("Enable a proxy before testing");
            }
         } else {
            try {
               this.run192();
            } catch (IllegalArgumentException var3x) {
               if (this.consumer != null) {
                  this.consumer.accept(var3x.getMessage());
               }

               return;
            }

            this.guiComponentSub4.handleBool26(true);
            Util4.handleRunnable(() -> {
               String var1x = null;

               try {
                  HttpUtil.HttpResponse var3xx;
                  if (!(var3xx = HttpUtil.getHttpResponseForString("https://api.minecraftservices.com/publickeys", 8000)).isEnabled()) {
                     var1x = new StringBuilder().insert(0, "Proxy test returned HTTP ").append(var3xx.status()).toString();
                  }
               } catch (RuntimeException | OnyxException var4x) {
                  var1x = var4x.getMessage() == null ? var4x.toString() : var4x.getMessage();
               }

               String var5x = var1x;
               MINECRAFT.addScheduledTask(() -> {
                  this.guiComponentSub4.handleBool26(false);
                  if (var5x == null) {
                     if (this.consumer2 != null) {
                        this.consumer2.accept("Proxy connection verified");
                        return;
                     }
                  } else if (this.consumer != null) {
                     this.consumer.accept(var5x);
                  }
               });
            });
         }
      });
      this.guiComponentSub42 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.FILLED, "Save", this::lambda262);
      this.guiComponentSub8.handleBool25(true);
      this.guiComponentSub83.handleRunnable(this::lambda262);
      this.guiComponentSub82.handleRunnable(this::lambda262);
      this.guiComponentSub8.handleRunnable(this::lambda262);
      this.list.add(this.guiComponentSub72);
      this.list.add(this.guiComponentSub7);
      this.list.add(this.guiComponentSub9);
      this.list.add(this.guiComponentSub83);
      this.list.add(this.guiComponentSub82);
      this.list.add(this.guiComponentSub8);
      this.list.add(this.guiComponentSub4);
      this.list.add(this.guiComponentSub42);
   }

   public void handleConsumer2(Consumer<String> var1) {
      this.consumer = var1;
   }

   private ProxyConfig.ProxyProtocol getProxyProtocol() {
      return ProxyConfig.ProxyProtocol.values()[this.guiComponentSub9.getInt70()];
   }

   public void run191() {
      ProxyConfig var2 = OnyxClient.accountManager.getProxyConfig();
      this.bool5 = var2.isEnabled2();
      this.bool4 = var2.isEnabled();
      this.guiComponentSub9.handleInt19(var2.getProxyProtocol().ordinal());
      this.guiComponentSub83.handleString23(var2.getString2());
      this.guiComponentSub82.handleString23(var2.getString());
      this.guiComponentSub8.handleString23(var2.getString4());
      this.guiComponentSub83.handleBool24(false);
      this.guiComponentSub82.handleBool24(false);
      this.guiComponentSub8.handleBool24(false);
   }

   public void lambda262() {
      try {
         this.run192();
         OnyxClient.accountManager.getCompletableFuture().whenComplete((var1, var2) -> MINECRAFT.addScheduledTask(() -> {
            if (var2 != null) {
               if (this.consumer != null) {
                  this.consumer.accept(var2.getCause() == null ? var2.getMessage() : var2.getCause().getMessage());
               }
            } else {
               if (this.consumer2 != null) {
                  this.consumer2.accept(this.bool5 ? "Proxy settings applied" : "Proxy disabled");
               }
            }
         }));
      } catch (IllegalArgumentException var3) {
         if (this.consumer != null) {
            this.consumer.accept(var3.getMessage());
         }
      }
   }

   @Override
   protected void run185() {
      float var2 = this.float_;
      this.guiComponentSub72.handleFloat80(this.float_3, var2 + 3.0F, 38.0F, 22.0F);
      var2 += 38.0F;
      this.guiComponentSub7.handleFloat80(this.float_3, var2 + 3.0F, 38.0F, 22.0F);
      var2 += 42.0F;
      this.guiComponentSub9.handleFloat80(this.float_3, var2, this.float_4, 30.0F);
      var2 += 44.0F;
      this.guiComponentSub83.handleFloat80(this.float_3, var2, this.float_4, 40.0F);
      var2 += 50.0F;
      this.guiComponentSub82.handleFloat80(this.float_3, var2, this.float_4, 40.0F);
      var2 += 50.0F;
      this.guiComponentSub8.handleFloat80(this.float_3, var2, this.float_4, 40.0F);
      var2 += 54.0F;
      this.guiComponentSub42.handleFloat80(this.float_3 + this.float_4 - 88.0F, var2, 88.0F, 30.0F);
      this.guiComponentSub4.handleFloat80(this.guiComponentSub42.getFloat118() - 8.0F - 144.0F, var2, 144.0F, 30.0F);
   }

   @Override
   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var2 = var1.sampler0;
      var2.handleOpticalWeightRecord9(
         client.onyx.theme.Util2.getOpticalWeightRecord4(),
         "Use proxy",
         this.guiComponentSub72.getFloat118() + 38.0F + 10.0F,
         this.guiComponentSub72.getFloat115() + 11.0F,
         var1.getPrimaryOnPrimaryRecord().onSurface()
      );
      var2.handleOpticalWeightRecord9(
         client.onyx.theme.Util2.getOpticalWeightRecord4(),
         "Use for account login",
         this.guiComponentSub7.getFloat118() + 38.0F + 10.0F,
         this.guiComponentSub7.getFloat115() + 11.0F,
         var1.getPrimaryOnPrimaryRecord().onSurfaceVariant()
      );
      super.handleCls27(var1);
   }

   private boolean isBool15(boolean var1) {
      GuiComponentSub8[] var7 = new GuiComponentSub8[]{this.guiComponentSub83, this.guiComponentSub82, this.guiComponentSub8};
      GuiComponentSub8[] var2 = var7;
      int var4 = -1;

      int var6;
      for (int var10000 = var6 = 0; var10000 < var2.length; var10000 = ++var6) {
         if (var2[var6].isEnabled154()) {
            var4 = var6;
         }
      }

      var6 = Math.floorMod(var4 + (var1 ? -1 : 1), var2.length);
      GuiComponentSub8[] var8 = var2;
      var4 = var2.length;

      int var5;
      for (int var11 = var5 = 0; var11 < var4; var11 = var5) {
         var8[var5++].handleBool24(false);
      }

      var2[var6].handleBool24(true);
      var2[var6].run195();
      return true;
   }
}
