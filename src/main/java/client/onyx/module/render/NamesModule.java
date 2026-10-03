package client.onyx.module.render;

import client.onyx.OnyxClient;
import client.onyx.gui.Reset2;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.combat.AntiBotModule;
import client.onyx.module.player.NameChangerModule;
import client.onyx.render.Sampler0;
import client.onyx.render.Util11;
import client.onyx.render.Util8;
import client.onyx.render.font.OpticalWeightRecord;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.NoneValueSetting;
import client.onyx.setting.impl.SettingSub;
import client.onyx.setting.impl.ValueSettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.Util5;
import client.onyx.theme.Util2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;

public class NamesModule extends Module {
   public NoneValueSetting noneValueSetting2;
   public ValueSettingSub6 valueSettingSub6;
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub9 valueSettingSub9;
   private static final int INT = 4;
   private static final float FLOAT = 3.0F;
   private static final int[] INT_ARRAY;
   private static final int INT2 = -38302;
   public ValueSettingSub9 valueSettingSub92;
   private static final float FLOAT2 = 16.0F;
   private static final int INT3 = -15253;
   private static final float FLOAT3 = 70.0F;
   private static final float FLOAT4 = 0.6F;
   private static final float FLOAT5 = 3.0F;
   private static final float FLOAT6 = 4.0F;
   public ValueSettingSub10 valueSettingSub102;
   public SettingSub settingSub = new SettingSub("Edit layout", () -> MINECRAFT.displayGuiScreen(new Reset2(MINECRAFT.currentScreen)))
      .getBooleanSetting("Drag the name and equipment around the player");
   public ValueSettingSub10 valueSettingSub103;
   public ValueSettingSub9 valueSettingSub93;
   public static final int INT4 = 1;
   public ValueSettingSub<NamesModule.HeadChestEnum> valueSettingSub;
   public static final int INT5 = 1;
   private static final int INT6 = 3;
   public ValueSettingSub9 valueSettingSub94;
   public ValueSettingSub10 valueSettingSub104;
   private static final float FLOAT7 = 10.0F;
   private static final float FLOAT8 = 2.0F;
   private static final float FLOAT9 = 4.0F;
   private static final int INT7 = -6560885;
   private final Sampler0 sampler0;
   public ValueSettingSub<NamesModule.HealthRankEnum> valueSettingSub2;
   public ValueSettingSub10 valueSettingSub105;
   public static final float FLOAT10 = 22.0F;
   public ValueSettingSub6 valueSettingSub62;
   public static final int INT8 = 0;
   public static final float FLOAT11 = 2.0F;
   private static final float FLOAT12 = 1.1F;
   public ValueSettingSub10 valueSettingSub106;
   private static final float FLOAT13 = 12.0F;
   public static final int INT9 = 2;
   private static final float FLOAT14 = 1.0F;
   public ValueSettingSub10 valueSettingSub107;
   public ValueSettingSub9 valueSettingSub95 = new ValueSettingSub9("Names", true);
   private static final float FLOAT15 = 3.0F;
   public static final int INT10 = 3;
   public static final int INT11 = 0;
   public ValueSettingSub10 valueSettingSub108;

   public float[] getFloatArray3(int var1, float var2, boolean var3) {
      int var4;
      float var5 = ((var4 = Math.max(var1, 1)) * 22.0F + (var4 - 1) * 2.0F) * var2;
      var2 = 22.0F * var2;
      if (var3) {
         float[] var7 = new float[2];
         boolean var8 = true;
         var7[0] = var5;
         var7[1] = var2;
         return var7;
      } else {
         float[] var10000 = new float[2];
         boolean var10002 = true;
         var10000[0] = var2;
         var10000[1] = var5;
         return var10000;
      }
   }

   public List<ItemStack> getList14() {
      ArrayList var3 = new ArrayList(4);

      int var2;
      for (int var10000 = var2 = 0; var10000 < 4; var10000 = var2) {
         var2++;
         var3.add(null);
      }

      return var3;
   }

