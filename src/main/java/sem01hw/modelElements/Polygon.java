package sem01hw.modelElements;

import java.util.Collection;

public class Polygon {

    //region Constructors

    public Polygon(Collection<Point3D> points) {
        this.points = points;
    }

    public Polygon() {}

    //endregion


    //region Public Properties

    public Collection<Point3D> getPoints() {
        return points;
    }

    //endregion


    //region Private Fields

    private Collection<Point3D> points;

    //endregion

}
