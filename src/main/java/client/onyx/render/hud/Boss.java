package client.onyx.render.hud;

import client.onyx.module.hud.CustomGuiModule;
import client.onyx.render.Sampler0;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import net.minecraft.entity.boss.BossStatus;

public final class Boss extends Abstract_ {
   private final client.onyx.render.misc.Cls cls2 = new client.onyx.render.misc.Cls(0.0F);
   private static final float FLOAT5 = 0.5F;
   private String string2;
   private float float_7;
   private final CustomGuiModule customGuiModule;
   private static final float FLOAT6 = 182.0F;
   private static final float FLOAT7 = 3.0F;
   private final client.onyx.render.misc.Cls cls3 = new client.onyx.render.misc.Cls(0.0F);
   private static final float FLOAT8 = 2.0F;
   private static final float FLOAT9 = 0.7F;
   private static final OpticalWeightRecord OPTICAL_WEIGHT_RECORD = new OpticalWeightRecord(
      client.onyx.render.font.Util.Pt9Pt24Enum.PT24, client.onyx.render.font.Util.ThinExtraLightEnum.BOLD, 12.0F, 15.0F
   );
   private static final float FLOAT10 = 10.0F;
   private static final float FLOAT11 = 6.0F;

   @Override
   protected float getFloat26(Sampler0 var1) {
      return 182.0F;
   }

   @Override
   protected boolean isBool(boolean var1) {
      if (BossStatus.bossName != null && BossStatus.statusBarTime > 0) {
         BossStatus.statusBarTime--;
         this.string2 = BossStatus.bossName;
         this.float_7 = Math.clamp(BossStatus.healthScale, 0.0F, 1.0F);
         return true;
      } else if (var1) {
         this.string2 = "Boss";
         this.float_7 = 0.7F;
         return true;
      } else {
         return false;
      }
   }

   @Override
   protected float getFloat25(Sampler0 var1) {
      return OPTICAL_WEIGHT_RECORD.lineHeight() + 3.0F + 6.0F;
   }

   public Boss(CustomGuiModule var1) {
      super(
         "mcgui:bossbar",
         var1.bossbarBooleanSetting.valueSettingSub102,
         var1.bossbarBooleanSetting.valueSettingSub10,
         var1.bossbarBooleanSetting.valueSettingSub103
      );
      this.string2 = "";
      this.customGuiModule = var1;
   }

   @Override
   protected void handleFloat36(float var1) {
      this.cls2.getCls2(this.float_7, 200.0F, client.onyx.render.misc.Util.IFACE2);
      this.cls2.handleFloat(var1);
      if (this.float_7 >= this.cls3.getFloat2()) {
         this.cls3.getCls(Math.max(this.float_7, this.cls2.getFloat()));
      } else {
         this.cls3.getCls2(this.float_7, 500.0F, client.onyx.render.misc.Util.IFACE);
         this.cls3.handleFloat(var1);
      }
   }

   @Override
   protected void handleSampler04(Sampler0 var1, float var2, float var3, float var4) {
      PrimaryOnPrimaryRecord var8 = client.onyx.theme.Util4.getPrimaryOnPrimaryRecord();
      Util2.getFloatForSampler05(
         var1,
         OPTICAL_WEIGHT_RECORD,
         this.string2,
         var2 / 2.0F,
         var1.getFloat19(OPTICAL_WEIGHT_RECORD, OPTICAL_WEIGHT_RECORD.lineHeight() / 2.0F),
         var8.onSurface()
      );
      var3 -= 6.0F;
      var1.handleFloat7(0.0F, var3, var2, 6.0F, Float.MAX_VALUE, var8.surfaceContainerHighest());
      if (this.customGuiModule.bossbarBooleanSetting.valueSettingSub92.isEnabled17()) {
         this.handleSampler03(var1, var8, var2, var3);
      } else {
         float var5;
         if ((var5 = var2 * this.cls3.getFloat()) > 0.5F) {
            var1.handleFloat7(0.0F, var3, var5, 6.0F, Float.MAX_VALUE, client.onyx.theme.Util4.getIntForInt2(var8.error(), 0.45F));
         }

         if ((var2 = var2 * this.cls2.getFloat()) > 0.5F) {
            var1.handleFloat7(0.0F, var3, var2, 6.0F, Float.MAX_VALUE, var8.error());
         }
      }
   }

   private void handleSampler03(Sampler0 var1, PrimaryOnPrimaryRecord var2, float var3, float var4) {
      float var5;
      float var6 = (var5 = (var3 + 2.0F) / 10.0F) - 2.0F;
      var3 *= this.cls2.getFloat();

      int var7;
      for (int var10000 = var7 = 0; var10000 < 10.0F; var10000 = var7) {
         float var8;
         if ((var8 = var7 * var5) >= var3) {
            return;
         }

         var1.handleFloat24(var8, var4, Math.min(var6, var3 - var8), 6.0F);
         var7++;
         var1.handleFloat7(var8, var4, var6, 6.0F, Float.MAX_VALUE, var2.error());
         var1.run38();
      }
   }
}
