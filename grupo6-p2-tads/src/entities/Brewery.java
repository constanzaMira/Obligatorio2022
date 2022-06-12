package entities;

import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.linkedlist.MyList;

public class Brewery {// son las casas de cerveza

    private Beer beer;
    private MyList<Beer> beers = new LinkedList<>();

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

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

    public boolean equals(Object obj) {
        boolean exit = false;
        if (obj instanceof Brewery){
            Brewery tmp = (Brewery) obj;
            exit = this.getId() == tmp.getId();
            //exit = Objects.equals(this.getNld(), tmp.getNld());
        }
        return exit;
    }
}
