package client.onyx.render.hud;

import client.onyx.module.hud.CustomGuiModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;

public final class Util6 {
   public static final float FLOAT = 8.0F;
   private static final client.onyx.render.misc.Cls CLS = new client.onyx.render.misc.Cls(0.0F);

   public static void handleFloat(float var0) {
      CustomGuiModule var3;
      if ((var3 = Util4.getCustomGuiModule()) != null && var3.isEnabled55() && var3.chatBooleanSetting.isEnabled5()) {
         boolean var2 = Minecraft.getMinecraft().currentScreen instanceof GuiChat;
         float var4 = var3.chatBooleanSetting.valueSettingSub10.getFloat5();
         float var10001;
         float var10002;
         if (var2) {
            var10001 = 1.0F;
            var10002 = var4;
         } else {
            var10001 = 0.0F;
            var10002 = var4;
         }

         CLS.getCls2(var10001, var10002, var2 ? client.onyx.render.misc.Util.IFACE7 : client.onyx.render.misc.Util.IFACE);
         CLS.handleFloat(var0);
      } else {
         CLS.getCls(0.0F);
      }
   }

   public static void run() {
      CLS.getCls(0.0F);
   }

   public static float getFloat2() {
      return CLS.getFloat();
   }

   public static float getFloat() {
      CustomGuiModule var0;
      return (var0 = Util4.getCustomGuiModule()) != null && var0.isEnabled55() && var0.chatBooleanSetting.isEnabled5()
         ? CLS.getFloat() * var0.chatBooleanSetting.valueSettingSub102.getFloat5()
         : 0.0F;
   }

   private Util6() {
   }
}
