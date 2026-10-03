package client.onyx.proxy;

import client.onyx.OnyxClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;

public final class Socks5ProxyHandler extends ChannelDuplexHandler {
   private final String string;
   private static final int INT = 3;
   private static final int INT2 = 2;
   private final InetSocketAddress inetSocketAddress;
   private static final int INT3 = 0;
   private final int int_;
   private final String string2;
   private InetSocketAddress inetSocketAddress2;
   private final String string3;
   private ByteBuf byteBuf;
   private static final int INT4 = 5;
   private Socks5ProxyHandler.ConnectingGreetingEnum connectingGreetingEnum = Socks5ProxyHandler.ConnectingGreetingEnum.CONNECTING;
   private ScheduledFuture<?> scheduledFuture;
   private static final int INT5 = 1;
   private static final int INT6 = 1;
   private ChannelPromise channelPromise;
   private static final int INT7 = 4;
   private static final int INT8 = 1;

   @Override
   public void handlerRemoved(ChannelHandlerContext var1) {
      if (this.byteBuf != null) {
         this.byteBuf.release();
         this.byteBuf = null;
      }

      this.run();
   }

   private void handleChannelHandlerContext4(ChannelHandlerContext var1) {
      byte[] var2;
      if ((var2 = this.string.getBytes(StandardCharsets.UTF_8)).length > 0 && var2.length <= 255) {
         ByteBuf var7 = Unpooled.buffer(7 + var2.length);
         var7.writeByte(5);
         var7.writeByte(1);
         var7.writeByte(0);
         var7.writeByte(3);
         var7.writeByte(var2.length);
         var7.writeBytes(var2);
         var7.writeShort(this.int_);
         var1.writeAndFlush(var7);
      } else {
         byte[] var5;
         int var6 = (var5 = this.inetSocketAddress2.getAddress().getAddress()).length == 4 ? 1 : 4;
         ByteBuf var4;
         (var4 = Unpooled.buffer(6 + var5.length)).writeByte(5);
         var4.writeByte(1);
         var4.writeByte(0);
         var4.writeByte(var6);
         var4.writeBytes(var5);
         var4.writeShort(this.int_);
         var1.writeAndFlush(var4);
      }
   }

   private boolean isChannelHandlerContext4(ChannelHandlerContext var1, ByteBuf var2) {
      switch (this.connectingGreetingEnum) {
         case CONNECT:

            return this.isChannelHandlerContext3(var1, var2);
         case CONNECTED:
            return this.isChannelHandlerContext2(var1, var2);
         case CONNECTING:
            return this.isChannelHandlerContext(var1, var2);
         default:
            return false;
      }
   }

   private void run() {
      if (this.scheduledFuture != null) {
         this.scheduledFuture.cancel(false);
         this.scheduledFuture = null;
      }
   }

   @Override
   public void channelInactive(ChannelHandlerContext var1) {
      if (this.connectingGreetingEnum != Socks5ProxyHandler.ConnectingGreetingEnum.CONNECTED) {
         IllegalStateException var2 = new IllegalStateException("SOCKS5 proxy closed the connection");
         this.handleChannelHandlerContext2(var1, var2);
      }

      var1.fireChannelInactive();
   }

   private boolean isChannelHandlerContext(ChannelHandlerContext var1, ByteBuf var2) {
      if (var2.readableBytes() < 4) {
         return false;
      } else {
         var2.markReaderIndex();
         short var3 = var2.readUnsignedByte();
         short var4 = var2.readUnsignedByte();
         var2.skipBytes(1);

         // 按字节码还原：SOCKS5 地址类型 ATYP（1=IPv4 4 字节，4=IPv6 16 字节，3=域名 长度在下一字节）
         int var5 = switch (var2.readUnsignedByte()) {
            case 1 -> 4;
            case 4 -> 16;
            case 3 -> var2.isReadable() ? var2.readUnsignedByte() : -1;
            default -> -1;
         };
         if (var5 < 0) {
            this.handleChannelHandlerContext2(var1, new IllegalStateException("SOCKS5 proxy returned an invalid address"));
            return true;
         } else if (var2.readableBytes() < var5 + 2) {
            var2.resetReaderIndex();
            return false;
         } else {
            var2.skipBytes(var5 + 2);
            if (var3 == 5 && var4 == 0) {
               this.connectingGreetingEnum = Socks5ProxyHandler.ConnectingGreetingEnum.CONNECTED;
               ByteBuf var6 = var2.isReadable() ? var2.readSlice(var2.readableBytes()).retain() : null;
               this.run();
               Logger var7 = OnyxClient.LOGGER;
               Object[] var10002 = new Object[2];
               boolean var10004 = true;
               var10002[0] = this.string;
               var10002[1] = this.int_;
               var7.info("SOCKS5 tunnel established to {}:{}", var10002);
               var1.fireChannelActive();
               this.channelPromise.trySuccess();
               if (var6 != null) {
                  var1.fireChannelRead(var6);
               }

               return true;
            } else {
               this.handleChannelHandlerContext2(
                  var1, new IllegalStateException(new StringBuilder().insert(0, "SOCKS5 CONNECT failed: ").append(getStringForInt(var4)).toString())
               );
               return true;
            }
         }
      }
   }

