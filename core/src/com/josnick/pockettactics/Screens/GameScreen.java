package com.josnick.pockettactics.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.josnick.pockettactics.PocketTacticsGame;
import com.josnick.pockettactics.World.GameWorld;

/**
 * Created by josnick on 16/03/2018.
 */
public class GameScreen extends AbstractGameScreen {
    private static final String TAG= GameScreen.class.getName();
    private GameWorld gameWorld; //represents the world

    public GameScreen(PocketTacticsGame game) {
        super(game);
        Gdx.input.setCursorCatched(true);
        this.gameWorld=new GameWorld();
    }


    @Override
    public void render(float render) {
        gameWorld.render(render);
    }

    @Override
    public void resize(int width, int height) {
        gameWorld.resize(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void dispose() {
        gameWorld.dispose();
    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {

    }
}
