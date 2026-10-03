package client.onyx.nowplaying;

interface NowPlayingSource {
   NowPlayingSource.TitleArtistRecord2 getTitleArtistRecord2();

   public record TitleArtistRecord2(String title, String artist, boolean playing, int positionMs, int durationMs, String artUrl, byte[] artData) {
   }
}
