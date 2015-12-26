package com.wewritecode.turnytiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Random;

/**
 * Created by levirosol on 12/25/15.
 */
public class TiledMapStage extends Stage {

    private TiledMap tiledMap;
    private TiledMapRenderer renderer;
    private int current_level = 0;

    public TiledMapStage(String tmx_file) {
        tiledMap = new TmxMapLoader().load(tmx_file);
        renderer = new OrthogonalTiledMapRenderer(tiledMap, 1f / 32f);

        for(int i = 0; i < tiledMap.getLayers().getCount(); i++){
            TiledMapTileLayer tiledLayer = (TiledMapTileLayer) tiledMap.getLayers().get("Level " + i);

            if(i == current_level) {
                createActorsForLayer(tiledLayer);
                tiledLayer.setVisible(true);
            }else{
                tiledLayer.setVisible(false);
            }
        }
    }

    private void createActorsForLayer(TiledMapTileLayer tiledLayer) {
        for (int x = 0; x < tiledLayer.getWidth(); x++) {
            for (int y = 0; y < tiledLayer.getHeight(); y++) {
                TiledMapTileLayer.Cell cell = tiledLayer.getCell(x, y);
                if(cell != null) {
                    rotateTile(cell);
                    TiledMapActor actor = new TiledMapActor(tiledMap, tiledLayer, cell, this);
                    actor.setBounds(x, y, 1, 1); // instead of using the tile height/width, we use 1 because the camera is set to a scale of 32 already.
                    addActor(actor);
                    EventListener eventListener = new TiledMapClickListener(actor);


                    actor.addListener(eventListener);
                }
            }
        }
    }

    private void rotateTile(TiledMapTileLayer.Cell cell) {
        Random rand = new Random();
        cell.setRotation(rand.nextInt((4 - 1) + 1) + 1);
    }

    public TiledMapRenderer getTiledMapRenderer(){
        return renderer;
    }

    public TiledMap getTiledMap(){
        return tiledMap;
    }

    public void setCurrent_level(int level){
        current_level = level;

        for(int i = 0; i < tiledMap.getLayers().getCount(); i++){
            final TiledMapTileLayer tiledLayer = (TiledMapTileLayer) tiledMap.getLayers().get("Level " + i);

            if(i == current_level) {
                createActorsForLayer(tiledLayer);
                tiledLayer.setVisible(true);
            }else{
                tiledLayer.setVisible(false);
            }
        }

    }

    public int getCurrent_level(){
        return current_level;
    }
}