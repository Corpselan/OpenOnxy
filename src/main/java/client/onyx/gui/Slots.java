package client.onyx.gui;

import client.onyx.OnyxClient;
import client.onyx.gui.component.GuiComponentSub3;
import client.onyx.gui.component.GuiComponentSub4;
import client.onyx.gui.component.GuiComponentSub8;
import client.onyx.gui.component.GuiComponentSub9;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.module.player.InventoryManagerModule;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.setting.impl.ValueSettingSub5;
import client.onyx.setting.impl.ValueSettingSub7;
import client.onyx.theme.Util4;
import client.onyx.util.Cls6;
import client.onyx.util.Util9;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Slots extends GuiScreen {
   private boolean Aa;
   private static final float Ca = 4.0F;
   private static final float Ba = 49.0F;
   private final GuiComponentSub4 aa;
   private float Ea;
   private static final float La = 116.0F;
   private float Ma;
   private float ba;
   private final Sampler0 Ia;
   private static final float Fa = 260.0F;
   private long Ja;
   private int ja;
   private static final float ma = 28.0F;
   private static final int da = 400;
   private static final float fa = 13.0F;
   private float Ka;
   private static final float ha = 18.0F;
   private static final float Ha = 32.0F;
   private static final float ia = 18.0F;
   private float Da;
   private float la;
   private final client.onyx.render.misc.Cls[] Ga;
   private static final float ga = 4.0F;
   private static final float ca = 20.0F;
   private Cls6 cls6;
   private static final float FLOAT = 97.0F;
   private static final float FLOAT2 = 100.0F;
   private int int_;
   private static final float FLOAT3 = 430.0F;
   private static final float FLOAT4 = 3.0F;
   private static final int INT = 1;
   private final List<Slots.XYRecord> list;
   private float float_;
   private static final float FLOAT5 = 5.0F;
   private static final int INT2 = 2;
   private static final float FLOAT6 = 13.0F;
   private final List<Slots.XYRecord> list2;
   private static final float FLOAT7 = 2.0F;
   private int int_2;
   private final GuiComponentSub4 guiComponentSub4;
   private final InventoryManagerModule inventoryManagerModule;
   private final List<Slots.XYRecord> list3;
   private float float_2;
   private static final float FLOAT8 = 560.0F;
   private float float_3;
   private static final float FLOAT9 = 5.0F;
   private static final float FLOAT10 = 26.0F;
   private final GuiComponentSub8 guiComponentSub8;
   private final List<Slots.XYRecord> list4;
   private float float_4;
   private static final float FLOAT11 = 8.0F;
   private static final float FLOAT12 = 18.0F;
   private final GuiScreen guiScreen;
   private static final float FLOAT13 = 22.0F;
   private static final float FLOAT14 = 8.0F;
   private float float_5;
   private static final float FLOAT15 = 16.0F;
   private static final float FLOAT16 = 3.0F;
   private float float_6;
   private final GuiComponentSub4 guiComponentSub42;
   private float float_7;
   private float float_8;
   private List<Util9.StackIdRecord> list5;
   private static final float FLOAT17 = 92.0F;
   private static final int INT3 = 0;
   private static final float FLOAT18 = 16.0F;
   private float float_9;
   private float float_10;
   private final GuiComponentSub9 guiComponentSub9;
   private static final float FLOAT19 = 20.0F;
   private static final float FLOAT20 = 9.0F;
   private float float_11;
   private static final float FLOAT21 = 7.0F;
   private static final float FLOAT22 = 38.0F;
   private static final float FLOAT23 = 120.0F;
   private String string;

   private void run() {
      this.Ma = Math.min(560.0F, (float)this.width - 40.0F);
      this.Ea = Math.min(430.0F, (float)this.height - 40.0F);
      this.float_6 = ((float)this.width - this.Ma) / 2.0F;
      this.Da = ((float)this.height - this.Ea) / 2.0F;
      this.float_8 = this.float_6 + 18.0F;
      this.float_3 = this.Ma - 36.0F;
      float var3 = Math.min(260.0F, this.float_3);
      float var2 = this.Da + 42.0F;
      this.guiComponentSub9.handleFloat80(this.float_6 + (this.Ma - var3) / 2.0F, var2, var3, 30.0F);
      this.float_7 = var2 + 30.0F + 14.0F;
      var3 = this.float_7 + 97.0F + 10.0F;
      this.guiComponentSub8.handleFloat80(this.float_8, var3, this.float_3, 40.0F);
      this.float_2 = var3 + 40.0F + 8.0F;
      this.float_9 = (var3 = this.Da + this.Ea - 18.0F - 30.0F) - 12.0F;
      var2 = 292.0F;
      var2 = this.float_6 + this.Ma - 18.0F - var2;
      this.guiComponentSub42.handleFloat80(var2, var3, 92.0F, 30.0F);
      this.aa.handleFloat80(var2 + 92.0F + 8.0F, var3, 92.0F, 30.0F);
      this.guiComponentSub4.handleFloat80(var2 + 200.0F, var3, 92.0F, 30.0F);
   }

   private void handleCls2(Cls2 var1) {
      this.list3.clear();
      this.list2.clear();
      float var2;
      if (!((var2 = this.float_9 - this.float_2) <= 0.0F)) {
         this.Ia.handleFloat24(this.float_8, this.float_2, this.float_3, var2);
         float var3 = this.getFloat5(var1, this.getFloat3(var1, this.float_2 - this.float_11) + 8.0F);
         this.Ia.run38();
         this.ba = Math.max(0.0F, var3 + this.float_11 - this.float_9);
         this.float_11 = Math.min(this.float_11, this.ba);
         this.handleFloat2(this.float_2, var2, this.float_11, this.ba);
      }
   }

   private String getString2(Cls6 var1) {
      return this.Ia.getString17(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD16, var1.getString3(), 116.0F);
   }

   private void handleFloat2(float var1, float var2, float var3, float var4) {
      if (!(var4 <= 0.0F) && !(var2 <= 0.0F)) {
         float var8 = var2 + var4;
         float var10 = var2 * var2 / var8;
         var8 = Math.max(18.0F, var10);
         float var6 = var2 - var8;
         float var7 = this.float_8 + this.float_3 - 3.0F;
         this.Ia.handleFloat7(var7, var1, 3.0F, var2, Float.MAX_VALUE, Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().outlineVariant(), 0.35F));
         this.Ia.handleFloat7(var7, var1 + var6 * (var3 / var4), 3.0F, var8, Float.MAX_VALUE, Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.7F));
      }
   }

   private float getFloat5(Cls2 var1, float var2) {
      int var7 = Math.max(1, (int)((this.float_3 - 7.0F + 4.0F) / 32.0F));
      float var4 = var2;

      int var5;
      for(int var10000 = var5 = 0; var10000 < this.list5.size(); var10000 = var5) {
         int var6 = var5 % var7;
         int var12 = var5 / var7;
         float var13 = this.float_8 + 32.0F * (float)var6;
         float var15;
         var4 = (var15 = var2 + 32.0F * (float)var12) + 28.0F;
         Util9.StackIdRecord var8;
         Cls6 var9;
         if (!(var15 + 28.0F < this.float_2) && !(var15 > this.float_9) && (var9 = Cls6.getCls6ForItemStack((var8 = (Util9.StackIdRecord)this.list5.get(var5)).stack())) != null) {
            boolean var10 = this.isCls6(var9);
            boolean var11 = var1.float_3 >= var13 && var1.float_3 < var13 + 28.0F && var1.float_2 >= var15 && var1.float_2 < var15 + 28.0F && var1.float_2 >= this.float_2 && var1.float_2 < this.float_9;
            int var14 = var10 ? Util4.getPrimaryOnPrimaryRecord().primaryContainer() : (var11 ? Util4.getPrimaryOnPrimaryRecord().surfaceContainerHighest() : Util4.getPrimaryOnPrimaryRecord().surfaceContainerHigh());
            this.Ia.handleFloat7(var13, var15, 28.0F, 28.0F, 4.0F, var14);
            this.handleItemStack(var8.stack(), var13 + 5.0F, var15 + 5.0F, 18.0F);
            this.list2.add(new Slots.XYRecord(var13, var15, 28.0F, 28.0F, var9, -1));
            if (var11) {
               this.string = var8.name();
            }
         }

         ++var5;
      }

      if (this.list5.isEmpty()) {
         this.Ia.handleOpticalWeightRecord8(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2, "No items match that search", this.float_8, var2 + 4.0F, Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.6F));
         return var2 + 22.0F;
      } else {
         return var4;
      }
   }

   public void handleMouseInput() throws IOException {
      int var3;
      if ((var3 = Mouse.getEventDWheel()) != 0) {
         float var13 = (float)var3 / 120.0F;
         float var2;
         if ((var2 = this.getFloat4()) >= this.Ka) {
            float var5 = this.Ka + this.float_5;
            if (var2 < var5 && this.float_ > 0.0F) {
               float var7 = this.float_10 - var13 * 27.0F;
               float var8 = this.float_;
               float var9 = Math.clamp(var7, 0.0F, var8);
               this.float_10 = var9;
               return;
            }
         }

         float var12 = Math.clamp(this.float_11 - var13 * 32.0F, 0.0F, this.ba);
         this.float_11 = var12;
      } else {
         super.handleMouseInput();
      }
   }

   private ValueSettingSub5 getValueSettingSub5() {
      switch(this.ja) {
      case 1:

         return this.inventoryManagerModule.valueSettingSub5;
      case 2:
         return this.inventoryManagerModule.valueSettingSub52;
      default:
         return null;
      }
   }

   private void lambda() {
      GuiComponentSub3.run194();
      this.mc.displayGuiScreen(this.guiScreen);
   }

   private String getString3() {
      return this.ja == 0 ? (new StringBuilder()).insert(0, "Slot ").append(this.int_ + 1).append(" is not claimed by anything yet").toString() : "Nothing on this list";
   }

   private void handleFloat(float var1, float var2) {
      Iterator var4;
      for(Iterator var10000 = var4 = this.list.iterator(); var10000.hasNext(); var10000 = var4) {
         Slots.XYRecord var5;
         if ((var5 = (Slots.XYRecord)var4.next()).isFloat(var1, var2)) {
            Slots var8;
            if (this.int_2 >= 0) {
               this.inventoryManagerModule.valueSettingSub7.handleInt2(this.int_2, var5.slot(), this.cls6);
               var8 = this;
            } else {
               this.inventoryManagerModule.valueSettingSub7.handleInt3(var5.slot(), this.cls6);
               var8 = this;
            }

            var8.handleInt(var5.slot());
            return;
         }
      }

      if (this.int_2 >= 0) {
         ValueSettingSub7 var6 = this.inventoryManagerModule.valueSettingSub7;
         int var7 = this.int_2;
         var6.handleInt4(var7, this.cls6);
      }

   }

   private void handleInt(int var1) {
      if (var1 != this.int_) {
         this.Ga[this.int_].getCls2(0.0F, 250.0F, client.onyx.render.misc.Util.IFACE2);
         this.int_ = var1;
         this.Ga[var1].getCls2(1.0F, 300.0F, client.onyx.render.misc.Util.IFACE2);
         this.float_10 = 0.0F;
      }
   }

   public Slots(GuiScreen var1) {
      this.inventoryManagerModule = OnyxClient.cls.la;
      this.Ia = new Sampler0();
      this.guiComponentSub8 = new GuiComponentSub8("Search items");
      String[] var10003 = new String[3];
      boolean var10005 = true;
      var10003[0] = "Slots";
      var10003[1] = "Keep";
      var10003[2] = "Drop";
      this.guiComponentSub9 = new GuiComponentSub9(var10003, (var1x) -> {
         this.ja = var1x;
         this.float_11 = 0.0F;
         this.float_10 = 0.0F;
      });
      this.guiComponentSub42 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.OUTLINED, "Clear", () -> {
         ValueSettingSub5 var2;
         if ((var2 = this.getValueSettingSub5()) == null) {
            this.inventoryManagerModule.valueSettingSub7.handleInt(this.int_);
         } else {
            var2.run8();
         }
      });
      this.aa = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.TONAL, "Reset", () -> {
         this.inventoryManagerModule.valueSettingSub7.run5();
         this.inventoryManagerModule.valueSettingSub5.run5();
         this.inventoryManagerModule.valueSettingSub52.run5();
      });
      this.guiComponentSub4 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.FILLED, "Done", this::lambda);
      this.list = new ArrayList();
      this.list4 = new ArrayList();
      this.list3 = new ArrayList();
      this.list2 = new ArrayList();
      client.onyx.render.misc.Cls[] var10001 = new client.onyx.render.misc.Cls[9];
      boolean var6 = true;
      this.Ga = var10001;
      int var10000 = 0;
      this.list5 = List.of();
      this.ja = 0;
      this.int_2 = -1;
      this.guiScreen = var1;

      for(int var2 = 0; var10000 < this.Ga.length; var10000 = var2) {
         client.onyx.render.misc.Cls[] var3 = this.Ga;
         int var5 = var2;
         client.onyx.render.misc.Cls var4 = new client.onyx.render.misc.Cls(var2 == this.int_ ? 1.0F : 0.0F);
         ++var2;
         var3[var5] = var4;
      }

      this.guiComponentSub8.handleConsumer4((var1x) -> {
         this.list5 = Util9.getListForString(var1x, 400);
         this.float_11 = 0.0F;
      });
   }

   public void initGui() {
      Keyboard.enableRepeatEvents(true);
      this.Ja = 0L;
      this.list5 = Util9.getListForString(this.guiComponentSub8.getString39(), 400);
   }

   private static int getIntForInt(int var0, int var1, float var2) {
      var2 = Math.clamp(var2, 0.0F, 1.0F);
      int var3 = (int)((float)(var0 >>> 24 & 255) + (float)((var1 >>> 24 & 255) - (var0 >>> 24 & 255)) * var2);
      int var4 = (int)((float)(var0 >>> 16 & 255) + (float)((var1 >>> 16 & 255) - (var0 >>> 16 & 255)) * var2);
      int var5 = (int)((float)(var0 >>> 8 & 255) + (float)((var1 >>> 8 & 255) - (var0 >>> 8 & 255)) * var2);
      var1 = (int)((float)(var0 & 255) + (float)((var1 & 255) - (var0 & 255)) * var2);
      return var3 << 24 | var4 << 16 | var5 << 8 | var1;
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.run();
      var3 = this.getFloat();
      client.onyx.render.misc.Cls[] var8;
      int var5 = (var8 = this.Ga).length;

      int var6;
      int var10000;
      for(var10000 = var6 = 0; var10000 < var5; var10000 = var6) {
         client.onyx.render.misc.Cls var12 = var8[var6];
         ++var6;
         var12.handleFloat(var3);
      }

      Cls2 var11 = new Cls2(this.Ia, var3, (float)var1, (float)var2);
      this.Ia.run42();
      Slots var13;
      if (this.mc.theWorld != null) {
         this.Ia.handleFloat28(0.0F, 0.0F, (float)this.width, (float)this.height, Util4.getIntForFloat(0.7F));
         var13 = this;
      } else {
         this.Ia.handleFloat13(0.0F, 0.0F, (float)this.width, (float)this.height);
         var13 = this;
      }

      var13.Ia.handleFloat7(this.float_6, this.Da, this.Ma, this.Ea, 28.0F, Util4.getPrimaryOnPrimaryRecord().surfaceContainer());
      this.Ia.handleOpticalWeightRecord8(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD18, "Inventory rules", this.float_8, this.Da + 26.0F, Util4.getPrimaryOnPrimaryRecord().onSurface());
      this.Ia.handleOpticalWeightRecord7(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2, this.getString(), this.float_6 + this.Ma - 18.0F, this.Da + 26.0F + 3.0F, Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.85F));
      this.guiComponentSub9.handleCls28(var11);
      this.guiComponentSub9.handleCls27(var11);
      this.list4.clear();
      this.list.clear();
      this.string = null;
      if (this.ja == 0) {
         this.handleCls24(var11);
         var13 = this;
         this.Ka = this.float_7 + 38.0F + 10.0F;
         this.float_5 = getFloatForFloat(49.0F);
         this.handleCls23(var11, this.inventoryManagerModule.valueSettingSub7.getList7(this.int_), this.int_);
      } else {
         this.Ka = this.float_7;
         this.float_5 = getFloatForFloat(97.0F);
         this.handleCls23(var11, (List)this.getValueSettingSub5().lambda15(), -1);
         var13 = this;
      }

      var13.guiComponentSub8.handleCls28(var11);
      this.guiComponentSub8.handleCls27(var11);
      this.handleCls2(var11);
      if (this.string != null) {
         this.Ia.handleOpticalWeightRecord9(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD16, this.Ia.getString17(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD16, this.string, Math.max(40.0F, this.float_3 - 276.0F - 16.0F - 12.0F)), this.float_8, this.guiComponentSub42.getFloat115() + 15.0F, Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.9F));
      }

      GuiComponentSub4[] var10;
      var6 = (var10 = this.getGuiComponentSub4Array()).length;

      int var7;
      for(var10000 = var7 = 0; var10000 < var6; var10000 = var7) {
         GuiComponentSub4 var9 = var10[var7];
         ++var7;
         var9.handleCls28(var11);
         var9.handleCls27(var11);
      }

      if (this.Aa) {
         this.handleCls22(var11);
      }

      this.Ia.run39();
   }

   private void handleXYRecord(Slots.XYRecord var1) {
      if (var1.slot() >= 0) {
         this.inventoryManagerModule.valueSettingSub7.handleInt4(var1.slot(), var1.matcher());
      } else {
         ValueSettingSub5 var2;
         if ((var2 = this.getValueSettingSub5()) != null) {
            var2.handleCls62(var1.matcher());
         }

      }
   }

   protected void mouseReleased(int var1, int var2, int var3) {
      GuiComponentSub4[] var4;
      int var5 = (var4 = this.getGuiComponentSub4Array()).length;

      int var6;
      for(int var10000 = var6 = 0; var10000 < var5; var10000 = var6) {
         GuiComponentSub4 var8 = var4[var6];
         float var10001 = (float)var1;
         ++var6;
         var8.isFloat19(var10001, (float)var2, var3);
      }

      Slots var9;
      label19: {
         this.guiComponentSub8.isFloat19((float)var1, (float)var2, var3);
         if (this.cls6 != null) {
            if (this.Aa) {
               this.handleFloat((float)var1, (float)var2);
               var9 = this;
               break label19;
            }

            if (this.int_2 < 0) {
               Cls6 var7 = this.cls6;
               this.handleCls6(var7);
            }
         }

         var9 = this;
      }

      var9.cls6 = null;
      this.int_2 = -1;
      this.Aa = false;
      super.mouseReleased(var1, var2, var3);
   }

   private float getFloat4() {
      int var2 = (new ScaledResolution(this.mc)).getScaleFactor();
      return (float)(this.mc.displayHeight - Minecraft.getScaledMouseY()) / (float)var2;
   }

   protected void keyTyped(char var1, int var2) throws IOException {
      KeyScancodeRecord var3 = new KeyScancodeRecord(var2, 0, 0, var1);
      if (!this.guiComponentSub8.isKeyScancodeRecord3(var3)) {
         if (var1 < ' ' || !this.guiComponentSub8.isCodepointModifiersRecord(new CodepointModifiersRecord(var1, 0))) {
            if (var2 == 1) {
               this.lambda();
            } else {
               super.keyTyped(var1, var2);
            }
         }
      }
   }

   private float getFloat() {
      long var1 = System.nanoTime();
      if (this.Ja == 0L) {
         this.Ja = var1;
         return 16.0F;
      } else {
         float var10000 = (float)(var1 - this.Ja) / 1000000.0F;
         this.Ja = var1;
         return Math.min(var10000, 100.0F);
      }
   }

   private void handleCls24(Cls2 var1) {
      float var5 = 382.0F;
      var5 = this.float_6 + (this.Ma - var5) / 2.0F;

      int var4;
      for(int var10000 = var4 = 0; var10000 < 9; var10000 = var4) {
         float var9 = var5 + 43.0F * (float)var4;
         this.list.add(new Slots.XYRecord(var9, this.float_7, 38.0F, 38.0F, (Cls6)null, var4));
         boolean var2 = this.Aa && var1.float_3 >= var9 && var1.float_3 < var9 + 38.0F && var1.float_2 >= this.float_7 && var1.float_2 < this.float_7 + 38.0F;
         float var6 = this.Ga[var4].getFloat();
         int var7 = Util4.getPrimaryOnPrimaryRecord().surfaceContainerHighest();
         int var8 = var2 ? Util4.getPrimaryOnPrimaryRecord().primaryContainer() : getIntForInt(var7, Util4.getPrimaryOnPrimaryRecord().secondaryContainer(), var6);
         this.Ia.handleFloat7(var9, this.float_7, 38.0F, 38.0F, 8.0F, var8);
         float var12;
         if ((var12 = Math.max(var6, var2 ? 1.0F : 0.0F)) > 0.01F) {
            this.Ia.handleFloat18(var9, this.float_7, 38.0F, 38.0F, 8.0F, 1.5F, Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().primary(), var12));
         }

         List var13;
         if (!(var13 = this.inventoryManagerModule.valueSettingSub7.getList7(var4)).isEmpty()) {
            this.handleItemStack(((Cls6)var13.get(0)).getItemStack(), var9 + 9.0F, this.float_7 + 13.0F + 2.5F, 20.0F);
         }

         if (var13.size() > 1) {
            this.Ia.handleOpticalWeightRecord7(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD13, (new StringBuilder()).insert(0, "+").append(var13.size() - 1).toString(), var9 + 38.0F - 3.0F, this.float_7 + 38.0F - 11.0F, Util4.getPrimaryOnPrimaryRecord().onSurface());
         }

         Sampler0 var14 = this.Ia;
         OpticalWeightRecord var10001 = client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD13;
         String var10002 = String.valueOf(var4 + 1);
         float var10003 = var9 + 19.0F;
         float var10004 = this.float_7 + 4.0F;
         int var10005 = Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant();
         float var10007 = 0.4F * var6;
         ++var4;
         var14.handleOpticalWeightRecord3(var10001, var10002, var10003, var10004, Util4.getIntForInt2(var10005, 0.55F + var10007));
      }

   }

   protected void mouseClickMove(int var1, int var2, int var3, long var4) {
      Slots var10000 = this;
      int var6 = var2;
      Slots var7 = var10000;
      if (var7.cls6 != null && !var7.Aa && (Math.abs((float)var1 - var7.la) > 3.0F || Math.abs((float)var6 - var7.float_4) > 3.0F)) {
         var7.Aa = true;
      }

      if (!var7.Aa) {
         var7.mouseClickMove(var1, var6, var3, var4);
      }
   }

   private void handleCls6(Cls6 var1) {
      if (var1 != null) {
         ValueSettingSub5 var2;
         if ((var2 = this.getValueSettingSub5()) != null) {
            var2.handleCls6(var1);
         } else if (this.inventoryManagerModule.valueSettingSub7.getList7(this.int_).contains(var1)) {
            this.inventoryManagerModule.valueSettingSub7.handleInt4(this.int_, var1);
         } else {
            this.inventoryManagerModule.valueSettingSub7.handleInt3(this.int_, var1);
         }
      }
   }

   private static float getFloatForFloat(float var0) {
      float var2 = 27.0F;
      return (float)Math.max(1, (int)((var0 + 5.0F) / var2)) * var2 - 5.0F;
   }

   private void handleItemStack(ItemStack var1, float var2, float var3, float var4) {
      if (var1 != null && var1.getItem() != null) {
         this.Ia.run36();
         this.Ia.handleFloat11(var2, var3);
         this.Ia.handleFloat12(var4 / 16.0F, 0.0F, 0.0F);
         this.Ia.handleItemStack(var1, 0.0F, 0.0F);
         this.Ia.run43();
      }
   }

   private String getString() {
      if (this.ja == 0) {
         return "Pick a slot, then click or drag an item onto it";
      } else {
         return this.ja == 1 ? "Never thrown away, even if the Drop list says so" : "Thrown away when Drop junk is on";
      }
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   private void handleCls22(Cls2 var1) {
      if (this.cls6 != null) {
         ItemStack var3 = this.cls6.getItemStack();
         this.handleItemStack(var3, var1.float_3 - 6.5F, var1.float_2 - 6.5F, 13.0F);
      }
   }

   private float getFloat2(Cls6 var1) {
      return 33.0F + this.Ia.getFloat17(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD16, this.getString2(var1)) + 4.0F + 9.0F;
   }

   private void handleCls62(Cls6 var1, int var2, float var3, float var4) {
      this.cls6 = var1;
      this.int_2 = var2;
      this.la = var3;
      this.float_4 = var4;
      this.Aa = false;
   }

   private boolean isCls6(Cls6 var1) {
      ValueSettingSub5 var3;
      return (var3 = this.getValueSettingSub5()) == null ? this.inventoryManagerModule.valueSettingSub7.getList7(this.int_).contains(var1) : var3.isCls6(var1);
   }

   private float getFloat3(Cls2 var1, float var2) {
      float var12 = this.float_8;
      var2 = var2;
      Cls6.SwordAxeEnum[] var4;
      int var5 = (var4 = Cls6.SwordAxeEnum.values()).length;

      int var6;
      for(int var10000 = var6 = 0; var10000 < var5; var10000 = var6) {
         Cls6 var7 = Cls6.getCls6ForSwordAxeEnum(var4[var6]);
         float var8 = this.getFloat2(var7);
         float var15 = this.float_8 + this.float_3 - 7.0F;
         if (var12 + var8 > var15 && var12 > this.float_8) {
            var12 = this.float_8;
            var2 += 27.0F;
         }

         boolean var9 = this.isCls6(var7);
         boolean var10 = var1.float_3 >= var12 && var1.float_3 < var12 + var8 && var1.float_2 >= var2 && var1.float_2 < var2 + 22.0F && var1.float_2 >= this.float_2 && var1.float_2 < this.float_9;
         int var11 = var9 ? Util4.getPrimaryOnPrimaryRecord().primaryContainer() : (var10 ? Util4.getPrimaryOnPrimaryRecord().surfaceContainerHighest() : Util4.getPrimaryOnPrimaryRecord().surfaceContainerHigh());
         this.Ia.handleFloat7(var12, var2, var8, 22.0F, Float.MAX_VALUE, var11);
         this.handleItemStack(var7.getItemStack(), var12 + 8.0F, var2 + 4.5F, 13.0F);
         this.Ia.handleOpticalWeightRecord9(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD16, this.getString2(var7), var12 + 8.0F + 13.0F + 4.0F, var2 + 11.0F, var9 ? Util4.getPrimaryOnPrimaryRecord().onPrimaryContainer() : Util4.getPrimaryOnPrimaryRecord().onSurface());
         if (var9) {
            Util.handleSampler06(this.Ia, var12 + var8 - 8.0F - 4.5F, var2 + 11.0F, 11.0F, Util4.getPrimaryOnPrimaryRecord().onPrimaryContainer());
         }

         this.list3.add(new Slots.XYRecord(var12, var2, var8, 22.0F, var7, -1));
         ++var6;
         var12 += var8 + 5.0F;
      }

      return var2 + 22.0F;
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      GuiComponentSub4[] var4;
      int var7 = (var4 = this.getGuiComponentSub4Array()).length;

      int var6;
      for(int var10000 = var6 = 0; var10000 < var7; var10000 = var6) {
         if (var4[var6].isFloat17((float)var1, (float)var2, var3)) {
            return;
         }

         ++var6;
      }

      if (!this.guiComponentSub9.isFloat17((float)var1, (float)var2, var3)) {
         if (!this.guiComponentSub8.isFloat17((float)var1, (float)var2, var3)) {
            if (var3 != 0) {
               super.mouseClicked(var1, var2, var3);
            } else {
               Iterator var8;
               Slots.XYRecord var9;
               Iterator var10;
               for(var10 = var8 = this.list.iterator(); var10.hasNext(); var10 = var8) {
                  if ((var9 = (Slots.XYRecord)var8.next()).isFloat((float)var1, (float)var2)) {
                     this.handleInt(var9.slot());
                     return;
                  }
               }

               for(var10 = var8 = this.list4.iterator(); var10.hasNext(); var10 = var8) {
                  if ((var9 = (Slots.XYRecord)var8.next()).isFloat((float)var1, (float)var2)) {
                     if ((float)var1 >= var9.x() + var9.width() - 8.0F - 9.0F - 2.0F) {
                        this.handleXYRecord(var9);
                        return;
                     }

                     this.handleCls62(var9.matcher(), var9.slot(), (float)var1, (float)var2);
                     return;
                  }
               }

               if ((float)var2 >= this.float_2 && (float)var2 < this.float_9) {
                  for(var10 = var8 = this.list3.iterator(); var10.hasNext(); var10 = var8) {
                     if ((var9 = (Slots.XYRecord)var8.next()).isFloat((float)var1, (float)var2)) {
                        this.handleCls62(var9.matcher(), -1, (float)var1, (float)var2);
                        return;
                     }
                  }

                  for(var10 = var8 = this.list2.iterator(); var10.hasNext(); var10 = var8) {
                     if ((var9 = (Slots.XYRecord)var8.next()).isFloat((float)var1, (float)var2)) {
                        this.handleCls62(var9.matcher(), -1, (float)var1, (float)var2);
                        return;
                     }
                  }
               }

               super.mouseClicked(var1, var2, var3);
            }
         }
      }
   }

   private void handleCls23(Cls2 var1, List<Cls6> var2, int var3) {
      if (var2.isEmpty()) {
         this.float_ = 0.0F;
         this.float_10 = 0.0F;
         this.Ia.handleOpticalWeightRecord8(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2, this.getString3(), this.float_8, this.Ka + 4.0F, Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.6F));
      } else {
         this.Ia.handleFloat24(this.float_8, this.Ka, this.float_3, this.float_5);
         float var4 = this.float_8;
         float var9 = this.Ka - this.float_10;

         Iterator var17;
         for(Iterator var10000 = var17 = var2.iterator(); var10000.hasNext(); var10000 = var17) {
            Cls6 var6 = (Cls6)var17.next();
            float var7 = this.getFloat2(var6);
            float var12 = this.float_8 + this.float_3 - 7.0F;
            if (var4 + var7 > var12 && var4 > this.float_8) {
               var4 = this.float_8;
               var9 += 27.0F;
            }

            if (var9 + 22.0F >= this.Ka) {
               float var15 = this.Ka + this.float_5;
               if (var9 < var15) {
                  boolean var8 = var1.float_3 >= var4 && var1.float_3 < var4 + var7 && var1.float_2 >= var9 && var1.float_2 < var9 + 22.0F;
                  this.Ia.handleFloat7(var4, var9, var7, 22.0F, Float.MAX_VALUE, var8 ? Util4.getPrimaryOnPrimaryRecord().secondaryContainer() : Util4.getPrimaryOnPrimaryRecord().surfaceContainerHighest());
                  this.handleItemStack(var6.getItemStack(), var4 + 8.0F, var9 + 4.5F, 13.0F);
                  this.Ia.handleOpticalWeightRecord9(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD16, this.getString2(var6), var4 + 8.0F + 13.0F + 4.0F, var9 + 11.0F, Util4.getPrimaryOnPrimaryRecord().onSurface());
                  Util.handleSampler0(this.Ia, var4 + var7 - 8.0F - 4.5F, var9 + 11.0F, 9.0F, Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), var8 ? 1.0F : 0.7F));
                  this.list4.add(new Slots.XYRecord(var4, var9, var7, 22.0F, var6, var3));
               }
            }

            var4 += var7 + 5.0F;
         }

         this.Ia.run38();
         this.float_ = Math.max(0.0F, var9 + 22.0F + this.float_10 - (this.Ka + this.float_5));
         this.float_10 = Math.min(this.float_10, this.float_);
         this.handleFloat2(this.Ka, this.float_5, this.float_10, this.float_);
      }
   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
      GuiComponentSub3.run194();
   }

   private GuiComponentSub4[] getGuiComponentSub4Array() {
      GuiComponentSub4[] var1 = new GuiComponentSub4[]{this.guiComponentSub42, this.aa, this.guiComponentSub4};
      return var1;
   }

   private static record XYRecord(float x, float y, float width, float height, Cls6 matcher, int slot) {
      public int slot() {
         return this.slot;
      }

      public float width() {
         return this.width;
      }

      public float y() {
         return this.y;
      }

      public float x() {
         return this.x;
      }

      public float height() {
         return this.height;
      }


      public Cls6 matcher() {
         return this.matcher;
      }

      boolean isFloat(float var1, float var2) {
         if (var1 >= this.x) {
            float var4 = this.x + this.width;
            if (var1 < var4 && var2 >= this.y) {
               float var7 = this.y + this.height;
               if (var2 < var7) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
