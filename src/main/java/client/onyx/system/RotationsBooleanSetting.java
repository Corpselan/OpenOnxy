package client.onyx.system;

import client.onyx.input.KeyScancodeRecord;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub9;

public class RotationsBooleanSetting extends BooleanSetting {
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub11<OffStrictEnum> valueSettingSub11;
   public ValueSettingSub10 valueSettingSub102;
   public ValueSettingSub10 valueSettingSub103;
   public ValueSettingSub10 valueSettingSub104;
   public ValueSettingSub10 valueSettingSub105;
   public ValueSettingSub10 valueSettingSub106;
   public ValueSettingSub10 valueSettingSub107;
   public ValueSettingSub10 valueSettingSub108;
   public ValueSettingSub11<RotationsBooleanSetting.InstantLinearEnum> valueSettingSub112 = new ValueSettingSub11<>(
         "Rotation", RotationsBooleanSetting.InstantLinearEnum.SMOOTH
      )
      .getBooleanSetting("How the aim moves toward the target");
   public ValueSettingSub9 valueSettingSub92;
   public ValueSettingSub10 valueSettingSub109 = new ValueSettingSub10("Yaw speed", 45.0, 1.0, 180.0, 1.0)
      .getValueSettingSub10("°/t")
      .getSetting2(() -> !this.valueSettingSub112.isEnum3(RotationsBooleanSetting.InstantLinearEnum.INSTANT));
   public ValueSettingSub10 valueSettingSub1010;
   public ValueSettingSub9 valueSettingSub93;
   public ValueSettingSub10 valueSettingSub1011;

   public RotationsBooleanSetting() {
      super("Rotations");
      this.valueSettingSub107 = new ValueSettingSub10("Pitch speed", 30.0, 1.0, 180.0, 1.0)
         .getValueSettingSub10("°/t")
         .getSetting2(() -> !this.valueSettingSub112.isEnum3(RotationsBooleanSetting.InstantLinearEnum.INSTANT));
      this.valueSettingSub103 = new ValueSettingSub10("Smoothing", 70.0, 0.0, 95.0, 5.0)
         .getValueSettingSub10(KeyScancodeRecord.decrypt("l"))
         .getBooleanSetting("Share of the remaining angle kept each tick")
         .getSetting2(() -> this.valueSettingSub112.isEnum3(RotationsBooleanSetting.InstantLinearEnum.SMOOTH));
      this.valueSettingSub104 = new ValueSettingSub10("Acceleration", 15.0, 1.0, 90.0, 1.0)
         .getValueSettingSub10("°/t²")
         .getSetting2(() -> this.valueSettingSub112.isEnum3(RotationsBooleanSetting.InstantLinearEnum.ACCELERATE));
      this.valueSettingSub1011 = new ValueSettingSub10("Start speed", 25.0, 5.0, 100.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Speed the ramp begins at")
         .getSetting2(() -> this.valueSettingSub112.isEnum3(RotationsBooleanSetting.InstantLinearEnum.ACCELERATE));
      this.valueSettingSub93 = new ValueSettingSub9("Speed variance", true)
         .getBooleanSetting("Rolls a fresh turn speed for every flick")
         .getSetting2(() -> !this.valueSettingSub112.isEnum3(RotationsBooleanSetting.InstantLinearEnum.INSTANT));
      this.valueSettingSub10 = new ValueSettingSub10("Yaw speed max", 75.0, 1.0, 180.0, 1.0)
         .getValueSettingSub10("°/t")
         .getSetting2(() -> !this.valueSettingSub112.isEnum3(RotationsBooleanSetting.InstantLinearEnum.INSTANT) && this.valueSettingSub93.isEnabled17());
      this.valueSettingSub105 = new ValueSettingSub10("Pitch speed max", 50.0, 1.0, 180.0, 1.0)
         .getValueSettingSub10("°/t")
         .getSetting2(() -> !this.valueSettingSub112.isEnum3(RotationsBooleanSetting.InstantLinearEnum.INSTANT) && this.valueSettingSub93.isEnabled17());
      this.valueSettingSub1010 = new ValueSettingSub10("Yaw jitter", 0.0, 0.0, 5.0, 0.1).getValueSettingSub10("°");
      this.valueSettingSub106 = new ValueSettingSub10("Pitch jitter", 0.0, 0.0, 5.0, 0.1).getValueSettingSub10("°");
      this.valueSettingSub108 = new ValueSettingSub10("Aim spread", 25.0, 0.0, 100.0, 5.0)
         .getValueSettingSub10(KeyScancodeRecord.decrypt("l"))
         .getBooleanSetting("How far from the closest point the aim may wander");
      this.valueSettingSub102 = new ValueSettingSub10("Aim re-roll", 0.0, 0.0, 60.0, 5.0)
         .getValueSettingSub10("t")
         .getBooleanSetting("0 keeps one point per target")
         .getSetting2(() -> this.valueSettingSub108.lambda15() > 0.0);
      this.valueSettingSub92 = new ValueSettingSub9("Sensitivity fix", true).getBooleanSetting("Snaps each delta to the mouse grid");
      this.valueSettingSub11 = new ValueSettingSub11<>("Move fix", OffStrictEnum.SILENT)
         .getBooleanSetting("Keeps movement consistent with the rotation the server sees");
   }

   public static enum InstantLinearEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      INSTANT,
      LINEAR,
      SMOOTH,
      ACCELERATE;

   }
}
