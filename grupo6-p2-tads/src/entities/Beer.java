package entities;


import uy.edu.um.prog2.tad.arraylist.ArrayList;
import uy.edu.um.prog2.tad.arraylist.MyArrayList;

public class Beer {

    private long id;

    private String name;

    private Style style;

    private double abv;

    private MyArrayList<Review> reviewsId;

    public Beer(long id, String beer_name, double beer_abv, Review newReview) {
        this.id = id;
    }

  /*  public Beer(long id, String name, double abv) {
        this.id = id;
        this.name = name;
        this.abv = abv;
        this.reviewsId = new ArrayList<>(1000);
    }*/

    public Beer(long id, String name, Style style, double abv, MyArrayList<Review> reviewsId) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.abv = abv;
        this.reviewsId = new ArrayList<>(1000);
    }



    public Beer(Long beer_beerId, String beer_name, double beer_abv, Style newStyle) {
    }

    public MyArrayList<Review> getReviewsId() {
        return reviewsId;
    }

    public void setReviewsId(MyArrayList<Review> reviewsId) {
        this.reviewsId = reviewsId;
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

    public void addReview(Review reviewId) {
        this.reviewsId.add(reviewId);
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
