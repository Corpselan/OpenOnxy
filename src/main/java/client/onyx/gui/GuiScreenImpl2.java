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

public class GuiScreenImpl2 extends GuiScreen {
   private final Sampler0 sampler0;
   private final client.onyx.render.misc.Cls cls;
   private static final float FLOAT = 0.92F;
   private static final float FLOAT2 = 100.0F;
   private float float_;
   private boolean bool;
   private static final float FLOAT3 = 0.5F;
   private final GuiScreen guiScreen;
   private static final float FLOAT4 = 0.32F;
   private long long_;
   private static final float FLOAT5 = 16.0F;
   private float float_2;
   private final client.onyx.render.misc.Cls cls2;
   private float float_3;
   private float float_4;
   private final ProxyGuiComponent proxyGuiComponent;
   private static final float FLOAT6 = 0.72F;

   @Override
   public boolean doesGuiPauseGame() {
      return false;
   }

   private void run() {
      float var2 = Math.min(this.width * 0.5F / this.proxyGuiComponent.getFloat119(), this.height * 0.72F / this.proxyGuiComponent.getFloat116());
      this.float_4 = Math.min(Util4.getFloat2(), var2);
      this.float_2 = Util4.getFloat2();
      this.proxyGuiComponent.handleFloat85(this.width / this.float_4, this.height / this.float_4);
   }

   @Override
   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      this.run2();
      if (!this.proxyGuiComponent.isFloat17(this.float_, this.float_3, var3)) {
         super.mouseClicked(var1, var2, var3);
      }
   }

   public GuiScreenImpl2(GuiScreen var1) {
      Runnable var2 = this::lambda;
      ProxyGuiComponent var3 = new ProxyGuiComponent(var2);
      this.proxyGuiComponent = var3;
      this.sampler0 = new Sampler0();
      this.cls = new client.onyx.render.misc.Cls(0.0F);
      this.cls2 = new client.onyx.render.misc.Cls(0.0F);
      this.float_4 = 1.0F;
      this.guiScreen = var1;
   }

   private void run2() {
      int var2 = new ScaledResolution(this.mc).getScaleFactor();
      this.float_ = this.getFloat2((float)Minecraft.getScaledMouseX() / var2);
      this.float_3 = this.getFloat2((float)(this.mc.displayHeight - Minecraft.getScaledMouseY()) / var2);
   }

   @Override
   protected void mouseClickMove(int var1, int var2, int var3, long var4) {
      float var6 = this.float_;
      float var8 = this.float_3;
      this.run2();
      if (!this.proxyGuiComponent.isFloat18(this.float_, this.float_3, var3, this.float_ - var6, this.float_3 - var8)) {
         super.mouseClickMove(var1, var2, var3, var4);
      }
   }

   @Override
   protected void keyTyped(char var1, int var2) throws IOException {
      KeyScancodeRecord var3 = new KeyScancodeRecord(var2, 0, 0, var1);
      if (!this.proxyGuiComponent.isKeyScancodeRecord3(var3)) {
         if (var1 < ' ' || !this.proxyGuiComponent.isCodepointModifiersRecord(new CodepointModifiersRecord(var1, 0))) {
            if (var2 == 1) {
               this.lambda();
            } else {
               super.keyTyped(var1, var2);
            }
         }
      }
   }

   private void lambda() {
      this.mc.displayGuiScreen(this.guiScreen);
   }

   @Override
   protected void mouseReleased(int var1, int var2, int var3) {
      this.run2();
      if (!this.proxyGuiComponent.isFloat19(this.float_, this.float_3, var3)) {
         super.mouseReleased(var1, var2, var3);
      }
   }

   @Override
   public void drawScreen(int var1, int var2, float var3) {
      float var13 = this.getFloat();
      this.cls.handleFloat(var13);
      this.cls2.handleFloat(var13);
      if (this.float_2 != Util4.getFloat2()) {
         this.run();
      }

      this.run2();
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
      float var11 = this.float_;
      Cls2 var14 = new Cls2(var10, var13, var11, this.float_3);
      float var15 = this.cls.getFloat();
      this.sampler0.run36();
      this.sampler0.getCls32().getCls33(this.float_4, this.float_4);
      this.sampler0.handleFloat12(0.92F + 0.07999998F * var15, this.proxyGuiComponent.getFloat124(), this.proxyGuiComponent.getFloat125());
      this.proxyGuiComponent.handleFloat84(var15);
      this.proxyGuiComponent.handleCls28(var14);
      this.proxyGuiComponent.handleCls27(var14);
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

   private float getFloat2(double var1) {
      return (float)(var1 / this.float_4);
   }

   @Override
   public void initGui() {
      if (!this.bool) {
         this.bool = true;
         this.proxyGuiComponent.run189();
         this.cls.getCls(0.0F).getCls2(1.0F, 400.0F, client.onyx.render.misc.Util.IFACE7);
         this.cls2.getCls(0.0F).getCls2(1.0F, 250.0F, client.onyx.render.misc.Util.IFACE5);
      }

      this.long_ = 0L;
      this.run();
   }

   @Override
   public void setWorldAndResolution(Minecraft var1, int var2, int var3) {
      super.setWorldAndResolution(var1, var2, var3);
      if (this.guiScreen != null && var1.theWorld == null) {
         this.guiScreen.setWorldAndResolution(var1, var2, var3);
      }

      this.run();
   }
}
