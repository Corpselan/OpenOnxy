package client.onyx.module.render;

import client.onyx.MinecraftAccess;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.Util8;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public final class Cls implements MinecraftAccess {
   private static final int INT = 5;
   private static final float FLOAT = 16.0F;
   private static final float FLOAT2 = 0.45F;
   private static final float FLOAT3 = 1.4F;
   private static final float FLOAT4 = 12.0F;
   private static final float FLOAT5 = 11.0F;
   private static final float FLOAT6 = 4.0F;
   private static final double DOUBLE = 1.4D;
   private static final int INT2 = -938339561;
   private static final float FLOAT7 = 10.0F;
   private static final float FLOAT8 = 1.0F;
   private final BedESPModule bedESPModule;
   private static final float FLOAT9 = 4.0F;
   private static final float FLOAT10 = 30.0F;

   private static String getStringForIconNameRecord(BedESPModule.IconNameRecord var0) {
      return String.valueOf(var0.count());
   }

   public Cls(BedESPModule var1) {
      this.bedESPModule = var1;
   }

   private void handleSampler013(Sampler0 var1, BedESPModule.IconNameRecord var2, float var3, float var4) {
      var1.run36();
      var1.handleFloat11(4.0F, var4 + 0.5F);
      var1.handleFloat12(0.625F, 0.0F, 0.0F);
      var1.handleItemStack(var2.icon(), 0.0F, 0.0F);
      var1.run43();
      var1.handleOpticalWeightRecord6(Util2.OPTICAL_WEIGHT_RECORD8, getStringForIconNameRecord(var2), var3 - 4.0F, var4 + 5.5F, Util4.getPrimaryOnPrimaryRecord().onSurface());
   }

   private double getDouble26(BlockPos var1) {
      return MINECRAFT.thePlayer.getDistanceSq((double)var1.getX() + 0.5D, (double)var1.getY() + 0.5D, (double)var1.getZ() + 0.5D);
   }

   public void handleSampler012(Sampler0 var1, float var2, float var3) {
      ArrayList<BedESPModule.BedOwnRecord> var4;
      if (!(var4 = new ArrayList<>(this.bedESPModule.getList19())).isEmpty()) {
         Util14.handleBool(this.bedESPModule.valueSettingSub96.isEnabled17());
         var4.sort(Comparator.comparingDouble((var1x) -> {
            return -this.getDouble26(var1x.bed());
         }));
         Iterator var10;
         Iterator var10000 = var10 = var4.iterator();

         while(var10000.hasNext()) {
            BedESPModule.BedOwnRecord var5 = (BedESPModule.BedOwnRecord)var10.next();
            double var6 = this.getDouble26(var5.bed());
            BlockPos var9 = var5.bed();
            float[] var11;
            if ((var11 = Util8.getFloatArrayForVec3(new Vec3((double)var9.getX() + 0.5D, (double)var9.getY() + 1.4D, (double)var9.getZ() + 0.5D), var2, var3)) == null) {
               var10000 = var10;
            } else {
               this.handleSampler014(var1, var5, var11[0], var11[1], this.getFloat39(var6));
               var10000 = var10;
            }
         }

      }
   }

   public boolean isEnabled60() {
      return this.bedESPModule.isEnabled55() && this.bedESPModule.valueSettingSub97.isEnabled17() && MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null && Util8.isEnabled44();
   }

   private float getFloat39(double var1) {
      Cls var3 = this;
      float var5 = (float)Math.sqrt(var1);
      float var4 = 12.0F / Math.max(1.0F, var5);
      float var2;
      if ((var2 = var3.bedESPModule.valueSettingSub103.getFloat5()) != 1.0F) {
         var4 = (float)Math.pow((double)var4, (double)var2);
      }

      return var3.bedESPModule.valueSettingSub107.getFloat5() * Math.min(1.4F, Math.max(0.45F, var4));
   }

   private void handleSampler014(Sampler0 var1, BedESPModule.BedOwnRecord var2, float var3, float var4, float var5) {
      List var12 = var2.entries();
      int var6 = Math.min(5, var12.size());
      boolean var7 = var12.size() > var6;
      int var8 = var6 + (var7 ? 1 : 0);
      float var11 = 30.0F;

      int var10;
      int var10000;
      for(var10000 = var10 = 0; var10000 < var6; var10000 = var10) {
         float var10002 = var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD8, getStringForIconNameRecord((BedESPModule.IconNameRecord)var12.get(var10)));
         ++var10;
         var11 = Math.max(var11, 22.0F + var10002);
      }

      float var14 = 8.0F + (float)var8 * 11.0F + (float)Math.max(0, var8 - 1) * 1.0F;
      var1.run36();
      var1.handleFloat11(var3, var4);
      var1.handleFloat12(var5, 0.0F, 0.0F);
      var1.handleFloat11(-var11 / 2.0F, -var14);
      Util14.handleSampler02(var1, 0.0F, 0.0F, var11, var14, 8.0F, -938339561, this.bedESPModule.valueSettingSub96.isEnabled17());
      var3 = 4.0F;

      int var13;
      for(var10000 = var13 = 0; var10000 < var6; var10000 = var13) {
         this.handleSampler013(var1, (BedESPModule.IconNameRecord)var12.get(var13), var11, var3);
         ++var13;
         var3 += 12.0F;
      }

      if (var7) {
         var1.handleOpticalWeightRecord4(Util2.OPTICAL_WEIGHT_RECORD8, (new StringBuilder()).insert(0, "+").append(var12.size() - var6).toString(), var11 / 2.0F, var3 + 5.5F, Util4.getIntForInt2(Util4.getPrimaryOnPrimaryRecord().onSurfaceVariant(), 0.75F));
      }

      var1.run43();
   }
}
