package client.onyx.module.render;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.Sampler0;
import client.onyx.render.Util11;
import client.onyx.render.Util7;
import client.onyx.render.Util8;
import client.onyx.setting.BooleanSettingSub;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.SettingGroup;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.setting.impl.ValueSettingSub9;
import client.onyx.system.SelfEnemyEnum;
import client.onyx.theme.impl.Util2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;

public final class BoxesModule extends Module {
   public final ValueSettingSub11<BoxesModule.TwoDThreeDEnum> valueSettingSub112 = new ValueSettingSub11<>("Shape", BoxesModule.TwoDThreeDEnum.TWO_D)
      .getBooleanSetting("A flat rectangle around the entity, or a cuboid sitting on it in the world");
   public final ValueSettingSub10 valueSettingSub10;
   private static final double DOUBLE = 0.125;
   private static final double DOUBLE2 = 0.06;
   public final ValueSettingSub9 valueSettingSub9;
   public final BoxesModule.TargetsBooleanSetting targetsBooleanSetting;
   public final ValueSettingSub11<BoxesModule.OutlineFilledEnum> valueSettingSub113 = new ValueSettingSub11<>("Style", BoxesModule.OutlineFilledEnum.OUTLINE)
      .getBooleanSetting("Lines only, or lines over a translucent fill");
   private static final float FLOAT = 2.0F;
   private final Sampler0 sampler0;
   public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Fill opacity", 18.0, 1.0, 60.0, 1.0)
      .getValueSettingSub10("%")
      .getBooleanSetting("How solid the fill sits behind the outline")
      .getSetting2(() -> this.valueSettingSub113.isEnum3(BoxesModule.OutlineFilledEnum.FILLED));
   public final ValueSettingSub10 valueSettingSub103 = new ValueSettingSub10("Line width", 1.5, 0.5, 5.0, 0.5).getValueSettingSub10(" px");

   private static AxisAlignedBB getAxisAlignedBBForAxisAlignedBB3(AxisAlignedBB var0) {
      double var1 = var0.maxY - var0.minY;
      var1 = Math.min(0.125, var1 * 0.5);
      return new AxisAlignedBB(var0.minX, var0.minY, var0.minZ, var0.maxX, var0.maxY - var1, var0.maxZ);
   }

   private static AxisAlignedBB getAxisAlignedBBForEntityLivingBase(EntityLivingBase var0, float var1) {
      double var2 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * var1 - var0.posX;
      double var4 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * var1 - var0.posY;
      double var6 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * var1 - var0.posZ;
      AxisAlignedBB var8 = var0.getEntityBoundingBox().offset(var2, var4, var6).expand(0.06, 0.06, 0.06);
      return isEntityLivingBase3(var0) ? getAxisAlignedBBForAxisAlignedBB3(var8) : var8;
   }

   public BoxesModule() {
      super("Boxes", "Outlines entities with a 2D or 3D box", ModuleCategory.RENDER);
      this.valueSettingSub9 = new ValueSettingSub9("Through walls", true)
         .getBooleanSetting("Keeps the box visible when the entity is behind blocks")
         .getSetting2(() -> this.valueSettingSub112.isEnum3(BoxesModule.TwoDThreeDEnum.THREE_D));
      this.valueSettingSub10 = new ValueSettingSub10("Distance", 256.0, 8.0, 256.0, 8.0)
         .getValueSettingSub10(" m")
         .getBooleanSetting("Maximum distance at which a box is drawn");
      this.targetsBooleanSetting = new BoxesModule.TargetsBooleanSetting();
      this.sampler0 = new Sampler0().getSampler0();
   }

   private static boolean isEntityLivingBase3(EntityLivingBase var0) {
      return var0 instanceof EntityPlayer && ((EntityPlayer)var0).isSneaking();
   }

   public void handleFloat41(float var1) {
      if (this.isTwoDThreeDEnum(BoxesModule.TwoDThreeDEnum.TWO_D) && Util8.isEnabled44()) {
         List var6;
         if (!(var6 = this.getList13()).isEmpty()) {
            ScaledResolution var5 = new ScaledResolution(MINECRAFT);
            float var11 = var5.getScaledWidth();
            float var10 = var5.getScaledHeight();
            this.sampler0.run42();
            Iterator var4 = var6.iterator();

            label31:
            while (true) {
               Iterator var12 = var4;

               while (var12.hasNext()) {
                  BoxesModule.EntityColorRecord var3;
                  Util11.LeftTopRecord var8;
                  if ((var8 = Util11.getLeftTopRecordForEntity((var3 = (BoxesModule.EntityColorRecord)var4.next()).entity(), var1, var11, var10)) == null) {
                     continue label31;
                  }

                  if (var8.width() < 2.0F) {
                     var12 = var4;
                  } else {
                     int var9 = var3.color();
                     float var7 = this.valueSettingSub103.getFloat5();
                     if (this.valueSettingSub113.isEnum3(BoxesModule.OutlineFilledEnum.FILLED)) {
                        this.sampler0.handleFloat28(var8.left(), var8.top(), var8.width(), var8.height(), this.getInt24(var9));
                     }

                     this.sampler0.handleFloat18(var8.left(), var8.top(), var8.width(), var8.height(), 0.0F, var7, var9);
                     var12 = var4;
                  }
               }

               this.sampler0.run39();
               return;
            }
         }
      }
   }

