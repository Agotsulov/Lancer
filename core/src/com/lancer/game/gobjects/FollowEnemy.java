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
    public float playerx;
    public float playery;
    Player player;
    Texture texture;
    int health;
Room room;
    public FollowEnemy(float x, float y, float width, float height, Room room) {//наверное можно сделать конструктор получше но я был сонный если что поправь
        this.room = room;
        //свойства
        this.x = x;
        this.y = y;
        tag="Entity";
        this.height = height;
        this.width = width;
        mass = 50;
        layer = 3;
        maxVelocity = 1;
        this.health = 1;
        isAlive = true;
        texture = new Texture("enemy.png");
        //объект плэера
        player= (Player) room.layers[3].get(0);


    }


    @Override
    public void update() {
        super.update();
        Gdx.app.log("You are DIE",""+ health);//ахуенно ебанутый алгоритм движения ебанутого врага лучше его исправить это алгоритм на сккорую руку хуюку
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
        if(health<=0){//если хпшки кончились то умирает вражок петушок
            isAlive=false;
            room.remove(this);
        }
        else {
            if (another.name == "Player") {//если с игрочком столкнулся вражок то игрочок получает бессмертие на секунду но при этом теряте 5 хп так как враг его ебанул в лицо
                if (player.godtime % 60 == 0) {
                    player.health -= 5;
                }
                player.godtime++;
            }
            if (another.name == "Fireball") {//если враженьку ебанул файр то пизда ему он потрачено
                health -= 1;

            }

        }
    }
}
