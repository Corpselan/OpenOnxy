package client.onyx.module.render;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.combat.BedBreakerModule;
import client.onyx.render.anim.ThemeColorRecord;
import client.onyx.render.misc.Util;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import java.util.Objects;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public final class BlockOverlayModule extends Module {
   private static final float FLOAT = 70.0F;
   public final ValueSettingSub9 valueSettingSub9;
   private static final float FLOAT2 = 60.0F;
   public final ValueSettingSub10 valueSettingSub10;
   private double double_;
   private float float_;
   public final ValueSettingSub9 valueSettingSub92;
   private static final float FLOAT3 = 0.004F;
   private BlockPos blockPos;
   public final ValueSettingSub9 valueSettingSub93;
   private final client.onyx.render.misc.Cls cls;
   public final ValueSettingSub10 valueSettingSub102;
   private final client.onyx.render.misc.Cls cls2;
   private BlockPos blockPos2;
   public final ValueSettingSub11<BlockOverlayModule.OutlineFillEnum> valueSettingSub112 = new ValueSettingSub11<>(
         "Theme", BlockOverlayModule.OutlineFillEnum.FILL
      )
      .getBooleanSetting("Outline on its own, over a transparent fill, or over the block's own texture");
   private final client.onyx.render.misc.Cls cls3;
   public final BlockOverlayModule.ModeSettingGroup modeSettingGroup;
   public final ValueSettingSub6 valueSettingSub6;
   private final client.onyx.render.anim.Cls cls4;
   private final client.onyx.render.misc.Cls[] clsArray;
   private boolean bool2;
   private static final double DOUBLE = 16.0;
   public final ValueSettingSub10 valueSettingSub103;
   private double double_2;
   private double double_3;
   public final BlockOverlayModule.GlintBooleanSetting glintBooleanSetting;
   public final BlockOverlayModule.AnimationBooleanSetting animationBooleanSetting;
   public final ValueSettingSub10 valueSettingSub104;
   private long long_;
   private static final float FLOAT4 = 100.0F;
   public final ValueSettingSub6 valueSettingSub62 = new ValueSettingSub6("Color", -10178561).getValueSettingSub6().getValueSettingSub62();

   private void handleFloat59(float var1) {
      client.onyx.render.misc.Cls[] var4 = this.clsArray;
      int var3 = this.clsArray.length;

      int var2;
      for (int var10000 = var2 = 0; var10000 < var3; var10000 = var2) {
         var4[var2++].handleFloat(var1);
      }

      this.cls3.handleFloat(var1);
      this.cls.handleFloat(var1);
      this.cls2.handleFloat(var1);
   }

   private void handleAxisAlignedBB4(AxisAlignedBB var1) {
      float var3 = this.animationBooleanSetting.valueSettingSub103.getFloat5();
      this.clsArray[0].getCls2((float)(var1.minX - this.double_2), var3, Util.IFACE2);
      this.clsArray[1].getCls2((float)(var1.minY - this.double_3), var3, Util.IFACE2);
      this.clsArray[2].getCls2((float)(var1.minZ - this.double_), var3, Util.IFACE2);
      this.clsArray[3].getCls2((float)(var1.maxX - this.double_2), var3, Util.IFACE2);
      this.clsArray[4].getCls2((float)(var1.maxY - this.double_3), var3, Util.IFACE2);
      this.clsArray[5].getCls2((float)(var1.maxZ - this.double_), var3, Util.IFACE2);
   }

   public void handleFloat58(float var1) {
      float var5 = this.getFloat62();
      if (this.isEnabled55() && MINECRAFT.theWorld != null && MINECRAFT.thePlayer != null) {
         BlockOverlayModule var10000;
         label27: {
            BlockPos var3;
            AxisAlignedBB var4 = (var3 = this.getBlockPos2(this.getBlockPos(), var5)) == null ? null : this.getAxisAlignedBB5(var3);
            if (var4 == null) {
               if (this.bool2) {
                  this.bool2 = false;
                  this.cls3.getCls2(0.0F, this.animationBooleanSetting.valueSettingSub10.getFloat5(), Util.IFACE);
                  this.cls
                     .getCls2(
                        this.animationBooleanSetting.valueSettingSub11.lambda15().getFloat2(),
                        this.animationBooleanSetting.valueSettingSub10.getFloat5(),
                        Util.IFACE
                     );
                  this.cls2.getCls(0.0F);
                  var10000 = this;
                  break label27;
               }
            } else {
               this.handleBlockPos(var3, var4);
               this.cls2.getCls2(this.getFloat61(), 70.0F, Util.IFACE8);
            }

            var10000 = this;
         }

         var10000.handleFloat59(var5);
         var5 = this.cls3.getFloat();
         if (!this.bool2 && var5 <= 0.004F) {
            this.blockPos2 = null;
         } else {
            this.cls4.handleFloat31(var1, this.blockPos2, this.getAxisAlignedBB4(), var5, this.cls2.getFloat(), this.getThemeColorRecord());
         }
      } else {
         this.run100();
      }
   }

   private void handleBlockPos(BlockPos var1, AxisAlignedBB var2) {
      boolean var5 = this.blockPos2 == null;
      boolean var4 = !var5 && var1.distanceSq(this.blockPos2.getX(), this.blockPos2.getY(), this.blockPos2.getZ()) > 16.0;
      if (!var1.equals(this.blockPos2)) {
         this.cls2.getCls(0.0F);
      }

      this.blockPos2 = var1;
      this.bool2 = true;
      boolean var10000;
      if (!var5 && !var4) {
         this.handleAxisAlignedBB4(var2);
         var10000 = var5;
      } else {
         this.double_2 = var2.minX;
         this.double_3 = var2.minY;
         this.double_ = var2.minZ;
         this.handleAxisAlignedBB3(var2);
         var10000 = var5;
      }

      if (var10000) {
         this.cls3.getCls(0.0F);
         this.cls.getCls(this.animationBooleanSetting.valueSettingSub11.lambda15().getFloat2());
      }

      this.cls3.getCls2(1.0F, this.animationBooleanSetting.valueSettingSub102.getFloat5(), Util.IFACE7);
      this.cls.getCls2(1.0F, this.animationBooleanSetting.valueSettingSub102.getFloat5(), Util.IFACE7);
   }

   private ThemeColorRecord getThemeColorRecord() {
      float var2 = this.valueSettingSub10.getFloat5() / 100.0F;
      return new ThemeColorRecord(
         this.valueSettingSub112.lambda15(),
         this.valueSettingSub62.lambda15(),
         this.valueSettingSub6.getInt8(),
         this.valueSettingSub103.getFloat5(),
         this.valueSettingSub104.getFloat5() / 100.0F,
         var2,
         Math.clamp(var2 * 3.0F, 0.0F, 1.6F),
         this.glintBooleanSetting.valueSettingSub10.getFloat5(),
         this.glintBooleanSetting.valueSettingSub103.getFloat5(),
         this.glintBooleanSetting.valueSettingSub102.getFloat5() / 100.0F,
         this.modeSettingGroup.isEnabled5(),
         this.modeSettingGroup.valueSettingSub112.lambda15(),
         this.modeSettingGroup.valueSettingSub11.isEnum3(BlockOverlayModule.DownUpEnum.UP),
         this.modeSettingGroup.valueSettingSub10.getFloat5() / 100.0F,
         this.valueSettingSub92.isEnabled17()
      );
   }

   public BlockOverlayModule() {
      super("BlockOverlay", "Highlights the block you are looking at", ModuleCategory.RENDER);
      this.valueSettingSub6 = new ValueSettingSub6("Second color", -7055617)
         .getValueSettingSub6()
         .getValueSettingSub63(48.0)
         .getBooleanSetting("The other end of the glint's gradient")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 == BlockOverlayModule.OutlineFillEnum.GLINT);
      this.valueSettingSub103 = new ValueSettingSub10("Line width", 1.5, 0.5, 5.0, 0.5).getValueSettingSub10(" px");
      this.valueSettingSub104 = new ValueSettingSub10("Outline opacity", 90.0, 5.0, 100.0, 5.0).getValueSettingSub10("%");
      this.valueSettingSub10 = new ValueSettingSub10("Fill opacity", 22.0, 1.0, 80.0, 1.0)
         .getValueSettingSub10("%")
         .getModeSetting2(this.valueSettingSub112, var0 -> var0 != BlockOverlayModule.OutlineFillEnum.OUTLINE);
      this.valueSettingSub102 = new ValueSettingSub10("Padding", 0.6, 0.0, 5.0, 0.1)
         .getValueSettingSub10("%")
         .getBooleanSetting("How far the box stands off the block face, as a fraction of a block");
      this.glintBooleanSetting = new BlockOverlayModule.GlintBooleanSetting();
      this.animationBooleanSetting = new BlockOverlayModule.AnimationBooleanSetting();
      this.modeSettingGroup = new BlockOverlayModule.ModeSettingGroup();
      this.valueSettingSub9 = new ValueSettingSub9("Only on bed break", false)
         .getBooleanSetting("Hides the overlay unless BedBreaker is mining, so it marks the bed and nothing else");
      this.valueSettingSub92 = new ValueSettingSub9("Through walls", true)
         .getBooleanSetting("Draws the whole box and its progress even when the block is buried");
      this.valueSettingSub93 = new ValueSettingSub9("Hide vanilla outline", true)
         .getBooleanSetting("Suppresses the black wireframe this overlay is standing in for");
      client.onyx.render.misc.Cls[] var10001 = new client.onyx.render.misc.Cls[6];
      boolean var10003 = true;
      var10001[0] = new client.onyx.render.misc.Cls(0.0F);
      var10001[1] = new client.onyx.render.misc.Cls(0.0F);
      var10001[2] = new client.onyx.render.misc.Cls(0.0F);
      var10001[3] = new client.onyx.render.misc.Cls(0.0F);
      var10001[4] = new client.onyx.render.misc.Cls(0.0F);
      var10001[5] = new client.onyx.render.misc.Cls(0.0F);
      this.clsArray = var10001;
      this.cls3 = new client.onyx.render.misc.Cls(0.0F);
      this.cls = new client.onyx.render.misc.Cls(1.0F);
      this.cls2 = new client.onyx.render.misc.Cls(0.0F);
      this.cls4 = new client.onyx.render.anim.Cls();
      this.glintBooleanSetting.getSetting2(() -> this.valueSettingSub112.isEnum3(BlockOverlayModule.OutlineFillEnum.GLINT));
   }

   @Override
   protected void run79() {
      this.run100();
      this.cls4.run55();
   }

   private void run100() {
      this.blockPos = this.blockPos2 = null;
      this.float_ = 0.0F;
      this.bool2 = false;
      this.long_ = 0L;
      client.onyx.render.misc.Cls[] var1 = this.clsArray;
      int var2 = this.clsArray.length;

      int var4;
      for (int var10000 = var4 = 0; var10000 < var2; var10000 = var4) {
         var1[var4++].getCls(0.0F);
      }

      this.cls3.getCls(0.0F);
      this.cls.getCls(1.0F);
      this.cls2.getCls(0.0F);
   }

   private BlockPos getBlockPos2(BlockPos var1, float var2) {
      if (this.blockPos2 != null && !Objects.equals(var1, this.blockPos2)) {
         if (!Objects.equals(var1, this.blockPos)) {
            this.blockPos = var1;
            this.float_ = 0.0F;
         }

         this.float_ += var2;
         return this.float_ >= 60.0F ? var1 : this.blockPos2;
      } else {
         this.blockPos = null;
         this.float_ = 0.0F;
         return var1;
      }
   }

   private float getFloat62() {
      long var1 = System.nanoTime();
      if (this.long_ == 0L) {
         this.long_ = var1;
         return 0.0F;
      } else {
         float var10000 = (float)(var1 - this.long_) / 1000000.0F;
         this.long_ = var1;
         return Math.clamp(var10000, 0.0F, 100.0F);
      }
   }

   private AxisAlignedBB getAxisAlignedBB4() {
      double var1 = this.double_2 + this.clsArray[0].getFloat();
      double var3 = this.double_3 + this.clsArray[1].getFloat();
      double var5 = this.double_ + this.clsArray[2].getFloat();
      double var7 = this.double_2 + this.clsArray[3].getFloat();
      double var9 = this.double_3 + this.clsArray[4].getFloat();
      double var11 = this.double_ + this.clsArray[5].getFloat();
      double var13 = (var1 + var7) / 2.0;
      double var15 = (var3 + var9) / 2.0;
      double var17 = (var5 + var11) / 2.0;
      double var19 = this.cls.getFloat();
      double var21 = this.valueSettingSub102.lambda15() / 100.0;
      return AxisAlignedBB.fromBounds(
         var13 + (var1 - var13) * var19 - var21,
         var15 + (var3 - var15) * var19 - var21,
         var17 + (var5 - var17) * var19 - var21,
         var13 + (var7 - var13) * var19 + var21,
         var15 + (var9 - var15) * var19 + var21,
         var17 + (var11 - var17) * var19 + var21
      );
   }

   private BlockPos getBlockPos() {
      BedBreakerModule var2 = OnyxClient.cls == null ? null : OnyxClient.cls.bedBreakerModule;
      if (var2 != null && var2.isEnabled55() && var2.getBlockPos3() != null) {
         return var2.getBlockPos3();
      } else if (this.valueSettingSub9.isEnabled17()) {
         return null;
      } else {
         MovingObjectPosition var3 = MINECRAFT.objectMouseOver;
         return MINECRAFT.objectMouseOver != null && var3.typeOfHit == MovingObjectType.BLOCK ? var3.getBlockPos() : null;
      }
   }

   private float getFloat61() {
      if (this.modeSettingGroup.isEnabled5() && MINECRAFT.playerController != null) {
         BedBreakerModule var3 = OnyxClient.cls == null ? null : OnyxClient.cls.bedBreakerModule;
         boolean var2 = var3 != null && var3.isEnabled55() && var3.getBlockPos3() != null;
         return !var2 && !MINECRAFT.playerController.isHittingBlock() ? 0.0F : Math.clamp(MINECRAFT.playerController.getCurBlockDamage(), 0.0F, 1.0F);
      } else {
         return 0.0F;
      }
   }

   public boolean isEnabled67() {
      return this.isEnabled55() && this.valueSettingSub93.isEnabled17() && this.getBlockPos() != null;
   }

   private AxisAlignedBB getAxisAlignedBB5(BlockPos var1) {
      return MINECRAFT.theWorld.getBlockState(var1).getBlock().getMaterial() == Material.air
         ? null
         : client.onyx.render.anim.Cls.getAxisAlignedBBForBlockPos2(var1);
   }

   private void handleAxisAlignedBB3(AxisAlignedBB var1) {
      this.clsArray[0].getCls((float)(var1.minX - this.double_2));
      this.clsArray[1].getCls((float)(var1.minY - this.double_3));
      this.clsArray[2].getCls((float)(var1.minZ - this.double_));
      this.clsArray[3].getCls((float)(var1.maxX - this.double_2));
      this.clsArray[4].getCls((float)(var1.maxY - this.double_3));
      this.clsArray[5].getCls((float)(var1.maxZ - this.double_));
   }

   public static final class AnimationBooleanSetting extends BooleanSetting {
      public final ValueSettingSub11<BlockOverlayModule.FadePopEnum> valueSettingSub11;
      public final ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Appear", 140.0, 0.0, 600.0, 10.0).getValueSettingSub10(" ms");
      public final ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Move", 110.0, 0.0, 600.0, 10.0)
         .getValueSettingSub10(" ms")
         .getBooleanSetting("How long the box takes to slide to a neighbouring block");

      public AnimationBooleanSetting() {
         super("Animation");
         this.valueSettingSub10 = new ValueSettingSub10("Fade", 180.0, 0.0, 600.0, 10.0).getValueSettingSub10(" ms");
         this.valueSettingSub11 = new ValueSettingSub11<>("Appearance", BlockOverlayModule.FadePopEnum.POP)
            .getBooleanSetting("Fade alone, a small pop, or growing out of the centre of the block");
      }
   }

   public static enum DownUpEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      DOWN("Top to bottom"),
      UP("Bottom to top");

      private final String string;

      @Override
      public String getString5() {
         return this.string;
      }


      private DownUpEnum(String var3) {
         this.string = var3;
      }
   }

   public static enum FadePopEnum implements DisplayNamed {
      FADE("Fade", 1.0F),
      POP("Pop", 0.62F),
      GROW("Grow", 0.0F);
      private final String string;
      private final float float_;

      private FadePopEnum(String var3, float var4) {
         this.string = var3;
         this.float_ = var4;
      }


      public float getFloat2() {
         return this.float_;
      }

      @Override
      public String getString5() {
         return this.string;
      }
   }

   public static enum FillGrowEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      FILL("Fill"),
      GROW("Grow from centre");
      private final String string;


      @Override
      public String getString5() {
         return this.string;
      }

      private FillGrowEnum(String var3) {
         this.string = var3;
      }
   }

   public static final class GlintBooleanSetting extends BooleanSetting {
      public final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Glint speed", 1.0, 0.1, 4.0, 0.1);
      public final ValueSettingSub10 valueSettingSub102;
      public final ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Glint scale", 1.5, 0.5, 4.0, 0.1)
         .getBooleanSetting("How large the curtains are across the block face");

      public GlintBooleanSetting() {
         super("Glint");
         this.valueSettingSub102 = new ValueSettingSub10("Glint glow", 60.0, 0.0, 100.0, 5.0).getValueSettingSub10("%");
      }
   }

   public static final class ModeSettingGroup extends SettingGroup {
      public final ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub11<BlockOverlayModule.DownUpEnum> valueSettingSub11;
      public final ValueSettingSub11<BlockOverlayModule.FillGrowEnum> valueSettingSub112 = new ValueSettingSub11<>("Mode", BlockOverlayModule.FillGrowEnum.FILL)
         .getBooleanSetting("The fill rising across the block, or growing out of its centre");

      public ModeSettingGroup() {
         super("Break progress", true);
         this.valueSettingSub11 = new ValueSettingSub11<>("Direction", BlockOverlayModule.DownUpEnum.DOWN)
            .getBooleanSetting("Which way the fill travels as the block breaks");
         this.valueSettingSub10 = new ValueSettingSub10("Progress opacity", 45.0, 1.0, 100.0, 1.0)
            .getValueSettingSub10("%")
            .getBooleanSetting("How solid the broken part of the block is");
         this.valueSettingSub11.getSetting2(() -> this.valueSettingSub112.isEnum3(BlockOverlayModule.FillGrowEnum.FILL));
      }
   }

   public static enum OutlineFillEnum implements DisplayNamed {
      // 顺序按原 $VALUES 数组（即 ordinal）
      OUTLINE("Outline"),
      FILL("Outline + fill"),
      GLINT("Outline + glint");
      private final String string;

      private OutlineFillEnum(String var3) {
         this.string = var3;
      }


      @Override
      public String getString5() {
         return this.string;
      }
   }
}
