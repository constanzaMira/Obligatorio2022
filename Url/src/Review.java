import java.util.Date;

public class Review {

    private long id;

    private Date date;

    private double overallScore;

    private double aromaScore;

    private double appearanceScore;

    private double palateScore;

    private double flavourScore;

    private User user;

    private Brewery brewery;

    public Review(long id, Date date, double overallScore, double aromaScore, double appearanceScore, double palateScore, double flavourScore, User user, Brewery brewery) {
        this.id = id;
        this.date = date;
        this.overallScore = overallScore;
        this.aromaScore = aromaScore;
        this.appearanceScore = appearanceScore;
        this.palateScore = palateScore;
        this.flavourScore = flavourScore;
        this.user = user;
        this.brewery = brewery;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public double getAromaScore() {
        return aromaScore;
    }

    public double getAppearanceScore() {
        return appearanceScore;
    }

    public double getPalateScore() {
        return palateScore;
    }

    public double getFlavourScore() {
        return flavourScore;
    }

    public User getUser() {
        return user;
    }

    public Brewery getBrewery() {
        return brewery;
    }

}
