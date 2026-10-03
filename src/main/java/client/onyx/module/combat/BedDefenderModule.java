package client.onyx.module.combat;

import client.onyx.OnyxClient;
import client.onyx.command.Abstract_;
import client.onyx.event.impl.EventSub10;
import client.onyx.interact.DoNotHideHideBothEnum;
import client.onyx.interact.Util;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Util7;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.OffStrictEnum;
import client.onyx.system.Util4;
import client.onyx.system.Util6;
import client.onyx.system.YawPitchRecord;
import client.onyx.util.OutlineColliderEnum;
import client.onyx.util.Util10;
import client.onyx.util.Util11;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockBed.EnumPartType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import org.apache.logging.log4j.Logger;

public class BedDefenderModule extends Module {
   private static final double DOUBLE = 4.5;
   private BlockPos blockPos;
   private BlockPos blockPos2;
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub11<OffStrictEnum> valueSettingSub112;
   private int int_;
   public ValueSettingSub9 valueSettingSub9;
   public ValueSettingSub10 valueSettingSub102;
   public ValueSettingSub10 valueSettingSub103;
   public ValueSettingSub10 valueSettingSub104;
   private List<BedDefenderModule.BlockOffsetRecord> list2;
   private String string3;
   private int int_2;
   public ValueSettingSub10 valueSettingSub105;
   private boolean bool2;
   private boolean bool3;
   private final Set<String> set;
   private static final String STRING = "{\"EndWoolCorners\":[{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":2}],\"EndWoolCorners2\":[{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":3}],\"EndGlassNoCorners\":[{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"stained_glass\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"stained_glass\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"stained_glass\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"stained_glass\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"stained_glass\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"stained_glass\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"stained_glass\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"stained_glass\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"stained_glass\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"stained_glass\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"stained_glass\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"stained_glass\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"stained_glass\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"stained_glass\",\"x\":0,\"y\":1,\"z\":2}],\"WoodWoolCorners\":[{\"block\":\"planks\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"planks\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"planks\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"planks\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"planks\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"planks\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"planks\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"planks\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"planks\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"planks\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"planks\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"planks\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"planks\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"planks\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"planks\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"planks\",\"x\":0,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":1}],\"EndGlassWool\":[{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"stained_glass\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"stained_glass\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"stained_glass\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"stained_glass\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"stained_glass\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"stained_glass\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"stained_glass\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"stained_glass\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"stained_glass\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"stained_glass\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"stained_glass\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"stained_glass\",\"x\":0,\"y\":1,\"z\":2},{\"block\":\"stained_glass\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"stained_glass\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"wool\",\"x\":-3,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":-3,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":-2,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":-2,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":3},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":3},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":4},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":3},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":2,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":2,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":3,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":3,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":2},{\"block\":\"wool\",\"x\":-1,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":-2},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":-3},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":-2},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":-2},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":3,\"z\":0},{\"block\":\"wool\",\"x\":0,\"y\":3,\"z\":1}],\"Wool1Layer\":[{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":-1}],\"EndWoodLongCorners\":[{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"planks\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"planks\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"planks\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"planks\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"planks\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"planks\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"planks\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"planks\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"planks\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"planks\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"planks\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"planks\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"planks\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"planks\",\"x\":0,\"y\":1,\"z\":2},{\"block\":\"planks\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"planks\",\"x\":-1,\"y\":0,\"z\":2}],\"EndWoolLong\":[{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":-2},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":-2},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":-3},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":-2}]}";
   private int int_3;
   public ValueSettingSub11<BedDefenderModule.BottomUpFurthestEnum> valueSettingSub113;
   public ValueSettingSub10 valueSettingSub106;
   public ValueSettingSub10 valueSettingSub107;
   public ValueSettingSub10 valueSettingSub108;
   public ValueSettingSub10 valueSettingSub109;
   public ValueSettingSub9 valueSettingSub92;
   private final Map<BlockPos, Integer> map;
   private static final Map<String, List<BedDefenderModule.BlockOffsetRecord>> MAP = new LinkedHashMap<>();
   public ValueSettingSub9 valueSettingSub93 = new ValueSettingSub9("Only Top Beds", true)
      .getBooleanSetting("Never click the side of a bed, only its top face");
   private boolean bool4;
   private int int_4;
   private static final float[] FLOAT_ARRAY;
   private int int_5;
   private BlockPos blockPos3;
   public ValueSettingSub11<BedDefenderModule.EndWoolCornersEndWoolCorners2Enum> valueSettingSub114;
   private final Map<String, Integer> map2;

   private int getInt46(String var1) {
      int var6 = 0;
      String var4 = var1.toLowerCase();
      String var2;
      Integer var5;
      if ((var5 = this.map2.get(var4)) != null
         && (var2 = getStringForItemStack(MINECRAFT.thePlayer.inventory.getStackInSlot(var5))) != null
         && var2.equalsIgnoreCase(var1)) {
         return var5;
      } else {
         this.handleString15(new StringBuilder().insert(0, "looking for block '").append(var4).append("' in hotbar").toString());

         for (int var10000 = var6 = 0; var10000 < 9; var10000 = ++var6) {
            ItemStack var7;
            if ((var7 = MINECRAFT.thePlayer.inventory.getStackInSlot(var6)) != null) {
               String var8 = getStringForItemStack(var7);
               this.handleString15("slot " + var6 + " -> " + var8);
               if (var8 != null && var8.equalsIgnoreCase(var1)) {
                  this.map2.put(var4, var6);
                  return var6;
               }
            }
         }

         return -1;
      }
   }

   private BlockPos getBlockPos8(int var1) {
      BlockPos var10000 = new BlockPos(MINECRAFT.thePlayer);
      int var12 = var10000.getX();
      int var11 = var10000.getY();
      int var4 = var10000.getZ();
      double var5 = Double.MAX_VALUE;
      BlockPos var7 = null;

      int var8;
      int var9;
      for (int var23 = var8 = var12 - var1; var23 <= var12 + var1; var23 = ++var8) {
         int var10;
         for (int var24 = var9 = var11 - var1; var24 <= var11 + var1; var24 = ++var9) {
            for (int var25 = var10 = var4 - var1; var25 <= var4 + var1; var25 = ++var10) {
               BlockPos var3 = new BlockPos(var8, var9, var10);
               if ("bed".equalsIgnoreCase(getStringForBlockPos2(var3))) {
                  BlockPos var21 = null;
                  BlockPos var13 = null;
                  switch (getIntForBlockPos(var3)) {
                     case 0:

                        var13 = var3;
                        var10000 = var21 = var3.add(0, 0, 1);
                        break;
                     case 1:
                        var13 = var3;
                        var10000 = var21 = var3.add(-1, 0, 0);
                        break;
                     case 2:
                        var13 = var3;
                        var10000 = var21 = var3.add(0, 0, -1);
                        break;
                     case 3:
                        var13 = var3;
                        var10000 = var21 = var3.add(1, 0, 0);
                        break;
                     case 8:
                        var21 = var3;
                        var13 = var3.add(0, 0, -1);
                        var10000 = var3;
                        break;
                     case 9:
                        var21 = var3;
                        var13 = var3.add(1, 0, 0);
                        var10000 = var3;
                        break;
                     case 10:
                        var21 = var3;
                        var13 = var3.add(0, 0, 1);
                        var10000 = var3;
                        break;
                     case 11:
                        var21 = var3;
                        var13 = var3.add(-1, 0, 0);
                     case 4:
                     case 5:
                     case 6:
                     case 7:
                     default:
                        var10000 = var21;
                  }

                  if (var10000 != null && var13 != null) {
                     double var14 = var21.distanceSq(var12, var11, var4);
                     double var16 = var13.distanceSq(var12, var11, var4);
                     double var18 = Math.min(var14, var16);
                     var3 = var14 <= var16 ? var21 : var13;
                     if (var18 < var5) {
                        var5 = var18;
                        var7 = var3;
                     }
                  }
               }
            }
         }
      }

      return var7;
   }

   private boolean isList2(List<BedDefenderModule.BlockOffsetRecord> var1) {
      int var5 = 0;
      if (var1 != null && !var1.isEmpty()) {
         HashSet var2 = new HashSet();
         Iterator var4 = var1.iterator();

         while (var4.hasNext()) {
            BedDefenderModule.BlockOffsetRecord var3;
            if ((var3 = (BedDefenderModule.BlockOffsetRecord)var4.next()).block() != null) {
               var2.add(var3.block().toLowerCase());
            }
         }

         for (int var10000 = var5 = 0; var10000 < 9; var10000 = ++var5) {
            String var6;
            if ((var6 = getStringForItemStack(MINECRAFT.thePlayer.inventory.getStackInSlot(var5))) != null && var2.contains(var6.toLowerCase())) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private Comparator<BedDefenderModule.PosBlockRecord> getComparator4() {
      switch ((BedDefenderModule.BottomUpFurthestEnum)this.valueSettingSub113.lambda15()) {
         case PATTERN:

            return Comparator.<BedDefenderModule.PosBlockRecord>comparingInt(var0 -> var0.pos().getY())
               .thenComparing(Comparator.comparingDouble(BedDefenderModule.PosBlockRecord::distance).reversed())
               .thenComparingInt(BedDefenderModule.PosBlockRecord::index);
         case NEAREST:
            return Comparator.comparingDouble(BedDefenderModule.PosBlockRecord::distance).reversed().thenComparingInt(BedDefenderModule.PosBlockRecord::index);
         case FURTHEST:
            return Comparator.comparingDouble(BedDefenderModule.PosBlockRecord::distance).thenComparingInt(BedDefenderModule.PosBlockRecord::index);
         case BOTTOM_UP:
            return Comparator.comparingInt(BedDefenderModule.PosBlockRecord::index);
         default:
            throw new MatchException(null, null);
      }
   }

   @Override
   protected void run79() {
      if (this.bool2) {
         handleBool22(false);
         this.bool2 = false;
      }

      this.blockPos3 = null;
      Util6.run183();
      this.handleString15("disabled.");
   }

   private static double getDoubleForDouble4(double var0, double var2) {
      return ThreadLocalRandom.current().nextDouble(var0, var2);
   }

   private void run147() {
      if (this.bool2) {
         if (this.int_ > 0) {
            int var2 = this.int_ - 1;
            this.int_ = var2;
         } else {
            handleBool22(false);
            this.bool2 = false;
            this.handleString15("released sneak.");
         }
      }
   }

   private void run145() {
      int var10000 = 0;
      this.set.clear();

      for (int var3 = 0; var10000 < 9; var10000 = ++var3) {
         String var2;
         if ((var2 = getStringForItemStack(MINECRAFT.thePlayer.inventory.getStackInSlot(var3))) != null) {
            this.set.add(var2.toLowerCase());
         }
      }
   }

   private void handleBlockPos4(BlockPos var1) {
      int var3;
      if ((var3 = this.valueSettingSub102.getInt10()) > 0) {
         this.map.put(var1, var3);
      }
   }

   private static String getStringForBlock(Block var0) {
      if (var0 == null) {
         return "air";
      } else {
         Object var2;
         return (var2 = Block.blockRegistry.getNameForObject(var0)) == null ? "" : getStringForString7(var2.toString());
      }
   }

   private static String getStringForString7(String var0) {
      int var2;
      return (var2 = var0.indexOf(58)) < 0 ? var0 : var0.substring(var2 + 1);
   }

   private static float getFloatForFloat16(float var0) {
      float var1;
      return (var1 = (var0 % 360.0F + 360.0F) % 360.0F) > 180.0F ? var1 - 360.0F : var1;
   }

   private static MovingObjectPosition getMovingObjectPositionForDouble(double var0, float var2, float var3) {
      MovingObjectPosition var6;
      if ((var6 = Util11.getMovingObjectPositionForDouble2(var0, OutlineColliderEnum.OUTLINE, false, Util4.getVec323(), Util4.getVec3ForFloat5(var2, var3)))
            == null
         || var6.typeOfHit != MovingObjectType.BLOCK) {
         return null;
      } else {
         return var6.getBlockPos() != null && var6.sideHit != null ? var6 : null;
      }
   }

   public void handleFloat74(float var1) {
      if (this.isEnabled55() && this.blockPos3 != null && MINECRAFT.theWorld != null) {
         AxisAlignedBB var3 = Util.AXIS_ALIGNED_B_B.offset(this.blockPos3.getX(), this.blockPos3.getY(), this.blockPos3.getZ());
         if (Util7.isFloat3(var1, true)) {
            Util7.handleAxisAlignedBB2(var3, -16711936, 1.5F, 1073807104);
            Util7.run49();
         }
      }
   }

   private float[] getFloatArray6(float var1, float var2, float var3, float var4) {
      float var6 = this.valueSettingSub10.getFloat5();
      var3 -= var1;
      var4 -= var2;
      var1 += Math.max(-var6, Math.min(var6, var3));
      var2 += Math.max(-var6, Math.min(var6, var4));
      return new float[]{var1, var2};
   }

   private float[] getFloatArray7(float var1, float var2, BlockPos var3, String var4, float var5, float var6) {
      MovingObjectPosition var25;
      if ((var25 = getMovingObjectPositionForDouble(4.5, var1, var2)) == null) {
         return null;
      } else {
         BlockPos var26 = var25.getBlockPos();
         EnumFacing var28 = var25.sideHit;
         if (!var26.offset(var28).equals(var3)) {
            return null;
         } else {
            String var7 = getStringForBlockPos2(var26);
            if (this.valueSettingSub93.isEnabled17() && var28 != EnumFacing.UP && var7.equals("bed")) {
               return null;
            } else {
               int var8 = MINECRAFT.thePlayer.inventory.currentItem;
               int var9;
               if ((var9 = this.getInt46(var4)) == -1) {
                  return null;
               } else {
                  if (var8 != var9) {
                     this.handleString15("switching to slot " + var9 + " for " + var4);
                     MINECRAFT.thePlayer.inventory.currentItem = var9;
                     this.int_3 = this.valueSettingSub108.getInt10();
                  }

                  if (!this.isBlockPos8(var26, var28)) {
                     return null;
                  } else {
                     int var10 = this.int_3;
                     int var11 = var10 - 1;
                     this.int_3 = var11;
                     if (var10 > 0) {
                        StringBuilder var13 = new StringBuilder().insert(0, "swap delay... (");
                        int var15 = this.int_3 + 1;
                        String var18 = var13.append(var15).append(" left)").toString();
                        this.handleString15(var18);
                        return FLOAT_ARRAY;
                     } else if (!MINECRAFT.gameSettings.keyBindSneak.isKeyDown() && var7.equals("bed")) {
                        handleBool22(true);
                        this.bool2 = true;
                        this.int_ = this.valueSettingSub103.getInt10();
                        this.handleString15("sneaking over bed for placement");
                        return FLOAT_ARRAY;
                     } else {
                        boolean var27 = false;
                        MovingObjectPosition var29;
                        if ((var29 = getMovingObjectPositionForDouble(4.5, var5, var6)) != null) {
                           BlockPos var30 = var29.getBlockPos();
                           EnumFacing var31 = var29.sideHit;
                           if (var30.offset(var31).equals(var3)) {
                              String var32 = getStringForBlockPos2(var30);
                              if (!this.valueSettingSub93.isEnabled17() || var31 == EnumFacing.UP || !var32.equals("bed")) {
                                 var27 = true;
                              }
                           }
                        }

                        if (this.int_5 <= 0 && var27) {
                           int var22 = this.valueSettingSub105.getInt10();
                           this.int_5 = var22;
                           boolean[] var23 = new boolean[]{false};
                           Util.handleMovingObjectPosition2(var29, () -> var23[0] = true, () -> false, DoNotHideHideBothEnum.DO_NOT_HIDE);
                           if (var23[0]) {
                              this.handleString15(
                                 new StringBuilder().insert(0, "placed ").append(var4).append(" at ").append(getStringForBlockPos(var3)).toString()
                              );
                              this.handleBlockPos4(var3);
                              this.blockPos2 = null;
                           } else {
                              this.handleString15(new StringBuilder().insert(0, "place failed at ").append(getStringForBlockPos(var3)).toString());
                           }

                           return new float[]{var5, var6};
                        } else {
                           if (this.int_5 > 0) {
                              int var20 = this.int_5 - 1;
                              this.int_5 = var20;
                           }

                           return FLOAT_ARRAY;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   static {
      JsonObject var10000;
      label87: {
         JsonObject var0;
         try {
            var0 = new JsonParser()
               .parse(
                  "{\"EndWoolCorners\":[{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":2}],\"EndWoolCorners2\":[{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":3}],\"EndGlassNoCorners\":[{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"stained_glass\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"stained_glass\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"stained_glass\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"stained_glass\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"stained_glass\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"stained_glass\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"stained_glass\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"stained_glass\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"stained_glass\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"stained_glass\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"stained_glass\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"stained_glass\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"stained_glass\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"stained_glass\",\"x\":0,\"y\":1,\"z\":2}],\"WoodWoolCorners\":[{\"block\":\"planks\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"planks\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"planks\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"planks\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"planks\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"planks\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"planks\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"planks\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"planks\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"planks\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"planks\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"planks\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"planks\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"planks\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"planks\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"planks\",\"x\":0,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":1}],\"EndGlassWool\":[{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"stained_glass\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"stained_glass\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"stained_glass\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"stained_glass\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"stained_glass\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"stained_glass\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"stained_glass\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"stained_glass\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"stained_glass\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"stained_glass\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"stained_glass\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"stained_glass\",\"x\":0,\"y\":1,\"z\":2},{\"block\":\"stained_glass\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"stained_glass\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"wool\",\"x\":-3,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":-3,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":-2,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":-2,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":3},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":3},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":4},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":3},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":2,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":2,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":3,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":3,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":2},{\"block\":\"wool\",\"x\":-1,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":-2},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":-3},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":-2},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":-2},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":3,\"z\":0},{\"block\":\"wool\",\"x\":0,\"y\":3,\"z\":1}],\"Wool1Layer\":[{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":-1}],\"EndWoodLongCorners\":[{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"planks\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"planks\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"planks\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"planks\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"planks\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"planks\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"planks\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"planks\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"planks\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"planks\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"planks\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"planks\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"planks\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"planks\",\"x\":0,\"y\":1,\"z\":2},{\"block\":\"planks\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"planks\",\"x\":-1,\"y\":0,\"z\":2}],\"EndWoolLong\":[{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":2},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":-1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-2},{\"block\":\"end_stone\",\"x\":0,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":-1},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":0},{\"block\":\"end_stone\",\"x\":1,\"y\":0,\"z\":1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":-1},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":0},{\"block\":\"end_stone\",\"x\":0,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":-2,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":-1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":-1},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":0},{\"block\":\"wool\",\"x\":0,\"y\":2,\"z\":1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":-1},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":0},{\"block\":\"wool\",\"x\":1,\"y\":1,\"z\":1},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":-1},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":0},{\"block\":\"wool\",\"x\":2,\"y\":0,\"z\":1},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":2},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":3},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":2},{\"block\":\"wool\",\"x\":1,\"y\":0,\"z\":-2},{\"block\":\"wool\",\"x\":0,\"y\":1,\"z\":-2},{\"block\":\"wool\",\"x\":0,\"y\":0,\"z\":-3},{\"block\":\"wool\",\"x\":-1,\"y\":0,\"z\":-2}]}"
               )
               .getAsJsonObject();
         } catch (Exception var13) {
            var10000 = new JsonObject();
            break label87;
         }

         var10000 = var0;
      }

      Iterator var1;
      for (Iterator var19 = var1 = var10000.entrySet().iterator(); var19.hasNext(); var19 = var1) {
         Entry var2 = (Entry)var1.next();
         ArrayList var3 = new ArrayList();

         try {
            Iterator var4 = ((JsonElement)var2.getValue()).getAsJsonArray().iterator();

            label77:
            while (true) {
               Iterator var20 = var4;

               while (true) {
                  if (!var20.hasNext()) {
                     break label77;
                  }

                  JsonElement var5 = (JsonElement)var4.next();

                  try {
                     JsonObject var18;
                     String var6 = (var18 = var5.getAsJsonObject()).has("block") ? var18.get("block").getAsString() : "";
                     if (!var6.isEmpty()) {
                        int var10006;
                        JsonObject var10007;
                        if (var18.has("x")) {
                           var10006 = var18.get("x").getAsInt();
                           var10007 = var18;
                        } else {
                           var10006 = 0;
                           var10007 = var18;
                        }

                        int var22;
                        JsonObject var10008;
                        if (var10007.has("y")) {
                           var22 = var18.get("y").getAsInt();
                           var10008 = var18;
                        } else {
                           var22 = 0;
                           var10008 = var18;
                        }

                        BlockPos var10004 = new BlockPos(var10006, var22, var10008.has("z") ? var18.get("z").getAsInt() : 0);
                        BedDefenderModule.BlockOffsetRecord var10001 = new BedDefenderModule.BlockOffsetRecord(var6, var10004);
                        var3.add(var10001);
                        break;
                     }
                  } catch (Exception var11) {
                     break;
                  }

                  var20 = var4;
               }
            }
         } catch (Exception var12) {
         }

         MAP.put((String)var2.getKey(), var3);
      }

      BedDefenderModule.EndWoolCornersEndWoolCorners2Enum[] var14;
      int var15 = (var14 = BedDefenderModule.EndWoolCornersEndWoolCorners2Enum.values()).length;

      int var16;
      for (int var21 = var16 = 0; var21 < var15; var21 = ++var16) {
         BedDefenderModule.EndWoolCornersEndWoolCorners2Enum var17 = var14[var16];
         if (!MAP.containsKey(var17.getString5())) {
            Logger var7 = OnyxClient.LOGGER;
            Object[] var8 = new Object[1];
            String var9 = var17.getString5();
            var8[0] = var9;
            var7.warn("BedDefender: no defense named '{}' in the embedded JSON", var8);
         }
      }

      float[] var10 = new float[]{-999.0F, -999.0F};
      FLOAT_ARRAY = var10;
   }

   private static float getFloatForFloat18(float var0, float var1) {
      float var7 = ((var0 - var1 + 180.0F) % 360.0F + 360.0F) % 360.0F - 180.0F;
      return var1 + var7;
   }

   private static String getStringForItemStack(ItemStack var0) {
      if (var0 == null) {
         return null;
      } else {
         Block var2;
         if ((var2 = Util10.getBlockForItemStack2(var0)) != null) {
            return getStringForBlock(var2);
         } else {
            Object var3;
            return (var3 = Item.itemRegistry.getNameForObject(var0.getItem())) == null ? null : getStringForString7(var3.toString());
         }
      }
   }

   private static float[] getFloatArrayForVec32(Vec3 var0, double var1, double var3, double var5) {
      var1 -= var0.xCoord;
      var3 -= var0.yCoord;
      var5 -= var0.zCoord;
      double var7 = Math.sqrt(var1 * var1 + var5 * var5);
      float var11 = getFloatForFloat16((float)Math.toDegrees(Math.atan2(var5, var1)) - 90.0F);
      float var2 = (float)Math.toDegrees(-Math.atan2(var3, var7));
      return new float[]{var11, var2};
   }

   private static boolean isBlockPos9(BlockPos var0) {
      EnumFacing[] var1;
      int var2 = (var1 = EnumFacing.values()).length;

      int var5;
      for (int var10000 = var5 = 0; var10000 < var2; var10000 = ++var5) {
         EnumFacing var4 = var1[var5];
         if (!"air".equals(getStringForBlockPos2(var0.offset(var4)))) {
            return true;
         }
      }

      return false;
   }

   private static String getStringForBlockPos2(BlockPos var0) {
      return getStringForBlock(Util.getBlockForBlockPos(var0));
   }

   private float[] getFloatArray10() {
      float var12;
      float var5 = var12 = this.valueSettingSub109.getFloat5();
      var12 = Math.min(var12, 90.0F);
      YawPitchRecord var10001 = Util6.getYawPitchRecord25();
      float var11 = var10001.yaw();
      float var4 = var10001.pitch();
      if (!this.bool3) {
         BlockPos var20;
         if (this.valueSettingSub92.isEnabled17()) {
            if ((var20 = Cls.CLS.getBlockPos7()) == null) {
               this.handleString15("no whitelisted bed. disabling.");
               return this.getFloatArray5();
            }

            if (!"bed".equalsIgnoreCase(getStringForBlockPos2(var20))) {
               this.handleString15("whitelisted bed pos is stale/not a bed. disabling.");
               return this.getFloatArray5();
            }
         } else {
            if ((var20 = this.getBlockPos8(16)) == null) {
               this.handleString15("no bed in range. disabling.");
               return this.getFloatArray5();
            }

            if (!"bed".equalsIgnoreCase(getStringForBlockPos2(var20))) {
               this.handleString15("findBed returned invalid target. disabling.");
               return this.getFloatArray5();
            }
         }

         this.handleString15(
            new StringBuilder().insert(0, "bed found at ").append(var20.getX()).append(",").append(var20.getY()).append(",").append(var20.getZ()).toString()
         );
         this.blockPos = var20;
         BedDefenderModule var10000;
         switch (getIntForBlockPos(var20)) {
            case 0:
            case 10:
               var10000 = this;


               this.string3 = "north";
               break;
            case 1:
            case 11:
               var10000 = this;
               this.string3 = "east";
               break;
            case 2:
            case 8:
               var10000 = this;
               this.string3 = "south";
               break;
            case 3:
            case 9:
               var10000 = this;
               this.string3 = "west";
               break;
            case 4:
            case 5:
            case 6:
            case 7:
            default:
               var10000 = this;
               this.string3 = "";
         }

         var10000.handleString15(new StringBuilder().insert(0, "lockedDirection=").append(this.string3).toString());
         this.bool3 = true;
      }

      this.run146();
      this.run145();
      int var29 = 0;
      boolean var6 = false;
      ArrayList var7 = new ArrayList();
      ArrayList var8 = new ArrayList();
      Vec3 var9 = Util4.getVec323();

      int var10;
      for (int var30 = var10 = 0; var30 < this.list2.size(); var30 = ++var10) {
         BedDefenderModule.BlockOffsetRecord var3 = this.list2.get(var10);
         BlockPos var1 = this.blockPos.add(getBlockPosForBlockPos(var3.offset(), this.string3));
         if ("air".equals(getStringForBlockPos2(var1))) {
            var29++;
            var8.add(var1);
            boolean var13 = this.set.contains(var3.block().toLowerCase());
            var6 |= var13;
            if (var13 && isBlockPos9(var1) && isBlockPos7(var1)) {
               double var14 = var1.getX() + 0.5 - var9.xCoord;
               double var16 = var1.getY() + 0.5 - var9.yCoord;
               double var18 = var1.getZ() + 0.5 - var9.zCoord;
               if (!((var14 = var14 * var14 + var16 * var16 + var18 * var18) > 36.0)) {
                  var7.add(new BedDefenderModule.PosBlockRecord(var1, var3.block(), var10, var14));
               }
            }
         }
      }

      if (var29 == 0) {
         this.handleString15("done (pattern filled).");
         return this.getFloatArray5();
      } else if (!var6) {
         this.handleString15("no block left in the hotbar for anything still open (disabling)");
         return this.getFloatArray5();
      } else {
         HashMap var26 = new HashMap();
         Iterator var24;
         Iterator var31 = var24 = var7.iterator();

         while (var31.hasNext()) {
            BedDefenderModule.PosBlockRecord var23 = (BedDefenderModule.PosBlockRecord)var24.next();
            var31 = var24;
            var26.put(var23.pos(), getIntForPosBlockRecord(var23, var8, var9));
         }

         var7.sort(Comparator.<BedDefenderModule.PosBlockRecord>comparingInt(var1x -> (Integer)var26.get(var1x.pos())).thenComparing(this.getComparator4()));
         float[] var25;
         if ((var25 = this.getFloatArray9(var7, var11, var4, var5, var12)) != null) {
            return var25;
         } else {
            this.int_4++;
            if (this.valueSettingSub106.getInt10() > 0) {
               int var21 = this.int_4;
               int var22 = this.valueSettingSub106.getInt10();
               if (var21 > var22) {
                  this.handleString15("nothing placeable for " + this.int_4 + " ticks (disabling)");
                  return this.getFloatArray5();
               }
            }

            this.blockPos3 = var7.isEmpty() ? null : ((BedDefenderModule.PosBlockRecord)var7.get(0)).pos();
            return null;
         }
      }
   }

   public boolean isEnabled110() {
      return this.isEnabled55();
   }

   private void run148() {
      this.bool4 = false;
      Util6.run183();
      this.handleBool16(false);
   }

   private float[] getFloatArray5() {
      this.bool4 = true;
      return null;
   }

   private float[] getFloatArray8(BedDefenderModule.PosBlockRecord var1, float var2, float var3, float var4, float var5) {
      BlockPos var49 = var1.pos();
      String var6 = var1.block();
      float[] var9;
      if ((var9 = this.getFloatArray7(var2, var3, var49, var6, var2, var3)) != null) {
         return var9[1] == -999.0F ? this.getFloatArray6(var2, var3, var2, var3) : var9;
      } else {
         EnumFacing[] var45 = new EnumFacing[]{EnumFacing.DOWN, EnumFacing.UP, EnumFacing.SOUTH, EnumFacing.NORTH, EnumFacing.WEST, EnumFacing.EAST};
         EnumFacing[] var7 = var45;
         int[] var46 = new int[]{0, 0, 0, 0, 1, -1};
         int[] var8 = var46;
         int[] var47 = new int[]{1, -1, 0, 0, 0, 0};
         int[] var50 = var47;
         int[] var48 = new int[]{0, 0, -1, 1, 0, 0};
         int[] var10 = var48;
         Vec3 var11 = Util4.getVec323();
         float var12 = getFloatForFloat16(var2);
         float var14 = getFloatForFloat16(MINECRAFT.thePlayer.rotationYaw);
         float var15 = MINECRAFT.thePlayer.rotationPitch;
         double var16 = 0.05;
         double var18 = 0.2;
         double var20 = 0.2;
         double var22 = 1.0 - var16 - 0.001;
         var16 += 0.001;
         int var24 = (int)Math.round(1.0 / var18);
         ArrayList<Object[]> var25 = new ArrayList<>((var24 + 1) * (var24 + 1) * 6);

         int var44;
         for (int var61 = var44 = 0; var61 < 6; var61 = ++var44) {
            EnumFacing var27 = var7[var44];
            BlockPos var28;
            String var29;
            int var30;
            if (!(var29 = getStringForBlockPos2(var28 = var49.add(var8[var44], var50[var44], var10[var44]))).equals("air")
               && (!this.valueSettingSub93.isEnabled17() || !var29.equals("bed") || var27 == EnumFacing.UP)) {
               for (int var62 = var30 = 0; var62 <= var24; var62 = ++var30) {
                  boolean var31 = (var30 & 1) == 0;
                  double var32;
                  if ((var32 = var30 * var18 + getDoubleForDouble4(-var18 * var20, var18 * var20)) < 0.0) {
                     var32 = 0.0;
                  } else if (var32 > 1.0) {
                     var32 = 1.0;
                  }

                  int var34;
                  for (int var63 = var34 = 0; var63 <= var24; var63 = ++var34) {
                     double var35;
                     boolean var64;
                     if ((var35 = var34 * var18 + getDoubleForDouble4(-var18 * var20, var18 * var20)) < 0.0) {
                        var35 = 0.0;
                        var64 = var31;
                     } else {
                        if (var35 > 1.0) {
                           var35 = 1.0;
                        }

                        var64 = var31;
                     }

                     double var37 = var64 ? var35 : 1.0 - var35;
                     double var39;
                     double var41;
                     Vec3 var65;
                     if (var44 < 2) {
                        var35 = var28.getX() + var37;
                        var41 = var28.getZ() + var32;
                        var39 = var28.getY() + (var44 == 1 ? var22 : var16);
                        var65 = var11;
                     } else if (var44 < 4) {
                        var35 = var28.getX() + var37;
                        var39 = var28.getY() + var32;
                        var41 = var28.getZ() + (var44 == 2 ? var22 : var16);
                        var65 = var11;
                     } else {
                        var41 = var28.getZ() + var37;
                        var39 = var28.getY() + var32;
                        var35 = var28.getX() + (var44 == 5 ? var22 : var16);
                        var65 = var11;
                     }

                     float[] var66 = getFloatArrayForVec32(var65, var35, var39, var41);
                     float var43 = var66[0];
                     float var59 = var66[1];
                     if (!(Math.abs(getFloatForFloat17(var14, var43)) > var4) && !(Math.abs(var59 - var15) > var5) && !(Math.abs(var59) > 90.0F)) {
                        var35 = Math.abs((double)getFloatForFloat17(var12, var43)) + Math.abs((double)(var59 - var3)) + (var27 == EnumFacing.UP ? -0.25 : 0.0);
                        Object[] var10001 = new Object[3];
                        boolean var10003 = true;
                        var10001[0] = var35;
                        var10001[1] = var43;
                        var10001[2] = var59;
                        var25.add(var10001);
                     }
                  }
               }
            }
         }

         if (var25.isEmpty()) {
            this.handleString15("no aim candidates (FOV/angles?)");
            return null;
         } else {
            var25.sort(Comparator.comparingDouble(var0 -> (Double)var0[0]));
            Iterator var60 = var25.iterator();

            while (var60.hasNext()) {
               Object[] var52;
               float var53 = (Float)(var52 = (Object[])var60.next())[1];
               float var54 = (Float)var52[2];
               float var55 = getFloatForFloat18(var53, var2);
               float[] var56;
               if ((var56 = this.getFloatArray7(var55, var54, var49, var6, var2, var3)) != null) {
                  if (var56[1] == -999.0F) {
                     return this.getFloatArray6(var2, var3, var55, var54);
                  }

                  return var56;
               }
            }

            return null;
         }
      }
   }

   private static boolean isBlockPos7(BlockPos var0) {
      return MINECRAFT.theWorld.checkNoEntityCollision(Util.AXIS_ALIGNED_B_B.offset(var0.getX(), var0.getY(), var0.getZ()));
   }

   private static float getFloatForFloat17(float var0, float var1) {
      float var2;
      float var10000 = var2 = var1 - var0;

      while (var10000 <= -180.0F) {
         var10000 = var2 += 360.0F;
      }

      var10000 = var2;

      while (var10000 > 180.0F) {
         var10000 = var2 -= 360.0F;
      }

      return var2;
   }

   private static int getIntForPosBlockRecord(BedDefenderModule.PosBlockRecord var0, List<BlockPos> var1, Vec3 var2) {
      AxisAlignedBB var5 = new AxisAlignedBB(
         var0.pos().getX(), var0.pos().getY(), var0.pos().getZ(), var0.pos().getX() + 1, var0.pos().getY() + 1, var0.pos().getZ() + 1
      );
      int var4 = 0;
      Iterator var7 = var1.iterator();

      label24:
      while (true) {
         Iterator var10000 = var7;

         while (var10000.hasNext()) {
            BlockPos var6;
            if ((var6 = (BlockPos)var7.next()).equals(var0.pos())) {
               var10000 = var7;
            } else {
               Vec3 var8 = new Vec3(var6.getX() + 0.5, var6.getY() + 0.5, var6.getZ() + 0.5);
               if (!(var2.squareDistanceTo(var8) <= var0.distance())) {
                  if (var5.calculateIntercept(var2, var8) != null) {
                     var4++;
                  }
                  continue label24;
               }

               var10000 = var7;
            }
         }

         return var4;
      }
   }

   private static String getStringForBlockPos(BlockPos var0) {
      return var0.getX() + "," + var0.getY() + "," + var0.getZ();
   }

   @Override
   protected void run80() {
      Map var1 = MAP;
      String var5 = this.valueSettingSub114.lambda15().getString5();
      ArrayList var6 = new ArrayList();
      List var8 = (List)var1.getOrDefault(var5, var6);
      this.list2 = var8;
      BedDefenderModule var10000;
      if (this.list2.isEmpty()) {
         this.handleString15("enabled, but no defenses loaded.");
         var10000 = this;
      } else {
         this.handleString15(
            new StringBuilder()
               .insert(0, "enabled. defense='")
               .append(this.valueSettingSub114.lambda15().getString5())
               .append("' steps=")
               .append(this.list2.size())
               .toString()
         );
         List var9 = this.list2;
         if (!this.isList2(var9)) {
            this.handleString15("no required blocks for selected defense in hotbar (disabling)");
            this.bool4 = true;
         }

         var10000 = this;
      }

      var10000.blockPos3 = null;
      this.blockPos2 = null;
      this.int_2 = 0;
      this.int_4 = 0;
      this.map.clear();
      this.set.clear();
      this.bool3 = false;
      this.bool2 = false;
      this.string3 = "";
      this.int_5 = this.valueSettingSub105.getInt10();
      this.map2.clear();
   }

   private boolean isBlockPos8(BlockPos var1, EnumFacing var2) {
      return "air".equalsIgnoreCase(getStringForBlockPos2(var1.offset(var2)));
   }

   private static int getIntForBlockPos(BlockPos var0) {
      IBlockState var2;
      return (var2 = Util.getIBlockStateForBlockPos(var0)) != null && var2.getBlock() instanceof BlockBed
         ? var2.getValue(BlockBed.FACING).getHorizontalIndex() | (var2.getValue(BlockBed.PART) == EnumPartType.HEAD ? 8 : 0)
         : -1;
   }

   @EventHandler
   public void handleEventSub104(EventSub10 var1) {
      if (MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null) {
         if (this.bool4) {
            this.run148();
         } else {
            this.run147();
            float[] var2 = this.getFloatArray10();
            if (this.bool4) {
               this.run148();
            } else if (var2 == null) {
               Util6.run183();
            } else {
               Util6.handleYawPitchRecord3(new YawPitchRecord(var2[0], var2[1]), this.valueSettingSub112.lambda15());
            }
         }
      }
   }

   private static BlockPos getBlockPosForBlockPos(BlockPos var0, String var1) {
      int var7;
      int var4;
      int var5;
      byte var11;
      label36: {
         var7 = var0.getX();
         var5 = var0.getY();
         var4 = var0.getZ();
         byte var2 = -1;
         switch (var1.hashCode()) {
            case 3105789:

               if (var1.equals("east")) {
                  var11 = var2 = 2;
                  break label36;
               }
               break;
            case 3645871:
               if (var1.equals("west")) {
                  var2 = 3;
               }
               break;
            case 105007365:
               if (var1.equals("north")) {
                  var11 = var2 = 0;
                  break label36;
               }
               break;
            case 109627853:
               if (var1.equals("south")) {
                  var11 = var2 = 1;
                  break label36;
               }
         }

         var11 = var2;
      }

      switch (var11) {
         case 0:
            return new BlockPos(var7, var5, var4);
         case 1:
            return new BlockPos(-var7, var5, -var4);
         case 2:
            return new BlockPos(-var4, var5, var7);
         case 3:
            return new BlockPos(var4, var5, -var7);
         default:
            return var0;
      }
   }

   private float[] getFloatArray9(List<BedDefenderModule.PosBlockRecord> var1, float var2, float var3, float var4, float var5) {
      BedDefenderModule.PosBlockRecord var11;
      BedDefenderModule.PosBlockRecord var10000;
      label58: {
         var11 = null;
         if (this.blockPos2 != null) {
            Iterator var7 = var1.iterator();

            while (var7.hasNext()) {
               BedDefenderModule.PosBlockRecord var8;
               if ((var8 = (BedDefenderModule.PosBlockRecord)var7.next()).pos().equals(this.blockPos2)) {
                  var10000 = var11 = var8;
                  break label58;
               }
            }
         }

         var10000 = var11;
      }

      if (var10000 != null && this.int_2 > 0) {
         this.int_2--;
         float[] var12;
         if ((var12 = this.getFloatArray8(var11, var2, var3, var4, var5)) != null) {
            this.blockPos3 = var11.pos();
            this.int_4 = 0;
            return var12;
         }

         this.handleString15(new StringBuilder().insert(0, "lost the aim on ").append(getStringForBlockPos(var11.pos())).append(", moving on").toString());
         this.handleBlockPos4(var11.pos());
      }

      this.blockPos2 = null;
      int var13 = this.valueSettingSub107.getInt10();
      int var14 = 0;
      int var17;
      Iterator var15;
      Iterator var16 = var15 = var1.iterator();

      while (true) {
         if (!var16.hasNext()) {
            var17 = var14;
            break;
         }

         BedDefenderModule.PosBlockRecord var9 = (BedDefenderModule.PosBlockRecord)var15.next();
         if (this.map.containsKey(var9.pos())) {
            var16 = var15;
         } else {
            if (var14 >= var13) {
               var17 = var14;
               break;
            }

            var14++;
            float[] var10;
            if ((var10 = this.getFloatArray8(var9, var2, var3, var4, var5)) != null) {
               this.blockPos2 = var9.pos();
               this.int_2 = this.valueSettingSub104.getInt10();
               this.blockPos3 = var9.pos();
               this.int_4 = 0;
               return var10;
            }

            this.handleBlockPos4(var9.pos());
            var16 = var15;
         }
      }

      if (var17 == 0 && !var1.isEmpty()) {
         this.map.clear();
      }

      return null;
   }

   private static void handleBool22(boolean var0) {
      KeyBinding.setKeyBindState(MINECRAFT.gameSettings.keyBindSneak.getKeyCode(), var0);
   }

   private void handleString15(String var1) {
      if (this.valueSettingSub9.isEnabled17()) {
         Abstract_.handleString2(new StringBuilder().insert(0, "[beddef] ").append(var1).toString());
      }
   }

   private void run146() {
      this.map.entrySet().removeIf(var0 -> {
         Integer var5 = var0.getValue() - 1;
         Object var6 = var0.setValue(var5);
         return var0.getValue() <= 0;
      });
   }

   public BedDefenderModule() {
      super("BedDefender", "Walls your bed in with a preset defense pattern", ModuleCategory.COMBAT);
      this.valueSettingSub92 = new ValueSettingSub9("Bedwars Only", true)
         .getBooleanSetting("Anchor to the tracked team bed instead of the nearest bed in range");
      this.valueSettingSub108 = new ValueSettingSub10("Delay After Swap", 0.0, 0.0, 10.0, 1.0).getValueSettingSub10(" ticks");
      this.valueSettingSub105 = new ValueSettingSub10("Delay After Aiming", 0.0, 0.0, 10.0, 1.0).getValueSettingSub10(" ticks");
      this.valueSettingSub103 = new ValueSettingSub10("Sneak Hold Ticks", 5.0, 0.0, 20.0, 1.0).getValueSettingSub10(" ticks");
      this.valueSettingSub10 = new ValueSettingSub10("Aim Speed", 20.0, 1.0, 180.0, 1.0).getValueSettingSub10(" deg/t");
      this.valueSettingSub109 = new ValueSettingSub10("FOV", 180.0, 0.0, 180.0, 1.0)
         .getBooleanSetting("How far off your own aim a candidate placement angle may be");
      this.valueSettingSub114 = new ValueSettingSub11<>("Defense", BedDefenderModule.EndWoolCornersEndWoolCorners2Enum.END_GLASS_NO_CORNERS);
      this.valueSettingSub113 = new ValueSettingSub11<>("Order", BedDefenderModule.BottomUpFurthestEnum.BOTTOM_UP)
         .getBooleanSetting(
            "Which open spot to wall in first when several are placeable - whatever this says, a spot standing in front of another is still left for last"
         );
      this.valueSettingSub107 = new ValueSettingSub10("Targets Per Tick", 4.0, 1.0, 16.0, 1.0)
         .getBooleanSetting("How many different spots to search for an aim each tick before giving up on the tick");
      this.valueSettingSub104 = new ValueSettingSub10("Target Lock", 30.0, 5.0, 100.0, 5.0)
         .getValueSettingSub10(" ticks")
         .getBooleanSetting("How long to keep turning toward one spot before writing it off and trying another");
      this.valueSettingSub102 = new ValueSettingSub10("Retry Cooldown", 20.0, 0.0, 100.0, 5.0)
         .getValueSettingSub10(" ticks")
         .getBooleanSetting("How long a spot that could not be reached is skipped before it is tried again");
      this.valueSettingSub106 = new ValueSettingSub10("Stuck Timeout", 100.0, 0.0, 400.0, 20.0)
         .getValueSettingSub10(" ticks")
         .getBooleanSetting("Turn off after this long with nothing placeable - 0 never gives up");
      this.valueSettingSub112 = new ValueSettingSub11<>("Move fix", OffStrictEnum.SILENT)
         .getBooleanSetting("Keeps movement consistent with the rotation the server sees");
      this.valueSettingSub9 = new ValueSettingSub9("Debug Logs", false);
      this.string3 = "";
      this.map2 = new HashMap<>();
      this.list2 = new ArrayList<>();
      this.map = new HashMap<>();
      this.set = new HashSet<>();
   }

   public record BlockOffsetRecord(String block, BlockPos offset) {
   }

   public static enum BottomUpFurthestEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      BOTTOM_UP("Bottom Up"),
      FURTHEST("Furthest"),
      NEAREST("Nearest"),
      PATTERN("Pattern");
      private final String string;

      @Override
      public String getString5() {
         return this.string;
      }

      private BottomUpFurthestEnum(String var3) {
         this.string = var3;
      }

   }

   public static enum EndWoolCornersEndWoolCorners2Enum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      END_WOOL_CORNERS("EndWoolCorners"),
      END_WOOL_CORNERS_2("EndWoolCorners2"),
      END_GLASS_NO_CORNERS("EndGlassNoCorners"),
      WOOD_WOOL_CORNERS("WoodWoolCorners"),
      END_GLASS_WOOL("EndGlassWool"),
      WOOL_1_LAYER("Wool1Layer"),
      END_WOOD_LONG_CORNERS("EndWoodLongCorners"),
      END_WOOL_LONG("EndWoolLong");
      private final String string;

      static {
         BedDefenderModule.EndWoolCornersEndWoolCorners2Enum[] var0 = new BedDefenderModule.EndWoolCornersEndWoolCorners2Enum[]{
            END_WOOL_CORNERS, END_WOOL_CORNERS_2, END_GLASS_NO_CORNERS, WOOD_WOOL_CORNERS, END_GLASS_WOOL, WOOL_1_LAYER, END_WOOD_LONG_CORNERS, END_WOOL_LONG
         };
      }

      private EndWoolCornersEndWoolCorners2Enum(String var3) {
         this.string = var3;
      }

      @Override
      public String getString5() {
         return this.string;
      }
   }

   private record PosBlockRecord(BlockPos pos, String block, int index, double distance) {
   }
}