   private void handleChannelHandlerContext(ChannelHandlerContext var1) {
      boolean var2 = !this.string2.isBlank();
      ByteBuf var4 = Unpooled.buffer(3);
      var4.writeByte(5);
      var4.writeByte(1);
      var4.writeByte(var2 ? 2 : 0);
      var1.writeAndFlush(var4);
   }

   private void handleChannelHandlerContext2(ChannelHandlerContext var1, Throwable var2) {
      if (this.connectingGreetingEnum != Socks5ProxyHandler.ConnectingGreetingEnum.FAILED
         && this.connectingGreetingEnum != Socks5ProxyHandler.ConnectingGreetingEnum.CONNECTED) {
         this.connectingGreetingEnum = Socks5ProxyHandler.ConnectingGreetingEnum.FAILED;
         this.run();
         Logger var10000 = OnyxClient.LOGGER;
         Object[] var10002 = new Object[3];
         boolean var10004 = true;
         var10002[0] = this.string;
         var10002[1] = this.int_;
         var10002[2] = var2.getMessage();
         var10000.warn("SOCKS5 tunnel to {}:{} failed: {}", var10002);
         if (this.channelPromise != null) {
            this.channelPromise.tryFailure(var2);
         }

         var1.close();
      }
   }

   private void handleChannelHandlerContext3(ChannelHandlerContext var1) {
      byte[] var2 = this.string2.getBytes(StandardCharsets.UTF_8);
      byte[] var4 = this.string3.getBytes(StandardCharsets.UTF_8);
      if (var2.length != 0 && var2.length <= 255 && var4.length <= 255) {
         ByteBuf var5 = Unpooled.buffer(3 + var2.length + var4.length);
         var5.writeByte(1);
         var5.writeByte(var2.length);
         var5.writeBytes(var2);
         var5.writeByte(var4.length);
         var5.writeBytes(var4);
         var1.writeAndFlush(var5);
      } else {
         IllegalArgumentException var6 = new IllegalArgumentException("SOCKS5 credentials must be at most 255 bytes");
         this.handleChannelHandlerContext2(var1, var6);
      }
   }