   static {
      int[] var0 = new int[]{
         0, 170, 43520, 43690, 11141120, 11141290, 16755200, 11184810, 5592405, 5592575, 5635925, 5636095, 16733525, 16733695, 16777045, 16777215
      };
      INT_ARRAY = var0;
   }

   private static int getIntForFloat(float var0) {
      float var2;
      return (var2 = Math.clamp(var0, 0.0F, 1.0F)) < 0.5F
         ? getIntForInt22(-38302, -15253, var2 * 2.0F)
         : getIntForInt22(-15253, -6560885, (var2 - 0.5F) * 2.0F);
   }

   private static String getStringForString3(String var0) {
      return Util5.getStringForString(var0);
   }

   public List<NamesModule.TypeCenterXRecord> getList15(
      Sampler0 var1, EntityPlayer var2, float var3, float var4, float var5, float var6, float var7, float var8, boolean var9
   ) {
      float var10 = this.getFloat37(var6);
      float var11 = var3 + var5;
      float var12 = var4 + var6;
      var5 = var3 + var5 / 2.0F;
      float var13 = var4 + var6 / 2.0F;
      boolean var14 = this.valueSettingSub95.isEnabled17();
      List var15;
      int var16 = !(var15 = this.getList18(var2)).isEmpty() ? var15.size() : (var9 ? 4 : 0);
      var9 = this.valueSettingSub93.isEnabled17() && var16 > 0;
      ArrayList var31 = new ArrayList(2);
      if (this.valueSettingSub94.isEnabled17()) {
         if (var14) {
            float[] var32 = this.getFloatArray4(var1, var2, var10);
            var31.add(
               new NamesModule.TypeCenterXRecord(
                  0, var5 + this.valueSettingSub102.getFloat5() * var6, var13 + this.valueSettingSub106.getFloat5() * var6, var32[0], var32[1], false
               )
            );
         }

         if (var9) {
            float[] var33 = this.getFloatArray3(var16, var10, false);
            var31.add(
               new NamesModule.TypeCenterXRecord(
                  1, var5 + this.valueSettingSub104.getFloat5() * var6, var13 + this.valueSettingSub103.getFloat5() * var6, var33[0], var33[1], false
               )
            );
         }

         return var31;
      } else {
         float var17 = 12.0F * var10;
         var5 = 10.0F * var10;

         int var29;
         for (int var10000 = var29 = 0; var10000 < 4; var10000 = ++var29) {
            boolean var18 = var29 == 0 || var29 == 3;
            boolean var19 = var14 && this.valueSettingSub105.getInt10() == var29;
            boolean var20 = var9 && this.valueSettingSub107.getInt10() == var29;
            if (var19 || var20) {
               ArrayList var21 = new ArrayList(2);
               ArrayList var22 = new ArrayList(2);
               boolean var23b = var19 && var20 && this.valueSettingSub92.isEnabled17();
               if (var23b) {
                  var21.add(1);
                  var22.add(this.getFloatArray3(var16, var10, var18));
               }

               if (var19) {
                  var21.add(0);
                  var22.add(this.getFloatArray4(var1, var2, var10));
               }

               if (var20 && !var23b) {
                  var21.add(1);
                  var22.add(this.getFloatArray3(var16, var10, var18));
               }

               float var34 = var5 * (var22.size() - 1);

               Iterator var36;
               for (Iterator var40 = var36 = var22.iterator(); var40.hasNext(); var40 = var36) {
                  float[] var38 = (float[])var36.next();
                  var34 += var38[1];
               }
               float var37 = switch (var29) {
                  case 0 -> {

                     yield var4 - var17 - var34;
                  }
                  case 3 -> var12 + var17;
                  default -> var13 - var34 / 2.0F;
               };

               int var23;
               for (int var42 = var23 = 0; var42 < var22.size(); var42 = var23) {
                  float var35 = ((float[])var22.get(var23))[0];
                  float var24 = ((float[])var22.get(var23))[1];
                  float var25 = var37 + var24 / 2.0F;

                  float var26 = switch (var29) {
                     case 1 -> {

                        yield var3 - var17 - var35 / 2.0F;
                     }
                     case 2 -> var11 + var17 + var35 / 2.0F;
                     case 3 -> var8;
                     default -> var7;
                  };
                  var31.add(new NamesModule.TypeCenterXRecord((Integer)var21.get(var23), var26, var25, var35, var24, var18));
                  var23++;
                  var37 += var24 + var5;
               }
            }
         }

         return var31;
      }
   }

