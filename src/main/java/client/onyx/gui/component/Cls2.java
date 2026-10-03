package client.onyx.gui.component;

import client.onyx.render.Sampler0;
import client.onyx.setting.Setting;
import client.onyx.theme.Util4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Cls2 {
   private final List<SettingComponent> list = new ArrayList<>();
   private final List<Cls2.YAlphaRecord> list2 = new ArrayList<>();

   public void run() {
      this.list.clear();
      this.list2.clear();
   }

   public float getFloat(float var1, float var2, float var3) {
      this.list2.clear();
      float var11 = var2;
      float var5 = 0.0F;
      boolean var6 = true;
      Iterator var7;
      Iterator var10000 = var7 = this.list.iterator();

      while (var10000.hasNext()) {
         SettingComponent var8;
         SettingComponent var12 = var8 = (SettingComponent)var7.next();
         float var9 = var12.getFloat183();
         float var10 = var12.getFloat184();
         if (var9 <= 0.5F) {
            var10000 = var7;
            var8.handleFloat80(var1, var11, var3, 0.0F);
         } else {
            if (!var6) {
               this.list2.add(new Cls2.YAlphaRecord(var11 + 7.5F, Math.min(var5, var10)));
               var11 += 15.0F;
            }

            var8.handleFloat80(var1, var11, var3, var9);
            var11 += var9;
            var5 = var10;
            var6 = false;
            var10000 = var7;
         }
      }

      return var11 - var2;
   }

   public boolean isEnabled() {
      return this.list.isEmpty();
   }

   public static String decrypt(String var0) {
      int var10000 = 3 << 3 ^ 6;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 116;
      var10000 = var10002;

      for (byte var2 = 119; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var10002 = var5--;
         var1[var10002] = (char)(var10.charAt(var10002) ^ var4);
      }

      return new String(var1);
   }

   public void handleSampler0(Sampler0 var1, float var2, float var3, int var4, float var5) {
      Iterator var9;
      Iterator var10000 = var9 = this.list2.iterator();

      while (var10000.hasNext()) {
         Cls2.YAlphaRecord var7;
         float var8;
         if ((var8 = (var7 = (Cls2.YAlphaRecord)var9.next()).alpha() * var5) <= 0.01F) {
            var10000 = var9;
         } else {
            var1.handleFloat28(var2, var7.y(), var3, 1.0F, Util4.getIntForInt2(var4, var8 * 0.8F));
            var10000 = var9;
         }
      }
   }

   public void handleList(List<Setting> var1) {
      this.run();
      Iterator var3 = var1.iterator();

      while (var3.hasNext()) {
         SettingComponent var2;
         if ((var2 = SettingComponent.getSettingComponentForSetting((Setting)var3.next())) != null) {
            this.list.add(var2);
         }
      }
   }

   public List<SettingComponent> getList() {
      return this.list;
   }

   private record YAlphaRecord(float y, float alpha) {
   }
}
