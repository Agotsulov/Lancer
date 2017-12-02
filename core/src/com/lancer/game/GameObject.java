package com.lancer.game;

/**
 * Created by byzilio on 28.11.17.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {

    public float x, y;
    public float width,height;

    public List<GameObject>  collide = new ArrayList<GameObject>();
    public List<GameObject>  overlap = new ArrayList<GameObject>();

    public Vector2 u;
    public Vector2 a;
    public float maxVelocity;

    public float mass;

    public String name;
    public String tag;
    public int layer;

    public int contact = 0;
    public final static int NO_CONTACT = 0;
    public final static int UP = 1;
    public final static int RIGHT = 2;
    public final static int DOWN = 3;
    public final static int LEFT = 4;

    public GameObject() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        name = "";
        tag = "";
        layer = 0;
        u = new Vector2(0,0);
        a = new Vector2(0,0);
        maxVelocity = 10f;
        mass = 0.4f;
    }

    public GameObject(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "";
        tag = "";
        layer = 0;
        u = new Vector2(0,0);
        a = new Vector2(0,0);
        maxVelocity = 10f;
        mass = 0.4f;
    }

    public void fixedUpdate(){

    }

    public void update(){
        if((a.len() == 0) && (u.len() != 0)){
            if((u.len() > 0) && (u.len() - mass > 0)){

                u.setLength(u.len() - mass);
            } else u.setLength(0);
        }
    }



    public void moveX(){
        u.add(a);

        if(u.len() > maxVelocity){
            u.setLength(maxVelocity);
        }
        x += u.x;
    }

    public void moveY(){
        y += u.y;
    }

    public boolean overlaps(GameObject another){

        float x1 = this.x + 1;
        float x2 = another.x;
        float y1 = this.y + 1;
        float y2 = another.y;
        float width1 = this.width - 2;
        float width2 = another.width;
        float height1 = this.height - 2;
        float height2 = another.height;

        if(x1 >=x2 && x1<=x2+width2 && y1>=y2 && y1<=y2+height2){
            return true;
        }
        if(x1+width1>=x2 && x1+width1<=x2+width2 && y1>=y2 && y1<=y2+height2){
            return true;
        }

        if(x1>=x2 && x1<=x2 + width2 && y1 + height1 >= y2 && y1 +height1 <= y2 + height2){
            return true;
        }
        if(x1 + width1>=x2 && x1+width1<=x2+width2 && y1 + height1>=y2 && y1 + height1 <= y2+height2){
            return true;
        }

        if(x1>=x2 && x1<=x2+width2 && y2>=y1 && y2<=y1+height1){
            return true;
        }
        return false;
    }

    public void repelX(GameObject another){
            if (u.x > 0) {
                x = another.x - width;
                contact = LEFT;
            }
            if (u.x < 0) {
                x = another.x + another.width;
                contact = RIGHT;
            }
    }
    public void repelY(GameObject another) {
            if (u.y > 0) {
                y = another.y - height;
                contact = DOWN;
            }
            if (u.y < 0) {
                y = another.y + another.height;
                contact = UP;
            }
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

    public void setSpeed(float velocity) {
        u.setLength(velocity);
    }

    public float getSpeed() {
        return u.len();
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

    @Override
    public String toString() {
        return "GameObject{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }

    public void addForce(Vector2 force){
        u.add(force);
    }

    public void dispose(){

    }
}