   private int getInt28(EntityPlayer var1) {
      NetworkPlayerInfo var2;
      return (var2 = this.getNetworkPlayerInfo(var1)) == null ? 0 : Math.max(0, var2.getResponseTime());
   }

   private float getFloat38(Sampler0 var1, List<NamesModule.StyleTextRecord> var2) {
      float var5 = 0.0F;

      int var4;
      for (int var10000 = var4 = 0; var10000 < var2.size(); var10000 = var4) {
         if (var4 > 0) {
            var5 += 4.0F;
         }

         OpticalWeightRecord var10002 = ((NamesModule.StyleTextRecord)var2.get(var4)).style();
         String var10003 = ((NamesModule.StyleTextRecord)var2.get(var4)).text();
         var4++;
         var5 += var1.getFloat17(var10002, var10003);
      }

      return var5;
   }

   private List<String> getList17(ItemStack var1) {
      if (var1 == null) {
         return List.of();
      } else {
         Map var5 = EnchantmentHelper.getEnchantments(var1);
         ArrayList var2 = new ArrayList(var5.size());
         Iterator var6;
         Iterator var10000 = var6 = var5.entrySet().iterator();

         while (var10000.hasNext()) {
            Entry var3;
            Enchantment var4;
            if ((var4 = Enchantment.getEnchantmentById((Integer)(var3 = (Entry)var6.next()).getKey())) == null) {
               var10000 = var6;
            } else {
               var2.add(
                  new StringBuilder()
                     .insert(0, getStringForString2(getStringForString3(var4.getTranslatedName(1)).replaceAll("\\s+[IVXLCDM]+$", "")))
                     .append(var3.getValue())
                     .toString()
               );
               var10000 = var6;
            }
         }

         return var2;
      }
   }

   public boolean isEntityPlayer(EntityPlayer var1) {
      if (!this.isEnabled55() || MINECRAFT.thePlayer == null || MINECRAFT.theWorld == null) {
         return false;
      } else if (!var1.isEntityAlive() || var1.isSpectator()) {
         return false;
      } else if (AntiBotModule.isEntity5(var1)) {
         return false;
      } else {
         return var1 == MINECRAFT.thePlayer && MINECRAFT.gameSettings.thirdPersonView == 0
            ? false
            : MINECRAFT.thePlayer.getDistanceSqToEntity(var1) <= this.valueSettingSub10.lambda15() * this.valueSettingSub10.lambda15();
      }
   }

   public List<ItemStack> getList18(EntityPlayer var1) {
      ArrayList var6 = new ArrayList(NamesModule.HeadChestEnum.values().length);
      NamesModule.HeadChestEnum[] var5;
      int var4 = (var5 = NamesModule.HeadChestEnum.values()).length;

      int var3;
      for (int var10000 = var3 = 0; var10000 < var4; var10000 = ++var3) {
         NamesModule.HeadChestEnum var7 = var5[var3];
         ItemStack var8;
         if (this.valueSettingSub.isEnum(var7) && (var8 = var1.getEquipmentInSlot(var7.getInt2())) != null) {
            var6.add(var8);
         }
      }

      return var6;
   }

