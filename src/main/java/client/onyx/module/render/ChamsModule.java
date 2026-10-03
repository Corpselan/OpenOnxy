package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.BooleanSettingSub;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.SelfEnemyEnum;
import client.onyx.theme.impl.Util2;
import net.minecraft.entity.EntityLivingBase;

public class ChamsModule extends Module {
   public final ChamsModule.TargetsBooleanSetting targetsBooleanSetting;

   public float getFloat42(SelfEnemyEnum var1) {
      ChamsModule.ColorSettingGroup var2;
      return (var2 = this.targetsBooleanSetting.getColorSettingGroup3(var1)).valueSettingSub92.isEnabled17()
         ? var2.valueSettingSub103.getFloat5() / 100.0F
         : 0.0F;
   }

   public int getInt30(SelfEnemyEnum var1) {
      ChamsModule.ColorSettingGroup var10000 = this.targetsBooleanSetting.getColorSettingGroup3(var1);
      int var2 = Math.round(Math.clamp(var10000.valueSettingSub10.getFloat5() / 100.0F, 0.05F, 1.0F) * 255.0F);
      return Util2.getIntForInt4(var10000.valueSettingSub6.getInt8(), var2);
   }

   public float getFloat41(SelfEnemyEnum var1) {
      return this.targetsBooleanSetting.getColorSettingGroup3(var1).valueSettingSub104.getFloat5() / 100.0F;
   }

   public ChamsModule.ColorSettingGroup getColorSettingGroup2(SelfEnemyEnum var1) {
      return this.targetsBooleanSetting.getColorSettingGroup3(var1);
   }

   public boolean isSelfEnemyEnum(SelfEnemyEnum var1) {
      return this.targetsBooleanSetting.getColorSettingGroup3(var1).valueSettingSub93.isEnabled17();
   }

   public ChamsModule() {
      super("Chams", "Reskins entities with a graded color tint on the model itself", ModuleCategory.RENDER);
      ChamsModule.TargetsBooleanSetting var1 = new ChamsModule.TargetsBooleanSetting();
      this.targetsBooleanSetting = var1;
   }

   public SelfEnemyEnum getSelfEnemyEnum(EntityLivingBase var1) {
      if (!this.isEnabled55()) {
         return null;
      } else {
         SelfEnemyEnum var2;
         if ((var2 = SelfEnemyEnum.getSelfEnemyEnumForEntityLivingBase(var1)) == null) {
            return null;
         } else {
            return this.targetsBooleanSetting.getColorSettingGroup3(var2).isEnabled5() ? var2 : null;
         }
      }
   }

   public static final class ColorSettingGroup extends SettingGroup {
      public final ValueSettingSub6 valueSettingSub6;
      public final ValueSettingSub9 valueSettingSub92;
      public final ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub9 valueSettingSub93;
      public final ValueSettingSub10 valueSettingSub102;
      public final ValueSettingSub10 valueSettingSub103;
      public final ValueSettingSub10 valueSettingSub104;

      private ColorSettingGroup(String var1, boolean var2, int var3, boolean var4) {
         super(var1, var2);
         this.valueSettingSub6 = new ValueSettingSub6("Color", var3);
         if (var4) {
            this.valueSettingSub6.getValueSettingSub6();
         }

         this.valueSettingSub10 = new ValueSettingSub10("Opacity", 100.0, 5.0, 100.0, 5.0).getValueSettingSub10("%");
         this.valueSettingSub102 = new ValueSettingSub10("Strength", 70.0, 0.0, 100.0, 5.0)
            .getValueSettingSub10("%")
            .getBooleanSetting("How far the skin is graded towards the tint - at 0% the skin is left exactly as the game drew it");
         this.valueSettingSub92 = new ValueSettingSub9("Keep model", false).getBooleanSetting("Leaves the untouched model visible under the shading");
         this.valueSettingSub103 = new ValueSettingSub10("Model opacity", 50.0, 0.0, 100.0, 5.0)
            .getValueSettingSub10("%")
            .getSetting2(this.valueSettingSub92::isEnabled17);
         this.valueSettingSub93 = new ValueSettingSub9("Through walls", false)
            .getBooleanSetting("Draws a second pass that ignores depth, so the model stays readable behind blocks");
         this.valueSettingSub104 = new ValueSettingSub10("Wall opacity", 40.0, 5.0, 100.0, 5.0)
            .getValueSettingSub10("%")
            .getBooleanSetting("How strong the occluded pass is against the visible one")
            .getSetting2(this.valueSettingSub93::isEnabled17);
      }
   }

   public static final class TargetsBooleanSetting extends BooleanSettingSub {
      public final ChamsModule.ColorSettingGroup colorSettingGroup;
      public final ChamsModule.ColorSettingGroup colorSettingGroup2;
      public final ChamsModule.ColorSettingGroup colorSettingGroup3;
      public final ChamsModule.ColorSettingGroup colorSettingGroup4 = new ChamsModule.ColorSettingGroup("Self", false, -2562832, true);

      private TargetsBooleanSetting() {
         super("Targets", SelfEnemyEnum.STRING_ARRAY);
         this.colorSettingGroup3 = new ChamsModule.ColorSettingGroup("Enemy", true, -3910337, true);
         this.colorSettingGroup2 = new ChamsModule.ColorSettingGroup("Team", false, -8585312, false);
         this.colorSettingGroup = new ChamsModule.ColorSettingGroup("Mobs", false, -3105793, false);
      }

      public ChamsModule.ColorSettingGroup getColorSettingGroup3(SelfEnemyEnum var1) {
         switch (var1) {
            case SELF:

               return this.colorSettingGroup4;
            case ENEMY:
               return this.colorSettingGroup3;
            case TEAM:
               return this.colorSettingGroup2;
            case MOBS:
               return this.colorSettingGroup;
            default:
               throw new MatchException(null, null);
         }
      }
   }
}
