package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lancer.game.helper.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byzilio on 28.11.17.
 */

public class GameScreen implements Screen {

    public static float scale = 1.f;

    public int seed;

    SpriteBatch batch;

    public Room curRoom;
    public Room map[][];


    @Override
    public void show() {

        batch = new SpriteBatch();
        curRoom = new TestRoom();
        //curRoom.add(new TestObject());
        Gdx.app.log("Screen","Show");
    }

    @Override
    public void render(float delta) {
        Gdx.app.log("Screen","Render");
        update();
        draw();
    }
    public void test()
    {

    }
    public void update(){
        List<Pair<GameObject,GameObject>> encountered = new ArrayList<Pair<GameObject, GameObject>>();

        for(int i = 0; i < curRoom.size(); i++){
            curRoom.get(i).update();
        }

        for(int i = 0; i < curRoom.size(); i++){
            curRoom.get(i).moveX();
        }
        for(int i = 0; i < curRoom.size(); i++){
            GameObject current = curRoom.get(i);
            for(int j = 0; j < curRoom.size(); j++){
                if(i != j){
                    Gdx.app.log("CollAfterX","" + i + " " + j);
                    if(current.overlaps(curRoom.get(j))){
                        encountered.add(new Pair<GameObject,GameObject>(current, curRoom.get(j)));
                        current.repelx(curRoom.get(j));
                    }
                }
            }
        }


        for(int i = 0; i < curRoom.size(); i++){
            curRoom.get(i).moveY();
        }
        for(int i = 0; i < curRoom.size(); i++){
            GameObject current = curRoom.get(i);
            for(int j = 0; j < curRoom.size(); j++){
                if(i != j) {
                    Gdx.app.log("CollAfterY", "" + i + " " + j);
                    if (current.overlaps(curRoom.get(j))) {
                        encountered.add(new Pair<GameObject, GameObject>(current, curRoom.get(j)));
                        current.repely(curRoom.get(j));
                    }
                }
            }
        }


        for(int i = 0; i < encountered.size(); i++){
            encountered.get(i).getFirst().collide(encountered.get(i).getSecond());
            encountered.get(i).getSecond().collide(encountered.get(i).getFirst());
        }


    }



    public void draw() {
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        for (int i = 0; i < curRoom.size(); i++) {
            curRoom.get(i).draw(batch);
        }
        batch.end();
    }
    public Room[][] generate(int seed){
        return null;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}
