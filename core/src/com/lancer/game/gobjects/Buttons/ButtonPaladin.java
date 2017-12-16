package com.lancer.game.gobjects.Buttons;

import com.badlogic.gdx.Gdx;
import com.lancer.game.GameScreen;
import com.lancer.game.NextRoom;
import com.lancer.game.gobjects.Players.Paladin;

/**
 * Created by zope on 16.12.2017.
 */

public class ButtonPaladin extends Button {
public ButtonPaladin(float x,float y,float w,float h,String filename){
    super(x,y,w,h,filename);
    }
    public void action(){
        //хп
        Gdx.app.log("paladin","");
        GameScreen.curRoom=new NextRoom();
        GameScreen.curRoom.init();
        GameScreen.curRoom.Resize();
         Paladin player=new Paladin(300,300,100,100,"paladin.png");
       player.Resize();

    }
}
