package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by byzilio on 28.11.17.
 */

public class TestObject extends GameObject {


    @Override
    public void update() {
        Gdx.app.log("TestObject","update");
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void collide(GameObject another) {

    }
}
