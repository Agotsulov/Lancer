package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.lancer.game.gobjects.Block;
import com.lancer.game.gobjects.Buttons.ButtonHealth;
import com.lancer.game.gobjects.Buttons.ButtonPaladin;
import com.lancer.game.gobjects.Buttons.ButtonWarrior;
import com.lancer.game.helper.OtherFunctions;
//import com.lancer.game.gobjects.Warrior;


/**
 * Created by zope on 13.12.2017.
 */

public class Village extends Room {

    public Village() {

    }

    @Override
    public void init() {
        float scale = OtherFunctions.min((float)Gdx.graphics.getWidth()/720,(float)Gdx.graphics.getHeight()/720);

       // Player p = (Player) GameScreen.save.get(0);
name="Village";
    Block block=new Block(0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),"village_background.png");
    add(block);
        ButtonHealth health=new ButtonHealth(0,720-50,50,50,"button_health.png");
        add(health);
        ButtonWarrior Warrior=new ButtonWarrior(0,30,100,100,"warrior.png");
        add(Warrior);
        ButtonPaladin Paladin=new ButtonPaladin(200,30,100,100,"paladin.png");
        add(Paladin);
        //FireEye eye=new FireEye(360,360,50,50,"enemy.png",5);
        //eye.update();
       // add(eye);

       // collide(p,GameScreen.find("Fireball"));
    }
}

