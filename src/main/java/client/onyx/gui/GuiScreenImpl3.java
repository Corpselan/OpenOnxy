package client.onyx.gui;

import client.onyx.gui.component.GuiComponentSub3;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.module.Module;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.theme.Util4;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;

public class GuiScreenImpl3 extends GuiScreen {
   private float float_;
   private static final float FLOAT = 100.0F;
   private final GuiScreen guiScreen;
   private float float_2;
   private final Sampler0 sampler0;
   private float float_3;
   private final client.onyx.render.misc.Cls cls;
   private long long_;
   private static final float FLOAT2 = 0.62F;
   private final UndoneGuiComponent undoneGuiComponent = new UndoneGuiComponent();
   private final client.onyx.render.misc.Cls cls2;
   private static final int INT = 120;
   private final Module module;
   private boolean bool;
   private static final float FLOAT3 = 0.72F;
   private static final float FLOAT4 = 16.0F;
   private float float_4;
   private boolean bool2;

   private void run() {
      int var2 = new ScaledResolution(this.mc).getScaleFactor();
      this.float_4 = this.getFloat2((float)Minecraft.getScaledMouseX() / var2);
      this.float_ = this.getFloat2((float)(this.mc.displayHeight - Minecraft.getScaledMouseY()) / var2);
   }

   @Override
   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      this.run();
      if (!this.undoneGuiComponent.isFloat17(this.float_4, this.float_, var3)) {
         super.mouseClicked(var1, var2, var3);
      }
   }

   @Override
   public void drawScreen(int var1, int var2, float var3) {
      if (this.isEnabled2()) {
         this.run2();
      } else {
         float var13 = this.getFloat();
         this.cls.handleFloat(var13);
         this.cls2.handleFloat(var13);
         if (this.float_3 != Util4.getFloat2()) {
            this.run3();
         }

         this.run();
         this.sampler0.run42();
         if (this.mc.theWorld == null) {
            this.sampler0.handleFloat13(0.0F, 0.0F, this.width, this.height);
            this.sampler0.run39();
            client.onyx.render.Util3.run4();
            client.onyx.render.Util3.run7();
            this.sampler0.run42();
         } else {
            Util14.run2();
            Sampler0 var4 = this.sampler0;
            float var5 = this.width;
            float var6 = this.height;
            float var7 = this.cls2.getFloat();
            int var9 = Util4.getIntForFloat(0.32F * var7);
            var4.handleFloat28(0.0F, 0.0F, var5, var6, var9);
         }

         Sampler0 var10 = this.sampler0;
         float var11 = this.float_4;
         Cls2 var14 = new Cls2(var10, var13, var11, this.float_);
         float var15 = this.cls.getFloat();
         this.sampler0.run36();
         this.sampler0.getCls32().getCls33(this.float_2, this.float_2);
         this.sampler0.handleFloat12(0.92F + 0.08F * var15, this.undoneGuiComponent.getFloat112(), this.undoneGuiComponent.getFloat110());
         this.undoneGuiComponent.handleFloat77(var15);
         this.undoneGuiComponent.handleCls28(var14);
         this.undoneGuiComponent.handleCls27(var14);
         this.sampler0.run43();
         this.sampler0.run39();
      }
   }

   private void run3() {
      float var2 = Math.min(this.width * 0.62F / this.undoneGuiComponent.getFloat119(), this.height * 0.72F / this.undoneGuiComponent.getFloat116());
      this.float_2 = Math.min(Util4.getFloat2(), var2);
      this.float_3 = Util4.getFloat2();
      this.undoneGuiComponent.handleFloat78(this.width / this.float_2, this.height / this.float_2);
   }

   @Override
   public void initGui() {
      if (!this.bool2) {
         this.bool2 = true;
         client.onyx.setting.Util.run2();
         this.cls.getCls(0.0F).getCls2(1.0F, 400.0F, client.onyx.render.misc.Util.IFACE7);
         this.cls2.getCls(0.0F).getCls2(1.0F, 250.0F, client.onyx.render.misc.Util.IFACE5);
      }

      this.long_ = 0L;
      this.bool = this.isEnabled();
      this.run3();
   }

   public GuiScreenImpl3(Module var1, GuiScreen var2) {
      this.sampler0 = new Sampler0();
      this.cls = new client.onyx.render.misc.Cls(0.0F);
      this.cls2 = new client.onyx.render.misc.Cls(0.0F);
      this.float_2 = 1.0F;
      this.module = var1;
      this.guiScreen = var2;
   }

   @Override
   public void onGuiClosed() {
      client.onyx.setting.Util.run3();
      if (this.module != null && this.module.isEnabled55()) {
         this.module.lambda35();
      }
   }

   private boolean isEnabled2() {
      boolean var2;
      if ((var2 = this.isEnabled()) == this.bool) {
         return false;
      } else {
         this.bool = var2;
         return var2 && !GuiComponentSub3.isEnabled153();
      }
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
   protected void mouseReleased(int var1, int var2, int var3) {
      this.run();
      if (!this.undoneGuiComponent.isFloat19(this.float_4, this.float_, var3)) {
         super.mouseReleased(var1, var2, var3);
      }
   }

   @Override
   protected void mouseClickMove(int var1, int var2, int var3, long var4) {
      float var6 = this.float_4;
      float var8 = this.float_;
      this.run();
      if (!this.undoneGuiComponent.isFloat18(this.float_4, this.float_, var3, this.float_4 - var6, this.float_ - var8)) {
         super.mouseClickMove(var1, var2, var3, var4);
      }
   }

   private boolean isEnabled() {
      return this.module != null && this.module.getNoneValueSetting2().isEnabled19() ? this.module.getNoneValueSetting2().isEnabled22() : false;
   }

   private void run2() {
      this.mc.displayGuiScreen(this.guiScreen);
   }

   @Override
   public void handleMouseInput() throws IOException {
      int var2;
      if ((var2 = Mouse.getEventDWheel()) != 0) {
         this.run();
         if (this.undoneGuiComponent.isFloat16(this.float_4, this.float_, var2 / 120.0)) {
            return;
         }
      }

      super.handleMouseInput();
   }

   @Override
   public void setWorldAndResolution(Minecraft var1, int var2, int var3) {
      super.setWorldAndResolution(var1, var2, var3);
      this.run3();
   }

   @Override
   protected void keyTyped(char var1, int var2) throws IOException {
      KeyScancodeRecord var3 = new KeyScancodeRecord(var2, 0, 0, var1);
      if (!this.undoneGuiComponent.isKeyScancodeRecord3(var3)) {
         if (var2 != 1 || !this.undoneGuiComponent.isEnabled142()) {
            if (this.module == null || !this.module.getNoneValueSetting2().isInt2(var2) || GuiComponentSub3.isEnabled153()) {
               if (var1 < ' ' || !this.undoneGuiComponent.isCodepointModifiersRecord(new CodepointModifiersRecord(var1, 0))) {
                  if (var2 == 1) {
                     this.run2();
                  } else {
                     super.keyTyped(var1, var2);
                  }
               }
            }
         }
      }
   }

   @Override
   public boolean doesGuiPauseGame() {
      return false;
   }

   private float getFloat2(double var1) {
      return (float)(var1 / this.float_2);
   }
}
