package com.lancer.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;
import com.lancer.game.gobjects.Entity;

/**
 * Created by byzilio on 02.12.17.
 */

public class Spikes extends Entity {
    Texture texture;

    public Spikes(float x, float y, float width, float height) {
        super(x, y, width, height);
        texture = new Texture("badlogic.jpg");
        name = "Spikes";
    }


    @Override
    public void update() {
super.update();
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }


    @Override
    public void collide(GameObject another) {
        Gdx.app.log("Spikes","" + another.toString());
    }
}
