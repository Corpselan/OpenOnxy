package client.onyx.render.font;

public record OpticalWeightRecord(Util.Pt9Pt24Enum optical, Util.ThinExtraLightEnum weight, float size, float lineHeight) {
   public float getFloat3() {
      return this.getFloat4() + this.getFloat();
   }

   public static String decrypt(String var0) {
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 125;
      byte var10001 = 52;
      int var10000 = var10002;

      for (byte var2 = 101; var10000 >= 0; var10000 = var5) {
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

   public float getFloat4() {
      return this.getAyg().getFloat5() * this.getFloat2();
   }

   public float getFloat() {
      return this.getAyg().getFloat2() * this.getFloat2();
   }

   public float getFloat2() {
      float var1 = this.size;
      float var2 = this.optical.getFloat();
      return var1 / var2;
   }

   public Ayg getAyg() {
      return Util.getAygForPt9Pt24Enum(this.optical, this.weight);
   }
}
