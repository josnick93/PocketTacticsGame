package com.josnick.pockettactics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.josnick.pockettactics.Screens.AbstractGameScreen;
import com.josnick.pockettactics.Screens.GameScreen;

public class PocketTacticsGame extends ApplicationAdapter {
	public static final float VIRTUAL_WIDTH = 960;
	public static final float VIRTUAL_HEIGHT = 540;
	private AbstractGameScreen currentScreen;


	@Override
	public void create () {
		Gdx.input.setCatchBackKey(true);
		setScreen(new GameScreen(this));

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT |
				GL20.GL_DEPTH_BUFFER_BIT);
		currentScreen.render(Gdx.graphics.getDeltaTime());

	}

	@Override
	public void resize(int width, int height) {
		currentScreen.resize(width, height);
	}

	public void setScreen(AbstractGameScreen screen){
		if(this.currentScreen != null){
			this.currentScreen.hide();
			this.currentScreen.dispose();
		}
		this.currentScreen=screen;
		if(this.currentScreen!=null){
			this.currentScreen.show();
			this.currentScreen.resize(Gdx.graphics.getWidth(),
					Gdx.graphics.getHeight());
		}
	}

	@Override
	public void dispose () {

	}
}
