package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.lancer.game.helper.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byzilio on 28.11.17.
 */

public class Room extends ArrayList<GameObject> {

    public List<GameObject>[] layers;

    public List<Pair<GameObject,GameObject>> collide = new ArrayList<Pair<GameObject, GameObject>>();
    public List<Pair<GameObject,GameObject>> overlap = new ArrayList<Pair<GameObject, GameObject>>();

    public Room(){
        //add( new TestObject());
        layers = new ArrayList[10];
        for(int i = 0;i < 10;i++){
            layers[i] = new ArrayList<GameObject>();
        }
    }

    @Override
    public boolean add(GameObject o) {
        //Gdx.app.log("Room","Add");
        layers[o.layer].add(o);
        return super.add(o);
    }

    public void add(List<GameObject> o) {
        //Gdx.app.log("Room","Add");
        for(int i = 0;i < o.size();i++){
            add(o.get(i));
        }
    }


    public void collide(GameObject g,GameObject c){
        collide.add(new Pair<GameObject, GameObject>(g,c));
    }

    public void collide(GameObject g,List<GameObject> c){
        Gdx.app.log("Room","Add");

        for(int i = 0;i < c.size();i++){
            collide.add(new Pair<GameObject, GameObject>(g,c.get(i)));
        }
    }


    public void overlap(GameObject g,GameObject c){
        overlap.add(new Pair<GameObject, GameObject>(g,c));
    }

    public void overlap(GameObject g,List<GameObject> c){
        for(int i = 0;i < c.size();i++){
            overlap.add(new Pair<GameObject, GameObject>(g,c.get(i)));
        }
    }
}
