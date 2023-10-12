package sem01hw.modelElements;

import java.util.Collection;

public class PolygonalModel {

    //region Constructors

    public PolygonalModel(Collection<Polygon> polygons, Collection<Texture> textures)
    {
        this.polygons = polygons;
        this.textures = textures;
    }

    public PolygonalModel(Collection<Polygon> polygons)
    {
        this.polygons = polygons;
    }

    //endregion


    //region Public Properties

    public Collection<Polygon> getPolygons() {
        return polygons;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    public void setTextures(Collection<Texture> textures) {
        this.textures = textures;
    }

    //endregion


    //region Private Fields

    private final Collection<Polygon> polygons;
    private Collection<Texture> textures;

    //endregion

}
