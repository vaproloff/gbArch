package sem01hw.modelElements;

public class Angle3D {

    //region Constructors

    public Angle3D(double xAngle, double yAngle, double zAngle) {
        this.xAngle = xAngle;
        this.yAngle = yAngle;
        this.zAngle = zAngle;
    }

    //endregion


    //region Public Properties

    public double getXAngle() {
        return xAngle;
    }

    public double getYAngle() {
        return yAngle;
    }

    public double getZAngle() {
        return zAngle;
    }

    //endregion


    //region Private Fields

    private final double xAngle;
    private final double yAngle;
    private final double zAngle;

    //endregion

}
