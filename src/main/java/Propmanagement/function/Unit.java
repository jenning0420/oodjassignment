/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.function;

/**
 *
 * @author Admin
 */
public class Unit {
    private String PID;
    private String PUnitNo;
    private String PType;
    private double PPrice;

    public Unit(String PID, String PUnitNo, String PType, double PPrice) {
        this.PID = PID;
        this.PUnitNo = PUnitNo;
        this.PType = PType;
        this.PPrice = PPrice;
    }
    
    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }
    
    
    public String getPUnitNo() {
        return PUnitNo;
    }

    public void setPUnitNo(String PUnitNo) {
        this.PUnitNo = PUnitNo;
    }
    
    public String getPType() {
        return PType;
    }

    public void setPType(String PType) {
        this.PType = PType;
    }
    
    public double getPPrice() {
        return PPrice;
    }

    public void setPPrice(double PPrice) {
        this.PPrice = PPrice;
    }
    
    
}
