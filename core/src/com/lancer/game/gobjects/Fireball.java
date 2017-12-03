package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
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
    public int damage;

    public Fireball(float x, float y, Vector2 dir,int damage){
        this.x = x;
        this.y = y;
        width = 10;
        height = 10;
        name="Fireball";
        maxVelocity = 5;
        u = dir;
        texture = new Texture("fireball.png");
        mass = 0;
        this.damage = damage;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {
        if(another.tag == "Entity" && another.name!="Player"){
            Entity e = (Entity) another;
            e.damage(damage);

           Gdx.app.log("hui12312",""+e.toString());
            this.dispose();
            this.kill();
        }
    }

    @Override
    public void dispose() {

    }
}
