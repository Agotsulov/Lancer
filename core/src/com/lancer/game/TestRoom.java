package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameObjects.Block;
import com.lancer.game.GameObjects.Player;

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
        /*
        TestObject t=new TestObject(200,0,50,50,"B4");
        add(new TestObject(200,300,100,100,"A4"));
        add(t);
        Vector2 v1=new Vector2(0,10);

        t.addForce(v1);
        */
        add(new Player(this));

        for(int i = 0;i < 100;i++){
            add(new Block(i*100, Gdx.graphics.getHeight() - 50,100,100));
        }

        for(int i = 0;i < 100;i++){
            add(new Block(i*100,-50,100,100));
        }

        for(int i = 0;i < 100;i++){
            add(new Block(-50,i*100,100,100));
        }

        for(int i = 0;i < 100;i++){
            add(new Block(Gdx.graphics.getWidth() - 50,i*100,100,100));
        }
    }

}
