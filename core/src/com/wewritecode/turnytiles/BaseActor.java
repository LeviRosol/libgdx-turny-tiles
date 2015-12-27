package com.wewritecode.turnytiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Iterator;

/**
 * Created by levirosol on 12/26/15.
 */
public abstract class BaseActor extends Actor {
    protected Texture _texture;
    protected TextureRegion _textureRegion;
    protected World _world;
    protected GridCell _cell;

    private TiledMap tiledMap;

    private TiledMapTileLayer tiledLayer;

    private TiledMapTileLayer.Cell cell;

    private TiledMapStage stage;

    public BaseActor(TiledMap tiledMap, TiledMapTileLayer tiledLayer, TiledMapTileLayer.Cell cell, TiledMapStage stage) {
        this.tiledMap = tiledMap;
        this.tiledLayer = tiledLayer;
        this.cell = cell;
        this.stage = stage;
    }

    public BaseActor() {

    }

    public World getWorld(){
        return _world;
    }

    @Override
    public void draw(Batch batch, float alpha){
        if(_texture == null){
            batch.draw(_textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
                    getHeight(), getScaleX(), getScaleY(), getRotation());
        }else {
            batch.draw(_texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
                    getHeight(), getScaleX(), getScaleY(), getRotation(), 0, 0,
                    _texture.getWidth(), _texture.getHeight(), false, false);
        }
    }

    @Override
    public void act(float delta){
        for(Iterator<Action> iter = getActions().iterator(); iter.hasNext();){
            iter.next().act(delta);
        }
    }
}
