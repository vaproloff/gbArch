package sem01hw.modelElements;

public class Color {

    //region Initializers and Constructors

    {
        id = ++counter;
    }

    public Color(String name)
    {
        this.name = name;
    }

    //endregion


    //region Public Properties

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //endregion


    //region Private Fields

    private static int counter = 0;
    private final int id;
    private final String name;

    //endregion

}
