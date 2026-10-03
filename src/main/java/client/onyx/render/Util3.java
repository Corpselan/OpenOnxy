/*
 * Decompiled with CFR 0.0.9 (FabricMC cc05e23f).
 */
package client.onyx.render;

import client.onyx.OnyxClient;
import client.onyx.render.extra.Cls;
import java.nio.ByteBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.GL11;

public final class Util3 {
    private static final int INT = 5888;
    private static final int INT2 = 32;
    private static final float FLOAT = 8.0f;
    private static int int_;
    private static boolean bool;
    private static boolean bool2;
    private static int int_2;
    private static int int_3;
    private static int int_4;
    private static final int INT3 = 64;
    private static Cls cls;
    private static int int_5;
    private static int int_6;
    private static int int_7;
    private static final int INT4 = 5889;
    private static int int_8;
    private static int int_9;
    private static int int_10;
    private static boolean bool3;
    private static int int_11;
    private static boolean bool4;
    private static int int_12;
    private static boolean bool5;
    private static int int_13;
    private static final int INT5 = 2;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void run7() {
        if (!bool2 || !Util3.isEnabled()) {
            return;
        }
        bool2 = false;
        try {
            int n;
            Minecraft minecraft = Minecraft.getMinecraft();
            Framebuffer framebuffer = minecraft.getFramebuffer();
            boolean bl = OpenGlHelper.isFramebufferEnabled() && framebuffer != null;
            int n2 = bl ? framebuffer.framebufferWidth : minecraft.displayWidth;
            int n3 = n = bl ? framebuffer.framebufferHeight : minecraft.displayHeight;
            if (n2 <= 0 || n <= 0) {
                return;
            }
            if (cls == null) {
                cls = Cls.getClsForString("box_blur");
            }
            if (!cls.isEnabled()) {
                Util3.handleThrowable(null);
                return;
            }
            int n4 = Math.max(1, n2 / 2);
            int n5 = Math.max(1, n / 2);
            Util3.handleInt3(n4, n5);
            int n6 = bl ? framebuffer.framebufferTexture : Util3.getIntForInt3(n2, n);
            Util3.handleInt6(n4, n5);
            Util3.handleInt4(n4, n5, n2, n);
            GlStateManager.bindTexture(n6);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            Util3.handleInt5(n6, int_11, n4, n5, 0.0f, 0.0f);
            Util3.handleInt5(int_9, int_13, n4, n5, 1.0f, 0.0f);
            Util3.handleInt5(int_, int_11, n4, n5, 0.0f, 1.0f);
            Util3.handleInt5(int_9, int_13, n4, n5, 1.0f, 0.0f);
            Util3.handleInt5(int_, int_11, n4, n5, 0.0f, 1.0f);
            if (bl) {
                GlStateManager.bindTexture(n6);
                GL11.glTexParameteri(3553, 10241, 9728);
                GL11.glTexParameteri(3553, 10240, 9728);
            }
            Util3.run2();
            Util3.handleMinecraft(minecraft, framebuffer, bl, n2, n);
            return;
        }
        catch (Throwable throwable) {
            Util3.handleThrowable(throwable);
            Util3.run3();
            return;
        }
        finally {
            Util3.run6();
        }
    }

    private static void run5() {
        if (int_11 != -1) {
            OpenGlHelper.glDeleteFramebuffers(int_11);
            int_11 = -1;
        }
        if (int_13 != -1) {
            OpenGlHelper.glDeleteFramebuffers(int_13);
            int_13 = -1;
        }
        if (int_9 != -1) {
            TextureUtil.deleteTexture(int_9);
            int_9 = -1;
        }
        if (int_ != -1) {
            TextureUtil.deleteTexture(int_);
            int_ = -1;
        }
        if (int_10 != -1) {
            TextureUtil.deleteTexture(int_10);
            int_10 = -1;
        }
        int_7 = 0;
        int_5 = 0;
        int_3 = 0;
        int_8 = 0;
    }

