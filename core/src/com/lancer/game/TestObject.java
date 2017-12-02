package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.helper.TouchListener;

/**
 * Created by byzilio on 28.11.17.
 */

public class TestObject extends GameObject {
    Texture texture;
    TouchListener touch;
    public TestObject(){

        super(0,0,130,120);
        texture = new Texture("badlogic.jpg");
        name = "A";
    }
    public TestObject(float x,float y,float width,float height){

        super(x,y,width,height);

        texture = new Texture("badlogic.jpg");
        name = "A";

    }


    public TestObject(float x,float y,float width,float height,String name){
        super(x,y,width,height);
        Gdx.input.setInputProcessor(touch);
        texture = new Texture("badlogic.jpg");
        this.name = name;
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

   // Gdx.app.log("12","");
    }
}
