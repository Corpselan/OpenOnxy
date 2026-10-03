package client.onyx.module.render;

import client.onyx.event.impl.EventSub2;
import client.onyx.gui.Fit;
import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.module.hud.notification.InfoSuccessEnum;
import client.onyx.render.cape.CapeLoader;
import client.onyx.render.cape.Util2;
import client.onyx.setting.impl.SettingSub;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub4;
import client.onyx.setting.impl.ValueSettingSub6;
import client.onyx.system.FileDialog;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.function.Consumer;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.ResourceLocation;

public final class CapeChangerModule extends Module {
   private BufferedImage bufferedImage;
   public ValueSettingSub10 valueSettingSub10;
   public ValueSettingSub10 valueSettingSub102;
   private boolean bool2;
   public ValueSettingSub4 valueSettingSub4;
   public SettingSub settingSub;
   private ResourceLocation resourceLocation;
   private int int_;
   public SettingSub settingSub2;
   public ValueSettingSub10 valueSettingSub103;
   public SettingSub settingSub3;
   public ValueSettingSub6 valueSettingSub6;
   public ValueSettingSub11<Util2.AutoFitEnum> valueSettingSub112;
   public ValueSettingSub11<CapeChangerModule.OnyxLogoLocalFileEnum> valueSettingSub113 = new ValueSettingSub11<>(
         "Source", CapeChangerModule.OnyxLogoLocalFileEnum.ONYX_LOGO
      )
      .getBooleanSetting("The built-in Onyx logo cape, or a PNG off your disk");
   private String string3;

   public void handleBool17(boolean var1) {
      if (this.bool2 != var1) {
         this.bool2 = var1;
         if (!var1) {
            this.run86();
         }
      }
   }

   private void lambda72() {
      if (this.valueSettingSub113.isEnum3(CapeChangerModule.OnyxLogoLocalFileEnum.ONYX_LOGO)) {
         CapeLoader.handleConsumer(var1x -> {
            this.handleResourceLocation6(var1x);
            client.onyx.system.Util2.handleString17("CapeChanger", "Onyx cape applied", InfoSuccessEnum.SUCCESS);
         }, var1x -> client.onyx.system.Util2.handleString17("CapeChanger", var1x, InfoSuccessEnum.ERROR));
      } else if (this.valueSettingSub4.lambda15().isEmpty()) {
         client.onyx.system.Util2.handleString17("CapeChanger", "Pick a cape PNG first", InfoSuccessEnum.WARNING);
      } else {
         if (this.bufferedImage != null) {
            String var1 = this.string3;
            Object var2 = this.valueSettingSub4.lambda15();
            if (var1.equals(var2)) {
               this.run86();
               return;
            }
         }

         CapeLoader.handleString9(this.valueSettingSub4.lambda15(), var1x -> {
            this.bufferedImage = var1x;
            this.string3 = this.valueSettingSub4.lambda15();
            CapeLoader.getResourceLocationForBufferedImage(var1x);
            this.run86();
            client.onyx.system.Util2.handleString17("CapeChanger", "Cape applied", InfoSuccessEnum.SUCCESS);
         }, var1x -> client.onyx.system.Util2.handleString17("CapeChanger", var1x, InfoSuccessEnum.ERROR));
      }
   }

   @Override
   protected void run80() {
      this.lambda72();
   }

   private void run85() {
      if (this.resourceLocation != null && MINECRAFT.thePlayer != null) {
         MINECRAFT.thePlayer.setLocationOfCape(this.resourceLocation);
      }
   }

   public BufferedImage getBufferedImage4() {
      return this.bufferedImage;
   }

   private void handleResourceLocation6(ResourceLocation var1) {
      this.resourceLocation = var1;
      if (this.isEnabled55()) {
         this.run85();
      }
   }

   @Override
   protected void run79() {
      if (MINECRAFT.thePlayer != null) {
         MINECRAFT.thePlayer.setLocationOfCape(null);
      }

      this.resourceLocation = null;
   }

   @EventHandler
   public void handleEventSub23(EventSub2 var1) {
      this.run85();
   }

