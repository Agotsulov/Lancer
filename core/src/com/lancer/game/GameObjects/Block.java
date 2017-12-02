package com.lancer.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;

/**
 * Created by byzilio on 02.12.17.
 */

public class Block extends GameObject{

    Texture texture;


    public Block(float x, float y, float width, float height) {
        super(x, y, width, height);
        texture = new Texture("badlogic.jpg");
        name = "B";
    }


    @Override
    public void update() {

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {

    }
}
