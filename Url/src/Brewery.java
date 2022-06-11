import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.linkedlist.MyList;

public class Brewery {

    private long id;

    private String name;

    private MyList<Beer> beers = new LinkedList<>();

    public Brewery(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MyList<Beer> getBeers() {
        return beers;
    }

}
