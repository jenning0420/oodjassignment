/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.function;

/**
 *
 * @author Admin
 */
public class AccExecPayment {
    
    private String AccUnitNo;
    private double AccAmount;
    private String AccStatus;

    public AccExecPayment(String AccUnitNo, double AccAmount, String AccStatus) {
        this.AccUnitNo = AccUnitNo;
        this.AccAmount = AccAmount;
        this.AccStatus = AccStatus;
    }
    
    public String getAccUnitNo() {
        return AccUnitNo;
    }

    public void setAccUnitNo(String AccUnitNo) {
        this.AccUnitNo = AccUnitNo;
    }
   
    public double getAccAmount() {
        return AccAmount;
    }

    public void setAccAmount(double AccAmount) {
        this.AccAmount = AccAmount;
    }    
    
    public String getAccStatus() {
        return AccStatus;
    }

    public void setAccStatus(String AccStatus) {
        this.AccStatus = AccStatus;
    }    
}
