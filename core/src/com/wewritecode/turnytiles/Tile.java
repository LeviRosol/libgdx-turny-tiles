package com.wewritecode.turnytiles;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by levirosol on 12/26/15.
 */
public class Tile extends BaseActor {

    public Tile (Texture texture){
        _texture = texture;
        setBounds(0, 0, 32, 32);
    }
}
