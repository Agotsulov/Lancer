package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;
import com.lancer.game.GameScreen;

/**
 * Created by byzilio on 02.12.17.
 */

public class Fireball extends GameObject {

    Texture texture;
    public int damage;

    public Fireball(float x, float y, Vector2 dir,int damage){
        this.x = x;
        this.y = y;
        width = 20;
        height = 20;
layer=9;

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
        if(another.name=="Player" ){
            Entity e = (Entity) another;
         //  GameScreen.curRoom.remove(this);
            this.x=-1000;
            this.y=-1000;
            e.damage(damage);
            //GameScreen.curRoom.collide.remove();
           Gdx.app.log("hui12312",""+e.health);

          //  this.kill();
            //this.dispose();
        }
    }

    @Override
    public void dispose() {
        GameScreen.remove(this);

    }
}
