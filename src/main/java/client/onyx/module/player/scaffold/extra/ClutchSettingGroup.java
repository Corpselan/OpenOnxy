package client.onyx.module.player.scaffold.extra;

import client.onyx.MinecraftAccess;
import client.onyx.rotation.Cls2;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.setting.Setting;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.util.Util2;
import java.util.Iterator;
import java.util.List;

public class ClutchSettingGroup extends SettingGroup implements MinecraftAccess {
   public static final ClutchSettingGroup CLUTCH_SETTING_GROUP = new ClutchSettingGroup();
   public ValueSettingSub10 valueSettingSub10 = (new ValueSettingSub10("Clutch speed", 90.0D, 1.0D, 180.0D, 1.0D)).getValueSettingSub10("°/t").getBooleanSetting("How fast the aim may move while clutching a fall. Higher lands more placements but looks less like the slow rotation; lower keeps more of the slow rotation at the cost of the odd fall.");
   public ValueSettingSub10 valueSettingSub102 = (new ValueSettingSub10("Clutch distance", 0.2D, 0.05D, 0.6D, 0.01D)).getBooleanSetting("How close to the fall-off edge the aim starts clutching. Larger engages earlier, so the aim is ready before the edge is reached.");

   public boolean isYawPitchRecord2(YawPitchRecord var1) {
      if (this.isEnabled5() && MINECRAFT.thePlayer != null && var1 != null) {
         if (!Util2.isEntityPlayerSP(MINECRAFT.thePlayer)) {
            return false;
         } else if (!Util2.isEntityPlayerSP2(MINECRAFT.thePlayer, (double)this.valueSettingSub102.getFloat5())) {
            return false;
         } else {
            return client.onyx.rotation.Cls.CLS.getYawPitchRecord2().getFloat(var1) > 1.0F;
         }
      } else {
         return false;
      }
   }

   private ClutchSettingGroup() {
      super("Clutch", true);
      this.getSetting2(Setting.BOOLEAN_SUPPLIER);
   }

   public int getInt53(YawPitchRecord var1) {
      return (int)Math.ceil((double)(client.onyx.rotation.Cls.CLS.getYawPitchRecord2().getFloat(var1) / Math.max(1.0F, this.valueSettingSub10.getFloat5())));
   }

   public Cls2 getCls214(Cls2 var1) {
      return !this.isEnabled5() ? var1 : new Cls2(var1.getYawPitchRecord6(), var1.getEntity(), List.of(new ClutchSettingGroup.Cls(var1.getList10())), var1.getInt21(), var1.getFloat27(), var1.isEnabled53(), var1.getOffStrictEnum2(), var1.getCls52());
   }

   private final class Cls implements client.onyx.rotation.mode.api.Iface {
      private final List<client.onyx.rotation.mode.api.Iface> list;

      private Cls(List<client.onyx.rotation.mode.api.Iface> var2) {
         this.list = var2;
      }

      public YawPitchRecord getYawPitchRecord9(Cls2 var1, YawPitchRecord var2, YawPitchRecord var3) {
         if (ClutchSettingGroup.this.isYawPitchRecord2(var3)) {
            float var6 = Math.min(ClutchSettingGroup.this.valueSettingSub10.getFloat5(), var2.getFloat(var3));
            return var2.getYawPitchRecord4(var3, var6, var6);
         } else {
            YawPitchRecord var4 = var3;

            Iterator var5;
            for(Iterator var10000 = var5 = this.list.iterator(); var10000.hasNext(); var10000 = var5) {
               var4 = ((client.onyx.rotation.mode.api.Iface)var5.next()).getYawPitchRecord9(var1, var2, var4);
            }

            return var4;
         }
      }
   }
}
