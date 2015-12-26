package com.wewritecode.turnytiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by levirosol on 12/25/15.
 */
public class TiledMapActor extends Actor {

    private TiledMap tiledMap;

    private TiledMapTileLayer tiledLayer;

    private TiledMapTileLayer.Cell cell;

    private TiledMapStage stage;

    public TiledMapActor(TiledMap tiledMap, TiledMapTileLayer tiledLayer, TiledMapTileLayer.Cell cell, TiledMapStage stage) {
        this.tiledMap = tiledMap;
        this.tiledLayer = tiledLayer;
        this.cell = cell;
        this.stage = stage;
    }

    public TiledMapTileLayer.Cell getCell(){
        return cell;
    }

    public TiledMapTileLayer getTiledLayer(){
        return tiledLayer;
    }

    public TiledMapStage getStage(){
        return stage;
    }
}