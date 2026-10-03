package client.onyx.module.hud;

import client.onyx.OnyxClient;
import client.onyx.event.impl.EventSub14;
import client.onyx.event.impl.IncomingOutgoingEnum;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.combat.BedBreakerModule;
import client.onyx.module.player.DelayModule;
import client.onyx.nowplaying.NowPlayingManager;
import client.onyx.render.PixelsSmoothEnum;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.guide.Util3;
import client.onyx.render.misc.Cls2;
import client.onyx.render.misc.Util;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub8;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import client.onyx.theme.Util5;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

public final class WatermarkModule extends Module {
   public ValueSettingSub9 Wa;
   private static final float sa = 9.0F;
   private static final float na = 6.0F;
   private static final float Za = 2.0F;
   private static final int Xa = 256;
   private Util3.XYRecord ya;
   public ValueSettingSub10 Sa;
   public ValueSettingSub10 Qa;
   private float wa;
   private static final float Oa = 2.5F;
   private static final float oa = 3.5F;
   private static final float ta = 2.0F;
   private final client.onyx.render.misc.Cls Va;
   private static final float ra = 8.0F;
   private static final float za = 7.0F;
   private static final float Pa = 1.0F;
   private static final float Na = 6.0F;
   private final NowPlayingManager Ra;
   private float ka;
   private final Singleplayer ea;
   private static final float Aa = 3.0F;
   private static final float Ca = 6.0F;
   private static final float Ba = 0.94F;
   private final Cls2 aa;
   private static final float Ea = 5.0F;
   private final client.onyx.render.misc.Cls La;
   private float Ma;
   private final client.onyx.render.misc.Cls ba;
   private boolean Ia;
   private static final int Fa = 3;
   private static final String Ja = "watermark";
   private float ja;
   private static final float ma = 11.0F;
   private static final float da = 0.5F;
   public ValueSettingSub10 fa;
   private WatermarkModule.NamePositiveRecord Ka;
   private final client.onyx.gui.Cls ha;
   public ValueSettingSub10 Ha;
   private WatermarkModule.TitleArtistRecord ia;
   private static final float Da = 16.695652F;
   private final client.onyx.render.misc.Cls la;
   private static final float Ga = 12.0F;
   private long ga;
   private final client.onyx.render.misc.Cls ca;
   private boolean bool2;
   private static final float FLOAT = 22.0F;
   private WatermarkModule.LabelValueRecord labelValueRecord;
   private static final float FLOAT2 = 12.0F;
   private static final int INT = 184;
   private String string3;
   private String string4;
   private static final float FLOAT3 = 8.0F;
   private static final float FLOAT4 = 22.0F;
   public ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Scale", 1.0, 0.5, 2.0, 0.05).getValueSettingSub10("x").getBooleanSetting("Island size");
   public ValueSettingSub9 valueSettingSub9;
   private float float_;
   private static final float FLOAT5 = 10.0F;
   private static final float FLOAT6 = 6.0F;
   private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("onyx", "textures/gui/logo.png");
   private static final float FLOAT7 = 12.0F;
   private static final float FLOAT8 = 6.0F;
   private static final float FLOAT9 = 90.0F;
   private static final int INT2 = 3;
   public ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Module toggles", true).getBooleanSetting("Announce modules turning on and off");
   private float float_2;
   private static final float FLOAT10 = 3.0F;
   private float float_3;
   private float float_4;
   private final Cls2 cls2;
   private static final float FLOAT11 = 10.0F;
   private static final float FLOAT12 = 5.0F;
   private float float_5;
   private static final float FLOAT13 = 30.0F;
   private static final float FLOAT14 = 5.0F;
   public ValueSettingSub8<WatermarkModule.FpsUsernameEnum> valueSettingSub8;
   public ValueSettingSub10 valueSettingSub102;
   private boolean bool3;
   private boolean bool4;
   private float float_6;
   private static final float FLOAT15 = 0.007F;
   private final client.onyx.render.guide.Cls cls;
   private static final WatermarkModule.KindTextRecord KIND_TEXT_RECORD2 = getKindTextRecordForIdleToggleEnum(
      WatermarkModule.IdleToggleEnum.IDLE, "onyx", "", true
   );
   private final client.onyx.render.misc.Cls cls3;
   private static final float FLOAT16 = 100.0F;
   private String string5;
   private int int_;
   private WatermarkModule.KindTextRecord kindTextRecord;
   private static final float FLOAT17 = 2.0F;
   private static final float FLOAT18 = 54.0F;
   private static final WatermarkModule.KindTextRecord KIND_TEXT_RECORD = getKindTextRecordForIdleToggleEnum(
      WatermarkModule.IdleToggleEnum.TOGGLE, "Drag to move", "", true
   );
   private static final float FLOAT19 = 4.5F;
   private final client.onyx.render.misc.Cls cls4;
   private final Cls2 cls22;
   private WatermarkModule.KindTextRecord kindTextRecord2;
   public ValueSettingSub10 valueSettingSub103;
   private final Set<Module> set;

