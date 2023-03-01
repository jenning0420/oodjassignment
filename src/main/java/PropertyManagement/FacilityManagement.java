/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PropertyManagement;

import dao.FacilityManagementDao;

/**
 *
 * @author User
 */
public class FacilityManagement {

    private int facilityID;
    private String facility;
    private String equipment;
    private String quantity;
    private String condition;

    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    public boolean BookFacility(FacilityManagementDao fmd, FacilityManagement fms) {
        return fmd.add(fms);
    }

}
