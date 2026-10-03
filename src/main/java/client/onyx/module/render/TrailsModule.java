package client.onyx.module.render;

import client.onyx.event.impl.EventSub17;
import client.onyx.event.impl.EventSub6;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.trail.ModeColorRecord;
import client.onyx.render.trail.PositionTimeRecord;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import java.util.ArrayList;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Vec3;

public final class TrailsModule extends Module {
   public final ValueSettingSub10 valueSettingSub10;
   private static final double DOUBLE = 1.0E-8;
   public final ValueSettingSub10 valueSettingSub102;
   public final ValueSettingSub10 valueSettingSub103;
   private static final float FLOAT = 0.8F;
   public final ValueSettingSub11<TrailsModule.WallPointsEnum> valueSettingSub112 = new ValueSettingSub11<>("Mode", TrailsModule.WallPointsEnum.WALL);
   public final ValueSettingSub10 valueSettingSub104;
   private final client.onyx.render.trail.Cls cls;
   private final List<PositionTimeRecord> list2;
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub9 valueSettingSub92;
   public final ValueSettingSub6 valueSettingSub6 = new ValueSettingSub6("Color", -10178561).getValueSettingSub6();

   @Override
   protected void run80() {
      this.list2.clear();
   }

   private ModeColorRecord getModeColorRecord() {
      return new ModeColorRecord(
         this.valueSettingSub112.lambda15(),
         this.valueSettingSub6.getInt8(),
         this.valueSettingSub103.getFloat5() / 100.0F,
         (long)(this.valueSettingSub104.lambda15() * 1000.0),
         this.valueSettingSub102.getFloat5(),
         this.valueSettingSub10.getFloat5(),
         this.valueSettingSub92.isEnabled17()
      );
   }

   private void run97() {
      long var1 = System.currentTimeMillis() - (long)(this.valueSettingSub104.lambda15() * 1000.0);
      this.list2.removeIf(var2 -> var2.time() < var1);
   }

   public TrailsModule() {
      super("Trails", "Leaves a fading trail behind you", ModuleCategory.RENDER);
      this.valueSettingSub104 = new ValueSettingSub10("Length", 1.0, 0.25, 5.0, 0.05)
         .getValueSettingSub10(" s")
         .getBooleanSetting("How long the trail stays behind you");
      this.valueSettingSub103 = new ValueSettingSub10("Opacity", 60.0, 5.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Overall opacity of the trail");
      this.valueSettingSub102 = new ValueSettingSub10("Line width", 1.5, 0.5, 5.0, 0.5)
         .getValueSettingSub10(" px")
         .getBooleanSetting("Thickness of the two lines bounding the wall")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 == TrailsModule.WallPointsEnum.WALL);
      this.valueSettingSub10 = new ValueSettingSub10("Point size", 4.0, 1.0, 12.0, 0.5)
         .getValueSettingSub10(" px")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 == TrailsModule.WallPointsEnum.POINTS);
      this.valueSettingSub9 = new ValueSettingSub9("First person", false)
         .getBooleanSetting("Draw the trail in first person too, where it runs through the camera");
      this.valueSettingSub92 = new ValueSettingSub9("Through walls", false);
      this.cls = new client.onyx.render.trail.Cls();
      this.list2 = new ArrayList<>();
   }

   private List<PositionTimeRecord> getList20(float var1) {
      ArrayList var3;
      (var3 = new ArrayList(this.list2.size() + 1)).addAll(this.list2);
      var3.add(
         new PositionTimeRecord(
            new Vec3(
               MINECRAFT.thePlayer.prevPosX + (MINECRAFT.thePlayer.posX - MINECRAFT.thePlayer.prevPosX) * var1,
               MINECRAFT.thePlayer.prevPosY + (MINECRAFT.thePlayer.posY - MINECRAFT.thePlayer.prevPosY) * var1,
               MINECRAFT.thePlayer.prevPosZ + (MINECRAFT.thePlayer.posZ - MINECRAFT.thePlayer.prevPosZ) * var1
            ),
            System.currentTimeMillis()
         )
      );
      return var3;
   }

   @EventHandler
   private void handleEventSub172(EventSub17 var1) {
      if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
         this.run97();
         Vec3 var4 = new Vec3(MINECRAFT.thePlayer.posX, MINECRAFT.thePlayer.posY, MINECRAFT.thePlayer.posZ);
         PositionTimeRecord var3 = this.list2.isEmpty() ? null : this.list2.get(this.list2.size() - 1);
         if (var3 == null || var3.position().squareDistanceTo(var4) > 1.0E-8) {
            this.list2.add(new PositionTimeRecord(var4, System.currentTimeMillis()));
         }
      }
   }

   @EventHandler
   private void handleEventSub66(EventSub6 var1) {
      this.list2.clear();
   }

   private float getFloat45() {
      return MINECRAFT.thePlayer.height * (MINECRAFT.thePlayer.isSneaking() ? 0.8F : 1.0F);
   }

   @Override
   protected void run79() {
      this.list2.clear();
      this.cls.run71();
   }

   public void handleFloat49(float var1) {
      if (this.isEnabled55() && MINECRAFT.theWorld != null && MINECRAFT.thePlayer != null) {
         if (this.valueSettingSub9.isEnabled17() || MINECRAFT.gameSettings.thirdPersonView != 0) {
            this.run97();
            List var3;
            if ((var3 = this.getList20(var1)).size() >= (this.valueSettingSub112.isEnum3(TrailsModule.WallPointsEnum.WALL) ? 2 : 1)) {
               this.cls.handleFloat34(var1, var3, this.getFloat45(), this.getModeColorRecord());
            }
         }
      }
   }

   public static enum WallPointsEnum implements DisplayNamed {
      WALL("Wall"),
      POINTS("Points");

      private final String string;


      private WallPointsEnum(String var3) {
         this.string = var3;
      }

      @Override
      public String getString5() {
         return this.string;
      }
   }
}
