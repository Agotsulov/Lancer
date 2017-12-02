package com.lancer.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;
import com.lancer.game.Room;

/**
 * Created by byzilio on 02.12.17.
 */

public class Player extends GameObject {

    public Stick moveStick;
    Texture texture;

    public Player(Room room) {
        super();
        //Room.collide(this,room);
        moveStick = new Stick(30,30,100);
        room.add(moveStick);
        mass = 100;
        x = 300;
        y = 300;
        width = 50;
        height = 50;
        name = "Player";
        texture = new Texture("player.png");maxVelocity = 2;
        layer = 3;
    }

    @Override
    public void update() {
        //Gdx.app.log("Player","moveStick = " + moveStick.dir);
        /*
        Gdx.app.log("Player","moveStick.len = " + moveStick.dir.len());
        Gdx.app.log("Player","u = " + u);
        Gdx.app.log("Player","a = " + a);
        */
        //Gdx.app.log("Player","" + toString());

        super.update();
        a = moveStick.dir;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {

    }
}