   public void handleFloat40(float var1) {
      if (this.isTwoDThreeDEnum(BoxesModule.TwoDThreeDEnum.THREE_D)) {
         List var4;
         if (!(var4 = this.getList13()).isEmpty()) {
            if (Util7.isFloat3(var1, this.valueSettingSub9.isEnabled17())) {
               Iterator var6;
               Iterator var10000 = var6 = var4.iterator();

               while (var10000.hasNext()) {
                  BoxesModule.EntityColorRecord var3 = (BoxesModule.EntityColorRecord)var6.next();
                  var10000 = var6;
                  int var5 = var3.color();
                  Util7.handleAxisAlignedBB2(
                     getAxisAlignedBBForEntityLivingBase(var3.entity(), var1), var5, this.valueSettingSub103.getFloat5(), this.getInt24(var5)
                  );
               }

               Util7.run49();
            }
         }
      }
   }

   private boolean isTwoDThreeDEnum(BoxesModule.TwoDThreeDEnum var1) {
      return this.isEnabled55() && this.valueSettingSub112.isEnum3(var1) && MINECRAFT.thePlayer != null && MINECRAFT.theWorld != null;
   }

   private int getInt24(int var1) {
      return this.valueSettingSub113.isEnum3(BoxesModule.OutlineFilledEnum.FILLED)
         ? Util2.getIntForInt3(var1, this.valueSettingSub102.getFloat5() / 100.0F)
         : 0;
   }

   private List<BoxesModule.EntityColorRecord> getList13() {
      ArrayList var4 = new ArrayList();
      double var2 = this.valueSettingSub10.lambda15() * this.valueSettingSub10.lambda15();
      Iterator var7 = MINECRAFT.theWorld.loadedEntityList.iterator();

      label26:
      while (true) {
         Iterator var10000 = var7;

         while (var10000.hasNext()) {
            Entity var5;
            if (!((var5 = (Entity)var7.next()) instanceof EntityLivingBase)) {
               continue label26;
            }

            SelfEnemyEnum var6;
            EntityLivingBase var8;
            if ((var6 = SelfEnemyEnum.getSelfEnemyEnumForEntityLivingBase(var8 = (EntityLivingBase)var5)) == null) {
               var10000 = var7;
            } else {
               BoxesModule.ColorSettingGroup var9;
               if (!(var9 = this.targetsBooleanSetting.getColorSettingGroup(var6)).isEnabled5()) {
                  var10000 = var7;
               } else if (MINECRAFT.thePlayer.getDistanceSqToEntity(var8) > var2) {
                  var10000 = var7;
               } else {
                  var4.add(new BoxesModule.EntityColorRecord(var8, var9.valueSettingSub6.getInt8()));
                  var10000 = var7;
               }
            }
         }

         var4.sort(Comparator.<BoxesModule.EntityColorRecord>comparingDouble(var0 -> MINECRAFT.thePlayer.getDistanceSqToEntity(var0.entity())).reversed());
         return var4;
      }
   }

   public static final class ColorSettingGroup extends SettingGroup {
      public final ValueSettingSub6 valueSettingSub6;

      private ColorSettingGroup(String var1, boolean var2, int var3, boolean var4) {
         super(var1, var2);
         this.valueSettingSub6 = new ValueSettingSub6("Color", var3);
         if (var4) {
            this.valueSettingSub6.getValueSettingSub6();
         }
      }
   }

   private record EntityColorRecord(EntityLivingBase entity, int color) {
   }

   public static enum OutlineFilledEnum implements DisplayNamed {
      OUTLINE("Outline"),
      FILLED("Outline + fill");

      private final String string;

      private OutlineFilledEnum(String var3) {
         this.string = var3;
      }


      @Override
      public String getString5() {
         return this.string;
      }
   }

   public static final class TargetsBooleanSetting extends BooleanSettingSub {
      public final BoxesModule.ColorSettingGroup colorSettingGroup;
      public final BoxesModule.ColorSettingGroup colorSettingGroup2;
      public final BoxesModule.ColorSettingGroup colorSettingGroup3;
      public final BoxesModule.ColorSettingGroup colorSettingGroup4 = new BoxesModule.ColorSettingGroup("Self", false, -2562832, true);

      private TargetsBooleanSetting() {
         super("Targets", SelfEnemyEnum.STRING_ARRAY);
         this.colorSettingGroup = new BoxesModule.ColorSettingGroup("Enemy", true, -3910337, true);
         this.colorSettingGroup3 = new BoxesModule.ColorSettingGroup("Team", false, -8585312, false);
         this.colorSettingGroup2 = new BoxesModule.ColorSettingGroup("Mobs", false, -3105793, false);
      }

      public BoxesModule.ColorSettingGroup getColorSettingGroup(SelfEnemyEnum var1) {
         switch (var1) {
            case SELF:

               return this.colorSettingGroup4;
            case ENEMY:
               return this.colorSettingGroup;
            case TEAM:
               return this.colorSettingGroup3;
            case MOBS:
               return this.colorSettingGroup2;
            default:
               throw new MatchException(null, null);
         }
      }
   }

   public static enum TwoDThreeDEnum implements DisplayNamed {
      TWO_D("2D"),
      THREE_D("3D");
      private final String string;

      private TwoDThreeDEnum(String var3) {
         this.string = var3;
      }


      @Override
      public String getString5() {
         return this.string;
      }
   }
}
