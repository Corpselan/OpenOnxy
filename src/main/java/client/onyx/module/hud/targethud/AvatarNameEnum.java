package client.onyx.module.hud.targethud;

import client.onyx.setting.DisplayNamed;

public enum AvatarNameEnum implements DisplayNamed {
   // 顺序按原 $VALUES 数组（即 ordinal）
   AVATAR("Avatar", AvatarNameEnum.AvatarTextEnum.AVATAR),
   NAME("Name", AvatarNameEnum.AvatarTextEnum.TEXT),
   HEALTH("Health", AvatarNameEnum.AvatarTextEnum.HEALTH_TEXT),
   DISTANCE("Distance", AvatarNameEnum.AvatarTextEnum.TEXT),
   STATUS("Status", AvatarNameEnum.AvatarTextEnum.TEXT),
   HEALTH_BAR("Health bar", AvatarNameEnum.AvatarTextEnum.BAR);
   private final String string;
   private final AvatarNameEnum.AvatarTextEnum avatarTextEnum;

   public boolean isEnabled9() {
      return this.avatarTextEnum == AvatarNameEnum.AvatarTextEnum.BAR;
   }

   public AvatarNameEnum.AvatarTextEnum getAvatarTextEnum() {
      return this.avatarTextEnum;
   }

   public boolean isEnabled11() {
      return this.avatarTextEnum == AvatarNameEnum.AvatarTextEnum.TEXT || this.avatarTextEnum == AvatarNameEnum.AvatarTextEnum.HEALTH_TEXT;
   }

   public boolean isEnabled10() {
      return this.avatarTextEnum == AvatarNameEnum.AvatarTextEnum.HEALTH_TEXT;
   }

   @Override
   public String getString5() {
      return this.string;
   }


   private AvatarNameEnum(String var3, AvatarNameEnum.AvatarTextEnum var4) {
      this.string = var3;
      this.avatarTextEnum = var4;
   }

   public static enum AvatarTextEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      AVATAR,
      TEXT,
      HEALTH_TEXT,
      BAR;

   }
}
