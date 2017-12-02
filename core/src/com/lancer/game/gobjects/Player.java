package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;
import com.lancer.game.Room;
import com.lancer.game.gobjects.sticks.FireWeaponStick;
import com.lancer.game.gobjects.sticks.MoveStick;

/**
 * Created by byzilio on 02.12.17.
 */

public class Player extends GameObject{

    public Stick moveStick;
    public Stick fireStick;

    public Room room;

    public int red = 10;
    public int green = 10;
    public int blue = 10;

    public int maxRed = 10;
    public int maxGreen = 10;
    public int maxBlue = 10;

    Texture texture;
    public int godtime;
    BitmapFont font = new BitmapFont();
    int health;
    public Player(Room room) {
        super();
        this.room = room;
        mass = 100;
        x = 300;
        y = 300;
        width = 50;
        height = 50;
        godtime=0;
        name = "Player";
        texture = new Texture("player.png");
        maxVelocity = 2;
        layer = 3;
        health=100;
        moveStick = new MoveStick(30,30,100,this);
        fireStick = new FireWeaponStick(400,300,40,this);
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
        if(red > maxRed) red = maxRed;
        if(green > maxGreen) green = maxGreen;
        if(blue > maxBlue) blue = maxBlue;
        if(health<=0)
        {
            isAlive=false;
            room.remove(this);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
       // Gdx.app.log("Mana","Red = " + red + " Blue = " + blue + " Blue = " + green);
        font.draw(batch,"Red = " + red,10,30,100,150,false);
    }

    @Override
    public void collide(GameObject another) {
    }
}