   public void handleSampler08(Sampler0 var1, EntityPlayer var2, float var3, float var4, float var5) {
      List var8 = this.getList16(var2);
      float var6 = this.getFloat38(var1, var8) + 8.0F;
      float var7 = Util2.OPTICAL_WEIGHT_RECORD11.lineHeight() + 4.0F;
      var1.run36();
      var1.handleFloat11(var3 - var6 * var5 / 2.0F, var4 - var7 * var5 / 2.0F);
      var1.handleFloat12(var5, 0.0F, 0.0F);
      var1.handleFloat7(0.0F, 0.0F, var6, var7, 8.0F, this.valueSettingSub6.lambda15());
      float var9 = 4.0F;
      Iterator var10;
      Iterator var12 = var10 = var8.iterator();

      while (var12.hasNext()) {
         NamesModule.StyleTextRecord var11 = (NamesModule.StyleTextRecord)var10.next();
         var12 = var10;
         var1.handleOpticalWeightRecord9(var11.style(), var11.text(), var9, var7 / 2.0F, var11.color());
         var9 += var1.getFloat17(var11.style(), var11.text()) + 4.0F;
      }

      var1.run43();
   }

   private NetworkPlayerInfo getNetworkPlayerInfo(EntityPlayer var1) {
      return MINECRAFT.getNetHandler() == null ? null : MINECRAFT.getNetHandler().getPlayerInfo(var1.getUniqueID());
   }

   public void handleSampler09(Sampler0 var1, EntityPlayer var2, float var3, float var4, float var5, float var6, float var7, float var8, boolean var9) {
      float var10 = this.getFloat37(var6);
      List var11;
      List var12 = (var11 = this.getList18(var2)).isEmpty() && var9 ? this.getList14() : var11;
      Iterator var13 = this.getList15(var1, var2, var3, var4, var5, var6, var7, var8, var9).iterator();

      while (var13.hasNext()) {
         NamesModule.TypeCenterXRecord var14;
         if ((var14 = (NamesModule.TypeCenterXRecord)var13.next()).type() == 0) {
            this.handleSampler08(var1, var2, var14.centerX(), var14.centerY(), var10);
         } else {
            this.handleSampler010(var1, var2, var14.centerX(), var14.centerY(), var10, var12, var14.horizontal());
         }
      }
   }

   public float getFloat37(float var1) {
      return this.valueSettingSub108.getFloat5() * Math.clamp(var1 / 70.0F, 0.6F, 1.1F);
   }

   private static String getStringForString2(String var0) {
      String[] var6;
      if ((var6 = var0.split(" ")).length == 1) {
         String var7 = var6[0];
         int var9 = var6[0].length();
         int var10 = Math.min(3, var9);
         return var7.substring(0, var10);
      } else {
         StringBuilder var2 = new StringBuilder(var6.length);
         String[] var12;
         int var4 = (var12 = var6).length;

         int var3;
         for (int var10000 = var3 = 0; var10000 < var4; var10000 = ++var3) {
            String var5;
            if (!(var5 = var12[var3]).isEmpty()) {
               var2.append(var5.charAt(0));
            }
         }

         return var2.toString();
      }
   }

   public static boolean isEntityLivingBase5(EntityLivingBase var0) {
      client.onyx.module.Cls var2 = OnyxClient.cls;
      NamesModule var3;
      return OnyxClient.cls != null && var0 instanceof EntityPlayer
         ? (var3 = var2.namesModule).valueSettingSub95.isEnabled17() && var3.isEntityPlayer((EntityPlayer)var0)
         : false;
   }

   private static int getIntForInt22(int var0, int var1, float var2) {
      int var4 = -16777216;

      byte var7;
      for (byte var10000 = var7 = 0; var10000 <= 16; var10000 = var7) {
         int var5 = var0 >> var7 & 0xFF;
         int var6 = var1 >> var7 & 0xFF;
         int var10001 = Math.round(var5 + (var6 - var5) * var2);
         byte var10002 = var7;
         var7 += 8;
         var4 |= var10001 << var10002;
      }

      return var4;
   }

   public boolean isEnabled58() {
      return this.valueSettingSub93.isEnabled17()
         && this.valueSettingSub9.isEnabled17()
         && this.noneValueSetting2.isEnabled19()
         && this.noneValueSetting2.isEnabled22();
   }

