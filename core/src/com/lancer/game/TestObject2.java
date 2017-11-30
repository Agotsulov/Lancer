package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by byzilio on 30.11.17.
 */

public class TestObject2 extends GameObject {
    Texture texture;


    public TestObject2(float x, float y, float width, float height) {
        super(x, y, width, height);
        texture = new Texture("badlogic.jpg");
        name = "B";
    }


    public TestObject2(float x, float y, float width, float height,String name) {
        super(x, y, width, height);
        texture = new Texture("badlogic.jpg");
        this.name = name;
    }

    public void update() {
        Gdx.app.log("TestObject","update");
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {
        Gdx.app.log("21","");
    }
}
