package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;

public final class DistanceModule extends Module {
   public final ValueSettingSub10 valueSettingSub10;
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Distance", 24.0, 4.0, 256.0, 1.0).getValueSettingSub10("m");
   public final ValueSettingSub9 valueSettingSub92;
   public final ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Fade", 48.0, 4.0, 256.0, 1.0).getValueSettingSub10("m");

   public DistanceModule() {
      super("Fog Blur", "Blurs the world based on distance from the camera", ModuleCategory.RENDER);
      this.valueSettingSub92 = new ValueSettingSub9("Client Color", true);
      this.valueSettingSub10 = new ValueSettingSub10("Tint", 0.5, 0.05, 0.95, 0.05).getModeSetting(this.valueSettingSub92);
      this.valueSettingSub9 = new ValueSettingSub9("Disable on zoom", true);
   }
}
