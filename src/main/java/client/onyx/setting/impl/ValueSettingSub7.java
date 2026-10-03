package client.onyx.setting.impl;

import client.onyx.setting.ValueSetting;
import client.onyx.util.Cls6;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.item.ItemStack;

public class ValueSettingSub7 extends ValueSetting<Map<Integer, List<Cls6>>> {
   public static final int INT = 9;

   public void run9() {
      LinkedHashMap var1 = new LinkedHashMap();
      this.handleObject2(var1);
   }

   public ValueSettingSub7 getBooleanSetting(String var1) {
      super.getBooleanSetting(var1);
      return this;
   }

   public void handleInt4(int var1, Cls6 var2) {
      if (var2 != null && this.getList7(var1).contains(var2)) {
         List var4;
         Map var5;
         if ((var4 = (List)(var5 = this.getMap()).get(var1)) != null) {
            var4.remove(var2);
            if (var4.isEmpty()) {
               var5.remove(var1);
            }

            this.handleObject2(var5);
         }
      }
   }

   public void handleInt(int var1) {
      if (!this.getList7(var1).isEmpty()) {
         Map var3;
         (var3 = this.getMap()).remove(var1);
         this.handleObject2(var3);
      }
   }

   public int getInt9(ItemStack var1) {
      int var2 = -1;

      int var6;
      for(int var10000 = var6 = 0; var10000 < 9; var10000 = var6) {
         Iterator var4 = this.getList7(var6).iterator();

         label31:
         while(true) {
            for(Iterator var7 = var4; var7.hasNext(); var7 = var4) {
               Cls6 var5;
               if ((var5 = (Cls6)var4.next()).isItemStack(var1)) {
                  if (var5.isEnabled()) {
                     return var6;
                  }

                  if (var2 < 0) {
                     var2 = var6;
                  }
                  continue label31;
               }
            }

            ++var6;
            break;
         }
      }

      return var2;
   }

   public boolean isInt(int var1, ItemStack var2) {
      Iterator var3 = this.getList7(var1).iterator();

      do {
         if (!var3.hasNext()) {
            return false;
         }
      } while(!((Cls6)var3.next()).isItemStack(var2));

      return true;
   }

   private Map<Integer, List<Cls6>> getMap() {
      LinkedHashMap var1 = new LinkedHashMap();

      Iterator var2;
      for(Iterator var10000 = var2 = ((Map)this.lambda15()).entrySet().iterator(); var10000.hasNext(); var10000 = var2) {
         Entry var4 = (Entry)var2.next();
         var1.put((Integer)var4.getKey(), new ArrayList((Collection)var4.getValue()));
      }

      return var1;
   }

   public ValueSettingSub7 getModeSetting3(Consumer<Map<Integer, List<Cls6>>> var1) {
      super.getModeSetting3(var1);
      return this;
   }

   protected Map<Integer, List<Cls6>> getObject2(Map<Integer, List<Cls6>> var1) {
      LinkedHashMap var5 = new LinkedHashMap();
      if (var1 == null) {
         return var5;
      } else {
         int var4;
         for(int var10000 = var4 = 0; var10000 < 9; var10000 = var4) {
            List var7;
            if ((var7 = (List)var1.get(var4)) != null) {
               ArrayList var2 = new ArrayList();
               Iterator var8 = var7.iterator();

               while(var8.hasNext()) {
                  Cls6 var6;
                  if ((var6 = (Cls6)var8.next()) != null && !var2.contains(var6)) {
                     var2.add(var6);
                  }
               }

               if (!var2.isEmpty()) {
                  var5.put(var4, var2);
               }
            }

            ++var4;
         }

         return var5;
      }
   }

   public List<Cls6> getList7(int var1) {
      List var2;
      return (var2 = (List)((Map)this.lambda15()).get(var1)) == null ? List.of() : var2;
   }

   public void handleInt3(int var1, Cls6 var2) {
      if (var2 != null && var1 >= 0 && var1 < 9) {
         if (!this.getList7(var1).contains(var2)) {
            Map var3;
            ((List)(var3 = this.getMap()).computeIfAbsent(var1, (var0) -> {
               return new ArrayList();
            })).add(var2);
            this.handleObject2(var3);
         }
      }
   }

