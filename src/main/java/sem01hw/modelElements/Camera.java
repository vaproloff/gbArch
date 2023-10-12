package sem01hw.modelElements;

public class Camera {

    //region Public Methods

    public void rotate(Angle3D newAngle) {
        this.angle = newAngle;
    }

    public void move(Point3D newLocation) {
        this.location = newLocation;
    }

    //endregion


    //region Constructors

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    //endregion


    //region Public Properties

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    //endregion


    //region Private Fields

    private Point3D location;
    private Angle3D angle;

    //endregion

}