   @Override
   public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) {
      this.handleChannelHandlerContext2(var1, var2);
   }

   private boolean isChannelHandlerContext3(ChannelHandlerContext var1, ByteBuf var2) {
      if (var2.readableBytes() < 2) {
         return false;
      } else {
         short var5 = var2.readUnsignedByte();
         short var3 = var2.readUnsignedByte();
         if (var5 != 5) {
            IllegalStateException var4 = new IllegalStateException("SOCKS5 proxy returned an invalid greeting");
            this.handleChannelHandlerContext2(var1, var4);
         } else if (var3 == 0) {
            this.connectingGreetingEnum = Socks5ProxyHandler.ConnectingGreetingEnum.CONNECT;
            this.handleChannelHandlerContext4(var1);
         } else if (var3 == 2 && !this.string2.isBlank()) {
            this.connectingGreetingEnum = Socks5ProxyHandler.ConnectingGreetingEnum.AUTH;
            this.handleChannelHandlerContext3(var1);
         } else {
            this.handleChannelHandlerContext2(var1, new IllegalStateException("SOCKS5 proxy rejected the configured authentication"));
         }

         return true;
      }
   }

   public Socks5ProxyHandler(InetSocketAddress var1, String var2, int var3, String var4, String var5) {
      this.inetSocketAddress = var1;
      this.string = var2 == null ? "" : var2;
      this.int_ = var3;
      this.string2 = var4 == null ? "" : var4;
      this.string3 = var5 == null ? "" : var5;
   }

   @Override
   public void connect(ChannelHandlerContext var1, SocketAddress var2, SocketAddress var3, ChannelPromise var4) {
      if (var2 instanceof InetSocketAddress var5) {
         this.inetSocketAddress2 = var5;
         this.channelPromise = var4;
         this.scheduledFuture = var1.executor().schedule(() -> {
            IllegalStateException var2x = new IllegalStateException("SOCKS5 proxy connection timed out");
            this.handleChannelHandlerContext2(var1, var2x);
         }, 10L, TimeUnit.SECONDS);
         InetSocketAddress var6 = this.inetSocketAddress;
         ChannelPromise var7 = var1.newPromise();
         ChannelFuture var9 = var1.connect(var6, var3, var7).addListener(var2x -> {
            if (!var2x.isSuccess()) {
               this.handleChannelHandlerContext2(var1, var2x.cause());
            }
         });
      } else {
         var4.tryFailure(new IllegalArgumentException("SOCKS5 requires an internet address"));
      }
   }

   private static String getStringForInt(int var0) {
      switch (var0) {
         case 1:

            return "general failure";
         case 2:
            return "connection not allowed by ruleset";
         case 3:
            return "network unreachable";
         case 4:
            return "host unreachable";
         case 5:
            return "connection refused";
         case 6:
            return "TTL expired";
         case 7:
            return "command not supported";
         case 8:
            return "address type not supported";
         default:
            return new StringBuilder().insert(0, "status ").append(var0).toString();
      }
   }

   @Override
   public void channelActive(ChannelHandlerContext var1) {
      if (this.connectingGreetingEnum == Socks5ProxyHandler.ConnectingGreetingEnum.CONNECTING) {
         this.connectingGreetingEnum = Socks5ProxyHandler.ConnectingGreetingEnum.GREETING;
         this.handleChannelHandlerContext(var1);
      }
   }

   private boolean isChannelHandlerContext2(ChannelHandlerContext var1, ByteBuf var2) {
      if (var2.readableBytes() < 2) {
         return false;
      } else {
         short var5 = var2.readUnsignedByte();
         short var3 = var2.readUnsignedByte();
         if (var5 == 1 && var3 == 0) {
            this.connectingGreetingEnum = Socks5ProxyHandler.ConnectingGreetingEnum.CONNECT;
            this.handleChannelHandlerContext4(var1);
         } else {
            IllegalStateException var4 = new IllegalStateException("SOCKS5 proxy rejected the username or password");
            this.handleChannelHandlerContext2(var1, var4);
         }

         return true;
      }
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public void channelRead(ChannelHandlerContext var1, Object var2) {
      if (var2 instanceof ByteBuf var4) {
         Socks5ProxyHandler var10000 = this;

         try {
            if (var10000.byteBuf == null) {
               this.byteBuf = var1.alloc().buffer(var4.readableBytes());
            }

            this.byteBuf.writeBytes(var4);

            while (
               this.connectingGreetingEnum != Socks5ProxyHandler.ConnectingGreetingEnum.CONNECTED
                  && this.connectingGreetingEnum != Socks5ProxyHandler.ConnectingGreetingEnum.FAILED
                  && this.byteBuf != null
                  && this.byteBuf.isReadable()
            ) {
               ByteBuf var5 = this.byteBuf;
               if (!this.isChannelHandlerContext4(var1, var5)) {
                  break;
               }
            }
         } catch (Throwable var8) {
            var4.release();
            throw var8;
         }

         var4.release();
         if (this.connectingGreetingEnum == Socks5ProxyHandler.ConnectingGreetingEnum.CONNECTED) {
            var1.pipeline().remove(this);
         } else {
            if (this.connectingGreetingEnum != Socks5ProxyHandler.ConnectingGreetingEnum.CONNECTED && this.byteBuf != null) {
               this.byteBuf.discardReadBytes();
            }
         }
      } else {
         var1.fireChannelRead(var2);
      }
   }

   private static enum ConnectingGreetingEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      CONNECTING,
      GREETING,
      AUTH,
      CONNECT,
      CONNECTED,
      FAILED;

      static {
         Socks5ProxyHandler.ConnectingGreetingEnum[] var0 = new Socks5ProxyHandler.ConnectingGreetingEnum[]{
            CONNECTING, GREETING, AUTH, CONNECT, CONNECTED, FAILED
         };
      }
   }
}
