package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub9;

public final class NoRenderModule extends Module {
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub9 valueSettingSub92;
   public final ValueSettingSub9 valueSettingSub93;
   public final ValueSettingSub9 valueSettingSub94;
   public final ValueSettingSub9 valueSettingSub95 = new ValueSettingSub9("Fire", true);
   public final ValueSettingSub9 valueSettingSub96;

   public boolean isValueSettingSub9(ValueSettingSub9 var1) {
      return this.isEnabled55() && var1.isEnabled17();
   }

   public NoRenderModule() {
      super("NoRender", "Hides selected vanilla visual effects", ModuleCategory.RENDER);
      this.valueSettingSub93 = new ValueSettingSub9("Hurt camera", true);
      this.valueSettingSub92 = new ValueSettingSub9("Hand bob", false);
      this.valueSettingSub94 = new ValueSettingSub9("Boss bar", false);
      this.valueSettingSub9 = new ValueSettingSub9("Bad effects", true);
      this.valueSettingSub96 = new ValueSettingSub9("Scoreboard", false);
   }
}
