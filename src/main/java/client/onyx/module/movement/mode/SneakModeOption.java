package client.onyx.module.movement.mode;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub16;
import client.onyx.setting.Cls;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.ModeOption;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub3;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.simulation.Cls5;
import client.onyx.simulation.PosFallDistanceRecord;
import client.onyx.util.ForwardsBackwardsRecord;
import client.onyx.util.Util2;
import client.onyx.util.Util3;
import client.onyx.util.Util6;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class SneakModeOption extends ModeOption implements MinecraftAccess {
   private transient int int_3;
   public ValueSettingSub3 valueSettingSub3 = ValueSettingSub3.getValueSettingSub3ForString("Distance", 0.1, 0.15, 0.05, 0.5);
   private transient int int_4;
   public ValueSettingSub11<SneakModeOption.StopInvertEnum> valueSettingSub11;
   public ValueSettingSub3 valueSettingSub32 = ValueSettingSub3.getValueSettingSub3ForString2("Keep", 1, 2, 1, 20).getValueSettingSub3(" ticks");
   public ValueSettingSub9 valueSettingSub92;
   private final transient Cls cls;
   public ValueSettingSub3 valueSettingSub33;
   private transient Vec3 vec3;

   public SneakModeOption() {
      super("On edge");
      this.valueSettingSub11 = new ValueSettingSub11<>("Mode", SneakModeOption.StopInvertEnum.STOP);
      this.valueSettingSub33 = ValueSettingSub3.getValueSettingSub3ForString2("Sneak", 0, 0, 0, 20).getValueSettingSub3(" ticks");
      this.valueSettingSub92 = new ValueSettingSub9("Jump", false);
      ValueSettingSub3 var1 = this.valueSettingSub3;
      Cls var2 = new Cls(var1);
      this.cls = var2;
   }

   @Override
   protected void run4() {
      this.vec3 = null;
      this.int_3 = 0;
      this.cls.run();
   }

   @EventHandler(
      priority = -100
   )
   private void handleEventSub164(EventSub16 var1) {
      if (MINECRAFT.thePlayer != null) {
         boolean var6 = MINECRAFT.thePlayer.onGround && !var1.isEnabled6();
         if (var6
            && Util2.isEntityPlayerSP3(
               MINECRAFT.thePlayer, var1.getForwardsBackwardsRecord2(), Math.min(Util2.getDoubleForEntity(MINECRAFT.thePlayer), this.cls.getDouble())
            )) {
            Vec3 var3 = this.vec3;
            if (this.vec3 != null) {
               PosFallDistanceRecord var10001 = Cls5.CLS5.getCls().getPosFallDistanceRecord(1);
               double var4 = var3.subtract(Util2.getVec3ForEntity2(MINECRAFT.thePlayer)).horizontalDistanceSqr();
               if (var3.subtract(var10001.pos()).horizontalDistanceSqr() <= var4) {
                  return;
               }
            }

            if (this.int_3 == 0) {
               this.cls.run();
               this.int_3 = this.valueSettingSub32.getInt4();
            }

            if (this.int_4 == 0) {
               int var8 = this.valueSettingSub33.getInt4();
               this.int_4 = var8;
            }
         }

         if (this.int_3 > 0) {
            this.int_3--;
            SneakModeOption var10000;
            if (this.valueSettingSub11.isEnum3(SneakModeOption.StopInvertEnum.INVERT)) {
               var10000 = this;
               var1.handleForwardsBackwardsRecord(var1.getForwardsBackwardsRecord2().getForwardsBackwardsRecord());
               var1.handleBool3(false);
            } else if (!this.valueSettingSub11.isEnum3(SneakModeOption.StopInvertEnum.CENTER) && !(Util2.getDoubleForEntity(MINECRAFT.thePlayer) > 0.05)) {
               if (this.valueSettingSub11.isEnum3(SneakModeOption.StopInvertEnum.STOP)) {
                  var1.handleForwardsBackwardsRecord(ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8);
                  var1.handleBool3(false);
               }

               var10000 = this;
            } else {
               Vec3 var10 = this.vec3 != null ? this.vec3 : Util6.getVec3ForVec3i4(new BlockPos(MINECRAFT.thePlayer));
               var10000 = this;
               float var9 = Util3.getFloatForVec3(var10.subtract(Util2.getVec3ForEntity2(MINECRAFT.thePlayer)), MINECRAFT.thePlayer.rotationYaw);
               var1.handleForwardsBackwardsRecord(
                  Util3.getForwardsBackwardsRecordForForwardsBackwardsRecord2(ForwardsBackwardsRecord.FORWARDS_BACKWARDS_RECORD8, var9, 20.0F)
               );
            }

            if (var10000.valueSettingSub92.lambda15()) {
               var1.handleBool3(true);
            }
         }

         if (this.int_4 > 0) {
            this.int_4--;
            var1.handleBool4(true);
         }

         Vec3 var11 = Util6.getVec3ForVec3i4(new BlockPos(MINECRAFT.thePlayer));
         if (!Util2.isEntityPlayer4(MINECRAFT.thePlayer, var11)) {
            this.vec3 = var11;
         }
      }
   }

   public static enum StopInvertEnum implements DisplayNamed {
      STOP("Stop"),
      INVERT("Invert"),
      CENTER("Center");

      private final String string;


      @Override
      public String getString5() {
         return this.string;
      }

      public String getString4() {
         return this.string;
      }

      private StopInvertEnum(String var3) {
         this.string = var3;
      }
   }
}
