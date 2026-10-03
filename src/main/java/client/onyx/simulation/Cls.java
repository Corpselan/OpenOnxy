package client.onyx.simulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cls {
   private final List<PosFallDistanceRecord> list = new ArrayList();
   private final Cls3 cls3;
   private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
   private int int_;

   public Cls3 getCls3() {
      return this.cls3;
   }

   public Cls(Cls3 var1) {
      this.cls3 = var1;
      this.list.add(new PosFallDistanceRecord(var1));
   }

   public Iterator<PosFallDistanceRecord> getIterator2(final int var1, final int var2) {
      if (var2 >= 1200) {
         throw new IllegalStateException("tried to simulate a player for more than a minute!");
      } else {
         this.handleInt(var2 + 1);
         return new Iterator<PosFallDistanceRecord>() {
            private int int_ = var1;

            public boolean hasNext() {
               return this.int_ <= var2;
            }

            public PosFallDistanceRecord next() {
               Cls var1x = Cls.this;
               int var2x = this.int_;
               int var3 = var2x + 1;
               this.int_ = var3;
               return var1x.getPosFallDistanceRecord(var2x);
            }
         };
      }
   }

   public void handleInt(int var1) {
      if (var1 < 0) {
         throw new IllegalStateException("ticks may not be negative");
      } else if (this.int_ < var1) {
         this.reentrantReadWriteLock.writeLock().lock();

         try {
            while(this.int_ < var1) {
               this.cls3.run17();
               this.list.add(new PosFallDistanceRecord(this.cls3));
               ++this.int_;
            }
         } catch (Throwable var3) {
            this.reentrantReadWriteLock.writeLock().unlock();
            throw var3;
         }

         this.reentrantReadWriteLock.writeLock().unlock();
      }
   }

   public PosFallDistanceRecord getPosFallDistanceRecord(int var1) {
      this.handleInt(var1);
      this.reentrantReadWriteLock.readLock().lock();

      PosFallDistanceRecord var4;
      try {
         var4 = (PosFallDistanceRecord)this.list.get(var1);
      } catch (Throwable var3) {
         this.reentrantReadWriteLock.readLock().unlock();
         throw var3;
      }

      this.reentrantReadWriteLock.readLock().unlock();
      return var4;
   }

   public List<PosFallDistanceRecord> getList(int var1, int var2) {
      if (var2 >= 1200) {
         throw new IllegalStateException("tried to simulate a player for more than a minute!");
      } else {
         this.handleInt(var2 + 1);
         this.reentrantReadWriteLock.readLock().lock();

         List var5;
         try {
            var5 = List.copyOf(this.list.subList(var1, var2 + 1));
         } catch (Throwable var4) {
            this.reentrantReadWriteLock.readLock().unlock();
            throw var4;
         }

         this.reentrantReadWriteLock.readLock().unlock();
         return var5;
      }
   }

   public Iterator<PosFallDistanceRecord> getIterator() {
      return new Iterator<PosFallDistanceRecord>() {
         private int int_;

         public PosFallDistanceRecord next() {
            Cls var1 = Cls.this;
            int var2 = this.int_;
            int var3 = var2 + 1;
            this.int_ = var3;
            return var1.getPosFallDistanceRecord(var2);
         }

         public boolean hasNext() {
            return true;
         }
      };
   }
}
