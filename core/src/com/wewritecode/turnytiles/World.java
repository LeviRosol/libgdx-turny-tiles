package com.wewritecode.turnytiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.ArrayList;

/**
 * Created by levirosol on 12/26/15.
 */
public class World{
    private TiledMap tiledMap;
    private TiledMapRenderer renderer;
    private BaseStage _stage;
    private Level[] _levels;
    private Level _currentLevel;
    private int _level_number;
    private Label _label;
    private boolean _inDebug = false;
    private Game _game;
    {
    }

    public void setStage(BaseStage stage) {
        stage.setWorld(this);

        _stage = stage;
    }

    public void BuildDebugLayer() {
        Skin skin = new Skin(Gdx.files.internal("skins/uiskin.json"));

        _label = new Label("", skin);

        Table root = new Table(skin);
        root.setBackground(skin.getDrawable("default-pane"));
        root.setPosition(120, 10);
        root.add(_label);

        Group debug = new Group();
        debug.addActor(root);

        getStage().addActor(debug);
    }

    public Level createLevel(String tileType){
        Level level = new Level(this);

//        level.setGrid(new Grid(level, 30, 30, tileType));

//        _levels.add(level);

        return level;
    }

    public void setCurrentLevel(int level) {
        _level_number = level;
        _currentLevel = _levels[_level_number];

        TiledMap tiledMap = new TiledMap();
        OrthogonalTiledMapRenderer renderer = new OrthogonalTiledMapRenderer(tiledMap, 1);

        TileStage stage = new TileStage(tiledMap, renderer);
        stage.addActor(_currentLevel.getLayer());
        setStage(stage);

        BuildDebugLayer();

    }

    public boolean getDebug(){
        return _inDebug;
    }

    public Label getDebugLabel(){
        return _label;
    }

    public BaseStage getStage(){
        return _stage;
    }

    public Grid getGrid(){
        return _currentLevel.getGrid();
    }

    public Level getCurrentLevel(){
        return _currentLevel;
    }

    public TiledMap getTiledMap(){
        return tiledMap;
    }

//    public ArrayList<Level> getLevels(){
//        return _levels;
//    }

    public Level getLevelByNumber(int number){
//        for (int y = 0; y < _levels.size(); y++) {
//            if (_levels.get(y).getNumber() == number){
//                return _levels.get(y);
//            }
//        }
        return null;
    }

    public void setDebug(boolean debug) {
        this._inDebug = debug;
    }

    public void setGame(Game game) {
        this._game = game;
    }

    public Game getGame() {
        return _game;
    }

    public void loadLevels(String tmx_file) {
        tiledMap = new TmxMapLoader().load(tmx_file);
        renderer = new OrthogonalTiledMapRenderer(tiledMap, 1f / 32f);

        _levels = new Level[tiledMap.getLayers().getCount()];

        for(int i = 0; i < tiledMap.getLayers().getCount(); i++) {
            TiledMapTileLayer tiledLayer = (TiledMapTileLayer) tiledMap.getLayers().get("Level " + i);
            Level level = new Level(this);
            level.createActorsForLayer(tiledLayer);
            level.setDebug(true);
            _levels[i] = level;
        }
    }
}