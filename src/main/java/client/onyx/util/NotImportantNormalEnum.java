package client.onyx.util;

public enum NotImportantNormalEnum {
   // 顺序按原 $VALUES 数组（即 ordinal）
   NOT_IMPORTANT(-20),
   NORMAL(0),
   IMPORTANT_FOR_USAGE_1(20),
   IMPORTANT_FOR_USAGE_2(30),
   IMPORTANT_FOR_USAGE_3(35),
   IMPORTANT_FOR_PLAYER_LIFE(40),
   IMPORTANT_FOR_USER_SAFETY(60);
   private final int int_;

   private NotImportantNormalEnum(int var3) {
      this.int_ = var3;
   }

   static {
      NotImportantNormalEnum[] var0 = new NotImportantNormalEnum[]{
         NOT_IMPORTANT, NORMAL, IMPORTANT_FOR_USAGE_1, IMPORTANT_FOR_USAGE_2, IMPORTANT_FOR_USAGE_3, IMPORTANT_FOR_PLAYER_LIFE, IMPORTANT_FOR_USER_SAFETY
      };
   }

   public int getInt() {
      return this.int_;
   }
}
