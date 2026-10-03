package client.onyx.module.hud;

import client.onyx.MinecraftAccess;
import client.onyx.OnyxClient;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.guide.Util3;
import client.onyx.render.misc.Util;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub8;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import client.onyx.theme.Util2;
import client.onyx.theme.Util4;
import client.onyx.theme.Util5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.network.Packet;
import org.lwjgl.input.Mouse;

public final class Singleplayer implements MinecraftAccess {
   private final Singleplayer.Cls2 cls22 = new Singleplayer.Cls2();
   private float float_;
   private final client.onyx.render.guide.Cls cls2;
   private final client.onyx.render.misc.Cls cls3 = new client.onyx.render.misc.Cls(0.0F);
   private float float_2;
   private final client.onyx.render.misc.Cls cls5 = new client.onyx.render.misc.Cls(28.0F);
   private boolean bool;
   private float float_3;
   private boolean bool2;
   private static final float FLOAT = 1.0F;
   private static final float FLOAT2 = 7.0F;
   private static final float FLOAT3 = 250.0F;
   private float float_4;
   private Util3.XYRecord xYRecord;
   private boolean bool3;
   private static final float FLOAT4 = 100.0F;
   private static final float FLOAT5 = 10.0F;
   private static final float FLOAT6 = 22.0F;
   private float[] floatArray;
   private static final float FLOAT7 = 3.0F;
   private static final float FLOAT8 = 10.0F;
   private static final int INT = 3;
   private static final float FLOAT9 = 8.0F;
   private float float_5;
   private static final float FLOAT10 = 28.0F;
   private static final String STRING = "stats-island";
   private float[] floatArray2;
   private float float_6;
   private static final float FLOAT11 = 96.0F;
   private static final float FLOAT12 = 5.0F;
   private int int_;
   private float float_7;
   private final client.onyx.gui.Cls cls = new client.onyx.gui.Cls();
   private final List<Singleplayer.StatValueRecord> list2 = new ArrayList();
   private boolean bool4;
   private boolean bool5;
   private long long_;
   private final Cls cls4;
   private final List<client.onyx.render.misc.Cls> list = new ArrayList();
   private static final float FLOAT13 = 0.94F;
   private int int_2;
   private static final float FLOAT14 = 3.0F;
   private boolean bool6;
   private float float_8;
   private final WatermarkModule watermarkModule;
   private static final float FLOAT15 = 1.0F;
   private float float_9;

   private String getString23() {
      ServerData var2;
      if ((var2 = MINECRAFT.getCurrentServerData()) != null) {
         return var2.serverIP;
      } else {
         return MINECRAFT.isSingleplayer() ? "Singleplayer" : "Local";
      }
   }

   public Singleplayer(WatermarkModule var1) {
      float[] var10010 = new float[0];
      boolean var10012 = true;
      this.floatArray2 = var10010;
      float[] var10008 = new float[0];
      boolean var2 = true;
      this.floatArray = var10008;
      this.int_ = -1;
      this.xYRecord = Util3.X_Y_RECORD;
      this.cls2 = new client.onyx.render.guide.Cls();
      this.watermarkModule = var1;
      this.cls4 = new Cls(var1);
   }

   public boolean isEnabled76() {
      return MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null && (this.isEnabled77() || this.cls3.getFloat() > 0.0F || !this.cls3.isEnabled());
   }

   private void run107() {
      if (this.int_ >= 0 && this.int_2 != this.int_) {
         ValueSettingSub8 var2 = this.watermarkModule.valueSettingSub8;
         int var3 = this.int_;
         var2.handleInt5(var3, this.int_2);
      }

      this.int_ = -1;
   }

   private List<Integer> getList21() {
      ArrayList var1 = new ArrayList(this.list2.size());

      int var3;
      for(int var10000 = var3 = 0; var10000 < this.list2.size(); var10000 = var3) {
         if (var3 != this.int_) {
            var1.add(var3);
         }

         ++var3;
      }

      var1.add(Math.clamp((long)this.int_2, 0, var1.size()), this.int_);
      return var1;
   }

   public boolean isDouble4(double var1, double var3) {
      return var1 >= (double)this.float_5 && var1 < (double)(this.float_5 + this.float_3) && var3 >= (double)this.float_8 && var3 < (double)(this.float_8 + this.float_9);
   }

