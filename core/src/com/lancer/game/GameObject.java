package com.lancer.game;

/**
 * Created by byzilio on 28.11.17.
 */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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
    public int contact=0;
    public final int UP=1;
    public final int RIGHT=2;
    public final int DOWN=3;
    public final int LEFT=4;
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

    public boolean overlaps(GameObject another){
        //Сталкновение обектов вернуть true
        float x1=this.x+1;
        float x2=another.x+1;
        float y1=this.y+1;
        float y2=another.y+1;
        float width1=this.width-2;
        float width2=another.width;
        float height1=this.height-2;
        float height2=another.height;
        if(x1 >=x2 && x1<=x2+width2 && y1>=y2 && y1<=y2+height2){
            Gdx.app.log("collision:x1"," " + this.name + " " +another.name);
            return true;
        }
        if(x1+width1>=x2 && x1+width1<=x2+width2 && y1>=y2 && y1<=y2+height2){
            Gdx.app.log("collision:x2"," " + this.name + " " +another.name);
            return true;
        }

        if(x1>=x2 && x1<=x2 + width2 && y1 + height1 >= y2 && y1 +height1 <= y2 + height2){
            Gdx.app.log("collision:y1"," " + this.name + " " +another.name);
            return true;
        }
        //if((x1+1+w1-2>=x2) && (x1+1+w1-2<=x2+w2) && (y1+1+h1-2>=y2) && (y1+1+h1-2<=y2+h2)) {

        if(x1 + width1>=x2 && x1+width1<=x2+width2 && y1 + height1>=y2 && y1 + height1 <= y2+height2){
            Gdx.app.log("collision:y2"," " + this.name + " " +another.name);
            return true;
        }

        //if((x1+1>=x2) && (x1+1<=x2+w2) && (y2>=y1+1) && (y2<=y1+1+h1-2)) {
        if(x1>=x2 && x1<=x2+width2 && y2>=y1 && y2<=y1+height1){
            Gdx.app.log("collision:z"," " + this.name + " " +another.name);
            return true;
        }

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

    public void repelx(GameObject another){
        if (isSolid == true && another.isSolid==true) {
            if (dir.x > 0) {
                x = another.x - width;
                contact = LEFT;
            }
            if (dir.x < 0) {
                x = another.x + another.width;
                contact = RIGHT;
            }
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
    }
    public void repely(GameObject another) {
        if (isSolid == true && another.isSolid==true) {
            if (dir.y > 0) {
                contact = DOWN;
                y = another.y - height;
            }
            if (dir.y < 0) {
                y = another.y + another.height;
                contact = UP;
            }
        }
    }
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
