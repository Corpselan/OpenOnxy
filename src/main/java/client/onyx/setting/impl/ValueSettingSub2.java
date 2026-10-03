package client.onyx.setting.impl;

import client.onyx.setting.ValueSetting;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class ValueSettingSub2 extends ValueSetting<Set<Block>> {
   public static final Comparator<Block> COMPARATOR = Comparator.comparing(ValueSettingSub2::lambda14);

   @Override
   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonArray()) {
         TreeSet var2 = new TreeSet<>(COMPARATOR);
         Iterator var4 = var1.getAsJsonArray().iterator();

         label27:
         while (true) {
            Iterator var10000 = var4;

            while (var10000.hasNext()) {
               JsonElement var3;
               if (!(var3 = (JsonElement)var4.next()).isJsonPrimitive()) {
                  continue label27;
               }

               if (!var3.getAsJsonPrimitive().isString()) {
                  var10000 = var4;
               } else {
                  ResourceLocation var5 = new ResourceLocation(var3.getAsString());
                  if (!Block.blockRegistry.containsKey(var5)) {
                     var10000 = var4;
                  } else {
                     var2.add(Block.blockRegistry.getObject(var5));
                     var10000 = var4;
                  }
               }
            }

            this.handleObject2(var2);
            return;
         }
      }
   }

   public void handleBlock(Block var1) {
      if (this.isBlock2(var1)) {
         this.handleBlock3(var1);
      } else {
         this.handleBlock2(var1);
      }
   }

   @Override
   public JsonElement getJsonElement() {
      JsonArray var1 = new JsonArray();
      Iterator var4;
      Iterator var10000 = var4 = this.lambda15().iterator();

      while (var10000.hasNext()) {
         Block var3 = (Block)var4.next();
         var10000 = var4;
         var1.add(new JsonPrimitive(lambda14(var3)));
      }

      return var1;
   }

   public boolean isBlock2(Block var1) {
      return this.lambda15().contains(var1);
   }

   public ValueSettingSub2 getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public <O> ValueSettingSub2 getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   protected Set<Block> getObject2(Set<Block> var1) {
      return getSetForIterable(var1);
   }

   public static String lambda14(Block var0) {
      return String.valueOf(Block.blockRegistry.getNameForObject(var0));
   }

   public ValueSettingSub2 getModeSetting3(Consumer<Set<Block>> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   public ValueSettingSub2 getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public static Set<Block> getSetForIterable(Iterable<Block> var0) {
      TreeSet var1 = new TreeSet<>(COMPARATOR);
      Iterator var4 = var0.iterator();

      while (var4.hasNext()) {
         Block var3;
         if ((var3 = (Block)var4.next()) != null) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public void handleBlock3(Block var1) {
      TreeSet var3;
      (var3 = new TreeSet<>(COMPARATOR)).addAll(this.lambda15());
      var3.remove(var1);
      this.handleObject2(var3);
   }

   public ValueSettingSub2(String var1, Block... var2) {
      super(var1, getSetForIterable(List.of(var2)));
   }

   public ValueSettingSub2 getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public void handleBlock2(Block var1) {
      TreeSet var3;
      (var3 = new TreeSet<>(COMPARATOR)).addAll(this.lambda15());
      var3.add(var1);
      this.handleObject2(var3);
   }
}
