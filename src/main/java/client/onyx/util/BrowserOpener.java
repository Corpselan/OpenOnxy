package client.onyx.util;

import client.onyx.OnyxClient;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Path;
import org.apache.logging.log4j.Logger;

public final class BrowserOpener {
   public static void handlePath(Path var0) {
      try {
         Class var3;
         Class var10000 = var3 = Class.forName("java.awt.Desktop");
         Class[] var10002 = new Class[0];
         boolean var10004 = true;
         Method var10 = var10000.getMethod("getDesktop", var10002);
         Object[] var11 = new Object[0];
         var10004 = true;
         Object var2 = var10.invoke(null, var11);
         Class[] var4 = new Class[]{File.class};
         Method var5 = var3.getMethod("open", var4);
         Object[] var6 = new Object[1];
         File var7 = var0.toFile();
         var6[0] = var7;
         Object var8 = var5.invoke(var2, var6);
      } catch (Throwable var9) {
         handleURI(var0.toUri());
      }
   }

   public static void handleURI(URI var0) {
      try {
         Class var3;
         Class var10000 = var3 = Class.forName("java.awt.Desktop");
         Class[] var10002 = new Class[0];
         boolean var10004 = true;
         Method var11 = var10000.getMethod("getDesktop", var10002);
         Object[] var12 = new Object[0];
         var10004 = true;
         Object var2 = var11.invoke(null, var12);
         Class[] var4 = new Class[]{URI.class};
         Method var5 = var3.getMethod("browse", var4);
         Object[] var6 = new Object[]{var0};
         Object var7 = var5.invoke(var2, var6);
      } catch (Throwable var10) {
         Logger var8 = OnyxClient.LOGGER;
         Object[] var9 = new Object[]{var0, var10};
         var8.error("Could not open {}", var9);
      }
   }

   public static String decrypt(String var0) {
      int var10002 = 4 << 4 ^ 12;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var12 = var5 = var10003 - 1;
      char[] var1 = var10004;
      int var4 = var10002;
      int var13 = 84;
      int var10000 = var12;

      for (byte var2 = 95; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var13 = var5--;
         var1[var13] = (char)(var10.charAt(var13) ^ var4);
      }

      return new String(var1);
   }

   public static void handleString(String var0) {
      handleURI(URI.create(var0));
   }

   private BrowserOpener() {
   }
}
