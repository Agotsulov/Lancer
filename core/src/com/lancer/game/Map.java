package com.lancer.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by zope on 08.12.2017.
 */

public class Map extends GameObject{
     public static Room map[][]=new Room[9][9];
    public Map(){}
   static {
       for(int i=0;i<9;i++)
       {
           for(int j=0;j<9;j++)
           {
               map[i][j]=new TestRoom();
               map[i][j].init();
           }
       }
   }
    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void collide(GameObject another) {

    }
}
