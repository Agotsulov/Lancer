package com.lancer.game.gobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.lancer.game.GameScreen;

/**
 * Created by zope on 13.12.2017.
 */

public class FireEye extends Entity{
float speed;

    public FireEye(float x,float y,float width,float height,String filename,float speed)
    {
       super(x,y,width,height,filename);
        this.health=20;
        this.curTime=120;
      this.speed=speed;
    }
    @Override
    public void fixedUpdate() {
       // int start=0;



            start++;
            if(start%this.curTime==0){
                Vector2 dir=new Vector2(GameScreen.find("Player").x-this.x,GameScreen.find("Player").y-this.y);
                dir.setLength(this.speed);
                Fireball fireball=new Fireball(this.x,this.y, dir,10);
                fireball.Resize();

                GameScreen.curRoom.add(fireball);
                GameScreen.curRoom.collide(GameScreen.save.get(0),fireball);
                GameScreen.curRoom.collide(fireball,GameScreen.save.get(0));
            }

    }
    public void draw(SpriteBatch batch)
    {
      batch.draw(texture,x,y,width,height);
    }

}
