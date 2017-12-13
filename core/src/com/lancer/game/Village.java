package com.lancer.game;

import com.badlogic.gdx.Gdx;
import com.lancer.game.gobjects.Block;
import com.lancer.game.gobjects.Button;
import com.lancer.game.gobjects.ButtonHealth;

/**
 * Created by zope on 13.12.2017.
 */

public class Village extends Room {
    public Village() {

    }

    @Override
    public void init() {
       // Player p = (Player) GameScreen.find("Player");
   // add(p);
    Block block=new Block(0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),"village_background.png");
    add(block);
        ButtonHealth health=new ButtonHealth(0,720-50,50,50,"button_health.png");
        add(health);
    }
}

