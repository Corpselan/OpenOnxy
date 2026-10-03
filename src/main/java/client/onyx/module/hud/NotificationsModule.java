package client.onyx.module.hud;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.combat.BedBreakerModule;
import client.onyx.module.hud.notification.InfoSuccessEnum;
import client.onyx.module.hud.notification.TitleMessageRecord;
import client.onyx.module.player.DelayModule;
import client.onyx.nowplaying.TitleArtistRecord;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.guide.Util;
import client.onyx.render.guide.Util3;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import client.onyx.theme.Util5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.block.BlockBed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.util.BlockPos;
import org.lwjgl.input.Mouse;

public final class NotificationsModule extends Module {
   private Util3.XYRecord xYRecord;
   private static final float FLOAT = 8.0F;
   private static final float FLOAT2 = 1.0F;
   public final ValueSettingSub10 valueSettingSub10;
   private long long_;
   private static final float FLOAT3 = 34.0F;
   private float float_;
   private static final int INT = -9706613;
   public final ValueSettingSub9 valueSettingSub9;
   private final client.onyx.gui.Cls cls;
   private String string3;
   private static final float FLOAT4 = 2.0F;
   private static final String STRING = "notifications";
   private static final float FLOAT5 = 10.0F;
   private static final float FLOAT6 = 240.0F;
   private static final float FLOAT7 = 4.5F;
   private float float_2;
   public final ValueSettingSub10 valueSettingSub102 = (new ValueSettingSub10("Scale", 0.85D, 0.5D, 2.0D, 0.05D)).getValueSettingSub10("x").getBooleanSetting("Popup size");
   private final Set<Module> set;
   private static final float FLOAT8 = 10.0F;
   private static final float FLOAT9 = 130.0F;
   private BlockPos blockPos;
   private boolean bool2;
   public final ValueSettingSub10 valueSettingSub103;
   private static final float FLOAT10 = 14.0F;
   private static final float FLOAT11 = 100.0F;
   private boolean bool3;
   private float float_3;
   public final ValueSettingSub10 valueSettingSub105 = (new ValueSettingSub10("Hold", 3.0D, 0.5D, 10.0D, 0.1D)).getValueSettingSub10("s").getBooleanSetting("How long each popup stays up");
   private static final float FLOAT12 = 9.0F;
   private static final int INT2 = 3;
   public final ValueSettingSub9 valueSettingSub92;
   private static final float FLOAT13 = 5.5F;
   private float float_4;
   public final ValueSettingSub10 valueSettingSub104 = (new ValueSettingSub10("Max stack", 5.0D, 1.0D, 10.0D, 1.0D)).getBooleanSetting("How many popups can be on screen at once");
   private final client.onyx.render.guide.Cls cls2;
   private float float_5;
   private boolean bool4;
   public final ValueSettingSub9 valueSettingSub94;
   private static final float FLOAT14 = 5.0F;
   public final ValueSettingSub9 valueSettingSub95 = (new ValueSettingSub9("Module toggles", true)).getBooleanSetting("Announce modules turning on and off");
   public final ValueSettingSub9 valueSettingSub93 = (new ValueSettingSub9("Scaffold blocks", true)).getBooleanSetting("Warn when Scaffold is running low on blocks");
   public final ValueSettingSub10 valueSettingSub106;
   public final ValueSettingSub9 valueSettingSub96;
   private static final float FLOAT15 = 16.0F;
   private final List<NotificationsModule.Cls2> list2;
   private float float_6;
   private boolean bool5;

