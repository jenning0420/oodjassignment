/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sng;

import dao.UserLoginDao;

/**
 *
 * @author User
 */
public class Employee extends Modification {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public boolean login(UserLoginDao uld, User uls) {
        return uld.add(uls);
    }

}
