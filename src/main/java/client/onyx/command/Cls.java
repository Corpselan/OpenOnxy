package client.onyx.command;

import client.onyx.OnyxClient;
import client.onyx.command.impl.NoConfigsSavedYet;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.logging.log4j.Logger;

public class Cls {
   public NoConfigsSavedYet noConfigsSavedYet = new NoConfigsSavedYet();
   public static final String STRING = ".";
   private final ArrayList<Abstract_> arrayList = new ArrayList<>();

   public boolean isString(String var1) {
      if (var1 == null) {
         return false;
      } else if (!(var1 = var1.trim()).startsWith(".")) {
         return false;
      } else if ((var1 = var1.substring(".".length()).trim()).isEmpty()) {
         return false;
      } else {
         String[] var13;
         String var2 = (var13 = var1.split("\\s+"))[0];
         int var5 = var13.length;
         String[] var14 = Arrays.copyOfRange(var13, 1, var5);

         Iterator var3;
         for (Iterator var10000 = var3 = this.arrayList.iterator(); var10000.hasNext(); var10000 = var3) {
            Abstract_ var4;
            if ((var4 = (Abstract_)var3.next()).isString2(var2)) {
               try {
                  var4.handleStringArray(var14);
               } catch (Exception var10) {
                  Abstract_.handleString3(new StringBuilder().insert(0, "Command failed: ").append(var10).toString());
                  Logger var8 = OnyxClient.LOGGER;
                  Object[] var9 = new Object[]{var2, var10};
                  var8.error("Command '{}' failed", var9);
               }

               return true;
            }
         }

         Abstract_.handleString3(new StringBuilder().insert(0, "Unknown command: ").append(var2).toString());
         return true;
      }
   }

   public ArrayList<Abstract_> getArrayList() {
      return this.arrayList;
   }

   public Cls() {
      Field[] var4;
      int var2 = (var4 = this.getClass().getDeclaredFields()).length;

      int var3;
      for (int var10000 = var3 = 0; var10000 < var2; var10000 = ++var3) {
         Field var5 = var4[var3];
         if (Abstract_.class.isAssignableFrom(var5.getType())) {
            try {
               this.arrayList.add((Abstract_)var5.get(this));
            } catch (IllegalAccessException var6) {
               var6.printStackTrace();
            }
         }
      }
   }
}
