package entities;


import uy.edu.um.prog2.tad.arraylist.ArrayList;
import uy.edu.um.prog2.tad.arraylist.MyArrayList;

public class Beer {

    private long id;

    private String name;

    private Style style;

    private double abv;

    private double puntaje;

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public void agregarPuntaje(double puntaje1){
        this.puntaje+=puntaje1;
    }

    private MyArrayList<Review> reviews;


    public Beer(long id, String name, double abv, Style style) {
        this.id = id;
        this.name = name;
        this.abv = abv;
        this.reviews = new ArrayList<>(1000);
        this.style = style;
        this.puntaje=0;
    }

    public MyArrayList<Review> getReviewsId() {
        return reviews;
    }

    public void setReviewsId(MyArrayList<Review> reviewsId) {
        this.reviews = reviewsId;
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

    public MyArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(MyArrayList<Review> reviews) {
        this.reviews = reviews;
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
}