   private void handleSampler017(Sampler0 var1) {
      this.run106();
      int var4 = this.list2.size();
      if (this.floatArray2.length != var4) {
         float[] var10003 = new float[var4];
         boolean var10005 = true;
         this.floatArray2 = var10003;
         float[] var10001 = new float[var4];
         boolean var6 = true;
         this.floatArray = var10001;
      }

      float var3 = 8.0F;

      int var5;
      for(int var10000 = var5 = 0; var10000 < var4; var10000 = var5) {
         if (var5 > 0) {
            var3 += 7.0F;
         }

         this.floatArray2[var5] = var3;
         this.floatArray[var5] = this.getFloat69(var1, (Singleplayer.StatValueRecord)this.list2.get(var5));
         var3 += this.floatArray[var5++];
      }

   }

   private void handleSampler019(Sampler0 var1, PrimaryOnPrimaryRecord var2, float var3) {
      int var4 = Util5.getIntForInt(3, var2);
      var1.handleFloat25(0.0F, 0.0F, var3, 22.0F, Float.MAX_VALUE, 3);
      Util14.handleSampler0(var1, 0.0F, 0.0F, var3, 22.0F, Float.MAX_VALUE, var4);
      float var14 = 11.0F;

      float var6;
      int var7;
      for(int var10000 = var7 = 0; var10000 < this.list2.size(); var10000 = var7) {
         if (var7 != this.int_) {
            var6 = ((client.onyx.render.misc.Cls)this.list.get(var7)).getFloat();
            if (var7 > 0 && var7 != this.int_) {
               var1.handleFloat23(this.floatArray2[var7] - 3.5F + var6, var14, 1.0F, var2.outlineVariant());
            }

            float var9 = this.floatArray2[var7] + var6;
            this.handleSampler020(var1, var2, var7, var9, var14, 1.0F);
         }

         ++var7;
      }

      if (this.int_ >= 0 && this.int_ < this.floatArray.length) {
         float var15 = this.floatArray[this.int_];
         var6 = Math.clamp(this.float_6 - this.float_, 0.0F, Math.max(0.0F, var3 - var15));
         var1.handleFloat7(var6 - 4.0F, 2.0F, var15 + 8.0F, 18.0F, 8.0F, Util4.getIntForInt2(var2.secondaryContainer(), 0.92F));
         this.handleSampler020(var1, var2, this.int_, var6, var14, 1.0F);
      }

      client.onyx.gui.Cls var11 = this.cls;
      int var12 = var2.onSurface();
      var11.handleSampler0(var1, 0.0F, 0.0F, var3, 22.0F, Float.MAX_VALUE, var12);
      int var13 = var2.outlineVariant();
      var1.handleFloat18(0.0F, 0.0F, var3, 22.0F, Float.MAX_VALUE, 1.0F, var13);
   }

   private static float getFloatForValueSettingSub103(ValueSettingSub10 var0, float var1) {
      return var1 <= 0.0F ? 0.0F : (float)((double)var1 * (Double)var0.lambda15() / 100.0D);
   }

   private void run104() {
      if (this.int_ < 0) {
         Iterator var8 = this.list.iterator();

         while(var8.hasNext()) {
            client.onyx.render.misc.Cls var9;
            if ((var9 = (client.onyx.render.misc.Cls)var8.next()).getFloat2() != 0.0F) {
               var9.getCls2(0.0F, 100.0F, Util.IFACE2);
            }
         }

      } else {
         List var1 = this.getList21();
         float var7 = 8.0F;

         int var4;
         for(int var10000 = var4 = 0; var10000 < var1.size(); var10000 = var4) {
            int var3 = (Integer)var1.get(var4);
            if (var4 > 0) {
               var7 += 7.0F;
            }

            if (var3 != this.int_) {
               float var5 = var7 - this.floatArray2[var3];
               client.onyx.render.misc.Cls var6;
               if ((var6 = (client.onyx.render.misc.Cls)this.list.get(var3)).getFloat2() != var5) {
                  var6.getCls2(var5, 100.0F, Util.IFACE2);
               }
            }

            ++var4;
            var7 += this.floatArray[var3];
         }

      }
   }

