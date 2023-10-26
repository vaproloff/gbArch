package sem05hw;

import java.util.Collection;

public interface UILayer {

    void openProject(String fileName);

    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();

    void renderModel(int i);

    void addModel(String modelName, Collection<Texture> textures);

    void deleteModel(int modelNo);

    void addTexture(String textureName);

    void deleteTexture(int textureNo);

    Texture getTexture(int textureNo);
}
