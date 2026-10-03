package client.onyx.proxy;

import client.onyx.OnyxClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;

public final class HttpProxyHandler extends ChannelDuplexHandler {
   private final InetSocketAddress inetSocketAddress;
   private InetSocketAddress inetSocketAddress2;
   private final String string;
   private static final byte[] BYTE_ARRAY;
   private final String string2;
   private final String string3;
   private final int int_;
   private ByteBuf byteBuf;
   private ScheduledFuture<?> scheduledFuture;
   private ChannelPromise channelPromise;

   public void handlerRemoved(ChannelHandlerContext var1) {
      if (this.byteBuf != null) {
         this.byteBuf.release();
         this.byteBuf = null;
      }

      this.run();
   }

   private void run() {
      if (this.scheduledFuture != null) {
         this.scheduledFuture.cancel(false);
         this.scheduledFuture = null;
      }

   }

   public HttpProxyHandler(InetSocketAddress var1, String var2, int var3, String var4, String var5) {
      this.inetSocketAddress = var1;
      this.string2 = var2 == null ? "" : var2;
      this.int_ = var3;
      this.string = var4 == null ? "" : var4;
      this.string3 = var5 == null ? "" : var5;
   }

   static {
      byte[] var0 = new byte[]{13, 10, 13, 10};
      BYTE_ARRAY = var0;
   }

   public void channelRead(ChannelHandlerContext var1, Object var2) {
      if (var2 instanceof ByteBuf) {
         ByteBuf var3 = (ByteBuf)var2;
         HttpProxyHandler var10000 = this;

         try {
            if (var10000.byteBuf == null) {
               this.byteBuf = var1.alloc().buffer(var3.readableBytes());
            }

            this.byteBuf.writeBytes(var3);
         } catch (Throwable var11) {
            var3.release();
            throw var11;
         }

         var3.release();
         int var12;
         if ((var12 = getIntForByteBuf(this.byteBuf)) >= 0) {
            int var14;
            if ((var14 = getIntForString(this.byteBuf.toString(this.byteBuf.readerIndex(), var12 - this.byteBuf.readerIndex(), StandardCharsets.US_ASCII))) >= 200 && var14 < 300) {
               this.byteBuf.skipBytes(var12 - this.byteBuf.readerIndex() + BYTE_ARRAY.length);
               ByteBuf var13 = this.byteBuf.isReadable() ? this.byteBuf.readSlice(this.byteBuf.readableBytes()).retain() : null;
               this.run();
               Logger var15 = OnyxClient.LOGGER;
               Object[] var10002 = new Object[2];
               boolean var10004 = true;
               var10002[0] = this.string2;
               var10002[1] = this.int_;
               var15.info("HTTP proxy tunnel established to {}:{}", var10002);
               var1.fireChannelActive();
               this.channelPromise.trySuccess();
               if (var13 != null) {
                  var1.fireChannelRead(var13);
               }

               var1.pipeline().remove((ChannelHandler)this);
            } else {
               String var8 = (new StringBuilder()).insert(0, "HTTP proxy CONNECT failed (").append(var14).append(")").toString();
               IllegalStateException var9 = new IllegalStateException(var8);
               this.handleChannelHandlerContext2(var1, var9);
            }
         }
      } else {
         var1.fireChannelRead(var2);
      }
   }

   private void handleChannelHandlerContext2(ChannelHandlerContext var1, Throwable var2) {
      this.run();
      Logger var10000 = OnyxClient.LOGGER;
      Object[] var10002 = new Object[3];
      boolean var10004 = true;
      var10002[0] = this.string2;
      var10002[1] = this.int_;
      var10002[2] = var2.getMessage();
      var10000.warn("HTTP proxy tunnel to {}:{} failed: {}", var10002);
      if (this.channelPromise != null) {
         this.channelPromise.tryFailure(var2);
      }

      var1.close();
   }

   private static int getIntForString(String var0) {
      String[] var2;
      if ((var2 = var0.split("\\s+", 3)).length < 2) {
         return 0;
      } else {
         try {
            return Integer.parseInt(var2[1]);
         } catch (NumberFormatException var3) {
            return 0;
         }
      }
   }

   public void channelActive(ChannelHandlerContext var1) {
      this.handleChannelHandlerContext(var1);
   }

   private static int getIntForByteBuf(ByteBuf var0) {
      int var1;
      for(int var10000 = var1 = var0.readerIndex(); var10000 <= var0.writerIndex() - BYTE_ARRAY.length; var10000 = var1) {
         boolean var2 = true;
         int var4;
         var10000 = var4 = 0;

         boolean var5;
         while(true) {
            if (var10000 >= BYTE_ARRAY.length) {
               var5 = var2;
               break;
            }

            if (var0.getByte(var1 + var4) != BYTE_ARRAY[var4]) {
               var5 = var2 = false;
               break;
            }

            ++var4;
            var10000 = var4;
         }

         if (var5) {
            return var1;
         }

         ++var1;
      }

      return -1;
   }

   public void connect(ChannelHandlerContext var1, SocketAddress var2, SocketAddress var3, ChannelPromise var4) {
      if (var2 instanceof InetSocketAddress) {
         InetSocketAddress var5 = (InetSocketAddress)var2;
         this.inetSocketAddress2 = var5;
         this.channelPromise = var4;
         this.scheduledFuture = var1.executor().schedule(() -> {
            IllegalStateException timeout = new IllegalStateException("HTTP proxy connection timed out");
            this.handleChannelHandlerContext2(var1, timeout);
         }, 10L, TimeUnit.SECONDS);
         InetSocketAddress var6 = this.inetSocketAddress;
         ChannelPromise var7 = var1.newPromise();
         ChannelFuture var9 = var1.connect(var6, var3, var7).addListener((var2x) -> {
            if (!var2x.isSuccess()) {
               this.handleChannelHandlerContext2(var1, var2x.cause());
            }

         });
      } else {
         var4.tryFailure(new IllegalArgumentException("HTTP proxy requires an internet address"));
      }
   }

   public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) {
      this.handleChannelHandlerContext2(var1, var2);
   }

   public void channelInactive(ChannelHandlerContext var1) {
      this.handleChannelHandlerContext2(var1, new IllegalStateException("HTTP proxy closed the connection"));
      var1.fireChannelInactive();
   }

   private void handleChannelHandlerContext(ChannelHandlerContext var1) {
      String var4 = this.string2.isBlank() ? this.inetSocketAddress2.getAddress().getHostAddress() : this.string2;
      if (var4.indexOf(58) >= 0) {
         var4 = (new StringBuilder()).insert(0, "[").append(var4).append("]").toString();
      }

      var4 = (new StringBuilder()).insert(0, var4).append(":").append(this.int_).toString();
      var4 = (new StringBuilder()).insert(0, "CONNECT ").append(var4).append(" HTTP/1.1\r\nHost: ").append(var4).append("\r\n").toString();
      if (!this.string.isBlank()) {
         String var3 = (new StringBuilder()).insert(0, this.string).append(":").append(this.string3).toString();
         var4 = (new StringBuilder()).insert(0, var4).append("Proxy-Authorization: Basic ").append(Base64.getEncoder().encodeToString(var3.getBytes(StandardCharsets.UTF_8))).append("\r\n").toString();
      }

      var1.writeAndFlush(Unpooled.copiedBuffer((CharSequence)(new StringBuilder()).insert(0, var4).append("\r\n").toString(), StandardCharsets.US_ASCII));
   }
}
