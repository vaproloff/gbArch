package sem05hw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }


    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels()) {
            processRender(model);
        }
    }

    @Override
    public void addModel(String modelName, Collection<Texture> textures) {
        databaseAccess.addEntity(new Model3D(modelName, textures));
    }

    @Override
    public void deleteModel(int modelNo) {
        for (Model3D model : databaseAccess.getAllModels()) {
            if (model.getId() == modelNo) {
                databaseAccess.removeEntity(model);
            }
        }
    }

    @Override
    public void addTexture(String textureName) {
        databaseAccess.addEntity(new Texture(textureName));
    }

    @Override
    public void deleteTexture(int textureNo) {
        for (Texture texture : databaseAccess.getAllTextures()) {
            if (texture.getId() == textureNo) {
                databaseAccess.removeEntity(texture);
            }
        }
    }

    @Override
    public Texture getTexture(int textureNo) {
        return (Texture) databaseAccess.getEntity(textureNo);
    }

    private Random random = new Random();

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
