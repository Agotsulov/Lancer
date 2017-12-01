package com.lancer.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byzilio on 28.11.17.
 */

public class Room extends ArrayList<GameObject> {

    List<GameObject> layers[];

    public Room(){
        //add( new TestObject());
        layers = new ArrayList[10];
        for(int i = 0;i < 10;i++){
            layers[i] = new ArrayList<GameObject>();
        }
    }

    @Override
    public boolean add(GameObject o) {
        Gdx.app.log("Room","Add");
        layers[o.layer].add(o);
        return super.add(o);
    }
}
