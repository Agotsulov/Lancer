package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;

/**
 * Created by zope on 03.12.2017.
 */
public class Fireblock extends GameObject {
    Texture texture;

    public Fireblock(float x,float y,float w,float h){
        super(x,y,w,h);
        texture = new Texture("fireblock.png");
        layer = 1;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {
        if(another.tag == "Entity"){
            Entity p = ((Entity) another);
            Gdx.app.log("","" + p.toString());
            p.damage(10);

           // p.room.remove(p);
        }
    }
}