   private int getInt27(EntityPlayer var1) {
      Team var2;
      int var3;
      return (var2 = var1.getTeam()) instanceof ScorePlayerTeam
            && (var3 = ((ScorePlayerTeam)var2).getChatFormat().getColorIndex()) >= 0
            && var3 < INT_ARRAY.length
         ? 0xFF000000 | INT_ARRAY[var3]
         : this.valueSettingSub62.getInt8();
   }

   public float[] getFloatArray4(Sampler0 var1, EntityPlayer var2, float var3) {
      List var4 = this.getList16(var2);
      float var8 = this.getFloat38(var1, var4) + 8.0F;
      float var9 = Util2.OPTICAL_WEIGHT_RECORD11.lineHeight() + 4.0F;
      return new float[]{var8 * var3, var9 * var3};
   }

   public void handleSampler010(Sampler0 var1, EntityPlayer var2, float var3, float var4, float var5, List<ItemStack> var6, boolean var7) {
      int var11;
      float var8 = (var11 = var6.size()) * 22.0F + (var11 - 1) * 2.0F;
      float var9 = var7 ? var8 : 22.0F;
      float var10 = var7 ? 22.0F : var8;
      int var10000 = 0;
      var1.run36();
      var1.handleFloat11(var3 - var9 * var5 / 2.0F, var4 - var10 * var5 / 2.0F);
      var1.handleFloat12(var5, 0.0F, 0.0F);

      for (int var12 = 0; var10000 < var11; var10000 = var12) {
         var4 = var7 ? var12 * 24.0F : 0.0F;
         var5 = var7 ? 0.0F : var12 * 24.0F;
         var1.handleFloat7(var4, var5, 22.0F, 22.0F, 8.0F, this.valueSettingSub6.lambda15());
         var1.run36();
         var1.handleFloat11(var4 + 3.0F, var5 + 3.0F);
         ItemStack var10001 = (ItemStack)var6.get(var12);
         var12++;
         var1.handleItemStack(var10001, 0.0F, 0.0F);
         var1.run43();
      }

      int var13;
      if (this.isEnabled58()) {
         for (int var16 = var13 = 0; var16 < var11; var16 = ++var13) {
            ItemStack var10002 = (ItemStack)var6.get(var13);
            float var10003;
            boolean var10004;
            if (var7) {
               var10003 = var13 * 24.0F;
               var10004 = var7;
            } else {
               var10003 = 0.0F;
               var10004 = var7;
            }

            float var17;
            boolean var10005;
            if (var10004) {
               var17 = 0.0F;
               var10005 = var7;
            } else {
               var17 = var13 * 24.0F;
               var10005 = var7;
            }

            this.handleSampler011(var1, var10002, var10003, var17, var10005);
         }
      }

      var1.run43();
   }

   private void handleSampler011(Sampler0 var1, ItemStack var2, float var3, float var4, boolean var5) {
      List var11;
      if (!(var11 = this.getList17(var2)).isEmpty()) {
         float var6 = Util2.OPTICAL_WEIGHT_RECORD13.lineHeight() + 2.0F;
         float var7 = 0.0F;

         Iterator var10;
         for (Iterator var10000 = var10 = var11.iterator(); var10000.hasNext(); var10000 = var10) {
            String var9 = (String)var10.next();
            var7 = Math.max(var7, var1.getFloat17(Util2.OPTICAL_WEIGHT_RECORD13, var9));
         }

         float var16 = var7 + 6.0F;
         float var15 = var11.size() * var6;
         var3 = var5 ? var3 + (22.0F - var16) / 2.0F : var3 + 22.0F + 3.0F;
         var4 = var5 ? var4 + 22.0F + 3.0F : var4 + (22.0F - var15) / 2.0F;
         int var17 = 0;
         var1.handleFloat7(var3, var4, var16, var15, 4.0F, this.valueSettingSub6.lambda15());

         for (int var14 = 0; var17 < var11.size(); var17 = var14) {
            OpticalWeightRecord var10001 = Util2.OPTICAL_WEIGHT_RECORD13;
            String var10002 = (String)var11.get(var14);
            float var10003 = var3 + var16 / 2.0F;
            float var10004 = var4 + var6 * (var14 + 0.5F);
            var14++;
            var1.handleOpticalWeightRecord4(var10001, var10002, var10003, var10004, this.valueSettingSub62.getInt8());
         }
      }
   }

