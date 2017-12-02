package com.lancer.game.gobjects.sticks;

import com.lancer.game.gobjects.Fireball;
import com.lancer.game.gobjects.Player;
import com.lancer.game.gobjects.Stick;

/**
 * Created by byzilio on 02.12.17.
 */

public class FireWeaponStick extends Stick {
    public FireWeaponStick(float x,float y,float r, Player p) {
        super(x, y, r, p);
    }


    public void end(){
        if(player.red > 0 && player.isAlive==true) {
            Fireball fb = new Fireball(player.x + player.width / 2, player.y + player.height / 2, dir,1/player.red*10);
            player.red -= 1;
            player.room.add(fb);
            player.room.overlap(fb, player.room.get("Entity"));
        }
    }
}
