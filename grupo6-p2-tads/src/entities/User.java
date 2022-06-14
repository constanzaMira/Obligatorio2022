package entities;

public class User {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public boolean equals(Object obj) {
        boolean exit = false;
        if (obj instanceof User){
            User tmp = (User) obj;
            exit = this.getUserName() == tmp.getUserName();
            //exit = Objects.equals(this.getNld(), tmp.getNld());
        }
        return exit;
    }
}
