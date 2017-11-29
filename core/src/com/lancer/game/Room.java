package com.lancer.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by byzilio on 28.11.17.
 */

public class Room extends ArrayList<GameObject> {

    public Room(){
        add( new TestObject());

    }

    @Override
    public boolean add(GameObject o) {
        Gdx.app.log("Room","Add");
        return super.add(o);
    }
}
