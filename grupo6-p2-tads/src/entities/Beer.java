package entities;


import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.linkedlist.MyList;

public class Beer {
    private long id;
    private String name;
    private Style style;
    private double abv;

    // una cerveza tiene una lista? de reviews
    //una cerveza tiene una lista? de estilos

    private MyList<Review> reviews = new LinkedList<>();

    public Beer(long id, String name, double abv) {
        this.id = id;
        this.name = name;
        this.abv = abv;
    }

    public MyList<Review> getReviews() {
        return reviews;
    }
    public void setReviews(LinkedList<Review> reviews) {
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

    public void addReview(Review review) {
        this.reviews.add(review);
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
    @Override
    public int hashCode() {
        return Long.hashCode(this.id);
    }
}
