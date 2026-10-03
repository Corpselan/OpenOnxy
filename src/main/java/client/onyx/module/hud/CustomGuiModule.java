package client.onyx.module.hud;

import client.onyx.module.Module;
import client.onyx.module.ModuleCategory;
import client.onyx.render.hud.Util;
import client.onyx.render.hud.Util3;
import client.onyx.render.hud.Util5;
import client.onyx.render.hud.Util6;
import client.onyx.setting.BooleanSetting;
import client.onyx.setting.DisplayNamed;
import client.onyx.setting.impl.ValueSettingSub10;
import client.onyx.setting.impl.ValueSettingSub11;
import client.onyx.setting.impl.ValueSettingSub9;

public final class CustomGuiModule extends Module {
   public final CustomGuiModule.ScoreboardBooleanSetting scoreboardBooleanSetting;
   public final CustomGuiModule.NoGUIShadowBooleanSetting noGUIShadowBooleanSetting;
   public final CustomGuiModule.ChatBooleanSetting chatBooleanSetting;
   public final CustomGuiModule.TitleBooleanSetting titleBooleanSetting;
   public final CustomGuiModule.DurationBooleanSetting durationBooleanSetting;
   public final CustomGuiModule.HotbarBooleanSetting hotbarBooleanSetting;
   public final CustomGuiModule.BossbarBooleanSetting bossbarBooleanSetting;
   public final CustomGuiModule.ModeBooleanSetting modeBooleanSetting;
   public final CustomGuiModule.FontBooleanSetting fontBooleanSetting = new CustomGuiModule.FontBooleanSetting();

   public CustomGuiModule() {
      super("CustomGui", "Reskins Minecraft's own HUD and screens", ModuleCategory.HUD);
      this.chatBooleanSetting = new CustomGuiModule.ChatBooleanSetting();
      this.scoreboardBooleanSetting = new CustomGuiModule.ScoreboardBooleanSetting();
      this.titleBooleanSetting = new CustomGuiModule.TitleBooleanSetting();
      this.bossbarBooleanSetting = new CustomGuiModule.BossbarBooleanSetting();
      this.hotbarBooleanSetting = new CustomGuiModule.HotbarBooleanSetting();
      this.modeBooleanSetting = new CustomGuiModule.ModeBooleanSetting();
      this.noGUIShadowBooleanSetting = new CustomGuiModule.NoGUIShadowBooleanSetting();
      this.durationBooleanSetting = new CustomGuiModule.DurationBooleanSetting();
   }

   @Override
   protected void run79() {
      Util6.run();
      Util.run();
      Util5.run();
   }

   public static final class BossbarBooleanSetting extends BooleanSetting {
      public final ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub10 valueSettingSub102;
      public final ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Segments", false)
         .getBooleanSetting("Break the bar into notches instead of one continuous fill");
      public final ValueSettingSub10 valueSettingSub103;

