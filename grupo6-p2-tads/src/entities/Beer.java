package entities;


import uy.edu.um.prog2.tad.linkedlist.LinkedList;

public class Beer {
    private long id;
    private String name;

    private Style style;

    // una cerveza tiene una lista? de reviews
    //una cerveza tiene una lista? de estilos

    private uy.edu.um.prog2.tad.linkedlist.LinkedList<Review> reviews;

    public LinkedList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(LinkedList<Review> reviews) {
        this.reviews = reviews;
    }

    public Beer(LinkedList<Review> reviews) {
        this.reviews = reviews;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
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

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    private double abv;

    public Beer(long id, String name, double abv) {
        this.id = id;
        this.name = name;
        this.abv = abv;
    }

    public boolean equals(Object obj) {
        boolean exit = false;
        if (obj instanceof Beer){
            Beer tmp = (Beer) obj;
            exit = this.getId() == tmp.getId();
            //exit = Objects.equals(this.getNld(), tmp.getNld());
        }
        return exit;
    }
}
