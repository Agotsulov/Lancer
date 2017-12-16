package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;

/**
 * Created by byzilio on 03.12.17.
 */

public class Block extends GameObject {

    Texture texture;

    public Block(float x,float y,float w,float h,String filename){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        texture = new Texture(filename);
        layer=0;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {

    }
}
