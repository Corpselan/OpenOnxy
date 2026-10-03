package client.onyx.util.math;

import client.onyx.util.Util12;
import client.onyx.util.Util6;
import java.util.function.DoubleConsumer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.util.EnumFacing.Axis;

public interface Iface {
   double DOUBLE = 1.0E-9;

   static void handleVec3(Vec3 var0) {
      if (Util6.isVec33(var0)) {
         throw new IllegalArgumentException(new StringBuilder().insert(0, "Direction should be not zero, actual: ").append(var0).toString());
      }
   }

   default PointDistanceSquaredRecord getPointDistanceSquaredRecord(AxisAlignedBB var1) {
      Vec3 var17 = this.getVec35();
      Vec3 var16 = this.getVec3();
      double var4 = var17.xCoord;
      double var6 = var17.yCoord;
      double var8 = var17.zCoord;
      double var10 = var16.xCoord;
      double var12 = var16.yCoord;
      double var14 = var16.zCoord;
      Cls var22 = new Cls(6);
      if (!isDouble(var10, 0.0)) {
         var22.handleDouble2((var1.minX - var4) / var10);
         var22.handleDouble2((var1.maxX - var4) / var10);
      }

      if (!isDouble(var12, 0.0)) {
         var22.handleDouble2((var1.minY - var6) / var12);
         var22.handleDouble2((var1.maxY - var6) / var12);
      }

      if (!isDouble(var14, 0.0)) {
         var22.handleDouble2((var1.minZ - var8) / var14);
         var22.handleDouble2((var1.maxZ - var8) / var14);
      }

      var22.run();
      UnboundedForwardEnum var2 = this.getUnboundedForwardEnum();
      double[] var10000 = new double[2];
      boolean var10002 = true;
      var10000[0] = Double.NaN;
      var10000[1] = Double.POSITIVE_INFINITY;
      double[] var18 = var10000;
      final double ox = var4, dx = var10, oy = var6, dy = var12, oz = var8, dz = var14;
      DoubleConsumer var29 = var15 -> {
         double t = var2.getDouble(var15);
         if (!Double.isNaN(t)) {
            double px = ox + dx * t;
            double py = oy + dy * t;
            double pz = oz + dz * t;
            double dist = Util12.getDoubleForAxisAlignedBB(var1, px, py, pz);
            if (Double.isNaN(var18[0]) || dist < var18[1] - 1.0E-9) {
               var18[0] = t;
               var18[1] = dist;
            }
         }
      };
      double[] var9;
      int var23 = (var9 = var2.getDoubleArray()).length;

      int var19;
      for (int var34 = var19 = 0; var34 < var23; var34 = var19) {
         double var10001 = var9[var19];
         var19++;
         var29.accept(var10001);
      }

      int var30;
      for (int var35 = var30 = 0; var35 < var22.getInt(); var35 = var30) {
         var29.accept(var22.getDouble(var30++));
      }

      Cls var31 = new Cls(8);

      int var24;
      for (int var36 = var24 = 0; var36 < var22.getInt(); var36 = var24) {
         handleCls(var31, var2, var22.getDouble(var24++));
      }

      double[] var25;
      var19 = (var25 = var2.getDoubleArray()).length;

      int var27;
      for (int var37 = var27 = 0; var37 < var19; var37 = var27) {
         double var20 = var25[var27];
         var27++;
         handleCls(var31, var2, var20);
      }

      var31.run();
      var4 = var2.getDouble2();

      int var28;
      for (int var38 = var28 = 0; var38 < var31.getInt(); var38 = var28) {
         double var33 = var31.getDouble(var28);
         var28++;
         handleAxisAlignedBB(var1, var2, var4, var33, var17, var16, var29);
         var4 = var33;
      }

      handleAxisAlignedBB(var1, var2, var4, var2.getDouble4(), var17, var16, var29);
      if (Double.isNaN(var18[0])) {
         var29.accept(0.0);
      }

      if (Double.isNaN(var18[0])) {
         throw new IllegalStateException(new StringBuilder().insert(0, "Unable to find nearest point on geometry ").append(this).toString());
      } else {
         return new PointDistanceSquaredRecord(this.getVec36(var18[0]), var18[1]);
      }
   }

   private double getDouble3(double[] var1) {
      UnboundedForwardEnum var9 = this.getUnboundedForwardEnum();
      double var3 = var1[0];
      double var5 = var1[1];
      double var7 = Math.max(var3, var9.getDouble2());
      boolean var10 = Double.isFinite(var9.getDouble2()) && var9.getDouble2() > var3 + 1.0E-9 && var9.getDouble2() < var5 - 1.0E-9;
      return var10 ? var9.getDouble(var5) : var9.getDouble(var7);
   }

   Vec3 getVec35();

