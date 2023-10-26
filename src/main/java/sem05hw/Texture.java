package sem05hw;

public class Texture implements Entity {

    private static int counter = 50000;
    private int id;
    private String name;

    {
        id = ++counter;
    }

    public Texture(String name) {
        this.name = name;
    }

    public Texture() {
        this.name = String.format("texture_%d", this.id);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Texture #%s: '%s'", id, name);
    }
}
