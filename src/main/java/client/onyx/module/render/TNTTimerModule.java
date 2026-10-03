package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Sampler0;
import client.onyx.render.Util8;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.theme.Util2;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.Vec3;

public final class TNTTimerModule extends Module {
   public final ValueSettingSub6 valueSettingSub6;

   public void handleSampler07(Sampler0 var1, float var2, float var3, float var4) {
      if (this.isEnabled55() && MINECRAFT.theWorld != null && Util8.isEnabled44()) {
         Iterator var5 = MINECRAFT.theWorld.loadedEntityList.iterator();

         label24:
         while (true) {
            Iterator var10000 = var5;

            while (var10000.hasNext()) {
               Entity var9;
               if (!((var9 = (Entity)var5.next()) instanceof EntityTNTPrimed)) {
                  continue label24;
               }

               EntityTNTPrimed var10 = (EntityTNTPrimed)var9;
               float[] var7;
               if ((
                     var7 = Util8.getFloatArrayForVec3(
                        new Vec3(
                           var10.lastTickPosX + (var10.posX - var10.lastTickPosX) * var4,
                           var10.lastTickPosY + (var10.posY - var10.lastTickPosY) * var4 + 1.25,
                           var10.lastTickPosZ + (var10.posZ - var10.lastTickPosZ) * var4
                        ),
                        var2,
                        var3
                     )
                  )
                  == null) {
                  var10000 = var5;
               } else {
                  Object[] var10001 = new Object[1];
                  boolean var10003 = true;
                  var10001[0] = Math.max(0.0F, (var10.fuse - var4) / 20.0F);
                  String var11 = String.format("%.1fs", var10001);
                  var10000 = var5;
                  float var8 = var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD11, var11) + 8.0F;
                  var1.handleFloat7(var7[0] - var8 / 2.0F, var7[1] - 7.0F, var8, 14.0F, 8.0F, -1206643431);
                  var1.handleOpticalWeightRecord4(Util2.OPTICAL_WEIGHT_RECORD11, var11, var7[0], var7[1], this.valueSettingSub6.getInt8());
               }
            }

            return;
         }
      }
   }

   public TNTTimerModule() {
      super("TNTTimer", "Shows time remaining before TNT explodes", ModuleCategory.RENDER);
      ValueSettingSub6 var1 = new ValueSettingSub6("Color", -41892);
      this.valueSettingSub6 = var1;
   }
}
