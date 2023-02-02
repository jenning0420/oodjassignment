/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.function;

/**
 *
 * @author Admin
 */
public class Item {
    private String POwnerName;
    private int PID;
    private String PType;
    private int PPrice;
    private String PRentBuy;;

    public Item(String POwnerName, int PID, String PType, int PPrice, String PRentBuy) {
        this.POwnerName = POwnerName;
        this.PID = PID;
        this.PType = PType;
        this.PPrice = PPrice;
        this.PRentBuy = PRentBuy;
    }
    
    public String getPOwnerName() {
        return POwnerName;
    }

    public void setPOwnerName(String POwnerName) {
        this.POwnerName = POwnerName;
    }
    
    
    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }
    
    public String getPType() {
        return PType;
    }

    public void setPType(String PType) {
        this.PType = PType;
    }
    
    public int getPPrice() {
        return PPrice;
    }

    public void setPPrice(int PPrice) {
        this.PPrice = PPrice;
    }
    
    public String getPRentBuy() {
        return PRentBuy;
    }

    public void setPRentBuy(String PRentBuy) {
        this.PRentBuy = PRentBuy;
    }
    
}
