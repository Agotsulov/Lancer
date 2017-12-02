package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;

/**
 * Created by zope on 03.12.2017.
 */

public class Blue extends GameObject{

        Texture texture;

        public Blue(float x, float y, float w, float h){
            super(x,y,w,h);
            texture = new Texture("green.png");
            layer = 1;
        }

        @Override
        public void draw(SpriteBatch batch) {
            batch.draw(texture,x,y,width,height);
        }

        @Override
        public void collide(GameObject another) {
            if(another.name == "Player"){

            }
        }
    }


