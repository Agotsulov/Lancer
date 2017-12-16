package com.lancer.game.gobjects.Players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;
import com.lancer.game.GameScreen;
import com.lancer.game.Room;
import com.lancer.game.gobjects.Entity;
import com.lancer.game.gobjects.Health;
import com.lancer.game.gobjects.sticks.FireWeaponStick;
import com.lancer.game.gobjects.sticks.MoveStick;
import com.lancer.game.helper.TouchListener;

/**
 * Created by byzilio on 02.12.17.
 */

public class Player extends Entity {

    //public Stick moveStick;
    // public Stick fireStick;

    public Room room;

    public int red = 10;
    public int green = 10;
    public int blue = 10;

    public int maxRed = 10;
    public int maxGreen = 10;
    public int maxBlue = 10;
    public int coord_room_x = 4;
    public int coord_room_y = 4;
    Health t;
    Texture texture;

    BitmapFont font = new BitmapFont();


    public Player(float x, float y, float w, float h, String filename) {
        super();
        tag = "Entity";
        this.room = room;
        mass = 1f;

        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        name = "Player";
        texture = new Texture(filename);
        maxVelocity = 17;
        layer = 3;
        health = 100;

        Gdx.input.setInputProcessor(new TouchListener());

        //Gdx.input.setInputProcessor(new TouchListener());
        //moveStick = new MoveStick(30,30,100,this);
        //fireStick = new FireWeaponStick(400,300,40,this);
        //  room.add(moveStick);
        //room.add(fireStick);
        t = new Health(this);
        GameScreen.Add(this);
    }

    @Override
    public void update() {
        super.update();

        // a = moveStick.dir;
        if (red > maxRed) red = maxRed;
        if (green > maxGreen) green = maxGreen;
        if (blue > maxBlue) blue = maxBlue;
        if (health <= 0) {
            kill();
            health = 0;
            room.remove(this);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
        font.draw(batch, "Red = " + red, 10, 30, 100, 150, false);
    }

    @Override
    public void collide(GameObject another) {
        if (another.name == "Fireball") {

            //  GameScreen.curRoom.remove(this);
            another.x = -1000;
            another.y = -1000;

            //GameScreen.curRoom.collide.remove();

        }

    }
}
