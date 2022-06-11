import uy.edu.um.prog2.tad.linkedlist.MyList;
import uy.edu.um.prog2.tad.linkedlist.LinkedList;

public class Beer {

    private long id;

    private String name;

    private double abv;

    private Style style;

    private MyList<Review> reviews = new LinkedList<>();

    public Beer(long id, String name, double abv) {
        this.id = id;
        this.name = name;
        this.abv = abv;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAbv() {
        return abv;
    }

    public Style getStyle() {
        return style;
    }
}
