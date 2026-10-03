package client.onyx.module.render;

import client.onyx.event.impl.EventSub6;
import client.onyx.interact.Util;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Sampler0;
import client.onyx.render.Util15;
import client.onyx.render.Util7;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.theme.impl.Util2;
import client.onyx.util.Cls7;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public final class BedESPModule extends Module {
   private static final double DOUBLE = 0.5625D;
   public final ValueSettingSub9 valueSettingSub9;
   public final ValueSettingSub10 valueSettingSub10;
   public final ValueSettingSub9 valueSettingSub93 = (new ValueSettingSub9("Own bed", true)).getBooleanSetting("Highlight the bed the tracker believes is yours");
   public final ValueSettingSub9 valueSettingSub92 = (new ValueSettingSub9("Enemy beds", true)).getBooleanSetting("Highlight every other bed");
   public final ValueSettingSub10 valueSettingSub102;
   public final ValueSettingSub10 valueSettingSub103;
   private boolean bool2;
   public final ValueSettingSub9 valueSettingSub94;
   public final ValueSettingSub10 valueSettingSub104;
   public final ValueSettingSub6 valueSettingSub6;
   public final ValueSettingSub9 valueSettingSub95;
   public final ValueSettingSub9 valueSettingSub96;
   private final List<BlockPos> list2;
   private static final double DOUBLE2 = 0.003D;
   public ValueSettingSub9 valueSettingSub97;
   private final Cls cls;
   public final ValueSettingSub10 valueSettingSub105;
   public final ValueSettingSub10 valueSettingSub106;
   public final ValueSettingSub10 valueSettingSub107;
   public final ValueSettingSub6 valueSettingSub62;
   public final ValueSettingSub9 valueSettingSub98;
   private static final int INT = 8;
   private final List<BedESPModule.PosColorRecord> list3;
   public final ValueSettingSub9 valueSettingSub99;
   public final ValueSettingSub10 valueSettingSub108;
   public final ValueSettingSub9 valueSettingSub910;
   public final ValueSettingSub9 valueSettingSub911;
   public final ValueSettingSub6 valueSettingSub63;
   public final ValueSettingSub6 valueSettingSub64;
   public final ValueSettingSub10 valueSettingSub109;
   private final List<BedESPModule.BedOwnRecord> list4;
   private final Cls7 cls7;

   protected void run80() {
      this.run91();
   }

   private static List<BedESPModule.IconNameRecord> getListForMap(Map<Integer, int[]> var0, Map<Integer, IBlockState> var1) {
      ArrayList var7 = new ArrayList();

      Iterator var3;
      for(Iterator var10000 = var3 = var0.entrySet().iterator(); var10000.hasNext(); var10000 = var3) {
         Entry var4 = (Entry)var3.next();
         IBlockState var5;
         Block var6 = (var5 = (IBlockState)var1.get(var4.getKey())).getBlock();
         var7.add(new BedESPModule.IconNameRecord(new ItemStack(var6, 1, var6.damageDropped(var5)), var6.getLocalizedName(), ((int[])var4.getValue())[0]));
      }

      var7.sort(Comparator.comparingInt(BedESPModule.IconNameRecord::count).reversed());
      return var7;
   }

   public void handleFloat46(float var1) {
      if (this.isEnabled55() && MINECRAFT.theWorld != null && MINECRAFT.thePlayer != null) {
         if (!this.bool2 || this.cls7.isLong2((long)this.valueSettingSub102.getInt10())) {
            this.run93();
            this.cls7.run();
            this.bool2 = true;
         }

         if (!this.list2.isEmpty()) {
            boolean var4 = false;
            float var5 = this.valueSettingSub108.getFloat5() / 100.0F;
            Iterator var8;
            Iterator var10000 = var8 = (this.valueSettingSub911.isEnabled17() ? this.list3 : List.of()).iterator();

            while(var10000.hasNext()) {
               BedESPModule.PosColorRecord var3 = (BedESPModule.PosColorRecord)var8.next();
               AxisAlignedBB var6;
               if ((var6 = this.getAxisAlignedBB3(var3.pos())) == null) {
                  var10000 = var8;
               } else {
                  if (!var4) {
                     if (!Util7.isFloat3(var1, this.valueSettingSub99.isEnabled17())) {
                        return;
                     }

                     var4 = true;
                  }

                  Util7.handleAxisAlignedBB2(var6, Util2.getIntForInt3(var3.color(), var5), this.valueSettingSub105.getFloat5(), this.valueSettingSub94.isEnabled17() ? Util2.getIntForInt3(var3.color(), var5 * 0.18F) : 0);
                  var10000 = var8;
               }
            }

            var10000 = var8 = this.list2.iterator();

            while(true) {
               while(var10000.hasNext()) {
                  BlockPos var9 = (BlockPos)var8.next();
                  boolean var11;
                  if ((var11 = client.onyx.module.combat.Cls.CLS.isBlockPos6(var9)) && !this.valueSettingSub93.isEnabled17()) {
                     var10000 = var8;
                  } else if (!var11 && !this.valueSettingSub92.isEnabled17()) {
                     var10000 = var8;
                  } else {
                     AxisAlignedBB var10;
                     if ((var10 = this.getAxisAlignedBB2(var9)) == null) {
                        var10000 = var8;
                     } else {
                        if (!var4) {
                           if (!Util7.isFloat3(var1, this.valueSettingSub99.isEnabled17())) {
                              return;
                           }

                           var4 = true;
                        }

                        int var7 = var11 ? this.valueSettingSub62.lambda15() : this.valueSettingSub6.lambda15();
                        Util7.handleAxisAlignedBB2(var10, Util2.getIntForInt3(var7, (float)Util2.getIntForInt6(var7) / 255.0F * 0.95F), this.valueSettingSub105.getFloat5(), this.valueSettingSub94.isEnabled17() ? Util2.getIntForInt3(var7, (float)Util2.getIntForInt6(var7) / 255.0F * 0.16F) : 0);
                        var10000 = var8;
                     }
                  }
               }

               if (var4) {
                  Util7.run49();
               }

               this.handleFloat45(var1);
               return;
            }
         }
      }
   }

   private void run91() {
      this.list2.clear();
      this.list3.clear();
      this.list4.clear();
      this.bool2 = false;
   }

   private static boolean isBlockPos3(BlockPos var0) {
      EnumFacing[] var1;
      int var2 = (var1 = EnumFacing.values()).length;

      int var5;
      for(int var10000 = var5 = 0; var10000 < var2; var10000 = var5) {
         EnumFacing var4 = var1[var5];
         if (Util.isBlockPos2(var0.offset(var4))) {
            return true;
         }

         ++var5;
      }

      return false;
   }

   private void run93() {
      this.list2.clear();
      IChunkProvider var13 = MINECRAFT.theWorld.getChunkProvider();
      if (var13 instanceof ChunkProviderClient) {
         ChunkProviderClient var1 = (ChunkProviderClient)var13;
         int var10 = Block.getIdFromBlock(Blocks.bed);
         Iterator var15 = var1.getLoadedChunks().iterator();

         while(true) {
            label43:
            while(true) {
               for(Iterator var10000 = var15; var10000.hasNext(); var10000 = var15) {
                  Chunk var8;
                  if ((var8 = (Chunk)var15.next()) == null) {
                     continue label43;
                  }

                  if (!var8.isEmpty()) {
                     int var16 = var8.xPosition << 4;
                     int var4 = var8.zPosition << 4;
                     ExtendedBlockStorage[] var5;
                     int var6 = (var5 = var8.getBlockStorageArray()).length;

                     int var7;
                     for(int var19 = var7 = 0; var19 < var6; var19 = var7) {
                        ExtendedBlockStorage var12;
                        if ((var12 = var5[var7]) != null && !var12.isEmpty()) {
                           char[] var17 = var12.getData();
                           int var9 = var12.getYLocation();

                           int var2;
                           for(var19 = var2 = 0; var19 < var17.length; var19 = var2) {
                              char var11;
                              if ((var11 = var17[var2]) >> 4 == var10 && (var11 & 8) != 0) {
                                 this.list2.add(new BlockPos(var16 + (var2 & 15), var9 + (var2 >> 8 & 15), var4 + (var2 >> 4 & 15)));
                              }

                              ++var2;
                           }
                        }

                        ++var7;
                     }
                     continue label43;
                  }
               }

               this.run92();
               return;
            }
         }
      }
   }

   private AxisAlignedBB getAxisAlignedBB3(BlockPos var1) {
      return Util.isBlockPos2(var1) ? null : Util.getAxisAlignedBBForBlockPos(var1).offset((double)var1.getX(), (double)var1.getY(), (double)var1.getZ()).expand(0.003D, 0.003D, 0.003D);
   }

   private void run92() {
      this.list3.clear();
      this.list4.clear();
      if (this.valueSettingSub911.isEnabled17() || this.valueSettingSub97.isEnabled17()) {
         int var6 = this.valueSettingSub10.getInt10();
         HashSet var17 = new HashSet();
         Iterator var19 = this.list2.iterator();

         label123:
         while(true) {
            Iterator var10000 = var19;

            while(true) {
               while(var10000.hasNext()) {
                  BlockPos var4 = (BlockPos)var19.next();
                  boolean var5;
                  if ((var5 = client.onyx.module.combat.Cls.CLS.isBlockPos6(var4)) && !this.valueSettingSub93.isEnabled17()) {
                     var10000 = var19;
                  } else if (!var5 && !this.valueSettingSub92.isEnabled17()) {
                     var10000 = var19;
                  } else {
                     IBlockState var25;
                     if ((var25 = MINECRAFT.theWorld.getBlockState(var4)).getBlock() instanceof BlockBed) {
                        BlockPos var33 = var4.offset(((EnumFacing)var25.getValue(BlockBed.FACING)).getOpposite());
                        int var7 = Math.min(var4.getX(), var33.getX()) - var6;
                        int var8 = Math.max(var4.getX(), var33.getX()) + var6;
                        int var9 = Math.min(var4.getZ(), var33.getZ()) - var6;
                        int var10 = Math.max(var4.getZ(), var33.getZ()) + var6;
                        int var11 = var4.getY();
                        int var12 = Math.min(255, var4.getY() + var6);
                        LinkedHashMap var13 = new LinkedHashMap();
                        LinkedHashMap var14 = new LinkedHashMap();
                        int var15 = 0;
                        HashSet var16 = new HashSet();
                        ArrayDeque var2 = new ArrayDeque();
                        Iterator var34 = List.of(var4, var33).iterator();

                        int var20;
                        int var27;
                        while(var34.hasNext()) {
                           BlockPos var18 = (BlockPos)var34.next();
                           var16.add(var18);
                           EnumFacing[] var3 = EnumFacing.values();
                           var20 = var3.length;

                           int var21;
                           for(var27 = var21 = 0; var27 < var20; var27 = var21) {
                              EnumFacing var22 = var3[var21];
                              BlockPos var23;
                              if ((var23 = var18.offset(var22)).getY() >= var11) {
                                 var2.add(var23);
                              }

                              ++var21;
                           }
                        }

                        while(true) {
                           label113:
                           while(true) {
                              ArrayDeque var28 = var2;

                              while(!var28.isEmpty()) {
                                 if ((var33 = (BlockPos)var2.poll()).getY() < var11) {
                                    continue label113;
                                 }

                                 if (var33.getY() > var12) {
                                    var28 = var2;
                                 } else {
                                    if (var33.getX() < var7) {
                                       continue label113;
                                    }

                                    if (var33.getX() > var8) {
                                       var28 = var2;
                                    } else {
                                       if (var33.getZ() < var9) {
                                          continue label113;
                                       }

                                       if (var33.getZ() > var10) {
                                          var28 = var2;
                                       } else if (!var16.add(var33)) {
                                          var28 = var2;
                                       } else {
                                          Block var26;
                                          IBlockState var29;
                                          if ((var26 = (var29 = MINECRAFT.theWorld.getBlockState(var33)).getBlock()).getMaterial() == Material.air) {
                                             var28 = var2;
                                          } else if (!var26.getMaterial().isSolid()) {
                                             var28 = var2;
                                          } else {
                                             if (!(var26 instanceof BlockBed)) {
                                                var20 = Block.getIdFromBlock(var26) << 4 | var26.damageDropped(var29) & 15;
                                                int var10002 = ((int[])var13.computeIfAbsent(var20, (var0) -> {
                                                   return new int[1];
                                                }))[0]++;
                                                ++var15;
                                                var14.putIfAbsent(var20, var29);
                                                if (isBlockPos3(var33) && var17.add(var33)) {
                                                   this.list3.add(new BedESPModule.PosColorRecord(var33, getIntForIBlockState(var29)));
                                                }

                                                EnumFacing[] var30;
                                                int var31 = (var30 = EnumFacing.values()).length;

                                                int var32;
                                                for(var27 = var32 = 0; var27 < var31; var27 = var32) {
                                                   EnumFacing var24 = var30[var32];
                                                   ++var32;
                                                   var2.add(var33.offset(var24));
                                                }
                                                continue label113;
                                             }

                                             var28 = var2;
                                          }
                                       }
                                    }
                                 }
                              }

                              if (this.valueSettingSub97.isEnabled17() && var15 > 0) {
                                 this.list4.add(new BedESPModule.BedOwnRecord(var4, var5, getListForMap(var13, var14), var15));
                              }
                              continue label123;
                           }
                        }
                     }

                     var10000 = var19;
                  }
               }

               return;
            }
         }
      }
   }

   public List<BedESPModule.BedOwnRecord> getList19() {
      return this.list4;
   }

   public BedESPModule() {
      super("BedESP", "Highlights beds through walls", ModuleCategory.RENDER);
      this.valueSettingSub62 = (new ValueSettingSub6("Own color", -9706613)).getBooleanSetting("Colour of your own bed").getModeSetting(this.valueSettingSub93);
      this.valueSettingSub6 = (new ValueSettingSub6("Enemy color", -38302)).getBooleanSetting("Colour of enemy beds").getModeSetting(this.valueSettingSub92);
      this.valueSettingSub911 = (new ValueSettingSub9("Defense", false)).getBooleanSetting("Outline the blocks walling each bed in, coloured by what they are made of").getModeSetting3((var1) -> {
         this.run91();
      });
      this.valueSettingSub10 = (new ValueSettingSub10("Defense radius", 3.0D, 1.0D, 6.0D, 1.0D)).getValueSettingSub10(" m").getBooleanSetting("How far around a bed counts as its defense").getSetting2(() -> {
         return this.valueSettingSub911.isEnabled17() || this.valueSettingSub97.isEnabled17();
      }).getModeSetting3((var1) -> {
         this.run91();
      });
      this.valueSettingSub108 = (new ValueSettingSub10("Defense opacity", 70.0D, 10.0D, 100.0D, 5.0D)).getValueSettingSub10("%").getBooleanSetting("How strongly the defense outlines are drawn").getModeSetting(this.valueSettingSub911);
      this.valueSettingSub97 = (new ValueSettingSub9("Defense tags", false)).getBooleanSetting("Float the blocks making up each bed's defense above the bed itself").getModeSetting3((var1) -> {
         this.run91();
      });
      this.valueSettingSub107 = (new ValueSettingSub10("Tag scale", 1.0D, 0.5D, 2.0D, 0.05D)).getValueSettingSub10("x").getBooleanSetting("Defense tag size - it still shrinks with distance").getModeSetting(this.valueSettingSub97);
      this.valueSettingSub103 = (new ValueSettingSub10("Tag falloff", 1.0D, 0.0D, 2.0D, 0.05D)).getValueSettingSub10("x").getBooleanSetting("How hard a tag shrinks as its bed gets further away - 0 keeps every tag the same size however far off it is").getModeSetting(this.valueSettingSub97);
      this.valueSettingSub96 = (new ValueSettingSub9("Tag blur", true)).getBooleanSetting("Frost the world behind each defense tag instead of tinting it flat").getModeSetting(this.valueSettingSub97);
      this.valueSettingSub95 = (new ValueSettingSub9("Beam", false)).getBooleanSetting("Stand a light beam over every highlighted bed");
      this.valueSettingSub106 = (new ValueSettingSub10("Beam height", 24.0D, 4.0D, 128.0D, 4.0D)).getValueSettingSub10(" m").getBooleanSetting("How far the beam reaches above the bed").getModeSetting(this.valueSettingSub95);
      this.valueSettingSub109 = (new ValueSettingSub10("Beam width", 0.5D, 0.1D, 2.0D, 0.1D)).getValueSettingSub10(" m").getBooleanSetting("How wide the beam column is").getModeSetting(this.valueSettingSub95);
      this.valueSettingSub104 = (new ValueSettingSub10("Beam opacity", 55.0D, 10.0D, 100.0D, 5.0D)).getValueSettingSub10("%").getBooleanSetting("How strongly the beam is drawn at its base").getModeSetting(this.valueSettingSub95);
      this.valueSettingSub98 = (new ValueSettingSub9("Beam color", false)).getBooleanSetting("Draw every beam in one colour of its own instead of the bed's own/enemy colour").getModeSetting(this.valueSettingSub95);
      this.valueSettingSub63 = (new ValueSettingSub6("Beam tint", -8399617)).getBooleanSetting("The colour every beam is drawn in").getModeSetting(this.valueSettingSub98);
      this.valueSettingSub9 = (new ValueSettingSub9("Own bed beam", true)).getBooleanSetting("Stand a beam over your own bed too - off leaves the column to enemy beds, which is one less thing lit up in the middle of your own base").getModeSetting(this.valueSettingSub95);
      this.valueSettingSub910 = (new ValueSettingSub9("Own beam color", false)).getBooleanSetting("Give your own bed's beam a colour of its own instead of the one the rest of the beams use").getSetting2(() -> {
         return this.valueSettingSub95.isEnabled17() && this.valueSettingSub9.isEnabled17();
      });
      this.valueSettingSub64 = (new ValueSettingSub6("Own beam tint", -9706613)).getBooleanSetting("The colour your own bed's beam is drawn in").getSetting2(() -> {
         return this.valueSettingSub95.isEnabled17() && this.valueSettingSub9.isEnabled17() && this.valueSettingSub910.isEnabled17();
      });
      this.valueSettingSub94 = new ValueSettingSub9("Fill", true);
      this.valueSettingSub99 = new ValueSettingSub9("Through walls", true);
      this.valueSettingSub105 = (new ValueSettingSub10("Line width", 1.5D, 0.5D, 5.0D, 0.5D)).getValueSettingSub10(" px");
      this.valueSettingSub102 = (new ValueSettingSub10("Refresh", 500.0D, 100.0D, 2000.0D, 50.0D)).getValueSettingSub10("ms").getBooleanSetting("How often the world is rescanned for beds");
      this.cls7 = new Cls7();
      this.list2 = new ArrayList();
      this.list3 = new ArrayList();
      this.list4 = new ArrayList();
      this.cls = new Cls(this);
   }

   private void handleFloat45(float var1) {
      if (this.valueSettingSub95.isEnabled17()) {
         boolean var10 = false;
         float var8 = this.valueSettingSub104.getFloat5() / 100.0F;
         double var4 = (Double)this.valueSettingSub109.lambda15();
         double var6 = (Double)this.valueSettingSub106.lambda15();
         Iterator var3 = this.list2.iterator();

         label51:
         while(true) {
            Iterator var10000 = var3;

            while(true) {
               while(var10000.hasNext()) {
                  BlockPos var9 = (BlockPos)var3.next();
                  boolean var19;
                  if (var19 = client.onyx.module.combat.Cls.CLS.isBlockPos6(var9)) {
                     if (!this.valueSettingSub93.isEnabled17()) {
                        continue label51;
                     }

                     if (!this.valueSettingSub9.isEnabled17()) {
                        var10000 = var3;
                        continue;
                     }
                  }

                  if (!var19 && !this.valueSettingSub92.isEnabled17()) {
                     var10000 = var3;
                  } else {
                     AxisAlignedBB var11;
                     if ((var11 = this.getAxisAlignedBB2(var9)) == null) {
                        var10000 = var3;
                     } else {
                        if (!var10) {
                           if (!Util15.isFloat6(var1, this.valueSettingSub99.isEnabled17())) {
                              return;
                           }

                           var10 = true;
                        }

                        int var20;
                        float var12 = (float)Util2.getIntForInt6(var20 = this.getInt29(var19)) / 255.0F * var8;
                        var10000 = var3;
                        double var13 = (double)var9.getY() + 0.5625D;
                        double var15 = (var11.minX + var11.maxX) / 2.0D;
                        double var17 = (var11.minZ + var11.maxZ) / 2.0D;
                        Util15.handleDouble5(var15, var17, var13, var13 + var6, var4, Util2.getIntForInt3(var20, var12 * 0.55F), Util2.getIntForInt3(var20, 0.0F));
                        Util15.handleDouble5(var15, var17, var13, var13 + var6, var4 * 0.35D, Util2.getIntForInt3(var20, var12), Util2.getIntForInt3(var20, 0.0F));
                     }
                  }
               }

               if (var10) {
                  Util15.run61();
               }

               return;
            }
         }
      }
   }

   @EventHandler
   private void handleEventSub64(EventSub6 var1) {
      this.run91();
   }

   private static int getIntForIBlockState(IBlockState var0) {
      Block var3;
      if ((var3 = var0.getBlock()) == Blocks.obsidian) {
         return -15003098;
      } else if (var3 == Blocks.glass) {
         return -4199947;
      } else {
         MapColor var4;
         int var2 = (var4 = var3.getMapColor(var0)) == null ? 0 : var4.colorValue;
         return var2 == 0 ? -5197648 : -16777216 | var2;
      }
   }

   public boolean isEnabled61() {
      return this.cls.isEnabled60();
   }

   protected void run79() {
      this.run91();
   }

   public void handleSampler015(Sampler0 var1, float var2, float var3) {
      this.cls.handleSampler012(var1, var2, var3);
   }

   private int getInt29(boolean var1) {
      if (var1 && this.valueSettingSub910.isEnabled17()) {
         return this.valueSettingSub64.lambda15();
      } else {
         return this.valueSettingSub98.isEnabled17() ? this.valueSettingSub63.lambda15() : var1 ? this.valueSettingSub62.lambda15() : this.valueSettingSub6.lambda15();
      }
   }

   private AxisAlignedBB getAxisAlignedBB2(BlockPos var1) {
      IBlockState var11;
      if (!((var11 = MINECRAFT.theWorld.getBlockState(var1)).getBlock() instanceof BlockBed)) {
         return null;
      } else {
         BlockPos var12 = var1.offset(((EnumFacing)var11.getValue(BlockBed.FACING)).getOpposite());
         double var3 = (double)Math.min(var1.getX(), var12.getX()) - 0.003D;
         double var5 = (double)Math.min(var1.getZ(), var12.getZ()) - 0.003D;
         double var7 = (double)(Math.max(var1.getX(), var12.getX()) + 1) + 0.003D;
         double var9 = (double)(Math.max(var1.getZ(), var12.getZ()) + 1) + 0.003D;
         return AxisAlignedBB.fromBounds(var3, (double)var1.getY() - 0.003D, var5, var7, (double)var1.getY() + 0.5625D + 0.003D, var9);
      }
   }

   private static record PosColorRecord(BlockPos pos, int color) {

      public int color() {
         return this.color;
      }

      public BlockPos pos() {
         return this.pos;
      }
   }

   public static record BedOwnRecord(BlockPos bed, boolean own, List<BedESPModule.IconNameRecord> entries, int total) {

      public List<BedESPModule.IconNameRecord> entries() {
         return this.entries;
      }

      public boolean own() {
         return this.own;
      }

      public BlockPos bed() {
         return this.bed;
      }

      public int total() {
         return this.total;
      }
   }

   public static record IconNameRecord(ItemStack icon, String name, int count) {
      public int count() {
         return this.count;
      }

      public String name() {
         return this.name;
      }


      public ItemStack icon() {
         return this.icon;
      }
   }
}
