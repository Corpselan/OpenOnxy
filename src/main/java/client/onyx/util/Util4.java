package client.onyx.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class Util4 {
   static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();
   private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool(new ThreadFactory() {
      @Override
      public Thread newThread(Runnable var1) {
         Thread var10000 = new Thread(var1, "onyx-worker-" + Util4.ATOMIC_INTEGER.incrementAndGet());
         var10000.setDaemon(true);
         return var10000;
      }
   });

   private Util4() {
   }

   public static Executor getExecutor() {
      return EXECUTOR_SERVICE;
   }

   public static void handleRunnable(Runnable var0) {
      EXECUTOR_SERVICE.execute(var0);
   }
}