   private void handleSampler028(Sampler0 var1, PrimaryOnPrimaryRecord var2, float var3, float var4, float var5) {
      var3 += 2.0F;
      float var8;
      float var10001 = var8 = var4 - 7.0F - 2.0F;
      var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD8, this.kindTextRecord2.badge(), var3, 11.0F, var2.onSurfaceVariant());
      var1.handleFloat10(this.Va.getFloat());
      var1.run36();
      var1.handleFloat11(0.0F, (1.0F - this.Va.getFloat()) * 5.0F * this.Ma);
      var1.handleOpticalWeightRecord6(Util2.OPTICAL_WEIGHT_RECORD9, this.kindTextRecord2.text(), var8, 11.0F, this.aa.getInt());
      var1.run43();
      var1.run40();
      var4 = var10001 - var3;
      var5 = var5 - 8.0F - 3.0F;
      float var6 = var4 * this.ca.getFloat();
      var1.handleFloat7(var3, var5, var4, 3.0F, Float.MAX_VALUE, var2.surfaceContainerHighest());
      if (var6 > 0.5F) {
         var1.handleFloat7(var3, var5, var6, 3.0F, Float.MAX_VALUE, this.cls22.getInt());
      }
   }

   private void handleSampler032(Sampler0 var1, PrimaryOnPrimaryRecord var2, float var3, float var4) {
      float var5 = var4 - 6.0F;
      float var6;
      float var10000 = var6 = var3 * this.kindTextRecord2.progress();
      var1.handleFloat24(0.0F, var5, var3, 6.0F);
      var1.handleFloat18(0.0F, 0.0F, var3, var4, Float.MAX_VALUE, 2.5F, var2.surfaceContainerHighest());
      var1.run38();
      if (!(var10000 <= 0.5F)) {
         var1.handleFloat24(0.0F, var5, var6, 6.0F);
         var1.handleFloat18(0.0F, 0.0F, var3, var4, Float.MAX_VALUE, 2.5F, var2.primary());
         var1.run38();
      }
   }

   public Singleplayer getSingleplayer() {
      return this.ea;
   }

   private void handleSampler026(Sampler0 var1, float var2, WatermarkModule.KindTextRecord var3) {
      this.cls3.getCls2(Math.max(22.0F, this.getFloat73(var1, var3)), 200.0F, Util.IFACE2);
      this.cls4.getCls2(var3.kind() == WatermarkModule.IdleToggleEnum.GAUGE ? 30.0F : 22.0F, 200.0F, Util.IFACE2);
      this.cls3.handleFloat(var2);
      this.cls4.handleFloat(var2);
   }

   private boolean isEnabled81() {
      return this.la.getFloat2() <= 0.0F;
   }

   private void handlePrimaryOnPrimaryRecord(PrimaryOnPrimaryRecord var1, float var2) {
      this.cls2.getCls22(var1.outlineVariant(), 400.0F, Util.IFACE2);
      this.cls2.handleFloat(var2);
      boolean var4 = this.labelValueRecord != null && this.labelValueRecord.alert();
      this.aa.getCls22(var4 ? var1.error() : var1.onSurface(), 250.0F, Util.IFACE2);
      this.aa.handleFloat(var2);
      this.cls22.getCls22(var4 ? var1.error() : var1.primary(), 250.0F, Util.IFACE2);
      this.cls22.handleFloat(var2);
   }

   public client.onyx.nowplaying.TitleArtistRecord getTitleArtistRecord2() {
      return this.ia == null ? null : this.Ra.getTitleArtistRecord();
   }

   private void handleSampler030(Sampler0 var1, PrimaryOnPrimaryRecord var2, int var3, float var4) {
      float var5 = var4 / 2.0F;
      float var9 = Math.min(16.695652F, var4 - 9.0F);
      float var7 = 7.0F + (16.695652F - var9) / 2.0F;
      float var8 = var5 - var9 / 2.0F;
      if (this.kindTextRecord2.art() != null) {
         var1.handleResourceLocation4(this.kindTextRecord2.art(), var7, var8, var9, var9, 0.0F, 0.0F, 1.0F, 1.0F, 1, 1, -1, PixelsSmoothEnum.MINIFIED);
         var1.handleFloat27(var7, var8, var9, var9, 3.5F, var3);
      } else {
         var1.handleString6("\ue405", 15.347826F, var5, 12.0F, var2.onSurfaceVariant());
      }

      float var11 = 29.695652F;
      String var12 = var1.getString17(Util2.OPTICAL_WEIGHT_RECORD9, this.string5, 90.0F);
      this.handleSampler029(var1, var2, var11, var5, var12, var4);
      float var10 = var11 + var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var12) + 6.0F;
      this.handleSampler031(var1, var2, var10, var5);
   }

   private void handleFloat68(float var1) {
      this.la.handleFloat(var1);
      if (isKindTextRecord(this.kindTextRecord, this.kindTextRecord2)) {
         this.kindTextRecord2 = this.kindTextRecord;
         if (this.la.getFloat2() < 1.0F) {
            this.la.getCls2(1.0F, 200.0F, Util.IFACE4);
         }
      } else if (this.La.getFloat() <= 0.0F) {
         this.kindTextRecord2 = this.kindTextRecord;
         this.la.getCls(1.0F);
      } else if (this.la.getFloat2() > 0.0F) {
         this.la.getCls2(0.0F, 50.0F, Util.IFACE);
      } else {
         if (this.la.isEnabled()) {
            this.kindTextRecord2 = this.kindTextRecord;
            this.la.getCls(0.0F).getCls2(1.0F, 200.0F, Util.IFACE4);
            if (this.kindTextRecord2.kind() == WatermarkModule.IdleToggleEnum.TOGGLE && !this.kindTextRecord2.badge().isEmpty()) {
               boolean var3 = this.kindTextRecord2.positive();
               this.handleBool19(var3);
            }
         }
      }
   }

   private void handleBool18(boolean var1, float var2) {
      if (var1) {
         this.kindTextRecord = KIND_TEXT_RECORD;
      } else {
         if (this.Ka != null) {
            this.float_4 -= var2;
            if (this.float_4 > 0.0F) {
               WatermarkModule.IdleToggleEnum var10000 = WatermarkModule.IdleToggleEnum.TOGGLE;
               String var10002 = this.Ka.name();
               String var10003;
               WatermarkModule var10004;
               if (this.Ka.positive()) {
                  var10003 = "ON";
                  var10004 = this;
               } else {
                  var10003 = "OFF";
                  var10004 = this;
               }

               this.kindTextRecord = getKindTextRecordForIdleToggleEnum(var10000, var10002, var10003, var10004.Ka.positive());
               return;
            }

            this.Ka = null;
         }

         if (this.labelValueRecord != null) {
            this.kindTextRecord = getKindTextRecordForIdleToggleEnum(
               WatermarkModule.IdleToggleEnum.GAUGE, this.labelValueRecord.value(), this.labelValueRecord.label(), !this.labelValueRecord.alert()
            );
         } else if (this.ia != null) {
            this.kindTextRecord = new WatermarkModule.KindTextRecord(
               WatermarkModule.IdleToggleEnum.MUSIC, this.ia.title(), this.ia.artist(), true, this.ia.art(), this.ia.progress(), this.ia.playing()
            );
         } else {
            this.kindTextRecord = KIND_TEXT_RECORD2;
         }
      }
   }

   private static WatermarkModule.KindTextRecord getKindTextRecordForIdleToggleEnum(WatermarkModule.IdleToggleEnum var0, String var1, String var2, boolean var3) {
      return new WatermarkModule.KindTextRecord(var0, var1, var2, var3, null, 0.0F, false);
   }

   @Override
   protected void run80() {
      this.bool2 = this.Ia = false;
      this.ga = 0L;
   }

   @Override
   protected void run79() {
      this.ea.run105();
      this.Ia = true;
      this.bool3 = false;
      this.Ka = null;
      this.float_4 = 0.0F;
      this.labelValueRecord = null;
      this.string3 = null;
      this.float_3 = 0.0F;
      this.int_ = 0;
      this.set.clear();
      this.kindTextRecord2 = KIND_TEXT_RECORD2;
      this.kindTextRecord = KIND_TEXT_RECORD2;
      this.la.getCls(1.0F);
      this.ia = null;
      this.string5 = "";
      this.string4 = "";
      this.ba.getCls(1.0F);
      this.Ra.run13();
   }

   @EventHandler
   private void handleEventSub143(EventSub14 var1) {
      if (var1.getIncomingOutgoingEnum() == IncomingOutgoingEnum.INCOMING) {
         this.ea.handlePacket(var1.getPacket());
      }
   }

   private void run114() {
      boolean var2 = this.isEnabled55() && this.Wa.isEnabled17() && this.Ra.isEnabled23();
      if (!var2) {
         this.Ra.run13();
         this.ia = null;
      } else {
         this.Ra.run14();
         client.onyx.nowplaying.TitleArtistRecord var3;
         if ((var3 = this.Ra.getTitleArtistRecord()) != null && var3.title() != null && !var3.title().isEmpty()) {
            this.ia = new WatermarkModule.TitleArtistRecord(var3.title(), var3.artist(), var3.art(), var3.getFloat(), var3.playing());
         } else {
            this.ia = null;
         }
      }
   }

   public void handleSampler025(Sampler0 var1, float var2, float var3) {
      float var14 = this.getFloat72();
      boolean var5 = this.isEnabled55() && MINECRAFT.currentScreen instanceof GuiChat;
      this.float_ = (this.float_ + var14) % 100000.0F;
      this.run115();
      this.handleFloat69(var14);
      this.run114();
      this.handleBool18(var5, var14);
      this.handleFloat68(var14);
      this.handleFloat70(var14);
      client.onyx.render.misc.Cls var10000 = this.La;
      float var10001;
      WatermarkModule var10002;
      if (this.isEnabled55()) {
         var10001 = 1.0F;
         var10002 = this;
      } else {
         var10001 = 0.0F;
         var10002 = this;
      }

      float var16;
      WatermarkModule var10003;
      if (var10002.isEnabled55()) {
         var16 = 300.0F;
         var10003 = this;
      } else {
         var16 = 200.0F;
         var10003 = this;
      }

      var10000.getCls2(var10001, var16, var10003.isEnabled55() ? Util.IFACE7 : Util.IFACE);
      this.La.handleFloat(var14);
      if (!this.isEnabled55() && this.La.isEnabled() && this.La.getFloat() <= 0.0F) {
         this.run116();
         this.bool4 = this.isEnabled83();
      } else {
         Util14.run();
         PrimaryOnPrimaryRecord var6 = Util4.getPrimaryOnPrimaryRecord();
         this.handlePrimaryOnPrimaryRecord(var6, var14);
         WatermarkModule.KindTextRecord var7 = this.isEnabled81() ? this.kindTextRecord2 : this.kindTextRecord;
         this.handleSampler026(var1, var14, var7);
         float var15 = this.valueSettingSub10.getFloat5() * (0.94F + 0.060000002F * this.La.getFloat());
         float var8 = 36.695652F + this.cls3.getFloat();
         float var9 = this.cls4.getFloat();
         this.ja = var8 * var15;
         this.float_5 = var9 * var15;
         float var10 = var2 - this.ja - 20.0F;
         float var11 = var3 - this.float_5 - 20.0F;
         this.float_2 = 10.0F + getFloatForValueSettingSub105(this.valueSettingSub102, var10);
         this.ka = 10.0F + getFloatForValueSettingSub105(this.Ha, var11);
         client.onyx.render.guide.Util.handleString2("watermark", this.float_2, this.ka, this.ja, this.float_5);
         boolean var12 = this.isBool6(var5, var10, var11, var2, var3);
         if (var5 && var12 && !this.bool3) {
            float[] var13;
            if ((var13 = this.cls.getFloatArray(true))[0] != 0.0F || var13[1] != 0.0F) {
               handleValueSettingSub105(this.valueSettingSub102, getFloatForValueSettingSub105(this.valueSettingSub102, var10) + var13[0], var10);
               handleValueSettingSub105(this.Ha, getFloatForValueSettingSub105(this.Ha, var11) + var13[1], var11);
            }
         } else {
            this.cls.getFloatArray(false);
         }

         this.float_2 = 10.0F + getFloatForValueSettingSub105(this.valueSettingSub102, var10);
         this.ka = 10.0F + getFloatForValueSettingSub105(this.Ha, var11);
         boolean var17;
         if (var5 && var12) {
            var17 = true;
            var10003 = this;
         } else {
            var17 = false;
            var10003 = this;
         }

         this.ha.handleFloat(var14, var17, var10003.bool3);
         if (this.bool3) {
            Util3.handleSampler02(var1, var2, var3, this.ya);
         }

         var1.handleFloat10(this.La.getFloat());
         var1.run36();
         var1.handleFloat11(this.float_2, this.ka + (1.0F - this.La.getFloat()) * 5.0F);
         var1.handleFloat12(var15, 0.0F, 0.0F);
         this.handleSampler024(var1, var6, var8, var9);
         var1.run43();
         var1.run40();
      }
   }

   private boolean isEnabled83() {
      return Mouse.isButtonDown(0);
   }

   private void handleSampler029(Sampler0 var1, PrimaryOnPrimaryRecord var2, float var3, float var4, String var5, float var6) {
      float var8;
      if ((var8 = this.ba.getFloat()) >= 0.999F) {
         var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, var5, var3, var4, var2.onSurface());
      } else {
         var1.handleFloat24(var3, 0.0F, 102.0F, var6);
         if (!this.string4.isEmpty()) {
            String var9 = var1.getString17(Util2.OPTICAL_WEIGHT_RECORD9, this.string4, 90.0F);
            var1.handleFloat10(1.0F - var8);
            var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, var9, var3 - 12.0F * var8, var4, var2.onSurface());
            var1.run40();
         }

         var1.handleFloat10(var8);
         var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, var5, var3 + 12.0F * (1.0F - var8), var4, var2.onSurface());
         var1.run40();
         var1.run38();
      }
   }

   private void handleFloat70(float var1) {
      if (this.kindTextRecord2.kind() != WatermarkModule.IdleToggleEnum.MUSIC) {
         this.string5 = this.kindTextRecord2.text();
         this.ba.getCls(1.0F);
      } else {
         if (!this.kindTextRecord2.text().equals(this.string5)) {
            this.string4 = this.string5;
            this.string5 = this.kindTextRecord2.text();
            this.ba.getCls(0.0F).getCls2(1.0F, 250.0F, Util.IFACE7);
         }

         this.ba.handleFloat(var1);
      }
   }

   private void handleSampler024(Sampler0 var1, PrimaryOnPrimaryRecord var2, float var3, float var4) {
      int var5 = Util5.getIntForInt(3, var2);
      var1.handleFloat25(0.0F, 0.0F, var3, var4, Float.MAX_VALUE, 3);
      Util14.handleSampler0(var1, 0.0F, 0.0F, var3, var4, Float.MAX_VALUE, var5);
      boolean var6 = this.kindTextRecord2.kind() == WatermarkModule.IdleToggleEnum.MUSIC;
      if (!var6) {
         var1.handleResourceLocation4(
            RESOURCE_LOCATION, 7.0F, (var4 - 12.0F) / 2.0F, 16.695652F, 12.0F, 0.0F, 0.0F, 256.0F, 184.0F, 256, 184, var2.primary(), PixelsSmoothEnum.MINIFIED
         );
      }

      var1.handleFloat10(this.la.getFloat());
      var1.run36();
      var1.handleFloat11(0.0F, (1.0F - this.la.getFloat()) * 6.0F);
      var1.handleFloat24(0.0F, 0.0F, var3, var4);
      Sampler0 var10000;
      if (var6) {
         var10000 = var1;
         this.handleSampler030(var1, var2, var5, var4);
      } else {
         float var7 = 29.695652F;
         switch (this.kindTextRecord2.kind()) {
            case IDLE:
               var10000 = var1;


               var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, this.kindTextRecord2.text(), var7, var4 / 2.0F, var2.onSurface());
               break;
            case MUSIC:
               this.handleSampler027(var1, var2, var7, var4 / 2.0F);
               var10000 = var1;
               break;
            case GAUGE:
               this.handleSampler028(var1, var2, var7, var3, var4);
               var10000 = var1;
               break;
            case TOGGLE:
            default:
               var10000 = var1;
         }
      }

      var10000.run38();
      var1.run43();
      var1.run40();
      this.ha.handleSampler0(var1, 0.0F, 0.0F, var3, var4, Float.MAX_VALUE, var2.onSurface());
      var1.handleFloat18(0.0F, 0.0F, var3, var4, Float.MAX_VALUE, 1.0F, this.cls2.getInt());
      if (var6) {
         this.handleSampler032(var1, var2, var3, var4);
      }
   }

   private float getFloat72() {
      long var1 = System.nanoTime();
      float var4 = this.ga == 0L ? 16.0F : Math.min((float)(var1 - this.ga) / 1000000.0F, 100.0F);
      this.ga = var1;
      return var4;
   }

   private void run116() {
      this.Ia = false;
      this.ga = 0L;
      this.ja = 0.0F;
      this.float_5 = 0.0F;
      client.onyx.render.guide.Util.handleString("watermark");
   }

   private static float getFloatForSampler0(Sampler0 var0, String var1) {
      return 10.0F + var0.getFloat17(Util2.OPTICAL_WEIGHT_RECORD8, var1);
   }

   private boolean isBool6(boolean var1, float var2, float var3, float var4, float var5) {
      float var6 = Minecraft.getScaledMouseX() * var4 / MINECRAFT.displayWidth;
      float var14 = Minecraft.getScaledMouseY() * var5 / MINECRAFT.displayHeight;
      float var10 = var5 - var14 - 1.0F;
      boolean var8 = this.isEnabled83();
      boolean var9 = this.isDouble6(var6, var10);
      WatermarkModule var10000;
      if (var1 && var8) {
         if (!this.bool4 && var9) {
            this.bool3 = true;
            this.float_6 = var6 - this.float_2;
            this.wa = var10 - this.ka;
         }

         var10000 = this;
      } else {
         var10000 = this;
         this.bool3 = false;
         this.ya = Util3.X_Y_RECORD;
      }

      var10000.bool4 = var8;
      if (this.bool3) {
         this.ya = Util3.getXYRecordForFloat2(
            var6 - this.float_6, var10 - this.wa, this.ja, this.float_5, var4, var5, 10.0F, client.onyx.render.guide.Util.getListForString("watermark")
         );
         handleValueSettingSub105(this.valueSettingSub102, this.ya.x() - 10.0F, var2);
         handleValueSettingSub105(this.Ha, this.ya.y() - 10.0F, var3);
      }

      return var9;
   }

   private float getFloat73(Sampler0 var1, WatermarkModule.KindTextRecord var2) {
      switch (var2.kind()) {
         case IDLE:

            return var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var2.text());
         case MUSIC:
            float var3 = Math.min(var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var2.text()), 90.0F);
            if (var2.badge().isEmpty()) {
               return var3;
            }

            return var3 + 6.0F + getFloatForSampler0(var1, var2.badge());
         case GAUGE:
            return Math.max(
                  54.0F, var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD8, var2.badge()) + 8.0F + var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var2.text())
               )
               + 4.0F;
         case TOGGLE:
            return Math.min(var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var2.text()), 90.0F) + 6.0F + 10.0F;
         default:
            throw new MatchException(null, null);
      }
   }

   private void handleSampler031(Sampler0 var1, PrimaryOnPrimaryRecord var2, float var3, float var4) {
      int var5;
      for (int var10000 = var5 = 0; var10000 < 3; var10000 = var5) {
         float var8 = var5 * 2.1F;
         float var7 = this.kindTextRecord2.playing() ? 0.5F + 0.5F * (float)Math.sin(this.float_ * 0.007F + var8) : 0.1F;
         var8 = 3.0F + 6.0F * var7;
         var1.handleFloat7(var3, var4 - var8 / 2.0F, 2.0F, var8, Float.MAX_VALUE, var2.primary());
         var5++;
         var3 += 4.0F;
      }
   }

   public boolean isDouble6(double var1, double var3) {
      return var1 >= this.float_2 && var1 < this.float_2 + this.ja && var3 >= this.ka && var3 < this.ka + this.float_5;
   }

   private static float getFloatForValueSettingSub105(ValueSettingSub10 var0, float var1) {
      return var1 <= 0.0F ? 0.0F : (float)(var1 * var0.lambda15() / 100.0);
   }

   private static boolean isKindTextRecord(WatermarkModule.KindTextRecord var0, WatermarkModule.KindTextRecord var1) {
      return var0.equals(var1)
         || var0.kind() == WatermarkModule.IdleToggleEnum.GAUGE && var1.kind() == WatermarkModule.IdleToggleEnum.GAUGE
         || var0.kind() == WatermarkModule.IdleToggleEnum.MUSIC && var1.kind() == WatermarkModule.IdleToggleEnum.MUSIC;
   }

   private WatermarkModule.LabelValueRecord getLabelValueRecord2() {
      BedBreakerModule var10 = OnyxClient.cls.bedBreakerModule;
      if (!OnyxClient.cls.bedBreakerModule.isEnabled55()) {
         return null;
      } else {
         BlockPos var11;
         if ((var11 = var10.getBlockPos3()) != null && MINECRAFT.theWorld != null) {
            float var2;
            int var3 = Math.round((var2 = Math.clamp(MINECRAFT.playerController.getCurBlockDamage(), 0.0F, 1.0F)) * 100.0F);
            String var12 = MINECRAFT.theWorld.getBlockState(var11).getBlock().getLocalizedName();
            String var8 = var3 + "%";
            return new WatermarkModule.LabelValueRecord(var12, var8, var2, (float)var3, false);
         } else {
            return new WatermarkModule.LabelValueRecord("Bed", "Idle", 0.0F, 0.0F, false);
         }
      }
   }

   public boolean isEnabled82() {
      return MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null && (this.isEnabled55() || this.Ia);
   }

   private void handleBool19(boolean var1) {
      PrimaryOnPrimaryRecord var3 = Util4.getPrimaryOnPrimaryRecord();
      this.cls2.getCls2(var1 ? var3.primary() : var3.error());
   }

   private WatermarkModule.LabelValueRecord getLabelValueRecord() {
      DelayModule var2 = OnyxClient.cls.delayModule;
      if (this.valueSettingSub9.isEnabled17() && var2.isEnabled55()) {
         int var3;
         if ((var3 = var2.getInt48()) > this.int_) {
            this.int_ = var3;
         }

         String var10003 = String.valueOf(var3);
         float var10004;
         int var10005;
         if (this.int_ > 0) {
            var10004 = Math.clamp((float)var3 / this.int_, 0.0F, 1.0F);
            var10005 = var3;
         } else {
            var10004 = 0.0F;
            var10005 = var3;
         }

         WatermarkModule.LabelValueRecord var10000 = new WatermarkModule.LabelValueRecord("Blocks", var10003, var10004, (float)var10005, var3 <= this.fa.getInt10());
         return var10000;
      } else {
         this.int_ = 0;
         return null;
      }
   }

   public WatermarkModule() {
      super("Watermark", "Dynamic island that reacts to what the client is doing", ModuleCategory.HUD);
      this.Sa = new ValueSettingSub10("Hold", 0.5, 0.3, 5.0, 0.1)
         .getValueSettingSub10("s")
         .getBooleanSetting("How long a notification stays expanded")
         .getModeSetting(this.valueSettingSub92);
      this.valueSettingSub9 = new ValueSettingSub9("Scaffold blocks", true).getBooleanSetting("Live block counter while Scaffold runs");
      this.fa = new ValueSettingSub10("Low blocks", 32.0, 0.0, 128.0, 1.0)
         .getBooleanSetting("Count below which the number turns red")
         .getModeSetting(this.valueSettingSub9);
      WatermarkModule.FpsUsernameEnum[] var10005 = new WatermarkModule.FpsUsernameEnum[2];
      boolean var10007 = true;
      var10005[0] = WatermarkModule.FpsUsernameEnum.FPS;
      var10005[1] = WatermarkModule.FpsUsernameEnum.PING;
      this.valueSettingSub8 = new ValueSettingSub8<>("Stats", WatermarkModule.FpsUsernameEnum.class, var10005)
         .getBooleanSetting("Live client and connection readouts on their own island — drag them on the island itself (press T) to reorder");
      this.Wa = new ValueSettingSub9("Now playing", true).getBooleanSetting("Show whatever's currently playing on the system (Windows/macOS only)");
      this.valueSettingSub102 = new ValueSettingSub10("Position X", 50.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
      this.Ha = new ValueSettingSub10("Position Y", 0.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
      this.Qa = new ValueSettingSub10("Stats X", 0.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
      this.valueSettingSub103 = new ValueSettingSub10("Stats Y", 0.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
      this.ea = new Singleplayer(this);
      this.Ra = new NowPlayingManager();
      this.La = new client.onyx.render.misc.Cls(0.0F);
      this.cls3 = new client.onyx.render.misc.Cls(22.0F);
      this.cls4 = new client.onyx.render.misc.Cls(22.0F);
      this.la = new client.onyx.render.misc.Cls(1.0F);
      this.Va = new client.onyx.render.misc.Cls(1.0F);
      this.ca = new client.onyx.render.misc.Cls(1.0F);
      this.ba = new client.onyx.render.misc.Cls(1.0F);
      this.cls2 = new Cls2(Util4.getPrimaryOnPrimaryRecord().outlineVariant());
      this.aa = new Cls2(Util4.getPrimaryOnPrimaryRecord().onSurface());
      this.cls22 = new Cls2(Util4.getPrimaryOnPrimaryRecord().primary());
      this.ha = new client.onyx.gui.Cls();
      this.set = Collections.newSetFromMap(new IdentityHashMap<>());
      this.kindTextRecord2 = KIND_TEXT_RECORD2;
      this.kindTextRecord = KIND_TEXT_RECORD2;
      this.Ma = 1.0F;
      this.string5 = "";
      this.string4 = "";
      this.ya = Util3.X_Y_RECORD;
      this.cls = new client.onyx.render.guide.Cls();
   }

   private void run115() {
      if (this.isEnabled55()) {
         Iterator var1 = OnyxClient.cls.getArrayList().iterator();

         label38:
         while (true) {
            Iterator var10000 = var1;

            while (var10000.hasNext()) {
               Module var4;
               if ((var4 = (Module)var1.next()) == this) {
                  continue label38;
               }

               if (var4 == OnyxClient.cls.clickGUIModule) {
                  var10000 = var1;
               } else {
                  boolean var3;
                  if ((var3 = var4.isEnabled55()) == this.set.contains(var4)) {
                     var10000 = var1;
                  } else {
                     WatermarkModule var5;
                     if (var3) {
                        this.set.add(var4);
                        var5 = this;
                     } else {
                        this.set.remove(var4);
                        var5 = this;
                     }

                     if (!var5.bool2) {
                        continue label38;
                     }

                     if (!this.valueSettingSub92.isEnabled17()) {
                        var10000 = var1;
                     } else {
                        this.Ka = new WatermarkModule.NamePositiveRecord(var4.getString20(), var3);
                        this.float_4 = this.Sa.getFloat5() * 1000.0F;
                        var10000 = var1;
                     }
                  }
               }
            }

            this.bool2 = true;
            return;
         }
      }
   }

   private void handleFloat69(float var1) {
      this.labelValueRecord = this.getLabelValueRecord();
      if (this.labelValueRecord == null) {
         WatermarkModule.LabelValueRecord var4 = this.getLabelValueRecord2();
         this.labelValueRecord = var4;
      }

      String var3 = this.labelValueRecord == null ? null : this.labelValueRecord.value();
      if (!Objects.equals(var3, this.string3) && this.Va.isEnabled()) {
         this.Ma = this.labelValueRecord != null && this.labelValueRecord.level() < this.float_3 ? -1.0F : 1.0F;
         this.Va.getCls(0.0F).getCls2(1.0F, 100.0F, Util.IFACE7);
      }

      this.string3 = var3;
      this.float_3 = this.labelValueRecord == null ? 0.0F : this.labelValueRecord.level();
      this.ca.getCls2(this.labelValueRecord == null ? 0.0F : this.labelValueRecord.fill(), 250.0F, Util.IFACE2);
      this.ca.handleFloat(var1);
      this.Va.handleFloat(var1);
   }

   private static void handleValueSettingSub105(ValueSettingSub10 var0, float var1, float var2) {
      if (!(var2 <= 0.0F)) {
         var0.handleObject2(Math.clamp(var1 / var2, 0.0F, 1.0F) * 100.0);
      }
   }

   private void handleSampler027(Sampler0 var1, PrimaryOnPrimaryRecord var2, float var3, float var4) {
      String var6 = var1.getString17(Util2.OPTICAL_WEIGHT_RECORD9, this.kindTextRecord2.text(), 90.0F);
      var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, var6, var3, var4, var2.onSurface());
      if (!this.kindTextRecord2.badge().isEmpty()) {
         var3 = var3 + var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var6) + 6.0F;
         float var8 = getFloatForSampler0(var1, this.kindTextRecord2.badge());
         var1.handleFloat7(
            var3, var4 - 6.0F, var8, 12.0F, Float.MAX_VALUE, this.kindTextRecord2.positive() ? var2.primaryContainer() : var2.surfaceContainerHighest()
         );
         var1.handleOpticalWeightRecord4(
            Util2.OPTICAL_WEIGHT_RECORD8,
            this.kindTextRecord2.badge(),
            var3 + var8 / 2.0F,
            var4,
            this.kindTextRecord2.positive() ? var2.onPrimaryContainer() : var2.onSurfaceVariant()
         );
      }
   }

   public static enum FpsUsernameEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      FPS("FPS"),
      USERNAME("Username"),
      PING("Ping"),
      PACKET_LOSS("Packet loss"),
      SERVER("Server");

      private final String string;

      @Override
      public String getString5() {
         return this.string;
      }


      private FpsUsernameEnum(String var3) {
         this.string = var3;
      }
   }

   private static enum IdleToggleEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      IDLE,
      TOGGLE,
      GAUGE,
      MUSIC;

   }

   private record KindTextRecord(
      WatermarkModule.IdleToggleEnum kind, String text, String badge, boolean positive, ResourceLocation art, float progress, boolean playing
   ) {
   }

   private record LabelValueRecord(String label, String value, float fill, float level, boolean alert) {
   }

   private record NamePositiveRecord(String name, boolean positive) {
   }

   private record TitleArtistRecord(String title, String artist, ResourceLocation art, float progress, boolean playing) {
   }
}
