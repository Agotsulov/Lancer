package com.lancer.game.gobjects.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;
import com.lancer.game.GameScreen;
import com.lancer.game.helper.ButtonListener;
import com.lancer.game.helper.TouchListener;

/**
 * Created by zope on 13.12.2017.
 */

public  class Button extends GameObject{
    Texture texture;

    public Button(float x, float y, float w, float h, String filename){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.name="button";
        texture = new Texture(filename);
        Gdx.input.setInputProcessor(new ButtonListener());
        this.layer=9;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {

    }
    public void action(){};

}
