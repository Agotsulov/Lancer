package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.lancer.game.GameObjects.Block;
import com.lancer.game.gobjects.Blue;
import com.lancer.game.gobjects.Deep;
import com.lancer.game.gobjects.Fireblock;
import com.lancer.game.gobjects.FollowEnemy;
import com.lancer.game.gobjects.Health;
import com.lancer.game.gobjects.Player;
import com.lancer.game.GameObjects.Spikes;
import com.lancer.game.gobjects.SpeckFire;

import java.util.ArrayList;
import java.util.List;

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
        Player p = new Player(this);
        add(p);
        List<GameObject> b = new ArrayList<GameObject>();

        //add(new Block(350,130,100,100));

        for(int i = 0;i < 3;i++){
            b.add(new Block(i*100, Gdx.graphics.getHeight() - 50,100,100));
        }

        collide(p,b);
        FollowEnemy one=new FollowEnemy(200,130,40,40,this);
        Deep s= new Deep(350,130,100,100);
        Fireblock s1= new Fireblock(460,130,100,100);
        Blue s2= new Blue(570,130,100,100);
        Health health=new Health(p);
        add(b);
        add(health);

        overlap(p,s);
        add(s);
        overlap(p,s1);
        add(s1);
        overlap(p,s2);
        add(s2);
        overlap(p,one);
        add(one);
        List<GameObject> fs = new ArrayList<GameObject>();
        for(int i = 0;i < 5;i++){
            GameObject f = new SpeckFire(300 + i*40,170,30,30);
            fs.add(f);
        }
        add(fs);

        overlap(p,fs);

        /*
        List<GameObject> fs = new ArrayList<GameObject>();
        for(int i = 0;i < 5;i++){
            GameObject f = new SpeckFire(300 + i*40,170,30,30);
            fs.add(f);
            overlap(f,p);
        }
        add(fs);


        for(int i = 0;i < 100;i++){
            add(new Block(i*100,-50,100,100));
        }

        for(int i = 0;i < 100;i++){
            add(new Block(-50,i*100,100,100));
        }

        for(int i = 0;i < 100;i++){
            add(new Block(Gdx.graphics.getWidth() - 50,i*100,100,100));
        }
        */
    }

}
