package client.onyx.render.hud;

import client.onyx.module.hud.CustomGuiModule;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public final class Subtitle extends Abstract_ {
   private String string2 = "";
   private static final String STRING = "Title";
   private static final OpticalWeightRecord OPTICAL_WEIGHT_RECORD2 = new OpticalWeightRecord(
      client.onyx.render.font.Util.Pt9Pt24Enum.PT72, client.onyx.render.font.Util.ThinExtraLightEnum.BOLD, 36.0F, 44.0F
   );
   private static final float FLOAT5 = 120.0F;
   private float float_7;
   private String string3 = "";
   private static final float FLOAT6 = 0.88F;
   private static final float FLOAT7 = 6.0F;
   private static final String STRING2 = "Subtitle";
   private static final float FLOAT8 = 0.6F;
   private float float_8;
   private static final OpticalWeightRecord OPTICAL_WEIGHT_RECORD = new OpticalWeightRecord(
      client.onyx.render.font.Util.Pt9Pt24Enum.PT24, client.onyx.render.font.Util.ThinExtraLightEnum.SEMI_BOLD, 16.0F, 24.0F
   );

   @Override
   protected boolean isBool(boolean var1) {
      GuiIngame var3;
      if ((var3 = Minecraft.getMinecraft().ingameGUI) != null && var3.getTitlesTimer() > 0) {
         this.string2 = var3.getDisplayedTitle() == null ? "" : var3.getDisplayedTitle();
         this.string3 = var3.getDisplayedSubTitle() == null ? "" : var3.getDisplayedSubTitle();
         if (!this.string2.isEmpty() || !this.string3.isEmpty()) {
            return this.isGuiIngame(var3);
         }
      }

      if (var1) {
         this.string2 = "Title";
         this.string3 = "Subtitle";
         this.float_7 = 1.0F;
         this.float_8 = 1.0F;
         return true;
      } else {
         this.float_7 = 0.0F;
         return false;
      }
   }

   public Subtitle(CustomGuiModule var1) {
      super("mcgui:title", var1.titleBooleanSetting.valueSettingSub102, var1.titleBooleanSetting.valueSettingSub10, var1.titleBooleanSetting.valueSettingSub103);
   }

   private boolean isGuiIngame(GuiIngame var1) {
      float var2 = var1.getTitlesTimer();
      int var5 = Math.max(1, var1.getTitleFadeIn());
      int var4 = Math.max(1, var1.getTitleFadeOut());
      float var3 = 1.0F;
      this.float_8 = 1.0F;
      Subtitle var10000;
      if (var2 > var1.getTitleFadeOut() + var1.getTitleDisplayTime()) {
         var3 = Math.clamp((var5 + var1.getTitleDisplayTime() + var1.getTitleFadeOut() - var2) / var5, 0.0F, 1.0F);
         var10000 = this;
         this.float_8 = Math.clamp(var3 / 0.6F, 0.0F, 1.0F);
      } else {
         if (var2 <= var1.getTitleFadeOut()) {
            var3 = Math.clamp(var2 / var4, 0.0F, 1.0F);
         }

         var10000 = this;
      }

      var10000.float_7 = (float)client.onyx.render.misc.Util.IFACE2.getDouble(var3);
      return this.float_7 > 0.03F;
   }

   @Override
   protected float getFloat26(Sampler0 var1) {
      return Math.max(
         120.0F,
         Math.max(Util2.getFloatForSampler04(var1, OPTICAL_WEIGHT_RECORD2, this.string2), Util2.getFloatForSampler04(var1, OPTICAL_WEIGHT_RECORD, this.string3))
      );
   }

   @Override
   protected void handleSampler04(Sampler0 var1, float var2, float var3, float var4) {
      PrimaryOnPrimaryRecord var7 = client.onyx.theme.Util4.getPrimaryOnPrimaryRecord();
      float var5 = (float)client.onyx.render.misc.Util.IFACE7.getDouble(this.float_8);
      var5 = 0.88F + 0.120000005F * var5;
      var1.handleFloat10(this.float_7);
      var1.run36();
      var1.handleFloat12(var5, var2 / 2.0F, var3 / 2.0F);
      var3 = 0.0F;
      if (!this.string2.isEmpty()) {
         Util2.getFloatForSampler05(
            var1,
            OPTICAL_WEIGHT_RECORD2,
            this.string2,
            var2 / 2.0F,
            var1.getFloat19(OPTICAL_WEIGHT_RECORD2, var3 + OPTICAL_WEIGHT_RECORD2.lineHeight() / 2.0F),
            var7.onSurface()
         );
         var3 += OPTICAL_WEIGHT_RECORD2.lineHeight() + 6.0F;
      }

      if (!this.string3.isEmpty()) {
         Util2.getFloatForSampler05(
            var1,
            OPTICAL_WEIGHT_RECORD,
            this.string3,
            var2 / 2.0F,
            var1.getFloat19(OPTICAL_WEIGHT_RECORD, var3 + OPTICAL_WEIGHT_RECORD.lineHeight() / 2.0F),
            var7.onSurfaceVariant()
         );
      }

      var1.run43();
      var1.run40();
   }

   @Override
   protected float getFloat25(Sampler0 var1) {
      float var2 = this.string2.isEmpty() ? 0.0F : OPTICAL_WEIGHT_RECORD2.lineHeight();
      if (!this.string3.isEmpty()) {
         var2 += (var2 > 0.0F ? 6.0F : 0.0F) + OPTICAL_WEIGHT_RECORD.lineHeight();
      }

      return var2;
   }
}
