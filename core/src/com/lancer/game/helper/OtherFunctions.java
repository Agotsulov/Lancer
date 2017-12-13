package com.lancer.game.helper;

/**
 * Created by zope on 06.12.2017.
 */

public class OtherFunctions<E> {
    public static float min(float a,float b){
        if(a>b)
        {
            return b;
        }
        else
        {
            return a;
        }
    }
    public static float max(float a,float b){
        if(a>b)
        {
            return a;
        }
        else
        {
            return b;
        }
    }
}
