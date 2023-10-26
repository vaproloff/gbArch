package sem05hw;

import java.util.Collection;

public interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModels();

    void addModel(String modelName, Collection<Texture> textures);

    void deleteModel(int modelNo);

    void addTexture(String textureName);

    void deleteTexture(int textureNo);

    Texture getTexture(int textureNo);
}
