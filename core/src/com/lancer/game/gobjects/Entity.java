package com.lancer.game.gobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;

import java.util.ArrayList;

/**
 * Created by byzilio on 02.12.17.
 */

public class Entity extends GameObject{
public int start=0;
    public int health;
    public int godTime = 60;
    public int curTime = 60;
    public int damage=0;
    Texture texture;
    public Entity(){
        health = 100;
        tag = "Entity";
    }
    public Entity(float x,float y,float width,float height,String filename){
        super(x,y,width,height);
        health = 100;
        damage=10;
        layer=2;
        tag = "Entity";
texture=new Texture(filename);
    }

    public void update(){
        super.update();

        curTime++;
        if(curTime > godTime) curTime = godTime;

        if(health <= 0) this.kill();
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void collide(GameObject another) {

    }

    public void damage(int damage){
       // Gdx.app.log("CurTime",""+curTime);
       // Gdx.app.log("godTIme",""+godTime);
       // if(curTime >= godTime) {
            health -= damage;

            //curTime = 0;
       // }
    }
    public void damage(int damage, Vector2 direction)
    {
this.addForce(direction);
    }

}
