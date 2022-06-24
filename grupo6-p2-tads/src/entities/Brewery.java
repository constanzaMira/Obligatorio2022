package entities;

import uy.edu.um.prog2.tad.arraylist.ArrayList;
import uy.edu.um.prog2.tad.arraylist.MyArrayList;

public class Brewery {

    private long id;

    private int cantReviews=0;

    private String name;

    public int getCantReviews() {
        return cantReviews;
    }

    public int setCantReviews(int cantReviews) {
        this.cantReviews = cantReviews;
        return cantReviews;
    }

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
        }
        return exit;
    }
}
