package client.onyx.gui;

import client.onyx.OnyxClient;
import client.onyx.gui.component.GuiComponentSub4;
import client.onyx.module.render.CapeChangerModule;
import client.onyx.render.PixelsSmoothEnum;
import client.onyx.render.Sampler0;
import client.onyx.theme.Util4;
import java.awt.image.BufferedImage;
import java.io.IOException;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

public class Fit extends GuiScreen {
   private float float_;
   private boolean bool;
   private final GuiScreen guiScreen;
   private double double_;
   private float float_2;
   private float float_3;
   private final CapeChangerModule capeChangerModule;
   private double double_2;
   private static final float FLOAT = 0.625F;
   private final GuiComponentSub4 guiComponentSub4;
   private static final float FLOAT2 = 8.0F;
   private static final float FLOAT3 = 96.0F;
   private final GuiComponentSub4 guiComponentSub42;
   private final GuiComponentSub4 guiComponentSub43;
   private final Sampler0 sampler0;
   private final GuiComponentSub4 guiComponentSub44;
   private static final float FLOAT4 = 1.12F;
   private static final float FLOAT5 = 0.56F;
   private final GuiComponentSub4 guiComponentSub45;
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("onyx", "capes/source");
   private float float_4;
   private float float_5;
   private float float_6;

   @Override
   protected void mouseClickMove(int var1, int var2, int var3, long var4) {
      if (!this.bool) {
         super.mouseClickMove(var1, var2, var3, var4);
      } else {
         this.capeChangerModule.valueSettingSub10.handleObject2(this.double_2 + (var1 - this.float_6) / this.float_4 * 100.0);
         this.capeChangerModule.valueSettingSub103.handleObject2(this.double_ + (var2 - this.float_) / this.float_5 * 100.0);
      }
   }

   private GuiComponentSub4[] getGuiComponentSub4Array() {
      return new GuiComponentSub4[]{this.guiComponentSub45, this.guiComponentSub4, this.guiComponentSub44, this.guiComponentSub42, this.guiComponentSub43};
   }

   @Override
   public void handleMouseInput() throws IOException {
      super.handleMouseInput();
      int var4;
      if ((var4 = Mouse.getEventDWheel()) != 0 && this.capeChangerModule.getBufferedImage4() != null) {
         double var2 = var4 > 0 ? 1.12F : 0.8928571390558262;
         this.capeChangerModule.valueSettingSub102.handleObject2(this.capeChangerModule.valueSettingSub102.lambda15() * var2);
         this.capeChangerModule.run86();
      }
   }

   @Override
   public boolean doesGuiPauseGame() {
      return false;
   }

