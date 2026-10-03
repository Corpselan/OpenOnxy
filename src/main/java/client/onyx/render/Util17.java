/*
 * Decompiled with CFR 0.0.9 (FabricMC cc05e23f).
 */
package client.onyx.render;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public final class Util17 {
    private static final float[] FLOAT_ARRAY;
    private static final int[] INT_ARRAY;
    private static final FloatBuffer FLOAT_BUFFER;
    private static float float_;
    private static float float_2;
    private static final float[] FLOAT_ARRAY2;
    private static boolean bool;
    private static final float FLOAT = 1.0E-4f;
    private static final float[] FLOAT_ARRAY3;
    private static boolean bool2;
    private static final float[] FLOAT_ARRAY4;
    private static final FloatBuffer FLOAT_BUFFER2;
    private static final float[] FLOAT_ARRAY5;
    private static float float_3;
    private static final float[] FLOAT_ARRAY6;
    private static float float_4;
    private static final float[] FLOAT_ARRAY7;

    static {
        float[] fArray = new float[]{-1.8f, -1.8f, -1.8f, 1.8f, 1.8f, 1.8f};
        FLOAT_ARRAY7 = fArray;
        float[] fArray2 = new float[]{-0.62f, -0.12f, -0.25f, -0.13f, 0.87f, 0.25f};
        FLOAT_ARRAY5 = fArray2;
        float[] fArray3 = new float[]{-0.62f, -0.58f, -0.6f, -0.13f, 0.83f, 0.6f};
        FLOAT_ARRAY3 = fArray3;
        FLOAT_BUFFER2 = BufferUtils.createFloatBuffer(16);
        FLOAT_BUFFER = BufferUtils.createFloatBuffer(16);
        int[] nArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 0, 2, 1, 3, 4, 6, 5, 7, 0, 4, 1, 5, 2, 6, 3, 7};
        INT_ARRAY = nArray;
        FLOAT_ARRAY6 = new float[8];
        FLOAT_ARRAY2 = new float[8];
        FLOAT_ARRAY = new float[8];
        FLOAT_ARRAY4 = new float[8];
    }

    private static void handleFloatArray(float[] fArray) {
        float f;
        FLOAT_BUFFER2.clear();
        FLOAT_BUFFER.clear();
        GL11.glGetFloat(2982, FLOAT_BUFFER2);
        GL11.glGetFloat(2983, FLOAT_BUFFER);
        int n = 0;
        int n2 = n;
        while (n2 < 8) {
            float f2 = fArray[(n & 1) == 0 ? 0 : 3];
            float f3 = fArray[(n & 2) == 0 ? 1 : 4];
            f = fArray[(n & 4) == 0 ? 2 : 5];
            float f4 = FLOAT_BUFFER2.get(0) * f2 + FLOAT_BUFFER2.get(4) * f3 + FLOAT_BUFFER2.get(8) * f + FLOAT_BUFFER2.get(12);
            float f5 = FLOAT_BUFFER2.get(1) * f2 + FLOAT_BUFFER2.get(5) * f3 + FLOAT_BUFFER2.get(9) * f + FLOAT_BUFFER2.get(13);
            float f6 = FLOAT_BUFFER2.get(2) * f2 + FLOAT_BUFFER2.get(6) * f3 + FLOAT_BUFFER2.get(10) * f + FLOAT_BUFFER2.get(14);
            Util17.FLOAT_ARRAY6[n] = FLOAT_BUFFER.get(0) * f4 + FLOAT_BUFFER.get(4) * f5 + FLOAT_BUFFER.get(8) * f6 + FLOAT_BUFFER.get(12);
            Util17.FLOAT_ARRAY2[n] = FLOAT_BUFFER.get(1) * f4 + FLOAT_BUFFER.get(5) * f5 + FLOAT_BUFFER.get(9) * f6 + FLOAT_BUFFER.get(13);
            float f7 = FLOAT_BUFFER.get(2) * f4 + FLOAT_BUFFER.get(6) * f5 + FLOAT_BUFFER.get(10) * f6 + FLOAT_BUFFER.get(14);
            Util17.FLOAT_ARRAY[n] = FLOAT_BUFFER.get(3) * f4 + FLOAT_BUFFER.get(7) * f5 + FLOAT_BUFFER.get(11) * f6 + FLOAT_BUFFER.get(15);
            float[] fArray2 = FLOAT_ARRAY4;
            float f8 = FLOAT_ARRAY[n];
            float f9 = f7 + f8;
            int n3 = n++;
            fArray2[n3] = f9;
            n2 = n;
        }
        int n4 = n = 0;
        while (n4 < 8) {
            if (FLOAT_ARRAY4[n] >= 0.0f) {
                Util17.handleFloat(FLOAT_ARRAY6[n], FLOAT_ARRAY2[n], FLOAT_ARRAY[n]);
            }
            n4 = ++n;
        }
        int n5 = n = 0;
        while (n5 < INT_ARRAY.length) {
            int n6;
            int n7 = INT_ARRAY[n];
            if (FLOAT_ARRAY4[n7] >= 0.0f != FLOAT_ARRAY4[n6 = INT_ARRAY[n + 1]] >= 0.0f) {
                f = FLOAT_ARRAY4[n7] / (FLOAT_ARRAY4[n7] - FLOAT_ARRAY4[n6]);
                Util17.handleFloat(FLOAT_ARRAY6[n7] + (FLOAT_ARRAY6[n6] - FLOAT_ARRAY6[n7]) * f, FLOAT_ARRAY2[n7] + (FLOAT_ARRAY2[n6] - FLOAT_ARRAY2[n7]) * f, FLOAT_ARRAY[n7] + (FLOAT_ARRAY[n6] - FLOAT_ARRAY[n7]) * f);
            }
            n5 = n += 2;
        }
    }

    public static void run() {
        bool2 = false;
    }

    public static void run3() {
        if (!bool) {
            return;
        }
        bool = false;
        GL11.glDisable(3089);
    }

    public static void handleFloat2(float f, int n, int n2) {
        if (!bool2) {
            return;
        }
        int n3 = Math.clamp((long)((int)Math.floor(float_ * (float)n - f)), 0, n);
        int n4 = Math.clamp((long)((int)Math.floor(float_3 * (float)n2 - f)), 0, n2);
        n = Math.clamp((long)((int)Math.ceil(float_2 * (float)n + f)), n3, n);
        n2 = Math.clamp((long)((int)Math.ceil(float_4 * (float)n2 + f)), n4, n2);
        if (n <= n3 || n2 <= n4) {
            return;
        }
        GL11.glEnable(3089);
        int n5 = n - n3;
        GL11.glScissor(n3, n4, n5, n2 - n4);
        bool = true;
    }

    private static void handleFloat(float f, float f2, float f3) {
        if (!(f3 > 1.0E-4f)) {
            return;
        }
        float f4 = f / f3 * 0.5f + 0.5f;
        f2 = f2 / f3 * 0.5f + 0.5f;
        if (!Float.isFinite(f4) || !Float.isFinite(f2)) {
            return;
        }
        if (bool2) {
            float_ = Math.min(float_, f4);
            float_3 = Math.min(float_3, f2);
            float_2 = Math.max(float_2, f4);
            float_4 = Math.max(float_4, f2);
            return;
        }
        float_ = f4;
        float_3 = f2;
        float_2 = f4;
        float_4 = f2;
        bool2 = true;
    }

    public static void run2() {
        Util17.handleFloatArray(FLOAT_ARRAY7);
    }

    private Util17() {
    }

    public static boolean isEnabled() {
        return bool2;
    }

    public static void handleBool(boolean bl) {
        Util17.handleFloatArray(bl ? FLOAT_ARRAY3 : FLOAT_ARRAY5);
    }
}

