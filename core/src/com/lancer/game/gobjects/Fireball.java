package com.lancer.game.gobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;

/**
 * Created by byzilio on 02.12.17.
 */

public class Fireball extends GameObject {

    Texture texture;

    public Fireball(float x, float y, Vector2 dir){
        this.x = x;
        this.y = y;
        width = 10;
        height = 10;
        maxVelocity = 5;
        u = dir;
        texture = new Texture("fireball.png");
        mass = 0;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {
        if(another.tag == "Entity"){
            Entity e = (Entity) another;
            e.health -= 10;
        }
    }

    @Override
    public void dispose() {

    }
}
