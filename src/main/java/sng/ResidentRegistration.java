/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sng;

import dao.UserRegisterDao;

/**
 *
 * @author User
 */
public class ResidentRegistration extends StaffRegistration{

    private int propID;

    public int getPropID() {
        return propID;
    }

    public void setPropID(int propID) {
        this.propID = propID;
    }

    public boolean register(UserRegisterDao urd, ResidentRegistration urs) {
        return urd.add(urs);
    }
}
