package client.onyx.render;

import client.onyx.MinecraftAccess;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public final class Util8 implements MinecraftAccess {
   private static final FloatBuffer FLOAT_BUFFER2 = BufferUtils.createFloatBuffer(16);
   private static final FloatBuffer FLOAT_BUFFER = BufferUtils.createFloatBuffer(16);
   private static final FloatBuffer FLOAT_BUFFER3 = BufferUtils.createFloatBuffer(3);
   private static final IntBuffer INT_BUFFER = BufferUtils.createIntBuffer(16);
   private static boolean bool;
   private static Vec3 vec34 = new Vec3(0.0, 0.0, 0.0);
   private static Vec3 vec3 = new Vec3(0.0, 0.0, 0.0);
   private static Vec3 vec32 = new Vec3(0.0, 0.0, 1.0);
   private static Vec3 vec33 = new Vec3(1.0, 0.0, 0.0);

   static {
      INT_BUFFER.put(0, 0);
      INT_BUFFER.put(1, 0);
      INT_BUFFER.put(2, 1);
      INT_BUFFER.put(3, 1);
   }

   public static boolean isEnabled44() {
      return bool;
   }

   public static void handleFloat30(float var0) {
      Entity var2;
      if ((var2 = MINECRAFT.getRenderViewEntity()) == null) {
         bool = false;
      } else {
         FLOAT_BUFFER2.clear();
         FLOAT_BUFFER.clear();
         GL11.glGetFloat(2982, FLOAT_BUFFER2);
         GL11.glGetFloat(2983, FLOAT_BUFFER);
         vec34 = new Vec3(
            var2.prevPosX + (var2.posX - var2.prevPosX) * var0,
            var2.prevPosY + (var2.posY - var2.prevPosY) * var0,
            var2.prevPosZ + (var2.posZ - var2.prevPosZ) * var0
         );
         vec32 = getVec3ForFloat3(0.0F, 0.0F, -1.0F);
         vec33 = getVec3ForFloat3(-1.0F, 0.0F, 0.0F);
         vec3 = vec34.add(getVec3ForFloat3(-FLOAT_BUFFER2.get(12), -FLOAT_BUFFER2.get(13), -FLOAT_BUFFER2.get(14)));
         bool = true;
      }
   }

   public static Vec3 getVec313() {
      return vec3;
   }

   public static Vec3 getVec315() {
      return vec32;
   }

   public static Vec3 getVec314() {
      return vec33;
   }

   public static float getFloat22() {
      return Math.abs(FLOAT_BUFFER.get(0));
   }

   private static Vec3 getVec3ForFloat3(float var0, float var1, float var2) {
      return new Vec3(
         FLOAT_BUFFER2.get(0) * var0 + FLOAT_BUFFER2.get(1) * var1 + FLOAT_BUFFER2.get(2) * var2,
         FLOAT_BUFFER2.get(4) * var0 + FLOAT_BUFFER2.get(5) * var1 + FLOAT_BUFFER2.get(6) * var2,
         FLOAT_BUFFER2.get(8) * var0 + FLOAT_BUFFER2.get(9) * var1 + FLOAT_BUFFER2.get(10) * var2
      );
   }

   public static float getFloat21() {
      return Math.abs(FLOAT_BUFFER.get(5));
   }

   public static void run50() {
      bool = false;
   }

   private Util8() {
   }

   public static float[] getFloatArrayForVec3(Vec3 var0, float var1, float var2) {
      if (!bool) {
         return null;
      } else {
         FLOAT_BUFFER3.clear();
         if (!GLU.gluProject(
            (float)(var0.xCoord - vec34.xCoord),
            (float)(var0.yCoord - vec34.yCoord),
            (float)(var0.zCoord - vec34.zCoord),
            FLOAT_BUFFER2,
            FLOAT_BUFFER,
            INT_BUFFER,
            FLOAT_BUFFER3
         )) {
            return null;
         } else {
            float var3;
            if (Float.isFinite(var3 = FLOAT_BUFFER3.get(2)) && !(var3 < 0.0F) && !(var3 > 1.0F)) {
               var1 = FLOAT_BUFFER3.get(0) * var1;
               var2 = (1.0F - FLOAT_BUFFER3.get(1)) * var2;
               return Float.isFinite(var1) && Float.isFinite(var2) ? new float[]{var1, var2} : null;
            } else {
               return null;
            }
         }
      }
   }
}
