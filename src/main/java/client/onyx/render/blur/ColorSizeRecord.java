package client.onyx.render.blur;

public record ColorSizeRecord(
   int color,
   float size,
   float speed,
   float startPhase,
   float glow,
   boolean gradient,
   boolean trail,
   float trailLength,
   float trailOpacity,
   boolean particles,
   float particleHeight,
   float particleLife,
   boolean redOnImpact,
   float impactFadeIn,
   float impactFadeOut,
   float impactIntensity
) {
}
