package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.lancer.game.helper.Camera;
import com.lancer.game.helper.Pair;
import com.lancer.game.helper.TouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byzilio on 28.11.17.
 */

public class GameScreen  implements Screen{

    public static float scale = 1.f;

    public int seed;

    Camera camera;

    TouchListener touchListener;


    public Room curRoom;
    public Room map[][];

    @Override
    public void show() {

        camera = new Camera();
        curRoom = new TestRoom();
        touchListener=new TouchListener(curRoom.layers[9]);
        Gdx.input.setInputProcessor(touchListener);
    }

    @Override
    public void render(float delta) {
        update();
        draw();
    }

    public void update(){


        List<Pair<GameObject,GameObject>> encountered = new ArrayList<Pair<GameObject, GameObject>>();

        for(int i = 0; i < curRoom.size(); i++){
            curRoom.get(i).fixedUpdate();
        }



        for(int i = 0; i < curRoom.size(); i++){
            curRoom.get(i).moveX();
        }
        for(int i = 0; i < curRoom.size(); i++){
            GameObject current = curRoom.get(i);
            for(int j = 0; j < curRoom.size(); j++){
                if(i != j){
                    if(current.overlaps(curRoom.get(j))){
                        Gdx.app.log("GameScreen","Y");
                        encountered.add(new Pair<GameObject,GameObject>(current, curRoom.get(j)));
                        current.repelX(curRoom.get(j));
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
                    if (current.overlaps(curRoom.get(j))) {
                        Gdx.app.log("GameScreen","Y");
                        encountered.add(new Pair<GameObject, GameObject>(current, curRoom.get(j)));
                        current.repelY(curRoom.get(j));
                    }
                }
            }
        }

        for(int i = 0; i < curRoom.size(); i++){
            curRoom.get(i).update();
        }

        for(int i = 0; i < encountered.size(); i++){
            encountered.get(i).getFirst().collide(encountered.get(i).getSecond());
            encountered.get(i).getSecond().collide(encountered.get(i).getFirst());
        }


    }



    public void draw() {
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.begin();
        camera.render(curRoom);
        /*
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < curRoom.layers[j].size(); i++) {
                curRoom.layers[j].get(i).draw(camera);
            }
        }
        for (int i = 0; i < curRoom.size(); i++) {
            curRoom.get(i).draw(camera);
        }
        */
        camera.end();
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
        camera.dispose();
    }


}
