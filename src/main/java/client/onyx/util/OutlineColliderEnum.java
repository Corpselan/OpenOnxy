package client.onyx.util;

public enum OutlineColliderEnum {
   // 顺序按原 $VALUES 数组（即 ordinal）
   OUTLINE(false),
   COLLIDER(true);
   private final boolean bool;

   private OutlineColliderEnum(boolean var3) {
      this.bool = var3;
   }

   public boolean isEnabled() {
      return this.bool;
   }

}
