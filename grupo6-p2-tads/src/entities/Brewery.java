package entities;

import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.linkedlist.MyList;

public class Brewery {// son las casas de cerveza
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

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyList<Beer> getBeers() {
        return beers;
    }

    public void setBeers(MyList<Beer> beers) {
        this.beers = beers;
    }

    public void addBeer(Beer beer) {
        this.beers.add(beer);
    }

    public boolean equals(Object obj) {
        boolean exit = false;
        if (obj instanceof Brewery){
            Brewery tmp = (Brewery) obj;
            exit = this.getId() == tmp.getId();
            //exit = Objects.equals(this.getNld(), tmp.getNld());
        }
        return exit;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.id);
    }
}
