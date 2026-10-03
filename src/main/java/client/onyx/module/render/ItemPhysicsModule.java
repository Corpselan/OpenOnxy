package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub10;

public final class ItemPhysicsModule extends Module {
   public final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Rotation speed", 0.0, 0.0, 3.0, 0.1).getValueSettingSub10("x");

   public ItemPhysicsModule() {
      super("ItemPhysics", "Makes dropped items lie and rotate on the ground", ModuleCategory.RENDER);
   }
}
