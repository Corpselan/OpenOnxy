package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.system.Util10;
import java.util.concurrent.ThreadLocalRandom;

public final class KeepModule extends Module {
   public final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Keep", 5.0, 5.0, 100.0, 5.0).getValueSettingSub10("%");

   public KeepModule() {
      super("Particle Limiter", "Thins vanilla particles in the Hypixel Bed Wars lobby", ModuleCategory.RENDER);
   }

   public boolean isEnabled59() {
      return this.isEnabled55() && Util10.isEnabled() ? ThreadLocalRandom.current().nextInt(100) >= this.valueSettingSub10.getInt10() : false;
   }
}
