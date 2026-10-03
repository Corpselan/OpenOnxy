package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.system.YawPitchRecord;

public class SkyboxModule extends Module {
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub10 valueSettingSub102;
   public ValueSettingSub10 valueSettingSub103;
   public ValueSettingSub6 valueSettingSub6;
   public ValueSettingSub10 valueSettingSub104;
   public ValueSettingSub11<SkyboxModule.CloudsThunderEnum> valueSettingSub112 = new ValueSettingSub11<>("Preset", SkyboxModule.CloudsThunderEnum.CLOUDS)
      .getBooleanSetting("Sky theme to paint");
   public ValueSettingSub10 valueSettingSub105;
   private static final long LONG = System.nanoTime();
   public ValueSettingSub10 valueSettingSub106;
   public ValueSettingSub10 valueSettingSub107;
   public ValueSettingSub11<SkyboxModule.FastBalancedEnum> valueSettingSub113;

   public float getFloat53() {
      return this.valueSettingSub102.getFloat5();
   }

   public float getFloat47() {
      return this.valueSettingSub107.getFloat5();
   }

   public int getInt32() {
      return this.valueSettingSub6.getInt8();
   }

   public boolean isEnabled62() {
      return this.isEnabled55();
   }

   public int getInt34() {
      return this.valueSettingSub112.lambda15().getInt();
   }

   public float getFloat54() {
      return 0.85F;
   }

   public float getFloat51() {
      return (float)(System.nanoTime() - LONG) / 1.0E9F;
   }

   public float getFloat48() {
      return this.valueSettingSub10.getFloat5() / 100.0F;
   }

   public float getFloat52() {
      return this.valueSettingSub103.getFloat5();
   }

   public float getFloat46() {
      return this.valueSettingSub105.getFloat5();
   }

   public float getFloat50() {
      return Math.clamp(this.valueSettingSub106.getFloat5() / 100.0F, 0.25F, 1.0F);
   }

   public float getFloat49() {
      return this.valueSettingSub104.getFloat5();
   }

   public SkyboxModule() {
      super("Skybox", "Animated sky with a fixed custom color", ModuleCategory.RENDER);
      this.valueSettingSub6 = new ValueSettingSub6("Color", -9335297).getValueSettingSub6().getBooleanSetting("Fixed sky color");
      this.valueSettingSub107 = new ValueSettingSub10("Animation Speed", 1.0, 0.1, 5.0, 0.1)
         .getValueSettingSub10(YawPitchRecord.decrypt("m"))
         .getBooleanSetting("Controls how fast the sky moves");
      this.valueSettingSub104 = new ValueSettingSub10("Scale", 5.0, 1.0, 20.0, 0.5)
         .getBooleanSetting("Size of the pattern across the sky")
         .getSetting2(() -> this.valueSettingSub112.lambda15().isEnabled());
      this.valueSettingSub10 = new ValueSettingSub10("Intensity", 1.0, 0.1, 5.0, 0.1)
         .getValueSettingSub10("%")
         .getBooleanSetting("Brightness the pattern is pushed to")
         .getSetting2(() -> this.valueSettingSub112.lambda15().isEnabled());
      this.valueSettingSub102 = new ValueSettingSub10("Strike Interval", 4.0, 1.0, 10.0, 0.5)
         .getValueSettingSub10(YawPitchRecord.decrypt("f"))
         .getBooleanSetting("Seconds between lightning rolls")
         .getSetting2(() -> this.valueSettingSub112.isEnum3(SkyboxModule.CloudsThunderEnum.THUNDER));
      this.valueSettingSub103 = new ValueSettingSub10("Strike Chance", 0.65, 0.0, 1.0, 0.05)
         .getBooleanSetting("Odds a roll actually produces a bolt")
         .getSetting2(() -> this.valueSettingSub112.isEnum3(SkyboxModule.CloudsThunderEnum.THUNDER));
      this.valueSettingSub105 = new ValueSettingSub10("Strike Glow", 1.0, 0.1, 3.0, 0.1)
         .getValueSettingSub10("x")
         .getBooleanSetting("How hard a bolt lights the storm")
         .getSetting2(() -> this.valueSettingSub112.isEnum3(SkyboxModule.CloudsThunderEnum.THUNDER));
      this.valueSettingSub113 = new ValueSettingSub11<>("Quality", SkyboxModule.FastBalancedEnum.BALANCED)
         .getBooleanSetting("Noise detail; fewer layers cost far less GPU time");
      this.valueSettingSub106 = new ValueSettingSub10("Resolution", 50.0, 25.0, 100.0, 25.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Fraction of the screen resolution the sky is drawn at");
   }

   public int getInt33() {
      return this.valueSettingSub113.lambda15().getInt3();
   }

   public static enum CloudsThunderEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      CLOUDS,
      THUNDER,
      PULSAR;

      public int getInt() {
         return this.ordinal();
      }


      public boolean isEnabled() {
         return this == THUNDER || this == PULSAR;
      }
   }

   public static enum FastBalancedEnum implements DisplayNamed {
      FAST("Fast", 3),
      BALANCED("Balanced", 4),
      DETAILED("Detailed", 6);

      private final int int_;
      private final String string;

      private FastBalancedEnum(String var3, int var4) {
         this.string = var3;
         this.int_ = var4;
      }

      @Override
      public String getString5() {
         return this.string;
      }

      public int getInt3() {
         return this.int_;
      }

   }
}
