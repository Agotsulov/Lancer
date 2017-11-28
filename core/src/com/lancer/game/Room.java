package com.lancer.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by byzilio on 28.11.17.
 */

public class Room<E> extends ArrayList<E> {

    public Room(){
        add((E) new TestObject());

    }

    @Override
    public boolean add(E o) {
        Gdx.app.log("Room","Add");
        return super.add(o);
    }
}
