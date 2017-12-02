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
    public final static int COUNT_LAYERS = 10;

    public List<Pair<GameObject,GameObject>> collide = new ArrayList<Pair<GameObject, GameObject>>();
    public List<Pair<GameObject,GameObject>> overlap = new ArrayList<Pair<GameObject, GameObject>>();


    public Room(){
        layers = new ArrayList[COUNT_LAYERS];
        for(int i = 0;i < COUNT_LAYERS;i++){
            layers[i] = new ArrayList<GameObject>();
        }
    }

    @Override
    public boolean add(GameObject o) {
        layers[o.layer].add(o);
        return super.add(o);
    }

    public void add(List<GameObject> o) {
        for(int i = 0;i < o.size();i++){
            add(o.get(i));
        }
    }


    public void collide(GameObject g,GameObject c){
        g.collide.add(c);
    }

    public void collide(GameObject g,List<GameObject> c){
        for(int i = 0;i < c.size();i++){
            collide(g,c.get(i));
        }
    }


    public void overlap(GameObject g,GameObject c){
        g.overlap.add(c);
    }

    public void overlap(GameObject g,List<GameObject> c){
        for(int i = 0;i < c.size();i++){
            overlap(g,c.get(i));
        }
    }

    public List<GameObject> get(String tag){
        List<GameObject> result = new ArrayList<GameObject>();
        for(int i = 0;i < size();i++){
            if(get(i).tag == tag) result.add(get(i));
        }
        return result;
    }


    public void dispose(){
        for(int i = 0;i < size();i++){
            get(i).dispose();
        }
    }
}
