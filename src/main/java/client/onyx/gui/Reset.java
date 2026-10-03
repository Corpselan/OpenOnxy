package client.onyx.gui;

import client.onyx.OnyxClient;
import client.onyx.gui.component.GuiComponentSub4;
import client.onyx.gui.component.SettingComponent;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import client.onyx.module.hud.TargetHUDModule;
import client.onyx.module.hud.targethud.TextSettingGroup;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.theme.Util4;
import client.onyx.theme.Util5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;

public class Reset extends GuiScreen {
   private final GuiScreen guiScreen;
   private static final float FLOAT = 16.0F;
   private float float_;
   private static final float FLOAT2 = 2.0F;
   private static final float FLOAT3 = 12.0F;
   private static final float FLOAT4 = 100.0F;
   private static final float FLOAT5 = 46.0F;
   private float float_2;
   private final GuiComponentSub4 guiComponentSub4;
   private static final float FLOAT6 = 210.0F;
   private TextSettingGroup textSettingGroup;
   private final List<float[]> list;
   private static final float FLOAT7 = 9.0F;
   private final TargetHUDModule targetHUDModule;
   private float float_3;
   private float float_4;
   private static final float FLOAT8 = 20.0F;
   private long long_;
   private float float_5;
   private final client.onyx.gui.component.Cls2 cls2;
   private float float_6;
   private static final float FLOAT9 = 120.0F;
   private float float_7;
   private static final float FLOAT10 = 10.0F;
   private TextSettingGroup textSettingGroup2;
   private static final float FLOAT11 = 2.4F;
   private static final float FLOAT12 = 12.0F;
   private float float_8;
   private client.onyx.render.guide.Util3.XYRecord xYRecord;
   private float float_9;
   private TargetHUDModule.WidthHeightRecord widthHeightRecord;
   private final GuiComponentSub4 guiComponentSub42;
   private float float_10;
   private float float_11;
   private float float_12;
   private float float_13;
   private static final float FLOAT13 = 5.0F;
   private final Sampler0 sampler0;

   protected void keyTyped(char var1, int var2) throws IOException {
      KeyScancodeRecord var4 = new KeyScancodeRecord(var2, 0, 0, var1);
      Iterator var6 = this.cls2.getList().iterator();

      while(var6.hasNext()) {
         if (((SettingComponent)var6.next()).isKeyScancodeRecord3(var4)) {
            return;
         }
      }

      if (var1 >= ' ') {
         CodepointModifiersRecord var8 = new CodepointModifiersRecord(var1, 0);
         Iterator var5 = this.cls2.getList().iterator();

         while(var5.hasNext()) {
            if (((SettingComponent)var5.next()).isCodepointModifiersRecord(var8)) {
               return;
            }
         }
      }

      if (var2 == 1) {
         this.lambda();
      } else {
         super.keyTyped(var1, var2);
      }
   }

   public void initGui() {
      this.long_ = 0L;
      if (this.textSettingGroup == null) {
         TextSettingGroup var4 = (TextSettingGroup)this.targetHUDModule.getList23().get(0);
         this.textSettingGroup = var4;
      }

      this.run2();
   }

   public void onGuiClosed() {
      this.targetHUDModule.run122();
   }

   private void run() {
      float var4 = 100.0F;
      float var2 = (float)this.width - 210.0F - 12.0F;
      float var3 = (float)this.height - 46.0F + 10.0F;
      this.guiComponentSub42.handleFloat80(var2, var3, var4, 30.0F);
      this.guiComponentSub4.handleFloat80(var2 + var4 + 10.0F, var3, var4, 30.0F);
   }

