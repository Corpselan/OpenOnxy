package client.onyx.render.anim;

import client.onyx.MinecraftAccess;
import client.onyx.module.render.BlockOverlayModule;
import client.onyx.render.Util7;
import client.onyx.theme.impl.Util2;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;

public final class Cls implements MinecraftAccess {
   private static final double DOUBLE = 0.0015D;

   public static AxisAlignedBB getAxisAlignedBBForBlockPos2(BlockPos var0) {
      return AxisAlignedBB.fromBounds((double)var0.getX(), (double)var0.getY(), (double)var0.getZ(), (double)(var0.getX() + 1), (double)(var0.getY() + 1), (double)(var0.getZ() + 1));
   }

   private static AxisAlignedBB getAxisAlignedBBForAxisAlignedBB2(AxisAlignedBB var0, float var1, ThemeColorRecord var2) {
      if (var2.progressMode() == BlockOverlayModule.FillGrowEnum.GROW) {
         return getAxisAlignedBBForAxisAlignedBB(var0, var1);
      } else {
         double var3 = (var0.maxY - var0.minY) * (double)var1;
         return var2.progressUpward() ? getAxisAlignedBBForDouble(var0.minX, var0.minY, var0.minZ, var0.maxX, var0.minY + var3, var0.maxZ) : getAxisAlignedBBForDouble(var0.minX, var0.maxY - var3, var0.minZ, var0.maxX, var0.maxY, var0.maxZ);
      }
   }

   private static AxisAlignedBB getAxisAlignedBBForDouble(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = Math.min(0.0015D, (var6 - var0) / 2.0D);
      double var14 = Math.min(0.0015D, (var8 - var2) / 2.0D);
      double var16 = Math.min(0.0015D, (var10 - var4) / 2.0D);
      return AxisAlignedBB.fromBounds(var0 + var12, var2 + var14, var4 + var16, var6 - var12, var8 - var14, var10 - var16);
   }

   public void run55() {
      Util.run56();
   }

   public void handleFloat31(float var1, BlockPos var2, AxisAlignedBB var3, float var4, float var5, ThemeColorRecord var6) {
      if (!(var4 <= 0.0F)) {
         boolean var7;
         AxisAlignedBB var8;
         boolean var10000;
         label57: {
            var7 = var6.progress() && var5 > 0.001F;
            var8 = var7 ? getAxisAlignedBBForAxisAlignedBB2(var3, var5, var6) : var3;
            boolean var10 = var7 && var6.progressMode() == BlockOverlayModule.FillGrowEnum.FILL;
            if (var6.theme() == BlockOverlayModule.OutlineFillEnum.GLINT && var2 != null) {
               AxisAlignedBB var10002;
               boolean var10003;
               if (var10) {
                  var10002 = var3;
                  var10003 = var10;
               } else {
                  var10002 = var8;
                  var10003 = var10;
               }

               AxisAlignedBB var12;
               float var10004;
               if (var10003) {
                  var12 = var8;
                  var10004 = var4;
               } else {
                  var12 = null;
                  var10004 = var4;
               }

               if (Util.isFloat4(var1, var2, var10002, var12, var10004, var6)) {
                  var10000 = true;
                  break label57;
               }
            }

            var10000 = false;
         }

         boolean var9 = var10000;
         if (Util7.isFloat3(var1, var6.throughWalls())) {
            AxisAlignedBB var11;
            label49: {
               if (var7) {
                  if (!var9) {
                     var11 = var3;
                     Util7.handleAxisAlignedBB2(var8, 0, 0.0F, Util2.getIntForInt3(var6.color(), var4 * var6.progressOpacity()));
                     break label49;
                  }
               } else if (var6.theme() == BlockOverlayModule.OutlineFillEnum.FILL && !var9) {
                  Util7.handleAxisAlignedBB2(var3, 0, 0.0F, Util2.getIntForInt3(var6.color(), var4 * var6.fillOpacity()));
               }

               var11 = var3;
            }

            Util7.handleAxisAlignedBB2(var11, Util2.getIntForInt3(var6.color(), var4 * var6.outlineOpacity()), var6.lineWidth(), 0);
            Util7.run49();
         }
      }
   }

   private static AxisAlignedBB getAxisAlignedBBForAxisAlignedBB(AxisAlignedBB var0, float var1) {
      double var2 = (var0.minX + var0.maxX) / 2.0D;
      double var4 = (var0.minY + var0.maxY) / 2.0D;
      double var6 = (var0.minZ + var0.maxZ) / 2.0D;
      return AxisAlignedBB.fromBounds(var2 + (var0.minX - var2) * (double)var1, var4 + (var0.minY - var4) * (double)var1, var6 + (var0.minZ - var6) * (double)var1, var2 + (var0.maxX - var2) * (double)var1, var4 + (var0.maxY - var4) * (double)var1, var6 + (var0.maxZ - var6) * (double)var1);
   }
}
