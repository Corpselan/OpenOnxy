package client.onyx.gui;

import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.theme.Util4;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;

public class GuiScreenImpl extends GuiScreen {
   private boolean bool;
   private float float_;
   private static final float FLOAT = 16.0F;
   private final Sampler0 sampler0;
   private static final float FLOAT2 = 0.92F;
   private long long_;
   private final client.onyx.render.misc.Cls cls;
   private final client.onyx.render.misc.Cls cls2;
   private static final float FLOAT3 = 0.62F;
   private float float_2;
   private float float_3;
   private final AddGuiComponent addGuiComponent = new AddGuiComponent();
   private static final int INT = 120;
   private static final float FLOAT4 = 0.32F;
   private float float_4;
   private static final float FLOAT5 = 0.72F;
   private final GuiScreen guiScreen;
   private static final float FLOAT6 = 100.0F;

   @Override
   public boolean doesGuiPauseGame() {
      return false;
   }

   private void run2() {
      float var2 = Math.min(this.width * 0.62F / this.addGuiComponent.getFloat119(), this.height * 0.72F / this.addGuiComponent.getFloat116());
      this.float_ = Math.min(Util4.getFloat2(), var2);
      this.float_2 = Util4.getFloat2();
      this.addGuiComponent.handleFloat82(this.width / this.float_, this.height / this.float_);
   }

   @Override
   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      this.run();
      if (!this.addGuiComponent.isFloat17(this.float_3, this.float_4, var3)) {
         super.mouseClicked(var1, var2, var3);
      }
   }

   private float getFloat2(double var1) {
      return (float)(var1 / this.float_);
   }

   public GuiScreenImpl(GuiScreen var1) {
      this.sampler0 = new Sampler0();
      this.cls = new client.onyx.render.misc.Cls(0.0F);
      this.cls2 = new client.onyx.render.misc.Cls(0.0F);
      this.float_ = 1.0F;
      this.guiScreen = var1;
   }

   @Override
   public void setWorldAndResolution(Minecraft var1, int var2, int var3) {
      super.setWorldAndResolution(var1, var2, var3);
      if (this.guiScreen != null && var1.theWorld == null) {
         this.guiScreen.setWorldAndResolution(var1, var2, var3);
      }

      this.run2();
   }

   @Override
   public void drawScreen(int var1, int var2, float var3) {
      float var13 = this.getFloat();
      this.cls.handleFloat(var13);
      this.cls2.handleFloat(var13);
      if (this.float_2 != Util4.getFloat2()) {
         this.run2();
      }

      this.run();
      if (this.mc.theWorld == null && this.guiScreen != null) {
         this.guiScreen.drawScreen(-1, -1, var3);
      }

      this.sampler0.run42();
      if (this.mc.theWorld == null) {
         if (this.guiScreen == null) {
            this.sampler0.handleFloat13(0.0F, 0.0F, this.width, this.height);
            this.sampler0.run39();
            client.onyx.render.Util3.run4();
            client.onyx.render.Util3.run7();
            this.sampler0.run42();
         }
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
      float var11 = this.float_3;
      Cls2 var14 = new Cls2(var10, var13, var11, this.float_4);
      float var15 = this.cls.getFloat();
      this.sampler0.run36();
      this.sampler0.getCls32().getCls33(this.float_, this.float_);
      this.sampler0.handleFloat12(0.92F + 0.07999998F * var15, this.addGuiComponent.getFloat123(), this.addGuiComponent.getFloat121());
      this.addGuiComponent.handleFloat81(var15);
      this.addGuiComponent.handleCls28(var14);
      this.addGuiComponent.handleCls27(var14);
      this.sampler0.run43();
      this.sampler0.run39();
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
   public void handleMouseInput() throws IOException {
      int var2;
      if ((var2 = Mouse.getEventDWheel()) != 0) {
         this.run();
         if (this.addGuiComponent.isFloat16(this.float_3, this.float_4, var2 / 120.0)) {
            return;
         }
      }

      super.handleMouseInput();
   }

   @Override
   protected void mouseReleased(int var1, int var2, int var3) {
      this.run();
      if (!this.addGuiComponent.isFloat19(this.float_3, this.float_4, var3)) {
         super.mouseReleased(var1, var2, var3);
      }
   }

   private void run() {
      int var2 = new ScaledResolution(this.mc).getScaleFactor();
      this.float_3 = this.getFloat2((float)Minecraft.getScaledMouseX() / var2);
      this.float_4 = this.getFloat2((float)(this.mc.displayHeight - Minecraft.getScaledMouseY()) / var2);
   }

   @Override
   protected void mouseClickMove(int var1, int var2, int var3, long var4) {
      float var6 = this.float_3;
      float var8 = this.float_4;
      this.run();
      if (!this.addGuiComponent.isFloat18(this.float_3, this.float_4, var3, this.float_3 - var6, this.float_4 - var8)) {
         super.mouseClickMove(var1, var2, var3, var4);
      }
   }

   @Override
   protected void keyTyped(char var1, int var2) throws IOException {
      KeyScancodeRecord var3 = new KeyScancodeRecord(var2, 0, 0, var1);
      if (!this.addGuiComponent.isKeyScancodeRecord3(var3)) {
         if (var2 != 1 || !this.addGuiComponent.lambda246()) {
            if (var1 < ' ' || !this.addGuiComponent.isCodepointModifiersRecord(new CodepointModifiersRecord(var1, 0))) {
               if (var2 == 1) {
                  this.mc.displayGuiScreen(this.guiScreen);
               } else {
                  super.keyTyped(var1, var2);
               }
            }
         }
      }
   }

   @Override
   public void initGui() {
      if (!this.bool) {
         this.bool = true;
         this.cls.getCls(0.0F).getCls2(1.0F, 400.0F, client.onyx.render.misc.Util.IFACE7);
         this.cls2.getCls(0.0F).getCls2(1.0F, 250.0F, client.onyx.render.misc.Util.IFACE5);
      }

      this.long_ = 0L;
      this.run2();
   }
}
