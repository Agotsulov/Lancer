package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.lancer.game.helper.OtherFunctions;
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

public String name;
    public Room(){
        layers = new ArrayList[COUNT_LAYERS];
        for(int i = 0;i < COUNT_LAYERS;i++){
            layers[i] = new ArrayList<GameObject>();
        }
    }

   // @Override
   // public boolean add(GameObject o) {
     //   layers[o.layer].add(o);
     //   return super.add(o);
   // }

    public void add(List<GameObject> o) {
        for(int i = 0;i < o.size();i++){
                add(o.get(i));
        }
    }


    public void collide(GameObject g,GameObject c){
        collide.add(new Pair<GameObject,GameObject>(g,c));
    }

    public void collide(GameObject g,List<GameObject> c){
        for(int i = 0;i < c.size();i++){
            collide(g,c.get(i));
        }
    }


    public void overlap(GameObject g,GameObject c){
        overlap.add(new Pair<GameObject,GameObject>(g,c));
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

    public void remove(GameObject o){
        o=null;
     //  layers[o.layer].remove(o);
       // o.dispose();
       // super.remove(o);
   }

   @Override
   public  boolean add(GameObject o) {
       layers[o.layer].add(o);
       return super.add(o);
   }

    public void add(int array[][],List<GameObject> gameobjects){
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
            add(gameobjects.get(array[i][j]));
            }
        }
    }
    public void init() {

    }
    public void Resize(){

        for(int i=0;i<this.size();i++)
        {
            if(this.get(i).layer!=0)
            this.get(i).Resize();
        }
    }
}
