package client.onyx.gui;

import client.onyx.OnyxClient;
import client.onyx.gui.component.GuiComponentSub4;
import client.onyx.module.render.NamesModule;
import client.onyx.render.Sampler0;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.theme.Util4;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;

public class Reset2 extends GuiScreen {
   private float float_;
   private final Sampler0 sampler0;
   private static final float FLOAT = 3.0F;
   private static final float FLOAT2 = 16.0F;
   private static final int INT = 2;
   private static final int INT2 = 0;
   private static final float FLOAT3 = 16.0F;
   private final client.onyx.render.misc.Cls cls;
   private final NamesModule namesModule;
   private float float_2;
   private long long_;
   private float[] floatArray;
   private int int_;
   private final GuiComponentSub4 guiComponentSub4;
   private float float_3;
   private float float_4;
   private final client.onyx.render.misc.Cls cls2;
   private final client.onyx.render.misc.Cls cls3;
   private static final float FLOAT4 = 100.0F;
   private final client.onyx.render.misc.Cls cls4;
   private GuiComponentSub4 guiComponentSub42;
   private float float_5;
   private final GuiComponentSub4 guiComponentSub43;
   private float[] floatArray2;
   private float float_6;
   private final GuiScreen guiScreen;
   private float float_7;
   private static final int INT3 = 1;
   private boolean bool;

   @Override
   public boolean doesGuiPauseGame() {
      return false;
   }

   private void handleFloatArray(float[] var1, boolean var2, String var3) {
      int var4 = var2 ? Util4.getPrimaryOnPrimaryRecord().primary() : Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurface(), 0.4F);
      float var10001 = var1[0] - 3.0F;
      float var10002 = var1[1] - 3.0F;
      float var10003 = var1[2] + 6.0F;
      float var10004 = var1[3] + 6.0F;
      float var10006;
      int var10007;
      if (var2) {
         var10006 = 1.5F;
         var10007 = var4;
      } else {
         var10006 = 1.0F;
         var10007 = var4;
      }

