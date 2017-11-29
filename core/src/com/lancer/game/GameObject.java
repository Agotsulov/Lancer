package com.lancer.game;

/**
 * Created by byzilio on 28.11.17.
 */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

public abstract class GameObject {

    public float x, y;
    public float width,height;

    public Vector2 dir;
    public float speed = 1.f;
    public boolean isSolid = false;

    public String name;
    public String tag;
    public int layer;

    public GameObject(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "";
        tag = "";
        layer = 0;
        dir = new Vector2(0,0);
        speed = 1.f;
        isSolid = true;
    }

    public abstract void update();


    //просто двигаем по вектору
    public void moveX(){
        x += dir.x * speed;
    }

    public void moveY(){
        y += dir.y * speed;
    }


    public void repel(GameObject another){
        //Оталкивает этот обьект от другого если нужно
        /*
        Типо
        ux скорость
        для y аналгично
        contact это int для знания где столкнулись чтобы прыграть например
                    if(ux > 0.0f) {
                        x = checkable.x - width;
                        contact = LEFT;
                    }
                    if(ux < 0.0f) {
                        x = checkable.x + checkable.width;
                        contact = RIGHT;
                    }
                } else {
                    if(ux > 0.0f) {
                        contact = LEFT;
                    }
                    if(ux < 0.0f) {
                        contact = RIGHT;
                    }
                }
         */
    }

    public boolean overlaps(GameObject another){
        //Сталкновение обектов вернуть true

        /*
        Типо такого
        if((x1+1>=x2) && (x1+1<=x2+w2) && (y1+1>=y2) && (y1+1<=y2+h2)) {
            return true;
        }
        if((x1+1+w1-2>=x2) && (x1+1+w1-2<=x2+w2) && (y1+1>=y2) && (y1+1<=y2+h2)) {
            return true;
        }
        if((x1+1>=x2) && (x1+1<=x2+w2) && (y1+1+h1-2>=y2) && (y1+1+h1-2<=y2+h2)) {
            return true;
        }
        if((x1+1+w1-2>=x2) && (x1+1+w1-2<=x2+w2) && (y1+1+h1-2>=y2) && (y1+1+h1-2<=y2+h2)) {
            return true;
        }

        if((x1+1>=x2) && (x1+1<=x2+w2) && (y2>=y1+1) && (y2<=y1+1+h1-2)) {
            return true;
        }
         */
        return false;
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

}
