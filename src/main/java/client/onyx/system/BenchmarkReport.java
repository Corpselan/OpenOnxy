package client.onyx.system;

import client.onyx.OnyxClient;
import client.onyx.module.Module;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ScreenShotHelper;

public final class BenchmarkReport {
   private static boolean bool;
   private static final String STRING = System.getProperty("onyx.bench");
   private static float float_;
   private static final boolean BOOL2 = STRING != null && !STRING.isEmpty();
   private static final long LONG = Long.getLong("onyx.bench.warmup", 12000L) * 1000000L;
   private static double double_;
   private static final double DOUBLE = 4.0;
   private static final long LONG3 = Long.getLong("onyx.bench.measure", 4000L) * 1000000L;
   private static final List<BenchmarkReport.LabelOffRecord> LIST = new ArrayList<>();
   private static final List<BenchmarkReport.LabelAvgFpsRecord> LIST3 = new ArrayList<>();
   private static final List<Long> LIST2 = new ArrayList<>();
   private static final long LONG2 = 700000000L;
   private static long long_;
   private static final double DOUBLE2 = 0.18;
   private static BenchmarkReport.MenuLoadingEnum menuLoadingEnum = BenchmarkReport.MenuLoadingEnum.MENU;
   private static boolean bool2 = true;
   private static long long_2;
   private static int int_;
   private static double double_2;
   private static final boolean BOOL = System.getProperty("onyx.bench.walk") != null;
   private static double double_3;
   private static float float_2;

   private BenchmarkReport() {
   }

   private static void handleMinecraft6(Minecraft var0) {
      if (bool && var0.thePlayer != null) {
         BenchmarkReport.LabelOffRecord var10 = int_ < LIST.size() ? LIST.get(int_) : null;
         float var2 = var10 != null && var10.yaw() != null ? var10.yaw() : float_2;
         float var3 = var10 != null && var10.pitch() != null ? var10.pitch() : float_;
         handleMinecraft2(var0);
         if (BOOL) {
            var0.gameSettings.thirdPersonView = 1;
            var0.thePlayer.rotationYaw = var2;
            var0.thePlayer.rotationPitch = var3;
            double var4 = var0.thePlayer.posX - double_2;
            double var6 = var0.thePlayer.posZ - double_3;
            double var8;
            if ((var8 = Math.sqrt(var4 * var4 + var6 * var6)) > 4.0) {
               var0.thePlayer.motionX = -var4 / var8 * 0.18;
               var0.thePlayer.motionZ = -var6 / var8 * 0.18;
            } else {
               var4 = System.nanoTime() % 4000000000L / 4.0E9 * 2.0 * Math.PI;
               var0.thePlayer.motionX = Math.cos(var4) * 0.18;
               var0.thePlayer.motionZ = Math.sin(var4) * 0.18;
            }
         } else {
            var0.thePlayer.setPositionAndRotation(double_2, double_, double_3, var2, var3);
            var0.thePlayer.motionX = 0.0;
            var0.thePlayer.motionY = 0.0;
            var0.thePlayer.motionZ = 0.0;
            var0.thePlayer.onGround = true;
         }
      }
   }

   private static void handleMinecraft(Minecraft var0) {
      Iterator var3 = LIST.get(int_).off().iterator();

      while (var3.hasNext()) {
         Module var2;
         if ((var2 = getModuleForString((String)var3.next())) != null) {
            var2.handleBool16(true);
         }
      }
   }

