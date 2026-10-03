package client.onyx.render.hud;

import client.onyx.module.hud.CustomGuiModule;
import client.onyx.render.Sampler0;
import client.onyx.render.Util14;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.theme.PrimaryOnPrimaryRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;

public final class Cls2 extends Abstract_ {
   private static final float FLOAT5 = 7.0F;
   private static final float FLOAT6 = 5.0F;
   private final client.onyx.render.misc.Cls cls3 = new client.onyx.render.misc.Cls(60.0F);
   private static final float FLOAT7 = 60.0F;
   private static final int INT = 3;
   private final client.onyx.render.misc.Cls cls2 = new client.onyx.render.misc.Cls(22.0F);
   private final CustomGuiModule customGuiModule;
   private static final float FLOAT8 = 11.0F;
   private static final int INT2 = 15;
   private static final OpticalWeightRecord OPTICAL_WEIGHT_RECORD;
   private static final float FLOAT9 = 1.0F;
   private static final float FLOAT10 = 6.0F;
   private static final OpticalWeightRecord OPTICAL_WEIGHT_RECORD2;
   private final List<Cls2.NameRecord> list = new ArrayList();
   private String string2 = "";

   private void run75() {
      this.list.clear();
      this.string2 = "";
      Minecraft var6;
      if ((var6 = Minecraft.getMinecraft()).theWorld != null && var6.thePlayer != null) {
         ScoreObjective var12;
         if ((var12 = getScoreObjectiveForMinecraft(var6)) != null) {
            Scoreboard var4 = var12.getScoreboard();
            Object var3 = new ArrayList();
            Iterator var2 = var4.getSortedScores(var12).iterator();

            label40:
            while(true) {
               Iterator var10000 = var2;

               Score var5;
               while(var10000.hasNext()) {
                  if ((var5 = (Score)var2.next()).getPlayerName() == null) {
                     continue label40;
                  }

                  if (var5.getPlayerName().startsWith("#")) {
                     var10000 = var2;
                  } else {
                     ((List)var3).add(var5);
                     var10000 = var2;
                  }
               }

               if (((List)var3).size() > 15) {
                  int var8 = ((List)var3).size() - 15;
                  int var9 = ((List)var3).size();
                  var3 = ((List)var3).subList(var8, var9);
               }

               this.string2 = var12.getDisplayName();

               int var11;
               for(int var13 = var11 = ((List)var3).size() - 1; var13 >= 0; var13 = var11) {
                  var5 = (Score)((List)var3).get(var11);
                  ScorePlayerTeam var14 = var4.getPlayersTeam(var5.getPlayerName());
                  List var15 = this.list;
                  String var10004 = var5.getPlayerName();
                  --var11;
                  var15.add(new Cls2.NameRecord(ScorePlayerTeam.formatPlayerName(var14, var10004)));
               }

               return;
            }
         }
      }
   }

   protected float getFloat25(Sampler0 var1) {
      float var2 = 29.0F + (float)this.list.size() * 11.0F;
      this.cls2.getCls2(var2, 200.0F, client.onyx.render.misc.Util.IFACE2);
      this.cls2.handleFloat(Util4.getFloat());
      return this.cls2.getFloat();
   }

   protected float getFloat26(Sampler0 var1) {
      float var2 = Util2.getFloatForSampler04(var1, OPTICAL_WEIGHT_RECORD2, this.string2);

      Iterator var5;
      for(Iterator var10000 = var5 = this.list.iterator(); var10000.hasNext(); var10000 = var5) {
         Cls2.NameRecord var4 = (Cls2.NameRecord)var5.next();
         var2 = Math.max(var2, Util2.getFloatForSampler04(var1, OPTICAL_WEIGHT_RECORD, var4.name()));
      }

      float var6 = this.customGuiModule.scoreboardBooleanSetting.valueSettingSub10.getFloat5();
      this.cls3.getCls2(Math.max(var6, var2 + 14.0F), 200.0F, client.onyx.render.misc.Util.IFACE2);
      this.cls3.handleFloat(Util4.getFloat());
      return this.cls3.getFloat();
   }

   public Cls2(CustomGuiModule var1) {
      super("mcgui:scoreboard", var1.scoreboardBooleanSetting.valueSettingSub104, var1.scoreboardBooleanSetting.valueSettingSub103, var1.scoreboardBooleanSetting.valueSettingSub105);
      this.customGuiModule = var1;
   }

   static {
      OPTICAL_WEIGHT_RECORD = client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD12;
      OPTICAL_WEIGHT_RECORD2 = client.onyx.theme.Util2.OPTICAL_WEIGHT_RECORD12;
   }

   protected void handleSampler04(Sampler0 var1, float var2, float var3, float var4) {
      PrimaryOnPrimaryRecord var8 = client.onyx.theme.Util4.getPrimaryOnPrimaryRecord();
      int var5 = client.onyx.theme.Util4.getIntForInt2(client.onyx.theme.Util5.getIntForInt(3, var8), this.customGuiModule.scoreboardBooleanSetting.valueSettingSub102.getFloat5() / 100.0F);
      Util14.handleBool(this.customGuiModule.scoreboardBooleanSetting.valueSettingSub92.isEnabled17());
      var1.handleFloat25(0.0F, 0.0F, var2, var3, 12.0F, 3);
      Util14.handleSampler02(var1, 0.0F, 0.0F, var2, var3, 12.0F, var5, this.customGuiModule.scoreboardBooleanSetting.valueSettingSub92.isEnabled17());
      var1.handleFloat24(0.0F, 0.0F, var2, var3);
      var3 = 6.0F;
      Util2.getFloatForSampler010(var1, OPTICAL_WEIGHT_RECORD2, this.string2, var2 / 2.0F, var1.getFloat19(OPTICAL_WEIGHT_RECORD2, var3 + 5.5F), var8.onSurface());
      float var9 = var3 + 11.0F + 2.5F;
      var1.handleFloat7(7.0F, var9, var2 - 14.0F, 1.0F, Float.MAX_VALUE, var8.outlineVariant());
      var2 = var3 + 11.0F + 5.0F + 1.0F;
      Iterator var7 = this.list.iterator();

      for(Iterator var10000 = var7; var10000.hasNext(); var2 += 11.0F) {
         Cls2.NameRecord var10 = (Cls2.NameRecord)var7.next();
         float var6 = var2 + 5.5F;
         var10000 = var7;
         Util2.getFloatForSampler011(var1, OPTICAL_WEIGHT_RECORD, var10.name(), 7.0F, var1.getFloat19(OPTICAL_WEIGHT_RECORD, var6), var8.onSurfaceVariant());
      }

      var1.run38();
   }

   private static ScoreObjective getScoreObjectiveForMinecraft(Minecraft var0) {
      Scoreboard var1;
      ScorePlayerTeam var3;
      int var4;
      ScoreObjective var5;
      return (var3 = (var1 = var0.theWorld.getScoreboard()).getPlayersTeam(var0.thePlayer.getName())) != null && (var4 = var3.getChatFormat().getColorIndex()) >= 0 && (var5 = var1.getObjectiveInDisplaySlot(3 + var4)) != null ? var5 : var1.getObjectiveInDisplaySlot(1);
   }

   protected boolean isBool(boolean var1) {
      this.run75();
      return !this.list.isEmpty();
   }

   private static record NameRecord(String name) {

      public String name() {
         return this.name;
      }
   }
}