   public NamesModule() {
      super("ESP", "A player's name and equipment, positioned around them", ModuleCategory.RENDER);
      NamesModule.HealthRankEnum[] var10005 = new NamesModule.HealthRankEnum[0];
      boolean var10007 = true;
      this.valueSettingSub2 = new ValueSettingSub<>("Name details", NamesModule.HealthRankEnum.class, var10005)
         .getBooleanSetting("Extra readouts carried on the name plate")
         .getModeSetting(this.valueSettingSub95);
      this.valueSettingSub93 = new ValueSettingSub9("Equipment", true);
      this.valueSettingSub = new ValueSettingSub<>("Slots", NamesModule.HeadChestEnum.class, NamesModule.HeadChestEnum.values())
         .getBooleanSetting("Equipment pieces to show")
         .getModeSetting(this.valueSettingSub93);
      this.valueSettingSub9 = new ValueSettingSub9("Enchant peek", true)
         .getBooleanSetting("Hold a key to list the enchantments on every shown item")
         .getModeSetting(this.valueSettingSub93);
      this.noneValueSetting2 = new NoneValueSetting("Peek key", 56).getBooleanSetting("Held to reveal enchantments").getModeSetting(this.valueSettingSub9);
      this.valueSettingSub10 = new ValueSettingSub10("Distance", 256.0, 8.0, 256.0, 8.0)
         .getValueSettingSub10(" m")
         .getBooleanSetting("Maximum distance at which player ESP is shown");
      this.valueSettingSub108 = new ValueSettingSub10("Scale", 1.0, 0.5, 2.0, 0.05).getValueSettingSub10("x");
      this.valueSettingSub62 = new ValueSettingSub6("Text color", -1);
      this.valueSettingSub6 = new ValueSettingSub6("Background", -1609033185).getValueSettingSub62();
      this.valueSettingSub105 = new ValueSettingSub10("Name zone", 0.0, 0.0, 3.0, 1.0).getSetting2(() -> false);
      this.valueSettingSub107 = new ValueSettingSub10("Equipment zone", 3.0, 0.0, 3.0, 1.0).getSetting2(() -> false);
      this.valueSettingSub94 = new ValueSettingSub9("Free layout", false).getSetting2(() -> false);
      this.valueSettingSub92 = new ValueSettingSub9("Equipment first", false).getSetting2(() -> false);
      this.valueSettingSub102 = new ValueSettingSub10("Name free X", 0.0, -2.0, 2.0, 1.0E-4).getSetting2(() -> false);
      this.valueSettingSub106 = new ValueSettingSub10("Name free Y", -0.72, -2.0, 2.0, 1.0E-4).getSetting2(() -> false);
      this.valueSettingSub104 = new ValueSettingSub10("Equipment free X", -0.6, -2.0, 2.0, 1.0E-4).getSetting2(() -> false);
      this.valueSettingSub103 = new ValueSettingSub10("Equipment free Y", 0.0, -2.0, 2.0, 1.0E-4).getSetting2(() -> false);
      this.sampler0 = new Sampler0().getSampler0();
   }

   private String getString21(EntityPlayer var1) {
      String var2;
      ScorePlayerTeam var3;
      Team var4;
      if ((var4 = var1.getTeam()) instanceof ScorePlayerTeam && !(var2 = getStringForString3((var3 = (ScorePlayerTeam)var4).getColorPrefix()).trim()).isEmpty()
         )
       {
         return var2;
      } else {
         NetworkPlayerInfo var7;
         if ((var7 = this.getNetworkPlayerInfo(var1)) != null && var7.getDisplayName() != null) {
            int var5;
            return (var5 = (var2 = getStringForString3(var7.getDisplayName().getFormattedText())).indexOf(getStringForString3(var1.getName()))) <= 0
               ? ""
               : var2.substring(0, var5).trim();
         } else {
            return "";
         }
      }
   }