   public Fit(GuiScreen var1) {
      this.capeChangerModule = OnyxClient.cls.capeChangerModule;
      this.sampler0 = new Sampler0();
      this.guiComponentSub45 = new GuiComponentSub4(
         GuiComponentSub4.FilledTonalEnum.OUTLINED, "Fit", () -> this.handleAutoFitEnum(client.onyx.render.cape.Util2.AutoFitEnum.FIT)
      );
      this.guiComponentSub4 = new GuiComponentSub4(
         GuiComponentSub4.FilledTonalEnum.OUTLINED, "Fill", () -> this.handleAutoFitEnum(client.onyx.render.cape.Util2.AutoFitEnum.FILL)
      );
      this.guiComponentSub44 = new GuiComponentSub4(
         GuiComponentSub4.FilledTonalEnum.OUTLINED, "Stretch", () -> this.handleAutoFitEnum(client.onyx.render.cape.Util2.AutoFitEnum.STRETCH)
      );
      this.guiComponentSub42 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.TONAL, "Reset", () -> {
         this.capeChangerModule.valueSettingSub102.run5();
         this.capeChangerModule.valueSettingSub10.run5();
         this.capeChangerModule.valueSettingSub103.run5();
         this.capeChangerModule.run86();
      });
      this.guiComponentSub43 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.FILLED, "Done", this::lambda5);
      this.guiScreen = var1;
   }

   private void handleBufferedImage(BufferedImage var1) {
      this.sampler0.handleFloat28(this.float_2, this.float_3, this.float_4, this.float_5, this.capeChangerModule.valueSettingSub6.lambda15() | 0xFF000000);
      double[] var2 = client.onyx.render.cape.Util2.getDoubleArrayForBufferedImage(
         var1,
         client.onyx.render.cape.Util2.getAutoFitEnumForAutoFitEnum(this.capeChangerModule.valueSettingSub112.lambda15(), var1),
         this.float_4,
         this.float_5,
         this.capeChangerModule.valueSettingSub102.lambda15() / 100.0,
         this.capeChangerModule.valueSettingSub10.lambda15() / 100.0,
         this.capeChangerModule.valueSettingSub103.lambda15() / 100.0
      );
      this.sampler0.handleFloat24(this.float_2, this.float_3, this.float_4, this.float_5);
      this.sampler0
         .handleResourceLocation4(
            RESOURCE_LOCATION,
            this.float_2 + (float)var2[0],
            this.float_3 + (float)var2[1],
            (float)var2[2],
            (float)var2[3],
            0.0F,
            0.0F,
            var1.getWidth(),
            var1.getHeight(),
            var1.getWidth(),
            var1.getHeight(),
            -1,
            PixelsSmoothEnum.SMOOTH
         );
      this.sampler0.run38();
      this.sampler0.handleFloat18(this.float_2, this.float_3, this.float_4, this.float_5, 8.0F, 1.5F, Util4.getPrimaryOnPrimaryRecord().primary());
      this.sampler0
         .handleOpticalWeightRecord3(
            client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2,
            "top",
            this.width / 2.0F,
            this.float_3 - 14.0F,
            Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.7F)
         );
      String var3 = client.onyx.render.cape.Util2.getAutoFitEnumForAutoFitEnum(this.capeChangerModule.valueSettingSub112.lambda15(), var1).getString5()
         + "  ·  "
         + Math.round(this.capeChangerModule.valueSettingSub102.lambda15())
         + "%";
      this.sampler0
         .handleOpticalWeightRecord3(
            client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2,
            var3,
            this.width / 2.0F,
            this.float_3 + this.float_5 + 8.0F,
            Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.85F)
         );
   }

   @Override
   protected void keyTyped(char var1, int var2) throws IOException {
      if (var2 == 1) {
         this.lambda5();
      } else {
         super.keyTyped(var1, var2);
      }
   }

   @Override
   public void drawScreen(int var1, int var2, float var3) {
      this.run();
      this.sampler0.run42();
      Fit var10000;
      if (this.mc.theWorld != null) {
         this.sampler0.handleFloat28(0.0F, 0.0F, this.width, this.height, Util4.getIntForFloat(0.7F));
         var10000 = this;
      } else {
         this.sampler0.handleFloat13(0.0F, 0.0F, this.width, this.height);
         var10000 = this;
      }

      var10000.sampler0
         .handleOpticalWeightRecord3(
            client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD14, "Cape", this.width / 2.0F, 22.0F, Util4.getPrimaryOnPrimaryRecord().onSurface()
         );
      this.sampler0
         .handleOpticalWeightRecord3(
            client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2,
            "Drag to move, scroll to zoom",
            this.width / 2.0F,
            44.0F,
            Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.85F)
         );
      BufferedImage var8;
      if ((var8 = this.capeChangerModule.getBufferedImage4()) == null) {
         this.sampler0
            .handleOpticalWeightRecord3(
               client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD14,
               "No cape picture loaded",
               this.width / 2.0F,
               this.height / 2.0F,
               Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurface(), 0.6F)
            );
      } else {
         this.handleBufferedImage(var8);
      }

      Cls2 var6 = new Cls2(this.sampler0, 16.0F, var1, var2);
      GuiComponentSub4[] var7;
      int var9 = (var7 = this.getGuiComponentSub4Array()).length;

      int var4;
      for (int var10 = var4 = 0; var10 < var9; var10 = var4) {
         GuiComponentSub4 var5 = var7[var4];
         var4++;
         var5.handleCls28(var6);
         var5.handleCls27(var6);
      }

      this.sampler0.run39();
   }

   private void lambda5() {
      this.capeChangerModule.handleBool17(false);
      this.mc.displayGuiScreen(this.guiScreen);
   }

   @Override
   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      GuiComponentSub4[] var4;
      int var5 = (var4 = this.getGuiComponentSub4Array()).length;

      int var6;
      for (int var10000 = var6 = 0; var10000 < var5; var10000 = ++var6) {
         if (var4[var6].isFloat17(var1, var2, var3)) {
            return;
         }
      }

      if (var3 == 0 && this.capeChangerModule.getBufferedImage4() != null && this.isFloat(var1, var2)) {
         this.bool = true;
         this.capeChangerModule.handleBool17(true);
         this.float_6 = var1;
         this.float_ = var2;
         this.double_2 = this.capeChangerModule.valueSettingSub10.lambda15();
         this.double_ = this.capeChangerModule.valueSettingSub103.lambda15();
      } else {
         super.mouseClicked(var1, var2, var3);
      }
   }

   @Override
   protected void mouseReleased(int var1, int var2, int var3) {
      if (this.bool) {
         this.bool = false;
         this.capeChangerModule.handleBool17(false);
      }

      GuiComponentSub4[] var4;
      int var5 = (var4 = this.getGuiComponentSub4Array()).length;

      int var7;
      for (int var10000 = var7 = 0; var10000 < var5; var10000 = var7) {
         GuiComponentSub4 var8 = var4[var7];
         float var10001 = var1;
         var7++;
         var8.isFloat19(var10001, var2, var3);
      }

      super.mouseReleased(var1, var2, var3);
   }

   private void run() {
      this.float_5 = this.height * 0.56F;
      this.float_4 = this.float_5 * 0.625F;
      this.float_2 = this.width / 2.0F - this.float_4 / 2.0F;
      this.float_3 = this.height / 2.0F - this.float_5 / 2.0F - 8.0F;
      float var3 = 512.0F;
      var3 = this.width / 2.0F - var3 / 2.0F;
      float var2 = this.height - 46.0F;
      this.guiComponentSub45.handleFloat80(var3, var2, 96.0F, 30.0F);
      this.guiComponentSub4.handleFloat80(var3 + 96.0F + 8.0F, var2, 96.0F, 30.0F);
      this.guiComponentSub44.handleFloat80(var3 + 208.0F, var2, 96.0F, 30.0F);
      this.guiComponentSub42.handleFloat80(var3 + 312.0F, var2, 96.0F, 30.0F);
      this.guiComponentSub43.handleFloat80(var3 + 416.0F, var2, 96.0F, 30.0F);
   }

   private void handleAutoFitEnum(client.onyx.render.cape.Util2.AutoFitEnum var1) {
      this.capeChangerModule.valueSettingSub112.handleObject2(var1);
   }

   private boolean isFloat(float var1, float var2) {
      if (var1 >= this.float_2) {
         float var4 = this.float_2 + this.float_4;
         if (var1 <= var4 && var2 >= this.float_3) {
            float var7 = this.float_3 + this.float_5;
            if (var2 <= var7) {
               return true;
            }
         }
      }

      return false;
   }
}
