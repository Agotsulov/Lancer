package com.lancer.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by zope on 02.12.2017.
 */

public class Stick extends GameObject {
    public float r;
    public Vector2 dir;
    public float cx=0.f;
    public float cy=0.f;
    public int pointer=-1;
    public Stick(float x,float y,float r) {
        cx=x+r;
        cy=y+r;
        this.name="Stick";
        this.layer=9;
        this.isSolid = false;
        this.x=x;
        this.y=y;
        this.r=r;
        this.dir=new Vector2(0,0);
    }
    @Override
    public void update() {

    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void collide(GameObject another) {

    }
}
