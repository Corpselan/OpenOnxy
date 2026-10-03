package client.onyx.module.render;

import client.onyx.event.impl.EventSub11;
import client.onyx.event.impl.EventSub14;
import client.onyx.event.impl.IncomingOutgoingEnum;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.play.server.S03PacketTimeUpdate;

public final class AmbienceModule extends Module {
   public ValueSettingSub9 valueSettingSub9 = new ValueSettingSub9("Time lock", false)
      .getBooleanSetting("Locks the client-side time of day without changing server time");
   public AmbienceModule.ColorBooleanSetting colorBooleanSetting;
   public AmbienceModule.SaturationBooleanSetting saturationBooleanSetting;
   private volatile S03PacketTimeUpdate s03PacketTimeUpdate;
   public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Time", 6000.0, 0.0, 24000.0, 100.0)
      .getValueSettingSub10(" ticks")
      .getBooleanSetting("World time to display (0 = sunrise, 6000 = noon, 18000 = midnight)")
      .getModeSetting(this.valueSettingSub9);

   @EventHandler
   private void handleEventSub114(EventSub11 var1) {
      if (MINECRAFT.theWorld != null) {
         if (this.valueSettingSub9.isEnabled17()) {
            MINECRAFT.theWorld.setWorldTime(this.valueSettingSub10.getInt10());
         } else {
            this.run103();
         }
      }
   }

   public AmbienceModule() {
      super("Ambience", "Cinematic world lighting and color grading", ModuleCategory.RENDER);
      this.colorBooleanSetting = new AmbienceModule.ColorBooleanSetting();
      this.saturationBooleanSetting = new AmbienceModule.SaturationBooleanSetting();
   }

   @Override
   protected void run79() {
      this.run103();
   }

   private void run103() {
      S03PacketTimeUpdate var2 = this.s03PacketTimeUpdate;
      this.s03PacketTimeUpdate = null;
      if (var2 != null && MINECRAFT.theWorld != null) {
         MINECRAFT.theWorld.setTotalWorldTime(var2.getTotalWorldTime());
         MINECRAFT.theWorld.setWorldTime(var2.getWorldTime());
      }
   }

   public boolean isEnabled75() {
      return this.isEnabled55() && (this.colorBooleanSetting.isEnabled5() || this.saturationBooleanSetting.isEnabled5());
   }

   @EventHandler
   private void handleEventSub142(EventSub14 var1) {
      if (var1.getIncomingOutgoingEnum() == IncomingOutgoingEnum.INCOMING) {
         if (!var1.isEnabled()) {
            if (this.valueSettingSub9.isEnabled17()) {
               if (var1.getPacket() instanceof S03PacketTimeUpdate var2) {
                  this.s03PacketTimeUpdate = var2;
                  var1.run();
               }
            }
         }
      }
   }

   @Override
   protected void run80() {
      this.s03PacketTimeUpdate = null;
   }

   public final class ColorBooleanSetting extends BooleanSetting {
      public ValueSettingSub6 valueSettingSub6 = new ValueSettingSub6("Color", -6718).getValueSettingSub6();
      public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Strength", 18.0, 0.0, 100.0, 1.0).getValueSettingSub10("%");

      private ColorBooleanSetting() {
         super("Light Color", false);
      }
   }

   public final class SaturationBooleanSetting extends BooleanSetting {
      public ValueSettingSub10 valueSettingSub10;
      public ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Saturation", 100.0, 0.0, 180.0, 5.0).getValueSettingSub10("%");
      public ValueSettingSub10 valueSettingSub103;
      public ValueSettingSub10 valueSettingSub104 = new ValueSettingSub10("Contrast", 100.0, 60.0, 160.0, 5.0).getValueSettingSub10("%");

      private SaturationBooleanSetting() {
         super("Color Grading", false);
         this.valueSettingSub10 = new ValueSettingSub10("Vignette", 10.0, 0.0, 80.0, 5.0).getValueSettingSub10("%");
         this.valueSettingSub103 = new ValueSettingSub10("Film Grain", 0.0, 0.0, 30.0, 1.0).getValueSettingSub10("%");
      }
   }
}
