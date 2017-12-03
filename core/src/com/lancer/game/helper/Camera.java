package com.lancer.game.helper;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.GameObject;
import com.lancer.game.Room;

/**
 * Created by byzilio on 02.12.17.
 */

public class Camera extends SpriteBatch {

    public float x,y;
    public float scale = 1f;

    public Camera(){
        x = 0;
        y = 0;
    }

    public Camera(float x,float y){
        this.x = x;
        this.y = y;
    }

    public void draw(Texture texture, float x, float y, float width, float height){
        super.draw(texture, ((x - this.x) * scale), (int) ((y - this.y) * scale),width * scale,height * scale);
    }

    public void render(Room room){
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < room.layers[j].size(); i++) {
                if(room.layers[j].get(i).isVisible) room.layers[j].get(i).draw(this);
            }
        }
    }
}
