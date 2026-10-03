package client.onyx.util.math;

import client.onyx.util.Util12;
import client.onyx.util.Util6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;

public class Cls2 {
   private final Vec3 vec3;
   private final Vec3 vec32;

   public Cls2 getCls25(Vec3i var1) {
      return new Cls2(this.vec32.add(var1.getX(), var1.getY(), var1.getZ()), this.vec3.add(var1.getX(), var1.getY(), var1.getZ()));
   }

   private Vec3[] getVec3Array() {
      Vec3 var2;
      if (Iface.isDouble((var2 = this.getVec33()).xCoord, 0.0)) {
         Vec3[] var4 = new Vec3[2];
         boolean var6 = true;
         boolean var10005 = false;
         var4[0] = new Vec3(0.0, var2.yCoord, 0.0);
         var4[1] = new Vec3(0.0, 0.0, var2.zCoord);
         return var4;
      } else if (Iface.isDouble(var2.yCoord, 0.0)) {
         Vec3[] var3 = new Vec3[2];
         boolean var5 = true;
         var3[0] = new Vec3(var2.xCoord, 0.0, 0.0);
         var3[1] = new Vec3(0.0, 0.0, var2.zCoord);
         return var3;
      } else if (Iface.isDouble(var2.zCoord, 0.0)) {
         Vec3[] var10000 = new Vec3[2];
         boolean var10002 = true;
         var10000[0] = new Vec3(0.0, var2.yCoord, 0.0);
         var10000[1] = new Vec3(var2.xCoord, 0.0, 0.0);
         return var10000;
      } else {
         throw new IllegalStateException(
            new StringBuilder().insert(0, "Face must be axis aligned for this function to work. dimensions=").append(var2).toString()
         );
      }
   }

   public Cls2 getCls2() {
      return Iface.isDouble(this.getDouble(), 0.0) ? null : this;
   }

   public Cls2(Vec3 var1, Vec3 var2) {
      this.vec32 = new Vec3(Math.min(var1.xCoord, var2.xCoord), Math.min(var1.yCoord, var2.yCoord), Math.min(var1.zCoord, var2.zCoord));
      this.vec3 = new Vec3(Math.max(var1.xCoord, var2.xCoord), Math.max(var1.yCoord, var2.yCoord), Math.max(var1.zCoord, var2.zCoord));
   }

   public Vec3 getVec32() {
      ThreadLocalRandom var2 = ThreadLocalRandom.current();
      double var10002;
      Cls2 var10003;
      if (this.vec32.xCoord == this.vec3.xCoord) {
         var10002 = this.vec32.xCoord;
         var10003 = this;
      } else {
         var10002 = var2.nextDouble(this.vec32.xCoord, this.vec3.xCoord);
         var10003 = this;
      }

      double var3;
      Cls2 var10004;
      if (var10003.vec32.yCoord == this.vec3.yCoord) {
         var3 = this.vec32.yCoord;
         var10004 = this;
      } else {
         var3 = var2.nextDouble(this.vec32.yCoord, this.vec3.yCoord);
         var10004 = this;
      }

      Vec3 var10000 = new Vec3(
         var10002, var3, var10004.vec32.zCoord == this.vec3.zCoord ? this.vec32.zCoord : var2.nextDouble(this.vec32.zCoord, this.vec3.zCoord)
      );
      return var10000;
   }

   public Vec3 getVec36() {
      return this.vec3;
   }

   public Cls3 getCls3() {
      Vec3[] var2 = this.getVec3Array();
      return Cls3.getCls3ForVec32(this.vec32, var2[0], var2[1]);
   }

   public Cls2 getCls22(double var1) {
      return new Cls2(
         new Vec3(this.vec32.xCoord, Math.max(this.vec32.yCoord, var1), this.vec32.zCoord),
         new Vec3(this.vec3.xCoord, Math.max(this.vec3.yCoord, var1), this.vec3.zCoord)
      );
   }

   public Cls2 getCls24(Vec3 var1) {
      return new Cls2(this.vec32.add(var1), this.vec3.add(var1));
   }

   public Cls2 getCls23(AxisAlignedBB var1) {
      return new Cls2(Util12.getVec3ForAxisAlignedBB3(var1, this.vec32), Util12.getVec3ForAxisAlignedBB3(var1, this.vec3));
   }

