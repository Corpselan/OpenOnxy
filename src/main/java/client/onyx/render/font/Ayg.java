package client.onyx.render.font;

import client.onyx.OnyxClient;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import org.apache.logging.log4j.Logger;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public final class Ayg {
   private boolean bool;
   private final Map<Character, Ayg.U0V0Record> map = new HashMap<>();
   private final float float_;
   private int int_;
   private final float float_2;
   private int int_2;
   private int int_3;
   private static final int INT = 8;
   private int int_4;
   private static final Ayg.U0V0Record U0_V0_RECORD2 = new Ayg.U0V0Record(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
   private static final int INT2 = 512;
   private static final int INT3 = 3;
   private final Font font;
   private static final int INT4 = 2048;
   private static final int INT5 = 8;
   private static final int INT6 = 192;
   private static final float FLOAT = 100.0F;
   private static final Ayg.U0V0Record U0_V0_RECORD = Ayg.U0_V0_RECORD2;
   public static final int INT7 = 4;
   private static final int INT8 = 12;
   private final FontRenderContext fontRenderContext = new FontRenderContext(null, true, true);
   private final int int_5;
   private final float float_3;
   private static final float FLOAT2 = 0.72F;
   private static final float FLOAT3 = 0.21F;

   public float getFloat(char var1) {
      return this.getU0V0Record2(var1).advance();
   }

   private static byte[] getByteArrayForByteArray(byte[] var0, int var1, int var2, int var3, int var4) {
      byte[] var5 = new byte[var3 * var4];

      int var6;
      for (int var10000 = var6 = 0; var10000 < var4; var10000 = ++var6) {
         int var7;
         int var8 = Math.min((var7 = var6 * 2) + 1, var2 - 1);

         int var9;
         for (int var15 = var9 = 0; var15 < var3; var15 = var9) {
            int var12;
            int var11 = Math.min((var12 = var9 * 2) + 1, var1 - 1);
            var12 = (var0[var7 * var1 + var12] & 255)
               + (var0[var7 * var1 + var11] & 255)
               + (var0[var8 * var1 + var12] & 255)
               + (var0[var8 * var1 + var11] & 255);
            int var10001 = var6 * var3 + var9;
            byte var10002 = (byte)(var12 >> 2);
            var9++;
            var5[var10001] = var10002;
         }
      }

      return var5;
   }

   public float getFloat5() {
      return this.float_;
   }

   private float getFloat6(char var1) {
      return -this.getRectangle(var1).y * this.float_2;
   }

   private void handleInt(int var1, int var2, int var3, int var4, int var5, byte[] var6) {
      ByteBuffer var7;
      (var7 = BufferUtils.createByteBuffer(var4 * var5)).put(var6, 0, var4 * var5).flip();
      GL11.glTexSubImage2D(3553, var1, var2, var3, var4, var5, 6406, 5121, var7);
   }

   public static Ayg getAygForString(String var0, float var1) {
      try {
         InputStream var5 = Ayg.class.getResourceAsStream(var0);

         Ayg var3;
         try {
            if (var5 == null) {
               throw new IOException(new StringBuilder().insert(0, "Missing font ").append(var0).toString());
            }

            var3 = new Ayg(Font.createFont(0, var5), var1);
         } catch (Throwable var9) {
            if (var5 != null) {
               try {
                  var5.close();
               } catch (Throwable var8) {
                  var9.addSuppressed(var8);
                  throw var9;
               }

               throw var9;
            }

            throw var9;
         }

         if (var5 != null) {
            var5.close();
         }

         return var3;
      } catch (Exception var10) {
         Logger var6 = OnyxClient.LOGGER;
         Object[] var7 = new Object[]{var0, var10};
         var6.error("Failed to load font '{}'", var7);
         return new Ayg(new Font("SansSerif", 0, 1), var1);
      }
   }

   private Ayg(Font var1, float var2) {
      this.int_2 = -1;
      float var6 = Math.min(var2 * 4.0F, 192.0F);
      LineMetrics var4;
      float var9;
      float var5 = (var9 = (var4 = var1.deriveFont(100.0F).getLineMetrics("Ayg", this.fontRenderContext)).getAscent() + var4.getDescent()) <= 0.0F
         ? 1.0F
         : 100.0F / var9;
      this.font = var1.deriveFont(var6 * var5);
      this.float_2 = var2 / var6;
      int var7 = (int)var6 + 16;
      this.int_5 = Math.min(2048, Math.max(512, Integer.highestOneBit(var7 * 12 - 1) * 2));
      float var8 = this.getFloat6('H');
      var6 = this.getFloat3('p');
      this.float_ = var8 > 0.0F ? var8 : var2 * 0.72F;
      this.float_3 = var6 > 0.0F ? var6 : var2 * 0.21F;
   }

   public float getFloat4(String var1) {
      float var4 = 0.0F;

      int var3;
      for (int var10000 = var3 = 0; var10000 < var1.length(); var10000 = var3) {
         char var10002 = var1.charAt(var3);
         var3++;
         var4 += this.getFloat(var10002);
      }

      return var4;
   }

   private static int getIntForInt(int var0) {
      return var0 + 8 - 1 & -8;
   }

   private int[] getIntArray(int var1, int var2) {
      if (this.bool) {
         return null;
      } else {
         var1 = getIntForInt(var1);
         var2 = getIntForInt(var2);
         if (this.int_ + var1 > this.int_5) {
            this.int_ = 0;
            this.int_3 = this.int_3 + this.int_4;
            this.int_4 = 0;
         }

         if (this.int_3 + var2 > this.int_5) {
            this.bool = true;
            Logger var3 = OnyxClient.LOGGER;
            Object[] var4 = new Object[1];
            Integer var5 = this.int_5;
            var4[0] = var5;
            var3.warn("Glyph atlas full at {}px", var4);
            return null;
         } else {
            int[] var10000 = new int[2];
            boolean var10002 = true;
            var10000[0] = this.int_;
            var10000[1] = this.int_3;
            this.int_ += var1;
            this.int_4 = Math.max(this.int_4, var2);
            return var10000;
         }
      }
   }

   public float getFloat2() {
      return this.float_3;
   }

   private void handleBufferedImage(BufferedImage var1, int var2, int var3, int var4, int var5) {
      if (this.int_2 == -1) {
         this.run();
      }

      int[] var15;
      byte[] var10000 = new byte[(var15 = ((DataBufferInt)var1.getRaster().getDataBuffer()).getData()).length];
      boolean var10002 = true;
      byte[] var6 = var10000;

      int var7;
      for (int var20 = var7 = 0; var20 < var15.length; var20 = var7) {
         byte var11 = (byte)(var15[var7] >>> 24);
         int var12 = var7++;
         var6[var12] = var11;
      }

      GlStateManager.bindTexture(this.int_2);
      GL11.glPixelStorei(3317, 1);
      var7 = var4;
      int var16 = var5;

      for (int var21 = var4 = 0; var21 <= 3; var21 = var4) {
         this.handleInt(var4, var2 >> var4, var3 >> var4, var7, var16, var6);
         if (var4 == 3) {
            break;
         }

         var5 = Math.max(1, var7 >> 1);
         int var13 = var16 >> 1;
         int var8 = Math.max(1, var13);
         var6 = getByteArrayForByteArray(var6, var7, var16, var5, var8);
         var4++;
         var7 = var5;
         var16 = var8;
      }

      GL11.glPixelStorei(3317, 4);
   }

   public Ayg.U0V0Record getU0V0Record2(char var1) {
      Ayg.U0V0Record var3;
      if ((var3 = this.map.get(var1)) != null) {
         return var3;
      } else {
         var3 = this.getU0V0Record(var1);
         this.map.put(var1, var3);
         return var3;
      }
   }

   private Ayg.U0V0Record getU0V0Record(char var1) {
      if (!this.font.canDisplay(var1)) {
         return U0_V0_RECORD;
      } else {
         Font var8 = this.font;
         FontRenderContext var9 = this.fontRenderContext;
         char[] var10 = new char[]{var1};
         GlyphVector var13 = var8.createGlyphVector(var9, var10);
         float var5 = var13.getGlyphMetrics(0).getAdvanceX() * this.float_2;
         Rectangle var3;
         if ((var3 = var13.getPixelBounds(this.fontRenderContext, 0.0F, 0.0F)).width > 0 && var3.height > 0) {
            int var4 = var3.width + 16;
            int var2 = var3.height + 16;
            if (var4 <= this.int_5 && var2 <= this.int_5) {
               BufferedImage var6;
               Graphics2D var7 = (var6 = new BufferedImage(var4, var2, 2)).createGraphics();
               var7.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
               var7.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
               var7.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
               var7.setColor(Color.WHITE);
               var7.setFont(this.font);
               var7.drawGlyphVector(var13, 8 - var3.x, 8 - var3.y);
               var7.dispose();
               int[] var14;
               if ((var14 = this.getIntArray(var4, var2)) == null) {
                  return U0_V0_RECORD2;
               } else {
                  this.handleBufferedImage(var6, var14[0], var14[1], var4, var2);
                  return new Ayg.U0V0Record(
                     (float)var14[0] / this.int_5,
                     (float)var14[1] / this.int_5,
                     (float)(var14[0] + var4) / this.int_5,
                     (float)(var14[1] + var2) / this.int_5,
                     (var3.x - 8) * this.float_2,
                     (var3.y - 8) * this.float_2,
                     var4 * this.float_2,
                     var2 * this.float_2,
                     var5
                  );
               }
            } else {
               return U0_V0_RECORD2;
            }
         } else {
            return new Ayg.U0V0Record(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, var5);
         }
      }
   }

   private float getFloat3(char var1) {
      Rectangle var10000 = this.getRectangle(var1);
      return (var10000.y + var10000.height) * this.float_2;
   }

   public boolean isChar2(char var1) {
      return Character.isWhitespace(var1) ? true : this.isChar(var1) && !this.getU0V0Record2(var1).isEnabled();
   }

   public int getInt() {
      return this.int_2;
   }

   public boolean isChar(char var1) {
      return this.font.canDisplay(var1);
   }

   private Rectangle getRectangle(char var1) {
      Font var2 = this.font;
      FontRenderContext var3 = this.fontRenderContext;
      char[] var4 = new char[]{var1};
      return var2.createGlyphVector(var3, var4).getPixelBounds(this.fontRenderContext, 0.0F, 0.0F);
   }

   private void run() {
      this.int_2 = TextureUtil.glGenTextures();
      GlStateManager.bindTexture(this.int_2);
      GL11.glTexParameteri(3553, 10241, 9987);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10242, 33071);
      GL11.glTexParameteri(3553, 10243, 33071);
      GL11.glTexParameteri(3553, 33085, 3);
      GL11.glPixelStorei(3317, 1);

      int var3;
      for (int var10000 = var3 = 0; var10000 <= 3; var10000 = var3) {
         int var2 = this.int_5 >> var3;
         GL11.glTexImage2D(3553, var3++, 6406, var2, var2, 0, 6406, 5121, BufferUtils.createByteBuffer(var2 * var2));
      }

      GL11.glPixelStorei(3317, 4);
   }

   public record U0V0Record(float u0, float v0, float u1, float v1, float bearingX, float bearingY, float width, float height, float advance) {
      public boolean isEnabled() {
         return this.width <= 0.0F || this.height <= 0.0F;
      }
   }
}
