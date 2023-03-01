/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PropertyManagement;

import dao.UserRegisterDao;
import dao.VendorRegisterDao;

/**
 *
 * @author User
 */
public class VendorRegistration extends StaffRegistration{
    private int propID;

    public int getPropID() {
        return propID;
    }

    public void setPropID(int propID) {
        this.propID = propID;
    }
    
    public boolean register(VendorRegisterDao vrd, VendorRegistration vrs) {
        return vrd.add(vrs);
    }
}
