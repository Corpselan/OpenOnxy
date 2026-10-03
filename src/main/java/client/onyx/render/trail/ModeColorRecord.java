package client.onyx.render.trail;

import client.onyx.module.render.TrailsModule;

public record ModeColorRecord(TrailsModule.WallPointsEnum mode, int color, float opacity, long lifetime, float lineWidth, float pointSize, boolean throughWalls) {
}
