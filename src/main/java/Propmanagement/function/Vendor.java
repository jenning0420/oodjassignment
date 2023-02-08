/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.function;

/**
 *
 * @author Admin
 */
public class Vendor {
    private String Username;
    private String Name;
    private String Contact;
    private String Gender;
    private String Password;
    
    private String userID;
    private String propID;
    
    public Vendor(String userID, String Username, String Name, String Contact, String Gender, String Password, String propID) {
        this.userID = userID;
        this.Username = Username;
        this.Name = Name;
        this.Contact = Contact;
        this.Gender = Gender;
        this.Password = Password;  
        this.propID = propID;
    }
    
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }
    
    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    } 
    
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }    

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPropID() {
        return propID;
    }

    public void setPropID(String propID) {
        this.propID = propID;
    }

    
    
    
    
}
