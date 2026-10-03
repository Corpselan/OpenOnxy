package client.onyx.module.render;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.BooleanSettingSub;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.system.SelfEnemyEnum;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class GlowESPModule extends Module {
   private static final String STRING = "onyx_glow_outline";
   private static final String STRING2 = "entity_outline";
   public ValueSettingSub10 valueSettingSub10;
   private static final String STRING3 = "onyx_glow_fill";
   public final GlowESPModule.TargetsBooleanSetting targetsBooleanSetting = new GlowESPModule.TargetsBooleanSetting();
   public ValueSettingSub10 valueSettingSub102;
   public ValueSettingSub11<GlowESPModule.OutlineFillEnum> valueSettingSub112 = new ValueSettingSub11<>("Mode", GlowESPModule.OutlineFillEnum.OUTLINE);

   public static String getString22() {
      GlowESPModule var0;
      if ((var0 = getGlowESPModule()) == null || !var0.isEnabled55()) {
         return "entity_outline";
      } else {
         return var0.isEnabled66() ? "onyx_glow_fill" : "onyx_glow_outline";
      }
   }

   public static boolean isEntityLivingBase7(EntityLivingBase var0) {
      GlowESPModule var2;
      return (var2 = getGlowESPModule()) != null && var2.isEntityLivingBase6(var0);
   }

   public boolean isEnabled66() {
      return this.isEnabled55() && this.valueSettingSub112.isEnum3(GlowESPModule.OutlineFillEnum.FILL);
   }

   public GlowESPModule.ColorSettingGroup getColorSettingGroup4(EntityLivingBase var1) {
      if (!this.isEnabled55()) {
         return null;
      } else {
         SelfEnemyEnum var2;
         if ((var2 = SelfEnemyEnum.getSelfEnemyEnumForEntityLivingBase(var1)) == null) {
            return null;
         } else {
            GlowESPModule.ColorSettingGroup var3;
            return (var3 = this.targetsBooleanSetting.getColorSettingGroup5(var2)).isEnabled5() ? var3 : null;
         }
      }
   }

   public boolean isEntityLivingBase6(EntityLivingBase var1) {
      return this.getColorSettingGroup4(var1) != null;
   }

   public static GlowESPModule getGlowESPModule() {
      client.onyx.module.Cls var0 = OnyxClient.cls;
      return OnyxClient.cls == null ? null : var0.glowESPModule;
   }

   public static int getIntForEntityLivingBase(EntityLivingBase var0) {
      GlowESPModule var1;
      GlowESPModule.ColorSettingGroup var3 = (var1 = getGlowESPModule()) == null ? null : var1.getColorSettingGroup4(var0);
      return var3 == null ? 16777215 : var3.valueSettingSub6.getInt8() & 16777215;
   }

   public GlowESPModule() {
      super("GlowESP", "Outline glow or liquid-metal fill for selected entities", ModuleCategory.RENDER);
      this.valueSettingSub102 = new ValueSettingSub10("Radius", 14.0, 2.0, 24.0, 1.0)
         .getValueSettingSub10(" px")
         .getBooleanSetting("How far the glow spreads around the entity")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 == GlowESPModule.OutlineFillEnum.OUTLINE);
      this.valueSettingSub10 = new ValueSettingSub10("Intensity", 40.0, 10.0, 100.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Opacity of the outer glow");
   }

   public static boolean isEntity2(Entity var0) {
      GlowESPModule var2;
      return (var2 = getGlowESPModule()) == null || !var2.isEnabled55()
         ? var0 instanceof EntityPlayer
         : var0 instanceof EntityLivingBase && var2.isEntityLivingBase6((EntityLivingBase)var0);
   }

   public static boolean isEnabled65() {
      GlowESPModule var0;
      return (var0 = getGlowESPModule()) != null && var0.isEnabled55();
   }

   public static final class ColorSettingGroup extends SettingGroup {
      public final ValueSettingSub6 valueSettingSub6;

      private ColorSettingGroup(String var1, boolean var2, int var3, boolean var4) {
         super(var1, var2);
         this.valueSettingSub6 = new ValueSettingSub6("Color", var3);
         if (var4) {
            this.valueSettingSub6.getValueSettingSub6();
         }
      }
   }

   public static enum OutlineFillEnum {
      OUTLINE,
      FILL;

   }

   public static final class TargetsBooleanSetting extends BooleanSettingSub {
      public final GlowESPModule.ColorSettingGroup colorSettingGroup;
      public final GlowESPModule.ColorSettingGroup colorSettingGroup2;
      public final GlowESPModule.ColorSettingGroup colorSettingGroup3;
      public final GlowESPModule.ColorSettingGroup colorSettingGroup4 = new GlowESPModule.ColorSettingGroup("Self", false, -2562832, false);

      private TargetsBooleanSetting() {
         super("Targets", SelfEnemyEnum.STRING_ARRAY);
         this.colorSettingGroup3 = new GlowESPModule.ColorSettingGroup("Enemy", true, -8857601, false);
         this.colorSettingGroup = new GlowESPModule.ColorSettingGroup("Team", false, -8585312, false);
         this.colorSettingGroup2 = new GlowESPModule.ColorSettingGroup("Mobs", false, -3105793, false);
      }

      public GlowESPModule.ColorSettingGroup getColorSettingGroup5(SelfEnemyEnum var1) {
         switch (var1) {
            case SELF:

               return this.colorSettingGroup4;
            case ENEMY:
               return this.colorSettingGroup3;
            case TEAM:
               return this.colorSettingGroup;
            case MOBS:
               return this.colorSettingGroup2;
            default:
               throw new MatchException(null, null);
         }
      }
   }
}
