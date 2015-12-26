package com.wewritecode.turnytiles;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by levirosol on 12/25/15.
 */
public class TiledMapClickListener extends ClickListener {

    private TiledMapActor actor;

    public TiledMapClickListener(TiledMapActor actor) {
        this.actor = actor;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        int rotation = actor.getCell().getRotation();
        actor.getCell().setRotation(rotation == 4 ? 1 : rotation + 1);

        checkMapRotation(actor.getTiledLayer());
    }

    private void checkMapRotation(TiledMapTileLayer tiledLayer) {
        int misplaced_count = 0;

        for (int x = 0; x < tiledLayer.getWidth(); x++) {
            for (int y = 0; y < tiledLayer.getHeight(); y++) {
                TiledMapTileLayer.Cell cell = tiledLayer.getCell(x, y);
                if(cell != null && cell.getRotation() != 4){
                    misplaced_count++;
                }
            }
        }

        if(misplaced_count > 0){
            System.out.println("You have " + misplaced_count + " misplaced tiles.");
        } else {
            System.out.println("You solved it!!");

            if(actor.getStage().getCurrent_level() < 10) {
                actor.getStage().setCurrent_level(actor.getStage().getCurrent_level() + 1);
            }else{
                System.out.println("You beat all of the levels!");
            }
        }
    }
}