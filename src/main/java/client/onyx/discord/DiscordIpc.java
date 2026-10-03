package client.onyx.discord;

import client.onyx.OnyxClient;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Locale;

public final class DiscordIpc {
   private SocketChannel socketChannel;
   private RandomAccessFile randomAccessFile;
   public static final int INT = 2;
   public static final int INT2 = 1;
   public static final int INT3 = 0;
   private volatile boolean bool;
   private static final boolean BOOL = System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win");

   private boolean isInt(int var1) {
      try {
         if (BOOL) {
            String var7 = new StringBuilder().insert(0, "\\\\.\\pipe\\discord-ipc-").append(var1).toString();
            RandomAccessFile var8 = new RandomAccessFile(var7, "rw");
            this.randomAccessFile = var8;
         } else {
            String[] var10000 = new String[3];
            boolean var10002 = true;
            var10000[0] = System.getenv("XDG_RUNTIME_DIR");
            var10000[1] = System.getenv("TMPDIR");
            var10000[2] = "/tmp";
            String var3 = getStringForStringArray(var10000);
            this.socketChannel = SocketChannel.open(StandardProtocolFamily.UNIX);
            SocketChannel var10 = this.socketChannel;
            String[] var11 = new String[1];
            boolean var10004 = true;
            var11[0] = new StringBuilder().insert(0, "discord-ipc-").append(var1).toString();
            var10.connect(UnixDomainSocketAddress.of(Path.of(var3, var11)));
         }

         return true;
      } catch (Exception var9) {
         this.run2();
         return false;
      }
   }

   public boolean isEnabled() {
      return this.bool;
   }

   private void run2() {
      this.bool = false;

      try {
         if (this.randomAccessFile != null) {
            this.randomAccessFile.close();
         }
      } catch (IOException var4) {
         OnyxClient.LOGGER.debug("Failed to close Discord IPC pipe", var4);
      }

      try {
         if (this.socketChannel != null) {
            this.socketChannel.close();
         }
      } catch (IOException var3) {
         OnyxClient.LOGGER.debug("Failed to close Discord IPC socket", var3);
      }

      this.randomAccessFile = null;
      this.socketChannel = null;
   }

   public void run() {
      boolean var2 = this.bool;
      this.bool = false;

      try {
         if (var2) {
            this.handleInt(2, "{}");
         }
      } catch (IOException var3) {
      }

      this.run2();
   }

   private static String getStringForStringArray(String... var0) {
      String[] var1 = var0;
      int var2 = var0.length;

      int var5;
      for (int var10000 = var5 = 0; var10000 < var2; var10000 = ++var5) {
         String var4;
         if ((var4 = var1[var5]) != null) {
            return var4;
         }
      }

      return "/tmp";
   }

   public boolean isString(String var1) {
      int var3;
      for (int var10000 = var3 = 0; var10000 < 10; var10000 = ++var3) {
         if (this.isInt(var3)) {
            try {
               boolean var10006 = false;
               this.handleInt(0, "{\"v\":1,\"client_id\":\"" + var1 + "\"}");
               this.bool = true;
               return true;
            } catch (IOException var4) {
               this.run2();
            }
         }
      }

      return false;
   }

   public void handleInt(int var1, String var2) throws IOException {
      byte[] var5 = var2.getBytes(StandardCharsets.UTF_8);
      ByteBuffer var4 = ByteBuffer.allocate(8 + var5.length).order(ByteOrder.LITTLE_ENDIAN);
      var4.putInt(var1);
      var4.putInt(var5.length);
      var4.put(var5);
      var4.flip();
      if (this.randomAccessFile != null) {
         this.randomAccessFile.write(var4.array());
      } else if (this.socketChannel == null) {
         throw new IOException("Discord IPC is not connected");
      } else {
         ByteBuffer var10000 = var4;

         while (var10000.hasRemaining()) {
            var10000 = var4;
            this.socketChannel.write(var4);
         }
      }
   }
}
