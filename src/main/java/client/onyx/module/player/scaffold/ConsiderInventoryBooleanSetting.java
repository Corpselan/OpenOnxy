package client.onyx.module.player.scaffold;

import client.onyx.rotation.RotationsBooleanSetting;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.mode.api.Iface;
import client.onyx.setting.Setting;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;
import java.util.Iterator;
import java.util.List;

public class ConsiderInventoryBooleanSetting extends RotationsBooleanSetting {
   public ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Consider inventory", false).getSetting2(Setting.BOOLEAN_SUPPLIER);
   final transient Cls cls;
   public ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Rotation variance", 0.3, 0.0, 3.0, 0.05)
      .getValueSettingSub10("°")
      .getBooleanSetting(
         "Wobbles the sent yaw by a mouse step or two each tick so no two placements go out with the same yaw (Grim DuplicateRotPlace). 0 turns it off."
      );

   public client.onyx.rotation.Cls2 getCls212(client.onyx.rotation.Cls2 var1) {
      return this.valueSettingSub103.lambda15() <= 0.0
         ? var1
         : new client.onyx.rotation.Cls2(
            var1.getYawPitchRecord6(),
            var1.getEntity(),
            List.of(new ConsiderInventoryBooleanSetting.Cls2(var1.getList10())),
            var1.getInt21(),
            var1.getFloat27(),
            var1.isEnabled53(),
            var1.getOffStrictEnum2(),
            var1.getCls52()
         );
   }

   public ConsiderInventoryBooleanSetting() {
      this.cls = new Cls();
   }

   private final class Cls2 implements Iface {
      private final List<Iface> list;

      private Cls2(List<Iface> var2) {
         this.list = var2;
      }

      @Override
      public YawPitchRecord getYawPitchRecord9(client.onyx.rotation.Cls2 var1, YawPitchRecord var2, YawPitchRecord var3) {
         Iterator var4;
         for (Iterator var10000 = var4 = this.list.iterator(); var10000.hasNext(); var10000 = var4) {
            var3 = ((Iface)var4.next()).getYawPitchRecord9(var1, var2, var3);
         }

         return new YawPitchRecord(
            ConsiderInventoryBooleanSetting.this.cls.getFloat(var3.yaw2(), ConsiderInventoryBooleanSetting.this.valueSettingSub103.lambda15()), var3.pitch2()
         );
      }
   }
}
