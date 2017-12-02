package com.lancer.game.gobjects.sticks;

import com.lancer.game.gobjects.Fireball;
import com.lancer.game.gobjects.Player;
import com.lancer.game.gobjects.Stick;

/**
 * Created by byzilio on 02.12.17.
 */

public class FireWeaponStick extends Stick {
    public FireWeaponStick(float r, Player p) {
        super(p.x + p.width / 2, p.y + p.height / 2, r, p);
    }


    public void end(){
        if(dir.len() != 0){
            Fireball fb = new Fireball(player.x + player.width / 2, player.y + player.height / 2,dir);
            player.room.add(fb);
            player.room.overlap(fb,player.room.get("Entity"));
        }
    }
}
