package com.lancer.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by byzilio on 28.11.17.
 */

class TestRoom extends Room {
    public TestRoom() {
        //add(new TestObject(100,100,100,100));
        //add(new TestObject2(110,110,10,10));

        //add(new TestObject(300,300,100,100,"A1"));
        //add(new TestObject2(310,290,100,100,"B1"));

        //add(new TestObject(300,300,100,100,"A2"));
        //add(new TestObject2(290,310,100,100,"B2"));

        //add(new TestObject(300,300,100,100,"A3"));
        //add(new TestObject2(290,290,100,100,"B3"));
        TestObject t=new TestObject(0,0,50,50,"B4");
        add(new TestObject(300,200,100,100,"A4"));
        add(t);
        t.dir=new Vector2(0.5f,0.5f);
    }

}
