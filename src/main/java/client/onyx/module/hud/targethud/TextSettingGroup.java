package client.onyx.module.hud.targethud;

import client.onyx.setting.Setting;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.ValueSetting;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub4;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import java.util.Iterator;
import java.util.function.IntSupplier;

public final class TextSettingGroup extends SettingGroup {
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub10 valueSettingSub102;
   private static final double DOUBLE = 150.0;
   public ValueSettingSub6 valueSettingSub6;
   public ValueSettingSub10 valueSettingSub103;
   public ValueSettingSub4 valueSettingSub4;
   public ValueSettingSub10 valueSettingSub104;
   public ValueSettingSub9 valueSettingSub92;
   private final AvatarNameEnum avatarNameEnum;
   public ValueSettingSub9 valueSettingSub93;
   public ValueSettingSub11<client.onyx.render.font.Util.ThinExtraLightEnum> valueSettingSub11;
   public ValueSettingSub10 valueSettingSub105;
   public ValueSettingSub11<NumberHeartsEnum> valueSettingSub112;

   public boolean isEnabled92() {
      return this.isEnabled5();
   }

   public float getFloat87() {
      return this.avatarNameEnum.isEnabled9() ? 1.0F : this.valueSettingSub104.getFloat5();
   }

   public TextSettingGroup(AvatarNameEnum var1, boolean var2, String var3, IntSupplier var4) {
      super(var1.getString5(), var2);
      this.avatarNameEnum = var1;
      this.valueSettingSub4 = new ValueSettingSub4("Text", var3).getBooleanSetting("Supports {name} {health} {max} {hearts} {distance} {status}");
      handleSetting2(this.valueSettingSub4, var1.isEnabled11());
      this.valueSettingSub112 = new ValueSettingSub11<>("Readout", NumberHeartsEnum.NUMBER).getBooleanSetting("How {health} and {max} are written out");
      handleSetting2(this.valueSettingSub112, var1.isEnabled10());
      client.onyx.render.font.Util.ThinExtraLightEnum var10004 = client.onyx.render.font.Util.ThinExtraLightEnum.MEDIUM;
      client.onyx.render.font.Util.ThinExtraLightEnum[] var10005 = new client.onyx.render.font.Util.ThinExtraLightEnum[5];
      boolean var10007 = true;
      var10005[0] = client.onyx.render.font.Util.ThinExtraLightEnum.LIGHT;
      var10005[1] = client.onyx.render.font.Util.ThinExtraLightEnum.REGULAR;
      var10005[2] = client.onyx.render.font.Util.ThinExtraLightEnum.MEDIUM;
      var10005[3] = client.onyx.render.font.Util.ThinExtraLightEnum.SEMI_BOLD;
      var10005[4] = client.onyx.render.font.Util.ThinExtraLightEnum.BOLD;
      this.valueSettingSub11 = new ValueSettingSub11<>("Weight", var10004, var10005).getBooleanSetting("Font weight");
      handleSetting2(this.valueSettingSub11, var1.isEnabled11());
      this.valueSettingSub104 = new ValueSettingSub10("Size", 1.0, 0.25, 3.0, 0.05).getValueSettingSub10("x");
      handleSetting2(this.valueSettingSub104, !var1.isEnabled9());
      this.valueSettingSub105 = new ValueSettingSub10("Thickness", 3.0, 1.0, 12.0, 0.5);
      handleSetting2(this.valueSettingSub105, var1.isEnabled9());
      this.valueSettingSub102 = new ValueSettingSub10("Offset X", 0.0, -150.0, 150.0, 0.5);
      this.valueSettingSub103 = new ValueSettingSub10("Offset Y", 0.0, -150.0, 150.0, 0.5);
      this.valueSettingSub6 = new ValueSettingSub6("Colour", -1).getValueSettingSub6().getValueSettingSub64(var4);
      this.valueSettingSub10 = new ValueSettingSub10("Glow", 0.0, 0.0, 12.0, 0.5).getBooleanSetting("Halo radius behind the element - 0 turns it off");
      this.valueSettingSub93 = new ValueSettingSub9("Absorption", true).getBooleanSetting("Count golden hearts as an extra bar segment");
      handleSetting2(this.valueSettingSub93, var1.isEnabled9());
      this.valueSettingSub92 = new ValueSettingSub9("Damage trail", true).getBooleanSetting("Trailing bar that drains after a hit");
      handleSetting2(this.valueSettingSub92, var1.isEnabled9());
   }

   private static void handleSetting2(Setting var0, boolean var1) {
      if (!var1) {
         var0.getSetting2(Setting.BOOLEAN_SUPPLIER);
      }
   }

   public void run124() {
      this.getValueSettingSub9().run5();
      Iterator var3 = this.getList2().iterator();

      while (var3.hasNext()) {
         Setting var2;
         if ((var2 = (Setting)var3.next()) instanceof ValueSetting) {
            ((ValueSetting)var2).run5();
         }
      }
   }

   public AvatarNameEnum getAvatarNameEnum() {
      return this.avatarNameEnum;
   }
}
