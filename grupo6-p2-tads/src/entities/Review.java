package entities;

import uy.edu.um.prog2.tad.hash.HashNode;

import java.util.Date;

public class Review implements Comparable<Review> {

    private long id;

    private Date date;

    private double overallScore;

    private double appearanceScore;

    private double aromaScore;

    private double palateScore;

    private double flavourScore;

    private User user;

    private Long breweryId;

    public Review(long id, Date date, double overallScore, double appearanceScore, double aromaScore, double palateScore, double flavourScore, User user, Long breweryId) {
        this.id = id;
        this.date = date;
        this.overallScore = overallScore;
        this.appearanceScore = appearanceScore;
        this.aromaScore = aromaScore;
        this.palateScore = palateScore;
        this.flavourScore = flavourScore;
        this.user = user;
        this.breweryId = breweryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public double getAppearanceScore() {
        return appearanceScore;
    }

    public void setAppearanceScore(double appearanceScore) {
        this.appearanceScore = appearanceScore;
    }

    public double getAromaScore() {
        return aromaScore;
    }

    public void setAromaScore(double aromaScore) {
        this.aromaScore = aromaScore;
    }

    public double getPalateScore() {
        return palateScore;
    }

    public void setPalateScore(double palateScore) {
        this.palateScore = palateScore;
    }

    public double getFlavourScore() {
        return flavourScore;
    }

    public void setFlavourScore(double flavourScore) {
        this.flavourScore = flavourScore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getBrewery() {
        return breweryId;
    }

    public void setBrewery(Long brewery) {
        this.breweryId = brewery;
    }

    @Override
    public boolean equals(Object obj) {
        boolean exit = false;
        if (obj instanceof Review){
            Review tmp = (Review) obj;
            exit = this.getId() == tmp.getId();
            //exit = Objects.equals(this.getNld(), tmp.getNld());
        }
        return exit;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.id);
    }

    @Override
    public int compareTo(Review o) {
        return 0;
    }
}