   private static void run() {
      StringBuilder var0;
      StringBuilder var10000 = var0 = new StringBuilder();
      Locale var10001 = Locale.ROOT;
      Object[] var10003 = new Object[5];
      boolean var10005 = true;
      var10003[0] = "phase";
      var10003[1] = "fps";
      var10003[2] = "median ms";
      var10003[3] = "p95 ms";
      var10003[4] = "vs base";
      var10000.append(String.format(var10001, "%-28s %8s %10s %10s %10s%n", var10003));
      double var1 = LIST3.isEmpty() ? 0.0 : LIST3.get(0).avgFps();

      Iterator var3;
      for (Iterator var13 = var3 = LIST3.iterator(); var13.hasNext(); var13 = var3) {
         BenchmarkReport.LabelAvgFpsRecord var4 = (BenchmarkReport.LabelAvgFpsRecord)var3.next();
         var10001 = Locale.ROOT;
         var10003 = new Object[5];
         var10005 = true;
         var10003[0] = var4.label();
         var10003[1] = var4.avgFps();
         var10003[2] = var4.medianMs();
         var10003[3] = var4.p95Ms();
         var10003[4] = var4.avgFps() - var1;
         var0.append(String.format(var10001, "%-28s %8.1f %10.2f %10.2f %+10.1f%n", var10003));
      }

      System.out.println(new StringBuilder().insert(0, "[onyx-bench] results\n").append((Object)var0).toString());
      String var12;
      if (!(var12 = System.getProperty("onyx.bench.out", "")).isEmpty()) {
         try {
            String[] var5 = new String[0];
            Path var6 = Path.of(var12, var5);
            String var7 = var0.toString();
            Charset var8 = StandardCharsets.UTF_8;
            OpenOption[] var9 = new OpenOption[0];
            Path var10 = Files.writeString(var6, var7, var8, var9);
         } catch (IOException var11) {
            handleString2(new StringBuilder().insert(0, "could not write report: ").append(var11).toString());
         }
      }
   }

   public static void run3() {
      if (BOOL2 && menuLoadingEnum != BenchmarkReport.MenuLoadingEnum.DONE) {
         Minecraft var0 = Minecraft.getMinecraft();
         long var1 = System.nanoTime();
         switch (menuLoadingEnum) {
            case MENU:

               if (var0.currentScreen instanceof GuiMainMenu) {
                  bool2 = var0.gameSettings.pauseOnLostFocus;
                  var0.gameSettings.pauseOnLostFocus = false;
                  handleString2(new StringBuilder().insert(0, "joining world '").append(STRING).append("'").toString());
                  var0.launchIntegratedServer(STRING, STRING, null);
                  handleMenuLoadingEnum(BenchmarkReport.MenuLoadingEnum.LOADING, var1);
                  return;
               }
               break;
            case LOADING:
               if (var0.thePlayer != null && var0.theWorld != null) {
                  var0.displayGuiScreen(null);
                  handleMinecraft5(var0);
                  run2();
                  handleString2("world up, warming up");
                  handleMenuLoadingEnum(BenchmarkReport.MenuLoadingEnum.WARMUP, var1);
                  return;
               }
               break;
            case WARMUP:
               handleMinecraft6(var0);
               if (var1 - long_ >= LONG) {
                  handleMinecraft3(var0, var1);
                  return;
               }
               break;
            case SETTLE:
               handleMinecraft6(var0);
               if (var1 - long_ >= 700000000L) {
                  LIST2.clear();
                  long_2 = var1;
                  handleMenuLoadingEnum(BenchmarkReport.MenuLoadingEnum.MEASURE, var1);
                  return;
               }
               break;
            case MEASURE:
               handleMinecraft6(var0);
               LIST2.add(var1 - long_2);
               long_2 = var1;
               if (var1 - long_ >= LONG3) {
                  handleMinecraft4(var0, LIST.get(int_).label());
                  handleString(LIST.get(int_).label());
                  handleMinecraft(var0);
                  int_++;
                  if (int_ >= LIST.size()) {
                     run();
                     menuLoadingEnum = BenchmarkReport.MenuLoadingEnum.DONE;
                     var0.gameSettings.pauseOnLostFocus = bool2;
                     var0.shutdown();
                     return;
                  }

                  handleMinecraft3(var0, var1);
                  return;
               }
         }
      }
   }

   private static Module getModuleForString(String var0) {
      if (OnyxClient.cls == null) {
         return null;
      } else {
         Iterator var3 = OnyxClient.cls.getArrayList().iterator();

         while (var3.hasNext()) {
            Module var2;
            if ((var2 = (Module)var3.next()).getString20().equalsIgnoreCase(var0)) {
               return var2;
            }
         }

         handleString2(new StringBuilder().insert(0, "unknown module '").append(var0).append("'").toString());
         return null;
      }
   }

