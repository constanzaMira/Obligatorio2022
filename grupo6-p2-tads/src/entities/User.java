package entities;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        boolean exit = false;
        if (obj instanceof User){
            User tmp = (User) obj;
            exit = this.getName() == tmp.getName();
            //exit = Objects.equals(this.getNld(), tmp.getNld());
        }
        return exit;
    }
}