   public CapeChangerModule() {
      super("CapeChanger", "Overrides your own cape texture locally", ModuleCategory.RENDER);
      this.valueSettingSub4 = new ValueSettingSub4("Cape file", "")
         .getBooleanSetting("Full path to a cape PNG - any resolution")
         .getModeSetting2(this.valueSettingSub113, var0 -> var0 == CapeChangerModule.OnyxLogoLocalFileEnum.LOCAL_FILE);
      this.settingSub = new SettingSub("Browse", () -> {
            String var2 = this.valueSettingSub4.lambda15();
            ValueSettingSub4 var3 = this.valueSettingSub4;
            Object var4 = Objects.requireNonNull(var3);
            Consumer<String> var5 = var3::handleObject2;
            FileDialog.handleString("Select a cape PNG", var2, var5);
         })
         .getSettingSub("Browse…")
         .getBooleanSetting("Or paste the path into the field above")
         .getSetting2(() -> this.valueSettingSub113.isEnum3(CapeChangerModule.OnyxLogoLocalFileEnum.LOCAL_FILE));
      this.settingSub2 = new SettingSub("Apply", this::lambda72)
         .getSettingSub("Apply cape")
         .getSetting2(() -> this.valueSettingSub113.isEnum3(CapeChangerModule.OnyxLogoLocalFileEnum.LOCAL_FILE));
      this.valueSettingSub112 = new ValueSettingSub11<>("Fit", Util2.AutoFitEnum.AUTO)
         .getBooleanSetting("Fit shows the whole picture on a background, Fill crops it to the cape, Texture takes the PNG as a finished cape sheet")
         .getSetting2(() -> this.valueSettingSub113.isEnum3(CapeChangerModule.OnyxLogoLocalFileEnum.LOCAL_FILE))
         .getModeSetting3(var1 -> this.run86());
      this.valueSettingSub6 = new ValueSettingSub6("Background", -15329507)
         .getValueSettingSub65()
         .getBooleanSetting("What fills the cape where the picture does not reach")
         .getSetting2(
            () -> this.valueSettingSub113.isEnum3(CapeChangerModule.OnyxLogoLocalFileEnum.LOCAL_FILE)
               && !this.valueSettingSub112.isEnum3(Util2.AutoFitEnum.TEXTURE)
         )
         .getModeSetting3(var1 -> this.run86());
      this.valueSettingSub102 = new ValueSettingSub10("Zoom", 100.0, 10.0, 400.0, 5.0)
         .getValueSettingSub10("%")
         .getSetting2(
            () -> this.valueSettingSub113.isEnum3(CapeChangerModule.OnyxLogoLocalFileEnum.LOCAL_FILE)
               && !this.valueSettingSub112.isEnum3(Util2.AutoFitEnum.TEXTURE)
         )
         .getModeSetting3(var1 -> this.run86());
      this.valueSettingSub10 = new ValueSettingSub10("Offset X", 0.0, -100.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getSetting2(
            () -> this.valueSettingSub113.isEnum3(CapeChangerModule.OnyxLogoLocalFileEnum.LOCAL_FILE)
               && !this.valueSettingSub112.isEnum3(Util2.AutoFitEnum.TEXTURE)
         )
         .getModeSetting3(var1 -> this.run86());
      this.valueSettingSub103 = new ValueSettingSub10("Offset Y", 0.0, -100.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getSetting2(
            () -> this.valueSettingSub113.isEnum3(CapeChangerModule.OnyxLogoLocalFileEnum.LOCAL_FILE)
               && !this.valueSettingSub112.isEnum3(Util2.AutoFitEnum.TEXTURE)
         )
         .getModeSetting3(var1 -> this.run86());
      this.settingSub3 = new SettingSub("Edit", () -> MINECRAFT.displayGuiScreen(new Fit(MINECRAFT.currentScreen)))
         .getSettingSub("Edit cape…")
         .getBooleanSetting("Drag the picture around the cape and scroll to zoom")
         .getSetting2(
            () -> this.valueSettingSub113.isEnum3(CapeChangerModule.OnyxLogoLocalFileEnum.LOCAL_FILE)
               && !this.valueSettingSub112.isEnum3(Util2.AutoFitEnum.TEXTURE)
         );
      this.string3 = "";
      this.valueSettingSub113.getModeSetting3(var1 -> {
         if (this.isEnabled55()) {
            this.lambda72();
         }
      });
   }

   public void run86() {
      if (!this.bool2) {
         if (this.isEnabled55() && this.valueSettingSub113.isEnum3(CapeChangerModule.OnyxLogoLocalFileEnum.LOCAL_FILE) && this.bufferedImage != null) {
            int var4 = this.int_ + 1;
            this.int_ = var4;
            CapeLoader.handleBufferedImage(
               this.bufferedImage,
               this.valueSettingSub112.lambda15(),
               this.valueSettingSub6.lambda15(),
               this.valueSettingSub102.lambda15() / 100.0,
               this.valueSettingSub10.lambda15() / 100.0,
               this.valueSettingSub103.lambda15() / 100.0,
               var2 -> {
                  if (var4 == this.int_) {
                     this.handleResourceLocation6(var2);
                  }
               }
            );
         }
      }
   }

   public static enum OnyxLogoLocalFileEnum {
      ONYX_LOGO,
      LOCAL_FILE;

   }
}
