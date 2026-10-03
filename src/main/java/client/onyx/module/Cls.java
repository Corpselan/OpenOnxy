package client.onyx.module;

import client.onyx.MinecraftAccess;
import client.onyx.event.impl.EventSub11;
import client.onyx.module.combat.AntiBotModule;
import client.onyx.module.combat.BedBreakerModule;
import client.onyx.module.combat.BedDefenderModule;
import client.onyx.module.combat.JumpResetModule;
import client.onyx.module.combat.KillAuraModule;
import client.onyx.module.combat.VelocityModule;
import client.onyx.module.hud.CustomGuiModule;
import client.onyx.module.hud.DiscordRPCModule;
import client.onyx.module.hud.KeybindsModule;
import client.onyx.module.hud.NotificationsModule;
import client.onyx.module.hud.PotionHUDModule;
import client.onyx.module.hud.StyleModule;
import client.onyx.module.hud.TargetHUDModule;
import client.onyx.module.hud.WatermarkModule;
import client.onyx.module.movement.AutoSprintModule;
import client.onyx.module.movement.ModeModule;
import client.onyx.module.movement.NoSlowModule;
import client.onyx.module.player.ChestStealerModule;
import client.onyx.module.player.DelayModule;
import client.onyx.module.player.DepositModule;
import client.onyx.module.player.FastPlaceModule;
import client.onyx.module.player.InventoryManagerModule;
import client.onyx.module.player.NameChangerModule;
import client.onyx.module.render.AmbienceModule;
import client.onyx.module.render.AnimationsModule;
import client.onyx.module.render.ArrowsModule;
import client.onyx.module.render.BedESPModule;
import client.onyx.module.render.BlockOverlayModule;
import client.onyx.module.render.BoxesModule;
import client.onyx.module.render.CameraModule;
import client.onyx.module.render.CapeChangerModule;
import client.onyx.module.render.ChamsModule;
import client.onyx.module.render.ChinaHatModule;
import client.onyx.module.render.ClickGUIModule;
import client.onyx.module.render.ContainerESPModule;
import client.onyx.module.render.CrosshairModule;
import client.onyx.module.render.DistanceModule;
import client.onyx.module.render.FogRemoveModule;
import client.onyx.module.render.FreelookModule;
import client.onyx.module.render.FullbrightModule;
import client.onyx.module.render.GlowESPModule;
import client.onyx.module.render.HandModule;
import client.onyx.module.render.HurtcamModule;
import client.onyx.module.render.ItemPhysicsModule;
import client.onyx.module.render.JumpCirclesModule;
import client.onyx.module.render.KeepModule;
import client.onyx.module.render.NamesModule;
import client.onyx.module.render.NoRenderModule;
import client.onyx.module.render.ParticlesModule;
import client.onyx.module.render.SeeInvisiblesModule;
import client.onyx.module.render.SkeletonESPModule;
import client.onyx.module.render.SkinChangerModule;
import client.onyx.module.render.SkyboxModule;
import client.onyx.module.render.TNTTimerModule;
import client.onyx.module.render.TargetESPModule;
import client.onyx.module.render.TrailsModule;
import client.onyx.module.render.TrajectoriesModule;
import client.onyx.module.render.WingsModule;
import client.onyx.module.render.ZoomModule;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;

public class Cls implements MinecraftAccess {
   public WingsModule Ka;
   public BedDefenderModule ha;
   public BlockOverlayModule Ha;
   public KeepModule ia;
   public DistanceModule Da;
   public InventoryManagerModule la;
   public BedESPModule Ga;
   public FastPlaceModule ga;
   public SeeInvisiblesModule ca;
   public ArrowsModule arrowsModule;
   public ItemPhysicsModule itemPhysicsModule;
   public ChinaHatModule chinaHatModule;
   public JumpResetModule jumpResetModule;
   public CameraModule cameraModule;
   public FreelookModule freelookModule;
   public AutoSprintModule autoSprintModule;
   public TargetESPModule targetESPModule;
   public NamesModule namesModule;
   public CrosshairModule crosshairModule;
   public HurtcamModule hurtcamModule;
   public CustomGuiModule customGuiModule;
   public TNTTimerModule tNTTimerModule;
   public WatermarkModule watermarkModule;
   public DiscordRPCModule discordRPCModule;
   public KillAuraModule killAuraModule;
   public FullbrightModule fullbrightModule;
   public DelayModule delayModule;
   public TargetHUDModule targetHUDModule;
   public SkyboxModule skyboxModule;
   public ZoomModule zoomModule;
   public JumpCirclesModule jumpCirclesModule;
   public SkeletonESPModule skeletonESPModule;
   public ModeModule modeModule;
   public VelocityModule velocityModule;
   public AnimationsModule animationsModule;
   public ChestStealerModule chestStealerModule;
   public AntiBotModule antiBotModule;
   public GlowESPModule glowESPModule;
   public ContainerESPModule containerESPModule;
   public TrailsModule trailsModule;
   public NoSlowModule noSlowModule;
   public NameChangerModule nameChangerModule;
   public StyleModule styleModule;
   public AmbienceModule ambienceModule;
   public CapeChangerModule capeChangerModule;
   public KeybindsModule keybindsModule;
   public FogRemoveModule fogRemoveModule;
   public ClickGUIModule clickGUIModule = new ClickGUIModule();
   public SkinChangerModule skinChangerModule;
   public TrajectoriesModule trajectoriesModule;
   public BoxesModule boxesModule;
   public DepositModule depositModule;
   public NoRenderModule noRenderModule;
   public ParticlesModule particlesModule;
   public NotificationsModule notificationsModule;
   public PotionHUDModule potionHUDModule;
   public HandModule handModule;
   private final ArrayList<Module> arrayList;
   public ChamsModule chamsModule;
   public BedBreakerModule bedBreakerModule;
   private final Set<Module> set;

