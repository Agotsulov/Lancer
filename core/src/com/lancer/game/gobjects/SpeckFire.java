package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;

/**
 * Created by byzilio on 03.12.17.
 */

public class SpeckFire extends GameObject {

    Texture texture;

    public SpeckFire(float x,float y,float w,float h){
        super(x,y,w,h);
        texture = new Texture("speckFire.png");
        layer = 1;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {
        if(another.name == "Player"){
            Player p = ((Player)another);
            Gdx.app.log("SpeckFire","++");
            if(p.red < p.maxRed){
                p.red++;
                p.room.remove(this);
            }
        }
    }
}
