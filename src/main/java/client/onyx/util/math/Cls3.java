package client.onyx.util.math;

import client.onyx.util.Util6;
import net.minecraft.util.Vec3;

public class Cls3 {
   private final Vec3 vec3;
   private final Vec3 vec32;

   public Vec3 getVec32(Iface var1) {
      Double var3;
      return (var3 = this.getDouble(var1)) == null ? null : var1.getVec32(var3);
   }

   public Double getDouble(Iface var1) {
      double var2 = this.vec3.dotProduct(this.vec32);
      double var4;
      return Iface.isDouble(var4 = var1.getVec3().dotProduct(this.vec32), 0.0) ? null : (var2 - var1.getVec35().dotProduct(this.vec32)) / var4;
   }

   public Vec3 getVec33() {
      return this.vec3;
   }

   public Cls3(Vec3 var1, Vec3 var2) {
      this.vec3 = var1;
      this.vec32 = Util6.getVec3ForVec32(var2);
   }

   public Vec3 getVec3() {
      return this.vec32;
   }

   public static Cls3 getCls3ForVec32(Vec3 var0, Vec3 var1, Vec3 var2) {
      if (Util6.isVec33(var1 = var1.crossProduct(var2).normalize())) {
         throw new IllegalArgumentException("Points must not be on the same line");
      } else {
         return new Cls3(var0, var1);
      }
   }

   public static Cls3 getCls3ForVec3(Vec3 var0, Vec3 var1, Vec3 var2) {
      Vec3 var3 = var1.subtract(var0);
      Vec3 var4 = var2.subtract(var0);
      return getCls3ForVec32(var0, var3, var4);
   }

   public PositionDirectionRecord getPositionDirectionRecord(Cls3 var1) {
      Vec3 var2 = var1.vec32;
      Vec3 var4 = this.vec32;
      double var5;
      Vec3 var11;
      if (Iface.isDouble(var5 = (var11 = var2.crossProduct(var4)).lengthSqr(), 0.0)) {
         return null;
      } else {
         double var7 = var2.dotProduct(var1.vec3);
         double var9 = var4.dotProduct(this.vec3);
         Vec3 var12 = var4.crossProduct(var11).scale(var7).add(var11.crossProduct(var2).scale(var9)).scale(1.0 / var5);
         return new PositionDirectionRecord(var12, var11);
      }
   }
}
