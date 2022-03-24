package DAO;

public class User {
    private String username;
    private String pass;
    private String gmail;

    public User(String username, String pass, String gmail) {
        this.username = username;
        this.pass = pass;
        this.gmail = gmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
