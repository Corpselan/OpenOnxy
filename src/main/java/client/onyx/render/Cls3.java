package client.onyx.render;

import net.minecraft.client.renderer.GlStateManager;

public final class Cls3 {
   static final Cls3 CLS3 = new Cls3();

   public Cls3 getCls32(float var1) {
      GlStateManager.rotate((float)Math.toDegrees(var1), 0.0F, 0.0F, 1.0F);
      return this;
   }

   public Cls3 getCls34() {
      GlStateManager.popMatrix();
      return this;
   }

   private Cls3() {
   }

   public Cls3 getCls35(float var1, float var2) {
      GlStateManager.translate(var1, var2, 0.0F);
      return this;
   }

   public Cls3 getCls3() {
      GlStateManager.pushMatrix();
      return this;
   }

   public Cls3 getCls33(float var1, float var2) {
      GlStateManager.scale(var1, var2, 1.0F);
      return this;
   }
}
