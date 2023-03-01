/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PropertyManagement;

import dao.SetupPatrolDao;

/**
 *
 * @author User
 */
public class Patrol {
    private int patrolID;
    private String userID;
    private String patrolVenue;
    private String patrolDetails;
    private String patrolDate;
    private String patrolTime;
    private String patrolStatus;

    public int getPatrolID() {
        return patrolID;
    }

    public void setPatrolID(int patrolID) {
        this.patrolID = patrolID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPatrolVenue() {
        return patrolVenue;
    }

    public void setPatrolVenue(String patrolVenue) {
        this.patrolVenue = patrolVenue;
    }

    public String getPatrolDetails() {
        return patrolDetails;
    }

    public void setPatrolDetails(String patrolDetails) {
        this.patrolDetails = patrolDetails;
    }

    public String getPatrolDate() {
        return patrolDate;
    }

    public void setPatrolDate(String patrolDate) {
        this.patrolDate = patrolDate;
    }

    public String getPatrolTime() {
        return patrolTime;
    }

    public void setPatrolTime(String patrolTime) {
        this.patrolTime = patrolTime;
    }

    public String getPatrolStatus() {
        return patrolStatus;
    }

    public void setPatrolStatus(String patrolStatus) {
        this.patrolStatus = patrolStatus;
    }
    
    public boolean setupPatrol(SetupPatrolDao spd, Patrol sps) {
        return spd.add(sps);
    }
}
