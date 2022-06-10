package entities;

public class Brewery {// son las casas de cerveza

    //tiene que tener una lista? de cervezas

    private long id;
    private String name;

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

    public Brewery(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
