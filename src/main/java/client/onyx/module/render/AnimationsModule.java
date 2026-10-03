package client.onyx.module.render;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub11;

public class AnimationsModule extends Module {
   public ValueSettingSub11<AnimationsModule.VanillaSmoothEnum> valueSettingSub112 = new ValueSettingSub11<>("Block", AnimationsModule.VanillaSmoothEnum.SMOOTH)
      .getBooleanSetting("Raises the sword higher and lets it sweep along with the swing");
   public ValueSettingSub11<AnimationsModule.VanillaSmoothEnum2> valueSettingSub113 = new ValueSettingSub11<>(
         "Swing", AnimationsModule.VanillaSmoothEnum2.SMOOTH
      )
      .getBooleanSetting("Drives the item bob off the equip progress instead of the swing progress");

   public AnimationsModule() {
      super("Animations", "Changes the swinging and blocking item animations", ModuleCategory.RENDER);
   }

   public static boolean isEnabled69() {
      AnimationsModule var0;
      return (var0 = getAnimationsModule()) != null && var0.isEnabled55() && var0.valueSettingSub112.isEnum3(AnimationsModule.VanillaSmoothEnum.SMOOTH);
   }

   public static boolean isEnabled68() {
      AnimationsModule var0;
      return (var0 = getAnimationsModule()) != null && var0.isEnabled55() && var0.valueSettingSub113.isEnum3(AnimationsModule.VanillaSmoothEnum2.SMOOTH);
   }

   private static AnimationsModule getAnimationsModule() {
      client.onyx.module.Cls var0 = OnyxClient.cls;
      return OnyxClient.cls == null ? null : var0.animationsModule;
   }

   public static enum VanillaSmoothEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      VANILLA,
      SMOOTH;

   }

   public static enum VanillaSmoothEnum2 {
      // 顺序按原 $VALUES 数组（即 ordinal）
      VANILLA,
      SMOOTH;

   }
}
