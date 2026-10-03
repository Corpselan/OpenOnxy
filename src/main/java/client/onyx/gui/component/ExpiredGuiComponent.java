package client.onyx.gui.component;

import client.onyx.OnyxClient;
import client.onyx.account.Abstract_;
import client.onyx.account.Util;
import client.onyx.gui.GuiComponent;
import client.onyx.render.Sampler0;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.function.Consumer;

public class ExpiredGuiComponent extends GuiComponent {
   private final Abstract_ abstract_;
   public static final float FLOAT = 56.0F;
   private static final float FLOAT2 = 1.8F;
   private static final float FLOAT3 = 14.0F;
   private final Consumer<ExpiredGuiComponent> consumer;
   private boolean bool4;
   private static final float FLOAT4 = 24.0F;
   private static final float FLOAT5 = 20.0F;
   private final Consumer<ExpiredGuiComponent> consumer2;
   private float float_5;
   private static final float FLOAT6 = 3.0F;
   private static final float FLOAT7 = 10.0F;
   private final client.onyx.gui.Cls cls = new client.onyx.gui.Cls();
   private static final long LONG = 60000L;
   private static final float FLOAT8 = 900.0F;
   private static final float FLOAT9 = 6.0F;
   private static final float FLOAT10 = 11.0F;
   private static final float FLOAT11 = 8.0F;
   private final client.onyx.render.misc.Cls2 cls2 = new client.onyx.render.misc.Cls2(0);
   private static final float FLOAT12 = 32.0F;
   private boolean bool5;
   private static final long LONG2 = 600000L;
   private final GuiComponentSub10 guiComponentSub10;
   private final client.onyx.render.misc.Cls cls3 = new client.onyx.render.misc.Cls(0.0F);
   private static final float FLOAT13 = 12.0F;
   private static final long LONG3 = 3600000L;

   public ExpiredGuiComponent(Abstract_ var1, Consumer<ExpiredGuiComponent> var2, Consumer<ExpiredGuiComponent> var3) {
      this.abstract_ = var1;
      this.float_2 = 56.0F;
      this.consumer = var2;
      this.consumer2 = var3;
      this.guiComponentSub10 = new GuiComponentSub10("\ue5d4", () -> {
         var3.accept(this);
      });
      boolean var5 = this.list.add(this.guiComponentSub10);
   }

   protected void run185() {
      GuiComponentSub10 var1 = this.guiComponentSub10;
      float var2 = this.float_3 + this.float_4 - 30.0F - 8.0F;
      float var4 = this.float_ + (this.float_2 - 30.0F) / 2.0F;
      var1.handleFloat80(var2, var4, 30.0F, 30.0F);
   }

   private int getInt69(PrimaryOnPrimaryRecord var1) {
      long var2;
      if ((var2 = this.abstract_.getLong2() - System.currentTimeMillis()) <= 600000L) {
         return var1.error();
      } else {
         return var2 <= 3600000L ? var1.secondary() : var1.tertiary();
      }
   }

   private boolean isEnabled161() {
      return OnyxClient.accountManager.getAbstract_() == this.abstract_;
   }

   public void handleCls27(client.onyx.gui.Cls2 var1) {
      Sampler0 var11;
      Sampler0 var10001 = var11 = var1.sampler0;
      boolean var5 = this.isEnabled161();
      float var4 = this.float_ + this.float_2 / 2.0F;
      var10001.handleFloat7(this.float_3, this.float_, this.float_4, this.float_2, 16.0F, this.cls2.getInt());
      this.cls.handleSampler0(var11, this.float_3, this.float_, this.float_4, this.float_2, 16.0F, var1.getPrimaryOnPrimaryRecord().onSurface());
      float var3;
      if ((var3 = this.cls3.getFloat()) > 0.01F) {
         var11.handleFloat23(this.float_3 + 11.0F, var4, 3.0F * var3, Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().primary(), var3));
      }