    private static int getIntForInt3(int n, int n2) {
        OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
        if (int_10 == -1 || int_3 != n || int_8 != n2) {
            if (int_10 == -1) {
                int_10 = TextureUtil.glGenTextures();
            }
            GlStateManager.bindTexture(int_10);
            Util3.handleInt(n, n2);
            int_3 = n;
            int_8 = n2;
        } else {
            GlStateManager.bindTexture(int_10);
        }
        GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, n, n2);
        return int_10;
    }

    private static int getIntForInt(int n) {
        int n2 = OpenGlHelper.glGenFramebuffers();
        if (n2 == -1) {
            return -1;
        }
        OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, n2);
        OpenGlHelper.glFramebufferTexture2D(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_COLOR_ATTACHMENT0, 3553, n, 0);
        int n3 = OpenGlHelper.glCheckFramebufferStatus(OpenGlHelper.GL_FRAMEBUFFER);
        OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
        if (n3 == OpenGlHelper.GL_FRAMEBUFFER_COMPLETE) {
            return n2;
        }
        return -1;
    }

    private Util3() {
    }

    private static int getIntForInt2(int n, int n2) {
        int n3 = TextureUtil.glGenTextures();
        GlStateManager.bindTexture(n3);
        Util3.handleInt(n, n2);
        return n3;
    }

    private static void handleMinecraft(Minecraft minecraft, Framebuffer framebuffer, boolean bl, int n, int n2) {
        OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
        if (bl) {
            framebuffer.bindFramebuffer(true);
            return;
        }
        GlStateManager.viewport(0, 0, n, n2);
    }

    private static void run2() {
        Cls.run2();
        GlStateManager.matrixMode(5889);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.resetColor();
    }

    private static void handleInt(int n, int n2) {
        GL11.glTexImage2D(3553, 0, 32856, n, n2, 0, 6408, 5121, (ByteBuffer)null);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10242, 33071);
        GL11.glTexParameteri(3553, 10243, 33071);
    }

    private static void run6() {
        if (!bool5) {
            return;
        }
        bool5 = false;
        GL11.glDisable(3089);
    }

    public static void run() {
        if (Util3.isEnabled()) {
            bool2 = true;
        }
    }

    public static void handleInt7(int n, int n2, int n3, int n4) {
        if (n3 <= 0 || n4 <= 0) {
            return;
        }
        if (bool4) {
            int_4 = Math.min(int_4, n);
            int_12 = Math.min(int_12, n2);
            int_2 = Math.max(int_2, n + n3);
            int_6 = Math.max(int_6, n2 + n4);
            return;
        }
        int_4 = n;
        int_12 = n2;
        int_2 = n + n3;
        int_6 = n2 + n4;
        bool4 = true;
    }

    private static void handleInt2(int n) {
        OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, n);
        GlStateManager.clearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.clear(16384);
        OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
    }

    private static void handleThrowable(Throwable throwable) {
        bool3 = false;
        try {
            Util3.run5();
        }
        catch (Throwable throwable2) {}
        OnyxClient.LOGGER.warn("Frosted glass unavailable, falling back to an opaque panel", throwable);
    }

    private static void handleInt5(int n, int n2, int n3, int n4, float f, float f2) {
        OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, n2);
        GlStateManager.bindTexture(n);
        cls.run3();
        cls.handleString5("Sampler0", 0);
        cls.handleString2("uResolution", n3, n4);
        cls.handleString2("uBlurDir", f, f2);
        cls.handleString("uRadius", f == 0.0f && f2 == 0.0f ? 0.0f : 8.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex2f(0.0f, 0.0f);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex2f(1.0f, 0.0f);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex2f(1.0f, 1.0f);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex2f(0.0f, 1.0f);
        GL11.glEnd();
    }

    public static boolean isEnabled() {
        return bool3 && OpenGlHelper.framebufferSupported;
    }

    private static void handleInt6(int n, int n2) {
        GlStateManager.matrixMode(5889);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GL11.glOrtho(0.0, 1.0, 0.0, 1.0, -1.0, 1.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.viewport(0, 0, n, n2);
    }

    public static void run4() {
        if (!Util3.isEnabled()) {
            return;
        }
        bool2 = true;
        bool = true;
    }

    public static int getInt() {
        if (Util3.isEnabled()) {
            return int_9;
        }
        return -1;
    }

    private static void run3() {
        try {
            Minecraft minecraft;
            boolean bl;
            Minecraft minecraft2 = Minecraft.getMinecraft();
            Framebuffer framebuffer = minecraft2.getFramebuffer();
            if (OpenGlHelper.isFramebufferEnabled() && minecraft2.getFramebuffer() != null) {
                bl = true;
                minecraft = minecraft2;
            } else {
                bl = false;
                minecraft = minecraft2;
            }
            Util3.handleMinecraft(minecraft2, framebuffer, bl, minecraft.displayWidth, minecraft2.displayHeight);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    private static void handleInt4(int n, int n2, int n3, int n4) {
        int n5 = bool4 && !bool ? 1 : 0;
        int n6 = int_4;
        int n7 = int_12;
        int n8 = int_2;
        int n9 = int_6;
        bool4 = false;
        bool = false;
        if (n5 == 0) {
            return;
        }
        float f = (float)n / (float)n3;
        float f2 = (float)n2 / (float)n4;
        n5 = 32 + Math.round(64.0f * Math.max(f, f2));
        n6 = Math.clamp((long)((int)Math.floor((float)n6 * f) - n5), 0, n);
        n7 = Math.clamp((long)((int)Math.floor((float)n7 * f2) - n5), 0, n2);
        int n10 = Math.clamp((long)((int)Math.ceil((float)n8 * f) + n5), n6, n);
        n2 = Math.clamp((long)((int)Math.ceil((float)n9 * f2) + n5), n7, n2);
        if (n10 <= n6 || n2 <= n7) {
            return;
        }
        GL11.glEnable(3089);
        int n11 = n10 - n6;
        GL11.glScissor(n6, n7, n11, n2 - n7);
        bool5 = true;
    }

    private static void handleInt3(int n, int n2) {
        if (int_11 != -1 && int_7 == n && int_5 == n2) {
            return;
        }
        Util3.run5();
        int_9 = Util3.getIntForInt2(n, n2);
        int_ = Util3.getIntForInt2(n, n2);
        int_11 = Util3.getIntForInt(int_9);
        int_13 = Util3.getIntForInt(int_);
        if (int_11 == -1 || int_13 == -1) {
            throw new IllegalStateException("could not create blur render targets");
        }
        int_7 = n;
        int_5 = n2;
        Util3.handleInt2(int_11);
        Util3.handleInt2(int_13);
    }

    static {
        int_9 = -1;
        int_11 = -1;
        int_ = -1;
        int_13 = -1;
        int_10 = -1;
        bool3 = true;
    }
}

