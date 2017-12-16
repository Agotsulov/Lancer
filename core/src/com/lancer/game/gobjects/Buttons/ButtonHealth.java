package com.lancer.game.gobjects.Buttons;

import com.badlogic.gdx.Gdx;

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
