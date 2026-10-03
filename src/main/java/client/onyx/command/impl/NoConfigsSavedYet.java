package client.onyx.command.impl;

import client.onyx.OnyxClient;
import client.onyx.command.Abstract_;
import client.onyx.config.ConfigManager;
import java.util.List;
import java.util.Locale;

public class NoConfigsSavedYet extends Abstract_ {
   @Override
   public void handleStringArray(String[] var1) {
      if (var1.length == 0) {
         this.run23();
      } else {
         byte var10000;
         label54: {
            String var2 = var1[0].toLowerCase(Locale.ROOT);
            byte var4 = -1;
            switch (var2.hashCode()) {
               case -1268966290:

                  if (var2.equals("folder")) {
                     var10000 = var4 = 3;
                     break label54;
                  }
                  break;
               case 3198785:
                  if (var2.equals("help")) {
                     var4 = 5;
                  }
                  break;
               case 3322014:
                  if (var2.equals("list")) {
                     var10000 = var4 = 2;
                     break label54;
                  }
                  break;
               case 3327206:
                  if (var2.equals("load")) {
                     var10000 = var4 = 1;
                     break label54;
                  }
                  break;
               case 3417674:
                  if (var2.equals("open")) {
                     var10000 = var4 = 4;
                     break label54;
                  }
                  break;
               case 3522941:
                  if (var2.equals("save")) {
                     var10000 = var4 = 0;
                     break label54;
                  }
            }

            var10000 = var4;
         }

         switch (var10000) {
            case 0:

               this.handleString5(this.getString16(var1));
               return;
            case 1:
               String var5 = this.getString16(var1);
               this.handleString4(var5);
               return;
            case 2:
               this.run22();
               return;
            case 3:
            case 4:
               this.run21();
               return;
            case 5:
               this.run23();
               return;
            default:
               handleString3(
                  new StringBuilder().insert(0, "Unknown subcommand: ").append(var1[0]).append(" (try ").append(this.getString15()).append(")").toString()
               );
         }
      }
   }

   public NoConfigsSavedYet() {
      super("config", "Saves and loads client configs", ".config <save|load|list|folder|help> [name]", new String[]{"cfg"});
   }

   private String getString16(String[] var1) {
      return var1.length > 1 ? var1[1] : "default";
   }

   private void run21() {
      OnyxClient.configManager.run207();
      handleString2(new StringBuilder().insert(0, "Opened ").append(OnyxClient.configManager.getPath4()).toString());
   }

   private void handleString5(String var1) {
      ConfigManager var2 = OnyxClient.configManager;
      if (!OnyxClient.configManager.lambda317(var1)) {
         handleString3(new StringBuilder().insert(0, "Invalid name '").append(var1).append("', use letters, digits, - and _").toString());
      } else {
         boolean var10000 = var2.isString4(var1);
         StringBuilder var10002;
         if (var10000) {
            var10002 = new StringBuilder();
            handleString2(var10002.insert(0, "Saved config '").append(var1).append("'").toString());
         } else {
            var10002 = new StringBuilder();
            handleString3(var10002.insert(0, "Could not save config '").append(var1).append("', see the log").toString());
         }
      }
   }

   private void run23() {
      handleString2(this.getString13());
      handleString2(".config save [name] - writes the current settings");
      handleString2(".config load [name] - applies a saved config");
      handleString2(".config list - lists saved configs");
      handleString2(".config folder - opens the config folder");
      handleString2("[name] defaults to 'default', which loads on start and saves on quit");
   }

   private void handleString4(String var1) {
      ConfigManager var2 = OnyxClient.configManager;
      if (!OnyxClient.configManager.lambda317(var1)) {
         handleString3(new StringBuilder().insert(0, "Invalid name '").append(var1).append("', use letters, digits, - and _").toString());
      } else if (!var2.isString8(var1)) {
         handleString3(new StringBuilder().insert(0, "No config named '").append(var1).append("'").toString());
      } else {
         boolean var10000 = var2.isString3(var1);
         StringBuilder var10002;
         if (var10000) {
            var10002 = new StringBuilder();
            handleString2(var10002.insert(0, "Loaded config '").append(var1).append("'").toString());
         } else {
            var10002 = new StringBuilder();
            handleString3(var10002.insert(0, "Could not load config '").append(var1).append("', see the log").toString());
         }
      }
   }

   private void run22() {
      List var2;
      if ((var2 = OnyxClient.configManager.getList31()).isEmpty()) {
         handleString2("No configs saved yet");
      } else {
         handleString2(var2.size() + " config(s): " + String.join(", ", var2));
      }
   }
}
