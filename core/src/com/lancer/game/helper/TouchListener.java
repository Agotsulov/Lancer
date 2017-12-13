package com.lancer.game.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObject;
import com.lancer.game.GameScreen;
import com.lancer.game.gobjects.Block;
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
    public TouchListener(){


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
        firstY=Gdx.graphics.getHeight()-screenY;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Point point=new Point(screenX,screenY);
        Block block=new Block(screenX,Gdx.graphics.getHeight()-screenY,1,1,"wall.png");
        Gdx.app.log("pustrun",""+(float)block.x+" "+(float)block.y);
        Gdx.app.log("pustrun1",""+GameScreen.find("button_health").x+" "+GameScreen.find("button_health").y);
        Gdx.app.log("pustrun1",""+GameScreen.find("button_health").width+" "+GameScreen.find("button_health").height);
         Gdx.app.log("pustrun2",""+ block.overlaps(GameScreen.find("button_health")));
if(GameScreen.find("button_health") !=null && block.overlaps(GameScreen.find("button_health"))){
Gdx.app.log("pustrun",""+2);
}
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
