package client.onyx.system;

import client.onyx.OnyxClient;
import java.awt.Frame;
import java.io.File;
import java.util.function.Consumer;

public final class FileDialog {
   private FileDialog() {
   }

   public static String decrypt(String var0) {
      int var10002 = (2 ^ 5) << 4 ^ 4;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var12 = var5 = var10003 - 1;
      char[] var1 = var10004;
      int var4 = var10002;
      int var13 = 5;
      int var10000 = var12;

      for (byte var2 = 122; var10000 >= 0; var10000 = var5) {
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

   public static void handleString(String var0, String var1, Consumer<String> var2) {
      final var var1_c = var1;
      Thread var10000 = new Thread(() -> {
         var var1_l = var1_c;
         try {
            java.awt.FileDialog var5 = new java.awt.FileDialog((Frame)null, var0, 0);
            var5.setFile("*.png");
            File var4;
            if (!var1_l.isEmpty() && (var4 = new File(var1_l)).getParentFile() != null) {
               var5.setDirectory(var4.getParent());
            }

            var5.setVisible(true);
            String var10 = var5.getDirectory();
            var1_l = var5.getFile();
            if (var10 != null && var1_l != null) {
               String var7 = new File(var10, var1_l).getAbsolutePath();
               var2.accept(var7);
               return;
            }
         } catch (Throwable var8) {
            OnyxClient.LOGGER.warn("File dialog failed - type the path in by hand instead", var8);
         }
      }, "onyx-file-dialog");
      var10000.setDaemon(true);
      var10000.start();
   }
}
