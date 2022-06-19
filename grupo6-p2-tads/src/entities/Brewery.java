package entities;

import uy.edu.um.prog2.tad.arraylist.ArrayList;
import uy.edu.um.prog2.tad.arraylist.MyArrayList;
import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.linkedlist.MyList;

public class Brewery {// son las casas de cerveza

    private long id;

    private String name;

    private MyArrayList<Long> beersId;

    public Brewery(long id, String name) {
        this.id = id;
        this.name = name;
        this.beersId = new ArrayList<>(200);
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

    public MyArrayList<Long> getBeersId() {
        return beersId;
    }

    public void setBeers(MyArrayList<Long> beers) {
        this.beersId = beers;
    }

    public void addBeer(Long beerId) {
        this.beersId.add(beerId);
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
