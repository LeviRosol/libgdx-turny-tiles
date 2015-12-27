package com.wewritecode.turnytiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;

/**
 * Created by levirosol on 12/26/15.
 */
public class TileStage extends BaseStage {

    public TileStage(TiledMap tiledMap, TiledMapRenderer renderer) {
        _tiledMap = tiledMap;
        _renderer = renderer;
    }
}