   public void handleSampler022(Sampler0 var1, float var2, float var3) {
      float var4 = this.getFloat70();
      boolean var5 = this.isEnabled55() && MINECRAFT.currentScreen instanceof GuiChat;
      this.run109();
      this.run110();
      this.handleFloat67(var4);
      ArrayList var14;
      if ((var14 = new ArrayList(this.list2)).isEmpty() && var5) {
         var14.add(this.getCls211());
      }

      PrimaryOnPrimaryRecord var7 = Util4.getPrimaryOnPrimaryRecord();
      float var8 = this.valueSettingSub102.getFloat5();
      float var9;
      this.float_3 = (var9 = this.getFloat71(var1, var14)) * var8;
      this.float_ = ((float)var14.size() * 34.0F + (float)Math.max(0, var14.size() - 1) * 5.0F) * var8;
      if (var14.isEmpty()) {
         Util.handleString("notifications");
         boolean var15 = this.isEnabled79();
         this.bool3 = var15;
      } else {
         float var10 = var2 - this.float_3 - 20.0F;
         float var11 = var3 - this.float_ - 20.0F;
         this.float_4 = 10.0F + getFloatForValueSettingSub104(this.valueSettingSub106, var10);
         this.float_5 = 10.0F + getFloatForValueSettingSub104(this.valueSettingSub103, var11);
         Util.handleString2("notifications", this.float_4, this.float_5, this.float_3, this.float_);
         boolean var12 = this.isBool5(var5, var10, var11, var2, var3);
         if (var5 && var12 && !this.bool2) {
            float[] var13;
            if ((var13 = this.cls2.getFloatArray(true))[0] != 0.0F || var13[1] != 0.0F) {
               handleValueSettingSub104(this.valueSettingSub106, getFloatForValueSettingSub104(this.valueSettingSub106, var10) + var13[0], var10);
               handleValueSettingSub104(this.valueSettingSub103, getFloatForValueSettingSub104(this.valueSettingSub103, var11) + var13[1], var11);
            }
         } else {
            this.cls2.getFloatArray(false);
         }

         this.float_4 = 10.0F + getFloatForValueSettingSub104(this.valueSettingSub106, var10);
         this.float_5 = 10.0F + getFloatForValueSettingSub104(this.valueSettingSub103, var11);
         client.onyx.gui.Cls var10000 = this.cls;
         boolean var10002;
         NotificationsModule var10003;
         if (var5 && var12) {
            var10002 = true;
            var10003 = this;
         } else {
            var10002 = false;
            var10003 = this;
         }

         var10000.handleFloat(var4, var10002, var10003.bool2);
         if (this.bool2) {
            Util3.handleSampler02(var1, var2, var3, this.xYRecord);
         }

         Util14.run();
         boolean var19 = (Double)this.valueSettingSub103.lambda15() > 50.0D;
         int var20 = 0;
         var1.run36();
         var1.handleFloat11(this.float_4, this.float_5);
         var1.handleFloat12(var8, 0.0F, 0.0F);

         for(int var16 = 0; var20 < var14.size(); var20 = var16) {
            NotificationsModule.Cls2 var17 = (NotificationsModule.Cls2)var14.get(var16);
            int var18 = var19 ? var14.size() - 1 - var16 : var16;
            float var10004 = (float)var18;
            ++var16;
            this.handleSampler023(var1, var7, var17, var10004 * 39.0F, var9);
         }

         var1.run43();
      }
   }

   public boolean isDouble5(double var1, double var3) {
      return var1 >= (double)this.float_4 && var1 < (double)(this.float_4 + this.float_3) && var3 >= (double)this.float_5 && var3 < (double)(this.float_5 + this.float_);
   }

   private float getFloat71(Sampler0 var1, List<NotificationsModule.Cls2> var2) {
      float var3 = 130.0F;

      Iterator var7;
      for(Iterator var10000 = var7 = var2.iterator(); var10000.hasNext(); var10000 = var7) {
         NotificationsModule.Cls2 var4 = (NotificationsModule.Cls2)var7.next();
         float var6 = var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var4.titleMessageRecord.title());
         if (this.valueSettingSub92.isEnabled17() && var4.titleMessageRecord.message() != null) {
            var6 = Math.max(var6, var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD13, var4.titleMessageRecord.message()));
         }

