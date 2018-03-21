package com.josnick.pockettactics.World;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.UBJsonReader;
import com.josnick.pockettactics.PocketTacticsGame;

/**
 * Created by josnick on 16/03/2018.
 */
public class GameWorld {

    private static final float FOV = 67F; //camera angle
    private ModelBatch modelBatch;
    private Environment environment;
    private PerspectiveCamera perspectiveCamera;

    private ModelInstance tileInstance,cubeInstance; //water tile model instance


    public GameWorld(){
        initPersCamera();
        initEnvironment();
        initModelBatch();
        loadExampleCube();
        loadExampleTile();
    }

    private void loadExampleTile() {
        UBJsonReader jsonReader = new UBJsonReader();
        G3dModelLoader modelLoader = new G3dModelLoader(jsonReader);
        Model water_tile_model = modelLoader.loadModel(Gdx.files.getFileHandle("models/humans/caer.g3db"
                , Files.FileType.Internal));
        water_tile_model.materials.add(new
                Material(ColorAttribute.createDiffuse(Color.BLUE)));
        tileInstance = new ModelInstance(water_tile_model);
        tileInstance.transform.trn(0,0,0);
    }

    private void loadExampleCube(){
        ModelBuilder modelBuilder = new ModelBuilder();
        Material mat = new
                Material(ColorAttribute.createDiffuse(Color.BLUE));
        Model model = modelBuilder.createBox(5, 5, 5, mat,
                VertexAttributes.Usage.Position |
                        VertexAttributes.Usage.Normal);
        cubeInstance = new ModelInstance(model);
    }

    private void initPersCamera() {
        perspectiveCamera = new PerspectiveCamera(FOV,
                PocketTacticsGame.VIRTUAL_WIDTH, PocketTacticsGame.VIRTUAL_HEIGHT);
        perspectiveCamera.position.set(10f, 10f, 10f);
        perspectiveCamera.lookAt(0f, 0f, 0f);
        perspectiveCamera.near = 1f;
        perspectiveCamera.far = 300f;
        perspectiveCamera.update();
    }

    private void initEnvironment() {
        environment= new Environment();
        environment.set(new
                ColorAttribute(ColorAttribute.AmbientLight,
                0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -
                1f, -0.8f, -0.2f));
    }
    private void initModelBatch() {
        modelBatch = new ModelBatch();
    }


    public void render(float delta) {
        modelBatch.begin(perspectiveCamera);
       // modelBatch.render(cubeInstance,environment);
        modelBatch.render(tileInstance,environment);
        modelBatch.end();
    }

    public void resize(int width, int height) {
        perspectiveCamera .viewportHeight = height;
        perspectiveCamera .viewportWidth = width;

    }

    public void dispose() {
    }
}
