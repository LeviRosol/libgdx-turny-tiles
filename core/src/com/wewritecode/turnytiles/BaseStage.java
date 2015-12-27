package com.wewritecode.turnytiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by levirosol on 12/26/15.
 */
public abstract class BaseStage extends Stage {
    protected TiledMap _tiledMap;
    protected TiledMapRenderer _renderer;
    protected World _world;
//    private static final float PAN_RATE = 0.7f;
//    float initialScale = .4f;

    public void setWorld(World world){
        _world = world;
    }

    public TiledMapRenderer getTiledMapRenderer() {
        return _renderer;
    }

    public TiledMap getTiledMap() {
        return _tiledMap;
    }

    public World getWorld() {
        return _world;
    }
}