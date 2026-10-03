package client.onyx.interact.placement;

import client.onyx.MinecraftAccess;
import client.onyx.util.Util12;
import client.onyx.util.Util2;
import java.util.Comparator;
import java.util.List;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;

public class Cls2 implements MinecraftAccess {
   private final List<? extends Vec3i> list;
   private final Comparator<BlockPos> comparator;

   public static Cls2 getCls2() {
      return new Cls2(
         NoOffsetNormalEnum.NO_OFFSET.getList(),
         Comparator.comparingDouble(
            var0 -> {
               Vec3 var2 = Util2.getVec3ForEntity2(MINECRAFT.thePlayer);
               return -Util12.getDoubleForAxisAlignedBB3(
                  client.onyx.interact.Util.getAxisAlignedBBForBlockPos(var0).offset(var0.getX(), var0.getY(), var0.getZ()), var2
               );
            }
         )
      );
   }

   public List<? extends Vec3i> getList() {
      return this.list;
   }

   public Comparator<BlockPos> getComparator() {
      return this.comparator;
   }

   public Cls2(List<? extends Vec3i> var1, Comparator<BlockPos> var2) {
      this.list = var1;
      this.comparator = var2;
   }
}
