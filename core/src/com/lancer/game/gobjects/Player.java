package com.lancer.game.gobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;
import com.lancer.game.Room;
import com.lancer.game.gobjects.sticks.FireWeaponStick;
import com.lancer.game.gobjects.sticks.MoveStick;

/**
 * Created by byzilio on 02.12.17.
 */

public class Player extends Entity {

    public Stick moveStick;
    public Stick fireStick;

    public Room room;

    Texture texture;

    public Player(Room room) {
        super();
        this.room = room;
        mass = 100;
        x = 300;
        y = 300;
        width = 50;
        height = 50;
        name = "Player";
        texture = new Texture("player.png");
        maxVelocity = 2;
        layer = 3;
        health = 100;
        moveStick = new MoveStick(30,30,100,this);
        fireStick = new FireWeaponStick(40,this);
        room.add(moveStick);
        room.add(fireStick);
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
