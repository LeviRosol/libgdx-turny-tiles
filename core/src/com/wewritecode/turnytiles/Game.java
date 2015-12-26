package com.wewritecode.turnytiles;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
    private OrthographicCamera camera;
    private BitmapFont font;
    private SpriteBatch batch;
    private TiledMapStage stage;

	@Override
	public void create () {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, (w / h) * 10, 10);
        camera.update();

        font = new BitmapFont();
        batch = new SpriteBatch();

        stage = new TiledMapStage("level_1.tmx");
        Gdx.input.setInputProcessor(stage);

        stage.getViewport().setCamera(camera);
    }

	@Override
	public void render () {
        Gdx.gl.glClearColor(240/255f, 248/255f, 255/255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        stage.getTiledMapRenderer().setView(camera);
        stage.getTiledMapRenderer().render();
        batch.begin();
        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
        batch.end();
        stage.act();
    }

    @Override
    public void dispose () {
        stage.getTiledMap().dispose();
    }
}
