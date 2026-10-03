package client.onyx.render;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.module.render.ChamsModule;
import client.onyx.system.SelfEnemyEnum;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

public final class Util10 implements MinecraftAccess {
   private static float float_;
   private static boolean bool = true;
   private static boolean bool2;
   private static boolean bool3;
   private static client.onyx.render.extra.Cls cls;
   private static float float_2;
   private static float float_3;
   private static boolean bool4;
   private static float float_4;
   private static float float_5;

   public static void run54() {
      if (bool2) {
         bool2 = false;
         client.onyx.render.extra.Cls.run2();
         GlStateManager.enableDepth();
         GlStateManager.depthMask(true);
         GlStateManager.disableBlend();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.resetColor();
      }
   }

   public static boolean isEnabled47() {
      if (bool2 && bool4) {
         GlStateManager.disableDepth();
         GlStateManager.depthMask(false);
         cls.handleString4("uTint", float_3, float_5, float_, float_2);
         return true;
      } else {
         return false;
      }
   }

   public static boolean isEntity(Entity var0) {
      if (var0 instanceof EntityLivingBase var3) {
         if (!isEnabled46()) {
            return false;
         } else {
            ChamsModule var2 = OnyxClient.cls.chamsModule;
            SelfEnemyEnum var4;
            return (var4 = OnyxClient.cls.chamsModule.getSelfEnemyEnum(var3)) != null && var2.isSelfEnemyEnum(var4);
         }
      } else {
         return false;
      }
   }

   public static boolean isEntityLivingBase(EntityLivingBase var0) {
      if (!bool || OnyxClient.cls == null) {
         return false;
      } else if (!OpenGlHelper.shadersSupported) {
         return false;
      } else {
         ChamsModule var1 = OnyxClient.cls.chamsModule;
         SelfEnemyEnum var5;
         if ((var5 = OnyxClient.cls.chamsModule.getSelfEnemyEnum(var0)) == null) {
            return false;
         } else {
            if (!bool3) {
               bool3 = true;
               cls = client.onyx.render.extra.Cls.getClsForString("onyx_chams");
            }

            if (cls != null && cls.isEnabled()) {
               ChamsModule.ColorSettingGroup var4 = var1.getColorSettingGroup2(var5);
               int var3;
               float_3 = client.onyx.theme.impl.Util2.getIntForInt7(var3 = var1.getInt30(var5)) / 255.0F;
               float_5 = client.onyx.theme.impl.Util2.getIntForInt(var3) / 255.0F;
               float_ = client.onyx.theme.impl.Util2.getIntForInt2(var3) / 255.0F;
               float_4 = client.onyx.theme.impl.Util2.getIntForInt6(var3) / 255.0F;
               bool4 = var1.isSelfEnemyEnum(var5);
               float_2 = float_4 * var1.getFloat41(var5);
               GlStateManager.enableBlend();
               GlStateManager.tryBlendFuncSeparate(770, 771, 1, 771);
               GlStateManager.depthMask(true);
               cls.run3();
               cls.handleString5("Sampler0", 0);
               cls.handleString5("Sampler1", 1);
               cls.handleString4("uTint", float_3, float_5, float_, float_4);
               client.onyx.render.extra.Cls var6 = cls;
               float var8 = var4.valueSettingSub102.getFloat5() / 100.0F;
               float var9 = var1.getFloat42(var5);
               var6.handleString4("uStyle", var8, 0.0F, 0.0F, var9);
               cls.handleString("uFogEnabled", GL11.glIsEnabled(2912) ? 1.0F : 0.0F);
               bool2 = true;
               return true;
            } else {
               bool = false;
               return false;
            }
         }
      }
   }

   public static void run53() {
      GlStateManager.enableDepth();
      GlStateManager.depthMask(true);
      cls.handleString4("uTint", float_3, float_5, float_, float_4);
   }

   private Util10() {
   }

   public static boolean isEnabled46() {
      if (bool && OnyxClient.cls != null) {
         if (!OpenGlHelper.shadersSupported) {
            return false;
         } else {
            ChamsModule var0 = OnyxClient.cls.chamsModule;
            if (!OnyxClient.cls.chamsModule.isEnabled55()) {
               return false;
            } else {
               SelfEnemyEnum[] var1;
               int var2 = (var1 = SelfEnemyEnum.values()).length;

               int var3;
               for (int var10000 = var3 = 0; var10000 < var2; var10000 = ++var3) {
                  SelfEnemyEnum var4 = var1[var3];
                  if (var0.getColorSettingGroup2(var4).isEnabled5() && var0.isSelfEnemyEnum(var4)) {
                     return true;
                  }
               }

               return false;
            }
         }
      } else {
         return false;
      }
   }
}