   public void handleMouseInput() throws IOException {
      int var1;
      if ((var1 = Mouse.getEventDWheel()) != 0) {
         ScaledResolution var4 = new ScaledResolution(this.mc);
         float var3 = (float)(Mouse.getEventX() * var4.getScaledWidth()) / (float)this.mc.displayWidth;
         float var8 = (float)var4.getScaledHeight() - (float)(Mouse.getEventY() * var4.getScaledHeight()) / (float)this.mc.displayHeight - 1.0F;
         if (var3 >= (float)this.width - 210.0F - 12.0F && var8 >= this.float_7) {
            float var6 = this.float_7 + this.float_13;
            if (var8 < var6) {
               this.float_3 = Math.clamp(this.float_3 - (float)var1 / 120.0F * 40.0F, 0.0F, Math.max(0.0F, this.float_9 - this.float_13));
               return;
            }
         }
      }

      super.handleMouseInput();
   }

   private List<float[]> getList(TextSettingGroup var1) {
      ArrayList var4 = new ArrayList();
      Iterator var3;
      Iterator var10000 = var3 = this.widthHeightRecord.parts().iterator();

      while(var10000.hasNext()) {
         TargetHUDModule.SettingsTextRecord var5;
         if ((var5 = (TargetHUDModule.SettingsTextRecord)var3.next()).settings() == var1) {
            var10000 = var3;
         } else {
            float[] var10001 = new float[4];
            boolean var10003 = true;
            var10001[0] = var5.x();
            var10001[1] = var5.y();
            var10001[2] = var5.width();
            var10001[3] = var5.height();
            var4.add(var10001);
            var10000 = var3;
         }
      }

      return var4;
   }

   private float[] getFloatArray(TargetHUDModule.SettingsTextRecord var1) {
      float[] var10000 = new float[4];
      boolean var10002 = true;
      var10000[0] = this.float_5 + var1.x() * 2.4F;
      var10000[1] = this.float_6 + var1.y() * 2.4F;
      var10000[2] = Math.max(var1.width(), 1.0F) * 2.4F;
      var10000[3] = Math.max(var1.height(), 1.0F) * 2.4F;
      return var10000;
   }

   protected void mouseReleased(int var1, int var2, int var3) {
      this.textSettingGroup2 = null;
      this.xYRecord = client.onyx.render.guide.Util3.X_Y_RECORD;

      Iterator var4;
      for(Iterator var10000 = var4 = this.cls2.getList().iterator(); var10000.hasNext(); var10000 = var4) {
         ((SettingComponent)var4.next()).isFloat19((float)var1, (float)var2, var3);
      }

      this.guiComponentSub42.isFloat19((float)var1, (float)var2, var3);
      this.guiComponentSub4.isFloat19((float)var1, (float)var2, var3);
      super.mouseReleased(var1, var2, var3);
   }

