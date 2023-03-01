/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PropertyManagement;

import dao.SecurityRecordIncidentDao;

/**
 *
 * @author User
 */
public class Incident {
    private int incidentID;
    private String userID;
    private String description;
    private String dateIn;
    private String timeIn;

    public int getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(int incidentID) {
        this.incidentID = incidentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID (String userID) {
        this.userID = userID;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }
    
    public boolean recordIncident(SecurityRecordIncidentDao srid, Incident sris) {
        return srid.add(sris);
    }
}
