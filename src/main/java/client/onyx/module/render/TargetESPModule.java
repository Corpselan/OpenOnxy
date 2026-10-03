package client.onyx.module.render;

import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub17;
import client.onyx.event.impl.EventSub6;
import client.onyx.event.impl.EventSub9;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.blur.BloomSizeRecord;
import client.onyx.render.blur.Cls2;
import client.onyx.render.blur.Cls3;
import client.onyx.render.blur.Cls4;
import client.onyx.render.blur.ColorSizeRecord;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.Util4;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.EntityLivingBase;

public final class TargetESPModule extends Module {
   private final Cls4 cls4;
   private final client.onyx.render.blur.Cls cls;
   private static final float FLOAT = 100.0F;
   public ValueSettingSub10 valueSettingSub10;
   public TargetESPModule.StrikeBooleanSetting strikeBooleanSetting;
   public ValueSettingSub11<TargetESPModule.CrystalsRingEnum> valueSettingSub112 = new ValueSettingSub11<>("Style", TargetESPModule.CrystalsRingEnum.CRYSTALS);
   private long long_;
   public ValueSettingSub6 valueSettingSub6 = new ValueSettingSub6("Color", -8857601)
      .getValueSettingSub6()
      .getBooleanSetting("Colour of the mark on the target");
   private final Cls2 cls2;
   private final Cls3<EntityLivingBase> cls3;
   public ValueSettingSub10 valueSettingSub102;
   public TargetESPModule.RingBooleanSetting ringBooleanSetting;
   public ValueSettingSub6 valueSettingSub62 = new ValueSettingSub6("Glow color", -8857601)
      .getModeSetting2(this.valueSettingSub112, var0 -> var0 == TargetESPModule.CrystalsRingEnum.CRYSTALS)
      .getBooleanSetting("Colour of the halo around each shard");
   public ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Glow", 75.0, 0.0, 300.0, 5.0)
      .getValueSettingSub10("%")
      .getModeSetting2(this.valueSettingSub112, var0 -> var0 == TargetESPModule.CrystalsRingEnum.CRYSTALS)
      .getBooleanSetting("How much light the halos throw");

   @EventHandler
   private void handleEventSub67(EventSub6 var1) {
      this.run99();
   }

   private ColorSizeRecord getColorSizeRecord() {
      return new ColorSizeRecord(
         this.valueSettingSub6.getInt8(),
         this.ringBooleanSetting.valueSettingSub10.getFloat5(),
         this.ringBooleanSetting.valueSettingSub104.getFloat5(),
         this.ringBooleanSetting.valueSettingSub11.lambda15().getFloat(),
         this.ringBooleanSetting.valueSettingSub1010.getFloat5() / 100.0F,
         this.ringBooleanSetting.valueSettingSub94.isEnabled17(),
         this.ringBooleanSetting.valueSettingSub92.isEnabled17(),
         this.ringBooleanSetting.valueSettingSub108.getFloat5(),
         this.ringBooleanSetting.valueSettingSub107.getFloat5() / 100.0F,
         this.ringBooleanSetting.valueSettingSub95.isEnabled17(),
         this.ringBooleanSetting.valueSettingSub106.getFloat5(),
         this.ringBooleanSetting.valueSettingSub105.getFloat5(),
         this.ringBooleanSetting.valueSettingSub93.isEnabled17(),
         this.ringBooleanSetting.valueSettingSub109.getFloat5(),
         this.ringBooleanSetting.valueSettingSub102.getFloat5(),
         this.ringBooleanSetting.valueSettingSub103.getFloat5()
      );
   }

   private EntityLivingBase getEntityLivingBase() {
      if (MINECRAFT.theWorld != null && MINECRAFT.thePlayer != null) {
         EntityLivingBase var2;
         return (var2 = OnyxClient.cls.killAuraModule.getEntityLivingBase3()) != null && var2.isEntityAlive() && var2.worldObj == MINECRAFT.theWorld
            ? var2
            : null;
      } else {
         return null;
      }
   }

   public void handleFloat52(float var1) {
      if (this.isEnabled55()) {
         long var2 = System.nanoTime();
         float var6 = this.long_ == 0L ? 0.0F : Math.min((float)(var2 - this.long_) / 1000000.0F, 100.0F);
         this.long_ = var2;
         TargetESPModule var10000;
         if (this.isEnabled63()) {
            this.cls2.handleFloat(var6);
            var10000 = this;
         } else {
            this.cls2.run();
            var10000 = this;
         }

         EntityLivingBase var7 = var10000.getEntityLivingBase();
         this.cls3.handleObject(var7, var6);
         EntityLivingBase var8;
         EntityLivingBase var9 = var8 = this.cls3.getObject2();
         float var5 = this.cls3.getFloat();
         if (var9 != null && !(var5 <= 0.0F) && var8.worldObj == MINECRAFT.theWorld) {
            if (this.valueSettingSub112.isEnum3(TargetESPModule.CrystalsRingEnum.RING)) {
               this.cls.handleEntityLivingBase2(var8, var5, var1, this.getColorSizeRecord());
            } else {
               this.cls4.handleEntityLivingBase6(var8, var5, System.currentTimeMillis(), var1, this.getBloomSizeRecord(), this.cls2);
            }
         }
      }
   }

