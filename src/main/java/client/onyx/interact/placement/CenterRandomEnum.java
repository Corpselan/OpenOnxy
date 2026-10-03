package client.onyx.interact.placement;

import client.onyx.setting.DisplayNamed;

public enum CenterRandomEnum implements DisplayNamed {
   // 顺序按原 $VALUES 数组（即 ordinal）
   CENTER("Center"),
   RANDOM("Random"),
   STABILIZED("Stabilized"),
   NEAREST_ROTATION("NearestRotation"),
   EDGE_POINT("EdgePoint");
   private final String string;

   @Override
   public String getString5() {
      return this.string;
   }

   private CenterRandomEnum(String var3) {
      this.string = var3;
   }

}
