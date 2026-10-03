package client.onyx.util;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import net.minecraft.client.Minecraft;

public class Cls<T> {
   private int int_;
   private final PriorityBlockingQueue<Cls.Cls8<T>> priorityBlockingQueue = new PriorityBlockingQueue<>(11, Comparator.comparingInt(var0 -> -var0.getInt2()));

   public T getObject() {
      Cls.Cls8 var3;
      if ((var3 = this.priorityBlockingQueue.peek()) == null) {
         return null;
      } else {
         Minecraft var2;
         if ((var2 = Minecraft.getMinecraft()) == null || var2.isCallingFromMinecraftThread()) {
            while (var3.int_ <= this.int_ || !var3.getIface().isEnabled136()) {
               this.priorityBlockingQueue.remove();
               if ((var3 = this.priorityBlockingQueue.peek()) == null) {
                  return null;
               }
            }
         }

         return (T)var3.getObject();
      }
   }

   public void run() {
      this.handleInt(1);
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 120;
      byte var12 = 34;
      int var10000 = var10002;

      for (byte var2 = 61; var10000 >= 0; var10000 = var5) {
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

   public void handleCls8(Cls.Cls8<T> var1) {
      this.priorityBlockingQueue.removeIf(var1x -> var1x.getIface() == var1.getIface());
      var1.int_ = var1.int_ + this.int_;
      this.priorityBlockingQueue.add(var1);
   }

   public void handleInt(int var1) {
      int var3 = this.int_ + var1;
      this.int_ = var3;
   }

   public static class Cls8<T> {
      int int_;
      private final T object;
      private final Iface iface;
      private final int int_2;

      public T getObject() {
         return this.object;
      }

      public Cls8(int var1, int var2, Iface var3, T var4) {
         this.int_ = var1;
         this.int_2 = var2;
         this.iface = var3;
         this.object = (T)var4;
      }

      public int getInt2() {
         return this.int_2;
      }

      public int getInt() {
         return this.int_;
      }

      public Iface getIface() {
         return this.iface;
      }
   }
}