         var3 = Math.max(var3, 45.0F + var6);
      }

      return Math.min(var3, 240.0F);
   }

   private boolean isBool5(boolean var1, float var2, float var3, float var4, float var5) {
      float var6 = (float)Minecraft.getScaledMouseX() * var4 / (float)MINECRAFT.displayWidth;
      float var14 = (float)Minecraft.getScaledMouseY() * var5 / (float)MINECRAFT.displayHeight;
      float var10 = var5 - var14 - 1.0F;
      boolean var8 = this.isEnabled79();
      boolean var9 = this.isDouble5((double)var6, (double)var10);
      NotificationsModule var10000;
      if (var1 && var8) {
         if (!this.bool3 && var9) {
            this.bool2 = true;
            this.float_6 = var6 - this.float_4;
            this.float_2 = var10 - this.float_5;
         }

         var10000 = this;
      } else {
         var10000 = this;
         this.bool2 = false;
         this.xYRecord = Util3.X_Y_RECORD;
      }

      var10000.bool3 = var8;
      if (this.bool2) {
         this.xYRecord = Util3.getXYRecordForFloat2(var6 - this.float_6, var10 - this.float_2, this.float_3, this.float_, var4, var5, 10.0F, Util.getListForString("notifications"));
         handleValueSettingSub104(this.valueSettingSub106, this.xYRecord.x() - 10.0F, var2);
         handleValueSettingSub104(this.valueSettingSub103, this.xYRecord.y() - 10.0F, var3);
      }

      return var9;
   }

   private NotificationsModule.Cls2 getCls211() {
      NotificationsModule.Cls2 var10000 = new NotificationsModule.Cls2(new TitleMessageRecord("Notifications", "Drag to move", InfoSuccessEnum.INFO), this.valueSettingSub105.getFloat5() * 1000.0F);
      var10000.cls.getCls(1.0F);
      return var10000;
   }

   private void run109() {
      if (this.valueSettingSub95.isEnabled17() && OnyxClient.cls != null) {
         Iterator var1 = OnyxClient.cls.getArrayList().iterator();

         while(true) {
            label44:
            while(true) {
               Iterator var10000 = var1;

               while(var10000.hasNext()) {
                  Module var5;
                  if ((var5 = (Module)var1.next()) == this) {
                     continue label44;
                  }

                  if (var5 == OnyxClient.cls.clickGUIModule) {
                     var10000 = var1;
                  } else {
                     boolean var3 = var5.isEnabled55();
                     boolean var4 = this.set.contains(var5);
                     if (var3 != var4) {
                        NotificationsModule var6;
                        if (var3) {
                           this.set.add(var5);
                           var6 = this;
                        } else {
                           this.set.remove(var5);
                           var6 = this;
                        }

                        if (var6.bool5) {
                           String var10003 = var5.getString20();
                           String var10004;
                           boolean var10005;
                           if (var3) {
                              var10004 = "Enabled";
                              var10005 = var3;
                           } else {
                              var10004 = "Disabled";
                              var10005 = var3;
                           }

                           TitleMessageRecord var10001 = new TitleMessageRecord(var10003, var10004, var10005 ? InfoSuccessEnum.SUCCESS : InfoSuccessEnum.INFO);
                           this.handleTitleMessageRecord(var10001);
                        }
                        continue label44;
                     }

                     var10000 = var1;
                  }
               }

               this.bool5 = true;
               return;
            }
         }
      } else {
         this.set.clear();
         this.bool5 = false;
      }
   }

   private void run110() {
      if (OnyxClient.cls != null) {
         this.run108();
         this.run111();
         this.run113();
      }
   }

   private void run112() {
      this.bool4 = false;
      this.blockPos = null;
      this.string3 = "";
   }

   private static float getFloatForValueSettingSub104(ValueSettingSub10 var0, float var1) {
      return var1 <= 0.0F ? 0.0F : (float)((double)var1 * (Double)var0.lambda15() / 100.0D);
   }

   public static void handleString13(String var0, InfoSuccessEnum var1) {
      handleString14(var0, (String)null, var1);
   }

   private void run108() {
      DelayModule var3 = OnyxClient.cls.delayModule;
      if (this.valueSettingSub93.isEnabled17() && var3 != null && var3.isEnabled55()) {
         int var4;
         boolean var2 = (var4 = var3.getInt48()) <= this.valueSettingSub10.getInt10();
         if (var2 && !this.bool4) {
            String var10004;
            int var10005;
            if (var4 <= 0) {
               var10004 = "Out of blocks";
               var10005 = var4;
            } else {
               var10004 = var4 + " blocks left";
               var10005 = var4;
            }

            TitleMessageRecord var10001 = new TitleMessageRecord("Scaffold", var10004, var10005 <= 0 ? InfoSuccessEnum.ERROR : InfoSuccessEnum.WARNING);
            this.handleTitleMessageRecord(var10001);
         }

         this.bool4 = var2;
      } else {
         this.bool4 = false;
      }
   }

   private void run113() {
      WatermarkModule var2 = OnyxClient.cls.watermarkModule;
      if (this.valueSettingSub96.isEnabled17() && var2 != null) {
         TitleArtistRecord var3;
         if ((var3 = var2.getTitleArtistRecord2()) != null && var3.title() != null && !var3.title().isEmpty()) {
            if (!var3.title().equals(this.string3)) {
               this.string3 = var3.title();
               this.handleTitleMessageRecord(new TitleMessageRecord(var3.title(), var3.artist() != null && !var3.artist().isEmpty() ? var3.artist() : "Now playing", InfoSuccessEnum.INFO));
            }
         } else {
            this.string3 = "";
         }
      } else {
         this.string3 = "";
      }
   }

   public NotificationsModule() {
      super("Notifications", "Popups for module toggles and client events", ModuleCategory.HUD);
      this.valueSettingSub10 = (new ValueSettingSub10("Low blocks", 32.0D, 1.0D, 128.0D, 1.0D)).getBooleanSetting("Count at which the warning goes up").getModeSetting(this.valueSettingSub93);
      this.valueSettingSub94 = (new ValueSettingSub9("Bed breaker", true)).getBooleanSetting("Announce when BedBreaker takes a bed down");
      this.valueSettingSub96 = (new ValueSettingSub9("Now playing", true)).getBooleanSetting("Announce whatever the system starts playing");
      this.valueSettingSub9 = (new ValueSettingSub9("Progress bar", true)).getBooleanSetting("Show the time each popup has left");
      this.valueSettingSub92 = (new ValueSettingSub9("Subtitle", true)).getBooleanSetting("Show the second line of each popup");
      this.valueSettingSub106 = (new ValueSettingSub10("Position X", 82.0D, 0.0D, 100.0D, 0.01D)).getSetting2(() -> {
         return false;
      });
      this.valueSettingSub103 = (new ValueSettingSub10("Position Y", 8.0D, 0.0D, 100.0D, 0.01D)).getSetting2(() -> {
         return false;
      });
      this.list2 = new ArrayList();
      this.string3 = "";
      this.set = Collections.newSetFromMap(new IdentityHashMap());
      this.cls = new client.onyx.gui.Cls();
      this.cls2 = new client.onyx.render.guide.Cls();
      this.xYRecord = Util3.X_Y_RECORD;
   }

   private static void handleValueSettingSub104(ValueSettingSub10 var0, float var1, float var2) {
      if (!(var2 <= 0.0F)) {
         var0.handleObject2((double)Math.clamp(var1 / var2, 0.0F, 1.0F) * 100.0D);
      }
   }

   public static void handleString14(String var0, String var1, InfoSuccessEnum var2) {
      if (OnyxClient.cls != null) {
         NotificationsModule var4;
         if ((var4 = OnyxClient.cls.notificationsModule) != null && var4.isEnabled55()) {
            var4.handleTitleMessageRecord(new TitleMessageRecord(var0, var1, var2));
         }
      }
   }

   private void handleSampler023(Sampler0 var1, PrimaryOnPrimaryRecord var2, NotificationsModule.Cls2 var3, float var4, float var5) {
      float var6;
      if (!((var6 = var3.cls.getFloat()) <= 0.001F)) {
         int var7 = var3.titleMessageRecord.accent() != null ? var3.titleMessageRecord.accent() : var3.titleMessageRecord.level().getInt4(var2);
         int var8 = Util5.getIntForInt(3, var2);
         var1.handleFloat10(var6);
         var1.run36();
         var1.handleFloat11((1.0F - var6) * 14.0F, var4);
         var1.handleFloat25(0.0F, 0.0F, var5, 34.0F, 12.0F, 3);
         Util14.handleSampler0(var1, 0.0F, 0.0F, var5, 34.0F, 12.0F, var8);
         var1.handleString6(var3.titleMessageRecord.level().getString3(), 18.0F, 17.0F, 16.0F, var7);
         var4 = 35.0F;
         var6 = var5 - var4 - 10.0F;
         boolean var13 = this.valueSettingSub92.isEnabled17() && var3.titleMessageRecord.message() != null;
         String var9 = var1.getString17(Util2.OPTICAL_WEIGHT_RECORD9, var3.titleMessageRecord.title(), var6);
         NotificationsModule var10000;
         if (var13) {
            var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, var9, var4, 11.5F, var2.onSurface());
            var10000 = this;
            var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD13, var1.getString17(Util2.OPTICAL_WEIGHT_RECORD13, var3.titleMessageRecord.message(), var6), var4, 21.5F, var2.onSurfaceVariant());
         } else {
            var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, var9, var4, 17.0F, var2.onSurface());
            var10000 = this;
         }

         if (var10000.valueSettingSub9.isEnabled17() && var3.float_2 > 0.0F) {
            float var12 = Math.clamp(var3.float_ / var3.float_2, 0.0F, 1.0F);
            var1.handleFloat7(10.0F, 29.0F, (var5 - 20.0F) * var12, 2.0F, Float.MAX_VALUE, Util4.getIntForInt2(var7, 0.85F));
         }

         client.onyx.gui.Cls var10 = this.cls;
         int var11 = var2.onSurface();
         var10.handleSampler0(var1, 0.0F, 0.0F, var5, 34.0F, 12.0F, var11);
         var1.handleFloat18(0.0F, 0.0F, var5, 34.0F, 12.0F, 1.0F, var2.outlineVariant());
         var1.run43();
         var1.run40();
      }
   }

   private void run111() {
      BedBreakerModule var2 = OnyxClient.cls.bedBreakerModule;
      if (this.valueSettingSub94.isEnabled17() && var2 != null && var2.isEnabled55() && MINECRAFT.theWorld != null) {
         BlockPos var6;
         if ((var6 = var2.getBlockPos6()) != null) {
            this.blockPos = var6;
         } else {
            if (this.blockPos != null && !(MINECRAFT.theWorld.getBlockState(this.blockPos).getBlock() instanceof BlockBed)) {
               InfoSuccessEnum var3 = InfoSuccessEnum.SUCCESS;
               Integer var4 = -9706613;
               TitleMessageRecord var5 = new TitleMessageRecord("BedBreaker", "Bed broken", var3, var4);
               this.handleTitleMessageRecord(var5);
            }

            this.blockPos = null;
         }
      } else {
         this.blockPos = null;
      }
   }

   private boolean isEnabled79() {
      return Mouse.isButtonDown(0);
   }

   private float getFloat70() {
      long var1 = System.nanoTime();
      float var4 = this.long_ == 0L ? 16.0F : Math.min((float)(var1 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var1;
      return var4;
   }

   protected void run80() {
      this.bool5 = false;
      this.long_ = 0L;
   }

   public boolean isEnabled80() {
      return MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null && this.isEnabled55();
   }

   protected void run79() {
      this.list2.clear();
      this.set.clear();
      this.run112();
      this.bool5 = false;
      this.bool2 = false;
      Util.handleString("notifications");
   }

   private void handleTitleMessageRecord(TitleMessageRecord var1) {
      NotificationsModule var10000 = this;
      this.list2.add(new NotificationsModule.Cls2(var1, this.valueSettingSub105.getFloat5() * 1000.0F));

      while(var10000.list2.size() > this.valueSettingSub104.getInt10()) {
         var10000 = this;
         this.list2.remove(0);
      }

   }

   private void handleFloat67(float var1) {
      this.list2.removeIf((var1x) -> {
         var1x.float_ -= var1;
         boolean var3 = var1x.float_ <= 0.0F;
         client.onyx.render.misc.Cls var10000 = var1x.cls;
         float var10001;
         boolean var10002;
         if (var3) {
            var10001 = 0.0F;
            var10002 = var3;
         } else {
            var10001 = 1.0F;
            var10002 = var3;
         }

         boolean var10003;
         float var4;
         if (var10002) {
            var4 = 200.0F;
            var10003 = var3;
         } else {
            var4 = 300.0F;
            var10003 = var3;
         }

         var10000.getCls2(var10001, var4, var10003 ? client.onyx.render.misc.Util.IFACE : client.onyx.render.misc.Util.IFACE7);
         var1x.cls.handleFloat(var1);
         return var3 && var1x.cls.isEnabled() && var1x.cls.getFloat() <= 0.0F;
      });
   }

   private static final class Cls2 {
      final client.onyx.render.misc.Cls cls = new client.onyx.render.misc.Cls(0.0F);
      final TitleMessageRecord titleMessageRecord;
      float float_;
      final float float_2;

      private Cls2(TitleMessageRecord var1, float var2) {
         this.titleMessageRecord = var1;
         this.float_2 = var2;
         this.float_ = var2;
      }
   }
}
