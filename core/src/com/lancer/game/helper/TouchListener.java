package com.lancer.game.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;
import com.lancer.game.gobjects.Stick;

import java.util.List;

/**
 * Created by zope on 01.12.2017.
 */

public class TouchListener implements InputProcessor{

    public List<GameObject> inputs;

    public TouchListener(List<GameObject> sticks){
        this.inputs =sticks;
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

        for(int i = 0; i<this.inputs.size(); i++)
        {
            if(inputs.get(i).name == "Stick")
            {
                Stick s = (Stick) inputs.get(i);
                if( Math.sqrt((screenX-s.cX)*(screenX-s.cX)+(Gdx.graphics.getHeight()-screenY-s.cY)*(Gdx.graphics.getHeight()-screenY-s.cY))<=s.r){
                    s.pointer = pointer;
                }
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        for(int i = 0; i<this.inputs.size(); i++)
        {
            if(inputs.get(i).name=="Stick")
            {
                Stick s= (Stick) inputs.get(i);
                if(s.pointer==pointer)
                {
                    s.end();
                    s.pointer=-1;
                    s.dir=new Vector2(0,0);
                }
            }
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        for(int i = 0; i<this.inputs.size(); i++)
        {
            if(inputs.get(i).name=="Stick")
            {
                Stick s= (Stick) inputs.get(i);
                if(s.pointer==pointer)
                {
                    s.dir=new Vector2(screenX-s.cX,Gdx.graphics.getHeight()-screenY-s.cY);
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
