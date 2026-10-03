package client.onyx.module.player.scaffold.extra;

import client.onyx.MinecraftAccess;
import client.onyx.setting.Setting;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.util.Util2;
import client.onyx.util.Util3;
import client.onyx.util.Util6;
import client.onyx.util.math.PositionDirectionRecord;
import java.util.ArrayDeque;
import net.minecraft.util.Vec3;

public class PredictionSettingGroup extends SettingGroup implements MinecraftAccess {
   public static final PredictionSettingGroup PREDICTION_SETTING_GROUP = new PredictionSettingGroup();
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub10 valueSettingSub102;
   private final transient ArrayDeque<Vec3> arrayDeque = new ArrayDeque<>(5);
   private static final int INT = 4;
   public ValueSettingSub10 valueSettingSub103;

   @Override
   protected void run4() {
      this.run168();
   }

   private Vec3 getVec321(Vec3 var1, Vec3 var2) {
      return this.valueSettingSub102.getFloat5() <= 0.0F ? var1 : var1.subtract(Util6.getVec3ForVec3(var2, this.valueSettingSub102.getFloat5()));
   }

   public Vec3 getVec322(PositionDirectionRecord var1) {
      if (var1 != null && this.isEnabled5()) {
         if (Util2.isEntityPlayerSP2(MINECRAFT.thePlayer, this.valueSettingSub103.getFloat5())) {
            return null;
         } else {
            Vec3 var5;
            if ((var5 = this.getVec320(var1)) == null) {
               return null;
            } else {
               Vec3 var6 = Util2.getVec3ForEntity2(MINECRAFT.thePlayer);
               var6 = var5.subtract(var6);
               var6 = this.getVec321(var5, var6);
               Vec3 var4;
               if ((var4 = this.getVec319()) == null) {
                  client.onyx.module.player.scaffold.Util.BlockPosOffsetXRecord var8;
                  return (var8 = client.onyx.module.player.scaffold.Util.getBlockPosOffsetXRecord2()) != null
                     ? var6.add(var8.offsetX(), 0.0, var8.offsetZ())
                     : var6;
               } else {
                  float var2 = (float)Math.atan2(var1.getVec3().zCoord, var1.getVec3().xCoord);
                  Vec3 var7 = var5.add(var4.rotateYaw(-var2));
                  return var6.lerp(var7, this.getDouble31());
               }
            }
         }
      } else {
         return null;
      }
   }

   public void handlePositionDirectionRecord(PositionDirectionRecord var1, Vec3 var2) {
      if (var1 != null && this.isEnabled5()) {
         if (var2 != null) {
            float var3 = (float)Math.atan2(var1.getVec3().zCoord, var1.getVec3().xCoord);
            Vec3 var4 = Util2.getVec3ForEntity2(MINECRAFT.thePlayer).subtract(var2).rotateYaw(var3);
            this.arrayDeque.addLast(var4);
            if (this.arrayDeque.size() > 4) {
               this.arrayDeque.removeFirst();
            }
         }
      }
   }

   public Vec3 getVec319() {
      return this.arrayDeque.isEmpty() ? null : Util6.getVec3ForIterable(this.arrayDeque);
   }

   public void run168() {
      this.arrayDeque.clear();
   }

   public Vec3 getVec320(PositionDirectionRecord var1) {
      Vec3 var10000 = var1.getVec34(Util2.getVec3ForEntity2(MINECRAFT.thePlayer)).add(0.0, -0.1, 0.0);
      Vec3 var2;
      return (var2 = Util3.getVec3ForVec38(var10000, var10000.add(Util6.getVec3ForVec3(var1.getVec3(), 3.0)))) == null
         ? null
         : Util6.getVec3ForVec38(var2, MINECRAFT.thePlayer.posY);
   }

   private PredictionSettingGroup() {
      super("Prediction", false);
      this.valueSettingSub102 = new ValueSettingSub10("Bootstrap backoff", 0.2, 0.0, 0.4, 0.01);
      this.valueSettingSub103 = new ValueSettingSub10("Prediction cutoff distance", 0.05, 0.0, 0.3, 0.01);
      this.valueSettingSub10 = new ValueSettingSub10("Warmup placements", 2.0, 0.0, 4.0, 1.0);
      this.getSetting2(Setting.BOOLEAN_SUPPLIER);
   }

   private double getDouble31() {
      return this.valueSettingSub10.getInt10() <= 0 ? 1.0 : Math.clamp((double)this.arrayDeque.size() / this.valueSettingSub10.getInt10(), 0.0, 1.0);
   }
}
