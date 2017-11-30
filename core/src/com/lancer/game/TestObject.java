package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by byzilio on 28.11.17.
 */

public class TestObject extends GameObject {
    Texture texture;

    public TestObject(){
        super(0,0,130,120);
        texture = new Texture("badlogic.jpg");
    }
    public TestObject(float x,float y,float width,float height){
        super(x,y,width,height);
        texture = new Texture("badlogic.jpg");
    }
    @Override
    public void update() {
        Gdx.app.log("TestObject","update");
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {
    Gdx.app.log("12","");
    }
}
