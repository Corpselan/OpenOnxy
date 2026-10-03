package client.onyx.render.anim;

import client.onyx.module.render.BlockOverlayModule;

public record ThemeColorRecord(
   BlockOverlayModule.OutlineFillEnum theme,
   int color,
   int secondColor,
   float lineWidth,
   float outlineOpacity,
   float fillOpacity,
   float glintAmount,
   float glintSpeed,
   float glintScale,
   float glintGlow,
   boolean progress,
   BlockOverlayModule.FillGrowEnum progressMode,
   boolean progressUpward,
   float progressOpacity,
   boolean throughWalls
) {
}
