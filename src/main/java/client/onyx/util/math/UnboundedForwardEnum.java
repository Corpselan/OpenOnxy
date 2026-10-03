package client.onyx.util.math;

public enum UnboundedForwardEnum {
   // 顺序按原 $VALUES 数组（即 ordinal）
   UNBOUNDED(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY),
   FORWARD(0.0, Double.POSITIVE_INFINITY),
   SEGMENT_01(0.0, 1.0);

   private static final double[] DOUBLE_ARRAY = new double[0];
   private static final double[] DOUBLE_ARRAY2;
   private static final double[] DOUBLE_ARRAY3;
   private final double double_;
   private final double double_2;

   public double getDouble4() {
      return this.double_;
   }

   public double getDouble(double var1) {
      if (!Double.isFinite(var1)) {
         return Double.NaN;
      } else {
         return !(var1 < this.double_2 - 1.0E-9) && !(var1 > this.double_ + 1.0E-9) ? this.getDouble3(var1) : Double.NaN;
      }
   }

   public double[] getDoubleArray() {
      switch (this) {
         case UNBOUNDED:

            return DOUBLE_ARRAY;
         case FORWARD:
            return DOUBLE_ARRAY3;
         case SEGMENT_01:
            return DOUBLE_ARRAY2;
         default:
            throw new MatchException(null, null);
      }
   }

   private UnboundedForwardEnum(double var3, double var5) {
      this.double_2 = var3;
      this.double_ = var5;
   }

   public double getDouble5(double var1) {
      return !Double.isFinite(var1) ? Double.NaN : this.getDouble3(var1);
   }

   private double getDouble3(double var1) {
      if (var1 < this.double_2) {
         return this.double_2;
      } else {
         return var1 > this.double_ ? this.double_ : var1;
      }
   }

   static {
      UnboundedForwardEnum[] var0 = new UnboundedForwardEnum[]{UNBOUNDED, FORWARD, SEGMENT_01};
      double[] var10000 = new double[1];
      boolean var10002 = true;
      var10000[0] = 0.0;
      DOUBLE_ARRAY3 = var10000;
      var10000 = new double[2];
      var10002 = true;
      var10000[0] = 0.0;
      var10000[1] = 1.0;
      DOUBLE_ARRAY2 = var10000;
   }

   public double getDouble2() {
      return this.double_2;
   }
}
