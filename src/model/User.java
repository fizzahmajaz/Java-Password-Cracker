package model;

public class User {
    private int id;
    private String username;
    private String hashedPassword;

    // constructor for fetching from db (including id)

    public User(int id, String username, String hashedPassword) {
        this.id = id;
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    // Constructor for inserting new user (id auto generated)

    public User(String username, String hashedpassword) {

        this.username = username;
        this.hashedPassword = hashedpassword;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    

    

}