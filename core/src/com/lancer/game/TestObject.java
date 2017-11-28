package com.lancer.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by byzilio on 28.11.17.
 */

public class TestObject extends GameObject {


    @Override
    public void update() {
        Gdx.app.log("TestObject","update");
    }
}