   private static void run2() {
      String var0 = System.getProperty("onyx.bench.modules", "");
      List var7 = LIST;
      List var8 = List.of();
      BenchmarkReport.LabelOffRecord var9 = new BenchmarkReport.LabelOffRecord("baseline", var8, null, null);
      boolean var10 = var7.add(var9);
      if (!var0.isEmpty() && !var0.equals("-")) {
         String[] var1;
         int var2 = (var1 = var0.split(",")).length;

         int var3;
         for (int var10000 = var3 = 0; var10000 < var2; var10000 = ++var3) {
            String var4;
            if (!(var4 = var1[var3].trim()).isEmpty()) {
               if (var4.equalsIgnoreCase("ALL")) {
                  List var11 = LIST;
                  List var12 = getList();
                  BenchmarkReport.LabelOffRecord var13 = new BenchmarkReport.LabelOffRecord("all render off", var12, null, null);
                  boolean var14 = var11.add(var13);
               } else if (var4.equalsIgnoreCase("gui")) {
                  List var15 = LIST;
                  List var16 = List.of();
                  BenchmarkReport.LabelOffRecord var17 = new BenchmarkReport.LabelOffRecord("gui", var16, null, null);
                  boolean var18 = var15.add(var17);
               } else if (var4.toLowerCase(Locale.ROOT).startsWith("only:")) {
                  List<String> var5 = List.of(var4.substring(5).split("\\+", -1)).stream().map(String::trim).toList();
                  ArrayList<String> var6;
                  (var6 = new ArrayList<>(getList())).removeIf(var1x -> var5.stream().anyMatch(var1xx -> var1xx.equalsIgnoreCase(var1x)));
                  LIST.add(new BenchmarkReport.LabelOffRecord(var4, var6, null, null));
               } else if (var4.toLowerCase(Locale.ROOT).startsWith("look:")) {
                  String[] var23 = var4.substring(5).split("/");
                  LIST.add(new BenchmarkReport.LabelOffRecord(var4, List.of(), Float.parseFloat(var23[0].trim()), Float.parseFloat(var23[1].trim())));
               } else {
                  LIST.add(
                     new BenchmarkReport.LabelOffRecord(
                        new StringBuilder().insert(0, "-").append(var4).toString(),
                        List.of(var4.split("\\+", -1)).stream().map(String::trim).toList(),
                        null,
                        null
                     )
                  );
               }
            }
         }
      }

      List var19 = LIST;
      List var20 = List.of();
      BenchmarkReport.LabelOffRecord var21 = new BenchmarkReport.LabelOffRecord("baseline (repeat)", var20, null, null);
      boolean var22 = var19.add(var21);
   }

   private static void handleMinecraft4(Minecraft var0, String var1) {
      String var3;
      if (!(var3 = System.getProperty("onyx.bench.shots", "")).isEmpty()) {
         try {
            File var5;
            (var5 = new File(var3)).mkdirs();
            ScreenShotHelper.saveScreenshot(var5, var1.replaceAll("[^A-Za-z0-9-]", "_") + ".png", var0.displayWidth, var0.displayHeight, var0.getFramebuffer());
         } catch (Throwable var4) {
            handleString2(new StringBuilder().insert(0, "screenshot failed: ").append(var4).toString());
         }
      }
   }

   private static void handleMenuLoadingEnum(BenchmarkReport.MenuLoadingEnum var0, long var1) {
      menuLoadingEnum = var0;
      long_ = var1;
   }

   private static void handleMinecraft5(Minecraft var0) {
      String var2;
      String[] var3;
      if (!(var2 = System.getProperty("onyx.bench.pose", "")).isEmpty() && (var3 = var2.split(",")).length == 5) {
         double_2 = Double.parseDouble(var3[0].trim());
         double_ = Double.parseDouble(var3[1].trim());
         double_3 = Double.parseDouble(var3[2].trim());
         float_2 = Float.parseFloat(var3[3].trim());
         float_ = Float.parseFloat(var3[4].trim());
         bool = true;
      } else {
         double_2 = var0.thePlayer.posX;
         double_ = var0.thePlayer.posY;
         double_3 = var0.thePlayer.posZ;
         float_2 = 0.0F;
         float_ = 0.0F;
         bool = true;
         Locale var10000 = Locale.ROOT;
         Object[] var10002 = new Object[5];
         boolean var10004 = true;
         var10002[0] = double_2;
         var10002[1] = double_;
         var10002[2] = double_3;
         var10002[3] = var0.displayWidth;
         var10002[4] = var0.displayHeight;
         handleString2(String.format(var10000, "pose %.2f,%.2f,%.2f  display %dx%d", var10002));
      }
   }