   public void handleJsonElement(JsonElement var1) {
      if (var1.isJsonObject()) {
         LinkedHashMap var6 = new LinkedHashMap();
         Iterator var9 = var1.getAsJsonObject().entrySet().iterator();

         label65:
         while(true) {
            Iterator var10000 = var9;

            while(var10000.hasNext()) {
               Entry var7 = (Entry)var9.next();

               int var4;
               try {
                  var4 = Integer.parseInt((String)var7.getKey());
               } catch (NumberFormatException var8) {
                  var10000 = var9;
                  continue;
               }

               if (var4 < 0 || var4 >= 9) {
                  continue label65;
               }

               if (((JsonElement)var7.getValue()).isJsonArray()) {
                  ArrayList var5 = new ArrayList();
                  Iterator var11 = ((JsonElement)var7.getValue()).getAsJsonArray().iterator();

                  while(true) {
                     label52:
                     while(true) {
                        for(var10000 = var11; var10000.hasNext(); var10000 = var11) {
                           JsonElement var2;
                           if (!(var2 = (JsonElement)var11.next()).isJsonPrimitive()) {
                              continue label52;
                           }

                           if (var2.getAsJsonPrimitive().isString()) {
                              Cls6 var10;
                              if ((var10 = Cls6.getCls6ForString2(var2.getAsString())) != null && !var5.contains(var10)) {
                                 var5.add(var10);
                              }
                              continue label52;
                           }
                        }

                        if (!var5.isEmpty()) {
                           var6.put(var4, var5);
                        }
                        continue label65;
                     }
                  }
               }

               var10000 = var9;
            }

            this.handleObject2(var6);
            return;
         }
      }
   }

   public boolean isEnabled15() {
      return ((Map)this.lambda15()).isEmpty();
   }

   public static Map<Integer, List<Cls6>> getMapForObjectArray(Object... var0) {
      LinkedHashMap var1 = new LinkedHashMap();

      int var2;
      for(int var10000 = var2 = 0; var10000 + 1 < var0.length; var10000 = var2) {
         int var5 = (Integer)var0[var2];
         Cls6 var4;
         if ((var4 = Cls6.getCls6ForString2(String.valueOf(var0[var2 + 1]))) != null && var5 >= 0 && var5 < 9) {
            ((List)var1.computeIfAbsent(var5, (var0x) -> {
               return new ArrayList();
            })).add(var4);
         }

         var2 += 2;
      }

      return var1;
   }

   public ValueSettingSub7 getModeSetting(ValueSetting<Boolean> var1) {
      super.getModeSetting(var1);
      return this;
   }

   public <O> ValueSettingSub7 getModeSetting2(ValueSetting<O> var1, Predicate<O> var2) {
      super.getModeSetting2(var1, var2);
      return this;
   }

   public ValueSettingSub7 getSetting2(BooleanSupplier var1) {
      super.getSetting2(var1);
      return this;
   }

   public ValueSettingSub7(String var1, Map<Integer, List<Cls6>> var2) {
      super(var1, var2);
   }

   public JsonElement getJsonElement() {
      JsonObject var1 = new JsonObject();

      int var2;
      for(int var10000 = var2 = 0; var10000 < 9; var10000 = var2) {
         List var6;
         if (!(var6 = this.getList7(var2)).isEmpty()) {
            JsonArray var4 = new JsonArray();
            Iterator var8;
            Iterator var7 = var8 = var6.iterator();

            while(var7.hasNext()) {
               Cls6 var5 = (Cls6)var8.next();
               var7 = var8;
               var4.add(new JsonPrimitive(var5.getString2()));
            }

            var1.add(String.valueOf(var2), var4);
         }

         ++var2;
      }

      return var1;
   }

   public void handleInt2(int var1, int var2, Cls6 var3) {
      if (var3 != null && var1 != var2 && var2 >= 0 && var2 < 9) {
         if (this.getList7(var1).contains(var3)) {
            Map var4;
            List var5;
            if ((var5 = (List)(var4 = this.getMap()).get(var1)) != null) {
               var5.remove(var3);
               if (var5.isEmpty()) {
                  var4.remove(var1);
               }
            }

            List var6;
            if (!(var6 = (List)var4.computeIfAbsent(var2, (var0) -> {
               return new ArrayList();
            })).contains(var3)) {
               var6.add(var3);
            }

            this.handleObject2(var4);
         }
      }
   }
}