   private List<NamesModule.StyleTextRecord> getList16(EntityPlayer var1) {
      ArrayList var2 = new ArrayList(4);
      int var4 = this.valueSettingSub62.getInt8();
      String var3;
      if (this.valueSettingSub2.isEnum(NamesModule.HealthRankEnum.RANK) && !(var3 = this.getString21(var1)).isEmpty()) {
         OpticalWeightRecord var6 = Util2.OPTICAL_WEIGHT_RECORD13;
         int var7 = this.getInt27(var1);
         NamesModule.StyleTextRecord var8 = new NamesModule.StyleTextRecord(var6, var3, var7);
         boolean var9 = var2.add(var8);
      }

      var2.add(new NamesModule.StyleTextRecord(Util2.OPTICAL_WEIGHT_RECORD11, getStringForString3(NameChangerModule.getStringForEntityPlayer(var1)), var4));
      if (this.valueSettingSub2.isEnum(NamesModule.HealthRankEnum.HEALTH)) {
         float var10 = var1.getHealth() + var1.getAbsorptionAmount();
         float var5 = Math.max(1.0F, var1.getMaxHealth());
         var2.add(new NamesModule.StyleTextRecord(Util2.OPTICAL_WEIGHT_RECORD13, Math.round(var10) + "hp", getIntForFloat(var1.getHealth() / var5)));
      }

      int var11;
      if (this.valueSettingSub2.isEnum(NamesModule.HealthRankEnum.PING) && (var11 = this.getInt28(var1)) > 0) {
         var2.add(new NamesModule.StyleTextRecord(Util2.OPTICAL_WEIGHT_RECORD13, var11 + "ms", var4));
      }

      return var2;
   }

   public void handleFloat44(float var1) {
      if (this.isEnabled55() && MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
         if (Util8.isEnabled44()) {
            ScaledResolution var10000 = new ScaledResolution(MINECRAFT);
            float var6 = var10000.getScaledWidth();
            float var4 = var10000.getScaledHeight();
            ArrayList var7;
            (var7 = new ArrayList<>(MINECRAFT.theWorld.playerEntities))
               .sort(Comparator.<EntityPlayer>comparingDouble(var0 -> MINECRAFT.thePlayer.getDistanceSqToEntity(var0)).reversed());
            this.sampler0.run42();
            Iterator var8;
            Iterator var9 = var8 = var7.iterator();

            while (var9.hasNext()) {
               EntityPlayer var5 = (EntityPlayer)var8.next();
               if (!this.isEntityPlayer(var5)) {
                  var9 = var8;
               } else {
                  Util11.LeftTopRecord var2;
                  if ((var2 = Util11.getLeftTopRecordForEntity(var5, var1, var6, var4)) == null) {
                     var9 = var8;
                  } else {
                     this.handleSampler09(
                        this.sampler0, var5, var2.left(), var2.top(), var2.width(), var2.height(), var2.topCenterX(), var2.bottomCenterX(), false
                     );
                     var9 = var8;
                  }
               }
            }

            this.sampler0.run39();
         }
      }
   }

   public static enum HeadChestEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      HEAD(4, "Helmet"),
      CHEST(3, "Chestplate"),
      LEGS(2, "Leggings"),
      FEET(1, "Boots"),
      MAINHAND(0, "Main hand");

      private final int int_;
      private final String string;

      private HeadChestEnum(int var3, String var4) {
         this.int_ = var3;
         this.string = var4;
      }

      public int getInt2() {
         return this.int_;
      }


      @Override
      public String getString5() {
         return this.string;
      }
   }

   public static enum HealthRankEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      HEALTH("Health"),
      RANK("Server rank"),
      PING("Ping");
      private final String string;

      @Override
      public String getString5() {
         return this.string;
      }


      private HealthRankEnum(String var3) {
         this.string = var3;
      }
   }

   private record StyleTextRecord(OpticalWeightRecord style, String text, int color) {
   }

   public record TypeCenterXRecord(int type, float centerX, float centerY, float width, float height, boolean horizontal) {
   }
}
