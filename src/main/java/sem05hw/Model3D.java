package sem05hw;

import java.util.ArrayList;
import java.util.Collection;

public class Model3D implements Entity {

    private static int counter = 10000;
    private int id;
    private String name;
    private Collection<Texture> textures;

    public Collection<Texture> getTextures() {
        if (textures == null) {
            textures = new ArrayList<>();
        }
        return textures;
    }

    {
        id = ++counter;
    }

    public Model3D(String name, Collection<Texture> textures) {
        this.name = name;
        this.textures = textures;
    }

    public Model3D() {
        this.name = String.format("3DModel_%d", this.id);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("3DModel #%s: '%s'", id, name);
    }
}