   private float getFloat69(Sampler0 var1, Singleplayer.StatValueRecord var2) {
      float var4 = Math.min(var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var2.value()), 96.0F);
      var4 += 13.0F;
      if (!var2.label().isEmpty()) {
         var4 += 3.0F + var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD8, var2.label());
      }

      return var4;
   }

   private boolean isEnabled78() {
      return Mouse.isButtonDown(0);
   }

   public void handlePacket(Packet<?> var1) {
      this.cls22.run120();
   }

   private void run106() {
      Singleplayer var10000 = this;

      while(var10000.list.size() < this.list2.size()) {
         var10000 = this;
         this.list.add(new client.onyx.render.misc.Cls(0.0F));
      }

      var10000 = this;

      while(var10000.list.size() > this.list2.size()) {
         var10000 = this;
         this.list.remove(this.list.size() - 1);
      }

   }

   private int getInt38() {
      if (MINECRAFT.getNetHandler() != null && MINECRAFT.thePlayer != null) {
         NetworkPlayerInfo var2;
         return (var2 = MINECRAFT.getNetHandler().getPlayerInfo(MINECRAFT.thePlayer.getUniqueID())) == null ? 0 : Math.max(0, var2.getResponseTime());
      } else {
         return 0;
      }
   }

   private boolean isBool3(boolean var1, float var2, float var3, float var4, float var5) {
      var4 = (float)Minecraft.getScaledMouseX() * var4 / (float)MINECRAFT.displayWidth;
      float var10 = (float)Minecraft.getScaledMouseY() * var5 / (float)MINECRAFT.displayHeight;
      var5 = var5 - var10 - 1.0F;
      boolean var6 = this.isEnabled78();
      var4 = (var4 - this.float_5) / var2;
      var2 = (var5 - this.float_8) / var2;
      Singleplayer var10000;
      if (var1 && var6) {
         if (!this.bool) {
            int var14;
            this.bool6 = (var14 = this.getInt40(var4, var2)) >= 0;
            if (this.bool6) {
               int var10001 = this.int_ = var14;
               this.float_ = var4 - this.floatArray2[var14];
               this.int_2 = var10001;
            }
         }

         this.bool = var6;
         this.float_6 = var4;
         if (this.int_ >= 0) {
            int var13 = this.getInt39(var4);
            this.int_2 = var13;
         }

         var10000 = this;
      } else {
         if (this.int_ >= 0) {
            this.run107();
         }

         var10000 = this;
         this.bool = var6;
         this.bool6 = false;
      }

      var10000.run104();

      Iterator var15;
      for(Iterator var16 = var15 = this.list.iterator(); var16.hasNext(); var16 = var15) {
         ((client.onyx.render.misc.Cls)var15.next()).handleFloat(var3);
      }

      return this.bool6;
   }

   private void handleSampler020(Sampler0 var1, PrimaryOnPrimaryRecord var2, int var3, float var4, float var5, float var6) {
      Singleplayer.StatValueRecord var8 = (Singleplayer.StatValueRecord)this.list2.get(var3);
      client.onyx.gui.Util.handleSampler05(var1, var8.stat(), var4 + 5.0F, var5, 10.0F, Util4.getIntForInt2(var2.onSurfaceVariant(), var6));
      var4 += 13.0F;
      String var7 = var1.getString17(Util2.OPTICAL_WEIGHT_RECORD9, var8.value(), 96.0F);
      var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD9, var7, var4, var5, Util4.getIntForInt2(var2.onSurface(), var6));
      var4 += var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD9, var7);
      if (!var8.label().isEmpty()) {
         var4 += 3.0F;
         var1.handleOpticalWeightRecord9(Util2.OPTICAL_WEIGHT_RECORD8, var8.label(), var4, var5, Util4.getIntForInt2(var2.onSurfaceVariant(), var6));
      }
   }

   public void handleSampler018(Sampler0 var1, float var2, float var3) {
      float var4 = this.getFloat67();
      boolean var5 = this.watermarkModule.isEnabled55() && MINECRAFT.currentScreen instanceof GuiChat;
      boolean var13 = this.isEnabled77();
      this.handleFloat66(var4, var13);
      client.onyx.render.misc.Cls var10000 = this.cls3;
      float var10001;
      boolean var10002;
      if (var13) {
         var10001 = 1.0F;
         var10002 = var13;
      } else {
         var10001 = 0.0F;
         var10002 = var13;
      }

      float var17;
      boolean var10003;
      if (var10002) {
         var17 = 300.0F;
         var10003 = var13;
      } else {
         var17 = 200.0F;
         var10003 = var13;
      }

      var10000.getCls2(var10001, var17, var10003 ? Util.IFACE7 : Util.IFACE);
      this.cls3.handleFloat(var4);
      if (!var13 && this.cls3.isEnabled() && this.cls3.getFloat() <= 0.0F) {
         this.float_3 = 0.0F;
         this.float_9 = 0.0F;
         this.bool2 = this.isEnabled78();
         this.cls4.run();
         client.onyx.render.guide.Util.handleString("stats-island");
      } else {
         Util14.run();
         PrimaryOnPrimaryRecord var15 = Util4.getPrimaryOnPrimaryRecord();
         this.cls5.getCls2(Math.max(28.0F, this.getFloat68(var1)), 200.0F, Util.IFACE2);
         this.cls5.handleFloat(var4);
         float var7 = this.watermarkModule.valueSettingSub10.getFloat5() * (0.94F + 0.060000002F * this.cls3.getFloat());
         float var8;
         this.float_3 = (var8 = this.cls5.getFloat()) * var7;
         this.float_9 = 22.0F * var7;
         float var9 = var2 - this.float_3 - 20.0F;
         float var10 = var3 - this.float_9 - 20.0F;
         this.float_5 = 10.0F + getFloatForValueSettingSub103(this.watermarkModule.Qa, var9);
         this.float_8 = 10.0F + getFloatForValueSettingSub103(this.watermarkModule.valueSettingSub103, var10);
         client.onyx.render.guide.Util.handleString2("stats-island", this.float_5, this.float_8, this.float_3, this.float_9);
         this.handleSampler021(var1, var5, var4, var2, var3);
         boolean var11 = this.cls4.isEnabled2();
         boolean var12 = var11 ? false : this.isBool3(var5, var7, var4, var2, var3);
         var11 = var11 ? false : this.isBool4(var5, var12, var9, var10, var2, var3);
         if (var5 && var11 && !this.bool4 && this.int_ < 0) {
            float[] var14;
            if ((var14 = this.cls2.getFloatArray(true))[0] != 0.0F || var14[1] != 0.0F) {
               handleValueSettingSub103(this.watermarkModule.Qa, getFloatForValueSettingSub103(this.watermarkModule.Qa, var9) + var14[0], var9);
               handleValueSettingSub103(this.watermarkModule.valueSettingSub103, getFloatForValueSettingSub103(this.watermarkModule.valueSettingSub103, var10) + var14[1], var10);
            }
         } else {
            this.cls2.getFloatArray(false);
         }

         this.float_5 = 10.0F + getFloatForValueSettingSub103(this.watermarkModule.Qa, var9);
         this.float_8 = 10.0F + getFloatForValueSettingSub103(this.watermarkModule.valueSettingSub103, var10);
         client.onyx.gui.Cls var16 = this.cls;
         Singleplayer var18;
         if (var5 && var11) {
            var10002 = true;
            var18 = this;
         } else {
            var10002 = false;
            var18 = this;
         }

         var16.handleFloat(var4, var10002, var18.bool4);
         if (this.bool4) {
            Util3.handleSampler02(var1, var2, var3, this.xYRecord);
         }

         var1.handleFloat10(this.cls3.getFloat());
         var1.run36();
         var1.handleFloat11(this.float_5, this.float_8 + (1.0F - this.cls3.getFloat()) * 5.0F);
         var1.handleFloat12(var7, 0.0F, 0.0F);
         this.handleSampler019(var1, var15, var8);
         var1.run43();
         var1.run40();
         if (this.cls4.isEnabled()) {
            this.cls4.handleSampler02(var1, var15);
         }

      }
   }

   private boolean isBool4(boolean var1, boolean var2, float var3, float var4, float var5, float var6) {
      float var7 = (float)Minecraft.getScaledMouseX() * var5 / (float)MINECRAFT.displayWidth;
      float var15 = (float)Minecraft.getScaledMouseY() * var6 / (float)MINECRAFT.displayHeight;
      float var11 = var6 - var15 - 1.0F;
      boolean var9 = this.isEnabled78();
      boolean var10 = this.isDouble4((double)var7, (double)var11);
      Singleplayer var10000;
      if (var1 && var9) {
         if (!this.bool2 && var10 && !var2) {
            this.bool4 = true;
            this.float_7 = var7 - this.float_5;
            this.float_2 = var11 - this.float_8;
         }

         var10000 = this;
      } else {
         var10000 = this;
         this.bool4 = false;
         this.xYRecord = Util3.X_Y_RECORD;
      }

      var10000.bool2 = var9;
      if (this.bool4) {
         this.xYRecord = Util3.getXYRecordForFloat2(var7 - this.float_7, var11 - this.float_2, this.float_3, this.float_9, var5, var6, 10.0F, client.onyx.render.guide.Util.getListForString("stats-island"));
         handleValueSettingSub103(this.watermarkModule.Qa, this.xYRecord.x() - 10.0F, var3);
         handleValueSettingSub103(this.watermarkModule.valueSettingSub103, this.xYRecord.y() - 10.0F, var4);
      }

      return var10;
   }

   private int getInt40(float var1, float var2) {
      if (!(var2 < 0.0F) && !(var2 >= 22.0F)) {
         int var3;
         for(int var10000 = var3 = 0; var10000 < this.list2.size(); var10000 = var3) {
            if (var1 >= this.floatArray2[var3] && var1 < this.floatArray2[var3] + this.floatArray[var3]) {
               return var3;
            }

            ++var3;
         }

         return -1;
      } else {
         return -1;
      }
   }

   private float getFloat68(Sampler0 var1) {
      this.handleSampler017(var1);
      if (this.list2.isEmpty()) {
         return 16.0F;
      } else {
         int var2 = this.list2.size() - 1;
         return this.floatArray2[var2] + this.floatArray[var2] + 8.0F;
      }
   }

   private boolean isEnabled77() {
      return this.watermarkModule.isEnabled55() && !this.watermarkModule.valueSettingSub8.isEnabled16();
   }

   private static void handleValueSettingSub103(ValueSettingSub10 var0, float var1, float var2) {
      if (!(var2 <= 0.0F)) {
         var0.handleObject2((double)Math.clamp(var1 / var2, 0.0F, 1.0F) * 100.0D);
      }
   }

   public void run105() {
      this.list2.clear();
      this.list.clear();
      this.int_ = -1;
      this.bool = false;
      this.bool6 = false;
      this.bool4 = false;
      this.float_4 = 0.0F;
      this.long_ = 0L;
      this.cls22.run119();
      this.cls4.run();
      client.onyx.render.guide.Util.handleString("stats-island");
   }

   private float getFloat67() {
      long var1 = System.nanoTime();
      float var4 = this.long_ == 0L ? 16.0F : Math.min((float)(var1 - this.long_) / 1000000.0F, 100.0F);
      this.long_ = var1;
      return var4;
   }

   private Singleplayer.StatValueRecord getStatValueRecord(WatermarkModule.FpsUsernameEnum var1) {
      switch(var1) {
      case FPS:
         return new Singleplayer.StatValueRecord(var1, String.valueOf(Minecraft.getDebugFPS()), "fps");
      case USERNAME:
         return new Singleplayer.StatValueRecord(var1, OnyxClient.getString(), "");
      case PING:
         return new Singleplayer.StatValueRecord(var1, String.valueOf(this.getInt38()), "ms");
      case PACKET_LOSS:
         return new Singleplayer.StatValueRecord(var1, String.valueOf(this.cls22.getInt41()), "% loss");
      case SERVER:
         return new Singleplayer.StatValueRecord(var1, this.getString23(), "");
      default:
         throw new MatchException((String)null, (Throwable)null);
      }
   }

   private int getInt39(float var1) {
      int var2 = 0;

      int var5;
      for(int var10000 = var5 = 0; var10000 < this.list2.size(); var10000 = var5) {
         if (var5 != this.int_) {
            float var4 = this.floatArray2[var5] + this.floatArray[var5] / 2.0F;
            if (var1 > var4) {
               ++var2;
            }
         }

         ++var5;
      }

      return var2;
   }

   private void handleSampler021(Sampler0 var1, boolean var2, float var3, float var4, float var5) {
      float var6 = (float)Minecraft.getScaledMouseX() * var4 / (float)MINECRAFT.displayWidth;
      float var14 = (float)Minecraft.getScaledMouseY() * var5 / (float)MINECRAFT.displayHeight;
      float var10 = var5 - var14 - 1.0F;
      boolean var8 = Mouse.isButtonDown(1);
      boolean var9 = this.isEnabled78();
      Singleplayer var10000;
      if (!var2) {
         var10000 = this;
         this.cls4.run();
      } else if (var8 && !this.bool3 && this.isDouble4((double)var6, (double)var10)) {
         var10000 = this;
         this.cls4.handleSampler0(var1, var6, var10, var4, var5);
      } else {
         if (var9 && !this.bool5 && this.cls4.isEnabled2() && !this.cls4.isFloat(var6, var10)) {
            this.cls4.run();
         }

         var10000 = this;
      }

      var10000.bool3 = var8;
      this.bool5 = var9;
      this.cls4.handleFloat(var3, var6, var10);
   }

   private void handleFloat66(float var1, boolean var2) {
      this.cls22.run121();
      this.float_4 -= var1;
      if (var2 && (!(this.float_4 > 0.0F) || this.list2.isEmpty())) {
         if (this.int_ < 0) {
            this.float_4 = 250.0F;
            this.list2.clear();
            Iterator var3 = ((List)this.watermarkModule.valueSettingSub8.lambda15()).iterator();

            while(var3.hasNext()) {
               WatermarkModule.FpsUsernameEnum var4 = (WatermarkModule.FpsUsernameEnum)var3.next();
               Singleplayer.StatValueRecord var5;
               if ((var5 = this.getStatValueRecord(var4)) != null) {
                  this.list2.add(var5);
               }
            }

         }
      }
   }

   private static final class Cls2 implements MinecraftAccess {
      private long long_;
      private static final int INT = 20;
      private final AtomicInteger atomicInteger = new AtomicInteger();
      private static final long LONG = 250000000L;
      private int int_;
      private final boolean[] boolArray;
      private int int_2;

      void run119() {
         this.atomicInteger.set(0);
         this.long_ = 0L;
         this.int_ = 0;
         this.int_2 = 0;
      }

      int getInt41() {
         if (this.int_2 == 0) {
            return 0;
         } else {
            int var1 = 0;

            int var3;
            for(int var10000 = var3 = 0; var10000 < this.int_2; var10000 = var3) {
               if (!this.boolArray[var3]) {
                  ++var1;
               }

               ++var3;
            }

            return Math.round((float)var1 * 100.0F / (float)this.int_2);
         }
      }

      private Cls2() {
         boolean[] var10001 = new boolean[20];
         boolean var10003 = true;
         this.boolArray = var10001;
      }

      void run121() {
         if (MINECRAFT.getNetHandler() == null) {
            this.run119();
         } else {
            long var1 = System.nanoTime();
            if (this.long_ == 0L) {
               this.long_ = var1;
            } else {
               long var3;
               if ((var3 = var1 - this.long_) >= 250000000L) {
                  boolean var6 = this.atomicInteger.getAndSet(0) > 0;
                  int var8 = (int)Math.min(var3 / 250000000L, 20L);
                  int var10000 = 0;
                  this.long_ = var1;

                  for(int var7 = 0; var10000 < var8; var10000 = var7) {
                     this.boolArray[this.int_] = var6;
                     this.int_ = (this.int_ + 1) % 20;
                     int var10001 = this.int_2 + 1;
                     ++var7;
                     this.int_2 = Math.min(var10001, 20);
                  }

               }
            }
         }
      }

      void run120() {
         this.atomicInteger.incrementAndGet();
      }
   }

   private static record StatValueRecord(WatermarkModule.FpsUsernameEnum stat, String value, String label) {
      public WatermarkModule.FpsUsernameEnum stat() {
         return this.stat;
      }

      public String label() {
         return this.label;
      }


      public String value() {
         return this.value;
      }
   }
}
