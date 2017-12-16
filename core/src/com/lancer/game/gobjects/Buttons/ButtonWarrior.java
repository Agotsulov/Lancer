package com.lancer.game.gobjects.Buttons;

import com.badlogic.gdx.Gdx;
import com.lancer.game.GameScreen;
import com.lancer.game.NextRoom;
import com.lancer.game.gobjects.Players.Paladin;
import com.lancer.game.gobjects.Players.Warrior;

/**
 * Created by zope on 16.12.2017.
 */

public class ButtonWarrior extends Button {

   public ButtonWarrior(float x, float y, float w, float h, String filename){
       super(x,y,w,h,filename);


    }
    public void action(){
        //хп
        Gdx.app.log("warrior","");
        GameScreen.curRoom=new NextRoom();

        GameScreen.curRoom.init();
        GameScreen.curRoom.Resize();
       Gdx.app.log("name"," "+GameScreen.curRoom.name);
       Warrior player=new Warrior(300,300,100,100,"warrior.png");

        player.Resize();

    }
}