   @Override
   protected void run80() {
      this.run99();
   }

   @EventHandler
   private void handleEventSub92(EventSub9 var1) {
      if (this.isEnabled63() && var1.getEntityPlayer() == MINECRAFT.thePlayer) {
         if (var1.getEntity() == this.cls3.getObject2()) {
            Cls2 var2 = this.cls2;
            int var3 = this.strikeBooleanSetting.valueSettingSub103.getInt10();
            float var5 = this.strikeBooleanSetting.valueSettingSub102.getFloat5() / 100.0F;
            var2.handleInt(var3, var5);
         }
      }
   }

   @EventHandler
   private void handleEventSub173(EventSub17 var1) {
      if (this.valueSettingSub112.isEnum3(TargetESPModule.CrystalsRingEnum.RING)) {
         EntityLivingBase var2 = this.cls3.getObject2();
         EntityLivingBase var10001;
         TargetESPModule var10002;
         if (var2 != null && var2.worldObj == MINECRAFT.theWorld) {
            var10001 = var2;
            var10002 = this;
         } else {
            var10001 = null;
            var10002 = this;
         }

         this.cls.handleEntityLivingBase5(var10001, var10002.cls3.getFloat(), this.getColorSizeRecord());
      }
   }

   private boolean isEnabled63() {
      return this.valueSettingSub112.isEnum3(TargetESPModule.CrystalsRingEnum.CRYSTALS) && this.strikeBooleanSetting.isEnabled5();
   }

   @Override
   protected void run79() {
      this.run99();
   }

   private void run99() {
      this.cls3.run();
      this.cls2.run();
      this.cls.run69();
      this.long_ = 0L;
   }

   private BloomSizeRecord getBloomSizeRecord() {
      return new BloomSizeRecord(
         this.valueSettingSub103.getFloat5() / 100.0F,
         this.valueSettingSub10.getFloat5() / 100.0F,
         this.valueSettingSub102.getFloat5() / 100.0F,
         this.strikeBooleanSetting.valueSettingSub10.getFloat5() / 100.0F,
         this.valueSettingSub6.getInt8(),
         this.valueSettingSub62.getInt8(),
         this.strikeBooleanSetting.valueSettingSub6.getInt8()
      );
   }

