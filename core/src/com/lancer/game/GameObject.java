package com.lancer.game;

/**
 * Created by byzilio on 28.11.17.
 */

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

public abstract class GameObject {

    public float x, y;
    public float width,height;

    public float speed;

    public String name;
    public String tag;
    public int layer;

    public List<GameObject> collidable;

    public void update(){
        moveX();
        //Проверяем на столкновения
        //Получаем список столкнувшихся
        //Отталкиваем если нужно

        moveY();
        //Проверяем на столкновения
        //Получаем список столкнувшихся
        //Отталкиваем если нужно


        //collidable это все с чем столкнулся обьект
    }

    public void moveX(){

    }


    public void moveY(){

    }

    public List<GameObject> collision(){
        return null;
    }

    public abstract void draw(SpriteBatch batch);

    public abstract void collide(GameObject another);

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public int getLayer() {
        return layer;
    }

    public List<GameObject> getCollidable() {
        return collidable;
    }

}
