package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;

public final class SeeInvisiblesModule extends Module {
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub10 valueSettingSub10;
   public final ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Players", true).getBooleanSetting("Show invisible players");
   public final ValueSettingSub9 valueSettingSub93;

   public float getFloat31() {
      return this.valueSettingSub10.getFloat5() / 100.0F;
   }

   public boolean isEntityLivingBase4(EntityLivingBase var1) {
      if (!this.isEnabled55() || var1 == null || !var1.isInvisible()) {
         return false;
      } else if (var1 instanceof EntityPlayer) {
         return this.valueSettingSub92.isEnabled17();
      } else if (var1 instanceof IMob) {
         return this.valueSettingSub9.isEnabled17();
      } else {
         return var1 instanceof EntityAnimal ? this.valueSettingSub93.isEnabled17() : this.valueSettingSub93.isEnabled17();
      }
   }

   public SeeInvisiblesModule() {
      super("SeeInvisibles", "Renders invisible entities", ModuleCategory.RENDER);
      this.valueSettingSub9 = new ValueSettingSub9("Mobs", true).getBooleanSetting("Show invisible hostile mobs");
      this.valueSettingSub93 = new ValueSettingSub9("Animals", false).getBooleanSetting("Show invisible passive mobs");
      this.valueSettingSub10 = new ValueSettingSub10("Opacity", 60.0, 10.0, 100.0, 5.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How solid an invisible entity is drawn");
   }
}
