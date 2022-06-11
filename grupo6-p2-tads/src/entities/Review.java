package entities;

import uy.edu.um.prog2.tad.hash.HashNode;

import java.util.Date;

public class Review {
    //private HashNode<>[] elements;
    //un user tiene una lista? de reviews

    private long id;
    private Date date;
    private double overallScore;
    private double appearanceScore;
    private double aromaScore;
    private double flavourScore;

    public Review(long id, Date date, double overallScore, double appearanceScore,
                  double aromaScore, double flavourScore) {
        this.id = id;
        this.date = date;
        this.overallScore = overallScore;
        this.appearanceScore = appearanceScore;
        this.aromaScore = aromaScore;
        this.flavourScore = flavourScore;
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

    public double getFlavourScore() {
        return flavourScore;
    }

    public void setFlavourScore(double flavourScore) {
        this.flavourScore = flavourScore;
    }
}
