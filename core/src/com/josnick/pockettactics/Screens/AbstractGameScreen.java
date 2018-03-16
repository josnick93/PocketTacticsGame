package com.josnick.pockettactics.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.josnick.pockettactics.PocketTacticsGame;

/**
 * Created by josnick on 16/03/2018.
 */
public abstract class AbstractGameScreen implements Screen {

    protected PocketTacticsGame game;


    public AbstractGameScreen(PocketTacticsGame game){
        this.game=game;
    }

    public void resume (){

    }

    public void dispose(){

    }

    public abstract void render (float render);
    public abstract void resize(int width,int height);
    public abstract void show();
    public abstract void pause();
}
