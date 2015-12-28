package com.wewritecode.turnytiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Created by levirosol on 12/26/15.
 */
public class Level extends Group {
    private Group _layer;
    private Grid _grid;
    private World _world;
    private int _number;
    private Tile[][] _tiles;

    public Level(World world){
        _world = world;
//        _number = world.getLevels().size();
        _layer = new Group();
    }

    public Group getLayer(){
        return _layer;
    }

    public Grid getGrid(){
        return _grid;
    }

    public Tile getTile(int x, int y){
        return _tiles[x][y];
    }

    public void setGrid(Grid grid){
        _grid = grid;
    }

    public World getWorld(){
        return _world;
    }

    public int getNumber(){
        return _number;
    }

    public void createActorsForLayer(TiledMapTileLayer tiledLayer) {
        _tiles = new Tile[tiledLayer.getWidth()][tiledLayer.getHeight()];
        Texture texture = new Texture(Gdx.files.internal("shapes.png"));

        for (int x = 0; x < tiledLayer.getWidth(); x++) {
            for (int y = 0; y < tiledLayer.getHeight(); y++) {
                TiledMapTileLayer.Cell cell = tiledLayer.getCell(x, y);
                if(cell != null) {
                    Tile tile = new Tile(texture);
                    tile.setDebug(true);
                    tile.setVisible(true);
                    _tiles[x][y] = tile;
                    addActor(tile);
//                    rotateTile(cell);
//                    GridCell gridCell = new GridCell(x, y, 32, 32, _grid, tile);
//                    TiledMapActor actor = new BaseActor(_world.getTiledMap(), tiledLayer, cell, this);
//                    actor.setBounds(x, y, 1, 1); // instead of using the tile height/width, we use 1 because the camera is set to a scale of 32 already.
//                    addActor(actor);
//                    EventListener eventListener = new TiledMapClickListener(actor);
//                    actor.addListener(eventListener);
                }
            }
        }
    }

}
