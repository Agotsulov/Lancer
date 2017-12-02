package com.lancer.game.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;
import com.lancer.game.Stick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zope on 01.12.2017.
 */

public class TouchListener implements InputProcessor{

    public int x,y,x1,y1;

    public List<GameObject> sticks;
    public TouchListener(List<GameObject> sticks){
        this.sticks=sticks;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        for(int i=0;i<this.sticks.size();i++)
        {
            if(sticks.get(i).name=="Stick")
            {
                Stick s= (Stick) sticks.get(i);
                if(((screenX-s.cx)*(screenX-s.cx)+(screenY-s.y)*(screenY-s.y))>=s.r){
                    s.pointer=pointer;
                }
            }
        }
        x=screenX;
        y=Gdx.graphics.getHeight()-screenY;
        Gdx.app.log("TestObject",x+" "+y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        x1=screenX;
        y1=Gdx.graphics.getHeight()-screenY;
        Vector2 v1=new Vector2(x,y);
        Vector2 v2=new Vector2(x1,y1);
        Vector2 v3=new Vector2((x1-x),(y1-y));
        Gdx.app.log("TestObject1",x1+" "+y1);

        float r= (float) Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-1));
        for(int i=0;i<this.sticks.size();i++)
        {
            if(sticks.get(i).name=="Stick")
            {
                Stick s= (Stick) sticks.get(i);
                if(s.pointer==pointer)
                {
                    s.pointer=-1;
                    s.dir=new Vector2(0,0);
                }
            }
        }
        Gdx.app.log("Down",""+v3);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        for(int i=0;i<this.sticks.size();i++)
        {
            if(sticks.get(i).name=="Stick")
            {
                Stick s= (Stick) sticks.get(i);
                if(s.pointer==pointer)
                {
                    s.dir=new Vector2(screenX-s.cx,Gdx.graphics.getHeight()-screenY-s.cy);
                }
            }
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
