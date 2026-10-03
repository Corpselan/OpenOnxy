package client.onyx.render;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public enum PixelsSmoothEnum {
   // 顺序按原 $VALUES 数组（即 ordinal）
   PIXELS,
   SMOOTH,
   MINIFIED;
   private static final Set<Integer> SET = new HashSet<>();
   private static final Set<Integer> SET2 = new HashSet<>();

   private static boolean isEnabled2() {
      int var0 = getIntForInt(0, 4096);
      int var1 = getIntForInt(0, 4097);
      int var2 = getIntForInt(0, 4099);
      if (var0 > 0 && var1 > 0) {
         int var3 = 0;

         while (var0 > 1 || var1 > 1) {
            var0 = Math.max(1, var0 / 2);
            var3++;
            var1 = Math.max(1, var1 / 2);
            if (getIntForInt(var3, 4096) != var0) {
               return false;
            }

            if (getIntForInt(var3, 4097) != var1) {
               return false;
            }

            if (getIntForInt(var3, 4099) != var2) {
               return false;
            }
         }

         return GL11.glGetTexParameteri(3553, 33085) >= var3 && GL11.glGetTexParameterf(3553, 33083) >= var3;
      } else {
         return false;
      }
   }

   private static int getIntForInt(int var0, int var1) {
      return GL11.glGetTexLevelParameteri(3553, var0, var1);
   }

   float getFloat() {
      return this == PIXELS ? 0.01F : 0.5F;
   }

   public static void handleInt2(int var0) {
      SET.remove(var0);
      SET2.remove(var0);
   }

   void handleInt(int var1) {
      if (this != PIXELS) {
         GL11.glTexParameteri(3553, 10241, var1);
         GL11.glTexParameteri(3553, 10240, var1);
      }
   }

   private static byte[] getByteArrayForByteArray(byte[] var0, int var1, int var2, int var3, int var4) {
      byte[] var5 = new byte[var3 * var4 * 4];

      int var6;
      int var7;
      for (int var10000 = var6 = 0; var10000 < var4; var10000 = ++var6) {
         for (int var22 = var7 = 0; var22 < var3; var22 = var7) {
            int var8 = 0;
            int var9 = 0;
            int var10 = 0;
            int var18 = 0;
            int var12 = 0;

            int var13;
            for (int var23 = var13 = 0; var23 < 2; var23 = ++var13) {
               int var14;
               int var15;
               if ((var14 = var6 * 2 + var13) < var2) {
                  for (int var24 = var15 = 0; var24 < 2; var24 = ++var15) {
                     int var16;
                     if ((var16 = var7 * 2 + var15) < var1) {
                        var16 = (var14 * var1 + var16) * 4;
                        int var17 = var0[var16 + 3] & 255;
                        var8 += (var0[var16] & 255) * var17;
                        var9 += (var0[var16 + 1] & 255) * var17;
                        var10 += (var0[var16 + 2] & 255) * var17;
                        var12++;
                        var18 += var17;
                     }
                  }
               }
            }

            var13 = (var6 * var3 + var7) * 4;
            var5[var13] = (byte)(var18 == 0 ? 0 : var8 / var18);
            var5[var13 + 1] = (byte)(var18 == 0 ? 0 : var9 / var18);
            var5[var13 + 2] = (byte)(var18 == 0 ? 0 : var10 / var18);
            int var10001 = var13 + 3;
            byte var10002 = (byte)(var12 == 0 ? 0 : var18 / var12);
            var7++;
            var5[var10001] = var10002;
         }
      }

      return var5;
   }


   private static void run() {
      int var0 = getIntForInt(0, 4096);
      int var1 = getIntForInt(0, 4097);
      int var2 = getIntForInt(0, 4099);
      if (var0 > 0 && var1 > 0 && var2 > 0) {
         ByteBuffer var3 = BufferUtils.createByteBuffer(var0 * var1 * 4);
         GL11.glGetTexImage(3553, 0, 6408, 5121, var3);
         byte[] var4 = new byte[var0 * var1 * 4];
         var3.get(var4);
         int var8 = 0;
         int var10000 = var0;

         while (var10000 > 1 || var1 > 1) {
            int var5 = Math.max(1, var0 / 2);
            int var6 = Math.max(1, var1 / 2);
            var4 = getByteArrayForByteArray(var4, var0, var1, var5, var6);
            var8++;
            var0 = var5;
            var1 = var6;
            ByteBuffer var9 = BufferUtils.createByteBuffer(var4.length);
            var10000 = var5;
            var9.put(var4).flip();
            GL11.glTexImage2D(3553, var8, var2, var5, var6, 0, 6408, 5121, var9);
         }

         GL11.glTexParameteri(3553, 33085, var8);
         GL11.glTexParameterf(3553, 33082, 0.0F);
         GL11.glTexParameterf(3553, 33083, var8);
      }
   }

   int getInt() {
      if (this == PIXELS) {
         return 9728;
      } else {
         if (this == MINIFIED && isEnabled()) {
            GL11.glTexParameteri(3553, 10241, 9987);
         } else {
            GL11.glTexParameteri(3553, 10241, 9729);
         }

         GL11.glTexParameteri(3553, 10240, 9729);
         return 9728;
      }
   }

   private static boolean isEnabled() {
      int var0;
      if ((var0 = GL11.glGetInteger(32873)) <= 0 || SET2.contains(var0)) {
         return false;
      } else if (SET.contains(var0) && getIntForInt(1, 4096) > 0) {
         return true;
      } else {
         SET.remove(var0);
         if (!isEnabled2()) {
            run();
         }

         if (isEnabled2()) {
            SET.add(var0);
            return true;
         } else {
            GL11.glTexParameteri(3553, 33085, 0);
            GL11.glTexParameterf(3553, 33083, 0.0F);
            SET2.add(var0);
            return false;
         }
      }
   }
}
