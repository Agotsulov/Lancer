package com.lancer.game.helper;

/**
 * Created by zope on 13.12.2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;
import com.lancer.game.GameScreen;
import com.lancer.game.gobjects.Buttons.Button;
import com.lancer.game.gobjects.Players.Player;


import java.util.List;

/**
 * Created by zope on 01.12.2017.
 */

public class ButtonListener implements InputProcessor {

    public List<GameObject> inputs;
    Vector2 vector;
    int firstX;
    int firstY;
    Player player;
public ButtonListener()
{
    inputs=GameScreen.curRoom.layers[9];
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

        firstX=screenX;
        firstY= Gdx.graphics.getHeight()-screenY;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {



       for(int i=0;i<inputs.size();i++) {

           if (inputs.get(i) != null && screenX >= inputs.get(i).x && screenX <= inputs.get(i).x + inputs.get(i).width && Gdx.graphics.getHeight() - screenY >= inputs.get(i).y && Gdx.graphics.getHeight() - screenY <= inputs.get(i).y + inputs.get(i).height && inputs.get(i).name=="button") {
               Button d= (Button) inputs.get(i);
               d.action();
           }
       }
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
