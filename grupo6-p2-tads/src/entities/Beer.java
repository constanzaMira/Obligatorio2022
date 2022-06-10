package entities;

public class Beer {
    private long id;
    private String name;

    // una cerveza tiene una lista? de reviews
    //una cerveza tiene una lista? de estilos

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
}
