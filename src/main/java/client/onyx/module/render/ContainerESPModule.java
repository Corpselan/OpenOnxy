package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Util7;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.impl.Util2;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;

public final class ContainerESPModule extends Module {
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub9 valueSettingSub92;
   public final ValueSettingSub9 valueSettingSub93;
   public final ValueSettingSub9 valueSettingSub94;
   public final ValueSettingSub10 valueSettingSub10;
   public final ValueSettingSub9 valueSettingSub95 = new ValueSettingSub9("Chests", true);
   public final ValueSettingSub9 valueSettingSub96;

   public void handleFloat47(float var1) {
      if (this.isEnabled55() && MINECRAFT.theWorld != null) {
         ArrayList var4 = new ArrayList<>(MINECRAFT.theWorld.loadedTileEntityList);
         boolean var3 = false;
         Iterator var7;
         Iterator var10000 = var7 = var4.iterator();

         while (var10000.hasNext()) {
            TileEntity var6 = (TileEntity)var7.next();
            int var5;
            if ((var5 = this.getInt31(var6)) == 0) {
               var10000 = var7;
            } else {
               if (!var3) {
                  if (!Util7.isFloat3(var1, this.valueSettingSub92.isEnabled17())) {
                     return;
                  }

                  var3 = true;
               }

               BlockPos var8;
               Util7.handleAxisAlignedBB2(
                  AxisAlignedBB.fromBounds(
                     (var8 = var6.getPos()).getX() - 0.003,
                     var8.getY() - 0.003,
                     var8.getZ() - 0.003,
                     var8.getX() + 1.003,
                     var8.getY() + 1.003,
                     var8.getZ() + 1.003
                  ),
                  Util2.getIntForInt3(var5, 0.95F),
                  this.valueSettingSub10.getFloat5(),
                  Util2.getIntForInt3(var5, this.valueSettingSub93.isEnabled17() ? 0.14F : 0.0F)
               );
               var10000 = var7;
            }
         }

         if (var3) {
            Util7.run49();
         }
      }
   }

   private int getInt31(TileEntity var1) {
      if (var1 instanceof TileEntityChest && this.valueSettingSub95.isEnabled17()) {
         return -19673;
      } else if (var1 instanceof TileEntityEnderChest && this.valueSettingSub9.isEnabled17()) {
         return -7055617;
      } else if (var1 instanceof TileEntityHopper && this.valueSettingSub94.isEnabled17()) {
         return -8947070;
      } else {
         return var1 instanceof TileEntityFurnace && this.valueSettingSub96.isEnabled17() ? -3092272 : 0;
      }
   }

   public ContainerESPModule() {
      super("ContainerESP", "Highlights storage blocks", ModuleCategory.RENDER);
      this.valueSettingSub9 = new ValueSettingSub9("Ender chests", false);
      this.valueSettingSub94 = new ValueSettingSub9("Hoppers", false);
      this.valueSettingSub96 = new ValueSettingSub9("Furnaces", false);
      this.valueSettingSub93 = new ValueSettingSub9("Fill", true);
      this.valueSettingSub92 = new ValueSettingSub9("Through walls", true);
      this.valueSettingSub10 = new ValueSettingSub10("Line width", 1.5, 0.5, 5.0, 0.5).getValueSettingSub10(" px");
   }
}
