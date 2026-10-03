package client.onyx.render.hud;

import client.onyx.OnyxClient;
import client.onyx.module.hud.CustomGuiModule;
import java.util.function.Predicate;

public final class Util4 {
   private static boolean bool;
   private static long long_;
   private static final float FLOAT = 100.0F;
   private static final float FLOAT2 = 16.0F;
   public static final int INT = 22;
   private static float float_ = 16.0F;

   public static boolean isEnabled6() {
      return isPredicate(var0 -> var0.chatBooleanSetting.isEnabled5());
   }

   public static boolean isEnabled9() {
      return isPredicate(var0 -> var0.modeBooleanSetting.isEnabled5());
   }

   public static float getFloat() {
      return float_;
   }

   public static float getFloat3() {
      long var0 = System.nanoTime();
      float_ = long_ == 0L ? 16.0F : Math.min((float)(var0 - long_) / 1000000.0F, 100.0F);
      long_ = var0;
      return float_;
   }

   public static boolean isEnabled2() {
      return isPredicate(var0 -> var0.chatBooleanSetting.isEnabled5() && var0.chatBooleanSetting.valueSettingSub92.isEnabled17());
   }

   public static boolean isEnabled10() {
      return bool;
   }

   public static void run2() {
      bool = true;
   }

   public static float getFloat2() {
      CustomGuiModule var0;
      return (var0 = getCustomGuiModule()) != null && var0.isEnabled55() && var0.noGUIShadowBooleanSetting.isEnabled5()
         ? var0.noGUIShadowBooleanSetting.valueSettingSub10.getFloat5() / 100.0F
         : 1.0F;
   }

   public static void run() {
      bool = false;
   }

   public static boolean isEnabled7() {
      return isPredicate(var0 -> var0.durationBooleanSetting.valueSettingSub93.isEnabled17());
   }

   public static boolean isEnabled3() {
      return isPredicate(var0 -> var0.bossbarBooleanSetting.isEnabled5());
   }

   private static boolean isPredicate(Predicate<CustomGuiModule> var0) {
      CustomGuiModule var2;
      return (var2 = getCustomGuiModule()) != null && var2.isEnabled55() && var0.test(var2);
   }

   private Util4() {
   }

   public static boolean isEnabled8() {
      return isPredicate(var0 -> var0.hotbarBooleanSetting.isEnabled5());
   }

   public static boolean isEnabled() {
      return isPredicate(var0 -> var0.titleBooleanSetting.isEnabled5());
   }

   public static boolean isEnabled5() {
      return isPredicate(var0 -> var0.scoreboardBooleanSetting.isEnabled5());
   }

   public static boolean isEnabled4() {
      CustomGuiModule var0;
      return (var0 = getCustomGuiModule()) != null && var0.isEnabled55();
   }

   public static CustomGuiModule getCustomGuiModule() {
      return OnyxClient.cls == null ? null : OnyxClient.cls.customGuiModule;
   }
}
