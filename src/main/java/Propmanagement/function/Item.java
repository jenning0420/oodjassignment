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
    private int PID;
    private String PType;
    private int POwnerID;
    private int PPrice;
    private String PRentBuy;;

    public Item(int PID, String PType, int POwnerID, int PPrice, String PRentBuy) {
        this.PID = PID;
        this.PType = PType;
        this.POwnerID = POwnerID;
        this.PPrice = PPrice;
        this.PRentBuy = PRentBuy;
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

    public int getPOwnerID() {
        return POwnerID;
    }

    public void setPOwnerID(int POwnerID) {
        this.POwnerID = POwnerID;
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
