package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.lancer.game.gobjects.Block;
import com.lancer.game.gobjects.Player;
import com.lancer.game.helper.Camera;
import com.lancer.game.helper.Pair;
import com.lancer.game.helper.TouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byzilio on 28.11.17.
 */

public  class GameScreen   implements Screen{

    //public static float scale = 1.f;

   // public int seed;

    public  static Camera camera;

    //TouchListener touchListener;


    public  static Room curRoom;
    public static ArrayList<GameObject> save;

    @Override
    public void show() {

        save=new ArrayList<GameObject>();
        camera = new Camera();
        Add(new Player(curRoom));

        curRoom = new Village();
        curRoom.init();
        for(int i=0;i<curRoom.size();i++)
        {
            curRoom.get(i).start();
        }

       // touchListener=new TouchListener(curRoom.layers[9]);
        //Gdx.input.setInputProcessor(touchListener);

    }

    @Override
    public void render(float delta) {

        update();
        draw();
    }

    public void update(){
        List<Pair<GameObject,GameObject>> encountered = new ArrayList<Pair<GameObject, GameObject>>();

        for(int i = 0; i < curRoom.size(); i++){
            if(curRoom.get(i).isAlive) curRoom.get(i).fixedUpdate();
        }

        for(int i = 0; i < curRoom.size(); i++){
            if(curRoom.get(i).isAlive) curRoom.get(i).moveX();
        }
        for(int i = 0; i < save.size(); i++){
            if(save.get(i).isAlive) save.get(i).fixedUpdate();
        }
        for(int i = 0; i < save.size(); i++){
            if(save.get(i).isAlive) save.get(i).moveX();
        }



            for(int j = 0;j < curRoom.collide.size();j++) {

                GameObject f = curRoom.collide.get(j).getFirst();
                GameObject s = curRoom.collide.get(j).getSecond();
                if(f.overlaps(s) && f.isAlive && s.isAlive){
                    encountered.add(new Pair<GameObject,GameObject>(f, s));
                    f.repelX(s);
                }
            }


        /*
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
        */

        for(int i = 0; i < curRoom.size(); i++){
            if(curRoom.get(i).isAlive) curRoom.get(i).moveY();
        }
        for(int i = 0; i < save.size(); i++){
            if(save.get(i).isAlive) save.get(i).moveY();
        }
        for(int j = 0;j < curRoom.collide.size();j++) {

            GameObject f = curRoom.collide.get(j).getFirst();
            GameObject s = curRoom.collide.get(j).getSecond();
            if(f.overlaps(s) && f.isAlive && s.isAlive){
                encountered.add(new Pair<GameObject,GameObject>(f, s));
                f.repelY(s);
            }
        }


        for(int j = 0;j < curRoom.overlap.size();j++) {

            GameObject f = curRoom.overlap.get(j).getFirst();
            GameObject s = curRoom.overlap.get(j).getSecond();
            if(f.overlaps(s) && f.isAlive && s.isAlive){
                encountered.add(new Pair<GameObject,GameObject>(f, s));

            }
        }

        /*
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
        */
        for(int i = 0; i < curRoom.size(); i++){
            if(curRoom.get(i).isAlive) curRoom.get(i).update();
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
    public static void Add(GameObject object)
    {
        save.add(object);
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
        curRoom.dispose();
        camera.dispose();
    }
    public static boolean add(GameObject o) {
        curRoom.layers[o.layer].add(o);
       return curRoom.add(o);
   }

    public static void add(List<GameObject> o) {
        for(int i = 0;i < o.size();i++){
            GameScreen.add(o.get(i));
        }
    }
    public static void remove(GameObject o){
        curRoom.layers[o.layer].remove(o);
        o.dispose();
        curRoom.remove(o);
   }
   public static GameObject find(String s){
        GameObject result;

        for(int i=0;i<curRoom.size();i++)
        {
            if(curRoom.get(i).name==s){

               return curRoom.get(i);

            }
        }
       for(int i=0;i<save.size();i++)
       {
           if(save.get(i).name==s){

               return save.get(i);

           }
       }
        return null;
   }

}
