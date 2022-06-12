package entities;

import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.linkedlist.MyList;

public class Brewery {// son las casas de cerveza

    private MyList<Beer> beers = new LinkedList<>();

    public MyList<Beer> getBeers() {
        return beers;
    }

    public void setBeers(MyList<Beer> beers) {
        this.beers = beers;
    }

    public Brewery(MyList<Beer> beers) {
        this.beers = beers;
    }

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brewery(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
