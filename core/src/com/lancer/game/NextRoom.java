package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.lancer.game.gobjects.Block;
import com.lancer.game.gobjects.Door;
import com.lancer.game.gobjects.FollowEnemy;
import com.lancer.game.gobjects.Player;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by byzilio on 28.11.17.
 */

public class NextRoom extends Room {
    public NextRoom() {

    }
    @Override
    public void init () {
        Player p = new Player(this);

       // Door rightdoor=new Door(Gdx.graphics.getWidth()/2+100,(Gdx.graphics.getHeight()-720)/2,40,40,null);
        //Door cur=new Door(Gdx.graphics.getWidth()/2,(Gdx.graphics.getHeight()-720)/2,40,40,rightdoor);
        add(p);
        int array[][] = new int[9][9];
        //  FileHandle handle = Gdx.files.external("myfile.txt");
      /*  FileHandle handle=Gdx.files.internal("B:/loid/test2/Lancer/android/assets/file.txt");


               String [] m =(handle.readString().split("\n"));

            for(int j=0;j<m.length;j++){
                String [] m1=(m[j].split(" "));
                Gdx.app.log("ssss",""+m1[0]);
                for(int k=0;k<m1.length;k++){
                    array[j][k]=Integer.parseInt(m1[k]);

                }
            }
*/


        //array=
        List<GameObject> b = new ArrayList<GameObject>();
        b.add(new FollowEnemy(0, 0, 30, 30));
      //  b.add(rightdoor);
       // b.add(cur);
        //  b.add(new Fireblock(0,0,80,80));
        add(array, b);
        // Gdx.app.log("size", "" + ((float) (Gdx.graphics.getWidth()) / 720) * (float) (80));

        float sizex = 80;
        float sizey =  80;
        Gdx.app.log("sos",""+sizex);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Block t=new Block(sizex + j * sizex, sizey + (float) (i * sizey), sizex, sizey, "floor.png");
                b.add(t);

            }
        }
        add(b);


        List<GameObject> wL = new ArrayList<GameObject>();
        for (int i = 0; i < 9; i++) {
            Block d=new Block(0, i * sizey, sizex, sizey, "wall.png");
            wL.add(d);
            collide(p,d);
        }
        add(wL);


        List<GameObject> wU = new ArrayList<GameObject>();
        for (int i = 0; i < 9; i++) {
            Block d=new Block(i * sizex, 8 * sizey, sizex, sizey, "wall.png");
            collide(p,d);
            wU.add(new Block(i * sizex, 8 * sizey, sizex, sizey, "wall.png"));


        }
        add(wU);

        List<GameObject> wR = new ArrayList<GameObject>();
        for (int i = 0; i < 9; i++) {
            Block d=new Block(8 * sizex, i * sizey, sizex, sizey, "wall.png");
            collide(p,d);
            wR.add(new Block(8 * sizex, i * sizey, sizex, sizey, "wall.png"));
        }
        add(wR);

        List<GameObject> wD = new ArrayList<GameObject>();
        for (int i = 0; i < 9; i++) {
            Block d=new Block(i * sizex, 0, sizex, sizey, "wall.png");
            collide(p,d);
            wD.add(new Block(i * sizex, 0, sizex, sizey, "wall.png"));
        }
        add(wD);



    }


}







  /*
    collide(p,b);
    FollowEnemy one=new FollowEnemy(200,130,40,40,this);
    Deep s= new Deep(350,130,100,100);
    Fireblock s1= new Fireblock(460,130,100,100);
    Blue s2= new Blue(570,130,100,100);
    Health health=new Health(p);
    add(b);
    add(health);

    overlap(p,s);
    overlap(one,s);
    add(s);
    overlap(p,s1);
    overlap(one,s1);
    add(s1);

    overlap(p,s2);
    overlap(one,s2);
    add(s2);
    overlap(p,one);
    add(one);
    Gdx.app.log("s",""+get("Entity"));
    List<GameObject> fs = new ArrayList<GameObject>();
    for(int i = 0;i < 5;i++){
        GameObject f = new SpeckFire(300 + i*40,170,30,30);
        fs.add(f);
    }
    add(fs);

    overlap(p,fs);
    */
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


