package client.onyx.render.extra;

import client.onyx.OnyxClient;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.renderer.OpenGlHelper;
import org.apache.logging.log4j.Logger;
import org.lwjgl.BufferUtils;

public final class Cls {
   private boolean bool;
   private int int_;
   private final Map<String, Integer> map = new HashMap<>();
   private final String string;
   private final String string2;
   private static final String STRING = "/assets/onyx/shaders/core/";
   private final FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(4);
   private static final int INT = 1024;
   private final String string3;

   private int getInt2(String var1) {
      if (!this.bool) {
         return -1;
      } else {
         Integer var3;
         if ((var3 = this.map.get(var1)) == null) {
            var3 = OpenGlHelper.glGetUniformLocation(this.int_, var1);
            this.map.put(var1, var3);
         }

         return var3;
      }
   }

   public void handleString3(String var1, float var2, float var3, float var4) {
      int var5;
      if ((var5 = this.getInt2(var1)) >= 0) {
         this.floatBuffer.clear();
         this.floatBuffer.put(var2).put(var3).put(var4).flip();
         OpenGlHelper.glUniform3(var5, this.floatBuffer);
      }
   }

   private void run() throws IOException {
      if (!OpenGlHelper.shadersSupported) {
         Logger var4 = OnyxClient.LOGGER;
         Object[] var5 = new Object[]{this.string2};
         var4.warn("Shaders unsupported, '{}' disabled", var5);
      } else {
         int var1 = this.getInt(OpenGlHelper.GL_VERTEX_SHADER, new StringBuilder().insert(0, this.string3).append(".vsh").toString());
         int var3 = this.getInt(OpenGlHelper.GL_FRAGMENT_SHADER, new StringBuilder().insert(0, this.string).append(".fsh").toString());
         if (var1 != 0 && var3 != 0) {
            this.int_ = OpenGlHelper.glCreateProgram();
            OpenGlHelper.glAttachShader(this.int_, var1);
            OpenGlHelper.glAttachShader(this.int_, var3);
            OpenGlHelper.glLinkProgram(this.int_);
            OpenGlHelper.glDeleteShader(var1);
            OpenGlHelper.glDeleteShader(var3);
            if (OpenGlHelper.glGetProgrami(this.int_, OpenGlHelper.GL_LINK_STATUS) == 0) {
               Logger var10000 = OnyxClient.LOGGER;
               Object[] var10002 = new Object[2];
               boolean var10004 = true;
               var10002[0] = this.string2;
               var10002[1] = OpenGlHelper.glGetProgramInfoLog(this.int_, 1024);
               var10000.error("Failed to link shader '{}': {}", var10002);
               OpenGlHelper.glDeleteProgram(this.int_);
               this.int_ = 0;
            } else {
               this.bool = true;
            }
         } else {
            if (var1 != 0) {
               OpenGlHelper.glDeleteShader(var1);
            }

            if (var3 != 0) {
               OpenGlHelper.glDeleteShader(var3);
            }
         }
      }
   }

   public void handleString2(String var1, float var2, float var3) {
      int var4;
      if ((var4 = this.getInt2(var1)) >= 0) {
         this.floatBuffer.clear();
         this.floatBuffer.put(var2).put(var3).flip();
         OpenGlHelper.glUniform2(var4, this.floatBuffer);
      }
   }

   public void handleString7(String var1, int var2) {
      this.handleString3(var1, (var2 >> 16 & 0xFF) / 255.0F, (var2 >> 8 & 0xFF) / 255.0F, (var2 & 0xFF) / 255.0F);
   }

   public static Cls getClsForString2(String var0, String var1, String var2) {
      Cls var6 = new Cls(var0, var1, var2);

      try {
         var6.run();
         return var6;
      } catch (Throwable var5) {
         Logger var3 = OnyxClient.LOGGER;
         Object[] var4 = new Object[]{var0, var5};
         var3.error("Failed to build shader '{}'", var4);
         var6.bool = false;
         return var6;
      }
   }

   public void handleString5(String var1, int var2) {
      int var3;
      if ((var3 = this.getInt2(var1)) >= 0) {
         OpenGlHelper.glUniform1i(var3, var2);
      }
   }

   private static ByteBuffer getByteBufferForString(String var0) throws IOException {
      InputStream var5 = Cls.class.getResourceAsStream(new StringBuilder().insert(0, "/assets/onyx/shaders/core/").append(var0).toString());

      ByteBuffer var4;
      try {
         if (var5 == null) {
            throw new IOException(new StringBuilder().insert(0, "Missing shader resource /assets/onyx/shaders/core/").append(var0).toString());
         }

         byte[] var2;
         ByteBuffer var3;
         (var3 = BufferUtils.createByteBuffer((var2 = var5.readAllBytes()).length)).put(var2);
         var3.flip();
         var4 = var3;
      } catch (Throwable var7) {
         if (var5 != null) {
            try {
               var5.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
               throw var7;
            }

            throw var7;
         }

         throw var7;
      }

      if (var5 != null) {
         var5.close();
      }

      return var4;
   }

   public void run3() {
      if (this.bool) {
         OpenGlHelper.glUseProgram(this.int_);
      }
   }

   public void handleString6(String var1, FloatBuffer var2) {
      int var3;
      if ((var3 = this.getInt2(var1)) >= 0) {
         OpenGlHelper.glUniformMatrix4(var3, false, var2);
      }
   }

   public static void run2() {
      if (OpenGlHelper.shadersSupported) {
         OpenGlHelper.glUseProgram(0);
      }
   }

   public static Cls getClsForString(String var0) {
      return getClsForString2(var0, var0, var0);
   }

   public boolean isEnabled() {
      return this.bool;
   }

   public void handleString(String var1, float var2) {
      int var3;
      if ((var3 = this.getInt2(var1)) >= 0) {
         this.floatBuffer.clear();
         this.floatBuffer.put(var2).flip();
         OpenGlHelper.glUniform1(var3, this.floatBuffer);
      }
   }

   public void handleString4(String var1, float var2, float var3, float var4, float var5) {
      int var6;
      if ((var6 = this.getInt2(var1)) >= 0) {
         this.floatBuffer.clear();
         this.floatBuffer.put(var2).put(var3).put(var4).put(var5).flip();
         OpenGlHelper.glUniform4(var6, this.floatBuffer);
      }
   }

   private int getInt(int var1, String var2) throws IOException {
      int var3;
      OpenGlHelper.glShaderSource(var3 = OpenGlHelper.glCreateShader(var1), getByteBufferForString(var2));
      OpenGlHelper.glCompileShader(var3);
      if (OpenGlHelper.glGetShaderi(var3, OpenGlHelper.GL_COMPILE_STATUS) == 0) {
         Logger var10000 = OnyxClient.LOGGER;
         Object[] var10002 = new Object[2];
         boolean var10004 = true;
         var10002[0] = var2;
         var10002[1] = OpenGlHelper.glGetShaderInfoLog(var3, 1024);
         var10000.error("Failed to compile '{}': {}", var10002);
         OpenGlHelper.glDeleteShader(var3);
         return 0;
      } else {
         return var3;
      }
   }

   private Cls(String var1, String var2, String var3) {
      this.string2 = var1;
      this.string3 = var2;
      this.string = var3;
   }
}
