package com.lancer.game.gobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;

/**
 * Created by zope on 02.12.2017.
 */

public class Stick extends GameObject {

    public float r;
    public Vector2 dir;

    public float cX = 0.f;
    public float cY = 0.f;

    public int pointer=-1;

    Texture texture;

    public Player player;

    public Stick(float x,float y,float r) {
        cX = x + r;
        cY = y + r;
        this.name = "Stick";
        this.layer = 9;
        this.x = x;
        this.y = y;
        this.r = r;
        this.dir = new Vector2(0,0);
        this.width = 2*r;
        this.height = 2*r;
        texture = new Texture("stick.png");
        player = null;
    }

    public Stick(float x,float y,float r,Player p) {
        cX = x + r;
        cY = y + r;
        this.name = "Stick";
        this.layer = 9;
        this.x = x;
        this.y = y;
        this.r = r;
        this.dir = new Vector2(0,0);
        this.width = 2*r;
        this.height = 2*r;
        texture = new Texture("stick.png");
        player = p;
    }



    @Override
    public void update() {

    }

    public void end(){
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {

    }

    @Override
    public void dispose() {

    }
}
