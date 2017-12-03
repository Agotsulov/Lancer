package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;
import com.lancer.game.Room;
import com.lancer.game.gobjects.sticks.FireWeaponStick;
import com.lancer.game.gobjects.sticks.MoveStick;

import static java.lang.Math.sqrt;

/**
 * Created by zope on 03.12.2017.
 */

public class FollowEnemy extends Entity {

    Player player;
    Texture texture;

    Room room;

    public FollowEnemy(float x, float y, float width, float height, Room room) {//наверное можно сделать конструктор получше но я был сонный если что поправь
        this.room = room;
        //свойства
        this.godTime=0;
        this.x = x;
        name="Suka";
        this.y = y;
        tag="Entity";
        this.height = height;
        this.width = width;
        mass = 50;
        layer = 3;
        maxVelocity = 1;
        this.health = 5;
        isAlive = true;
        texture = new Texture("enemy.png");
        //объект плэера
        player= (Player) room.layers[3].get(0);


    }


    @Override
    public void update() {
        super.update();
        Gdx.app.log("hui",""+health);
        //Gdx.app.log("You are DIE",""+ health);//ахуенно ебанутый алгоритм движения ебанутого врага лучше его исправить это алгоритм на сккорую руку хуюку
        if (Math.sqrt((player.x - x) * (player.x - x) + (player.y - y) * (player.y - y)) <= 100) {
            a = new Vector2(player.x - x, player.y - y);
        } else {
            if (x <= 300 && y <= 300) {
                a = new Vector2(0.01f, 0.01f);
            } else {
                a = new Vector2(-0.01f, -0.01f);
            }
        }

    }


    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    @Override
    public void collide(GameObject another) {
        if(another.tag == "Entity"){
            ((Entity) another).damage(10);
        }
    }
}