   private TargetHUDModule.SettingsTextRecord getSettingsTextRecord(TextSettingGroup var1) {
      Iterator var4 = this.widthHeightRecord.parts().iterator();

      TargetHUDModule.SettingsTextRecord var3;
      do {
         if (!var4.hasNext()) {
            return null;
         }
      } while((var3 = (TargetHUDModule.SettingsTextRecord)var4.next()).settings() != var1);

      return var3;
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

   private static boolean isFloatArray(float[] var0, float var1, float var2) {
      return var1 >= var0[0] && var1 <= var0[0] + var0[2] && var2 >= var0[1] && var2 <= var0[1] + var0[3];
   }

   private void handleFloat(float var1, float var2) {
      if (this.widthHeightRecord != null) {
         TargetHUDModule.SettingsTextRecord var4;
         if ((var4 = this.getSettingsTextRecord(this.textSettingGroup2)) != null) {
            var1 = (var1 - this.float_11 - this.float_5) / 2.4F;
            var2 = (var2 - this.float_12 - this.float_6) / 2.4F;
            this.xYRecord = client.onyx.render.guide.Util3.getXYRecordForFloat2(var1, var2, var4.width(), var4.height(), this.widthHeightRecord.width(), this.widthHeightRecord.height(), 0.0F, this.getList(this.textSettingGroup2));
            this.textSettingGroup2.valueSettingSub102.handleObject2((double)(this.xYRecord.x() - this.float_8));
            this.textSettingGroup2.valueSettingSub103.handleObject2((double)(this.xYRecord.y() - this.float_10));
         }
      }
   }

   private void handleInt2(int var1, int var2) {
      float var4 = (float)this.width - 210.0F - 12.0F;
      float var6 = 12.0F;
      float var5 = (float)this.height - 46.0F;
      this.sampler0.handleFloat7(var4, var6, 210.0F, var5 - var6, 16.0F, Util5.getIntForInt(2, Util4.getPrimaryOnPrimaryRecord()));
      var6 += 12.0F;
      this.sampler0.handleOpticalWeightRecord2(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD18, "Elements", var4 + 12.0F, var6, Util4.getPrimaryOnPrimaryRecord().onSurface());
      var6 += client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD18.lineHeight() + 4.0F;
      var6 = this.getFloat2(var4 + 12.0F, var6, 186.0F, var1, var2) + 8.0F;
      this.sampler0.handleFloat28(var4 + 12.0F, var6, 186.0F, 1.0F, Util4.getPrimaryOnPrimaryRecord().outlineVariant());
      this.float_7 = var6 += 10.0F;
      this.float_13 = Math.max(0.0F, var5 - 12.0F - this.float_7);
      Cls2 var7 = new Cls2(this.sampler0, this.float_4, (float)var1, (float)var2);
      float var8 = var4 + 12.0F;
      var4 = 186.0F;
      Iterator var10;
      Iterator var10000 = var10 = this.cls2.getList().iterator();

      SettingComponent var9;
      while(var10000.hasNext()) {
         var9 = (SettingComponent)var10.next();
         var10000 = var10;
         var9.handleCls28(var7);
      }

      this.float_9 = this.cls2.getFloat(var8, this.float_7 - this.float_3, var4);
      this.float_3 = Math.clamp(this.float_3, 0.0F, Math.max(0.0F, this.float_9 - this.float_13));
      this.float_9 = this.cls2.getFloat(var8, this.float_7 - this.float_3, var4);
      this.sampler0.handleFloat24(var8, this.float_7, var4, this.float_13);
      this.cls2.handleSampler0(this.sampler0, var8, var4, Util4.getPrimaryOnPrimaryRecord().outlineVariant(), 1.0F);
      var10000 = var10 = this.cls2.getList().iterator();

      while(var10000.hasNext()) {
         var9 = (SettingComponent)var10.next();
         var10000 = var10;
         var9.handleCls27(var7);
      }

      this.sampler0.run38();
      this.run();
      this.guiComponentSub42.handleCls28(var7);
      this.guiComponentSub4.handleCls28(var7);
      this.guiComponentSub42.handleCls27(var7);
      this.guiComponentSub4.handleCls27(var7);
   }

   private float getFloat2(float var1, float var2, float var3, int var4, int var5) {
      this.list.clear();
      float var14 = var1;
      var2 = var2;

      Iterator var7;
      float var10;
      for(Iterator var10000 = var7 = this.targetHUDModule.getList23().iterator(); var10000.hasNext(); var14 += var10 + 5.0F) {
         TextSettingGroup var8;
         String var9 = (var8 = (TextSettingGroup)var7.next()).getAvatarNameEnum().getString5();
         var10 = this.sampler0.getFloat17(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2, var9) + 18.0F;
         if (var14 > var1 && var14 + var10 > var1 + var3) {
            var14 = var1;
            var2 += 25.0F;
         }

         boolean var11 = var8 == this.textSettingGroup;
         boolean var12 = (float)var4 >= var14 && (float)var4 < var14 + var10 && (float)var5 >= var2 && (float)var5 < var2 + 20.0F;
         int var13 = var11 ? Util4.getPrimaryOnPrimaryRecord().secondaryContainer() : Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurface(), var12 ? 0.1F : 0.04F);
         int var15 = var11 ? Util4.getPrimaryOnPrimaryRecord().onSecondaryContainer() : Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), var8.isEnabled92() ? 1.0F : 0.45F);
         var10000 = var7;
         this.sampler0.handleFloat7(var14, var2, var10, 20.0F, Float.MAX_VALUE, var13);
         this.sampler0.handleOpticalWeightRecord4(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2, var9, var14 + var10 / 2.0F, var2 + 10.0F, var15);
         float[] var10002 = new float[4];
         boolean var10004 = true;
         var10002[0] = var14;
         var10002[1] = var2;
         var10002[2] = var10;
         var10002[3] = 20.0F;
         this.list.add(var10002);
      }

      return var2 + 20.0F;
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      int var5;
      if (var3 == 0) {
         for(int var10000 = var5 = 0; var10000 < this.list.size(); var10000 = var5) {
            if (isFloatArray((float[])this.list.get(var5), (float)var1, (float)var2)) {
               TextSettingGroup var9 = (TextSettingGroup)this.targetHUDModule.getList23().get(var5);
               this.handleTextSettingGroup(var9);
               return;
            }

            ++var5;
         }
      }

      Iterator var10 = this.cls2.getList().iterator();

      do {
         if (!var10.hasNext()) {
            if (this.guiComponentSub42.isFloat17((float)var1, (float)var2, var3)) {
               return;
            }

            if (this.guiComponentSub4.isFloat17((float)var1, (float)var2, var3)) {
               return;
            }

            if (var3 == 0 && this.isFloat((float)var1, (float)var2)) {
               return;
            }

            super.mouseClicked(var1, var2, var3);
            return;
         }
      } while(!((SettingComponent)var10.next()).isFloat17((float)var1, (float)var2, var3));

   }

   private void handleSettingsTextRecord(TargetHUDModule.SettingsTextRecord var1, int var2, int var3) {
      boolean var4 = var1.settings() == this.textSettingGroup;
      float[] var6 = this.getFloatArray(var1);
      boolean var5 = var4 || this.textSettingGroup2 == null && isFloatArray(var6, (float)var2, (float)var3);
      if (var5) {
         var2 = var4 ? Util4.getPrimaryOnPrimaryRecord().primary() : Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurface(), 0.45F);
         Sampler0 var10000 = this.sampler0;
         float var10001 = var6[0] - 2.0F;
         float var10002 = var6[1] - 2.0F;
         float var10003 = var6[2] + 4.0F;
         float var10004 = var6[3] + 4.0F;
         float var10006;
         int var10007;
         if (var4) {
            var10006 = 1.5F;
            var10007 = var2;
         } else {
            var10006 = 1.0F;
            var10007 = var2;
         }

         var10000.handleFloat18(var10001, var10002, var10003, var10004, 4.0F, var10006, var10007);
      }
   }

   private void handleTextSettingGroup(TextSettingGroup var1) {
      if (this.textSettingGroup != var1) {
         this.textSettingGroup = var1;
         this.run2();
      }
   }

   private void run2() {
      this.cls2.run();
      this.float_3 = 0.0F;
      if (this.textSettingGroup != null) {
         ArrayList var2;
         (var2 = new ArrayList()).add(this.textSettingGroup.getValueSettingSub9());
         var2.addAll(this.textSettingGroup.getList2());
         this.cls2.handleList(var2);
      }
   }

   public Reset(GuiScreen var1) {
      this.targetHUDModule = OnyxClient.cls.targetHUDModule;
      this.sampler0 = new Sampler0();
      this.cls2 = new client.onyx.gui.component.Cls2();
      this.guiComponentSub42 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.OUTLINED, "Reset", () -> {
         if (this.textSettingGroup != null) {
            this.textSettingGroup.run124();
         }
      });
      this.guiComponentSub4 = new GuiComponentSub4(GuiComponentSub4.FilledTonalEnum.FILLED, "Done", this::lambda);
      this.xYRecord = client.onyx.render.guide.Util3.X_Y_RECORD;
      this.list = new ArrayList();
      this.guiScreen = var1;
   }

   private void handleInt(int var1, int var2) {
      this.float_ = this.widthHeightRecord.width() * 2.4F;
      this.float_2 = this.widthHeightRecord.height() * 2.4F;
      this.float_5 = ((float)this.width - 210.0F - 12.0F) / 2.0F - this.float_ / 2.0F;
      this.float_6 = (float)this.height / 2.0F - this.float_2 / 2.0F;
      this.sampler0.run36();
      this.sampler0.handleFloat11(this.float_5, this.float_6);
      this.sampler0.handleFloat12(2.4F, 0.0F, 0.0F);
      this.targetHUDModule.handleSampler044(this.sampler0, Util4.getPrimaryOnPrimaryRecord(), this.widthHeightRecord, false);
      if (this.textSettingGroup2 != null) {
         Sampler0 var6 = this.sampler0;
         float var7 = this.widthHeightRecord.width();
         float var8 = this.widthHeightRecord.height();
         client.onyx.render.guide.Util3.handleSampler02(var6, var7, var8, this.xYRecord);
      }

      this.sampler0.run43();
      Iterator var5;
      Iterator var10000 = var5 = this.widthHeightRecord.parts().iterator();

      while(var10000.hasNext()) {
         TargetHUDModule.SettingsTextRecord var4 = (TargetHUDModule.SettingsTextRecord)var5.next();
         var10000 = var5;
         this.handleSettingsTextRecord(var4, var1, var2);
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.float_4 = this.getFloat();
      this.sampler0.run42();
      Reset var10000;
      if (this.mc.theWorld != null) {
         this.sampler0.handleFloat28(0.0F, 0.0F, (float)this.width, (float)this.height, Util4.getIntForFloat(0.55F));
         var10000 = this;
      } else {
         this.sampler0.handleFloat13(0.0F, 0.0F, (float)this.width, (float)this.height);
         var10000 = this;
      }

      var10000.widthHeightRecord = this.targetHUDModule.getWidthHeightRecord(this.sampler0, Util4.getPrimaryOnPrimaryRecord(), this.float_4);
      var3 = (float)this.width - 210.0F - 12.0F;
      this.sampler0.handleOpticalWeightRecord3(client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD14, "Target HUD", var3 / 2.0F, 22.0F, Util4.getPrimaryOnPrimaryRecord().onSurface());
      Sampler0 var4 = this.sampler0;
      OpticalWeightRecord var10001 = client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD2;
      String var10002;
      float var10003;
      if (this.widthHeightRecord == null) {
         var10002 = "Join a world to preview the card";
         var10003 = var3;
      } else {
         var10002 = "Drag an element to move it, or pick one to edit";
         var10003 = var3;
      }

      var4.handleOpticalWeightRecord3(var10001, var10002, var10003 / 2.0F, 44.0F, Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.85F));
      if (this.widthHeightRecord != null) {
         this.handleInt(var1, var2);
      }

      this.handleInt2(var1, var2);
      this.sampler0.run39();
   }

   private boolean isFloat(float var1, float var2) {
      if (this.widthHeightRecord == null) {
         return false;
      } else {
         int var4;
         List var5;
         for(int var10000 = var4 = (var5 = this.widthHeightRecord.parts()).size() - 1; var10000 >= 0; var10000 = var4) {
            TargetHUDModule.SettingsTextRecord var7 = (TargetHUDModule.SettingsTextRecord)var5.get(var4);
            float[] var6;
            if (isFloatArray(var6 = this.getFloatArray(var7), var1, var2)) {
               this.handleTextSettingGroup(var7.settings());
               this.textSettingGroup2 = var7.settings();
               this.float_11 = var1 - var6[0];
               this.float_12 = var2 - var6[1];
               this.float_8 = var7.x() - var7.settings().valueSettingSub102.getFloat5();
               this.float_10 = var7.y() - var7.settings().valueSettingSub103.getFloat5();
               return true;
            }

            --var4;
         }

         return false;
      }
   }

   protected void mouseClickMove(int var1, int var2, int var3, long var4) {
      Reset var6 = this;
      if (this.textSettingGroup2 != null) {
         this.handleFloat((float)var1, (float)var2);
      } else {
         Iterator var7 = this.cls2.getList().iterator();

         do {
            if (!var7.hasNext()) {
               var6.mouseClickMove(var1, var2, var3, var4);
               return;
            }
         } while(!((SettingComponent)var7.next()).isFloat18((float)var1, (float)var2, var3, 0.0F, 0.0F));

      }
   }
}
