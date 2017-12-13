package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.lancer.game.GameObject;
import com.lancer.game.GameScreen;
import com.lancer.game.Map;
import com.lancer.game.NextRoom;
import com.lancer.game.helper.Camera;
import com.lancer.game.helper.Pair;
import com.lancer.game.helper.TouchListener;
/**
 * Created by zope on 07.12.2017.
 */

public class Door extends GameObject {

    Texture texture;
public int dir;

    public Door(int dir){
        this.x=300;
        this.y=100;
        this.width=100;
        this.height=100;
        this.dir=dir;
        texture=new Texture("door.png");
        this.layer=3;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
       // font.draw(batch,"Red = " + red,10,30,100,150,false);
    }



    @Override
    public void collide(GameObject another) {
        Gdx.app.log("sos",""+2);
        if(another.name=="Player")
        {
            Player a=(Player) another;
            if(dir==0)
            {
                a.coord_room_y+=1;
            }
            if(dir==1)
            {
                a.coord_room_x+=1;
            }
            if(dir==2)
            {
                a.coord_room_y-=1;
            }
            if(dir==3)
            {
                a.coord_room_x-=1;
            }
            Gdx.app.log("petusha"," "+1);
            GameScreen.curRoom= Map.map[a.coord_room_x][a.coord_room_y];
            GameScreen.find("Player").x=0;
        }
    }
}
