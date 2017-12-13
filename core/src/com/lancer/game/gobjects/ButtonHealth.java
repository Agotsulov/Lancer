package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.lancer.game.helper.ButtonListener;

/**
 * Created by zope on 13.12.2017.
 */

public class ButtonHealth extends Button {

    public ButtonHealth(float x, float y, float w, float h, String filename) {
        super(x, y, w, h, filename);
    }
    @Override
    public void action(){
      //хп
        Gdx.app.log("hp","");
    }

}
