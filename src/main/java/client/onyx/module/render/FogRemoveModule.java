package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import net.minecraft.client.renderer.GlStateManager;

public final class FogRemoveModule extends Module {
   private static final float FLOAT = 8.5070587E37F;
   private static final float FLOAT2 = 1.7014117E38F;

   public void handleInt18(int var1) {
      if (this.isEnabled55()) {
         GlStateManager.setFog(9729);
         GlStateManager.setFogDensity(0.0F);
         GlStateManager.setFogStart(8.5070587E37F);
         GlStateManager.setFogEnd(1.7014117E38F);
      }
   }

   public FogRemoveModule() {
      super("FogRemove", "Removes first-person environmental and distance fog", ModuleCategory.RENDER);
   }
}
