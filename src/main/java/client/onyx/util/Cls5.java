package client.onyx.util;

import java.util.function.BooleanSupplier;

public class Cls5 {
   private final Runnable runnable;
   private boolean bool;
   private final BooleanSupplier booleanSupplier;

   public Cls5(BooleanSupplier var1, Runnable var2) {
      this.booleanSupplier = var1;
      this.runnable = var2;
   }

   public void run() {
      if (!this.bool && this.booleanSupplier.getAsBoolean()) {
         this.runnable.run();
         this.bool = true;
      }
   }
}
