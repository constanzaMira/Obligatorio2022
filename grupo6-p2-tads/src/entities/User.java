package entities;

public class User {

    private String userName;

    private Long userId;

    private int cantResenias = 0;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public int getCantResenias() {
        return cantResenias;
    }

    public void setCantResenias(int cantResenias) {
        this.cantResenias = cantResenias;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    void sumarResenia() {
        this.cantResenias++;
    }

    public boolean equals(Object obj) {
        boolean exit = false;
        if (obj instanceof User){
            User tmp = (User) obj;
            exit = this.getUserName() == tmp.getUserName();
        }
        return exit;
    }
}
