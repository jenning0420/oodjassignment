/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sng;

/**
 *
 * @author User
 */
public class User {

    private String userId;
    private String username;
    private String password;
    private String textFile;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTextFile() {
        return textFile;
    }

    public void setTextFile(String textFile) {
        this.textFile = textFile;
    }

    public User() {
        userId = "";
        username = "";
        password = "";
        textFile = "";
    }

    public User(String id, String name, String password, String textfile) {
        userId = id;
        username = name;
        password = password;
        textFile = textfile;
    }
}