      this.sampler0.handleFloat18(var10001, var10002, var10003, var10004, 8.0F, var10006, var10007);
      if (var2) {
         this.sampler0
            .handleOpticalWeightRecord3(
               client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2,
               var3,
               var1[0] + var1[2] / 2.0F,
               var1[1] - 3.0F - 3.0F - client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2.lineHeight(),
               var4
            );
      }
   }

   private void handleInt5(int var1, int var2) {
      float var7 = this.namesModule.getFloat37(this.float_5);
      List var10;
      List var5 = (var10 = this.namesModule.getList18(this.mc.thePlayer)).isEmpty() ? this.namesModule.getList14() : var10;
      NamesModule.TypeCenterXRecord var21 = null;
      NamesModule.TypeCenterXRecord var6 = null;
      float var3 = this.float_3 + this.float_2 / 2.0F;
      Iterator var15 = this.namesModule
         .getList15(this.sampler0, this.mc.thePlayer, this.float_3, this.float_6, this.float_2, this.float_5, var3, var3, true)
         .iterator();

      while (var15.hasNext()) {
         NamesModule.TypeCenterXRecord var8;
         if ((var8 = (NamesModule.TypeCenterXRecord)var15.next()).type() == 0) {
            var21 = var8;
         } else {
            var6 = var8;
         }
      }

      this.floatArray2 = this.floatArray = null;
      if (var21 != null) {
         boolean var16 = !this.bool || this.namesModule.valueSettingSub94.isEnabled17() && this.int_ == 1;
         float var18 = this.getFloat2(this.cls4, var21.centerX(), var16);
         float var9 = this.getFloat2(this.cls, var21.centerY(), var16);
         this.namesModule.handleSampler08(this.sampler0, this.mc.thePlayer, var18, var9, var7);
         float[] var10001 = new float[4];
         boolean var10003 = true;
         var10001[0] = var18 - var21.width() / 2.0F;
         var10001[1] = var9 - var21.height() / 2.0F;
         var10001[2] = var21.width();
         var10001[3] = var21.height();
         this.floatArray = var10001;
      }

      if (var6 != null) {
         boolean var17 = !this.bool || this.namesModule.valueSettingSub94.isEnabled17() && this.int_ == 2;
         float var19 = this.getFloat2(this.cls3, var6.centerX(), var17);
         float var20 = this.getFloat2(this.cls2, var6.centerY(), var17);
         this.namesModule.handleSampler010(this.sampler0, this.mc.thePlayer, var19, var20, var7, var5, var6.horizontal());
         float[] var22 = new float[4];
         boolean var23 = true;
         var22[0] = var19 - var6.width() / 2.0F;
         var22[1] = var20 - var6.height() / 2.0F;
         var22[2] = var6.width();
         var22[3] = var6.height();
         this.floatArray2 = var22;
      }

      this.bool = true;
      if (this.floatArray != null) {
         float[] var11 = this.floatArray;
         boolean var12 = this.isInt(1, this.floatArray, var1, var2);
         this.handleFloatArray(var11, var12, "Name");
      }

      if (this.floatArray2 != null) {
         float[] var13 = this.floatArray2;
         boolean var14 = this.isInt(2, this.floatArray2, var1, var2);
         this.handleFloatArray(var13, var14, "Equipment");
      }

      if (this.int_ != 0 && !this.namesModule.valueSettingSub94.isEnabled17()) {
         this.run2();
      }
   }

   public Reset2(GuiScreen var1) {
      this.namesModule = OnyxClient.cls.namesModule;
      this.sampler0 = new Sampler0();
      this.guiComponentSub4 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.OUTLINED, "Reset", () -> {
         this.namesModule.valueSettingSub105.run5();
         this.namesModule.valueSettingSub107.run5();
         this.namesModule.valueSettingSub102.run5();
         this.namesModule.valueSettingSub106.run5();
         this.namesModule.valueSettingSub104.run5();
         this.namesModule.valueSettingSub103.run5();
         this.namesModule.valueSettingSub92.handleObject2(false);
         this.namesModule.valueSettingSub94.handleObject2(false);
         this.guiComponentSub42.handleString24("Unlock");
      });
      this.guiComponentSub42 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.TONAL, "Unlock", () -> {
         this.namesModule.valueSettingSub94.run10();
         this.guiComponentSub42.handleString24(this.namesModule.valueSettingSub94.isEnabled17() ? "Snap to slots" : "Unlock");
      });
      this.guiComponentSub43 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.FILLED, "Done", this::lambda);
      this.int_ = 0;
      this.cls4 = new client.onyx.render.misc.Cls(0.0F);
      this.cls = new client.onyx.render.misc.Cls(0.0F);
      this.cls3 = new client.onyx.render.misc.Cls(0.0F);
      this.cls2 = new client.onyx.render.misc.Cls(0.0F);
      this.guiScreen = var1;
   }

   private float getFloat2(client.onyx.render.misc.Cls var1, float var2, boolean var3) {
      client.onyx.render.misc.Cls var10000;
      if (var3) {
         var1.getCls(var2);
         var10000 = var1;
      } else {
         if (Math.abs(var1.getFloat2() - var2) > 0.01F) {
            var1.getCls2(var2, 200.0F, client.onyx.render.misc.Util.IFACE2);
         }

         var10000 = var1;
      }

      var10000.handleFloat(this.float_);
      return var1.getFloat();
   }

   private int getInt(float var1, float var2) {
      float var3 = this.float_3 + this.float_2 / 2.0F;
      float var4 = this.float_6 + this.float_5 / 2.0F;
      var1 = (var1 - var3) / (this.float_2 / 2.0F + 1.0F);
      if (Math.abs(var2 = (var2 - var4) / (this.float_5 / 2.0F + 1.0F)) >= Math.abs(var1)) {
         return var2 < 0.0F ? 0 : 3;
      } else {
         return var1 < 0.0F ? 1 : 2;
      }
   }

   private void handleInt4(int var1, float[] var2, float var3, float var4) {
      this.int_ = var1;
      this.float_4 = var3 - (var2[0] + var2[2] / 2.0F);
      this.float_7 = var4 - (var2[1] + var2[3] / 2.0F);
   }

   private boolean isInt(int var1, float[] var2, int var3, int var4) {
      return this.int_ == var1 ? true : this.int_ == 0 && isFloatArray(var2, var3, var4);
   }

   @Override
   protected void mouseClickMove(int var1, int var2, int var3, long var4) {
      if (this.int_ != 0) {
         this.handleFloat(var1, var2);
      } else {
         super.mouseClickMove(var1, var2, var3, var4);
      }
   }

   private void handleInt2(int var1, int var2) {
      this.sampler0
         .handleOpticalWeightRecord3(
            client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD14, "ESP layout", this.width / 2.0F, 22.0F, Util4.getPrimaryOnPrimaryRecord().onSurface()
         );
      this.sampler0
         .handleOpticalWeightRecord3(
            client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2,
            "Drag the name and equipment around the player",
            this.width / 2.0F,
            44.0F,
            Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.85F)
         );
      Cls2 var3 = new Cls2(this.sampler0, this.float_, var1, var2);
      this.guiComponentSub4.handleCls28(var3);
      this.guiComponentSub42.handleCls28(var3);
      this.guiComponentSub43.handleCls28(var3);
      this.guiComponentSub4.handleCls27(var3);
      this.guiComponentSub42.handleCls27(var3);
      this.guiComponentSub43.handleCls27(var3);
   }

   private void handleFloat(float var1, float var2) {
      if (!(this.float_2 <= 0.0F) && !(this.float_5 <= 0.0F)) {
         if (this.namesModule.valueSettingSub94.isEnabled17()) {
            float var9 = this.float_3 + this.float_2 / 2.0F;
            float var8 = this.float_6 + this.float_5 / 2.0F;
            ValueSettingSub10 var6 = this.int_ == 1 ? this.namesModule.valueSettingSub102 : this.namesModule.valueSettingSub104;
            ValueSettingSub10 var10000 = this.int_ == 1 ? this.namesModule.valueSettingSub106 : this.namesModule.valueSettingSub103;
            var6.handleObject2((double)((var1 - this.float_4 - var9) / this.float_5));
            var10000.handleObject2((double)((var2 - this.float_7 - var8) / this.float_5));
         } else {
            int var7 = this.getInt(var1, var2);
            ValueSettingSub10 var3 = this.int_ == 1 ? this.namesModule.valueSettingSub105 : this.namesModule.valueSettingSub107;
            var3.handleObject2((double)var7);
            this.handleInt(var7, var2);
         }
      }
   }

   private void handleInt(int var1, float var2) {
      if (this.namesModule.valueSettingSub95.isEnabled17() && this.namesModule.valueSettingSub93.isEnabled17()) {
         if ((this.int_ == 1 ? this.namesModule.valueSettingSub107 : this.namesModule.valueSettingSub105).getInt10() == var1) {
            float[] var3 = this.int_ == 1 ? this.floatArray2 : this.floatArray;
            if (var3 != null) {
               float var4 = var3[1] + var3[3] / 2.0F;
               boolean var5 = var2 - this.float_7 < var4;
               boolean var6 = this.int_ == 1 ? var5 : !var5;
               this.namesModule.valueSettingSub92.handleObject2(!var6);
            }
         }
      }
   }

   @Override
   public void initGui() {
      this.long_ = 0L;
      this.guiComponentSub42.handleString24(this.namesModule.valueSettingSub94.isEnabled17() ? "Snap to slots" : "Unlock");
   }

   private void run4() {
      this.sampler0.run39();
      GuiInventory.drawEntityOnScreen(this.width / 2, (int)(this.float_6 + this.float_5), (int)(this.float_5 * 0.5F), 0.0F, 0.0F, this.mc.thePlayer);
      this.sampler0.run42();
   }

   private boolean isFloat(float var1, float var2) {
      if (this.floatArray != null && isFloatArray(this.floatArray, var1, var2)) {
         this.handleInt4(1, this.floatArray, var1, var2);
         return true;
      } else if (this.floatArray2 != null && isFloatArray(this.floatArray2, var1, var2)) {
         this.handleInt4(2, this.floatArray2, var1, var2);
         return true;
      } else {
         return false;
      }
   }

   private void run() {
      float var5 = 118.0F;
      float var2 = 10.0F;
      float var3 = var5 * 3.0F + var2 * 2.0F;
      var3 = this.width / 2.0F - var3 / 2.0F;
      float var4 = this.height - 46.0F;
      this.guiComponentSub4.handleFloat80(var3, var4, var5, 30.0F);
      this.guiComponentSub42.handleFloat80(var3 + var5 + var2, var4, var5, 30.0F);
      this.guiComponentSub43.handleFloat80(var3 + (var5 + var2) * 2.0F, var4, var5, 30.0F);
   }

   private void run3() {
      float var2 = this.mc.thePlayer.width / this.mc.thePlayer.height;
      this.float_5 = this.height * 0.5F;
      this.float_6 = this.height / 2.0F - this.float_5 / 2.0F;
      this.float_2 = this.float_5 * var2;
      this.float_3 = this.width / 2.0F - this.float_2 / 2.0F;
   }

   @Override
   protected void mouseReleased(int var1, int var2, int var3) {
      this.int_ = 0;
      this.guiComponentSub4.isFloat19(var1, var2, var3);
      this.guiComponentSub42.isFloat19(var1, var2, var3);
      this.guiComponentSub43.isFloat19(var1, var2, var3);
      super.mouseReleased(var1, var2, var3);
   }

   @Override
   protected void keyTyped(char var1, int var2) throws IOException {
      if (var2 == 1) {
         this.lambda();
      } else {
         super.keyTyped(var1, var2);
      }
   }

   private void lambda() {
      this.mc.displayGuiScreen(this.guiScreen);
   }

   private float getFloat() {
      long var1 = System.nanoTime();
      if (this.long_ == 0L) {
         this.long_ = var1;
         return 16.0F;
      } else {
         float var10000 = (float)(var1 - this.long_) / 1000000.0F;
         this.long_ = var1;
         return Math.min(var10000, 100.0F);
      }
   }

   @Override
   public void drawScreen(int var1, int var2, float var3) {
      this.float_ = this.getFloat();
      this.run();
      this.sampler0.run42();
      Reset2 var10000;
      if (this.mc.theWorld != null) {
         this.sampler0.handleFloat28(0.0F, 0.0F, this.width, this.height, Util4.getIntForFloat(0.55F));
         var10000 = this;
      } else {
         this.sampler0.handleFloat13(0.0F, 0.0F, this.width, this.height);
         var10000 = this;
      }

      if (var10000.mc.thePlayer != null) {
         this.run3();
         this.run4();
         this.handleInt5(var1, var2);
      }

      this.handleInt2(var1, var2);
      this.sampler0.run39();
   }

   private static boolean isFloatArray(float[] var0, float var1, float var2) {
      return var1 >= var0[0] && var1 <= var0[0] + var0[2] && var2 >= var0[1] && var2 <= var0[1] + var0[3];
   }

   private void handleInt3(int var1, int var2, float var3, float var4) {
      boolean var5 = var1 == var2;
      var2 = var5 ? Util4.getPrimaryOnPrimaryRecord().primary() : Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurface(), 0.3F);
      float var10003;
      int var10004;
      if (var5) {
         var10003 = 4.0F;
         var10004 = var2;
      } else {
         var10003 = 2.5F;
         var10004 = var2;
      }

      this.sampler0.handleFloat23(var3, var4, var10003, var10004);
   }

   @Override
   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      if (var3 != 0 || !this.isFloat(var1, var2)) {
         if (!this.guiComponentSub4.isFloat17(var1, var2, var3)) {
            if (!this.guiComponentSub42.isFloat17(var1, var2, var3)) {
               if (!this.guiComponentSub43.isFloat17(var1, var2, var3)) {
                  super.mouseClicked(var1, var2, var3);
               }
            }
         }
      }
   }

   private void run2() {
      int var4 = (this.int_ == 1 ? this.namesModule.valueSettingSub105 : this.namesModule.valueSettingSub107).getInt10();
      float var2 = this.float_3 + this.float_2 / 2.0F;
      float var3 = this.float_6 + this.float_5 / 2.0F;
      this.handleInt3(0, var4, var2, this.float_6 - 16.0F);
      this.handleInt3(3, var4, var2, this.float_6 + this.float_5 + 16.0F);
      this.handleInt3(1, var4, this.float_3 - 16.0F, var3);
      this.handleInt3(2, var4, this.float_3 + this.float_2 + 16.0F, var3);
   }
}