   public TargetESPModule() {
      super("TargetESP", "Marks the KillAura target", ModuleCategory.RENDER);
      this.valueSettingSub10 = new ValueSettingSub10("Glow size", 70.0, 25.0, 300.0, 5.0)
         .getValueSettingSub10("%")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 == TargetESPModule.CrystalsRingEnum.CRYSTALS)
         .getBooleanSetting("Radius of each halo");
      this.valueSettingSub102 = new ValueSettingSub10("Crystal opacity", 100.0, 0.0, 100.0, 5.0)
         .getValueSettingSub10("%")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 == TargetESPModule.CrystalsRingEnum.CRYSTALS)
         .getBooleanSetting("How solid the orbiting shards are");
      this.ringBooleanSetting = new TargetESPModule.RingBooleanSetting();
      this.strikeBooleanSetting = new TargetESPModule.StrikeBooleanSetting();
      this.cls3 = new Cls3<>();
      this.cls2 = new Cls2();
      this.cls4 = new Cls4();
      this.cls = new client.onyx.render.blur.Cls();
      this.ringBooleanSetting.getSetting2(() -> this.valueSettingSub112.isEnum3(TargetESPModule.CrystalsRingEnum.RING));
      this.strikeBooleanSetting.getSetting2(() -> this.valueSettingSub112.isEnum3(TargetESPModule.CrystalsRingEnum.CRYSTALS));
   }

   public static enum CrystalsRingEnum implements DisplayNamed {
      CRYSTALS("Crystals"),
      RING("Ring");
      private final String string;

      private CrystalsRingEnum(String var3) {
         this.string = var3;
      }

      @Override
      public String getString5() {
         return this.string;
      }

   }

   public static enum FeetMiddleEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      FEET("Feet", -90.0F),
      MIDDLE("Middle", 0.0F),
      HEAD("Head", 90.0F);

      private final float float_;
      private final String string;

      @Override
      public String getString5() {
         return this.string;
      }

      private FeetMiddleEnum(String var3, float var4) {
         this.string = var3;
         this.float_ = var4;
      }

      public float getFloat() {
         return this.float_;
      }

   }

   public static final class RingBooleanSetting extends BooleanSetting {
      public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Size", 1.0, 0.5, 2.0, 0.05)
         .getBooleanSetting("How wide the hoop stands off the target");
      public ValueSettingSub10 valueSettingSub102;
      public ValueSettingSub9 valueSettingSub92;
      public ValueSettingSub10 valueSettingSub103;
      public ValueSettingSub9 valueSettingSub93;
      public ValueSettingSub10 valueSettingSub104 = new ValueSettingSub10("Speed", 4.0, 0.5, 12.0, 0.5)
         .getBooleanSetting("How fast it travels up and back down");
      public ValueSettingSub10 valueSettingSub105;
      public ValueSettingSub9 valueSettingSub94;
      public ValueSettingSub10 valueSettingSub106;
      public ValueSettingSub10 valueSettingSub107;
      public ValueSettingSub9 valueSettingSub95;
      public ValueSettingSub11<TargetESPModule.FeetMiddleEnum> valueSettingSub11 = new ValueSettingSub11<>("Start", TargetESPModule.FeetMiddleEnum.FEET)
         .getBooleanSetting("Where on the target the hoop sets off from");
      public ValueSettingSub10 valueSettingSub108;
      public ValueSettingSub10 valueSettingSub109;
      public ValueSettingSub10 valueSettingSub1010 = new ValueSettingSub10("Glow", 100.0, 0.0, 300.0, 10.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How much light comes off the line");

      private RingBooleanSetting() {
         super("Ring");
         this.valueSettingSub94 = new ValueSettingSub9("Gradient", false)
            .getBooleanSetting("Walk the hue around the hoop instead of holding the picked colour");
         this.valueSettingSub92 = new ValueSettingSub9("Trail", true).getBooleanSetting("Drag a curtain of light behind the hoop");
         this.valueSettingSub108 = new ValueSettingSub10("Trail length", 1.0, 0.25, 2.0, 0.05)
            .getBooleanSetting("How far back the curtain reaches")
            .getModeSetting(this.valueSettingSub92);
         this.valueSettingSub107 = new ValueSettingSub10("Trail opacity", 100.0, 10.0, 300.0, 10.0)
            .getValueSettingSub10("%")
            .getBooleanSetting("How strongly the curtain is drawn")
            .getModeSetting(this.valueSettingSub92);
         this.valueSettingSub95 = new ValueSettingSub9("Particles", true).getBooleanSetting("Shed glowing motes as the hoop goes");
         this.valueSettingSub106 = new ValueSettingSub10("Particle height", 1.0, 0.1, 1.0, 0.05)
            .getBooleanSetting("How much of the target's height the motes are spread over")
            .getModeSetting(this.valueSettingSub95);
         this.valueSettingSub105 = new ValueSettingSub10("Particle life", 1.0, 0.3, 3.0, 0.1)
            .getBooleanSetting("How long a mote lasts before it is gone")
            .getModeSetting(this.valueSettingSub95);
         this.valueSettingSub93 = new ValueSettingSub9("Red on impact", true).getBooleanSetting("Flush the ring red whenever the target is hit");
         this.valueSettingSub109 = new ValueSettingSub10("Impact fade in", 0.3, 0.05, 1.0, 0.01)
            .getBooleanSetting("How fast the flush comes on")
            .getModeSetting(this.valueSettingSub93);
         this.valueSettingSub102 = new ValueSettingSub10("Impact fade out", 0.08, 0.01, 0.5, 0.01)
            .getBooleanSetting("How fast it drains away again")
            .getModeSetting(this.valueSettingSub93);
         this.valueSettingSub103 = new ValueSettingSub10("Impact intensity", 1.0, 0.1, 1.0, 0.05)
            .getBooleanSetting("How red it gets at its strongest")
            .getModeSetting(this.valueSettingSub93);
      }
   }

   public static final class StrikeBooleanSetting extends BooleanSetting {
      public ValueSettingSub10 valueSettingSub10;
      public ValueSettingSub6 valueSettingSub6;
      public ValueSettingSub10 valueSettingSub102;
      public ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Shards per hit", 1.0, 1.0, 6.0, 1.0)
         .getBooleanSetting("How many shards lunge in on every hit");

      private StrikeBooleanSetting() {
         super("Strike", true);
         this.valueSettingSub10 = new ValueSettingSub10("Reach", 55.0, 10.0, 90.0, 5.0)
            .getValueSettingSub10("%")
            .getBooleanSetting("How far towards the target a shard drives in");
         this.valueSettingSub102 = new ValueSettingSub10("Speed", 100.0, 40.0, 250.0, 10.0)
            .getValueSettingSub10("%")
            .getBooleanSetting("Pace of the lunge and of the gap between shards");
         this.valueSettingSub6 = new ValueSettingSub6("Flash", -1)
            .getValueSettingSub6()
            .getValueSettingSub64(() -> Util4.getPrimaryOnPrimaryRecord().onPrimaryContainer())
            .getBooleanSetting("Colour a shard flashes to as it lands");
      }
   }
}
