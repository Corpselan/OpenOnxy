package client.onyx.module.player;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.util.Cls7;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class FastPlaceModule extends Module {
   private transient long long_;
   public ValueSettingSub3 valueSettingSub3;
   public ValueSettingSub9 valueSettingSub9;
   private final transient Cls7 cls7;
   public ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Place", true)
      .getBooleanSetting("Removes the delay when the right click puts a block down");
   public ValueSettingSub9 valueSettingSub93;

   @Override
   public String getString19() {
      return this.valueSettingSub3.getString7();
   }

   private boolean isMovingObjectPosition2(MovingObjectPosition var1, ItemStack var2) {
      boolean var4 = var1 != null && var1.typeOfHit == MovingObjectType.BLOCK && var2 != null && var2.getItem() instanceof ItemBlock;
      return var4 ? this.valueSettingSub92.isEnabled17() : this.valueSettingSub9.isEnabled17();
   }

   private static FastPlaceModule getFastPlaceModule() {
      return OnyxClient.cls == null ? null : OnyxClient.cls.ga;
   }

   public FastPlaceModule() {
      super("FastPlace", "Places, interacts and jumps without vanilla's cooldowns", ModuleCategory.PLAYER);
      this.valueSettingSub9 = new ValueSettingSub9("Interact", true)
         .getBooleanSetting("Removes the delay on everything else the right click does - using items, and clicking entities");
      this.valueSettingSub93 = new ValueSettingSub9("Jump", false)
         .getBooleanSetting("Removes the 10 tick cooldown after a jump, so you leave the ground again the tick you land");
      this.valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString2("CPS", 12, 20, 1, 20)
         .getValueSettingSub3(" cps")
         .getBooleanSetting("The rate the held right click repeats at - re-rolled inside this range every action")
         .getSetting2(() -> {
            FastPlaceModule var0;
            return (var0 = getFastPlaceModule()) != null && (var0.valueSettingSub92.isEnabled17() || var0.valueSettingSub9.isEnabled17());
         });
      this.cls7 = new Cls7();
   }

   public static int getIntForMovingObjectPosition(MovingObjectPosition var0, ItemStack var1) {
      FastPlaceModule var3;
      if ((var3 = getFastPlaceModule()) != null && var3.isEnabled55()) {
         var3.cls7.run();
         return var3.isMovingObjectPosition2(var0, var1) ? 0 : 4;
      } else {
         return 4;
      }
   }

   @Override
   protected void run80() {
      this.long_ = this.getLong3();
      this.cls7.run();
   }

   private long getLong3() {
      return (long)(1000.0 / this.valueSettingSub3.getDouble());
   }

   public static boolean isEnabled116() {
      FastPlaceModule var0;
      if ((var0 = getFastPlaceModule()) == null || !var0.isEnabled55()) {
         return true;
      } else if (!var0.valueSettingSub92.isEnabled17() && !var0.valueSettingSub9.isEnabled17()) {
         return true;
      } else if (!var0.cls7.isLong(var0.long_)) {
         return false;
      } else {
         var0.long_ = var0.getLong3();
         return true;
      }
   }

   public static int getIntForEntityLivingBase2(EntityLivingBase var0) {
      FastPlaceModule var2;
      if ((var2 = getFastPlaceModule()) == null || !var2.isEnabled55() || !var2.valueSettingSub93.isEnabled17()) {
         return 10;
      } else {
         return var0 == MINECRAFT.thePlayer ? 0 : 10;
      }
   }
}
