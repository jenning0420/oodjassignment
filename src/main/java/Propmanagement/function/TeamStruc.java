/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.function;

/**
 *
 * @author Admin
 */
public class TeamStruc {

    private String TSRole;
    private int TSAmount;

    public TeamStruc(String TSRole, int TSAmount) {
        this.TSRole = TSRole;
        this.TSAmount = TSAmount;
    }
    
    public String getTSRole() {
        return TSRole;
    }

    public void setTSRole(String TSRole) {
        this.TSRole = TSRole;
    }
    
    
    public int getTSAmount() {
        return TSAmount;
    }

    public void setTSAmount(int TSAmount) {
        this.TSAmount = TSAmount;
    }
        
}
