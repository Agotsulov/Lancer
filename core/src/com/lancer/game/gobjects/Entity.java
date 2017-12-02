package com.lancer.game.gobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;

import java.util.ArrayList;

/**
 * Created by byzilio on 02.12.17.
 */

public class Entity extends GameObject{

    public int health;

    public Entity(){
        health = 100;
        tag = "Entity";
    }
    public Entity(float x,float y,float width,float height){
        super(x,y,width,height);
        health = 100;
        tag = "Entity";

    }

    public void update(){
        super.update();
        Gdx.app.log("sqwwd","");
        if(health <= 0){
        this.width=0;
        this.height=0;
        }
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void collide(GameObject another) {

    }
}