   default Vec3 getVec36(double var1) {
      return Util6.getVec3ForVec35(this.getVec35(), var1, this.getVec3());
   }

   UnboundedForwardEnum getUnboundedForwardEnum();

   private static void handleCls(Cls var0, UnboundedForwardEnum var1, double var2) {
      if (!(var2 < var1.getDouble2() - 1.0E-9) && !(var2 > var1.getDouble4() + 1.0E-9)) {
         var0.handleDouble(var2);
      }
   }

   default Vec3 getVec33(AxisAlignedBB var1) {
      double[] var4;
      if ((var4 = this.getDoubleArray(var1)) == null) {
         return null;
      } else {
         double var2;
         return Double.isNaN(var2 = this.getDouble3(var4)) ? null : this.getVec32(var2);
      }
   }

   private double[] getDoubleArray(AxisAlignedBB var1) {
      Vec3 var11 = this.getVec35();
      Vec3 var8 = this.getVec3();
      double var4 = Double.NEGATIVE_INFINITY;
      double var6 = Double.POSITIVE_INFINITY;
      Axis[] var20;
      int var9 = (var20 = Axis.values()).length;

      int var10;
      for (int var10000 = var10 = 0; var10000 < var9; var10000 = ++var10) {
         Axis var2 = var20[var10];
         double var12 = var11.get(var2);
         double var14 = var8.get(var2);
         double var16 = var1.min(var2);
         double var18 = var1.max(var2);
         if (isDouble(var14, 0.0)) {
            if (var12 < var16 || var12 > var18) {
               return null;
            }
         } else {
            var16 = (var16 - var12) / var14;
            var12 = (var18 - var12) / var14;
            var4 = Math.max(var4, Math.min(var16, var12));
            var6 = Math.min(var6, Math.max(var16, var12));
            if (var4 > var6 + 1.0E-9) {
               return null;
            }
         }
      }

      UnboundedForwardEnum var23 = this.getUnboundedForwardEnum();
      if (!(var6 < var23.getDouble2() - 1.0E-9) && !(var4 > var23.getDouble4() + 1.0E-9)) {
         double[] var24 = new double[2];
         boolean var10002 = true;
         var24[0] = var4;
         var24[1] = var6;
         return var24;
      } else {
         return null;
      }
   }

   default double getDouble4(Vec3 var1) {
      return this.getVec34(var1).distanceToSqr(var1);
   }

   default Vec3 getVec34(Vec3 var1) {
      double var2;
      if (Double.isNaN(var2 = this.getUnboundedForwardEnum().getDouble5(this.getDouble2(var1)))) {
         throw new IllegalStateException(new StringBuilder().insert(0, "Unable to project point ").append(var1).append(" on geometry ").append(this).toString());
      } else {
         return this.getVec36(var2);
      }
   }

   private static void handleDoubleArray(
      double[] var0,
      UnboundedForwardEnum var1,
      UnboundedForwardEnum var2,
      Vec3 var3,
      Vec3 var4,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13
   ) {
      var11 = var1.getDouble(var11);
      var13 = var2.getDouble(var13);
      if (!Double.isNaN(var11) && !Double.isNaN(var13)) {
         var5 = var5 + var3.xCoord * var11 - var4.xCoord * var13;
         var7 = var7 + var3.yCoord * var11 - var4.yCoord * var13;
         var9 = var9 + var3.zCoord * var11 - var4.zCoord * var13;
         var5 = var5 * var5 + var7 * var7 + var9 * var9;
         if (Double.isNaN(var0[0]) || var5 < var0[2] - 1.0E-9) {
            var0[0] = var11;
            var0[1] = var13;
            var0[2] = var5;
         }
      }
   }

   Vec3 getVec3();

   default Vec3 getVec32(double var1) {
      double var3;
      return Double.isNaN(var3 = this.getUnboundedForwardEnum().getDouble(var1)) ? null : this.getVec36(var3);
   }

   private static boolean isDouble2(double var0, double var2, double var4) {
      if (!Double.isFinite(var0)) {
         return false;
      } else {
         boolean var6 = !Double.isFinite(var2) || var0 > var2 + 1.0E-9;
         boolean var7 = !Double.isFinite(var4) || var0 < var4 - 1.0E-9;
         return var6 && var7;
      }
   }

   default double getDouble(double var1, double var3, double var5) {
      Vec3 var9 = this.getVec35();
      Vec3 var8;
      return Util6.getDoubleForVec33(var8 = this.getVec3(), var1 - var9.xCoord, var3 - var9.yCoord, var5 - var9.zCoord) / var8.lengthSqr();
   }

   default boolean isAxisAlignedBB(AxisAlignedBB var1) {
      return this.getDoubleArray(var1) != null;
   }

