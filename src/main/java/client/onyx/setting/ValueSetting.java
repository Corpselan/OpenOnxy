package client.onyx.setting;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class ValueSetting<T> extends Setting {
   private final T object;
   private T object2;
   private Consumer<T> consumer = var0 -> {};

   public ValueSetting<T> getModeSetting3(Consumer<T> var1) {
      this.consumer = var1;
      return this;
   }

   public void handleObject2(T var1) {
      if (!(var1 = this.getObject2(var1)).equals(this.object2)) {
         Object var2 = this.object2;
         this.object2 = (T)var1;
         T newValue = var1;
         Util.handleObject(this, () -> this.handleObject2((T)var2), () -> this.handleObject2(newValue));
         this.consumer.accept((T)var1);
      }
   }

   public T getObject() {
      return this.object;
   }

   public T lambda15() {
      return this.object2;
   }

   public ValueSetting<T> getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   protected ValueSetting(String var1, T var2) {
      super(var1);
      this.object = (T)var2;
      this.object2 = (T)var2;
   }

   public <O> ValueSetting<T> getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      return this.getSetting2(() -> var2.test(var1.lambda15()));
   }

   public ValueSetting<T> getModeSetting(ValueSetting<Boolean> var1) {
      Object var2 = Objects.requireNonNull(var1);
      return this.getSetting2(var1::lambda15);
   }

   public ValueSetting<T> getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public boolean isEnabled7() {
      return this.object2.equals(this.object);
   }

   protected T getObject2(T var1) {
      return (T)var1;
   }

   public void run5() {
      Object var1 = this.object;
      this.handleObject2((T)var1);
   }
}
