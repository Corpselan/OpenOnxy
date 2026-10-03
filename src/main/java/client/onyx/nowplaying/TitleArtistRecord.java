package client.onyx.nowplaying;

import net.minecraft.util.ResourceLocation;

public record TitleArtistRecord(String title, String artist, ResourceLocation art, boolean playing, int progressMs, int durationMs, long capturedAtNanos) {
   public float getFloat() {
      if (this.durationMs <= 0) {
         return 0.0F;
      } else {
         long var1 = this.playing ? (System.nanoTime() - this.capturedAtNanos) / 1000000L : 0L;
         return Math.clamp((float)Math.min((long)this.durationMs, this.progressMs + var1) / this.durationMs, 0.0F, 1.0F);
      }
   }
}