      var3 = var4 - 16.0F;
      var11.handleFloat7(this.float_3 + 20.0F, var3, 32.0F, 32.0F, 4.0F, var1.getPrimaryOnPrimaryRecord().surfaceContainerHighest());
      var11.handleResourceLocation(Util.getResourceLocationForUUID(this.abstract_.getUUID(), this.abstract_.getString()), this.float_3 + 20.0F, var3, 32.0F);
      int var12 = var5 ? var1.getPrimaryOnPrimaryRecord().onSecondaryContainer() : var1.getPrimaryOnPrimaryRecord().onSurface();
      int var13 = var5 ? Util4.getIntForInt2(var1.getPrimaryOnPrimaryRecord().onSecondaryContainer(), 0.72F) : var1.getPrimaryOnPrimaryRecord().onSurfaceVariant();
      String var6;
      float var7 = (var6 = this.getString42()) == null ? 0.0F : var11.getFloat17(Util2.OPTICAL_WEIGHT_RECORD2, var6) + 10.0F;
      float var8 = this.float_3 + 20.0F + 32.0F + 12.0F;
      var7 = this.guiComponentSub10.getFloat118() - 10.0F - var7;
      String var9 = (new StringBuilder()).insert(0, "(").append(this.abstract_.getOfflineAccessTokenEnum().getString()).append(")").toString();
      float var10 = var11.getFloat17(Util2.OPTICAL_WEIGHT_RECORD2, var9);
      String var14 = var11.getString17(Util2.OPTICAL_WEIGHT_RECORD14, this.abstract_.getString(), Math.max(24.0F, var7 - var8 - var10 - 6.0F));
      var11.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD14, var14, var8, var4, var12);
      var11.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD2, var9, var8 + var11.getFloat17(Util2.OPTICAL_WEIGHT_RECORD14, var14) + 6.0F, var4, var13);
      if (var6 != null) {
         var11.handleOpticalWeightRecord6(Util2.OPTICAL_WEIGHT_RECORD2, var6, this.guiComponentSub10.getFloat118() - 10.0F, var4, this.getInt69(var1.getPrimaryOnPrimaryRecord()));
      }

      if (this.bool5) {
         var11.handleFloat20(this.guiComponentSub10.getFloat118() + 15.0F, var4, 7.0F, 1.8F, this.float_5 / 900.0F, var1.getPrimaryOnPrimaryRecord().primary());
      } else {
         super.handleCls27(var1);
      }
   }

   public Abstract_ getAbstract_2() {
      return this.abstract_;
   }

   public GuiComponent getGuiComponent2() {
      return this.guiComponentSub10;
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      if (this.bool5) {
         return this.isFloat15(var1, var2);
      } else if (this.guiComponentSub10.isFloat17(var1, var2, var3)) {
         return true;
      } else if (!this.isFloat15(var1, var2)) {
         return false;
      } else if (var3 == 0) {
         boolean var10000 = this.bool3 = true;
         this.consumer.accept(this);
         return var10000;
      } else if (var3 == 1) {
         this.consumer2.accept(this);
         return true;
      } else {
         return false;
      }
   }

   private String getString42() {
      long var1;
      if ((var1 = this.abstract_.getLong2()) <= 0L) {
         return null;
      } else if ((var1 -= System.currentTimeMillis()) <= 0L) {
         return "Expired";
      } else {
         long var3 = var1 / 3600000L;
         var1 = var1 % 3600000L / 60000L;
         long var5;
         int var10000 = (var5 = var3 - 0L) == 0L ? 0 : (var5 < 0L ? -1 : 1);
         StringBuilder var10002;
         if (var10000 > 0) {
            var10002 = new StringBuilder();
            return var10002.append(var3).append("h").append(var1).append("m").toString();
         } else {
            var10002 = new StringBuilder();
            return var10002.append(Math.max(1L, var1)).append("m").toString();
         }
      }
   }

   public boolean isFloat19(float var1, float var2, int var3) {
      this.bool3 = false;
      return super.isFloat19(var1, var2, var3);
   }

   public void handleBool27(boolean var1) {
      this.bool5 = var1;
   }

   public void handleCls28(client.onyx.gui.Cls2 var1) {
      super.handleCls28(var1);
      boolean var2;
      int var3 = (var2 = this.isEnabled161()) ? var1.getPrimaryOnPrimaryRecord().secondaryContainer() : var1.getPrimaryOnPrimaryRecord().surfaceContainerHigh();
      if (!this.bool4) {
         this.bool4 = true;
         this.cls2.getCls2(var3);
         this.cls3.getCls(var2 ? 1.0F : 0.0F);
      }

      this.cls2.getCls22(var3, 250.0F, client.onyx.render.misc.Util.IFACE6);
      this.cls2.handleFloat(var1.float_);
      this.cls3.getCls2(var2 ? 1.0F : 0.0F, 250.0F, client.onyx.render.misc.Util.IFACE6);
      this.cls3.handleFloat(var1.float_);
      client.onyx.gui.Cls var10000 = this.cls;
      float var10001 = var1.float_;
      boolean var10002;
      ExpiredGuiComponent var10003;
      if (this.bool && !this.bool5 && !this.guiComponentSub10.isEnabled146()) {
         var10002 = true;
         var10003 = this;
      } else {
         var10002 = false;
         var10003 = this;
      }

      var10000.handleFloat(var10001, var10002, var10003.bool3);
      if (this.bool5) {
         float var6 = (this.float_5 + var1.float_) % 900.0F;
         this.float_5 = var6;
      }

   }
}
