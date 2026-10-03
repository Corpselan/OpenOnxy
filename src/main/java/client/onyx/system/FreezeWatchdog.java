package client.onyx.system;

import client.onyx.OnyxClient;
import java.lang.Thread.State;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.logging.log4j.Logger;

public final class FreezeWatchdog {
   private static final long LONG = 250L;
   private static final String STRING = "Client thread";
   private static final long LONG2 = 10000000000L;
   private static final Map<String, int[]> MAP = new HashMap();
   private static volatile boolean bool;
   private static final long LONG3 = 15000000000L;
   private static final float FLOAT = 8.0F;
   private static volatile long long_ = System.nanoTime();
   private static final long LONG4 = 3000000000L;
   private static volatile long long_2;
   private static final long LONG5 = 5000000000L;
   private static final int INT = 40;
   private static final int INT2 = 12;

   private static void handleStackTraceElementArray(StackTraceElement[] var0) {
      if (var0.length != 0) {
         handleString(var0[0].toString());
         StackTraceElement[] var1 = var0;
         int var2 = var0.length;

         int var5;
         for(int var10000 = var5 = 0; var10000 < var2; var10000 = var5) {
            StackTraceElement var4;
            if ((var4 = var1[var5]).getClassName().startsWith("client.onyx.")) {
               handleString((new StringBuilder()).insert(0, "onyx: ").append(var4).toString());
               return;
            }

            ++var5;
         }

      }
   }

   private static Thread getThread() {
      Iterator var0 = Thread.getAllStackTraces().keySet().iterator();

      Thread var1;
      do {
         if (!var0.hasNext()) {
            return null;
         }

         var1 = (Thread)var0.next();
      } while(!"Client thread".equals(var1.getName()));

      return var1;
   }

   private static void handleString2(String var0, Thread var1) {
      MemoryMXBean var10000 = ManagementFactory.getMemoryMXBean();
      long var3 = var10000.getHeapMemoryUsage().getUsed() >> 20;
      long var5 = var10000.getHeapMemoryUsage().getMax() >> 20;
      StringBuilder var8 = new StringBuilder(2048);
      var8.append(var0).append(" — heap ").append(var3).append('/').append(var5).append(" MB");
      StringBuilder var12;
      if (var1 == null) {
         var12 = var8;
         var8.append("\n  the client thread is gone");
      } else {
         Map var11 = Thread.getAllStackTraces();
         StackTraceElement[] var10 = (StackTraceElement[])var11.get(var1);
         handleStringBuilder2(var8, var1, var10);
         if (var1.getState() == State.BLOCKED || var1.getState() == State.WAITING) {
            Iterator var7 = var11.entrySet().iterator();

            while(var7.hasNext()) {
               Entry var4;
               if ((var4 = (Entry)var7.next()).getKey() != var1) {
                  handleStringBuilder2(var8, (Thread)var4.getKey(), (StackTraceElement[])var4.getValue());
               }
            }
         }

         var12 = var8;
      }

      handleStringBuilder(var12);
      OnyxClient.LOGGER.error(var8.toString());
   }

   private static void handleStringBuilder(StringBuilder var0) {
      if (!MAP.isEmpty()) {
         ArrayList<Map.Entry<String, int[]>> var4;
         (var4 = new ArrayList<>(MAP.entrySet())).sort(Comparator.comparingInt((Map.Entry<String, int[]> var0x) -> {
            return var0x.getValue()[0];
         }).reversed());
         int var2 = 0;

         Iterator var5;
         for(Iterator var10000 = var5 = MAP.values().iterator(); var10000.hasNext(); var10000 = var5) {
            int[] var1 = (int[])var5.next();
            var2 += var1[0];
         }

         var0.append("\n  where the time went, ").append(var2).append(" samples:");
         int var7 = 0;

         for(int var8 = var7; var8 < Math.min(12, var4.size()); var8 = var7) {
            Entry var6 = (Entry)var4.get(var7);
            StringBuilder var9 = var0.append("\n      ").append(((int[])var6.getValue())[0]).append("x  ");
            ++var7;
            var9.append((String)var6.getKey());
         }

         MAP.clear();
      }
   }

   public static void run2() {
      if (!bool) {
         bool = true;
         Thread watchdog = new Thread(() -> {
            long var0 = 0L;
            long var2 = 0L;
            long var4 = System.nanoTime();
            long var6 = long_2;

            while(true) {
               while(true) {
                  try {
                     Thread.sleep(250L);
                  } catch (InterruptedException var16) {
                     Thread.currentThread().interrupt();
                     return;
                  }

                  Thread var8;
                  if ((var8 = getThread()) != null) {
                     handleStackTraceElementArray(var8.getStackTrace());
                  }

                  long var9;
                  long var11;
                  if ((var11 = (var9 = System.nanoTime()) - long_) >= 3000000000L) {
                     if (var0 == 0L || var9 - var0 >= 10000000000L) {
                        var0 = var9;
                        handleString2((new StringBuilder()).insert(0, "No frame for ").append(var11 / 1000000L).append(" ms").toString(), var8);
                     }

                     var4 = var9;
                     var6 = long_2;
                  } else {
                     var0 = 0L;
                     if (var9 - var4 >= 5000000000L) {
                        float var17 = (float)(long_2 - var6) * 1.0E9F / (float)(var9 - var4);
                        var4 = var9;
                        var6 = long_2;
                        if (!(var17 >= 8.0F) && var9 - var2 >= 15000000000L) {
                           var2 = var9;
                           Object[] var13 = new Object[1];
                           Float var14 = var17;
                           var13[0] = var14;
                           handleString2(String.format("Frames have fallen to %.1f fps", var13), var8);
                        }
                     }
                  }
               }
            }
         }, "onyx-freeze-watchdog");
         watchdog.setDaemon(true);
         watchdog.setPriority(1);
         watchdog.start();
         Logger var10000 = OnyxClient.LOGGER;
         Object[] var10002 = new Object[2];
         boolean var10004 = true;
         var10002[0] = 3L;
         var10002[1] = 8;
         var10000.warn("Freeze watchdog armed — a stall of {} s or a drop under {} fps will be reported here", var10002);
      }
   }

   private FreezeWatchdog() {
   }

   private static void handleString(String var0) {
      int[] var2 = (int[])MAP.computeIfAbsent(var0, (var0x) -> {
         return new int[1];
      });
      int var4 = var2[0] + 1;
      var2[0] = var4;
   }

   public static void run() {
      long_ = System.nanoTime();
      ++long_2;
   }

   private static void handleStringBuilder2(StringBuilder var0, Thread var1, StackTraceElement[] var2) {
      var0.append("\n  \"").append(var1.getName()).append("\" ").append(var1.getState());
      if (var2 != null) {
         int var4;
         for(int var10000 = var4 = 0; var10000 < Math.min(40, var2.length); var10000 = var4) {
            var0.append("\n      at ").append(var2[var4++]);
         }

      }
   }
}
