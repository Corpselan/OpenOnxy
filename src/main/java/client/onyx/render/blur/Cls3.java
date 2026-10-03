package client.onyx.render.blur;

public final class Cls3<T> {
   private float float_;
   public static final float FLOAT = 250.0F;
   private T object;
   private T object2;

   public float getFloat() {
      return this.float_;
   }

   public T getObject2() {
      return this.object2;
   }

   public void handleObject(T var1, float var2) {
      var2 = Math.max(0.0F, var2) / 250.0F;
      if (var1 == this.object2) {
         this.object = null;
         this.float_ = this.object2 == null ? Math.max(0.0F, this.float_ - var2) : Math.min(1.0F, this.float_ + var2);
      } else {
         this.object = (T)var1;
         if (this.object2 != null && this.float_ > 0.0F) {
            this.float_ = Math.max(0.0F, this.float_ - var2);
            if (this.float_ > 0.0F) {
               return;
            }
         }

         this.object2 = this.object;
         this.object = null;
         this.float_ = 0.0F;
      }
   }

   public void run() {
      this.object = this.object2 = null;
      this.float_ = 0.0F;
   }

   public T getObject() {
      return this.object;
   }
}
