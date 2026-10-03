package client.onyx.module.render;

import client.onyx.event.impl.EventSub17;
import client.onyx.event.impl.EventSub6;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.trail2.ModeColorRecord;
import client.onyx.render.trail2.PositionTimeRecord;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub4;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

public final class JumpCirclesModule extends Module {
   private final List<PositionTimeRecord> list2;
   public final ValueSettingSub6 valueSettingSub6;
   public final ValueSettingSub10 valueSettingSub10;
   public final ValueSettingSub11<JumpCirclesModule.RingTextEnum> valueSettingSub112 = new ValueSettingSub11<>("Mode", JumpCirclesModule.RingTextEnum.RING);
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub10 valueSettingSub102;
   public final ValueSettingSub10 valueSettingSub103;
   public final ValueSettingSub9 valueSettingSub92;
   private static final double DOUBLE = 0.01;
   private final client.onyx.render.trail2.Cls cls;
   private final Map<Integer, Vec3> map;
   public final ValueSettingSub4 valueSettingSub4 = new ValueSettingSub4("Text", "ONYX")
      .getBooleanSetting("Written around the ring, repeated all the way round")
      .getModeSetting2(this.valueSettingSub112, var0 -> var0 == JumpCirclesModule.RingTextEnum.TEXT);
   public final ValueSettingSub10 valueSettingSub104;
   public final ValueSettingSub10 valueSettingSub105 = new ValueSettingSub10("Text size", 0.22, 0.05, 0.6, 0.01)
      .getBooleanSetting("How tall the letters stand, in blocks")
      .getModeSetting2(this.valueSettingSub112, var0 -> var0 == JumpCirclesModule.RingTextEnum.TEXT);
   public final JumpCirclesModule.DistortionBooleanSetting distortionBooleanSetting;

   @Override
   protected void run80() {
      this.list2.clear();
      this.map.clear();
   }

   @EventHandler
   private void handleEventSub174(EventSub17 var1) {
      if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
         this.run101();
         HashSet var6 = new HashSet();
         Iterator var2 = MINECRAFT.theWorld.playerEntities.iterator();

         label41:
         while (true) {
            Iterator var10000 = var2;

            while (var10000.hasNext()) {
               EntityPlayer var5;
               if ((var5 = (EntityPlayer)var2.next()) == null) {
                  continue label41;
               }

               if (!var5.isEntityAlive()) {
                  var10000 = var2;
               } else if (var5 != MINECRAFT.thePlayer && !this.valueSettingSub9.isEnabled17()) {
                  var10000 = var2;
               } else {
                  var6.add(var5.getEntityId());
                  Vec3 var4 = new Vec3(var5.posX, var5.posY, var5.posZ);
                  if (!var5.onGround) {
                     if ((var4 = this.map.remove(var5.getEntityId())) != null && isEntityPlayer2(var5, var4)) {
                        this.list2.add(new PositionTimeRecord(var4, System.currentTimeMillis()));
                     }
                     continue label41;
                  }

                  var10000 = var2;
                  this.map.put(var5.getEntityId(), var4);
               }
            }

            this.map.keySet().retainAll(var6);
            return;
         }
      }
   }

   private void run101() {
      long var1 = System.currentTimeMillis() - this.getLong();
      this.list2.removeIf(var2 -> var2.time() < var1);
   }

   @Override
   protected void run79() {
      this.list2.clear();
      this.map.clear();
      this.cls.run76();
   }

   private ModeColorRecord getModeColorRecord2() {
      return new ModeColorRecord(
         this.valueSettingSub112.lambda15(),
         this.valueSettingSub6.getInt8(),
         this.valueSettingSub103.getFloat5() / 100.0F,
         this.valueSettingSub10.getFloat5(),
         this.getLong(),
         this.valueSettingSub104.getFloat5(),
         this.valueSettingSub4.lambda15(),
         this.valueSettingSub105.getFloat5(),
         this.valueSettingSub92.isEnabled17(),
         this.distortionBooleanSetting.isEnabled5(),
         this.distortionBooleanSetting.valueSettingSub10.getFloat5() / 100.0F,
         this.distortionBooleanSetting.valueSettingSub102.getFloat5() / 100.0F
      );
   }

   public JumpCirclesModule() {
      super("JumpCircles", "Draws a circle where a jump started", ModuleCategory.RENDER);
      this.valueSettingSub104 = new ValueSettingSub10("Spin speed", 40.0, -360.0, 360.0, 5.0)
         .getValueSettingSub10("°/s")
         .getBooleanSetting("How fast the text travels around the ring")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 == JumpCirclesModule.RingTextEnum.TEXT);
      this.valueSettingSub6 = new ValueSettingSub6("Color", -10178561).getValueSettingSub6();
      this.valueSettingSub10 = new ValueSettingSub10("Radius", 1.5, 0.3, 6.0, 0.1).getBooleanSetting("How wide the circle opens out to");
      this.valueSettingSub103 = new ValueSettingSub10("Opacity", 70.0, 5.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Overall opacity of the circles");
      this.valueSettingSub102 = new ValueSettingSub10("Duration", 2.0, 0.25, 8.0, 0.25)
         .getValueSettingSub10(" s")
         .getBooleanSetting("How long a circle lasts before it is gone");
      this.valueSettingSub9 = new ValueSettingSub9("Other players", false).getBooleanSetting("Leave circles under everyone else's jumps too");
      this.valueSettingSub92 = new ValueSettingSub9("Through walls", false);
      this.distortionBooleanSetting = new JumpCirclesModule.DistortionBooleanSetting();
      this.cls = new client.onyx.render.trail2.Cls();
      this.list2 = new ArrayList<>();
      this.map = new HashMap<>();
   }

   @EventHandler
   private void handleEventSub68(EventSub6 var1) {
      this.list2.clear();
      this.map.clear();
   }

   public void handleFloat60(float var1) {
      if (this.isEnabled55() && MINECRAFT.theWorld != null && MINECRAFT.thePlayer != null) {
         this.run101();
         this.cls.handleFloat37(var1, this.list2, this.getModeColorRecord2());
      }
   }

   private long getLong() {
      return (long)(this.valueSettingSub102.lambda15() * 1000.0);
   }

   private static boolean isEntityPlayer2(EntityPlayer var0, Vec3 var1) {
      return var0.motionY > 0.0 || var0.posY > var1.yCoord + 0.01;
   }

   public final class DistortionBooleanSetting extends BooleanSetting {
      public final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Blur", 60.0, 0.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How far out of focus the ground inside the ring goes");
      public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Warp", 45.0, 0.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How hard the view bends outwards at the rim of the lens");

      private DistortionBooleanSetting() {
         super("Distortion", true);
      }
   }

   public static enum RingTextEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      RING("Ring"),
      TEXT("Text");

      private final String string;


      private RingTextEnum(String var3) {
         this.string = var3;
      }

      @Override
      public String getString5() {
         return this.string;
      }
   }
}