   public Cls() {
      this.customGuiModule = new CustomGuiModule();
      this.animationsModule = new AnimationsModule();
      this.namesModule = new NamesModule();
      this.glowESPModule = new GlowESPModule();
      this.targetESPModule = new TargetESPModule();
      this.particlesModule = new ParticlesModule();
      this.fullbrightModule = new FullbrightModule();
      this.crosshairModule = new CrosshairModule();
      this.containerESPModule = new ContainerESPModule();
      this.tNTTimerModule = new TNTTimerModule();
      this.noRenderModule = new NoRenderModule();
      this.ia = new KeepModule();
      this.fogRemoveModule = new FogRemoveModule();
      this.itemPhysicsModule = new ItemPhysicsModule();
      this.cameraModule = new CameraModule();
      this.zoomModule = new ZoomModule();
      this.ambienceModule = new AmbienceModule();
      this.skyboxModule = new SkyboxModule();
      this.Da = new DistanceModule();
      this.chamsModule = new ChamsModule();
      this.boxesModule = new BoxesModule();
      this.Ha = new BlockOverlayModule();
      this.Ka = new WingsModule();
      this.chinaHatModule = new ChinaHatModule();
      this.trailsModule = new TrailsModule();
      this.jumpCirclesModule = new JumpCirclesModule();
      this.handModule = new HandModule();
      this.autoSprintModule = new AutoSprintModule();
      this.modeModule = new ModeModule();
      this.noSlowModule = new NoSlowModule();
      this.killAuraModule = new KillAuraModule();
      this.antiBotModule = new AntiBotModule();
      this.bedBreakerModule = new BedBreakerModule();
      this.ha = new BedDefenderModule();
      this.velocityModule = new VelocityModule();
      this.jumpResetModule = new JumpResetModule();
      this.delayModule = DelayModule.DELAY_MODULE;
      this.nameChangerModule = new NameChangerModule();
      this.skinChangerModule = new SkinChangerModule();
      this.capeChangerModule = new CapeChangerModule();
      this.ga = new FastPlaceModule();
      this.depositModule = DepositModule.DEPOSIT_MODULE;
      this.la = new InventoryManagerModule();
      this.chestStealerModule = new ChestStealerModule();
      this.targetHUDModule = new TargetHUDModule();
      this.keybindsModule = new KeybindsModule();
      this.styleModule = new StyleModule();
      this.watermarkModule = new WatermarkModule();
      this.notificationsModule = new NotificationsModule();
      this.potionHUDModule = new PotionHUDModule();
      this.arrowsModule = new ArrowsModule();
      this.Ga = new BedESPModule();
      this.skeletonESPModule = new SkeletonESPModule();
      this.trajectoriesModule = new TrajectoriesModule();
      this.ca = new SeeInvisiblesModule();
      this.freelookModule = new FreelookModule();
      this.hurtcamModule = new HurtcamModule();
      this.discordRPCModule = new DiscordRPCModule();
      this.arrayList = new ArrayList<>();
      this.set = new HashSet<>();
      Field[] var4;
      int var2 = (var4 = this.getClass().getDeclaredFields()).length;

      int var3;
      for (int var10000 = var3 = 0; var10000 < var2; var10000 = ++var3) {
         Field var5 = var4[var3];
         if (Module.class.isAssignableFrom(var5.getType())) {
            try {
               Module var7 = (Module)var5.get(this);
               var7.run81();
               this.arrayList.add(var7);
            } catch (IllegalAccessException var6) {
               var6.printStackTrace();
            }
         }
      }

      this.arrayList.sort(Comparator.comparing(Module::getString20, String.CASE_INSENSITIVE_ORDER).thenComparing(Module::getString20));
   }

   public ArrayList<Module> getArrayList2(ModuleCategory var1) {
      ArrayList var2 = new ArrayList();
      Iterator var5 = this.arrayList.iterator();

      while (var5.hasNext()) {
         Module var4;
         if ((var4 = (Module)var5.next()).getModuleCategory() == var1) {
            var2.add(var4);
         }
      }

      return var2;
   }

   @EventHandler
   public void handleEventSub11(EventSub11 var1) {
      boolean var7 = MINECRAFT.currentScreen != null;
      Iterator var2 = this.arrayList.iterator();

      label67:
      while (true) {
         Iterator var10000 = var2;

         while (var10000.hasNext()) {
            Module var6;
            boolean var4 = (var6 = (Module)var2.next()).getValueSettingSub112().isEnum3(ToggleHoldEnum.HOLD) && var6.isEnabled56();
            boolean var5 = !var7 && var6.getNoneValueSetting2().isEnabled19() && var6.getNoneValueSetting2().isEnabled22();
            if (var4) {
               if (var5) {
                  var10000 = var2;
                  this.set.add(var6);
                  var6.handleBool16(true);
               } else {
                  if (!this.set.remove(var6)) {
                     continue label67;
                  }

                  var10000 = var2;
                  var6.handleBool16(false);
               }
            } else {
               if (var7) {
                  continue label67;
               }

               if (var6.getNoneValueSetting2().isEnabled19()) {
                  if (var5 && this.set.add(var6)) {
                     var6.lambda35();
                  } else if (!var5) {
                     this.set.remove(var6);
                  }
                  continue label67;
               }

               var10000 = var2;
            }
         }

         return;
      }
   }

   public ArrayList<Module> getArrayList() {
      return this.arrayList;
   }
}
