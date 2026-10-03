package client.onyx.account;

import client.onyx.MinecraftAccess;
import client.onyx.util.Util4;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.client.resources.SkinManager.SkinAvailableCallback;
import net.minecraft.util.ResourceLocation;

public final class Util implements MinecraftAccess {
   static final Map<UUID, ResourceLocation> MAP2 = new ConcurrentHashMap<>();
   private static final Map<UUID, Boolean> MAP = new ConcurrentHashMap<>();

   public static void handleUUID(UUID var0) {
      if (var0 != null) {
         MAP2.remove(var0);
         MAP.remove(var0);
      }
   }

   public static ResourceLocation getResourceLocationForUUID(UUID var0, String var1) {
      if (var0 == null) {
         return DefaultPlayerSkin.getDefaultSkinLegacy();
      } else {
         ResourceLocation var3;
         if ((var3 = MAP2.get(var0)) != null) {
            return var3;
         } else {
            handleUUID2(var0, var1);
            return DefaultPlayerSkin.getDefaultSkin(var0);
         }
      }
   }

   private Util() {
   }

   private static void handleUUID2(UUID var0, String var1) {
      if (MAP.putIfAbsent(var0, Boolean.TRUE) == null) {
         Util4.handleRunnable(() -> {
            GameProfile var3 = new GameProfile(var0, var1);

            try {
               MINECRAFT.getSessionService().fillProfileProperties(var3, false);
            } catch (RuntimeException var2) {
            }

            MINECRAFT.addScheduledTask(() -> {
               SkinManager var2x = MINECRAFT.getSkinManager();
               SkinAvailableCallback var3x = new SkinAvailableCallback() {
                  @Override
                  public void skinAvailable(Type var1x, ResourceLocation var2, MinecraftProfileTexture var3xx) {
                     if (var1x == Type.SKIN) {
                        Util.MAP2.put(var0, var2);
                     }
                  }
               };
               var2x.loadProfileTextures(var3, var3x, false);
            });
         });
      }
   }
}
