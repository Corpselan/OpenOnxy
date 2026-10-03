package client.onyx.setting;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Util {
   private static boolean bool;
   private static final int INT = 96;
   private static final Deque<Util.OwnerUndoRecord> DEQUE2 = new ArrayDeque<>();
   private static final long LONG = 450L;
   private static final Deque<Util.OwnerUndoRecord> DEQUE = new ArrayDeque<>();
   private static boolean bool2;

   public static void handleRunnable(Runnable var0) {
      boolean var3 = bool;
      bool = true;

      try {
         var0.run();
      } finally {
         bool = var3;
      }
   }

   private Util() {
   }

   public static boolean isEnabled2() {
      if (DEQUE2.isEmpty()) {
         return false;
      } else {
         Util.OwnerUndoRecord var0;
         handleRunnable((var0 = DEQUE2.pop()).undo()::run);
         DEQUE.push(var0);
         return true;
      }
   }

   public static void handleObject(Object var0, Util.Iface var1, Util.Iface var2) {
      if (bool2 && !bool) {
         long var3 = System.currentTimeMillis();
         Util.OwnerUndoRecord var6;
         if ((var6 = DEQUE2.peek()) != null && var0 != null && var6.owner() == var0 && var3 - var6.stamp() <= 450L) {
            DEQUE2.pop();
            DEQUE2.push(new Util.OwnerUndoRecord(var0, var6.undo(), var2, var3));
         } else {
            DEQUE2.push(new Util.OwnerUndoRecord(var0, var1, var2, var3));

            while (DEQUE2.size() > 96) {
               DEQUE2.removeLast();
            }
         }

         DEQUE.clear();
      }
   }

   public static boolean isEnabled() {
      if (DEQUE.isEmpty()) {
         return false;
      } else {
         Util.OwnerUndoRecord var0;
         handleRunnable((var0 = DEQUE.pop()).redo()::run);
         DEQUE2.push(var0);
         return true;
      }
   }

   public static void run() {
      DEQUE2.clear();
      DEQUE.clear();
   }

   public static void run3() {
      bool2 = false;
      run();
   }

   public static void run2() {
      bool2 = true;
   }

   public interface Iface {
      void run();
   }

   private record OwnerUndoRecord(Object owner, Util.Iface undo, Util.Iface redo, long stamp) {
   }
}