   private static double getDoubleForDouble(double var0, double var2) {
      if (Double.isFinite(var0) && Double.isFinite(var2)) {
         return var0 < var2 - 1.0E-9 ? (var0 + var2) * 0.5 : Double.NaN;
      } else if (Double.isFinite(var0)) {
         return var0 + 1.0;
      } else {
         return Double.isFinite(var2) ? var2 - 1.0 : 0.0;
      }
   }

   default FirstSecondRecord getFirstSecondRecord(Iface var1) {
      Vec3 var5 = this.getVec3();
      Vec3 var4 = var1.getVec3();
      UnboundedForwardEnum var28 = this.getUnboundedForwardEnum();
      UnboundedForwardEnum var2 = var1.getUnboundedForwardEnum();
      double var6 = this.getVec35().xCoord - var1.getVec35().xCoord;
      double var8 = this.getVec35().yCoord - var1.getVec35().yCoord;
      double var10 = this.getVec35().zCoord - var1.getVec35().zCoord;
      double var12 = var5.dotProduct(var5);
      double var14 = var5.dotProduct(var4);
      double var16 = var4.dotProduct(var4);
      double var18 = Util6.getDoubleForVec33(var5, var6, var8, var10);
      double var20 = Util6.getDoubleForVec33(var4, var6, var8, var10);
      double var22 = var12 * var16 - var14 * var14;
      double[] var10000 = new double[3];
      boolean var10002 = true;
      var10000[0] = Double.NaN;
      var10000[1] = Double.NaN;
      var10000[2] = Double.POSITIVE_INFINITY;
      double[] var24 = var10000;
      if (Math.abs(var22) > 1.0E-9) {
         handleDoubleArray(var24, var28, var2, var5, var4, var6, var8, var10, (var14 * var20 - var16 * var18) / var22, (var12 * var20 - var14 * var18) / var22);
      }

      double[] var25;
      int var26 = (var25 = var28.getDoubleArray()).length;

      int var27;
      for (int var34 = var27 = 0; var34 < var26; var34 = var27) {
         var22 = var25[var27];
         double var10010 = var14 * var22 + var20;
         var27++;
         handleDoubleArray(var24, var28, var2, var5, var4, var6, var8, var10, var22, var2.getDouble5(var10010 / var16));
      }

      var26 = (var25 = var2.getDoubleArray()).length;

      for (int var35 = var27 = 0; var35 < var26; var35 = var27) {
         var22 = var25[var27];
         double var10009 = (var14 * var22 - var18) / var12;
         var27++;
         handleDoubleArray(var24, var28, var2, var5, var4, var6, var8, var10, var28.getDouble5(var10009), var22);
      }

      handleDoubleArray(var24, var28, var2, var5, var4, var6, var8, var10, var28.getDouble5(-var18 / var12), 0.0);
      handleDoubleArray(var24, var28, var2, var5, var4, var6, var8, var10, 0.0, var2.getDouble5(var20 / var16));
      return Double.isNaN(var24[0]) ? null : new FirstSecondRecord(this.getVec36(var24[0]), var1.getVec36(var24[1]));
   }

   static boolean isDouble(double var0, double var2) {
      return Math.abs(var2 - var0) < 1.0E-5;
   }

   default double getDouble2(Vec3 var1) {
      return this.getDouble(var1.xCoord, var1.yCoord, var1.zCoord);
   }

   private static void handleAxisAlignedBB(AxisAlignedBB var0, UnboundedForwardEnum var1, double var2, double var4, Vec3 var6, Vec3 var7, DoubleConsumer var8) {
      AxisAlignedBB var18 = var0;
      var2 = Math.max(var2, var1.getDouble2());
      var4 = Math.min(var4, var1.getDouble4());
      double var9;
      if (!Double.isNaN(var9 = getDoubleForDouble(var2, var4))) {
         Vec3 var26 = Util6.getVec3ForVec35(var6, var9, var7);
         double var11 = 0.0;
         double var13 = 0.0;
         Axis[] var15;
         int var16 = (var15 = Axis.values()).length;

         int var17;
         for (int var10000 = var17 = 0; var10000 < var16; var10000 = ++var17) {
            Axis var25 = var15[var17];
            double var19 = var26.get(var25);
            double var21 = var7.get(var25);
            double var23 = var6.get(var25);
            if (var19 < var18.min(var25)) {
               var11 += var21 * var21;
               var13 += var21 * (var23 - var18.min(var25));
            } else if (var19 > var18.max(var25)) {
               var11 += var21 * var21;
               var13 += var21 * (var23 - var18.max(var25));
            }
         }

         if (Math.abs(var11) <= 1.0E-9) {
            var8.accept(var9);
         } else {
            double var29;
            if (isDouble2(var29 = -var13 / var11, var2, var4)) {
               var8.accept(var29);
            }
         }
      }
   }
}
