package com.lancer.game.gobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;

/**
 * Created by byzilio on 02.12.17.
 */

public class Entity extends GameObject{

    protected int health;

    public Entity(){
        health = 100;
        tag = "Entity";
    }

    public void update(){
        super.update();
        if(health <= 0){

        }
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void collide(GameObject another) {

    }
}
