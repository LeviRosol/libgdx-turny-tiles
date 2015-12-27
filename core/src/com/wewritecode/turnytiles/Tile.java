package com.wewritecode.turnytiles;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by levirosol on 12/26/15.
 */
public class Tile extends BaseActor {

    public Tile (Texture texture){
        super();
        _texture = texture;
        setBounds(getX(), getY(), _texture.getWidth(), _texture.getHeight());
    }
}