   public Vec3 getVec3() {
      return this.vec32;
   }

   public Vec3 getVec34(Iface var1) {
      Vec3[] var13 = this.getVec3Array();
      Cls3 var16 = Cls3.getCls3ForVec32(this.vec32, var13[0], var13[1]);
      List var5 = this.getList();
      Vec3 var17 = var16.getVec32(var1);
      Vec3 var4 = this.getVec35();
      if (var17 != null) {
         boolean var3 = true;
         Iterator var6 = var5.iterator();

         while (true) {
            List var18;
            if (var6.hasNext()) {
               Vec3 var10000 = ((StartEndRecord)var6.next()).getVec36(0.5);
               Vec3 var9 = var10000.subtract(var4);
               if (!(var10000.subtract(var17).dotProduct(var9) <= 0.0)) {
                  continue;
               }

               var3 = false;
               var18 = var5;
            } else {
               var18 = var5;
            }

            if (var18.isEmpty() || var3) {
               return var17;
            }
            break;
         }
      }

      Vec3 var14 = null;
      double var15 = Double.POSITIVE_INFINITY;
      Iterator var8 = var5.iterator();

      label39:
      while (true) {
         for (Iterator var19 = var8; var19.hasNext(); var19 = var8) {
            FirstSecondRecord var10;
            if ((var10 = ((StartEndRecord)var8.next()).getFirstSecondRecord(var1)) != null) {
               double var11;
               if ((var11 = var10.first().distanceToSqr(var10.second())) < var15) {
                  var15 = var11;
                  var14 = var10.first();
               }
               continue label39;
            }
         }

         if (var14 != null) {
            return var14;
         }

         if (var17 != null) {
            return var17;
         }

         return var4;
      }
   }

   public Vec3 getVec35() {
      return this.vec32.lerp(this.vec3, 0.5);
   }

   private List<StartEndRecord> getList() {
      ArrayList var1 = new ArrayList(4);
      Vec3[] var3;
      if (!Util6.isVec33((var3 = this.getVec3Array())[0])) {
         var1.add(new StartEndRecord(this.vec32, this.vec32.add(var3[0])));
         var1.add(new StartEndRecord(this.vec3, this.vec3.subtract(var3[0])));
      }

      if (!Util6.isVec33(var3[1])) {
         var1.add(new StartEndRecord(this.vec32, this.vec32.add(var3[1])));
         var1.add(new StartEndRecord(this.vec3, this.vec3.subtract(var3[1])));
      }

      return var1;
   }

   public double getDouble() {
      Vec3 var2;
      return (var2 = this.getVec33()).xCoord * var2.yCoord + var2.yCoord * var2.zCoord + var2.xCoord * var2.zCoord;
   }

   public StartEndRecord getStartEndRecord(Iface var1) {
      ArrayList<PointDistanceSquaredRecord> var2 = new ArrayList<>(4);
      Iterator var6;
      Iterator var10000 = var6 = this.getList().iterator();

      while (var10000.hasNext()) {
         StartEndRecord var4 = (StartEndRecord)var6.next();
         FirstSecondRecord var5;
         if ((var5 = var1.getFirstSecondRecord(var4)) == null) {
            var10000 = var6;
         } else {
            var2.add(new PointDistanceSquaredRecord(var5.second(), var5.second().distanceToSqr(var5.first())));
            var10000 = var6;
         }
      }

      var2.sort((var0, var1x) -> Double.compare(var0.distanceSquared(), var1x.distanceSquared()));
      if (var2.size() < 2) {
         return null;
      } else {
         Vec3 var8 = ((PointDistanceSquaredRecord)var2.get(0)).point();
         Vec3 var7;
         return Util6.isVec33((var7 = ((PointDistanceSquaredRecord)var2.get(1)).point()).subtract(var8)) ? null : new StartEndRecord(var8, var7);
      }
   }

   public Vec3 getVec33() {
      return new Vec3(this.vec3.xCoord - this.vec32.xCoord, this.vec3.yCoord - this.vec32.yCoord, this.vec3.zCoord - this.vec32.zCoord);
   }
}
