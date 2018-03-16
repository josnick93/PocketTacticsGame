package com.josnick.pockettactics.World;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.josnick.pockettactics.PocketTacticsGame;

/**
 * Created by josnick on 16/03/2018.
 */
public class GameWorld {

    private static final float FOV = 67F; //camera angle
    private ModelBatch modelBatch;
    private Environment environment;
    private PerspectiveCamera perspectiveCamera;



    public GameWorld(){
        initPersCamera();
        initEnvironment();
        initModelBatch();
    }

    private void initPersCamera() {
        perspectiveCamera = new PerspectiveCamera(FOV,
                PocketTacticsGame.VIRTUAL_WIDTH, PocketTacticsGame.VIRTUAL_HEIGHT);
        perspectiveCamera.position.set(30f, 40f, 30f);
        perspectiveCamera.lookAt(0f, 0f, 0f);
        perspectiveCamera.near = 1f;
        perspectiveCamera.far = 300f;
        perspectiveCamera.update();
    }

    private void initEnvironment() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight,
                0.3f, 0.3f, 0.3f, 1f));
    }
    private void initModelBatch() {
        modelBatch = new ModelBatch();
    }


    public void render(float delta) {
        modelBatch.begin(perspectiveCamera);
        modelBatch.end();
    }

    public void resize(int width, int height) {
        perspectiveCamera .viewportHeight = height;
        perspectiveCamera .viewportWidth = width;

    }

    public void dispose() {
    }
}
