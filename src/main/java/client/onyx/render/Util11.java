package client.onyx.render;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

public final class Util11 {
   private static final double DOUBLE = 0.05;
   private static final double DOUBLE2 = 8.0;
   private static final double DOUBLE3 = 24.0;
   private static final double DOUBLE4 = 0.05859375;
   private static final float FLOAT = 1.0F;
   private static final int INT = 1;
   private static final double DOUBLE5 = 1.0;
   private static final double DOUBLE6 = 4.0;
   private static final double DOUBLE7 = -8.5;
   private static final int INT2 = 3;
   private static final int INT3 = 4;
   private static final double DOUBLE8 = 0.1875;

   private static float getFloatForEntity(Entity var0, float var1) {
      EntityLivingBase var3;
      return var0 instanceof EntityLivingBase
         ? (var3 = (EntityLivingBase)var0).prevRenderYawOffset + (var3.renderYawOffset - var3.prevRenderYawOffset) * var1
         : var0.prevRotationYaw + (var0.rotationYaw - var0.prevRotationYaw) * var1;
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 100;
      byte var10001 = 119;
      int var10000 = var10002;

      for (byte var2 = 92; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var10002 = var5--;
         var1[var10002] = (char)(var10.charAt(var10002) ^ var4);
      }

      return new String(var1);
   }

   public static Util11.LeftTopRecord getLeftTopRecordForEntity(Entity var0, float var1, float var2, float var3) {
      if (!Util8.isEnabled44()) {
         return null;
      } else {
         Vec3 var4;
         if ((var4 = getVec3ForEntity(var0, var1)).addVector(0.0, var0.height * 0.5, 0.0).subtract(Util8.getVec313()).dotProduct(Util8.getVec315()) <= 0.05) {
            return null;
         } else {
            Util11.HalfWidthHalfDepthRecord var5 = Util11.HalfWidthHalfDepthRecord.getHalfWidthHalfDepthRecordForEntity(var0);
            double var6;
            double var8 = Math.cos(var6 = Math.toRadians(getFloatForEntity(var0, var1))) * var5.halfWidth();
            double var10 = Math.sin(var6) * var5.halfWidth();
            double var12 = -Math.sin(var6) * var5.halfDepth();
            var6 = Math.cos(var6) * var5.halfDepth();
            var1 = Float.MAX_VALUE;
            float var14 = -Float.MAX_VALUE;
            float var15 = Float.MAX_VALUE;
            float var16 = -Float.MAX_VALUE;

            int var23;
            for (int var10000 = var23 = 0; var10000 < 8; var10000 = var23) {
               double var18 = (var23 & 1) == 0 ? 1.0 : -1.0;
               double var20 = (var23 & 2) == 0 ? 1.0 : -1.0;
               double var10001 = var8 * var18 + var12 * var20;
               double var10002;
               double var10003;
               if ((var23 & 4) == 0) {
                  var10002 = var5.top();
                  var10003 = var10;
               } else {
                  var10002 = var5.bottom();
                  var10003 = var10;
               }

               Vec3 var19;
               if ((var19 = var4.addVector(var10001, var10002, var10003 * var18 + var6 * var20)).subtract(Util8.getVec313()).dotProduct(Util8.getVec315())
                  <= 0.05) {
                  return null;
               }

               float[] var22;
               if ((var22 = Util8.getFloatArrayForVec3(var19, var2, var3)) == null) {
                  return null;
               }

               var1 = Math.min(var1, var22[0]);
               var14 = Math.max(var14, var22[0]);
               var15 = Math.min(var15, var22[1]);
               var23++;
               var16 = Math.max(var16, var22[1]);
            }

            if (var16 - var15 <= 1.0F) {
               return null;
            } else {
               float[] var29 = Util8.getFloatArrayForVec3(var4.addVector(0.0, var5.top(), 0.0), var2, var3);
               float[] var28 = Util8.getFloatArrayForVec3(var4.addVector(0.0, var5.bottom(), 0.0), var2, var3);
               if (var29 != null && var28 != null) {
                  float var24 = var14 - var1;
                  return new Util11.LeftTopRecord(var1, var15, var24, var16 - var15, var29[0], var28[0]);
               } else {
                  return null;
               }
            }
         }
      }
   }

   private static Vec3 getVec3ForEntity(Entity var0, float var1) {
      return new Vec3(
         var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * var1,
         var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * var1,
         var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * var1
      );
   }

   private Util11() {
   }

   private record HalfWidthHalfDepthRecord(double halfWidth, double halfDepth, double top, double bottom) {
      static Util11.HalfWidthHalfDepthRecord getHalfWidthHalfDepthRecordForEntity(Entity var0) {
         if (var0 instanceof EntityPlayer var4) {
            double var2 = (32.5 - getDoubleForEntityLivingBase(var4, 4)) * 0.05859375;
            double var10002 = (8.0 + getDoubleForEntityLivingBase(var4, 3)) * 0.05859375;
            double var10003 = (4.0 + getDoubleForEntityLivingBase(var4, 4)) * 0.05859375;
            double var10004;
            EntityPlayer var10005;
            if (var4.isSneaking()) {
               var10004 = var2 - 0.1875;
               var10005 = var4;
            } else {
               var10004 = var2;
               var10005 = var4;
            }

            Util11.HalfWidthHalfDepthRecord var10000 = new Util11.HalfWidthHalfDepthRecord(var10002, var10003, var10004, -getDoubleForEntityLivingBase(var10005, 1) * 0.05859375);
            return var10000;
         } else {
            return new Util11.HalfWidthHalfDepthRecord(var0.width * 0.5, var0.width * 0.5, var0.height, 0.0);
         }
      }

      private static double getDoubleForEntityLivingBase(EntityLivingBase var0, int var1) {
         return var0.getEquipmentInSlot(var1) != null ? 1.0 : 0.0;
      }
   }

   public record LeftTopRecord(float left, float top, float width, float height, float topCenterX, float bottomCenterX) {
   }
}
