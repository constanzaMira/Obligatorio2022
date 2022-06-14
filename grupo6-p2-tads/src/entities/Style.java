package entities;

public class Style {
    private String name;

    public Style(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        boolean exit = false;
        if (obj instanceof Style){
            Style tmp = (Style) obj;
            exit = this.getName() == tmp.getName();
            //exit = Objects.equals(this.getNld(), tmp.getNld());
        }
        return exit;
    }
}
