package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;

/**
 * Created by zope on 03.12.2017.
 */

    public class Health extends GameObject{
    Texture texture;
    int health;
    Player player;
    Texture polos;

    public Health(Player player){

        super();
        this.health=100;
        layer=2;
        this.player=player;
        texture=new Texture("health1.png");

        polos=new Texture("healthpolos.png");

    }
    @Override
    public void draw(SpriteBatch batch) {
        Gdx.app.log("hp",""+player.width*player.health/100);
        isAlive=player.isAlive;

        batch.draw(texture,player.x,player.y+player.height+10,player.width,20);
        batch.draw(polos,player.x,player.y+player.height+10,player.width*player.health/100,20);
    }

public void update(){
        if(isAlive==false)
        {
           // this.
        }
}


    @Override
    public void collide(GameObject another) {

    }
}
