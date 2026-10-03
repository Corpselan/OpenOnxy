/*
 * Decompiled with CFR 0.0.9 (FabricMC cc05e23f).
 */
package client.onyx.render.hud;

import client.onyx.OnyxClient;
import client.onyx.module.hud.CustomGuiModule;
import client.onyx.module.render.NoRenderModule;
import client.onyx.render.Sampler0;
import client.onyx.render.hud.Boss;
import client.onyx.render.hud.Cls2;
import client.onyx.render.hud.Cls3;
import client.onyx.render.hud.Cls4;
import client.onyx.render.hud.Subtitle;
import client.onyx.render.hud.Util4;
import client.onyx.setting.impl.ValueSettingSub9;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;

public final class Util5 {
    private static Cls3 cls3;
    private static float float_;
    private static Cls4 cls4;
    private static Boss boss;
    private static Subtitle subtitle;
    private static Cls2 cls2;

    public static float getFloat() {
        return float_;
    }

    private static CustomGuiModule getCustomGuiModule() {
        CustomGuiModule customGuiModule = Util4.getCustomGuiModule();
        if (customGuiModule == null) {
            return null;
        }
        if (cls2 == null) {
            cls2 = new Cls2(customGuiModule);
            subtitle = new Subtitle(customGuiModule);
            boss = new Boss(customGuiModule);
            cls4 = new Cls4(customGuiModule);
            cls3 = new Cls3(customGuiModule);
        }
        return customGuiModule;
    }

    public static boolean isEnabled() {
        CustomGuiModule customGuiModule = Util5.getCustomGuiModule();
        Minecraft minecraft = Minecraft.getMinecraft();
        return customGuiModule != null && customGuiModule.isEnabled55() && minecraft.thePlayer != null && minecraft.theWorld != null;
    }

    private Util5() {
    }

    public static void handleSampler0(Sampler0 sampler0, float f, float f2) {
        float f3;
        CustomGuiModule customGuiModule;
        ValueSettingSub9 valueSettingSub9;
        CustomGuiModule customGuiModule2;
        ValueSettingSub9 valueSettingSub92;
        CustomGuiModule customGuiModule3 = Util5.getCustomGuiModule();
        if (customGuiModule3 == null) {
            return;
        }
        Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft.thePlayer == null || minecraft.theWorld == null) {
            return;
        }
        float f4 = Util4.getFloat();
        boolean bl = minecraft.currentScreen instanceof GuiChat;
        NoRenderModule noRenderModule = OnyxClient.cls.noRenderModule;
        if (customGuiModule3.bossbarBooleanSetting.isEnabled5() && !noRenderModule.isValueSettingSub9(valueSettingSub92 = noRenderModule.valueSettingSub94)) {
            boss.handleSampler05(sampler0, f, f2, bl);
            customGuiModule2 = customGuiModule3;
        } else {
            boss.run74();
            customGuiModule2 = customGuiModule3;
        }
        if (customGuiModule2.scoreboardBooleanSetting.isEnabled5() && !noRenderModule.isValueSettingSub9(valueSettingSub9 = noRenderModule.valueSettingSub96)) {
            cls2.handleSampler05(sampler0, f, f2, bl);
            customGuiModule = customGuiModule3;
        } else {
            cls2.run74();
            customGuiModule = customGuiModule3;
        }
        if (customGuiModule.titleBooleanSetting.isEnabled5()) {
            subtitle.handleSampler05(sampler0, f, f2, bl);
            f3 = f2;
        } else {
            subtitle.run74();
            f3 = f2;
        }
        float f5 = f3;
        float f6 = f / 2.0f - 103.0f;
        float f7 = f / 2.0f + 103.0f;
        if (cls4.isEnabled()) {
            cls4.handleSampler0(sampler0, f, f2, f4);
            f5 = cls4.getFloat4();
            f6 = cls4.getFloat();
            f7 = cls4.getFloat2();
        }
        f = f5;
        if (cls3.isEnabled()) {
            cls3.handleSampler0(sampler0, f6, f7, f5, f4);
            if (Float.isFinite(cls3.getFloat2())) {
                f = Math.min(f, cls3.getFloat2());
            }
        }
        float_ = f;
    }

    static {
        float_ = Float.NaN;
    }

    public static void run() {
        if (cls2 == null) {
            return;
        }
        cls2.run74();
        subtitle.run74();
        boss.run74();
        cls4.run();
        cls3.run();
        float_ = Float.NaN;
    }
}

