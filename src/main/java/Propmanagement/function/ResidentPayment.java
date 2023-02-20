/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propmanagement.function;

/**
 *
 * @author Admin
 */
public class ResidentPayment {
    private String UnitNo;
    private String PaymentType;
    private Double Amount;
    private String PaymentDue;
    
    private String invoiceID;
    
    public ResidentPayment(String UnitNo, String PaymentType, Double Amount, String PaymentDue) {
        this.UnitNo = UnitNo;
        this.PaymentType = PaymentType;
        this.Amount = Amount;
        this.PaymentDue = PaymentDue;
    }
    
    public String getUnitNo() {
        return UnitNo;
    }

    public void setUnitNo(String UnitNo) {
        this.UnitNo = UnitNo;
    }
    
    
    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String PaymentType) {
        this.PaymentType = PaymentType;
    }
    
    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }
    
    public String getPaymentDue() {
        return PaymentDue;
    }

    public void setPaymentDue(String PaymentDue) {
        this.PaymentDue = PaymentDue;
    }    

    public String getinvoiceID() {
        return invoiceID;
    }

    public void setinvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }
    
}