      private BossbarBooleanSetting() {
         super("Bossbar", true);
         this.valueSettingSub102 = new ValueSettingSub10("Position X", 50.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
         this.valueSettingSub10 = new ValueSettingSub10("Position Y", 2.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
         this.valueSettingSub103 = new ValueSettingSub10("Scale", 1.0, 0.5, 2.0, 0.05).getSetting2(() -> false);
      }
   }

   public static final class ChatBooleanSetting extends BooleanSetting {
      public final ValueSettingSub9 valueSettingSub92;
      public final ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Hotbar lift", 14.0, 0.0, 32.0, 1.0)
         .getValueSettingSub10(" px")
         .getBooleanSetting("How far the hotbar moves up to make room for the chat box");

      private ChatBooleanSetting() {
         super("Chat", true);
         this.valueSettingSub10 = new ValueSettingSub10("Duration", 300.0, 80.0, 600.0, 10.0)
            .getValueSettingSub10(" ms")
            .getBooleanSetting("How long the chat takes to open and close");
         this.valueSettingSub92 = new ValueSettingSub9("Smooth caret", true)
            .getBooleanSetting("The text cursor glides as you type and breathes instead of blinking");
      }
   }

   public static final class DurationBooleanSetting extends BooleanSetting {
      public final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Duration", 300.0, 80.0, 600.0, 10.0).getValueSettingSub10(" ms");
      public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Scale from", 0.92, 0.5, 1.0, 0.01)
         .getValueSettingSub10("x")
         .getBooleanSetting("How small the screen starts before it settles");
      public final ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Fade", true).getBooleanSetting("Fade the whole screen in, not just scale it");
      public final ValueSettingSub9 valueSettingSub93 = new ValueSettingSub9("Centered containers", true)
         .getBooleanSetting("Stop the inventory sliding sideways when a potion effect is running");

      private DurationBooleanSetting() {
         super("Open animation", true);
      }
   }

   public static final class FontBooleanSetting extends BooleanSetting {
      public final ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub11<CustomGuiModule.RegularMediumEnum> valueSettingSub11 = new ValueSettingSub11<>(
            "Weight", CustomGuiModule.RegularMediumEnum.MEDIUM
         )
         .getModeSetting3(var0 -> Util3.run())
         .getBooleanSetting("How heavy the replacement font sits against the world");
      public final ValueSettingSub10 valueSettingSub102;
      public final ValueSettingSub9 valueSettingSub92;

      private FontBooleanSetting() {
         super("Font", true);
         this.valueSettingSub10 = new ValueSettingSub10("Size", 1.0, 0.85, 1.2, 0.01)
            .getValueSettingSub10("x")
            .getModeSetting3(var0 -> Util3.run())
            .getBooleanSetting("Scales the letters inside the 9px line the game lays text out on");
         this.valueSettingSub102 = new ValueSettingSub10("Letter spacing", 0.0, -1.0, 1.0, 0.05)
            .getValueSettingSub10(" px")
            .getBooleanSetting("Tightens or opens the gap between letters, in the game's own pixels");
         this.valueSettingSub92 = new ValueSettingSub9("Shadow", true).getBooleanSetting("Keep the drop shadow the game asks for");
      }
   }

   public static final class HotbarBooleanSetting extends BooleanSetting {
      public final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Scale", 1.0, 0.6, 1.6, 0.05).getValueSettingSub10("x");
      public final ValueSettingSub9 valueSettingSub92 = new ValueSettingSub9("Slot glide", true)
         .getBooleanSetting("The selection slides between slots instead of jumping");
      public final ValueSettingSub9 valueSettingSub93;
      public final ValueSettingSub9 valueSettingSub94 = new ValueSettingSub9("Item pop", true).getBooleanSetting("Items grow into place when a slot changes");

      private HotbarBooleanSetting() {
         super("Hotbar", true);
         this.valueSettingSub93 = new ValueSettingSub9("Blur", true).getBooleanSetting("Frost the bar over what is behind it (needs ClickGui's frosted glass)");
      }
   }

   public static enum IconsBarsEnum implements DisplayNamed {
      ICONS("Icons"),
      BARS("Bars");
      private final String string;

      @Override
      public String getString5() {
         return this.string;
      }


      private IconsBarsEnum(String var3) {
         this.string = var3;
      }
   }

   public static final class ModeBooleanSetting extends BooleanSetting {
      public final ValueSettingSub9 valueSettingSub92;
      public final ValueSettingSub9 valueSettingSub93;
      public final ValueSettingSub11<CustomGuiModule.IconsBarsEnum> valueSettingSub11 = new ValueSettingSub11<>("Mode", CustomGuiModule.IconsBarsEnum.ICONS)
         .getBooleanSetting("Redrawn icons, or continuous progress bars");

      private ModeBooleanSetting() {
         super("Status bars", true);
         this.valueSettingSub93 = new ValueSettingSub9("Animate", true).getBooleanSetting("Pop on gain, shake on damage, pulse when low");
         this.valueSettingSub92 = new ValueSettingSub9("Damage trail", true).getBooleanSetting("A lighter ghost that catches up to the value after a hit");
      }
   }

   public static final class NoGUIShadowBooleanSetting extends BooleanSetting {
      public final ValueSettingSub10 valueSettingSub10 = new ValueSettingSub10("Keep dim", 0.0, 0.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("How much of the vanilla darkening to keep");

      private NoGUIShadowBooleanSetting() {
         super("No GUI shadow", true);
      }
   }

   public static enum RegularMediumEnum implements DisplayNamed {
      REGULAR("Regular", client.onyx.render.font.Util.ThinExtraLightEnum.REGULAR),
      MEDIUM("Medium", client.onyx.render.font.Util.ThinExtraLightEnum.MEDIUM);
      private final String string;
      private final client.onyx.render.font.Util.ThinExtraLightEnum thinExtraLightEnum;

      @Override
      public String getString5() {
         return this.string;
      }


      private RegularMediumEnum(String var3, client.onyx.render.font.Util.ThinExtraLightEnum var4) {
         this.string = var3;
         this.thinExtraLightEnum = var4;
      }

      public client.onyx.render.font.Util.ThinExtraLightEnum getThinExtraLightEnum() {
         return this.thinExtraLightEnum;
      }
   }

   public static final class ScoreboardBooleanSetting extends BooleanSetting {
      public final ValueSettingSub9 valueSettingSub92;
      public final ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Background", 70.0, 0.0, 100.0, 1.0)
         .getValueSettingSub10("%")
         .getBooleanSetting("Opacity of the card behind the rows");
      public final ValueSettingSub10 valueSettingSub103;
      public final ValueSettingSub10 valueSettingSub104;
      public final ValueSettingSub10 valueSettingSub105;

      private ScoreboardBooleanSetting() {
         super("Scoreboard", true);
         this.valueSettingSub10 = new ValueSettingSub10("Min width", 60.0, 40.0, 260.0, 1.0)
            .getValueSettingSub10(" px")
            .getBooleanSetting("The card never draws narrower than this, however short its rows are");
         this.valueSettingSub92 = new ValueSettingSub9("Blur", true)
            .getBooleanSetting("Frost the card over what is behind it (needs ClickGui's frosted glass)");
         this.valueSettingSub104 = new ValueSettingSub10("Position X", 100.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
         this.valueSettingSub103 = new ValueSettingSub10("Position Y", 45.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
         this.valueSettingSub105 = new ValueSettingSub10("Scale", 1.0, 0.5, 2.0, 0.05).getSetting2(() -> false);
      }
   }

   public static final class TitleBooleanSetting extends BooleanSetting {
      public final ValueSettingSub10 valueSettingSub10;
      public final ValueSettingSub10 valueSettingSub102 = new ValueSettingSub10("Position X", 50.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
      public final ValueSettingSub10 valueSettingSub103;

      private TitleBooleanSetting() {
         super("Title", true);
         this.valueSettingSub10 = new ValueSettingSub10("Position Y", 38.0, 0.0, 100.0, 0.01).getSetting2(() -> false);
         this.valueSettingSub103 = new ValueSettingSub10("Scale", 1.0, 0.5, 2.0, 0.05).getSetting2(() -> false);
      }
   }
}
