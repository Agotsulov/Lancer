package com.lancer.game.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;
import com.lancer.game.gobjects.Player;
import com.lancer.game.gobjects.Stick;

import java.util.List;

/**
 * Created by zope on 01.12.2017.
 */

public class TouchListener implements InputProcessor{

    public List<GameObject> inputs;
    Vector2 vector;
    int firstX;
    int firstY;
    Player player;
    public TouchListener(Player player){
        this.player=player;

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

      int firstx=screenX;
      int firsty=Gdx.graphics.getHeight()-screenY;
      return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

     vector=new Vector2(screenX-firstX,Gdx.graphics.getHeight()-screenY-firstY);
     vector.setLength(vector.len()/30);
     player.addForce(vector);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
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