   private static void handleMinecraft2(Minecraft var0) {
      String var3;
      if (!(var3 = System.getProperty("onyx.bench.hold", "")).isEmpty()) {
         Item var4;
         if ((var4 = Item.getByNameOrId(var3)) != null) {
            ItemStack var2;
            if ((var2 = var0.thePlayer.getHeldItem()) == null || var2.getItem() != var4) {
               var0.thePlayer.inventory.mainInventory[var0.thePlayer.inventory.currentItem] = new ItemStack(var4);
            }
         }
      }
   }

   private static void handleString2(String var0) {
      System.out.println(new StringBuilder().insert(0, "[onyx-bench] ").append(var0).toString());
   }

   private static void handleString(String var0) {
      if (LIST2.size() < 4) {
         LIST3.add(new BenchmarkReport.LabelAvgFpsRecord(var0, 0.0, 0.0, 0.0));
      } else {
         long[] var8 = new long[LIST2.size()];
         long var2 = 0L;

         int var4;
         for (int var10000 = var4 = 0; var10000 < LIST2.size(); var10000 = var4) {
            var8[var4] = LIST2.get(var4);
            var2 += var8[var4++];
         }

         Arrays.sort(var8);
         double var12 = LIST2.size() / (var2 / 1.0E9);
         double var11 = var8[var8.length / 2] / 1000000.0;
         double var6 = var8[(int)(var8.length * 0.95)] / 1000000.0;
         LIST3.add(new BenchmarkReport.LabelAvgFpsRecord(var0, var12, var11, var6));
         Locale var13 = Locale.ROOT;
         Object[] var14 = new Object[4];
         boolean var10004 = true;
         var14[0] = var0;
         var14[1] = var12;
         var14[2] = var11;
         var14[3] = var6;
         handleString2(String.format(var13, "  %-28s %6.1f fps  median %5.2f ms  p95 %5.2f ms", var14));
      }
   }

   private static void handleMinecraft3(Minecraft var0, long var1) {
      BenchmarkReport.LabelOffRecord var6;
      BenchmarkReport.LabelOffRecord var10000;
      if ((var6 = LIST.get(int_)).label().equalsIgnoreCase("gui")) {
         OnyxClient.cls.clickGUIModule.handleBool16(true);
         var10000 = var6;
      } else {
         if (var0.currentScreen != null) {
            var0.displayGuiScreen(null);
         }

         var10000 = var6;
      }

      Iterator var4 = var10000.off().iterator();

      while (var4.hasNext()) {
         Module var5;
         if ((var5 = getModuleForString((String)var4.next())) != null) {
            var5.handleBool16(false);
         }
      }

      handleString2(new StringBuilder().insert(0, "phase ").append(int_ + 1).append("/").append(LIST.size()).append(": ").append(var6.label()).toString());
      handleMenuLoadingEnum(BenchmarkReport.MenuLoadingEnum.SETTLE, var1);
   }

   private static List<String> getList() {
      ArrayList var0 = new ArrayList();
      if (OnyxClient.cls == null) {
         return var0;
      } else {
         Iterator var1 = OnyxClient.cls.getArrayList().iterator();

         while (var1.hasNext()) {
            Module var2;
            if ((var2 = (Module)var1.next()).isEnabled55()) {
               var0.add(var2.getString20());
            }
         }

         return var0;
      }
   }

   private record LabelAvgFpsRecord(String label, double avgFps, double medianMs, double p95Ms) {
   }

   private record LabelOffRecord(String label, List<String> off, Float yaw, Float pitch) {
   }

   private static enum MenuLoadingEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      MENU,
      LOADING,
      WARMUP,
      SETTLE,
      MEASURE,
      DONE;

   }
}
